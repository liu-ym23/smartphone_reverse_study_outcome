package com.obric.aiproactive.impl.livecard;

import androidx.core.app.NotificationCompat;
import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.impl.livecard.ProactiveLiveCardManager", f = "ProactiveLiveCardManager.kt", i = {0, 0, 0, 0, 0, 0, 0, 4, 4, 4, 4, 4, 4, 4, 4, 8, 8, 8, 9, 9, 9}, l = {920, 964, 964, 964, 1478, 964, 964, 964, 949, 955, 964, 964}, m = "submitContinueFromLockScreen$ai_proactive_impl_obricRelease", n = {"this", NotificationCompat.CATEGORY_RECOMMENDATION, "action", "session", "service", Ext.KEY_REQUEST, "recommendId", "this", NotificationCompat.CATEGORY_RECOMMENDATION, "action", "session", "service", Ext.KEY_REQUEST, "recommendId", "$this$withLock_u24default$iv", "this", "session", "recommendId", "this", "session", "recommendId"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
final class ProactiveLiveCardManager$submitContinueFromLockScreen$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ n this$0;

    ProactiveLiveCardManager$submitContinueFromLockScreen$1(n r3, Continuation<? super ProactiveLiveCardManager$submitContinueFromLockScreen$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, null, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
