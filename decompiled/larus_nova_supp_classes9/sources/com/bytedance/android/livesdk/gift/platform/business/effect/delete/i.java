package com.bytedance.android.livesdk.gift.platform.business.effect.delete;

import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i implements SingleOnSubscribe<Map<String, ? extends List<? extends v>>> {
    public final /* synthetic */ LRUCleanStrategy a;
    public final /* synthetic */ Map b;
    public final /* synthetic */ List c;
    public final /* synthetic */ CleanOpportunity d;

    public static final class a<T> implements Comparator<T> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((v) r3).i3()), Long.valueOf(((v) r4).i3()));
        }
    }

    public final void subscribe(SingleEmitter<Map<String, List<v>>> r26) {
        Intrinsics.checkNotNullParameter(r26, "emitter");
        LinkedHashMap r2 = new LinkedHashMap();
        long r3 = com.bytedance.live.kmp.util.e.b() / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
        Iterator r5 = this.b.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L65;
        Map.Entry r6 = (Map.Entry) r5.next();
        String r13 = (String) r6.getKey();
        List r7 = (List) r6.getValue();
        if (r7.size() <= 1) goto L8;
        CollectionsKt.sortWith(r7, new a());
    L8:
        Iterator r14 = r7.iterator();
        long r8 = 0;
        ArrayList r15 = new ArrayList();
        com.bytedance.android.livesdk.gift.configmodel.g r9 = this.a.h().K8().get(r13);
        if (r9 == null) goto L11;
        long r10 = r9.i5();
    L12:
        long r16 = r10;
        com.bytedance.android.livesdk.gift.configmodel.g r11 = this.a.h().K8().get(r13);
        if (r11 == null) goto L15;
        long r17 = r11.d5();
    L17:
        if (r17 > 0) goto L20;
        r17 = this.a.h().d3();
    L20:
        long r18 = r17;
        long r20 = r8;
        long r23 = 0;
    L22:
        if (r14.hasNext() == false) goto L39;
        if (this.a.f == false) goto L39;
        if (r20 >= r16) goto L39;
        v r19 = (v) r14.next();
        if (LRUCleanStrategy.j(this.a, r19, this.c, r3) == false) goto L31;
        Iterator r24 = r5;
    L38:
        r5 = r24;
        goto L22
    L31:
        if ((r3 - r19.i3()) <= r18) goto L36;
        r24 = r5;
        if (LRUCleanStrategy.f(this.a, r19, r3, this.d, r13) != LRUCleanStrategy.CleanResourceResult.FILE_REMOVE_SUCCESS) goto L35;
        r15.add(r19);
        r20 = r20 + r19.getSize();
        goto L38
    L35:
        long r21 = r19.getSize();
    L37:
        r23 = r23 + r21;
        goto L38
    L36:
        r24 = r5;
        r21 = r19.getSize();
    L39:
        Iterator r25 = r5;
        com.bytedance.android.live.core.resources.c r27 = (com.bytedance.android.live.core.resources.c) ((LinkedHashMap) this.a.d).get(r13);
        if (r27 == null) goto L42;
        int r28 = r27.getPoolSize();
    L44:
        if (r23 <= r28) goto L64;
        Iterator r29 = r7.iterator();
    L47:
        if (r29.hasNext() == false) goto L64;
        if (this.a.f == false) goto L64;
        com.bytedance.android.live.core.resources.c r30 = (com.bytedance.android.live.core.resources.c) ((LinkedHashMap) this.a.d).get(r13);
        if (r30 == null) goto L53;
        int r31 = r30.getPoolSize();
    L55:
        if (r23 <= r31) goto L64;
        if (r20 >= r16) goto L64;
        v r33 = (v) r29.next();
        if (LRUCleanStrategy.j(this.a, r33, this.c, r3) == true) goto L47;
        if (LRUCleanStrategy.f(this.a, r33, r3, this.d, r13) != LRUCleanStrategy.CleanResourceResult.FILE_REMOVE_SUCCESS) goto L47;
        r15.add(r33);
        r20 = r20 + r33.getSize();
        r23 = r23 - r33.getSize();
        goto L47
    L53:
        r31 = Integer.MAX_VALUE;
    L64:
        r2.put(r13, r15);
        r5 = r25;
        goto L4
    L42:
        r28 = Integer.MAX_VALUE;
        goto L44
    L15:
        r17 = r8;
        goto L17
    L11:
        r10 = 30720;
        goto L12
    L65:
        r26.onSuccess(r2);
    }

    public i(LRUCleanStrategy r1, Map r2, List r3, CleanOpportunity r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
