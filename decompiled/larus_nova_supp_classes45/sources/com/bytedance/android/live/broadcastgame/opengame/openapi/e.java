package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.broadcastgame.opengame.cloud.CloudExecutor;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class e implements com.bytedance.android.live.broadcastgame.opengame.openapi.y {
    public final List<String> a;
    public final List<io0.b> b;
    public final Map<String, Queue<Long>> c;
    public final PluginContext d;
    public final u10.b e;
    public final CloudExecutor f;
    public final /* synthetic */ i20.a g;

    public static final class a {
    }

    public static final class a0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ e a;

        public a0(e r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            e r1 = this.a;
            return new ShowLoadingMethod(r1.d, (Queue) ((LinkedHashMap) r1.c).get("showLoading"));
        }
    }

    public static final class b implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ e a;
        public final /* synthetic */ g0 b;

        public b(e r1, g0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            e r1 = this.a;
            return new PayMethod(r1.d, this.b, (Queue) ((LinkedHashMap) r1.c).get("payDiamonds"));
        }
    }

    public static final class b0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ e a;

        public b0(e r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            e r1 = this.a;
            return new HideLoadingMethod(r1.d, (Queue) ((LinkedHashMap) r1.c).get("hideLoading"));
        }
    }

    public static final class c implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ e a;
        public final /* synthetic */ g0 b;

        public c(e r1, g0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            e r1 = this.a;
            return new p0(r1.d, this.b, (Queue) ((LinkedHashMap) r1.c).get("payDiamondsV3"));
        }
    }

    public static final class c0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ e a;
        public final /* synthetic */ g0 b;

        public c0(e r1, g0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            e r1 = this.a;
            return new i1(r1.d, r1.f, this.b.getContext(), (Queue) ((LinkedHashMap) this.a.c).get("login"));
        }
    }

    public static final class d implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ e a;

        public d(e r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            e r1 = this.a;
            return new x0(r1.d, (Queue) ((LinkedHashMap) r1.c).get("drawOpenNickName"));
        }
    }

    public static final class d0 implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ e a;
        public final /* synthetic */ g0 b;

        public d0(e r1, g0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            e r1 = this.a;
            return new NetworkRequestMethod(r1.d, r1.e, this.b.d, (Queue) ((LinkedHashMap) r1.c).get("request"));
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.openapi.e$e, reason: collision with other inner class name */
    public static final class C0072e implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ e a;

        public C0072e(e r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            e r1 = this.a;
            return new w0(r1.d, (Queue) ((LinkedHashMap) r1.c).get("drawOpenAvatar"));
        }
    }

    public static final class f implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ e a;
        public final /* synthetic */ g0 b;

        public f(e r1, g0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            e r1 = this.a;
            return new com.bytedance.android.live.broadcastgame.opengame.openapi.h(r1.d, this.b, (Queue) ((LinkedHashMap) r1.c).get("checkIndividualPlayer"));
        }
    }

    public static final class g implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ e a;
        public final /* synthetic */ g0 b;

        public g(e r1, g0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            e r1 = this.a;
            return new com.bytedance.android.live.broadcastgame.opengame.openapi.i(r1.d, this.b, (Queue) ((LinkedHashMap) r1.c).get("checkIntermediateIndividualPlayer"));
        }
    }

    public static final class h implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ e a;

        public h(e r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            e r1 = this.a;
            return new SwitchScreenMethod(r1.d, (Queue) ((LinkedHashMap) r1.c).get("switchScreen"));
        }
    }

    public static final class i implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ e a;

        public i(e r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            e r1 = this.a;
            return new GetScreenTypeMethod(r1.d, (Queue) ((LinkedHashMap) r1.c).get("getScreenType"));
        }
    }

    public static final class j implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ e a;

        public j(e r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            e r1 = this.a;
            return new com.bytedance.android.live.broadcastgame.opengame.openapi.k(r1.d, r1.f, (Queue) ((LinkedHashMap) r1.c).get("callContainer"));
        }
    }

    public static final class k implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ e a;
        public final /* synthetic */ g0 b;

        public k(e r1, g0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            e r0 = this.a;
            PluginContext r1 = r0.d;
            g0 r2 = this.b;
            return new com.bytedance.android.live.broadcastgame.opengame.openapi.w(r1, r2.a, r2.b, (Queue) ((LinkedHashMap) r0.c).get("getUserInfoV2"));
        }
    }

    public static final class l implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ e a;

        public l(e r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.live.broadcastgame.opengame.openapi.a0(this.a.d);
        }
    }

    public static final class m implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ e a;
        public final /* synthetic */ g0 b;

        public m(e r1, g0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            e r1 = this.a;
            return new com.bytedance.android.live.broadcastgame.opengame.openapi.v(r1.d, this.b.a, (Queue) ((LinkedHashMap) r1.c).get("getSetting"));
        }
    }

    public static final class n implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ e a;
        public final /* synthetic */ g0 b;

        public n(e r1, g0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            e r1 = this.a;
            return new h0(r1.d, this.b.a, (Queue) ((LinkedHashMap) r1.c).get("openSetting"));
        }
    }

    public static final class o implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ e a;
        public final /* synthetic */ g0 b;

        public o(e r1, g0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            e r0 = this.a;
            PluginContext r1 = r0.d;
            g0 r2 = this.b;
            return new w10.b(r1, r2.a, r2.b, (Queue) ((LinkedHashMap) r0.c).get("getUserPropInfo"));
        }
    }

    public static final class p implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ e a;
        public final /* synthetic */ g0 b;

        public p(e r1, g0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            e r0 = this.a;
            PluginContext r1 = r0.d;
            g0 r2 = this.b;
            return new w10.a(r1, r2.a, r2.b, (Queue) ((LinkedHashMap) r0.c).get("createPropUsageOrder"));
        }
    }

    public static final class q implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ e a;
        public final /* synthetic */ g0 b;

        public q(e r1, g0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            e r1 = this.a;
            return new OpenCloudGameMethod(r1.d, this.b, (Queue) ((LinkedHashMap) r1.c).get("openCloudGame"));
        }
    }

    public static final class r implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ e a;
        public final /* synthetic */ g0 b;

        public r(e r1, g0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            e r1 = this.a;
            return new com.bytedance.android.live.broadcastgame.opengame.openapi.j(r1.d, this.b, (Queue) ((LinkedHashMap) r1.c).get("closeCloudGame"));
        }
    }

    public static final class s implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ e a;
        public final /* synthetic */ g0 b;

        public s(e r1, g0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            e r1 = this.a;
            return new com.bytedance.android.live.broadcastgame.opengame.openapi.g(r1.d, this.b, (Queue) ((LinkedHashMap) r1.c).get("changeScene"));
        }
    }

    public static final class t implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ e a;

        public t(e r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            e r1 = this.a;
            return new com.bytedance.android.live.broadcastgame.opengame.openapi.s(r1.d, (Queue) ((LinkedHashMap) r1.c).get("getCounterRuleInfo"));
        }
    }

    public static final class u implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ e a;

        public u(e r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            e r1 = this.a;
            return new b1(r1.d, (Queue) ((LinkedHashMap) r1.c).get("startCounter"));
        }
    }

    public static final class v implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ e a;

        public v(e r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            e r1 = this.a;
            return new com.bytedance.android.live.broadcastgame.opengame.openapi.r(r1.d, (Queue) ((LinkedHashMap) r1.c).get("getCounterRank"));
        }
    }

    public static final class w implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ e a;
        public final /* synthetic */ g0 b;

        public w(e r1, g0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            e r0 = this.a;
            PluginContext r1 = r0.d;
            g0 r2 = this.b;
            return new com.bytedance.android.live.broadcastgame.opengame.openapi.u(r1, r2.a, r2.b, (Queue) ((LinkedHashMap) r0.c).get("getRoomInfo"));
        }
    }

    public static final class x implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ e a;
        public final /* synthetic */ g0 b;

        public x(e r1, g0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            e r0 = this.a;
            PluginContext r1 = r0.d;
            g0 r2 = this.b;
            return new com.bytedance.android.live.broadcastgame.opengame.openapi.t(r1, r2.a, r2.b, (Queue) ((LinkedHashMap) r0.c).get("getUserInfo"));
        }
    }

    public static final class y implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ e a;

        public y(e r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            e r1 = this.a;
            return new com.bytedance.android.live.broadcastgame.opengame.openapi.b0(r1.d, (Queue) ((LinkedHashMap) r1.c).get("navigateTo"));
        }
    }

    public static final class z implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ e a;

        public z(e r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            e r1 = this.a;
            return new NavigateBackMethod(r1.d, (Queue) ((LinkedHashMap) r1.c).get("navigateBack"));
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.y
    public final void release() {
        ((ArrayList) this.a).clear();
        ((LinkedHashMap) this.c).clear();
        this.g.b();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.y
    public final void b(com.bytedance.android.live.lynx.api.d r3) {
        Intrinsics.checkNotNullParameter(r3, "component");
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r3.f((String) r0.next());
        goto L4
    L6:
        ((ArrayList) this.b).remove(r3);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.y
    public void a(io0.b r3, g0 r4) {
        Intrinsics.checkNotNullParameter(r3, "component");
        Intrinsics.checkNotNullParameter(r4, "param");
        c(r3, "log", new l(this));
        c(r3, "getRoomInfo", new w(this, r4));
        c(r3, "getUserInfo", new x(this, r4));
        c(r3, "navigateTo", new y(this));
        c(r3, "navigateBack", new z(this));
        c(r3, "showLoading", new a0(this));
        c(r3, "hideLoading", new b0(this));
        c(r3, "login", new c0(this, r4));
        c(r3, "request", new d0(this, r4));
        c(r3, "payDiamonds", new b(this, r4));
        c(r3, "payDiamondsV3", new c(this, r4));
        c(r3, "drawOpenNickName", new d(this));
        c(r3, "drawOpenAvatar", new C0072e(this));
        c(r3, "checkIndividualPlayer", new f(this, r4));
        c(r3, "checkIntermediateIndividualPlayer", new g(this, r4));
        c(r3, "switchScreen", new h(this));
        c(r3, "getScreenType", new i(this));
        c(r3, "callContainer", new j(this));
        c(r3, "getUserInfoV2", new k(this, r4));
        c(r3, "getSetting", new m(this, r4));
        c(r3, "openSetting", new n(this, r4));
        c(r3, "getUserPropInfo", new o(this, r4));
        c(r3, "createPropUsageOrder", new p(this, r4));
        c(r3, "openCloudGame", new q(this, r4));
        c(r3, "closeCloudGame", new r(this, r4));
        c(r3, "changeScene", new s(this, r4));
        c(r3, "getCounterRuleInfo", new t(this));
        c(r3, "startCounter", new u(this));
        c(r3, "getCounterRank", new v(this));
    }

    public e(PluginContext r2, u10.b r3, CloudExecutor r4) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        Intrinsics.checkNotNullParameter(r3, "networkExecutor");
        Intrinsics.checkNotNullParameter(r4, "cloudExecutor");
        this.g = new i20.a();
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new LinkedHashMap();
    }

    public final void c(io0.b r3, String r4, com.bytedance.ies.web.jsbridge2.f.b r5) {
        Intrinsics.checkNotNullParameter(r3, "component");
        Intrinsics.checkNotNullParameter(r4, "name");
        Intrinsics.checkNotNullParameter(r5, "method");
        if (((ArrayList) this.a).contains(r4) == true) goto L6;
        ((ArrayList) this.a).add(r4);
        this.c.put(r4, new LinkedList());
    L6:
        if (((ArrayList) this.b).contains(r3) == true) goto L8;
        ((ArrayList) this.b).add(r3);
    L8:
        r3.registerMethod(r4, r5);
    }
}
