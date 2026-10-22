package com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation;

import android.content.Context;
import android.view.View;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.ui.entity.MmPanelHeightConfig;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "event", "Lcom/ss/android/lark/officesdk/minutes/ui/record/standaloneinterpretation/MmStandaloneAIInterpretationVMEvent;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationTopBarView$bind$11", f = "MmStandaloneAIInterpretationTopBarView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmStandaloneAIInterpretationTopBarView$bind$11 extends SuspendLambda implements Function2<f, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.scope.d $scope;
    final /* synthetic */ MmRecordingUILaunchMode $uiLaunchMode;
    final /* synthetic */ MmStandaloneAIInterpretationViewModel $viewModel;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmStandaloneAIInterpretationTopBarView this$0;

    public MmStandaloneAIInterpretationTopBarView$bind$11(com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.scope.d r1, MmStandaloneAIInterpretationTopBarView r2, MmStandaloneAIInterpretationViewModel r3, MmRecordingUILaunchMode r4, Continuation<? super MmStandaloneAIInterpretationTopBarView$bind$11> r5) {
        this.$scope = r1;
        this.this$0 = r2;
        this.$viewModel = r3;
        this.$uiLaunchMode = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        MmStandaloneAIInterpretationTopBarView$bind$11 r6 = new MmStandaloneAIInterpretationTopBarView$bind$11(this.$scope, this.this$0, this.$viewModel, this.$uiLaunchMode, r9);
        r6.L$0 = r8;
        return r6;
    }

    public final Object invoke(f r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((f) r1, (Continuation) r2);
    }

    /* JADX WARN: Type inference failed for: r13v11, types: [android.view.ViewGroup, com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationTopBarView, java.lang.Object] */
    public final Object invokeSuspend(Object r13) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L30;
        ResultKt.throwOnFailure(r13);
        f r14 = (f) this.L$0;
        if (Intrinsics.areEqual(r14, f.a.a) == false) goto L8;
        this.$scope.a.closePage();
    L28:
        return Unit.INSTANCE;
    L8:
        if (Intrinsics.areEqual(r14, f.b.a) == false) goto L19;
        ?? r15 = this.this$0;
        final com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.scope.d r0 = this.$scope;
        final MmStandaloneAIInterpretationViewModel r1 = this.$viewModel;
        MmRecordingUILaunchMode r6 = this.$uiLaunchMode;
        int r2 = MmStandaloneAIInterpretationTopBarView.c;
        r15.getClass();
        com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.scope.b r10 = r0.f;
        Function1<Context, View> r4 = new MmStandaloneAIInterpretationTopBarView$showLanguagePanel$1(r1, r0);
        MmRecordingUILaunchMode r3 = MmRecordingUILaunchMode.WITH_DOUBAO_UI;
        if (r6 != r3) goto L12;
        int r16 = (int) (UIUtils.getScreenHeight(r15.getContext()) * 0.78f);
    L13:
        MmPanelHeightConfig.Fixed r5 = new MmPanelHeightConfig.Fixed(r16, true);
        rub.c.b r7 = rub.c.b.a;
        if (r6 != r3) goto L16;
        boolean r8 = true;
    L17:
        r10.v(new rub.d("MmStandaloneAIInterpretationLanguagePanel", r4, r5, r6, r7, r8, 3194));
        goto L28
    L16:
        r8 = false;
        goto L17
    L12:
        r16 = r15.R5(416.0f);
        goto L13
    L19:
        if ((r14 instanceof f.d) == false) goto L28;
        MmStandaloneAIInterpretationTopBarView r9 = this.this$0;
        boolean r17 = ((f.d) r14).a;
        int r11 = MmStandaloneAIInterpretationTopBarView.c;
        r9.getClass();
        if (r17 == false) goto L23;
        String r18 = UIHelper.getString(2131893505);
    L24:
        if (r18 == null) goto L28;
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.e(r18);
        goto L28
    L23:
        r18 = UIHelper.getString(2131893504);
        goto L24
    L30:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
