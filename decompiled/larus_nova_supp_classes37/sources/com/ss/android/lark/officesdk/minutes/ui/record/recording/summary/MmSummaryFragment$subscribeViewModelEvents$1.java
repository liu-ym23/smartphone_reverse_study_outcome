package com.ss.android.lark.officesdk.minutes.ui.record.recording.summary;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import qub.f;
import qub.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "event", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/summary/MmSummaryVMEvent;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.MmSummaryFragment$subscribeViewModelEvents$1", f = "MmSummaryFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmSummaryFragment$subscribeViewModelEvents$1 extends SuspendLambda implements Function2<d, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmSummaryFragment this$0;

    public MmSummaryFragment$subscribeViewModelEvents$1(MmSummaryFragment r1, Continuation<? super MmSummaryFragment$subscribeViewModelEvents$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MmSummaryFragment$subscribeViewModelEvents$1 r0 = new MmSummaryFragment$subscribeViewModelEvents$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(d r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((d) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r14) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L47;
        ResultKt.throwOnFailure(r14);
        d r15 = (d) this.L$0;
        if ((r15 instanceof d.a) == false) goto L32;
        MmSummaryFragment r0 = this.this$0;
        d.a r16 = (d.a) r15;
        View r1 = r16.a;
        String r2 = r16.d;
        int r3 = MmSummaryFragment.F;
        r0.getClass();
        FrameLayout r7 = r0.ga0().k;     // Catch: RuntimeException -> L16
        ViewParent r8 = r1.getParent();     // Catch: RuntimeException -> L16
        if (r8 != r7) goto L10;
        r1.setId(2131387719);     // Catch: RuntimeException -> L16
    L14:
        r0.z = r1;     // Catch: RuntimeException -> L16
        r0.ta0("addWebViewSafely_" + r2, false);     // Catch: RuntimeException -> L16
        Result.Companion r4 = Result.Companion;     // Catch: RuntimeException -> L16
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: RuntimeException -> L16
    L22:
        MmSummaryFragment r6 = this.this$0;
        Throwable r9 = Result.exceptionOrNull-impl(r5);
        if (r9 != null) goto L30;
        Unit r10 = (Unit) r5;
        if (r16.b == false) goto L43;
        Job r17 = r6.w;
        if (r17 == null) goto L29;
        Job.DefaultImpls.cancel$default(r17, null, 1, null);
    L29:
        r6.ma0("replace");
        FrameLayout r18 = r6.ga0().j;
        View r11 = new View(r18.getContext());
        Context r12 = r11.getContext();
        int r13 = com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper.b.a;
        r11.setBackgroundColor(UIUtils.getColor(r12, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper.b.a(r6.ha0().getMainViewModel().getUiLaunchMode())));
        r11.setImportantForAccessibility(2);
        r18.addView(r11, new FrameLayout.LayoutParams(-1, -1));
        r6.x = r11;
        int r19 = bwb.b.a;
        bwb.b.f(MmUiLogScene.SUMMARY, "showThemeTransitionOverlay", "from=BindFishBoneWebView", r6.U90());
        r6.w = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r6.getViewLifecycleOwner()), null, null, new MmSummaryFragment$showThemeTransitionOverlay$1(r6, null), 3, null);
    L43:
        return Unit.INSTANCE;
    L30:
        r6.z = null;
        r6.ha0().dispatchEvent(new b.f(r6.getContext(), r16.c, r16.d, r9));
        goto L43
    L10:
        if ((r8 instanceof ViewGroup) == false) goto L12;
        int r110 = bwb.b.a;     // Catch: RuntimeException -> L16
        bwb.b.f(MmUiLogScene.SUMMARY, "addWebViewSafely", "remove from existing parent=" + r8.getClass().getSimpleName() + ", from=" + r2, r0.U90());     // Catch: RuntimeException -> L16
        ((ViewGroup) r8).removeView(r1);     // Catch: RuntimeException -> L16
    L12:
        r1.setId(2131387719);     // Catch: RuntimeException -> L16
        r7.addView(r1);     // Catch: RuntimeException -> L16
    L16:
        e = move-exception;
        int r20 = bwb.b.a;
        MmUiLogScene r21 = MmUiLogScene.SUMMARY;
        StringBuilder r22 = new StringBuilder("attach failed, from=");
        r22.append(r2);
        r22.append(", parent=");
        ViewParent r23 = r1.getParent();
        if (r23 == null) goto L20;
        String r24 = r23.getClass().getSimpleName();
    L21:
        r22.append(r24);
        r22.append(", error=");
        r22.append(e.getClass().getSimpleName());
        r22.append(": ");
        r22.append(e.getMessage());
        bwb.b.d(r21, "addWebViewSafely", r22.toString(), r0.U90());
        Result.Companion r25 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(e));
        goto L22
    L20:
        r24 = null;
        goto L21
    L32:
        if ((r15 instanceof d.b) == false) goto L38;
        d.b r111 = (d.b) r15;
        Function1<Boolean, Unit> r26 = this.this$0.B.remove(Boxing.boxLong(r111.a));
        if (r26 != null) goto L36;
        int r27 = bwb.b.a;
        bwb.b.h(MmUiLogScene.SUMMARY, "FishBoneWebScrollResult", "ignore stale result, requestId=" + r111.a, this.this$0.U90());
        goto L43
    L36:
        int r28 = bwb.b.a;
        bwb.b.f(MmUiLogScene.SUMMARY, "FishBoneWebScrollResult", "requestId=" + r111.a + ", canScroll=" + r111.b, this.this$0.U90());
        r26.invoke(Boxing.boxBoolean(r111.b));
        goto L43
    L38:
        if ((r15 instanceof d.c) == false) goto L45;
        f r29 = this.this$0.ha0().getMainViewModel().hostBridge();
        if (r29 == null) goto L43;
        new i.a(this.this$0.requireContext(), ((d.c) r15).a);
        Boxing.boxBoolean(r29.C0());
        goto L43
    L45:
        throw new NoWhenBranchMatchedException();
    L47:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
