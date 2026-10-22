package com.ss.android.lark.image.compose.android_platform;

import com.ss.android.lark.image.entity.AvatarImage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface a {

    /* JADX INFO: renamed from: com.ss.android.lark.image.compose.android_platform.a$a, reason: collision with other inner class name */
    public static final class C0091a implements a {
        public final Object a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0091a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((C0091a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Custom(platformCustom=" + this.a + ')';
        }

        public C0091a(AvatarImage r2) {
            Intrinsics.checkNotNullParameter(r2, "platformCustom");
            this.a = r2;
        }
    }

    public static final class b implements a {
        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L8;
            return false;
        L8:
            ((b) r4).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "File(path=null)";
        }
    }

    public static final class c implements a {
        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof c) == true) goto L9;
            return false;
        L9:
            ((c) r3).getClass();
            return true;
        }

        public final int hashCode() {
            return 0;
        }

        public final String toString() {
            return "Res(id=0)";
        }
    }

    public static final class d implements a {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((d) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Url(url=" + this.a + ')';
        }

        public d(String r2) {
            Intrinsics.checkNotNullParameter(r2, "url");
            this.a = r2;
        }
    }
}
