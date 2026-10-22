package com.bytedance.android.live.browser.jsbridge;

import com.bytedance.android.live.browser.jsbridge.newmethods.h9;
import com.bytedance.android.live.browser.jsbridge.newmethods.kc;
import com.bytedance.android.live.browser.jsbridge.newmethods.nc;
import com.bytedance.android.live.browser.jsbridge.newmethods.oc;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends y6.a {
    public final String b;

    /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.a$a, reason: collision with other inner class name */
    public static final class C0108a implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ y6.c a;

        public C0108a(y6.c r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new oc(this.a);
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
            return new nc();
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
            return new kc();
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
            return new h9();
        }
    }

    public a() {
        this.b = "AnnieJsbRegister";
    }

    public final String a() {
        return this.b;
    }

    public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> l(y6.c r3) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("shareViewToPanel", new C0108a(r3)), TuplesKt.to("shareTicket", b.a), TuplesKt.to("shareImageUrlToPanel", c.a), TuplesKt.to("openMultiPosterSharePanel", d.a)});
    }
}
