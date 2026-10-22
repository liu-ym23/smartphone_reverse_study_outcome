package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.livesdk.downloader.GiftResourceManagerFactory;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e2 implements SingleOnSubscribe<Boolean> {
    public final /* synthetic */ GiftResourceFileCacheService a;

    public e2(GiftResourceFileCacheService r1) {
        this.a = r1;
    }

    public final void subscribe(SingleEmitter<Boolean> r13) {
        Intrinsics.checkNotNullParameter(r13, "emitter");
        com.bytedance.live.kmp.util.c r0 = com.bytedance.live.kmp.util.c.a;
        long r1 = System.currentTimeMillis();
        if (this.a.c.isEmpty() == true) goto L5;
        return;
    L5:
        String r2 = this.a.f();
        if (r2 != null) goto L8;
    L11:
        boolean r5 = true;
    L12:
        if (r5 == false) goto L14;
        return;
    L14:
        GiftResourceFileCacheService r6 = this.a;
        r6.k = com.bytedance.android.livesdk.gift.platform.core.utils.d.a.h(r6.a);
        List r3 = this.a.g().c(r2);
        if (r3 == null) goto L41;
        Iterator r4 = r3.iterator();
    L18:
        if (r4.hasNext() == false) goto L41;
        String r7 = (String) r4.next();
        jy0.b.a("GiftAssetClean", "collectAssetFile, localDirectory foreach, filePath = " + r7);
        GiftResourceFileCacheService r8 = this.a;
        if (r8.k == false) goto L21;
        String r9 = uy0.a.b(r7);
        if (r9 == null) goto L18;
        this.a.c.put(r9, r7);
        goto L18
    L21:
        List r10 = r8.g().c(r7);
        if (r10 == null) goto L29;
        Iterator r11 = r10.iterator();
        boolean r14 = false;
    L25:
        if (r11.hasNext() == false) goto L30;
        String r15 = (String) r11.next();
        jy0.b.a("GiftAssetClean", "collectAssetFile, localDirectory subForeach, filePath = " + r15);
        Lazy r16 = GiftResourceManagerFactory.a;
        if (Intrinsics.areEqual(".fetched", uy0.a.b(r15)) == false) goto L25;
        r14 = true;
    L30:
        String r17 = uy0.a.b(r7);
        if (r17 == null) goto L18;
        if (r14 == true) goto L34;
        int r18 = GiftResourceFileCacheService.p;
        if ((!Intrinsics.areEqual("zip", r17)) == false) goto L18;
        this.a.g().J(r7);
        this.a.j++;
        goto L18
    L34:
        this.a.c.put(r17, r7);
        goto L18
    L29:
        r14 = false;
    L41:
        GiftResourceFileCacheService r19 = this.a;
        r19.f = true;
        com.bytedance.live.kmp.util.c r20 = com.bytedance.live.kmp.util.c.a;
        r19.h = System.currentTimeMillis() - r1;
        GiftResourceFileCacheService r21 = this.a;
        r21.i = r21.c.size();
        GiftResourceFileCacheService r23 = this.a;
        if (r23.j != 0) goto L44;
        com.bytedance.android.livesdk.gift.platform.core.utils.d.a.f(r23.a);
    L44:
        StringBuilder r24 = new StringBuilder("===========collectSize=");
        r24.append(this.a.i);
        r24.append(", collectTime=");
        r24.append(this.a.h);
        r24.append(", deleteSize=");
        r24.append(this.a.j);
        r24.append(", completeDelete=");
        r24.append(this.a.k);
        r24.append(", mAssetsFileArray=");
        r24.append(GsonProtectorUtils.toJson(l97.a.a, this.a.c));
        jy0.b.a("GiftAssetClean", r24.toString());
        r13.onSuccess(Boolean.TRUE);
        return;
    L8:
        if (r2.length() == 0) goto L11;
        r5 = false;
        goto L12
    }
}
