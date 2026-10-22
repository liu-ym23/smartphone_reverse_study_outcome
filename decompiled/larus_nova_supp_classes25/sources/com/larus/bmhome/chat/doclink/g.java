package com.larus.bmhome.chat.doclink;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.auth.c1;
import com.larus.bmhome.auth.j0;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g {
    public static final g a = null;
    public static final AtomicBoolean b = null;

    public static final class a {
        public final String a;
        public final String b;

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
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "CandidateUrl(host=" + this.a + ", path=" + this.b + ')';
        }

        public a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "host");
            Intrinsics.checkNotNullParameter(r3, "path");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b {
        public final String a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + this.b.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public final String toString() {
            return "PreviewUrlRule(host=" + this.a + ", pathPrefix=" + this.b + ')';
        }

        public b(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "pathPrefix");
            this.a = r2;
            this.b = r3;
        }
    }

    public g() {
    }

    static {
        a = new g();
        b = new AtomicBoolean(false);
    }

    public static Set a() {
        List r0 = CollectionsKt.createListBuilder();
        AuthModelDelegate r1 = AuthModelDelegate.b;
        e0 r2 = (e0) r1.e().getValue();
        if (r2 == null) goto L7;
        LaunchInfo r3 = r2.a;
        if (r3 == null) goto L7;
        List r4 = r3.Z0();
    L8:
        if (r4 != null) goto L10;
        r4 = CollectionsKt.emptyList();
    L10:
        r0.addAll(r4);
        LaunchInfo r5 = (LaunchInfo) r1.x().getValue();
        if (r5 == null) goto L13;
        List r6 = r5.Z0();
    L14:
        if (r6 != null) goto L16;
        r6 = CollectionsKt.emptyList();
    L16:
        r0.addAll(r6);
        c1 r7 = (c1) r1.i().getValue();
        if (r7 == null) goto L21;
        j0 r8 = (j0) r7.d;
        if (r8 == null) goto L21;
        List r9 = r8.n();
    L22:
        if (r9 != null) goto L24;
        r9 = CollectionsKt.emptyList();
    L24:
        r0.addAll(r9);
        List r10 = CollectionsKt.build(r0);
        ArrayList r11 = new ArrayList();
        Iterator r12 = r10.iterator();
    L26:
        if (r12.hasNext() == false) goto L62;
        String r13 = (String) r12.next();
        a.getClass();
        String r14 = StringsKt.trim(r13).toString();
        if (StringsKt.isBlank(r14) == false) goto L31;
    L57:
        b r15 = null;
    L59:
        if (r15 == null) goto L26;
        r11.add(r15);
        goto L26
    L31:
        if (StringsKt.startsWith$default(r14, "/", false, 2, null) == false) goto L33;
        r15 = new b(null, f(r14));
        goto L59
    L33:
        String r16 = l.a(r14);
        if (StringsKt.isBlank(r16) == true) goto L57;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L38
        Object r18 = Result.constructor-impl(UriProtector.parse(r16));     // Catch: Throwable -> L38
    L41:
        if (Result.isFailure-impl(r18) == false) goto L43;
        r18 = null;
    L43:
        Uri r19 = (Uri) r18;
        if (r19 == null) goto L46;
        String r20 = r19.getHost();
    L47:
        String r21 = d(r20);
        if (r19 == null) goto L53;
        String r22 = r19.getPath();
        if (r22 == null) goto L53;
        String r23 = f(r22);
        if (r23 == null) goto L53;
    L54:
        if (r21 == null) goto L56;
    L58:
        r15 = new b(r21, r23);
        goto L59
    L56:
        if (Intrinsics.areEqual(r23, "/") == false) goto L58;
    L53:
        r23 = "/";
        goto L54
    L46:
        r20 = null;
    L38:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L41
    L62:
        return CollectionsKt.toSet(r11);
    L21:
        r9 = null;
        goto L22
    L13:
        r6 = null;
    L7:
        r4 = null;
        goto L8
    }

    public static boolean c() {
        return !a().isEmpty();
    }

    public static List b(List r15) {
        Intrinsics.checkNotNullParameter(r15, "urls");
        if (r15.isEmpty() == true) goto L5;
        Set r0 = a();
        if (r0.isEmpty() == false) goto L10;
        FLogger.a.i("MessageDocPreviewDomainMatcher", "filterPreviewableUrls skipped, prefixCount=0, urlCount=" + r15.size());
        return CollectionsKt.emptyList();
    L10:
        ArrayList r3 = new ArrayList();
        Iterator r1 = r15.iterator();
    L12:
        if (r1.hasNext() == false) goto L69;
        Object r4 = r1.next();
        a.getClass();
        String r5 = l.a((String) r4);
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L16
        Object r7 = Result.constructor-impl(UriProtector.parse(r5));     // Catch: Throwable -> L16
    L19:
        if (Result.isFailure-impl(r7) == false) goto L21;
        r7 = null;
    L21:
        Uri r8 = (Uri) r7;
        if (r8 == null) goto L26;
        String r9 = d(r8.getHost());
        if (r9 == null) goto L26;
        a r10 = new a(r9, e(r8.getPath()));
    L28:
        boolean r11 = false;
        if (r10 == null) goto L66;
        Set r12 = r0;
        if ((r12 instanceof Collection) == true) goto L33;
    L35:
        Iterator r13 = r12.iterator();
    L37:
        if (r13.hasNext() == false) goto L63;
        b r14 = (b) r13.next();
        r14.getClass();
        Intrinsics.checkNotNullParameter(r10, "candidate");
        String r16 = r14.a;
        if (r16 == null) goto L48;
        g r17 = a;
        String r18 = r10.a;
        r17.getClass();
        if (Intrinsics.areEqual(r18, r16) == false) goto L43;
    L46:
        boolean r19 = true;
    L47:
        if (r19 == true) goto L48;
    L60:
        boolean r20 = false;
    L61:
        if (r20 == false) goto L37;
        boolean r21 = true;
    L64:
        if (r21 == false) goto L66;
        r11 = true;
        goto L66
    L43:
        if (StringsKt.endsWith$default(r18, ".".concat(r16), false, 2, null) == true) goto L46;
        r19 = false;
    L48:
        g r110 = a;
        String r111 = r10.b;
        String r22 = r14.b;
        r110.getClass();
        if (Intrinsics.areEqual(r22, "/") == false) goto L52;
    L57:
        boolean r23 = true;
    L58:
        if (r23 == false) goto L60;
        r20 = true;
        goto L61
    L52:
        if (Intrinsics.areEqual(r111, StringsKt.trimEnd(r22, new char[]{'/'})) == true) goto L57;
        if (StringsKt.startsWith$default(r111, r22, false, 2, null) == true) goto L57;
        r23 = false;
    L63:
        r21 = false;
        goto L64
    L33:
        if (r12.isEmpty() == false) goto L35;
    L66:
        if (r11 == false) goto L12;
        r3.add(r4);
    L26:
        r10 = null;
    L16:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L69:
        if (r3.size() == r15.size()) goto L71;
        FLogger.a.i("MessageDocPreviewDomainMatcher", "filterPreviewableUrls filtered urlCount=" + r15.size() + ", previewableCount=" + r3.size() + ", prefixCount=" + r0.size());
    L71:
        return r3;
    L5:
        return CollectionsKt.emptyList();
    }

    public static String d(String r4) {
        if (r4 == null) goto L14;
        String r5 = StringsKt.trim(r4).toString();
        if (r5 == null) goto L14;
        String r6 = StringsKt.trimEnd(r5, new char[]{'.'});
        if (r6 == null) goto L14;
        String r7 = StringsKt.removePrefix(r6, "*.");
        if (r7 == null) goto L14;
        String r8 = r7.toLowerCase(Locale.US);
        if (r8 == null) goto L14;
        if ((true ^ StringsKt.isBlank(r8)) == false) goto L14;
        return r8;
    L14:
        return null;
    }

    public static String e(String r4) {
        if (r4 == null) goto L14;
        String r5 = StringsKt.substringBefore$default(r4, "?", null, 2, null);
        if (r5 == null) goto L14;
        String r6 = StringsKt.substringBefore$default(r5, "#", null, 2, null);
        if (r6 == null) goto L14;
        if ((!StringsKt.isBlank(r6)) == true) goto L12;
        r6 = null;
    L12:
        if (r6 == null) goto L14;
    L16:
        if (StringsKt.startsWith$default(r6, "/", false, 2, null) == false) goto L19;
        return r6;
    L19:
        return "/".concat(r6);
    L14:
        r6 = "/";
        goto L16
    }

    public static String f(String r4) {
        String r5 = e(r4);
        if (Intrinsics.areEqual(r5, "/") == false) goto L5;
        return r5;
    L5:
        if (StringsKt.endsWith$default(r5, "/", false, 2, null) == false) goto L8;
        return r5;
    L8:
        return r5 + '/';
    }
}
