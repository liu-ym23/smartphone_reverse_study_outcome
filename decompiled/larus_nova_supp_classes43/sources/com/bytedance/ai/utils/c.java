package com.bytedance.ai.utils;

import com.bytedance.ai.model.objects.PageInfo;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final LinkedHashSet<a> a = null;
    public static final String b = null;

    public static final class a {
        public final PageInfo a;
        public final WeakReference<k2.j> b;
        public final int c;
        public boolean d;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r11.c) goto L18;
            return false;
        L18:
            if (this.d == r11.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31;
            if (this.d == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "AppletPageInfo(pageInfo=" + this.a + ", pageView=" + this.b + ", fragmentHashCode=" + this.c + ", isPaused=" + this.d + ')';
        }

        public a(PageInfo r10, WeakReference r11, int r12) {
            Intrinsics.checkNotNullParameter(r10, "pageInfo");
            Intrinsics.checkNotNullParameter(r11, "pageView");
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = false;
        }
    }

    static {
        a = new LinkedHashSet();
        b = "AppletPageManager";
    }

    public static boolean a(int r10) {
        Iterator<T> r0 = a.iterator();
    L3:
        String r11 = null;
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((a) r1).c != r10) goto L8;
        boolean r12 = true;
    L9:
        if (r12 == false) goto L3;
    L12:
        a r13 = (a) r1;
        g r14 = g.a;
        String r15 = b;
        StringBuilder r16 = new StringBuilder("popPage Page ");
        if (r13 == null) goto L17;
        PageInfo r17 = r13.a;
        if (r17 == null) goto L17;
        r11 = r17.getPageName();
    L17:
        r16.append(r11);
        r16.append(" to ");
        r16.append(r10);
        r14.d(r15, r16.toString());
        if (r13 != null) goto L20;
        return false;
    L20:
        return a.remove(r13);
    L8:
        r12 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    public static void c(int r10, boolean r11) {
        Iterator<T> r0 = a.iterator();
    L3:
        String r12 = null;
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((a) r1).c != r10) goto L8;
        boolean r13 = true;
    L9:
        if (r13 == false) goto L3;
    L12:
        a r14 = (a) r1;
        g r15 = g.a;
        String r16 = b;
        StringBuilder r17 = new StringBuilder("updatePagePauseState Page ");
        if (r14 == null) goto L17;
        PageInfo r18 = r14.a;
        if (r18 == null) goto L17;
        r12 = r18.getPageName();
    L17:
        r17.append(r12);
        r17.append(" to ");
        r17.append(r11);
        r15.d(r16, r17.toString());
        if (r14 == null) goto L28;
        r14.d = r11;
        if (r11 == true) goto L29;
        LinkedHashSet<a> r19 = a;
        r19.remove(r14);
        r19.add(r14);
        return;
    L29:
        return;
    L28:
        return;
    L8:
        r13 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    public static void b(PageInfo r10, com.bytedance.ai.model.widgets.c r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "pageInfo");
        Intrinsics.checkNotNullParameter(r11, "appletPage");
        Iterator<T> r0 = a.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((a) r1).c != r12) goto L8;
        boolean r13 = true;
    L9:
        if (r13 == false) goto L4;
    L12:
        a r14 = (a) r1;
        if (r14 == null) goto L15;
        a.remove(r14);
    L15:
        g.a.d(b, "push Page " + r10.getPageName() + " to " + r12);
        a.add(new a(r10, new WeakReference(r11), r12));
        return;
    L8:
        r13 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }
}
