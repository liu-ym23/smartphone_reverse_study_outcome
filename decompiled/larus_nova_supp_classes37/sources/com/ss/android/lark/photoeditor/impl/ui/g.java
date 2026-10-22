package com.ss.android.lark.photoeditor.impl.ui;

import android.graphics.Bitmap;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g implements ObservableOnSubscribe<File> {
    public final /* synthetic */ String a;
    public final /* synthetic */ Bitmap b;
    public final /* synthetic */ h c;

    public final void subscribe(ObservableEmitter<File> r8) throws Exception {
        OutputStream r3 = null;
        VFSFiles.b.getClass();     // Catch: Throwable -> L15 Exception -> L17
        VFSFile r5 = VFSFiles.b(true).i(this.a);     // Catch: Throwable -> L15 Exception -> L17
        Log.i("PhotoEditorModel", "result file isExit = " + r5.exists());     // Catch: Throwable -> L15 Exception -> L17
        if (r5.exists() == true) goto L6;
        r5.createNewFile();     // Catch: Throwable -> L15 Exception -> L17
    L6:
        r3 = VFSFiles.b(true).s(r5.getVfsPath(), false);     // Catch: Throwable -> L15 Exception -> L17
        if (h.h(this.c, this.b) == false) goto L9;
        Bitmap.CompressFormat r2 = Bitmap.CompressFormat.PNG;     // Catch: Throwable -> L15 Exception -> L17
    L10:
        Log.i("PhotoEditorModel", "result file bitmap compress format = " + r2 + ", isSuccessful = " + this.b.compress(r2, 100, r3));     // Catch: Throwable -> L15 Exception -> L17
        r3.flush();     // Catch: Throwable -> L15 Exception -> L17
        h.k(this.c, r5);     // Catch: Throwable -> L15 Exception -> L17
        r8.onNext(r5);     // Catch: Throwable -> L15 Exception -> L17
        r8.onComplete();     // Catch: Throwable -> L15 Exception -> L17
    L39:
        r3.close();     // Catch: IOException -> L13
        return;
    L13:
        e = move-exception;
        Throwable r1 = new Throwable(e);
    L24:
        r8.onError(r1);
        return;
    L9:
        r2 = Bitmap.CompressFormat.JPEG;     // Catch: Throwable -> L15 Exception -> L17
    L17:
        e = move-exception;
        r8.onError(new Throwable(e));     // Catch: Throwable -> L15
        if (r3 == null) goto L41;
        r3.close();     // Catch: IOException -> L22
        return;
    L22:
        e = move-exception;
        r1 = new Throwable(e);
        goto L24
    L41:
        return;
    L15:
        th = move-exception;
        if (r3 != null) goto L34;
    L31:
        throw th;
    L34:
        r3.close();     // Catch: IOException -> L29
    L29:
        e = move-exception;
        r8.onError(new Throwable(e));
        goto L31
    }

    public g(h r1, String r2, Bitmap r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
