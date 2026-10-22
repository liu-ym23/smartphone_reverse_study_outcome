package dk8;

import android.graphics.Color;
import com.larus.im.bean.message.block.DisplayColor;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d {
    public static final Integer a(DisplayColor r4, boolean r5) {
        Object r0 = null;
        if (r5 == false) goto L11;
        String r6 = r4.getColorDark();
        if (r6 == null) goto L11;
        if ((!StringsKt.isBlank(r6)) == true) goto L10;
        r6 = null;
    L10:
        if (r6 == null) goto L11;
    L12:
        if (r6 != null) goto L14;
        return null;
    L14:
        if ((!StringsKt.isBlank(r6)) == true) goto L17;
        r6 = null;
    L17:
        if (r6 == null) goto L40;
        String r7 = StringsKt.trim(r6).toString();
        if (r7 == null) goto L41;
        String r8 = StringsKt.removePrefix(r7, "#");
        int r1 = r8.length();
        if (r1 != 6) goto L23;
        String r9 = "#".concat(r8);
    L37:
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L29
        Object r11 = Result.constructor-impl(Integer.valueOf(Color.parseColor(r9)));     // Catch: Throwable -> L29
    L32:
        if (Result.isFailure-impl(r11) == true) goto L36;
        r0 = r11;
    L36:
        return (Integer) r0;
    L29:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L32
    L23:
        if (r1 != 8) goto L42;
        r9 = "#" + StringsKt.takeLast(r8, 2) + StringsKt.take(r8, 6);
        goto L37
    L42:
        return null;
    L41:
        return null;
    L40:
        return null;
    L11:
        r6 = r4.getColor();
        goto L12
    }
}
