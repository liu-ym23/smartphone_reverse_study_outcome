package com.bytedance.android.live.liveinteract.revenue.common.vieweffect;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import ch0.f;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.MultiLinkMicSeatGiftIconElement;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.PlayType;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.revenue.battle.i;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.LinkMicQuickInteractView;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.ThemedCompetitionQuickInteractView;
import com.bytedance.android.live.profit.dress.s;
import com.bytedance.android.live.ui.k;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;
import nh0.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public final HSImageView a;
    public final ViewGroup b;
    public boolean c;
    public Integer d;
    public LinkMicQuickInteractView e;
    public MultiLinkMicSeatGiftIconElement f;
    public ThemedCompetitionQuickInteractView g;
    public String h;
    public final ViewGroup i;
    public final ke0.a j;
    public final xg0.a k;

    public final void b(String r4) {
        if (((Boolean) vm2.d.Z2.getValue(null, vm2.d.a[205(0xcd, float:2.87E-43)])).booleanValue() == false) goto L5;
        this.h = null;
    L5:
        f(r4);
        HSImageView r5 = this.a;
        if (r5 == null) goto L8;
        UtilityKotlinExtentionsKt.u(r5);
    L8:
        HSImageView r6 = this.a;
        if (r6 == null) goto L12;
        r6.setController(null);
        return;
    }

    public final void f(String r4) {
        if (this.c == false) goto L16;
        if (r4 == null) goto L17;
        com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.b r0 = new com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.b(r4, 1, null);
        r0.a = true;
        ke0.a r5 = this.j;
        if (r5 == null) goto L8;
        r5.b(r0);
    L8:
        Integer r6 = this.d;
        if (r6 == null) goto L18;
        int r7 = r6.intValue();
        xg0.a r1 = this.k;
        if (r1 == null) goto L19;
        ig0.b r8 = r1.P6(r7);
        if (r8 == null) goto L20;
        r8.b(r0);
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    public final void d(boolean r5, ch0.e r6) {
        String r0 = null;
        if (r6 == null) goto L5;
        ILinkPlayerInfoBridge r7 = r6.a;
    L7:
        if (r5 == false) goto L20;
        if (r7 != null) goto L10;
    L16:
        HSImageView r1 = this.a;
        if (r1 == null) goto L19;
        UtilityKotlinExtentionsKt.u(r1);
    L19:
        ALogger.w("CommonMicWidgetManager", "#onMediaTypeChanged# set fight seat effect gone. isVideoOrAvatar=" + r5 + ", guestInfo=" + r7);
        return;
    L10:
        if (r7.isBackground() == false) goto L16;
        IBaseUser r3 = r7.getUser();
        if (r3 == null) goto L15;
        r0 = r3.getIdString();
    L15:
        if (Intrinsics.areEqual(r0, je0.d.b0()) == true) goto L16;
    L20:
        HSImageView r2 = this.a;
        if (r2 == null) goto L25;
        Intrinsics.checkNotNullParameter(r2, "$this$setVisibilityVisibleIfNeed");
        if (this.c == true) goto L25;
        UIUtils.setViewVisibility(r2, 0);
    L25:
        ALogger.w("CommonMicWidgetManager", "#onMediaTypeChanged# set fight seat effect visible. isVideoOrAvatar=" + r5 + ", guestInfo=" + r7);
        return;
    L5:
        r7 = null;
        goto L7
    }

    public final void g(boolean r5, ch0.e r6) {
        String r0 = null;
        if (r6 == null) goto L5;
        ILinkPlayerInfoBridge r1 = r6.a;
    L6:
        boolean r2 = true;
        if (r5 == false) goto L28;
        int r7 = ki0.a.a;
        if (r1 != null) goto L11;
    L13:
        if (r1 == null) goto L18;
        IBaseUser r8 = r1.getUser();
        if (r8 == null) goto L18;
        r0 = r8.getIdString();
    L18:
        if ((!Intrinsics.areEqual(r0, je0.d.b0())) == true) goto L21;
    L20:
        r2 = false;
    L21:
        if (r2 == false) goto L35;
        HSImageView r9 = this.a;
        if (r9 == null) goto L27;
        Intrinsics.checkNotNullParameter(r9, "$this$setVisibilityVisibleIfNeed");
        if (this.c == true) goto L27;
        UIUtils.setViewVisibility(r9, 0);
    L27:
        ALogger.w("CommonMicWidgetManager", "#updateBackgroundStatus# set fight seat effect visible. isBackground=" + r5 + ", totalBackground=false, guestInfo=" + r1);
        return;
    L35:
        return;
    L11:
        if (r1.getSilenceStatus() != 0) goto L13;
    L28:
        if (r6 != null) goto L30;
    L32:
        r2 = false;
    L33:
        d(r2, r6);
        return;
    L30:
        if (f.b(r6) != true) goto L32;
    L5:
        r1 = null;
        goto L6
    }

    public static void e(LinkMicQuickInteractView r5, MultiLinkMicSeatGiftIconElement r6, m r7) {
        if (r7 == null) goto L7;
        Integer r1 = r7.m();
        if (r1 == null) goto L7;
        int r2 = r1.intValue();
    L8:
        String r3 = null;
        if (r5 == null) goto L14;
        if (r7 == null) goto L12;
        String r4 = r7.h();
    L13:
        r5.l(r2, r4);
        goto L14
    L12:
        r4 = null;
    L14:
        if (r5 == null) goto L16;
        r5.h(null);
    L16:
        if (r5 == null) goto L18;
        r5.g("#33000000");
    L18:
        if (r5 == null) goto L20;
        r5.setAnimationBackground("#57FE2C55");
    L20:
        if (r5 == null) goto L22;
        r5.i(null);
    L22:
        if (r5 == null) goto L29;
        if (r7 == null) goto L25;
        long r8 = r7.n();
    L26:
        if (r7 == null) goto L28;
        r3 = r7.h();
    L28:
        r5.s = r8;
        r5.t = r3;
        r5.k(false);
        goto L29
    L25:
        r8 = 0;
    L29:
        if (r6 != null) goto L31;
        return;
    L31:
        if (r6.d == true) goto L33;
        return;
    L33:
        if (r2 != 2) goto L36;
        if (r5 == null) goto L41;
        r5.setVisibility(0);
        return;
    L41:
        return;
    L36:
        if (r2 != 0) goto L43;
        r6.e(r6.b);
        return;
    L43:
        return;
    L7:
        r2 = 0;
        goto L8
    }

    public static void h(LinkMicQuickInteractView r7, MultiLinkMicSeatGiftIconElement r8, m r9) {
        if (r9 == null) goto L7;
        Integer r1 = r9.m();
        if (r1 == null) goto L7;
        int r2 = r1.intValue();
    L8:
        String r3 = null;
        if (r7 == null) goto L14;
        if (r9 == null) goto L12;
        String r4 = r9.h();
    L13:
        r7.l(r2, r4);
        goto L14
    L12:
        r4 = null;
    L14:
        String r5 = "";
        if (r7 == null) goto L27;
        int r6 = i.a;
        if (r9 == null) goto L20;
        String r10 = r9.h();
        if (r10 == null) goto L20;
    L21:
        Uri r11 = i.d(r10);
        if (r11 == null) goto L24;
        String r12 = r11.toString();
    L25:
        r7.h(r12);
        goto L27
    L24:
        r12 = null;
    L20:
        r10 = "";
    L27:
        if (r9 == null) goto L36;
        String r13 = r9.g();
        if (r13 == null) goto L36;
        if (r13.length() <= 0) goto L33;
        boolean r14 = true;
    L34:
        if (r14 != true) goto L36;
        String r15 = r9.g();
    L42:
        if (r7 == null) goto L44;
        r7.g(r15);
    L44:
        if (r7 == null) goto L51;
        int r16 = i.a;
        if (r9 == null) goto L49;
        String r17 = r9.h();
        if (r17 == null) goto L49;
    L50:
        r7.setAnimationBackground(i.b(r17));
    L49:
        r17 = "";
    L51:
        if (r7 == null) goto L59;
        int r18 = i.a;
        if (r9 == null) goto L58;
        String r19 = r9.h();
        if (r19 == null) goto L58;
        r5 = r19;
    L58:
        r7.i(i.c(r5));
    L59:
        if (r7 == null) goto L66;
        if (r9 == null) goto L62;
        long r20 = r9.n();
    L63:
        if (r9 == null) goto L65;
        r3 = r9.h();
    L65:
        r7.s = r20;
        r7.t = r3;
        r7.k(false);
        goto L66
    L62:
        r20 = 0;
    L66:
        if (r8 != null) goto L68;
        return;
    L68:
        if (r8.d == true) goto L70;
        return;
    L70:
        if (r2 != 2) goto L73;
        if (r7 == null) goto L78;
        r7.setVisibility(0);
        return;
    L78:
        return;
    L73:
        if (r2 != 0) goto L80;
        r8.e(r8.b);
        return;
    L80:
        return;
    L33:
        r14 = false;
    L36:
        int r21 = i.a;
        if (r9 == null) goto L40;
        String r22 = r9.h();
        if (r22 == null) goto L40;
    L41:
        r15 = i.b(r22);
    L40:
        r22 = "";
    L7:
        r2 = 0;
        goto L8
    }

    public final void a(String r11, String r12, boolean r13) {
        if (r12 == null) goto L5;
        Object r14 = r12;
    L22:
        gj0.i.a("CommonMicWidgetManager", "animateRightTopIcon  hatUrl : " + r12 + " animationUri : " + r14 + "  isVideoOrAvatar : " + r13);
        if (r14 != null) goto L25;
        return;
    L25:
        HSImageView r15 = this.a;
        if (r15 == null) goto L28;
        int r2 = qy.a.a;
        k.c(r15, qy.a.a(r14.toString()), 0, null);
    L28:
        HSImageView r16 = this.a;
        if (r16 == null) goto L31;
        r16.setAlpha(0.0f);
    L31:
        HSImageView r17 = this.a;
        if (r17 == null) goto L34;
        UtilityKotlinExtentionsKt.d(r17, 500);
    L34:
        if (r13 == false) goto L38;
        HSImageView r18 = this.a;
        if (r18 == null) goto L42;
        UtilityKotlinExtentionsKt.u(r18);
        return;
    L42:
        return;
    L38:
        HSImageView r19 = this.a;
        if (r19 == null) goto L44;
        UtilityKotlinExtentionsKt.w(r19);
        return;
    L44:
        return;
    L5:
        int r3 = i.a;
        Intrinsics.checkNotNullParameter(r11, "dressId");
        ALogger.i("CommonWidgetResouce", "#DressResourceDebug# [getCrownSettingIcon] dressId " + r11);
        if (r11 != null) goto L8;
    L11:
        boolean r4 = true;
    L12:
        if (r4 == true) goto L17;
        zt0.e r5 = yt0.c.a();
        Intrinsics.checkNotNull(r11);
        s r110 = r5.getDressData(r11, 33, i.a(), "CommonWidgetResouce asyncCrownBeautyEffectId", new com.bytedance.android.live.liveinteract.revenue.battle.c());
        if (r110 == null) goto L17;
        String r111 = r110.e;
    L19:
        if (TextUtils.isEmpty(r111) == false) goto L21;
        r14 = null;
        goto L22
    L21:
        r14 = UriProtector.parse(r111);
    L17:
        r111 = null;
        goto L19
    L8:
        if (r11.length() == 0) goto L11;
        r4 = false;
        goto L12
    }

    public final void c(m r22, boolean r23, boolean r24) {
        StringBuilder r4 = new StringBuilder("handleWidgetInfo ");
        r4.append(r22);
        r4.append(", isVideoOrAvatar ");
        r4.append(r23);
        r4.append(" isBind ");
        r4.append(r24);
        r4.append(". postion: ");
        r4.append(this.d);
        r4.append(" showingDressId: ");
        r4.append(this.h);
        r4.append(" guestSendGiftView ");
        r4.append(this.e);
        r4.append(" themedScoreView: ");
        r4.append(this.g);
        r4.append(" style : ");
        String r5 = null;
        if (r22 == null) goto L5;
        Integer r6 = r22.m();
    L6:
        r4.append(r6);
        ALogger.i("CommonMicWidgetManager", r4.toString());
        boolean r7 = false;
        if (c.a(r22) == false) goto L22;
        if (r22 == null) goto L10;
        String r2 = r22.c();
    L11:
        f(r2);
        HSImageView r3 = this.a;
        if (r3 == null) goto L14;
        UtilityKotlinExtentionsKt.u(r3);
    L14:
        HSImageView r8 = this.a;
        if (r8 == null) goto L17;
        r8.setController(null);
    L17:
        e(this.e, this.f, r22);
        e(null, null, r22);
        ThemedCompetitionQuickInteractView r1 = this.g;
        if (r1 == null) goto L20;
        r1.d(null, null, null, 0);
    L20:
        this.h = null;
        return;
    L10:
        r2 = null;
        goto L11
    L22:
        String r9 = this.h;
        if (r22 == null) goto L25;
        String r10 = r22.h();
    L27:
        if (Intrinsics.areEqual(r9, r10) == false) goto L43;
        if (r22 != null) goto L30;
    L31:
        if (r22 == null) goto L33;
        Integer r11 = r22.m();
    L34:
        if (r11 != null) goto L37;
    L38:
        StringBuilder r12 = new StringBuilder("try to show same dressId ");
        if (r22 == null) goto L41;
        r5 = r22.h();
    L41:
        r12.append(r5);
        r12.append(", do nothing.");
        ALogger.i("CommonMicWidgetManager", r12.toString());
        return;
    L37:
        if (r11.intValue() == 2) goto L43;
    L33:
        r11 = null;
        goto L34
    L30:
        if (r22.i() != true) goto L31;
    L43:
        h(this.e, this.f, r22);
        h(null, null, r22);
        ThemedCompetitionQuickInteractView r13 = this.g;
        final String r14 = "";
        if (r13 == null) goto L70;
        int r15 = i.a;
        if (r22 == null) goto L49;
        String r16 = r22.h();
        if (r16 == null) goto L49;
    L50:
        Uri r17 = i.d(r16);
        if (r17 == null) goto L53;
        String r18 = r17.toString();
    L54:
        if (r22 == null) goto L57;
        String r19 = r22.h();
        if (r19 == null) goto L57;
    L58:
        String r110 = i.b(r19);
        if (r22 == null) goto L62;
        String r111 = r22.h();
        if (r111 == null) goto L62;
    L63:
        String r112 = i.c(r111);
        if (r22 == null) goto L68;
        Integer r113 = r22.m();
        if (r113 == null) goto L68;
        int r114 = r113.intValue();
    L69:
        r13.d(r18, r110, r112, r114);
    L68:
        r114 = 0;
    L62:
        r111 = "";
    L57:
        r19 = "";
        goto L58
    L53:
        r18 = null;
    L49:
        r16 = "";
    L70:
        if (r22 == null) goto L74;
        String r20 = r22.c();
        if (r20 == null) goto L74;
    L75:
        f(r20);
        HSImageView r21 = this.a;
        if (r21 == null) goto L78;
        r21.setController(null);
    L78:
        if (r24 == false) goto L97;
        if (r22 == null) goto L84;
        String r25 = r22.h();
        if (r25 == null) goto L84;
        r14 = r25;
    L84:
        if (r22 == null) goto L86;
        String r26 = r22.j();
    L87:
        if (r23 == false) goto L96;
        if (r22 == null) goto L90;
        Integer r27 = r22.m();
    L91:
        if (r27 != null) goto L94;
    L95:
        r7 = true;
        goto L96
    L94:
        if (r27.intValue() == 2) goto L96;
    L90:
        r27 = null;
    L96:
        a(r14, r26, r7);
    L190:
        if (r22 == null) goto L192;
        r5 = r22.h();
    L192:
        this.h = r5;
        return;
    L86:
        r26 = null;
        goto L87
    L97:
        if (r22 == null) goto L99;
        PlayType r28 = r22.k();
    L101:
        if (r28 != PlayType.PLAY_TYPE_NONE) goto L114;
        String r29 = r22.h();
        if (r29 == null) goto L105;
        r14 = r29;
    L105:
        String r30 = r22.j();
        if (r23 == false) goto L113;
        Integer r31 = r22.m();
        if (r31 != null) goto L111;
    L112:
        r7 = true;
        goto L113
    L111:
        if (r31.intValue() != 2) goto L112;
    L113:
        a(r14, r30, r7);
        goto L190
    L114:
        if (r22 == null) goto L116;
        PlayType r32 = r22.k();
    L118:
        if (r32 != PlayType.PLAY_TYPE_SEAT) goto L173;
        String r115 = r22.c().toString();
        String r33 = r22.h();
        if (r33 == null) goto L122;
        r14 = r33;
    L122:
        final String r34 = r22.j();
        if (r23 == false) goto L130;
        Integer r35 = r22.m();
        if (r35 != null) goto L128;
    L129:
        final boolean r36 = true;
    L131:
        String r37 = r22.l();
        if (r36 == false) goto L134;
        a(r14, r34, r36);
        goto L190
    L134:
        HSImageView r38 = this.a;
        if (r38 == null) goto L137;
        UtilityKotlinExtentionsKt.u(r38);
    L137:
        int r39 = i.a;
        Intrinsics.checkNotNullParameter(r14, "dressId");
        if (r14.length() != 0) goto L140;
        boolean r116 = true;
    L141:
        if (r116 == true) goto L146;
        zt0.e r117 = yt0.c.a();
        Intrinsics.checkNotNull(r14);
        s r118 = r117.getDressData(r14, 33, i.a(), "CommonWidgetResouce asyncCrownBeautyEffectId", new com.bytedance.android.live.liveinteract.revenue.battle.b());
        if (r118 == null) goto L146;
        String r119 = r118.c;
    L148:
        if (TextUtils.isEmpty(r119) == false) goto L150;
        Uri r210 = null;
    L151:
        Intrinsics.checkNotNullParameter(r14, "dressId");
        ALogger.i("CommonWidgetResouce", "#DressResourceDebug# [getSponsorBgColorByDressId] dressId ".concat(r14));
        if (r14.length() != 0) goto L154;
        r7 = true;
    L154:
        if (r7 == true) goto L159;
        zt0.e r120 = yt0.c.a();
        Intrinsics.checkNotNull(r14);
        s r40 = r120.getDressData(r14, 33, i.a(), "CommonWidgetResouce asyncCrownBeautyEffectId", new com.bytedance.android.live.liveinteract.revenue.battle.e());
        if (r40 == null) goto L159;
        String r121 = r40.i;
    L160:
        if (r210 == null) goto L172;
        com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.b r41 = new com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.b(r115, 1, -1, r210, r37, r121, new CommonMicWidgetManager$playSeatCrownAnim$animEvent$1(this, r14, r34, r36));
        r41.b = true;
        ke0.a r42 = this.j;
        if (r42 == null) goto L164;
        r42.b(r41);
    L164:
        Integer r43 = this.d;
        if (r43 == null) goto L171;
        int r44 = r43.intValue();
        xg0.a r45 = this.k;
        if (r45 == null) goto L171;
        ig0.b r46 = r45.P6(r44);
        if (r46 == null) goto L171;
        r46.b(r41);
    L171:
        this.c = true;
        goto L190
    L172:
        ALogger.e("CommonMicWidgetManager", "playSeatCrownAnim error, dressId " + r14 + " userId " + r115);
        a(r14, r34, r36);
    L159:
        r121 = null;
        goto L160
    L150:
        r210 = UriProtector.parse(r119);
    L146:
        r119 = null;
        goto L148
    L140:
        r116 = false;
        goto L141
    L128:
        if (r35.intValue() != 2) goto L129;
    L130:
        r36 = false;
        goto L131
    L173:
        if (r22 == null) goto L177;
        String r47 = r22.h();
        if (r47 == null) goto L177;
        r14 = r47;
    L177:
        if (r22 == null) goto L179;
        String r48 = r22.j();
    L180:
        if (r23 == false) goto L189;
        if (r22 == null) goto L183;
        Integer r49 = r22.m();
    L184:
        if (r49 != null) goto L187;
    L188:
        r7 = true;
        goto L189
    L187:
        if (r49.intValue() == 2) goto L189;
    L183:
        r49 = null;
    L189:
        a(r14, r48, r7);
        goto L190
    L179:
        r48 = null;
        goto L180
    L116:
        r32 = null;
        goto L118
    L99:
        r28 = null;
    L74:
        r20 = null;
        goto L75
    L25:
        r10 = null;
        goto L27
    L5:
        r6 = null;
        goto L6
    }

    public b(ViewGroup r1, ke0.a r2, boolean r3, xg0.a r4) {
        Intrinsics.checkNotNullParameter(r1, "root");
        this.i = r1;
        this.j = r2;
        this.k = r4;
        this.a = r1.findViewById(2131389466);
        this.b = (ViewGroup) r1.findViewById(2131389467);
        View r5 = r1.findViewById(2131374117);
        if (r5 == null) goto L6;
        r5.post(new a(this, r5));
        return;
    }
}
