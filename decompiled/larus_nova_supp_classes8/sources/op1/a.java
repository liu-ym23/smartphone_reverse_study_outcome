package op1;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public final Pattern a;
    public final Pattern b;

    /* JADX INFO: renamed from: op1.a$a, reason: collision with other inner class name */
    public static final class C0405a {
    }

    public static final class b {
        public final String a;
        public final long b;

        public b(String r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, "content");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c {
        public final long a;
        public final long b;
        public final int c;
        public final int d;

        public c(long r1, long r3, int r5, int r6) {
            this.a = r1;
            this.b = r3;
            this.c = r5;
            this.d = r6;
        }
    }

    public static final class d {
        public final String a;

        public d(String r2) {
            Intrinsics.checkNotNullParameter(r2, "content");
            this.a = r2;
        }
    }

    static {
    }

    public a() {
        this.a = PatternProtector.compile("\\[(\\d+),(\\d+)\\]");
        this.b = PatternProtector.compile("\\<(\\d+),(\\d+)(,\\d+)?\\>");
    }

    public final void b(List<b> r18, String r19) {
        Matcher r0 = this.a.matcher(r19);
        ArrayList r9 = new ArrayList();
    L3:
        int r2 = 0;
        if (r0.find() == false) goto L19;
        String r1 = r0.group();
        if (r1 == null) goto L17;
        String r3 = StringsKt.trim(r1).toString();
        List r4 = StringsKt.split$default(r3.substring(1, r3.length() - 1), new String[]{","}, false, 0, 6, null);
        if (r4.size() == 2) goto L41;
    L12:
        Pair r5 = null;
    L13:
        if (r5 == null) goto L3;
        r9.add(new c(((Number) r5.getFirst()).longValue(), ((Number) r5.getSecond()).longValue(), r0.start(), r0.end()));
        goto L3
    L41:
        long r6 = CastIntegerProtector.parseInt((String) ListProtector.get(r4, 0));     // Catch: Exception -> L40
        r5 = TuplesKt.to(Long.valueOf(r6), Long.valueOf(((long) CastIntegerProtector.parseInt((String) ListProtector.get(r4, 1))) + r6));     // Catch: Exception -> L40
    L17:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L19:
        if (r9.isEmpty() == false) goto L21;
        return;
    L21:
        int r10 = r9.size();
        Iterator r11 = r9.iterator();
    L23:
        if (r11.hasNext() == false) goto L39;
        Object r7 = r11.next();
        int r12 = r2 + 1;
        if (r2 >= 0) goto L27;
        CollectionsKt.throwIndexOverflow();
    L27:
        c r8 = (c) r7;
        if (r2 != (r10 - 1)) goto L30;
        a(r8.a, r8.b, r19.substring(r8.d, r19.length()), r18);
    L36:
        r2 = r12;
        goto L23
    L30:
        c r13 = (c) CollectionsKt.getOrNull(r9, r12);
        if (r13 == null) goto L36;
        int r14 = r8.d;
        int r15 = r13.c;
        if (r19 == null) goto L38;
        a(r8.a, r8.b, r19.substring(r14, r15), r18);
        goto L36
    L38:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public static void c(String r8, long r9, long r11, ArrayList r13) {
        int r1 = 0;
        if (r8.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return;
    L9:
        if (r8.length() > 1) goto L12;
        r13.add(new d(r8));
        return;
    L12:
        String r3 = StringsKt.trim(r8).toString();
        int r2 = r3.length();
        long r10 = Math.abs(r11 - r9);
        if (r2 == 0) goto L16;
        long r12 = r10 / ((long) r3.length());
    L16:
        int r14 = StringsKt.indexOf$default(r8, r3, 0, false, 6, null);
        Iterator r15 = StringsKt.toList(r8).iterator();
    L18:
        if (r15.hasNext() == false) goto L27;
        Object r16 = r15.next();
        int r17 = r1 + 1;
        if (r1 >= 0) goto L22;
        CollectionsKt.throwIndexOverflow();
    L22:
        char r18 = ((Character) r16).charValue();
        if (r1 >= r14) goto L25;
        r13.add(new d(String.valueOf(r18)));
    L26:
        r1 = r17;
        goto L18
    L25:
        r13.add(new d(String.valueOf(r18)));
        goto L26
    L27:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void a(long r24, long r26, String r28, List r29) {
        ArrayList r3 = new ArrayList();
        Matcher r5 = this.b.matcher(r28);
        long r13 = r24;
    L3:
        int r8 = 0;
        if (r5.find() == false) goto L18;
        String r6 = r5.group();
        if (r6 == null) goto L17;
        String r7 = StringsKt.trim(r6).toString();
        List r9 = StringsKt.split$default(r7.substring(1, r7.length() - 1), new String[]{","}, false, 0, 6, null);
        if (r9.size() == 3) goto L46;
    L12:
        Pair r10 = null;
    L13:
        if (r10 == null) goto L14;
        r3.add(new c(((Number) r10.getFirst()).longValue(), ((Number) r10.getSecond()).longValue(), r5.start(), r5.end()));
        r13 = ((Number) r10.getSecond()).longValue();
        goto L3
    L14:
        long r11 = r13;
        long r12 = r13;
        r3.add(new c(r11, r12, r5.start(), r5.end()));
        goto L3
    L46:
        long r14 = ((long) CastIntegerProtector.parseInt((String) ListProtector.get(r9, 0))) + r24;     // Catch: Exception -> L45
        long r15 = ((long) CastIntegerProtector.parseInt((String) ListProtector.get(r9, 1))) + r14;     // Catch: Exception -> L45
        r10 = TuplesKt.to(Long.valueOf(r14), Long.valueOf(r15));     // Catch: Exception -> L45
    L17:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L18:
        ArrayList r16 = new ArrayList();
        Iterator r17 = r3.iterator();
    L20:
        if (r17.hasNext() == false) goto L37;
        Object r18 = r17.next();
        int r19 = r8 + 1;
        if (r8 >= 0) goto L24;
        CollectionsKt.throwIndexOverflow();
    L24:
        c r20 = (c) r18;
        if (r8 != (r3.size() - 1)) goto L27;
        c(r28.substring(r20.d, r28.length()), r20.a, r20.b, r16);
    L33:
        r8 = r19;
        goto L20
    L27:
        c r21 = (c) CollectionsKt.getOrNull(r3, r19);
        if (r21 == null) goto L33;
        int r110 = r20.d;
        int r22 = r21.c;
        if (r28 == null) goto L35;
        c(r28.substring(r110, r22), r20.a, r20.b, r16);
        goto L33
    L35:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L37:
        if (r16.isEmpty() == false) goto L39;
        return;
    L39:
        StringBuilder r2 = new StringBuilder();
        Iterator r4 = r16.iterator();
    L41:
        if (r4.hasNext() == false) goto L43;
        r2.append(((d) r4.next()).a);
        goto L41
    L43:
        ArrayList r0 = (ArrayList) r29;
        r0.add(new b(r2.toString(), r24));
    }
}
