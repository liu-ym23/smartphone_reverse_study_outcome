package com.ss.android.lark.officesdk.minutes.service.recording.common.repo;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.event.SubtitleSource;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.f;
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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo$subscribeLanguageState$4", f = "MmRecordingRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingRepo$subscribeLanguageState$4 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ MmRecordingRepo this$0;

    public MmRecordingRepo$subscribeLanguageState$4(MmRecordingRepo r1, Continuation<? super MmRecordingRepo$subscribeLanguageState$4> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MmRecordingRepo$subscribeLanguageState$4 r0 = new MmRecordingRepo$subscribeLanguageState$4(this.this$0, r4);
        r0.Z$0 = ((Boolean) r3).booleanValue();
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
    }

    public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
        return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r4);
        boolean r5 = this.Z$0;
        String r0 = ((f) this.this$0.l().l().b().getValue()).d.a;
        if (r0.length() != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L10;
        this.this$0.x().l().D(r5);
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.a.C0045a.a(this.this$0.x().l(), this.this$0.v, r0, SubtitleSource.BILINGUAL_SWITCH);
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    L7:
        r1 = false;
        goto L8
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
