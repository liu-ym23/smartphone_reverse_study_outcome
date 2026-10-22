package com.bytedance.frameworks.baselib.network.http.impl;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<URI, List<f>> f1643a;

    public e() {
        this.f1643a = new HashMap();
    }

    private URI c(URI r10) {
        if (r10 != null) goto L8;
        return null;
    L8:
        return new URI("http", r10.getHost(), null, null);
    L7:
        return r10;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.d
    public synchronized void a(URI r10, f r11) {
        monitor-enter(this);
        if (r11 == null) goto L14;
        URI r12 = c(r10);     // Catch: Throwable -> L11
        List<f> r13 = this.f1643a.get(r12);     // Catch: Throwable -> L11
        if (r13 != null) goto L7;
        r13 = new ArrayList();     // Catch: Throwable -> L11
        this.f1643a.put(r12, r13);     // Catch: Throwable -> L11
    L8:
        r13.add(r11);     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L7:
        r13.remove(r11);     // Catch: Throwable -> L11
        goto L8
    L14:
        throw new NullPointerException("cookie == null");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.d
    public synchronized List<f> b(URI r10) {
        monitor-enter(this);
        if (r10 == null) goto L37;
        ArrayList r11 = new ArrayList();     // Catch: Throwable -> L34
        List<f> r12 = this.f1643a.get(r10);     // Catch: Throwable -> L34
        if (r12 == null) goto L13;
        Iterator<f> r13 = r12.iterator();     // Catch: Throwable -> L34
    L8:
        if (r13.hasNext() == false) goto L13;
        f r14 = r13.next();     // Catch: Throwable -> L34
        if (r14.H() == true) goto L11;
        r11.add(r14);     // Catch: Throwable -> L34
        goto L8
    L11:
        r13.remove();     // Catch: Throwable -> L34
    L13:
        Iterator<Map.Entry<URI, List<f>>> r15 = this.f1643a.entrySet().iterator();     // Catch: Throwable -> L34
    L15:
        if (r15.hasNext() == false) goto L31;
        Map.Entry<URI, List<f>> r16 = r15.next();     // Catch: Throwable -> L34
        if (r10.equals(r16.getKey()) == true) goto L15;
        Iterator<f> r17 = r16.getValue().iterator();     // Catch: Throwable -> L34
    L21:
        if (r17.hasNext() == false) goto L15;
        f r18 = r17.next();     // Catch: Throwable -> L34
        if (f.t(r18.y(), r10.getHost()) == false) goto L21;
        if (r18.H() == true) goto L27;
        if (r11.contains(r18) == true) goto L21;
        r11.add(r18);     // Catch: Throwable -> L34
        goto L21
    L27:
        r17.remove();     // Catch: Throwable -> L34
        goto L21
    L31:
        List<f> r19 = Collections.unmodifiableList(r11);     // Catch: Throwable -> L34
        monitor-exit(this);
        return r19;
    L37:
        throw new NullPointerException("uri == null");     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        throw th;
    }
}
