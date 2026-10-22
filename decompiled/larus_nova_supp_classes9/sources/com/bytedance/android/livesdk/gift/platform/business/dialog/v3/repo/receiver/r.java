package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.gift.model.w0;
import com.bytedance.android.livesdk.gift.model.x0;
import com.bytedance.android.livesdk.gift.model.y0;
import com.bytedance.android.livesdk.gift.model.z0;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class r<T> implements Consumer {
    public final /* synthetic */ GiftReceiverRepoService a;

    public r(GiftReceiverRepoService r1) {
        this.a = r1;
    }

    public final void accept(Object r8) {
        ExtraResponse r9 = (ExtraResponse) r8;
        w0 r0 = ((z0) r9.data).getInfo();
        if (r0 == null) goto L5;
        com.bytedance.live.kmp.util.c r1 = com.bytedance.live.kmp.util.c.a;
        long r2 = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r9, "$this$now");
        x0.a(r0, Long.valueOf(r2 - r9.extra.now));
    L5:
        GiftReceiverRepoService r10 = this.a;
        r10.getClass();
        StringBuilder r3 = new StringBuilder("groupShowUsers size = ");
        if (r0 == null) goto L10;
        List<y0> r4 = r0.getGroupShowUsers();
        if (r4 == null) goto L10;
        Integer r5 = Integer.valueOf(r4.size());
    L11:
        r3.append(r5);
        jy0.b.d("GiftReceiverRepo", r3.toString());
        if (((Number) nz1.b.d.getValue(null, nz1.b.a[2])).intValue() != 1) goto L17;
        if (r0 == null) goto L17;
        if (r0.getGroupShowScene() != 2) goto L17;
        return;
    L17:
        if (r0 == null) goto L26;
        List<y0> r6 = r0.getGroupShowUsers();
        if (r6 == null) goto L26;
        List<y0> r7 = r6;
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator<T> r13 = r7.iterator();
    L22:
        if (r13.hasNext() == false) goto L24;
        r11.add(((y0) r13.next()).getGroupShowUser());
        goto L22
    L24:
        List r14 = CollectionsKt.toList(r11);
        if (r14 == null) goto L26;
    L27:
        r10.b.put(4, new j(r14, r0, null));
        r10.U();
        return;
    L26:
        r14 = CollectionsKt.emptyList();
    L10:
        r5 = null;
        goto L11
    }
}
