package com.bytedance.android.livesdk.interactivity.barrage.utils.shoot;

import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.interactivity.common.utils.LimitedSizeHashMap;
import com.bytedance.android.livesdk.interactivity.zdanmaku.widget.LandscapeDanmakuPresenterV2;
import com.bytedance.common.utility.Logger;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o extends r22.a<q22.a> {
    public final Deque<q22.a> c;
    public final LinkedHashMap<String, q22.a> d;
    public final Observable<Long> e;
    public Disposable f;
    public final LimitedSizeHashMap<String, Disposable> g;

    public static final class a {
    }

    static {
    }

    @Override // r22.a
    public final q22.a j() {
        return (q22.a) ((LinkedList) this.c).pollFirst();
    }

    @Override // r22.a
    public final Queue<q22.a> h() {
        return this.c;
    }

    public o(LandscapeDanmakuPresenterV2.f r3) {
        Intrinsics.checkNotNullParameter(r3, "danmakuReceiver");
        super(r3);
        this.c = new LinkedList();
        this.d = new LinkedHashMap();
        this.e = Observable.timer(3000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread());
        this.g = new LimitedSizeHashMap(100);
    }

    @Override // r22.a
    public final void e(q22.a r6) {
        q22.a r7 = r6;
        Intrinsics.checkNotNullParameter(r7, "danmaku");
        Logger.d("GiftDanmakuShooter", "Filling: " + r7.c);
        if (r7.e == false) goto L25;
        Disposable r0 = this.f;
        if (r0 == null) goto L8;
        r0.dispose();
    L8:
        if ((!this.d.isEmpty()) == false) goto L21;
        if (this.d.containsKey(r7.d) == true) goto L21;
        Iterator<String> r1 = this.d.keySet().iterator();
    L13:
        if (r1.hasNext() == false) goto L19;
        String r2 = r1.next();
        StringBuilder r3 = new StringBuilder("self take 1: ");
        q22.a r4 = this.d.get(r2);
        if (r4 == null) goto L17;
        String r5 = r4.c;
    L18:
        r3.append(r5);
        Logger.d("GiftDanmakuShooter", r3.toString());
        l(this.d.get(r2));
        goto L13
    L17:
        r5 = null;
        goto L18
    L19:
        this.d.clear();
    L21:
        if (r7.k == false) goto L23;
        l(r7);
        return;
    L23:
        this.d.put(r7.d, r7);
        this.f = this.e.subscribe(new r(this));
        return;
    L25:
        if (r7.k == false) goto L28;
        l(r7);
        return;
    L28:
        if (this.g.containsKey(r7.d) == false) goto L32;
        Disposable r8 = this.g.remove(r7.d);
        if (r8 == null) goto L32;
        r8.dispose();
    L32:
        this.g.put(r7.d, Observable.timer(3000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new q(this, r7)));
    }

    public final void l(q22.a r3) {
        if (((LinkedList) this.c).size() < 100) goto L5;
        ((LinkedList) this.c).removeFirst();
    L5:
        ((LinkedList) this.c).add(r3);
        k();
    }

    @Override // r22.a
    public final void b(q22.a r4, r22.a.b<q22.a> r5) {
        q22.a r6 = r4;
        Intrinsics.checkNotNullParameter(r6, "data");
        Intrinsics.checkNotNullParameter(r5, "notifier");
        if (r6.f != null) goto L5;
        r5.a(r6);
        return;
    L5:
        jc1.k.n(IHostFrescoHelper.class).loadFirstAvailableImageBitmap(r6.f, new p(r6, r5));
    }
}
