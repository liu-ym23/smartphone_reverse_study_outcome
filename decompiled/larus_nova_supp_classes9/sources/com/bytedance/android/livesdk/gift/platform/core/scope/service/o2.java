package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.UpdatePropExpireTime;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o2 implements com.bytedance.android.scope.o {
    public Disposable a;
    public List<? extends Map<Integer, ? extends List<vz1.e>>> b;
    public final i12.d c;

    public final void onStart() {
    }

    public final void onStop() {
        Disposable r0 = this.a;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public o2(i12.d r2) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        this.c = r2;
    }

    public final void c(List<? extends Map<Integer, ? extends List<vz1.e>>> r14) {
        long r0 = com.bytedance.android.live.revenue.common.u0.k.a;
        if (r14 == null) goto L27;
        Iterator<T> r15 = r14.iterator();
    L6:
        if (r15.hasNext() == false) goto L27;
        Map.Entry r4 = com.bytedance.android.live.core.utils.z0.a((Map) r15.next());
        if (r4 == null) goto L6;
        List r5 = (List) r4.getValue();
        if (r5 == null) goto L6;
        Iterator r6 = r5.iterator();
    L13:
        if (r6.hasNext() == false) goto L6;
        vz1.e r7 = (vz1.e) r6.next();
        if (r7.e == true) goto L16;
        long r9 = r7.a.getGiftEndingTime() - ((System.currentTimeMillis() / 1000) + r7.a.getNowTimeDiffSeconds());
        if (r9 <= 0) goto L13;
        if (r9 >= r0) goto L13;
    L25:
        r0 = r9;
        goto L13
    L16:
        r9 = r7.g.d - ((System.currentTimeMillis() / 1000) + r7.g.e);
        if (r9 <= 0) goto L13;
        if (r9 >= r0) goto L13;
    L27:
        if (r0 <= 0) goto L65;
        Disposable r16 = this.a;
        if (r16 == null) goto L32;
        r16.dispose();
    L32:
        Ref.LongRef r17 = new Ref.LongRef();
        r17.element = r0;
        Ref.LongRef r1 = new Ref.LongRef();
        r1.element = 1;
        long r8 = r17.element;
        long r10 = IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW;
        long r11 = r8 * r10;
        long r13 = com.bytedance.android.live.revenue.common.u0.j.a;
        if (r11 <= r13) goto L35;
        r1.element = r13 / r10;
    L42:
        if (r17.element <= 0) goto L64;
        com.bytedance.android.live.core.utils.rxutils.j.a r2 = com.bytedance.android.live.core.utils.rxutils.j.a;
        this.a = RxUtilKt.h(com.bytedance.android.live.core.utils.rxutils.j.c(r1.element, TimeUnit.SECONDS).takeWhile(new m2(r17)).subscribeOn(Schedulers.io())).subscribe(new n2(this, r17, r1));
        return;
    L64:
        return;
    L35:
        long r18 = com.bytedance.android.live.revenue.common.u0.i.a;
        if (r11 <= r18) goto L38;
        r1.element = r18 / r10;
        goto L42
    L38:
        long r19 = com.bytedance.android.live.revenue.common.u0.h.a;
        if (r11 <= r19) goto L42;
        r1.element = r19 / r10;
        goto L42
    }

    public static final void a(o2 r0, long r1, boolean r3) {
        if (r3 == false) goto L7;
        Disposable r4 = r0.a;
        if (r4 == null) goto L6;
        r4.dispose();
    L6:
        r0.c(r0.b);
    L7:
        i12.d r2 = r0.c;
        uz1.a r5 = com.bytedance.android.livesdk.gift.platform.core.utils.b0.a();
        if (r5 == null) goto L11;
        r5.a(new UpdatePropExpireTime(r1));
        return;
    }
}
