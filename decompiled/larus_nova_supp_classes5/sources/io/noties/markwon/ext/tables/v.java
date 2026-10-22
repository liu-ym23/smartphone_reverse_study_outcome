package io.noties.markwon.ext.tables;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;
import vvc.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class v implements e.b, pvc.a {
    public final f a;

    public static class a extends e$a {
        public final f a;

        public a(f r1) {
            this.a = r1;
        }

        @Override // wvc.e
        public final wvc.f a(wvc.g r14, org.commonmark.internal.h.a r15) {
            org.commonmark.internal.h r16 = (org.commonmark.internal.h) r14;
            CharSequence r0 = r16.a;
            CharSequence r7 = r15.a();
            if (r7 != null) goto L5;
            return null;
        L5:
            if ((r7 instanceof StringBuilder) == true) goto L7;
            CharSequence r1 = null;
        L8:
            StringBuilder r9 = (StringBuilder) r1;
            if (r9 == null) goto L30;
            String r17 = (String) CollectionsKt.last(StringsKt.split$default(r7, new String[]{"\n"}, false, 0, 6, null));
            if (StringsKt.contains$default(r17, "|", false, 2, null) == false) goto L29;
            List r2 = e.j(r0.subSequence(r16.b, r0.length()));
            if (r2 != null) goto L15;
        L18:
            boolean r3 = true;
        L19:
            if (r3 == true) goto L29;
            List r4 = e.k(r17);
            ArrayList r5 = (ArrayList) r2;
            if (r5.size() < ((ArrayList) r4).size()) goto L29;
            int r6 = r9.length();
            int r8 = r6 - r17.length();
            if (r8 <= 0) goto L27;
            int r10 = r8 - 1;
            if (((StringBuilder) r7).charAt(r10) != '\n') goto L27;
            r8 = r10;
        L27:
            r9.delete(r8, r6);
            org.commonmark.internal.d r18 = new org.commonmark.internal.d(new wvc.d[]{new e(r5, r4, r17, this.a.a)});
            r18.b = r16.b;
            return r18;
        L15:
            if (((ArrayList) r2).isEmpty() == true) goto L18;
            r3 = false;
        L29:
            return null;
        L30:
            CharSequence r11 = r16.a;
            CharSequence r19 = r15.a();
            if (r19 == null) goto L45;
            StringBuilder r12 = (StringBuilder) r19;
            if (r12.toString().contains("|") == true) goto L35;
            return null;
        L35:
            if (r12.toString().contains("\n") == true) goto L47;
            List r13 = e.j(r11.subSequence(r16.b, r11.length()));
            if (r13 == null) goto L48;
            ArrayList r20 = (ArrayList) r13;
            if (r20.isEmpty() == true) goto L49;
            List r110 = e.k(r19);
            if (r20.size() < ((ArrayList) r110).size()) goto L50;
            org.commonmark.internal.d r21 = new org.commonmark.internal.d(new wvc.d[]{new e(r13, r110)});
            r21.b = r16.b;
            r21.d = true;
            return r21;
        L50:
            return null;
        L49:
            return null;
        L48:
            return null;
        L47:
            return null;
        L45:
            return null;
        L7:
            r1 = r7;
            goto L8
        }
    }

    public v(f r1) {
        this.a = r1;
    }

    @Override // vvc.e.b
    public final void a(e.a r3) {
        r3.a(new a(this.a));
    }
}
