package com.bytedance.android.livesdk.interactivity.publicscreen.plugin;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageAction;
import com.bytedance.android.livesdk.interactivity.api.entity.PublicScreenRichTextUtilsKt;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PSMessageViewHolder;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PublicScreenConfig$MessageModelType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.i;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.j;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.s;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.x;
import com.bytedance.android.livesdk.interactivity.api.utils.MessageCommonColorUtil;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.r;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.w;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.f3;
import com.bytedance.android.livesdk.message.model.z6;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Map;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class CombinedTextMessagePlugin extends x implements l {
    public static final /* synthetic */ int e = 0;
    public final com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel.d b;
    public final DataCenter c;
    public final o d;

    public static final class a {
    }

    public static final class b extends com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel.c {
        public final s.c m;
        public final PublicScreenConfig$MessageModelType n;
        public final IPublicAreaCommon o;
        public final IBaseUser p;
        public PSMessageAction q;
        public final com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel.d r;
        public final boolean s;
        public final tb2.d t;
        public boolean u;
        public final /* synthetic */ CombinedTextMessagePlugin v;
        public final /* synthetic */ tlc.d w;

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.s
        public final boolean m(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            return true;
        }

        @Override // com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel.c
        public final void q() {
            this.u = true;
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

        @Override // com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel.c
        public final boolean o() {
            return this.u;
        }

        @Override // com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel.c
        public final tb2.d p() {
            return this.t;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.s
        public final boolean n(View r11, tb2.b r13) {
            Intrinsics.checkNotNullParameter(r11, "view");
            boolean r1 = false;
            if ((r13 instanceof tb2.e) == false) goto L75;
            tb2.e r14 = (tb2.e) r13;
            String r0 = r14.a().a();
            if (r0 == null) goto L72;
            IBaseLiveActionHandler r3 = k.f(IBaseLiveActionHandler.class);
            if (r3 == null) goto L72;
            Context r15 = r11.getContext();
            CombinedTextMessagePlugin r4 = this.v;
            String r16 = r14.a().a;
            int r5 = CombinedTextMessagePlugin.e;
            r4.getClass();
            if (r16 != null) goto L11;
        L71:
            r3.handle(r15, r0);
            goto L72
        L11:
            if (StringsKt.startsWith$default(r16, "local_life", false, 2, null) != true) goto L71;
            HashMap r17 = new HashMap();
            com.bytedance.android.livesdk.log.filter.o r6 = j0.l().c(am2.x.class);
            com.bytedance.android.livesdk.log.filter.o r7 = j0.l().c(Room.class);
            String r8 = BuildConfig.FLAVOR;
            if (r7 != null) goto L16;
        L27:
            if (r6 != null) goto L29;
        L46:
            m r9 = r4.d.getRoom();
            if (r9 == null) goto L64;
            IRoom r10 = (IRoom) r9.getValue();
            if (r10 == null) goto L64;
            String r18 = r10.getRequestId();
            if (r18 == null) goto L64;
            if (r18.length() <= 0) goto L55;
            r1 = true;
        L55:
            if (r1 != true) goto L64;
            m r2 = r4.d.getRoom();
            if (r2 == null) goto L62;
            IRoom r19 = (IRoom) r2.getValue();
            if (r19 == null) goto L62;
            String r20 = r19.getRequestId();
            if (r20 == null) goto L62;
        L63:
            r17.put("request_id", r20);
        L62:
            r20 = BuildConfig.FLAVOR;
        L64:
            Uri.Builder r21 = UriProtector.parse(r0).buildUpon();
            IMiddlewareHostAction r23 = k.f(IMiddlewareHostAction.class);
            if (r23 == null) goto L70;
            String r110 = r23.generateSession(r17);
            if (r110 == null) goto L70;
            r8 = r110;
        L70:
            r0 = r21.appendQueryParameter("trace_session_id", r8).build().toString();
            goto L71
        L29:
            if (r6.getMap().containsKey("enter_from_merge") == false) goto L35;
            String r24 = (String) r6.getMap().get("enter_from_merge");
            if (r24 != null) goto L33;
            r24 = BuildConfig.FLAVOR;
        L33:
            r17.put("enter_from_merge", r24);
        L35:
            if (r6.getMap().containsKey("enter_method") == false) goto L41;
            String r25 = (String) r6.getMap().get("enter_method");
            if (r25 != null) goto L39;
            r25 = BuildConfig.FLAVOR;
        L39:
            r17.put("enter_method", r25);
        L41:
            if (r6.getMap().containsKey("action_type") == false) goto L46;
            String r26 = (String) r6.getMap().get("action_type");
            if (r26 != null) goto L45;
            r26 = BuildConfig.FLAVOR;
        L45:
            r17.put("action_type", r26);
            goto L46
        L16:
            if (r7.getMap().containsKey("room_id") == false) goto L22;
            String r27 = (String) r7.getMap().get("room_id");
            if (r27 != null) goto L20;
            r27 = BuildConfig.FLAVOR;
        L20:
            r17.put("room_id", r27);
        L22:
            if (r7.getMap().containsKey("anchor_id") == false) goto L27;
            String r28 = (String) r7.getMap().get("anchor_id");
            if (r28 != null) goto L26;
            r28 = BuildConfig.FLAVOR;
        L26:
            r17.put("anchor_id", r28);
        L72:
            CombinedTextMessagePlugin.r(this.v, this.w, "schema");
            RxBusAbility.INSTANCE.getRxBus(this.v.c).post(new u22.h(2, this.w.getMessageId()));
            return true;
        L75:
            if ((r13 instanceof tb2.g) == false) goto L78;
            UserProfileEvent r111 = new UserProfileEvent(((tb2.g) r13).getUser());
            r111.setExtraFollowParams(com.bytedance.android.livesdk.user.j.b(LiveFollowScene.PROFILE_PUBLIC_SCREEN));
            CombinedTextMessagePlugin.r(this.v, this.w, "text_user");
            xs2.b.a().post(r111);
            RxBusAbility.INSTANCE.getRxBus(this.v.c).post(new u22.h(1, this.w.getMessageId()));
            return true;
        L78:
            return false;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.s
        public final void l(View r5, g52.d r6, g52.c r7) {
            Intrinsics.checkNotNullParameter(r5, "view");
            CombinedTextMessagePlugin.r(this.v, this.w, "other");
            RxBusAbility.INSTANCE.getRxBus(this.v.c).post(new u22.h(4, this.w.getMessageId()));
            IPublicAreaCommon r8 = this.w.getPublicAreaCommon();
            if (r8 == null) goto L16;
            String r9 = r8.getDefaultClickSchemaUrl();
            if (r9 == null) goto L16;
            Context r10 = com.bytedance.android.live.core.utils.a.d();
            if (r10 != null) goto L10;
            r10 = r5.getContext();
        L10:
            if (r10 == null) goto L16;
            IBaseLiveActionHandler r11 = k.f(IBaseLiveActionHandler.class);
            if (r11 == null) goto L22;
            r11.handle(r10, r9);
            return;
        L22:
            return;
        L16:
            m0 r13 = this.w.getBaseMessage();
            if (r13 == null) goto L23;
            IBaseUser r14 = r13.getUser();
            if (r14 == null) goto L24;
            UserProfileEvent r15 = new UserProfileEvent(r14);
            r15.setExtraFollowParams(com.bytedance.android.livesdk.user.j.b(LiveFollowScene.PROFILE_PUBLIC_SCREEN));
            xs2.b.a().post(r15);
            return;
        L24:
            return;
        }

        public b(CombinedTextMessagePlugin r2, tlc.d r3, Ref.ObjectRef r4, Ref.ObjectRef r5, z6 r6) {
            this.v = r2;
            this.w = r3;
            super(r6);
            boolean r0 = false;
            this.m = new s.c((tb2.d) r4.element, false, false);
            this.n = PublicScreenConfig$MessageModelType.COMBINED_TEXT;
            z6 r7 = (z6) r3;
            this.o = r7.getPublicAreaCommon();
            this.p = r7.getUserInMessage();
            this.q = PSMessageAction.CHAT;
            this.r = r2.b;
            IPublicAreaCommon r8 = r7.getPublicAreaCommon();
            if (r8 != null) goto L5;
        L7:
            this.s = r0;
            this.t = (tb2.d) r5.element;
            return;
        L5:
            if (r8.getForceInsert() != true) goto L7;
            r0 = true;
            goto L7
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.x
    public final void q() {
        com.bytedance.live.datacontext.j r0 = this.d.getMessageManager();
        if (r0 == null) goto L6;
        r0.c(new CombinedTextMessagePlugin$onUnload$1(this));
        return;
    }

    public final void onMessage(tlc.d r11) {
        if ((r11 instanceof z6) == false) goto L18;
        Ref.ObjectRef r4 = new Ref.ObjectRef();
        r4.element = new tb2.d();
        yb2.a r0 = w.a();
        int r2 = MessageCommonColorUtil.a;
        s.a r1 = new s.a(MessageCommonColorUtil.d(), MessageCommonColorUtil.a());
        z6 r6 = (z6) r11;
        f3 r3 = r6.Y();
        if (r3 == null) goto L9;
        a5 r5 = r3.a();
        if (r5 == null) goto L9;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.i r8 = new com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.i(0);
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.a.getClass();
        com.bytedance.android.livesdk.interactivity.service.textrender.core.x r9 = r.b;
        Intrinsics.checkNotNullParameter(r5, "text");
        tb2.d r7 = r.a(r5, r0);
        com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.g.a(r7, r8);
        r4.element = r7;
        r7.b = r1;
        r7.e(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(String.valueOf(8206)));
        ((tb2.d) r4.element).a(PublicScreenRichTextUtilsKt.c(r6.getPublicAreaCommon(), r0));
    L9:
        Ref.ObjectRef r10 = new Ref.ObjectRef();
        r10.element = null;
        f3 r13 = r6.t();
        if (r13 == null) goto L14;
        a5 r14 = r13.a();
        if (r14 == null) goto L14;
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.a.getClass();
        com.bytedance.android.livesdk.interactivity.service.textrender.core.x r15 = r.b;
        Intrinsics.checkNotNullParameter(r14, "text");
        tb2.d r16 = r.a(r14, r0);
        com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.g.a(r16, new com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.i(0));
        r16.b = r1;
        r16.e(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(String.valueOf(8206)));
        r10.element = r16;
    L14:
        b r17 = new b(this, r11, r4, r10, r6);
        com.bytedance.android.livesdk.interactivity.api.publicscreen.l r18 = o();
        if (r18 == null) goto L19;
        r18.insertMessage(r17);
        return;
    L19:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.x
    public final void p(com.bytedance.android.livesdk.interactivity.api.publicscreen.l r2) {
        Intrinsics.checkNotNullParameter(r2, "publicScreenContext");
        com.bytedance.live.datacontext.j r3 = this.d.getMessageManager();
        if (r3 == null) goto L5;
        r3.c(new CombinedTextMessagePlugin$onLoad$1(this));
    L5:
        com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel.d r4 = this.b;
        n(r4.a, r4);
    }

    public CombinedTextMessagePlugin(DataCenter r2, o r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "roomContext");
        this.c = r2;
        this.d = r3;
        this.b = new com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel.d();
    }

    public static final void r(CombinedTextMessagePlugin r3, z6 r4, String r5) {
        r3.getClass();
        Pair[] r0 = new Pair[2];
        if (r4 == null) goto L6;
        String r1 = r4.getBizScene();
        if (r1 == null) goto L6;
    L7:
        r0[0] = TuplesKt.to("msg_show_type", r1);
        r0[1] = TuplesKt.to("click_area", r5);
        HashMap r6 = MapsKt.hashMapOf(r0);
        if (r4 == null) goto L14;
        IPublicAreaCommon r7 = r4.getPublicAreaCommon();
        if (r7 == null) goto L14;
        Map r8 = r7.getTrackingParams();
        if (r8 == null) goto L14;
        r6.putAll(r8);
    L14:
        j0.l().sendLog("livesdk_public_screen_combined_text_message_click", r6, new Object[]{IRoom.class, am2.x.class});
        return;
    L6:
        r1 = BuildConfig.FLAVOR;
        goto L7
    }
}
