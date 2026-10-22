package com.larksuite.component.universe_design.emptystate.compose;

import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class e {

    public static final class a extends e {
        public final Painter a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "PainterImage(painter=" + this.a + ')';
        }

        public a(Painter r2) {
            Intrinsics.checkNotNullParameter(r2, "painter");
            this.a = r2;
        }
    }

    public static final class b extends e {
        public final ImageVector a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "VectorImage(imageVector=" + this.a + ')';
        }

        public b(ImageVector r2) {
            Intrinsics.checkNotNullParameter(r2, "imageVector");
            this.a = r2;
        }
    }

    public e() {
    }
}
