package com.ss.android.lark.movable.attatchment;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class q {
    public static final /* synthetic */ int d = 0;
    public final String a;
    public final int b;
    public final String c;

    public static final class a {
        public static q a(String r14) {
            Intrinsics.checkNotNullParameter(r14, "url");
            if (r14.length() != 0) goto L5;
            boolean r1 = true;
        L6:
            q r4 = null;
            if (r1 == false) goto L22;
            return null;
        L22:
            Uri r2 = UriProtector.parse(r14);     // Catch: Exception -> L17
            String r5 = (String) ListProtector.get(StringsKt.split$default(r14, new String[]{"?"}, false, 0, 6, null), 0);     // Catch: Exception -> L17
            String r6 = UriProtector.getQueryParameter(r2, "event");     // Catch: Exception -> L17
            if (r6 == null) goto L14;
            Integer r7 = StringsKt.toIntOrNull(r6);     // Catch: Exception -> L17
            if (r7 == null) goto L14;
            int r8 = r7.intValue();     // Catch: Exception -> L17
        L15:
            return new q(r5, r8, UriProtector.getQueryParameter(r2, "tint_color"));
        L14:
            r8 = 0;
        L17:
            List r15 = StringsKt.split$default(r14, new String[]{"?"}, false, 0, 6, null);
            if ((!r15.isEmpty()) == false) goto L21;
            r4 = new q((String) ListProtector.get(r15, 0), 0, null);
        L21:
            return r4;
        L5:
            r1 = false;
            goto L6
        }
    }

    static {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof q) == true) goto L8;
        return false;
    L8:
        q r6 = (q) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b) * 31;
        String r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "MovableUDIconData(iconKey=" + this.a + ", event=" + this.b + ", tintColor=" + this.c + ')';
    }

    public q(String r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "iconKey");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
