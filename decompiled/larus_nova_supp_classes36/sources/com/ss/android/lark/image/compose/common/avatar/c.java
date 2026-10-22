package com.ss.android.lark.image.compose.common.avatar;

import androidx.compose.ui.graphics.painter.Painter;
import com.ss.android.lark.image.compose.android_platform.DrawablePainter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface c {

    public static final class a implements c {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // com.ss.android.lark.image.compose.common.avatar.c
        public final Painter a() {
            return null;
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof a) == true) goto L9;
            return false;
        L9:
            a r4 = (a) r3;
            return true;
        }

        public final int hashCode() {
            return -1759575281;
        }

        public final String toString() {
            return "Empty";
        }
    }

    public static final class b implements c {
        public final Painter a;
        public final com.ss.android.lark.image.compose.common.avatar.b b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            Painter r0 = this.a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + this.b.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public final String toString() {
            return "Error(painter=" + this.a + ", result=" + this.b + ')';
        }

        @Override // com.ss.android.lark.image.compose.common.avatar.c
        public final Painter a() {
            return this.a;
        }

        public b(Painter r3) {
            com.ss.android.lark.image.compose.common.avatar.b r0 = com.ss.android.lark.image.compose.common.avatar.b.a;
            Intrinsics.checkNotNullParameter(r0, "result");
            this.a = r3;
            this.b = r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.image.compose.common.avatar.c$c, reason: collision with other inner class name */
    public static final class C0092c implements c {
        public final Painter a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0092c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((C0092c) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            Painter r0 = this.a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "Loading(painter=" + this.a + ')';
        }

        @Override // com.ss.android.lark.image.compose.common.avatar.c
        public final Painter a() {
            return this.a;
        }

        public C0092c(Painter r1) {
            this.a = r1;
        }
    }

    public static final class d implements c {
        public final Painter a;
        public final com.ss.android.lark.image.compose.common.avatar.d b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "Success(painter=" + this.a + ", result=" + this.b + ')';
        }

        @Override // com.ss.android.lark.image.compose.common.avatar.c
        public final Painter a() {
            return this.a;
        }

        public d(DrawablePainter r3) {
            com.ss.android.lark.image.compose.common.avatar.d r0 = com.ss.android.lark.image.compose.common.avatar.d.a;
            Intrinsics.checkNotNullParameter(r3, "painter");
            Intrinsics.checkNotNullParameter(r0, "result");
            this.a = r3;
            this.b = r0;
        }
    }

    Painter a();
}
