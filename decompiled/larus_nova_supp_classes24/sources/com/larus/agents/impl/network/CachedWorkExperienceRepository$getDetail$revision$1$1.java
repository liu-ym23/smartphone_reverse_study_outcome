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
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.agents.impl.network.CachedWorkExperienceRepository$getDetail$revision$1$1", f = "WorkExperienceApi.kt", i = {}, l = {374}, m = "invokeSuspend", n = {}, s = {})
public final class CachedWorkExperienceRepository$getDetail$revision$1$1 extends SuspendLambda implements Function1<Continuation<? super Long>, Object> {
    final /* synthetic */ String $experienceId;
    final /* synthetic */ String $it;
    int label;
    final /* synthetic */ CachedWorkExperienceRepository this$0;

    public CachedWorkExperienceRepository$getDetail$revision$1$1(CachedWorkExperienceRepository r1, String r2, String r3, Continuation<? super CachedWorkExperienceRepository$getDetail$revision$1$1> r4) {
        this.this$0 = r1;
        this.$it = r2;
        this.$experienceId = r3;
        super(1, r4);
    }

    public final Continuation<Unit> create(Continuation<?> r5) {
        return new CachedWorkExperienceRepository$getDetail$revision$1$1(this.this$0, this.$it, this.$experienceId, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Long> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        return r5;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        com.larus.agents.impl.experience.m r6 = this.this$0.b;
        String r2 = this.$it;
        String r3 = this.$experienceId;
        this.label = 1;
        r5 = r6.d(r2, r3, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
