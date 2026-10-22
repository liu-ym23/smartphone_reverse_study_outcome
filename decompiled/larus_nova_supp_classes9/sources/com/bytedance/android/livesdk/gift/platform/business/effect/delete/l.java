package com.bytedance.android.livesdk.gift.platform.business.effect.delete;

import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l implements SingleOnSubscribe<List<? extends v>> {
    public final /* synthetic */ LRUCleanStrategy a;
    public final /* synthetic */ List b;
    public final /* synthetic */ String c;
    public final /* synthetic */ long d;
    public final /* synthetic */ long e;
    public final /* synthetic */ List f;
    public final /* synthetic */ ConcurrentHashMap g;
    public final /* synthetic */ CleanOpportunity h;

    public static final class a<T> implements Comparator<T> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((v) r3).i3()), Long.valueOf(((v) r4).i3()));
        }
    }

    public final void subscribe(SingleEmitter<List<v>> r18) {
        l r0 = this;
        Intrinsics.checkNotNullParameter(r18, "emitter");
        long r2 = com.bytedance.live.kmp.util.e.b() / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
        ArrayList r4 = new ArrayList();
        List r5 = r0.b;
        if (r5.size() <= 1) goto L5;
        CollectionsKt.sortWith(r5, new a());
    L5:
        Iterator r6 = r0.b.iterator();
        long r7 = 0;
        com.bytedance.android.livesdk.gift.configmodel.g r8 = r0.a.h().K8().get(r0.c);
        if (r8 == null) goto L8;
        long r13 = r8.i5();
    L9:
        long r14 = r7;
    L11:
        if (r6.hasNext() == false) goto L23;
        if (r0.d <= r0.e) goto L23;
        if (r14 >= r13) goto L23;
        v r11 = (v) r6.next();
        LRUCleanStrategy r9 = r0.a;
        List r10 = r0.f;
        ConcurrentHashMap r15 = r0.g;
        r9.getClass();
        if (LRUCleanStrategy.i(r11, r10, r2, r15) == true) goto L22;
        if (LRUCleanStrategy.f(r0.a, r11, r2, r0.h, r0.c) != LRUCleanStrategy.CleanResourceResult.FILE_REMOVE_SUCCESS) goto L22;
        r4.add(r11);
        r14 = r14 + r11.getSize();
    L22:
        r0 = this;
    L23:
        r18.onSuccess(r4);
        return;
    L8:
        r13 = r7;
        goto L9
    }

    public l(LRUCleanStrategy r1, List r2, String r3, long r4, long r6, List r8, ConcurrentHashMap r9, CleanOpportunity r10) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
        this.f = r8;
        this.g = r9;
        this.h = r10;
    }
}
