package com.bytedance.android.livesdk.gift.platform.business.effect.atmosphere;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.anya.BaseMVIView;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.a0;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.k;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends BaseMVIView<e, Object> {
    public final View h;
    public final FrameLayout i;
    public zy0.b j;
    public String k;
    public final Context l;

    public final void i() {
        zy0.b r0 = this.j;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        FrameLayout r1 = this.i;
        if (r1 == null) goto L9;
        r1.removeAllViews();
        return;
    }

    public final Context getContext() {
        return this.l;
    }

    public c(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.l = r3;
        View r4 = LayoutInflater.from(r3).inflate(2131565165, null);
        this.h = r4;
        this.i = (FrameLayout) r4.findViewById(2131363321);
        this.k = BuildConfig.FLAVOR;
    }

    public final boolean d(a0 r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
        if ((r3 instanceof g) == false) goto L11;
        zy0.b r0 = this.j;
        if (r0 == null) goto L12;
        xy0.a r1 = r0.g();
        if (r1 == null) goto L13;
        r1.sendJsEvent("update_activity_avatars", ((g) r3).a);
        return false;
    L13:
        return false;
    L12:
        return false;
    L11:
        return false;
    }

    public final void b(k r7, MVIState r8) {
        e r9 = (e) r8;
        Intrinsics.checkNotNullParameter(r7, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r9, "state");
        r r0 = r9.a;
        KProperty[] r1 = e.c;
        KProperty r3 = r1[0];
        r0.getClass();
        r r10 = r9.b;
        KProperty r2 = r1[1];
        r10.getClass();
        Object r4 = r7.c.a(r0);
        if (r4 == null) goto L5;
        r7.b.a.invoke(r0);
    L6:
        Object r5 = r7.c.a(r10);
        if (r5 == null) goto L9;
        r7.b.a.invoke(r10);
    L10:
        if (r4 != null) goto L12;
        if (r5 != null) goto L12;
        return;
    L12:
        if (r4 != null) goto L14;
        r4 = r0.c();
    L14:
        if (r5 != null) goto L16;
        r5 = r10.c();
    L16:
        Map r6 = (Map) r5;
        String r11 = (String) r4;
        if ((!Intrinsics.areEqual(r11, this.k)) == false) goto L52;
        zy0.b r13 = this.j;
        if (r13 == null) goto L21;
        r13.dispose();
    L21:
        this.j = null;
        this.i.removeAllViews();
        this.k = r11;
        if (r11.length() <= 0) goto L24;
        boolean r14 = true;
    L25:
        if (r14 == false) goto L61;
        ReadOnlyProperty r15 = d.b;
        KProperty[] r16 = d.a;
        if (((Boolean) r15.getValue(null, r16[0])).booleanValue() == false) goto L29;
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a r17 = com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).q8(this.l, UriProtector.parse(r11), null);
    L30:
        this.j = r17;
        if (r17 != null) goto L33;
    L42:
        zy0.b r18 = this.j;
        if (r18 == null) goto L47;
        xy0.a r19 = r18.g();
        if (r19 == null) goto L47;
        r19.load(null, r6);
    L47:
        zy0.b r20 = this.j;
        if (r20 == null) goto L62;
        xy0.a r21 = r20.g();
        if (r21 == null) goto L63;
        r21.registerMethod("activity_float_asset_lynx_page_event", b.a);
        return;
    L63:
        return;
    L62:
        return;
    L33:
        if (((Boolean) d.c.getValue(null, r16[1])).booleanValue() == true) goto L58;
    L39:
        FrameLayout r23 = this.i;
        if (r23 == null) goto L42;
        r23.addView(r17.c());
        goto L42
    L58:
        r17.x();     // Catch: Exception -> L37
    L37:
        e = move-exception;
        ALogger.e("TopEffect", "registerKryptonServices error " + e);
        e.printStackTrace();
        goto L39
    L29:
        r17 = com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).J8(this.l, UriProtector.parse(r11), null);
        goto L30
    L61:
        return;
    L24:
        r14 = false;
        goto L25
    L52:
        String r24 = GsonProtectorUtils.toJson(GsonHelper.getDefault(), r6).toString();
        zy0.b r25 = this.j;
        if (r25 == null) goto L65;
        xy0.a r26 = r25.g();
        if (r26 == null) goto L66;
        r26.sendJsEvent("update_activity_information", r24);
        return;
    L66:
        return;
    L65:
        return;
    L9:
        r5 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }
}
