package com.ss.android.lark.officesdk.minutes.ui.record.recording.summary;

import android.text.SpannableString;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.LifecycleOwnerKt;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.MmSummaryViewType;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "aiSummary", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/summary/MmRecordingAISummary;", "viewType", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/summary/MmSummaryViewType;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.MmSummaryFragment$subscribeRichContent$3", f = "MmSummaryFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmSummaryFragment$subscribeRichContent$3 extends SuspendLambda implements Function3<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.b, MmSummaryViewType, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ MmSummaryFragment this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.MmSummaryFragment$subscribeRichContent$3$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.MmSummaryFragment$subscribeRichContent$3$1", f = "MmSummaryFragment.kt", i = {}, l = {466}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isNewContent;
        final /* synthetic */ String $richContent;
        final /* synthetic */ MmSummaryViewType $viewType;
        int label;
        final /* synthetic */ MmSummaryFragment this$0;

        public AnonymousClass1(MmSummaryFragment r1, boolean r2, MmSummaryViewType r3, String r4, Continuation<? super AnonymousClass1> r5) {
            this.this$0 = r1;
            this.$isNewContent = r2;
            this.$viewType = r3;
            this.$richContent = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.this$0, this.$isNewContent, this.$viewType, this.$richContent, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L11:
            MmSummaryFragment r2 = this.this$0;
            int r3 = MmSummaryFragment.F;
            AppCompatTextView r4 = r2.ga0().d;
            r4.setText((SpannableString) r6);
            this.this$0.ga0().d.setVisibility(0);
            awb.c r7 = this.this$0.n;
            if (r7 == null) goto L15;
            r7.a(true);
        L15:
            if (this.$isNewContent == false) goto L24;
            if (this.$viewType.isMarkdown() == false) goto L22;
            MmSummaryFragment r8 = this.this$0;
            if (r8.o == false) goto L21;
            r8.pa0("new_markdown_received");
            goto L24
        L21:
            r8.la0(true, "new_markdown_received");
            goto L24
        L22:
            MmSummaryFragment r9 = this.this$0;
            r9.q = true;
            int r5 = bwb.b.a;
            bwb.b.f(MmUiLogScene.SUMMARY, "subscribeRichContent", "FishBone mode, pending new content", r9.U90());
        L24:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            CoroutineDispatcher r10 = Dispatchers.getDefault();
            MmSummaryFragment$subscribeRichContent$3$1$parsedMarkdown$1 r11 = new MmSummaryFragment$subscribeRichContent$3$1$parsedMarkdown$1(this.$richContent, null);
            this.label = 1;
            r6 = BuildersKt.withContext(r10, r11, this);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    public MmSummaryFragment$subscribeRichContent$3(MmSummaryFragment r1, Continuation<? super MmSummaryFragment$subscribeRichContent$3> r2) {
        this.this$0 = r1;
        super(3, r2);
    }

    public final Object invoke(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.b r3, MmSummaryViewType r4, Continuation<? super Unit> r5) {
        MmSummaryFragment$subscribeRichContent$3 r0 = new MmSummaryFragment$subscribeRichContent$3(this.this$0, r5);
        r0.L$0 = r3;
        r0.L$1 = r4;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.b) r1, (MmSummaryViewType) r2, (Continuation) r3);
    }

    public final Object invokeSuspend(Object r19) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L38;
        ResultKt.throwOnFailure(r19);
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.b r1 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.b) this.L$0;
        MmSummaryViewType r6 = (MmSummaryViewType) this.L$1;
        e r2 = this.this$0.ha0().getState();
        if (r2.b == false) goto L11;
        if (r2.a == true) goto L11;
        int r3 = bwb.b.a;
        bwb.b.f(MmUiLogScene.SUMMARY, "subscribeRichContent", "FishBone only mode, skip markdown refresh", this.this$0.U90());
        return Unit.INSTANCE;
    L11:
        if (r1 == null) goto L13;
        String r7 = r1.a;
    L15:
        if (r7 != null) goto L17;
    L22:
        boolean r8 = false;
    L23:
        if (r8 == false) goto L36;
        long r9 = r1.b;
        MmSummaryFragment r10 = this.this$0;
        if (r9 <= r10.p) goto L27;
        boolean r11 = true;
    L28:
        r10.p = r9;
        int r12 = bwb.b.a;
        bwb.b.f(MmUiLogScene.SUMMARY, "subscribeRichContent", "markdown text updated, timestamp=" + r1.b + ", isNewContent=" + r11 + ", viewType=" + r6, this.this$0.U90());
        awb.c r4 = this.this$0.n;
        if (r4 == null) goto L31;
        r4.a(false);
    L31:
        Job r5 = this.this$0.v;
        if (r5 == null) goto L34;
        Job.DefaultImpls.cancel$default(r5, null, 1, null);
    L34:
        MmSummaryFragment r13 = this.this$0;
        r13.v = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r13.getViewLifecycleOwner()), null, null, new AnonymousClass1(this.this$0, r11, r6, r7, null), 3, null);
        goto L36
    L27:
        r11 = false;
    L36:
        return Unit.INSTANCE;
    L17:
        if (r7.length() <= 0) goto L19;
        boolean r14 = true;
    L20:
        if (r14 != true) goto L22;
        r8 = true;
        goto L23
    L19:
        r14 = false;
        goto L20
    L13:
        r7 = null;
        goto L15
    L38:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
