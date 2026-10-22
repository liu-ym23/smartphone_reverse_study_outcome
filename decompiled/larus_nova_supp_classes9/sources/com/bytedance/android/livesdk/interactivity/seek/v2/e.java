package com.bytedance.android.livesdk.interactivity.seek.v2;

import im2.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements com.ss.ugc.live.sdk.msg.b {
    public final /* synthetic */ b a;

    public final void onInit() {
        List<vlc.b> r0 = this.a.z;
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
        n r0 = this.a.d;
        if ((r0 instanceof n) == true) goto L5;
        r0 = null;
    L5:
        if (r0 == null) goto L7;
        r0.a();
    L7:
        List<vlc.b> r1 = this.a.z;
        if (r1 == null) goto L19;
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r1.iterator();
    L11:
        if (r3.hasNext() == false) goto L15;
        Object r4 = r3.next();
        if ((r4 instanceof com.bytedance.android.livesdk.message.interceptor.h) == false) goto L11;
        r2.add(r4);
        goto L11
    L15:
        Iterator r5 = r2.iterator();
    L17:
        if (r5.hasNext() == false) goto L19;
        ((com.bytedance.android.livesdk.message.interceptor.h) r5.next()).onRelease();
    L19:
        this.a.c.d("seek_message");
    }

    public final void onResume() {
        List<vlc.b> r0 = this.a.z;
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

    public final void onStart() {
        List<vlc.b> r0 = this.a.z;
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

    public e(b r1) {
        this.a = r1;
    }

    public final void a(boolean r4) {
        List<vlc.b> r5 = this.a.z;
        if (r5 == null) goto L14;
        ArrayList r0 = new ArrayList();
        Iterator<T> r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L10;
        Object r1 = r6.next();
        if ((r1 instanceof com.bytedance.android.livesdk.message.interceptor.h) == false) goto L6;
        r0.add(r1);
        goto L6
    L10:
        Iterator r7 = r0.iterator();
    L12:
        if (r7.hasNext() == false) goto L21;
        ((com.bytedance.android.livesdk.message.interceptor.h) r7.next()).getClass();
        goto L12
    L21:
        return;
    }
}
