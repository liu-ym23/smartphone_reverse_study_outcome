package com.ivy.ivykit.plugin.impl.jsb;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import de.e;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile b f9516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f9517c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList f9518a;

    static {
        com.lynx.tasm.utils.c r5 = new com.lynx.tasm.utils.c(8);
        b r10 = f9516b;
        if (r10 != null) goto L15;
        monitor-enter(r5);
        r10 = f9516b;     // Catch: Throwable -> L9
        if (r10 != null) goto L11;
        r10 = new b();     // Catch: Throwable -> L9
        f9516b = r10;     // Catch: Throwable -> L9
    L11:
        monitor-exit(r5);
    L9:
        th = move-exception;
        throw th;
    L15:
        f9517c = r10;
    }

    public b() {
        this.f9518a = new CopyOnWriteArrayList();
    }

    public final void a(Class r5) {
        if (r5 == null) goto L37;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L10
        if (ml.a.class.isAssignableFrom(r5) == false) goto L13;
        if (r5.newInstance() != null) goto L9;
    L32:
        IDLXBridgeMethod r11 = null;
    L33:
        if (r11 == null) goto L38;
        this.f9518a.add(r11);
        return;
    L38:
        return;
    L9:
        throw new ClassCastException();     // Catch: Throwable -> L10
    L13:
        if (de.c.class.isAssignableFrom(r5) == false) goto L20;
        if (r5.newInstance() == null) goto L32;
        throw new ClassCastException();     // Catch: Throwable -> L10
    L20:
        if (e.class.isAssignableFrom(r5) == false) goto L27;
        if (r5.newInstance() == null) goto L32;
        throw new ClassCastException();     // Catch: Throwable -> L10
    L27:
        if (IDLXBridgeMethod.class.isAssignableFrom(r5) == false) goto L29;
        r11 = (IDLXBridgeMethod) r5.newInstance();     // Catch: Throwable -> L10
        goto L33
    L29:
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L32
    }
}
