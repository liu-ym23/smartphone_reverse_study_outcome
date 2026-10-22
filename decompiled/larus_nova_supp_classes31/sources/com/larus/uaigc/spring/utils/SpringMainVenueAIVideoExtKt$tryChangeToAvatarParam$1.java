package com.larus.uaigc.spring.utils;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.spring.utils.SpringMainVenueAIVideoExtKt", f = "SpringMainVenueAIVideoExt.kt", i = {0, 0, 0, 0}, l = {72}, m = "tryChangeToAvatarParam", n = {"$this$tryChangeToAvatarParam", "pocket", "disposableAvatarCreatedFormat", "aiReplicaInfo"}, s = {"L$0", "L$1", "L$2", "L$3"})
final class SpringMainVenueAIVideoExtKt$tryChangeToAvatarParam$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    public SpringMainVenueAIVideoExtKt$tryChangeToAvatarParam$1(Continuation<? super SpringMainVenueAIVideoExtKt$tryChangeToAvatarParam$1> r1) {
        super(r1);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return e.a(null, null, null, this);
    }
}
