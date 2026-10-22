package com.bytedance.android.livesdk.feed.tab.repository;

import android.os.SystemClock;
import com.bytedance.android.livesdk.feed.tab.monitor.FeedTabMonitor;
import io.reactivex.Observable;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class l implements com.bytedance.android.livesdk.feed.j {
    public final q a;
    public final r b;
    public final FeedTabMonitor c;

    @Override // com.bytedance.android.livesdk.feed.j
    public final List<com.bytedance.android.livesdk.feed.feed.e> c() {
        return this.a.b();
    }

    @Override // com.bytedance.android.livesdk.feed.j
    public final Observable<List<com.bytedance.android.livesdk.feed.feed.e>> e() {
        FeedTabMonitor r0 = this.c;
        r0.getClass();
        r0.a = SystemClock.uptimeMillis();
        return Observable.concat(Observable.create(new a(this)), Observable.create(new c(this)));
    }

    @Override // com.bytedance.android.livesdk.feed.j
    public final com.bytedance.android.livesdk.feed.feed.f getExtra() {
        return this.a.getExtra();
    }

    @Override // com.bytedance.android.livesdk.feed.j
    public final Observable<List<com.bytedance.android.livesdk.feed.feed.e>> a(final FeedTabMonitor.Action r4) {
        FeedTabMonitor r0 = this.c;
        r0.getClass();
        r0.a = SystemClock.uptimeMillis();
        return this.b.a().map(new d(this)).doOnNext(new e(this, r4)).doOnError(new f(this, r4));
    }

    @Override // com.bytedance.android.livesdk.feed.j
    public final boolean b(long r1) {
        com.bytedance.android.livesdk.feed.feed.e r2 = d(r1);
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.c() <= 0) goto L7;
        return true;
    }

    @Override // com.bytedance.android.livesdk.feed.j
    public final com.bytedance.android.livesdk.feed.feed.e d(long r2) {
        return this.a.f(r2);
    }

    public l(s r2, r r3) {
        this.c = new FeedTabMonitor();
        this.a = r2;
        this.b = r3;
    }
}
