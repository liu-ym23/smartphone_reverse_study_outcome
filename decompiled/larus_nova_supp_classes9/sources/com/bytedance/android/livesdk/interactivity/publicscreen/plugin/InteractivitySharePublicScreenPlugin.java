package com.bytedance.android.livesdk.interactivity.publicscreen.plugin;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.live.base.model.data.m;
import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.base.model.message.i5;
import com.bytedance.android.live.base.model.message.m1;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.api.comment.event.OpenInputSource;
import com.bytedance.android.livesdk.interactivity.api.entity.DisplayTimeRecorder;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageAction;
import com.bytedance.android.livesdk.interactivity.api.entity.PublicScreenRichTextUtilsKt;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PSMessageViewHolder;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PublicScreenConfig$MessageModelType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.i;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.j;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.s;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.p;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.v;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.x;
import com.bytedance.android.livesdk.interactivity.api.utils.MessageCommonColorUtil;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.r;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.w;
import com.bytedance.android.livesdk.o4;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdk.w7;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import gm2.q;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import py.t;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class InteractivitySharePublicScreenPlugin extends x implements l {
    public static final /* synthetic */ int e = 0;
    public final com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel.h b;
    public final DataCenter c;
    public final o d;

    public static final class a {
    }

    public static final class b extends com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel.g {
        public final PublicScreenConfig$MessageModelType m;
        public final IPublicAreaCommon n;
        public final s.c o;
        public final boolean p;
        public PSMessageAction q;
        public final com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel.h r;
        public final /* synthetic */ InteractivitySharePublicScreenPlugin s;
        public final /* synthetic */ Ref.ObjectRef t;
        public final /* synthetic */ tlc.d u;

        public static final class a implements DisplayTimeRecorder.a {
            public final /* synthetic */ b a;

            @Override // com.bytedance.android.livesdk.interactivity.api.entity.DisplayTimeRecorder.a
            public final void b(DisplayTimeRecorder.b r2) {
                Intrinsics.checkNotNullParameter(r2, "record");
            }

            public a(b r1) {
                this.a = r1;
            }

            @Override // com.bytedance.android.livesdk.interactivity.api.entity.DisplayTimeRecorder.a
            public final void a(int r8) {
                if (r8 != 1) goto L71;
                b r9 = this.a;
                final m1 r1 = r9.u;
                o r10 = r9.s.d;
                int r2 = c.a;
                Intrinsics.checkNotNullParameter(r1, "message");
                Intrinsics.checkNotNullParameter(r10, "roomContext");
                com.bytedance.android.livesdk.interactivity.common.utils.b.a("livesdk_room_share_card_show", new PublicScreenInteractivityShareAppLogger$sendShareCardShow$1(r1));
                Intrinsics.checkNotNullParameter(r1, "message");
                Intrinsics.checkNotNullParameter(r10, "roomContext");
                m r3 = r1.getItemStyle();
                String r4 = null;
                if (r3 == null) goto L7;
                String r5 = r3.itemType;
            L9:
                if (Intrinsics.areEqual(r5, "song_sheet") == false) goto L54;
                a5 r6 = r1.getShareText();
                if (r6 == null) goto L31;
                List r7 = r6.getPieces();
                if (r7 == null) goto L31;
                Iterator r11 = r7.iterator();
            L16:
                if (r11.hasNext() == false) goto L23;
                Object r13 = r11.next();
                if (((c5) r13).getType() != PieceType.USER.getPieceType()) goto L20;
                boolean r14 = true;
            L21:
                if (r14 == false) goto L16;
            L24:
                c5 r15 = (c5) r13;
                if (r15 == null) goto L31;
                i5 r0 = r15.getUserValue();
                if (r0 == null) goto L31;
                IBaseUser r16 = r0.getUser();
                if (r16 == null) goto L31;
                String r17 = r16.getIdString();
            L32:
                if (r17 == null) goto L54;
                com.bytedance.live.datacontext.m r18 = r10.getRoom();
                if (r18 == null) goto L36;
                IRoom r19 = (IRoom) r18.getValue();
            L37:
                IInteractivityInjectService r20 = (IInteractivityInjectService) k.n(IInteractivityInjectService.class);
                IMiddlewareUserService r21 = k.f(IMiddlewareUserService.class);
                if (r21 == null) goto L42;
                com.bytedance.android.livesdk.user.e r23 = r21.user();
                if (r23 == null) goto L42;
                String r24 = r23.n();
            L44:
                if (Intrinsics.areEqual(r24, r17) == false) goto L46;
                String r25 = "oneself";
            L47:
                if (r19 == null) goto L52;
                Intrinsics.checkNotNullParameter(r19, "$this$liveTypeStr");
                if (r19.isLiveTypeAudio() == false) goto L51;
                String r26 = "voice_live";
            L53:
                r20.logHighScoreSongLabelShow("message", r17, r25, r26);
                goto L54
            L51:
                r26 = "video_live";
                goto L53
            L52:
                r26 = BuildConfig.FLAVOR;
                goto L53
            L46:
                r25 = "others";
            L42:
                r24 = null;
                goto L44
            L36:
                r19 = null;
                goto L37
            L20:
                r14 = false;
                goto L21
            L23:
                r13 = null;
            L31:
                r17 = null;
            L54:
                m r27 = this.a.u.getItemStyle();
                if (r27 == null) goto L72;
                String r28 = r27.schema;
                if (r28 != null) goto L59;
                return;
            L59:
                if (this.a.s.s(r28) == false) goto L61;
                r4 = r28;
            L61:
                if (r4 == null) goto L74;
                IInteractivityInjectService r29 = (IInteractivityInjectService) k.f(IInteractivityInjectService.class);
                if (r29 == null) goto L75;
                r29.preloadMiniAPPForInteractivityShare(r4);
                return;
            L75:
                return;
            L74:
                return;
            L72:
                return;
            L7:
                r5 = null;
                goto L9
            }
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.i
        public final DisplayTimeRecorder j() {
            return new DisplayTimeRecorder(this.u, new a(this));
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.i
        public final PSMessageAction a() {
            return this.q;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.s, com.bytedance.android.livesdk.interactivity.api.publicscreen.i
        public final j<? extends i, ? extends PSMessageViewHolder> b() {
            return this.r;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.i
        public final IPublicAreaCommon c() {
            return this.n;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.i
        public PublicScreenConfig$MessageModelType getType() {
            return this.m;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.i
        public final boolean h() {
            return this.p;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.s
        public final s.c k() {
            return this.o;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.s
        public final boolean m(View r14) {
            Intrinsics.checkNotNullParameter(r14, "view");
            if (this.u.isFromOtherIntercomRoom() == false) goto L5;
            return false;
        L5:
            com.bytedance.live.datacontext.m r15 = this.s.d.getRoom();
            if (r15 == null) goto L11;
            IRoom r16 = (IRoom) r15.getValue();
            if (r16 == null) goto L11;
            Object r17 = r16.getAnchorId();
            if (r17 == null) goto L11;
        L12:
            IBaseUser r1 = this.u.getChatUserInfo();
            String r3 = null;
            if (r1 == null) goto L28;
            String r2 = r1.getIdString();
            if (r2 == null) goto L28;
            if (r2.length() <= 0) goto L19;
            boolean r4 = true;
        L20:
            if (r4 != true) goto L28;
            IBaseUser r5 = this.u.getChatUserInfo();
            if (r5 == null) goto L24;
            String r6 = r5.getIdString();
        L26:
            if (Intrinsics.areEqual(r6, r17.toString()) == false) goto L28;
            boolean r7 = true;
        L29:
            String r9 = q.a(this.u.getChatUserInfo(), r7);
            u22.m r18 = new u22.m(r9);
            r18.l = OpenInputSource.LongPressMessage;
            IBaseUser r8 = this.u.getChatUserInfo();
            if (r8 == null) goto L33;
            String r10 = r8.getIdString();
            if (r10 == null) goto L33;
        L34:
            String r11 = r10;
            long r13 = this.u.getMessageId();
            IBaseUser r19 = this.u.getChatUserInfo();
            if (r19 == null) goto L37;
            r3 = r19.getWebcastUid();
        L37:
            u22.m.a r0 = new u22.m.a("message", r7, r11, 2, r9, r13, r3);
            r0.k = this.u.isFromOtherIntercomRoom();
            r0.j = this.u.getChatUserInfo();
            r0.a("is_reply_user_show", "0");
            r0.a("message_type", this.u.getMessageMethod());
            r18.e = r0;
            xs2.b.a().post(r18);
            return true;
        L33:
            r10 = BuildConfig.FLAVOR;
            goto L34
        L24:
            r6 = null;
            goto L26
        L19:
            r4 = false;
        L28:
            r7 = false;
        L11:
            r17 = 0L;
            goto L12
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.s
        public final boolean n(View r3, tb2.b r4) {
            Intrinsics.checkNotNullParameter(r3, "view");
            if ((r4 instanceof com.bytedance.android.livesdk.interactivity.publicscreen.plugin.a) == false) goto L8;
            IBaseUser r5 = (IBaseUser) this.t.element;
            if (r5 == null) goto L8;
            UserProfileEvent r6 = new UserProfileEvent(r5);
            r6.setExtraFollowParams(com.bytedance.android.livesdk.user.j.b(LiveFollowScene.PROFILE_PUBLIC_SCREEN));
            r6.setReportType("data_card_incomeinfo");
            InteractivitySharePublicScreenPlugin r7 = this.s;
            m1 r0 = this.u;
            int r1 = InteractivitySharePublicScreenPlugin.e;
            r7.getClass();
            InteractivitySharePublicScreenPlugin.t(r0, "text_user");
            xs2.b.a().post(r6);
            return true;
        L8:
            Intrinsics.checkNotNullParameter(r3, "view");
            return false;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.s
        public final void l(View r1, g52.d r2, g52.c r3) {
            Intrinsics.checkNotNullParameter(r1, "view");
            InteractivitySharePublicScreenPlugin.r(this.s, this.u, r1.getContext());
        }

        public b(InteractivitySharePublicScreenPlugin r1, Ref.ObjectRef r2, tlc.d r3, tb2.d r4, Ref.BooleanRef r5, m1 r6) {
            this.s = r1;
            this.t = r2;
            this.u = r3;
            super(r6);
            this.m = PublicScreenConfig$MessageModelType.INTERACTIVITY_SHARE;
            m1 r7 = (m1) r3;
            this.n = r7.getPublicAreaCommon();
            this.o = new s.c(r4, false, r5.element);
            this.p = r7.isInsert();
            if (r7.isInsert() == false) goto L5;
            PSMessageAction r8 = PSMessageAction.SYSTEM;
        L6:
            this.q = r8;
            this.r = r1.b;
            return;
        L5:
            r8 = PSMessageAction.CHAT;
            goto L6
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.x
    public final void q() {
    }

    public final void onMessage(tlc.d r10) {
        if ((r10 instanceof m1) == false) goto L36;
        Ref.ObjectRef r3 = new Ref.ObjectRef();
        r3.element = null;
        m1 r7 = (m1) r10;
        a5 r1 = r7.getShareText();
        if (r1 != null) goto L7;
        return;
    L7:
        Ref.BooleanRef r6 = new Ref.BooleanRef();
        r6.element = false;
        yb2.a r4 = w.a();
        com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.i r5 = new com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.i(0);
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.a.getClass();
        com.bytedance.android.livesdk.interactivity.service.textrender.core.x r2 = r.b;
        Intrinsics.checkNotNullParameter(r1, "text");
        tb2.d r8 = r.a(r1, r4);
        com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.g.a(r8, r5);
        r6.element = r5.a;
        Iterator<tb2.c> r9 = r8.a.iterator();
    L9:
        if (r9.hasNext() == false) goto L22;
        tb2.c r11 = r9.next();
        if (r11.getType() != PieceType.USER.getPieceType()) goto L9;
        i5 r13 = r11.getUserValue();
        if (r13 == null) goto L15;
        IBaseUser r14 = r13.getUser();
    L16:
        r3.element = r14;
        r11.setClickAction(com.bytedance.android.livesdk.interactivity.publicscreen.plugin.a.a);
        List<tb2.c> r15 = r11.getBindUserBadgePieceList();
        if (r15 == null) goto L9;
        Iterator<T> r16 = r15.iterator();
    L20:
        if (r16.hasNext() == false) goto L9;
        ((tb2.c) r16.next()).setClickAction(com.bytedance.android.livesdk.interactivity.publicscreen.plugin.a.a);
        goto L20
    L15:
        r14 = null;
        goto L16
    L22:
        int r17 = MessageCommonColorUtil.a;
        r8.b = new s.a(MessageCommonColorUtil.d(), MessageCommonColorUtil.a());
        r8.e(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(String.valueOf(8206)));
        if (((Boolean) w7.a.getValue()).booleanValue() == false) goto L25;
        r8.a(PublicScreenRichTextUtilsKt.c(r7.getPublicAreaCommon(), w.a()));
    L25:
        b r0 = new b(this, r3, r10, r8, r6, r7);
        com.bytedance.android.livesdk.interactivity.api.publicscreen.l r18 = o();
        if (r18 == null) goto L37;
        r18.insertMessage(r0);
        return;
    L37:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.x
    public final void p(com.bytedance.android.livesdk.interactivity.api.publicscreen.l r2) {
        Intrinsics.checkNotNullParameter(r2, "publicScreenContext");
        com.bytedance.live.datacontext.j r3 = this.d.getMessageManager();
        if (r3 == null) goto L5;
        r3.c(new InteractivitySharePublicScreenPlugin$onLoad$1(this));
    L5:
        com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel.h r4 = this.b;
        n(r4.a, r4);
    }

    public final boolean s(String r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        String r1 = null;
        Uri r6 = UriProtector.parse(r5);     // Catch: Throwable -> L8
    L9:
        if (r6 == null) goto L11;
        String r2 = r6.getHost();
    L13:
        if (Intrinsics.areEqual(r2, "microapp") == true) goto L18;
        if (r6 == null) goto L17;
        r1 = r6.getHost();
    L17:
        if (Intrinsics.areEqual(r1, "microgame") == true) goto L18;
        return false;
    L18:
        return true;
    L11:
        r2 = null;
    L8:
        r6 = null;
        goto L9
    }

    public InteractivitySharePublicScreenPlugin(DataCenter r2, o r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "roomContext");
        this.c = r2;
        this.d = r3;
        this.b = new com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel.h(new InteractivitySharePublicScreenPlugin$binder$1(this));
    }

    public static void t(m1 r3, String r4) {
        Pair[] r0 = new Pair[1];
        m r1 = r3.getItemStyle();
        if (r1 == null) goto L5;
        String r2 = r1.itemType;
    L6:
        r0[0] = TuplesKt.to("item_type", r2);
        Map r5 = MapsKt.mutableMapOf(r0);
        p.a(r5, r3);
        p.b(r3.getMessageMethod(), r4, r5);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public static final void r(InteractivitySharePublicScreenPlugin r16, m1 r17, Context r18) {
        r16.getClass();
        IPublicAreaCommon r2 = r17.getPublicAreaCommon();
        if (r2 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == false) goto L10;
        t(r17, "default");
        return;
    L10:
        m r4 = r17.getItemStyle();
        if (r4 == null) goto L146;
        String r5 = r4.schema;
        if (r5 != null) goto L16;
    L19:
        boolean r6 = true;
    L20:
        if (r6 == true) goto L143;
        DataCenter r7 = r16.c;
        a5 r8 = r17.getShareText();
        IRoom r9 = null;
        if (r8 == null) goto L40;
        List r10 = r8.getPieces();
        if (r10 == null) goto L40;
        Iterator r11 = r10.iterator();
    L27:
        if (r11.hasNext() == false) goto L34;
        Object r13 = r11.next();
        if (((c5) r13).getType() != PieceType.USER.getPieceType()) goto L31;
        boolean r14 = true;
    L32:
        if (r14 == false) goto L27;
    L35:
        c5 r15 = (c5) r13;
        if (r15 == null) goto L40;
        i5 r19 = r15.getUserValue();
        if (r19 == null) goto L40;
        IBaseUser r20 = r19.getUser();
    L41:
        int r21 = v.a;
        if (r20 == null) goto L126;
        String r23 = r20.getIdString();
        if (r23 == null) goto L126;
        if (r23.length() != 0) goto L50;
        boolean r24 = true;
    L51:
        if (r24 == true) goto L126;
        if (Intrinsics.areEqual("0", r23) == true) goto L126;
        IRoomContextService r25 = k.f(IRoomContextService.class);
        if (r25 == null) goto L126;
        o r26 = IRoomContextService.a.a(r25, null, 0, 3);
        if (r26 == null) goto L126;
        if (r7 == null) goto L62;
        IBaseUser r27 = (IBaseUser) r7.get("data_user_in_room", null);
    L63:
        if (r27 == null) goto L67;
        t r28 = r27.getUserAttrExt();
        if (r28 == null) goto L67;
        boolean r29 = r28.isAdmin();
    L69:
        if (k.n(IMiddlewareUserService.class).user().isLogin() == false) goto L71;
        boolean r110 = Intrinsics.areEqual(k.n(IMiddlewareUserService.class).user().n(), r23);
    L72:
        com.bytedance.live.datacontext.m r111 = r26.getRoom();
        if (r111 == null) goto L75;
        IRoom r112 = (IRoom) r111.getValue();
    L76:
        if (r112 != null) goto L78;
    L94:
        boolean r30 = false;
    L95:
        if (r112 == null) goto L97;
        boolean r31 = r112.isGuestAnchor(r23);
    L98:
        Boolean r33 = r26.isAnchor();
        if (r33 == null) goto L101;
        boolean r34 = r33.booleanValue();
    L102:
        if (r34 == true) goto L125;
        IRoomContextService r35 = k.f(IRoomContextService.class);
        if (r35 == null) goto L112;
        o r36 = IRoomContextService.a.a(r35, null, 0, 3);
        if (r36 == null) goto L112;
        com.bytedance.live.datacontext.m r37 = r36.getRoom();
        if (r37 == null) goto L112;
        r9 = (IRoom) r37.getValue();
    L112:
        if (((Boolean) o4.a.getValue()).booleanValue() == false) goto L123;
        if (r9 == null) goto L123;
        if (r9.getRoomAuthStatus() == null) goto L123;
        if (r9.getRoomAuthStatus().getEnableUserCard() == true) goto L123;
        if (r29 == true) goto L123;
        if (r110 == true) goto L123;
        if (r30 == true) goto L123;
        if (r31 == true) goto L123;
        boolean r38 = true;
    L124:
        if (r38 == true) goto L126;
    L123:
        r38 = false;
    L125:
        boolean r39 = true;
    L127:
        if (r39 == false) goto L135;
        String r40 = r4.schema;
        if (r16.s(r40) == false) goto L134;
        IInteractivityInjectService r0 = (IInteractivityInjectService) k.f(IInteractivityInjectService.class);
        if (r0 == null) goto L133;
        r0.openMiniAppFromPublicScreen(r40);
    L133:
        t(r17, "business");
        return;
    L134:
        k.n(IBaseLiveActionHandler.class).handle(r18, r4.schema);
        t(r17, "schema");
        return;
    L135:
        f2.b(2131914664, 0);
        return;
    L101:
        r34 = false;
        goto L102
    L97:
        r31 = false;
        goto L98
    L78:
        if (Intrinsics.areEqual(r112.getOwnerUserIdString(), r23) == true) goto L93;
        IBaseUser r113 = r112.getOwner();
        if (r113 == null) goto L82;
        String r114 = r113.getWebcastUid();
    L84:
        if (Intrinsics.areEqual(r114, r20.getWebcastUid()) == false) goto L94;
        String r41 = r20.getWebcastUid();
        if (r41 != null) goto L88;
    L91:
        boolean r43 = true;
    L92:
        if (r43 == true) goto L94;
    L88:
        if (r41.length() == 0) goto L91;
        r43 = false;
        goto L92
    L82:
        r114 = null;
    L93:
        r30 = true;
        goto L95
    L75:
        r112 = null;
        goto L76
    L71:
        r110 = false;
    L67:
        r29 = false;
        goto L69
    L62:
        r27 = null;
        goto L63
    L50:
        r24 = false;
    L126:
        r39 = false;
        goto L127
    L31:
        r14 = false;
        goto L32
    L34:
        r13 = null;
    L40:
        r20 = null;
        goto L41
    L143:
        return;
    L16:
        if (r5.length() == 0) goto L19;
        r6 = false;
        goto L20
    L146:
        return;
    L5:
        if (r2.getSupportPin() != 1) goto L7;
        r3 = true;
        goto L8
    }
}
