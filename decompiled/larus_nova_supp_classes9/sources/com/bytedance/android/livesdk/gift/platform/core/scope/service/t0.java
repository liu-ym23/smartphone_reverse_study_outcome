package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.live.browser.jsbridge.newmethods.k4;
import com.bytedance.android.live.browser.jsbridge.newmethods.q4;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class t0 implements t2, com.bytedance.android.scope.o {
    public final CompositeDisposable a;
    public final vy0.c b;
    public final com.bytedance.android.live.revenue.platform.hybrid.api.shareview.a c;

    public static final class a implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.livesdk.gift.platform.core.ui.configuration.f();
        }
    }

    public static final class b implements wy0.f {

        public static final class a implements com.bytedance.ies.web.jsbridge2.f.b {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }

            public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
                return new com.bytedance.android.live.browser.jsbridge.newmethods.q2();
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.core.scope.service.t0$b$b, reason: collision with other inner class name */
        public static final class C0073b implements com.bytedance.ies.web.jsbridge2.f.b {
            public static final C0073b a = null;

            static {
                a = new C0073b();
            }

            public C0073b() {
            }

            public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
                return new com.bytedance.android.live.browser.jsbridge.newmethods.u3();
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
                return new q4();
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
                return new k4();
            }
        }

        public b() {
        }

        public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> a(y6.c r3) {
            Intrinsics.checkNotNullParameter(r3, "manager");
            return MapsKt.mapOf(new Pair[]{TuplesKt.to("downloadGiftAsset", a.a), TuplesKt.to("getAssetsPath", C0073b.a), TuplesKt.to("getGiftExtraData", c.a), TuplesKt.to("getDownloadGiftAssets", d.a)});
        }

        public final Map<String, wy0.h<Object, ?>> c(y6.c r2) {
            Intrinsics.checkNotNullParameter(r2, "manager");
            return wy0.f.a.a(r2);
        }

        public final Map<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> d(y6.c r2) {
            Intrinsics.checkNotNullParameter(r2, "manager");
            Intrinsics.checkNotNullParameter(r2, "manager");
            return MapsKt.emptyMap();
        }

        public final Map<String, com.bytedance.ies.web.jsbridge2.g<Object, ?>> f(y6.c r2) {
            Intrinsics.checkNotNullParameter(r2, "manager");
            return wy0.f.a.b(r2);
        }
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.scope.service.t2
    public final void g0() {
        this.a.add(this.b.O3(new b()));
    }

    public final void onStart() {
        this.c.registerMethod("revenue.requestStickerEffectStatus", a.a);
    }

    public final void onStop() {
        this.a.clear();
    }

    public t0(vy0.c r2, com.bytedance.android.live.revenue.platform.hybrid.api.shareview.a r3) {
        Intrinsics.checkNotNullParameter(r2, "hybridService");
        Intrinsics.checkNotNullParameter(r3, "shareViewService");
        this.b = r2;
        this.c = r3;
        this.a = new CompositeDisposable();
    }
}
