package com.obric.memorydata.middleware.impl.npth;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.applog.AppLog;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICommonParams;
import com.bytedance.crash.Npth;
import com.bytedance.crash.anr.AnrManager;
import com.bytedance.crash.config.RuntimeConfig;
import com.bytedance.crash.crash.CrashManager;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.util.RomUtils;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.aikernel.PapayaAPI;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.npth.INpthInit;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.middleware.database.DatabaseIsolationTracker;
import com.obric.memorydata.middleware.impl.bdtracker.MemoryAppLogSettings;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.utils.ab;
import com.obric.memorydata.utils.am;
import com.obric.memorydata.utils.ba;
import com.obric.memorydata.utils.j;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\u0000H\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u0006\u0010\u000e\u001a\u00020\rJ\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\rH\u0002J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u001b\u001a\u00020\rH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/middleware/impl/npth/NpthInit;", "Lcom/obric/memorydata/middleware/api/npth/INpthInit;", "<init>", "()V", "TAG", "", "KEY_LAST_CRASH_INFO", "startTime", "", "isStart", "", "getInst", CommonConsts.APM_INNER_EVENT_COST_INIT, "", CommonConsts.APM_INNER_EVENT_COST_START, "reportCrashTeaEvent", "type", "Lcom/bytedance/crash/CrashType;", TrackerImpl.PARAMS, "Lorg/json/JSONObject;", "registerShutdownReceiver", "backupDb", "dbName", "handleDbCrash", CrashManager.DIR_NAME, "extractDbName", "message", "clearNpthCrashFileIfTooLarge", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NpthInit implements INpthInit {
    public static final NpthInit INSTANCE = null;
    private static final String KEY_LAST_CRASH_INFO = "key_last_crash_info";
    private static final String TAG = "NpthInit";
    private static volatile boolean isStart;
    private static long startTime;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11786a = null;

        static {
            int[] r0 = new int[CrashType.values().length];
            r0[CrashType.JAVA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[CrashType.NATIVE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[CrashType.ANR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[CrashType.LAUNCH.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f11786a = r0;
        }
    }

    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0014\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u0003H\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\rH\u0016¨\u0006\u000e"}, d2 = {"com/obric/memorydata/middleware/impl/npth/NpthInit$start$1", "Lcom/bytedance/crash/ICommonParams;", "getCommonParams", "", "", "", "getDeviceId", "getUserId", "", "getSessionId", "getPluginInfo", "", "getPatchInfo", "", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements ICommonParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f11787a;

        b(String r1) {
            this.f11787a = r1;
        }

        @Override // com.bytedance.crash.ICommonParams
        public Map<String, Object> getCommonParams() {
            Map<String, Object> r0 = (Map) ZeusTransformUtils.preCheckCast(new HashMap(), Map.class, "com.obric.memorydata.plugin");
            r0.put("aid", Integer.valueOf(AppContext.INSTANCE.getAid()));
            r0.put("channel", AppContext.INSTANCE.getChannel());
            r0.put("app_version", AppContext.INSTANCE.getVersionName());
            r0.put("version_code", Integer.valueOf(AppContext.INSTANCE.getVersionCode()));
            r0.put("update_version_code", String.valueOf(AppContext.INSTANCE.getUpdateVersionCode()));
            r0.put("release_build", this.f11787a);
            return r0;
        }

        @Override // com.bytedance.crash.ICommonParams
        public String getDeviceId() {
            return AppContext.INSTANCE.getServerDeviceId();
        }

        @Override // com.bytedance.crash.ICommonParams
        public List<String> getPatchInfo() {
            return CollectionsKt.emptyList();
        }

        @Override // com.bytedance.crash.ICommonParams
        public Map<String, Integer> getPluginInfo() {
            return MapsKt.emptyMap();
        }

        @Override // com.bytedance.crash.ICommonParams
        public String getSessionId() {
            String r0 = AppLog.getSessionId();
            if (r0 != null) goto L6;
            return "";
        L6:
            return r0;
        }

        @Override // com.bytedance.crash.ICommonParams
        public long getUserId() {
            Long r2 = StringsKt.toLongOrNull(AppContext.INSTANCE.getUserId());
            if (r2 != null) goto L7;
            return 0;
        L7:
            return r2.longValue();
        }
    }

    static {
        INSTANCE = new NpthInit();
    }

    private NpthInit() {
    }

    private final void backupDb(String r15) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "backup db", null, 4, null);
        File r14 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getDataDir().getAbsolutePath() + "/databases");
        File r0 = new File(r14.getAbsolutePath() + "/backup");
        if (r0.exists() == true) goto L5;
        r0.mkdirs();
    L5:
        File[] r16 = r14.listFiles();
        if (r16 == null) goto L14;
        int r5 = r16.length;
        int r6 = 0;
    L8:
        if (r6 >= r5) goto L14;
        File r13 = r16[r6];
        String r7 = r13.getName();
        Intrinsics.checkNotNullExpressionValue(r7, "getName(...)");
        if (StringsKt.startsWith$default(r7, r15, false, 2, null) == false) goto L12;
        File r8 = new File(r0, r13.getName());
        Intrinsics.checkNotNull(r13);
        FilesKt.copyTo$default(r13, r8, true, 0, 4, null);
        r13.delete();
    L12:
        r6 = r6 + 1;
    L14:
        if (Intrinsics.areEqual(r15, MemoryDbEngine.ENCRYPT_DB_NAME) == false) goto L19;
        File r17 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir(), "vectorDataBase");
        if (r17.exists() == false) goto L18;
        FilesKt.deleteRecursively(r17);
    L18:
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("contact_sms_entity_donated", false);
    L19:
        j.a($$Lambda$NpthInit$AJwlnCewTLUOpgJjNMlkx0E1BMw.INSTANCE);
    }

    private static final Unit backupDb$lambda$10() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        String r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.db_crash_tips, TypedValues.Custom.S_STRING, "db_crash_tips"));
        Intrinsics.checkNotNullExpressionValue(r1, "getString(...)");
        ba.a(r0, r1, 0, 4, null);
        return Unit.INSTANCE;
    }

    @JvmStatic
    public static final void clearNpthCrashFileIfTooLarge() {
        ThreadPoolContainer.Companion.execute($$Lambda$NpthInit$piow7YMbrpApzg3KK_Rd20PK7Dg.INSTANCE);
    }

    private static final void clearNpthCrashFileIfTooLarge$lambda$15() {
        File r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir();     // Catch: Throwable -> L24
        Intrinsics.checkNotNullExpressionValue(r2, "getFilesDir(...)");     // Catch: Throwable -> L24
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new File[]{r2, r2.getParentFile()}), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L24
    L4:
        if (r3.hasNext() == false) goto L46;
        File r4 = (File) ZeusTransformUtils.preCheckCast(r3.next(), File.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        if (r4 == null) goto L4;
        File r5 = new File(r4, "npth/crash");     // Catch: Throwable -> L24
        if (r5.exists() == false) goto L4;
        if (r5.isDirectory() == false) goto L4;
        long r6 = SequencesKt.sumOfLong(SequencesKt.map(SequencesKt.filter((Sequence) ZeusTransformUtils.preCheckCast(FilesKt.walkTopDown(r5), Sequence.class, "com.obric.memorydata.plugin"), $$Lambda$NpthInit$eF60B5OWYqm5XG8uTw6IIVajePs.INSTANCE), $$Lambda$NpthInit$kFTueQVz_7mitgw2pOvg5maSjIg.INSTANCE));     // Catch: Throwable -> L24
        if (r6 <= 314572800) goto L4;
        RunLog.INSTANCE.debug(TAG, "clearNpthCrashFileIfTooLarge, crashDir: " + r5.getAbsolutePath() + ", totalSize: " + r6);     // Catch: Throwable -> L24
        File[] r7 = r5.listFiles();     // Catch: Throwable -> L24
        if (r7 == null) goto L4;
        int r8 = r7.length;     // Catch: Throwable -> L24
        int r9 = 0;
    L17:
        if (r9 >= r8) goto L4;
        File r10 = r7[r9];     // Catch: Throwable -> L24
        Intrinsics.checkNotNull(r10);     // Catch: Throwable -> L21
        FilesKt.deleteRecursively(r10);     // Catch: Throwable -> L21
    L23:
        r9 = r9 + 1;
    L21:
        th = move-exception;
        RunLog.INSTANCE.error(TAG, "clearNpthCrashFileIfTooLarge delete item error", th);     // Catch: Throwable -> L24
        goto L23
    L46:
        return;
    L24:
        th = move-exception;
        RunLog.INSTANCE.error(TAG, "clearNpthCrashFileIfTooLarge error", th);
    }

    private static final boolean clearNpthCrashFileIfTooLarge$lambda$15$lambda$14$lambda$11(File r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return r1.isFile();
    }

    private static final long clearNpthCrashFileIfTooLarge$lambda$15$lambda$14$lambda$12(File r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return r2.length();
    }

    private final String extractDbName(String r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        MatchResult r6 = Regex.find$default(new Regex("name=([^,]+)"), (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"), 0, 2, null);
        if (r6 == null) goto L11;
        List<String> r7 = r6.getGroupValues();
        if (r7 != null) goto L10;
        return null;
    L10:
        return (String) ZeusTransformUtils.preCheckCast(r7.get(1), String.class, "com.obric.memorydata.plugin");
    L11:
        return null;
    }

    @JvmStatic
    public static final NpthInit getInst() {
        return INSTANCE;
    }

    private final void handleDbCrash(String r20) {
        String r5 = StringsKt.substringBefore$default(r20, "\n", null, 2, null);
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("SQLiteException", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L5;
    L8:
        CrashInfo r6 = new CrashInfo(StringsKt.substringBefore$default(r20, "\n", null, 2, null), System.currentTimeMillis(), 1);
        String r1 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getString(KEY_LAST_CRASH_INFO, "");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L11;
        boolean r11 = true;
    L13:
        if (r11 == false) goto L16;
        IRunLog r13 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder();
        String r2 = "save last crash info : ";
    L15:
        IRunLog.a.b(r13, TAG, r0.append(r2).append(r6).toString(), null, 4, null);
        IStore r3 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
        String r4 = ab.a().toJson(r6);
        Intrinsics.checkNotNullExpressionValue(r4, "toJson(...)");
        r3.save(KEY_LAST_CRASH_INFO, r4);
        return;
    L16:
        CrashInfo r7 = (CrashInfo) ZeusTransformUtils.preCheckCast(ab.a().fromJson(r1, CrashInfo.class), CrashInfo.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r7.getCrashLog(), r5) == false) goto L30;
        r7.setCrashTimes(r7.getCrashTimes() + 1);
        if (Math.abs(System.currentTimeMillis() - r7.getFirstCrashTime()) < 60000) goto L21;
        r7.setFirstCrashTime(System.currentTimeMillis());
        r7.setCrashTimes(1);
    L29:
        r6 = r7;
        goto L30
    L21:
        if (AppContext.INSTANCE.isDebug() == true) goto L29;
        if (r7.getCrashTimes() <= 6) goto L29;
        r7.setCrashTimes(0);
        String r8 = extractDbName(r6.getCrashLog());
        if (r8 != null) goto L27;
        r8 = MemoryDbEngine.ENCRYPT_DB_NAME;
    L27:
        backupDb(r8);
    L30:
        r13 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r0 = new StringBuilder();
        r2 = "save last crash info: ";
        goto L15
    L11:
        r11 = false;
        goto L13
    L5:
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("RoomDatabase", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L8;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("DatabaseException", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L8;
    }

    private static final Unit init$lambda$0() {
        INSTANCE.start();
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void lambda$8YOZWHHkxUI0NHxnpKucTodHAgs(CrashType r0, String r1, Thread r2) {
        start$lambda$5(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$AJwlnCewTLUOpgJjNMlkx0E1BMw() {
        return backupDb$lambda$10();
    }

    public static /* synthetic */ void lambda$TgmLdn3jOeMYP1Umwwh1LsBX96A(CrashType r0, Throwable r1, Thread r2, long r3) {
        start$lambda$8(r0, r1, r2, r3);
    }

    public static /* synthetic */ Map lambda$WHQsmVfAJMcKYZkxQ0DygqjY6Tw(Map r0, CrashType r1) {
        return start$lambda$3(r0, r1);
    }

    public static /* synthetic */ Unit lambda$b5X7VIVSGa9rkgThAjodGSn1ZiI() {
        return init$lambda$0();
    }

    public static /* synthetic */ boolean lambda$eF60B5OWYqm5XG8uTw6IIVajePs(File r0) {
        return clearNpthCrashFileIfTooLarge$lambda$15$lambda$14$lambda$11(r0);
    }

    public static /* synthetic */ long lambda$kFTueQVz_7mitgw2pOvg5maSjIg(File r2) {
        return clearNpthCrashFileIfTooLarge$lambda$15$lambda$14$lambda$12(r2);
    }

    public static /* synthetic */ void lambda$piow7YMbrpApzg3KK_Rd20PK7Dg() {
        clearNpthCrashFileIfTooLarge$lambda$15();
    }

    private final void registerShutdownReceiver() {
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        IntentFilter r1 = new IntentFilter("android.intent.action.ACTION_SHUTDOWN");
        ZeusTransformUtils.registerReceiver(r4, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.middleware.impl.a.b(), PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), r1, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.info(TAG, "register shutdown receiver", true);
    }

    private final void reportCrashTeaEvent(CrashType r4, JSONObject r5) {
        int r3 = a.f11786a[r4.ordinal()];
        if (r3 != 1) goto L5;
    L9:
        com.obric.memorydata.middleware.impl.npth.a.f11788a.a("memory_app_crash", r5, System.currentTimeMillis());
        return;
    L5:
        if (r3 == 2) goto L9;
        if (r3 == 4) goto L9;
        Tracker.INSTANCE.reportDevEvent("memory_app_crash", r5);
    }

    private static final Map start$lambda$3(Map r4, CrashType r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Map r7 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(MapsKt.mapCapacity(r6.size())), Map.class, "com.obric.memorydata.plugin");
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r6.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        Object r1 = r8.next();
        r7.put(((Map.Entry) ZeusTransformUtils.preCheckCast(r1, Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), ((Map.Entry) ZeusTransformUtils.preCheckCast(r1, Map.Entry.class, "com.obric.memorydata.plugin")).getValue().toString());
        goto L4
    L6:
        Map r9 = MapsKt.toMutableMap(r7);
        String r10 = PapayaAPI.INSTANCE.getPythonThreadTrace();
        if (r10 == null) goto L9;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r9.put("python_dump", r10), String.class, "com.obric.memorydata.plugin");
    L9:
        return r9;
    }

    private static final void start$lambda$5(CrashType r6, String r7, Thread r8) {
        Intrinsics.checkNotNullParameter(r6, "type");
        if (r7 != null) goto L5;
        return;
    L5:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "crash type: " + r6 + ", crash: " + r7, null, 4, null);
        long r0 = SystemClock.elapsedRealtime() - startTime;
        JSONObject r9 = new JSONObject();
        r9.put(Header.KEY_CRASH_TYPE, r6.name());
        r9.put("runtime_duration", r0);
        NpthInit r1 = INSTANCE;
        r1.reportCrashTeaEvent(r6, r9);
        int r10 = a.f11786a[r6.ordinal()];
        if (r10 != 1) goto L8;
        String r11 = "java";
    L15:
        com.obric.memorydata.middleware.impl.a.a.f11674a.a(r11);
        r1.handleDbCrash(r7);
        clearNpthCrashFileIfTooLarge();
        com.ss.android.agilelogger.a.d();
        return;
    L8:
        if (r10 != 2) goto L10;
        r11 = "native";
        goto L15
    L10:
        if (r10 == 3) goto L12;
        r11 = r6.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r11, "toLowerCase(...)");
        goto L15
    L12:
        r11 = AnrManager.ANR_ROOT_DIR;
        goto L15
    }

    private static final void start$lambda$8(CrashType r8, Throwable r9, Thread r10, long r11) {
        Intrinsics.checkNotNullParameter(r8, "type");
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "oom crash: " + r9, null, 4, null);
        JSONObject r12 = new JSONObject();
        r12.put(Header.KEY_CRASH_TYPE, r8.name());
        Long r13 = Long.valueOf(r11);
        if (((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == true) goto L9;
        r13 = null;
    L9:
        if (r13 == null) goto L11;
        long r15 = r13.longValue();
    L12:
        com.obric.memorydata.middleware.impl.npth.a.f11788a.a("memory_app_oom", r12, r15);
        return;
    L11:
        r15 = System.currentTimeMillis();
        goto L12
    L5:
        r14 = false;
        goto L6
    }

    @Override // com.obric.memorydata.middleware.api.npth.INpthInit
    public void init() {
        MemoryAppLogSettings.INSTANCE.registerDidReadyListener($$Lambda$NpthInit$b5X7VIVSGa9rkgThAjodGSn1ZiI.INSTANCE);
    }

    public final void start() {
        if (isStart == false) goto L5;
        return;
    L5:
        isStart = true;
        startTime = SystemClock.elapsedRealtime();
        com.obric.memorydata.middleware.impl.a.a.f11674a.b();
        registerShutdownReceiver();
        final Map<String, Object> r14 = AppContext.INSTANCE.getSlardarExtras();
        Npth.addAttachUserData(new $$Lambda$NpthInit$WHQsmVfAJMcKYZkxQ0DygqjY6Tw(r14), CrashType.ALL);
        String r15 = AppContext.INSTANCE.getBuildInfo();
        String r1 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getString("rom_info");
        String r8 = AppContext.INSTANCE.getRomVersion();
        RunLog.INSTANCE.info(TAG, "buildInfo: " + r15 + " channel: " + AppContext.INSTANCE.getChannel() + ", pkg = " + AppContext.INSTANCE.getPackageName() + ", romVersion = " + r8, true);
        Log.i(TAG, "buildInfo: " + r15 + " channel: " + AppContext.INSTANCE.getChannel());
        if (Intrinsics.areEqual(r1, r8) == true) goto L8;
        RunLog.INSTANCE.info(TAG, "romInfo changed from " + r1 + " to " + r8, true);
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("rom_info", r8);
    L8:
        Npth.addTag("rom_info", RomUtils.getSystemProperty("ro.os.ota.version"));
        com.obric.aiagent.product.feature.a.a r2 = am.f13169a.b();
        if (r2 == null) goto L12;
        String r3 = r2.d();
        if (r3 == null) goto L12;
    L13:
        Npth.addTag("flow_app_variant", r3);
        Npth.setOpenNewAnrMonitor(true);
        Npth.init((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (ICommonParams) ZeusTransformUtils.preCheckCast(new b(r15), ICommonParams.class, "com.obric.memorydata.plugin"), true, true, true);
        Npth.registerCrashCallback($$Lambda$NpthInit$8YOZWHHkxUI0NHxnpKucTodHAgs.INSTANCE, CrashType.ALL);
        RuntimeConfig.setDebugMode(AppContext.INSTANCE.isDebug());
        Npth.registerOOMCallback($$Lambda$NpthInit$TgmLdn3jOeMYP1Umwwh1LsBX96A.INSTANCE);
        d.f11793a.a();
        DatabaseIsolationTracker.f11642a.a();
        com.obric.memorydata.middleware.impl.npth.a.f11788a.a();
        Tracker.INSTANCE.reportDevEvent("memory_app_launch", new JSONObject());
        return;
    L12:
        r3 = "obric";
        goto L13
    }
}
