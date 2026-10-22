package com.bytedance.android.ec.core.address;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class u {
    public final ArrayList<a> a;
    public int b;

    public final class a {
        public final String a;
        public final WeakReference<Object> b;
        public final String c;
        public final String d;
        public final String e;

        public a(WeakReference r10, String r11, String r12, String r13) {
            Intrinsics.checkNotNullParameter(r10, "node");
            Intrinsics.checkNotNullParameter(r11, "topActivityHash");
            Intrinsics.checkNotNullParameter(r12, "topFragmentHash");
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
            this.a = u.a(r10.get(), r13);
        }
    }

    public u() {
        this.a = new ArrayList();
        this.b = 50;
    }

    public static String a(Object r1, String r10) {
        if (r1 != null) goto L6;
        if (r10 != null) goto L7;
        return "";
    L7:
        return r10;
    L6:
        return "0x" + Integer.toHexString(System.identityHashCode(r1));
    }

    public final void b(Object r10, String r11) {
        String r12 = a(r10, r11);
        ArrayList r13 = new ArrayList();
        boolean r0 = false;
    L4:
        if ((!this.a.isEmpty()) == false) goto L18;
        if (r0 == true) goto L26;
        a r1 = (a) CollectionsKt.lastOrNull(this.a);
        if (r1 == null) goto L11;
        WeakReference<Object> r14 = r1.b;
        if (r14 == null) goto L11;
        r14.get();
    L11:
        if (r1 == null) goto L13;
        String r15 = r1.a;
    L15:
        if (Intrinsics.areEqual(r15, r12) == true) goto L16;
        ArrayList<a> r16 = this.a;
        r13.add(ListProtector.remove(r16, CollectionsKt.getLastIndex(r16)));
        goto L4
    L16:
        r0 = true;
        goto L4
    L13:
        r15 = null;
        goto L15
    L26:
        return;
    }
}
