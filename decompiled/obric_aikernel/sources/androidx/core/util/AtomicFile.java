package androidx.core.util;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class AtomicFile {
    private static final String LOG_TAG = "AtomicFile";
    private final File mBaseName;
    private final File mLegacyBackupName;
    private final File mNewName;

    public AtomicFile(@NonNull File r10) {
        this.mBaseName = r10;
        this.mNewName = new File(r10.getPath() + ".new");
        this.mLegacyBackupName = new File(r10.getPath() + ".bak");
    }

    private static void rename(@NonNull File r10, @NonNull File r11) {
        if (r11.isDirectory() == false) goto L8;
        if (r11.delete() == true) goto L8;
        Log.e(LOG_TAG, "Failed to delete file which is a directory " + r11);
    L8:
        if (r10.renameTo(r11) == true) goto L11;
        Log.e(LOG_TAG, "Failed to rename " + r10 + " to " + r11);
        return;
    }

    private static boolean sync(@NonNull FileOutputStream r10) {
        r10.getFD().sync();     // Catch: IOException -> L5
        return true;
    L5:
        return false;
    }

    public void delete() {
        this.mBaseName.delete();
        this.mNewName.delete();
        this.mLegacyBackupName.delete();
    }

    public void failWrite(@Nullable FileOutputStream r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (sync(r10) == true) goto L15;
        Log.e(LOG_TAG, "Failed to sync file output stream");
    L15:
        r10.close();     // Catch: IOException -> L9
    L12:
        if (this.mNewName.delete() == true) goto L17;
        Log.e(LOG_TAG, "Failed to delete new file " + this.mNewName);
        return;
    L17:
        return;
    L9:
        e = move-exception;
        Log.e(LOG_TAG, "Failed to close file output stream", e);
        goto L12
    }

    public void finishWrite(@Nullable FileOutputStream r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (sync(r10) == true) goto L13;
        Log.e(LOG_TAG, "Failed to sync file output stream");
    L13:
        r10.close();     // Catch: IOException -> L9
    L11:
        rename(this.mNewName, this.mBaseName);
        return;
    L9:
        e = move-exception;
        Log.e(LOG_TAG, "Failed to close file output stream", e);
        goto L11
    }

    @NonNull
    public File getBaseFile() {
        return this.mBaseName;
    }

    @NonNull
    public FileInputStream openRead() {
        if (this.mLegacyBackupName.exists() == false) goto L6;
        rename(this.mLegacyBackupName, this.mBaseName);
    L6:
        if (this.mNewName.exists() == false) goto L13;
        if (this.mBaseName.exists() == false) goto L13;
        if (this.mNewName.delete() == true) goto L13;
        Log.e(LOG_TAG, "Failed to delete outdated new file " + this.mNewName);
    L13:
        return new FileInputStream(this.mBaseName);
    }

    @NonNull
    public byte[] readFully() {
        FileInputStream r10 = openRead();
        byte[] r11 = new byte[r10.available()];     // Catch: Throwable -> L13
        int r12 = 0;
    L4:
        int r13 = r10.read(r11, r12, r11.length - r12);     // Catch: Throwable -> L13
        if (r13 <= 0) goto L6;
        r12 = r12 + r13;
        int r14 = r10.available();     // Catch: Throwable -> L13
        if (r14 <= (r11.length - r12)) goto L4;
        byte[] r15 = new byte[r14 + r12];     // Catch: Throwable -> L13
        System.arraycopy(r11, 0, r15, 0, r12);     // Catch: Throwable -> L13
        r11 = r15;
        goto L4
    L6:
        r10.close();
        return r11;
    L13:
        th = move-exception;
        r10.close();
        throw th;
    }

    @NonNull
    public FileOutputStream startWrite() {
        if (this.mLegacyBackupName.exists() == false) goto L16;
        rename(this.mLegacyBackupName, this.mBaseName);
    L16:
        return new FileOutputStream(this.mNewName);
    L8:
        if (this.mNewName.getParentFile().mkdirs() == false) goto L15;
        return new FileOutputStream(this.mNewName);
    L11:
        e = move-exception;
        throw new IOException("Failed to create new file " + this.mNewName, e);
    L15:
        throw new IOException("Failed to create directory for " + this.mNewName);
    }
}
