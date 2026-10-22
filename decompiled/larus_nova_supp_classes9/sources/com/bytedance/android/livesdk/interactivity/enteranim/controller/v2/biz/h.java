package com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h<T> implements SingleOnSubscribe {
    public final /* synthetic */ RevenueUtils a;
    public final /* synthetic */ long b;

    public h(RevenueUtils r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(SingleEmitter<Pair<com.bytedance.android.live.core.resources.e, Boolean>> r7) {
        Intrinsics.checkNotNullParameter(r7, "emitter");
        ALogger.i("RevenueUtils", "syncing asset model id=" + this.b + "...");
        RevenueUtils r0 = this.a;
        if (r0.d == true) goto L5;
        r0.c().T(this.a.h);
        this.a.d = true;
    L5:
        RevenueUtils r1 = this.a;
        Map<Long, List<SingleEmitter<Pair<com.bytedance.android.live.core.resources.e, Boolean>>>> r2 = r1.g;
        Long r3 = Long.valueOf(this.b);
        r1.getClass();
        LinkedHashMap r4 = (LinkedHashMap) r2;
        List r5 = (List) r4.get(r3);
        if (r5 != null) goto L8;
        r4.put(r3, CollectionsKt.mutableListOf(new Object[]{r7}));
    L10:
        if (((Boolean) this.a.f.getValue()).booleanValue() == false) goto L12;
        this.a.c().d4(4, ((Boolean) this.a.e.getValue()).booleanValue(), this.b, "getAssetModelForTargetId");
        return;
    L12:
        this.a.c().T2(4, "getAssetModel");
        return;
    L8:
        r5.add(r7);
        goto L10
    }
}
