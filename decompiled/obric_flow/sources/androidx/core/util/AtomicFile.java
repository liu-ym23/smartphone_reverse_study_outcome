package androidx.core.util;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class AtomicFile {
    private static final String LOG_TAG = "AtomicFile";
    private final File mBaseName;
    private final File mLegacyBackupName;
    private final File mNewName;

    public AtomicFile(@NonNull File r5) {
        this.mBaseName = r5;
        this.mNewName = new File(r5.getPath() + ".new");
        this.mLegacyBackupName = new File(r5.getPath() + ".bak");
    }

    private static void rename(@NonNull File r5, @NonNull File r10) {
        if (r10.isDirectory() == false) goto L8;
        if (r10.delete() == true) goto L8;
        Log.e(LOG_TAG, "Failed to delete file which is a directory " + r10);
    L8:
        if (r5.renameTo(r10) == true) goto L11;
        Log.e(LOG_TAG, "Failed to rename " + r5 + " to " + r10);
        return;
    }

    private static boolean sync(@NonNull FileOutputStream r5) {
        r5.getFD().sync();     // Catch: IOException -> L5
        return true;
    L5:
        return false;
    }

    public void delete() {
        this.mBaseName.delete();
        this.mNewName.delete();
        this.mLegacyBackupName.delete();
    }

    public void failWrite(@Nullable FileOutputStream r5) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (sync(r5) == true) goto L15;
        Log.e(LOG_TAG, "Failed to sync file output stream");
    L15:
        r5.close();     // Catch: IOException -> L9
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

    public void finishWrite(@Nullable FileOutputStream r5) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (sync(r5) == true) goto L13;
        Log.e(LOG_TAG, "Failed to sync file output stream");
    L13:
        r5.close();     // Catch: IOException -> L9
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
    public FileInputStream openRead() throws FileNotFoundException {
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
    public byte[] readFully() throws IOException {
        FileInputStream r5 = openRead();
        byte[] r10 = new byte[r5.available()];     // Catch: Throwable -> L13
        int r11 = 0;
    L4:
        int r12 = r5.read(r10, r11, r10.length - r11);     // Catch: Throwable -> L13
        if (r12 <= 0) goto L6;
        r11 = r11 + r12;
        int r13 = r5.available();     // Catch: Throwable -> L13
        if (r13 <= (r10.length - r11)) goto L4;
        byte[] r14 = new byte[r13 + r11];     // Catch: Throwable -> L13
        System.arraycopy(r10, 0, r14, 0, r11);     // Catch: Throwable -> L13
        r10 = r14;
        goto L4
    L6:
        r5.close();
        return r10;
    L13:
        th = move-exception;
        r5.close();
        throw th;
    }

    @NonNull
    public FileOutputStream startWrite() throws IOException {
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
