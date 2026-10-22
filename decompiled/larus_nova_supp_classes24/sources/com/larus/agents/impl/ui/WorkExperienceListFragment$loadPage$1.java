package com.larus.agents.impl.ui;

import android.content.Context;
import android.widget.TextView;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.agents.impl.databinding.LarusFragmentWorkExperienceListBinding;
import com.larus.agents.impl.network.CachedWorkExperienceRepository;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Result;
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
@DebugMetadata(c = "com.larus.agents.impl.ui.WorkExperienceListFragment$loadPage$1", f = "WorkExperienceListFragment.kt", i = {1}, l = {199, 212}, m = "invokeSuspend", n = {"cachedPageShown"}, s = {"I$0"})
public final class WorkExperienceListFragment$loadPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $reset;
    int I$0;
    int label;
    final /* synthetic */ WorkExperienceListFragment this$0;

    public WorkExperienceListFragment$loadPage$1(boolean r1, WorkExperienceListFragment r2, Continuation<? super WorkExperienceListFragment$loadPage$1> r3) {
        this.$reset = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new WorkExperienceListFragment$loadPage$1(this.$reset, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        int r3 = 8;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        int r2 = this.I$0;
        ResultKt.throwOnFailure(r10);
        Object r11 = ((Result) r10).unbox-impl();
    L32:
        WorkExperienceListFragment r4 = this.this$0;
        LarusFragmentWorkExperienceListBinding r5 = r4.d;
        if (r5 == null) goto L35;
        r4.h = false;
        r5.e.setVisibility(8);
        WorkExperienceListFragment r6 = this.this$0;
        boolean r7 = this.$reset;
        if (Result.isSuccess-impl(r11) == false) goto L39;
        r6.T90(r5, (com.larus.agents.impl.experience.s) r11, r7, true);
    L39:
        boolean r8 = this.$reset;
        WorkExperienceListFragment r9 = this.this$0;
        if (Result.exceptionOrNull-impl(r11) == null) goto L50;
        if (r8 == false) goto L43;
        r9.j = null;
        r9.i = false;
    L43:
        TextView r12 = r5.b;
        r12.setText(r9.getString(2131897428));
        Intrinsics.checkNotNull(r12);
        if (((ArrayList) r9.f).isEmpty() == false) goto L46;
        r3 = 0;
    L46:
        r12.setVisibility(r3);
        if (r2 != 0) goto L50;
        t19.s r13 = t19.s.a;
        Context r14 = r9.getContext();
        r13.getClass();
        t19.s.s(r14, 2131902015);
    L50:
        return Unit.INSTANCE;
    L35:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
    L15:
        com.larus.agents.impl.experience.s r15 = (com.larus.agents.impl.experience.s) r10;
    L17:
        if (r15 == null) goto L19;
        int r16 = 1;
    L20:
        if (r15 == null) goto L24;
        WorkExperienceListFragment r17 = this.this$0;
        LarusFragmentWorkExperienceListBinding r19 = r17.d;
        if (r19 == null) goto L24;
        r17.T90(r19, r15, true, false);
        r19.e.setVisibility(8);
    L24:
        WorkExperienceListFragment r110 = this.this$0;
        CachedWorkExperienceRepository r20 = r110.e;
        if (this.$reset == false) goto L27;
        String r111 = null;
    L28:
        this.I$0 = r16;
        this.label = 2;
        r11 = r20.d(20, r111, this);
        if (r11 != r0) goto L31;
        return r0;
    L31:
        r2 = r16;
        goto L32
    L27:
        r111 = r110.j;
        goto L28
    L19:
        r16 = 0;
        goto L20
    L10:
        ResultKt.throwOnFailure(r10);
        if (this.$reset == false) goto L16;
        CachedWorkExperienceRepository r112 = this.this$0.e;
        this.label = 1;
        r10 = r112.m(this);
        if (r10 != r0) goto L15;
        return r0;
    L16:
        r15 = null;
        goto L17
    }
}
