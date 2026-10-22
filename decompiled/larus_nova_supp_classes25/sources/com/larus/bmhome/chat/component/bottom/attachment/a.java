package com.larus.bmhome.chat.component.bottom.attachment;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface a {

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.attachment.a$a, reason: collision with other inner class name */
    public static final class C0043a implements a {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0043a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((C0043a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Drive(token=" + this.a + ')';
        }

        public C0043a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "token");
            this.a = r2;
        }
    }

    public static final class b implements a {
        public final Uri a;

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
            return "Local(uri=" + this.a + ')';
        }

        public b(Uri r2) {
            Intrinsics.checkNotNullParameter(r2, "uri");
            this.a = r2;
        }
    }

    public static final class c implements a {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((c) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Remote(url=" + this.a + ')';
        }

        public c(String r2) {
            Intrinsics.checkNotNullParameter(r2, "url");
            this.a = r2;
        }
    }
}
