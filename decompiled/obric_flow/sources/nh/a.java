package nh;

import android.text.TextUtils;
import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class a implements fh.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f20231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f20232c;

    public a() {
        this.f20231b = new AtomicBoolean(false);
        this.f20232c = new ConcurrentHashMap();
    }

    public final Object a(String r5) {
        if (this.f20231b.get() == false) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(r5) == false) goto L9;
        return null;
    L9:
        return this.f20232c.get(r5);
    }

    public final void b(Object r5, String r10) {
        if (this.f20231b.get() == false) goto L5;
        return;
    L5:
        if (r5 != null) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r10) == true) goto L12;
        this.f20232c.putIfAbsent(r10, r5);
        return;
    }

    @Override // fh.c
    public void release() {
        if (this.f20231b.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        ConcurrentHashMap r5 = this.f20232c;
        Enumeration r10 = r5.elements();
    L7:
        if (r10.hasMoreElements() == false) goto L12;
        Object r11 = r10.nextElement();     // Catch: Throwable -> L14
        if ((r11 instanceof fh.c) == false) goto L7;
        ((fh.c) r11).release();     // Catch: Throwable -> L14
        goto L7
    L12:
        r5.clear();
    }
}
