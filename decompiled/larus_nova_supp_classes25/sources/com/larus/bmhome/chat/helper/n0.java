package com.larus.bmhome.chat.helper;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.api.IMessageExtService;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.instruction.core.model.ActiveSwitchType;
import com.larus.bmhome.utils.w2;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.legacy.NativeMessageServiceImpl;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.p0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n0 {
    public static final n0 a = null;

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/im/internal/core/util/GsonHolder$fromJson$1$1", "Lcom/google/gson/reflect/TypeToken;", "runtime_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class a extends TypeToken<HashMap<String, String>> {
        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/im/internal/core/util/GsonHolder$fromJson$1$1", "Lcom/google/gson/reflect/TypeToken;", "runtime_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class b extends TypeToken<HashMap<String, String>> {
        public b() {
        }
    }

    public static final class c implements IIMCallback<Boolean> {
        public final /* synthetic */ Message a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;

        public final boolean mustInMain() {
            return true;
        }

        public final void onFailure(IIMError r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            Intrinsics.checkNotNullParameter(r4, "error");
            FLogger.a.i("ShootMultiQuestionsHelper", "requestSubMessage(" + this.c + ", index = " + this.b + "): failed, error = " + r4);
        }

        public final void onSuccess(Object r3) {
            ((Boolean) r3).booleanValue();
            IAIChatControlTraceService.a.cb(this.a.getMessageId() + this.b);
            FLogger.a.i("ShootMultiQuestionsHelper", "requestSubMessage(" + this.c + ", index = " + this.b + "): success");
        }

        public c(Message r1, int r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
        a = new n0();
    }

    public n0() {
    }

    public static String a(Message r3) {
        int r0 = p0.a;
        Map r4 = r3.getExt();
        if (r4 == null) goto L5;
        String r5 = (String) r4.get("edu_params");
    L6:
        JSONObject r6 = p0.b(r5);
        if (r6.has("is_perspective_corrected") == true) goto L10;
        return null;
    L10:
        if (r6.optBoolean("is_perspective_corrected") == false) goto L12;
        return "1";
    L12:
        return "0";
    L5:
        r5 = null;
        goto L6
    }

    public static String b(Map r2) {
        int r0 = p0.a;
        if (r2 == null) goto L5;
        String r3 = (String) r2.get("Copilot:hippo:hippo_ext");
    L6:
        String r4 = p0.b(p0.b(r3).optString("data")).optString("is_perspective_corrected");
        if (Intrinsics.areEqual(r4, "0") == false) goto L9;
    L12:
        boolean r1 = true;
    L13:
        if (r1 == true) goto L15;
        return null;
    L15:
        return r4;
    L9:
        if (Intrinsics.areEqual(r4, "1") == true) goto L12;
        r1 = false;
        goto L13
    L5:
        r3 = null;
        goto L6
    }

    public static boolean d(Message r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        ConcurrentHashMap r0 = w2.a;
        int r1 = w2.a(r4.getMessageId());
        String r2 = r4.getMessageId();
        List r5 = r4.getSubList();
        if (r5 != null) goto L6;
        FLogger.a.i("ShootMultiQuestionsHelper", r2 + " is not a parent message");
        return false;
    L6:
        if (r1 >= 0) goto L8;
    L17:
        FLogger.a.i("ShootMultiQuestionsHelper", "index out of bounds");
        return false;
    L8:
        if (r1 >= r5.size()) goto L17;
        Message r6 = (Message) CollectionsKt.getOrNull(r5, r1);
        if (r6 != null) goto L13;
    L16:
        return false;
    L13:
        if (r6.getMessageStatusLocal() != 21) goto L16;
        return true;
    }

    public static boolean e(Message r7) {
        Object r0 = null;
        if (r7 == null) goto L7;
        Map r8 = r7.getExt();
        if (r8 == null) goto L7;
        String r9 = (String) r8.get("sub_message_ext");
    L8:
        zd9.h r1 = zd9.h.a;
        if (r9 != null) goto L11;
    L14:
        boolean r4 = true;
    L15:
        if (r4 == false) goto L36;
    L28:
        Map r2 = (Map) r0;
        if (r2 != null) goto L31;
        r2 = MapsKt.emptyMap();
    L31:
        Map r10 = MapsKt.toMutableMap(r2);
        int r3 = p0.a;
        if (p0.b(p0.b((String) r10.get("Copilot:hippo:hippo_ext")).optString("data")).optInt("detection_type") == 2) goto L38;
        return false;
    L38:
        return true;
    L36:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L19
        r1.getClass();     // Catch: Throwable -> L19
        Object r11 = Result.constructor-impl(zd9.h.b.fromJson(r9, new a().getType()));     // Catch: Throwable -> L19
    L21:
        Throwable r6 = Result.exceptionOrNull-impl(r11);
        if (r6 == null) goto L25;
        com.larus.im.internal.delegate.c0 r12 = com.larus.im.internal.delegate.c0.b;
        StringBuilder r13 = new StringBuilder("fromJson failed, stack: ");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        r13.append(ExceptionsKt.stackTraceToString(r6));
        r12.e("GsonHolder", r13.toString());
    L25:
        if (Result.isFailure-impl(r11) == true) goto L28;
        r0 = r11;
    L19:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    L11:
        if (StringsKt.isBlank(r9) == true) goto L14;
        r4 = false;
    L7:
        r9 = null;
        goto L8
    }

    public static boolean f(Map r1) {
        int r0 = p0.a;
        if (r1 == null) goto L5;
        String r2 = (String) r1.get("Copilot:hippo:hippo_ext");
    L7:
        if (p0.b(p0.b(r2).optString("data")).optInt("detection_type") != 2) goto L9;
        return true;
    L9:
        return false;
    L5:
        r2 = null;
        goto L7
    }

    public static boolean g(Map r1) {
        int r0 = p0.a;
        if (r1 == null) goto L5;
        String r2 = (String) r1.get("Copilot:hippo:hippo_ext");
    L7:
        if (p0.b(p0.b(r2).optString("data")).optInt("detection_type") == 1) goto L11;
        return false;
    L11:
        return true;
    L5:
        r2 = null;
        goto L7
    }

    public static String h(Map r1) {
        int r0 = p0.a;
        if (r1 == null) goto L5;
        String r2 = (String) r1.get("Copilot:hippo:hippo_ext");
    L7:
        return p0.b(p0.b(r2).optString("data")).optString("origin_path");
    L5:
        r2 = null;
        goto L7
    }

    public static void i(Message r16, int r17) {
        Intrinsics.checkNotNullParameter(r16, "parent");
        String r0 = r16.getMessageId();
        String r3 = "";
        if (r0 != null) goto L5;
        String r4 = "";
    L6:
        List r1 = r16.getSubList();
        if (r1 != null) goto L10;
        FLogger.a.i("ShootMultiQuestionsHelper", r4.concat(" is not a parent message"));
        return;
    L10:
        if (r17 >= 0) goto L12;
    L89:
        FLogger.a.i("ShootMultiQuestionsHelper", "index out of bounds");
        return;
    L12:
        if (r17 >= r1.size()) goto L89;
        Message r2 = (Message) CollectionsKt.getOrNull(r1, r17);
        boolean r6 = false;
        if (r2 != null) goto L17;
    L32:
        Map r5 = r16.getExt();
        if (r5 == null) goto L35;
        String r7 = (String) r5.get("sub_message_ext");
    L36:
        Map r10 = r16.getExt();
        if (r10 == null) goto L39;
        String r11 = (String) r10.get("next_sub_message_upstream_hippo_ext");
    L40:
        zd9.h r12 = zd9.h.a;
        if (r7 != null) goto L43;
    L44:
        r6 = true;
    L45:
        if (r6 == false) goto L91;
    L56:
        Object r8 = null;
    L57:
        Map r9 = (Map) r8;
        if (r9 != null) goto L60;
        r9 = MapsKt.emptyMap();
    L60:
        Map<String, String> r13 = MapsKt.toMutableMap(r9);
        int r14 = p0.a;
        JSONObject r15 = p0.b(r13.get("Copilot:hippo:hippo_ext"));
        JSONObject r18 = p0.b(r15.optString("data"));
        r18.put("search_index", r17);
        r18.put("refer_msg_id", r16.getReplyId());
        if (r11 == null) goto L67;
        JSONObject r19 = p0.b(r11);
        if (r19 == null) goto L67;
        if (r19.optInt("picture_source", -1) == (-1)) goto L67;
        r18.remove("picture_source");
        r18.put("picture_source", r19.optInt("picture_source"));
    L67:
        r15.put("data", r18.toString());
        r13.put("Copilot:hippo:hippo_ext", r15.toString());
        com.larus.bmhome.instruction.i r20 = ILegacyChatUiServiceDelegate.b.I8();
        if (r20 == null) goto L78;
        String r21 = r16.getSenderId();
        if (r21 != null) goto L72;
        r21 = "";
    L72:
        ReplyOption r22 = r20.a(r21, ActiveSwitchType.DEEPTHINK.getValue());
        if (r22 == null) goto L78;
        ModelItemIdentity r23 = r22.getModel();
        if (r23 == null) goto L78;
        String r24 = Integer.valueOf(r23.getDeprecatedItemId()).toString();
        if (r24 == null) goto L78;
    L79:
        r13.put("need_deep_think", r24);
        Iterator r25 = ServiceManager.get().getServices(IMessageExtService.class, true).iterator();
    L81:
        if (r25.hasNext() == false) goto L83;
        ((IMessageExtService) r25.next()).a(r13, null, null);
        goto L81
    L83:
        FLogger.a.i("ShootMultiQuestionsHelper", "requestSubMessage(" + r4 + ", index = " + r17 + "): begin");
        NativeMessageServiceImpl r26 = com.larus.im.d.e();
        r13.put("is_sub_msg", "true");
        r13.put("edu_multi_answers_msg_id", r4);
        String r27 = r16.getReplyId();
        if (r27 == null) goto L87;
        r3 = r27;
    L87:
        r13.put("question_msg_id", r3);
        r13.put("sub_msg_index", String.valueOf(r17));
        r13.put("tts", "1");
        Unit r28 = Unit.INSTANCE;
        r26.requestSubMessage(r16, r17, r13, new c(r16, r17, r4));
        return;
    L78:
        r24 = "";
        goto L79
    L91:
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L49
        r12.getClass();     // Catch: Throwable -> L49
        r8 = Result.constructor-impl(zd9.h.b.fromJson(r7, new b().getType()));     // Catch: Throwable -> L49
    L51:
        Throwable r30 = Result.exceptionOrNull-impl(r8);
        if (r30 == null) goto L55;
        com.larus.im.internal.delegate.c0 r110 = com.larus.im.internal.delegate.c0.b;
        StringBuilder r111 = new StringBuilder("fromJson failed, stack: ");
        Intrinsics.checkNotNullParameter(r30, "<this>");
        r111.append(ExceptionsKt.stackTraceToString(r30));
        r110.e("GsonHolder", r111.toString());
    L55:
        if (Result.isFailure-impl(r8) == false) goto L57;
    L49:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L51
    L43:
        if (StringsKt.isBlank(r7) == false) goto L45;
    L39:
        r11 = null;
        goto L40
    L35:
        r7 = null;
        goto L36
    L17:
        if (r2.getMessageStatusLocal() != 22) goto L19;
    L23:
        String r32 = r2.getMessageId();
        if (r32 != null) goto L26;
    L28:
        boolean r33 = false;
    L29:
        if (r33 == true) goto L32;
        FLogger.a.i("ShootMultiQuestionsHelper", "sub message is fake #: parent = " + r4 + ", index = " + r17);
        return;
    L26:
        if (StringsKt.contains$default(r32, "#", false, 2, null) != true) goto L28;
        r33 = true;
        goto L29
    L19:
        if (r2.getMessageStatusLocal() == 20) goto L23;
        FLogger.a.i("ShootMultiQuestionsHelper", "sub message has exist: parent = " + r4 + ", index = " + r17);
        return;
    L5:
        r4 = r0;
        goto L6
    }

    public static Map j(Map r10, mr9.l r11) {
        Intrinsics.checkNotNullParameter(r11, "resourceUploadResult");
        if (r10 != null) goto L6;
        return null;
    L6:
        Map r0 = MapsKt.toMutableMap(r10);
        int r1 = p0.a;
        JSONObject r12 = p0.b((String) r10.get("Copilot:hippo:hippo_ext"));
        JSONObject r3 = p0.b(r12.optString("data"));
        JSONArray r4 = new JSONArray();
        JSONObject r5 = new JSONObject();
        String r6 = r11.a;
        if (r6 != null) goto L9;
        r6 = "";
    L9:
        r5.put("image_uri", r6);
        mr9.d r7 = r11.d;
        if (r7 == null) goto L12;
        Object r8 = Integer.valueOf(r7.b);
    L13:
        r5.put("width", r8);
        mr9.d r13 = r11.d;
        if (r13 == null) goto L16;
        Object r14 = Integer.valueOf(r13.a);
    L17:
        r5.put("height", r14);
        r4.put(r5);
        Unit r15 = Unit.INSTANCE;
        r3.put("images", r4);
        r3.put("search_index", -1);
        r12.put("data", r3.toString());
        r0.put("Copilot:hippo:hippo_ext", r12.toString());
        return r0;
    L16:
        r14 = 0L;
        goto L17
    L12:
        r8 = 0L;
        goto L13
    }

    public static Map k(Map r5, mr9.l r6) {
        Intrinsics.checkNotNullParameter(r6, "resourceUploadResult");
        if (r5 != null) goto L6;
        return null;
    L6:
        Map r0 = MapsKt.toMutableMap(r5);
        int r1 = p0.a;
        JSONObject r7 = p0.b((String) r5.get("Copilot:hippo:hippo_ext"));
        JSONObject r3 = p0.b(r7.optString("data"));
        String r8 = r6.a;
        if (r8 != null) goto L9;
        r8 = "";
    L9:
        r3.put("origin_image_uri", r8);
        r7.put("data", r3.toString());
        r0.put("Copilot:hippo:hippo_ext", r7.toString());
        return r0;
    }

    public static boolean c(Map r10, Message r11, int r12, String r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r10, "extra");
        Object r0 = null;
        if (r11 == null) goto L7;
        Map r1 = r11.getExt();
        if (r1 == null) goto L7;
        String r2 = (String) r1.get("intention");
    L9:
        if (Intrinsics.areEqual(r2, "intention_edu") == false) goto L41;
        if (r11 == null) goto L14;
        Map r3 = r11.getExt();
        if (r3 == null) goto L14;
        String r4 = (String) r3.get("sub_message_ext");
    L15:
        zd9.h r6 = zd9.h.a;
        if (r4 != null) goto L18;
    L21:
        boolean r7 = true;
    L22:
        if (r7 == false) goto L71;
    L35:
        Map r5 = (Map) r0;
        if (r5 != null) goto L38;
        r5 = MapsKt.emptyMap();
    L38:
        Map r8 = MapsKt.toMutableMap(r5);
        int r9 = p0.a;
        if (p0.b(p0.b((String) r8.get("Copilot:hippo:hippo_ext")).optString("data")).optInt("picture_source") == 0) goto L41;
        boolean r15 = true;
    L42:
        if (r15 == false) goto L70;
        if (r14 == false) goto L70;
        if (r11 == null) goto L64;
        String r16 = r11.getMessageId();
        if (r16 != null) goto L48;
        r16 = "";
    L48:
        r10.put("edu_multi_answers_msg_id", r16);
        if (Intrinsics.areEqual(r13, "reference_input") == false) goto L60;
        List r17 = r11.getSubList();
        if (r17 == null) goto L60;
        if (r12 >= r17.size()) goto L60;
        JSONObject r18 = new JSONObject();
        Message r19 = (Message) ListProtector.get(r17, r12);
        if (r19 == null) goto L58;
        String r110 = r19.getMessageId();
        if (r110 == null) goto L58;
    L59:
        r18.put("msg_id", r110);
        r10.put("from_text_click", r18.toString());
    L58:
        r110 = r11.getMessageId();
    L60:
        JSONObject r111 = new JSONObject();
        JSONObject r20 = new JSONObject();
        r20.put("search_index", r12);
        r20.put("refer_msg_id", r11.getReplyId());
        if (r13 == null) goto L63;
        r20.put("send_msg_scene", r13);
    L63:
        Unit r112 = Unit.INSTANCE;
        r111.put("data", r20.toString());
        r10.put("Copilot:hippo:hippo_ext", r111.toString());
    L64:
        if (r11 != null) goto L66;
    L68:
        return false;
    L66:
        if (com.larus.bmhome.chat.bean.d.x0(r11) != true) goto L68;
        return true;
    L70:
        return false;
    L71:
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L26
        r6.getClass();     // Catch: Throwable -> L26
        Object r22 = Result.constructor-impl(zd9.h.b.fromJson(r4, new m0().getType()));     // Catch: Throwable -> L26
    L28:
        Throwable r23 = Result.exceptionOrNull-impl(r22);
        if (r23 == null) goto L32;
        com.larus.im.internal.delegate.c0 r24 = com.larus.im.internal.delegate.c0.b;
        StringBuilder r25 = new StringBuilder("fromJson failed, stack: ");
        Intrinsics.checkNotNullParameter(r23, "<this>");
        r25.append(ExceptionsKt.stackTraceToString(r23));
        r24.e("GsonHolder", r25.toString());
    L32:
        if (Result.isFailure-impl(r22) == true) goto L35;
        r0 = r22;
    L26:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r22 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    L18:
        if (StringsKt.isBlank(r4) == true) goto L21;
        r7 = false;
    L14:
        r4 = null;
    L41:
        r15 = false;
    L7:
        r2 = null;
        goto L9
    }
}
