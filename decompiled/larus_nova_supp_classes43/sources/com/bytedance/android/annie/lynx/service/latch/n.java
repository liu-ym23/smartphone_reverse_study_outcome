package com.bytedance.android.annie.lynx.service.latch;

import io.reactivex.functions.Function;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class n<T, R> implements Function {
    public final /* synthetic */ k a;

    public n(k r1) {
        this.a = r1;
    }

    public final Object apply(Object r10) {
        k.a r11 = (k.a) r10;
        Intrinsics.checkNotNullParameter(r11, "channelLoader");
        com.bytedance.android.annie.service.prefetch.n r0 = r11.a;
        String r12 = r11.b;
        this.a.getClass();
        InputStream r1 = r0.a("latch.json", r12);
        if (r1 == null) goto L18;
        Reader r13 = new InputStreamReader(r1, Charsets.UTF_8);
        if ((r13 instanceof BufferedReader) == false) goto L7;
        BufferedReader r14 = (BufferedReader) r13;
    L21:
        String r15 = TextStreamsKt.readText(r14);     // Catch: Throwable -> L12
        CloseableKt.closeFinally(r14, null);
        if (r15 == null) goto L18;
        return new b(r12, r15);
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);
        throw th;
    L7:
        r14 = new BufferedReader(r13, 8192);
    L18:
        return b.c;
    }
}
