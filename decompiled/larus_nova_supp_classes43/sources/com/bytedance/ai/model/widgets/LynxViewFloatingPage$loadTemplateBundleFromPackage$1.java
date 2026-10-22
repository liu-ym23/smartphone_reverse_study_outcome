package com.bytedance.ai.model.widgets;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.model.widgets.LynxViewFloatingPage", f = "LynxViewFloatingPage.kt", i = {0, 0}, l = {458}, m = "loadTemplateBundleFromPackage", n = {"packageName", BdpAwemeConstant.KEY_APP_ID}, s = {"L$0", "L$1"})
final class LynxViewFloatingPage$loadTemplateBundleFromPackage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LynxViewFloatingPage this$0;

    public LynxViewFloatingPage$loadTemplateBundleFromPackage$1(LynxViewFloatingPage r1, Continuation<? super LynxViewFloatingPage$loadTemplateBundleFromPackage$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return LynxViewFloatingPage.h(this.this$0, this);
    }
}
