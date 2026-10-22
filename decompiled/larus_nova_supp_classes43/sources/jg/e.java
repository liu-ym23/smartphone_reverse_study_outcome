package jg;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "originKey");
        Intrinsics.checkNotNullParameter(r12, "originValue");
        String r13 = Uri.encode(r11);
        String r14 = Uri.encode(r12);
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return r10;
    L5:
        if (TextUtils.isEmpty(r13) == false) goto L7;
        return r10;
    L7:
        return new Regex("(" + r13 + "=[^&]*)").replace(r10, r13 + '=' + r14);
    }

    public static String b(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "key");
        Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return r10;
    L5:
        if (TextUtils.isEmpty(r11) == false) goto L7;
        return r10;
    L7:
        if (StringsKt.contains$default(r10, r11, false, 2, null) == true) goto L17;
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "key");
        Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        if (TextUtils.isEmpty(r10) == false) goto L12;
        return r10;
    L12:
        if (TextUtils.isEmpty(r11) == false) goto L14;
        return r10;
    L14:
        return UriProtector.parse(r10).buildUpon().appendQueryParameter(r11, r12).toString();
    L17:
        return a(r10, r11, r12);
    }

    public static String c(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Uri r13 = UriProtector.parse(r10);
        if (r12 == null) goto L20;
        Uri.Builder r0 = r13.buildUpon();
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r13, r11)) == false) goto L8;
        r0.appendQueryParameter(r11, r12);
    L18:
        r13 = r0.build();
        goto L20
    L8:
        r0.clearQuery();
        Iterator r1 = UriProtector.getQueryParameterNames(r13).iterator();
    L10:
        if (r1.hasNext() == false) goto L18;
        String r14 = (String) r1.next();
        if ((!Intrinsics.areEqual(r14, r11)) == true) goto L13;
        r0.appendQueryParameter(r14, r12);
        goto L10
    L13:
        Iterator r15 = UriProtector.getQueryParameters(r13, r14).iterator();
    L15:
        if (r15.hasNext() == false) goto L10;
        r0.appendQueryParameter(r14, (String) r15.next());
    L20:
        return String.valueOf(r13);
    }
}
