package com.obric.assistant.omnidetailpage.componment;

import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.omnidetailpage.componment.OmniDetailContentComponent$updateTitle$1", f = "OmniDetailContentComponent.kt", i = {0}, l = {234, 236, 247}, m = "invokeSuspend", n = {"queryId"}, s = {"L$1"})
final class OmniDetailContentComponent$updateTitle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ OmniDetailContentComponent this$0;

    public OmniDetailContentComponent$updateTitle$1(OmniDetailContentComponent r1, Continuation<? super OmniDetailContentComponent$updateTitle$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new OmniDetailContentComponent$updateTitle$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r4 = true;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ResultKt.throwOnFailure(r11);
    L102:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r11);
    L29:
        Message r12 = (Message) r11;
    L31:
        String r2 = "";
        if (r12 == null) goto L75;
        Intrinsics.checkNotNullParameter(r12, "<this>");
        Map r6 = r12.getExt();
        if (r6 == null) goto L36;
        String r7 = (String) r6.get("o_event_task");
    L37:
        if (r7 != null) goto L39;
    L42:
        boolean r8 = true;
    L43:
        if (r8 == false) goto L103;
    L64:
        String r9 = com.larus.bmhome.chat.bean.d.H(r12);
        if (r9 == null) goto L67;
        Pair r10 = new Pair(r9, "");
    L68:
        if (r10 == null) goto L75;
        OmniDetailContentComponent r13 = this.this$0;
        int r14 = OmniDetailContentComponent.I;
        ifa.e r15 = r13.V3();
        if (r15 == null) goto L72;
        r15.a = (String) r10.getFirst();
    L72:
        ifa.e r16 = r13.V3();
        if (r16 == null) goto L75;
        r16.b = (String) r10.getSecond();
        goto L75
    L67:
        r10 = null;
        goto L68
    L103:
        JSONObject r17 = new JSONObject(r7);     // Catch: Exception -> L62
        String r18 = r17.optString("instruct");     // Catch: Exception -> L62
        String r19 = r17.optString("shortInstruct");     // Catch: Exception -> L62
        if (r19 != null) goto L47;
    L50:
        boolean r20 = true;
    L51:
        if (r20 == true) goto L53;
        r10 = new Pair(r19, r18);     // Catch: Exception -> L62
        goto L68
    L53:
        if (r18 != null) goto L55;
    L58:
        boolean r21 = true;
    L59:
        if (r21 == true) goto L64;
        r10 = new Pair(r18, "");     // Catch: Exception -> L62
        goto L68
    L55:
        if (r18.length() == 0) goto L58;
        r21 = false;
        goto L59
    L47:
        if (r19.length() == 0) goto L50;
        r20 = false;
    L62:
        e = move-exception;
        FLogger.a.e("MessageExt", "parse o_event_task error", e);
        goto L64
    L39:
        if (r7.length() == 0) goto L42;
        r8 = false;
        goto L43
    L36:
        r7 = null;
    L75:
        OmniDetailContentComponent r22 = this.this$0;
        int r23 = OmniDetailContentComponent.I;
        ifa.e r24 = r22.V3();
        if (r24 == null) goto L98;
        ifa.e r25 = this.this$0.V3();
        if (r25 == null) goto L80;
        String r26 = r25.h;
    L81:
        if (r26 != null) goto L84;
        r26 = "";
    L84:
        if (r26.length() == 0) goto L87;
        r4 = false;
    L87:
        if (r4 == false) goto L97;
        if (r12 == null) goto L92;
        Map r110 = r12.getExt();
        if (r110 == null) goto L92;
        String r111 = (String) r110.get("o_omni_instruction_type");
    L93:
        if (r111 == null) goto L96;
        r2 = r111;
    L96:
        r26 = r2;
    L92:
        r111 = null;
    L97:
        r24.h = r26;
        goto L98
    L80:
        r26 = null;
    L98:
        OmniDetailContentComponent r112 = this.this$0;
        r112.C = false;
        this.L$0 = null;
        this.L$1 = null;
        this.label = 3;
        if (r112.H3(this) != r0) goto L102;
        return r0;
    L11:
        String r3 = (String) this.L$1;
        OmniDetailContentComponent r27 = (OmniDetailContentComponent) this.L$0;
        ResultKt.throwOnFailure(r11);
    L24:
        r12 = (Message) r11;
        if (r12 != null) goto L31;
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        r11 = OmniDetailContentComponent.p3(r27, r3, this);
        if (r11 != r0) goto L29;
        return r0;
    L12:
        ResultKt.throwOnFailure(r11);
        OmniDetailContentComponent r113 = this.this$0;
        int r5 = OmniDetailContentComponent.I;
        ifa.e r114 = r113.V3();
        if (r114 == null) goto L30;
        String r115 = r114.e;
        if (r115 == null) goto L30;
        if ((!StringsKt.isBlank(r115)) == false) goto L19;
        r3 = r115;
    L20:
        if (r3 == null) goto L30;
        r27 = this.this$0;
        CoroutineDispatcher r116 = Dispatchers.getIO();
        OmniDetailContentComponent$updateTitle$1$message$2$1 r28 = new OmniDetailContentComponent$updateTitle$1$message$2$1(r27, r3, null);
        this.L$0 = r27;
        this.L$1 = r3;
        this.label = 1;
        r11 = BuildersKt.withContext(r116, r28, this);
        if (r11 != r0) goto L24;
        return r0;
    L19:
        r3 = null;
    L30:
        r12 = null;
        goto L31
    }
}
