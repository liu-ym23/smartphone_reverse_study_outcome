package com.obric.assistant.obric_action.handler;

import android.app.Activity;
import android.content.Context;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.assistant.oauto.IOAutoApi;
import com.obric.assistant.obric_action.IObricActionHandler;
import com.obric.assistant.obric_action.d;
import com.obric.assistant.obric_action.h;
import com.obric.assistant.utils.k;
import gd9.i;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001a\u001bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013J\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010\u0017J\u000e\u0010\u0018\u001a\u0004\u0018\u00010\u0015*\u00020\u0019H\u0002R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/obric/assistant/obric_action/handler/OpenCreateShortcutHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "Lcom/obric/assistant/obric_action/handler/OpenCreateShortcutHandler$Params;", "", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", "context", "Landroid/content/Context;", "params", "(Landroid/content/Context;Lcom/obric/assistant/obric_action/handler/OpenCreateShortcutHandler$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveTaskModelJson", "", "messageId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "taskModelJson", "Lcom/larus/im/bean/message/Message;", "Companion", "Params", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenCreateShortcutHandler implements IObricActionHandler<b, Unit> {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/obric_action/handler/OpenCreateShortcutHandler$Params;", "", "query", "", "messageId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getQuery", "()Ljava/lang/String;", "getMessageId", "component1", "component2", "copy", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("messageId")
        private final String messageId;

        @SerializedName("query")
        private final String query;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.query, r6.query) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.messageId, r6.messageId) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r0 = this.query;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.messageId;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "Params(query=" + this.query + ", messageId=" + this.messageId + ')';
        }

        public b() {
            this.query = null;
            this.messageId = null;
        }

        public final String a() {
            return this.messageId;
        }

        public final String b() {
            return this.query;
        }
    }

    static {
    }

    public OpenCreateShortcutHandler() {
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final d c() {
        d r0 = d.g.a;
        return d.g.b;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Class<b> b() {
        return b.class;
    }

    public static String g(Message r1) {
        Map r2 = r1.getExt();
        if (r2 == null) goto L12;
        String r3 = (String) r2.get("o_complex_task_model");
        if (r3 == null) goto L12;
        if (r3.length() <= 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == false) goto L12;
        return r3;
    L9:
        r0 = false;
    L12:
        return null;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final b a(Context r1, String r2) {
        return (b) IObricActionHandler.b.a(this, r1, r2);
    }

    public final Object f(String r9, Continuation<? super String> r10) {
        if ((r10 instanceof OpenCreateShortcutHandler$resolveTaskModelJson$1) == false) goto L7;
        OpenCreateShortcutHandler$resolveTaskModelJson$1 r0 = (OpenCreateShortcutHandler$resolveTaskModelJson$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L17;
        if (r3 != 2) goto L16;
        OpenCreateShortcutHandler r12 = (OpenCreateShortcutHandler) r0.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L63
    L57:
        Message r13 = (Message) r11;     // Catch: Throwable -> L63
        if (r13 == null) goto L60;
        r12.getClass();     // Catch: Throwable -> L63
        String r14 = g(r13);     // Catch: Throwable -> L63
    L61:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L63
    L65:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L69;
        FLogger.a.w("OpenCreateShortcutHandler", "resolveTaskModelJson failed. " + r16.getMessage(), r16);
    L69:
        if (Result.isFailure-impl(r15) == false) goto L72;
        return null;
    L72:
        return r15;
    L60:
        r14 = null;
        goto L61
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r12 = (OpenCreateShortcutHandler) r0.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L63
    L25:
        Message r17 = (Message) r11;     // Catch: Throwable -> L63
        if (r17 == null) goto L31;
        r12.getClass();     // Catch: Throwable -> L63
        String r5 = g(r17);     // Catch: Throwable -> L63
        if (r5 == null) goto L31;
        return r5;
    L31:
        if (r17 == null) goto L40;
        String r6 = k.a(r17);     // Catch: Throwable -> L63
        if (r6.length() <= 0) goto L35;
        boolean r7 = true;
    L36:
        if (r7 == true) goto L39;
        r6 = null;
    L39:
        if (r6 == null) goto L40;
    L54:
        IChatRepoService r18 = zh8.a.a;     // Catch: Throwable -> L63
        r0.L$0 = r12;     // Catch: Throwable -> L63
        r0.label = 2;     // Catch: Throwable -> L63
        r11 = r18.E1(r6, r0);     // Catch: Throwable -> L63
        if (r11 != r2) goto L57;
        return r2;
    L35:
        r7 = false;
    L40:
        if (r17 == null) goto L51;
        String r19 = r17.getReplyId();     // Catch: Throwable -> L63
        if (r19 == null) goto L51;
        if (r19.length() > 0) goto L47;
        r4 = false;
    L47:
        if (r4 == true) goto L50;
        r19 = null;
    L50:
        r6 = r19;
    L52:
        if (r6 != null) goto L54;
        return null;
    L51:
        r6 = null;
        goto L52
    L20:
        ResultKt.throwOnFailure(r11);
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L63
        IChatRepoService r111 = zh8.a.a;     // Catch: Throwable -> L63
        r0.L$0 = this;     // Catch: Throwable -> L63
        r0.label = 1;     // Catch: Throwable -> L63
        r11 = r111.E1(r9, r0);     // Catch: Throwable -> L63
        if (r11 != r2) goto L24;
        return r2;
    L24:
        r12 = this;
    L63:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new OpenCreateShortcutHandler$resolveTaskModelJson$1(this, r10);
        goto L8
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final /* bridge */ /* synthetic */ Object d(Context r1, b r2, Continuation<? super h<? extends Unit>> r3) {
        return e(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v25, types: [com.obric.assistant.obric_action.handler.a] */
    public final Object e(Context r19, b r20, Continuation<? super h<Unit>> r21) {
        if ((r21 instanceof OpenCreateShortcutHandler$execute$1) == false) goto L7;
        OpenCreateShortcutHandler$execute$1 r4 = (OpenCreateShortcutHandler$execute$1) r21;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        Object r0 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        boolean r8 = false;
        if (r7 == 0) goto L16;
        if (r7 != 1) goto L15;
        String r2 = (String) r4.L$2;
        String r9 = (String) r4.L$1;
        Context r10 = (Context) r4.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L64
        String r15 = r2;
        Context r3 = r10;
        String r14 = r9;
    L46:
        String r1 = (String) r0;     // Catch: Throwable -> L64
        FLogger r11 = FLogger.a;     // Catch: Throwable -> L64
        StringBuilder r12 = new StringBuilder("openCreateShortcutPage, hasTaskModel: ");     // Catch: Throwable -> L64
        if (r1 != null) goto L49;
    L50:
        r8 = true;
    L51:
        r12.append(!r8);     // Catch: Throwable -> L64
        r11.i("OpenCreateShortcutHandler", r12.toString());     // Catch: Throwable -> L64
        IOAutoApi r13 = com.obric.assistant.oauto.b.a();     // Catch: Throwable -> L64
        if (r13 != 0) goto L55;
        r11.w("OpenCreateShortcutHandler", "openCreateShortcutPage failed, OAutoApi is null");     // Catch: Throwable -> L64
        h r16 = h.a.a(h.d, "OAutoApi is null", 2);     // Catch: Throwable -> L64
    L62:
        Object r17 = Result.constructor-impl(r16);     // Catch: Throwable -> L64
    L66:
        Throwable r18 = Result.exceptionOrNull-impl(r17);
        if (r18 == null) goto L69;
        FLogger.a.w("OpenCreateShortcutHandler", "openCreateShortcutPage failed. " + r18.getMessage(), r18);
    L69:
        Throwable r22 = Result.exceptionOrNull-impl(r17);
        if (r22 != null) goto L73;
        return r17;
    L73:
        return h.a.a(h.d, r22.getMessage(), 2);
    L55:
        if ((r3 instanceof Activity) == false) goto L57;
        final Activity r110 = (Activity) r3;     // Catch: Throwable -> L64
    L58:
        if (r110 == null) goto L60;
        r13.d(r110, r14, r15, r1, new com.obric.assistant.obric_action.handler.a(r110));     // Catch: Throwable -> L64
    L61:
        r16 = h.a.c(h.d, null, "openCreateShortcutPage susscess", 1);     // Catch: Throwable -> L64
        goto L62
    L60:
        r11.i("OpenCreateShortcutHandler", "openCreateShortcutPage: context is not Activity, jump without result");     // Catch: Throwable -> L64
        r13.a(r3, r14, r15, r1);     // Catch: Throwable -> L64
        goto L61
    L57:
        r110 = null;
        goto L58
    L49:
        if (r1.length() != 0) goto L51;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r0);
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L64
        if (r20 == null) goto L20;
        String r24 = r20.b();     // Catch: Throwable -> L64
    L21:
        if (r20 == null) goto L23;
        String r25 = r20.a();     // Catch: Throwable -> L64
    L24:
        if (r25 != null) goto L26;
        r25 = "";
    L26:
        FLogger r111 = FLogger.a;     // Catch: Throwable -> L64
        StringBuilder r112 = new StringBuilder("openCreateShortcutPage, query isNullOrEmpty: ");     // Catch: Throwable -> L64
        if (r24 != null) goto L29;
    L32:
        boolean r26 = true;
    L33:
        r112.append(r26);     // Catch: Throwable -> L64
        r112.append(", messageId: ");     // Catch: Throwable -> L64
        r112.append(r25);     // Catch: Throwable -> L64
        r111.i("OpenCreateShortcutHandler", r112.toString());     // Catch: Throwable -> L64
        if (r19.getResources().getConfiguration().orientation != 2) goto L37;
        r111.i("OpenCreateShortcutHandler", "openCreateShortcutPage failed, landscape is not supported");     // Catch: Throwable -> L64
        s r27 = s.a;     // Catch: Throwable -> L64
        i r28 = com.larus.im.b.a;     // Catch: Throwable -> L64
        Intrinsics.checkNotNull(r28);     // Catch: Throwable -> L64
        r27.g(r28.getApplication(), 2131912394, false);     // Catch: Throwable -> L64
        r16 = h.a.a(h.d, "landscape is not supported", 2);     // Catch: Throwable -> L64
        goto L62
    L37:
        if (r25.length() != 0) goto L39;
        boolean r29 = true;
    L40:
        if (r29 == false) goto L42;
        r16 = h.a.a(h.d, "messageId is empty", 2);     // Catch: Throwable -> L64
        goto L62
    L42:
        r3 = r19;
        r4.L$0 = r3;     // Catch: Throwable -> L64
        r4.L$1 = r24;     // Catch: Throwable -> L64
        r4.L$2 = r25;     // Catch: Throwable -> L64
        r4.label = 1;     // Catch: Throwable -> L64
        Object r30 = f(r25, r4);     // Catch: Throwable -> L64
        if (r30 != r6) goto L45;
        return r6;
    L45:
        r14 = r24;
        r0 = r30;
        r15 = r25;
        goto L46
    L39:
        r29 = false;
        goto L40
    L29:
        if (r24.length() == 0) goto L32;
        r26 = false;
        goto L33
    L23:
        r25 = null;
        goto L24
    L20:
        r24 = null;
    L64:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r4 = new OpenCreateShortcutHandler$execute$1(this, r21);
        goto L8
    }
}
