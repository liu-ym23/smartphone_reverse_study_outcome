package uvb;

import android.content.Context;
import android.view.View;
import com.larksuite.framework.utils.DevEnvUtil;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public static String d(String r18) {
        return StringsKt.trim(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r18, ';', ',', false, 4, null), '\n', ' ', false, 4, null), '\r', ' ', false, 4, null), '\t', ' ', false, 4, null)).toString();
    }

    public static void b(View r6, c.a r7) {
        Map r0 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r7, "source");
        Intrinsics.checkNotNullParameter(r0, "extraFields");
        if (r6 == null) goto L34;
        a r3 = a;
        Context r4 = r6.getContext();
        r3.getClass();
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L7
        Object r8 = Result.constructor-impl(Boolean.valueOf(DevEnvUtil.isDebugMode(r4)));     // Catch: Throwable -> L7
    L9:
        Boolean r9 = Boolean.FALSE;
        if (Result.isFailure-impl(r8) == false) goto L13;
        r8 = r9;
    L13:
        if (((Boolean) r8).booleanValue() == false) goto L35;
        a.getClass();
        Intrinsics.checkNotNullParameter(r7, "source");
        Intrinsics.checkNotNullParameter(r0, "extraFields");
        StringBuilder r1 = new StringBuilder();
        r1.append("minutes-auto:id=");
        r1.append(d(r7.a));
        a(r1, "label", r7.b);
        a(r1, "hint", r7.c);
        a(r1, "expected", r7.d);
        Iterator r10 = r0.entrySet().iterator();
    L17:
        if (r10.hasNext() == false) goto L23;
        Map.Entry r2 = (Map.Entry) r10.next();
        String r11 = (String) r2.getKey();
        String r12 = (String) r2.getValue();
        if ((!StringsKt.isBlank(r11)) == false) goto L17;
        if ((!StringsKt.isBlank(r12)) == false) goto L17;
        a.getClass();
        a(r1, r11, r12);
        goto L17
    L23:
        r6.setContentDescription(r1.toString());
        return;
    L35:
        return;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    @JvmStatic
    public static final void c(View r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "pageName");
        a.getClass();
        Intrinsics.checkNotNullParameter(r4, "pageName");
        String r0 = "minutes-office-sdk-page-" + new Regex("([a-z0-9])([A-Z])").replace(r4, "$1-$2").toLowerCase(Locale.ROOT);
        b(r3, new c.a(r0, r4, "", r0));
    }

    public static void a(StringBuilder r1, String r2, String r3) {
        r1.append(';');
        r1.append(d(r2));
        r1.append('=');
        r1.append(d(r3));
    }
}
