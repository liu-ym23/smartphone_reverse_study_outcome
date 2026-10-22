package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "event", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/ainote/MmAINoteVMEvent;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.MmAINoteFragment$subscribeEvents$1", f = "MmAINoteFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmAINoteFragment$subscribeEvents$1 extends SuspendLambda implements Function2<r, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmAINoteFragment this$0;

    public MmAINoteFragment$subscribeEvents$1(MmAINoteFragment r1, Continuation<? super MmAINoteFragment$subscribeEvents$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MmAINoteFragment$subscribeEvents$1 r0 = new MmAINoteFragment$subscribeEvents$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(r r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((r) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L95;
        ResultKt.throwOnFailure(r9);
        r r10 = (r) this.L$0;
        boolean r2 = false;
        if ((r10 instanceof r.h) == false) goto L15;
        final MmAINotePanelAnimator r0 = this.this$0.q;
        if (r0 == null) goto L91;
        final boolean r11 = ((r.h) r10).a;
        int r3 = bwb.b.a;
        bwb.b.g(MmUiLogScene.AI_NOTE, "[show] expandImmediately=" + r11, null, null, 12);
        r0.K = false;
        r0.H = false;
        r0.I = false;
        r0.J = null;
        r0.e.invoke(Boolean.TRUE);
        FrameLayout r1 = r0.f;
        Function0<Unit> r4 = new MmAINotePanelAnimator$show$1(r0, r11);
        if (r1.getWidth() > 0) goto L11;
    L13:
        r1.addOnLayoutChangeListener(new n(r1, r4));
        goto L91
    L11:
        if (r1.getHeight() <= 0) goto L13;
        r4.invoke();
    L91:
        return Unit.INSTANCE;
    L15:
        if ((r10 instanceof r.c) == false) goto L20;
        MmAINotePanelAnimator r12 = this.this$0.q;
        if (r12 == null) goto L91;
        r12.v();
        goto L91
    L20:
        if ((r10 instanceof r.f) == false) goto L37;
        MmAINotePanelAnimator r5 = this.this$0.q;
        if (r5 == null) goto L35;
        MmAINoteHint r13 = ((r.f) r10).a;
        if (r13 != null) goto L26;
        int r14 = -1;
    L27:
        if (r14 == (-1)) goto L35;
        if (r14 != 1) goto L30;
        r5.E(r5.a.s);
        goto L35
    L30:
        if (r14 != 2) goto L33;
        r5.E(r5.a.t);
        goto L35
    L33:
        throw new NoWhenBranchMatchedException();
    L26:
        r14 = MmAINotePanelAnimator.e.a[r13.ordinal()];
    L35:
        this.this$0.fa0().dispatchEvent(MmAINoteUIEvent.c.a);
        goto L91
    L37:
        if (Intrinsics.areEqual(r10, r.g.a) == false) goto L53;
        final MmAINoteFragment r15 = this.this$0;
        mwb.b r6 = r15.p;
        if (r6 == null) goto L91;
        qub.a r7 = r15.t;
        if (r7 != null) goto L44;
    L46:
        if (r2 == true) goto L91;
        final View r8 = r6.a.findViewById(2131362358);
        if (r8 != null) goto L51;
        r8 = r6.E;
    L51:
        r8.post(new MmAINoteFragment$showSaveSwitchTooltip$1(r15, r8));
        goto L91
    L44:
        if (r7.isShowing() != true) goto L46;
        r2 = true;
        goto L46
    L53:
        if (Intrinsics.areEqual(r10, r.b.a) == false) goto L59;
        MmAINoteFragment r16 = this.this$0;
        int r17 = MmAINoteFragment.y;
        qub.a r18 = r16.t;
        if (r18 == null) goto L57;
        r18.hide();
    L57:
        r16.t = null;
        goto L91
    L59:
        if ((r10 instanceof r.d) == false) goto L67;
        Function1<? super com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.l, Boolean> r19 = this.this$0.m;
        if (r19 != null) goto L63;
    L65:
        this.this$0.fa0().dispatchEvent(new MmAINoteUIEvent.k(r2));
        goto L91
    L63:
        if (((Boolean) r19.invoke(((r.d) r10).a)).booleanValue() != true) goto L65;
        r2 = true;
        goto L65
    L67:
        if (Intrinsics.areEqual(r10, r.e.a) == false) goto L86;
        Activity r20 = this.this$0.getActivity();
        if ((r20 instanceof FragmentActivity) == true) goto L72;
        r20 = null;
    L72:
        if (r20 == null) goto L74;
        Intent r21 = r20.getIntent();
        if (r21 == null) goto L78;
        r21.putExtra("minutes_skip_vc_fast_entry_on_next_stop", true);
    L78:
        int r22 = bwb.b.a;
        MmUiLogScene r23 = MmUiLogScene.AI_NOTE;
        StringBuilder r24 = new StringBuilder("fragment=");
        MmAINoteFragment r25 = this.this$0;
        int r26 = MmAINoteFragment.y;
        r25.getClass();
        r24.append(MmAINoteFragment.ca0(r25));
        r24.append(" activity=");
        this.this$0.getClass();
        r24.append(MmAINoteFragment.ca0(r20));
        r24.append(" skipFloatExtra=true");
        bwb.b.g(r23, "MmAINoteFragment#openCamera", r24.toString(), null, 8);
        e r27 = this.this$0.s;
        if (r27 != null) goto L81;
    L83:
        if (r2 == true) goto L91;
        StringBuilder r28 = new StringBuilder("fragment=");
        MmAINoteFragment r29 = this.this$0;
        r29.getClass();
        r28.append(MmAINoteFragment.ca0(r29));
        r28.append(" openCamera returned false");
        bwb.b.h(r23, "MmAINoteFragment#openCamera", r28.toString(), null);
        this.this$0.fa0().handleCameraOpenFailed();
        goto L91
    L81:
        if (r27.h(r20) != true) goto L83;
        r2 = true;
        goto L83
    L74:
        return Unit.INSTANCE;
    L86:
        if (Intrinsics.areEqual(r10, r.a.a) == false) goto L93;
        MmAINotePanelAnimator r30 = this.this$0.q;
        if (r30 == null) goto L91;
        r30.f.post(new p(r30));
        goto L91
    L93:
        throw new NoWhenBranchMatchedException();
    L95:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
