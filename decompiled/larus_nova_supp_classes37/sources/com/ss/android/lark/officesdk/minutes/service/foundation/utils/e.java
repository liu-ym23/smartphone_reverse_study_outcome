package com.ss.android.lark.officesdk.minutes.service.foundation.utils;

import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r18) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r18, "{{", "{", false, 4, null), "}}", "}", false, 4, null), "{", "{{", false, 4, null), "}", "}}", false, 4, null);
    }

    public static String b(int r1, String r2, String r3) {
        String r4 = UIHelper.getString(r1);
        Intrinsics.checkNotNullParameter(r4, "originString");
        return UIHelper.mustacheFormat(a(r4), r2, r3);
    }
}
