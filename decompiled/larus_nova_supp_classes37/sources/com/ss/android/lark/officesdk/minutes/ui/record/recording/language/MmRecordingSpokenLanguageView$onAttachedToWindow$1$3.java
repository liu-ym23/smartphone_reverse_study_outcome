package com.ss.android.lark.officesdk.minutes.ui.record.recording.language;

import android.content.Context;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "list", "", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/language/MmSubtitleLanguage;", "current"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.language.MmRecordingSpokenLanguageView$onAttachedToWindow$1$3", f = "MmRecordingSpokenLanguageView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingSpokenLanguageView$onAttachedToWindow$1$3 extends SuspendLambda implements Function3<List<? extends h>, h, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ MmRecordingSpokenLanguageView this$0;

    public MmRecordingSpokenLanguageView$onAttachedToWindow$1$3(MmRecordingSpokenLanguageView r1, Continuation<? super MmRecordingSpokenLanguageView$onAttachedToWindow$1$3> r2) {
        this.this$0 = r1;
        super(3, r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((List) r1, (h) r2, (Continuation) r3);
    }

    public final Object invoke(List<h> r3, h r4, Continuation<? super Unit> r5) {
        MmRecordingSpokenLanguageView$onAttachedToWindow$1$3 r0 = new MmRecordingSpokenLanguageView$onAttachedToWindow$1$3(this.this$0, r5);
        r0.L$0 = r3;
        r0.L$1 = r4;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r8);
        List r2 = (List) this.L$0;
        h r3 = (h) this.L$1;
        Context r1 = this.this$0.getContext();
        final MmRecordingSpokenLanguageView r0 = this.this$0;
        MmRecordingLanguageAdapter r9 = new MmRecordingLanguageAdapter(r1, r2, r3, r0.b, false, new MmRecordingSpokenLanguageView$onAttachedToWindow$1$3$adapter$1(r0));
        this.this$0.d.setAdapter(r9);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
