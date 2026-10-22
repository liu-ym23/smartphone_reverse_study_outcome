package com.larus.bmhome.chat.component.list.pipeline.pre_dependent;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.helper.n0;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.bmhome.social.userchat.model.z;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.internal.delegate.c0;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.p0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a implements td8.c {
    public final td8.d a;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.list.pipeline.pre_dependent.a$a, reason: collision with other inner class name */
    public static final class C0057a {
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/im/internal/core/util/GsonHolder$fromJson$1$1", "Lcom/google/gson/reflect/TypeToken;", "runtime_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class b extends TypeToken<HashMap<String, String>> {
        public b() {
        }
    }

    static {
    }

    public a(td8.d r2) {
        Intrinsics.checkNotNullParameter(r2, "taskContext");
        this.a = r2;
    }

    public final Message c(List<? extends xc8.b> r8) {
        Iterator<T> r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L38;
        Object r0 = r9.next();
        xc8.b r2 = (xc8.b) r0;
        Message r3 = r2.getMessage();
        boolean r5 = true;
        if (com.larus.bmhome.chat.bean.d.i0(r3) == false) goto L11;
        if (com.larus.bmhome.chat.bean.d.w(r3) == true) goto L11;
    L30:
        boolean r4 = false;
    L31:
        if (r4 == true) goto L33;
    L35:
        r5 = false;
    L36:
        if (r5 == false) goto L4;
    L39:
        xc8.b r1 = (xc8.b) r0;
        if (r1 != null) goto L42;
        return null;
    L42:
        return r1.getMessage();
    L33:
        if (b0.f(r2.getMessage()) == true) goto L35;
    L11:
        if (com.larus.bmhome.chat.bean.d.T(r3) == true) goto L30;
        if (com.larus.bmhome.chat.bean.d.p0(r3) == true) goto L30;
        if (com.larus.bmhome.chat.bean.d.C0(r3) == true) goto L18;
    L20:
        MessageStatus r6 = r3.getMessageStatus();
        if (r6 != null) goto L23;
    L25:
        boolean r7 = false;
    L26:
        if (r7 == false) goto L28;
    L29:
        r4 = true;
        goto L31
    L28:
        if (b0.f(r3) == false) goto L30;
    L23:
        if (r6.isVisible() != true) goto L25;
        r7 = true;
        goto L26
    L18:
        if (r3.getRegenVisible() == true) goto L20;
    L38:
        r0 = null;
        goto L39
    }

    @Override // td8.c
    public final boolean a(int r12, xc8.b r13, xc8.b r14, List<? extends xc8.b> r15) {
        Intrinsics.checkNotNullParameter(r14, "current");
        Intrinsics.checkNotNullParameter(r15, "input");
        if (com.larus.bmhome.utils.i.f(this.a.g()) == false) goto L5;
        boolean r16 = z2.a.getEduIntentionCameraConfig().b();
    L7:
        if (r16 == true) goto L11;
        FLogger.a.i("Pipeline_List_EduContinueShot", "edu continue shot message no show because of not hit the ab test");
        return false;
    L11:
        if ((this.a.l() instanceof z) == false) goto L15;
        FLogger.a.i("Pipeline_List_EduContinueShot", "edu continue shot message no show because of collect page no suggest");
        return false;
    L15:
        if ((this.a.l() instanceof com.larus.bmhome.social.userchat.model.b) == false) goto L18;
        FLogger.a.i("Pipeline_List_EduContinueShot", "edu continue shot message no show because of collect page no suggest");
        return false;
    L18:
        Message r17 = c(r15);
        if (r17 != null) goto L22;
        FLogger.a.i("Pipeline_List_EduContinueShot", "edu continue shot message no show because of latestVisibleMessage is null");
        return false;
    L22:
        FLogger r18 = FLogger.a;
        r18.i("Pipeline_List_EduContinueShot", "latestVisibleMessage is >>> messageId is " + r17.getMessageId() + ", localId is " + r17.getLocalMessageId() + ", contentType is " + r17.getContentType());
        if (r17.getMessageStatusLocal() == 21) goto L25;
    L126:
        r18.i("Pipeline_List_EduContinueShot", "edu continue shot message no show because of default");
        return false;
    L25:
        if (r17.getContentType() == 2) goto L126;
        if (com.larus.bmhome.chat.bean.d.z0(r17) == false) goto L31;
        Intrinsics.checkNotNullParameter(r17, "<this>");
        if (com.larus.bmhome.chat.bean.d.x(r17).isNoDisappear() == false) goto L31;
    L34:
        r18.i("Pipeline_List_EduContinueShot", "edu continue shot message no show because of latestVisibleMessage is no disappear");
        return false;
    L31:
        if (com.larus.bmhome.chat.bean.d.b0(r17) == false) goto L37;
        if (com.larus.bmhome.chat.bean.d.R0(r17) == true) goto L34;
    L37:
        if (com.larus.bmhome.chat.bean.d.k0(r17) == false) goto L56;
        z2 r3 = z2.a;
        if (r3.getSubConversationNewShowSuggest() == true) goto L56;
        wc9.e r7 = this.a.g();
        if (r7 == null) goto L48;
        Integer r8 = r7.v;
        if (r8 == null) goto L48;
        if (r8.intValue() != 3) goto L48;
        boolean r9 = true;
    L49:
        if (r9 == false) goto L56;
        if (r3.getSubConversationNewOnboardingStyle() == false) goto L56;
        if (com.larus.bmhome.chat.bean.d.x(r17).getSkillCardCnt() > 0) goto L56;
        r18.i("Pipeline_List_EduContinueShot", "edu continue shot message no show because of new conversation onboarding");
        return false;
    L48:
        r9 = false;
    L56:
        String r10 = null;
        if (com.larus.bmhome.chat.bean.d.z0(r17) == true) goto L130;
        wc9.e r4 = this.a.g();
        if (r4 == null) goto L61;
        String r5 = r4.B;
    L63:
        if (o0.d(r5) == false) goto L130;
        wc9.e r6 = this.a.g();
        if (r6 == null) goto L67;
        String r11 = r6.B;
    L69:
        if (Intrinsics.areEqual(r11, r17.getSectionId()) == true) goto L130;
        r18.i("Pipeline_List_EduContinueShot", "edu continue shot message no show because of clear context");
        return false;
    L67:
        r11 = null;
        goto L69
    L61:
        r5 = null;
    L130:
        Map r19 = r17.getExt();     // Catch: Exception -> L123
        if (r19 == null) goto L75;
        String r110 = (String) r19.get("intention");     // Catch: Exception -> L123
    L77:
        if (Intrinsics.areEqual(r110, "intention_edu") == false) goto L125;
        Map r111 = r17.getExt();     // Catch: Exception -> L123
        if (r111 == null) goto L81;
        String r112 = (String) r111.get("sub_message_ext");     // Catch: Exception -> L123
    L82:
        zd9.h r20 = zd9.h.a;     // Catch: Exception -> L123
        if (r112 != null) goto L85;
    L88:
        boolean r21 = true;
    L89:
        if (r21 == false) goto L128;
    L100:
        Object r113 = null;
    L101:
        Map r114 = (Map) r113;     // Catch: Exception -> L123
        if (r114 != null) goto L104;
        r114 = MapsKt.emptyMap();     // Catch: Exception -> L123
    L104:
        Map r115 = MapsKt.toMutableMap(r114);     // Catch: Exception -> L123
        int r0 = p0.a;     // Catch: Exception -> L123
        JSONObject r116 = p0.b(p0.b((String) r115.get("Copilot:hippo:hippo_ext")).optString("data"));     // Catch: Exception -> L123
        if (r116.optInt("picture_source") == 0) goto L125;
        Map r1 = r17.getExt();     // Catch: Exception -> L123
        if (r1 == null) goto L110;
        r10 = (String) r1.get("need_auth_identity");     // Catch: Exception -> L123
    L110:
        if (Intrinsics.areEqual(r10, "1") == false) goto L113;
        FLogger.a.i("Pipeline_List_EduContinueShot", "edu continue shot message no show because of plugin auth");     // Catch: Exception -> L123
        return false;
    L113:
        FLogger r2 = FLogger.a;     // Catch: Exception -> L123
        StringBuilder r22 = new StringBuilder("isMultiQuestion: ");     // Catch: Exception -> L123
        if (r116.optInt("detection_type") != 2) goto L116;
        boolean r117 = true;
    L117:
        r22.append(r117);     // Catch: Exception -> L123
        r22.append(", isReceived: ");     // Catch: Exception -> L123
        n0.a.getClass();     // Catch: Exception -> L123
        r22.append(n0.d(r17));     // Catch: Exception -> L123
        r2.e("Pipeline_List_EduContinueShot", r22.toString());     // Catch: Exception -> L123
        if (r116.optInt("detection_type") == 2) goto L120;
        r2.i("Pipeline_List_EduContinueShot", "Add one more shot card, it is not multi questions");     // Catch: Exception -> L123
        return true;
    L120:
        return n0.d(r17);
    L116:
        r117 = false;
        goto L117
    L128:
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L93
        r20.getClass();     // Catch: Throwable -> L93
        r113 = Result.constructor-impl(zd9.h.b.fromJson(r112, new b().getType()));     // Catch: Throwable -> L93
    L95:
        Throwable r24 = Result.exceptionOrNull-impl(r113);     // Catch: Exception -> L123
        if (r24 == null) goto L99;
        c0 r25 = c0.b;     // Catch: Exception -> L123
        StringBuilder r118 = new StringBuilder("fromJson failed, stack: ");     // Catch: Exception -> L123
        Intrinsics.checkNotNullParameter(r24, "<this>");     // Catch: Exception -> L123
        r118.append(ExceptionsKt.stackTraceToString(r24));     // Catch: Exception -> L123
        r25.e("GsonHolder", r118.toString());     // Catch: Exception -> L123
    L99:
        if (Result.isFailure-impl(r113) == false) goto L101;
    L93:
        th = move-exception;
        Result.Companion r26 = Result.Companion;     // Catch: Exception -> L123
        r113 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Exception -> L123
        goto L95
    L85:
        if (StringsKt.isBlank(r112) == true) goto L88;
        r21 = false;
        goto L89
    L81:
        r112 = null;
    L125:
        return false;
    L75:
        r110 = null;
    L123:
        e = move-exception;
        FLogger.a.e("Pipeline_List_EduContinueShot", "error when parse json", e);
        goto L125
    L5:
        r16 = z2.a.getEduIntentionCameraConfig().d();
        goto L7
    }

    @Override // td8.c
    public final List<xc8.b> b(int r51, xc8.b r52, xc8.b r53, List<xc8.b> r54) {
        Intrinsics.checkNotNullParameter(r53, "current");
        Intrinsics.checkNotNullParameter(r54, "input");
        FLogger r0 = FLogger.a;
        r0.i("Pipeline_List_EduContinueShot", "start suggest task, current input size is " + r54.size());
        Message r5 = c(r54);
        if (r5 == null) goto L59;
        this.a.g();
        int r3 = wf9.b.a;
        Intrinsics.checkNotNullParameter(r5, "message");
        com.larus.bmhome.chat.list.cell.edu_continue_shot.e r6 = null;
        if (com.larus.im.bean.message.a.w0(r5) == false) goto L7;
        r0.i("Pipeline_List_EduContinueShot", "edu continue shot message no show because of isStreaming");
    L55:
        int r4 = 0;
    L57:
        if (r6 == null) goto L59;
        FLogger.a.i("Pipeline_List_EduContinueShot", "suggest added");
        ListProtector.add(r54, r4, r6);
        goto L59
    L7:
        Map r7 = r5.getExt();
        if (r7 == null) goto L10;
        String r8 = (String) r7.get("intention");
    L12:
        if (Intrinsics.areEqual(r8, "intention_edu") == true) goto L14;
        r0.i("Pipeline_List_EduContinueShot", "edu continue shot message no show because of not edu intention message");
        goto L55
    L14:
        Map r1 = r5.getExt();
        if (r1 == null) goto L22;
        String r2 = (String) r1.get("edu_params");
        if (r2 == null) goto L22;
        Boolean r9 = Boolean.valueOf(new JSONObject(r2).optBoolean("edu_continue_shot", false));     // Catch: JSONException -> L20
    L24:
        if (Intrinsics.areEqual(r9, Boolean.TRUE) == true) goto L26;
        FLogger.a.i("Pipeline_List_EduContinueShot", "edu continue shot message no show because of edu continue shot not required");
        goto L55
    L26:
        Map r10 = r5.getExt();
        if (r10 == null) goto L29;
        String r11 = (String) r10.get("sub_message_ext");
    L30:
        zd9.h r12 = zd9.h.a;
        if (r11 != null) goto L33;
    L36:
        boolean r13 = true;
    L37:
        if (r13 == false) goto L63;
    L48:
        Object r14 = null;
    L49:
        Map r15 = (Map) r14;
        if (r15 != null) goto L52;
        r15 = MapsKt.emptyMap();
    L52:
        Map r16 = MapsKt.toMutableMap(r15);
        int r17 = p0.a;
        if (p0.b(p0.b((String) r16.get("Copilot:hippo:hippo_ext")).optString("data")).optInt("picture_source") != 0) goto L56;
        FLogger.a.i("Pipeline_List_EduContinueShot", "edu continue shot message no show because of picture_source is 0");
        goto L55
    L56:
        r4 = 0;
        r6 = new com.larus.bmhome.chat.list.cell.edu_continue_shot.e(b0.j(Message.copy$default(r5, null, null, null, 0, 21, MessageStatus.MessageStatus_AVAILABLE, 800, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, "edu_continue_shot", null, 0, null, null, null, 2147483535, 31, null), 10));
        goto L57
    L63:
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L41
        r12.getClass();     // Catch: Throwable -> L41
        r14 = Result.constructor-impl(zd9.h.b.fromJson(r11, new com.larus.bmhome.chat.component.list.pipeline.pre_dependent.b().getType()));     // Catch: Throwable -> L41
    L43:
        Throwable r19 = Result.exceptionOrNull-impl(r14);
        if (r19 == null) goto L47;
        c0 r20 = c0.b;
        StringBuilder r21 = new StringBuilder("fromJson failed, stack: ");
        Intrinsics.checkNotNullParameter(r19, "<this>");
        r21.append(ExceptionsKt.stackTraceToString(r19));
        r20.e("GsonHolder", r21.toString());
    L47:
        if (Result.isFailure-impl(r14) == false) goto L49;
    L41:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L43
    L33:
        if (StringsKt.isBlank(r11) == true) goto L36;
        r13 = false;
        goto L37
    L29:
        r11 = null;
    L20:
        e = move-exception;
        FLogger.a.e("Pipeline_List_EduContinueShot", "edu continue shot message no show because of invalid edu params", e);
    L22:
        r9 = null;
        goto L24
    L10:
        r8 = null;
    L59:
        FLogger.a.i("Pipeline_List_EduContinueShot", "end suggest task, current input size is " + r54.size());
        return r54;
    }
}
