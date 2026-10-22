package com.larus.agents.impl.ui;

import android.content.Context;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.agents.impl.databinding.LarusFragmentWorkExperienceListBinding;
import com.larus.agents.impl.network.CachedWorkExperienceRepository;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.agents.impl.ui.WorkExperienceListFragment$loadEnabled$1", f = "WorkExperienceListFragment.kt", i = {1}, l = {129, 133}, m = "invokeSuspend", n = {"cachedEnabled"}, s = {"L$0"})
final class WorkExperienceListFragment$loadEnabled$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ WorkExperienceListFragment this$0;

    public WorkExperienceListFragment$loadEnabled$1(WorkExperienceListFragment r1, Continuation<? super WorkExperienceListFragment$loadEnabled$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new WorkExperienceListFragment$loadEnabled$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        Boolean r2 = (Boolean) this.L$0;
        ResultKt.throwOnFailure(r9);
        Object r10 = ((Result) r9).unbox-impl();
    L22:
        if (Result.isFailure-impl(r10) == false) goto L24;
        r10 = null;
    L24:
        Boolean r11 = (Boolean) r10;
        WorkExperienceListFragment r3 = this.this$0;
        LarusFragmentWorkExperienceListBinding r4 = r3.d;
        if (r4 == null) goto L27;
        if (r11 != null) goto L34;
        if (r2 != null) goto L31;
        t19.s r12 = t19.s.a;
        Context r5 = r3.getContext();
        r12.getClass();
        t19.s.s(r5, 2131902015);
        r4.c.getToggleView().setEnabled(false);
    L33:
        return Unit.INSTANCE;
    L31:
        r4.c.getToggleView().setEnabled(true);
        goto L33
    L34:
        boolean r13 = r11.booleanValue();
        r3.k = true;
        r4.c.getToggleView().setChecked(r13);
        r3.k = false;
        r4.c.getToggleView().setEnabled(true);
        return Unit.INSTANCE;
    L27:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r9);
    L13:
        Boolean r14 = (Boolean) r9;
        WorkExperienceListFragment r6 = this.this$0;
        LarusFragmentWorkExperienceListBinding r7 = r6.d;
        if (r7 == null) goto L17;
        if (r14 == null) goto L17;
        boolean r8 = r14.booleanValue();
        r6.k = true;
        r7.c.getToggleView().setChecked(r8);
        r6.k = false;
        r7.c.getToggleView().setEnabled(false);
    L17:
        CachedWorkExperienceRepository r15 = this.this$0.e;
        this.L$0 = r14;
        this.label = 2;
        Object r16 = r15.e(this);
        if (r16 != r0) goto L20;
        return r0;
    L20:
        r2 = r14;
        r10 = r16;
        goto L22
    L10:
        ResultKt.throwOnFailure(r9);
        CachedWorkExperienceRepository r17 = this.this$0.e;
        this.label = 1;
        r9 = r17.l(this);
        if (r9 != r0) goto L13;
        return r0;
    }
}
