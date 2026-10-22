package com.ss.android.lark.keyboard.biz.voice.inject;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.widget.richtext.RichText;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/widget/richtext/RichText;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.biz.voice.inject.VoiceInputPreviewDelegate$startPreview$2$result$1", f = "VoiceInputPreviewDelegate.kt", i = {}, l = {159}, m = "invokeSuspend", n = {}, s = {})
public final class VoiceInputPreviewDelegate$startPreview$2$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RichText>, Object> {
    final /* synthetic */ String $recognitionText;
    int label;
    final /* synthetic */ VoiceInputPreviewDelegate this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.biz.voice.inject.VoiceInputPreviewDelegate$startPreview$2$result$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/widget/richtext/RichText;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.keyboard.biz.voice.inject.VoiceInputPreviewDelegate$startPreview$2$result$1$1", f = "VoiceInputPreviewDelegate.kt", i = {}, l = {160}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RichText>, Object> {
        final /* synthetic */ String $recognitionText;
        int label;
        final /* synthetic */ VoiceInputPreviewDelegate this$0;

        public AnonymousClass1(VoiceInputPreviewDelegate r1, String r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$recognitionText = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$recognitionText, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super RichText> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            final VoiceInputPreviewDelegate r2 = this.this$0;
            final String r3 = this.$recognitionText;
            Function0<RichText> r6 = new C01291(r2, r3);
            this.label = 1;
            r5 = a1.a(r6, this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    public VoiceInputPreviewDelegate$startPreview$2$result$1(VoiceInputPreviewDelegate r1, String r2, Continuation<? super VoiceInputPreviewDelegate$startPreview$2$result$1> r3) {
        this.this$0 = r1;
        this.$recognitionText = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new VoiceInputPreviewDelegate$startPreview$2$result$1(this.this$0, this.$recognitionText, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super RichText> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        return r7;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        CoroutineDispatcher r8 = Dispatchers.getIO();
        AnonymousClass1 r2 = new AnonymousClass1(this.this$0, this.$recognitionText, null);
        this.label = 1;
        r7 = BuildersKt.withContext(r8, r2, this);
        if (r7 != r0) goto L11;
        return r0;
    }
}
