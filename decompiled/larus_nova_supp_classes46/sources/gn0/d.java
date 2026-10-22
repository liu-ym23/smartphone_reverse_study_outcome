package gn0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.o;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.live.multilink.impl.LinkMultiControlPresenter;
import com.bytedance.android.live.multilink.impl.control.setting.PaidLinkConfigType;
import com.bytedance.android.livesdk.chatroom.interact.model.y;
import com.bytedance.android.livesdk.chatroom.model.interact.l;
import com.bytedance.android.livesdk.chatroom.model.interact.p1;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdkapi.util.KotlinTypeUtilsKt;
import com.bytedance.android.scope.j;
import com.bytedance.android.scope.m;
import com.bytedance.android.scope.p;
import com.bytedance.live.kmp.util.KmpToastUtil;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ b a;

    public d(b r1) {
        this.a = r1;
    }

    public final void accept(Object r22) {
        com.bytedance.android.live.liveinteract.multianchor.model.e r0 = (com.bytedance.android.live.liveinteract.multianchor.model.e) r22;
        b r2 = this.a;
        if (r2.b == null) goto L24;
        String r3 = r0.toString();
        int r5 = x.a;
        Intrinsics.checkNotNullParameter(r3, "setting");
        LinkedHashMap r6 = new LinkedHashMap();
        x.a(r6);
        r6.put("setting_notify", r3);
        r6.put("event_name", "audience_link_setting_msg");
        b0.o().j("ttlive_link", r6);
        if (r0.getSettings() == null) goto L24;
        if (k.f(IInteractService.class) == null) goto L24;
        IInteractService r4 = (IInteractService) k.f(IInteractService.class);
        List r7 = (List) IInteractService.linkMicSettings.getValue();
        ArrayList r8 = new ArrayList();
        if (r7 == null) goto L23;
        Iterator r9 = r7.iterator();
    L12:
        if (r9.hasNext() == false) goto L23;
        y r10 = (y) r9.next();
        Iterator r11 = r0.getSettings().iterator();
    L15:
        if (r11.hasNext() == false) goto L19;
        if (((y) r11.next()).getKey() != r10.getKey()) goto L15;
        Boolean r12 = Boolean.TRUE;
    L21:
        if (r12.booleanValue() == true) goto L12;
        r8.add(r10);
        goto L12
    L19:
        r12 = Boolean.FALSE;
    L23:
        r8.addAll(r0.getSettings());
        IInteractService r13 = (IInteractService) k.f(IInteractService.class);
        IInteractService.linkMicSettings.postValue(r8);
        k.f(IKtvService.class).handleSettingUpdate(KotlinTypeUtilsKt.castElementType(r8));
    L24:
        List<y> r14 = r0.getSettings();
        char r15 = '\"';
        if (r14 != null) goto L27;
    L99:
        int r1 = wh0.c.a;
        boolean r16 = r2.e();
        Intrinsics.checkNotNullParameter(r0, MultiLinkOpenSource.MESSAGE);
        String r17 = "call updateLinkSettingByMsg, message = " + r0.toString();
        jy0.b.c("ttlive_link", r17, null, 4);
        if (((Boolean) vm2.e.P.getValue(null, vm2.e.a[40])).booleanValue() == false) goto L103;
        if (r16 == false) goto L103;
        boolean r18 = true;
    L104:
        if (r18 == false) goto L106;
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.Q(r17, "from LinkSettingNotifyMessage");
    L106:
        List<y> r19 = r0.getSettings();
        if (r19 == null) goto L270;
        Iterator<T> r20 = r19.iterator();
    L110:
        if (r20.hasNext() == false) goto L431;
        y r21 = (y) r20.next();
        int r23 = r21.getKey();
        if (r23 != 4) goto L114;
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.b0.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[52], Boolean.valueOf(r21.isOpen()));
        goto L110
    L114:
        if (r23 == 7) goto L268;
        if (r23 != 33) goto L118;
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.s.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[17], Boolean.valueOf(r21.isOpen()));
        a r110 = r2.b;
        if (r110 == null) goto L262;
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        a.C0215a.a(r110, null, 33, r21, r21.isOpen(), null, 17);
    L262:
        if (r2.e() == true) goto L110;
        int r24 = KmpToastUtil.a;
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        if (r21.isOpen() == false) goto L266;
        String r25 = "主播开启了视频连线功能";
    L267:
        KmpToastUtil.a(r25, 0);
        goto L110
    L266:
        r25 = "主播关闭了视频连线功能";
        goto L267
    L118:
        if (r23 != 34) goto L120;
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.l(r21.isOpen());
        a r111 = r2.b;
        if (r111 == null) goto L252;
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        a.C0215a.a(r111, null, 34, r21, r21.isOpen(), null, 17);
    L252:
        if (r2.e() == true) goto L110;
        int r26 = KmpToastUtil.a;
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        if (r21.isOpen() == false) goto L256;
        String r27 = "房主已开启视频演唱功能";
    L257:
        KmpToastUtil.a(r27, 0);
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.l(r21.isOpen());
        goto L110
    L256:
        r27 = "房主已关闭视频演唱功能";
        goto L257
    L120:
        if (r23 != 61) goto L122;
        a r112 = r2.b;
        if (r112 == null) goto L110;
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        a.C0215a.a(r112, null, 61, r21, r21.isOpen(), null, 17);
        goto L110
    L122:
        if (r23 != 62) goto L124;
        a r113 = r2.b;
        if (r113 == null) goto L110;
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        a.C0215a.a(r113, null, 62, r21, r21.isOpen(), null, 17);
        goto L110
    L124:
        if (r23 != 72) goto L126;
        a r114 = r2.b;
        if (r114 == null) goto L110;
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        a.C0215a.a(r114, null, 72, r21, r21.isOpen(), "IM", 1);
        goto L110
    L126:
        if (r23 != 73) goto L128;
        a r115 = r2.b;
        if (r115 == null) goto L110;
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        a.C0215a.a(r115, null, 73, r21, r21.isOpen(), "IM", 1);
        goto L110
    L128:
        if (r23 != 76) goto L130;
        a r116 = r2.b;
        if (r116 == null) goto L110;
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        a.C0215a.a(r116, null, 76, r21, r21.isOpen(), null, 17);
        goto L110
    L130:
        if (r23 != 77) goto L131;
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.E.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[29], Boolean.valueOf(r21.isOpen()));
        goto L110
    L131:
        switch(r23) {
            case 7: goto L268;
            case 24: goto L169;
            case 40: goto L168;
            case 47: goto L165;
            case 69: goto L161;
            case 82: goto L159;
            case 93: goto L143;
            case 105: goto L142;
            case 107: goto L139;
            case 109: goto L138;
            case 113: goto L137;
            default: goto L133;
        };
    L137:
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.x.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[22], Boolean.valueOf(r21.isOpen()));
        goto L110
    L138:
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.w.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[21], Boolean.valueOf(r21.isOpen()));
        goto L110
    L139:
        a r117 = r2.b;
        if (r117 == null) goto L110;
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        a.C0215a.a(r117, null, 107, r21, r21.isOpen(), null, 17);
        goto L110
    L142:
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.e(r21.isOpen());
        goto L110
    L143:
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.d(r21.isOpen());
        bn0.b r28 = r2.e;
        if (r28 == null) goto L150;
        KClass r29 = Reflection.getOrCreateKotlinClass(hd0.b.class);
        m r118 = m.e;
        r118.getClass();
        p r30 = m.b(r28);
        Intrinsics.checkNotNullParameter(r29, "key");
        j r31 = r30.a;
        r118.getClass();
        com.bytedance.android.scope.tree.d r32 = m.c(r31);
        if (r32 == null) goto L148;
        Object r33 = r32.d(r29);
    L149:
        hd0.b r34 = (hd0.b) r33;
    L151:
        if (r34 == null) goto L110;
        if (r34.getState() != 2) goto L110;
        int r35 = KmpToastUtil.a;
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        if (r21.isOpen() == false) goto L157;
        String r36 = "当前设置：嘉宾下麦后清空计值";
    L158:
        KmpToastUtil.a(r36, 0);
        goto L110
    L157:
        r36 = "当前设置：嘉宾下麦后不清空计值";
        goto L158
    L148:
        r33 = null;
        goto L149
    L150:
        r34 = null;
        goto L151
    L159:
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.t.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[18], Boolean.valueOf(r21.isOpen()));
        goto L110
    L161:
        if (((Boolean) vm2.e.S.getValue(null, vm2.e.a[43])).booleanValue() == false) goto L110;
        a r119 = r2.b;
        if (r119 == null) goto L110;
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        a.C0215a.a(r119, null, 69, r21, r21.isOpen(), null, 17);
        goto L110
    L165:
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.v.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[20], Boolean.valueOf(r21.isOpen()));
        a r120 = r2.b;
        if (r120 == null) goto L110;
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        a.C0215a.a(r120, "data_voice_chat_pre_online_on", null, r21, r21.isOpen(), null, 18);
        goto L110
    L168:
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.D.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[28], Boolean.valueOf(r21.isOpen()));
        goto L110
    L169:
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.m.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[11], Boolean.valueOf(r21.isOpen()));
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        boolean r37 = r21.isOpen();
        cy0.e.a.getClass();
        cy0.j r121 = cy0.e.a.a;
        m.e.getClass();
        Object r38 = m.b(r121).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r38);
        IBaseUser r39 = ((com.bytedance.live.kmp.core.c) r38).b();
        if (r39 != null) goto L172;
    L178:
        a r122 = r2.b;
        if (r122 == null) goto L110;
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        a.C0215a.a(r122, null, 24, r21, r21.isOpen(), null, 17);
        goto L110
    L172:
        if (o.b(r39) != true) goto L178;
        int r40 = KmpToastUtil.a;
        if (r37 == false) goto L176;
        String r41 = "主播已开启管理员对嘉宾操作权限";
    L177:
        KmpToastUtil.a(r41, 0);
        goto L178
    L176:
        r41 = "主播已关闭管理员对嘉宾操作权限";
        goto L177
    L133:
        switch(r23) {
            case 9: goto L200;
            case 10: goto L199;
            case 11: goto L191;
            case 12: goto L190;
            case 13: goto L182;
            case 14: goto L181;
            default: goto L134;
        };
    L181:
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.i(r21.isOpen());
        goto L110
    L182:
        int r42 = com.bytedance.android.live.multilink.impl.control.b.a.a(r2.f);
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        b.k(r42, "data_intimate_chat_support_send_gift_to_linker", r21.isOpen());
        a r123 = r2.b;
        if (r123 == null) goto L185;
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        a.C0215a.a(r123, "data_intimate_chat_support_send_gift_to_linker", null, r21, r21.isOpen(), null, 18);
    L185:
        int r43 = KmpToastUtil.a;
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        if (r21.isOpen() == false) goto L188;
        String r44 = "主播已开启对连线用户的送礼功能";
    L189:
        KmpToastUtil.a(r44, 0);
        goto L110
    L188:
        r44 = "主播已关闭对连线用户的送礼功能";
        goto L189
    L190:
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.h(r21.isOpen());
        goto L110
    L191:
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.j.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[8], Boolean.valueOf(r21.isOpen()));
        int r45 = com.bytedance.android.live.multilink.impl.control.b.a.a(r2.f);
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        b.k(r45, "data_big_party_support_send_gift_to_linker", r21.isOpen());
        a r124 = r2.b;
        if (r124 == null) goto L194;
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        a.C0215a.a(r124, "data_big_party_support_send_gift_to_linker", null, r21, r21.isOpen(), null, 18);
    L194:
        int r46 = KmpToastUtil.a;
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        if (r21.isOpen() == false) goto L197;
        String r47 = "主播已开启对连线用户的送礼功能";
    L198:
        KmpToastUtil.a(r47, 0);
        goto L110
    L197:
        r47 = "主播已关闭对连线用户的送礼功能";
        goto L198
    L199:
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.c.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[1], Boolean.valueOf(r21.isOpen()));
        goto L110
    L200:
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.i.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[7], Boolean.valueOf(r21.isOpen()));
        a r125 = r2.b;
        if (r125 == null) goto L110;
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        a.C0215a.a(r125, "data_video_talk_apply_need_verify", null, r21, r21.isOpen(), null, 18);
        goto L110
    L134:
        switch(r23) {
            case 16: goto L212;
            case 17: goto L211;
            case 18: goto L203;
            default: goto L135;
        };
    L203:
        int r48 = com.bytedance.android.live.multilink.impl.control.b.a.a(r2.f);
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        b.k(r48, "data_audio_chat_support_send_gift_to_linker", r21.isOpen());
        a r126 = r2.b;
        if (r126 == null) goto L206;
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        a.C0215a.a(r126, "data_audio_chat_support_send_gift_to_linker", null, r21, r21.isOpen(), null, 18);
    L206:
        int r49 = KmpToastUtil.a;
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        if (r21.isOpen() == false) goto L209;
        String r50 = "主播已开启对连线用户的送礼功能";
    L210:
        KmpToastUtil.a(r50, 0);
        goto L110
    L209:
        r50 = "主播已关闭对连线用户的送礼功能";
        goto L210
    L211:
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.e.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[3], Boolean.valueOf(r21.isOpen()));
        goto L110
    L212:
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.h.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[6], Boolean.valueOf(r21.isOpen()));
        a r127 = r2.b;
        if (r127 == null) goto L110;
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        a.C0215a.a(r127, "data_voice_talk_apply_need_verify", null, r21, r21.isOpen(), null, 18);
        goto L110
    L135:
        switch(r23) {
            case 52: goto L230;
            case 53: goto L226;
            case 54: goto L221;
            case 55: goto L216;
            default: goto L110;
        };
    L216:
        if (vm2.e.f() == true) goto L110;
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.C.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[27], Boolean.valueOf(r21.isOpen()));
        a r128 = r2.b;
        if (r128 == null) goto L110;
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        a.C0215a.a(r128, null, 55, r21, r21.isOpen(), null, 17);
        goto L110
    L221:
        if (vm2.e.f() == true) goto L110;
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.B.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[26], Boolean.valueOf(r21.isOpen()));
        a r129 = r2.b;
        if (r129 == null) goto L110;
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        a.C0215a.a(r129, null, 54, r21, r21.isOpen(), null, 17);
        goto L110
    L226:
        if (vm2.e.f() == true) goto L110;
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.A.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[25], Boolean.valueOf(r21.isOpen()));
        a r51 = r2.b;
        if (r51 == null) goto L110;
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        a.C0215a.a(r51, null, 53, r21, r21.isOpen(), null, 17);
        goto L110
    L230:
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.y.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[23], Boolean.valueOf(r21.isOpen()));
    L268:
        Intrinsics.checkNotNullParameter(r21, "$this$isOpenExt");
        com.bytedance.android.livesdk.sharedpref.d.c0.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[53], Boolean.valueOf(r21.isOpen()));
        goto L110
    L431:
        return;
    L270:
        return;
    L103:
        r18 = false;
        goto L104
    L27:
        if (r14.isEmpty() == true) goto L99;
        Iterator<T> r52 = r14.iterator();
        int r53 = -1;
        int r54 = -1;
        int r130 = -1;
        int r131 = -1;
        int r132 = -1;
    L31:
        if (r52.hasNext() == false) goto L86;
        y r133 = (y) r52.next();
        int r134 = r133.getKey();
        if (r134 != 51) goto L35;
        r130 = r133.getValue();
        if (r133.getValue() == 0) goto L61;
        com.bytedance.android.livesdk.sharedpref.d.J.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[r15], Integer.valueOf(r133.getValue()));
    L61:
        if (r133.getContent() == null) goto L84;
        p1 r55 = r133.getContent();
        if (r55 == null) goto L65;
        l r56 = r55.getApplicationReasonContent();
    L66:
        if (r56 == null) goto L84;
        p1 r57 = r133.getContent();
        String r135 = "";
        if (r57 == null) goto L73;
        l r58 = r57.getApplicationReasonContent();
        if (r58 == null) goto L73;
        String r59 = r58.getManualReason();
        if (r59 == null) goto L73;
    L74:
        KProperty[] r136 = com.bytedance.android.livesdk.sharedpref.d.a;
        Intrinsics.checkNotNullParameter(r59, "<set-?>");
        com.bytedance.tools.kcp.spongepreference.runtime.a r60 = com.bytedance.android.livesdk.sharedpref.d.U;
        KProperty[] r137 = com.bytedance.android.livesdk.sharedpref.d.a;
        r60.setValue(null, r137[45], r59);
        p1 r61 = r133.getContent();
        if (r61 == null) goto L82;
        l r62 = r61.getApplicationReasonContent();
        if (r62 == null) goto L82;
        String r63 = r62.getDefaultReason();
        if (r63 == null) goto L82;
        r135 = r63;
    L82:
        Intrinsics.checkNotNullParameter(r135, "<set-?>");
        com.bytedance.android.livesdk.sharedpref.d.V.setValue(null, r137[46], r135);
    L73:
        r59 = "";
        goto L74
    L65:
        r56 = null;
    L84:
        r52 = r52;
        r15 = '\"';
        goto L31
    L35:
        if (r134 != 89) goto L36;
        a r138 = r2.b;
        if (r138 == null) goto L56;
        Intrinsics.checkNotNullParameter(r133, "$this$isOpenExt");
        a.C0215a.a(r138, null, 89, r133, r133.isOpen(), null, 17);
    L56:
        com.bytedance.android.livesdk.sharedpref.d.T.setValue(null, com.bytedance.android.livesdk.sharedpref.d.a[44], Integer.valueOf(r133.getValue()));
        goto L31
    L36:
        switch(r134) {
            case 41: goto L42;
            case 42: goto L41;
            case 43: goto L40;
            case 44: goto L39;
            default: goto L37;
        };
    L39:
        r132 = r133.getValue();
        com.bytedance.android.livesdk.sharedpref.d.o(r133.getValue());
        goto L31
    L40:
        r131 = r133.getValue();
        com.bytedance.android.livesdk.sharedpref.d.p(r133.getValue());
        goto L31
    L41:
        r54 = r133.getValue();
        com.bytedance.android.livesdk.sharedpref.d.f(r133.getValue());
        goto L31
    L42:
        r53 = r133.getValue();
        com.bytedance.android.livesdk.sharedpref.d.j(r133.getValue());
        goto L31
    L37:
        switch(r134) {
            case 63: goto L49;
            case 64: goto L48;
            case 65: goto L47;
            case 66: goto L43;
            default: goto L31;
        };
    L43:
        a r139 = r2.b;
        if (r139 == null) goto L46;
        Intrinsics.checkNotNullParameter(r133, "$this$isOpenExt");
        a.C0215a.a(r139, null, 66, r133, r133.isOpen(), null, 17);
    L46:
        b.h(r133);
        goto L31
    L47:
        b.i(r133);
        goto L31
    L48:
        b.j(r133);
        goto L31
    L49:
        a r140 = r2.b;
        if (r140 == null) goto L52;
        Intrinsics.checkNotNullParameter(r133, "$this$isOpenExt");
        a.C0215a.a(r140, null, 63, r133, r133.isOpen(), null, 17);
    L52:
        b.g(r133);
        goto L31
    L86:
        if (r53 >= 0) goto L89;
        if (r54 >= 0) goto L89;
        if (r130 >= 0) goto L89;
    L93:
        if (r131 >= 0) goto L95;
        if (r132 < 0) goto L99;
    L95:
        a r65 = r2.b;
        if (r65 == null) goto L98;
        ((LinkMultiControlPresenter) r65).C0(PaidLinkConfigType.VideoTalk);
    L98:
        jy0.b.d("ttlive_link_paid", "videoTalkConfig msg ");
    L89:
        a r66 = r2.b;
        if (r66 == null) goto L92;
        ((LinkMultiControlPresenter) r66).C0(PaidLinkConfigType.InteractAudience);
    L92:
        jy0.b.d("ttlive_link_paid", "interactAudienceConfig msg ");
        goto L93
    }
}
