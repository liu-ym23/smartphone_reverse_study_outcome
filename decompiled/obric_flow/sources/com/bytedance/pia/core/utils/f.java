package com.bytedance.pia.core.utils;

import android.util.Pair;
import com.bytedance.pia.core.api.resource.LoadFrom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements dh.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final dh.d f7149a;

    public f(dh.d r5) {
        if ((r5 instanceof f) == false) goto L5;
        r5 = null;
    L5:
        this.f7149a = r5;
    }

    public static void c(dh.e r5, fh.a r10) {
        Intrinsics.checkNotNullParameter(r5, "request");
        j.y("[Resource] Custom resource loader load failed, fallback to default resource loader.", null);
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L5
        d(r5.getUrl().toString(), r5.getRequestHeaders());     // Catch: Throwable -> L5
        throw null;     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Throwable r13 = Result.m127exceptionOrNullimpl(Result.m124constructorimpl(ResultKt.createFailure(th)));
        if (r13 == null) goto L12;
        r10.accept(r13);
        return;
    }

    public static void d(String r5, Map r10) {
        Pair r11 = com.bytedance.frameworks.baselib.network.http.util.c.c(r5, new HashMap());
        if (r10 == null) goto L9;
        ArrayList r12 = new ArrayList(r10.size());
        Iterator r13 = r10.entrySet().iterator();
    L6:
        if (r13.hasNext() == false) goto L9;
        Map.Entry r14 = (Map.Entry) r13.next();
        r12.add(new bi.c((String) r14.getKey(), (String) r14.getValue()));
    L9:
        if (zg.b.f23440c == null) goto L11;
        com.bytedance.ai.resource.core.net.a r15 = new com.bytedance.ai.resource.core.net.a(17);
    L13:
        if (r15 == null) goto L20;
        if (com.bytedance.ttnet.utils.d.c(b.class, (String) r11.first) == null) goto L20;
        throw new ClassCastException();
    L20:
        if (com.bytedance.ttnet.utils.d.c(b.class, (String) r11.first) != null) goto L24;
        String r16 = (String) r11.second;
        throw null;
    L24:
        throw new ClassCastException();
    L11:
        r15 = null;
        goto L13
    }

    @Override // dh.d
    public final fh.c a(dh.e r5, fh.a r10, fh.a r11) {
        Intrinsics.checkNotNullParameter(LoadFrom.f6957c, "loadFrom");
        Intrinsics.checkNotNullParameter(r5, "request");
        dh.d r12 = this.f7149a;
        if (r12 != null) goto L5;
        c(r5, r11);
        return e.f7148b;
    L5:
        return r12.a(r5, new c(r10, this, r5, r11), new d(this, r5, r11));
    }

    @Override // dh.d
    public final dh.f b(LoadFrom r5, dh.e r10) {
        Intrinsics.checkNotNullParameter(r5, "loadFrom");
        Intrinsics.checkNotNullParameter(r10, "request");
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L6
        dh.d r12 = this.f7149a;     // Catch: Throwable -> L6
        if (r12 == null) goto L8;
        dh.f r13 = r12.b(r5, r10);     // Catch: Throwable -> L6
    L9:
        Object r14 = Result.m124constructorimpl(r13);     // Catch: Throwable -> L6
    L13:
        if (Result.m130isFailureimpl(r14) == false) goto L15;
        r14 = null;
    L15:
        dh.f r15 = (dh.f) r14;
        if (r15 == null) goto L19;
        j.y("[Resource] Custom resource loader load success.", null);
        return r15;
    L19:
        Intrinsics.checkNotNullParameter(r10, "request");
        j.y("[Resource] Custom resource loader load failed, fallback to default resource loader.", null);
        d(r10.getUrl().toString(), r10.getRequestHeaders());     // Catch: Throwable -> L22
        throw null;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        Throwable r17 = Result.m127exceptionOrNullimpl(Result.m124constructorimpl(ResultKt.createFailure(th)));
        if (r17 == null) goto L26;
        j.y("[Resource] Load online failed:", r17);
    L26:
        return null;
    L8:
        r13 = null;
    L6:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r14 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L13
    }
}
