package com.obric.cae.smartNetwork.networkHandoverRL;

import android.content.Context;
import android.util.AtomicFile;
import com.bytedance.bdlocation.scan.wifi.f;
import com.obric.cae.log.CaeLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkSwitchDatabase {
    private static final String FILE_IMPORTANT = "network_switch_model_params_important.bin";
    private static final String FILE_OTHER = "network_switch_model_params_other.bin";
    private static final String KV_FILE_NAME = "network_switch_kv.json";
    private static final int PARAM_COUNT = 11;
    private static final int PARAM_RECORD_SIZE = 54;
    private static final String TAG = "NetworkSwitchDatabase";
    private static volatile NetworkSwitchDatabase sInstance;
    private final Context context;
    private JSONObject kvCache;
    private File kvFile;
    private final Object lock;

    private NetworkSwitchDatabase(Context r8) {
        this.lock = new Object();
        this.kvCache = null;
        Context r10 = r8.getApplicationContext();
        this.context = r10;
        this.kvFile = new File(r10.getFilesDir(), KV_FILE_NAME);
        validateAndRepairRecordFile(new File(r10.getFilesDir(), FILE_IMPORTANT));
        validateAndRepairRecordFile(new File(r10.getFilesDir(), FILE_OTHER));
        this.kvCache = readJsonValue(this.kvFile);
    }

    public static /* synthetic */ int a(boolean r8, NetworkSwitchPolicyML.FeatureParams r10, NetworkSwitchPolicyML.FeatureParams r11) {
        return lambda$getModelParams$1(r8, r10, r11);
    }

    public static /* synthetic */ int b(NetworkSwitchPolicyML.FeatureParams r8, NetworkSwitchPolicyML.FeatureParams r10) {
        return lambda$getRecentModelParams$0(r8, r10);
    }

    private void ensureKvCacheLoaded(File r8) {
        if (this.kvCache == null) goto L5;
        return;
    L5:
        this.kvCache = readJsonValue(r8);
    }

    public static NetworkSwitchDatabase getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(NetworkSwitchDatabase.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new NetworkSwitchDatabase(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(NetworkSwitchDatabase.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private static /* synthetic */ int lambda$getModelParams$1(boolean r8, NetworkSwitchPolicyML.FeatureParams r10, NetworkSwitchPolicyML.FeatureParams r11) {
        if (r8 == false) goto L5;
        return Long.compare(r10.timestamp, r11.timestamp);
    L5:
        return Long.compare(r11.timestamp, r10.timestamp);
    }

    private static /* synthetic */ int lambda$getRecentModelParams$0(NetworkSwitchPolicyML.FeatureParams r8, NetworkSwitchPolicyML.FeatureParams r10) {
        return Long.compare(r10.timestamp, r8.timestamp);
    }

    private int pruneOldRecords(File r10, long r11) {
        if (r10 != null) goto L5;
    L34:
        return 0;
    L5:
        if (r10.exists() == false) goto L34;
        if (r10.length() < 54) goto L34;
        AtomicFile r8 = new AtomicFile(r10);
        FileOutputStream r12 = null;
        FileInputStream r13 = new FileInputStream(r10);     // Catch: Exception -> L30
        FileOutputStream r14 = r8.startWrite();     // Catch: Throwable -> L24
        byte[] r15 = new byte[54];     // Catch: Throwable -> L22
        int r16 = 0;
    L15:
        if (readFully(r13, r15) != 54) goto L19;
        if (ByteBuffer.wrap(r15).order(ByteOrder.LITTLE_ENDIAN).getLong() < r11) goto L15;
        r14.write(r15, 0, 54);     // Catch: Throwable -> L22
        r16 = r16 + 1;     // Catch: Throwable -> L22
        goto L15
    L19:
        r14.flush();     // Catch: Throwable -> L22
        r8.finishWrite(r14);     // Catch: Throwable -> L22
        r13.close();     // Catch: Exception -> L30
        return r16;
    L22:
        th = th;
        r12 = r14;
    L43:
        r13.close();     // Catch: Throwable -> L27
    L29:
        throw th;     // Catch: Exception -> L30
    L27:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L30
    L24:
        th = th;
    L30:
        e = move-exception;
        if (r12 != null) goto L38;
    L33:
        CaeLog.w(TAG, "pruneOldRecords error: " + e.getMessage());
        goto L34
    L38:
        r8.failWrite(r12);     // Catch: Throwable -> L35
        goto L33
    }

    private List<NetworkSwitchPolicyML.FeatureParams> readFilteredRecords(File r12, long r13) {
        ArrayList r11 = new ArrayList();
        if (r12 != null) goto L5;
    L31:
        return r11;
    L5:
        if (r12.exists() == false) goto L31;
        if (r12.length() < 54) goto L31;
        FileInputStream r8 = new FileInputStream(r12);     // Catch: Exception -> L29
        byte[] r10 = new byte[54];     // Catch: Throwable -> L23
    L12:
        if (readFully(r8, r10) != 54) goto L21;
        ByteBuffer r14 = ByteBuffer.wrap(r10).order(ByteOrder.LITTLE_ENDIAN);     // Catch: Throwable -> L23
        long r15 = r14.getLong();     // Catch: Throwable -> L23
        int[] r16 = new int[11];     // Catch: Throwable -> L23
        int r17 = 0;
    L15:
        if (r17 >= 11) goto L17;
        r16[r17] = r14.getInt();     // Catch: Throwable -> L23
        r17 = r17 + 1;     // Catch: Throwable -> L23
        goto L15
    L17:
        int r18 = r14.get() & 255;     // Catch: Throwable -> L23
        int r19 = r14.get() & 255;     // Catch: Throwable -> L23
        if (r15 < r13) goto L12;
        r11.add(new NetworkSwitchPolicyML.FeatureParams(r15, 0, r16, r18, r19));     // Catch: Throwable -> L23
        goto L12
    L21:
        r8.close();     // Catch: Exception -> L29
        goto L31
    L23:
        th = move-exception;
        r8.close();     // Catch: Throwable -> L26
    L28:
        throw th;     // Catch: Exception -> L29
    L26:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L29
    L29:
        e = move-exception;
        CaeLog.e(TAG, "readFilteredRecords error: " + e.getMessage(), e);
        goto L31
    }

    private static int readFully(FileInputStream r8, byte[] r10) {
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        int r13 = r8.read(r10, r12, r11 - r12);
        if (r13 < 0) goto L6;
        r12 = r12 + r13;
        goto L3
    L6:
        return r12;
    L8:
        return r12;
    }

    private JSONObject readJsonValue(File r8) {
        if (r8.exists() == false) goto L40;
        if (r8.length() == 0) goto L40;
        FileInputStream r10 = new FileInputStream(r8);     // Catch: Exception -> L36
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();     // Catch: Throwable -> L30
        byte[] r12 = new byte[4096];     // Catch: Throwable -> L24
    L11:
        int r13 = r10.read(r12);     // Catch: Throwable -> L24
        if (r13 == (-1)) goto L15;
        r11.write(r12, 0, r13);     // Catch: Throwable -> L24
        goto L11
    L15:
        if (r11.size() > 0) goto L20;
        JSONObject r14 = new JSONObject();     // Catch: Throwable -> L24
        r11.close();     // Catch: Throwable -> L30
        r10.close();     // Catch: Exception -> L36
        return r14;
    L20:
        JSONObject r15 = new JSONObject(new String(r11.toByteArray(), StandardCharsets.UTF_8));     // Catch: Throwable -> L24
        r11.close();     // Catch: Throwable -> L30
        r10.close();     // Catch: Exception -> L36
        return r15;
    L24:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L27
    L29:
        throw th;     // Catch: Throwable -> L30
    L27:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        r10.close();     // Catch: Throwable -> L33
    L35:
        throw th;     // Catch: Exception -> L36
    L33:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L36
    L36:
        e = move-exception;
        CaeLog.e(TAG, "readJsonValue error: " + e.getMessage(), e);
        return new JSONObject();
    L40:
        return new JSONObject();
    }

    private void validateAndRepairRecordFile(File r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.exists() == false) goto L29;
        long r8 = r10.length();
        if ((r8 % 54) == 0) goto L28;
        long r11 = (r8 / 54) * 54;
        CaeLog.w(TAG, "validateAndRepairRecordFile: file " + r10.getName() + " length " + r8 + " is not multiple of 54, truncating to " + r11);
        RandomAccessFile r12 = new RandomAccessFile(r10, "rw");     // Catch: Exception -> L19
        r12.setLength(r11);     // Catch: Throwable -> L13
        r12.close();     // Catch: Exception -> L19
        return;
    L13:
        th = move-exception;
        r12.close();     // Catch: Throwable -> L16
    L18:
        throw th;     // Catch: Exception -> L19
    L16:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L19
    L19:
        e = move-exception;
        CaeLog.e(TAG, "validateAndRepairRecordFile failed: " + e.getMessage(), e);
        return;
    L28:
        return;
    }

    private void writeJsonValue(File r8, JSONObject r10) {
        byte[] r11 = r10.toString().getBytes(StandardCharsets.UTF_8);
        AtomicFile r12 = new AtomicFile(r8);
        FileOutputStream r13 = r12.startWrite();     // Catch: Exception -> L8
        r13.write(r11);     // Catch: Exception -> L6
        r13.flush();     // Catch: Exception -> L6
        r12.finishWrite(r13);     // Catch: Exception -> L6
        return;
    L6:
        e = e;
    L10:
        if (r13 != null) goto L19;
    L12:
        CaeLog.e(TAG, "writeJsonValue error: " + e.getMessage(), e);
        return;
    L19:
        r12.failWrite(r13);     // Catch: Throwable -> L14
    L8:
        e = e;
        r13 = null;
        goto L10
    }

    public void commitAllValue() {
        Object r8 = this.lock;
        monitor-enter(r8);
        ensureKvCacheLoaded(this.kvFile);     // Catch: Throwable -> L6 Exception -> L8
        writeJsonValue(this.kvFile, this.kvCache);     // Catch: Throwable -> L6 Exception -> L8
    L10:
        monitor-exit(r8);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    L8:
        e = move-exception;
        CaeLog.e(TAG, "commitAllValue error: " + e.getMessage(), e);     // Catch: Throwable -> L6
        goto L10
    }

    public List<NetworkSwitchPolicyML.FeatureParams> getModelParams(int r8, final boolean r10, Integer r11) {
        ArrayList r12 = new ArrayList();
        if (r8 > 0) goto L5;
        return r12;
    L5:
        Object r13 = this.lock;
        monitor-enter(r13);
        if (r11 != null) goto L28;
    L15:
        if (r11 != null) goto L17;
    L19:
        r12.addAll(readFilteredRecords(new File(this.context.getFilesDir(), FILE_IMPORTANT), Long.MIN_VALUE));     // Catch: Throwable -> L13
        List<NetworkSwitchPolicyML.FeatureParams> r14 = readFilteredRecords(new File(this.context.getFilesDir(), FILE_OTHER), Long.MIN_VALUE);     // Catch: Throwable -> L13
    L12:
        r12.addAll(r14);     // Catch: Throwable -> L13
        monitor-exit(r13);     // Catch: Throwable -> L13
        r12.sort(new a(r10));
        if (r12.size() > r8) goto L24;
        return r12;
    L24:
        return new ArrayList(r12.subList(0, r8));
    L13:
        th = move-exception;
        throw th;
    L17:
        if (r11.intValue() != 0) goto L19;
        r14 = readFilteredRecords(new File(this.context.getFilesDir(), FILE_OTHER), Long.MIN_VALUE);     // Catch: Throwable -> L13
        goto L12
    L28:
        if (r11.intValue() != 1) goto L15;
        r14 = readFilteredRecords(new File(this.context.getFilesDir(), FILE_IMPORTANT), Long.MIN_VALUE);     // Catch: Throwable -> L13
        goto L12
    }

    public List<NetworkSwitchPolicyML.FeatureParams> getRecentModelParams(int r8, Integer r10) {
        ArrayList r11 = new ArrayList();
        if (r8 > 0) goto L5;
        return r11;
    L5:
        long r12 = System.currentTimeMillis() - ((((((long) r8) * 24) * 60) * 60) * 1000);
        Object r13 = this.lock;
        monitor-enter(r13);
        int r14 = 1;
        if (r10 != null) goto L25;
    L15:
        if (r10 != null) goto L17;
    L19:
        r11.addAll(readFilteredRecords(new File(this.context.getFilesDir(), FILE_IMPORTANT), r12));     // Catch: Throwable -> L13
        List<NetworkSwitchPolicyML.FeatureParams> r15 = readFilteredRecords(new File(this.context.getFilesDir(), FILE_OTHER), r12);     // Catch: Throwable -> L13
    L12:
        r11.addAll(r15);     // Catch: Throwable -> L13
        monitor-exit(r13);     // Catch: Throwable -> L13
        r11.sort(new f(r14));
        return r11;
    L13:
        th = move-exception;
        throw th;
    L17:
        if (r10.intValue() != 0) goto L19;
        r15 = readFilteredRecords(new File(this.context.getFilesDir(), FILE_OTHER), r12);     // Catch: Throwable -> L13
        goto L12
    L25:
        if (r10.intValue() != 1) goto L15;
        r15 = readFilteredRecords(new File(this.context.getFilesDir(), FILE_IMPORTANT), r12);     // Catch: Throwable -> L13
        goto L12
    }

    public String getValue(String r8, String r10) {
        if (r8 != null) goto L5;
    L20:
        return r10;
    L5:
        if (r8.isEmpty() == true) goto L20;
        Object r11 = this.lock;
        monitor-enter(r11);
        ensureKvCacheLoaded(this.kvFile);     // Catch: Throwable -> L12 Exception -> L14
        String r12 = this.kvCache.optString(r8, r10);     // Catch: Throwable -> L12 Exception -> L14
        monitor-exit(r11);     // Catch: Throwable -> L12
        return r12;
    L14:
        e = move-exception;
        CaeLog.e(TAG, "getValue error: " + e.getMessage(), e);     // Catch: Throwable -> L12
        return r10;
    L12:
        th = move-exception;
        throw th;
    }

    public boolean getValueBoolean(String r8, boolean r10) {
        if (r8 != null) goto L5;
    L20:
        return r10;
    L5:
        if (r8.isEmpty() == true) goto L20;
        Object r11 = this.lock;
        monitor-enter(r11);
        ensureKvCacheLoaded(this.kvFile);     // Catch: Throwable -> L12 Exception -> L14
        boolean r12 = this.kvCache.optBoolean(r8, r10);     // Catch: Throwable -> L12 Exception -> L14
        monitor-exit(r11);     // Catch: Throwable -> L12
        return r12;
    L14:
        e = move-exception;
        CaeLog.e(TAG, "getValueBoolean error: " + e.getMessage(), e);     // Catch: Throwable -> L12
        return r10;
    L12:
        th = move-exception;
        throw th;
    }

    public int getValueInt(String r8, int r10) {
        if (r8 != null) goto L5;
    L20:
        return r10;
    L5:
        if (r8.isEmpty() == true) goto L20;
        Object r11 = this.lock;
        monitor-enter(r11);
        ensureKvCacheLoaded(this.kvFile);     // Catch: Throwable -> L12 Exception -> L14
        int r12 = this.kvCache.optInt(r8, r10);     // Catch: Throwable -> L12 Exception -> L14
        monitor-exit(r11);     // Catch: Throwable -> L12
        return r12;
    L14:
        e = move-exception;
        CaeLog.e(TAG, "getValueInt error: " + e.getMessage(), e);     // Catch: Throwable -> L12
        return r10;
    L12:
        th = move-exception;
        throw th;
    }

    public int purgeRecordsOlderThan(int r8, Integer r10) {
        if (r8 > 0) goto L5;
        return 0;
    L5:
        long r11 = System.currentTimeMillis() - ((((((long) r8) * 24) * 60) * 60) * 1000);
        Object r12 = this.lock;
        monitor-enter(r12);
        if (r10 != null) goto L23;
    L14:
        if (r10 != null) goto L16;
    L18:
        int r13 = pruneOldRecords(new File(this.context.getFilesDir(), FILE_IMPORTANT), r11) + 0;     // Catch: Throwable -> L12
        int r14 = pruneOldRecords(new File(this.context.getFilesDir(), FILE_OTHER), r11) + r13;     // Catch: Throwable -> L12
    L19:
        monitor-exit(r12);     // Catch: Throwable -> L12
        return r14;
    L12:
        th = move-exception;
        throw th;
    L16:
        if (r10.intValue() != 0) goto L18;
        File r15 = new File(this.context.getFilesDir(), FILE_OTHER);     // Catch: Throwable -> L12
    L11:
        r14 = pruneOldRecords(r15, r11) + 0;     // Catch: Throwable -> L12
        goto L19
    L23:
        if (r10.intValue() != 1) goto L14;
        r15 = new File(this.context.getFilesDir(), FILE_IMPORTANT);     // Catch: Throwable -> L12
        goto L11
    }

    public void saveModelParams(long r8, int[] r10, int r11, int r12) {
        if (r10 != null) goto L4;
    L33:
        StringBuilder r13 = new StringBuilder("saveModelParams invalid length: ");
        if (r10 != null) goto L36;
        int r14 = -1;
    L37:
        r13.append(r14);
        CaeLog.w(TAG, r13.toString());
        return;
    L36:
        r14 = r10.length;
        goto L37
    L4:
        if (r10.length != 11) goto L33;
        ByteBuffer r15 = ByteBuffer.allocate(54).order(ByteOrder.LITTLE_ENDIAN);
        r15.putLong(r8);
        int r16 = 0;
    L7:
        if (r16 >= 11) goto L9;
        r15.putInt(r10[r16]);
        r16 = r16 + 1;
        goto L7
    L9:
        r15.put((byte) (r11 & 255));
        r15.put((byte) (r12 & 255));
        byte[] r17 = r15.array();
        File r18 = this.context.getFilesDir();
        if (r12 != 1) goto L12;
        String r19 = FILE_IMPORTANT;
    L13:
        File r20 = new File(r18, r19);
        Object r21 = this.lock;
        monitor-enter(r21);
        FileOutputStream r22 = new FileOutputStream(r20, true);     // Catch: Throwable -> L25 Exception -> L27
        r22.write(r17);     // Catch: Throwable -> L19
        r22.flush();     // Catch: Throwable -> L19
        r22.close();     // Catch: Throwable -> L25 Exception -> L27
    L29:
        monitor-exit(r21);     // Catch: Throwable -> L25
        return;
    L19:
        th = move-exception;
        r22.close();     // Catch: Throwable -> L22
    L24:
        throw th;     // Catch: Throwable -> L25 Exception -> L27
    L22:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L25 Exception -> L27
    L25:
        th = move-exception;
        throw th;
    L27:
        e = move-exception;
        CaeLog.e(TAG, "saveModelParams: Failed to save model params: " + e.getMessage(), e);     // Catch: Throwable -> L25
        goto L29
    L12:
        r19 = FILE_OTHER;
        goto L13
    }

    public void setValue(String r8, String r10) {
        if (r8 != null) goto L5;
    L22:
        CaeLog.w(TAG, "setValue: invalid key");
        return;
    L5:
        if (r8.isEmpty() == true) goto L22;
        Object r11 = this.lock;
        monitor-enter(r11);
        ensureKvCacheLoaded(this.kvFile);     // Catch: Throwable -> L14 Exception -> L16
        JSONObject r12 = this.kvCache;     // Catch: Throwable -> L14 Exception -> L16
        if (r10 != null) goto L12;
        r10 = "";
    L12:
        r12.put(r8, r10);     // Catch: Throwable -> L14 Exception -> L16
    L18:
        monitor-exit(r11);     // Catch: Throwable -> L14
        return;
    L16:
        e = move-exception;
        CaeLog.e(TAG, "setValue error: " + e.getMessage(), e);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public void setValueBoolean(String r8, boolean r10) {
        if (r8 != null) goto L5;
    L19:
        CaeLog.w(TAG, "setValueBoolean: invalid key");
        return;
    L5:
        if (r8.isEmpty() == true) goto L19;
        Object r11 = this.lock;
        monitor-enter(r11);
        ensureKvCacheLoaded(this.kvFile);     // Catch: Throwable -> L11 Exception -> L13
        this.kvCache.put(r8, r10);     // Catch: Throwable -> L11 Exception -> L13
    L15:
        monitor-exit(r11);     // Catch: Throwable -> L11
        return;
    L13:
        e = move-exception;
        CaeLog.e(TAG, "setValueBoolean error: " + e.getMessage(), e);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setValueInt(String r8, int r10) {
        if (r8 != null) goto L5;
    L19:
        CaeLog.w(TAG, "setValueInt: invalid key");
        return;
    L5:
        if (r8.isEmpty() == true) goto L19;
        Object r11 = this.lock;
        monitor-enter(r11);
        ensureKvCacheLoaded(this.kvFile);     // Catch: Throwable -> L11 Exception -> L13
        this.kvCache.put(r8, r10);     // Catch: Throwable -> L11 Exception -> L13
    L15:
        monitor-exit(r11);     // Catch: Throwable -> L11
        return;
    L13:
        e = move-exception;
        CaeLog.e(TAG, "setValueInt error: " + e.getMessage(), e);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }
}
