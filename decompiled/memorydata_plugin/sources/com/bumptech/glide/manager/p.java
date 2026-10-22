package com.bumptech.glide.manager;

import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<com.bumptech.glide.request.d> f930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<com.bumptech.glide.request.d> f931b;
    private boolean c;

    public p() {
        this.f930a = Collections.newSetFromMap(new WeakHashMap());
        this.f931b = new HashSet();
    }

    public void a() {
        this.c = true;
        Iterator r0 = com.bumptech.glide.util.k.a(this.f930a).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        com.bumptech.glide.request.d r1 = (com.bumptech.glide.request.d) ZeusTransformUtils.preCheckCast(r0.next(), com.bumptech.glide.request.d.class, "com.obric.memorydata.plugin");
        if (r1.d() == false) goto L4;
        r1.c();
        this.f931b.add(r1);
        goto L4
    }

    public void a(com.bumptech.glide.request.d r3) {
        com.bumptech.glide.request.d r4 = (com.bumptech.glide.request.d) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.d.class, "com.obric.memorydata.plugin");
        this.f930a.add(r4);
        if (this.c == true) goto L5;
        r4.a();
        return;
    L5:
        r4.b();
        if (Log.isLoggable("RequestTracker", 2) == false) goto L8;
        Log.v("RequestTracker", "Paused, delaying request");
    L8:
        this.f931b.add(r4);
    }

    public void b() {
        this.c = true;
        Iterator r0 = com.bumptech.glide.util.k.a(this.f930a).iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        com.bumptech.glide.request.d r1 = (com.bumptech.glide.request.d) ZeusTransformUtils.preCheckCast(r0.next(), com.bumptech.glide.request.d.class, "com.obric.memorydata.plugin");
        if (r1.d() == true) goto L9;
        if (r1.e() == false) goto L4;
    L9:
        r1.b();
        this.f931b.add(r1);
        goto L4
    }

    public boolean b(com.bumptech.glide.request.d r3) {
        com.bumptech.glide.request.d r4 = (com.bumptech.glide.request.d) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.d.class, "com.obric.memorydata.plugin");
        boolean r0 = true;
        if (r4 != null) goto L5;
        return true;
    L5:
        boolean r1 = this.f930a.remove(r4);
        if (this.f931b.remove(r4) == true) goto L10;
        if (r1 == true) goto L10;
        r0 = false;
    L10:
        if (r0 == false) goto L12;
        r4.b();
    L12:
        return r0;
    }

    public void c() {
        this.c = false;
        Iterator r0 = com.bumptech.glide.util.k.a(this.f930a).iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        com.bumptech.glide.request.d r1 = (com.bumptech.glide.request.d) ZeusTransformUtils.preCheckCast(r0.next(), com.bumptech.glide.request.d.class, "com.obric.memorydata.plugin");
        if (r1.e() == true) goto L4;
        if (r1.d() == true) goto L4;
        r1.a();
        goto L4
    L10:
        this.f931b.clear();
    }

    public void d() {
        Iterator r0 = com.bumptech.glide.util.k.a(this.f930a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        b((com.bumptech.glide.request.d) ZeusTransformUtils.preCheckCast(r0.next(), com.bumptech.glide.request.d.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        this.f931b.clear();
    }

    public void e() {
        Iterator r0 = com.bumptech.glide.util.k.a(this.f930a).iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        com.bumptech.glide.request.d r1 = (com.bumptech.glide.request.d) ZeusTransformUtils.preCheckCast(r0.next(), com.bumptech.glide.request.d.class, "com.obric.memorydata.plugin");
        if (r1.e() == true) goto L4;
        if (r1.f() == true) goto L4;
        r1.b();
        if (this.c == false) goto L11;
        this.f931b.add(r1);
        goto L4
    L11:
        r1.a();
        goto L4
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f930a.size() + ", isPaused=" + this.c + "}";
    }
}
