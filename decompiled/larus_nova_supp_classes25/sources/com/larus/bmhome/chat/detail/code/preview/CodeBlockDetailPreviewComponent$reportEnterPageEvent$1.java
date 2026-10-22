package com.larus.bmhome.chat.detail.code.preview;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.platform.service.o;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.detail.code.preview.CodeBlockDetailPreviewComponent$reportEnterPageEvent$1", f = "CodeBlockDetailPreviewComponent.kt", i = {1}, l = {271, 272}, m = "invokeSuspend", n = {"messageIsFinish"}, s = {"Z$0"})
public final class CodeBlockDetailPreviewComponent$reportEnterPageEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $costTime;
    final /* synthetic */ boolean $isSuccess;
    boolean Z$0;
    int label;
    final /* synthetic */ CodeBlockDetailPreviewComponent this$0;

    public CodeBlockDetailPreviewComponent$reportEnterPageEvent$1(CodeBlockDetailPreviewComponent r1, long r2, boolean r4, Continuation<? super CodeBlockDetailPreviewComponent$reportEnterPageEvent$1> r5) {
        this.this$0 = r1;
        this.$costTime = r2;
        this.$isSuccess = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new CodeBlockDetailPreviewComponent$reportEnterPageEvent$1(this.this$0, this.$costTime, this.$isSuccess, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r2v2, types: [org.json.JSONObject] */
    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        boolean r2 = this.Z$0;
        ResultKt.throwOnFailure(r10);
        ?? r3 = r2;
    L35:
        boolean r11 = ((Boolean) r10).booleanValue();
        o r4 = o.a;
        ?? r5 = new JSONObject();
        CodeBlockDetailPreviewComponent r6 = this.this$0;
        long r7 = this.$costTime;
        boolean r8 = this.$isSuccess;
        r5.put("message_id", r6.m);
        r5.put("cost_time", r7);
        r5.put("is_preload", r6.v ? 1 : 0);
        r5.put("is_success", r8 ? 1 : 0);
        String r9 = r6.getLanguage();
        if (r9 != null) goto L38;
        r9 = "";
    L38:
        r5.put("code_type", r9);
        r5.put("is_from_deep_research", r6.q ? 1 : 0);
        r5.put("message_is_finish", r3);
        r5.put("message_is_last", r11 ? 1 : 0);
        Unit r12 = Unit.INSTANCE;
        r4.reportEvent("rd_enter_page_code_preview", r5);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
    L19:
        boolean r13 = ((Boolean) r10).booleanValue();
        CodeBlockDetailPreviewComponent r14 = this.this$0;
        this.Z$0 = r13;
        this.label = 2;
        if (r14.n.length() != 0) goto L22;
        boolean r15 = true;
    L23:
        if (r15 == false) goto L25;
    L31:
        Object r16 = Boxing.boxBoolean(false);
    L32:
        if (r16 != r0) goto L34;
        return r0;
    L34:
        r3 = r13;
        r10 = r16;
        goto L35
    L25:
        if (r14.m.length() != 0) goto L27;
        boolean r17 = true;
    L28:
        if (r17 == true) goto L31;
        CompletableDeferred r18 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        com.larus.im.d.e().l(r14.n, new f(r18, r14));
        r16 = r18.await(this);
        goto L32
    L27:
        r17 = false;
        goto L28
    L22:
        r15 = false;
        goto L23
    L10:
        ResultKt.throwOnFailure(r10);
        CodeBlockDetailPreviewComponent r19 = this.this$0;
        this.label = 1;
        if (r19.m.length() != 0) goto L13;
        boolean r20 = true;
    L14:
        if (r20 == false) goto L16;
        r10 = Boxing.boxBoolean(false);
    L17:
        if (r10 != r0) goto L19;
        return r0;
    L16:
        CompletableDeferred r21 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        com.larus.im.d.e().m(r19.m, new e(r21));
        r10 = r21.await(this);
        goto L17
    L13:
        r20 = false;
        goto L14
    }
}
