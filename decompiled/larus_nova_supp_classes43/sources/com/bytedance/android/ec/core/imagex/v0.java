package com.bytedance.android.ec.core.imagex;

import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class v0 implements Runnable {
    public final /* synthetic */ GenericDraweeView a;
    public final /* synthetic */ ImageRequest[] b;
    public final /* synthetic */ ImageRequest c;
    public final /* synthetic */ r d;
    public final /* synthetic */ ControllerListener e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ Function1 g;

    public v0(GenericDraweeView r1, ImageRequest[] r10, ImageRequest r11, r r12, ControllerListener r13, boolean r14, Function1 r15) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ImageExtensionsKt.y(this.a, this.b, this.c, this.d, this.e, this.f, this.g, true, null, 128);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
