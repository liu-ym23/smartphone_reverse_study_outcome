package com.larus.uaigc.createpage.component.instruction;

import android.net.Uri;
import com.bytedance.router.SmartRouter;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.instruction.CreationEditorComponent$handleMsgInstructionRedirectSchema$4", f = "CreationEditorComponent.kt", i = {0}, l = {4160}, m = "invokeSuspend", n = {"curMediaAttachment"}, s = {"L$0"})
public final class CreationEditorComponent$handleMsgInstructionRedirectSchema$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $schema;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ CreationEditorComponent this$0;

    public CreationEditorComponent$handleMsgInstructionRedirectSchema$4(CreationEditorComponent r1, String r2, Continuation<? super CreationEditorComponent$handleMsgInstructionRedirectSchema$4> r3) {
        this.this$0 = r1;
        this.$schema = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CreationEditorComponent$handleMsgInstructionRedirectSchema$4(this.this$0, this.$schema, r4);
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
        MediaAttachment r2 = (MediaAttachment) this.L$1;
        MediaAttachment r3 = (MediaAttachment) this.L$0;
        ResultKt.throwOnFailure(r7);
    L30:
        String r8 = (String) r7;
        if (r8 == null) goto L33;
        MediaAttachment r5 = r2;
        String r4 = com.larus.utils.y0.k(Uri.fromFile(new PolarisFileWrapper(r8)));
        MediaAttachment r9 = r3;
        MediaAttachment r6 = r5;
    L36:
        r6.setLocalFilePath(r4);
    L37:
        CreationEditorComponent r10 = this.this$0;
        String r11 = this.$schema;
        int r12 = CreationEditorComponent.g2;
        if (r10.m6(r11, r9, null) == true) goto L40;
        final com.bytedance.router.i r13 = SmartRouter.buildRoute(this.this$0.getContext(), this.$schema);
        r13.c.putExtra("media_attachment", r9);
        r13.c.putExtra("enable_compact_fragment_forseti", this.this$0.T5());
        r13.d = 2130772343;
        r13.e = 2130772399;
        this.this$0.o5(new t1(r13), Boxing.boxInt(2130772343), Boxing.boxInt(2130772399), new u1(r13));
        return Unit.INSTANCE;
    L40:
        return Unit.INSTANCE;
    L33:
        r9 = r2;
    L35:
        r4 = null;
        MediaAttachment r14 = r3;
        r6 = r9;
        r9 = r14;
        goto L36
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        CreationEditorComponent r15 = this.this$0;
        int r16 = CreationEditorComponent.g2;
        sy9.a r17 = (sy9.a) r15.R.getValue();
        if (r17 == null) goto L15;
        kotlinx.coroutines.flow.i1<ry9.j> r18 = r17.D20();
        if (r18 == null) goto L15;
        ry9.j r19 = (ry9.j) r18.getValue();
        if (r19 == null) goto L15;
        ry9.i r20 = r19.a();
    L17:
        if ((r20 instanceof ry9.i.a) == false) goto L19;
        ry9.i.a r21 = (ry9.i.a) r20;
    L20:
        if (r21 == null) goto L22;
        r9 = r21.a;
    L23:
        if (r9 == null) goto L37;
        sy9.a r22 = (sy9.a) this.this$0.R.getValue();
        if (r22 == null) goto L34;
        this.L$0 = r9;
        this.L$1 = r9;
        this.label = 1;
        Object r23 = r22.Ov(this);
        if (r23 != r0) goto L29;
        return r0;
    L29:
        r2 = r9;
        r7 = r23;
        r3 = r2;
        goto L30
    L34:
        r3 = r9;
        goto L35
    L22:
        r9 = null;
        goto L23
    L19:
        r21 = null;
    L15:
        r20 = null;
        goto L17
    }
}
