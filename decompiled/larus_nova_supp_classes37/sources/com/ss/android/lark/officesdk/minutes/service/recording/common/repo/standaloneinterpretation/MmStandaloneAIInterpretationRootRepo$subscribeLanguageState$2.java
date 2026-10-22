package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.event.SubtitleSource;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "language", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/standaloneinterpretation/MmStandaloneAIInterpretationLanguage;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.MmStandaloneAIInterpretationRootRepo$subscribeLanguageState$2", f = "MmStandaloneAIInterpretationRootRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmStandaloneAIInterpretationRootRepo$subscribeLanguageState$2 extends SuspendLambda implements Function2<c, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmStandaloneAIInterpretationRootRepo this$0;

    public MmStandaloneAIInterpretationRootRepo$subscribeLanguageState$2(MmStandaloneAIInterpretationRootRepo r1, Continuation<? super MmStandaloneAIInterpretationRootRepo$subscribeLanguageState$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MmStandaloneAIInterpretationRootRepo$subscribeLanguageState$2 r0 = new MmStandaloneAIInterpretationRootRepo$subscribeLanguageState$2(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(c r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((c) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r4);
        c r5 = (c) this.L$0;
        if (r5 == null) goto L7;
        String r6 = r5.a;
    L8:
        if (r6 != null) goto L10;
    L13:
        boolean r0 = true;
    L14:
        if (r0 == true) goto L16;
        lvb.a.e(this.this$0.c, "[subscribeLanguageState] standaloneTarget=" + r6);
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.a.C0045a.a(this.this$0.b().l(), this.this$0.d, r6, SubtitleSource.LANGUAGE_CHANGE);
        return Unit.INSTANCE;
    L16:
        return Unit.INSTANCE;
    L10:
        if (StringsKt.isBlank(r6) == true) goto L13;
        r0 = false;
        goto L14
    L7:
        r6 = null;
        goto L8
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
