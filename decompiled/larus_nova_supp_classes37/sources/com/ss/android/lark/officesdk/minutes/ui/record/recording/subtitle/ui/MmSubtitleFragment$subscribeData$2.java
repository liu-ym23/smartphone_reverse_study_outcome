package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import android.view.View;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "degraded", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui.MmSubtitleFragment$subscribeData$2", f = "MmSubtitleFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmSubtitleFragment$subscribeData$2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ MmSubtitleFragment this$0;

    public MmSubtitleFragment$subscribeData$2(MmSubtitleFragment r1, Continuation<? super MmSubtitleFragment$subscribeData$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MmSubtitleFragment$subscribeData$2 r0 = new MmSubtitleFragment$subscribeData$2(this.this$0, r4);
        r0.Z$0 = ((Boolean) r3).booleanValue();
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
    }

    public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
        return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r5);
        boolean r6 = this.Z$0;
        MmSubtitleFragment r0 = this.this$0;
        int r1 = MmSubtitleFragment.E;
        View r2 = r0.fa0().c;
        if (r2 == null) goto L7;
        MmSubtitleFragment r3 = this.this$0;
        t r4 = r3.u;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h r7 = r4.b;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r7, "quotaCtaState");
        r3.u = new t(r6, r7);
        if (this.this$0.u.a == false) goto L11;
        int r8 = 0;
    L12:
        r2.setVisibility(r8);
        MmSubtitleFragment r9 = this.this$0;
        if (r9.q == null) goto L15;
        boolean r10 = r9.u.a;
    L15:
        r9.ca0();
        return Unit.INSTANCE;
    L11:
        r8 = 8;
        goto L12
    L7:
        return Unit.INSTANCE;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
