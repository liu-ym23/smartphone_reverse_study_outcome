package com.ss.android.lark.officesdk.minutes.service.recording.common.repo;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.event.SubtitleSource;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.g;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo$subscribeLanguageRepoEvent$1", f = "MmRecordingRepo.kt", i = {}, l = {582}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingRepo$subscribeLanguageRepoEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MmRecordingRepo this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ MmRecordingRepo a;

        public a(MmRecordingRepo r1) {
            this.a = r1;
        }

        public final Object emit(Object r9, Continuation r10) {
            g r11 = (g) r9;
            if ((r11 instanceof g.b) == false) goto L15;
            MmRecordingRepo r12 = this.a;
            g.b r13 = (g.b) r11;
            int r0 = MmRecordingRepo.F;
            if (r12.z() == false) goto L17;
            String r2 = r13.a.a;
            if (r2.length() != 0) goto L10;
            boolean r14 = true;
        L11:
            if (r14 == true) goto L17;
            lvb.a.e(r12.c, "[fetchPersonalAINoteTranslatedSubtitles] language=" + r2 + ", count=3000");
            r12.x().l().n0(r12.v, r2, null, true, 3000, SubtitleSource.LANGUAGE_CHANGE);
            goto L17
        L10:
            r14 = false;
        L17:
            return Unit.INSTANCE;
        L15:
            if ((r11 instanceof g.a) == true) goto L17;
            throw new NoWhenBranchMatchedException();
        }
    }

    public MmRecordingRepo$subscribeLanguageRepoEvent$1(MmRecordingRepo r1, Continuation<? super MmRecordingRepo$subscribeLanguageRepoEvent$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmRecordingRepo$subscribeLanguageRepoEvent$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        d1<g> r6 = this.this$0.l().e();
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
