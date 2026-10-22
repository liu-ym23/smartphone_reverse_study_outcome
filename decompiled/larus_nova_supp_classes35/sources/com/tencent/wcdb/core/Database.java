package com.tencent.wcdb.core;

import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.wcdb.base.CppObject;
import com.tencent.wcdb.base.Value;
import com.tencent.wcdb.base.WCDBException;
import com.tencent.wcdb.orm.Field;
import com.tencent.wcdb.winq.Expression;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class Database extends HandleORMOperation {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final long DictDefaultMatchValue = Long.MAX_VALUE;
    public static String OperationInfoKeyHandleCount;
    public static String OperationInfoKeyIndexCount;
    public static String OperationInfoKeyOpenCPUTime;
    public static String OperationInfoKeyOpenTime;
    public static String OperationInfoKeySchemaUsage;
    public static String OperationInfoKeyTableCount;
    public static String OperationInfoKeyTriggerCount;
    public final String dbPath;

    /* JADX INFO: renamed from: com.tencent.wcdb.core.Database$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$wcdb$core$Database$ConfigPriority = null;

        static {
            int[] r0 = new int[ConfigPriority.values().length];
            $SwitchMap$com$tencent$wcdb$core$Database$ConfigPriority = r0;
            r0[ConfigPriority.low.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$tencent$wcdb$core$Database$ConfigPriority[ConfigPriority.high.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$tencent$wcdb$core$Database$ConfigPriority[ConfigPriority.highest.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public interface BackupFilter {
        boolean tableShouldBeBackup(String r1);
    }

    public interface BusyTracer {
        void onTrace(long r1, String r3, long r4, String r6);
    }

    public static final enum CipherVersion extends Enum<CipherVersion> {
        private static final /* synthetic */ CipherVersion[] $VALUES = null;
        public static final CipherVersion defaultVersion = null;
        public static final CipherVersion version1 = null;
        public static final CipherVersion version2 = null;
        public static final CipherVersion version3 = null;
        public static final CipherVersion version4 = null;

        private static /* synthetic */ CipherVersion[] $values() {
            return new CipherVersion[]{defaultVersion, version1, version2, version3, version4};
        }

        static {
            defaultVersion = new CipherVersion("defaultVersion", 0);
            version1 = new CipherVersion("version1", 1);
            version2 = new CipherVersion("version2", 2);
            version3 = new CipherVersion("version3", 3);
            version4 = new CipherVersion("version4", 4);
            $VALUES = $values();
        }

        public static CipherVersion[] values() {
            return (CipherVersion[]) $VALUES.clone();
        }

        public static CipherVersion valueOf(String r1) {
            return (CipherVersion) a.a(CipherVersion.class, r1);
        }

        private CipherVersion(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface CloseCallBack {
        void onClose() throws WCDBException;
    }

    public interface CompressionFilter {
        void filterCompress(CompressionInfo r1);
    }

    public static class CompressionInfo {
        private long cppInfo;
        public String table;

        public <T> void enableReplaceCompression() {
            Database.access$200(this.cppInfo);
        }

        public <T> void addZSTDNormalCompress(Field<T> r5) {
            Database.access$000(this.cppInfo, CppObject.get(r5));
        }

        public CompressionInfo(long r1, String r3) {
            this.cppInfo = r1;
            this.table = r3;
        }

        public <T> void addZSTDDictCompress(Field<T> r5, byte r6) {
            Database.access$100(this.cppInfo, CppObject.get(r5), r6);
        }

        public <T> void addZSTDMultiDictCompress(Field<T> r10, Field<T> r11, Map<Long, Byte> r12) {
            long[] r7 = new long[r12.size()];
            byte[] r8 = new byte[r12.size()];
            Iterator<Map.Entry<Long, Byte>> r13 = r12.entrySet().iterator();
            int r0 = 0;
        L4:
            if (r13.hasNext() == false) goto L6;
            Map.Entry<Long, Byte> r1 = r13.next();
            r7[r0] = r1.getKey().longValue();
            r8[r0] = r1.getValue().byteValue();
            r0 = r0 + 1;
            goto L4
        L6:
            Database.access$300(this.cppInfo, CppObject.get(r10), CppObject.get(r11), r7, r8);
        }
    }

    public interface CompressionNotification {
        void onCompressed(Database r1, String r2);
    }

    public interface Config {
        void onInvocation(Handle r1) throws WCDBException;
    }

    public static final enum ConfigPriority extends Enum<ConfigPriority> {
        private static final /* synthetic */ ConfigPriority[] $VALUES = null;
        public static final ConfigPriority default_ = null;
        public static final ConfigPriority high = null;
        public static final ConfigPriority highest = null;
        public static final ConfigPriority low = null;

        private static /* synthetic */ ConfigPriority[] $values() {
            return new ConfigPriority[]{low, default_, high, highest};
        }

        static {
            low = new ConfigPriority("low", 0);
            default_ = new ConfigPriority("default_", 1);
            high = new ConfigPriority("high", 2);
            highest = new ConfigPriority("highest", 3);
            $VALUES = $values();
        }

        public static ConfigPriority[] values() {
            return (ConfigPriority[]) $VALUES.clone();
        }

        public static ConfigPriority valueOf(String r1) {
            return (ConfigPriority) a.a(ConfigPriority.class, r1);
        }

        private ConfigPriority(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface CorruptionNotification {
        void onCorrupted(Database r1);
    }

    public interface ExceptionTracer {
        void onTrace(WCDBException r1);
    }

    public interface MigrationFilter {
        void filterMigrate(MigrationInfo r1);
    }

    public static class MigrationInfo {
        public Expression filterCondition;
        public String sourceTable;
        public String table;

        public MigrationInfo() {
        }
    }

    public interface MigrationNotification {
        void onMigrated(Database r1, MigrationInfo r2);
    }

    public static final enum Operation extends Enum<Operation> {
        private static final /* synthetic */ Operation[] $VALUES = null;
        public static final Operation Create = null;
        public static final Operation OpenHandle = null;
        public static final Operation SetTag = null;

        private static /* synthetic */ Operation[] $values() {
            return new Operation[]{Create, SetTag, OpenHandle};
        }

        static {
            Create = new Operation("Create", 0);
            SetTag = new Operation("SetTag", 1);
            OpenHandle = new Operation("OpenHandle", 2);
            $VALUES = $values();
        }

        public static Operation[] values() {
            return (Operation[]) $VALUES.clone();
        }

        public static Operation valueOf(String r1) {
            return (Operation) a.a(Operation.class, r1);
        }

        private Operation(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface OperationTracer {
        void onTrace(Database r1, Operation r2, HashMap<String, Value> r3);
    }

    public static class PerformanceInfo {
        public long costInNanoseconds;
        public int indexPageReadCount;
        public int indexPageWriteCount;
        public int overflowPageReadCount;
        public int overflowPageWriteCount;
        public int tablePageReadCount;
        public int tablePageWriteCount;

        public PerformanceInfo() {
        }
    }

    public interface PerformanceTracer {
        void onTrace(long r1, String r3, long r4, String r6, PerformanceInfo r7);
    }

    public interface ProgressMonitor {
        boolean onProgressUpdate(double r1, double r3);
    }

    public interface SQLTracer {
        void onTrace(long r1, String r3, long r4, String r6, String r7);
    }

    private static native void addAuxiliaryFunction(long r0, String r2);

    private static native void addMigrationSource(long r0, String r2, byte[] r3, MigrationFilter r4);

    private static native void addTokenizer(long r0, String r2);

    private static native void addZSTDDictCompress(long r0, long r2, byte r4);

    private static native void addZSTDMultiDictCompress(long r0, long r2, long r4, long[] r6, byte[] r7);

    private static native void addZSTDNormalCompress(long r0, long r2);

    private static native boolean backup(long r0);

    private static native void blockade(long r0);

    private static native boolean canOpen(long r0);

    private static native boolean checkIfCorrupted(long r0);

    private static native boolean checkIfIsAlreadyCorrupted(long r0);

    private static native void close(long r0, CloseCallBack r2);

    private static native void configPinyinDict(String[] r0, String[][] r1);

    private static native void configTraditionalChineseDict(String[] r0, String[] r1);

    private static native boolean containDepositedFiles(long r0);

    private static native long createDatabase(String r0);

    private static native boolean deposit(long r0);

    private static native void disableCompressNewData(long r0, boolean r2);

    private static native void enableAutoBackup(long r0, boolean r2);

    private static native void enableAutoCompression(long r0, boolean r2);

    private static native void enableAutoMigration(long r0, boolean r2);

    private static native void enableAutoVacuum(long r0, boolean r2);

    private static native void enableLiteMode(long r0, boolean r2);

    private static native void enableReplaceCompression(long r0);

    private static native void enumerateInfo(HashMap<String, Value> r0, long r1);

    private static native void filterBackup(long r0, BackupFilter r2);

    private static native long getError(long r0);

    private static native long getFileSize(long r0);

    public static native long getHandle(long r0, boolean r2);

    private static native int getNumberOfAliveHandle(long r0);

    private static native String getPath(long r0);

    private static native List<String> getPaths(long r0);

    private static native long getTag(long r0);

    private static native long getThreadedError();

    public static native void globalTraceBusy(BusyTracer r0, double r1);

    public static native void globalTraceDatabaseOperation(OperationTracer r0);

    public static native void globalTraceException(ExceptionTracer r0);

    public static native void globalTracePerformance(PerformanceTracer r0);

    public static native void globalTraceSQL(SQLTracer r0);

    private static native boolean incrementalVacuum(long r0, int r2);

    private static native boolean isBlockaded(long r0);

    private static native boolean isCompressed(long r0);

    private static native boolean isMigrated(long r0);

    private static native boolean isOpened(long r0);

    private static native boolean moveFile(long r0, String r2);

    private static native boolean nativeRegisterDict(byte[] r0, byte r1);

    private static native boolean passiveCheckpoint(long r0);

    private static native void purge(long r0);

    public static native void purgeAll();

    public static native void releaseSQLiteMemory(int r0);

    private static native boolean removeDepositedFiles(long r0);

    private static native boolean removeFiles(long r0);

    private static native double retrieve(long r0, ProgressMonitor r2);

    private static native boolean rollbackCompression(long r0, ProgressMonitor r2);

    private static native void setAutoCheckpointEnable(long r0, boolean r2);

    public static native void setAutoCheckpointMinFrames(int r0);

    private static native void setCipherKey(long r0, byte[] r2, int r3, int r4);

    private static native void setCompression(long r0, CompressionFilter r2);

    private static native void setConfig(long r0, String r2, Config r3, Config r4, int r5);

    private static native void setDefaultCipherVersion(int r0);

    private static native void setFullSQLTraceEnable(long r0, boolean r2);

    private static native void setMigrationInfo(long r0, long r2, String r4, long r5);

    private static native void setNotificationWhenCompressed(long r0, CompressionNotification r2);

    private static native void setNotificationWhenCorrupted(long r0, CorruptionNotification r2);

    private static native void setNotificationWhenMigrated(long r0, MigrationNotification r2);

    public static native void setSoftHeapLimit(long r0);

    private static native void setTag(long r0, long r2);

    private static native boolean stepCompression(long r0);

    private static native boolean stepMigration(long r0);

    private static native void traceException(long r0, ExceptionTracer r2);

    private static native void tracePerformance(long r0, PerformanceTracer r2);

    private static native void traceSQL(long r0, SQLTracer r2);

    private static native byte[] trainDict(String[] r0, byte r1);

    private static native byte[] trainDict(byte[][] r0, byte r1);

    private static native boolean truncateCheckpoint(long r0);

    private static native void unblockade(long r0);

    private static native boolean vacuum(long r0, ProgressMonitor r2);

    @Override // com.tencent.wcdb.core.HandleOperation
    public boolean autoInvalidateHandle() {
        return true;
    }

    @Override // com.tencent.wcdb.core.HandleORMOperation
    public Database getDatabase() {
        return this;
    }

    static {
        OperationInfoKeyHandleCount = "HandleCount";
        OperationInfoKeyOpenTime = "OpenTime";
        OperationInfoKeyOpenCPUTime = "OpenCPUTime";
        OperationInfoKeySchemaUsage = "SchemaUsage";
        OperationInfoKeyTableCount = "TableCount";
        OperationInfoKeyIndexCount = "IndexCount";
        OperationInfoKeyTriggerCount = "TriggerCount";
    }

    public void backup() throws WCDBException {
        if (backup(((CppObject) this).cppObj) == false) goto L6;
        return;
    L6:
        throw createException();
    }

    public void blockade() {
        blockade(((CppObject) this).cppObj);
    }

    public boolean canOpen() {
        return canOpen(((CppObject) this).cppObj);
    }

    public boolean checkIfCorrupted() {
        return checkIfCorrupted(((CppObject) this).cppObj);
    }

    public boolean checkIfIsAlreadyCorrupted() {
        return checkIfIsAlreadyCorrupted(((CppObject) this).cppObj);
    }

    public void close() {
        long r0 = ((CppObject) this).cppObj;
        ((CppObject) this).cppObj = 0;
        if (r0 <= 0) goto L6;
        close(r0, null);
        return;
    }

    public boolean containDepositedFiles() {
        return containDepositedFiles(((CppObject) this).cppObj);
    }

    public WCDBException createException() {
        return WCDBException.createException(getError(((CppObject) this).cppObj));
    }

    public void deposit() throws WCDBException {
        if (deposit(((CppObject) this).cppObj) == false) goto L6;
        return;
    L6:
        throw createException();
    }

    public long getFileSize() throws WCDBException {
        long r0 = getFileSize(((CppObject) this).cppObj);
        if (r0 < 0) goto L6;
        return r0;
    L6:
        throw createException();
    }

    public Handle getHandle() {
        return new Handle(this, false);
    }

    public int getNumberOfAliveHandle() {
        return getNumberOfAliveHandle(((CppObject) this).cppObj);
    }

    public List<String> getPaths() {
        return getPaths(((CppObject) this).cppObj);
    }

    public long getTag() {
        return getTag(((CppObject) this).cppObj);
    }

    public boolean isBlockaded() {
        return isBlockaded(((CppObject) this).cppObj);
    }

    public boolean isCompressed() {
        return isCompressed(((CppObject) this).cppObj);
    }

    public boolean isMigrated() {
        return isMigrated(((CppObject) this).cppObj);
    }

    public boolean isOpened() {
        return isOpened(((CppObject) this).cppObj);
    }

    public void passiveCheckpoint() throws WCDBException {
        if (passiveCheckpoint(((CppObject) this).cppObj) == false) goto L6;
        return;
    L6:
        throw createException();
    }

    public void purge() {
        purge(((CppObject) this).cppObj);
    }

    public void removeDepositedFiles() throws WCDBException {
        if (removeDepositedFiles(((CppObject) this).cppObj) == false) goto L6;
        return;
    L6:
        throw createException();
    }

    public void removeFiles() throws WCDBException {
        if (removeFiles(((CppObject) this).cppObj) == false) goto L6;
        return;
    L6:
        throw createException();
    }

    public void stepCompression() throws WCDBException {
        if (stepCompression(((CppObject) this).cppObj) == false) goto L6;
        return;
    L6:
        throw createException();
    }

    public void stepMigration() throws WCDBException {
        if (stepMigration(((CppObject) this).cppObj) == false) goto L6;
        return;
    L6:
        throw createException();
    }

    public void truncateCheckpoint() throws WCDBException {
        if (truncateCheckpoint(((CppObject) this).cppObj) == false) goto L6;
        return;
    L6:
        throw createException();
    }

    public void unblockade() {
        unblockade(((CppObject) this).cppObj);
    }

    private Database() {
        this.dbPath = BuildConfig.FLAVOR;
    }

    private static WCDBException createThreadedException() {
        return WCDBException.createException(getThreadedError());
    }

    public String getPath() {
        return this.dbPath;
    }

    public Database(String r3) {
        this.dbPath = r3;
        ((CppObject) this).cppObj = createDatabase(r3);
    }

    public static /* synthetic */ void access$200(long r0) {
        enableReplaceCompression(r0);
    }

    public static void configPinyinDict(Map<String, List<String>> r6) {
        String[] r0 = (String[]) r6.keySet().toArray(new String[0]);
        if (r0.length != 0) goto L5;
        return;
    L5:
        String[][] r2 = new String[r0.length][];
        int r3 = 0;
    L7:
        if (r3 >= r0.length) goto L13;
        List<String> r4 = r6.get(r0[r3]);
        if (r4 == null) goto L12;
        r2[r3] = (String[]) r4.toArray(new String[0]);
    L12:
        r3 = r3 + 1;
        goto L7
    L13:
        configPinyinDict(r0, r2);
    }

    public static void configTraditionalChineseDict(Map<String, String> r4) {
        int r1 = 0;
        String[] r0 = (String[]) r4.keySet().toArray(new String[0]);
        if (r0.length != 0) goto L5;
        return;
    L5:
        String[] r2 = new String[r0.length];
    L7:
        if (r1 >= r0.length) goto L9;
        r2[r1] = r4.get(r0[r1]);
        r1 = r1 + 1;
        goto L7
    L9:
        configTraditionalChineseDict(r0, r2);
    }

    private static void onClose(CloseCallBack r0) throws WCDBException {
        r0.onClose();
    }

    public static void setDefaultCipherVersion(CipherVersion r0) {
        setDefaultCipherVersion(r0.ordinal());
    }

    public void addAuxiliaryFunction(String r3) {
        addAuxiliaryFunction(((CppObject) this).cppObj, r3);
    }

    public void addTokenizer(String r3) {
        addTokenizer(((CppObject) this).cppObj, r3);
    }

    public void close(CloseCallBack r6) {
        long r0 = ((CppObject) this).cppObj;
        ((CppObject) this).cppObj = 0;
        if (r0 <= 0) goto L6;
        close(r0, r6);
        return;
    }

    public void disableCompressNewData(boolean r3) {
        disableCompressNewData(((CppObject) this).cppObj, r3);
    }

    public void enableAutoBackup(boolean r3) {
        enableAutoBackup(((CppObject) this).cppObj, r3);
    }

    public void enableAutoCompression(boolean r3) {
        enableAutoCompression(((CppObject) this).cppObj, r3);
    }

    public void enableAutoMigration(boolean r3) {
        enableAutoMigration(((CppObject) this).cppObj, r3);
    }

    public void enableAutoVacuum(boolean r3) {
        enableAutoVacuum(((CppObject) this).cppObj, r3);
    }

    public void enableLiteMode(boolean r3) {
        enableLiteMode(((CppObject) this).cppObj, r3);
    }

    public void filterBackup(BackupFilter r3) {
        filterBackup(((CppObject) this).cppObj, r3);
    }

    @Override // com.tencent.wcdb.core.HandleOperation
    public Handle getHandle(boolean r2) {
        return new Handle(this, r2);
    }

    public void incrementalVacuum(int r3) throws WCDBException {
        if (incrementalVacuum(((CppObject) this).cppObj, r3) == false) goto L6;
        return;
    L6:
        throw createException();
    }

    public void moveFile(String r3) throws WCDBException {
        if (moveFile(((CppObject) this).cppObj, r3) == false) goto L6;
        return;
    L6:
        throw createException();
    }

    public double retrieve(ProgressMonitor r5) throws WCDBException {
        double r0 = retrieve(((CppObject) this).cppObj, r5);
        if (r0 < 0.0d) goto L6;
        return r0;
    L6:
        throw createException();
    }

    public void rollbackCompression(ProgressMonitor r3) throws WCDBException {
        if (rollbackCompression(((CppObject) this).cppObj, r3) == false) goto L6;
        return;
    L6:
        throw createException();
    }

    public void setAutoCheckpointEnable(boolean r3) {
        setAutoCheckpointEnable(((CppObject) this).cppObj, r3);
    }

    public void setCipherKey(byte[] r2) {
        setCipherKey(r2, 4096);
    }

    public void setCompression(CompressionFilter r3) {
        setCompression(((CppObject) this).cppObj, r3);
    }

    public void setFullSQLTraceEnable(boolean r3) {
        setFullSQLTraceEnable(((CppObject) this).cppObj, r3);
    }

    public void setNotificationWhenCompressed(CompressionNotification r3) {
        setNotificationWhenCompressed(((CppObject) this).cppObj, r3);
    }

    public void setNotificationWhenCorrupted(CorruptionNotification r3) {
        setNotificationWhenCorrupted(((CppObject) this).cppObj, r3);
    }

    public void setNotificationWhenMigrated(MigrationNotification r3) {
        setNotificationWhenMigrated(((CppObject) this).cppObj, r3);
    }

    public void setTag(long r3) {
        setTag(((CppObject) this).cppObj, r3);
    }

    public void traceException(ExceptionTracer r3) {
        traceException(((CppObject) this).cppObj, r3);
    }

    public void tracePerformance(PerformanceTracer r3) {
        tracePerformance(((CppObject) this).cppObj, r3);
    }

    public void traceSQL(SQLTracer r3) {
        traceSQL(((CppObject) this).cppObj, r3);
    }

    public void vacuum(ProgressMonitor r3) throws WCDBException {
        if (vacuum(((CppObject) this).cppObj, r3) == false) goto L6;
        return;
    L6:
        throw createException();
    }

    public static /* synthetic */ void access$000(long r0, long r2) {
        addZSTDNormalCompress(r0, r2);
    }

    private static boolean checkTableShouldBeBackup(BackupFilter r0, String r1) {
        return r0.tableShouldBeBackup(r1);
    }

    private static boolean onConfig(long r2, Config r4) {
        r4.onInvocation(new Handle(r2, null));     // Catch: WCDBException -> L5
        return true;
    L5:
        return false;
    }

    private static void onCorrupted(CorruptionNotification r1, long r2) {
        Database r0 = new Database();
        ((CppObject) r0).cppObj = r2;
        r1.onCorrupted(r0);
    }

    private static void onTraceException(ExceptionTracer r0, long r1) {
        r0.onTrace(WCDBException.createException(r1));
    }

    public static void registerDict(byte[] r0, byte r1) throws WCDBException {
        if (nativeRegisterDict(r0, r1) == false) goto L6;
        return;
    L6:
        throw createThreadedException();
    }

    public static byte[] trainDictWithData(List<byte[]> r1, byte r2) throws WCDBException {
        byte[] r3 = trainDict((byte[][]) r1.toArray(new byte[0][]), r2);
        if (r3 == null) goto L8;
        if (r3.length == 0) goto L8;
        return r3;
    L8:
        throw createThreadedException();
    }

    public static byte[] trainDictWithString(List<String> r1, byte r2) throws WCDBException {
        byte[] r3 = trainDict((String[]) r1.toArray(new String[0]), r2);
        if (r3 == null) goto L8;
        if (r3.length == 0) goto L8;
        return r3;
    L8:
        throw createThreadedException();
    }

    public void addMigrationSource(String r2, MigrationFilter r3) {
        addMigrationSource(r2, null, r3);
    }

    public void setCipherKey(byte[] r2, int r3) {
        setCipherKey(r2, r3, CipherVersion.defaultVersion);
    }

    public void setConfig(String r2, Config r3) {
        setConfig(r2, r3, ConfigPriority.default_);
    }

    public static /* synthetic */ void access$100(long r0, long r2, byte r4) {
        addZSTDDictCompress(r0, r2, r4);
    }

    private static void filterCompress(CompressionFilter r1, long r2, String r4) {
        r1.filterCompress(new CompressionInfo(r2, r4));
    }

    private static boolean onProgressUpdate(ProgressMonitor r0, double r1, double r3) {
        return r0.onProgressUpdate(r1, r3);
    }

    private static void onTableCompressed(CompressionNotification r1, long r2, String r4) {
        Database r0 = new Database();
        ((CppObject) r0).cppObj = r2;
        r1.onCompressed(r0, r4);
    }

    public void addMigrationSource(String r3, byte[] r4, MigrationFilter r5) {
        addMigrationSource(((CppObject) this).cppObj, r3, r4, r5);
    }

    public void setCipherKey(byte[] r3, int r4, CipherVersion r5) {
        setCipherKey(((CppObject) this).cppObj, r3, r4, r5.ordinal());
    }

    public void setConfig(String r2, Config r3, ConfigPriority r4) {
        setConfig(r2, r3, null, r4);
    }

    private static void filterMigrate(MigrationFilter r8, long r9, long r11, String r13) {
        MigrationInfo r0 = new MigrationInfo();
        r0.table = r13;
        r8.filterMigrate(r0);
        setMigrationInfo(r9, r11, r0.sourceTable, CppObject.get(r0.filterCondition));
    }

    private static void onTableMigrated(MigrationNotification r1, long r2, String r4, String r5) {
        Database r0 = new Database();
        ((CppObject) r0).cppObj = r2;
        if (r4 != null) goto L5;
    L7:
        MigrationInfo r3 = null;
    L8:
        r1.onMigrated(r0, r3);
        return;
    L5:
        if (r4.length() <= 0) goto L7;
        r3 = new MigrationInfo();
        r3.table = r4;
        r3.sourceTable = r5;
        goto L8
    }

    private static void onTraceOperation(OperationTracer r1, long r2, int r4, long r5) {
        Database r0 = new Database();
        ((CppObject) r0).cppObj = r2;
        Operation r3 = Operation.Create;
        if (r4 != 1) goto L5;
        r3 = Operation.SetTag;
    L9:
        HashMap<String, Value> r6 = new HashMap();
        enumerateInfo(r6, r5);
        r1.onTrace(r0, r3, r6);
        return;
    L5:
        if (r4 != 2) goto L9;
        r3 = Operation.OpenHandle;
        goto L9
    }

    public void setConfig(String r7, Config r8, Config r9, ConfigPriority r10) {
        int r11 = AnonymousClass1.$SwitchMap$com$tencent$wcdb$core$Database$ConfigPriority[r10.ordinal()];
        if (r11 != 1) goto L5;
        int r5 = 100;
    L12:
        setConfig(((CppObject) this).cppObj, r7, r8, r9, r5);
        return;
    L5:
        if (r11 != 2) goto L7;
        r5 = -100;
        goto L12
    L7:
        if (r11 == 3) goto L9;
        r5 = 0;
        goto L12
    L9:
        r5 = PluginList.LEVEL_NOT_SET;
        goto L12
    }

    public static /* synthetic */ void access$300(long r0, long r2, long r4, long[] r6, byte[] r7) {
        addZSTDMultiDictCompress(r0, r2, r4, r6, r7);
    }

    private static void onBusyTrace(BusyTracer r0, long r1, String r3, long r4, String r6) {
        r0.onTrace(r1, r3, r4, r6);
    }

    private static void onEnumerateInfo(HashMap<String, Value> r1, String r2, int r3, long r4, double r6, String r8) {
        if (r3 != 3) goto L6;
        r1.put(r2, new Value(r4));
        return;
    L6:
        if (r3 != 5) goto L9;
        r1.put(r2, new Value(r6));
        return;
    L9:
        if (r3 != 6) goto L14;
        r1.put(r2, new Value(r8));
        return;
    }

    private static void onTraceSQL(SQLTracer r0, long r1, String r3, long r4, String r6, String r7) {
        r0.onTrace(r1, r3, r4, r6, r7);
    }

    private static void onTracePerformance(PerformanceTracer r10, long r11, String r13, long r14, String r16, long r17, int[] r19) {
        if (r19 != null) goto L5;
    L7:
        PerformanceInfo r1 = null;
    L8:
        r10.onTrace(r11, r13, r14, r16, r1);
        return;
    L5:
        if (r19.length != 6) goto L7;
        r1 = new PerformanceInfo();
        r1.tablePageReadCount = r19[0];
        r1.tablePageWriteCount = r19[1];
        r1.indexPageReadCount = r19[2];
        r1.indexPageWriteCount = r19[3];
        r1.overflowPageReadCount = r19[4];
        r1.overflowPageWriteCount = r19[5];
        r1.costInNanoseconds = r17;
        goto L8
    }
}
