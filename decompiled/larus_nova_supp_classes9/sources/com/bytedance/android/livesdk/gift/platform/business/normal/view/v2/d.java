package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.android.livesdk.gift.platform.core.utils.GiftNitaViewInfo;
import com.bytedance.ies.sdk.widgets.inflater.AsyncLayoutInflater;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements com.bytedance.android.scope.o {
    public final fy1.a a;
    public boolean b;
    public AsyncLayoutInflater c;
    public Typeface d;
    public final HashMap<GiftNitaViewInfo, ArrayList<View>> e;
    public final Context f;

    public static final class a {
    }

    public static final class b implements androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener {
        public final /* synthetic */ d a;
        public final /* synthetic */ GiftNitaViewInfo b;

        public b(d r1, GiftNitaViewInfo r2) {
            this.a = r1;
            this.b = r2;
        }

        public final /* synthetic */ void onCancel(int r1) {
            androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener.-CC.$default$onCancel(this, r1);
        }

        public final void onInflateFinished(View r5, int r6, ViewGroup r7) {
            Intrinsics.checkNotNullParameter(r5, "view");
            d r8 = this.a;
            if (r8.b == true) goto L6;
            jy0.b.c("GiftTrayPreInflateService", "service not alive", null, 4);
            return;
        L6:
            ArrayList<View> r9 = r8.e.get(this.b);
            if (r9 != null) goto L9;
            return;
        L9:
            if (r9.size() >= 2) goto L11;
            r9.add(r5);
            jy0.b.c("GiftTrayPreInflateService", "async inflate success " + this.b, null, 4);
            return;
        L11:
            jy0.b.c("GiftTrayPreInflateService", "async inflate success but cache is already full: " + this.b, null, 4);
        }
    }

    static {
    }

    public final void onStart() {
        this.b = true;
        this.c = new AsyncLayoutInflater(this.f);
        this.e.put(GiftNitaViewInfo.TTLIVE_VIEW_GIFT_NORMAL_V3, new ArrayList());
        this.e.put(GiftNitaViewInfo.TTLIVE_VIEW_GIFT_NORMAL_V3_PK, new ArrayList());
        this.e.put(GiftNitaViewInfo.TTLIVE_VIEW_GIFT_NORMAL_V2_LANDSCAPE_SPLIT, new ArrayList());
        jy0.b.c("GiftTrayPreInflateService", "jank opt config: " + this.a, null, 4);
    }

    public final void onStop() {
        this.e.clear();
        this.d = null;
        this.b = false;
    }

    public d(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.f = r3;
        this.a = (fy1.a) com.bytedance.android.livesdk.gift.platform.business.e.d.getValue(null, com.bytedance.android.livesdk.gift.platform.business.e.a[2]);
        this.e = new HashMap();
    }

    public final Typeface a(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Typeface r0 = this.d;
        if (r0 == null) goto L11;
        return r0;
    L11:
        this.d = Typeface.createFromAsset(r4.getAssets(), "font/ttlive_base_gift_combo_opt_font.ttf");     // Catch: Exception -> L7
    L10:
        return this.d;
    L7:
        e = move-exception;
        e.printStackTrace();
        jy0.b.c("GiftTrayPreInflateService", "load font asset exception: " + e.getMessage(), null, 4);
        goto L10
    }

    public final void d(GiftNitaViewInfo r6) {
        Intrinsics.checkNotNullParameter(r6, "viewInfo");
        ArrayList<View> r0 = this.e.get(r6);
        if (r0 != null) goto L7;
        jy0.b.c("GiftTrayPreInflateService", "unsupported type: " + r6, null, 4);
        return;
    L7:
        if (r0.size() < 2) goto L10;
        jy0.b.c("GiftTrayPreInflateService", "cache is already full: " + r6, null, 4);
        return;
    L10:
        AsyncLayoutInflater r1 = this.c;
        if (r1 == null) goto L14;
        r1.inflate(r6.getResId(), new LinearLayout(this.f), new b(this, r6));
        return;
    }

    public final void c(ViewGroup r4, GiftNitaViewInfo r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "viewInfo");
        ArrayList<View> r0 = this.e.get(r5);
        if (r0 != null) goto L5;
    L8:
        jy0.b.c("initTrayView no cache, do normal inflate", null, null, 6);
        LayoutInflater.from(r4.getContext()).inflate(r5.getResId(), r4);
        return;
    L5:
        if ((!r0.isEmpty()) != true) goto L8;
        r4.addView((View) ListProtector.remove(r0, 0));
    }
}
