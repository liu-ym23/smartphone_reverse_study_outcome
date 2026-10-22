package com.bytedance.retrofit2;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
abstract class p<T> {

    class a extends p<Iterable<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ p f2564a;

        a(p r10) {
            this.f2564a = r10;
        }

        @Override // com.bytedance.retrofit2.p
        /* bridge */ /* synthetic */ void a(com.bytedance.retrofit2.r r10, Object r11) {
            d(r10, (Iterable) r11);
        }

        void d(com.bytedance.retrofit2.r r10, Iterable<T> r11) {
            if (r11 != null) goto L4;
            return;
        L4:
            Iterator<T> r12 = r11.iterator();
        L6:
            if (r12.hasNext() == false) goto L8;
            T r13 = r12.next();
            this.f2564a.a(r10, r13);
            goto L6
        }
    }

    class b extends p<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ p f2565a;

        b(p r10) {
            this.f2565a = r10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.retrofit2.p
        void a(com.bytedance.retrofit2.r r10, Object r11) {
            if (r11 != null) goto L4;
            return;
        L4:
            int r12 = 0;
            int r13 = Array.getLength(r11);
        L5:
            if (r12 >= r13) goto L7;
            this.f2565a.a(r10, Array.get(r11, r12));
            r12 = r12 + 1;
            goto L5
        }
    }

    static final class c<T> extends p<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bytedance.retrofit2.f<T, String> f2566a;

        c(com.bytedance.retrofit2.f<T, String> r10) {
            this.f2566a = (com.bytedance.retrofit2.f) c0.a(r10, "converter == null");
        }

        @Override // com.bytedance.retrofit2.p
        void a(com.bytedance.retrofit2.r r10, T r11) {
            if (r11 != null) goto L9;
            return;
        L9:
            r10.l(Boolean.parseBoolean(this.f2566a.convert(r11)));     // Catch: IOException -> L6
            return;
        L6:
            e = move-exception;
            throw new RuntimeException("Unable to convert " + r11 + " to AddCommonParam", e);
        }
    }

    static final class d<T> extends p<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f2567a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f2568b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f2569c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final com.bytedance.retrofit2.f<T, r4.f> f2570d;

        d(Method r10, int r11, boolean r12, com.bytedance.retrofit2.f<T, r4.f> r13) {
            this.f2567a = r10;
            this.f2568b = r11;
            this.f2569c = r12;
            this.f2570d = r13;
        }

        @Override // com.bytedance.retrofit2.p
        void a(com.bytedance.retrofit2.r r10, T r11) {
            if (r11 == null) goto L5;
            r10.n(this.f2570d.convert(r11));
            return;
        L12:
            e = move-exception;
            throw c0.r(this.f2567a, e, this.f2568b, "Unable to convert " + r11 + " to RequestBody", new Object[0]);
        L5:
            if (this.f2569c == false) goto L8;
            return;
        L8:
            throw c0.q(this.f2567a, this.f2568b, "Body parameter value must not be null.", new Object[0]);
        }
    }

    static final class e extends p<okhttp3.y> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final e f2571a = null;

        static {
            f2571a = new e();
        }

        e() {
        }

        @Override // com.bytedance.retrofit2.p
        /* bridge */ /* synthetic */ void a(com.bytedance.retrofit2.r r10, okhttp3.y r11) {
            d(r10, r11);
        }

        void d(com.bytedance.retrofit2.r r10, okhttp3.y r11) {
            if (r11 == null) goto L6;
            r10.m(r11);
            r10.t();
            return;
        L6:
            throw new IllegalArgumentException("Body parameter value must not be null.");
        }
    }

    static final class f extends p<okhttp3.y> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final okhttp3.r f2572a;

        f(okhttp3.r r10) {
            this.f2572a = r10;
        }

        @Override // com.bytedance.retrofit2.p
        /* bridge */ /* synthetic */ void a(com.bytedance.retrofit2.r r10, okhttp3.y r11) {
            d(r10, r11);
        }

        void d(com.bytedance.retrofit2.r r10, okhttp3.y r11) {
            if (r11 != null) goto L4;
            return;
        L4:
            r10.e(this.f2572a, r11);
            r10.t();
        }
    }

    static final class g extends p<Map<String, okhttp3.y>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f2573a;

        g(String r10) {
            this.f2573a = r10;
        }

        @Override // com.bytedance.retrofit2.p
        /* bridge */ /* synthetic */ void a(com.bytedance.retrofit2.r r10, Map<String, okhttp3.y> r11) {
            d(r10, r11);
        }

        void d(com.bytedance.retrofit2.r r10, Map<String, okhttp3.y> r11) {
            if (r11 == null) goto L18;
            Iterator<Map.Entry<String, okhttp3.y>> r12 = r11.entrySet().iterator();
        L5:
            if (r12.hasNext() == false) goto L15;
            Map.Entry<String, okhttp3.y> r13 = r12.next();
            String r14 = r13.getKey();
            if (r14 == null) goto L14;
            okhttp3.y r15 = r13.getValue();
            if (r15 == null) goto L12;
            r10.e(okhttp3.r.g(new String[]{"Content-Disposition", "form-data; name=\"" + r14 + "\"", "Content-Transfer-Encoding", this.f2573a}), r15);
            goto L5
        L12:
            throw new IllegalArgumentException("Part map contained null value for key '" + r14 + "'.");
        L14:
            throw new IllegalArgumentException("Part map contained null key.");
        L15:
            r10.t();
            return;
        L18:
            throw new IllegalArgumentException("Part map was null.");
        }
    }

    static final class h extends p<okhttp3.v.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final h f2574a = null;

        static {
            f2574a = new h();
        }

        h() {
        }

        @Override // com.bytedance.retrofit2.p
        /* bridge */ /* synthetic */ void a(com.bytedance.retrofit2.r r10, okhttp3.v.c r11) {
            d(r10, r11);
        }

        void d(com.bytedance.retrofit2.r r10, okhttp3.v.c r11) {
            if (r11 == null) goto L4;
            r10.f(r11);
        L4:
            r10.t();
        }
    }

    static final class i<T> extends p<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bytedance.retrofit2.f<T, Object> f2575a;

        i(com.bytedance.retrofit2.f<T, Object> r10) {
            this.f2575a = (com.bytedance.retrofit2.f) c0.a(r10, "converter == null");
        }

        @Override // com.bytedance.retrofit2.p
        void a(com.bytedance.retrofit2.r r10, T r11) {
            if (r11 != null) goto L9;
            return;
        L9:
            r10.o(this.f2575a.convert(r11));     // Catch: IOException -> L6
            return;
        L6:
            e = move-exception;
            throw new RuntimeException("Unable to convert " + r11 + " to ExtraInfo", e);
        }
    }

    static final class j<T> extends p<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f2576a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.bytedance.retrofit2.f<T, String> f2577b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f2578c;

        j(String r10, com.bytedance.retrofit2.f<T, String> r11, boolean r12) {
            this.f2576a = (String) c0.a(r10, "name == null");
            this.f2577b = r11;
            this.f2578c = r12;
        }

        @Override // com.bytedance.retrofit2.p
        void a(com.bytedance.retrofit2.r r10, T r11) {
            if (r11 != null) goto L4;
            return;
        L4:
            String r12 = this.f2577b.convert(r11);
            if (r12 != null) goto L7;
            return;
        L7:
            r10.a(this.f2576a, r12, this.f2578c);
        }
    }

    static final class k<T> extends p<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f2579a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f2580b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.bytedance.retrofit2.f<T, String> f2581c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f2582d;

        k(Method r10, int r11, com.bytedance.retrofit2.f<T, String> r12, boolean r13) {
            this.f2579a = r10;
            this.f2580b = r11;
            this.f2581c = r12;
            this.f2582d = r13;
        }

        @Override // com.bytedance.retrofit2.p
        /* bridge */ /* synthetic */ void a(com.bytedance.retrofit2.r r10, Object r11) {
            d(r10, (Map) r11);
        }

        void d(com.bytedance.retrofit2.r r10, Map<String, T> r11) {
            if (r11 == null) goto L22;
            Iterator<Map.Entry<String, T>> r12 = r11.entrySet().iterator();
        L6:
            if (r12.hasNext() == false) goto L20;
            Map.Entry<String, T> r13 = r12.next();
            String r14 = r13.getKey();
            if (r14 == null) goto L19;
            T r15 = r13.getValue();
            if (r15 == null) goto L17;
            String r16 = this.f2581c.convert(r15);
            if (r16 == null) goto L15;
            r10.a(r14, r16, this.f2582d);
            goto L6
        L15:
            throw c0.q(this.f2579a, this.f2580b, "Field map value '" + r15 + "' converted to null by " + this.f2581c.getClass().getName() + " for key '" + r14 + "'.", new Object[0]);
        L17:
            throw c0.q(this.f2579a, this.f2580b, "Field map contained null value for key '" + r14 + "'.", new Object[0]);
        L19:
            throw c0.q(this.f2579a, this.f2580b, "Field map contained null key.", new Object[0]);
        L20:
            return;
        L22:
            throw c0.q(this.f2579a, this.f2580b, "Field map was null.", new Object[0]);
        }
    }

    static final class l<T> extends p<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f2583a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.bytedance.retrofit2.f<T, String> f2584b;

        l(String r10, com.bytedance.retrofit2.f<T, String> r11) {
            this.f2583a = (String) c0.a(r10, "name == null");
            this.f2584b = r11;
        }

        @Override // com.bytedance.retrofit2.p
        void a(com.bytedance.retrofit2.r r10, T r11) {
            if (r11 != null) goto L4;
            return;
        L4:
            String r12 = this.f2584b.convert(r11);
            if (r12 != null) goto L7;
            return;
        L7:
            r10.b(this.f2583a, r12);
        }
    }

    static final class m<T> extends p<List<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bytedance.retrofit2.f<T, n4.b> f2585a;

        m(com.bytedance.retrofit2.f<T, n4.b> r10) {
            this.f2585a = r10;
        }

        @Override // com.bytedance.retrofit2.p
        /* bridge */ /* synthetic */ void a(com.bytedance.retrofit2.r r10, Object r11) {
            d(r10, (List) r11);
        }

        void d(com.bytedance.retrofit2.r r10, List<T> r11) {
            if (r11 != null) goto L4;
            return;
        L4:
            Iterator<T> r12 = r11.iterator();
        L6:
            if (r12.hasNext() == false) goto L8;
            T r13 = r12.next();
            n4.b r14 = this.f2585a.convert(r13);
            r10.b(r14.a(), r14.b());
            goto L6
        }
    }

    static final class n<T> extends p<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f2586a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f2587b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.bytedance.retrofit2.f<T, String> f2588c;

        n(Method r10, int r11, com.bytedance.retrofit2.f<T, String> r12) {
            this.f2586a = r10;
            this.f2587b = r11;
            this.f2588c = r12;
        }

        @Override // com.bytedance.retrofit2.p
        /* bridge */ /* synthetic */ void a(com.bytedance.retrofit2.r r10, Object r11) {
            d(r10, (Map) r11);
        }

        void d(com.bytedance.retrofit2.r r10, Map<String, T> r11) {
            if (r11 == null) goto L18;
            Iterator<Map.Entry<String, T>> r12 = r11.entrySet().iterator();
        L6:
            if (r12.hasNext() == false) goto L16;
            Map.Entry<String, T> r13 = r12.next();
            String r14 = r13.getKey();
            if (r14 == null) goto L15;
            T r15 = r13.getValue();
            if (r15 == null) goto L13;
            r10.b(r14, this.f2588c.convert(r15));
            goto L6
        L13:
            throw c0.q(this.f2586a, this.f2587b, "Header map contained null value for key '" + r14 + "'.", new Object[0]);
        L15:
            throw c0.q(this.f2586a, this.f2587b, "Header map contained null key.", new Object[0]);
        L16:
            return;
        L18:
            throw c0.q(this.f2586a, this.f2587b, "Header map was null.", new Object[0]);
        }
    }

    static final class o<T> extends p<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bytedance.retrofit2.f<T, String> f2589a;

        o(com.bytedance.retrofit2.f<T, String> r10) {
            this.f2589a = (com.bytedance.retrofit2.f) c0.a(r10, "converter == null");
        }

        @Override // com.bytedance.retrofit2.p
        void a(com.bytedance.retrofit2.r r10, T r11) {
            if (r11 != null) goto L9;
            return;
        L9:
            r10.p(Integer.parseInt(this.f2589a.convert(r11)));     // Catch: IOException -> L6
            return;
        L6:
            e = move-exception;
            throw new RuntimeException("Unable to convert " + r11 + " to MaxLength", e);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.retrofit2.p$p, reason: collision with other inner class name */
    static final class C0070p<T> extends p<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f2590a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.bytedance.retrofit2.f<T, String> f2591b;

        C0070p(String r10, com.bytedance.retrofit2.f<T, String> r11) {
            this.f2590a = (String) c0.a(r10, "name == null");
            this.f2591b = r11;
        }

        @Override // com.bytedance.retrofit2.p
        void a(com.bytedance.retrofit2.r r10, T r11) {
            if (r11 == null) goto L6;
            r10.q(this.f2590a, this.f2591b.convert(r11));
            return;
        L6:
            throw new IllegalArgumentException("Method parameter \"" + this.f2590a + "\" value must not be null.");
        }
    }

    static final class q<T> extends p<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f2592a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f2593b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f2594c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final com.bytedance.retrofit2.f<T, r4.f> f2595d;

        q(Method r10, int r11, String r12, com.bytedance.retrofit2.f<T, r4.f> r13) {
            this.f2592a = r10;
            this.f2593b = r11;
            this.f2594c = r12;
            this.f2595d = r13;
        }

        @Override // com.bytedance.retrofit2.p
        void a(com.bytedance.retrofit2.r r10, T r11) {
            if (r11 != null) goto L10;
            return;
        L10:
            r10.d(this.f2594c, this.f2595d.convert(r11));
            return;
        L7:
            e = move-exception;
            throw c0.q(this.f2592a, this.f2593b, "Unable to convert " + r11 + " to RequestBody", new Object[]{e});
        }
    }

    static final class r<T> extends p<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f2596a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f2597b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.bytedance.retrofit2.f<T, r4.f> f2598c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f2599d;

        r(Method r10, int r11, com.bytedance.retrofit2.f<T, r4.f> r12, String r13) {
            this.f2596a = r10;
            this.f2597b = r11;
            this.f2598c = r12;
            this.f2599d = r13;
        }

        @Override // com.bytedance.retrofit2.p
        /* bridge */ /* synthetic */ void a(com.bytedance.retrofit2.r r10, Object r11) {
            d(r10, (Map) r11);
        }

        void d(com.bytedance.retrofit2.r r10, Map<String, T> r11) {
            if (r11 == null) goto L18;
            Iterator<Map.Entry<String, T>> r12 = r11.entrySet().iterator();
        L6:
            if (r12.hasNext() == false) goto L16;
            Map.Entry<String, T> r13 = r12.next();
            String r14 = r13.getKey();
            if (r14 == null) goto L15;
            T r15 = r13.getValue();
            if (r15 == null) goto L13;
            r10.c(r14, this.f2599d, this.f2598c.convert(r15));
            goto L6
        L13:
            throw c0.q(this.f2596a, this.f2597b, "Part map contained null value for key '" + r14 + "'.", new Object[0]);
        L15:
            throw c0.q(this.f2596a, this.f2597b, "Part map contained null key.", new Object[0]);
        L16:
            return;
        L18:
            throw c0.q(this.f2596a, this.f2597b, "Part map was null.", new Object[0]);
        }
    }

    static final class s<T> extends p<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f2600a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f2601b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f2602c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final com.bytedance.retrofit2.f<T, String> f2603d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f2604e;

        s(Method r10, int r11, String r12, com.bytedance.retrofit2.f<T, String> r13, boolean r14) {
            this.f2600a = r10;
            this.f2601b = r11;
            this.f2602c = (String) c0.a(r12, "name == null");
            this.f2603d = r13;
            this.f2604e = r14;
        }

        @Override // com.bytedance.retrofit2.p
        void a(com.bytedance.retrofit2.r r10, T r11) {
            if (r11 == null) goto L6;
            r10.g(this.f2602c, this.f2603d.convert(r11), this.f2604e);
            return;
        L6:
            throw c0.q(this.f2600a, this.f2601b, "Path parameter \"" + this.f2602c + "\" value must not be null.", new Object[0]);
        }
    }

    static final class t<T> extends p<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f2605a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.bytedance.retrofit2.f<T, String> f2606b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f2607c;

        t(String r10, com.bytedance.retrofit2.f<T, String> r11, boolean r12) {
            this.f2605a = (String) c0.a(r10, "name == null");
            this.f2606b = r11;
            this.f2607c = r12;
        }

        @Override // com.bytedance.retrofit2.p
        void a(com.bytedance.retrofit2.r r10, T r11) {
            if (r11 != null) goto L4;
            return;
        L4:
            String r12 = this.f2606b.convert(r11);
            if (r12 != null) goto L7;
            return;
        L7:
            r10.h(this.f2605a, r12, this.f2607c);
        }
    }

    static final class u<T> extends p<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f2608a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f2609b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.bytedance.retrofit2.f<T, String> f2610c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f2611d;

        u(Method r10, int r11, com.bytedance.retrofit2.f<T, String> r12, boolean r13) {
            this.f2608a = r10;
            this.f2609b = r11;
            this.f2610c = r12;
            this.f2611d = r13;
        }

        @Override // com.bytedance.retrofit2.p
        /* bridge */ /* synthetic */ void a(com.bytedance.retrofit2.r r10, Object r11) {
            d(r10, (Map) r11);
        }

        void d(com.bytedance.retrofit2.r r10, Map<String, T> r11) {
            if (r11 != null) goto L4;
            return;
        L4:
            Iterator<Map.Entry<String, T>> r12 = r11.entrySet().iterator();
        L6:
            if (r12.hasNext() == false) goto L19;
            Map.Entry<String, T> r13 = r12.next();
            String r14 = r13.getKey();
            if (r14 == null) goto L18;
            T r15 = r13.getValue();
            if (r15 == null) goto L6;
            String r16 = this.f2610c.convert(r15);
            if (r16 == null) goto L16;
            r10.h(r14, r16, this.f2611d);
            goto L6
        L16:
            throw c0.q(this.f2608a, this.f2609b, "Query map value '" + r15 + "' converted to null by " + this.f2610c.getClass().getName() + " for key '" + r14 + "'.", new Object[0]);
        L18:
            throw c0.q(this.f2608a, this.f2609b, "Query map contained null key.", new Object[0]);
        }
    }

    static final class v<T> extends p<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bytedance.retrofit2.f<T, String> f2612a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f2613b;

        v(com.bytedance.retrofit2.f<T, String> r10, boolean r11) {
            this.f2612a = r10;
            this.f2613b = r11;
        }

        @Override // com.bytedance.retrofit2.p
        void a(com.bytedance.retrofit2.r r10, T r11) {
            if (r11 != null) goto L4;
            return;
        L4:
            r10.h(this.f2612a.convert(r11), null, this.f2613b);
        }
    }

    static final class w<T> extends p<T> {
        w() {
        }

        @Override // com.bytedance.retrofit2.p
        void a(com.bytedance.retrofit2.r r10, T r11) {
            if (r11 != null) goto L5;
            return;
        L5:
            if ((r11 instanceof p4.b) == false) goto L9;
            r10.r(((p4.b) r11).a());
            return;
        L9:
            throw new RuntimeException("wrong type:" + r11.getClass() + ",not implement QueryParamObject");
        }
    }

    static final class x extends p<Object> {
        x(Method r10, int r11) {
        }

        @Override // com.bytedance.retrofit2.p
        void a(com.bytedance.retrofit2.r r10, Object r11) {
            r10.s(r11);
        }
    }

    static final class y<T> extends p<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Class<T> f2614a;

        y(Class<T> r10) {
            this.f2614a = r10;
        }

        @Override // com.bytedance.retrofit2.p
        void a(com.bytedance.retrofit2.r r10, T r11) {
            r10.i(this.f2614a, r11);
        }
    }

    p() {
    }

    abstract void a(com.bytedance.retrofit2.r r10, T r11);

    final p<Object> b() {
        return new b(this);
    }

    final p<Iterable<T>> c() {
        return new a(this);
    }
}
