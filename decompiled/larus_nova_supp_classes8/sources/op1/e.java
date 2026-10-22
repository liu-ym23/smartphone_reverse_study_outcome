package op1;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e {
    public final ArrayList<d> a;
    public final Pattern b;

    public e() {
        this.a = new ArrayList();
        this.b = PatternProtector.compile("\\[\\d{1,2}:\\d{1,2}([\\.:]\\d{1,3})?\\]");
    }

    public static void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "line");
        Matcher r4 = PatternProtector.compile("\\[(offset):[^\\]]+\\]").matcher(r3);
    L4:
        if (r4.find() == false) goto L13;
        String r0 = r4.group();
        if (r0 == null) goto L12;
        String r1 = r0.substring(1, 7);
        if (r1.hashCode() != (-1019779949)) goto L4;
        r1.equals("offset");
        goto L4
    L12:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public final void b(String r19) {
        Intrinsics.checkNotNullParameter(r19, "line");
        Matcher r4 = this.b.matcher(r19);
        ArrayList r5 = new ArrayList();
        boolean r6 = false;
        int r0 = 0;
    L3:
        long r8 = -1;
        boolean r10 = true;
        if (r4.find() == false) goto L41;
        String r1 = r4.group();
        Intrinsics.checkNotNullParameter(r1, "line");
        String r2 = StringsKt.trim(r1).toString();
        List r3 = StringsKt.split$default(r2.substring(1, r2.length() - 1), new String[]{":", "."}, false, 0, 6, null);
        if (r3.size() < 2) goto L40;
        if (r3.size() != 2) goto L20;
        int r7 = CastIntegerProtector.parseInt((String) ListProtector.get(r3, 0));     // Catch: NumberFormatException -> L17
        int r9 = CastIntegerProtector.parseInt((String) ListProtector.get(r3, 1));     // Catch: NumberFormatException -> L17
        if (r7 < 0) goto L16;
        if (r9 < 0) goto L16;
        if (r9 >= 60) goto L16;
        r8 = ((long) ((r7 * 60) + r9)) * 1000;     // Catch: NumberFormatException -> L17
    L16:
        throw new NumberFormatException();     // Catch: NumberFormatException -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L40
    L20:
        if (r3.size() != 3) goto L40;
        int r11 = CastIntegerProtector.parseInt((String) ListProtector.get(r3, 0));     // Catch: NumberFormatException -> L38
        int r15 = CastIntegerProtector.parseInt((String) ListProtector.get(r3, 1));     // Catch: NumberFormatException -> L38
        int r12 = CastIntegerProtector.parseInt((String) ListProtector.get(r3, 2));     // Catch: NumberFormatException -> L38
        if (r11 < 0) goto L30;
        if (r15 < 0) goto L30;
        if (r15 >= 60) goto L30;
        if (r12 < 0) goto L30;
        if (r12 > 999) goto L30;
        r10 = false;
    L30:
        if (r10 == true) goto L37;
        int r13 = (r11 * 60) + r15;     // Catch: NumberFormatException -> L38
        if (r12 <= 99) goto L34;
        long r14 = ((long) r13) * 1000;     // Catch: NumberFormatException -> L38
    L35:
        r8 = r14 + ((long) r12);     // Catch: NumberFormatException -> L38
        goto L40
    L34:
        r14 = ((long) r13) * 1000;     // Catch: NumberFormatException -> L38
        r12 = r12 * 10;     // Catch: NumberFormatException -> L38
        goto L35
    L37:
        throw new NumberFormatException();     // Catch: NumberFormatException -> L38
    L38:
        e = move-exception;
        e.printStackTrace();
    L40:
        r5.add(Long.valueOf(r8));
        r0 = r4.end();
        ((Number) CollectionsKt.last(r5)).longValue();
        goto L3
    L41:
        String r16 = r19.substring(r0, r19.length());
        if (r16 == null) goto L62;
        String r17 = StringsKt.trim(r16).toString();
        if (StringsKt.startsWith$default(r17, "[", false, 2, null) == true) goto L46;
    L48:
        if (r17 != null) goto L50;
    L51:
        r6 = true;
    L52:
        if (r6 == false) goto L54;
        return;
    L54:
        Iterator r18 = r5.iterator();
    L56:
        if (r18.hasNext() == false) goto L60;
        long r20 = ((Number) r18.next()).longValue();
        if (r20 == (-1)) goto L56;
        this.a.add(new d(r20 / 1000.0f, r17));
        goto L56
    L60:
        return;
    L50:
        if (r17.length() != 0) goto L52;
    L46:
        if (StringsKt.endsWith$default(r17, "]", false, 2, null) == false) goto L48;
        r17 = "";
        goto L48
    L62:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public final String c(String r10) {
        Intrinsics.checkNotNullParameter(r10, "line");
        StringBuffer r0 = new StringBuffer();
        List r11 = StringsKt.split$default(r10, new String[]{"]"}, false, 0, 6, null);
        int r2 = r11.size();
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L22;
        String r5 = (String) ListProtector.get(r11, r4);
        if (r4 == (r11.size() - 1)) goto L7;
        r5 = r5 + "]";
    L11:
        if (StringsKt.startsWith$default(r5, "[", false, 2, null) == true) goto L13;
    L19:
        r0.append(r5);
    L20:
        r4 = r4 + 1;
        goto L3
    L13:
        if (StringsKt.endsWith$default(r5, "]", false, 2, null) == false) goto L19;
        if (this.b.matcher(r5).find() == false) goto L17;
        r0.append(r5);
        goto L20
    L17:
        return "";
    L7:
        if (StringsKt.endsWith$default(r5, "]", false, 2, null) == false) goto L11;
        r5 = r5 + "]";
        goto L11
    L22:
        return r0.toString();
    }
}
