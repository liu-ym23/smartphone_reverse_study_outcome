package ubb;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.net.URI;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public static boolean a(URI r5, Collection r6, boolean r7) {
        if (r5.getScheme() == null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == true) goto L12;
        return r7;
    L12:
        if (StringsKt.equals(r5.getScheme(), "https", true) == true) goto L14;
        return false;
    L14:
        String r8 = r5.getHost();
        if (r8 == null) goto L17;
        String r9 = r8.toLowerCase(Locale.US);
    L18:
        if (r9 != null) goto L21;
        r9 = BuildConfig.FLAVOR;
    L21:
        if (r9.length() != 0) goto L23;
        boolean r10 = true;
    L24:
        if (r10 == false) goto L26;
        return false;
    L26:
        Collection r11 = r6;
        if ((r11 instanceof Collection) == true) goto L29;
    L31:
        Iterator r12 = r11.iterator();
    L33:
        if (r12.hasNext() == false) goto L43;
        String r13 = StringsKt.trim((String) r12.next()).toString().toLowerCase(Locale.US);
        if (r13.length() != 0) goto L37;
        boolean r1 = true;
    L38:
        if (r1 == false) goto L40;
        boolean r14 = false;
    L41:
        if (r14 == false) goto L33;
        return true;
    L40:
        r14 = new Regex("^(?:[^.]+\\.)*" + Regex.Companion.escape(r13) + '$').matches(r9);
        goto L41
    L37:
        r1 = false;
    L43:
        return false;
    L29:
        if (r11.isEmpty() == false) goto L31;
    L23:
        r10 = false;
        goto L24
    L17:
        r9 = null;
        goto L18
    L5:
        if (r5.getHost() != null) goto L8;
        r0 = false;
        goto L9
    }
}
