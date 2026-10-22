package com.obric.memorydata.screencapture.accessibility;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.screencapture.accessibility.ScreenshotManager", f = "ScreenshotManager.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {277, 65}, m = "generateScreenshotForNode", n = {"rootNode", "screenshotOption", "key", "$this$withLock_u24default$iv", "key", "$this$withLock_u24default$iv", "currentTime"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "J$0"})
final class ScreenshotManager$generateScreenshotForNode$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ e this$0;

    ScreenshotManager$generateScreenshotForNode$1(e r3, Continuation<? super ScreenshotManager$generateScreenshotForNode$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
