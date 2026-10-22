package com.ss.android.lark.imageocr.utils;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.photo.preview.menu.action.ImageOCRAction;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ float b;
    public final /* synthetic */ llb.b c;

    public c(String r1, float r2, ImageOCRAction.Companion.addMenu.1.1.1 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ExecutorService r0 = VeOCRController.a;     // Catch: Throwable -> L4
        VeOCRController.a(this.a, this.b, this.c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Log.e("VeOCRController", "ocr image by ve error:" + th);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
