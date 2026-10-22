package com.bytedance.android.live.liveinteract.animation.universalwidget.utils;

import ch0.h;
import ch0.j;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkAudioFirstUserViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkAudioFirstUserVirtualAvatarViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.g0;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.livesdk.link.model.bridge.Linkmic2DAvatar;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.Map;
import je0.d;
import kd1.b;
import kd1.c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import nh0.f;
import py.k;
import py.t;
import tf0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class ListDiffUtils {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(List r8, List r9) {
        Intrinsics.checkNotNullParameter(r9, "itemData");
        if (r8 != null) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r8, r9) == false) goto L9;
        return true;
    L9:
        if (r8.size() == r9.size()) goto L11;
        return false;
    L11:
        int r1 = r9.size();
        int r3 = 0;
    L12:
        if (r3 >= r1) goto L25;
        e r4 = (e) ListProtector.get(r8, r3);
        e r5 = (e) ListProtector.get(r9, r3);
        if ((!Intrinsics.areEqual(r4.getClass(), r5.getClass())) == true) goto L15;
        if ((r5 instanceof MultiLinkGuestViewBinder.a) == false) goto L24;
        if ((r4 instanceof MultiLinkGuestViewBinder.a) == false) goto L24;
        MultiLinkGuestViewBinder.a r6 = (MultiLinkGuestViewBinder.a) r5;
        if (((MultiLinkGuestViewBinder.a) r4).k.a.getFanTicketDisplayStr().equals(r6.k.a.getFanTicketDisplayStr()) == false) goto L22;
        r6.k.d.get("EXT_KEY_QUICK_INTERACT_TASK");
        goto L24
    L22:
        return false;
    L24:
        r3 = r3 + 1;
        goto L12
    L15:
        return false;
    L25:
        return true;
    }

    public static boolean c(List r17, List r18) {
        Intrinsics.checkNotNullParameter(r18, "itemData");
        if (r17 != null) goto L5;
        return false;
    L5:
        boolean r4 = true;
        if (Intrinsics.areEqual(r17, r18) == false) goto L9;
        return true;
    L9:
        if (r17.size() == r18.size()) goto L11;
        return false;
    L11:
        int r3 = r18.size();
        int r5 = 0;
    L12:
        if (r5 >= r3) goto L268;
        e r6 = (e) ListProtector.get(r17, r5);
        e r7 = (e) ListProtector.get(r18, r5);
        if ((Intrinsics.areEqual(r6.getClass(), r7.getClass()) ^ r4) == false) goto L24;
        if ((r6 instanceof MultiLinkGuestViewBinder.a) == true) goto L18;
    L20:
        boolean r8 = false;
    L21:
        if (r8 == true) goto L24;
        return false;
    L18:
        if ((r7 instanceof MultiLinkGuestViewBinder.a) == false) goto L20;
        r8 = true;
    L24:
        if ((r7 instanceof MultiLinkGuestViewBinder.a) == false) goto L267;
        if ((r6 instanceof MultiLinkGuestViewBinder.a) == false) goto L267;
        MultiLinkGuestViewBinder.a r9 = (MultiLinkGuestViewBinder.a) r7;
        IBaseUser r10 = r9.k.a.getUser();
        if (r10 == null) goto L30;
        final String r11 = r10.getIdString();
    L31:
        MultiLinkGuestViewBinder.a r12 = (MultiLinkGuestViewBinder.a) r6;
        IBaseUser r13 = r12.k.a.getUser();
        if (r13 == null) goto L34;
        final String r14 = r13.getIdString();
    L36:
        if (d(r11, r14, new ListDiffUtils$isUserItemDataEquals$1(r11, r14)) == true) goto L37;
        if (r12.k.a.getLinkType() != r9.k.a.getLinkType()) goto L41;
        boolean r15 = true;
    L42:
        h r16 = r12.k.b;
        if (r16 == null) goto L45;
        Boolean r19 = Boolean.valueOf(r16.c);
    L46:
        h r110 = r9.k.b;
        if (r110 == null) goto L49;
        Boolean r111 = Boolean.valueOf(r110.c);
    L50:
        boolean r112 = Intrinsics.areEqual(r19, r111);
        j r113 = r12.k.c;
        if (r113 == null) goto L53;
        Integer r114 = Integer.valueOf(r113.c);
    L54:
        j r115 = r9.k.c;
        if (r115 == null) goto L57;
        Integer r116 = Integer.valueOf(r115.c);
    L58:
        boolean r117 = Intrinsics.areEqual(r114, r116);
        if (((Boolean) vm2.h.y6.getValue(null, vm2.h.a[387(0x183, float:5.42E-43)])).booleanValue() == false) goto L63;
        int r20 = f.i;
        if (f.a.a(r12.k) == f.a.a(r9.k)) goto L66;
    L67:
        boolean r21 = false;
    L68:
        if (r21 == false) goto L69;
        ILinkPlayerInfoBridge r22 = r9.k.a;
        if (r22 != null) goto L73;
    L76:
        final boolean r23 = true;
    L77:
        ILinkPlayerInfoBridge r118 = r9.k.a;
        if (r118 != null) goto L80;
    L83:
        final boolean r119 = true;
    L85:
        if (d(Boolean.valueOf(r23), Boolean.valueOf(r119), new ListDiffUtils$isUserItemDataEquals$2(r23, r119)) == true) goto L86;
        final long r120 = r9.k.a.getSelfDisciplineDuration();
        final long r121 = r12.k.a.getSelfDisciplineDuration();
        if (d(Long.valueOf(r120), Long.valueOf(r121), new ListDiffUtils$isUserItemDataEquals$3(r120, r121)) == true) goto L89;
        ILinkPlayerInfoBridge r24 = r12.k.a;
        ILinkPlayerInfoBridge r25 = r9.k.a;
        IBaseUser r26 = r24.getUser();
        if (r26 == null) goto L95;
        t r27 = r26.getUserAttr();
        if (r27 == null) goto L95;
        Boolean r28 = Boolean.valueOf(r27.isAdmin());
    L96:
        IBaseUser r29 = r25.getUser();
        if (r29 == null) goto L101;
        t r30 = r29.getUserAttr();
        if (r30 == null) goto L101;
        Boolean r31 = Boolean.valueOf(r30.isAdmin());
    L103:
        if (Intrinsics.areEqual(r28, r31) == false) goto L104;
        if (r12.k.a.getSilenceStatus() != r9.k.a.getSilenceStatus()) goto L108;
        boolean r32 = true;
    L109:
        if (r32 == false) goto L266;
        ILinkPlayerInfoBridge r33 = r12.k.a;
        ILinkPlayerInfoBridge r34 = r9.k.a;
        if (r33.isBackground() == r34.isBackground()) goto L113;
    L115:
        boolean r35 = false;
    L116:
        if (r35 == false) goto L266;
        ILinkPlayerInfoBridge r36 = r12.k.a;
        ILinkPlayerInfoBridge r37 = r9.k.a;
        if (r36.getRoomLinkSilenceStatus() == r37.getRoomLinkSilenceStatus()) goto L121;
    L143:
        boolean r38 = false;
    L144:
        if (r38 == false) goto L145;
        g0 r39 = r9.k.a.getMicPosTagInfo();
        if (r39 == null) goto L149;
        String r40 = r39.getPositionTagName();
    L150:
        g0 r41 = r12.k.a.getMicPosTagInfo();
        if (r41 == null) goto L153;
        String r42 = r41.getPositionTagName();
    L155:
        if ((!Intrinsics.areEqual(r40, r42)) == true) goto L156;
        ILinkPlayerInfoBridge r43 = r12.k.a;
        ILinkPlayerInfoBridge r44 = r9.k.a;
        b r45 = r43.getMicDress();
        b r46 = r44.getMicDress();
        if (r45 == r46) goto L203;
        if (r45 != null) goto L163;
        if (r46 == null) goto L163;
    L204:
        boolean r47 = false;
    L205:
        if (r47 == false) goto L206;
        if (r12.k.a.getExpectLeaveTime() != r9.k.a.getExpectLeaveTime()) goto L210;
        boolean r48 = true;
    L211:
        if (r48 == false) goto L212;
        final boolean r49 = r7.j;
        final boolean r50 = r6.j;
        if (d(Boolean.valueOf(r49), Boolean.valueOf(r50), new ListDiffUtils$isUserItemDataEquals$4(r49, r50)) == true) goto L215;
        Integer r51 = d.h();
        if (r51 == null) goto L225;
        if (r51.intValue() != 28) goto L225;
        if (r9.k.a.isEnlarged() == r12.k.a.isEnlarged()) goto L225;
        return false;
    L225:
        if (r12.k.a.isEnlarged() != r9.k.a.isEnlarged()) goto L227;
        boolean r52 = true;
    L228:
        if (r52 == false) goto L229;
        if (MultiLinkLoadWidgetUtils.k() == false) goto L267;
        ILinkPlayerInfoBridge r53 = r12.k.a;
        ILinkPlayerInfoBridge r54 = r9.k.a;
        Linkmic2DAvatar r55 = r53.getLinkmic2DAvatar();
        if (r55 == null) goto L235;
        k r56 = r55.getImage();
    L236:
        if (r56 != null) goto L243;
        Linkmic2DAvatar r57 = r54.getLinkmic2DAvatar();
        if (r57 == null) goto L240;
        k r58 = r57.getImage();
    L241:
        if (r58 != null) goto L243;
    L242:
        boolean r59 = true;
    L265:
        if (r59 == true) goto L267;
    L240:
        r58 = null;
    L243:
        Linkmic2DAvatar r60 = r53.getLinkmic2DAvatar();
        if (r60 == null) goto L246;
        Boolean r61 = r60.getEnableAvatar();
    L247:
        Linkmic2DAvatar r62 = r54.getLinkmic2DAvatar();
        if (r62 == null) goto L250;
        Boolean r63 = r62.getEnableAvatar();
    L252:
        if (Intrinsics.areEqual(r61, r63) == false) goto L264;
        Linkmic2DAvatar r65 = r53.getLinkmic2DAvatar();
        if (r65 == null) goto L264;
        k r66 = r65.getImage();
        if (r66 == null) goto L264;
        Linkmic2DAvatar r67 = r54.getLinkmic2DAvatar();
        if (r67 == null) goto L260;
        k r122 = r67.getImage();
    L262:
        if (r66.equalsOnlyUri(r122) != true) goto L264;
    L260:
        r122 = null;
    L264:
        r59 = false;
        goto L265
    L250:
        r63 = null;
        goto L252
    L246:
        r61 = null;
        goto L247
    L235:
        r56 = null;
        goto L236
    L229:
        return false;
    L227:
        r52 = false;
        goto L228
    L215:
        return false;
    L212:
        return false;
    L210:
        r48 = false;
        goto L211
    L206:
        return false;
    L163:
        if (r45 == null) goto L166;
        if (r46 == null) goto L204;
    L166:
        if (r46 == null) goto L204;
        if (r45 == null) goto L169;
        Class<?> r123 = r45.getClass();
    L171:
        if ((!Intrinsics.areEqual(r123, r46.getClass())) == true) goto L204;
        c r124 = r45.getVoiceWave();
        if (r124 == null) goto L176;
        String r125 = r124.getDressId();
    L177:
        c r126 = r46.getVoiceWave();
        if (r126 == null) goto L180;
        String r127 = r126.getDressId();
    L182:
        if (Intrinsics.areEqual(r125, r127) == false) goto L204;
        kd1.a r128 = r45.getBadge();
        if (r128 == null) goto L186;
        String r129 = r128.getDressId();
    L187:
        kd1.a r130 = r46.getBadge();
        if (r130 == null) goto L190;
        String r131 = r130.getDressId();
    L192:
        if (Intrinsics.areEqual(r129, r131) == false) goto L204;
        kd1.a r68 = r45.getBadge();
        if (r68 == null) goto L196;
        Integer r69 = Integer.valueOf(r68.getShowType());
    L197:
        kd1.a r70 = r46.getBadge();
        if (r70 == null) goto L200;
        Integer r71 = Integer.valueOf(r70.getShowType());
    L202:
        if (Intrinsics.areEqual(r69, r71) == false) goto L204;
    L200:
        r71 = null;
        goto L202
    L196:
        r69 = null;
        goto L197
    L190:
        r131 = null;
        goto L192
    L186:
        r129 = null;
        goto L187
    L180:
        r127 = null;
        goto L182
    L176:
        r125 = null;
        goto L177
    L169:
        r123 = null;
    L203:
        r47 = true;
        goto L205
    L156:
        return false;
    L153:
        r42 = null;
        goto L155
    L149:
        r40 = null;
        goto L150
    L145:
        return false;
    L121:
        if (r36.getLinkRoomId() != r37.getLinkRoomId()) goto L143;
        Map.Entry<Long, g2> r132 = r36.getOtherRoomInfo();
        Map.Entry<Long, g2> r133 = r37.getOtherRoomInfo();
        if (r132 != null) goto L127;
        if (r133 != null) goto L143;
    L127:
        if (r132 == null) goto L130;
        if (r133 == null) goto L143;
    L130:
        if (r132 == null) goto L142;
        if (r133 == null) goto L142;
        if (Intrinsics.areEqual(r132.getValue().getAnchorIdString(), r133.getValue().getAnchorIdString()) == false) goto L143;
        if (r132.getValue().getRoomLinkSilenceStatus() != r133.getValue().getRoomLinkSilenceStatus()) goto L143;
        if (r36.getRoomLinkSilenceStatus() != r37.getRoomLinkSilenceStatus()) goto L143;
        if (r132.getKey().longValue() != r133.getKey().longValue()) goto L143;
    L142:
        r38 = true;
        goto L144
    L113:
        if (r33.isSelfBackground() != r34.isSelfBackground()) goto L115;
        r35 = true;
    L266:
        return false;
    L108:
        r32 = false;
        goto L109
    L104:
        return false;
    L101:
        r31 = null;
    L95:
        r28 = null;
        goto L96
    L89:
        return false;
    L86:
        return false;
    L80:
        if (r118.getSilenceStatus() != 0) goto L83;
        r119 = false;
        goto L85
    L73:
        if (r22.getSilenceStatus() != 0) goto L76;
        r23 = false;
        goto L77
    L69:
        return false;
    L66:
        r21 = true;
        goto L68
    L63:
        if (r15 == false) goto L67;
        if (r112 == false) goto L67;
        if (r117 == false) goto L67;
    L57:
        r116 = null;
        goto L58
    L53:
        r114 = null;
        goto L54
    L49:
        r111 = null;
        goto L50
    L45:
        r19 = null;
        goto L46
    L41:
        r15 = false;
        goto L42
    L37:
        return false;
    L34:
        r14 = null;
        goto L36
    L30:
        r11 = null;
    L267:
        r5 = r5 + 1;
        r4 = true;
        goto L12
    L268:
        return r4;
    }

    public static boolean d(Object r0, Object r1, Function0 r2) {
        if (r0 == null) goto L7;
        if (r1 != null) goto L6;
        return false;
    L6:
        return ((Boolean) r2.invoke()).booleanValue();
    L7:
        return false;
    }

    public static boolean b(List r11, int r12, List r13, int r14) {
        Intrinsics.checkNotNullParameter(r13, "itemData");
        if (r11 != null) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r11, r13) == false) goto L9;
        return true;
    L9:
        if (r11.size() == r13.size()) goto L12;
        return false;
    L12:
        if (r11.isEmpty() == false) goto L14;
        return true;
    L14:
        if (r12 == r14) goto L16;
        return false;
    L16:
        e r15 = (e) ListProtector.get(r11, 0);
        e r16 = (e) ListProtector.get(r13, 0);
        boolean r17 = r15 instanceof MultiLinkAudioFirstUserVirtualAvatarViewBinder.a;
        if (r17 == false) goto L19;
    L21:
        if (r17 == true) goto L23;
    L25:
        Boolean r3 = null;
        String r4 = "";
        if (r17 == false) goto L83;
        if ((r16 instanceof MultiLinkAudioFirstUserVirtualAvatarViewBinder.a) == false) goto L83;
        MultiLinkAudioFirstUserVirtualAvatarViewBinder.a r18 = (MultiLinkAudioFirstUserVirtualAvatarViewBinder.a) r15;
        Linkmic2DAvatar r5 = r18.k.a.getLinkmic2DAvatar();
        if (r5 == null) goto L37;
        k r6 = r5.getImage();
        if (r6 == null) goto L37;
        List r7 = r6.getUrls();
        if (r7 == null) goto L37;
        String r8 = (String) CollectionsKt.firstOrNull(r7);
        if (r8 == null) goto L37;
    L38:
        MultiLinkAudioFirstUserVirtualAvatarViewBinder.a r9 = (MultiLinkAudioFirstUserVirtualAvatarViewBinder.a) r16;
        Linkmic2DAvatar r10 = r9.k.a.getLinkmic2DAvatar();
        if (r10 == null) goto L46;
        k r19 = r10.getImage();
        if (r19 == null) goto L46;
        List r20 = r19.getUrls();
        if (r20 == null) goto L46;
        String r21 = (String) CollectionsKt.firstOrNull(r20);
        if (r21 == null) goto L46;
    L47:
        Linkmic2DAvatar r22 = r18.k.a.getLinkmic2DAvatar();
        if (r22 == null) goto L50;
        Boolean r23 = r22.getEnableAvatar();
    L51:
        Boolean r24 = Boolean.TRUE;
        if (Intrinsics.areEqual(r23, r24) == true) goto L54;
    L59:
        boolean r25 = false;
    L60:
        Linkmic2DAvatar r110 = r9.k.a.getLinkmic2DAvatar();
        if (r110 == null) goto L63;
        Boolean r111 = r110.getEnableAvatar();
    L65:
        if (Intrinsics.areEqual(r111, r24) == true) goto L67;
    L72:
        boolean r26 = false;
    L73:
        if (r25 == r26) goto L75;
        return false;
    L75:
        if (r25 == true) goto L77;
    L79:
        InteractiveSongContext.a r27 = InteractiveSongContext.Companion;
        if (InteractiveSongContext.a.d(r27, r18.k, r14, false, 4) == InteractiveSongContext.a.d(r27, r9.k, r14, false, 4)) goto L83;
        return false;
    L77:
        if ((!Intrinsics.areEqual(r8, r21)) == false) goto L79;
        return false;
    L67:
        if (r21.length() <= 0) goto L69;
        boolean r28 = true;
    L70:
        if (r28 == false) goto L72;
        r26 = true;
        goto L73
    L69:
        r28 = false;
        goto L70
    L63:
        r111 = null;
        goto L65
    L54:
        if (r8.length() <= 0) goto L56;
        boolean r29 = true;
    L57:
        if (r29 == false) goto L59;
        r25 = true;
        goto L60
    L56:
        r29 = false;
        goto L57
    L50:
        r23 = null;
    L46:
        r21 = "";
    L37:
        r8 = "";
    L83:
        if (r14 != 30) goto L149;
        boolean r112 = r15 instanceof MultiLinkAudioFirstUserViewBinder.a;
        if (r112 == false) goto L87;
    L89:
        if (r112 == true) goto L91;
    L93:
        if (r112 == false) goto L149;
        if ((r16 instanceof MultiLinkAudioFirstUserViewBinder.a) == false) goto L149;
        MultiLinkAudioFirstUserViewBinder.a r113 = (MultiLinkAudioFirstUserViewBinder.a) r15;
        Linkmic2DAvatar r114 = r113.k.a.getLinkmic2DAvatar();
        if (r114 == null) goto L104;
        k r115 = r114.getImage();
        if (r115 == null) goto L104;
        List r116 = r115.getUrls();
        if (r116 == null) goto L104;
        String r117 = (String) CollectionsKt.firstOrNull(r116);
        if (r117 == null) goto L104;
    L105:
        MultiLinkAudioFirstUserViewBinder.a r118 = (MultiLinkAudioFirstUserViewBinder.a) r16;
        Linkmic2DAvatar r30 = r118.k.a.getLinkmic2DAvatar();
        if (r30 == null) goto L115;
        k r31 = r30.getImage();
        if (r31 == null) goto L115;
        List r32 = r31.getUrls();
        if (r32 == null) goto L115;
        String r33 = (String) CollectionsKt.firstOrNull(r32);
        if (r33 == null) goto L115;
        r4 = r33;
    L115:
        Linkmic2DAvatar r34 = r113.k.a.getLinkmic2DAvatar();
        if (r34 == null) goto L118;
        Boolean r35 = r34.getEnableAvatar();
    L119:
        Boolean r36 = Boolean.TRUE;
        if (Intrinsics.areEqual(r35, r36) == true) goto L122;
    L127:
        boolean r37 = false;
    L128:
        Linkmic2DAvatar r38 = r118.k.a.getLinkmic2DAvatar();
        if (r38 == null) goto L132;
        r3 = r38.getEnableAvatar();
    L132:
        if (Intrinsics.areEqual(r3, r36) == true) goto L134;
    L139:
        boolean r39 = false;
    L140:
        if (r37 == r39) goto L142;
        return false;
    L142:
        if (r37 == true) goto L144;
    L146:
        InteractiveSongContext.a r119 = InteractiveSongContext.Companion;
        if (InteractiveSongContext.a.d(r119, r113.k, r14, false, 4) == InteractiveSongContext.a.d(r119, r118.k, r14, false, 4)) goto L149;
        return false;
    L144:
        if ((!Intrinsics.areEqual(r117, r4)) == false) goto L146;
        return false;
    L134:
        if (r4.length() <= 0) goto L136;
        boolean r40 = true;
    L137:
        if (r40 == false) goto L139;
        r39 = true;
        goto L140
    L136:
        r40 = false;
        goto L137
    L122:
        if (r117.length() <= 0) goto L124;
        boolean r41 = true;
    L125:
        if (r41 == false) goto L127;
        r37 = true;
        goto L128
    L124:
        r41 = false;
        goto L125
    L118:
        r35 = null;
    L104:
        r117 = "";
        goto L105
    L91:
        if ((r16 instanceof MultiLinkAudioFirstUserViewBinder.a) == true) goto L93;
        return false;
    L87:
        if ((r16 instanceof MultiLinkAudioFirstUserViewBinder.a) == false) goto L89;
        return false;
    L149:
        return true;
    L23:
        if ((r16 instanceof MultiLinkAudioFirstUserVirtualAvatarViewBinder.a) == true) goto L25;
        return false;
    L19:
        if ((r16 instanceof MultiLinkAudioFirstUserVirtualAvatarViewBinder.a) == false) goto L21;
        return false;
    }
}
