package com.bytedance.ai.model.widgets;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.model.widgets.LynxEngineAssem", f = "LynxEngineAssem.kt", i = {0}, l = {186}, m = "loadTemplateBundleFromPackage", n = {"sessionId"}, s = {"L$0"})
final class LynxEngineAssem$loadTemplateBundleFromPackage$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LynxEngineAssem this$0;

    public LynxEngineAssem$loadTemplateBundleFromPackage$1(LynxEngineAssem r1, Continuation<? super LynxEngineAssem$loadTemplateBundleFromPackage$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return LynxEngineAssem.s(this.this$0, this);
    }
}
