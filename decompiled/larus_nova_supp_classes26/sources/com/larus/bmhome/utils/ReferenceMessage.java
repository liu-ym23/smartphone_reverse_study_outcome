package com.larus.bmhome.utils;

import android.app.Application;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.component.bottom.reference.entity.RefEntranceType;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.im.bean.message.TextContent;
import com.larus.network.http.HttpExtKt;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.Transient;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0012\b\u0087\b\u0018\u0000 32\u00020\u0001:\u000234Ba\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u001e\u001a\u00020\u0003J\u0006\u0010\u001f\u001a\u00020\u0003J\u0006\u0010 \u001a\u00020!J\u0016\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010#H\u0002J\u000e\u0010$\u001a\u00020\u0000H\u0086@¢\u0006\u0002\u0010%J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\t\u0010+\u001a\u00020\nHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jc\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010/\u001a\u00020\u00072\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\nHÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R&\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u001d¨\u00065"}, d2 = {"Lcom/larus/bmhome/utils/ReferenceMessage;", "", "messageId", "", "content", "senderName", "self", "", "exist", "searchIndex", "", "refExt", "replyId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZILjava/lang/String;Ljava/lang/String;)V", "getMessageId", "()Ljava/lang/String;", "getContent", "getSenderName", "getSelf", "()Z", "getExist", "getSearchIndex", "()I", "getRefExt", "getReplyId$annotations", "()V", "getReplyId", "setReplyId", "(Ljava/lang/String;)V", "toJsonString", "getReferenceReply", "getReferenceInfo", "Lcom/larus/im/bean/message/ReferenceInfo;", "getRefExtFromString", "", "update", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "Companion", "Manager", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReferenceMessage {
    public static final Companion Companion = null;
    private static final String DEFAULT_MSG_ID = "0";
    private static final ReferenceMessage EMPTY_REFERENCE_MESSAGE = null;
    public static final String KEY_REFERENCE_TEXT = "reference_text";
    private static final Map<String, String> botNameCache = null;
    private static final Lazy<Gson> convert$delegate = null;
    private static final Map<String, ReferenceMessage> refMessageCache = null;

    @SerializedName("content")
    private final String content;

    @SerializedName("exist")
    private final boolean exist;

    @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
    private final String messageId;

    @SerializedName("ref_ext")
    private final String refExt;
    private transient String replyId;

    @SerializedName("search_index")
    private final int searchIndex;

    @SerializedName("self")
    private final boolean self;

    @SerializedName("sender_name")
    private final String senderName;

    public static final class Companion {
        public Companion() {
        }

        public final Object c(ReferenceInfo r23, Continuation<? super ReferenceMessage> r24) {
            ReferenceInfo r1 = r23;
            if ((r24 instanceof ReferenceMessage$Companion$build$8) == false) goto L7;
            ReferenceMessage$Companion$build$8 r3 = (ReferenceMessage$Companion$build$8) r24;
            int r4 = r3.label;
            if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
            r3.label = r4 - Integer.MIN_VALUE;
        L8:
            Object r2 = r3.result;
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r6 = r3.label;
            if (r6 == 0) goto L19;
            if (r6 == 1) goto L15;
            if (r6 != 2) goto L14;
            boolean r7 = r3.Z$0;
            String r8 = (String) r3.L$3;
            String r9 = (String) r3.L$2;
            Message r10 = (Message) r3.L$1;
            ReferenceInfo r11 = (ReferenceInfo) r3.L$0;
            ResultKt.throwOnFailure(r2);
            boolean r15 = r7;
            String r12 = r8;
            String r13 = r9;
        L49:
            String r14 = (String) r2;
            boolean r16 = com.larus.bmhome.chat.bean.d.G0(r10);
            int r17 = r11.searchIndex;
            JSONObject r18 = new JSONObject();
            Map r19 = r11.ext;
            if (r19 == null) goto L55;
            Iterator r20 = r19.entrySet().iterator();
        L53:
            if (r20.hasNext() == false) goto L55;
            Map.Entry r21 = (Map.Entry) r20.next();
            r18.put((String) r21.getKey(), r21.getValue());
        L55:
            Unit r22 = Unit.INSTANCE;
            ReferenceMessage r25 = new ReferenceMessage(r13, r12, r14, r16, r15, r17, r18.toString(), null, 128, null);
            String r26 = r25.getMessageId();
            if (r26 == null) goto L58;
            ReferenceMessage.access$getRefMessageCache$cp().put(r26, r25);
        L58:
            return r25;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            String r27 = (String) r3.L$2;
            ReferenceMessage r28 = (ReferenceMessage) r3.L$1;
            ReferenceInfo r29 = (ReferenceInfo) r3.L$0;
            ResultKt.throwOnFailure(r2);     // Catch: Exception -> L18
            String r30 = r27;
            r1 = r29;
            Object r31 = r2;
        L33:
            r10 = (Message) r31;     // Catch: Exception -> L60
        L36:
            if (r10 != null) goto L39;
            FLogger.a.i("BotUtils", "ref message not found, use default");
            return r28;
        L39:
            boolean r32 = com.larus.bmhome.chat.bean.d.U(r10);
            if (r32 == false) goto L44;
            String r33 = r1.displayContent;
            if (r33 != null) goto L45;
            r33 = "";
        L45:
            r3.L$0 = r1;
            r3.L$1 = r10;
            r3.L$2 = r30;
            r3.L$3 = r33;
            r3.Z$0 = r32;
            r3.label = 2;
            Object r34 = d(r10, false, r3);
            if (r34 != r5) goto L48;
            return r5;
        L48:
            r13 = r30;
            r2 = r34;
            r15 = r32;
            r12 = r33;
            r11 = r1;
            goto L49
        L44:
            r33 = AppHost.a.getApplication().getString(2131908670);
        L35:
            r10 = null;
        L18:
            r30 = r27;
            r1 = r29;
            goto L35
        L19:
            ResultKt.throwOnFailure(r2);
            r28 = new ReferenceMessage(null, r1.displayContent, null, false, false, 0, null, null, 253, null);
            r30 = r1.referencedMessageId;
            if (r30 != null) goto L22;
        L25:
            boolean r35 = true;
        L26:
            if (r35 == false) goto L28;
        L59:
            return r28;
        L28:
            if (Intrinsics.areEqual(r30, "0") == true) goto L59;
            IChatRepoService r36 = zh8.a.a;     // Catch: Exception -> L60
            r3.L$0 = r1;     // Catch: Exception -> L60
            r3.L$1 = r28;     // Catch: Exception -> L60
            r3.L$2 = r30;     // Catch: Exception -> L60
            r3.label = 1;     // Catch: Exception -> L60
            r31 = r36.E1(r30, r3);     // Catch: Exception -> L60
            if (r31 != r5) goto L33;
            return r5;
        L22:
            if (r30.length() == 0) goto L25;
            r35 = false;
        L7:
            r3 = new ReferenceMessage$Companion$build$8(this, r24);
            goto L8
        }

        public static ReferenceMessage a(ReferenceInfo r22, Message r23, BotModel r24) {
            Intrinsics.checkNotNullParameter(r22, "info");
            ReferenceMessage r1 = new ReferenceMessage(null, r22.displayContent, null, false, false, 0, null, null, 253, null);
            String r14 = r22.referencedMessageId;
            if (r23 != null) goto L5;
        L46:
            FLogger.a.i("BotUtils", "ref message not found, use default");
            return r1;
        L5:
            if (r14 != null) goto L7;
        L10:
            boolean r3 = true;
        L11:
            if (r3 == true) goto L46;
            if (Intrinsics.areEqual(r14, "0") == true) goto L46;
            ReferenceMessage r2 = (ReferenceMessage) ReferenceMessage.access$getRefMessageCache$cp().get(r14);
            if (r2 == null) goto L18;
            return r2;
        L18:
            boolean r18 = com.larus.bmhome.chat.bean.d.U(r23);
            if (r18 == false) goto L23;
            String r4 = r22.displayContent;
            if (r4 != null) goto L24;
            String r15 = "";
        L25:
            String r5 = r23.getReplyId();
            if (r5 != null) goto L28;
        L30:
            r5 = null;
        L31:
            if (r5 != null) goto L33;
            String r21 = "";
        L34:
            String r6 = r24.getName();
            if (r6 != null) goto L37;
            String r16 = "";
        L38:
            boolean r17 = com.larus.bmhome.chat.bean.d.G0(r23);
            int r7 = r22.searchIndex;
            JSONObject r8 = new JSONObject();
            Map r0 = r22.ext;
            if (r0 == null) goto L45;
            Iterator r9 = r0.entrySet().iterator();
        L42:
            if (r9.hasNext() == false) goto L45;
            Map.Entry r10 = (Map.Entry) r9.next();
            r8.put((String) r10.getKey(), r10.getValue());
        L45:
            return new ReferenceMessage(r14, r15, r16, r17, r18, r7, r8.toString(), r21);
        L37:
            r16 = r6;
            goto L38
        L33:
            r21 = r5;
            goto L34
        L28:
            if ((true ^ Intrinsics.areEqual(r5, "0")) == false) goto L30;
        L24:
            r15 = r4;
            goto L25
        L23:
            r4 = AppHost.a.getApplication().getString(2131908670);
            goto L24
        L7:
            if (r14.length() == 0) goto L10;
            r3 = false;
            goto L11
        }

        /* JADX WARN: Type inference failed for: r7v0, types: [com.larus.bmhome.utils.m3] */
        public final Object b(Message r27, Map<String, String> r28, Continuation<? super ReferenceMessage> r29) {
            if ((r29 instanceof ReferenceMessage$Companion$build$1) == false) goto L7;
            ReferenceMessage$Companion$build$1 r2 = (ReferenceMessage$Companion$build$1) r29;
            int r3 = r2.label;
            if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
            r2.label = r3 - Integer.MIN_VALUE;
        L8:
            Object r0 = r2.result;
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r4 = r2.label;
            String r14 = "";
            if (r4 == 0) goto L16;
            if (r4 == 1) goto L15;
            if (r4 != 2) goto L14;
            String r5 = (String) r2.L$4;
            String r6 = (String) r2.L$3;
            String r7 = (String) r2.L$2;
            Map<String, String> r8 = (Map) r2.L$1;
            Message r9 = (Message) r2.L$0;
            ResultKt.throwOnFailure(r0);
            String r11 = r5;
        L70:
            String r12 = (String) r0;
            boolean r13 = com.larus.bmhome.chat.bean.d.G0(r9);
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L81
            int r15 = com.larus.utils.p0.a;     // Catch: Throwable -> L81
            Map r16 = r9.getBusinessExt();     // Catch: Throwable -> L81
            if (r16 == null) goto L74;
            String r17 = (String) r16.get("search_index");     // Catch: Throwable -> L81
        L75:
            String r18 = com.larus.utils.p0.a(r17);     // Catch: Throwable -> L81
            if (r18 == null) goto L78;
            int r19 = CastIntegerProtector.parseInt(r18);     // Catch: Throwable -> L81
        L79:
            Object r20 = Result.constructor-impl(Boxing.boxInt(r19));     // Catch: Throwable -> L81
        L84:
            if (Result.exceptionOrNull-impl(r20) == null) goto L87;
            r20 = Boxing.boxInt(0);
        L87:
            int r21 = ((Number) r20).intValue();
            JSONObject r22 = new JSONObject();
            Map r23 = r9.getExt();
            if (r23 == null) goto L90;
            r22.put("deep_research_phase", r23.get("deep_research_phase"));
        L90:
            if (r8 == null) goto L96;
            Iterator<Map.Entry<String, String>> r24 = r8.entrySet().iterator();
        L93:
            if (r24.hasNext() == false) goto L96;
            Map.Entry<String, String> r25 = r24.next();
            r22.put(r25.getKey(), r25.getValue());
        L96:
            return new ReferenceMessage(r6, r7, r12, r13, true, r21, r22.toString(), r11);
        L78:
            r19 = 0;
            goto L79
        L74:
            r17 = null;
        L81:
            th = move-exception;
            Result.Companion r26 = Result.Companion;
            r20 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L84
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            Map<String, String> r30 = (Map) r2.L$1;
            Message r31 = (Message) r2.L$0;
            ResultKt.throwOnFailure(r0);
            Map<String, String> r110 = r30;
        L24:
            List r32 = (List) r0;
            if (r32 == null) goto L28;
            String r33 = CollectionsKt.joinToString$default(r32, "", null, null, 0, null, new n3(), 30, null);
        L56:
            r7 = r33;
        L57:
            String r34 = r31.getMessageId();
            String r35 = r31.getReplyId();
            if (r35 != null) goto L60;
        L62:
            r35 = null;
        L63:
            if (r35 == null) goto L66;
            r14 = r35;
        L66:
            r2.L$0 = r31;
            r2.L$1 = r110;
            r2.L$2 = r7;
            r2.L$3 = r34;
            r2.L$4 = r14;
            r2.label = 2;
            Object r36 = d(r31, true, r2);
            if (r36 != r10) goto L69;
            return r10;
        L69:
            r11 = r14;
            r8 = r110;
            Message r210 = r31;
            r6 = r34;
            r0 = r36;
            r9 = r210;
            goto L70
        L60:
            if ((!Intrinsics.areEqual(r35, "0")) == false) goto L62;
        L28:
            r7 = null;
            goto L57
        L16:
            ResultKt.throwOnFailure(r0);
            if (com.larus.im.bean.message.a.b0(r27) == false) goto L29;
            com.larus.bmhome.chat.layout.holder.helper.s0 r37 = ILegacyChatUiServiceDelegate.b.X8();
            if (r37 == null) goto L27;
            Application r38 = AppHost.a.getApplication();
            List r39 = com.larus.im.bean.message.a.A(r27);
            ?? r40 = new m3();
            r2.L$0 = r27;
            r110 = r28;
            r2.L$1 = r110;
            r2.label = 1;
            r0 = com.larus.bmhome.chat.layout.holder.helper.s0.a.c(r37, r38, r39, true, r40, r2, 56);
            if (r0 != r10) goto L23;
            return r10;
        L23:
            r31 = r27;
            goto L24
        L27:
            r110 = r28;
            r31 = r27;
            goto L28
        L29:
            r110 = r28;
            String r41 = r27.getContent();
            if (r41 != null) goto L32;
        L52:
            r33 = null;
        L53:
            r31 = r27;
            if (r33 != null) goto L56;
            r7 = "";
            goto L57
        L32:
            if (r41.length() <= 0) goto L34;
            boolean r42 = true;
        L35:
            if (r42 == true) goto L38;
            r41 = null;
        L38:
            if (r41 == null) goto L52;
            if (StringsKt.isBlank(r41) == false) goto L97;
        L48:
            Object r43 = null;
        L49:
            TextContent r44 = (TextContent) r43;
            if (r44 == null) goto L52;
            r33 = r44.text;
            goto L53
        L97:
            Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L44
            r43 = Result.constructor-impl(HttpExtKt.f.fromJson(r41, TextContent.class));     // Catch: Throwable -> L44
        L47:
            if (Result.isFailure-impl(r43) == false) goto L49;
        L44:
            th = move-exception;
            Result.Companion r46 = Result.Companion;
            r43 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L47
        L34:
            r42 = false;
        L7:
            r2 = new ReferenceMessage$Companion$build$1(this, r29);
            goto L8
        }

        public final Object d(Message r6, boolean r7, Continuation<? super String> r8) {
            if ((r8 instanceof ReferenceMessage$Companion$getBotName$1) == false) goto L7;
            ReferenceMessage$Companion$getBotName$1 r0 = (ReferenceMessage$Companion$getBotName$1) r8;
            int r1 = r0.label;
            if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
            r0.label = r1 - Integer.MIN_VALUE;
        L8:
            Object r9 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            boolean r4 = true;
            String r5 = "";
            if (r3 == 0) goto L16;
            if (r3 != 1) goto L15;
            r6 = (Message) r0.L$0;
            ResultKt.throwOnFailure(r9);     // Catch: Exception -> L35
        L29:
            BotModel r10 = (BotModel) r9;     // Catch: Exception -> L35
            if (r10 == null) goto L37;
            String r11 = r10.getName();     // Catch: Exception -> L35
            if (r11 == null) goto L37;
            r5 = r11;
            goto L37
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L16:
            ResultKt.throwOnFailure(r9);
            if (r6 != null) goto L19;
            return "";
        L19:
            if (r7 == false) goto L23;
            String r12 = r6.getConversationId();
            String r13 = (String) ReferenceMessage.access$getBotNameCache$cp().get(r12);
            if (r13 == null) goto L23;
            return r13;
        L23:
            IChatRepoService r14 = zh8.a.a;     // Catch: Exception -> L35
            IChatRepoService r15 = zh8.a.a;     // Catch: Exception -> L35
            String r16 = r6.getMessageId();     // Catch: Exception -> L35
            if (r16 != null) goto L26;
            r16 = "";
        L26:
            r0.L$0 = r6;     // Catch: Exception -> L35
            r0.label = 1;     // Catch: Exception -> L35
            r9 = r15.F1(r16, r0);     // Catch: Exception -> L35
            if (r9 != r2) goto L29;
            return r2;
        L37:
            if (r5.length() == 0) goto L40;
            r4 = false;
        L40:
            if (r4 == false) goto L42;
            return r5;
        L42:
            String r17 = r6.getConversationId();
            if (r17 == null) goto L45;
            ReferenceMessage.access$getBotNameCache$cp().put(r17, r5);
        L45:
            return r5;
        L7:
            r0 = new ReferenceMessage$Companion$getBotName$1(this, r8);
            goto L8
        }
    }

    public static final class a {
        public Function0<Unit> a;
        public ReferenceMessage b;
        public String c;
        public String d;
        public String e;

        /* JADX INFO: renamed from: com.larus.bmhome.utils.ReferenceMessage$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0042a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[RefEntranceType.values().length];
                r0[RefEntranceType.ChooseTextAutoCite.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
            L15:
                r0[RefEntranceType.LongPressAnswerMore.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
            L23:
                r0[RefEntranceType.LongPressAndChooseText.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
            L17:
                r0[RefEntranceType.ClickMarkDownLink.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
            L19:
                r0[RefEntranceType.TaskCardQuestion.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
            L8:
                a = r0;
            }
        }

        public a() {
            this.a = new p3();
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.utils.ReferenceMessage$update$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.utils.ReferenceMessage", f = "ReferenceMessage.kt", i = {}, l = {270}, m = "update", n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ReferenceMessage this$0;

        public AnonymousClass1(ReferenceMessage r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.update(this);
        }
    }

    public ReferenceMessage() {
        this(null, null, null, false, false, 0, null, null, 255, null);
    }

    public static /* synthetic */ Gson a() {
        return convert_delegate$lambda$4();
    }

    public static /* synthetic */ String b(ReferenceMessage r0) {
        return toJsonString$lambda$0(r0);
    }

    public static /* synthetic */ ReferenceMessage copy$default(ReferenceMessage r9, String r10, String r11, String r12, boolean r13, boolean r14, int r15, String r16, String r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r2 = r9.messageId;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = r9.content;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = r9.senderName;
    L15:
        if ((r18 & 8) == 0) goto L17;
        boolean r5 = r9.self;
    L19:
        if ((r18 & 16) == 0) goto L21;
        boolean r6 = r9.exist;
    L23:
        if ((r18 & 32) == 0) goto L25;
        int r7 = r9.searchIndex;
    L27:
        if ((r18 & 64) == 0) goto L29;
        String r8 = r9.refExt;
    L31:
        if ((r18 & 128) == 0) goto L33;
        String r1 = r9.replyId;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    @Transient
    public static /* synthetic */ void getReplyId$annotations() {
    }

    public final String component1() {
        return this.messageId;
    }

    public final String component2() {
        return this.content;
    }

    public final String component3() {
        return this.senderName;
    }

    public final boolean component4() {
        return this.self;
    }

    public final boolean component5() {
        return this.exist;
    }

    public final int component6() {
        return this.searchIndex;
    }

    public final String component7() {
        return this.refExt;
    }

    public final String component8() {
        return this.replyId;
    }

    public final ReferenceMessage copy(String r11, String r12, String r13, boolean r14, boolean r15, int r16, String r17, String r18) {
        return new ReferenceMessage(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ReferenceMessage) == true) goto L8;
        return false;
    L8:
        ReferenceMessage r6 = (ReferenceMessage) r5;
        if (Intrinsics.areEqual(this.messageId, r6.messageId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.senderName, r6.senderName) == true) goto L18;
        return false;
    L18:
        if (this.self == r6.self) goto L21;
        return false;
    L21:
        if (this.exist == r6.exist) goto L24;
        return false;
    L24:
        if (this.searchIndex == r6.searchIndex) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.refExt, r6.refExt) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.replyId, r6.replyId) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        String r0 = this.messageId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.content;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.senderName;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        int r10 = 1231;
        if (this.self == false) goto L17;
        int r11 = 1231;
    L18:
        int r12 = (r9 + r11) * 31;
        if (this.exist == true) goto L22;
        r10 = 1237;
    L22:
        int r13 = (((r12 + r10) * 31) + this.searchIndex) * 31;
        String r14 = this.refExt;
        if (r14 != null) goto L25;
        int r15 = 0;
    L26:
        int r16 = (r13 + r15) * 31;
        String r17 = this.replyId;
        if (r17 == null) goto L31;
        r1 = r17.hashCode();
    L31:
        return r16 + r1;
    L25:
        r15 = r14.hashCode();
        goto L26
    L17:
        r11 = 1237;
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

    public String toString() {
        return "ReferenceMessage(messageId=" + this.messageId + ", content=" + this.content + ", senderName=" + this.senderName + ", self=" + this.self + ", exist=" + this.exist + ", searchIndex=" + this.searchIndex + ", refExt=" + this.refExt + ", replyId=" + this.replyId + ')';
    }

    static {
        Companion = new Companion();
        convert$delegate = LazyKt.lazy(new l3());
        botNameCache = new LinkedHashMap();
        refMessageCache = new LinkedHashMap();
        EMPTY_REFERENCE_MESSAGE = new ReferenceMessage("", "", "", false, false, 0, null, null, 224, null);
    }

    private static final Gson convert_delegate$lambda$4() {
        return new Gson();
    }

    private final Map<String, String> getRefExtFromString() {
        if (this.refExt != null) goto L26;
        return null;
    L26:
        LinkedHashMap r3 = new LinkedHashMap();     // Catch: JSONException -> L25
        JSONObject r5 = new JSONObject(this.refExt);     // Catch: JSONException -> L25
        Object r6 = r5.opt("deep_research_phase");     // Catch: JSONException -> L25
        if ((r6 instanceof String) == false) goto L8;
        String r7 = (String) r6;     // Catch: JSONException -> L25
    L9:
        if (r7 == null) goto L11;
        r3.put("deep_research_phase", r7);     // Catch: JSONException -> L25
    L11:
        r3.put("ref_msg_is_self", String.valueOf(this.self));     // Catch: JSONException -> L25
        Object r2 = r5.opt("ref_icon_key");     // Catch: JSONException -> L25
        if ((r2 instanceof String) == false) goto L14;
        String r4 = (String) r2;     // Catch: JSONException -> L25
    L15:
        if (r4 == null) goto L17;
        r3.put("ref_icon_key", r4);     // Catch: JSONException -> L25
    L17:
        Object r1 = r5.opt("general_task_param");     // Catch: JSONException -> L25
        if ((r1 instanceof String) == false) goto L20;
        String r8 = (String) r1;     // Catch: JSONException -> L25
    L21:
        if (r8 == null) goto L24;
        r3.put("general_task_param", r8);     // Catch: JSONException -> L25
    L24:
        return r3;
    L20:
        r8 = null;
        goto L21
    L14:
        r4 = null;
        goto L15
    L8:
        r7 = null;
    L28:
        return null;
    }

    public final ReferenceInfo getReferenceInfo() {
        String r3 = this.messageId;
        String r8 = this.replyId;
        return new ReferenceInfo(1, this.content, r3, this.searchIndex, null, getRefExtFromString(), null, r8, 80, null);
    }

    public final String getReferenceReply() {
        String r0 = this.content;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public final String toJsonString() {
        return (String) com.larus.utils.l0.a("", new k3(this));
    }

    public static final /* synthetic */ Map access$getBotNameCache$cp() {
        return botNameCache;
    }

    public static final /* synthetic */ Lazy access$getConvert$delegate$cp() {
        return convert$delegate;
    }

    public static final /* synthetic */ ReferenceMessage access$getEMPTY_REFERENCE_MESSAGE$cp() {
        return EMPTY_REFERENCE_MESSAGE;
    }

    public static final /* synthetic */ Map access$getRefMessageCache$cp() {
        return refMessageCache;
    }

    public final String getContent() {
        return this.content;
    }

    public final boolean getExist() {
        return this.exist;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getRefExt() {
        return this.refExt;
    }

    public final String getReplyId() {
        return this.replyId;
    }

    public final int getSearchIndex() {
        return this.searchIndex;
    }

    public final boolean getSelf() {
        return this.self;
    }

    public final String getSenderName() {
        return this.senderName;
    }

    private static final String toJsonString$lambda$0(ReferenceMessage r1) {
        Companion.getClass();
        return GsonProtectorUtils.toJson((Gson) access$getConvert$delegate$cp().getValue(), r1);
    }

    public final void setReplyId(String r1) {
        this.replyId = r1;
    }

    public final Object update(Continuation<? super ReferenceMessage> r12) {
        if ((r12 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r1 = (AnonymousClass1) r12;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        Message r5 = null;
        if (r4 == 0) goto L15;
        if (r4 != 1) goto L14;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L30
    L28:
        r5 = (Message) r0;     // Catch: Exception -> L30
        goto L31
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r0);
        String r6 = this.messageId;     // Catch: Exception -> L30
        if (r6 != null) goto L19;
    L22:
        boolean r7 = true;
    L23:
        if (r7 == true) goto L31;
        IChatRepoService r8 = zh8.a.a;     // Catch: Exception -> L30
        IChatRepoService r9 = zh8.a.a;     // Catch: Exception -> L30
        String r10 = this.messageId;     // Catch: Exception -> L30
        r1.label = 1;     // Catch: Exception -> L30
        r0 = r9.E1(r10, r1);     // Catch: Exception -> L30
        if (r0 != r3) goto L28;
        return r3;
    L19:
        if (r6.length() == 0) goto L22;
        r7 = false;
    L31:
        boolean r11 = com.larus.bmhome.chat.bean.d.U(r5);
        if (r11 == false) goto L34;
        String r13 = this.content;
    L36:
        return copy$default(this, null, r13, null, false, r11, 0, null, null, 237, null);
    L34:
        r13 = AppHost.a.getApplication().getString(2131908670);
    L7:
        r1 = new AnonymousClass1(this, r12);
        goto L8
    }

    public ReferenceMessage(String r1, String r2, String r3, boolean r4, boolean r5, int r6, String r7, String r8) {
        this.messageId = r1;
        this.content = r2;
        this.senderName = r3;
        this.self = r4;
        this.exist = r5;
        this.searchIndex = r6;
        this.refExt = r7;
        this.replyId = r8;
    }

    public /* synthetic */ ReferenceMessage(String r10, String r11, String r12, boolean r13, boolean r14, int r15, String r16, String r17, int r18, DefaultConstructorMarker r19) {
        String r2 = null;
        if ((r18 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = null;
    L14:
        int r6 = 0;
        if ((r18 & 8) == 0) goto L17;
        boolean r5 = false;
    L19:
        if ((r18 & 16) == 0) goto L21;
        boolean r7 = false;
    L23:
        if ((r18 & 32) != 0) goto L27;
        r6 = r15;
    L27:
        if ((r18 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r18 & 128) != 0) goto L34;
        r2 = r17;
    L34:
        this(r1, r3, r4, r5, r7, r6, r8, r2);
        return;
    L29:
        r8 = r16;
        goto L31
    L21:
        r7 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L14
    L9:
        r3 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }
}
