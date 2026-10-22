package cn.nubia.neopush.commons.deviceid;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public class IdCache {
    private static final String TAG = "IdCache";
    private long mFlockTimeout;
    private boolean mSPCommitNow;
    private boolean mSPMultiProcess;

    public static class FlockHolder {
        FileLock flock;
        FileOutputStream fos;

        private FlockHolder() {
        }

        public /* synthetic */ FlockHolder(FlockHolder r5) {
            this();
        }
    }

    public IdCache() {
        this.mSPCommitNow = true;
        this.mSPMultiProcess = false;
        this.mFlockTimeout = 5000;
    }

    private void closeSafely(Closeable r5) {
        if (r5 == null) goto L8;
        r5.close();     // Catch: Exception -> L5
        return;
    L9:
        return;
    }

    public void enableSPMultiProcess(boolean r5) {
        this.mSPMultiProcess = r5;
    }

    public boolean loadFromCursor(Cursor r5, String[] r10, String[] r11, boolean r12) {
        boolean r13 = false;
        int r14 = 0;
        r13 = false;
        r13 = false;
        r13 = false;
        r13 = false;
        r13 = false;
        if (r5 == null) goto L22;
        if (r10 == null) goto L22;
        if (r10.length <= 0) goto L22;
        if (r11 == null) goto L22;
        if (r10.length != r11.length) goto L22;
        boolean r15 = r5.moveToNext();     // Catch: Exception -> L28
        if (r15 == true) goto L33;
    L21:
        r13 = r15;
    L33:
        if (r14 >= r10.length) goto L21;
        if (TextUtils.isEmpty(r10[r14]) == true) goto L20;
        int r16 = r5.getColumnIndex(r10[r14]);     // Catch: Exception -> L27
        if (r16 < 0) goto L20;
        r11[r14] = r5.getString(r16);     // Catch: Exception -> L26
    L20:
        r14 = r14 + 1;
    L22:
        if (r12 == false) goto L25;
        if (r5 == null) goto L25;
        r5.close();
    L25:
        return r13;
    }

    public void loadFromFile(Context r5, String r10, String[] r11, String[] r12) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r10) == true) goto L35;
        if (r11 != null) goto L7;
        return;
    L7:
        if (r11.length <= 0) goto L37;
        if (r12 != null) goto L10;
        return;
    L10:
        if (r11.length != r12.length) goto L39;
        FileInputStream r13 = null;
        r13 = r5.openFileInput(r10);     // Catch: Exception -> L27 Throwable -> L20
        Properties r14 = new Properties();     // Catch: Exception -> L27 Throwable -> L20
        r14.load(r13);     // Catch: Exception -> L27 Throwable -> L20
        int r15 = 0;
    L14:
        if (r15 >= r11.length) goto L15;
        if (TextUtils.isEmpty(r11[r15]) == true) goto L22;
        r12[r15] = r14.getProperty(r11[r15]);     // Catch: Throwable -> L20 Exception -> L26
    L22:
        r15 = r15 + 1;
    L20:
        th = move-exception;
        closeSafely(r13);
        throw th;
    L15:
        closeSafely(r13);
        return;
    L39:
        return;
    L37:
        return;
    }

    public void loadFromSP(Context r5, String r10, String[] r11, String[] r12) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r10) == true) goto L31;
        if (r11 != null) goto L7;
        return;
    L7:
        if (r11.length <= 0) goto L33;
        if (r12 != null) goto L10;
        return;
    L10:
        if (r11.length != r12.length) goto L35;
        int r13 = 0;
        if (this.mSPMultiProcess == false) goto L14;
        int r14 = 4;
    L15:
        SharedPreferences r15 = r5.getSharedPreferences(r10, r14);
        if (r15 != null) goto L18;
        return;
    L18:
        if (r13 >= r11.length) goto L37;
        if (TextUtils.isEmpty(r11[r13]) == true) goto L23;
        r12[r13] = r15.getString(r11[r13], null);     // Catch: Exception -> L25
    L23:
        r13 = r13 + 1;
        goto L18
    L37:
        return;
    L14:
        r14 = 0;
        goto L15
    L35:
        return;
    L33:
        return;
    }

    public Object obtainFileLock(Context r14, String r15) {
        FlockHolder r5 = null;
        if (r14 != null) goto L5;
    L21:
        return null;
    L5:
        if (TextUtils.isEmpty(r15) == true) goto L21;
        long r10 = this.mFlockTimeout / 20;
        int r11 = 0;
    L7:
        FlockHolder r12 = new FlockHolder(r5);
        FileOutputStream r13 = new FileOutputStream(new File(r14.getFilesDir(), ".lock_" + r15));     // Catch: Exception -> L13
        r12.fos = r13;     // Catch: Exception -> L13
        FileLock r16 = r13.getChannel().tryLock();     // Catch: Exception -> L13
        r12.flock = r16;     // Catch: Exception -> L13
        if (r16 == null) goto L15;
        if (r16.isValid() == false) goto L15;
        return r12;
    L15:
        releaseFileLock(r12);
        if (r11 < (r10 - 1)) goto L23;
    L18:
        r11 = r11 + 1;
        if (r11 < r10) goto L7;
        Log.i(TAG, "Can't obtain file lock, timeout !");
        goto L21
    L23:
        Thread.sleep(20);     // Catch: Exception -> L22
    L13:
        e = move-exception;
        Log.i(TAG, "Failed to obtain file lock " + e);
        goto L15
    }

    public void releaseFileLock(Object r5) {
        if ((r5 instanceof FlockHolder) == false) goto L12;
        FlockHolder r10 = (FlockHolder) r5;
        FileLock r11 = r10.flock;
        if (r11 != null) goto L10;
    L7:
        closeSafely(r10.fos);
        return;
    L10:
        r11.release();     // Catch: Exception -> L9
        goto L7
    }

    public void saveToFile(Context r10, String r11, String[] r12, String[] r13) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r11) == true) goto L65;
        if (r12 != null) goto L7;
        return;
    L7:
        if (r12.length <= 0) goto L67;
        if (r13 != null) goto L10;
        return;
    L10:
        if (r12.length != r13.length) goto L69;
        Properties r5 = new Properties();
        FileInputStream r14 = null;
        FileInputStream r15 = r10.openFileInput(r11);     // Catch: Throwable -> L17 Exception -> L20
        r5.load(r15);     // Catch: Exception -> L46 Throwable -> L15
    L15:
        th = th;
        r14 = r15;
    L18:
        closeSafely(r14);
        throw th;
    L14:
        closeSafely(r15);
        int r16 = 0;
    L49:
        if (r16 < r12.length) goto L39;
        FileOutputStream r17 = r10.openFileOutput(r11, 0);     // Catch: Throwable -> L31 Exception -> L33
        r5.store(r17, null);     // Catch: Throwable -> L27 Exception -> L29
        closeSafely(r17);
    L48:
        return;
    L29:
        e = e;
        r14 = r17;
    L34:
        Log.e(TAG, "Failed to save to file " + e);     // Catch: Throwable -> L31
        closeSafely(r14);
    L27:
        th = th;
        r14 = r17;
    L36:
        closeSafely(r14);
        throw th;
    L33:
        e = e;
        goto L34
    L39:
        if (TextUtils.isEmpty(r12[r16]) == true) goto L44;
        String r18 = r13[r16];     // Catch: Exception -> L47
        if (r18 == null) goto L43;
        r5.setProperty(r12[r16], r18);     // Catch: Exception -> L47
        goto L44
    L43:
        r5.remove(r12[r16]);     // Catch: Exception -> L47
    L44:
        r16 = r16 + 1;
    L31:
        th = th;
        goto L36
    L20:
        r15 = null;
    L17:
        th = th;
        goto L18
    L69:
        return;
    L67:
        return;
    }

    public void saveToSP(Context r5, String r10, String[] r11, String[] r12) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r10) == true) goto L35;
        if (r11 != null) goto L7;
        return;
    L7:
        if (r11.length <= 0) goto L37;
        if (r12 != null) goto L10;
        return;
    L10:
        if (r11.length != r12.length) goto L39;
        int r13 = 0;
        if (this.mSPMultiProcess == false) goto L14;
        int r14 = 4;
    L15:
        SharedPreferences r15 = r5.getSharedPreferences(r10, r14);
        if (r15 == null) goto L40;
        SharedPreferences.Editor r16 = r15.edit();
        if (r16 != null) goto L20;
        return;
    L20:
        if (r13 >= r11.length) goto L22;
        if (TextUtils.isEmpty(r11[r13]) == true) goto L30;
        r16.putString(r11[r13], r12[r13]);
    L30:
        r13 = r13 + 1;
        goto L20
    L22:
        if (this.mSPCommitNow == true) goto L24;
        r16.apply();
        return;
    L24:
        if (r16.commit() == true) goto L42;
        Log.e(TAG, "Failed to commit prefs");
        return;
    L42:
        return;
    L40:
        return;
    L14:
        r14 = 0;
        goto L15
    L39:
        return;
    L37:
        return;
    }

    public void setFlockTimeout(long r5) {
        this.mFlockTimeout = r5;
    }

    public void setSPCommitNow(boolean r5) {
        this.mSPCommitNow = r5;
    }
}
