package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.annie.param.UtilsKt;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.revenue.platform.hybrid.impl.ui.BaseHybridComponentContainer;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftDSNoticeState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVIDSNoticeView extends com.bytedance.android.anya.d<GiftPanelState, GiftDSNoticeState, GiftAction> {
    public zy0.b h;
    public com.bytedance.android.live.revenue.model.extension.main.b i;
    public Disposable j;
    public int k;
    public final Context l;
    public final ViewGroup m;

    public final Context getContext() {
        return this.l;
    }

    public final void a(com.bytedance.android.anya.dsl.f<GiftPanelState> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVIDSNoticeView$bindToParent$1 r0 = GiftMVIDSNoticeView$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.j(this, r0));
    }

    public GiftMVIDSNoticeView(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        this.l = r2;
        this.m = r3;
        this.k = 1;
    }

    public final void b(com.bytedance.android.anya.k r5, MVIState r6) {
        GiftDSNoticeState r7 = (GiftDSNoticeState) r6;
        Intrinsics.checkNotNullParameter(r5, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r7, "state");
        com.bytedance.android.anya.r0<GiftDSNoticeState, com.bytedance.android.live.revenue.model.extension.main.b> r0 = r7.getGiftDSNoticeInfo();
        Object r1 = r5.c.a(r0);
        if (r1 == null) goto L5;
        r5.b.a.invoke(r0);
        this.i = (com.bytedance.android.live.revenue.model.extension.main.b) r1;
    L5:
        com.bytedance.android.anya.r0<GiftDSNoticeState, Boolean> r8 = r7.getShouldShow();
        Object r2 = r5.c.a(r8);
        if (r2 == null) goto L31;
        r5.b.a.invoke(r8);
        boolean r9 = ((Boolean) r2).booleanValue();
        JsonElement r10 = GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), this.i);
        if ((r10 instanceof JsonObject) == true) goto L10;
        r10 = null;
    L10:
        JsonObject r11 = (JsonObject) r10;
        if (r11 == null) goto L14;
        Map r13 = MapsKt.toMutableMap(UtilsKt.i(r11));
        if (r13 == null) goto L14;
    L15:
        this.m.removeAllViews();
        Disposable r3 = this.j;
        if (r3 == null) goto L18;
        r3.dispose();
    L18:
        if (r9 == false) goto L32;
        this.j = com.bytedance.android.livesdk.gift.platform.core.utils.w.a("livesdk_dspanel_height_change", new GiftMVIDSNoticeView$handleDiff$$inlined$select$lambda$1(this));
        com.bytedance.android.live.revenue.model.extension.main.b r14 = this.i;
        if (r14 == null) goto L33;
        String r15 = r14.getPanelSchema();
        if (r15 == null) goto L35;
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.e r16 = com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).J8(this.l, x6.a.d(r15), GiftMVIDSNoticeView$handleDiff$2$hybridCard$1.INSTANCE);
        this.h = r16;
        if (r16 == null) goto L34;
        this.m.addView((View) ((BaseHybridComponentContainer) r16).d);
        com.bytedance.android.live.revenue.platform.hybrid.impl.component.b r17 = r16.g();
        if (r17 == null) goto L29;
        r13.put("event_page", "gift");
        r13.put("first_open", Integer.valueOf(this.k));
        Unit r4 = Unit.INSTANCE;
        r17.load(null, r13);
    L29:
        this.k = 0;
        return;
    L34:
        return;
    L35:
        return;
    L33:
        return;
    L32:
        return;
    L14:
        r13 = new LinkedHashMap();
        goto L15
    }
}
