package gg0;

import android.os.Bundle;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.hamlet.model.l;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkAudioFirstUserViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.g0;
import com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.n1;
import com.bytedance.android.livesdk.link.model.bridge.Linkmic2DAvatar;
import com.bytedance.android.livesdk.message.model.b8;
import com.bytedance.android.livesdk.message.model.f6;
import com.bytedance.android.livesdk.message.model.fa;
import com.bytedance.android.livesdk.message.model.n8;
import com.bytedance.android.livesdk.message.model.za;
import com.bytedance.android.livesdkapi.depend.message.IMicrophoneItem;
import com.bytedance.common.utility.Lists;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import py.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e extends b<MultiLinkGuestViewBinder.a> {

    public static final class a {
    }

    static {
    }

    public e() {
    }

    public static boolean m(MultiLinkGuestViewBinder.a r1) {
        Object r2 = r1.k.d.get("EXT_KEY_UPDATE_INTERACT_SONG_GOLDEN_MIC_INFO_LIST");
        if (TypeIntrinsics.isMutableList(r2) == true) goto L5;
        r2 = null;
    L5:
        List r3 = (List) r2;
        if (r3 != null) goto L8;
    L10:
        return false;
    L8:
        if ((!r3.isEmpty()) != true) goto L10;
        return true;
    }

    public static boolean e(MultiLinkGuestViewBinder.a r1, MultiLinkGuestViewBinder.a r2) {
        IBaseUser r3 = r1.k.a.getUser();
        Boolean r0 = null;
        if (r3 == null) goto L7;
        t r4 = r3.getUserAttr();
        if (r4 == null) goto L7;
        Boolean r5 = Boolean.valueOf(r4.isAdmin());
    L8:
        IBaseUser r6 = r2.k.a.getUser();
        if (r6 == null) goto L14;
        t r7 = r6.getUserAttr();
        if (r7 == null) goto L14;
        r0 = Boolean.valueOf(r7.isAdmin());
    L14:
        return Intrinsics.areEqual(r5, r0);
    L7:
        r5 = null;
        goto L8
    }

    public static boolean g(MultiLinkGuestViewBinder.a r3, MultiLinkGuestViewBinder.a r4) {
        Object r5 = r3.k.d.get("EXT_KEY_UPDATE_FEED_VIEW_INTERACT_SONG_UPDATE");
        Object r2 = null;
        if ((r5 instanceof IMicrophoneItem) == true) goto L5;
        r5 = null;
    L5:
        IMicrophoneItem r6 = (IMicrophoneItem) r5;
        Object r7 = r4.k.d.get("EXT_KEY_UPDATE_FEED_VIEW_INTERACT_SONG_UPDATE");
        if ((r7 instanceof IMicrophoneItem) == false) goto L10;
        r2 = r7;
    L10:
        return Intrinsics.areEqual(r6, (IMicrophoneItem) r2);
    }

    public static boolean h(MultiLinkGuestViewBinder.a r3, MultiLinkGuestViewBinder.a r4) {
        Object r5 = r3.k.d.get("EXT_KEY_UPDATE_MEDIA_TYPE_TIME_STAMP");
        Object r2 = null;
        if ((r5 instanceof Long) == true) goto L5;
        r5 = null;
    L5:
        Long r6 = (Long) r5;
        Object r7 = r4.k.d.get("EXT_KEY_UPDATE_MEDIA_TYPE_TIME_STAMP");
        if ((r7 instanceof Long) == false) goto L10;
        r2 = r7;
    L10:
        return Intrinsics.areEqual(r6, (Long) r2);
    }

    public static boolean i(MultiLinkGuestViewBinder.a r3, MultiLinkGuestViewBinder.a r4) {
        Object r5 = r3.k.d.get("EXT_KEY_UPDATE_HAMLET_AVATAR_POSITION");
        Object r2 = null;
        if ((r5 instanceof l) == true) goto L5;
        r5 = null;
    L5:
        l r6 = (l) r5;
        Object r7 = r4.k.d.get("EXT_KEY_UPDATE_HAMLET_AVATAR_POSITION");
        if ((r7 instanceof l) == false) goto L10;
        r2 = r7;
    L10:
        return Intrinsics.areEqual(r6, (l) r2);
    }

    public static boolean j(MultiLinkGuestViewBinder.a r3, MultiLinkGuestViewBinder.a r4) {
        Object r5 = r3.k.d.get("EXT_KEY_UPDATE_HAMLET_AVATAR_RENDING");
        Object r2 = null;
        if ((r5 instanceof Boolean) == true) goto L5;
        r5 = null;
    L5:
        Boolean r6 = (Boolean) r5;
        Object r7 = r4.k.d.get("EXT_KEY_UPDATE_HAMLET_AVATAR_RENDING");
        if ((r7 instanceof Boolean) == false) goto L10;
        r2 = r7;
    L10:
        return Intrinsics.areEqual(r6, (Boolean) r2);
    }

    public static boolean k(MultiLinkGuestViewBinder.a r3, MultiLinkGuestViewBinder.a r4) {
        Object r5 = r3.k.d.get("EXT_KEY_UPDATE_INTERACT_SONG_SHOW_GOLDEN_MIC");
        Object r2 = null;
        if ((r5 instanceof Boolean) == true) goto L5;
        r5 = null;
    L5:
        Boolean r6 = (Boolean) r5;
        Object r7 = r4.k.d.get("EXT_KEY_UPDATE_INTERACT_SONG_SHOW_GOLDEN_MIC");
        if ((r7 instanceof Boolean) == false) goto L10;
        r2 = r7;
    L10:
        return Intrinsics.areEqual(r6, (Boolean) r2);
    }

    public static boolean l(MultiLinkGuestViewBinder.a r3, MultiLinkGuestViewBinder.a r4) {
        Object r5 = r3.k.d.get("EXT_KEY_UPDATE_INTERACT_SONG_GOLDEN_MIC_INFO");
        Object r2 = null;
        if ((r5 instanceof pf0.a) == true) goto L5;
        r5 = null;
    L5:
        pf0.a r6 = (pf0.a) r5;
        Object r7 = r4.k.d.get("EXT_KEY_UPDATE_INTERACT_SONG_GOLDEN_MIC_INFO");
        if ((r7 instanceof pf0.a) == false) goto L10;
        r2 = r7;
    L10:
        return Intrinsics.areEqual(r6, (pf0.a) r2);
    }

    public static boolean n(MultiLinkGuestViewBinder.a r3, MultiLinkGuestViewBinder.a r4) {
        Object r5 = r3.k.d.get("EXT_KEY_UPDATE_FEED_VIEW_INTERACT_SONG_SUB_UI_LAYOUT");
        Object r2 = null;
        if ((r5 instanceof Integer) == true) goto L5;
        r5 = null;
    L5:
        Integer r6 = (Integer) r5;
        Object r7 = r4.k.d.get("EXT_KEY_UPDATE_FEED_VIEW_INTERACT_SONG_SUB_UI_LAYOUT");
        if ((r7 instanceof Integer) == false) goto L10;
        r2 = r7;
    L10:
        return !Intrinsics.areEqual(r6, (Integer) r2);
    }

    public static boolean o(MultiLinkGuestViewBinder.a r2, MultiLinkGuestViewBinder.a r3) {
        ch0.c r4 = r2.p;
        String r1 = null;
        if (r4 == null) goto L9;
        za r5 = r4.a;
        if (r5 == null) goto L9;
        Intrinsics.checkNotNullParameter(r5, "$this$topUserFlex");
        b8 r6 = r5.getTopUser();
        if (r6 == null) goto L9;
        String r7 = n8.b(r6);
    L10:
        ch0.c r8 = r3.p;
        if (r8 == null) goto L18;
        za r9 = r8.a;
        if (r9 == null) goto L18;
        Intrinsics.checkNotNullParameter(r9, "$this$topUserFlex");
        b8 r10 = r9.getTopUser();
        if (r10 == null) goto L18;
        r1 = n8.b(r10);
    L18:
        return Intrinsics.areEqual(r7, r1);
    L9:
        r7 = null;
        goto L10
    }

    public static boolean p(MultiLinkGuestViewBinder.a r4, MultiLinkGuestViewBinder.a r5) {
        Linkmic2DAvatar r0 = r4.k.a.getLinkmic2DAvatar();
        py.k r1 = null;
        if (r0 == null) goto L5;
        py.k r2 = r0.getImage();
    L7:
        if (r2 != null) goto L14;
        Linkmic2DAvatar r3 = r5.k.a.getLinkmic2DAvatar();
        if (r3 == null) goto L11;
        py.k r6 = r3.getImage();
    L12:
        if (r6 != null) goto L14;
        return true;
    L11:
        r6 = null;
    L14:
        Linkmic2DAvatar r7 = r4.k.a.getLinkmic2DAvatar();
        if (r7 == null) goto L17;
        Boolean r8 = r7.getEnableAvatar();
    L18:
        Linkmic2DAvatar r9 = r5.k.a.getLinkmic2DAvatar();
        if (r9 == null) goto L21;
        Boolean r10 = r9.getEnableAvatar();
    L23:
        if (Intrinsics.areEqual(r8, r10) == false) goto L34;
        Linkmic2DAvatar r11 = r4.k.a.getLinkmic2DAvatar();
        if (r11 == null) goto L34;
        py.k r12 = r11.getImage();
        if (r12 == null) goto L34;
        Linkmic2DAvatar r13 = r5.k.a.getLinkmic2DAvatar();
        if (r13 == null) goto L32;
        r1 = r13.getImage();
    L32:
        if (r12.equalsOnlyUri(r1) != true) goto L34;
        return true;
    L34:
        return false;
    L21:
        r10 = null;
        goto L23
    L17:
        r8 = null;
        goto L18
    L5:
        r2 = null;
        goto L7
    }

    public static boolean q(MultiLinkGuestViewBinder.a r4, MultiLinkGuestViewBinder.a r5) {
        InteractiveSongContext.a r0 = InteractiveSongContext.Companion;
        if (InteractiveSongContext.a.d(r0, r4.k, 0, true, 2) != InteractiveSongContext.a.d(r0, r5.k, 0, true, 2)) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean s(MultiLinkGuestViewBinder.a r5, MultiLinkGuestViewBinder.a r6) {
        if (((Boolean) vm2.d.i2.getValue(null, vm2.d.a[162(0xa2, float:2.27E-43)])).booleanValue() == false) goto L11;
        if ((!Intrinsics.areEqual(r5.k.d.get("EXT_KEY_UPDATE_PAID_TIME_REMAIN_VALUE"), r6.k.d.get("EXT_KEY_UPDATE_PAID_TIME_REMAIN_VALUE"))) == true) goto L7;
        return false;
    L7:
        if (r6.k.d.get("EXT_KEY_UPDATE_PAID_TIME_REMAIN") == null) goto L15;
        return true;
    L15:
        return false;
    L11:
        if (r6.k.d.get("EXT_KEY_UPDATE_PAID_TIME_REMAIN") == null) goto L16;
        return true;
    L16:
        return false;
    }

    public static boolean t(MultiLinkGuestViewBinder.a r3, MultiLinkGuestViewBinder.a r4) {
        wg0.a r5 = r3.n;
        wg0.a r6 = r4.n;
        Boolean r0 = null;
        if (r5 == null) goto L5;
        Boolean r1 = Boolean.valueOf(r5.a);
    L6:
        if (r6 == null) goto L8;
        Boolean r2 = Boolean.valueOf(r6.a);
    L10:
        if (Intrinsics.areEqual(r1, r2) == false) goto L31;
        if (r5 == null) goto L15;
        EnlargeGuestInfo.EnlargeGuestType r7 = r5.b;
        if (r7 == null) goto L15;
        Integer r8 = Integer.valueOf(r7.ordinal());
    L16:
        if (r6 == null) goto L20;
        EnlargeGuestInfo.EnlargeGuestType r9 = r6.b;
        if (r9 == null) goto L20;
        Integer r10 = Integer.valueOf(r9.ordinal());
    L22:
        if (Intrinsics.areEqual(r8, r10) == false) goto L31;
        if (r5 == null) goto L25;
        Boolean r11 = Boolean.valueOf(r5.c);
    L26:
        if (r6 == null) goto L29;
        r0 = Boolean.valueOf(r6.c);
    L29:
        if (Intrinsics.areEqual(r11, r0) == false) goto L31;
        return true;
    L25:
        r11 = null;
    L20:
        r10 = null;
    L15:
        r8 = null;
    L31:
        return false;
    L8:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public static boolean u(MultiLinkGuestViewBinder.a r3, MultiLinkGuestViewBinder.a r4) {
        Object r5 = r3.k.d.get("EXT_KEY_UPDATE_REQUEST_SONG_OPEN");
        Object r2 = null;
        if ((r5 instanceof Boolean) == true) goto L5;
        r5 = null;
    L5:
        Boolean r6 = (Boolean) r5;
        Object r7 = r4.k.d.get("EXT_KEY_UPDATE_REQUEST_SONG_OPEN");
        if ((r7 instanceof Boolean) == false) goto L10;
        r2 = r7;
    L10:
        return Intrinsics.areEqual(r6, (Boolean) r2);
    }

    public static boolean v(MultiLinkGuestViewBinder.a r3, MultiLinkGuestViewBinder.a r4) {
        Object r5 = r3.k.d.get("EXT_KEY_UPDATE_THEME_COMPETITION_CHANGE_CONTENT");
        Long r2 = null;
        if ((r5 instanceof fa) == true) goto L5;
        r5 = null;
    L5:
        fa r6 = (fa) r5;
        Object r7 = r4.k.d.get("EXT_KEY_UPDATE_THEME_COMPETITION_CHANGE_CONTENT");
        if ((r7 instanceof fa) == true) goto L8;
        r7 = null;
    L8:
        fa r8 = (fa) r7;
        if (r6 == null) goto L13;
        n1 r9 = r6.getChangeUserScore();
        if (r9 == null) goto L13;
        Long r10 = Long.valueOf(r9.getScore());
    L14:
        if (r8 == null) goto L19;
        n1 r11 = r8.getChangeUserScore();
        if (r11 == null) goto L19;
        r2 = Long.valueOf(r11.getScore());
    L19:
        return Intrinsics.areEqual(r10, r2);
    L13:
        r10 = null;
        goto L14
    }

    public static boolean w(MultiLinkGuestViewBinder.a r3, MultiLinkGuestViewBinder.a r4) {
        Object r5 = r3.k.d.get("EXT_KEY_UPDATE_THEME_COMPETITION_CHANGE_WIN_TYPE");
        Boolean r2 = null;
        if ((r5 instanceof n1) == true) goto L5;
        r5 = null;
    L5:
        n1 r6 = (n1) r5;
        Object r7 = r4.k.d.get("EXT_KEY_UPDATE_THEME_COMPETITION_CHANGE_WIN_TYPE");
        if ((r7 instanceof n1) == true) goto L8;
        r7 = null;
    L8:
        n1 r8 = (n1) r7;
        if (r6 == null) goto L11;
        Integer r0 = Integer.valueOf(r6.getWinType());
    L12:
        if (r8 == null) goto L14;
        Integer r1 = Integer.valueOf(r8.getWinType());
    L16:
        if (Intrinsics.areEqual(r0, r1) == false) goto L25;
        if (r6 == null) goto L19;
        Boolean r9 = Boolean.valueOf(r6.getShowFaceEffect());
    L20:
        if (r8 == null) goto L23;
        r2 = Boolean.valueOf(r8.getShowFaceEffect());
    L23:
        if (Intrinsics.areEqual(r9, r2) == false) goto L25;
        return true;
    L19:
        r9 = null;
    L25:
        return false;
    L14:
        r1 = null;
        goto L16
    L11:
        r0 = null;
        goto L12
    }

    public static boolean x(MultiLinkGuestViewBinder.a r6, MultiLinkGuestViewBinder.a r7) {
        if (r6.k.a.getLinkType() != r7.k.a.getLinkType()) goto L5;
        boolean r0 = true;
    L6:
        ch0.h r1 = r6.k.b;
        Integer r4 = null;
        if (r1 == null) goto L9;
        Boolean r2 = Boolean.valueOf(r1.c);
    L10:
        ch0.h r5 = r7.k.b;
        if (r5 == null) goto L13;
        Boolean r8 = Boolean.valueOf(r5.c);
    L14:
        boolean r3 = Intrinsics.areEqual(r2, r8);
        ch0.j r9 = r6.k.c;
        if (r9 == null) goto L17;
        Integer r10 = Integer.valueOf(r9.c);
    L18:
        ch0.j r11 = r7.k.c;
        if (r11 == null) goto L21;
        r4 = Integer.valueOf(r11.c);
    L21:
        boolean r12 = Intrinsics.areEqual(r10, r4);
        if (r0 == false) goto L27;
        if (r3 == false) goto L28;
        if (r12 == false) goto L29;
        return true;
    L29:
        return false;
    L28:
        return false;
    L27:
        return false;
    L17:
        r10 = null;
        goto L18
    L13:
        r8 = null;
        goto L14
    L9:
        r2 = null;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    public static boolean y(MultiLinkGuestViewBinder.a r2, MultiLinkGuestViewBinder.a r3) {
        f6 r1 = null;
        if ((r2 instanceof MultiLinkAudioFirstUserViewBinder.a) == true) goto L5;
        r2 = null;
    L5:
        MultiLinkAudioFirstUserViewBinder.a r4 = (MultiLinkAudioFirstUserViewBinder.a) r2;
        if ((r3 instanceof MultiLinkAudioFirstUserViewBinder.a) == true) goto L8;
        r3 = null;
    L8:
        MultiLinkAudioFirstUserViewBinder.a r5 = (MultiLinkAudioFirstUserViewBinder.a) r3;
        if (r4 == null) goto L13;
        ch0.l r6 = r4.s;
        if (r6 == null) goto L13;
        f6 r7 = r6.b;
    L14:
        if (r7 != null) goto L22;
        if (r5 == null) goto L19;
        ch0.l r8 = r5.s;
        if (r8 == null) goto L19;
        r1 = r8.b;
    L19:
        if (r1 == null) goto L22;
        return false;
    L22:
        return true;
    L13:
        r7 = null;
        goto L14
    }

    @Override // gg0.b
    public final boolean a(tf0.e r9, tf0.e r10) {
        MultiLinkGuestViewBinder.a r11 = (MultiLinkGuestViewBinder.a) r9;
        MultiLinkGuestViewBinder.a r12 = (MultiLinkGuestViewBinder.a) r10;
        Intrinsics.checkNotNullParameter(r11, "oldItem");
        Intrinsics.checkNotNullParameter(r12, "newItem");
        if (super.a(r11, r12) == true) goto L5;
        return false;
    L5:
        if (r11.k.a.getUserPosition() != r12.k.a.getUserPosition()) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
        return false;
    L10:
        if (f(r11.k.a, r12.k.a) == true) goto L12;
        return false;
    L12:
        if (x(r11, r12) == false) goto L153;
        ILinkPlayerInfoBridge r1 = r11.k.a;
        ILinkPlayerInfoBridge r2 = r12.k.a;
        if (r1.getSilenceStatus() == r2.getSilenceStatus()) goto L16;
    L18:
        boolean r3 = false;
    L19:
        if (r3 == false) goto L154;
        ILinkPlayerInfoBridge r4 = r11.k.a;
        ILinkPlayerInfoBridge r5 = r12.k.a;
        if (r4.isBackground() == r5.isBackground()) goto L23;
    L25:
        boolean r6 = false;
    L26:
        if (r6 == false) goto L155;
        LinkmicPositionItem r7 = r11.l;
        LinkmicPositionItem r8 = r12.l;
        if (r7 != null) goto L32;
        if (r8 != null) goto L32;
        boolean r13 = true;
    L38:
        if (r13 == false) goto L156;
        g0 r14 = r11.k.a.getMicPosTagInfo();
        g0 r15 = r12.k.a.getMicPosTagInfo();
        if (r14 != null) goto L43;
        if (r15 != null) goto L43;
        boolean r16 = true;
    L46:
        if (r16 == false) goto L157;
        ILinkPlayerInfoBridge r17 = r11.k.a;
        ILinkPlayerInfoBridge r18 = r12.k.a;
        if (r17.getFanTicketDisplayStr().equals(r18.getFanTicketDisplayStr()) == false) goto L158;
        ILinkPlayerInfoBridge r19 = r11.k.a;
        ILinkPlayerInfoBridge r20 = r12.k.a;
        if (r19.isOpenSendGift() != r20.isOpenSendGift()) goto L52;
        boolean r21 = true;
    L53:
        if (r21 == true) goto L55;
        return false;
    L55:
        if (r12.k.d.get("EXT_KEY_GUEST_BATTLE_ACTION") == null) goto L57;
        boolean r22 = true;
    L58:
        if (r22 == false) goto L60;
        return false;
    L60:
        if (r12.k.d.get("EXT_KEY_SEAT_ANIM_ACTION") == null) goto L62;
        boolean r23 = true;
    L63:
        if (r23 == false) goto L65;
        return false;
    L65:
        if (r12.k.d.get("EXT_KEY_GIFT_ICON_FLASH") == null) goto L67;
        boolean r24 = true;
    L68:
        if (r24 == false) goto L70;
        return false;
    L70:
        if (r12.k.d.get("EXT_KEY_QUICK_INTERACT_TASK") == null) goto L72;
        boolean r25 = true;
    L73:
        if (r25 == false) goto L75;
        return false;
    L75:
        if (s(r11, r12) == false) goto L77;
        return false;
    L77:
        if (r(r11.k.a, r12.k.a) == true) goto L79;
        return false;
    L79:
        if (ch0.f.a(r11.k) != ch0.f.a(r12.k)) goto L81;
        boolean r26 = true;
    L82:
        if (r26 == false) goto L166;
        ILinkPlayerInfoBridge r27 = r11.k.a;
        ILinkPlayerInfoBridge r28 = r12.k.a;
        if (r27.getSelfDisciplineDuration() != r28.getSelfDisciplineDuration()) goto L86;
        boolean r29 = true;
    L87:
        if (r29 == true) goto L89;
        return false;
    L89:
        if (r12.k.d.get("EXT_KEY_UPDATE_THEME_COMPETITION_OPEN_STATUS_CHANGE") == null) goto L91;
        boolean r30 = true;
    L92:
        if (r30 == false) goto L94;
        return false;
    L94:
        if (v(r11, r12) == true) goto L96;
        return false;
    L96:
        if (w(r11, r12) == true) goto L98;
        return false;
    L98:
        if (k(r11, r12) == true) goto L100;
        return false;
    L100:
        if (l(r11, r12) == true) goto L102;
        return false;
    L102:
        if (m(r12) == false) goto L104;
        return false;
    L104:
        if (g(r11, r12) == true) goto L106;
        return false;
    L106:
        if (i(r11, r12) == true) goto L108;
        return false;
    L108:
        if (j(r11, r12) == true) goto L110;
        return false;
    L110:
        if (u(r11, r12) == true) goto L112;
        return false;
    L112:
        if (n(r11, r12) == false) goto L114;
        return false;
    L114:
        if (r11.k.a.isEnlarged() != r12.k.a.isEnlarged()) goto L116;
        boolean r31 = true;
    L117:
        if (r31 == true) goto L119;
        return false;
    L119:
        if (h(r11, r12) == true) goto L121;
        return false;
    L121:
        if (r12.k.d.get("EXT_KEY_TAG_LABEL_ACTION") == null) goto L123;
        boolean r32 = true;
    L124:
        if (r32 == false) goto L126;
        return false;
    L126:
        if (Lists.deepEquals(r11.o, r12.o) == true) goto L128;
        return false;
    L128:
        if (t(r11, r12) == true) goto L130;
        return false;
    L130:
        if (r11.f == r12.f) goto L132;
    L136:
        boolean r33 = false;
    L137:
        if (r33 == true) goto L139;
        return false;
    L139:
        if (o(r11, r12) == true) goto L141;
        return false;
    L141:
        if (y(r11, r12) == true) goto L143;
        return false;
    L143:
        if (e(r11, r12) == true) goto L145;
        return false;
    L145:
        if (p(r11, r12) == true) goto L147;
        return false;
    L147:
        if (q(r11, r12) == false) goto L189;
        return true;
    L189:
        return false;
    L132:
        if (r11.e != r12.e) goto L136;
        if (Intrinsics.areEqual(r11.g, r12.g) == false) goto L136;
        r33 = true;
        goto L137
    L123:
        r32 = false;
        goto L124
    L116:
        r31 = false;
        goto L117
    L91:
        r30 = false;
        goto L92
    L86:
        r29 = false;
        goto L87
    L166:
        return false;
    L81:
        r26 = false;
        goto L82
    L72:
        r25 = false;
        goto L73
    L67:
        r24 = false;
        goto L68
    L62:
        r23 = false;
        goto L63
    L57:
        r22 = false;
        goto L58
    L52:
        r21 = false;
        goto L53
    L158:
        return false;
    L157:
        return false;
    L43:
        if (r14 == null) goto L45;
        r16 = r14.equals(r15);
        goto L46
    L45:
        r16 = false;
        goto L46
    L156:
        return false;
    L32:
        if (vm2.d.N0() == false) goto L36;
        if (r7 == null) goto L35;
        r13 = com.bytedance.android.live.liveinteract.multianchor.model.h.b(r7, r8);
    L35:
        r13 = false;
        goto L38
    L36:
        if (r7 == null) goto L35;
        r13 = r7.equals(r8);
        goto L38
    L155:
        return false;
    L23:
        if (r4.isSelfBackground() != r5.isSelfBackground()) goto L25;
        r6 = true;
        goto L26
    L154:
        return false;
    L16:
        if (r1.getRoomLinkSilenceStatus() != r2.getRoomLinkSilenceStatus()) goto L18;
        r3 = true;
        goto L19
    L153:
        return false;
    L7:
        r0 = false;
        goto L8
    }

    @Override // gg0.b
    public final boolean b(tf0.e r2, tf0.e r3) {
        MultiLinkGuestViewBinder.a r4 = (MultiLinkGuestViewBinder.a) r2;
        MultiLinkGuestViewBinder.a r5 = (MultiLinkGuestViewBinder.a) r3;
        Intrinsics.checkNotNullParameter(r4, "oldItem");
        Intrinsics.checkNotNullParameter(r5, "newItem");
        IBaseUser r6 = r4.k.a.getUser();
        String r0 = null;
        if (r6 == null) goto L5;
        String r7 = r6.getIdString();
    L6:
        IBaseUser r8 = r5.k.a.getUser();
        if (r8 == null) goto L10;
        r0 = r8.getIdString();
    L10:
        return Intrinsics.areEqual(r7, r0);
    L5:
        r7 = null;
        goto L6
    }

    public final boolean f(ILinkPlayerInfoBridge r1, ILinkPlayerInfoBridge r2) {
        IBaseUser r3 = r1.getUser();
        if (r3 == null) goto L11;
        py.k r4 = r3.getAvatarMedium();
        if (r4 == null) goto L11;
        IBaseUser r5 = r2.getUser();
        if (r5 == null) goto L9;
        py.k r6 = r5.getAvatarMedium();
    L13:
        return r4.equalsOnlyUri(r6);
    L9:
        r6 = null;
    L11:
        return false;
    }

    public final boolean r(ILinkPlayerInfoBridge r3, ILinkPlayerInfoBridge r4) {
        if (vm2.d.N0() == false) goto L17;
        if (r3.getMicDress() == null) goto L7;
    L9:
        kd1.b r5 = r3.getMicDress();
        if (r5 != null) goto L12;
    L14:
        return false;
    L12:
        if (r5.equals(r4.getMicDress()) != true) goto L14;
        return true;
    L7:
        if (r4.getMicDress() != null) goto L9;
        return true;
    L17:
        return Intrinsics.areEqual(r3.getMicDress(), r4.getMicDress());
    }

    @Override // gg0.b
    public final Bundle d(tf0.e r7, tf0.e r8, int r9, int r10) {
        MultiLinkGuestViewBinder.a r11 = (MultiLinkGuestViewBinder.a) r7;
        MultiLinkGuestViewBinder.a r12 = (MultiLinkGuestViewBinder.a) r8;
        Intrinsics.checkNotNullParameter(r11, "oldItem");
        Intrinsics.checkNotNullParameter(r12, "newItem");
        Bundle r0 = super.d(r11, r12, r9, r10);
        boolean r3 = false;
        if (r11.k.a.getUserPosition() != r12.k.a.getUserPosition()) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        if (r9 != r10) goto L8;
    L10:
        if (f(r11.k.a, r12.k.a) == true) goto L13;
        r0.putBoolean("payload_key_avatar_update", true);
    L13:
        if (x(r11, r12) == true) goto L15;
        r0.putBoolean("payload_key_video_status_update", true);
    L15:
        ILinkPlayerInfoBridge r13 = r11.k.a;
        ILinkPlayerInfoBridge r14 = r12.k.a;
        if (r13.getSilenceStatus() == r14.getSilenceStatus()) goto L18;
    L20:
        boolean r15 = false;
    L21:
        if (r15 == true) goto L23;
        r0.putBoolean("payload_key_silence_status_update", true);
    L23:
        ILinkPlayerInfoBridge r16 = r11.k.a;
        ILinkPlayerInfoBridge r17 = r12.k.a;
        if (r16.isBackground() == r17.isBackground()) goto L26;
    L28:
        boolean r18 = false;
    L29:
        if (r18 == true) goto L31;
        r0.putBoolean("payload_key_background_status_update", true);
    L31:
        LinkmicPositionItem r19 = r11.l;
        LinkmicPositionItem r110 = r12.l;
        if (r19 != null) goto L36;
        if (r110 != null) goto L36;
        boolean r20 = true;
    L42:
        if (r20 == true) goto L44;
        r0.putBoolean("payload_key_position_name_update", true);
    L44:
        g0 r21 = r11.k.a.getMicPosTagInfo();
        g0 r111 = r12.k.a.getMicPosTagInfo();
        if (r21 != null) goto L48;
        if (r111 != null) goto L48;
        boolean r22 = true;
    L51:
        if (r22 == true) goto L53;
        r0.putBoolean("payload_key_link_mic_tag_info_update", true);
    L53:
        ILinkPlayerInfoBridge r23 = r11.k.a;
        ILinkPlayerInfoBridge r112 = r12.k.a;
        if (r23.getSelfDisciplineDuration() != r112.getSelfDisciplineDuration()) goto L56;
        boolean r24 = true;
    L57:
        if (r24 == true) goto L59;
        r0.putBoolean("payload_key_self_discipline_duration_update", true);
    L59:
        ILinkPlayerInfoBridge r25 = r11.k.a;
        ILinkPlayerInfoBridge r113 = r12.k.a;
        if (r25.getFanTicketDisplayStr().equals(r113.getFanTicketDisplayStr()) == true) goto L62;
        r0.putBoolean("payload_key_fan_ticket_str_update", true);
    L62:
        ILinkPlayerInfoBridge r26 = r11.k.a;
        ILinkPlayerInfoBridge r114 = r12.k.a;
        if (r26.isOpenSendGift() != r114.isOpenSendGift()) goto L65;
        boolean r27 = true;
    L66:
        if (r27 == true) goto L69;
        r0.putBoolean("payload_key_is_open_send_gift_update", true);
    L69:
        if (r12.k.d.get("EXT_KEY_SEAT_ANIM_ACTION") == null) goto L71;
        boolean r28 = true;
    L72:
        if (r28 == false) goto L75;
        r0.putBoolean("payload_key_is_seat_anim_action_update", true);
    L75:
        if (r12.k.d.get("EXT_KEY_GUEST_BATTLE_ACTION") == null) goto L77;
        boolean r29 = true;
    L78:
        if (r29 == false) goto L81;
        r0.putBoolean("payload_key_guest_battle_action_update", true);
    L81:
        if (r12.k.d.get("EXT_KEY_TAG_LABEL_ACTION") == null) goto L83;
        boolean r30 = true;
    L84:
        if (r30 == false) goto L87;
        r0.putBoolean("payload_key_tag_label_action_update", true);
    L87:
        if (r12.k.d.get("EXT_KEY_QUICK_INTERACT_TASK") == null) goto L89;
        boolean r31 = true;
    L90:
        if (r31 == false) goto L93;
        r0.putBoolean("payload_key_interact_task_update", true);
    L93:
        if (r12.k.d.get("EXT_KEY_GIFT_ICON_FLASH") == null) goto L95;
        boolean r32 = true;
    L96:
        if (r32 == false) goto L99;
        r0.putBoolean("payload_key_gift_icon_flash_update", true);
    L99:
        if (s(r11, r12) == false) goto L102;
        r0.putBoolean("payload_key_paid_link_time_remain_update", true);
    L102:
        if (r(r11.k.a, r12.k.a) == true) goto L105;
        r0.putBoolean("payload_key_mic_dress", true);
    L105:
        if (ch0.f.a(r11.k) != ch0.f.a(r12.k)) goto L107;
        boolean r33 = true;
    L108:
        if (r33 == true) goto L111;
        r0.putBoolean("payload_key_mic_talk_state", true);
    L111:
        if (r12.k.d.get("EXT_KEY_UPDATE_THEME_COMPETITION_OPEN_STATUS_CHANGE") == null) goto L113;
        boolean r34 = true;
    L114:
        if (r34 == false) goto L117;
        r0.putBoolean("payload_key_competition_open_status_update", true);
    L117:
        if (v(r11, r12) == true) goto L120;
        r0.putBoolean("payload_key_competition_score_update", true);
    L120:
        if (w(r11, r12) == true) goto L123;
        r0.putBoolean("payload_key_competition_win_type_update", true);
    L123:
        if (k(r11, r12) == true) goto L126;
        r0.putBoolean("payload_key_interact_song_golden_mic_display_state", true);
    L126:
        if (g(r11, r12) == true) goto L129;
        r0.putBoolean("payload_key_feedview_interact_song_golden_mic_online_state", true);
    L129:
        if (i(r11, r12) == true) goto L132;
        r0.putBoolean("payload_key_hamlet_avatar_position_update", true);
    L132:
        if (j(r11, r12) == true) goto L135;
        r0.putBoolean("payload_key_hamlet_avatar_rending_update", true);
    L135:
        if (u(r11, r12) == true) goto L138;
        r0.putBoolean("payload_key_request_song_open_update", true);
    L138:
        if (l(r11, r12) == true) goto L141;
        r0.putBoolean("payload_key_interact_song_golden_mic_info_update", true);
    L141:
        if (m(r12) == false) goto L144;
        r0.putBoolean("payload_key_interact_song_golden_mic_info_list_update", true);
    L144:
        if (n(r11, r12) == false) goto L147;
        r0.putBoolean("payload_key_feedview_interact_song_sub_ui_layout_update", true);
    L147:
        if (r11.k.a.isEnlarged() != r12.k.a.isEnlarged()) goto L149;
        boolean r35 = true;
    L150:
        if (r35 == true) goto L153;
        r0.putBoolean("payload_key_is_c_position_update", true);
    L153:
        if (h(r11, r12) == true) goto L156;
        r0.putBoolean("payload_key_changed_media_type_time_stamp", true);
    L156:
        if (r11.k.a.isHost() != r12.k.a.isHost()) goto L158;
        boolean r36 = true;
    L159:
        if (r36 == true) goto L162;
        r0.putBoolean("mic_room_host", true);
    L162:
        if (Lists.deepEquals(r11.o, r12.o) == true) goto L165;
        r0.putBoolean("payload_key_not_audio_user_position_list", true);
    L165:
        if (t(r11, r12) == true) goto L168;
        r0.putBoolean("payload_key_play_mode_state_update", true);
    L168:
        if (r11.f == r12.f) goto L170;
    L174:
        if (r3 == true) goto L177;
        r0.putBoolean("payload_key_room_state_update", true);
    L177:
        if (o(r11, r12) == true) goto L180;
        r0.putBoolean("payload_key_ktv_business_update", true);
    L180:
        if (y(r11, r12) == true) goto L183;
        r0.putBoolean("payload_key_audio_anchor_guest_info_update", true);
    L183:
        if (e(r11, r12) == true) goto L186;
        r0.putBoolean("payload_key_user_admin_update", true);
    L186:
        if (p(r11, r12) == true) goto L189;
        r0.putBoolean("payload_key_linkmic_2d_avatar_update", true);
    L189:
        if (q(r11, r12) == true) goto L191;
        r0.putBoolean("payload_key_linkmic_3d_avatar_update", true);
    L191:
        return r0;
    L170:
        if (r11.e != r12.e) goto L174;
        if (Intrinsics.areEqual(r11.g, r12.g) == false) goto L174;
        r3 = true;
        goto L174
    L158:
        r36 = false;
        goto L159
    L149:
        r35 = false;
        goto L150
    L113:
        r34 = false;
        goto L114
    L107:
        r33 = false;
        goto L108
    L95:
        r32 = false;
        goto L96
    L89:
        r31 = false;
        goto L90
    L83:
        r30 = false;
        goto L84
    L77:
        r29 = false;
        goto L78
    L71:
        r28 = false;
        goto L72
    L65:
        r27 = false;
        goto L66
    L56:
        r24 = false;
    L48:
        if (r21 == null) goto L50;
        r22 = r21.equals(r111);
        goto L51
    L50:
        r22 = false;
    L36:
        if (vm2.d.N0() == false) goto L40;
        if (r19 == null) goto L39;
        r20 = com.bytedance.android.live.liveinteract.multianchor.model.h.b(r19, r110);
    L39:
        r20 = false;
        goto L42
    L40:
        if (r19 == null) goto L39;
        r20 = r19.equals(r110);
        goto L42
    L26:
        if (r16.isSelfBackground() != r17.isSelfBackground()) goto L28;
        r18 = true;
        goto L29
    L18:
        if (r13.getRoomLinkSilenceStatus() != r14.getRoomLinkSilenceStatus()) goto L20;
        r15 = true;
    L8:
        r0.putBoolean("payload_key_user_position", true);
        goto L10
    L5:
        r1 = false;
        goto L6
    }
}
