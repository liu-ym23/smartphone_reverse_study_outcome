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
public final class o implements SingleOnSubscribe<Map<String, ? extends List<? extends v>>> {
    public final /* synthetic */ LRUCleanStrategy a;
    public final /* synthetic */ Map b;
    public final /* synthetic */ List c;

    public static final class a<T> implements Comparator<T> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((v) r3).i3()), Long.valueOf(((v) r4).i3()));
        }
    }

    public final void subscribe(SingleEmitter<Map<String, List<v>>> r15) {
        Intrinsics.checkNotNullParameter(r15, "emitter");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r1 = this.b.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L24;
        Map.Entry r2 = (Map.Entry) r1.next();
        String r3 = (String) r2.getKey();
        List r4 = (List) r2.getValue();
        if (r4.size() <= 1) goto L8;
        CollectionsKt.sortWith(r4, new a());
    L8:
        Iterator r5 = r4.iterator();
        ArrayList r10 = new ArrayList();
        long r11 = com.bytedance.live.kmp.util.e.b() / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
    L10:
        if (r5.hasNext() == false) goto L23;
        if (this.a.g == false) goto L23;
        v r13 = (v) r5.next();
        if (LRUCleanStrategy.j(this.a, r13, this.c, r11) == true) goto L10;
        if ((r11 - r13.i3()) <= com.bytedance.android.livesdk.gift.platform.business.i.d().C0()) goto L10;
        LRUCleanStrategy.CleanResourceResult r6 = LRUCleanStrategy.f(this.a, r13, r11, CleanOpportunity.MANUAL_CLEAN_IN_ROOM, r3);
        jy0.b.c("GiftAssetClean", "删除结果：" + r6 + ", 资源ID是：" + r13.getAssetId(), null, 4);
        if (r6 == LRUCleanStrategy.CleanResourceResult.FILE_REMOVE_SUCCESS) goto L22;
        if (r6 != LRUCleanStrategy.CleanResourceResult.FILE_NOT_EXIST) goto L10;
    L22:
        r10.add(r13);
        r13.getSize();
    L23:
        r0.put(r3, r10);
        goto L4
    L24:
        r15.onSuccess(r0);
    }

    public o(LRUCleanStrategy r1, Map r2, List r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
