package com.bytedance.ai.applet.app.foundation.performance;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class f {

    public static final class a extends f {
        public final long a;
        public final long b;
        public final com.bytedance.ai.applet.app.foundation.performance.g.a c;
        public final Long d;
        public final AppletPerformanceNavigationType e;
        public final AppletPerformanceMetric f;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (this.a == r11.a) goto L12;
            return false;
        L12:
            if (this.b == r11.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
            return false;
        L21:
            if (this.e == r11.e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            long r10 = this.b;
            int r11 = (((r1 + ((int) (r10 ^ (r10 >>> 32)))) * 31) + this.c.hashCode()) * 31;
            Long r12 = this.d;
            int r13 = 0;
            if (r12 != null) goto L5;
            int r14 = 0;
        L6:
            int r15 = (r11 + r14) * 31;
            AppletPerformanceNavigationType r16 = this.e;
            if (r16 == null) goto L11;
            r13 = r16.hashCode();
        L11:
            return r15 + r13;
        L5:
            r14 = r12.hashCode();
            goto L6
        }

        public final String toString() {
            return "AppLaunch(startTime=" + this.a + ", duration=" + this.b + ", source=" + this.c + ", navigationStart=" + this.d + ", navigationType=" + this.e + ')';
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final boolean d() {
            if (Long.valueOf(this.b).longValue() < 0) goto L13;
            Long r0 = this.d;
            if (r0 != null) goto L7;
        L9:
            boolean r1 = false;
        L10:
            if (r1 == true) goto L14;
            return true;
        L14:
            return false;
        L7:
            if (com.bytedance.ai.applet.app.foundation.performance.h.a(r0.longValue()) == true) goto L9;
            r1 = true;
            goto L10
        L13:
            return false;
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final AppletPerformanceMetric a() {
            return this.f;
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final com.bytedance.ai.applet.app.foundation.performance.g b() {
            return this.c;
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final long c() {
            return this.a;
        }

        public a(long r10, long r11, com.bytedance.ai.applet.app.foundation.performance.g.a r12, Long r13, AppletPerformanceNavigationType r14) {
            Intrinsics.checkNotNullParameter(r12, "source");
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = r13;
            this.e = r14;
            this.f = AppletPerformanceMetric.APP_LAUNCH;
        }
    }

    public static final class b extends f {
        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final AppletPerformanceMetric a() {
            return null;
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final /* bridge */ /* synthetic */ com.bytedance.ai.applet.app.foundation.performance.g b() {
            return null;
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final long c() {
            return 0;
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            ((b) r10).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(null, null) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "DownloadPackage(startTime=0, duration=0, source=null, packageName=null, packageSize=0)";
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final boolean d() {
            Long r10 = 0L;
            if (r10.longValue() >= 0) goto L5;
        L7:
            return false;
        L5:
            if ((!StringsKt.isBlank(null)) == false) goto L7;
            return true;
        }
    }

    public static final class c extends f {
        public final long a;
        public final long b;
        public final com.bytedance.ai.applet.app.foundation.performance.g c;
        public final String d;
        public final AppletPerformanceMetric e;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof c) == true) goto L8;
            return false;
        L8:
            c r11 = (c) r10;
            if (this.a == r11.a) goto L12;
            return false;
        L12:
            if (this.b == r11.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r11.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            long r10 = this.b;
            return ((((r1 + ((int) (r10 ^ (r10 >>> 32)))) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public final String toString() {
            return "EvaluateScript(startTime=" + this.a + ", duration=" + this.b + ", source=" + this.c + ", moduleName=" + this.d + ')';
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final boolean d() {
            if (Long.valueOf(this.b).longValue() >= 0) goto L5;
        L7:
            return false;
        L5:
            if ((!StringsKt.isBlank(this.d)) == false) goto L7;
            return true;
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final AppletPerformanceMetric a() {
            return this.e;
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final com.bytedance.ai.applet.app.foundation.performance.g b() {
            return this.c;
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final long c() {
            return this.a;
        }

        public c(long r10, long r11, com.bytedance.ai.applet.app.foundation.performance.g r12, String r13) {
            Intrinsics.checkNotNullParameter(r12, "source");
            Intrinsics.checkNotNullParameter(r13, "moduleName");
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = r13;
            this.e = AppletPerformanceMetric.EVALUATE_SCRIPT;
        }
    }

    public static final class d extends f {
        public final long a;
        public final i b;
        public final AppletPerformanceMetric c;

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final boolean d() {
            return true;
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof d) == true) goto L8;
            return false;
        L8:
            d r11 = (d) r10;
            if (this.a == r11.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            return (((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "FirstContentfulPaint(startTime=" + this.a + ", source=" + this.b + ')';
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final AppletPerformanceMetric a() {
            return this.c;
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final com.bytedance.ai.applet.app.foundation.performance.g b() {
            return this.b;
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final long c() {
            return this.a;
        }

        public d(long r10, i r11) {
            Intrinsics.checkNotNullParameter(r11, "source");
            this.a = r10;
            this.b = r11;
            this.c = AppletPerformanceMetric.FIRST_CONTENTFUL_PAINT;
        }
    }

    public static final class e extends f {
        public final long a;
        public final i b;
        public final AppletPerformanceMetric c;

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final boolean d() {
            return true;
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof e) == true) goto L8;
            return false;
        L8:
            e r11 = (e) r10;
            if (this.a == r11.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            return (((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "FirstPaint(startTime=" + this.a + ", source=" + this.b + ')';
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final AppletPerformanceMetric a() {
            return this.c;
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final com.bytedance.ai.applet.app.foundation.performance.g b() {
            return this.b;
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final long c() {
            return this.a;
        }

        public e(long r10, i r11) {
            Intrinsics.checkNotNullParameter(r11, "source");
            this.a = r10;
            this.b = r11;
            this.c = AppletPerformanceMetric.FIRST_PAINT;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.applet.app.foundation.performance.f$f, reason: collision with other inner class name */
    public static final class C0016f extends f {
        public final long a;
        public final long b;
        public final i c;
        public final Long d;
        public final Long e;
        public final Long f;
        public final AppletPerformanceMetric g;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof C0016f) == true) goto L8;
            return false;
        L8:
            C0016f r11 = (C0016f) r10;
            if (this.a == r11.a) goto L12;
            return false;
        L12:
            if (this.b == r11.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r11.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r11.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            long r10 = this.b;
            int r11 = (((r1 + ((int) (r10 ^ (r10 >>> 32)))) * 31) + this.c.hashCode()) * 31;
            Long r12 = this.d;
            int r13 = 0;
            if (r12 != null) goto L5;
            int r14 = 0;
        L6:
            int r15 = (r11 + r14) * 31;
            Long r16 = this.e;
            if (r16 != null) goto L9;
            int r17 = 0;
        L10:
            int r18 = (r15 + r17) * 31;
            Long r19 = this.f;
            if (r19 == null) goto L15;
            r13 = r19.hashCode();
        L15:
            return r18 + r13;
        L9:
            r17 = r16.hashCode();
            goto L10
        L5:
            r14 = r12.hashCode();
            goto L6
        }

        public final String toString() {
            return "FirstRender(startTime=" + this.a + ", duration=" + this.b + ", source=" + this.c + ", viewLayerReadyTime=" + this.d + ", viewLayerRenderStartTime=" + this.e + ", viewLayerRenderEndTime=" + this.f + ')';
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final boolean d() {
            if (Long.valueOf(this.b).longValue() < 0) goto L22;
            List r0 = CollectionsKt.listOfNotNull(new Long[]{this.d, this.e, this.f});
            if ((r0 instanceof Collection) == true) goto L7;
        L9:
            Iterator r1 = r0.iterator();
        L11:
            if (r1.hasNext() == false) goto L15;
            if (com.bytedance.ai.applet.app.foundation.performance.h.a(((Number) r1.next()).longValue()) == true) goto L11;
            boolean r10 = false;
        L16:
            if (r10 == false) goto L23;
            return true;
        L23:
            return false;
        L15:
            r10 = true;
            goto L16
        L7:
            if (r0.isEmpty() == false) goto L9;
        L22:
            return false;
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final AppletPerformanceMetric a() {
            return this.g;
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final com.bytedance.ai.applet.app.foundation.performance.g b() {
            return this.c;
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final long c() {
            return this.a;
        }

        public C0016f(long r10, long r11, i r12, Long r13, Long r14, Long r15) {
            Intrinsics.checkNotNullParameter(r12, "source");
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = r13;
            this.e = r14;
            this.f = r15;
            this.g = AppletPerformanceMetric.FIRST_RENDER;
        }
    }

    public static final class g extends f {
        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final AppletPerformanceMetric a() {
            return null;
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final /* bridge */ /* synthetic */ com.bytedance.ai.applet.app.foundation.performance.g b() {
            return null;
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final long c() {
            return 0;
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof g) == true) goto L8;
            return false;
        L8:
            ((g) r10).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(null, null) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(null, null) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(null, null) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(null, null) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "ResourceTiming(startTime=0, duration=0, source=null, uri=null, initiatorType=null, transferSize=null, domainLookupStart=null, domainLookupEnd=null)";
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final boolean d() {
            Long r10 = 0L;
            if (r10.longValue() >= 0) goto L5;
            return false;
        L5:
            if ((!StringsKt.isBlank(null)) == false) goto L25;
            List r0 = CollectionsKt.listOfNotNull(new Long[]{null, null});
            if ((r0 instanceof Collection) == true) goto L9;
        L11:
            Iterator r1 = r0.iterator();
        L13:
            if (r1.hasNext() == false) goto L17;
            if (com.bytedance.ai.applet.app.foundation.performance.h.a(((Number) r1.next()).longValue()) == true) goto L13;
            boolean r11 = false;
        L18:
            if (r11 == false) goto L26;
            return true;
        L26:
            return false;
        L17:
            r11 = true;
            goto L18
        L9:
            if (r0.isEmpty() == false) goto L11;
        L25:
            return false;
        }
    }

    public static final class h extends f {
        public final long a;
        public final long b;
        public final com.bytedance.ai.applet.app.foundation.performance.g.a c;
        public final String d;
        public final Long e;
        public final Long f;
        public final AppletPerformanceNavigationType g;
        public final AppletPerformanceMetric h;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof h) == true) goto L8;
            return false;
        L8:
            h r11 = (h) r10;
            if (this.a == r11.a) goto L12;
            return false;
        L12:
            if (this.b == r11.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r11.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r11.f) == true) goto L27;
            return false;
        L27:
            if (this.g == r11.g) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            long r10 = this.b;
            int r11 = (((r1 + ((int) (r10 ^ (r10 >>> 32)))) * 31) + this.c.hashCode()) * 31;
            String r12 = this.d;
            int r13 = 0;
            if (r12 != null) goto L5;
            int r14 = 0;
        L6:
            int r15 = (r11 + r14) * 31;
            Long r16 = this.e;
            if (r16 != null) goto L9;
            int r17 = 0;
        L10:
            int r18 = (r15 + r17) * 31;
            Long r19 = this.f;
            if (r19 != null) goto L13;
            int r20 = 0;
        L14:
            int r21 = (r18 + r20) * 31;
            AppletPerformanceNavigationType r22 = this.g;
            if (r22 == null) goto L19;
            r13 = r22.hashCode();
        L19:
            return r21 + r13;
        L13:
            r20 = r19.hashCode();
            goto L14
        L9:
            r17 = r16.hashCode();
            goto L10
        L5:
            r14 = r12.hashCode();
            goto L6
        }

        public final String toString() {
            return "Route(startTime=" + this.a + ", duration=" + this.b + ", source=" + this.c + ", referrerPath=" + this.d + ", referrerTraceId=" + this.e + ", navigationStart=" + this.f + ", navigationType=" + this.g + ')';
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final boolean d() {
            if (Long.valueOf(this.b).longValue() < 0) goto L23;
            Long r0 = this.f;
            if (r0 != null) goto L7;
        L9:
            boolean r1 = false;
        L10:
            if (r1 == true) goto L24;
            Long r10 = this.e;
            if (r10 != null) goto L14;
        L19:
            boolean r11 = false;
        L20:
            if (r11 == true) goto L25;
            return true;
        L25:
            return false;
        L14:
            if (r10.longValue() <= 0) goto L16;
            boolean r12 = true;
        L17:
            if (r12 == true) goto L19;
            r11 = true;
            goto L20
        L16:
            r12 = false;
            goto L17
        L24:
            return false;
        L7:
            if (com.bytedance.ai.applet.app.foundation.performance.h.a(r0.longValue()) == true) goto L9;
            r1 = true;
            goto L10
        L23:
            return false;
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final AppletPerformanceMetric a() {
            return this.h;
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final com.bytedance.ai.applet.app.foundation.performance.g b() {
            return this.c;
        }

        @Override // com.bytedance.ai.applet.app.foundation.performance.f
        public final long c() {
            return this.a;
        }

        public h(long r10, long r11, com.bytedance.ai.applet.app.foundation.performance.g.a r12, String r13, Long r14, Long r15, AppletPerformanceNavigationType r16) {
            Intrinsics.checkNotNullParameter(r12, "source");
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = r13;
            this.e = r14;
            this.f = r15;
            this.g = r16;
            this.h = AppletPerformanceMetric.ROUTE;
        }
    }

    public f() {
    }

    public abstract AppletPerformanceMetric a();

    public abstract com.bytedance.ai.applet.app.foundation.performance.g b();

    public abstract long c();

    public abstract boolean d();

    public final boolean e() {
        if (com.bytedance.ai.applet.app.foundation.performance.h.a(c()) == false) goto L32;
        com.bytedance.ai.applet.app.foundation.performance.g r0 = b();
        if (r0.getTraceId() <= 0) goto L7;
        boolean r10 = true;
    L8:
        if (r10 == true) goto L11;
    L25:
        boolean r1 = false;
    L26:
        if (r1 == true) goto L28;
        return false;
    L28:
        if (d() == false) goto L34;
        return true;
    L34:
        return false;
    L11:
        if ((r0 instanceof com.bytedance.ai.applet.app.foundation.performance.g.a) == false) goto L16;
        if (StringsKt.isBlank(((com.bytedance.ai.applet.app.foundation.performance.g.a) r0).b) == true) goto L25;
    L24:
        r1 = true;
        goto L26
    L16:
        if ((r0 instanceof com.bytedance.ai.applet.app.foundation.performance.g.b) == true) goto L24;
        if ((r0 instanceof com.bytedance.ai.applet.app.foundation.performance.g.c) == false) goto L31;
        com.bytedance.ai.applet.app.foundation.performance.g.c r11 = (com.bytedance.ai.applet.app.foundation.performance.g.c) r0;
        if ((!StringsKt.isBlank(r11.b)) == false) goto L25;
        if ((!StringsKt.isBlank(r11.c)) == false) goto L25;
    L31:
        throw new NoWhenBranchMatchedException();
    L7:
        r10 = false;
        goto L8
    L32:
        return false;
    }
}
