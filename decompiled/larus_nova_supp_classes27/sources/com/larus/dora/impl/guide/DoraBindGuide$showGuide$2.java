package com.larus.dora.impl.guide;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.larus.dora.impl.DoraBuryPointManager;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.DoraBindGuide$showGuide$2", f = "DoraBindGuide.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraBindGuide$showGuide$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Fragment $fragment;
    int label;
    final /* synthetic */ DoraBindGuide this$0;

    public DoraBindGuide$showGuide$2(Fragment r1, DoraBindGuide r2, Continuation<? super DoraBindGuide$showGuide$2> r3) {
        this.$fragment = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraBindGuide$showGuide$2(this.$fragment, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r5);
        FragmentManager r6 = this.$fragment.getParentFragmentManager();
        if (r6.isStateSaved() == false) goto L8;
        g49.d.c("DoraBindGuide", "showGuide() aborted: fragmentManager.isStateSaved", new IllegalStateException("Invalid fragmentManager state"));
        DoraBindGuide r7 = this.this$0;
        int r0 = DoraBindGuide.p;
        r7.i(404);
        return Unit.INSTANCE;
    L8:
        DoraBindGuide.BindBottomSheetDialogFragment r2 = r6.findFragmentByTag("BindBottomSheetDialogFragment");
        if ((r2 instanceof DoraBindGuide.BindBottomSheetDialogFragment) == false) goto L11;
        DoraBindGuide.BindBottomSheetDialogFragment r3 = r2;
    L12:
        if (r3 != null) goto L14;
    L16:
        g49.d.d("DoraBindGuide", "Creating and showing new BindBottomSheetDialogFragment");
        DoraBindGuide r1 = this.this$0;
        DoraBindGuide.BindBottomSheetDialogFragment r4 = new DoraBindGuide.BindBottomSheetDialogFragment();
        r4.d = this.this$0;
        INVOKEVIRTUAL_com_larus_dora_impl_guide_DoraBindGuide$showGuide$2_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r4, r6, "BindBottomSheetDialogFragment");
        r1.k = r4;
    L17:
        DoraBuryPointManager r8 = DoraBuryPointManager.a;
        DoraBindGuide r9 = this.this$0;
        int r10 = DoraBindGuide.p;
        boolean r11 = ((com.larus.dora.impl.guide.strategy.b) r9.i.getValue()).c;
        r8.getClass();
        g49.d.d(DoraBuryPointManager.b, "reportBindGuideExposure");
        r8.L("dora_bind_guide_exposure", MapsKt.mapOf(TuplesKt.to("hit_target_user_strategy", Boolean.valueOf(r11))));
        this.this$0.m(2);
        return Unit.INSTANCE;
    L14:
        if (r3.isAdded() == false) goto L16;
        g49.d.d("DoraBindGuide", "Reusing existing BindBottomSheetDialogFragment in FragmentManager");
        DoraBindGuide r12 = this.this$0;
        r3.d = r12;
        r12.k = r3;
        goto L17
    L11:
        r3 = null;
        goto L12
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public static void INVOKEVIRTUAL_com_larus_dora_impl_guide_DoraBindGuide$showGuide$2_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(DoraBindGuide.BindBottomSheetDialogFragment r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        DoraBindGuide.BindBottomSheetDialogFragment r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.show(r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }
}
