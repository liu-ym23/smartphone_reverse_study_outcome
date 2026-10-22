package com.bumptech.glide.integration.okhttp3;

import com.bumptech.glide.d;
import d0.g;
import d0.s;
import d0.u;
import d0.z;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import y.b;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class OkHttpGlideModule {
    public OkHttpGlideModule() {
    }

    public final void a(d r5) {
        b r10 = new b(0);
        u r11 = r5.f1392a;
        monitor-enter(r11);
        z r12 = r11.f16569a;     // Catch: Throwable -> L15
        monitor-enter(r12);     // Catch: Throwable -> L15
        ArrayList r13 = r12.e();     // Catch: Throwable -> L17
        r12.a(g.class, InputStream.class, r10);     // Catch: Throwable -> L17
        monitor-exit(r12);     // Catch: Throwable -> L15
        Iterator r14 = r13.iterator();     // Catch: Throwable -> L15
    L10:
        if (r14.hasNext() == false) goto L12;
        ((s) r14.next()).getClass();     // Catch: Throwable -> L15
        goto L10
    L12:
        ((HashMap) r11.f16570b.f23310b).clear();     // Catch: Throwable -> L15
        monitor-exit(r11);
        return;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }
}
