package com.bytedance.ies.bullet.lynx.resource;

import com.bytedance.ies.bullet.service.base.a0;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.concurrent.Callable;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a0 f5771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ go.a f5772c;

    public /* synthetic */ i(a0 r5, go.a r10, int r11) {
        this.f5770a = r11;
        this.f5771b = r5;
        this.f5772c = r10;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch(this.f5770a) {
            case 0: goto L30;
            default: goto L4;
        };
    L4:
        go.a r5 = this.f5772c;
        InputStream r10 = this.f5771b.c();     // Catch: Throwable -> L13
        if (r10 == null) goto L73;
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();     // Catch: Throwable -> L15
        ByteStreamsKt.copyTo$default(r10, r11, 0, 2, null);     // Catch: Throwable -> L17
        h.f r12 = h.f.b(new f(r5, r11.toByteArray(), 1), h.f.f17263i);     // Catch: Throwable -> L17
        CloseableKt.closeFinally(r11, null);     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r10, null);     // Catch: Throwable -> L13
        return r12;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L73:
        return h.f.b(new g(r5, 1), h.f.f17263i);
    L13:
        th = move-exception;
        return h.f.b(new h(r5, th, 1), h.f.f17263i);
    L30:
        go.a r13 = this.f5772c;
        InputStream r14 = this.f5771b.c();     // Catch: Throwable -> L39
        if (r14 == null) goto L75;
        ByteArrayOutputStream r15 = new ByteArrayOutputStream();     // Catch: Throwable -> L41
        ByteStreamsKt.copyTo$default(r14, r15, 0, 2, null);     // Catch: Throwable -> L43
        h.f r16 = h.f.b(new f(r13, r15.toByteArray(), 0), h.f.f17263i);     // Catch: Throwable -> L43
        CloseableKt.closeFinally(r15, null);     // Catch: Throwable -> L41
        CloseableKt.closeFinally(r14, null);     // Catch: Throwable -> L39
        return r16;
    L43:
        th = move-exception;
        throw th;     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        CloseableKt.closeFinally(r15, th);     // Catch: Throwable -> L41
        throw th;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        throw th;     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);     // Catch: Throwable -> L39
        throw th;     // Catch: Throwable -> L39
    L75:
        return h.f.b(new g(r13, 0), h.f.f17263i);
    L39:
        th = move-exception;
        return h.f.b(new h(r13, th, 0), h.f.f17263i);
    }
}
