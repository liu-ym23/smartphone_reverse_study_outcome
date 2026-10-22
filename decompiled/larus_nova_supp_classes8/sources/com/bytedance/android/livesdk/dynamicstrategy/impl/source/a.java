package com.bytedance.android.livesdk.dynamicstrategy.impl.source;

import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.a0;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.google.gson.annotations.SerializedName;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import ku1.h;
import lu1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static boolean a;
    public static List<? extends a0> b;
    public static final a c = null;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.dynamicstrategy.impl.source.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\b\u0018\u00002\u00020\u0001R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/dynamicstrategy/impl/source/a$a;", "", "", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/entity/a0;", "strategy", "Ljava/util/List;", "a", "()Ljava/util/List;", "dynamicstrategy-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class C0307a {

        @SerializedName("strategy")
        private final List<a0> strategy;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof C0307a) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.strategy, ((C0307a) r2).strategy) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            List<a0> r0 = this.strategy;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "StrategyData(strategy=" + this.strategy + ")";
        }

        public final List<a0> a() {
            return this.strategy;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C0307a(List<? extends a0> r2) {
            Intrinsics.checkNotNullParameter(r2, "strategy");
            this.strategy = r2;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ List b;

        public b(String r1, List r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean r0 = a.a;     // Catch: Throwable -> L4
            a.b(this.a, this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public a() {
    }

    static {
        c = new a();
        b = CollectionsKt.emptyList();
    }

    public static List a() {
        if (a == true) goto L15;
        String r0 = SharedPrefHelper.c(s1.getContext(), "live_dynamic_strategy_data").j("strategy_data", "");
        if (TextUtils.isEmpty(r0) == false) goto L13;
        C0307a r1 = new C0307a(CollectionsKt.emptyList());
    L11:
        List<a0> r2 = r1.a();
        b = r2;
        a = true;
        return r2;
    L13:
        r1 = (C0307a) GsonHelper.get().fromJson(r0, C0307a.class);     // Catch: Exception -> L10
    L10:
        r1 = new C0307a(CollectionsKt.emptyList());
        goto L11
    L15:
        return b;
    }

    public static void b(String r5, List r6) {
        SharedPrefHelper r0 = SharedPrefHelper.c(s1.getContext(), "live_dynamic_strategy_data");
        String r1 = GsonHelper.get().toJson(new C0307a(r6));     // Catch: Exception -> L5
    L6:
        r0.l("strategy_data", r1);
        r0.a();
        SharedPrefHelper r2 = SharedPrefHelper.c(s1.getContext(), "live_dynamic_strategy_info");
        r2.l("strategy_version", r5);
        r2.a();
        int r3 = k.a;
        ArrayList r4 = new ArrayList();
        Iterator r7 = r6.iterator();
    L8:
        if (r7.hasNext() == false) goto L12;
        String r8 = ((a0) r7.next()).strategyName;
        if (r8 == null) goto L8;
        r4.add(r8);
        goto L8
    L12:
        List r9 = CollectionsKt.toList(r4);
        Intrinsics.checkNotNullParameter(r5, "version");
        Intrinsics.checkNotNullParameter(r9, "strategy");
        k.g("DynamicStrategy_memory_cache", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("action", "update"), TuplesKt.to("version", r5), TuplesKt.to("strategy", r9)}));
        return;
    L5:
        r1 = "";
        goto L6
    }

    public final void update(String r7, List<? extends a0> r8) {
        Intrinsics.checkNotNullParameter(r7, "newVersion");
        Intrinsics.checkNotNullParameter(r8, "newStrategyList");
        if (((Boolean) h.a.getValue()).booleanValue() == false) goto L5;
        Schedulers.io().scheduleDirect(new b(r7, r8));
    L6:
        b = r8;
        a = true;
        int r1 = k.a;
        ArrayList r2 = new ArrayList();
        Iterator<T> r9 = r8.iterator();
    L8:
        if (r9.hasNext() == false) goto L12;
        String r3 = ((a0) r9.next()).strategyName;
        if (r3 == null) goto L8;
        r2.add(r3);
        goto L8
    L12:
        List r10 = CollectionsKt.toList(r2);
        Intrinsics.checkNotNullParameter(r7, "version");
        Intrinsics.checkNotNullParameter(r10, "strategy");
        k.g("DynamicStrategy_memory_cache", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("action", "update"), TuplesKt.to("version", r7), TuplesKt.to("strategy", r10)}));
        return;
    L5:
        b(r7, r8);
        goto L6
    }
}
