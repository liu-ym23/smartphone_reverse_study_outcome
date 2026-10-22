package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.BaseProfileInfo;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileGiftExhibitionBanner;
import com.bytedance.android.live.base.model.user.ProfileGiftExhibitionBannerUIConfig;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.profile.model.EnterExitStateType;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.profile.p000enum.TrackArea;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateUtil;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateViewInfo;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.IGroupLiveData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomOthersData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ProfileGiftExhibitionComponent extends com.bytedance.android.live.profile.ui.base.k {
    public static final int s = 0;
    public static final com.bytedance.android.livesdk.sharedpref.e<com.bytedance.android.live.profile.model.e> t = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Set<Integer>> u = null;
    public View b;
    public TextView c;
    public TextView d;
    public TextView e;
    public HSImageView f;
    public HSImageView g;
    public HSImageView h;
    public LinearLayout i;
    public LinearLayout j;
    public Disposable k;
    public Disposable l;
    public Disposable m;
    public AnimatorSet n;
    public boolean o;
    public boolean p;
    public final ca0.l q;
    public final com.bytedance.android.live.profile.ui.base.h r;

    public static final class a {
        public a() {
        }
    }

    public static final class b extends vt0.b {
        public final /* synthetic */ ProfileGiftExhibitionComponent d;
        public final /* synthetic */ ProfileGiftExhibitionBanner e;
        public final /* synthetic */ NewProfileUser f;

        @Override // vt0.b
        public final void a(View r19) {
            View r1 = this.d.b;
            if (r1 == null) goto L170;
            Context r2 = r1.getContext();
            if (r2 == null) goto L171;
            String r3 = this.e.jumpSchema;
            if (r3 != null) goto L10;
        L13:
            boolean r5 = true;
        L14:
            if (r5 == false) goto L16;
            return;
        L16:
            ca0.l r6 = this.d.q;
            if (r6 == null) goto L26;
            BaseProfileInfo r7 = this.f.baseProfileInfo;
            if (r7 == null) goto L21;
            String r8 = r7.getIdStr();
        L22:
            String r9 = r6.g(r8, r3);
            if (r9 == null) goto L26;
            r3 = r9;
            goto L26
        L21:
            r8 = null;
        L26:
            IBaseLiveActionHandler r10 = jc1.k.f(IBaseLiveActionHandler.class);
            if (r10 == null) goto L29;
            r10.handle(r2, r3);
        L29:
            ProfileGiftExhibitionComponent r4 = this.d;
            NewProfileUser r12 = this.f;
            r4.getClass();
            LinkedHashMap r13 = new LinkedHashMap();
            IMiddlewareUserService r14 = jc1.k.f(IMiddlewareUserService.class);
            if (r14 == null) goto L35;
            com.bytedance.android.livesdk.user.e r15 = r14.user();
            if (r15 == null) goto L35;
            String r16 = r15.n();
            if (r16 == null) goto L35;
        L36:
            r13.put("user_id", r16);
            qs0.i r17 = os0.b.c().getIInteractService();
            if (r17 == null) goto L39;
            mv0.k.d r18 = r17.getLinkUserInfoCenter();
        L40:
            qs0.u r20 = os0.b.c().getIPkAudienceLinkOutServiceProxy();
            if (r20 == null) goto L43;
            mv0.b0.a r22 = r20.getPkLinkUserInfoCenter();
        L44:
            IMiddlewareUserService r23 = jc1.k.f(IMiddlewareUserService.class);
            String r110 = "group_member";
            if (r23 == null) goto L87;
            com.bytedance.android.livesdk.user.e r24 = r23.user();
            if (r24 == null) goto L87;
            String r25 = r24.n();
            if (r25 == null) goto L87;
            com.bytedance.android.livesdk.chatroom.o r111 = os0.b.a();
            if (r111 == null) goto L57;
            com.bytedance.live.datacontext.m r112 = r111.getRoom();
            if (r112 == null) goto L57;
            IRoom r113 = (IRoom) r112.getValue();
            if (r113 == null) goto L57;
            String r114 = r113.getOwnerUserIdString();
        L59:
            if (Intrinsics.areEqual(r114, r25) == false) goto L61;
            Object r26 = "anchor";
        L86:
            r13.put("user_type", r26);
            goto L87
        L61:
            if (r22 == null) goto L63;
            int r115 = r22.k(r25);
        L65:
            Integer r116 = Integer.valueOf(r115);
        L67:
            if (r116 == null) goto L69;
            int r117 = r116.intValue();
        L70:
            if (r117 == (-1)) goto L72;
            r26 = "guest";
            goto L86
        L72:
            boolean r118 = com.bytedance.android.live.revenue.core.util.h.a;
            List r119 = com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class).getGroupMemberList();
            if (r119 == null) goto L82;
            Iterator r120 = r119.iterator();
        L76:
            if (r120.hasNext() == false) goto L80;
            Object r121 = r120.next();
            if (Intrinsics.areEqual(((IBaseUser) r121).getIdString(), r25) == false) goto L76;
        L81:
            IBaseUser r122 = (IBaseUser) r121;
        L83:
            if (r122 == null) goto L85;
            r26 = "group_member";
            goto L86
        L85:
            r26 = "user";
            goto L86
        L80:
            r121 = null;
            goto L81
        L82:
            r122 = null;
            goto L83
        L69:
            r117 = -1;
            goto L70
        L63:
            if (r18 == null) goto L66;
            r115 = r18.o(r25);
            goto L65
        L66:
            r116 = null;
        L57:
            r114 = null;
        L87:
            BaseProfileInfo r27 = r4.r.getTargetUser().baseProfileInfo;
            if (r27 == null) goto L90;
            String r28 = r27.getIdStr();
        L91:
            String r29 = String.valueOf(r28);
            com.bytedance.android.livesdk.chatroom.o r30 = os0.b.a();
            if (r30 == null) goto L98;
            com.bytedance.live.datacontext.m r32 = r30.getRoom();
            if (r32 == null) goto L98;
            IRoom r33 = (IRoom) r32.getValue();
            if (r33 == null) goto L98;
            String r34 = r33.getOwnerUserIdString();
        L100:
            if (Intrinsics.areEqual(r34, r29) == false) goto L102;
            r110 = "anchor";
        L127:
            r13.put("to_user_type", r110);
            r13.put("entry_from", "new");
            ProfileGiftExhibitionBanner r35 = r12.getGiftExhibitionBannerData();
            if (r35 != null) goto L130;
        L151:
            com.bytedance.live.datacontext.m r36 = os0.b.a().getRoom();
            if (r36 == null) goto L162;
            IRoom r37 = (IRoom) r36.getValue();
            if (r37 == null) goto L162;
            IRoomOthersData r38 = r37.getRoomOthers();
            if (r38 == null) goto L162;
            IGroupLiveData r39 = r38.getGroupData();
            if (r39 == null) goto L162;
            if (r39.isGroupLive() != 1) goto L162;
            r13.put("is_grouped_lived", DataType.TRUE);
        L162:
            r4.r.sendLog("livesdk_giftwall_profile_card_click", r13, new Object[]{am2.x.class, IRoom.class});
            this.d.r.recordBusinessClick("gift_exhibition_banner", null);
            return;
        L130:
            if (r35.lightedCount != r35.totalCount) goto L132;
            String r40 = "is_collected";
        L133:
            r13.put("giftwall_status", r40);
            List r42 = r35.achievedGifts;
            if (r42 != null) goto L136;
        L139:
            boolean r43 = true;
        L140:
            String r44 = DataType.FALSE;
            if (r43 == true) goto L143;
            Object r45 = DataType.TRUE;
        L144:
            r13.put("is_light_expensive_gift", r45);
            List r46 = r35.achievedGifts;
            if (r46 == null) goto L150;
            String r47 = String.valueOf(r46.size());
            if (r47 == null) goto L150;
            r44 = r47;
        L150:
            r13.put("light_expensive_gift_cnt", r44);
            goto L151
        L143:
            r45 = DataType.FALSE;
            goto L144
        L136:
            if (r42.isEmpty() == true) goto L139;
            r43 = false;
            goto L140
        L132:
            r40 = "collecting";
            goto L133
        L102:
            if (r22 == null) goto L104;
            int r48 = r22.k(r29);
        L106:
            Integer r49 = Integer.valueOf(r48);
        L108:
            if (r49 == null) goto L110;
            int r50 = r49.intValue();
        L111:
            if (r50 == (-1)) goto L113;
            r110 = "guest";
            goto L127
        L113:
            boolean r52 = com.bytedance.android.live.revenue.core.util.h.a;
            List r53 = com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class).getGroupMemberList();
            if (r53 == null) goto L123;
            Iterator r54 = r53.iterator();
        L117:
            if (r54.hasNext() == false) goto L121;
            Object r55 = r54.next();
            if (Intrinsics.areEqual(((IBaseUser) r55).getIdString(), r29) == false) goto L117;
        L122:
            IBaseUser r56 = (IBaseUser) r55;
        L124:
            if (r56 == null) goto L126;
            r13.put("group_member_id", r29);
            goto L127
        L126:
            r110 = "user";
            goto L127
        L121:
            r55 = null;
            goto L122
        L123:
            r56 = null;
            goto L124
        L110:
            r50 = -1;
            goto L111
        L104:
            if (r18 == null) goto L107;
            r48 = r18.o(r29);
            goto L106
        L107:
            r49 = null;
        L98:
            r34 = null;
            goto L100
        L90:
            r28 = null;
            goto L91
        L43:
            r22 = null;
            goto L44
        L39:
            r18 = null;
        L35:
            r16 = "";
            goto L36
        L10:
            if (r3.length() == 0) goto L13;
            r5 = false;
            goto L14
        L171:
            return;
        }

        public b(ProfileGiftExhibitionComponent r1, ProfileGiftExhibitionBanner r2, NewProfileUser r3) {
            this.d = r1;
            this.e = r2;
            this.f = r3;
        }
    }

    static {
        new a();
        s = UtilityKotlinExtentionsKt.i(6);
        t = new com.bytedance.android.livesdk.sharedpref.e("live_profile_gift_exhibition_anim_info", new com.bytedance.android.live.profile.model.e());
        u = new com.bytedance.android.livesdk.sharedpref.e("live_profile_gift_exhibition_grad_update_record", new LinkedHashSet());
    }

    public static int m() {
        return ((Integer) rs0.e0.a.getValue()).intValue();
    }

    public final boolean o() {
        if (com.bytedance.android.live.profile.ui.base.i.l(this.r) == false) goto L7;
        ALogger.i("GiftExhibition", "target is anchor");
        return true;
    L7:
        if (os0.b.c().getLinkPlayerState().getData() == 0) goto L10;
        ALogger.i("GiftExhibition", "target is talk guest");
        return true;
    L10:
        boolean r0 = com.bytedance.android.live.revenue.core.util.h.a;
        ILinkService r1 = (ILinkService) com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class);
        p11.j r3 = r1.mo471getRevenueLinkDataHolder();
        com.bytedance.android.live.profile.ui.base.h r4 = this.r;
        Intrinsics.checkNotNullParameter(r4, "$this$targetUserId");
        String r5 = r4.getPageTypeUseCase().h;
        if (r3 == null) goto L13;
        String r6 = r3.a();
    L15:
        if (Intrinsics.areEqual(r6, r5) == true) goto L42;
        p11.e r2 = r1.mo468getMultiAnchorService();
        if (r2 != null) goto L19;
    L20:
        qs0.r r7 = os0.b.c().getIMediaLinkOutService();
        if (r7 != null) goto L23;
    L24:
        qs0.d r8 = os0.b.c().getIBroadcastService();
        if (r8 != null) goto L27;
    L29:
        qs0.i r9 = os0.b.c().getIInteractService();
        if (r9 == null) goto L36;
        mv0.k.d r10 = r9.getLinkUserInfoCenter();
        if (r10 == null) goto L36;
        ILinkPlayerInfoBridge r12 = r10.k(r5.toString());
        if (r12 == null) goto L36;
        int r13 = r12.getLinkStatus();
    L38:
        if (r13 != 2) goto L41;
        ALogger.i("GiftExhibition", "target is link audience");
        return true;
    L41:
        return false;
    L36:
        r13 = 0;
        goto L38
    L27:
        if (r8.isUserInAnchorLink(r5) != true) goto L29;
    L23:
        if (r7.isUserInMediaLink(r5) == true) goto L42;
    L19:
        if (r2.a(r5) != true) goto L20;
    L42:
        ALogger.i("GiftExhibition", "target is link anchor");
        return true;
    L13:
        r6 = null;
        goto L15
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void onComponentDestroy() {
        Disposable r0 = this.k;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.k = null;
        Disposable r1 = this.l;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        this.l = null;
        Disposable r2 = this.m;
        if (r2 == null) goto L11;
        r2.dispose();
    L11:
        this.m = null;
        this.o = true;
        AnimatorSet r3 = this.n;
        if (r3 == null) goto L14;
        r3.cancel();
    L14:
        this.n = null;
        this.p = false;
        ca0.l r4 = this.q;
        if (r4 == null) goto L18;
        r4.f();
        return;
    }

    public final boolean k() {
        if (o() == true) goto L5;
        return false;
    L5:
        com.bytedance.android.livesdk.sharedpref.e<com.bytedance.android.live.profile.model.e> r0 = t;
        com.bytedance.android.live.profile.model.e r2 = (com.bytedance.android.live.profile.model.e) r0.getValue();
        if (r2 != null) goto L8;
        return false;
    L8:
        long r3 = r2.a();
        long r5 = System.currentTimeMillis();
        if (r3 >= (r5 - ((((long) TimeZone.getDefault().getRawOffset()) + r5) % 86400000))) goto L12;
        ALogger.i("GiftExhibition", "new day, reset playedTimes 0");
        r2.d(0);
    L12:
        if (r2.b() >= m()) goto L14;
        ALogger.i("GiftExhibition", "don't reach limited times, current playedTimes is " + r2.b() + ", limited times is " + m());
        r2.d(r2.b() + 1);
        r2.c(System.currentTimeMillis());
        com.bytedance.android.livesdk.sharedpref.f.d(r0, r2);
        return true;
    L14:
        ALogger.i("GiftExhibition", "reach limited times, current playedTimes is " + r2.b() + ", limited times is " + m());
        return false;
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final ComponentType getComponentType() {
        return ComponentType.GiftExhibition.INSTANCE;
    }

    public ProfileGiftExhibitionComponent(com.bytedance.android.live.profile.profilecontext.a r2) {
        Intrinsics.checkNotNullParameter(r2, "profileContext");
        this.r = r2;
        boolean r3 = com.bytedance.android.live.revenue.core.util.h.a;
        this.q = com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class).getGiftWallPreRequestManager();
    }

    public static boolean l(int r5) {
        if (r5 != 0) goto L5;
        return false;
    L5:
        com.bytedance.android.livesdk.sharedpref.e<Set<Integer>> r1 = u;
        Set r2 = (Set) r1.getValue();
        if (r2 != null) goto L8;
    L10:
        Set r0 = (Set) r1.getValue();
        if (r0 == null) goto L13;
        r0.add(Integer.valueOf(r5));
    L13:
        return true;
    L8:
        if (r2.contains(Integer.valueOf(r5)) != true) goto L10;
        return false;
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void b(com.bytedance.android.live.profile.ui.base.d r6) {
        int r1 = 2131567178;
        LinearLayout r4 = null;
        if (ProfilePreInflateUtil.a() == false) goto L15;
        if (this.r.getTargetUser().useStandardHonorWallV3() == false) goto L10;
        if (r6 == null) goto L21;
        View r7 = r6.b(ProfilePreInflateViewInfo.TTLIVE_PROFILE_GIFT_EXHIBITION_NEW, true);
        if (r7 == null) goto L21;
        View r8 = r7.findViewById(2131373707);
    L22:
        this.b = r8;
        if (r8 == null) goto L25;
        TextView r9 = (TextView) r8.findViewById(2131373708);
    L26:
        this.c = r9;
        View r10 = this.b;
        if (r10 == null) goto L29;
        TextView r12 = (TextView) r10.findViewById(2131373706);
    L30:
        this.d = r12;
        View r13 = this.b;
        if (r13 == null) goto L33;
        TextView r14 = (TextView) r13.findViewById(2131373709);
    L34:
        this.e = r14;
        View r15 = this.b;
        if (r15 == null) goto L37;
        HSImageView r16 = (HSImageView) r15.findViewById(2131373699);
    L38:
        this.f = r16;
        View r17 = this.b;
        if (r17 == null) goto L41;
        HSImageView r18 = (HSImageView) r17.findViewById(2131373703);
    L42:
        this.g = r18;
        View r19 = this.b;
        if (r19 == null) goto L45;
        HSImageView r20 = (HSImageView) r19.findViewById(2131373701);
    L46:
        this.h = r20;
        View r22 = this.b;
        if (r22 == null) goto L49;
        LinearLayout r23 = (LinearLayout) r22.findViewById(2131373704);
    L50:
        this.i = r23;
        View r24 = this.b;
        if (r24 == null) goto L53;
        r4 = (LinearLayout) r24.findViewById(2131373705);
    L53:
        this.j = r4;
        return;
    L49:
        r23 = null;
        goto L50
    L45:
        r20 = null;
        goto L46
    L41:
        r18 = null;
        goto L42
    L37:
        r16 = null;
        goto L38
    L33:
        r14 = null;
        goto L34
    L29:
        r12 = null;
        goto L30
    L25:
        r9 = null;
    L21:
        r8 = null;
        goto L22
    L10:
        if (r6 == null) goto L21;
        View r25 = r6.f(2131567178, true);
        if (r25 == null) goto L21;
        r8 = r25.findViewById(2131373707);
        goto L22
    L15:
        if (this.r.getTargetUser().useStandardHonorWallV3() == false) goto L17;
        r1 = 2131567180;
    L17:
        if (r6 == null) goto L21;
        View r26 = r6.f(r1, true);
        if (r26 == null) goto L21;
        r8 = r26.findViewById(2131373707);
        goto L22
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void d(NewProfileUser r15) {
        String r0 = "user";
        Intrinsics.checkNotNullParameter(r15, "user");
        Intrinsics.checkNotNullParameter(r15, "user");
        Intrinsics.checkNotNullParameter(r15, "user");
        this.r.recordBusinessShow(TrackArea.BottomOperatingArea, "gift_exhibition_banner");
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
        if (com.bytedance.android.live.profile.ui.base.i.l(this.r) == false) goto L13;
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
        BaseProfileInfo r20 = this.r.getTargetUser().baseProfileInfo;
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
        if (com.bytedance.android.live.profile.ui.base.i.h(this.r) == false) goto L96;
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
        this.r.sendLog("livesdk_giftwall_profile_card_show", r6, new Object[]{xs0.a.a(), IRoom.class, am2.x.class});
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
        j(r12);
        if (l(r0.gradeLevel) == false) goto L8;
        p(r0, Boolean.TRUE);
    L13:
        if (((Boolean) rs0.q.a.getValue()).booleanValue() == true) goto L15;
        boolean r13 = k();
        this.p = r13;
        if (r13 == false) goto L45;
        Disposable r14 = this.l;
        if (r14 == null) goto L44;
        r14.dispose();
    L44:
        this.l = com.bytedance.android.live.profile.ui.base.i.j(this.r, new ProfileGiftExhibitionComponent$bindUserData$3(this));
        return;
    L45:
        n(r0, Boolean.FALSE);
        return;
    L15:
        if (o() == false) goto L32;
        com.bytedance.android.live.profile.model.e r15 = (com.bytedance.android.live.profile.model.e) t.getValue();
        if (r15 == null) goto L29;
        long r3 = r15.a();
        long r5 = System.currentTimeMillis();
        if (r3 >= (r5 - ((((long) TimeZone.getDefault().getRawOffset()) + r5) % 86400000))) goto L25;
        ALogger.i("GiftExhibition", "new day, reset playedTimes 0");
        if (m() <= 0) goto L29;
    L27:
        boolean r16 = true;
    L30:
        if (r16 == false) goto L32;
        boolean r17 = true;
    L33:
        if (r17 == false) goto L38;
        this.p = true;
        Disposable r18 = this.l;
        if (r18 == null) goto L37;
        r18.dispose();
    L37:
        this.l = com.bytedance.android.live.profile.ui.base.i.j(this.r, new ProfileGiftExhibitionComponent$bindUserData$2(this));
        return;
    L38:
        this.p = false;
        n(r0, Boolean.FALSE);
        return;
    L25:
        if (r15.b() >= m()) goto L28;
        ALogger.i("GiftExhibition", "don't reach limited times, current playedTimes is " + r15.b() + ", limited times is " + m());
        goto L27
    L28:
        ALogger.i("GiftExhibition", "reach limited times, current playedTimes is " + r15.b() + ", limited times is " + m());
    L29:
        r16 = false;
    L32:
        r17 = false;
        goto L33
    L8:
        Disposable r19 = this.m;
        if (r19 == null) goto L11;
        r19.dispose();
    L11:
        this.m = com.bytedance.android.live.profile.ui.base.i.j(this.r, new ProfileGiftExhibitionComponent$bindUserData$1(this));
        goto L13
    }

    public final void j(NewProfileUser r13) {
        ProfileGiftExhibitionBanner r0 = r13.getGiftExhibitionBannerData();
        if (r0 != null) goto L5;
        return;
    L5:
        TextView r1 = this.c;
        if (r1 == null) goto L8;
        r1.setText(r0.text);
    L8:
        com.bytedance.android.live.profile.ui.base.h r2 = this.r;
        Intrinsics.checkNotNullParameter(r2, "$this$useStandardHonorWallV3");
        if (r2.getTargetUser().useStandardHonorWallV3() == true) goto L11;
        int r3 = com.bytedance.android.live.profile.ui.util.m.a;
        com.bytedance.android.live.profile.ui.util.m.a(this.d);
        com.bytedance.android.live.profile.ui.util.m.a(this.e);
    L11:
        TextView r4 = this.d;
        if (r4 == null) goto L14;
        r4.setText(String.valueOf(r0.lightedCount));
    L14:
        TextView r5 = this.e;
        if (r5 == null) goto L17;
        r5.setText(String.valueOf(r0.totalCount));
    L17:
        py.k r6 = r0.achievedIcon;
        if (r6 == null) goto L26;
        HSImageView r7 = this.f;
        if (r7 == null) goto L22;
        a1.p(r7, UtilityKotlinExtentionsKt.i(r6.getWidth()));
    L22:
        HSImageView r8 = this.f;
        if (r8 == null) goto L25;
        a1.k(r8, UtilityKotlinExtentionsKt.i(r6.getHeight()));
    L25:
        ImageLoader.bindImage(this.f, r6);
    L26:
        ProfileGiftExhibitionBannerUIConfig r9 = r0.uiConfig;
        View r10 = null;
        if (r9 != null) goto L102;
    L74:
        ProfileGiftExhibitionBannerUIConfig r12 = r0.uiConfig;
        if (r12 == null) goto L95;
        com.bytedance.android.live.profile.ui.base.h r14 = this.r;
        Intrinsics.checkNotNullParameter(r14, "$this$useStandardHonorWallV3");
        if (r14.getTargetUser().useStandardHonorWallV3() == false) goto L87;
        String r15 = r12.titleColorV3;
        String r16 = r12.textColorV3;
        int r17 = com.bytedance.android.live.profile.ui.util.m.a;
        com.bytedance.android.live.profile.ui.util.m.e(this.c, r15);
        View[] r18 = new View[4];
        r18[0] = this.d;
        r18[1] = this.e;
        View r19 = this.b;
        if (r19 == null) goto L82;
        View r20 = r19.findViewById(2131373702);
    L83:
        r18[2] = r20;
        View r22 = this.b;
        if (r22 == null) goto L86;
        r10 = r22.findViewById(2131380720);
    L86:
        r18[3] = r10;
        com.bytedance.android.live.profile.ui.util.m.h(CollectionsKt.listOf(r18), r16);
        goto L95
    L82:
        r20 = null;
        goto L83
    L87:
        String r23 = r12.textColor;
        int r24 = com.bytedance.android.live.profile.ui.util.m.a;
        View[] r25 = new View[5];
        r25[0] = this.c;
        r25[1] = this.d;
        r25[2] = this.e;
        View r26 = this.b;
        if (r26 == null) goto L90;
        View r27 = r26.findViewById(2131373702);
    L91:
        r25[3] = r27;
        View r28 = this.b;
        if (r28 == null) goto L94;
        r10 = r28.findViewById(2131373700);
    L94:
        r25[4] = r10;
        com.bytedance.android.live.profile.ui.util.m.h(CollectionsKt.listOf(r25), r23);
        goto L95
    L90:
        r27 = null;
    L95:
        ca0.l r29 = this.q;
        if (r29 == null) goto L98;
        r29.d(r13.baseProfileInfo.getIdStr());
    L98:
        View r30 = this.b;
        if (r30 == null) goto L104;
        r30.setOnClickListener(new b(this, r0, r13));
        return;
    L104:
        return;
    L102:
        View r32 = this.b;     // Catch: Exception -> L72
        if (r32 == null) goto L32;
        Drawable r33 = r32.getBackground();     // Catch: Exception -> L72
    L34:
        if ((r33 instanceof GradientDrawable) == true) goto L36;
        r33 = null;
    L36:
        GradientDrawable r34 = (GradientDrawable) r33;     // Catch: Exception -> L72
        if (r34 == null) goto L74;
        r34.mutate();     // Catch: Exception -> L72
        List r35 = r9.gradientColor;     // Catch: Exception -> L72
        if (r35 == null) goto L50;
        r34.setGradientType(0);     // Catch: Exception -> L72
        r34.setOrientation(GradientDrawable.Orientation.BL_TR);     // Catch: Exception -> L72
        int r110 = r35.size();     // Catch: Exception -> L72
        if (r110 == 2) goto L49;
        if (r110 != 3) goto L50;
        if (Build.VERSION.SDK_INT < 29) goto L48;
        r34.setColors(new int[]{Color.parseColor((String) ListProtector.get(r35, 0)), Color.parseColor((String) ListProtector.get(r35, 1)), Color.parseColor((String) ListProtector.get(r35, 2))}, new float[]{0.0f, 0.7f, 1.0f});     // Catch: Exception -> L72
        goto L50
    L48:
        r34.setColors(new int[]{Color.parseColor((String) ListProtector.get(r35, 0)), Color.parseColor((String) ListProtector.get(r35, 1)), Color.parseColor((String) ListProtector.get(r35, 2))});     // Catch: Exception -> L72
        goto L50
    L49:
        r34.setColors(new int[]{Color.parseColor((String) ListProtector.get(r35, 0)), Color.parseColor((String) ListProtector.get(r35, 1))});     // Catch: Exception -> L72
    L50:
        String r36 = r9.borderColor;     // Catch: Exception -> L72
        if (r36 != null) goto L53;
    L56:
        boolean r37 = true;
    L57:
        if (r37 == true) goto L59;
        r34.setStroke((int) UtilityKotlinExtentionsKt.h(0.5f), Color.parseColor(r9.borderColor));     // Catch: Exception -> L72
    L59:
        py.k r38 = r9.backgroundIcon;     // Catch: Exception -> L72
        if (r38 == null) goto L68;
        HSImageView r39 = this.h;     // Catch: Exception -> L72
        if (r39 == null) goto L64;
        a1.p(r39, UtilityKotlinExtentionsKt.i(r38.getWidth()));     // Catch: Exception -> L72
    L64:
        HSImageView r40 = this.h;     // Catch: Exception -> L72
        if (r40 == null) goto L67;
        a1.k(r40, UtilityKotlinExtentionsKt.i(r38.getHeight()));     // Catch: Exception -> L72
    L67:
        ImageLoader.bindImage(this.h, r38, UtilityKotlinExtentionsKt.i(r38.getWidth()), UtilityKotlinExtentionsKt.i(r38.getHeight()));     // Catch: Exception -> L72
    L68:
        View r42 = this.b;     // Catch: Exception -> L72
        if (r42 == null) goto L74;
        r42.setBackground(r34);     // Catch: Exception -> L72
        goto L74
    L53:
        if (r36.length() == 0) goto L56;
        r37 = false;
        goto L57
    L32:
        r33 = null;
    L72:
        e = move-exception;
        ALogger.e("GiftExhibition", "ProfileGiftExhibitionComponent renderBackground error: " + e.getMessage());
        goto L74
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public void update(NewProfileUser r9) {
        Intrinsics.checkNotNullParameter(r9, "newUser");
        ALogger.i("NewUserProfile_ProfilePre", "ProfileGiftExhibitionComponent update");
        View r2 = null;
        if (com.bytedance.android.live.profile.ui.base.i.f(this.r) == true) goto L5;
    L22:
        ALogger.i("NewUserProfile_ProfilePre", "ProfileGiftExhibitionComponent update normal");
        HSImageView r0 = this.f;
        if (r0 == null) goto L25;
        a1.p(r0, -2);
    L25:
        HSImageView r1 = this.f;
        if (r1 == null) goto L28;
        a1.k(r1, -2);
    L28:
        HSImageView r3 = this.f;
        if (r3 == null) goto L31;
        com.bytedance.android.live.profile.ui.util.m.b(r3);
    L31:
        HSImageView r4 = this.g;
        if (r4 == null) goto L34;
        a1.p(r4, -2);
    L34:
        HSImageView r5 = this.g;
        if (r5 == null) goto L37;
        a1.k(r5, -2);
    L37:
        HSImageView r6 = this.g;
        if (r6 == null) goto L40;
        com.bytedance.android.live.profile.ui.util.m.b(r6);
    L40:
        HSImageView r7 = this.h;
        if (r7 == null) goto L43;
        a1.p(r7, -2);
    L43:
        HSImageView r8 = this.h;
        if (r8 == null) goto L46;
        a1.k(r8, -2);
    L46:
        HSImageView r10 = this.h;
        if (r10 == null) goto L49;
        com.bytedance.android.live.profile.ui.util.m.b(r10);
    L49:
        LinearLayout r12 = this.i;
        if (r12 == null) goto L52;
        r12.removeAllViews();
    L52:
        View r13 = this.b;
        if (r13 != null) goto L55;
    L59:
        com.bytedance.android.live.profile.ui.base.h r14 = this.r;
        Intrinsics.checkNotNullParameter(r14, "$this$useStandardHonorWallV3");
        if (r14.getTargetUser().useStandardHonorWallV3() == false) goto L72;
        TextView r15 = this.c;
        if (r15 == null) goto L64;
        r15.setTextColor(s1.h(2131107562));
    L64:
        int r16 = com.bytedance.android.live.profile.ui.util.m.a;
        View[] r17 = new View[4];
        r17[0] = this.d;
        r17[1] = this.e;
        View r18 = this.b;
        if (r18 == null) goto L67;
        View r19 = r18.findViewById(2131373702);
    L68:
        r17[2] = r19;
        View r20 = this.b;
        if (r20 == null) goto L71;
        r2 = r20.findViewById(2131380720);
    L71:
        r17[3] = r2;
        com.bytedance.android.live.profile.ui.util.m.g(CollectionsKt.listOf(r17), s1.h(2131107561));
    L83:
        j(r9);
        if (this.p == true) goto L90;
        ProfileGiftExhibitionBanner r22 = r9.getGiftExhibitionBannerData();
        if (r22 == null) goto L91;
        n(r22, Boolean.FALSE);
        return;
    L91:
        return;
    L90:
        return;
    L67:
        r19 = null;
        goto L68
    L72:
        TextView r23 = this.c;
        if (r23 == null) goto L75;
        r23.setTextColor(s1.h(2131107032));
    L75:
        int r24 = com.bytedance.android.live.profile.ui.util.m.a;
        View[] r25 = new View[3];
        r25[0] = this.d;
        r25[1] = this.e;
        View r26 = this.b;
        if (r26 == null) goto L78;
        r2 = r26.findViewById(2131373702);
    L78:
        r25[2] = r2;
        com.bytedance.android.live.profile.ui.util.m.g(CollectionsKt.listOf(r25), s1.h(2131107036));
        View r27 = this.b;
        if (r27 == null) goto L83;
        ImageView r28 = (ImageView) r27.findViewById(2131373700);
        if (r28 == null) goto L83;
        r28.clearColorFilter();
        goto L83
    L55:
        if (this.r.getTargetUser().useStandardHonorWallV3() == false) goto L57;
        int r29 = 2131249164;
    L58:
        r13.setBackgroundResource(r29);
        goto L59
    L57:
        r29 = 2131249162;
        goto L58
    L5:
        if (((ss0.c) rs0.y.a.getValue()).d() == false) goto L22;
        ALogger.i("NewUserProfile_ProfilePre", "ProfileGiftExhibitionComponent update version change");
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        com.bytedance.android.live.profile.ui.base.d r30 = this.a;
        if (r30 == null) goto L9;
        r30.removeAllViews();
    L9:
        Disposable r32 = this.k;
        if (r32 == null) goto L12;
        r32.dispose();
    L12:
        this.k = null;
        Disposable r33 = this.l;
        if (r33 == null) goto L15;
        r33.dispose();
    L15:
        this.l = null;
        Disposable r34 = this.m;
        if (r34 == null) goto L18;
        r34.dispose();
    L18:
        this.m = null;
        AnimatorSet r35 = this.n;
        if (r35 == null) goto L21;
        r35.cancel();
    L21:
        this.n = null;
        this.o = false;
        this.p = false;
        b(this.a);
        g(r9);
    }

    public final void n(final ProfileGiftExhibitionBanner r12, Boolean r13) {
        List r0 = r12.achievedGifts;
        List r1 = r0;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return;
    L11:
        if (r13 == null) goto L13;
        boolean r14 = r13.booleanValue();
    L15:
        if (r14 == false) goto L47;
        final ArrayList r15 = new ArrayList();
        final ArrayList r3 = new ArrayList();
        py.k r4 = r12.lightSweepAnimation;
        Function2<HSImageView, HSImageView, Unit> r5 = new ProfileGiftExhibitionComponent$loadAndPlayAnimIfNeedOpt$1(r15, r3);
        if (r0 == null) goto L43;
        Iterator r6 = r0.iterator();
    L21:
        if (r6.hasNext() == false) goto L43;
        py.k r7 = (py.k) r6.next();
        if (r7 == null) goto L21;
        View r8 = this.b;
        if (r8 == null) goto L28;
        Context r9 = r8.getContext();
    L29:
        View r10 = new HSImageView(r9);
        LinearLayout r16 = this.i;
        if (r16 == null) goto L32;
        LinearLayout.LayoutParams r17 = new LinearLayout.LayoutParams(UtilityKotlinExtentionsKt.i(r7.getWidth()), UtilityKotlinExtentionsKt.i(r7.getHeight()));
        r17.rightMargin = s;
        Unit r18 = Unit.INSTANCE;
        r16.addView(r10, r17);
    L32:
        ImageLoader.bindImage(r10, r7);
        if (r4 == null) goto L41;
        View r19 = this.b;
        if (r19 == null) goto L37;
        Context r20 = r19.getContext();
    L38:
        View r22 = new HSImageView(r20);
        LinearLayout r23 = this.j;
        if (r23 == null) goto L42;
        LinearLayout.LayoutParams r24 = new LinearLayout.LayoutParams(UtilityKotlinExtentionsKt.i(r4.getWidth()), UtilityKotlinExtentionsKt.i(r4.getHeight()));
        r24.rightMargin = s;
        Unit r25 = Unit.INSTANCE;
        r23.addView(r22, r24);
    L42:
        r5.invoke(r10, r22);
        goto L21
    L37:
        r20 = null;
        goto L38
    L41:
        r22 = null;
        goto L42
    L28:
        r9 = null;
    L43:
        Disposable r26 = this.k;
        if (r26 == null) goto L46;
        r26.dispose();
    L46:
        this.k = com.bytedance.android.live.profile.ui.base.i.i(this.r, EnterExitStateType.ENTER_END, new ProfileGiftExhibitionComponent$loadAndPlayAnimIfNeedOpt$2(this, r15, r3, r12));
        return;
    L47:
        if (r0 == null) goto L74;
        Iterator r110 = r0.iterator();
    L51:
        if (r110.hasNext() == false) goto L75;
        py.k r111 = (py.k) r110.next();
        if (r111 == null) goto L51;
        View r27 = this.b;
        if (r27 == null) goto L58;
        Context r28 = r27.getContext();
    L59:
        View r29 = new HSImageView(r28);
        LinearLayout r30 = this.i;
        if (r30 == null) goto L62;
        LinearLayout.LayoutParams r32 = new LinearLayout.LayoutParams(UtilityKotlinExtentionsKt.i(r111.getWidth()), UtilityKotlinExtentionsKt.i(r111.getHeight()));
        r32.rightMargin = s;
        Unit r33 = Unit.INSTANCE;
        r30.addView(r29, r32);
    L62:
        ImageLoader.bindImage(r29, r111);
        goto L51
    L58:
        r28 = null;
        goto L59
    L75:
        return;
    L74:
        return;
    L13:
        r14 = k();
        goto L15
    L5:
        if (r1.isEmpty() == true) goto L8;
        r2 = false;
        goto L9
    }

    public final void p(ProfileGiftExhibitionBanner r3, Boolean r4) {
        if (r3.achievedIcon == null) goto L18;
        if (r4 == null) goto L6;
        boolean r5 = r4.booleanValue();
    L7:
        if (r5 == false) goto L19;
        py.k r6 = r3.levelUpAnimation;
        if (r6 == null) goto L20;
        HSImageView r7 = this.g;
        if (r7 == null) goto L13;
        a1.p(r7, UtilityKotlinExtentionsKt.i(45));
    L13:
        HSImageView r8 = this.g;
        if (r8 == null) goto L16;
        a1.k(r8, UtilityKotlinExtentionsKt.i(14));
    L16:
        ImageLoader.bindImageWithAnimation(this.g, r6, null, true);
        return;
    L20:
        return;
    L19:
        return;
    L6:
        r5 = l(r3.gradeLevel);
        goto L7
    }
}
