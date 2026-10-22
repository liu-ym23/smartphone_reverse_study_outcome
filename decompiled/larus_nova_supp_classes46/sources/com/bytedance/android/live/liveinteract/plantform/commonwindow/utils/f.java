package com.bytedance.android.live.liveinteract.plantform.commonwindow.utils;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.setting.v2;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarContext;
import com.bytedance.android.live.liveinteract.digitavatar.c0;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.chatroom.interact.model.e0;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.MultiLinkFrequencyOptConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import com.bytedance.live.datacontext.j;
import java.util.List;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import rj0.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f {
    public static final MultiLinkFrequencyOptConfig a = null;

    static {
        a = (MultiLinkFrequencyOptConfig) v2.a.getValue();
    }

    public static boolean d() {
        int r0 = je0.d.f();
        Integer r1 = je0.d.h();
        j r2 = m.d().getVideoTalkRoomSubScene();
        if (r2 == null) goto L16;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r3 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r2.getValue();
        if (r3 == null) goto L16;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r4 = r3.t();
        if (r4 == null) goto L16;
        List r5 = r4.b;
        if (r5 == null) goto L16;
        if (r5.contains(4) == true) goto L14;
        r5 = null;
    L14:
        if (r5 == null) goto L16;
        boolean r6 = true;
    L18:
        if (r0 != 12) goto L29;
        if (r1 != null) goto L22;
    L23:
        if (r1 == null) goto L29;
        if (r1.intValue() != 112) goto L29;
        return false;
    L22:
        if (r1.intValue() != 6) goto L23;
        return false;
    L29:
        return r6;
    L16:
        r6 = false;
        goto L18
    }

    public static boolean b(Integer r1) {
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.intValue() != 28) goto L7;
        return true;
    }

    public static boolean j(Integer r1) {
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.intValue() != 29) goto L7;
        return true;
    }

    public static boolean a(ch0.e r10, String r11) {
        String r1 = null;
        if (a.getFreqFuncOpt() == false) goto L9;
        ILiveRoomService r0 = k.f(ILiveRoomService.class);
        if (r0 == null) goto L14;
        Room r2 = r0.getCurrentRoom();
        if (r2 == null) goto L14;
        String r3 = r2.getOwnerUserIdString();
    L16:
        if (r3 != null) goto L18;
    L21:
        boolean r4 = true;
    L22:
        if (r4 == true) goto L25;
        r11 = r3;
    L25:
        if (r10 == null) goto L27;
        boolean r5 = ch0.f.c(r10);
    L28:
        if (r10 == null) goto L30;
        boolean r6 = ch0.f.d(r10);
    L31:
        if (r10 == null) goto L33;
        ILinkPlayerInfoBridge r7 = r10.a;
    L35:
        if (c0.a == false) goto L84;
        if (c0.b == true) goto L39;
    L111:
        boolean r8 = false;
    L112:
        if (r10 == null) goto L117;
        ILinkPlayerInfoBridge r9 = r10.a;
        if (r9 == null) goto L117;
        if (r9.isBackground() == true) goto L117;
    L135:
        boolean r12 = true;
    L137:
        if (r10 == null) goto L143;
        ILinkPlayerInfoBridge r13 = r10.a;
        if (r13 == null) goto L143;
        IBaseUser r14 = r13.getUser();
        if (r14 == null) goto L143;
        String r15 = r14.getIdString();
    L145:
        if (Intrinsics.areEqual(r11, r15) == true) goto L147;
    L149:
        boolean r16 = false;
    L151:
        if (Intrinsics.areEqual("local_test", k.n(IMiddleWareHostContext.class).getChannel()) == true) goto L153;
    L171:
        if (r5 == false) goto L177;
        if (r6 == true) goto L174;
        if (r16 == false) goto L177;
    L174:
        if (r8 == true) goto L177;
        if (r12 == false) goto L177;
        return true;
    L177:
        return false;
    L153:
        if (((Boolean) vm2.d.B3.getValue(null, vm2.d.a[233(0xe9, float:3.27E-43)])).booleanValue() == false) goto L171;
        j r17 = m.i().A2();
        if (r17 == null) goto L159;
        DataCenter r18 = (DataCenter) r17.getValue();
        if (r18 == null) goto L159;
        Boolean r19 = (Boolean) r18.get("data_multi_link_start_mock_video", Boolean.TRUE);
    L161:
        if (Intrinsics.areEqual(r19, Boolean.TRUE) == false) goto L171;
        if (r10 == null) goto L169;
        ILinkPlayerInfoBridge r110 = r10.a;
        if (r110 == null) goto L169;
        IBaseUser r111 = r110.getUser();
        if (r111 == null) goto L169;
        r1 = r111.getIdString();
    L169:
        if (Intrinsics.areEqual(r1, je0.d.b0()) == false) goto L171;
        r6 = true;
    L159:
        r19 = null;
        goto L161
    L147:
        if (((Boolean) vm2.d.Y1.getValue(null, vm2.d.a[152(0x98, float:2.13E-43)])).booleanValue() == false) goto L149;
        r16 = true;
    L143:
        r15 = null;
    L117:
        if (r10 == null) goto L126;
        ILinkPlayerInfoBridge r20 = r10.a;
        if (r20 == null) goto L126;
        if (r20.isSelfBackground() == true) goto L126;
        l.n2.getClass();
        l r21 = l.a.a();
        if (r21 == null) goto L126;
        if (r21.isEngineOn() == true) goto L135;
    L126:
        if (r10 == null) goto L132;
        ILinkPlayerInfoBridge r22 = r10.a;
        if (r22 == null) goto L132;
        IBaseUser r23 = r22.getUser();
        if (r23 == null) goto L132;
        String r24 = r23.getIdString();
    L134:
        if (Intrinsics.areEqual(r24, je0.d.b0()) == true) goto L135;
        r12 = false;
    L132:
        r24 = null;
        goto L134
    L39:
        if (c0.d != null) goto L41;
        c0.d = m.i();
    L41:
        o r25 = c0.d;
        if (r25 == null) goto L44;
        Boolean r26 = r25.isAnchor();
    L46:
        if ((!Intrinsics.areEqual(r26, Boolean.TRUE)) == false) goto L111;
        if (r7 == null) goto L51;
        IBaseUser r27 = r7.getUser();
        if (r27 == null) goto L51;
        String r28 = r27.getIdString();
    L53:
        if (c0.e != null) goto L56;
        c0.e = je0.d.b0();
    L56:
        if (Intrinsics.areEqual(r28, c0.e) == false) goto L111;
        if (c0.c != null) goto L60;
        c0.c = DigitAvatarContext.Companion.getContext();
    L60:
        DigitAvatarContext r29 = c0.c;
        if (r29 == null) goto L63;
        VideoShowMode r30 = r29.getCurrentVideoShowMode();
    L65:
        if (r30 != VideoShowMode.DIGIT_AVATAR) goto L111;
        if (c0.c != null) goto L69;
        c0.c = DigitAvatarContext.Companion.getContext();
    L69:
        DigitAvatarContext r31 = c0.c;
        if (r31 == null) goto L72;
        VideoShowMode r32 = r31.getLastVideoShowMode();
    L74:
        if (r32 == VideoShowMode.VIDEO) goto L111;
        if (c0.c != null) goto L78;
        c0.c = DigitAvatarContext.Companion.getContext();
    L78:
        DigitAvatarContext r33 = c0.c;
        if (r33 == null) goto L111;
        if (r33.getIsDigitAvatarLoading() != true) goto L111;
    L110:
        r8 = true;
        goto L112
    L72:
        r32 = null;
        goto L74
    L63:
        r30 = null;
    L51:
        r28 = null;
        goto L53
    L44:
        r26 = null;
        goto L46
    L84:
        if (vm2.e.d() == false) goto L111;
        if ((!Intrinsics.areEqual(m.i().isAnchor(), Boolean.TRUE)) == false) goto L111;
        if (r7 == null) goto L91;
        IBaseUser r34 = r7.getUser();
        if (r34 == null) goto L91;
        String r35 = r34.getIdString();
    L93:
        if (Intrinsics.areEqual(r35, je0.d.b0()) == false) goto L111;
        DigitAvatarContext.a r36 = DigitAvatarContext.Companion;
        DigitAvatarContext r37 = r36.getContext();
        if (r37 == null) goto L97;
        VideoShowMode r38 = r37.getCurrentVideoShowMode();
    L99:
        if (r38 != VideoShowMode.DIGIT_AVATAR) goto L111;
        DigitAvatarContext r39 = r36.getContext();
        if (r39 == null) goto L103;
        VideoShowMode r40 = r39.getLastVideoShowMode();
    L105:
        if (r40 == VideoShowMode.VIDEO) goto L111;
        DigitAvatarContext r41 = r36.getContext();
        if (r41 == null) goto L111;
        if (r41.getIsDigitAvatarLoading() != true) goto L111;
    L103:
        r40 = null;
        goto L105
    L97:
        r38 = null;
    L91:
        r35 = null;
        goto L93
    L33:
        r7 = null;
        goto L35
    L30:
        r6 = false;
        goto L31
    L27:
        r5 = false;
        goto L28
    L18:
        if (r3.length() == 0) goto L21;
        r4 = false;
    L14:
        r3 = null;
        goto L16
    L9:
        com.bytedance.live.datacontext.m r42 = m.i().getRoom();
        if (r42 == null) goto L14;
        IRoom r43 = (IRoom) r42.getValue();
        if (r43 == null) goto L14;
        r3 = r43.getOwnerUserIdString();
        goto L16
    }

    public static boolean c(Integer r3, Integer r4) {
        if (r4 != null) goto L6;
    L7:
        if (r4 != null) goto L10;
    L11:
        if (r4 != null) goto L14;
    L16:
        if (r3 != null) goto L19;
        return false;
    L19:
        if (r3.intValue() != 15) goto L21;
        return true;
    L21:
        return false;
    L14:
        if (r4.intValue() != 29) goto L16;
    L23:
        return true;
    L10:
        if (r4.intValue() == 25) goto L23;
    L6:
        if (r4.intValue() == 7) goto L23;
        goto L7
    }

    public static boolean e(Integer r3, Integer r4) {
        if (r4 != null) goto L6;
    L7:
        if (r4 != null) goto L10;
    L11:
        if (r4 != null) goto L14;
    L16:
        if (r3 != null) goto L19;
    L20:
        if (r3 != null) goto L23;
    L24:
        if (r3 != null) goto L27;
        return false;
    L27:
        if (r3.intValue() == 12) goto L31;
        return false;
    L31:
        return true;
    L23:
        if (r3.intValue() == 10) goto L31;
    L19:
        if (r3.intValue() == 8) goto L31;
    L14:
        if (r4.intValue() != 9) goto L16;
    L10:
        if (r4.intValue() == 6) goto L31;
    L6:
        if (r4.intValue() == 1) goto L31;
        goto L7
    }

    public static boolean f(Integer r1, Integer r2) {
        if (e(r1, r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (c(r1, r2) == true) goto L8;
        return false;
    }

    public static boolean g(Integer r2, Integer r3) {
        if (r3 != null) goto L6;
    L8:
        if (r2 != null) goto L11;
        return false;
    L11:
        if (r2.intValue() != 30) goto L13;
        return true;
    L13:
        return false;
    L6:
        if (r3.intValue() != 15) goto L8;
        return true;
    }

    public static boolean h(Integer r2, Integer r3) {
        if (r3 != null) goto L6;
    L8:
        if (r2 != null) goto L11;
        return false;
    L11:
        if (r2.intValue() != 35) goto L13;
        return true;
    L13:
        return false;
    L6:
        if (r3.intValue() != 16) goto L8;
        return true;
    }

    public static boolean i(Integer r2, Integer r3) {
        if (r3 != null) goto L6;
    L8:
        if (r2 != null) goto L11;
        return false;
    L11:
        if (r2.intValue() != 37) goto L13;
        return true;
    L13:
        return false;
    L6:
        if (r3.intValue() != 65) goto L8;
        return true;
    }

    public static boolean k(Integer r2, Integer r3) {
        if (r3 != null) goto L5;
    L6:
        if (r3 != null) goto L9;
    L10:
        if (r3 != null) goto L13;
    L15:
        if (r2 != null) goto L18;
    L19:
        if (r2 != null) goto L22;
    L23:
        if (r2 != null) goto L26;
        return false;
    L26:
        if (r2.intValue() == 27) goto L37;
        return false;
    L37:
        return true;
    L22:
        if (r2.intValue() != 25) goto L23;
        return true;
    L18:
        if (r2.intValue() != 26) goto L19;
        return true;
    L13:
        if (r3.intValue() != 111) goto L15;
        return true;
    L9:
        if (r3.intValue() != 109) goto L10;
        return true;
    L5:
        if (r3.intValue() != 110) goto L6;
        return true;
    }

    public static boolean m(Integer r2, Integer r3) {
        if (r3 != null) goto L5;
    L6:
        if (r3 != null) goto L9;
    L10:
        if (r3 != null) goto L13;
    L14:
        if (r3 != null) goto L17;
    L19:
        if (r2 != null) goto L22;
    L23:
        if (r2 != null) goto L26;
    L27:
        if (r2 != null) goto L30;
    L31:
        if (r2 != null) goto L34;
        return false;
    L34:
        if (r2.intValue() == 28) goto L47;
        return false;
    L47:
        return true;
    L30:
        if (r2.intValue() != 27) goto L31;
        return true;
    L26:
        if (r2.intValue() != 25) goto L27;
        return true;
    L22:
        if (r2.intValue() != 26) goto L23;
        return true;
    L17:
        if (r3.intValue() != 112) goto L19;
        return true;
    L13:
        if (r3.intValue() != 111) goto L14;
        return true;
    L9:
        if (r3.intValue() != 109) goto L10;
        return true;
    L5:
        if (r3.intValue() != 110) goto L6;
        return true;
    }

    public static boolean n(Integer r4, Integer r5) {
        if (r5 == null) goto L5;
        int r1 = r5.intValue();
    L7:
        if (e0.b(r1) == true) goto L23;
        if (r5 != null) goto L11;
    L12:
        if (r5 != null) goto L15;
    L17:
        if (r4 != null) goto L20;
    L22:
        return false;
    L20:
        if (r4.intValue() != 3) goto L22;
        return true;
    L15:
        if (r5.intValue() != 26) goto L17;
    L11:
        if (r5.intValue() != 22) goto L12;
    L23:
        return true;
    L5:
        r1 = 0;
        goto L7
    }

    public static boolean l(Integer r3, Integer r4, Integer r5) {
        if (r3 != null) goto L6;
    L16:
        if (r3 != null) goto L19;
        return false;
    L19:
        if (r3.intValue() != 12) goto L29;
        if (r5 != null) goto L23;
    L24:
        if (r5 != null) goto L27;
        return false;
    L27:
        if (r5.intValue() != 112) goto L31;
    L28:
        return true;
    L31:
        return false;
    L23:
        if (r5.intValue() == 6) goto L28;
    L29:
        return false;
    L6:
        if (r3.intValue() != 12) goto L16;
        if (r4 != null) goto L10;
    L11:
        if (r4 == null) goto L16;
        if (r4.intValue() != 28) goto L16;
    L15:
        return true;
    L10:
        if (r4.intValue() == 12) goto L15;
        goto L11
    }

    public static boolean o(int r3, int r4, int r5) {
        if (r3 == 5) goto L8;
        if (r3 == 9) goto L8;
        if (r3 == 1) goto L8;
    L10:
        boolean r6 = false;
    L12:
        if (FoldScreenUtils.e() == false) goto L14;
    L16:
        return true;
    L14:
        if (PadConfigUtils.c() == true) goto L16;
        if (r6 == true) goto L16;
        return false;
    L8:
        if ((r4 / r5) <= 0.5625f) goto L10;
        r6 = true;
        goto L12
    }
}
