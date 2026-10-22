package com.larus.doc.impl.chat.component;

import android.content.Context;
import androidx.core.os.BundleKt;
import com.larus.doc.api.IDocService;
import com.larus.doc.api.IDocService$Companion;
import com.larus.doc.impl.DocumentApi;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.chat.component.NewDocComponent$createNewDocV2$1", f = "NewDocComponent.kt", i = {0}, l = {37}, m = "invokeSuspend", n = {"clickTimestamp"}, s = {"J$0"})
final class NewDocComponent$createNewDocV2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isFromClickVoice;
    long J$0;
    int label;
    final /* synthetic */ NewDocComponent this$0;

    public NewDocComponent$createNewDocV2$1(NewDocComponent r1, boolean r2, Continuation<? super NewDocComponent$createNewDocV2$1> r3) {
        this.this$0 = r1;
        this.$isFromClickVoice = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new NewDocComponent$createNewDocV2$1(this.this$0, this.$isFromClickVoice, r4);
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
        String r3 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        long r2 = this.J$0;
        ResultKt.throwOnFailure(r9);
    L12:
        dm9.a.b r10 = (dm9.a) r9;
        FLogger r5 = FLogger.a;
        r5.i("[DocTracer]", "After create doc");
        if ((r10 instanceof dm9.a.b) == false) goto L29;
        h39.d r11 = (h39.d) r10.a.getData();
        r5.i("NewDocComponent", "createNewDocV2, success resp = " + r11);
        if (r11 == null) goto L17;
        String r4 = r11.a();
    L19:
        if (o0.d(r4) == false) goto L28;
        IDocService$Companion r6 = IDocService.a;
        Context r7 = this.this$0.getContext();
        Pair[] r8 = new Pair[5];
        if (r11 == null) goto L23;
        r3 = r11.a();
    L23:
        r8[0] = TuplesKt.to("key_doc_id", r3);
        r8[1] = TuplesKt.to("key_action_bar_scene", "doc_create_empty");
        r8[2] = TuplesKt.to("key_create_new_doc_by_voice", Boxing.boxBoolean(this.$isFromClickVoice));
        if (this.$isFromClickVoice == false) goto L26;
        String r12 = "ai_doc_list_speak_input_create";
    L27:
        r8[3] = TuplesKt.to("key_doc_enter_from", r12);
        r8[4] = TuplesKt.to("key_click_timestamp", Boxing.boxLong(r2));
        r6.Z9(r7, BundleKt.bundleOf(r8), "ai_doc_list");
    L31:
        return Unit.INSTANCE;
    L26:
        r12 = "ai_doc_list_blank_file_create";
        goto L27
    L28:
        r5.i("NewDocComponent", "createNewDocV2, resourceId isNullOrEmpty");
        goto L31
    L17:
        r4 = null;
        goto L19
    L29:
        r5.i("NewDocComponent", "createNewDocV2, fail");
        goto L31
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        FLogger.a.i("[DocTracer]", "Before create doc");
        long r13 = System.currentTimeMillis();
        DocumentApi.a r14 = DocumentApi.a;
        NewDocComponent$createNewDocV2$1$resp$1 r15 = new NewDocComponent$createNewDocV2$1$resp$1(null);
        this.J$0 = r13;
        this.label = 1;
        r14.getClass();
        r9 = DocumentApi.a.a(r15, this);
        if (r9 != r0) goto L11;
        return r0;
    L11:
        r2 = r13;
        goto L12
    }
}
