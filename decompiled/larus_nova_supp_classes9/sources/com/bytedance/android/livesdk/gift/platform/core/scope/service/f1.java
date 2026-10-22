package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import android.text.TextUtils;
import androidx.collection.LongSparseArray;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f1 implements com.bytedance.android.scope.o {
    public final com.bytedance.android.livesdk.gift.configmodel.e2 a;
    public final int b;
    public final ConcurrentHashMap<Integer, LongSparseArray<com.bytedance.android.livesdk.gift.platform.core.model.o>> c;
    public final LongSparseArray<Integer> d;
    public long e;
    public final String f;
    public final List<com.bytedance.android.livesdk.gift.model.a2> g;
    public final Set<Long> h;
    public final List<Integer> i;
    public final yz0.k j;
    public final b2 k;

    public static final class a {
    }

    public static final class b implements wp2.l {
        public b() {
        }
    }

    static {
    }

    public final String d() {
        LinkedHashSet r0 = new LinkedHashSet();
        List<com.bytedance.android.livesdk.gift.model.a2> r1 = this.g;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r2.add(((com.bytedance.android.livesdk.gift.model.a2) r3.next()).getScene());
        goto L4
    L6:
        r0.addAll(r2);
        if (r0.isEmpty() == false) goto L10;
        return null;
    L10:
        return TextUtils.join("-", r0);
    }

    public final void onStart() {
        if (this.a.b() == true) goto L5;
        return;
    L5:
        vh6.c.b(rq2.a.class).tc(new b());
    }

    public final void onStop() {
        if (this.a.b() == true) goto L5;
        return;
    L5:
        vh6.c.b(rq2.a.class).removeGiftAsyncSortCallback();
    }

    public final String c(long r6) {
        LinkedHashSet r0 = new LinkedHashSet();
        Iterator<T> r1 = this.g.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        com.bytedance.android.livesdk.gift.model.a2 r2 = (com.bytedance.android.livesdk.gift.model.a2) r1.next();
        if (r2.getEffectedGiftIds().contains(Long.valueOf(r6)) == false) goto L4;
        r0.add(r2.getScene());
        goto L4
    L9:
        if (r0.isEmpty() == false) goto L12;
        return null;
    L12:
        return TextUtils.join("-", r0);
    }

    public final boolean f(long r4) {
        Iterator<T> r0 = this.g.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (((com.bytedance.android.livesdk.gift.model.a2) r0.next()).getEffectedGiftIds().contains(Long.valueOf(r4)) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public final void g(List<? extends com.bytedance.android.livesdk.gift.model.a2> r5) {
        Intrinsics.checkNotNullParameter(r5, "giftSortStrategyList");
        JSONObject r0 = new JSONObject();
        r0.putOpt("version", 2);     // Catch: JSONException -> L6
        r0.putOpt("room_id", Long.valueOf(this.j.getRoom().getRoomId()));     // Catch: JSONException -> L6
        r0.putOpt("gift_sort_strategy", new JSONArray(GsonProtectorUtils.toJson(GsonHelper.get(), r5)));     // Catch: JSONException -> L6
    L4:
        vh6.c.b(rq2.a.class).triggerGiftAsyncSort(r0);
    }

    public f1(yz0.k r2, b2 r3) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        Intrinsics.checkNotNullParameter(r3, "giftRecommendLogService");
        this.j = r2;
        this.k = r3;
        com.bytedance.android.livesdk.gift.configmodel.e2 r4 = (com.bytedance.android.livesdk.gift.configmodel.e2) com.bytedance.android.livesdk.gift.platform.core.h.h0.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[58]);
        this.a = r4;
        this.b = r4.a();
        this.c = new ConcurrentHashMap();
        this.d = new LongSparseArray();
        this.f = BuildConfig.FLAVOR;
        this.g = new ArrayList();
        this.h = new LinkedHashSet();
        this.i = new ArrayList();
    }

    public final String a(int r2, long r3) {
        LongSparseArray<com.bytedance.android.livesdk.gift.platform.core.model.o> r4 = this.c.get(Integer.valueOf(r2));
        if (r4 == null) goto L7;
        com.bytedance.android.livesdk.gift.platform.core.model.o r5 = (com.bytedance.android.livesdk.gift.platform.core.model.o) r4.get(r3);
        if (r5 == null) goto L7;
        return r5.e();
    L7:
        return null;
    }
}
