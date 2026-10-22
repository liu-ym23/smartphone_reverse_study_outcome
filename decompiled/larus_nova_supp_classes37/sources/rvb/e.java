package rvb;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e {
    public static final boolean a(String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "sourceLang");
        Intrinsics.checkNotNullParameter(r8, "targetLang");
        String r9 = StringsKt.replace$default(StringsKt.trim(r7).toString(), '_', '-', false, 4, null);
        Locale r0 = Locale.ROOT;
        String r10 = r9.toLowerCase(r0);
        String r11 = StringsKt.replace$default(StringsKt.trim(r8).toString(), '_', '-', false, 4, null).toLowerCase(r0);
        if (r10.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
    L52:
        return false;
    L8:
        if (r11.length() != 0) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == true) goto L52;
        if (Intrinsics.areEqual(r10, "zhen") == false) goto L16;
    L19:
        boolean r3 = true;
    L20:
        if (r3 == true) goto L52;
        if (Intrinsics.areEqual(r11, "zhen") == false) goto L24;
    L27:
        boolean r4 = true;
    L28:
        if (r4 == true) goto L52;
        if (Intrinsics.areEqual(r10, r11) == false) goto L34;
        return true;
    L34:
        if (Intrinsics.areEqual(r10, "zh") == false) goto L36;
    L39:
        boolean r12 = true;
    L40:
        if (r12 == true) goto L42;
    L50:
        return false;
    L42:
        if (Intrinsics.areEqual(r11, "zh") == false) goto L44;
    L47:
        boolean r13 = true;
    L48:
        if (r13 == false) goto L50;
        return true;
    L44:
        if (StringsKt.startsWith$default(r11, "zh-", false, 2, null) == true) goto L47;
        r13 = false;
        goto L48
    L36:
        if (StringsKt.startsWith$default(r10, "zh-", false, 2, null) == true) goto L39;
        r12 = false;
        goto L40
    L24:
        if (Intrinsics.areEqual(r11, "zh-cn-en-us") == true) goto L27;
        r4 = false;
        goto L28
    L16:
        if (Intrinsics.areEqual(r10, "zh-cn-en-us") == true) goto L19;
        r3 = false;
        goto L20
    L10:
        r2 = false;
        goto L11
    L5:
        r1 = false;
        goto L6
    }

    public static final h b(h r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "model");
        Intrinsics.checkNotNullParameter(r5, "sourceContent");
        Intrinsics.checkNotNullParameter(r6, "targetContent");
        if (r6.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L19;
        if (r4.f.length() != 0) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == false) goto L19;
        if (r4.e.length() <= 0) goto L15;
        boolean r2 = true;
    L16:
        if (r2 == false) goto L19;
        String r3 = r4.e;
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r4.f = r3;
        goto L19
    L15:
        r2 = false;
        goto L16
    L10:
        r1 = false;
    L19:
        if (r5.length() <= 0) goto L21;
        boolean r7 = true;
    L22:
        if (r7 == true) goto L24;
    L32:
        r4.o = true;
        r4.n = true;
        return r4;
    L24:
        if (r6.length() <= 0) goto L26;
        boolean r8 = true;
    L27:
        if (r8 == false) goto L32;
        if (Intrinsics.areEqual(r5, r6) == true) goto L32;
        r4.o = false;
        r4.n = false;
        return r4;
    L26:
        r8 = false;
        goto L27
    L21:
        r7 = false;
        goto L22
    L5:
        r0 = false;
        goto L6
    }
}
