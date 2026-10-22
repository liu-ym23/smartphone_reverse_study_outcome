package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.live.browser.jsbridge.base.ChangeGiftReceiverResultModel;
import com.bytedance.android.live.browser.jsbridge.base.LiveRequireGiftEffectLynxViewResultModel;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b3 implements com.bytedance.android.scope.o {
    public final CompositeDisposable a;
    public final com.bytedance.android.scope.j b;
    public final DataCenter c;
    public final x2 d;
    public final vy0.b e;
    public final l02.h f;

    public static final class a implements wy0.d {
        public final /* synthetic */ b3 a;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.core.scope.service.b3$a$a, reason: collision with other inner class name */
        public static final class C0071a<P, R> implements wy0.h {
            public final /* synthetic */ a a;

            public C0071a(a r1) {
                this.a = r1;
            }

            public final wy0.a<Object, LiveRequireGiftEffectLynxViewResultModel> a() {
                return new com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods.m(this.a.a.f);
            }
        }

        public static final class b<P, R> implements wy0.h {
            public final /* synthetic */ a a;

            public b(a r1) {
                this.a = r1;
            }

            public final wy0.a<Object, ChangeGiftReceiverResultModel> a() {
                return new com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods.b(this.a.a.b);
            }
        }

        public a(b3 r1) {
            this.a = r1;
        }

        public final Map<String, wy0.h<Object, ?>> c(y6.c r3) {
            Intrinsics.checkNotNullParameter(r3, "manager");
            LinkedHashMap r4 = new LinkedHashMap();
            r4.put("live.requireGiftEffectLynxView", new C0071a(this));
            r4.put("changeGiftReceiver", new b(this));
            return r4;
        }

        public final Map<String, com.bytedance.ies.web.jsbridge2.g<Object, ?>> f(y6.c r4) {
            Intrinsics.checkNotNullParameter(r4, "manager");
            b3 r1 = this.a;
            Pair[] r5 = {TuplesKt.to("getGiftGuestListData", new com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods.i(r1.b, r1.c))};
            LinkedHashMap r0 = new LinkedHashMap();
            MapsKt.putAll(r0, r5);
            return r0;
        }
    }

    public final void onStart() {
        com.bytedance.revenue.platform.api.core.rx.f.a(this.e.Sb(new a(this)), this.a);
        this.d.g0();
    }

    public final void onStop() {
        this.a.clear();
    }

    public b3(com.bytedance.android.scope.j r2, DataCenter r3, x2 r4, vy0.b r5, l02.h r6) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "roomJsbService");
        Intrinsics.checkNotNullParameter(r5, "hybridService");
        Intrinsics.checkNotNullParameter(r6, "effectInfoService");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.a = new CompositeDisposable();
    }
}
