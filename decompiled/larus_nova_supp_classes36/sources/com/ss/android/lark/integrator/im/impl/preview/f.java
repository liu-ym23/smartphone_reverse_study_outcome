package com.ss.android.lark.integrator.im.impl.preview;

import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class f {

    public static final class a extends f {
        public final String a;
        public final long b;
        public final PreviewHangPoint c;
        public final UrlCardPreviewEntity d;
        public final Map<g, t6c.d> e;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r9.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            long r1 = this.b;
            return ((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public final String toString() {
            return "EntityReady(previewId=" + this.a + ", generation=" + this.b + ", hangPoint=" + this.c + ", entity=" + this.d + ')';
        }

        @Override // com.ss.android.lark.integrator.im.impl.preview.f
        public final UrlCardPreviewEntity a() {
            return this.d;
        }

        @Override // com.ss.android.lark.integrator.im.impl.preview.f
        public final long b() {
            return this.b;
        }

        @Override // com.ss.android.lark.integrator.im.impl.preview.f
        public final PreviewHangPoint c() {
            return this.c;
        }

        @Override // com.ss.android.lark.integrator.im.impl.preview.f
        public final String d() {
            return this.a;
        }

        @Override // com.ss.android.lark.integrator.im.impl.preview.f
        public final Map<g, t6c.d> e() {
            return this.e;
        }

        public a(String r2, long r3, PreviewHangPoint r5, UrlCardPreviewEntity r6) {
            Intrinsics.checkNotNullParameter(r2, "previewId");
            Intrinsics.checkNotNullParameter(r5, "hangPoint");
            Intrinsics.checkNotNullParameter(r6, "entity");
            this.a = r2;
            this.b = r3;
            this.c = r5;
            this.d = r6;
            this.e = MapsKt.emptyMap();
        }
    }

    public static final class b extends f {
        public final String a;
        public final long b;
        public final PreviewHangPoint c;
        public final Map<g, t6c.d> d;

        @Override // com.ss.android.lark.integrator.im.impl.preview.f
        public final UrlCardPreviewEntity a() {
            return null;
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof b) == true) goto L8;
            return false;
        L8:
            b r9 = (b) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r9.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            long r1 = this.b;
            return ((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "Pending(previewId=" + this.a + ", generation=" + this.b + ", hangPoint=" + this.c + ')';
        }

        @Override // com.ss.android.lark.integrator.im.impl.preview.f
        public final long b() {
            return this.b;
        }

        @Override // com.ss.android.lark.integrator.im.impl.preview.f
        public final PreviewHangPoint c() {
            return this.c;
        }

        @Override // com.ss.android.lark.integrator.im.impl.preview.f
        public final String d() {
            return this.a;
        }

        @Override // com.ss.android.lark.integrator.im.impl.preview.f
        public final Map<g, t6c.d> e() {
            return this.d;
        }

        public b(String r2, long r3, PreviewHangPoint r5) {
            Intrinsics.checkNotNullParameter(r2, "previewId");
            Intrinsics.checkNotNullParameter(r5, "hangPoint");
            this.a = r2;
            this.b = r3;
            this.c = r5;
            this.d = MapsKt.emptyMap();
        }
    }

    public static final class c extends f {
        public final String a;
        public final long b;
        public final PreviewHangPoint c;
        public final UrlCardPreviewEntity d;
        public final Map<g, t6c.d> e;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof c) == true) goto L8;
            return false;
        L8:
            c r9 = (c) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r9.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            long r1 = this.b;
            return ((((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
        }

        public final String toString() {
            return "RenderReady(previewId=" + this.a + ", generation=" + this.b + ", hangPoint=" + this.c + ", entity=" + this.d + ", renders=" + this.e + ')';
        }

        @Override // com.ss.android.lark.integrator.im.impl.preview.f
        public final UrlCardPreviewEntity a() {
            return this.d;
        }

        @Override // com.ss.android.lark.integrator.im.impl.preview.f
        public final long b() {
            return this.b;
        }

        @Override // com.ss.android.lark.integrator.im.impl.preview.f
        public final PreviewHangPoint c() {
            return this.c;
        }

        @Override // com.ss.android.lark.integrator.im.impl.preview.f
        public final String d() {
            return this.a;
        }

        @Override // com.ss.android.lark.integrator.im.impl.preview.f
        public final Map<g, t6c.d> e() {
            return this.e;
        }

        public c(String r2, long r3, PreviewHangPoint r5, UrlCardPreviewEntity r6, Map<g, t6c.d> r7) {
            Intrinsics.checkNotNullParameter(r2, "previewId");
            Intrinsics.checkNotNullParameter(r5, "hangPoint");
            Intrinsics.checkNotNullParameter(r6, "entity");
            Intrinsics.checkNotNullParameter(r7, "renders");
            this.a = r2;
            this.b = r3;
            this.c = r5;
            this.d = r6;
            this.e = r7;
        }
    }

    public f() {
    }

    public abstract UrlCardPreviewEntity a();

    public abstract long b();

    public abstract PreviewHangPoint c();

    public abstract String d();

    public abstract Map<g, t6c.d> e();
}
