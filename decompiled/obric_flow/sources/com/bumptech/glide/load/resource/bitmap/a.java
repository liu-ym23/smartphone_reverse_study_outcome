package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.engine.d0;
import java.io.InputStream;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
public final class a implements z.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f1598c;

    public /* synthetic */ a(int r5, Object r10, Object r11) {
        this.f1596a = r5;
        this.f1597b = r10;
        this.f1598c = r11;
    }

    @Override // z.g
    public final boolean a(Object r5, z.f r10) {
        switch(this.f1596a) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L4;
        };
    L4:
        InputStream r11 = (InputStream) r5;
        return true;
    L7:
        return "android.resource".equals(((Uri) r5).getScheme());
    L9:
        return ((z.g) this.f1597b).a(r5, r10);
    }

    @Override // z.g
    public final d0 b(Object r14, int r15, int r16, z.f r17) {
        switch(this.f1596a) {
            case 0: goto L45;
            case 1: goto L40;
            default: goto L4;
        };
    L4:
        InputStream r5 = (InputStream) r14;
        if ((r5 instanceof s) == false) goto L7;
        s r10 = (s) r5;
        boolean r11 = false;
    L8:
        ArrayDeque r12 = q0.d.f21448c;
        monitor-enter(r12);
        q0.d r13 = (q0.d) r12.poll();     // Catch: Throwable -> L37
        monitor-exit(r12);     // Catch: Throwable -> L37
        if (r13 != null) goto L14;
        r13 = new q0.d();
    L14:
        q0.d r18 = r13;
        r18.f21449a = r10;
        kotlinx.metadata.internal.protobuf.a r19 = new kotlinx.metadata.internal.protobuf.a(r18);
        ai.p r20 = new ai.p(3, r10, r18);
        l r21 = (l) this.f1597b;     // Catch: Throwable -> L26
        c r22 = r21.a(new com.google.common.reflect.w(r21.f1623c, r19, r21.d), r15, r16, r17, r20);     // Catch: Throwable -> L26
        r18.f21450b = null;
        r18.f21449a = null;
        monitor-enter(r12);
        r12.offer(r18);     // Catch: Throwable -> L23
        monitor-exit(r12);     // Catch: Throwable -> L23
        if (r11 == false) goto L22;
        r10.d();
    L22:
        return r22;
    L23:
        th = move-exception;
        throw th;
    L26:
        th = move-exception;
        r18.f21450b = null;
        r18.f21449a = null;
        ArrayDeque r23 = q0.d.f21448c;
        monitor-enter(r23);
        r23.offer(r18);     // Catch: Throwable -> L34
        if (r11 == false) goto L33;
        r10.d();
    L33:
        throw th;
    L34:
        th = move-exception;
        throw th;
    L37:
        th = move-exception;
        throw th;
    L7:
        r11 = true;
        r10 = new s(r5, (com.bumptech.glide.load.engine.bitmap_recycle.f) this.f1598c);
        goto L8
    L40:
        d0 r24 = ((e) this.f1597b).c((Uri) r14);
        if (r24 != null) goto L44;
        return null;
    L44:
        return n.a((com.bumptech.glide.load.engine.bitmap_recycle.a) this.f1598c, (Drawable) ((h0.a) r24).get(), r15, r16);
    L45:
        d0 r25 = ((z.g) this.f1597b).b(r14, r15, r16, r17);
        if (r25 != null) goto L49;
        return null;
    L49:
        return new c((Resources) this.f1598c, r25);
    }

    public a(Resources r5, z.g r10) {
        this.f1596a = 0;
        this.f1598c = r5;
        this.f1597b = r10;
    }
}
