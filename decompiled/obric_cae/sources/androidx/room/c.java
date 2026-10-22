package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a1.c.InterfaceC0001c f2604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r.e f2605d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<r.b> f2606e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f2607f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final r.d f2608g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Executor f2609h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Executor f2610i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Intent f2611j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f2612k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f2613l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Set<Integer> f2614m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Callable<InputStream> f2615n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<Object> f2616o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<Object> f2617p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f2618q;

    @SuppressLint({"LambdaLast"})
    public c(Context r8, String r10, a1.c.InterfaceC0001c r11, r.e r12, ArrayList r13, boolean r14, r.d r15, Executor r16, Executor r17, boolean r18, boolean r19, LinkedHashSet r110, ArrayList r111, ArrayList r112) {
        he.i.f(r8, "context");
        he.i.f(r12, "migrationContainer");
        he.i.f(r111, "typeConverters");
        he.i.f(r112, "autoMigrationSpecs");
        this.f2602a = r8;
        this.f2603b = r10;
        this.f2604c = r11;
        this.f2605d = r12;
        this.f2606e = r13;
        this.f2607f = r14;
        this.f2608g = r15;
        this.f2609h = r16;
        this.f2610i = r17;
        this.f2611j = null;
        this.f2612k = r18;
        this.f2613l = r19;
        this.f2614m = r110;
        this.f2615n = null;
        this.f2616o = r111;
        this.f2617p = r112;
        this.f2618q = false;
    }

    public final boolean a(int r8, int r10) {
        if (r8 <= r10) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L11;
        if (this.f2613l == false) goto L11;
        return false;
    L11:
        if (this.f2612k == false) goto L18;
        Set<Integer> r12 = this.f2614m;
        if (r12 != null) goto L15;
        return true;
    L15:
        if (r12.contains(Integer.valueOf(r8)) == true) goto L18;
        return true;
    L18:
        return false;
    L5:
        r11 = false;
        goto L6
    }
}
