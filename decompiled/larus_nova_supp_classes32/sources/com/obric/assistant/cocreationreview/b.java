package com.obric.assistant.cocreationreview;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class b {

    public static final class a extends b {
        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L8;
            return false;
        L8:
            ((a) r4).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "Editable(meta=null)";
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.cocreationreview.b$b, reason: collision with other inner class name */
    public static final class C0079b extends b {
        public static final C0079b a = null;

        static {
            a = new C0079b();
        }

        public C0079b() {
        }
    }

    public static final class c extends b {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }
    }

    public b() {
    }
}
