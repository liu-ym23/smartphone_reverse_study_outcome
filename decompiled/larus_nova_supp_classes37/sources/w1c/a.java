package w1c;

import com.bytedance.lark.pb.contact.v2.I18nVal;
import java.text.BreakIterator;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import yob.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final String a(I18nVal r4) {
        e.a().getClass();
        int r0 = com.ss.android.lark.language.service.impl.a.f;
        apb.b r1 = com.ss.android.lark.language.service.impl.a.b.a;
        String r2 = r1.d(r1.getCacheLanguageSetting());
        String r3 = null;
        if (r4 == null) goto L7;
        Map r5 = r4.i18n_vals;
        if (r5 == null) goto L7;
        Intrinsics.checkNotNull(r2);
        String r6 = (String) r5.get(r2.toLowerCase(Locale.ROOT));
    L8:
        String r7 = "";
        if (r6 != null) goto L12;
        r6 = "";
    L12:
        if (r6.length() != 0) goto L14;
        boolean r8 = true;
    L15:
        if (r8 == false) goto L23;
        if (r4 == null) goto L18;
        r3 = r4.default_val;
    L18:
        if (r3 == null) goto L22;
        r7 = r3;
    L22:
        return r7;
    L23:
        return r6;
    L14:
        r8 = false;
    L7:
        r6 = null;
        goto L8
    }

    public static final String b(String r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        BreakIterator r0 = BreakIterator.getCharacterInstance(Locale.getDefault());
        r0.setText(r5);
        int r1 = r0.first();
        int r3 = 0;
    L4:
        if (r1 == (-1)) goto L7;
        if (r3 >= r6) goto L7;
        r1 = r0.next();
        r3 = r3 + 1;
    L7:
        if (r1 != (-1)) goto L10;
        return r5;
    L10:
        return r5.substring(0, r1);
    }
}
