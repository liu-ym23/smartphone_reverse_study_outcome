package com.ss.android.lark.photoeditor.impl.ui;

import android.graphics.Bitmap;
import com.larksuite.framework.mvp.BaseModel;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.lark.android.encryption.CipherManager;
import com.ss.lark.android.encryption.exception.EncryptException;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class h extends BaseModel implements a {
    public h() {
    }

    public static boolean h(h r12, Bitmap r13) {
        r12.getClass();
        if (p0c.a.a() != null) goto L5;
    L7:
        if (r13 != null) goto L9;
        return false;
    L9:
        if (r13.hasAlpha() == false) goto L26;
        int r14 = r13.getWidth();
        int r9 = r13.getHeight();
        int[] r10 = new int[r14];
        int r11 = 0;
    L12:
        if (r11 >= r9) goto L27;
        r13.getPixels(r10, 0, r14, 0, r11, r14, 1);
        int r1 = 0;
    L14:
        if (r1 >= r14) goto L19;
        if ((r10[r1] >>> 24) != 255) goto L17;
        r1 = r1 + 1;
        goto L14
    L17:
        return true;
    L19:
        r11 = r11 + 1;
        goto L12
    L27:
        return false;
    L26:
        return false;
    L5:
        if (p0c.a.a().isFeatureGatingEnable("image_editor.photo_png_compress_reverse") == false) goto L7;
        return false;
    }

    public static void k(h r2, VFSFile r3) {
        r2.getClass();
        CipherManager.c(r3);     // Catch: EncryptException -> L5
        Log.i("PhotoEditorModel", "[cipher] file encrypt success, path = " + r3.getAbsolutePath());     // Catch: EncryptException -> L5
        return;
    L5:
        Log.e("PhotoEditorModel", "[cipher] file encrypt failed, path = " + r3.getAbsolutePath());
    }

    @Override // com.ss.android.lark.photoeditor.impl.ui.a
    public final void g5(File r4, l r5) {
        int r0 = CipherManager.a;
        Intrinsics.checkNotNullParameter(r4, "file");
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new com.ss.lark.android.encryption.a(r4, false, r5));
    }

    @Override // com.ss.android.lark.photoeditor.impl.ui.a
    public final void n0(final Bitmap r3, final vfc.d r4) {
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new c(this, r3, r4));
    }

    @Override // com.ss.android.lark.photoeditor.impl.ui.a
    public final void m1(Bitmap r2, String r3, m.a r4) {
        Observable.create(new g(this, r3, r2)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(r4), new f(r4));
    }
}
