package com.bytedance.android.live.browser.jsbridge;

import com.bytedance.android.livesdk.jsbridge.methods.p0;
import com.bytedance.android.livesdk.jsbridge.methods.p3;
import com.bytedance.android.livesdk.jsbridge.methods.q1;
import com.bytedance.android.livesdk.jsbridge.methods.r0;
import com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r extends BaseJsBridgeMethodFactory {
    public static final r a = null;

    public static final class a implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.livesdk.jsbridge.methods.a();
        }
    }

    public static final class b implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new p3();
        }
    }

    public static final class c implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new r0();
        }
    }

    public static final class d implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new q1();
        }
    }

    public static final class e implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new wc2.d();
        }
    }

    public static final class f implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new p0();
        }
    }

    public static final class g implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.livesdk.jsbridge.methods.d0();
        }
    }

    public static final class h implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final h a = null;

        static {
            a = new h();
        }

        public h() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new f30.b();
        }
    }

    public final Map<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> provideStatelessCacheableMethods() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("showManagePoiDialog", new yc2.d()), TuplesKt.to("apiParam", new f30.a())});
    }

    static {
        a = new r();
    }

    public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> provideStatefulCacheableMethods() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("reportALog", a.a), TuplesKt.to("uploadFullLinkMonitor", b.a), TuplesKt.to("fetchClipBoard", c.a), TuplesKt.to("reportLiveTrace", d.a), TuplesKt.to("updateUserInfo", e.a), TuplesKt.to("endLiveLocationModule", f.a), TuplesKt.to("baseInfo", g.a), TuplesKt.to("getUserInfo", h.a)});
    }

    public r() {
    }

    public final Map<String, n56.c> provideLegacySpecifiedMethods(IJsBridgeManager r3) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        return MapsKt.mapOf(TuplesKt.to("copyToClipboard", new com.bytedance.android.livesdk.jsbridge.methods.f0(new WeakReference(r3.getActivity()))));
    }
}
