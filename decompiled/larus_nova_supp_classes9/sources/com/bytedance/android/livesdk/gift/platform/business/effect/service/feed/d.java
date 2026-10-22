package com.bytedance.android.livesdk.gift.platform.business.effect.service.feed;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.gift.platform.business.effect.giftview.GiftEffectInfoDraggableView;
import com.bytedance.android.livesdk.gift.platform.business.effect.giftview.GiftEffectInfoFullScreenView;
import com.bytedance.android.livesdkapi.feed.IPreviewMultiLinkEffectService;
import com.bytedance.android.scope.o;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements o {
    public final Map<String, zy0.b> a;
    public final Map<String, GiftEffectInfoFullScreenView> b;
    public final Map<String, GiftEffectInfoDraggableView> c;
    public final IPreviewMultiLinkEffectService d;
    public final e e;
    public final vh6.b f;

    public static final class a {
    }

    static {
    }

    public final void onStart() {
    }

    public final void onStop() {
        Iterator r0 = ((LinkedHashMap) this.a).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        zy0.b r1 = (zy0.b) ((Map.Entry) r0.next()).getValue();
        if (r1 == null) goto L4;
        r1.dispose();
        goto L4
    L8:
        ((LinkedHashMap) this.a).clear();
        Iterator r2 = ((LinkedHashMap) this.b).values().iterator();
    L10:
        if (r2.hasNext() == false) goto L12;
        GiftEffectInfoFullScreenView r3 = (GiftEffectInfoFullScreenView) r2.next();
        f(r3);
        r3.removeAllViews();
        goto L10
    L12:
        Iterator r4 = ((LinkedHashMap) this.c).values().iterator();
    L14:
        if (r4.hasNext() == false) goto L16;
        GiftEffectInfoDraggableView r5 = (GiftEffectInfoDraggableView) r4.next();
        f(r5);
        r5.removeAllViews();
        goto L14
    L16:
        ((LinkedHashMap) this.b).clear();
        ((LinkedHashMap) this.c).clear();
    }

    public final void d(String r2) {
        zy0.b r0 = (zy0.b) ((LinkedHashMap) this.a).get(r2);
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.a.remove(r2);
    }

    public final void f(View r1) {
        this.d.removeEffectView();
    }

    public d(IPreviewMultiLinkEffectService r2, e r3, vh6.b r4) {
        Intrinsics.checkNotNullParameter(r2, "multiLinKEffectService");
        Intrinsics.checkNotNullParameter(r3, "effectServiceContainer");
        Intrinsics.checkNotNullParameter(r4, "dependencyResolver");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
    }

    public final void c(String r5, ViewGroup r6, String r7) {
        if (((LinkedHashMap) this.a).get(r7) == null) goto L5;
        d(r7);
    L5:
        Context r0 = (Context) this.f.a(com.bytedance.android.live.revenue.core.d.a);
        if (r0 != null) goto L8;
        return;
    L8:
        vy0.c r1 = com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class);
        Intrinsics.checkNotNullParameter(r5, "$this$toUri");
        zy0.b r8 = r1.q8(r0, UriProtector.parse(r5), null);
        if (r8 == null) goto L21;
        r8.x();     // Catch: Exception -> L12
    L14:
        r6.addView(((com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a) r8).c);
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a.b r9 = ((com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a) r8).d;
        if (r9 == null) goto L17;
        r9.load(null, null);
    L17:
        this.a.put(r7, r8);
        return;
    L12:
        e = move-exception;
        ALogger.e("GiftEffectFeedScopeService", "registerKryptonServices error " + e);
        e.printStackTrace();
        goto L14
    }

    public final void a(int r15, int r16, boolean r17, String r18, boolean r19, String r20, String r21) {
        Intrinsics.checkNotNullParameter(r18, "schema");
        e r13 = this.e;
        com.bytedance.android.livesdk.gift.platform.business.effect.service.feed.a r14 = new com.bytedance.android.livesdk.gift.platform.business.effect.service.feed.a(r15, r16, r17, r18, r19, r20, r21);
        r13.getClass();
        Intrinsics.checkNotNullParameter(r14, "effectRequestParam");
        if (r13.c == true) goto L6;
        ((ArrayList) r13.d).add(r14);
    L6:
        if (r13.c == true) goto L8;
        return;
    L8:
        String r1 = "default";
        if (r15 == 1) goto L11;
        if (r15 != 0) goto L54;
        if (r20 == null) goto L38;
        r1 = r20;
    L38:
        if (r16 == 0) goto L47;
        if (r16 == 1) goto L42;
        return;
    L42:
        if (((LinkedHashMap) this.c).get(r1) == null) goto L55;
        d(r1);
        View r2 = (GiftEffectInfoDraggableView) this.c.remove(r1);
        if (r2 == null) goto L56;
        f(r2);
        return;
    L56:
        return;
    L55:
        return;
    L47:
        if (((LinkedHashMap) this.b).get(r1) == null) goto L58;
        d(r1);
        View r3 = (GiftEffectInfoFullScreenView) this.b.remove(r1);
        if (r3 == null) goto L59;
        f(r3);
        return;
    L59:
        return;
    L58:
        return;
    L54:
        return;
    L11:
        if (r16 == 0) goto L24;
        if (r16 != 1) goto L60;
        if (r20 == null) goto L17;
        r1 = r20;
    L17:
        View r4 = (GiftEffectInfoDraggableView) ((LinkedHashMap) this.c).get(r1);
        if (r4 == null) goto L20;
        f(r4);
    L20:
        Context r5 = (Context) this.f.a(com.bytedance.android.live.revenue.core.d.a);
        if (r5 == null) goto L61;
        GiftEffectInfoDraggableView r6 = new GiftEffectInfoDraggableView(r5, null, 6, 0);
        ConstraintLayout.LayoutParams r7 = new ConstraintLayout.LayoutParams(-2, -2);
        int r8 = s1.f(0.0f);
        ((ViewGroup.MarginLayoutParams) r7).topMargin = r8;
        r6.setLayoutParams(r7);
        r6.setDraggable(r17);
        r6.setTopMarginPx(r8);
        this.c.put(r1, r6);
        this.d.insertEffectView(r6, 0);
        c(r18, r6, r1);
        return;
    L61:
        return;
    L60:
        return;
    L24:
        if (r20 == null) goto L27;
        r1 = r20;
    L27:
        View r9 = (GiftEffectInfoFullScreenView) ((LinkedHashMap) this.b).get(r1);
        if (r9 == null) goto L30;
        f(r9);
    L30:
        Context r10 = (Context) this.f.a(com.bytedance.android.live.revenue.core.d.a);
        if (r10 == null) goto L62;
        GiftEffectInfoFullScreenView r11 = new GiftEffectInfoFullScreenView(r10, null, 6, 0);
        r11.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        r11.setTouchable(r19);
        this.b.put(r1, r11);
        this.d.insertEffectView(r11, 0);
        c(r18, r11, r1);
        return;
    }
}
