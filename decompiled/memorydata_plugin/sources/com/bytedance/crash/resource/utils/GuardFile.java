package com.bytedance.crash.resource.utils;

import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class GuardFile {
    public static final long DEFAULT_EXPIRE_TIME = 604800;
    private static final String TAG = "GuardFile: ";
    private final long mExpireTime;
    private final File mGuardFile;
    private final String mGuardFileName;

    public GuardFile(String r2, String r3, long r4) {
        this.mGuardFile = new File(r2, r3);
        this.mGuardFileName = r3;
        if (r4 > 0) goto L6;
        r4 = DEFAULT_EXPIRE_TIME;
    L6:
        this.mExpireTime = r4;
    }

    public boolean checkGuardFile() {
        if (this.mGuardFile.exists() == true) goto L18;
        return true;
    L18:
        long r3 = System.currentTimeMillis() / 1000;     // Catch: IOException -> L15
        long r5 = Long.parseLong(FileUtils.readFile(this.mGuardFile.getAbsolutePath()));     // Catch: IOException -> L15
        if (r3 >= r5) goto L8;
        NpthLog.i(TAG, this.mGuardFileName + ": time error currentTime is earlier than lastTime");     // Catch: IOException -> L15
        return false;
    L8:
        if ((r3 - r5) >= this.mExpireTime) goto L11;
        NpthLog.i(TAG, this.mGuardFileName + ": CheckTime Less than " + this.mExpireTime + " seconds, lastTime:" + r5 + " currentTime:" + r3);     // Catch: IOException -> L15
        return false;
    L11:
        FileUtils.deleteFile(this.mGuardFile.getAbsolutePath());     // Catch: IOException -> L15
        NpthLog.i(TAG, this.mGuardFileName + ": deleteFile guard file");     // Catch: IOException -> L15
        return true;
    L15:
        NpthLog.i(TAG, this.mGuardFileName + ": read guard file faild!");
        return false;
    }

    public void createGuardFile() {
        FileUtils.writeFile(this.mGuardFile, String.valueOf(System.currentTimeMillis() / 1000), false);     // Catch: Throwable -> L5
        NpthLog.i(TAG, this.mGuardFileName + ": createGuardFile success");     // Catch: Throwable -> L5
        return;
    L5:
        NpthLog.i(TAG, this.mGuardFileName + ": createGuardFile fail");
    }

    public void deleteGurardFile() {
        if (this.mGuardFile.exists() == true) goto L5;
        return;
    L5:
        if (this.mGuardFile.delete() == true) goto L7;
        String r1 = "delete guard file faild!";
    L8:
        NpthLog.i(TAG, r1);
        return;
    L7:
        r1 = "delete guard file success";
        goto L8
    }
}
