package qw1;

import com.bytedance.android.livesdk.feed.preview.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e implements d.a {
    public final d a;
    public final a b;

    public final void a() {
        d r0 = this.a;
        if (r0.d == true) goto L7;
        r0.d = true;
        r0.a();
        return;
    }

    public final void b() {
        d r0 = this.a;
        if (r0.d == false) goto L7;
        r0.d = false;
        r0.a.removeCallbacksAndMessages(null);
        return;
    }

    public e(long r1, long r3, f r5) {
        this.a = new d(r1, this);
        this.b = r5;
    }
}
