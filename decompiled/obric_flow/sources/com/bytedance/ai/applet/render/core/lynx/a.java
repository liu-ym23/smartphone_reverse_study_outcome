package com.bytedance.ai.applet.render.core.lynx;

import android.content.Context;
import java.io.InputStream;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements ln.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1759a;

    public a(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.f1759a = r5;
    }

    @Override // ln.b
    public final void a(String r5, zm.c r10) {
        if (r5 != null) goto L5;
    L24:
        r10.m(null, new Throwable("url is empty"));
        return;
    L5:
        if (r5.length() == 0) goto L24;
        String r11 = (String) b.f1760a.get(r5);
        if (r11 != null) goto L26;
        d(r5, r10);
        return;
    L26:
        Context r12 = this.f1759a;     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter(r12, "context");     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter(r11, "assetPath");     // Catch: Throwable -> L13
        InputStream r13 = r12.getAssets().open(r11);     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r13);     // Catch: Throwable -> L15
        byte[] r14 = ByteStreamsKt.readBytes(r13);     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r13, null);     // Catch: Throwable -> L13
        b(r5);     // Catch: Throwable -> L13
        r10.m(r14, null);     // Catch: Throwable -> L13
        return;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r13, th);     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        c(r5, th);
        r10.m(null, th);
    }

    public abstract void b(String r5);

    public abstract void c(String r5, Throwable r10);

    public abstract void d(String r5, zm.c r10);
}
