package com.bytedance.awemeopen.infra.base.player.surface;

import android.content.Context;
import android.util.Log;
import android.view.Surface;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class AbsSurfaceSource implements com.bytedance.awemeopen.infra.base.player.surface.a.InterfaceC0192a {
    public final com.bytedance.awemeopen.infra.base.player.h a;
    public final e b;
    public com.bytedance.awemeopen.infra.base.player.surface.a c;
    public final AtomicBoolean d;

    public static final class a {
    }

    static {
    }

    public abstract i a(Context r1);

    public final Surface b() {
        com.bytedance.awemeopen.infra.base.player.surface.a r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSurface();
    }

    public final void c() {
        final Ref.ObjectRef r0 = new Ref.ObjectRef();
        com.bytedance.awemeopen.infra.base.player.surface.a r1 = this.c;
        if (r1 == null) goto L31;
        Surface r2 = r1.getSurface();
        if (r2 == null) goto L35;
        r0.element = r2;
        com.bytedance.awemeopen.infra.base.player.h r3 = this.a;
        if (r3 == null) goto L12;
        com.bytedance.awemeopen.infra.base.player.g r4 = r3.getCustomPlayer();
        if (r4 == null) goto L12;
        final String r5 = r4.g();
    L13:
        AoLogger.g("AbsSurfaceSource", new Object[]{"onSurfaceAvailable#" + ((Surface) r0.element).hashCode() + " aid=" + r5 + " hasDestroyed=" + this.d.get()});
        e r6 = this.b;
        Surface r7 = (Surface) r0.element;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "surface");
        c r8 = r6.a;
        if (r8 == null) goto L16;
        r8.a(r7);
    L16:
        Surface r9 = (Surface) r0.element;
        Intrinsics.checkNotNullParameter(r9, "surface");
        d r10 = r6.b;
        if (r10 == null) goto L19;
        r10.a(r9);
    L19:
        Surface r11 = (Surface) r0.element;
        Intrinsics.checkNotNullParameter(r11, "surface");
        b r12 = r6.c;
        if (r12 == null) goto L22;
        r12.a(r11);
    L22:
        r6.b = null;
        r6.a = null;
        r6.c = null;
        com.bytedance.awemeopen.infra.base.player.h r13 = this.a;
        if (r13 == null) goto L32;
        final com.bytedance.awemeopen.infra.base.player.g r14 = r13.getCustomPlayer();
        if (r14 == null) goto L33;
        Function0<Unit> r15 = new AbsSurfaceSource$onSurfaceAvailableInner$2$1$action$1(r14, r0, r5);
        if (this.d.getAndSet(false) == false) goto L29;
        r13.a(r15);
        return;
    L29:
        r15.invoke();
        return;
    L33:
        return;
    L32:
        return;
    L12:
        r5 = null;
        goto L13
    L35:
        return;
    }

    public final void d() {
        com.bytedance.awemeopen.infra.base.player.surface.a r0 = this.c;
        if (r0 == null) goto L5;
        Surface r1 = r0.getSurface();
    L6:
        com.bytedance.awemeopen.infra.base.player.h r2 = this.a;
        if (r2 == null) goto L11;
        com.bytedance.awemeopen.infra.base.player.g r3 = r2.getCustomPlayer();
        if (r3 == null) goto L11;
        String r4 = r3.g();
    L12:
        Object[] r5 = new Object[1];
        StringBuilder r6 = new StringBuilder("onSurfaceDestroyed#");
        if (r1 == null) goto L15;
        int r7 = r1.hashCode();
    L16:
        r6.append(r7);
        r6.append(" aid=");
        r6.append(r4);
        r5[0] = r6.toString();
        AoLogger.g("AbsSurfaceSource", r5);
        this.d.set(true);
        e r8 = this.b;
        r8.b = null;
        r8.a = null;
        r8.c = null;
        return;
    L15:
        r7 = 0;
    L11:
        r4 = null;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.awemeopen.infra.base.player.surface.a.InterfaceC0192a
    public final void onSurfaceAvailable() {
        c();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        AoLogger.c("AbsSurfaceSource", new Object[]{"onSurfaceAvailable\n" + Log.getStackTraceString(e)});
    }

    @Override // com.bytedance.awemeopen.infra.base.player.surface.a.InterfaceC0192a
    public final void onSurfaceDestroyed() {
        d();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        AoLogger.c("AbsSurfaceSource", new Object[]{"onSurfaceDestroyed\n" + Log.getStackTraceString(e)});
    }

    public AbsSurfaceSource(com.bytedance.awemeopen.infra.base.player.h r2) {
        this.a = r2;
        this.b = new e();
        this.d = new AtomicBoolean(false);
    }
}
