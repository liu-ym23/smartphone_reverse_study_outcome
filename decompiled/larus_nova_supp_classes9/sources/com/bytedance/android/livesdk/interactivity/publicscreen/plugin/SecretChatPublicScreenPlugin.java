package com.bytedance.android.livesdk.interactivity.publicscreen.plugin;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.i4;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.base.model.message.v3;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.api.comment.event.OpenInputSource;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageAction;
import com.bytedance.android.livesdk.interactivity.api.entity.PublicScreenRichTextUtilsKt;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PSMessageViewHolder;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PublicScreenConfig$MessageModelType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.i;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.j;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.s;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.p;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.v;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.x;
import com.bytedance.android.livesdk.interactivity.api.utils.MessageCommonColorUtil;
import com.bytedance.android.livesdk.interactivity.publicscreen.widget.TextMessageWidget;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.r;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.w;
import com.bytedance.android.livesdk.message.model.yk;
import com.bytedance.android.livesdk.q7;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveSecretChatReplySuffixConfig;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import gm2.q;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import u22.m;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class SecretChatPublicScreenPlugin extends x implements l {
    public static final /* synthetic */ int g = 0;
    public final String b;
    public final LiveSecretChatReplySuffixConfig c;
    public final v d;
    public final DataCenter e;
    public final o f;

    public static final class a {
    }

    public static final class b extends e {
        public final s.c m;
        public final PublicScreenConfig$MessageModelType n;
        public final IPublicAreaCommon o;
        public final IBaseUser p;
        public PSMessageAction q;
        public final v r;
        public final boolean s;
        public final /* synthetic */ SecretChatPublicScreenPlugin t;
        public final /* synthetic */ tlc.d u;

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
            return this.o;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.i
        public final boolean e() {
            return this.s;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.i
        public final IBaseUser f() {
            return this.p;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.i
        public PublicScreenConfig$MessageModelType getType() {
            return this.n;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.s
        public final s.c k() {
            return this.m;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.s
        public final boolean m(View r13) {
            Intrinsics.checkNotNullParameter(r13, "view");
            SecretChatPublicScreenPlugin r14 = this.t;
            i4 r0 = this.u;
            int r1 = SecretChatPublicScreenPlugin.g;
            r14.getClass();
            String r8 = q.a(r0.getTargetUser(), Intrinsics.areEqual(r14.f.isAnchor(), Boolean.TRUE));
            long r9 = r0.getMessageId();
            m r2 = new m(r8);
            r2.l = OpenInputSource.LongPressMessage;
            r2.g = System.currentTimeMillis();
            User r3 = r0.getTargetUser();
            if (r3 == null) goto L5;
            String r4 = r3.getIdString();
        L6:
            com.bytedance.live.datacontext.m r15 = r14.f.getRoom();
            if (r15 == null) goto L11;
            IRoom r16 = (IRoom) r15.getValue();
            if (r16 == null) goto L11;
            String r17 = r16.getAnchorId();
        L12:
            boolean r18 = TextUtils.equals(r4, r17);
            User r5 = r0.getTargetUser();
            if (r5 == null) goto L15;
            String r6 = r5.getIdString();
        L16:
            User r7 = r0.getTargetUser();
            if (r7 == null) goto L19;
            String r11 = r7.getWebcastUid();
        L20:
            m.a r10 = new m.a("message", r18, r6, 2, r8, r9, r11);
            r10.j = r0.getTargetUser();
            r10.a("message_type", r0.getMessageMethod());
            r2.e = r10;
            xs2.b.a().post(r2);
            return true;
        L19:
            r11 = null;
            goto L20
        L15:
            r6 = null;
        L11:
            r17 = null;
            goto L12
        L5:
            r4 = null;
            goto L6
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.s
        public final boolean n(View r4, tb2.b r5) {
            Intrinsics.checkNotNullParameter(r4, "view");
            boolean r6 = r5 instanceof com.bytedance.android.livesdk.interactivity.textmessage.render.c;
            boolean r7 = false;
            if (r6 == false) goto L16;
            SecretChatPublicScreenPlugin r8 = this.t;
            i4 r0 = this.u;
            String r9 = r8.b;
            LinkedHashMap r1 = new LinkedHashMap();
            p.a(r1, r0);
            p.b(r0.getMessageMethod(), r9, r1);
            IBaseUser r10 = this.t.r();
            if (r10 == null) goto L8;
            String r11 = r10.getUserId();
            if (r11 == null) goto L8;
        L9:
            IBaseUser r2 = this.u.getSender();
            if (r2 != null) goto L12;
            return false;
        L12:
            r7 = true;
            if (com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.a.b(r11, String.valueOf(r2.getUserId())) == false) goto L15;
            return true;
        L15:
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.a.d(r2, OpenInputSource.ReplySecretChat, Long.valueOf(this.u.getMessageId()), 3);
        L8:
            r11 = BuildConfig.FLAVOR;
        L16:
            return r7;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.s
        public final void l(View r5, g52.d r6, g52.c r7) {
            Intrinsics.checkNotNullParameter(r5, "view");
            IBaseUser r0 = this.u.getSender();
            if (r0 == null) goto L15;
            String r1 = r0.getUserId();
            if (r1 == null) goto L15;
            SecretChatPublicScreenPlugin r2 = this.t;
            int r3 = SecretChatPublicScreenPlugin.g;
            IBaseUser r4 = r2.r();
            if (r4 == null) goto L9;
            String r8 = r4.getUserId();
        L11:
            if (r1.equals(r8) != true) goto L15;
            UserProfileEvent r9 = new UserProfileEvent(this.t.r());
            r9.setClickUserPosition("comment_area");
            xs2.b.a().post(r9);
            return;
        L9:
            r8 = null;
        L15:
            if (com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.h.c() == false) goto L33;
            SecretChatPublicScreenPlugin r10 = this.t;
            t r11 = this.u;
            if (r11 == null) goto L32;
            t r13 = (yk) r11;
            int r14 = SecretChatPublicScreenPlugin.g;
            r10.getClass();
            if (com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.h.b(r13) == false) goto L43;
            com.bytedance.android.livesdk.interactivity.api.publicscreen.api.l r15 = com.bytedance.android.livesdk.interactivity.api.q.a();
            if (r15 != null) goto L24;
            return;
        L24:
            if (r15.e(r13, r5, new g(this, r6)) == false) goto L28;
            this.i = true;
            if (r7 == null) goto L38;
            ((TextMessageWidget) r7).Aq();
            return;
        L38:
            return;
        L28:
            this.i = false;
            if (r6 == null) goto L40;
            r6.d3();
            return;
        L40:
            return;
        L43:
            return;
        L32:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.message.model.SecretChatMessage");
        L33:
            SecretChatPublicScreenPlugin r16 = this.t;
            t r17 = (i4) this.u;
            int r18 = SecretChatPublicScreenPlugin.g;
            r16.getClass();
            IInteractivityInjectService r19 = (IInteractivityInjectService) k.f(IInteractivityInjectService.class);
            if (r19 == null) goto L42;
            r19.openPSOperatePanel(r17, r5.getContext(), this, new f());
            return;
        }

        public b(SecretChatPublicScreenPlugin r2, tlc.d r3, tb2.d r4, i4 r5) {
            this.t = r2;
            this.u = r3;
            super(r5);
            boolean r0 = false;
            this.m = new s.c(r4, false, false);
            this.n = PublicScreenConfig$MessageModelType.SECRET_CHAT;
            this.o = v3.a(r3);
            IBaseUser r6 = ((i4) r3).getSender();
            this.p = r6;
            this.q = PSMessageAction.CHAT;
            this.r = r2.d;
            IBaseUser r7 = r2.r();
            if (r7 == null) goto L12;
            String r8 = r7.getUserId();
            if (r8 == null) goto L12;
            if (r6 == null) goto L8;
            String r9 = r6.getIdString();
        L10:
            if (r8.equals(r9) != true) goto L12;
            r0 = true;
            goto L12
        L8:
            r9 = null;
        L12:
            this.s = r0;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.x
    public final void q() {
        com.bytedance.live.datacontext.j r0 = this.f.getMessageManager();
        if (r0 == null) goto L6;
        r0.c(new SecretChatPublicScreenPlugin$onUnload$1(this));
        return;
    }

    public final IBaseUser r() {
        IMiddlewareUserService r0 = k.f(IMiddlewareUserService.class);
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.user.e r1 = r0.user();
        if (r1 == null) goto L7;
        return r1.b();
    L7:
        return null;
    }

    public final void onMessage(tlc.d r10) {
        if ((r10 instanceof i4) == false) goto L49;
        a5 r0 = ((i4) r10).getDisplayText();
        if (r0 != null) goto L7;
        return;
    L7:
        yb2.a r1 = w.a();
        com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.i r2 = new com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.i(0);
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.a.getClass();
        com.bytedance.android.livesdk.interactivity.service.textrender.core.x r3 = r.b;
        Intrinsics.checkNotNullParameter(r0, "text");
        tb2.d r4 = r.a(r0, r1);
        com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.g.a(r4, r2);
        int r5 = MessageCommonColorUtil.a;
        r4.b = new s.a(MessageCommonColorUtil.d(), MessageCommonColorUtil.a());
        r4.e(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(String.valueOf(8206)));
        yb2.a r6 = w.a();
        r4.a(PublicScreenRichTextUtilsKt.c(v3.a(r10), r6));
        i4 r7 = (i4) r10;
        IRoom r8 = (IRoom) this.e.get("data_room");
        if (r8 == null) goto L45;
        Boolean r9 = (Boolean) this.e.get("data_is_anchor");
        String r11 = null;
        if ((r8 instanceof Room) == true) goto L13;
        r8 = null;
    L13:
        Room r13 = (Room) r8;
        if (r13 == null) goto L18;
        Map r14 = r13.anchorAbMap;
        if (r14 == null) goto L18;
        String r15 = (String) r14.get("anchor_secret_chat_v2_ab_value");
    L19:
        IBaseUser r16 = r();
        if (r16 == null) goto L45;
        String r17 = r16.getUserId();
        if (r17 == null) goto L45;
        IBaseUser r18 = r7.getSender();
        if (r18 == null) goto L27;
        r11 = r18.getIdString();
    L27:
        if (r17.equals(r11) == true) goto L45;
        if (Intrinsics.areEqual(r9, Boolean.FALSE) == false) goto L33;
        if (this.c.getEnableAudience() == false) goto L33;
    L38:
        a5 r19 = r7.getSuffixText();
        if (r19 == null) goto L45;
        Intrinsics.checkNotNullParameter(r19, "text");
        tb2.d r20 = r.a(r19, r6);
        tb2.c r21 = (tb2.c) CollectionsKt.firstOrNull(r20.a);
        if (r21 == null) goto L44;
        r21.setClickAction(com.bytedance.android.livesdk.interactivity.textmessage.render.c.a);
    L44:
        r4.b(r20.a);
    L33:
        if (Intrinsics.areEqual(r9, Boolean.TRUE) == false) goto L45;
        if (this.c.getEnableAnchor() == true) goto L38;
        if (Intrinsics.areEqual(r15, "1") == false) goto L45;
    L18:
        r15 = null;
    L45:
        b r23 = new b(this, r10, r4, r7);
        com.bytedance.android.livesdk.interactivity.api.publicscreen.l r110 = o();
        if (r110 == null) goto L50;
        r110.insertMessage(r23);
        return;
    L50:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.x
    public final void p(com.bytedance.android.livesdk.interactivity.api.publicscreen.l r2) {
        Intrinsics.checkNotNullParameter(r2, "publicScreenContext");
        com.bytedance.live.datacontext.j r3 = this.f.getMessageManager();
        if (r3 == null) goto L5;
        r3.c(new SecretChatPublicScreenPlugin$onLoad$1(this));
    L5:
        this.d.getClass();
        n(v.a, this.d);
    }

    public SecretChatPublicScreenPlugin(DataCenter r2, o r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "roomContext");
        this.e = r2;
        this.f = r3;
        this.b = "reply";
        this.c = (LiveSecretChatReplySuffixConfig) q7.a.getValue();
        this.d = v.b;
    }
}
