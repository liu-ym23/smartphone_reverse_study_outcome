package com.larus.profile.impl.creation;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.creation.CreationImageEditAbility", f = "CreationImageEditAbility.kt", i = {0}, l = {429}, m = "downloadByUrl", n = {"dataSubscriber"}, s = {"L$0"})
public final class CreationImageEditAbility$downloadByUrl$3 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationImageEditAbility this$0;

    public CreationImageEditAbility$downloadByUrl$3(CreationImageEditAbility r1, Continuation<? super CreationImageEditAbility$downloadByUrl$3> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        CreationImageEditAbility r3 = this.this$0;
        int r0 = CreationImageEditAbility.d;
        return r3.d(null, null, null, this);
    }
}
