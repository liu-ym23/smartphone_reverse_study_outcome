package com.bytedance.android.live.revenue.platform.log.impl.filterimpl;

import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.filter.t;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import mz0.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class PlatformPageSourceFilter extends a implements f {
    public final Lazy b;

    public final t p() {
        return (t) this.b.getValue();
    }

    @Override // mz0.f
    public final String b() {
        Intrinsics.checkNotNullParameter("from_room_id", "key");
        t r0 = this.a;
        if ((r0 instanceof t) == false) goto L9;
        Map r1 = r0.getMap();
        if (r1 != null) goto L11;
        return null;
    L11:
        return (String) r1.get("from_room_id");
    L9:
        return "";
    }

    @Override // mz0.f
    public final String getCommonParams() {
        Intrinsics.checkNotNullParameter("homepage_hot_scene", "key");
        t r0 = this.a;
        if ((r0 instanceof t) == true) goto L5;
        return "";
    L5:
        return r0.h("homepage_hot_scene");
    }

    @Override // mz0.f
    public final String d() {
        t r0 = p();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d();
    }

    @Override // mz0.f
    public final String e() {
        t r0 = p();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e();
    }

    @Override // mz0.f
    public final String f() {
        t r0 = p();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.f();
    }

    @Override // mz0.f
    public final String g() {
        t r0 = p();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.g();
    }

    @Override // mz0.f
    public final int getApplyType() {
        t r0 = p();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getApplyType();
    }

    @Override // mz0.f
    public final String getRoomTag() {
        t r0 = p();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRoomTag();
    }

    @Override // mz0.f
    public final boolean j() {
        t r0 = p();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.j();
    }

    @Override // mz0.f
    public final String k() {
        t r0 = p();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.k();
    }

    @Override // mz0.f
    public final String l() {
        t r0 = p();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.l();
    }

    @Override // mz0.f
    public final String m() {
        t r0 = p();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.m();
    }

    @Override // mz0.f
    public final boolean o() {
        t r0 = p();
        if (r0 == null) goto L7;
        r0.o();
        return false;
    L7:
        return false;
    }

    public PlatformPageSourceFilter(final o<Object> r2) {
        Intrinsics.checkNotNullParameter(r2, FileUtils.FILTER);
        super(r2);
        this.b = LazyKt.lazy(new PlatformPageSourceFilter$pageSourceFilter$2(r2));
    }
}
