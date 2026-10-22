package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.BaseProfileInfo;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileGiftExhibitionBanner;
import com.bytedance.android.live.base.model.user.ProfileGiftExhibitionBannerUIConfig;
import com.bytedance.android.live.base.model.user.ProfileGiftExhibitionBannerUniverseInfo;
import com.bytedance.android.live.base.model.user.ProfileText;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.profile.p000enum.TrackArea;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.IGroupLiveData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomOthersData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class y extends com.bytedance.android.live.profile.ui.base.k {
    public View b;
    public TextView c;
    public LinearLayout d;
    public LinearLayout e;
    public final com.bytedance.android.live.profile.ui.base.h f;

    public static final class a {
    }

    public static final class b extends vt0.b {
        public final /* synthetic */ y d;
        public final /* synthetic */ ProfileGiftExhibitionBanner e;
        public final /* synthetic */ NewProfileUser f;

        @Override // vt0.b
        public final void a(View r19) {
            View r1 = this.d.b;
            if (r1 == null) goto L160;
            Context r2 = r1.getContext();
            if (r2 == null) goto L161;
            String r3 = this.e.jumpSchema;
            if (r3 != null) goto L10;
        L13:
            boolean r5 = true;
        L14:
            if (r5 == false) goto L16;
            return;
        L16:
            IBaseLiveActionHandler r6 = jc1.k.f(IBaseLiveActionHandler.class);
            if (r6 == null) goto L19;
            r6.handle(r2, r3);
        L19:
            y r4 = this.d;
            NewProfileUser r7 = this.f;
            r4.getClass();
            LinkedHashMap r8 = new LinkedHashMap();
            IMiddlewareUserService r9 = jc1.k.f(IMiddlewareUserService.class);
            if (r9 == null) goto L25;
            com.bytedance.android.livesdk.user.e r10 = r9.user();
            if (r10 == null) goto L25;
            String r12 = r10.n();
            if (r12 == null) goto L25;
        L26:
            r8.put("user_id", r12);
            qs0.i r13 = os0.b.c().getIInteractService();
            if (r13 == null) goto L29;
            mv0.k.d r14 = r13.getLinkUserInfoCenter();
        L30:
            qs0.u r15 = os0.b.c().getIPkAudienceLinkOutServiceProxy();
            if (r15 == null) goto L33;
            mv0.b0.a r16 = r15.getPkLinkUserInfoCenter();
        L34:
            IMiddlewareUserService r17 = jc1.k.f(IMiddlewareUserService.class);
            String r18 = "group_member";
            if (r17 == null) goto L77;
            com.bytedance.android.livesdk.user.e r20 = r17.user();
            if (r20 == null) goto L77;
            String r22 = r20.n();
            if (r22 == null) goto L77;
            com.bytedance.android.livesdk.chatroom.o r110 = os0.b.a();
            if (r110 == null) goto L47;
            com.bytedance.live.datacontext.m r111 = r110.getRoom();
            if (r111 == null) goto L47;
            IRoom r112 = (IRoom) r111.getValue();
            if (r112 == null) goto L47;
            String r113 = r112.getOwnerUserIdString();
        L49:
            if (Intrinsics.areEqual(r113, r22) == false) goto L51;
            Object r23 = "anchor";
        L76:
            r8.put("user_type", r23);
            goto L77
        L51:
            if (r16 == null) goto L53;
            int r114 = r16.k(r22);
        L55:
            Integer r115 = Integer.valueOf(r114);
        L57:
            if (r115 == null) goto L59;
            int r116 = r115.intValue();
        L60:
            if (r116 == (-1)) goto L62;
            r23 = "guest";
            goto L76
        L62:
            boolean r117 = com.bytedance.android.live.revenue.core.util.h.a;
            List r118 = com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class).getGroupMemberList();
            if (r118 == null) goto L72;
            Iterator r119 = r118.iterator();
        L66:
            if (r119.hasNext() == false) goto L70;
            Object r120 = r119.next();
            if (Intrinsics.areEqual(((IBaseUser) r120).getIdString(), r22) == false) goto L66;
        L71:
            IBaseUser r121 = (IBaseUser) r120;
        L73:
            if (r121 == null) goto L75;
            r23 = "group_member";
            goto L76
        L75:
            r23 = "user";
            goto L76
        L70:
            r120 = null;
            goto L71
        L72:
            r121 = null;
            goto L73
        L59:
            r116 = -1;
            goto L60
        L53:
            if (r14 == null) goto L56;
            r114 = r14.o(r22);
            goto L55
        L56:
            r115 = null;
        L47:
            r113 = null;
        L77:
            BaseProfileInfo r24 = r4.f.getTargetUser().baseProfileInfo;
            if (r24 == null) goto L80;
            String r25 = r24.getIdStr();
        L81:
            String r26 = String.valueOf(r25);
            com.bytedance.android.livesdk.chatroom.o r27 = os0.b.a();
            if (r27 == null) goto L88;
            com.bytedance.live.datacontext.m r28 = r27.getRoom();
            if (r28 == null) goto L88;
            IRoom r29 = (IRoom) r28.getValue();
            if (r29 == null) goto L88;
            String r30 = r29.getOwnerUserIdString();
        L90:
            if (Intrinsics.areEqual(r30, r26) == false) goto L92;
            r18 = "anchor";
        L117:
            r8.put("to_user_type", r18);
            r8.put("entry_from", "new");
            ProfileGiftExhibitionBanner r32 = r7.getGiftExhibitionBannerData();
            if (r32 != null) goto L120;
        L141:
            com.bytedance.live.datacontext.m r33 = os0.b.a().getRoom();
            if (r33 == null) goto L152;
            IRoom r34 = (IRoom) r33.getValue();
            if (r34 == null) goto L152;
            IRoomOthersData r35 = r34.getRoomOthers();
            if (r35 == null) goto L152;
            IGroupLiveData r36 = r35.getGroupData();
            if (r36 == null) goto L152;
            if (r36.isGroupLive() != 1) goto L152;
            r8.put("is_grouped_lived", DataType.TRUE);
        L152:
            r4.f.sendLog("livesdk_giftwall_profile_card_click", r8, new Object[]{am2.x.class, IRoom.class});
            this.d.f.recordBusinessClick("gift_exhibition_banner", null);
            return;
        L120:
            if (r32.lightedCount != r32.totalCount) goto L122;
            String r37 = "is_collected";
        L123:
            r8.put("giftwall_status", r37);
            List r38 = r32.achievedGifts;
            if (r38 != null) goto L126;
        L129:
            boolean r39 = true;
        L130:
            String r40 = DataType.FALSE;
            if (r39 == true) goto L133;
            Object r42 = DataType.TRUE;
        L134:
            r8.put("is_light_expensive_gift", r42);
            List r43 = r32.achievedGifts;
            if (r43 == null) goto L140;
            String r44 = String.valueOf(r43.size());
            if (r44 == null) goto L140;
            r40 = r44;
        L140:
            r8.put("light_expensive_gift_cnt", r40);
            goto L141
        L133:
            r42 = DataType.FALSE;
            goto L134
        L126:
            if (r38.isEmpty() == true) goto L129;
            r39 = false;
            goto L130
        L122:
            r37 = "collecting";
            goto L123
        L92:
            if (r16 == null) goto L94;
            int r45 = r16.k(r26);
        L96:
            Integer r46 = Integer.valueOf(r45);
        L98:
            if (r46 == null) goto L100;
            int r47 = r46.intValue();
        L101:
            if (r47 == (-1)) goto L103;
            r18 = "guest";
            goto L117
        L103:
            boolean r48 = com.bytedance.android.live.revenue.core.util.h.a;
            List r49 = com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class).getGroupMemberList();
            if (r49 == null) goto L113;
            Iterator r50 = r49.iterator();
        L107:
            if (r50.hasNext() == false) goto L111;
            Object r52 = r50.next();
            if (Intrinsics.areEqual(((IBaseUser) r52).getIdString(), r26) == false) goto L107;
        L112:
            IBaseUser r53 = (IBaseUser) r52;
        L114:
            if (r53 == null) goto L116;
            r8.put("group_member_id", r26);
            goto L117
        L116:
            r18 = "user";
            goto L117
        L111:
            r52 = null;
            goto L112
        L113:
            r53 = null;
            goto L114
        L100:
            r47 = -1;
            goto L101
        L94:
            if (r14 == null) goto L97;
            r45 = r14.o(r26);
            goto L96
        L97:
            r46 = null;
        L88:
            r30 = null;
            goto L90
        L80:
            r25 = null;
            goto L81
        L33:
            r16 = null;
            goto L34
        L29:
            r14 = null;
        L25:
            r12 = "";
            goto L26
        L10:
            if (r3.length() == 0) goto L13;
            r5 = false;
            goto L14
        L161:
            return;
        }

        public b(y r1, ProfileGiftExhibitionBanner r2, NewProfileUser r3) {
            this.d = r1;
            this.e = r2;
            this.f = r3;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final ComponentType getComponentType() {
        return ComponentType.GroupAnchorGiftExhibition.INSTANCE;
    }

    public y(com.bytedance.android.live.profile.profilecontext.a r2) {
        Intrinsics.checkNotNullParameter(r2, "profileContext");
        this.f = r2;
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void b(com.bytedance.android.live.profile.ui.base.d r3) {
        if (((com.bytedance.android.live.profile.ui.base.e) r3).f(2131567179, true) == null) goto L6;
        this.b = i(2131373919);
        this.c = (TextView) i(2131373921);
        this.d = (LinearLayout) i(2131373920);
        this.e = (LinearLayout) i(2131373918);
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void d(NewProfileUser r15) {
        String r0 = "user";
        Intrinsics.checkNotNullParameter(r15, "user");
        Intrinsics.checkNotNullParameter(r15, "user");
        Intrinsics.checkNotNullParameter(r15, "user");
        this.f.recordBusinessShow(TrackArea.BottomOperatingArea, "gift_exhibition_banner");
        qs0.i r1 = os0.b.c().getIInteractService();
        Object r2 = null;
        if (r1 == null) goto L5;
        mv0.k.d r3 = r1.getLinkUserInfoCenter();
    L6:
        qs0.u r4 = os0.b.c().getIPkAudienceLinkOutServiceProxy();
        if (r4 == null) goto L9;
        mv0.b0.a r5 = r4.getPkLinkUserInfoCenter();
    L10:
        HashMap r6 = new HashMap();
        r6.put("card_type", "old");
        if (com.bytedance.android.live.profile.ui.base.i.l(this.f) == false) goto L13;
        String r7 = "normal_entrance";
    L14:
        r6.put("giftwall_entrance_type", r7);
        com.bytedance.android.livesdk.chatroom.o r8 = os0.b.a();
        IMiddlewareUserService r9 = jc1.k.f(IMiddlewareUserService.class);
        if (r9 == null) goto L56;
        com.bytedance.android.livesdk.user.e r10 = r9.user();
        if (r10 == null) goto L56;
        String r12 = r10.n();
        if (r12 == null) goto L56;
        if (r8 == null) goto L26;
        com.bytedance.live.datacontext.m r13 = r8.getRoom();
        if (r13 == null) goto L26;
        IRoom r14 = (IRoom) r13.getValue();
        if (r14 == null) goto L26;
        String r16 = r14.getOwnerUserIdString();
    L28:
        if (Intrinsics.areEqual(r16, r12) == false) goto L30;
        Object r17 = "anchor";
    L55:
        r6.put("user_type", r17);
        goto L56
    L30:
        if (r5 == null) goto L32;
        int r18 = r5.k(r12);
    L34:
        Integer r19 = Integer.valueOf(r18);
    L36:
        if (r19 == null) goto L38;
        int r110 = r19.intValue();
    L39:
        if (r110 == (-1)) goto L41;
        r17 = "guest";
        goto L55
    L41:
        boolean r111 = com.bytedance.android.live.revenue.core.util.h.a;
        List r112 = com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class).getGroupMemberList();
        if (r112 == null) goto L51;
        Iterator r113 = r112.iterator();
    L45:
        if (r113.hasNext() == false) goto L49;
        Object r114 = r113.next();
        if (Intrinsics.areEqual(((IBaseUser) r114).getIdString(), r12) == false) goto L45;
    L50:
        IBaseUser r115 = (IBaseUser) r114;
    L52:
        if (r115 == null) goto L54;
        r17 = "group_member";
        goto L55
    L54:
        r17 = "user";
        goto L55
    L49:
        r114 = null;
        goto L50
    L51:
        r115 = null;
        goto L52
    L38:
        r110 = -1;
        goto L39
    L32:
        if (r3 == null) goto L35;
        r18 = r3.o(r12);
        goto L34
    L35:
        r19 = null;
    L26:
        r16 = null;
    L56:
        BaseProfileInfo r20 = this.f.getTargetUser().baseProfileInfo;
        if (r20 == null) goto L59;
        String r22 = r20.getIdStr();
    L60:
        String r23 = String.valueOf(r22);
        if (r8 == null) goto L67;
        com.bytedance.live.datacontext.m r24 = r8.getRoom();
        if (r24 == null) goto L67;
        IRoom r25 = (IRoom) r24.getValue();
        if (r25 == null) goto L67;
        String r26 = r25.getOwnerUserIdString();
    L69:
        if (Intrinsics.areEqual(r26, r23) == false) goto L71;
        r0 = "anchor";
    L93:
        r6.put("to_user_type", r0);
        if (com.bytedance.android.live.profile.ui.base.i.h(this.f) == false) goto L96;
        String r27 = "open_package";
    L97:
        r6.put("show_from", r27);
        r6.put("entry_from", "new");
        ProfileGiftExhibitionBanner r116 = r15.getGiftExhibitionBannerData();
        if (r116 != null) goto L100;
    L121:
        com.bytedance.live.datacontext.m r117 = os0.b.a().getRoom();
        if (r117 == null) goto L132;
        IRoom r118 = (IRoom) r117.getValue();
        if (r118 == null) goto L132;
        IRoomOthersData r119 = r118.getRoomOthers();
        if (r119 == null) goto L132;
        IGroupLiveData r120 = r119.getGroupData();
        if (r120 == null) goto L132;
        if (r120.isGroupLive() != 1) goto L132;
        r6.put("is_grouped_lived", DataType.TRUE);
    L132:
        boolean r121 = com.bytedance.android.live.revenue.core.util.h.a;
        ((ILinkService) com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class)).mo471getRevenueLinkDataHolder();
        this.f.sendLog("livesdk_giftwall_profile_card_show", r6, new Object[]{xs0.a.a(), IRoom.class, am2.x.class});
        return;
    L100:
        if (r116.lightedCount != r116.totalCount) goto L102;
        String r28 = "is_collected";
    L103:
        r6.put("giftwall_status", r28);
        List r29 = r116.achievedGifts;
        if (r29 != null) goto L106;
    L109:
        boolean r30 = true;
    L110:
        String r32 = DataType.FALSE;
        if (r30 == true) goto L113;
        Object r33 = DataType.TRUE;
    L114:
        r6.put("is_light_expensive_gift", r33);
        List r122 = r116.achievedGifts;
        if (r122 == null) goto L120;
        String r123 = String.valueOf(r122.size());
        if (r123 == null) goto L120;
        r32 = r123;
    L120:
        r6.put("light_expensive_gift_cnt", r32);
        goto L121
    L113:
        r33 = DataType.FALSE;
        goto L114
    L106:
        if (r29.isEmpty() == true) goto L109;
        r30 = false;
        goto L110
    L102:
        r28 = "collecting";
        goto L103
    L96:
        r27 = DataType.Normal;
        goto L97
    L71:
        if (r5 == null) goto L73;
        int r34 = r5.k(r23);
    L75:
        Integer r35 = Integer.valueOf(r34);
    L77:
        if (r35 == null) goto L79;
        int r36 = r35.intValue();
    L80:
        if (r36 == (-1)) goto L82;
        r0 = "guest";
        goto L93
    L82:
        boolean r37 = com.bytedance.android.live.revenue.core.util.h.a;
        List r38 = com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class).getGroupMemberList();
        if (r38 == null) goto L91;
        Iterator r39 = r38.iterator();
    L86:
        if (r39.hasNext() == false) goto L90;
        Object r40 = r39.next();
        if (Intrinsics.areEqual(((IBaseUser) r40).getIdString(), r23) == false) goto L86;
        r2 = r40;
    L90:
        r2 = (IBaseUser) r2;
    L91:
        if (r2 == null) goto L93;
        r6.put("group_member_id", r23);
        r0 = "group_member";
        goto L93
    L79:
        r36 = -1;
        goto L80
    L73:
        if (r3 == null) goto L76;
        r34 = r3.o(r23);
        goto L75
    L76:
        r35 = null;
    L67:
        r26 = null;
        goto L69
    L59:
        r22 = null;
        goto L60
    L13:
        r7 = "nabob_sponsor";
        goto L14
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void g(NewProfileUser r12) {
        Intrinsics.checkNotNullParameter(r12, "user");
        ProfileGiftExhibitionBanner r0 = r12.getGiftExhibitionBannerData();
        if (r0 != null) goto L5;
        return;
    L5:
        LinearLayout r1 = this.d;
        if (r1 == null) goto L8;
        r1.removeAllViews();
    L8:
        LinearLayout r2 = this.e;
        if (r2 == null) goto L11;
        r2.removeAllViews();
    L11:
        TextView r3 = this.c;
        if (r3 == null) goto L14;
        r3.setTextColor(s1.h(2131107062));
    L14:
        View r4 = this.b;
        if (r4 == null) goto L17;
        r4.setBackgroundResource(2131249163);
    L17:
        TextView r5 = this.c;
        if (r5 == null) goto L20;
        r5.setText(r0.text);
    L20:
        zs0.a r6 = zs0.c.a;
        LinearLayout r7 = this.d;
        ProfileGiftExhibitionBannerUniverseInfo r8 = r0.universeInfo;
        Drawable r9 = null;
        if (r8 == null) goto L23;
        ProfileText r10 = r8.getSubTitle();
    L24:
        zs0.c.a(r7, r10, null, null);
        LinearLayout r13 = this.e;
        ProfileGiftExhibitionBannerUniverseInfo r14 = r0.universeInfo;
        if (r14 == null) goto L27;
        ProfileText r15 = r14.getContent();
    L28:
        zs0.c.a(r13, r15, null, null);
        ProfileGiftExhibitionBannerUIConfig r16 = r0.uiConfig;
        if (r16 != null) goto L76;
    L68:
        ProfileGiftExhibitionBannerUIConfig r17 = r0.uiConfig;
        if (r17 == null) goto L72;
        String r18 = r17.titleColorV3;
        int r19 = com.bytedance.android.live.profile.ui.util.m.a;
        com.bytedance.android.live.profile.ui.util.m.e(this.c, r18);
    L72:
        View r20 = this.b;
        if (r20 == null) goto L78;
        r20.setOnClickListener(new b(this, r0, r12));
        return;
    L78:
        return;
    L76:
        View r22 = this.b;     // Catch: Exception -> L66
        if (r22 == null) goto L34;
        Drawable r23 = r22.getBackground();     // Catch: Exception -> L66
    L36:
        if ((r23 instanceof GradientDrawable) == false) goto L39;
        r9 = r23;
    L39:
        GradientDrawable r24 = (GradientDrawable) r9;     // Catch: Exception -> L66
        if (r24 == null) goto L68;
        r24.mutate();     // Catch: Exception -> L66
        List r25 = r16.gradientColor;     // Catch: Exception -> L66
        boolean r26 = true;
        if (r25 == null) goto L54;
        r24.setGradientType(0);     // Catch: Exception -> L66
        r24.setOrientation(GradientDrawable.Orientation.BL_TR);     // Catch: Exception -> L66
        int r27 = r25.size();     // Catch: Exception -> L66
        if (r27 != 2) goto L47;
        r24.setColors(new int[]{Color.parseColor((String) ListProtector.get(r25, 0)), Color.parseColor((String) ListProtector.get(r25, 1))});     // Catch: Exception -> L66
        goto L54
    L47:
        if (r27 != 3) goto L54;
        if (Build.VERSION.SDK_INT < 29) goto L52;
        r24.setColors(new int[]{Color.parseColor((String) ListProtector.get(r25, 0)), Color.parseColor((String) ListProtector.get(r25, 1)), Color.parseColor((String) ListProtector.get(r25, 2))}, new float[]{0.0f, 0.7f, 1.0f});     // Catch: Exception -> L66
        goto L54
    L52:
        r24.setColors(new int[]{Color.parseColor((String) ListProtector.get(r25, 0)), Color.parseColor((String) ListProtector.get(r25, 1)), Color.parseColor((String) ListProtector.get(r25, 2))});     // Catch: Exception -> L66
    L54:
        String r28 = r16.borderColor;     // Catch: Exception -> L66
        if (r28 != null) goto L57;
    L60:
        if (r26 == true) goto L62;
        r24.setStroke((int) UtilityKotlinExtentionsKt.h(0.5f), Color.parseColor(r16.borderColor));     // Catch: Exception -> L66
    L62:
        View r29 = this.b;     // Catch: Exception -> L66
        if (r29 == null) goto L68;
        r29.setBackground(r24);     // Catch: Exception -> L66
        goto L68
    L57:
        if (r28.length() == 0) goto L60;
        r26 = false;
        goto L60
    L34:
        r23 = null;
    L66:
        e = move-exception;
        ALogger.e("ProfileGroupAnchorGiftExhibitionComponent", "ProfileGiftExhibitionComponent renderBackground error: " + e.getMessage());
        goto L68
    L27:
        r15 = null;
        goto L28
    L23:
        r10 = null;
        goto L24
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public void update(NewProfileUser r2) {
        Intrinsics.checkNotNullParameter(r2, "newUser");
        g(r2);
    }
}
