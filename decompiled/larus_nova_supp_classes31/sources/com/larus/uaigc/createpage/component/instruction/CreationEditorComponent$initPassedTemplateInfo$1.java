package com.larus.uaigc.createpage.component.instruction;

import android.os.Bundle;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.instruction.CreationEditorComponent$initPassedTemplateInfo$1", f = "CreationEditorComponent.kt", i = {0}, l = {2775}, m = "invokeSuspend", n = {"it"}, s = {"L$1"})
final class CreationEditorComponent$initPassedTemplateInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ CreationEditorComponent this$0;

    public CreationEditorComponent$initPassedTemplateInfo$1(CreationEditorComponent r1, Continuation<? super CreationEditorComponent$initPassedTemplateInfo$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationEditorComponent$initPassedTemplateInfo$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        TemplateInfo$TemplateInfo r2 = (TemplateInfo$TemplateInfo) this.L$1;
        CreationEditorComponent r3 = (CreationEditorComponent) this.L$0;
        ResultKt.throwOnFailure(r9);
    L26:
        int r10 = CreationEditorComponent.g2;
        r3.i4().onInstructionImageTemplateSelected(r2, null);
    L28:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        ny9.s r11 = this.this$0.W3();
        if (r11 == null) goto L28;
        Bundle r12 = r11.a;
        if (r12 == null) goto L13;
        TemplateInfo$TemplateInfo r13 = (TemplateInfo$TemplateInfo) r12.getParcelable("template_info");
    L15:
        if ((r13 instanceof TemplateInfo$TemplateInfo) == true) goto L18;
        r13 = null;
    L18:
        if (r13 == null) goto L28;
        r3 = this.this$0;
        ICoreInputAbility r4 = r3.a4();
        if (r4 == null) goto L22;
        ICoreInputAbility.b.e(r4, "use_template", null, false, 6);
    L22:
        this.L$0 = r3;
        this.L$1 = r13;
        this.label = 1;
        if (DelayKt.delay(100, this) != r0) goto L25;
        return r0;
    L25:
        r2 = r13;
        goto L26
    L13:
        r13 = null;
        goto L15
    }
}
