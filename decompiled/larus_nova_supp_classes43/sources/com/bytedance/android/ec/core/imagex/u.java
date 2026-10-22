package com.bytedance.android.ec.core.imagex;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.SystemClock;
import android.view.View;
import androidx.collection.LruCache;
import com.facebook.imagepipeline.common.ResizeOptions;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class u extends r {
    public static final /* synthetic */ int G = 0;
    public com.bytedance.android.shopping.api.image.q A;
    public String B;
    public String C;
    public String D;
    public String E;
    public volatile boolean F;
    public boolean i;
    public Point j;
    public ResizeOptions k;
    public Integer l;
    public boolean m;
    public boolean n;
    public String o;
    public Boolean p;
    public long q;
    public long r;
    public long s;
    public long t;
    public long u;
    public long v;
    public long w;
    public long x;
    public final LruCache<String, f> y;
    public com.bytedance.android.shopping.api.image.r z;

    public final void k() {
        long r0 = this.r;
        if (r0 > 0) goto L5;
        return;
    L5:
        long r10 = this.s;
        if (r10 <= 0) goto L8;
        this.r = r0 + r10;
        this.s = -1;
    L8:
        Long r1 = Long.valueOf(System.nanoTime() - this.r);
        if (r1.longValue() <= 0) goto L11;
        boolean r11 = true;
    L12:
        if (r11 == true) goto L15;
        r1 = null;
    L15:
        if (r1 == null) goto L17;
        f("ec_local_duration", Double.valueOf(r1.longValue() / ((double) 1000000.0f)));
    L17:
        this.r = -1;
        return;
    L11:
        r11 = false;
        goto L12
    }

    public final com.bytedance.android.shopping.api.image.q n() {
        com.bytedance.android.shopping.api.image.r r0 = this.z;
        if ((r0 instanceof com.bytedance.android.shopping.api.image.q) == true) goto L6;
        r0 = null;
    L6:
        return (com.bytedance.android.shopping.api.image.q) r0;
    }

    public final String p() {
        String r0 = this.D;
        if (r0 != null) goto L9;
        com.bytedance.android.shopping.api.image.r r1 = this.z;
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.getOriginUrl();
    L9:
        return r0;
    }

    public final long s() {
        ResizeOptions r0 = this.k;
        int r1 = 0;
        if (r0 != null) goto L12;
        Point r10 = this.j;
        if (r10 == null) goto L11;
        if (r10 == null) goto L8;
        int r11 = r10.x;
    L9:
        if (r10 == null) goto L18;
        r1 = r10.y;
    L18:
        return r11 * r1;
    L8:
        r11 = 0;
        goto L9
    L11:
        return 0;
    L12:
        if (r0 == null) goto L14;
        r11 = r0.width;
    L15:
        if (r0 == null) goto L18;
        r1 = r0.height;
        goto L18
    L14:
        r11 = 0;
        goto L15
    }

    public final String t() {
        Integer r10 = null;
        if (this.k == null) goto L5;
        StringBuilder r0 = new StringBuilder();
        ResizeOptions r11 = this.k;
        if (r11 == null) goto L18;
        Integer r12 = Integer.valueOf(r11.width);
    L19:
        r0.append(String.valueOf(r12));
        r0.append("x");
        ResizeOptions r1 = this.k;
        if (r1 == null) goto L22;
        r10 = Integer.valueOf(r1.height);
    L22:
        r0.append(String.valueOf(r10));
        return r0.toString();
    L18:
        r12 = null;
        goto L19
    L5:
        if (this.j == null) goto L14;
        StringBuilder r13 = new StringBuilder();
        Point r14 = this.j;
        if (r14 == null) goto L9;
        Integer r15 = Integer.valueOf(r14.x);
    L10:
        r13.append(String.valueOf(r15));
        r13.append("x");
        Point r16 = this.j;
        if (r16 == null) goto L13;
        r10 = Integer.valueOf(r16.y);
    L13:
        r13.append(String.valueOf(r10));
        return r13.toString();
    L9:
        r15 = null;
        goto L10
    L14:
        return "";
    }

    public final void y() {
        i("ec_local_duration");
        i("ec_local_duration_request");
        i("ec_local_duration_url_parser");
        i("ec_local_duration_url_edit");
        i("ec_local_duration_url_transform");
        i("ec_local_duration_url_build");
        i("ec_local_duration_url_query_build");
        i("ec_local_duration_url_find_cache");
        i("ec_local_duration_async_build_init");
        i("ec_local_duration_async_context_init");
        i("ec_local_duration_load_controller_before");
        i("ec_local_duration_load_controller_build");
        i("ec_local_duration_load_controller");
        i("ec_local_duration_request_core_build");
        i("ec_local_duration_request_secondary_build");
    }

    public final void B() {
        y();
        this.q = SystemClock.elapsedRealtime();
        this.r = System.nanoTime();
    }

    public final void z() {
        long r0 = System.nanoTime();
        long r10 = this.u;
        long r11 = this.v;
        if (r10 <= r11) goto L6;
    L18:
        this.t = -1;
        this.u = -1;
        this.v = -1;
        this.w = -1;
        this.x = -1;
        return;
    L6:
        if (r0 < r11) goto L18;
        long r12 = this.t;
        if (r10 < r12) goto L18;
        Long r1 = Long.valueOf((r0 - r11) + (r10 - r12));
        if (r1.longValue() <= 0) goto L12;
        boolean r13 = true;
    L13:
        if (r13 == true) goto L16;
        r1 = null;
    L16:
        if (r1 == null) goto L18;
        f("ec_local_duration", Double.valueOf(r1.longValue() / ((double) 1000000.0f)));
        goto L18
    L12:
        r13 = false;
        goto L13
    }

    public final String l() {
        return this.E;
    }

    public final com.bytedance.android.shopping.api.image.r m() {
        return this.z;
    }

    public final String o() {
        return this.o;
    }

    public final Integer q() {
        return this.l;
    }

    public final long r() {
        return this.q;
    }

    public final Point u() {
        return this.j;
    }

    public final Boolean v() {
        return this.p;
    }

    public final boolean w() {
        return this.i;
    }

    public final boolean x() {
        return this.m;
    }

    public u(r r10) {
        Intrinsics.checkNotNullParameter(r10, "internal");
        String r0 = r10.f;
        String r1 = r10.g;
        WeakReference<Function0<Map<String, Object>>> r11 = r10.e;
        if (r11 == null) goto L5;
        Function0<Map<String, Object>> r12 = r11.get();
    L6:
        super(r0, r1, r12);
        LinkedHashMap r13 = new LinkedHashMap();
        r13.putAll(r10.c);
        Unit r14 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        this.c = r13;
        LinkedHashMap r15 = new LinkedHashMap();
        r15.putAll(r10.d);
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        this.d = r15;
        this.a = r10.a;
        this.b = r10.b;
        this.q = Long.MAX_VALUE;
        this.r = -1;
        this.s = -1;
        this.t = -1;
        this.u = -1;
        this.v = -1;
        this.w = -1;
        this.x = -1;
        this.y = new LruCache(3);
        return;
    L5:
        r12 = null;
        goto L6
    }

    public final void A(Context r10) {
        String r0 = this.a;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        return;
    L11:
        if (r10 == null) goto L16;
        Activity r11 = com.bytedance.android.ec.core.utils.l0.b(r10);
        if (r11 == null) goto L17;
        this.a = r11.getClass().getName();
        return;
    L17:
        return;
    L16:
        return;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    public final void C(ResizeOptions r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.width > 0) goto L6;
        return;
    L6:
        if (r10.height <= 0) goto L11;
        this.k = r10;
        return;
    }

    public final void D(View r10) {
        Intrinsics.checkNotNullParameter(r10, "genericDraweeView");
        if (r10.getWidth() > 0) goto L5;
        return;
    L5:
        if (r10.getHeight() <= 0) goto L9;
        this.j = new Point(r10.getWidth(), r10.getHeight());
        return;
    }

    public final boolean j(Uri r10) {
        com.bytedance.android.shopping.api.image.r r0 = this.z;
        String r1 = null;
        if (r0 == null) goto L8;
        if (r0 == null) goto L7;
        r1 = r0.c();
    L7:
        return Intrinsics.areEqual("ecom-shop-material", r1);
    L8:
        if (r10 == null) goto L11;
        String r11 = r10.getPath();
        if (r11 == null) goto L11;
    L13:
        if (r11 != null) goto L15;
        return false;
    L15:
        if (StringsKt.contains$default(r11, "/ecom-shop-material/", false, 2, null) != true) goto L19;
        return true;
    L19:
        return false;
    L11:
        r11 = p();
        goto L13
    }
}
