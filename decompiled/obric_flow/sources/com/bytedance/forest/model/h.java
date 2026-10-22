package com.bytedance.forest.model;

import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ForestBuffer f4375a;

    public h(ForestBuffer r5) {
        this.f4375a = r5;
    }

    public final boolean a(w r10) {
        if (ForestBuffer.access$getExceptionHandlerHandled$p(this.f4375a).compareAndSet(false, true) == true) goto L5;
        return false;
    L5:
        Request r5 = r10.f4441q;
        if (this.f4375a.getReferenceCount$forest_release().get() <= 1) goto L8;
    L37:
        return false;
    L8:
        if (r10.f4444u != ResourceFrom.f4340c) goto L37;
        if (com.bytedance.forest.utils.q.b() == true) goto L37;
        if ((r5.getNetDepender$forest_release() instanceof com.bytedance.forest.pollyfill.q) == false) goto L37;
        ForestBuffer r11 = this.f4375a;
        monitor-enter(r11);
    L22:
        th = move-exception;
        throw th;
    L16:
        if (this.f4375a.isCacheClear$forest_release() == true) goto L19;
        monitor-exit(r11);
        return true;
    L19:
        AtomicBoolean r12 = com.bytedance.forest.pollyfill.q.f4535b;     // Catch: Throwable -> L22
        String r13 = r5.getUrl();     // Catch: Throwable -> L22
        this.f4375a.getContext$forest_release();     // Catch: Throwable -> L22
        com.bytedance.forest.pollyfill.c r14 = com.bytedance.forest.pollyfill.n.a(r13, r5);     // Catch: Throwable -> L22
        if (r14 == null) goto L24;
        com.bytedance.forest.pollyfill.d r15 = com.bytedance.forest.pollyfill.n.b(r10, r14, this.f4375a.getContext$forest_release());     // Catch: Throwable -> L22
    L25:
        if (r15 == null) goto L33;
        InputStream r16 = r15.b();     // Catch: Throwable -> L22
        if (r16 == null) goto L33;
        if (this.f4375a.replaceOriginInputStream$forest_release(r16) == false) goto L32;
        monitor-exit(r11);
        return true;
    L32:
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L22
    L33:
        monitor-exit(r11);
        goto L37
    L24:
        r15 = null;
        goto L25
    }
}
