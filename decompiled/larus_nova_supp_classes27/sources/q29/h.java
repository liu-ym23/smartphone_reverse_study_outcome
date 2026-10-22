package q29;

import android.text.TextUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h {
    public static final int a(CharSequence r5) {
        Intrinsics.checkNotNullParameter(r5, "sequence");
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return 0;
    L5:
        int r0 = 0;
        int r2 = 0;
    L7:
        if (r0 >= r5.length()) goto L28;
        Character.UnicodeBlock r3 = Character.UnicodeBlock.of(r5.charAt(r0));
        if (Intrinsics.areEqual(r3, Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) == false) goto L11;
    L24:
        boolean r4 = true;
    L25:
        if (r4 == false) goto L27;
        r2 = r2 + 1;
    L27:
        r0 = r0 + 1;
        goto L7
    L11:
        if (Intrinsics.areEqual(r3, Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) == true) goto L24;
        if (Intrinsics.areEqual(r3, Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) == true) goto L24;
        if (Intrinsics.areEqual(r3, Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B) == true) goto L24;
        if (Intrinsics.areEqual(r3, Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) == true) goto L24;
        if (Intrinsics.areEqual(r3, Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) == true) goto L24;
        if (Intrinsics.areEqual(r3, Character.UnicodeBlock.GENERAL_PUNCTUATION) == true) goto L24;
        r4 = false;
        goto L25
    L28:
        return r2;
    }
}
