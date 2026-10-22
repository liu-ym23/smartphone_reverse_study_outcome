package com.bytedance.android.live.revenue.platform.hybrid.impl.ui;

import android.view.View;
import com.bytedance.android.live.revenue.platform.container.impl.d0;
import com.bytedance.android.live.revenue.platform.hybrid.api.HybridType;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.web.jsbridge2.g;
import java.util.Map;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends c implements zy0.b {
    public final View c;
    public final b d;
    public final com.bytedance.android.livesdk.revenue.service.hybrid.b e;

    /* JADX INFO: renamed from: com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a$a, reason: collision with other inner class name */
    public static final class C0096a implements wy0.e {
        public final /* synthetic */ a a;

        public C0096a(a r1) {
            this.a = r1;
        }

        @Override // wy0.e
        public final void registerMethod(String r2, com.bytedance.ies.web.jsbridge2.f.b r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, "methodProvider");
            this.a.d.registerMethod(r2, r3);
        }

        @Override // wy0.e
        public final void sendJsEvent(String r2, Object r3) {
            Intrinsics.checkNotNullParameter("rpcChannelMessage", "name");
            Intrinsics.checkNotNullParameter(r3, Constants.Keys.DATA);
            this.a.d.sendJsEvent("rpcChannelMessage", r3);
        }

        @Override // wy0.e
        public final void registerMethod(String r2, g<?, ?> r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, "method");
            this.a.d.registerMethod(r2, r3);
        }
    }

    public static final class b implements xy0.a<View> {
        public final HybridType a;
        public final View b;
        public final /* synthetic */ a c;

        @Override // xy0.a
        public final void load() {
            load(null, null);
        }

        @Override // xy0.a
        public final void dispose() {
            this.c.e.dispose();
        }

        @Override // xy0.a
        public final boolean isDisposed() {
            return this.c.e.isDisposed();
        }

        @Override // xy0.a
        public final View getHybridView() {
            return this.b;
        }

        @Override // xy0.a
        public final HybridType o() {
            return this.a;
        }

        public b(a r2) {
            this.c = r2;
            this.a = HybridType.LYNX;
            r2.e.getContainerId();
            this.b = r2.e.c();
        }

        public final void b(Map<String, ? extends Object> r3) {
            this.c.e.load(null, r3);
        }

        @Override // xy0.a
        public final void load(String r2) {
            load(r2, null);
        }

        @Override // xy0.a
        public final void updateData(Map<String, ? extends Object> r2) {
            Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
            this.c.e.updateData(r2);
        }

        @Override // xy0.a
        public final void updateGlobalProps(Map<String, ? extends Object> r2) {
            this.c.e.updateGlobalProps(r2);
        }

        @Override // xy0.a
        public final void load(String r2, Map<String, ? extends Object> r3) {
            this.c.e.load(r2, r3);
        }

        @Override // xy0.a, wy0.e
        public final void registerMethod(String r2, com.bytedance.ies.web.jsbridge2.f.b r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, "methodProvider");
            this.c.e.registerMethod(r2, r3);
        }

        @Override // xy0.a, wy0.e
        public final void sendJsEvent(String r2, Object r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, Constants.Keys.DATA);
            this.c.e.sendJsEvent(r2, r3);
        }

        @Override // xy0.a
        public final void updateScreenMetrics(int r2, int r3) {
            this.c.e.updateScreenMetrics(r2, r3);
        }

        @Override // xy0.a, wy0.e
        public final void registerMethod(String r2, g<?, ?> r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, "method");
            this.c.e.registerMethod(r2, r3);
        }
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.impl.ui.c
    public final View getHybridView() {
        return this.d.b;
    }

    @Override // zy0.b
    public final void x() {
        IMiddlewareHostBusiness r0 = k.f(IMiddlewareHostBusiness.class);
        if (r0 == null) goto L6;
        r0.loadLynxSoLib(this.c);
        return;
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.impl.ui.c, com.bytedance.android.live.revenue.common.j
    public final void d() {
        super.d();
        this.e.dispose();
    }

    @Override // zy0.b
    public final View c() {
        return this.c;
    }

    @Override // zy0.c
    public final xy0.a<View> g() {
        return this.d;
    }

    @Override // zy0.c
    public final xy0.a<?> w() {
        return this.d;
    }

    public a(com.bytedance.android.livesdk.revenue.service.hybrid.b r2) {
        Intrinsics.checkNotNullParameter(r2, "originalCard");
        this.e = r2;
        this.c = r2.c();
        this.d = new b(this);
        l1(new BaseHybridComponentContainerBase$init$1(this));
    }

    @Override // zy0.c
    public final void l1(Function1<? super wy0.e, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        r2.invoke(new C0096a(this));
    }

    public final void b(String r3, d0 r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "method");
        this.e.registerMethod(r3, new com.bytedance.android.live.revenue.platform.hybrid.impl.ui.b(r4));
    }

    public final void sendJsEvent(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, Constants.Keys.DATA);
        this.e.sendJsEvent(r2, r3);
    }
}
