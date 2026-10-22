package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.browser.GsonMap;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.browser.UtilsKt;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.feed.drawerfeed.LynxScrollLayout;
import com.bytedance.android.livesdk.feed.drawerfeed.widget.FixedRatioRelativeLayout;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/feed/drawerfeed/viewholder/DrawerLynxViewHolder;", "Lcom/bytedance/android/live/core/viewholder/BaseViewHolder;", "Lcom/bytedance/android/live/base/model/feed/FeedItem;", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class DrawerLynxViewHolder extends BaseViewHolder<FeedItem> {
    public HybridCard a;
    public final FixedRatioRelativeLayout b;
    public final ViewGroup c;
    public final View d;
    public FeedItem e;
    public final LynxScrollLayout f;
    public final ViewGroup g;
    public final View h;

    public abstract float T3();

    public abstract int U3();

    public abstract Object V3();

    public abstract String W3();

    public abstract String X3();

    public abstract ViewGroup Z3();

    public abstract String a4();

    public abstract String b4();

    public final JsonObject Y3() {
        JsonElement r0 = GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), V3());
        if ((r0 instanceof JsonObject) == true) goto L6;
        r0 = null;
    L6:
        return (JsonObject) r0;
    }

    public final void onViewAttachedToWindow() {
        super.onViewAttachedToWindow();
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L7
        r0.put("visible", true);     // Catch: JSONException -> L7
        HybridCard r1 = this.a;     // Catch: JSONException -> L7
        if (r1 == null) goto L12;
        r1.sendJsEvent("H5_visibilityChange", r0);     // Catch: JSONException -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        ALogger.e(a4(), "onViewAttachedToWindow" + e.toString());
    }

    public final void onViewDetachedFromWindow() {
        super.onViewDetachedFromWindow();
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L7
        r0.put("visible", false);     // Catch: JSONException -> L7
        HybridCard r1 = this.a;     // Catch: JSONException -> L7
        if (r1 == null) goto L12;
        r1.sendJsEvent("H5_visibilityChange", r0);     // Catch: JSONException -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        ALogger.e(a4(), "onViewDetachedFromWindow" + e.toString());
    }

    public DrawerLynxViewHolder(ViewGroup r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        Intrinsics.checkNotNullParameter(r3, "holderItemView");
        super(r3);
        this.g = r2;
        this.h = r3;
        FixedRatioRelativeLayout r4 = (FixedRatioRelativeLayout) r3.findViewById(2131367728);
        this.b = r4;
        this.c = (ViewGroup) r3.findViewById(2131379281);
        this.d = r3.findViewById(2131379289);
        this.f = (LynxScrollLayout) r3.findViewById(2131379300);
        if (r4 == null) goto L6;
        r4.setRatio(T3());
        return;
    }

    public final void bind(Object r8, int r9) {
        this.e = (FeedItem) r8;
        FixedRatioRelativeLayout r10 = this.b;
        if (r10 == null) goto L10;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        int r0 = (int) (U3() / T3());
        if (r11.width == U3()) goto L7;
    L9:
        r11.width = U3();
        r11.height = r0;
        r10.setLayoutParams(r11);
        goto L10
    L7:
        if (r11.height != r0) goto L9;
    L10:
        HybridCard r12 = this.a;
        GsonMap r13 = null;
        if (r12 == null) goto L16;
        Pair[] r1 = new Pair[1];
        String r2 = W3();
        JsonObject r3 = Y3();
        if (r3 == null) goto L15;
        r13 = UtilsKt.i(r3);
    L15:
        r1[0] = TuplesKt.to(r2, r13);
        r12.updateData(MapsKt.hashMapOf(r1));
        return;
    L16:
        String r14 = b4();
        String r4 = X3() + "?initialProps=%5B%22operation_banner%22%5D";
        jc1.k.n(IBrowserService.class).registerOrNotifyState(new com.bytedance.android.live.browser.jsbridge.i.e.e.b(W3()), Y3());
        Uri r15 = x6.a.d(r14).buildUpon().appendQueryParameter("fallback_url", r4).build();
        if (r15 == null) goto L28;
        IBrowserService r5 = jc1.k.n(IBrowserService.class);
        Context r6 = this.g.getContext();
        v r7 = new v(this);
        Bundle r16 = new Bundle();
        r16.putInt("create_view_sync", 1);
        Unit r17 = Unit.INSTANCE;
        HybridCard r18 = r5.getHybridCard(r6, r15, r7, r16);
        if (r18 == null) goto L29;
        this.a = r18;
        String r19 = b4();
        Pair[] r20 = new Pair[1];
        String r21 = W3();
        JsonObject r22 = Y3();
        if (r22 == null) goto L23;
        r13 = UtilsKt.i(r22);
    L23:
        r20[0] = TuplesKt.to(r21, r13);
        r18.load(r19, MapsKt.hashMapOf(r20));
        r18.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        ViewGroup r23 = Z3();
        if (r23 == null) goto L30;
        r23.addView(r18);
        return;
    L30:
        return;
    L29:
        return;
    }
}
