package com.bytedance.ai.applet.app.foundation;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.app.foundation.AppletAppRouter", f = "AppletAppRouter.kt", i = {}, l = {213}, m = "launch-IoAF18A", n = {}, s = {})
public final class AppletAppRouter$launch$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppletAppRouter this$0;

    public AppletAppRouter$launch$1(AppletAppRouter r1, Continuation<? super AppletAppRouter$launch$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        Object r11 = this.this$0.l(this);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Result.box-impl(r11);
    }
}
