package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language;

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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.MmRecordingAutoTranslationCoordinator$onTranslationSuggested$1", f = "MmRecordingAutoTranslationCoordinator.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingAutoTranslationCoordinator$onTranslationSuggested$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $targetLanguage;
    int label;
    final /* synthetic */ MmRecordingAutoTranslationCoordinator this$0;

    public MmRecordingAutoTranslationCoordinator$onTranslationSuggested$1(MmRecordingAutoTranslationCoordinator r1, String r2, Continuation<? super MmRecordingAutoTranslationCoordinator$onTranslationSuggested$1> r3) {
        this.this$0 = r1;
        this.$targetLanguage = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmRecordingAutoTranslationCoordinator$onTranslationSuggested$1(this.this$0, this.$targetLanguage, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r17);
    L35:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r17);
        MmRecordingAutoTranslationCoordinator r3 = this.this$0;
        int r4 = MmRecordingAutoTranslationCoordinator.k;
        if (r3.e() == false) goto L28;
        e r5 = (e) this.this$0.g.getValue();
        if (r5 != null) goto L17;
        long r13 = this.this$0.b.i0();
        if (r13 <= 0) goto L16;
        MmRecordingAutoTranslationCoordinator r6 = this.this$0;
        MmAutoTranslationStatus r8 = MmAutoTranslationStatus.SKIPPED;
        String r9 = this.$targetLanguage;
        MmAutoTranslationStage r10 = MmAutoTranslationStage.TRANSLATION;
        long r11 = r6.j + 1;
        r6.j = r11;
        r6.m(new e(r8, r9, r10, r11, r13, "manual_setting_before_push"));
        goto L28
    L16:
        MmRecordingAutoTranslationCoordinator r7 = this.this$0;
        MmAutoTranslationStatus r12 = MmAutoTranslationStatus.WAITING;
        String r14 = this.$targetLanguage;
        MmAutoTranslationStage r15 = MmAutoTranslationStage.TRANSLATION;
        long r16 = r7.j + 1;
        r7.j = r16;
        r7.m(new e(r12, r14, r15, r16, r13, ""));
    L27:
        boolean r18 = true;
    L29:
        if (r18 == false) goto L33;
        this.this$0.b.l0();
        MmRecordingAutoTranslationCoordinator r19 = this.this$0;
        this.label = 1;
        if (r19.k("push", this) != r1) goto L35;
        return r1;
    L33:
        lvb.a.e("MmAutoTranslation", "[onTranslationSuggested] absorb duplicate, target=" + this.$targetLanguage);
        goto L35
    L17:
        MmAutoTranslationStatus r20 = r5.a;
        MmAutoTranslationStatus r21 = MmAutoTranslationStatus.WAITING;
        if (r20 == r21) goto L20;
    L24:
        if (r20 != r21) goto L28;
        if (r5.c != MmAutoTranslationStage.BILINGUAL) goto L28;
    L20:
        if (r5.c != MmAutoTranslationStage.TRANSLATION) goto L24;
        if (Intrinsics.areEqual(r5.b, this.$targetLanguage) == true) goto L27;
        MmRecordingAutoTranslationCoordinator r22 = this.this$0;
        String r23 = this.$targetLanguage;
        long r110 = r22.j + 1;
        r22.j = r110;
        r22.m(e.a(r5, null, r23, null, r110, r22.b.i0(), "", 5));
    L28:
        r18 = false;
        goto L29
    }
}
