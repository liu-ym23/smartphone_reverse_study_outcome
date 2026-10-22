package com.obric.assistant.obric_action.handler.message;

import android.content.Context;
import android.util.LruCache;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.chat.model.repo.u1;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.assistant.obric_action.IObricActionHandler;
import com.obric.assistant.obric_action.d;
import com.obric.assistant.obric_action.h;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0019\u001aB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/obric/assistant/obric_action/handler/message/SendMessageActionHandler;", "Lcom/obric/assistant/obric_action/IObricActionHandler;", "Lcom/obric/assistant/obric_action/handler/message/SendMessageActionHandler$Params;", "", "<init>", "()V", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", "context", "Landroid/content/Context;", "params", "(Landroid/content/Context;Lcom/obric/assistant/obric_action/handler/message/SendMessageActionHandler$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasSuccessfullySent", "", "oActionUUID", "", "recordSuccessfulOActionUUID", "Companion", "Params", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SendMessageActionHandler implements IObricActionHandler<b, Unit> {
    public static final LruCache<String, Boolean> c = null;
    public final Class<b> b;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bw\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\u001e\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0019J~\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\f2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R(\u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019¨\u0006*"}, d2 = {"Lcom/obric/assistant/obric_action/handler/message/SendMessageActionHandler$Params;", "", "content", "", "cvsId", "scene", "ext", "", "sendFuncChannel", "traceId", "oActionUUID", "preventDuplicateSend", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getContent", "()Ljava/lang/String;", "getCvsId", "getScene", "getExt", "()Ljava/util/Map;", "getSendFuncChannel", "getTraceId", "getOActionUUID", "getPreventDuplicateSend", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/obric/assistant/obric_action/handler/message/SendMessageActionHandler$Params;", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("content")
        private final String content;

        @SerializedName("cvsId")
        private final String cvsId;

        @SerializedName("ext")
        private final Map<String, String> ext;

        @SerializedName("oActionUUID")
        private final String oActionUUID;

        @SerializedName("preventDuplicateSend")
        private final Boolean preventDuplicateSend;

        @SerializedName("scene")
        private final String scene;

        @SerializedName("sendFuncChannel")
        private final String sendFuncChannel;

        @SerializedName("traceId")
        private final String traceId;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.content, r6.content) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.cvsId, r6.cvsId) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.scene, r6.scene) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.ext, r6.ext) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.sendFuncChannel, r6.sendFuncChannel) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.traceId, r6.traceId) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.oActionUUID, r6.oActionUUID) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.preventDuplicateSend, r6.preventDuplicateSend) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            String r0 = this.content;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.cvsId;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.scene;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            Map<String, String> r10 = this.ext;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            String r13 = this.sendFuncChannel;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            String r16 = this.traceId;
            if (r16 != null) goto L25;
            int r17 = 0;
        L26:
            int r18 = (r15 + r17) * 31;
            String r19 = this.oActionUUID;
            if (r19 != null) goto L29;
            int r20 = 0;
        L30:
            int r21 = (r18 + r20) * 31;
            Boolean r22 = this.preventDuplicateSend;
            if (r22 == null) goto L35;
            r1 = r22.hashCode();
        L35:
            return r21 + r1;
        L29:
            r20 = r19.hashCode();
            goto L30
        L25:
            r17 = r16.hashCode();
            goto L26
        L21:
            r14 = r13.hashCode();
            goto L22
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "Params(content=" + this.content + ", cvsId=" + this.cvsId + ", scene=" + this.scene + ", ext=" + this.ext + ", sendFuncChannel=" + this.sendFuncChannel + ", traceId=" + this.traceId + ", oActionUUID=" + this.oActionUUID + ", preventDuplicateSend=" + this.preventDuplicateSend + ')';
        }

        public b() {
            this.content = null;
            this.cvsId = null;
            this.scene = null;
            this.ext = null;
            this.sendFuncChannel = null;
            this.traceId = null;
            this.oActionUUID = null;
            this.preventDuplicateSend = null;
        }

        public final String a() {
            return this.content;
        }

        public final String b() {
            return this.cvsId;
        }

        public final Map<String, String> c() {
            return this.ext;
        }

        public final String d() {
            return this.oActionUUID;
        }

        public final Boolean e() {
            return this.preventDuplicateSend;
        }

        public final String f() {
            return this.scene;
        }

        public final String g() {
            return this.sendFuncChannel;
        }

        public final String h() {
            return this.traceId;
        }
    }

    static {
        c = new LruCache(10);
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final d c() {
        d r0 = d.f.a;
        return d.f.a;
    }

    public SendMessageActionHandler() {
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

    public final Object e(b r35, Continuation r36) {
        b r0 = r35;
        if ((r36 instanceof SendMessageActionHandler$execute$1) == false) goto L7;
        SendMessageActionHandler$execute$1 r2 = (SendMessageActionHandler$execute$1) r36;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        String r10 = "";
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        String r6 = (String) r2.L$1;
        b r7 = (b) r2.L$0;
        ResultKt.throwOnFailure(r1);
        String r8 = r6;
        r0 = r7;
        Object r9 = r1;
    L41:
        e r11 = (e) r9;
        if (r11 == null) goto L44;
        String r12 = r11.a;
    L45:
        if (r12 != null) goto L47;
        String r13 = "";
    L48:
        FLogger.a.i("SendMessageActionHandler", "get main conversation id = ".concat(r13));
    L49:
        String r14 = r8;
        String r15 = r13;
        if (r15.length() != 0) goto L52;
        boolean r16 = true;
    L53:
        if (r16 == false) goto L56;
        FLogger.a.w("SendMessageActionHandler", "handle send message failed. cvsId is empty.");
        return h.a.a(h.d, "cvsId is empty", 2);
    L56:
        boolean r17 = Intrinsics.areEqual(r0.e(), Boxing.boxBoolean(true));
        String r18 = r0.d();
        if (r18 != null) goto L59;
        r18 = "";
    L59:
        if (r17 == true) goto L61;
    L64:
        if (r17 == true) goto L66;
    L69:
        String r19 = r0.h();
        if (r19 != null) goto L73;
        r19 = "";
    L73:
        if (r19.length() != 0) goto L75;
        boolean r20 = true;
    L76:
        if (r20 == false) goto L78;
        r19 = UUID.randomUUID().toString();
    L78:
        String r110 = r19;
        String r21 = r0.f();
        if (r21 != null) goto L82;
        r21 = "";
    L82:
        if (r21.length() != 0) goto L84;
        boolean r22 = true;
    L86:
        if (r22 == false) goto L88;
        String r111 = "obric_send_msg_intent_handler";
    L89:
        String r23 = r0.g();
        if (r23 == null) goto L94;
        r10 = r23;
    L94:
        if (r10.length() != 0) goto L96;
        boolean r24 = true;
    L97:
        if (r24 == false) goto L99;
        String r25 = "obric_send_msg_intent_handler";
    L100:
        h.a r26 = h.d;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L112
        u1 r112 = RepoDispatcherDelegate.b.e().u1();     // Catch: Throwable -> L112
        LinkedHashMap r113 = new LinkedHashMap();     // Catch: Throwable -> L112
        Map<String, String> r28 = r0.c();     // Catch: Throwable -> L112
        if (r28 == null) goto L110;
        Iterator<Map.Entry<String, String>> r29 = r28.entrySet().iterator();     // Catch: Throwable -> L112
    L105:
        if (r29.hasNext() == false) goto L110;
        Map.Entry<String, String> r30 = r29.next();     // Catch: Throwable -> L112
        String r31 = r30.getKey();     // Catch: Throwable -> L112
        String r32 = r30.getValue();     // Catch: Throwable -> L112
        if (r31 == null) goto L105;
        if (r32 == null) goto L105;
        r113.put(r31, r32);     // Catch: Throwable -> L112
    L110:
        Unit r33 = Unit.INSTANCE;     // Catch: Throwable -> L112
        u1.a.f(r112, r14, r15, r111, r113, new com.obric.assistant.obric_action.handler.message.a(), null, r110, false, new ReferenceInfo(null, null, null, 0, null, null, null, null, 255, null), r25, null, null, null, false, 31040);     // Catch: Throwable -> L112
        Object r34 = Result.constructor-impl(Boxing.boxBoolean(true));     // Catch: Throwable -> L112
    L114:
        Throwable r37 = Result.exceptionOrNull-impl(r34);
        if (r37 == null) goto L118;
        FLogger.a.w("SendMessageActionHandler", "handle send message failed. " + r37.getMessage(), r37);
    L118:
        if (Result.isSuccess-impl(r34) == false) goto L124;
        ((Boolean) r34).booleanValue();
        FLogger.a.i("SendMessageActionHandler", "handle send message success.");
        if (r17 == false) goto L124;
        if ((!StringsKt.isBlank(r18)) == false) goto L124;
        c.put(r18, Boolean.TRUE);
    L124:
        Boolean r38 = Boxing.boxBoolean(false);
        if (Result.isFailure-impl(r34) == false) goto L128;
        r34 = r38;
    L128:
        return r26.b(((Boolean) r34).booleanValue());
    L112:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        r34 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L114
    L99:
        r25 = r10;
        goto L100
    L96:
        r24 = false;
        goto L97
    L88:
        r111 = r21;
        goto L89
    L84:
        r22 = false;
        goto L86
    L75:
        r20 = false;
        goto L76
    L66:
        if (Intrinsics.areEqual(c.get(r18), Boolean.TRUE) == false) goto L69;
        FLogger.a.w("SendMessageActionHandler", "handle send message failed. duplicate send prevented for oActionUUID.");
        return h.a.a(h.d, "duplicate send prevented for oActionUUID", 2);
    L61:
        if (StringsKt.isBlank(r18) == false) goto L64;
        FLogger.a.w("SendMessageActionHandler", "handle send message failed. oActionUUID is empty while preventing duplicate send.");
        return h.a.a(h.d, "oActionUUID is empty when preventDuplicateSend is true", 2);
    L52:
        r16 = false;
        goto L53
    L47:
        r13 = r12;
    L44:
        r12 = null;
        goto L45
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        if (r0 == null) goto L17;
        r8 = r35.a();
        if (r8 != null) goto L22;
        r8 = "";
    L22:
        if (r8.length() != 0) goto L24;
        boolean r40 = true;
    L25:
        if (r40 == false) goto L28;
        FLogger.a.w("SendMessageActionHandler", "handle send message failed. content is empty.");
        return h.a.a(h.d, "content is empty", 2);
    L28:
        r13 = r35.b();
        if (r13 != null) goto L32;
        r13 = "";
    L32:
        if (r13.length() != 0) goto L34;
        boolean r114 = true;
    L35:
        if (r114 == false) goto L49;
        IObricChatService r41 = (IObricChatService) ServiceManager.get().getService(IObricChatService.class);
        if (r41 == null) goto L44;
        r2.L$0 = r0;
        r2.L$1 = r8;
        r2.label = 1;
        r9 = r41.d(r2);
        if (r9 != r4) goto L41;
        return r4;
    L34:
        r114 = false;
        goto L35
    L24:
        r40 = false;
        goto L25
    L17:
        return h.a.a(h.d, "params is null", 2);
    L7:
        r2 = new SendMessageActionHandler$execute$1(this, r36);
        goto L8
    }

    @Override // com.obric.assistant.obric_action.IObricActionHandler
    public final /* bridge */ /* synthetic */ Object d(Context r1, b r2, Continuation<? super h<? extends Unit>> r3) {
        return e(r2, r3);
    }
}
