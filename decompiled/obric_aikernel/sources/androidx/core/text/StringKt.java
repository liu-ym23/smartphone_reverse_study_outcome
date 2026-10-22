package androidx.core.text;

import android.text.TextUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class StringKt {
    public static final String htmlEncode(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        String r11 = TextUtils.htmlEncode(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "htmlEncode(this)");
        return r11;
    }
}
