package com.larus.bmhome.social.page.datasource;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class g<T, Key> {
    public static final /* synthetic */ int b = 0;
    public final List<T> a;

    public static final class a {
    }

    public static final class b<T, Key> extends g<T, Key> {
        public final Object c;

        public b() {
            this(null);
        }

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.c, ((b) r4).c) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            Object r0 = this.c;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "Empty(nothing=" + this.c + ')';
        }

        public b(Object r2) {
            super(null);
            this.c = r2;
        }
    }

    public static final class c<T, Key> extends g<T, Key> {
        public final Throwable c;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.c, ((c) r4).c) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            Throwable r0 = this.c;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "Failed(error=" + this.c + ')';
        }

        public c(Throwable r2) {
            super(CollectionsKt.emptyList());
            this.c = r2;
        }
    }

    public static final class d<T, Key> extends g<T, Key> {
        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof d) == true) goto L8;
            return false;
        L8:
            ((d) r4).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(null, null) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(null, null) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "Success(list=null, prev=null, next=null)";
        }
    }

    static {
    }

    public g() {
        throw null;
    }

    public g(List r1) {
        this.a = r1;
    }
}
