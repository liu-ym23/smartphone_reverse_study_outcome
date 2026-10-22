package com.bytedance.ai.applet.login;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.login.CustomLoginNavigator", f = "CustomLoginNavigator.kt", i = {}, l = {82}, m = "navigateToCustomLogin-hUnOzRk", n = {}, s = {})
public final class CustomLoginNavigator$navigateToCustomLogin$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CustomLoginNavigator this$0;

    public CustomLoginNavigator$navigateToCustomLogin$1(CustomLoginNavigator r1, Continuation<? super CustomLoginNavigator$navigateToCustomLogin$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        Object r11 = this.this$0.a(null, null, null, null, null, this);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Result.box-impl(r11);
    }
}
