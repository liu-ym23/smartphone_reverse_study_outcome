package com.larus.agents.impl.network;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.agents.impl.network.CachedWorkExperienceRepository$getDetail$stored$1", f = "WorkExperienceApi.kt", i = {}, l = {383}, m = "invokeSuspend", n = {}, s = {})
public final class CachedWorkExperienceRepository$getDetail$stored$1 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $accountId;
    final /* synthetic */ com.larus.agents.impl.experience.n $detail;
    final /* synthetic */ Long $revision;
    int label;
    final /* synthetic */ CachedWorkExperienceRepository this$0;

    public CachedWorkExperienceRepository$getDetail$stored$1(CachedWorkExperienceRepository r1, String r2, com.larus.agents.impl.experience.n r3, Long r4, Continuation<? super CachedWorkExperienceRepository$getDetail$stored$1> r5) {
        this.this$0 = r1;
        this.$accountId = r2;
        this.$detail = r3;
        this.$revision = r4;
        super(1, r5);
    }

    public final Continuation<Unit> create(Continuation<?> r8) {
        return new CachedWorkExperienceRepository$getDetail$stored$1(this.this$0, this.$accountId, this.$detail, this.$revision, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Boolean> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        com.larus.agents.impl.experience.m r3 = this.this$0.b;
        String r4 = this.$accountId;
        com.larus.agents.impl.experience.n r5 = this.$detail;
        long r6 = this.$revision.longValue();
        this.label = 1;
        r10 = r3.b(r4, r5, r6, this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
