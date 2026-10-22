package com.larus.bmhome.utils;

import android.net.Uri;
import com.larus.bmhome.share.panel.ShareType;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class n {

    public static final class a extends n {
        public final List<Uri> a;

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
            return "MediaContent(uriList=" + this.a + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(List<? extends Uri> r2) {
            Intrinsics.checkNotNullParameter(r2, "uriList");
            this.a = r2;
        }
    }

    public static final class b extends n {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    public static final class c extends n {
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
            return "TextContent(text=" + this.a + ')';
        }

        public c(String r2) {
            Intrinsics.checkNotNullParameter(r2, ShareType.TEXT);
            this.a = r2;
        }
    }

    public n() {
    }
}
