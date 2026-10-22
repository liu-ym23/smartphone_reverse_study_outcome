package com.ss.android.lark.officesdk.minutes.service.recording.common.repo;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.event.SubtitleSource;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/language/MmSubtitleLanguage;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo$subscribeLanguageState$2", f = "MmRecordingRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingRepo$subscribeLanguageState$2 extends SuspendLambda implements Function2<h, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmRecordingRepo this$0;

    public MmRecordingRepo$subscribeLanguageState$2(MmRecordingRepo r1, Continuation<? super MmRecordingRepo$subscribeLanguageState$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MmRecordingRepo$subscribeLanguageState$2 r0 = new MmRecordingRepo$subscribeLanguageState$2(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(h r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((h) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r9);
        h r10 = (h) this.L$0;
        if (r10.a.length() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
        MmRecordingRepo r1 = this.this$0;
        int r2 = MmRecordingRepo.F;
        if (r1.z() == false) goto L15;
        lvb.a.e(this.this$0.c, "[subscribeLanguageState] skip state-driven translate fetch for personal AINote, language=" + r10.a);
        return Unit.INSTANCE;
    L15:
        lvb.a.e(this.this$0.c, "[subscribeLanguageState] translate language changed, language=" + r10.a + ", isPersonalAINoteEnable=" + this.this$0.z() + ", count=30");
        this.this$0.x().l().n0(this.this$0.v, r10.a, null, true, 30, SubtitleSource.LANGUAGE_CHANGE);
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    L7:
        r0 = false;
        goto L8
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
