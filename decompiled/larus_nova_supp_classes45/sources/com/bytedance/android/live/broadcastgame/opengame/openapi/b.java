package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.broadcastgame.opengame.cloud.CloudExecutor;
import com.bytedance.android.live.broadcastgame.opengame.message.AnchorGameMessageChannel;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.livesdk.message.model.uh;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Queue;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b extends com.bytedance.android.live.broadcastgame.opengame.openapi.e {
    public final AnchorGameMessageChannel h;
    public final PluginContext i;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            com.bytedance.android.live.broadcastgame.opengame.message.f r5 = (com.bytedance.android.live.broadcastgame.opengame.message.f) r4;
            int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("AnchorOpenApiImpl", new Object[]{"recv audience business msg: ", r5});
            com.bytedance.android.live.broadcastgame.opengame.runtime.k r1 = this.a.i.k();
            if (r1 == null) goto L6;
            JSONObject r2 = new JSONObject();
            r2.put("message", r5.d);
            Unit r6 = Unit.INSTANCE;
            r1.sendEvent("onReceiveAudienceMessage", r2);
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.openapi.b$b, reason: collision with other inner class name */
    public static final class C0069b<T> implements Consumer {
        public static final C0069b a = null;

        static {
            a = new C0069b();
        }

        public C0069b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ b a;

        public c(b r1) {
            this.a = r1;
        }

        public final void accept(Object r11) {
            int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("AnchorOpenApiImpl", new Object[]{"recv comment msg"});
            JSONArray r1 = new JSONArray();
            Iterator<T> r12 = ((com.bytedance.android.live.broadcastgame.opengame.message.o) r11).a.iterator();
        L4:
            if (r12.hasNext() == false) goto L12;
            com.bytedance.android.live.broadcastgame.opengame.message.n r4 = (com.bytedance.android.live.broadcastgame.opengame.message.n) r12.next();
            Iterator<T> r5 = r4.a.iterator();
        L7:
            if (r5.hasNext() == false) goto L4;
            uh r6 = (uh) r5.next();
            if (Intrinsics.areEqual(r6.appId, this.a.i.m.i) == false) goto L7;
            JSONObject r7 = new JSONObject();
            r7.put("openUID", r6.openUid);
            r7.put("secNickname", r4.b);
            r7.put("secAvatarURL", r4.c);
            r7.put("content", r4.d);
            r7.put("timestamp", r4.e);
            Unit r8 = Unit.INSTANCE;
            r1.put(r7);
            goto L7
        L12:
            if (r1.length() == 0) goto L25;
            int r13 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("AnchorOpenApiImpl", new Object[]{"comment data: " + r1});
            com.bytedance.android.live.broadcastgame.opengame.runtime.k r14 = this.a.i.k();
            if (r14 == null) goto L24;
            JSONObject r2 = new JSONObject();
            r2.put("commentList", r1);
            Unit r3 = Unit.INSTANCE;
            r14.sendEvent("onReceiveSpecifiedComment", r2);
            return;
        L24:
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ b a;

        public e(b r1) {
            this.a = r1;
        }

        public final void accept(Object r11) {
            int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("AnchorOpenApiImpl", new Object[]{"recv follow action msg"});
            JSONArray r1 = new JSONArray();
            Iterator<T> r12 = ((com.bytedance.android.live.broadcastgame.opengame.message.u) r11).a.iterator();
        L4:
            if (r12.hasNext() == false) goto L12;
            com.bytedance.android.live.broadcastgame.opengame.message.t r4 = (com.bytedance.android.live.broadcastgame.opengame.message.t) r12.next();
            Iterator<T> r5 = r4.a.iterator();
        L7:
            if (r5.hasNext() == false) goto L4;
            uh r6 = (uh) r5.next();
            if (Intrinsics.areEqual(r6.appId, this.a.i.m.i) == false) goto L7;
            JSONObject r7 = new JSONObject();
            r7.put("openUID", r6.openUid);
            r7.put("secNickname", r4.b);
            r7.put("secAvatarURL", r4.c);
            r7.put("action", r4.d);
            r7.put("timestamp", r4.e);
            Unit r8 = Unit.INSTANCE;
            r1.put(r7);
            goto L7
        L12:
            if (r1.length() == 0) goto L25;
            int r13 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("AnchorOpenApiImpl", new Object[]{"follow data: " + r1});
            com.bytedance.android.live.broadcastgame.opengame.runtime.k r14 = this.a.i.k();
            if (r14 == null) goto L24;
            JSONObject r2 = new JSONObject();
            r2.put("followInfoList", r1);
            Unit r3 = Unit.INSTANCE;
            r14.sendEvent("onReceiveAudiencesFollowAction", r2);
            return;
        L24:
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class g {
    }

    public static final class h implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ AnchorGameMessageChannel a;
        public final /* synthetic */ b b;
        public final /* synthetic */ io0.b c;

        public h(AnchorGameMessageChannel r1, b r2, io0.b r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            b r1 = this.b;
            return new com.bytedance.android.live.broadcastgame.opengame.openapi.c(r1.i, this.a, (Queue) ((LinkedHashMap) r1.c).get("sendMessageToAudiences"));
        }
    }

    public static final class i implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ b a;
        public final /* synthetic */ g0 b;

        public i(b r1, g0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            b r0 = this.a;
            PluginContext r1 = r0.i;
            g0 r2 = this.b;
            return new v10.e(r1, r2.a, r2.b, (Queue) ((LinkedHashMap) r0.c).get("inviteLiveUser"));
        }
    }

    public static final class j implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ b a;
        public final /* synthetic */ g0 b;

        public j(b r1, g0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            b r0 = this.a;
            PluginContext r1 = r0.i;
            g0 r2 = this.b;
            return new v10.f(r1, r2.a, r2.b, (Queue) ((LinkedHashMap) r0.c).get("kickOffMic"));
        }
    }

    public static final class k implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ b a;
        public final /* synthetic */ g0 b;

        public k(b r1, g0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            b r0 = this.a;
            PluginContext r1 = r0.i;
            g0 r2 = this.b;
            return new v10.a(r1, r2.a, r2.b, (Queue) ((LinkedHashMap) r0.c).get("disableLiveCamera"));
        }
    }

    public static final class l implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ b a;
        public final /* synthetic */ g0 b;

        public l(b r1, g0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            b r0 = this.a;
            PluginContext r1 = r0.i;
            g0 r2 = this.b;
            return new v10.c(r1, r2.a, r2.b, (Queue) ((LinkedHashMap) r0.c).get("enableLiveCamera"));
        }
    }

    public static final class m implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ b a;
        public final /* synthetic */ g0 b;

        public m(b r1, g0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            b r0 = this.a;
            PluginContext r1 = r0.i;
            g0 r2 = this.b;
            return new v10.b(r1, r2.a, r2.b, (Queue) ((LinkedHashMap) r0.c).get("disableLiveMic"));
        }
    }

    public static final class n implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ b a;
        public final /* synthetic */ g0 b;

        public n(b r1, g0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            b r0 = this.a;
            PluginContext r1 = r0.i;
            g0 r2 = this.b;
            return new v10.d(r1, r2.a, r2.b, (Queue) ((LinkedHashMap) r0.c).get("enableLiveCamera"));
        }
    }

    public static final class o implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ b a;
        public final /* synthetic */ g0 b;

        public o(b r1, g0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            b r1 = this.a;
            return new d1(r1.i, this.b, (Queue) ((LinkedHashMap) r1.c).get("subscribeSpecifiedContentComment"));
        }
    }

    public static final class p implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ b a;
        public final /* synthetic */ g0 b;

        public p(b r1, g0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            b r1 = this.a;
            return new g1(r1.i, this.b, (Queue) ((LinkedHashMap) r1.c).get("unsubscribeAllSpecifiedContentComment"));
        }
    }

    public static final class q implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ b a;
        public final /* synthetic */ g0 b;

        public q(b r1, g0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            b r1 = this.a;
            return new e1(r1.i, this.b, (Queue) ((LinkedHashMap) r1.c).get("subscribeSpecifiedUserComment"));
        }
    }

    public static final class r implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ b a;
        public final /* synthetic */ g0 b;

        public r(b r1, g0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            b r1 = this.a;
            return new h1(r1.i, this.b, (Queue) ((LinkedHashMap) r1.c).get("unsubscribeAllSpecifiedUserComment"));
        }
    }

    public static final class s implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ b a;
        public final /* synthetic */ g0 b;

        public s(b r1, g0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            b r1 = this.a;
            return new c1(r1.i, this.b, (Queue) ((LinkedHashMap) r1.c).get("unsubscribeAllSpecifiedUserComment"));
        }
    }

    public static final class t implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ b a;
        public final /* synthetic */ g0 b;

        public t(b r1, g0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            b r1 = this.a;
            return new f1(r1.i, this.b, (Queue) ((LinkedHashMap) r1.c).get("unsubscribeAllSpecifiedUserComment"));
        }
    }

    public static final class u implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ b a;
        public final /* synthetic */ g0 b;

        public u(b r1, g0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            b r1 = this.a;
            return new z0(r1.i, this.b, (Queue) ((LinkedHashMap) r1.c).get("showAllAudienceCornerMark"));
        }
    }

    public static final class v implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ b a;
        public final /* synthetic */ g0 b;

        public v(b r1, g0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            b r1 = this.a;
            return new a1(r1.i, this.b, (Queue) ((LinkedHashMap) r1.c).get("showSpecifiedAudienceCornerMark"));
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.e, com.bytedance.android.live.broadcastgame.opengame.openapi.y
    public final void a(io0.b r3, g0 r4) {
        Intrinsics.checkNotNullParameter(r3, "component");
        Intrinsics.checkNotNullParameter(r4, "param");
        super.a(r3, r4);
        AnchorGameMessageChannel r0 = this.h;
        if (r0 == null) goto L5;
        c(r3, "sendMessageToAudiences", new h(r0, this, r3));
    L5:
        c(r3, "subscribeSpecifiedContentComment", new o(this, r4));
        c(r3, "unsubscribeAllSpecifiedContentComment", new p(this, r4));
        c(r3, "subscribeSpecifiedUserComment", new q(this, r4));
        c(r3, "unsubscribeAllSpecifiedUserComment", new r(this, r4));
        c(r3, "subscribeAudiencesFollowAction", new s(this, r4));
        c(r3, "unsubscribeAudiencesFollowAction", new t(this, r4));
        c(r3, "showAllAudienceCornerMark", new u(this, r4));
        c(r3, "showSpecifiedAudienceCornerMark", new v(this, r4));
        c(r3, "inviteLiveUser", new i(this, r4));
        c(r3, "kickOffMic", new j(this, r4));
        c(r3, "disableLiveCamera", new k(this, r4));
        c(r3, "enableLiveCamera", new l(this, r4));
        c(r3, "disableLiveMic", new m(this, r4));
        c(r3, "enableLiveMic", new n(this, r4));
    }

    public b(PluginContext r4, u10.b r5, CloudExecutor r6) {
        Intrinsics.checkNotNullParameter(r4, "pluginContext");
        Intrinsics.checkNotNullParameter(r5, "networkExecutor");
        Intrinsics.checkNotNullParameter(r6, "cloudExecutor");
        super(r4, r5, r6);
        this.i = r4;
        com.bytedance.android.live.broadcastgame.opengame.message.c0 r7 = r4.l;
        if ((r7 instanceof AnchorGameMessageChannel) == true) goto L5;
        r7 = null;
    L5:
        AnchorGameMessageChannel r8 = (AnchorGameMessageChannel) r7;
        this.h = r8;
        if (r8 == null) goto L12;
        Observable r0 = r8.a(com.bytedance.android.live.broadcastgame.opengame.message.f.class);
        if (r0 == null) goto L12;
        Disposable r1 = r0.subscribe(new a(this), C0069b.a);
        if (r1 == null) goto L12;
        Intrinsics.checkNotNullParameter(r1, "$this$autoDispose");
        this.g.a(r1);
    L12:
        com.bytedance.android.live.broadcastgame.opengame.message.c0 r9 = r4.l;
        if (r9 == null) goto L19;
        Observable r11 = r9.a(com.bytedance.android.live.broadcastgame.opengame.message.o.class);
        if (r11 == null) goto L19;
        Disposable r12 = r11.subscribe(new c(this), d.a);
        if (r12 == null) goto L19;
        Intrinsics.checkNotNullParameter(r12, "$this$autoDispose");
        this.g.a(r12);
    L19:
        if (r8 == null) goto L26;
        Observable r13 = r8.a(com.bytedance.android.live.broadcastgame.opengame.message.u.class);
        if (r13 == null) goto L27;
        Disposable r14 = r13.subscribe(new e(this), f.a);
        if (r14 == null) goto L28;
        Intrinsics.checkNotNullParameter(r14, "$this$autoDispose");
        this.g.a(r14);
        return;
    L28:
        return;
    L27:
        return;
    }
}
