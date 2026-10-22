package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import androidx.collection.LongSparseArray;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f0 implements com.bytedance.android.scope.o {
    public final com.bytedance.android.livesdk.gift.configmodel.n2 a;
    public int b;
    public int c;
    public final Map<Long, Long> d;
    public long e;
    public final int f;
    public final f1 g;
    public final o3 h;

    public static final class a implements wp2.i {
        public final WeakReference<f0> a;

        public a(WeakReference<f0> r2) {
            Intrinsics.checkNotNullParameter(r2, "serviceRef");
            this.a = r2;
        }

        public final void a(wp2.d r4) {
            f0 r0 = this.a.get();
            if (r0 != null) goto L5;
            return;
        L5:
            if (((wp2.k) r4).a == true) goto L7;
            return;
        L7:
            if ((r4 instanceof wp2.p) == false) goto L12;
            wp2.p r5 = (wp2.p) r4;
            r0.c += 0;
            return;
        }
    }

    public final void onStart() {
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void a() {
        if (this.a.c() == true) goto L6;
        return;
    L6:
        if ((System.currentTimeMillis() - this.e) >= this.f) goto L8;
        return;
    L8:
        JSONObject r1 = new JSONObject();
        JSONObject r2 = new JSONObject();
        if (this.a.e() == true) goto L11;
        this.h.a(r2);
        this.h.c(r2);
        r2.put("use_feature_center", 0);
    L12:
        r2.put("count", this.a.b());
        this.b++;
        JSONArray r3 = new JSONArray();
        Iterator<Map.Entry<Integer, LongSparseArray<com.bytedance.android.livesdk.gift.platform.core.model.o>>> r6 = this.g.c.entrySet().iterator();
    L14:
        if (r6.hasNext() == false) goto L36;
        Map.Entry<Integer, LongSparseArray<com.bytedance.android.livesdk.gift.platform.core.model.o>> r7 = r6.next();
        JSONObject r8 = new JSONObject();
        JSONArray r9 = new JSONArray();
        r8.put("tabId", r7.getKey().intValue());
        LongSparseArray<com.bytedance.android.livesdk.gift.platform.core.model.o> r10 = r7.getValue();
        int r11 = r10.size();
        if (r11 <= 0) goto L35;
        int r13 = 0;
    L18:
        if (r13 >= r11) goto L35;
        com.bytedance.android.livesdk.gift.platform.core.model.o r14 = (com.bytedance.android.livesdk.gift.platform.core.model.o) r10.valueAt(r13);
        if (r14 == null) goto L33;
        Iterator<Map.Entry<Integer, LongSparseArray<com.bytedance.android.livesdk.gift.platform.core.model.o>>> r15 = r6;
        if (this.g.e != r14.b) goto L34;
        int r5 = r14.a;
        if (r5 == 1) goto L34;
        if (r5 == 3) goto L34;
        if (r5 == 4) goto L34;
        JSONObject r16 = new JSONObject();
        r16.put("id", r14.b());
        r16.put("price", r14.d());
        r16.put("index", r14.c());
        if (r14.a() == 0) goto L32;
        r16.put("force_insert", r14.a());
    L32:
        r16.put("sort_extra", r14.e());
        r9.put(r16);
    L34:
        r13 = r13 + 1;
        r6 = r15;
        goto L18
    L33:
        r15 = r6;
    L35:
        r8.put("gifts", r9);
        r3.put(r8);
        r6 = r6;
        goto L14
    L36:
        r2.put("tabs", r3);
        r1.put("custom_feat_dict", r2);
        wp2.o r4 = new wp2.o(r1, new a(new WeakReference(this)));
        this.e = System.currentTimeMillis();
        vh6.c.b(rq2.a.class).yc(r4);
        return;
    L11:
        r2.put("use_feature_center", 1);
        goto L12
    }

    public final void onStop() {
        int r0 = this.b;
        if (r0 <= 0) goto L5;
    L6:
        Map r1 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("trigger_count", String.valueOf(r0)), TuplesKt.to("predict_count", String.valueOf(this.c))});
        String r2 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
        Intrinsics.checkNotNullParameter(r1, "param");
        mz0.n r3 = new mz0.n();
        Map r4 = r3.a;
        Intrinsics.checkNotNullParameter(r4, "map");
        Intrinsics.checkNotNullParameter(r1, "map");
        r4.putAll(r1);
        mz0.m r5 = new mz0.m();
        r5.b(LogCommon.LIVE_SHARE_LOG);
        r5.b(LogCommon.ROOM);
        com.bytedance.android.livesdk.revenue.log.i r6 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r6, "pageSourceLog");
        ((ArrayList) r5.a).add(r6.a);
        ((ArrayList) r3.b).addAll(r5.a);
        cy0.e.a.getClass();
        cy0.j r7 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r8 = com.bytedance.android.scope.m.b(r7).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r8);
        ((f80.a) r8).w3("livesdk_send_gift_predict", r3.a, r3.b);
        return;
    L5:
        if (this.c > 0) goto L6;
    }

    public f0(f1 r2, o3 r3) {
        Intrinsics.checkNotNullParameter(r2, "giftListSortService");
        Intrinsics.checkNotNullParameter(r3, "featureCenterService");
        this.g = r2;
        this.h = r3;
        this.a = (com.bytedance.android.livesdk.gift.configmodel.n2) com.bytedance.android.livesdk.gift.platform.core.h.i0.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[59]);
        this.d = new LinkedHashMap();
        this.f = 30000;
    }
}
