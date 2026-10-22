package com.ss.android.lark.officesdk.minutes.ui.record.recording.content;

import android.animation.ValueAnimator;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.MmRecordingUITab;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "hasUnviewed", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.content.MmRecordingContentController$subscribeHintState$2", f = "MmRecordingContentController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingContentController$subscribeHintState$2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmRecordingContentController this$0;

    public MmRecordingContentController$subscribeHintState$2(MmRecordingContentController r1, Continuation<? super MmRecordingContentController$subscribeHintState$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MmRecordingContentController$subscribeHintState$2 r0 = new MmRecordingContentController$subscribeHintState$2(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(Boolean r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Boolean) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L40;
        ResultKt.throwOnFailure(r7);
        Boolean r8 = (Boolean) this.L$0;
        int r0 = bwb.b.a;
        MmRecordingContentController r2 = this.this$0;
        int r3 = MmRecordingContentController.p;
        bwb.b.f(MmUiLogScene.CONTENT, "subscribeHintState", "hasUnviewedSummary=" + r8, r2.c());
        if (Intrinsics.areEqual(r8, Boxing.boxBoolean(true)) == false) goto L28;
        List<? extends h> r9 = this.this$0.l;
        if ((r9 instanceof Collection) == true) goto L9;
    L11:
        Iterator<T> r10 = r9.iterator();
    L13:
        if (r10.hasNext() == false) goto L20;
        if (((h) r10.next()).getTabType() != MmRecordingUITab.SUMMARY) goto L17;
        boolean r4 = true;
    L18:
        if (r4 == false) goto L13;
        boolean r11 = true;
    L21:
        if (r11 == false) goto L28;
        final g r12 = this.this$0.f;
        if (r12 == null) goto L38;
        if (r12.b.getVisibility() == 0) goto L38;
        r12.c = true;
        int r1 = bwb.b.a;
        bwb.b.g(MmUiLogScene.CONTENT, "showHint", null, null, 12);
        r12.b.post(new MmRecordingNewSummaryHintHelper$showHint$1(r12));
    L38:
        return Unit.INSTANCE;
    L17:
        r4 = false;
    L20:
        r11 = false;
        goto L21
    L9:
        if (r9.isEmpty() == false) goto L11;
    L28:
        g r13 = this.this$0.f;
        if (r13 == null) goto L38;
        if (r13.c == false) goto L38;
        int r5 = bwb.b.a;
        bwb.b.g(MmUiLogScene.CONTENT, "hideHint", null, null, 12);
        r13.c = false;
        r13.b.setVisibility(8);
        ValueAnimator r6 = r13.d;
        if (r6 == null) goto L36;
        r6.cancel();
    L36:
        r13.d = null;
        goto L38
    L40:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
