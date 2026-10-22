package com.ss.android.lark.keyboard.biz.voice.inject;

import android.text.Editable;
import android.widget.EditText;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.edittext2.compat.ExtensionEditTextCompatKt;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.i;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.biz.voice.inject.VoiceInputPreviewDelegate$startPreview$2", f = "VoiceInputPreviewDelegate.kt", i = {0}, l = {158}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class VoiceInputPreviewDelegate$startPreview$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ EditText $editText;
    final /* synthetic */ String $recognitionText;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ VoiceInputPreviewDelegate this$0;

    public VoiceInputPreviewDelegate$startPreview$2(VoiceInputPreviewDelegate r1, EditText r2, String r3, Continuation<? super VoiceInputPreviewDelegate$startPreview$2> r4) {
        this.this$0 = r1;
        this.$editText = r2;
        this.$recognitionText = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        VoiceInputPreviewDelegate$startPreview$2 r0 = new VoiceInputPreviewDelegate$startPreview$2(this.this$0, this.$editText, this.$recognitionText, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r7);
    L12:
        RichText r8 = (RichText) r7;
        if (CoroutineScopeKt.isActive(r2) == false) goto L56;
        if (((Boolean) this.this$0.d.invoke()).booleanValue() == true) goto L56;
        VoiceInputPreviewDelegate r3 = this.this$0;
        r3.h = null;
        EditText r4 = this.$editText;
        r3.m = true;
        int r5 = 0;
        fya.a.d r6 = r3.b();     // Catch: Throwable -> L52
        if (r6 == null) goto L21;
        r6.b(r4);     // Catch: Throwable -> L52
    L21:
        r3.m = false;
        VoiceInputPreviewDelegate r9 = this.this$0;
        r9.l = r9.c();
        if (r8 != null) goto L24;
    L47:
        EditText r10 = this.$editText;
        Editable r11 = r10.getText();
        if (r11 == null) goto L50;
        r5 = r11.length();
    L50:
        r10.setSelection(r5);
        return Unit.INSTANCE;
    L24:
        if (i.l(r8) == true) goto L47;
        VoiceInputPreviewDelegate r12 = this.this$0;
        String r13 = r12.l;
        EditText r14 = this.$editText;
        r12.m = true;
        ExtensionEditTextCompatKt.p(r14, r8);     // Catch: Throwable -> L44
        r12.m = false;
        String r15 = this.this$0.c();
        if (r15.length() != 0) goto L30;
        boolean r16 = true;
    L31:
        if (r16 == true) goto L33;
    L43:
        this.this$0.l = r15;
        goto L47
    L33:
        if (r13.length() <= 0) goto L35;
        boolean r17 = true;
    L36:
        if (r17 == false) goto L43;
        VoiceInputPreviewDelegate r18 = this.this$0;
        EditText r19 = this.$editText;
        r18.m = true;
        ExtensionEditTextCompatKt.p(r19, com.ss.android.lark.widget.richtext.c.c(r13));     // Catch: Throwable -> L40
        r18.m = false;
        VoiceInputPreviewDelegate r20 = this.this$0;
        r20.l = r20.c();
    L40:
        th = move-exception;
        r18.m = false;
        throw th;
    L35:
        r17 = false;
        goto L36
    L30:
        r16 = false;
    L44:
        th = move-exception;
        r12.m = false;
        throw th;
    L52:
        th = move-exception;
        r3.m = false;
        throw th;
    L56:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        CoroutineScope r21 = (CoroutineScope) this.L$0;
        VoiceInputPreviewDelegate$startPreview$2$result$1 r22 = new VoiceInputPreviewDelegate$startPreview$2$result$1(this.this$0, this.$recognitionText, null);
        this.L$0 = r21;
        this.label = 1;
        Object r23 = TimeoutKt.c(300000, r22, this);
        if (r23 != r0) goto L11;
        return r0;
    L11:
        r2 = r21;
        r7 = r23;
        goto L12
    }
}
