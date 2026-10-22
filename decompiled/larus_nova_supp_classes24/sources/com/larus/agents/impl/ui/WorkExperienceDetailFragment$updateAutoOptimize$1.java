package com.larus.agents.impl.ui;

import android.content.Context;
import android.os.Bundle;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.agents.impl.databinding.LarusFragmentWorkExperienceDetailBinding;
import com.larus.agents.impl.experience.WorkExperienceMutationResult;
import com.larus.agents.impl.experience.WorkExperienceSource;
import com.larus.agents.impl.network.CachedWorkExperienceRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.agents.impl.ui.WorkExperienceDetailFragment$updateAutoOptimize$1", f = "WorkExperienceDetailFragment.kt", i = {}, l = {116}, m = "invokeSuspend", n = {}, s = {})
final class WorkExperienceDetailFragment$updateAutoOptimize$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.agents.impl.experience.n $current;
    final /* synthetic */ boolean $enabled;
    int label;
    final /* synthetic */ WorkExperienceDetailFragment this$0;

    public WorkExperienceDetailFragment$updateAutoOptimize$1(WorkExperienceDetailFragment r1, com.larus.agents.impl.experience.n r2, boolean r3, Continuation<? super WorkExperienceDetailFragment$updateAutoOptimize$1> r4) {
        this.this$0 = r1;
        this.$current = r2;
        this.$enabled = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new WorkExperienceDetailFragment$updateAutoOptimize$1(this.this$0, this.$current, this.$enabled, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r20);
        Object r3 = r20;
    L11:
        WorkExperienceMutationResult r4 = (WorkExperienceMutationResult) r3;
        WorkExperienceDetailFragment r5 = this.this$0;
        r5.j = false;
        LarusFragmentWorkExperienceDetailBinding r6 = r5.f;
        if (r6 != null) goto L16;
        return Unit.INSTANCE;
    L16:
        if (r4 != WorkExperienceMutationResult.SUCCESS) goto L18;
        com.larus.agents.impl.experience.n r7 = this.$current;
        com.larus.agents.impl.experience.t r8 = r7.a;
        boolean r15 = this.$enabled;
        String r9 = r8.a;
        String r10 = r8.b;
        String r11 = r8.c;
        String r12 = r8.d;
        WorkExperienceSource r13 = r8.e;
        long r14 = r8.f;
        List<String> r16 = r8.g;
        long r17 = r8.i;
        Intrinsics.checkNotNullParameter(r9, "id");
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r11, "description");
        Intrinsics.checkNotNullParameter(r12, "type");
        Intrinsics.checkNotNullParameter(r13, "source");
        Intrinsics.checkNotNullParameter(r16, "tags");
        com.larus.agents.impl.experience.t r19 = new com.larus.agents.impl.experience.t(r9, r10, r11, r12, r13, r14, r16, r15, r17);
        String r21 = r7.b;
        String r22 = r7.c;
        Intrinsics.checkNotNullParameter(r19, "summary");
        Intrinsics.checkNotNullParameter(r21, "details");
        Intrinsics.checkNotNullParameter(r22, "fullContent");
        r5.h = new com.larus.agents.impl.experience.n(r19, r21, r22);
        this.this$0.getParentFragmentManager().setFragmentResult("work_experience_changed", Bundle.EMPTY);
        t19.s r23 = t19.s.a;
        Context r24 = this.this$0.getContext();
        r23.getClass();
        t19.s.o(r24, 2131907647, false);
    L23:
        r6.b.getToggleView().setEnabled(true);
        return Unit.INSTANCE;
    L18:
        r5.i = true;
        r6.b.getToggleView().setChecked(!this.$enabled);
        WorkExperienceDetailFragment r25 = this.this$0;
        r25.i = false;
        t19.s r26 = t19.s.a;
        Context r27 = r25.getContext();
        if (r4 != WorkExperienceMutationResult.SECURITY_RISK) goto L21;
        int r29 = 2131907646;
    L22:
        r26.getClass();
        t19.s.s(r27, r29);
        goto L23
    L21:
        r29 = 2131902015;
        goto L22
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r20);
        CachedWorkExperienceRepository r30 = this.this$0.g;
        com.larus.agents.impl.experience.n r31 = this.$current;
        com.larus.agents.impl.experience.t r32 = r31.a;
        String r33 = r32.a;
        com.larus.agents.impl.experience.p r34 = new com.larus.agents.impl.experience.p(r32.b, r32.c, r31.b, this.$enabled);
        this.label = 1;
        r3 = r30.update(r33, r34, this);
        if (r3 != r1) goto L11;
        return r1;
    }
}
