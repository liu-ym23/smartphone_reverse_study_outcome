package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.broadcastgame.opengame.cloud.CloudExecutor;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.Queue;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d extends com.bytedance.android.live.broadcastgame.opengame.openapi.e {
    public final com.bytedance.android.live.broadcastgame.opengame.message.g h;
    public final PluginContext i;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            com.bytedance.android.live.broadcastgame.opengame.message.a r5 = (com.bytedance.android.live.broadcastgame.opengame.message.a) r4;
            int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("AudienceOpenApiImpl", new Object[]{"recv anchor business msg: " + r5});
            com.bytedance.android.live.broadcastgame.opengame.runtime.k r1 = this.a.i.k();
            if (r1 == null) goto L6;
            JSONObject r2 = new JSONObject();
            r2.put("message", r5.f);
            Unit r6 = Unit.INSTANCE;
            r1.sendEvent("onReceiveAnchorMessage", r2);
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class c {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.openapi.d$d, reason: collision with other inner class name */
    public static final class C0071d implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ d a;
        public final /* synthetic */ io0.b b;

        public C0071d(d r1, io0.b r2) {
            this.a = r1;
            this.b = r2;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            d r1 = this.a;
            return new y0(r1.i, r1.h, (Queue) ((LinkedHashMap) r1.c).get("sendMessageToAnchor"));
        }
    }

    public static final class e implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ d a;
        public final /* synthetic */ io0.b b;

        public e(d r1, io0.b r2) {
            this.a = r1;
            this.b = r2;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            d r1 = this.a;
            return new q(r1.i, r1.h, (Queue) ((LinkedHashMap) r1.c).get("getSelfCommentCountDuringPluginRunning"));
        }
    }

    public static final class f implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ d a;
        public final /* synthetic */ g0 b;

        public f(d r1, g0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            d r1 = this.a;
            return new o(r1.i, this.b, (Queue) ((LinkedHashMap) r1.c).get("isFollowingAnchor"));
        }
    }

    public static final class g implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ d a;
        public final /* synthetic */ g0 b;

        public g(d r1, g0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            d r1 = this.a;
            return new z(r1.i, this.b, (Queue) ((LinkedHashMap) r1.c).get("isFavoriteGame"));
        }
    }

    public static final class h implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ d a;
        public final /* synthetic */ g0 b;

        public h(d r1, g0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            d r1 = this.a;
            return new com.bytedance.android.live.broadcastgame.opengame.openapi.a(r1.i, this.b.a, (Queue) ((LinkedHashMap) r1.c).get("addToFavorites"));
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.e, com.bytedance.android.live.broadcastgame.opengame.openapi.y
    public final void a(io0.b r3, g0 r4) {
        Intrinsics.checkNotNullParameter(r3, "component");
        Intrinsics.checkNotNullParameter(r4, "param");
        super.a(r3, r4);
        if (this.h == null) goto L5;
        c(r3, "sendMessageToAnchor", new C0071d(this, r3));
        c(r3, "getSelfCommentCountDuringPluginRunning", new e(this, r3));
    L5:
        c(r3, "isFollowingAnchor", new f(this, r4));
        c(r3, "isFavoriteGame", new g(this, r4));
        c(r3, "addToFavorites", new h(this, r4));
    }

    public d(PluginContext r2, u10.b r3, CloudExecutor r4) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        Intrinsics.checkNotNullParameter(r3, "networkExecutor");
        Intrinsics.checkNotNullParameter(r4, "cloudExecutor");
        super(r2, r3, r4);
        this.i = r2;
        com.bytedance.android.live.broadcastgame.opengame.message.c0 r5 = r2.l;
        if ((r5 instanceof com.bytedance.android.live.broadcastgame.opengame.message.g) == true) goto L5;
        com.bytedance.android.live.broadcastgame.opengame.message.c0 r6 = null;
    L6:
        this.h = (com.bytedance.android.live.broadcastgame.opengame.message.g) r6;
        if (r5 == null) goto L14;
        Observable r7 = r5.a(com.bytedance.android.live.broadcastgame.opengame.message.a.class);
        if (r7 == null) goto L15;
        Disposable r8 = r7.subscribe(new a(this), b.a);
        if (r8 == null) goto L16;
        Intrinsics.checkNotNullParameter(r8, "$this$autoDispose");
        this.g.a(r8);
        return;
    L16:
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r6 = r5;
        goto L6
    }
}
