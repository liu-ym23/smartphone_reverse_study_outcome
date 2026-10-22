package com.loc;

import android.content.Context;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: classes3.dex */
public class ax {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static boolean f5338a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static int f5339b = 20;
    private static int c = 20;
    private static WeakReference<as> d;
    private static int e;

    static class a extends bq {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static int f5340a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static int f5341b = 2;
        static int c = 3;
        private Context e;
        private aw f;
        private int g;
        private List<aw> h;

        static {
        }

        a(Context r3, int r4) {
            this.e = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
            this.g = r4;
        }

        a(Context r3, int r4, aw r5) {
            this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4);
            this.f = r5;
        }

        a(Context r3, int r4, List<aw> r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            List<aw> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            this(r6, r4);
            this.h = r7;
        }

        @Override // com.loc.bq
        public final void a() {
            int r0 = this.g;
            if (r0 != 1) goto L30;
        L25:
            th = th;
            String r1 = "stm";
            String r2 = "as";
        L27:
            q.b(th, r1, r2);
            return;
        L5:
            if (this.e != null) goto L7;
            return;
        L7:
            if (this.f != null) goto L10;
            return;
        L10:
            monitor-enter(ax.class);     // Catch: Throwable -> L25
            Context r3 = this.e;     // Catch: Throwable -> L21
            if (r3 == null) goto L19;
            aw r4 = this.f;     // Catch: Throwable -> L21
            if (r4 == null) goto L19;
            ax.a(r3, r4.a());     // Catch: Throwable -> L21
            monitor-exit(ax.class);     // Catch: Throwable -> L21
            return;
        L19:
            monitor-exit(ax.class);     // Catch: Throwable -> L21
            return;
        L21:
            th = move-exception;
            throw th;     // Catch: Throwable -> L25
        L30:
            if (r0 != 2) goto L82;
            monitor-enter(ax.class);     // Catch: Throwable -> L79
        L76:
            th = move-exception;
            throw th;     // Catch: Throwable -> L79
        L34:
            if (this.h != null) goto L36;
        L74:
            monitor-exit(ax.class);     // Catch: Throwable -> L76
            return;
        L36:
            if (this.e == null) goto L74;
            ByteArrayOutputStream r5 = null;
            byte[] r6 = new byte[0];     // Catch: Throwable -> L76
            ByteArrayOutputStream r7 = new ByteArrayOutputStream();     // Catch: Throwable -> L55
            Iterator<aw> r8 = this.h.iterator();     // Catch: Throwable -> L53
        L42:
            if (r8.hasNext() == false) goto L46;
            aw r9 = (aw) ZeusTransformUtils.preCheckCast(r8.next(), aw.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L53
            if (r9 == null) goto L42;
            r7.write(r9.a());     // Catch: Throwable -> L53
            goto L42
        L46:
            r6 = r7.toByteArray();     // Catch: Throwable -> L53
            r7.close();     // Catch: Throwable -> L49
        L62:
            ax.a(this.e, r6);     // Catch: Throwable -> L76
            monitor-exit(ax.class);     // Catch: Throwable -> L76
            return;
        L49:
            th = move-exception;
            Throwable r10 = th;
        L51:
            r10.printStackTrace();     // Catch: Throwable -> L76
        L53:
            th = th;
            r5 = r7;
        L109:
            q.b(th, "stm", "aStB");     // Catch: Throwable -> L65
            if (r5 == null) goto L62;
            r5.close();     // Catch: Throwable -> L60
        L60:
            th = move-exception;
            r10 = th;
            goto L51
        L65:
            th = move-exception;
            if (r5 == null) goto L124;
            r5.close();     // Catch: Throwable -> L70
        L125:
            throw th;     // Catch: Throwable -> L76
        L70:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L76
            throw th;     // Catch: Throwable -> L76
        L124:
            throw th;     // Catch: Throwable -> L76
        L55:
            th = th;
        L79:
            th = th;
            r1 = "stm";
            r2 = "apb";
            goto L27
        L82:
            if (r0 != 3) goto L126;
        L97:
            th = move-exception;
            q.b(th, "stm", "usd");
            return;
        L84:
            if (this.e != null) goto L86;
            return;
        L86:
            as r11 = ay.a(ax.a());     // Catch: Throwable -> L97
            ay.a(this.e, r11, o.h, 1000, 307200, "2");     // Catch: Throwable -> L97
            if (r11.g != null) goto L89;
            r11.g = new az(new bd(this.e, new ba(new be(new bg()))));     // Catch: Throwable -> L97
        L89:
            r11.h = 3600000;     // Catch: Throwable -> L97
            if (TextUtils.isEmpty(r11.i) == false) goto L93;
            r11.i = "cKey";     // Catch: Throwable -> L97
        L93:
            if (r11.f != null) goto L95;
            r11.f = new bk(this.e, r11.h, r11.i, new bh(r11.f5328a, new bi(this.e, ax.f5338a, ax.b() * 1024, ax.f5339b * 1024, "staticUpdate", ax.c() * 1024)));     // Catch: Throwable -> L97
        L95:
            at.a(r11);     // Catch: Throwable -> L97
            return;
        }
    }

    static {
    }

    public ax() {
    }

    static /* synthetic */ WeakReference a() {
        return d;
    }

    public static void a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        bp.a().b(new a(r4, a.c));
    }

    static /* synthetic */ void a(Context r6, byte[] r7) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        as r8 = ay.a(d);
        ay.a(r0, r8, o.h, 1000, 307200, "2");
        if (r8.e != null) goto L11;
        r8.e = new aa();
    L11:
        at.a(Integer.toString(new Random().nextInt(100)) + Long.toString(System.nanoTime()), r7, r8);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        q.b(th, "stm", "wts");
    }

    public static synchronized void a(aw r4, Context r5) {
        monitor-enter(ax.class);
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        bp.a().b(new a(r6, a.f5340a, r4));     // Catch: Throwable -> L7
        monitor-exit(ax.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void a(List<aw> r4, Context r5) {
        monitor-enter(ax.class);
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        if (r6 != null) goto L19;
    L14:
        monitor-exit(ax.class);
        return;
    L19:
        if (r6.size() == 0) goto L14;
        bp.a().b(new a(r7, a.f5341b, r6));     // Catch: Throwable -> L12
        monitor-exit(ax.class);
        return;
    L13:
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public static synchronized void a(boolean r1, int r2) {
        monitor-enter(ax.class);
        f5338a = r1;     // Catch: Throwable -> L7
        e = Math.max(0, r2);     // Catch: Throwable -> L7
        monitor-exit(ax.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ int b() {
        return c;
    }

    public static synchronized void b(List<aw> r3, Context r4) {
        monitor-enter(ax.class);
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        List<aw> r1 = an.b();     // Catch: Throwable -> L16
        if (r1 == null) goto L10;
        if (r1.size() <= 0) goto L10;
        r5.addAll(r1);     // Catch: Throwable -> L16
    L10:
        a(r5, r6);     // Catch: Throwable -> L13
        monitor-exit(ax.class);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ int c() {
        return e;
    }
}
