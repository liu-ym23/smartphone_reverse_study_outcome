package com.bytedance.android.livesdk.interactivity.publicscreen.plugin;

import am2.n;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.m6;
import com.bytedance.android.live.base.model.message.v3;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.config.f5;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageAction;
import com.bytedance.android.livesdk.interactivity.api.entity.PublicScreenRichTextUtilsKt;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityMonitor;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PSMessageViewHolder;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PublicScreenConfig$MessageModelType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.i;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.j;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.s;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.p;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.x;
import com.bytedance.android.livesdk.interactivity.api.q;
import com.bytedance.android.livesdk.interactivity.api.utils.MessageCommonColorUtil;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.r;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.w;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.LinkedHashMap;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class AIAutoReplyPublicScreenPlugin extends x implements l {
    public static final /* synthetic */ int e = 0;
    public final com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel.a b;
    public final DataCenter c;
    public final o d;

    public static final class a {
    }

    public static final class b extends com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel.b {
        public final s.c m;
        public final PublicScreenConfig$MessageModelType n;
        public final IPublicAreaCommon o;
        public final IBaseUser p;
        public PSMessageAction q;
        public final com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel.a r;
        public final boolean s;
        public final /* synthetic */ AIAutoReplyPublicScreenPlugin t;
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
        public final boolean m(View r5) {
            Intrinsics.checkNotNullParameter(r5, "view");
            MiddlewareRoomContext r6 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, this.t.c, 0, 2);
            if (r6 == null) goto L9;
            com.bytedance.live.datacontext.i r7 = r6.isAnchor();
            if (r7 == null) goto L9;
            if (((Boolean) r7.getValue()).booleanValue() != true) goto L9;
            return true;
        L9:
            AIAutoReplyPublicScreenPlugin.r(this.t, this.u.getSchema());
            int r8 = k22.a.a;
            k22.a.a(this.u.getTag(), "long_click", "other");
            return true;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.s
        public final boolean n(View r13, tb2.b r14) {
            Intrinsics.checkNotNullParameter(r13, "view");
            boolean r1 = false;
            if ((r14 instanceof tb2.e) == false) goto L87;
            tb2.e r15 = (tb2.e) r14;
            m6 r0 = r15.a();
            AIAutoReplyPublicScreenPlugin r2 = this.t;
            String r3 = r0.a;
            int r4 = AIAutoReplyPublicScreenPlugin.e;
            r2.getClass();
            if (Intrinsics.areEqual("ai_reply_goods_link", r3) == true) goto L7;
        L81:
            AIAutoReplyPublicScreenPlugin r16 = this.t;
            String r5 = r0.a;
            r16.getClass();
            if (Intrinsics.areEqual("ai_reply_pic", r5) == false) goto L84;
            int r17 = k22.a.a;
            k22.a.a(this.u.getTag(), "click", "pic");
        L85:
            tb2.f.a(r15);
        L86:
            return true;
        L84:
            int r18 = k22.a.a;
            k22.a.a(this.u.getTag(), "click", "other");
            goto L85
        L7:
            if (r0.a() == null) goto L81;
            IBaseLiveActionHandler r19 = k.f(IBaseLiveActionHandler.class);
            if (r19 == null) goto L80;
            Context r110 = r13.getContext();
            AIAutoReplyPublicScreenPlugin r6 = this.t;
            String r7 = r0.a();
            r6.getClass();
            String r8 = BuildConfig.FLAVOR;
            if (r7 == null) goto L79;
            HashMap r9 = new HashMap();
            com.bytedance.android.livesdk.log.filter.o r10 = j0.l().c(Room.class);
            com.bytedance.android.livesdk.log.filter.o r11 = j0.l().c(am2.x.class);
            if (r10 != null) goto L16;
        L27:
            if (r11 != null) goto L29;
        L52:
            m r20 = r6.d.getRoom();
            if (r20 == null) goto L71;
            IRoom r21 = (IRoom) r20.getValue();
            if (r21 == null) goto L71;
            String r23 = r21.getRequestId();
            if (r23 == null) goto L71;
            if (r23.length() <= 0) goto L61;
            r1 = true;
        L61:
            if (r1 != true) goto L71;
            m r24 = r6.d.getRoom();
            if (r24 == null) goto L70;
            IRoom r25 = (IRoom) r24.getValue();
            if (r25 == null) goto L70;
            String r26 = r25.getRequestId();
            if (r26 == null) goto L70;
            r8 = r26;
        L70:
            r9.put("request_id", r8);
        L71:
            String r27 = n.f().c();
            if (r27 == null) goto L74;
            r9.put("cid", r27);
        L74:
            Uri.Builder r28 = UriProtector.parse(r7).buildUpon();
            IMiddlewareHostAction r29 = k.f(IMiddlewareHostAction.class);
            if (r29 == null) goto L77;
            String r30 = r29.generateSession(r9);
        L78:
            r8 = r28.appendQueryParameter("trace_session_id", r30).build().toString();
            goto L79
        L77:
            r30 = null;
            goto L78
        L29:
            if (r11.getMap().containsKey("enter_from_merge") == false) goto L35;
            String r31 = (String) r11.getMap().get("enter_from_merge");
            if (r31 != null) goto L33;
            r31 = BuildConfig.FLAVOR;
        L33:
            r9.put("enter_from_merge", r31);
        L35:
            if (r11.getMap().containsKey("enter_method") == false) goto L41;
            String r33 = (String) r11.getMap().get("enter_method");
            if (r33 != null) goto L39;
            r33 = BuildConfig.FLAVOR;
        L39:
            r9.put("enter_method", r33);
        L41:
            if (r11.getMap().containsKey("action_type") == false) goto L47;
            String r34 = (String) r11.getMap().get("action_type");
            if (r34 != null) goto L45;
            r34 = BuildConfig.FLAVOR;
        L45:
            r9.put("action_type", r34);
        L47:
            if (r11.getMap().containsKey("video_id") == false) goto L52;
            String r35 = (String) r11.getMap().get("video_id");
            if (r35 != null) goto L51;
            r35 = BuildConfig.FLAVOR;
        L51:
            r9.put("video_id", r35);
            goto L52
        L16:
            if (r10.getMap().containsKey("room_id") == false) goto L22;
            String r36 = (String) r10.getMap().get("room_id");
            if (r36 != null) goto L20;
            r36 = BuildConfig.FLAVOR;
        L20:
            r9.put("room_id", r36);
        L22:
            if (r10.getMap().containsKey("anchor_id") == false) goto L27;
            String r37 = (String) r10.getMap().get("anchor_id");
            if (r37 != null) goto L26;
            r37 = BuildConfig.FLAVOR;
        L26:
            r9.put("anchor_id", r37);
        L79:
            r19.handle(r110, r8);
        L80:
            int r111 = k22.a.a;
            k22.a.a(this.u.getTag(), "click", "card");
            goto L86
        L87:
            return false;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.s
        public final void l(View r3, g52.d r4, g52.c r5) {
            Intrinsics.checkNotNullParameter(r3, "view");
            MiddlewareRoomContext r6 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, this.t.c, 0, 2);
            if (r6 == null) goto L9;
            com.bytedance.live.datacontext.i r7 = r6.isAnchor();
            if (r7 == null) goto L9;
            if (((Boolean) r7.getValue()).booleanValue() != true) goto L9;
            return;
        L9:
            AIAutoReplyPublicScreenPlugin.r(this.t, this.u.getSchema());
            LinkedHashMap r8 = new LinkedHashMap();
            p.a(r8, this.u);
            p.b(this.u.getMessageMethod(), "business", r8);
            int r9 = k22.a.a;
            k22.a.a(this.u.getTag(), "click", "other");
        }

        public b(AIAutoReplyPublicScreenPlugin r2, tlc.d r3, tb2.d r4, com.bytedance.android.live.base.model.message.j r5) {
            this.t = r2;
            this.u = r3;
            super(r5);
            this.m = new s.c(r4, false, false);
            this.n = PublicScreenConfig$MessageModelType.AI_AUTO_REPLY;
            this.o = v3.a(r3);
            this.p = ((com.bytedance.android.live.base.model.message.j) r3).getUserInMessage();
            this.q = PSMessageAction.CHAT;
            this.r = r2.b;
            this.s = ((Boolean) f5.a.getValue()).booleanValue();
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.x
    public final void q() {
    }

    public final void onMessage(tlc.d r5) {
        if ((r5 instanceof com.bytedance.android.live.base.model.message.j) == false) goto L15;
        InteractivityMonitor.Event r0 = InteractivityMonitor.Event.AIAutoReplyMessageReceive;
        m r1 = this.d.getRoom();
        if (r1 == null) goto L7;
        IRoom r2 = (IRoom) r1.getValue();
    L8:
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.b.b(r0, r2);
        a5 r3 = ((com.bytedance.android.live.base.model.message.j) r5).getDisplayText();
        if (r3 != null) goto L11;
        return;
    L11:
        yb2.a r4 = w.a();
        com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.i r6 = new com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.i(0);
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.a.getClass();
        com.bytedance.android.livesdk.interactivity.service.textrender.core.x r7 = r.b;
        Intrinsics.checkNotNullParameter(r3, "text");
        tb2.d r8 = r.a(r3, r4);
        com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.g.a(r8, r6);
        int r9 = MessageCommonColorUtil.a;
        r8.b = new s.a(MessageCommonColorUtil.d(), MessageCommonColorUtil.a());
        r8.e(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(String.valueOf(8206)));
        yb2.a r10 = w.a();
        r8.a(PublicScreenRichTextUtilsKt.c(v3.a(r5), r10));
        b r11 = new b(this, r5, r8, (com.bytedance.android.live.base.model.message.j) r5);
        com.bytedance.android.livesdk.interactivity.api.publicscreen.l r13 = o();
        if (r13 == null) goto L16;
        r13.insertMessage(r11);
        return;
    L16:
        return;
    L7:
        r2 = null;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.x
    public final void p(com.bytedance.android.livesdk.interactivity.api.publicscreen.l r2) {
        Intrinsics.checkNotNullParameter(r2, "publicScreenContext");
        com.bytedance.live.datacontext.j r3 = this.d.getMessageManager();
        if (r3 == null) goto L5;
        r3.c(new AIAutoReplyPublicScreenPlugin$onLoad$1(this));
    L5:
        com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel.a r4 = this.b;
        n(r4.a, r4);
    }

    public AIAutoReplyPublicScreenPlugin(DataCenter r2, o r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "roomContext");
        this.c = r2;
        this.d = r3;
        this.b = new com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel.a();
    }

    public static final void r(AIAutoReplyPublicScreenPlugin r1, String r2) {
        r1.getClass();
        com.bytedance.android.livesdk.interactivity.api.h r3 = q.g();
        if (r3 == null) goto L10;
        com.bytedance.live.datacontext.j<k22.b> r4 = r3.getAiCloneManager();
        if (r4 == null) goto L11;
        k22.b r5 = (k22.b) r4.getValue();
        if (r5 == null) goto L12;
        r5.b(r2, "live_screen_message");
        return;
    L12:
        return;
    L11:
        return;
    }
}
