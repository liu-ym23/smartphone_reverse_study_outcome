package com.obric.assistant.obric_action.handler.message;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import com.larus.applog.api.IApplog;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.chat.internal.ChatSender;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.assistant.obric_action.IObricActionHandler;
import com.obric.assistant.obric_action.d;
import com.obric.assistant.obric_action.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001a\u001bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013J.\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0016H\u0002R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/obric/assistant/obric_action/handler/message/ResendMessageActionHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "Lcom/obric/assistant/obric_action/handler/message/ResendMessageActionHandler$Params;", "", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", "context", "Landroid/content/Context;", "params", "(Landroid/content/Context;Lcom/obric/assistant/obric_action/handler/message/ResendMessageActionHandler$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportObricMessageClick", "messageId", "", "buttonType", "messageType", "currentPage", "Companion", "Params", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResendMessageActionHandler implements IObricActionHandler<b, Unit> {
    public final Class<b> b;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003Ji\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR&\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000f¨\u0006$"}, d2 = {"Lcom/obric/assistant/obric_action/handler/message/ResendMessageActionHandler$Params;", "", "messageId", "", "isQuestion", "", "scene", "extras", "", "buttonType", "messageType", "currentPage", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMessageId", "()Ljava/lang/String;", "()Z", "getScene", "getExtras", "()Ljava/util/Map;", "getButtonType", "getMessageType", "getCurrentPage", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("buttonType")
        private final String buttonType;

        @SerializedName("currentPage")
        private final String currentPage;

        @SerializedName("extras")
        private final Map<String, String> extras;

        @SerializedName("isQuestion")
        private final boolean isQuestion;

        @SerializedName("messageId")
        private final String messageId;

        @SerializedName("messageType")
        private final String messageType;

        @SerializedName("scene")
        private final String scene;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.messageId, r6.messageId) == true) goto L12;
            return false;
        L12:
            if (this.isQuestion == r6.isQuestion) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.scene, r6.scene) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.extras, r6.extras) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.buttonType, r6.buttonType) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.messageType, r6.messageType) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.currentPage, r6.currentPage) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            String r0 = this.messageId;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            if (this.isQuestion == false) goto L9;
            int r4 = 1231;
        L10:
            int r5 = (r3 + r4) * 31;
            String r6 = this.scene;
            if (r6 != null) goto L13;
            int r7 = 0;
        L14:
            int r8 = (r5 + r7) * 31;
            Map<String, String> r9 = this.extras;
            if (r9 != null) goto L17;
            int r10 = 0;
        L18:
            int r11 = (r8 + r10) * 31;
            String r12 = this.buttonType;
            if (r12 != null) goto L21;
            int r13 = 0;
        L22:
            int r14 = (r11 + r13) * 31;
            String r15 = this.messageType;
            if (r15 != null) goto L25;
            int r16 = 0;
        L26:
            int r17 = (r14 + r16) * 31;
            String r18 = this.currentPage;
            if (r18 == null) goto L31;
            r1 = r18.hashCode();
        L31:
            return r17 + r1;
        L25:
            r16 = r15.hashCode();
            goto L26
        L21:
            r13 = r12.hashCode();
            goto L22
        L17:
            r10 = r9.hashCode();
            goto L18
        L13:
            r7 = r6.hashCode();
            goto L14
        L9:
            r4 = 1237;
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "Params(messageId=" + this.messageId + ", isQuestion=" + this.isQuestion + ", scene=" + this.scene + ", extras=" + this.extras + ", buttonType=" + this.buttonType + ", messageType=" + this.messageType + ", currentPage=" + this.currentPage + ')';
        }

        public b() {
            this.messageId = null;
            this.isQuestion = false;
            this.scene = null;
            this.extras = null;
            this.buttonType = null;
            this.messageType = null;
            this.currentPage = null;
        }

        public final String a() {
            return this.buttonType;
        }

        public final String b() {
            return this.currentPage;
        }

        public final Map<String, String> c() {
            return this.extras;
        }

        public final String d() {
            return this.messageId;
        }

        public final String e() {
            return this.messageType;
        }

        public final String f() {
            return this.scene;
        }

        public final boolean g() {
            return this.isQuestion;
        }
    }

    static {
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final d c() {
        d r0 = d.f.a;
        return d.f.b;
    }

    public ResendMessageActionHandler() {
        this.b = b.class;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Class<b> b() {
        return this.b;
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final b a(Context r1, String r2) {
        return (b) IObricActionHandler.b.a(this, r1, r2);
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final Object d(Context r13, b r14, Continuation<? super h<? extends Unit>> r15) {
        b r16 = r14;
        if (r16 == null) goto L77;
        FLogger r17 = FLogger.a;
        r17.i("ResendMessageActionHandler", "handle: receive action payload.");
        String r0 = r16.d();
        String r2 = "";
        if (r0 != null) goto L8;
        r0 = "";
    L8:
        boolean r4 = true;
        if (r0.length() != 0) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == false) goto L14;
        r17.w("ResendMessageActionHandler", "handle: messageId is empty, abort resend.");
        return h.a.a(h.d, "messageId is empty", 2);
    L14:
        String r18 = r16.f();
        if (r18 != null) goto L18;
        r18 = "";
    L18:
        if (r18.length() != 0) goto L20;
        boolean r5 = true;
    L21:
        if (r5 == false) goto L23;
        r18 = "obric_resend_message_intent_handler";
    L23:
        Map<String, String> r6 = r16.c();
        if (r6 == null) goto L37;
        ArrayList r7 = new ArrayList();
        Iterator<Map.Entry<String, String>> r8 = r6.entrySet().iterator();
    L27:
        if (r8.hasNext() == false) goto L34;
        Map.Entry<String, String> r9 = r8.next();
        String r10 = r9.getKey();
        String r11 = r9.getValue();
        if (r11 != null) goto L31;
        Pair r12 = null;
    L32:
        if (r12 == null) goto L27;
        r7.add(r12);
        goto L27
    L31:
        r12 = TuplesKt.to(r10, r11);
        goto L32
    L34:
        Map r19 = MapsKt.toMap(r7);
        if (r19 == null) goto L37;
    L38:
        String r20 = r16.a();
        String r21 = r16.e();
        String r22 = r16.b();
        JSONObject r110 = new JSONObject();
        if (r22 != null) goto L42;
        r22 = "";
    L42:
        if (r22.length() == 0) goto L45;
        r4 = false;
    L45:
        if (r4 == false) goto L47;
        r22 = "chat";
    L47:
        r110.put("current_page", r22);
        r110.put("message_id", r0);
        if (r20 != null) goto L50;
        r20 = "";
    L50:
        r110.put("button_type", r20);
        if (r21 == null) goto L54;
        r2 = r21;
    L54:
        r110.put("message_type", r2);
        FLogger.a.i("ResendMessageActionHandler", "report obric_message_click: " + r110);
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L57
        IApplog.a.reportEvent("obric_message_click", r110);     // Catch: Throwable -> L57
        Object r24 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L57
    L59:
        Throwable r25 = Result.exceptionOrNull-impl(r24);
        if (r25 == null) goto L62;
        FLogger.a.w("ResendMessageActionHandler", "report obric_message_click failed. " + r25.getMessage(), r25);
    L62:
        FLogger r26 = FLogger.a;
        r26.i("ResendMessageActionHandler", "handle: invoke resend. messageId=" + r0 + ", isQuestion=" + r16.g() + ", scene=" + r18 + ", buttonType=" + r16.a() + ", messageType=" + r16.e() + ", extrasSize=" + r19.size());
        IObricChatService.a.getClass();
        IObricChatService r27 = IObricChatService.a.a();
        if (r27 == null) goto L65;
        ChatSender r28 = r27.getSender();
    L66:
        if (r28 != null) goto L68;
        r26.w("ResendMessageActionHandler", "handle: sender is null, abort resend.");
        return h.a.a(h.d, "sender is null", 2);
    L68:
        r28.b(r0, r16.g(), r19, r18);
        return h.a.c(h.d, null, null, 3);
    L65:
        r28 = null;
    L57:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r24 = Result.constructor-impl(ResultKt.createFailure(th));
    L37:
        r19 = MapsKt.emptyMap();
        goto L38
    L20:
        r5 = false;
        goto L21
    L11:
        r3 = false;
        goto L12
    L77:
        return h.a.a(h.d, "params is null", 2);
    }
}
