package com.larus.agents.impl.network;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.agents.impl.experience.s;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lcom/larus/agents/impl/experience/WorkExperiencePage;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.agents.impl.network.CachedWorkExperienceRepository$cachedFirstPage$2", f = "WorkExperienceApi.kt", i = {}, l = {434}, m = "invokeSuspend", n = {}, s = {})
final class CachedWorkExperienceRepository$cachedFirstPage$2 extends SuspendLambda implements Function1<Continuation<? super s>, Object> {
    final /* synthetic */ String $accountId;
    int label;
    final /* synthetic */ CachedWorkExperienceRepository this$0;

    public CachedWorkExperienceRepository$cachedFirstPage$2(CachedWorkExperienceRepository r1, String r2, Continuation<? super CachedWorkExperienceRepository$cachedFirstPage$2> r3) {
        this.this$0 = r1;
        this.$accountId = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new CachedWorkExperienceRepository$cachedFirstPage$2(this.this$0, this.$accountId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super s> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        return r4;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        com.larus.agents.impl.experience.m r5 = this.this$0.b;
        String r2 = this.$accountId;
        this.label = 1;
        r4 = r5.i(r2, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
