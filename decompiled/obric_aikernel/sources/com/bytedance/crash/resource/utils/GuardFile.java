package com.bytedance.crash.resource.utils;

import androidx.annotation.NonNull;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class GuardFile {
    public static final long DEFAULT_EXPIRE_TIME = 604800;
    private static final String TAG = "GuardFile: ";
    private final long mExpireTime;
    private final File mGuardFile;
    private final String mGuardFileName;

    public GuardFile(@NonNull String r10, String r11, long r12) {
        this.mGuardFile = new File(r10, r11);
        this.mGuardFileName = r11;
        if (r12 > 0) goto L6;
        r12 = DEFAULT_EXPIRE_TIME;
    L6:
        this.mExpireTime = r12;
    }

    public boolean checkGuardFile() {
        if (this.mGuardFile.exists() == true) goto L18;
        return true;
    L18:
        long r10 = System.currentTimeMillis() / 1000;     // Catch: IOException -> L15
        long r11 = Long.parseLong(FileUtils.readFile(this.mGuardFile.getAbsolutePath()));     // Catch: IOException -> L15
        if (r10 >= r11) goto L8;
        NpthLog.i(TAG, this.mGuardFileName + ": time error currentTime is earlier than lastTime");     // Catch: IOException -> L15
        return false;
    L8:
        if ((r10 - r11) >= this.mExpireTime) goto L11;
        NpthLog.i(TAG, this.mGuardFileName + ": CheckTime Less than " + this.mExpireTime + " seconds, lastTime:" + r11 + " currentTime:" + r10);     // Catch: IOException -> L15
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
        String r10 = "delete guard file faild!";
    L8:
        NpthLog.i(TAG, r10);
        return;
    L7:
        r10 = "delete guard file success";
        goto L8
    }
}
