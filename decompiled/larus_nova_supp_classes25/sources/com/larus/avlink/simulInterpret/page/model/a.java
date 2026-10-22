package com.larus.avlink.simulInterpret.page.model;

import com.larus.common.apphost.AppHost;
import hq9.z0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public static final a e = null;
    public static final a f = null;
    public final String a;
    public final String b;
    public final String c;
    public final boolean d;

    /* JADX INFO: renamed from: com.larus.avlink.simulInterpret.page.model.a$a, reason: collision with other inner class name */
    public static final class C0026a {
        public C0026a() {
        }

        public static /* synthetic */ a b(String r1) {
            return a(r1, CollectionsKt.emptyList());
        }

        public static List c(List r7) {
            Intrinsics.checkNotNullParameter(r7, "configList");
            ArrayList r0 = new ArrayList();
            LinkedHashSet r1 = new LinkedHashSet();
            a r2 = a.e;
            r0.add(r2);
            r1.add(r2.b);
            a r3 = a.f;
            r0.add(r3);
            r1.add(r3.b);
            Iterator r8 = r7.iterator();
        L4:
            if (r8.hasNext() == false) goto L21;
            z0 r4 = (z0) r8.next();
            String r5 = r4.a();
            String r6 = r4.b();
            Boolean r9 = r4.d();
            if (r9 == null) goto L8;
            boolean r10 = r9.booleanValue();
        L9:
            if (r5 == null) goto L4;
            if (r6 == null) goto L4;
            if (r1.contains(r5) == true) goto L4;
            if (r10 == false) goto L17;
            String r11 = r4.c();
            if (r11 == null) goto L19;
        L20:
            r0.add(new a(r6, r5, r11, r10));
            r1.add(r5);
        L19:
            r11 = "Listening...";
            goto L20
        L17:
            r11 = r4.c();
            if (r11 != null) goto L20;
        L8:
            r10 = false;
            goto L9
        L21:
            return r0;
        }

        public static a a(String r3, List r4) {
            Intrinsics.checkNotNullParameter(r4, "configList");
            if (Intrinsics.areEqual(r3, "zh") == false) goto L7;
            return a.e;
        L7:
            if (Intrinsics.areEqual(r3, "en") == true) goto L9;
            if (r3 == null) goto L26;
            Iterator r5 = r4.iterator();
        L13:
            if (r5.hasNext() == false) goto L34;
            z0 r0 = (z0) r5.next();
            String r1 = r0.b();
            if (Intrinsics.areEqual(r0.a(), r3) == false) goto L13;
            if (r1 == null) goto L13;
            String r2 = r0.c();
            if (r2 != null) goto L20;
            r2 = "Listening...";
        L20:
            Boolean r6 = r0.d();
            if (r6 == null) goto L23;
            boolean r7 = r6.booleanValue();
        L25:
            return new a(r1, r3, r2, r7);
        L23:
            r7 = false;
            goto L25
        L34:
            return null;
        L26:
            return null;
        L9:
            return a.f;
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "Language(showText=" + this.a + ", code=" + this.b + ", waitingText=" + this.c + ", isPrimary=" + this.d + ')';
    }

    static {
        new C0026a();
        AppHost.Companion r1 = AppHost.a;
        e = new a(r1.getApplication().getString(2131900835), "zh", (String) ea8.b.a.getValue(), true);
        f = new a(r1.getApplication().getString(2131905492), "en", "Listening...", true);
    }

    public a(String r2, String r3, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "showText");
        Intrinsics.checkNotNullParameter(r3, "code");
        Intrinsics.checkNotNullParameter(r4, "waitingText");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
