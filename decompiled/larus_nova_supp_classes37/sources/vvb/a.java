package vvb;

import android.content.Context;
import android.view.View;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import rub.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final ConcurrentHashMap<String, C0201a> a = null;

    /* JADX INFO: renamed from: vvb.a$a, reason: collision with other inner class name */
    public static final class C0201a {
        public final Function1<Context, View> a;
        public final Function0<Unit> b;
        public final Function0<Unit> c;
        public final c d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0201a) == true) goto L8;
            return false;
        L8:
            C0201a r6 = (C0201a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(null, null) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            Function0<Unit> r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = (r0 + r2) * 31;
            Function0<Unit> r4 = this.c;
            if (r4 != null) goto L9;
            int r5 = 0;
        L11:
            return ((((r3 + r5) * 31) + this.d.hashCode()) * 31) + 0;
        L9:
            r5 = r4.hashCode();
            goto L11
        L5:
            r2 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "Entry(contentViewProvider=" + this.a + ", onDismiss=" + this.b + ", onShow=" + this.c + ", backgroundConfig=" + this.d + ", dismissConfig=null)";
        }

        public C0201a(Function1 r2, Function0 r3, Function0 r4, c r5) {
            Intrinsics.checkNotNullParameter(r2, "contentViewProvider");
            Intrinsics.checkNotNullParameter(r5, "backgroundConfig");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    static {
        a = new ConcurrentHashMap();
    }
}
