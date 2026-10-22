package com.larus.bmhome.chat.component.list.pipeline.pre_dependent;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.IChatAzerothService;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.helper.n0;
import com.larus.bmhome.chat.list.cell.prompt.g2;
import com.larus.bmhome.chat.list.cell.prompt.w0;
import com.larus.bmhome.chat.model.repo.ISettingRepoService;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.setting.UserSettingCacheManager;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.bmhome.social.userchat.model.z;
import com.larus.bmhome.utils.g3;
import com.larus.bmhome.x;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.internal.delegate.c0;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.service.IZLotteryService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.p0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d implements td8.c {
    public static final /* synthetic */ int c = 0;
    public final td8.d a;
    public xc8.b b;

    public static final class a {
        public static String a(Message r5) {
            Intrinsics.checkNotNullParameter(r5, "<this>");
            StringBuilder r0 = new StringBuilder("(");
            r0.append(r5.getMessageId());
            r0.append('_');
            r0.append(r5.getLocalMessageId());
            r0.append('_');
            r0.append(r5.getMessageStatus());
            r0.append('_');
            r0.append(r5.getMessageStatusLocal());
            r0.append('_');
            r0.append(r5.getContentType());
            r0.append('_');
            boolean r3 = false;
            if (com.larus.bmhome.chat.bean.d.i0(r5) == false) goto L8;
            if (com.larus.bmhome.chat.bean.d.w(r5) == true) goto L8;
        L27:
            r0.append(r3);
            r0.append('_');
            r0.append(r5.getTags());
            r0.append('_');
            r0.append(r5.getSectionId());
            r0.append('_');
            r0.append(com.larus.bmhome.chat.bean.d.x(r5).getNextPulseType());
            r0.append(')');
            return r0.toString();
        L8:
            if (com.larus.bmhome.chat.bean.d.T(r5) == true) goto L27;
            if (com.larus.bmhome.chat.bean.d.p0(r5) == true) goto L27;
            if (com.larus.bmhome.chat.bean.d.C0(r5) == true) goto L15;
        L17:
            MessageStatus r2 = r5.getMessageStatus();
            if (r2 != null) goto L20;
        L22:
            boolean r4 = false;
        L23:
            if (r4 == false) goto L25;
        L26:
            r3 = true;
            goto L27
        L25:
            if (b0.f(r5) == false) goto L27;
        L20:
            if (r2.isVisible() != true) goto L22;
            r4 = true;
            goto L23
        L15:
            if (r5.getRegenVisible() == true) goto L17;
            goto L17
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/im/internal/core/util/GsonHolder$fromJson$1$1", "Lcom/google/gson/reflect/TypeToken;", "runtime_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class b extends TypeToken<HashMap<String, String>> {
        public b() {
        }
    }

    static {
    }

    public d(td8.d r2) {
        Intrinsics.checkNotNullParameter(r2, "taskContext");
        this.a = r2;
    }

    public final void c(Message r11, String r12) {
        if (com.larus.bmhome.chat.bean.d.W0(r11) == false) goto L10;
        ChatControlTrace r0 = ChatControlTrace.b;
        String r1 = r11.getMessageId();
        String r2 = r11.getSenderId();
        String r3 = com.larus.bmhome.chat.bean.d.Z0(r11);
        Long r5 = Long.valueOf(RangesKt.coerceAtLeast(System.currentTimeMillis() - (r11.getCreateTime() * ((long) 1000)), 0));
        long r6 = this.a.b();
        if (com.larus.bmhome.chat.bean.d.x(r11).getNextPulseType() == null) goto L7;
        boolean r4 = true;
    L8:
        Boolean r8 = Boolean.valueOf(r4);
        Integer r9 = com.larus.bmhome.chat.bean.d.x(r11).getNextPulseType();
        r0.getClass();
        ChatControlTrace.Q(r1, r2, r3, r12, r5, r6, r8, r9);
        return;
    L7:
        r4 = false;
        goto L8
    }

    @Override // td8.c
    public final boolean a(int r7, xc8.b r8, xc8.b r9, List<? extends xc8.b> r10) {
        Intrinsics.checkNotNullParameter(r9, "current");
        Intrinsics.checkNotNullParameter(r10, "input");
        if ((this.a.l() instanceof z) == false) goto L7;
        FLogger.a.i("Pipeline_List_Suggest", "suggest no show because of collect page no suggest");
        return false;
    L7:
        if ((this.a.l() instanceof com.larus.bmhome.social.userchat.model.b) == false) goto L10;
        FLogger.a.i("Pipeline_List_Suggest", "suggest no show because of collect page no suggest");
        return false;
    L10:
        Object r11 = null;
        String r12 = null;
        r11 = null;
        if (IAIChatUgcAIGCService.a.y0() == false) goto L24;
        Iterator<? extends xc8.b> r13 = r10.iterator();
    L15:
        if (r13.hasNext() == false) goto L24;
        xc8.b r1 = r13.next();
        Message r2 = r1.getMessage();
        if (com.larus.bmhome.chat.bean.d.z0(r2) == true) goto L22;
        if (com.larus.bmhome.chat.bean.d.W0(r2) == false) goto L24;
    L22:
        if (com.larus.bmhome.chat.bean.d.Y0(r2) == false) goto L15;
    L25:
        this.b = r1;
        if (r1 == null) goto L29;
        FLogger.a.i("Pipeline_List_Suggest", "add z lottery prompt msg");
        return true;
    L29:
        Iterator<T> r14 = r10.iterator();
    L31:
        if (r14.hasNext() == false) goto L65;
        Object r3 = r14.next();
        xc8.b r4 = (xc8.b) r3;
        Message r5 = r4.getMessage();
        if (com.larus.bmhome.chat.bean.d.i0(r5) == false) goto L38;
        if (com.larus.bmhome.chat.bean.d.w(r5) == true) goto L38;
    L57:
        boolean r6 = false;
    L58:
        if (r6 == true) goto L60;
    L62:
        boolean r15 = false;
    L63:
        if (r15 == false) goto L31;
    L66:
        xc8.b r16 = (xc8.b) r3;
        if (r16 == null) goto L69;
        Message r17 = r16.getMessage();
    L70:
        if (r17 != null) goto L73;
        FLogger.a.i("Pipeline_List_Suggest", "suggest no show because of latestVisibleMessage is null");
        return false;
    L73:
        FLogger r18 = FLogger.a;
        r18.i("Pipeline_List_Suggest", "latestVisibleMessage is >>> " + a.a(r17));
        if (r17.getMessageStatusLocal() == 21) goto L76;
    L188:
        r18.i("Pipeline_List_Suggest", "suggest no show because of default");
        return false;
    L76:
        if (r17.getContentType() == 2) goto L188;
        if (com.larus.bmhome.chat.bean.d.z0(r17) == false) goto L84;
        Intrinsics.checkNotNullParameter(r17, "<this>");
        if (com.larus.bmhome.chat.bean.d.x(r17).isNoDisappear() == false) goto L84;
        r18.i("Pipeline_List_Suggest", "suggest no show because of latestVisibleMessage is no disappear");
        c(r17, "no disappear");
        return false;
    L84:
        if (com.larus.bmhome.chat.bean.d.b0(r17) == false) goto L90;
        if (com.larus.bmhome.chat.bean.d.R0(r17) == false) goto L90;
        r18.i("Pipeline_List_Suggest", "suggest no show because of latestVisibleMessage is unselected crowd test");
        c(r17, "unselected crowd test");
        return false;
    L90:
        if (com.larus.bmhome.chat.bean.d.k0(r17) == false) goto L110;
        z2 r19 = z2.a;
        if (r19.getSubConversationNewShowSuggest() == true) goto L110;
        wc9.e r20 = this.a.g();
        if (r20 == null) goto L101;
        Integer r21 = r20.v;
        if (r21 == null) goto L101;
        if (r21.intValue() != 3) goto L101;
        boolean r22 = true;
    L102:
        if (r22 == false) goto L110;
        if (r19.getSubConversationNewOnboardingStyle() == false) goto L110;
        if (com.larus.bmhome.chat.bean.d.x(r17).getSkillCardCnt() > 0) goto L110;
        r18.i("Pipeline_List_Suggest", "suggest no show because of new conversation onboarding");
        c(r17, "new conversation onboarding");
        return false;
    L101:
        r22 = false;
    L110:
        if (com.larus.bmhome.chat.bean.d.z0(r17) == true) goto L131;
        wc9.e r23 = this.a.g();
        if (r23 == null) goto L114;
        String r24 = r23.B;
    L116:
        if (o0.d(r24) == false) goto L131;
        wc9.e r25 = this.a.g();
        if (r25 == null) goto L120;
        String r26 = r25.B;
    L122:
        if (Intrinsics.areEqual(r26, r17.getSectionId()) == true) goto L131;
        if (k99.d.a(r17) == true) goto L131;
        StringBuilder r27 = new StringBuilder("suggest no show because of clear context, ");
        wc9.e r28 = this.a.g();
        if (r28 == null) goto L128;
        r12 = r28.B;
    L128:
        r27.append(r12);
        r27.append("->");
        r27.append(r17.getSectionId());
        r18.i("Pipeline_List_Suggest", r27.toString());
        c(r17, "clear context");
        return false;
    L120:
        r26 = null;
        goto L122
    L114:
        r24 = null;
    L131:
        if (com.larus.bmhome.utils.i.f(this.a.g()) == false) goto L133;
        boolean r29 = z2.a.getEduIntentionCameraConfig().b();
    L134:
        if (r29 == false) goto L187;
        Map r30 = r17.getExt();
        if (r30 == null) goto L143;
        String r31 = (String) r30.get("edu_params");
        if (r31 == null) goto L143;
        Boolean r32 = Boolean.valueOf(new JSONObject(r31).optBoolean("edu_continue_shot", false));     // Catch: JSONException -> L141
    L145:
        if (Intrinsics.areEqual(r32, Boolean.TRUE) == false) goto L187;
        Map r33 = r17.getExt();
        if (r33 == null) goto L149;
        String r34 = (String) r33.get("intention");
    L151:
        if (Intrinsics.areEqual(r34, "intention_edu") == false) goto L187;
        Map r35 = r17.getExt();
        if (r35 == null) goto L155;
        String r36 = (String) r35.get("sub_message_ext");
    L156:
        zd9.h r37 = zd9.h.a;
        if (r36 != null) goto L159;
    L162:
        boolean r38 = true;
    L163:
        if (r38 == false) goto L192;
    L176:
        Map r39 = (Map) r11;
        if (r39 != null) goto L179;
        r39 = MapsKt.emptyMap();
    L179:
        Map r40 = MapsKt.toMutableMap(r39);
        int r41 = p0.a;
        if (p0.b(p0.b((String) r40.get("Copilot:hippo:hippo_ext")).optString("data")).optInt("picture_source") == 0) goto L187;
        if (com.larus.bmhome.chat.bean.d.x0(r17) == false) goto L185;
        n0.a.getClass();
        if (n0.d(r17) == false) goto L187;
    L185:
        c(r17, "continue shot");
        return false;
    L192:
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L167
        r37.getClass();     // Catch: Throwable -> L167
        Object r43 = Result.constructor-impl(zd9.h.b.fromJson(r36, new b().getType()));     // Catch: Throwable -> L167
    L169:
        Throwable r44 = Result.exceptionOrNull-impl(r43);
        if (r44 == null) goto L173;
        c0 r45 = c0.b;
        StringBuilder r46 = new StringBuilder("fromJson failed, stack: ");
        Intrinsics.checkNotNullParameter(r44, "<this>");
        r46.append(ExceptionsKt.stackTraceToString(r44));
        r45.e("GsonHolder", r46.toString());
    L173:
        if (Result.isFailure-impl(r43) == true) goto L176;
        r11 = r43;
    L167:
        th = move-exception;
        Result.Companion r47 = Result.Companion;
        r43 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L169
    L159:
        if (StringsKt.isBlank(r36) == true) goto L162;
        r38 = false;
        goto L163
    L155:
        r36 = null;
        goto L156
    L149:
        r34 = null;
    L141:
        e = move-exception;
        FLogger.a.e("Pipeline_List_Suggest", "Parse edu_continue_shot failed, invalid edu params", e);
    L143:
        r32 = null;
    L187:
        return true;
    L133:
        r29 = z2.a.getEduIntentionCameraConfig().d();
        goto L134
    L69:
        r17 = null;
        goto L70
    L60:
        if (b0.f(r4.getMessage()) == true) goto L62;
        r15 = true;
    L38:
        if (com.larus.bmhome.chat.bean.d.T(r5) == true) goto L57;
        if (com.larus.bmhome.chat.bean.d.p0(r5) == true) goto L57;
        if (com.larus.bmhome.chat.bean.d.C0(r5) == true) goto L45;
    L47:
        MessageStatus r48 = r5.getMessageStatus();
        if (r48 != null) goto L50;
    L52:
        boolean r49 = false;
    L53:
        if (r49 == false) goto L55;
    L56:
        r6 = true;
        goto L58
    L55:
        if (b0.f(r5) == false) goto L57;
    L50:
        if (r48.isVisible() != true) goto L52;
        r49 = true;
        goto L53
    L45:
        if (r5.getRegenVisible() == true) goto L47;
    L65:
        r3 = null;
    L24:
        r1 = null;
        goto L25
    }

    @Override // td8.c
    public final List<xc8.b> b(int r53, xc8.b r54, xc8.b r55, List<xc8.b> r56) {
        Intrinsics.checkNotNullParameter(r55, "current");
        Intrinsics.checkNotNullParameter(r56, "input");
        xc8.b r2 = this.b;
        xc8.b r3 = null;
        if (r2 != null) goto L41;
        ArrayList r4 = new ArrayList();
        Iterator<T> r6 = r56.iterator();
    L6:
        if (r6.hasNext() == false) goto L40;
        xc8.b r7 = (xc8.b) r6.next();
        Message r8 = r7.getMessage();
        if (com.larus.bmhome.chat.bean.d.i0(r8) == false) goto L13;
        if (com.larus.bmhome.chat.bean.d.w(r8) == true) goto L13;
    L32:
        boolean r9 = false;
    L33:
        if (r9 == false) goto L38;
        if (b0.f(r7.getMessage()) == true) goto L38;
        r4.add(r7.getMessage());
    L38:
        if (r4.size() >= 2) goto L40;
    L13:
        if (com.larus.bmhome.chat.bean.d.T(r8) == true) goto L32;
        if (com.larus.bmhome.chat.bean.d.p0(r8) == true) goto L32;
        if (com.larus.bmhome.chat.bean.d.C0(r8) == true) goto L20;
    L22:
        MessageStatus r10 = r8.getMessageStatus();
        if (r10 != null) goto L25;
    L27:
        boolean r11 = false;
    L28:
        if (r11 == false) goto L30;
    L31:
        r9 = true;
        goto L33
    L30:
        if (b0.f(r8) == false) goto L32;
    L25:
        if (r10.isVisible() != true) goto L27;
        r11 = true;
        goto L28
    L20:
        if (r8.getRegenVisible() == true) goto L22;
    L40:
        Pair r5 = TuplesKt.to(CollectionsKt.getOrNull(r4, 0), CollectionsKt.getOrNull(r4, 1));
    L42:
        Message r12 = (Message) r5.component1();
        Message r13 = (Message) r5.component2();
        FLogger r14 = FLogger.a;
        StringBuilder r15 = new StringBuilder("start suggest task, latest=");
        if (r12 == null) goto L45;
        String r16 = r12.getLocalMessageId();
    L46:
        r15.append(r16);
        r15.append(" prev=");
        if (r13 == null) goto L49;
        String r17 = r13.getLocalMessageId();
    L50:
        r15.append(r17);
        r15.append(", input size = ");
        r15.append(r56.size());
        r15.append(", top4 msg = ");
        List r18 = CollectionsKt.take(r56, 4);
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
        Iterator r20 = r18.iterator();
    L52:
        if (r20.hasNext() == false) goto L54;
        r19.add(a.a(((xc8.b) r20.next()).getMessage()));
        goto L52
    L54:
        r15.append(r19);
        String r110 = "Pipeline_List_Suggest";
        r14.i("Pipeline_List_Suggest", r15.toString());
        if (r12 == null) goto L223;
        wc9.e r21 = this.a.g();
        if (r21 == null) goto L59;
        Integer r22 = r21.v;
    L60:
        ISettingRepoService r23 = (ISettingRepoService) ServiceManager.get().getService(ISettingRepoService.class);
        if (r23 != null) goto L63;
    L65:
        boolean r24 = false;
    L66:
        if (r24 == true) goto L68;
        FLogger.a.i("Pipeline_List_Suggest", "suggest no show because of switchOn is false");
        c(r12, "switchOn is false");
    L221:
        if (r3 == null) goto L224;
        FLogger.a.w(r110, "suggest added " + a.a(r3.getMessage()));
        ListProtector.add(r56, 0, r3);
    L224:
        FLogger.a.i(r110, "end suggest task, current input size is " + r56.size());
        return r56;
    L68:
        Regex r25 = com.larus.bmhome.chat.bean.d.a;
        Intrinsics.checkNotNullParameter(r12, "<this>");
        List r26 = r12.getSuggestQuestions();
        if (r26 != null) goto L71;
    L74:
        boolean r27 = true;
    L75:
        if (r27 == true) goto L78;
    L87:
        boolean r28 = true;
    L88:
        if (r28 == true) goto L97;
        if (com.larus.bmhome.chat.bean.d.x(r12).getLocalSubCoCoMsg() == true) goto L97;
        if (com.larus.bmhome.chat.bean.d.X(r12) == true) goto L97;
        if (com.larus.bmhome.chat.bean.d.Y0(r12) == true) goto L97;
        FLogger.a.i("Pipeline_List_Suggest", "suggest no show because of message no suggestion");
        c(r12, "message no suggestion");
    L97:
        if (com.larus.bmhome.chat.bean.d.z0(r12) == false) goto L99;
    L101:
        int r29 = wf9.b.a;
        Intrinsics.checkNotNullParameter(r12, "message");
        if (com.larus.im.bean.message.a.w0(r12) == false) goto L104;
        FLogger.a.i("Pipeline_List_Suggest", "suggest no show because of " + r12.getMessageId() + " isStreaming");
        c(r12, "isStreaming");
        goto L221
    L104:
        IChatAzerothService r30 = x.a();
        if (r30 != null) goto L107;
    L109:
        boolean r31 = false;
    L110:
        if (r31 == false) goto L113;
        FLogger.a.i("Pipeline_List_Suggest", "suggest no show because of isMessageCipher");
        c(r12, "isMessageCipher");
        goto L221
    L113:
        if (((Boolean) g3.a.getValue()).booleanValue() == false) goto L125;
        if (com.larus.bmhome.chat.bean.d.z0(r12) == true) goto L125;
        if (r22 == null) goto L125;
        if (r22.intValue() != 1) goto L125;
        if (((AppHost.a.getAppClock().currentTimeMillis() / ((long) 1000)) - r12.getCreateTime()) < g3.a()) goto L125;
        FLogger.a.i("Pipeline_List_Suggest", "suggest no show because of within sug interval " + g3.a() + 's');
        c(r12, "botConversationType is COCO");
    L125:
        if (com.larus.bmhome.chat.bean.d.W0(r12) == true) goto L128;
    L152:
        boolean r32 = false;
    L154:
        if (r32 == false) goto L181;
        Intrinsics.checkNotNullParameter(r12, "<this>");
        if (com.larus.bmhome.chat.bean.d.W0(r12) == true) goto L158;
    L177:
        boolean r33 = false;
    L178:
        if (r33 == false) goto L181;
        FLogger.a.i("Pipeline_List_SuggestWCB", "suggest no show because of welcome back expired");
        c(r12, "welcome back expired");
        goto L221
    L158:
        if (com.larus.platform.service.n0.a.b() == false) goto L161;
    L176:
        r33 = true;
        goto L178
    L161:
        if (com.larus.bmhome.chat.bean.d.Y0(r12) == false) goto L170;
        if (IAIChatUgcAIGCService.a.J() == false) goto L176;
        AccountService r34 = AccountService.a;
        if (r34.isLogin().booleanValue() == true) goto L177;
        if (r34.k() == false) goto L177;
    L170:
        if (IAIChatUgcAIGCService.a.y0() == false) goto L172;
        FLogger.a.i("wcb", "z disable wcb");
        goto L176
    L172:
        long r35 = com.larus.bmhome.chat.bean.d.x(r12).getOnboardingSugExpirationTime() * 1000;
        long r111 = AppHost.a.getAppClock().currentTimeMillis();
        FLogger.a.i("wcb", "expired: " + r35 + ", cur: " + r111);
        if (1 > r35) goto L177;
        if (r35 >= r111) goto L177;
    L181:
        if (com.larus.bmhome.chat.bean.d.W(r12) == false) goto L185;
        UserSettingCacheManager.a.getClass();
        if (UserSettingCacheManager.i() == true) goto L185;
        FLogger.a.i("Pipeline_List_Suggest", "suggest no show because of related video switch off");
    L185:
        LinkedHashMap r36 = new LinkedHashMap();
        if (r13 == null) goto L189;
        r36.put("time_after_prev_message", String.valueOf(r12.getCreateTime() - r13.getCreateTime()));
    L189:
        if (r12.getContentType() != 5) goto L204;
        Map r37 = r12.getBusinessExt();
        if (r37 != null) goto L193;
    L196:
        boolean r38 = true;
    L198:
        if (r38 == false) goto L200;
        r36.put("suggested_type", "related_video_suggested_prompted");
    L208:
        Message r39 = b0.j(Message.copy$default(r12, null, null, null, 0, 21, MessageStatus.MessageStatus_AVAILABLE, 2, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, r36, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -4194417, 31, null), 1);
        if (com.larus.bmhome.chat.bean.d.W(r39) == false) goto L213;
        xc8.b r40 = new com.larus.bmhome.chat.list.cell.video.d(Message.copy$default(r39, null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, r39.getLocalMessageId(), 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -32769, 31, null));
    L211:
        r3 = r40;
        goto L221
    L213:
        if (com.larus.bmhome.chat.bean.d.Y0(r39) == false) goto L218;
        r40 = IZLotteryService.a.s(r39);
        if (r40 != null) goto L211;
        r40 = new yc8.a(r39);
        goto L211
    L218:
        if (com.larus.bmhome.chat.bean.d.X(r39) == false) goto L220;
        r40 = new g2(r39);
        goto L211
    L220:
        r40 = new w0(r39);
        goto L211
    L200:
        Object r41 = r12.getBusinessExt();
        if (r41 != null) goto L203;
        r41 = new LinkedHashMap();
    L203:
        r36.putAll(r41);
        r36.put("suggested_type", "related_video_suggested_prompted");
        goto L208
    L193:
        if (r37.isEmpty() == true) goto L196;
        r38 = false;
        goto L198
    L204:
        Object r42 = r12.getBusinessExt();
        if (r42 != null) goto L207;
        r42 = new LinkedHashMap();
    L207:
        r36.putAll(r42);
        goto L208
    L128:
        if (com.larus.bmhome.chat.bean.d.U0() == false) goto L153;
        String r43 = (String) com.larus.bmhome.chat.bean.d.x(r12).get("next_pulse_type");
        if (com.larus.bmhome.chat.bean.d.W0(r12) == false) goto L149;
        if (r43 != null) goto L133;
    L136:
        boolean r44 = true;
    L137:
        if (r44 == true) goto L141;
        if (Intrinsics.areEqual(r43, "1") == false) goto L149;
    L141:
        if (com.larus.bmhome.chat.bean.d.X(r12) == true) goto L149;
        if (com.larus.bmhome.chat.bean.d.W(r12) == true) goto L149;
        if (com.larus.bmhome.chat.bean.d.Y0(r12) == true) goto L149;
        if (com.larus.bmhome.chat.bean.d.X0(r12) == true) goto L149;
        boolean r45 = true;
    L150:
        if (r45 == true) goto L152;
    L133:
        if (r43.length() == 0) goto L136;
        r44 = false;
    L149:
        r45 = false;
    L153:
        r32 = true;
        goto L154
    L107:
        if (r30.d(r12) != true) goto L109;
        r31 = true;
        goto L110
    L99:
        if (r12.getContentType() != 1001) goto L101;
        FLogger.a.i("Pipeline_List_Suggest", "suggest no show because of message contentType is SYS_MSG");
        c(r12, "message contentType is SYS_MSG");
        goto L221
    L78:
        if (com.larus.bmhome.chat.bean.d.a(com.larus.bmhome.chat.bean.d.x(r12).getSuggestItems()) == true) goto L87;
        if (com.larus.bmhome.chat.bean.d.a(com.larus.bmhome.chat.bean.d.x(r12).getSuggestItemsV2()) == true) goto L87;
        if (com.larus.bmhome.chat.bean.d.a(com.larus.bmhome.chat.bean.d.x(r12).getSuggestV2Prompt()) == true) goto L87;
        if (com.larus.bmhome.chat.bean.d.a(com.larus.bmhome.chat.bean.d.x(r12).getOnboardingSug()) == true) goto L87;
        r28 = false;
        goto L88
    L71:
        if (r26.isEmpty() == true) goto L74;
        r27 = false;
        goto L75
    L63:
        if (r23.i() != true) goto L65;
        r24 = true;
        goto L66
    L59:
        r22 = null;
        goto L60
    L223:
        r110 = "Pipeline_List_Suggest";
        goto L224
    L49:
        r17 = null;
        goto L50
    L45:
        r16 = null;
        goto L46
    L41:
        r5 = TuplesKt.to(r2.getMessage(), null);
        goto L42
    }
}
