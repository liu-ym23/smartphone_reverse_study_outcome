package com.ss.android.lark.framework.assembly.diskmanage;

import android.app.Application;
import com.larksuite.framework.utils.FileUtils;
import com.larksuite.framework.utils.l;
import com.ss.android.lark.diskmanage.Biz;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.a0;
import ebb.f;
import ebb.g;
import ebb.h;
import ebb.j;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Singleton
public final class a implements g {
    public final Provider<Set<f>> a;
    public final h b;

    /* JADX INFO: renamed from: com.ss.android.lark.framework.assembly.diskmanage.a$a, reason: collision with other inner class name */
    public static final class C0079a {
    }

    static {
    }

    public final void b() {
    }

    public final Biz getBiz() {
        return Biz.DEFAULT;
    }

    public static cbb.a c(ArrayList r5) {
        Iterator r6 = r5.iterator();
        long r0 = 0;
    L4:
        if (r6.hasNext() == false) goto L7;
        File r2 = (File) r6.next();
        r0 = r0 + r2.length();
        FileUtils.g(r2.getPath());
        goto L4
    L7:
        return new cbb.a(true, r0, 4);
    }

    public final cbb.a a(cbb.d r8) {
        Intrinsics.checkNotNullParameter(r8, "remoteConfig");
        Application r0 = LarkContext.getApplication();
        new j().b(r0, j.c(r8.b));     // Catch: Exception -> L5
    L8:
        if (this.b.a() == false) goto L15;
        Log.w("DefaultCleanTask", "disk space is low, use manual clean");
        Application r9 = LarkContext.getApplication();
        HashSet r1 = new HashSet();
        Object r2 = ebb.e.a;
        int r3 = com.ss.android.lark.diskmanage.storage.d.a;
        Intrinsics.checkNotNull(r9);
        r1.addAll(ebb.e.d(com.ss.android.lark.diskmanage.storage.d.i(r9), 1));
        r1.addAll(ebb.e.d(com.ss.android.lark.diskmanage.storage.d.m(r9), 1));
        r1.addAll(ebb.e.d(com.ss.android.lark.diskmanage.storage.d.d(r9), 0));
        r1.addAll(ebb.e.d(com.ss.android.lark.diskmanage.storage.d.r(r9), 0));
        r1.addAll(ebb.e.d(com.ss.android.lark.diskmanage.storage.d.b(r9), 0));
        r1.addAll(ebb.e.c(com.ss.android.lark.diskmanage.storage.d.n(r9), 3));
        r1.addAll(ebb.e.c(com.ss.android.lark.diskmanage.storage.d.o(r9), 3));
        r1.addAll(ebb.e.d(a0.f(r9), 3));
        Iterator r4 = ((Iterable) this.a.get()).iterator();
    L11:
        if (r4.hasNext() == false) goto L14;
        r1.addAll(((f) r4.next()).b(r9));
        goto L11
    L14:
        return c(new ArrayList(r1));
    L15:
        Application r10 = LarkContext.getApplication();
        ArrayList r5 = new ArrayList();
        eac.a r6 = eac.a.a();
        float r7 = 1.0f;
        if (r6.getBoolean("small_disk_on", false) == false) goto L18;
        r7 = r6.getFloat("disk_timeout_factor", 1.0f);
    L18:
        int r11 = (int) (2 * r7);
        Object r12 = ebb.e.a;
        int r13 = com.ss.android.lark.diskmanage.storage.d.a;
        Intrinsics.checkNotNull(r10);
        r5.addAll(ebb.e.d(com.ss.android.lark.diskmanage.storage.d.r(r10), r11));
        Intrinsics.checkNotNullParameter(r10, "context");
        String r14 = com.ss.android.lark.diskmanage.storage.d.i(r10) + "/zip/";
        FileUtils.t(r14);
        r5.addAll(ebb.e.d(r14, r11));
        int r15 = (int) (7 * r7);
        r5.addAll(ebb.e.c(com.ss.android.lark.diskmanage.storage.d.n(r10), r15));
        r5.addAll(ebb.e.c(com.ss.android.lark.diskmanage.storage.d.o(r10), r15));
        int r16 = (int) (6 * r7);
        r5.addAll(ebb.e.d(com.ss.android.lark.diskmanage.storage.d.i(r10), r16));
        r5.addAll(ebb.e.d(com.ss.android.lark.diskmanage.storage.d.m(r10), r16));
        Intrinsics.checkNotNullParameter(r10, "context");
        StringBuilder r17 = new StringBuilder();
        r17.append(l.b(r10));
        String r18 = File.separator;
        r17.append(r18);
        r17.append("camera");
        r17.append(r18);
        String r19 = r17.toString();
        FileUtils.t(r19);
        r5.addAll(ebb.e.d(r19, r16));
        r5.addAll(ebb.e.d(com.ss.android.lark.diskmanage.storage.d.e(r10), r16));
        r5.addAll(ebb.e.d(com.ss.android.lark.diskmanage.storage.d.a(r10), r16));
        r5.addAll(ebb.e.d(com.ss.android.lark.diskmanage.storage.d.d(r10), r16));
        r5.addAll(ebb.e.d(a0.f(r10), r16));
        Iterator r20 = ((Iterable) this.a.get()).iterator();
    L20:
        if (r20.hasNext() == false) goto L22;
        r5.addAll(((f) r20.next()).a(r10));
        goto L20
    L22:
        int r21 = ebb.b.c;
        ebb.b r22 = ebb.b.b.a;
        monitor-enter(r22);
        ArrayList r23 = new ArrayList();     // Catch: Throwable -> L38
        Iterator r24 = r22.a.values().iterator();     // Catch: Throwable -> L38
    L26:
        if (r24.hasNext() == false) goto L31;
        g r25 = (g) r24.next();     // Catch: Throwable -> L38
        if (r25.getBiz() == Biz.DEFAULT) goto L26;
        r25.b();     // Catch: Throwable -> L38
        goto L26
    L31:
        monitor-exit(r22);
        Iterator r26 = r23.iterator();
    L34:
        if (r26.hasNext() == false) goto L37;
        cbb.b r27 = (cbb.b) r26.next();
        Object r28 = ebb.e.a;
        r5.addAll(ebb.e.d(r27.a, (int) (r27.b * r7)));
        goto L34
    L37:
        return c(r5);
    L38:
        th = move-exception;
        throw th;
    L5:
        e = move-exception;
        Log.i("RemoteDeleteHandler", "handleRemoteDelete error");
        e.printStackTrace();
        goto L8
    }

    @Inject
    public a(Provider<Set<f>> r2, h r3) {
        Intrinsics.checkNotNullParameter(r2, "cleanFileProvider");
        Intrinsics.checkNotNullParameter(r3, "manuDiskCleanTrigger");
        this.a = r2;
        this.b = r3;
    }
}
