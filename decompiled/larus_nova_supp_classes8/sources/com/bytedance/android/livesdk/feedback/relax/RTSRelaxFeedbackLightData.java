package com.bytedance.android.livesdk.feedback.relax;

import com.bytedance.android.live.rts.client_utils.IESLiveRTSSettingUtils;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class RTSRelaxFeedbackLightData {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final long g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final Map<String, Object> n;
    public final String o;
    public final String p;
    public Map<String, Object> q;
    public Map<String, Object> r;
    public Map<String, Object> s;

    public RTSRelaxFeedbackLightData(Map<String, Object> r12) {
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        String r1 = "0";
        this.h = "0";
        this.i = "room";
        String r2 = "live_banner_horizontal";
        this.j = "live_banner_horizontal";
        String r3 = "single";
        this.k = "single";
        this.l = "";
        this.m = "";
        this.o = "";
        this.p = "";
        int r4 = com.bytedance.rts.foundation.f.a;
        Object r5 = null;
        if (r12 == null) goto L5;
        Object r6 = r12.get("feedbackData");
    L7:
        if ((r6 instanceof String) == true) goto L9;
        r6 = null;
    L9:
        String r7 = (String) r6;
        String r8 = "{}";
        if (r7 != null) goto L12;
        r7 = "{}";
    L12:
        Map<String, Object> r9 = com.bytedance.rts.foundation.f.a.c(r7, RTSRelaxFeedbackLightData$feedback$1.INSTANCE);
        if (r12 == null) goto L15;
        Object r10 = r12.get("enter_from_merge");
    L17:
        if ((r10 instanceof String) == true) goto L19;
        r10 = null;
    L19:
        String r11 = (String) r10;
        if (r11 != null) goto L22;
        r11 = (String) com.bytedance.rts.foundation.g.m(r9, "enter_from_merge");
    L22:
        if (r11 != null) goto L24;
        r11 = "";
    L24:
        this.a = r11;
        if (r12 == null) goto L27;
        Object r13 = r12.get("enter_method");
    L29:
        if ((r13 instanceof String) == true) goto L31;
        r13 = null;
    L31:
        String r14 = (String) r13;
        if (r14 != null) goto L34;
        r14 = (String) com.bytedance.rts.foundation.g.m(r9, "enter_method");
    L34:
        if (r14 != null) goto L36;
        r14 = "";
    L36:
        this.b = r14;
        if (r12 == null) goto L39;
        Object r15 = r12.get("action_type");
    L41:
        if ((r15 instanceof String) == true) goto L43;
        r15 = null;
    L43:
        String r16 = (String) r15;
        if (r16 != null) goto L46;
        r16 = "";
    L46:
        this.c = r16;
        if (r12 == null) goto L49;
        Object r17 = r12.get("room_id");
    L51:
        if ((r17 instanceof String) == true) goto L53;
        r17 = null;
    L53:
        String r18 = (String) r17;
        if (r18 != null) goto L56;
        r18 = (String) com.bytedance.rts.foundation.g.m(r9, "room_id");
    L56:
        if (r18 != null) goto L58;
        r18 = "";
    L58:
        this.d = r18;
        if (r12 == null) goto L61;
        Object r19 = r12.get("anchor_id");
    L63:
        if ((r19 instanceof String) == true) goto L65;
        r19 = null;
    L65:
        String r20 = (String) r19;
        if (r20 != null) goto L68;
        r20 = "";
    L68:
        this.e = r20;
        if (r12 == null) goto L71;
        Object r21 = r12.get("request_id");
    L73:
        if ((r21 instanceof String) == true) goto L75;
        r21 = null;
    L75:
        String r22 = (String) r21;
        if (r22 != null) goto L78;
        r22 = (String) com.bytedance.rts.foundation.g.m(r9, "request_id");
    L78:
        if (r22 != null) goto L80;
        r22 = "";
    L80:
        this.f = r22;
        Long r23 = (Long) com.bytedance.rts.foundation.g.l(r9, "feedback_id");
        if (r23 == null) goto L83;
        long r24 = r23.longValue();
    L84:
        this.g = r24;
        if (r12 == null) goto L87;
        Object r25 = r12.get("duration");
    L89:
        if ((r25 instanceof String) == true) goto L91;
        r25 = null;
    L91:
        String r26 = (String) r25;
        if (r12 == null) goto L94;
        Object r27 = r12.get("draw_order");
    L96:
        if ((r27 instanceof String) == true) goto L98;
        r27 = null;
    L98:
        String r28 = (String) r27;
        if (r28 == null) goto L102;
        r1 = r28;
    L102:
        this.h = r1;
        if (r12 == null) goto L105;
        Object r29 = r12.get("flow_type");
    L107:
        if ((r29 instanceof String) == true) goto L109;
        r29 = null;
    L109:
        String r30 = (String) r29;
        if (r30 != null) goto L112;
        r30 = "";
    L112:
        this.i = r30;
        if (r12 == null) goto L115;
        Object r31 = r12.get("question_text");
    L117:
        if ((r31 instanceof String) == true) goto L119;
        r31 = null;
    L119:
        String r32 = (String) r31;
        if (r12 == null) goto L122;
        Object r33 = r12.get("card_type");
    L124:
        if ((r33 instanceof String) == true) goto L126;
        r33 = null;
    L126:
        String r34 = (String) r33;
        if (r34 == null) goto L130;
        r2 = r34;
    L130:
        this.j = r2;
        if (r12 == null) goto L133;
        Object r35 = r12.get("question_type");
    L135:
        if ((r35 instanceof String) == true) goto L137;
        r35 = null;
    L137:
        String r36 = (String) r35;
        if (r36 == null) goto L141;
        r3 = r36;
    L141:
        this.k = r3;
        if (r12 == null) goto L144;
        Object r37 = r12.get("pk_id");
    L146:
        if ((r37 instanceof String) == true) goto L148;
        r37 = null;
    L148:
        String r38 = (String) r37;
        if (r38 != null) goto L151;
        r38 = "";
    L151:
        this.l = r38;
        if (r12 == null) goto L154;
        Object r39 = r12.get("feedbackData");
    L156:
        if ((r39 instanceof String) == true) goto L158;
        r39 = null;
    L158:
        String r40 = (String) r39;
        if (r40 == null) goto L162;
        r8 = r40;
    L162:
        this.m = r8;
        if (r12 == null) goto L165;
        Object r41 = r12.get("position");
    L167:
        if ((r41 instanceof String) == true) goto L169;
        r41 = null;
    L169:
        String r42 = (String) r41;
        if (r42 != null) goto L172;
        r42 = "";
    L172:
        this.o = r42;
        if (r12 == null) goto L175;
        Object r110 = r12.get("recent_room_ids");
    L177:
        if ((r110 instanceof String) == false) goto L180;
        r5 = r110;
    L180:
        String r43 = (String) r5;
        if (r43 != null) goto L183;
        r43 = "";
    L183:
        this.p = r43;
        int r111 = IESLiveRTSSettingUtils.a;
        IESLiveRTSSettingUtils.a(new com.bytedance.android.live.rts.client_utils.a("live_light_feedback_config", "object", ""), new RTSRelaxFeedbackLightData$getClientSetting$1(this));
        IESLiveRTSSettingUtils.a(new com.bytedance.android.live.rts.client_utils.a("live_feedback_tomain_config", "object", ""), new RTSRelaxFeedbackLightData$getClientSetting$2(this));
        IESLiveRTSSettingUtils.a(new com.bytedance.android.live.rts.client_utils.a("live_public_screen_emoji_feedback_config", "object", ""), new RTSRelaxFeedbackLightData$getClientSetting$3(this));
        this.n = r9;
        return;
    L175:
        r110 = null;
        goto L177
    L165:
        r41 = null;
        goto L167
    L154:
        r39 = null;
        goto L156
    L144:
        r37 = null;
        goto L146
    L133:
        r35 = null;
        goto L135
    L122:
        r33 = null;
        goto L124
    L115:
        r31 = null;
        goto L117
    L105:
        r29 = null;
        goto L107
    L94:
        r27 = null;
        goto L96
    L87:
        r25 = null;
        goto L89
    L83:
        r24 = 0;
        goto L84
    L71:
        r21 = null;
        goto L73
    L61:
        r19 = null;
        goto L63
    L49:
        r17 = null;
        goto L51
    L39:
        r15 = null;
        goto L41
    L27:
        r13 = null;
        goto L29
    L15:
        r10 = null;
        goto L17
    L5:
        r6 = null;
        goto L7
    }
}
