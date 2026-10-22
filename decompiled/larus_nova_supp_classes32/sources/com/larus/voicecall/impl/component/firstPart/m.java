package com.larus.voicecall.impl.component.firstPart;

import com.larus.bmhome.auth.douyin.IAiChatOpenDouyinAuthService;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.bean.ChatParam;
import com.larus.voicecall.api.bean.CommandType;
import com.larus.voicecall.impl.util.RealtimeCallUtil;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class m implements ya8.a {
    public final /* synthetic */ RealtimeFirstPartComponent a;

    public m(RealtimeFirstPartComponent r1) {
        this.a = r1;
    }

    public final void a(boolean r3, Message r4) {
        FLogger r5 = FLogger.a;
        StringBuilder r0 = new StringBuilder("Douyin auth result, isInCall=");
        RealtimeCallUtil.a.getClass();
        r0.append(RealtimeCallUtil.G);
        r0.append(", result=");
        r0.append(r3);
        r5.i("RealtimeFirstPartComponent", r0.toString());
        if (RealtimeCallUtil.G == true) goto L5;
        return;
    L5:
        RealtimeFirstPartComponent r6 = this.a;
        int r1 = RealtimeFirstPartComponent.y;
        IAiChatOpenDouyinAuthService r7 = r6.z3();
        if (r7 == null) goto L8;
        r7.g();
    L8:
        String r8 = null;
        if (r3 == false) goto L24;
        com.larus.voicecall.impl.component.core.a r9 = this.a.p3();
        if (r9 == null) goto L39;
        CommandType r2 = this.a.s;
        if (r2 == null) goto L17;
        ChatParam r10 = r2.getParam();
        if (r10 == null) goto L17;
        String r11 = r10.getQuestionId();
    L18:
        CommandType r12 = this.a.s;
        if (r12 == null) goto L23;
        ChatParam r13 = r12.getParam();
        if (r13 == null) goto L23;
        r8 = r13.getAnswerId();
    L23:
        r9.RS(r11, r8);
        return;
    L17:
        r11 = null;
        goto L18
    L39:
        return;
    L24:
        com.larus.voicecall.impl.component.core.a r14 = this.a.p3();
        if (r14 == null) goto L41;
        CommandType r15 = this.a.s;
        if (r15 == null) goto L31;
        ChatParam r16 = r15.getParam();
        if (r16 == null) goto L31;
        String r17 = r16.getRefuseText();
    L32:
        CommandType r18 = this.a.s;
        if (r18 == null) goto L37;
        ChatParam r19 = r18.getParam();
        if (r19 == null) goto L37;
        r8 = r19.getQuestionId();
    L37:
        r14.xG(r17, r8);
        return;
    L31:
        r17 = null;
        goto L32
    }
}
