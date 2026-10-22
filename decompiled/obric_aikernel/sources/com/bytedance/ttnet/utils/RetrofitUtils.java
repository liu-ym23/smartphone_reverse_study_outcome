package com.bytedance.ttnet.utils;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.g;
import com.bytedance.frameworks.baselib.network.http.parser.MimeType;
import com.bytedance.frameworks.baselib.network.http.util.e;
import com.bytedance.retrofit2.f;
import com.bytedance.retrofit2.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class RetrofitUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile CopyOnWriteArrayList<q4.a> f2932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static e<String, t> f2933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static e<String, t> f2934c;

    public static final enum CompressType extends Enum<CompressType> {
        private static final /* synthetic */ CompressType[] $VALUES = null;
        public static final CompressType DEFLATER = null;
        public static final CompressType GZIP = null;
        public static final CompressType NONE = null;
        final int nativeInt;

        static {
            CompressType r10 = new CompressType("NONE", 0, 0);
            NONE = r10;
            CompressType r11 = new CompressType("GZIP", 1, 1);
            GZIP = r11;
            CompressType r12 = new CompressType("DEFLATER", 2, 2);
            DEFLATER = r12;
            $VALUES = new CompressType[]{r10, r11, r12};
        }

        private CompressType(String r10, int r11, int r12) {
            super(r10, r11);
            this.nativeInt = r12;
        }

        public static CompressType valueOf(String r10) {
            return (CompressType) Enum.valueOf(CompressType.class, r10);
        }

        public static CompressType[] values() {
            return (CompressType[]) $VALUES.clone();
        }
    }

    class a implements n4.a.InterfaceC0245a {
        a() {
        }

        @Override // n4.a.InterfaceC0245a
        public n4.a get() {
            return new e5.b();
        }
    }

    class b implements n4.a.InterfaceC0245a {
        b() {
        }

        @Override // n4.a.InterfaceC0245a
        public n4.a get() {
            return new e5.b();
        }
    }

    static {
        f2932a = new CopyOnWriteArrayList();
        t.s(f2932a);
        f2933b = new e(10);
        f2934c = new e(10);
    }

    public static synchronized void a(q4.a r10) {
        monitor-enter(RetrofitUtils.class);
        if (r10 != null) goto L16;
        monitor-exit(RetrofitUtils.class);
        return;
    L16:
    L13:
        th = move-exception;
        throw th;
    L8:
        if (f2932a.contains(r10) == true) goto L10;
        f2932a.add(r10);     // Catch: Throwable -> L13
    L10:
        d.g(f2933b, r10);     // Catch: Throwable -> L13
        d.g(f2934c, r10);     // Catch: Throwable -> L13
        monitor-exit(RetrofitUtils.class);
    }

    public static synchronized t b(String r10, List<q4.a> r11, f.a r12, com.bytedance.retrofit2.c.a r13, n4.a.InterfaceC0245a r14) {
        monitor-enter(RetrofitUtils.class);
        ArrayList r15 = null;
        if (r12 != null) goto L17;
        ArrayList r16 = null;
    L10:
        if (r13 == null) goto L12;
        r15 = new ArrayList();     // Catch: Throwable -> L7
        r15.add(r13);     // Catch: Throwable -> L7
    L12:
        t r17 = c(r11, r16, r15, r14, r10);     // Catch: Throwable -> L7
        monitor-exit(RetrofitUtils.class);
        return r17;
    L7:
        th = move-exception;
        throw th;
    L17:
        r16 = new ArrayList();     // Catch: Throwable -> L7
        r16.add(r12);     // Catch: Throwable -> L7
        goto L10
    }

    public static synchronized t c(List<q4.a> r10, List<f.a> r11, List<com.bytedance.retrofit2.c.a> r12, n4.a.InterfaceC0245a r13, String r14) {
        monitor-enter(RetrofitUtils.class);
        if (r13 == null) goto L56;
    L6:
        t.b r15 = new t.b().h(r14).e(r13).f(new a3.c());     // Catch: Throwable -> L53
        if (r11 != null) goto L10;
        r11 = new ArrayList();     // Catch: Throwable -> L53
    L10:
        if (r11.isEmpty() == false) goto L12;
        r11.add(b3.a.f());     // Catch: Throwable -> L53
    L12:
        Iterator<f.a> r16 = r11.iterator();     // Catch: Throwable -> L53
    L14:
        if (r16.hasNext() == false) goto L16;
        r15.b(r16.next());     // Catch: Throwable -> L53
        goto L14
    L16:
        if (r12 != null) goto L18;
    L23:
        LinkedList r17 = new LinkedList();     // Catch: Throwable -> L53
        if (r10 != null) goto L26;
    L38:
        boolean r18 = false;
    L39:
        if (r18 == true) goto L42;
        r17.add(0, new e5.a());     // Catch: Throwable -> L53
    L42:
        if (f2932a != null) goto L44;
    L46:
        r17.add(new a3.b());     // Catch: Throwable -> L53
        Iterator r19 = r17.iterator();     // Catch: Throwable -> L53
    L48:
        if (r19.hasNext() == false) goto L50;
        r15.c((q4.a) r19.next());     // Catch: Throwable -> L53
        goto L48
    L50:
        t r20 = r15.d();     // Catch: Throwable -> L53
        monitor-exit(RetrofitUtils.class);
        return r20;
    L53:
        th = move-exception;
        throw th;
    L44:
        if (f2932a.size() <= 0) goto L46;
        r17.addAll(f2932a);     // Catch: Throwable -> L53
        goto L46
    L26:
        if (r10.size() <= 0) goto L38;
        Iterator<q4.a> r21 = r10.iterator();     // Catch: Throwable -> L53
        r18 = false;
    L29:
        if (r21.hasNext() == false) goto L39;
        q4.a r22 = r21.next();     // Catch: Throwable -> L53
        if ((r22 instanceof e5.a) == true) goto L32;
        if ((r22 instanceof a3.b) == true) goto L29;
    L37:
        r17.add(r22);     // Catch: Throwable -> L53
        goto L29
    L32:
        if (r18 == true) goto L29;
        r17.add(r22);     // Catch: Throwable -> L53
        r18 = true;
        goto L37
    L18:
        if (r12.isEmpty() == true) goto L23;
        Iterator<com.bytedance.retrofit2.c.a> r23 = r12.iterator();     // Catch: Throwable -> L53
    L21:
        if (r23.hasNext() == false) goto L23;
        r15.a(r23.next());     // Catch: Throwable -> L53
        goto L21
    L56:
        r13 = new b();     // Catch: Throwable -> L53
        goto L6
    }

    public static synchronized <S> S d(t r10, Class<S> r11) {
        monitor-enter(RetrofitUtils.class);
        if (r10 == null) goto L12;
        S r12 = (S) r10.e(r11);
        monitor-exit(RetrofitUtils.class);
        return r12;
    L8:
        th = move-exception;
        throw th;
    L12:
        monitor-exit(RetrofitUtils.class);
        return null;
    }

    public static synchronized t e(String r10, List<q4.a> r11, f.a r12) {
        monitor-enter(RetrofitUtils.class);
        t r13 = f(r10, r11, r12, null);     // Catch: Throwable -> L8
        monitor-exit(RetrofitUtils.class);
        return r13;
    L8:
        th = move-exception;
        throw th;
    }

    public static synchronized t f(String r10, List<q4.a> r11, f.a r12, com.bytedance.retrofit2.c.a r13) {
        monitor-enter(RetrofitUtils.class);
        t r14 = b(r10, r11, r12, r13, new a());     // Catch: Throwable -> L7
        monitor-exit(RetrofitUtils.class);
        return r14;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized <S> S g(String r10, Class<S> r11) {
        monitor-enter(RetrofitUtils.class);
        S r12 = (S) d(i(r10), r11);
        monitor-exit(RetrofitUtils.class);
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    public static String h(List<n4.b> r10, String r11) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (r10.isEmpty() == false) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(r11) == true) goto L23;
        Iterator<n4.b> r12 = r10.iterator();
    L10:
        if (r12.hasNext() == false) goto L15;
        n4.b r13 = r12.next();
        if (r11.equalsIgnoreCase(r13.a()) == false) goto L10;
        return r13.b();
    L15:
        return "";
    L23:
        return null;
    }

    public static synchronized t i(String r10) {
        monitor-enter(RetrofitUtils.class);
    L16:
        th = move-exception;
        throw th;
    L6:
        if (g.b(r10) == false) goto L9;
        monitor-exit(RetrofitUtils.class);
        return null;
    L9:
        t r11 = f2933b.d(r10);     // Catch: Throwable -> L16
        if (r11 == null) goto L13;
        monitor-exit(RetrofitUtils.class);
        return r11;
    L13:
        t r12 = f(r10, null, null, null);     // Catch: Throwable -> L16
        f2933b.f(r10, r12);     // Catch: Throwable -> L16
        monitor-exit(RetrofitUtils.class);
        return r12;
    }

    public static Pair<String, String> j(String r10) {
        String r11 = null;
        if (r10 != null) goto L17;
        return null;
    L17:
        MimeType r12 = new MimeType(r10);     // Catch: Throwable -> L10
        String r13 = r12.getBaseType();     // Catch: Throwable -> L10
        r11 = r12.getParameter("charset");     // Catch: Throwable -> L8
    L14:
        return new Pair(r13, r11);
    L8:
        th = th;
    L12:
        th.printStackTrace();
    L10:
        th = th;
        r13 = null;
        goto L12
    }
}
