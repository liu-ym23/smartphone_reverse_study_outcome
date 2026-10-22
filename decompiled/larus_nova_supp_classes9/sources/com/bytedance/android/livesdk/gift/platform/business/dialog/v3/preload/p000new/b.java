package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.GiftPanelPreloadView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public final ConcurrentHashMap<GiftPanelPreloadView, LinkedList<View>> a;
    public final Map<Integer, GiftPanelPreloadView> b;
    public final Context c;

    public final class a {
        public final LayoutInflater a;
        public final FrameLayout b;
        public final List<Pair<GiftPanelPreloadView, Integer>> c;
        public final /* synthetic */ b d;

        public final void b() {
            Iterator r0 = ((ArrayList) this.c).iterator();
        L4:
            if (r0.hasNext() == false) goto L24;
            Pair r1 = (Pair) r0.next();
            GiftPanelPreloadView r2 = (GiftPanelPreloadView) r1.component1();
            int r3 = ((Number) r1.component2()).intValue();
            b r4 = this.d;
            r4.getClass();
            Intrinsics.checkNotNullParameter(r2, "viewInfo");
            LinkedList<View> r5 = r4.a.get(r2);
            if (r5 == null) goto L8;
            int r6 = r5.size();
        L10:
            if (r6 >= r2.getMaxCount()) goto L4;
            int r7 = Math.min(r3, r2.getMaxCount() - r6);
            int r8 = 1;
            if (1 > r7) goto L4;
        L15:
            if (r2.getHasParent() == false) goto L17;
            FrameLayout r9 = this.b;
        L25:
            c(r2, this.a.inflate(r2.getLayoutId(), r9, false));     // Catch: Exception -> L20
        L22:
            if (r8 == r7) goto L4;
            r8 = r8 + 1;
        L20:
            e = move-exception;
            jy0.b.b("ttlive_gift_preload_new", "inflate view for " + r2 + " failed", e);
            goto L22
        L17:
            r9 = null;
            goto L25
        L8:
            r6 = 0;
            goto L10
        }

        public a(b r3) {
            this.d = r3;
            this.a = LayoutInflater.from(r3.getContext()).cloneInContext(r3.getContext());
            this.b = new FrameLayout(r3.getContext());
            this.c = new ArrayList();
        }

        public final void a(GiftPanelPreloadView r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "target");
            List<Pair<GiftPanelPreloadView, Integer>> r0 = this.c;
            ArrayList r1 = (ArrayList) r0;
            r1.add(TuplesKt.to(r2, Integer.valueOf(r3)));
        }

        public final void c(GiftPanelPreloadView r4, View r5) {
            LinkedList<View> r0 = this.d.a.get(r4);
            if (r0 != null) goto L5;
            ConcurrentHashMap<GiftPanelPreloadView, LinkedList<View>> r1 = this.d.a;
            LinkedList<View> r2 = new LinkedList();
            r2.offer(r5);
            Unit r6 = Unit.INSTANCE;
            r1.put(r4, r2);
            return;
        L5:
            if (r0.size() < r4.getMaxCount()) goto L7;
            jy0.b.d("ttlive_gift_preload_new", r4 + " cache is full, count=" + r0.size());
            return;
        L7:
            r0.add(r5);
        }
    }

    public final Context getContext() {
        return this.c;
    }

    public b(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        this.c = r6;
        this.a = new ConcurrentHashMap();
        GiftPanelPreloadView[] r7 = GiftPanelPreloadView.values();
        LinkedHashMap r1 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r7.length), 16));
        int r0 = r7.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        GiftPanelPreloadView r3 = r7[r2];
        r1.put(Integer.valueOf(r3.getLayoutId()), r3);
        r2 = r2 + 1;
        goto L3
    L5:
        this.b = r1;
    }
}
