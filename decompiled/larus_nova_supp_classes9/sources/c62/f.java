package c62;

import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import zg1.k1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements com.ss.ugc.live.sdk.msg.b {
    public final /* synthetic */ d a;

    public final void onInit() {
        List<vlc.b> r0 = this.a.q;
        if (r0 == null) goto L14;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L10;
        Object r3 = r2.next();
        if ((r3 instanceof com.bytedance.android.livesdk.message.interceptor.h) == false) goto L6;
        r1.add(r3);
        goto L6
    L10:
        Iterator r4 = r1.iterator();
    L12:
        if (r4.hasNext() == false) goto L21;
        ((com.bytedance.android.livesdk.message.interceptor.h) r4.next()).getClass();
        goto L12
    L21:
        return;
    }

    public final void onRelease() {
        d r0 = this.a;
        Disposable r1 = r0.d;
        if (r1 == null) goto L5;
        r1.dispose();
    L5:
        im2.n r2 = null;
        r0.d = null;
        im2.n r3 = this.a.e;
        if ((r3 instanceof im2.n) == false) goto L9;
        r2 = r3;
    L9:
        if (r2 == null) goto L11;
        r2.a();
    L11:
        List<vlc.b> r4 = this.a.q;
        if (r4 == null) goto L23;
        ArrayList r5 = new ArrayList();
        Iterator<T> r6 = r4.iterator();
    L15:
        if (r6.hasNext() == false) goto L19;
        Object r7 = r6.next();
        if ((r7 instanceof com.bytedance.android.livesdk.message.interceptor.h) == false) goto L15;
        r5.add(r7);
        goto L15
    L19:
        Iterator r8 = r5.iterator();
    L21:
        if (r8.hasNext() == false) goto L23;
        ((com.bytedance.android.livesdk.message.interceptor.h) r8.next()).onRelease();
    L23:
        this.a.c.d("room_channel_message");
    }

    public final void onResume() {
        d r0 = this.a;
        r0.getClass();
        r0.d = xs2.b.a().b(k1.class).subscribe(new h(r0));
        List<vlc.b> r1 = this.a.q;
        if (r1 == null) goto L14;
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        Object r4 = r3.next();
        if ((r4 instanceof com.bytedance.android.livesdk.message.interceptor.h) == false) goto L6;
        r2.add(r4);
        goto L6
    L10:
        Iterator r5 = r2.iterator();
    L12:
        if (r5.hasNext() == false) goto L21;
        ((com.bytedance.android.livesdk.message.interceptor.h) r5.next()).getClass();
        goto L12
    L21:
        return;
    }

    public final void onStart() {
        d r0 = this.a;
        r0.getClass();
        r0.d = xs2.b.a().b(k1.class).subscribe(new h(r0));
        List<vlc.b> r1 = this.a.q;
        if (r1 == null) goto L14;
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        Object r4 = r3.next();
        if ((r4 instanceof com.bytedance.android.livesdk.message.interceptor.h) == false) goto L6;
        r2.add(r4);
        goto L6
    L10:
        Iterator r5 = r2.iterator();
    L12:
        if (r5.hasNext() == false) goto L21;
        ((com.bytedance.android.livesdk.message.interceptor.h) r5.next()).getClass();
        goto L12
    L21:
        return;
    }

    public f(d r1) {
        this.a = r1;
    }

    public final void a(boolean r4) {
        d r5 = this.a;
        Disposable r0 = r5.d;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        r5.d = null;
        List<vlc.b> r6 = this.a.q;
        if (r6 == null) goto L17;
        ArrayList r1 = new ArrayList();
        Iterator<T> r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L13;
        Object r2 = r7.next();
        if ((r2 instanceof com.bytedance.android.livesdk.message.interceptor.h) == false) goto L9;
        r1.add(r2);
        goto L9
    L13:
        Iterator r8 = r1.iterator();
    L15:
        if (r8.hasNext() == false) goto L24;
        ((com.bytedance.android.livesdk.message.interceptor.h) r8.next()).getClass();
        goto L15
    L24:
        return;
    }
}
