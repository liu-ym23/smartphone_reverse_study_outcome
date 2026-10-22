package fj0;

import kotlin.jvm.internal.Intrinsics;
import tf0.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements l {
    public String a;
    public boolean b;
    public boolean c;
    public long d;
    public long e;
    public long f;
    public boolean g;
    public int h;
    public int i;

    /* JADX INFO: renamed from: fj0.a$a, reason: collision with other inner class name */
    public static final class C0209a {
    }

    static {
    }

    public static long a() {
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.k().c == false) goto L6;
        int r0 = com.bytedance.android.live.liveinteract.api.data.a.C0017a.k().a;
    L12:
        return r0;
    L6:
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.h().c == false) goto L9;
        r0 = com.bytedance.android.live.liveinteract.api.data.a.C0017a.h().a;
        goto L12
    L9:
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.a().c == false) goto L13;
        r0 = com.bytedance.android.live.liveinteract.api.data.a.C0017a.a().a;
        goto L12
    L13:
        return 0;
    }

    public static long b() {
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.k().c == false) goto L6;
        int r0 = com.bytedance.android.live.liveinteract.api.data.a.C0017a.k().b;
    L12:
        return r0;
    L6:
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.h().c == false) goto L9;
        r0 = com.bytedance.android.live.liveinteract.api.data.a.C0017a.h().b;
        goto L12
    L9:
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.a().c == false) goto L13;
        r0 = com.bytedance.android.live.liveinteract.api.data.a.C0017a.a().b;
        goto L12
    L13:
        return 0;
    }

    public final a d() {
        a r0 = new a();
        r0.a = this.a;
        r0.b = this.b;
        r0.c = this.c;
        r0.d = this.d;
        r0.e = this.e;
        r0.f = this.f;
        r0.g = this.g;
        r0.h = this.h;
        r0.i = this.i;
        return r0;
    }

    public a() {
        this.a = "";
    }

    public final void c(a r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        this.a = r3.a;
        this.b = r3.b;
        this.c = r3.c;
        this.d = r3.d;
        this.e = r3.e;
        this.f = r3.f;
        this.g = r3.g;
        this.h = r3.h;
        this.i = r3.i;
    }
}
