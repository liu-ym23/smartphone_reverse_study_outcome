package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public final String a;
    public final Integer b;

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
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "AttachmentProtocolSource(remoteUri=" + this.a + ", type=" + this.b + ')';
    }

    public final String a() {
        String r0 = this.a;
        String r1 = null;
        if (r0 == null) goto L28;
        Integer r2 = this.b;
        if (r2 != null) goto L7;
        return null;
    L7:
        if (r2.intValue() <= 0) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == true) goto L13;
        r2 = null;
    L13:
        if (r2 == null) goto L30;
        int r4 = r2.intValue();
        String r5 = StringsKt.substringBefore$default(r0, '/', null, 2, null);
        if ((!StringsKt.isBlank(r5)) == true) goto L18;
        r5 = null;
    L18:
        if (r5 == null) goto L31;
        String r6 = StringsKt.substringAfter(r0, '/', "");
        if ((true ^ StringsKt.isBlank(r6)) == false) goto L23;
        r1 = r6;
    L23:
        Uri.Builder r7 = new Uri.Builder().scheme("attachment").encodedAuthority(r5);
        if (r1 == null) goto L27;
        r7.encodedPath("/".concat(r1));
    L27:
        return r7.appendQueryParameter("type", String.valueOf(r4)).build().toString();
    L31:
        return null;
    L30:
        return null;
    L9:
        r3 = false;
        goto L10
    L28:
        return null;
    }

    public final Integer getType() {
        return this.b;
    }

    public a(String r1, Integer r2) {
        this.a = r1;
        this.b = r2;
    }
}
