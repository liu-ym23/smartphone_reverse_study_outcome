package lbb;

import android.text.TextUtils;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final boolean a(String r4) {
        if (TextUtils.isEmpty(r4) == true) goto L8;
        Intrinsics.checkNotNull(r4);
        if (StringsKt.startsWith$default(r4.toLowerCase(), "fake_", false, 2, null) == false) goto L8;
        return true;
    L8:
        return false;
    }
}
