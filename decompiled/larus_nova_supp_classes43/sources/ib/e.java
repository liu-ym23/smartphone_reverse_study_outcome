package ib;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;
import t36.j;
import y36.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public static final String a(Uri r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        String r0 = b(r10);
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        boolean r11 = true;
        if (r0.length() != 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L36;
        String r12 = a36.b.e(r10, "channel");
        String r13 = a36.b.e(r10, "bundle");
        if (r12 != null) goto L13;
    L16:
        boolean r14 = true;
    L17:
        if (r14 == true) goto L28;
        if (r13 != null) goto L20;
    L23:
        boolean r15 = true;
    L24:
        if (r15 == true) goto L28;
        return r12 + '_' + r13;
    L20:
        if (r13.length() == 0) goto L23;
        r15 = false;
    L28:
        if (r0.length() == 0) goto L31;
        r11 = false;
    L31:
        if (r11 == true) goto L33;
        return r0;
    L33:
        return r10.toString();
    L13:
        if (r12.length() == 0) goto L16;
        r14 = false;
        goto L17
    L36:
        return UriProtector.parse(r0).buildUpon().clearQuery().toString();
    L8:
        r1 = false;
        goto L9
    }

    public static final String b(Uri r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (Intrinsics.areEqual(r10.getScheme(), "http") == true) goto L13;
        if (Intrinsics.areEqual(r10.getScheme(), "https") == true) goto L13;
        String r0 = a36.b.e(r10, "a_surl");
        if (r0 != null) goto L14;
        String r1 = a36.b.e(r10, "surl");
        if (r1 == null) goto L16;
        return r1;
    L16:
        return a36.b.e(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
    L14:
        return r0;
    L13:
        return r10.toString();
    }

    public static final boolean c(j r10) {
        i r0 = null;
        if (r10 == null) goto L5;
        t36.f r11 = r10.d;
    L7:
        if ((r11 instanceof v36.e) == false) goto L9;
        v36.e r12 = (v36.e) r11;
    L10:
        if (r12 == null) goto L19;
        i r13 = r12.s;
        if (r13 == null) goto L14;
        r0 = r13;
    L15:
        if (r0 == null) goto L19;
        Boolean r14 = (Boolean) r0.b;
        if (r14 == null) goto L19;
        return r14.booleanValue();
    L14:
        Intrinsics.throwUninitializedPropertyAccessException("compactMode");
    L19:
        return true;
    L9:
        r12 = null;
        goto L10
    L5:
        r11 = null;
        goto L7
    }
}
