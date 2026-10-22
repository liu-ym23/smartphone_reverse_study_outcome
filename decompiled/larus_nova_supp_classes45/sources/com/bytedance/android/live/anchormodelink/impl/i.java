package com.bytedance.android.live.anchormodelink.impl;

import com.bytedance.android.live.liveinteract.jsbridge.method.l;
import com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i extends BaseJsBridgeMethodFactory {
    public final /* synthetic */ AnchorModeLinkDynamicWidget a;

    public static final class a implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ i a;
        public final /* synthetic */ IJsBridgeManager b;

        public a(i r1, IJsBridgeManager r2) {
            this.a = r1;
            this.b = r2;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new l(((Widget) this.a.a).dataCenter, false, null, this.b, null, 16);
        }
    }

    public static final class b implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ i a;

        public b(i r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.live.liveinteract.jsbridge.method.c(((Widget) this.a.a).dataCenter, false, null, 12);
        }
    }

    public i(AnchorModeLinkDynamicWidget r1) {
        this.a = r1;
    }

    public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> provideStatefulMethods(IJsBridgeManager r3) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("updateLinkmicStatus", new a(this, r3)), TuplesKt.to("getLinkmicStatus", new b(this))});
    }
}
