package x29;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.larus.contextwindow.api.ContextWindowContainer;
import com.larus.contextwindow.api.ContextWindowHiddenReason;
import com.larus.contextwindow.api.ContextWindowMessageSnapshot;
import com.larus.contextwindow.api.ContextWindowMode;
import com.larus.contextwindow.api.ContextWindowSnapshot;
import com.larus.contextwindow.api.ContextWindowTotalSource;
import com.larus.contextwindow.api.ContextWindowUsageParts;
import com.larus.contextwindow.api.ContextWindowUsageSource;
import com.larus.contextwindow.api.a$b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class g {
    public static final g a = null;

    public static final class a {
        public final ContextWindowMessageSnapshot a;
        public final String b;
        public final ContextWindowUsageSource c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "UsageSelection(message=" + this.a + ", raw=" + this.b + ", source=" + this.c + ')';
        }

        public a(ContextWindowMessageSnapshot r2, String r3, ContextWindowUsageSource r4) {
            Intrinsics.checkNotNullParameter(r2, "message");
            Intrinsics.checkNotNullParameter(r3, "raw");
            Intrinsics.checkNotNullParameter(r4, "source");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    static {
        a = new g();
    }

    public g() {
    }

    public static com.larus.contextwindow.api.a a(v29.a r210) {
        Intrinsics.checkNotNullParameter(r210, "input");
        Pair r2 = null;
        if (r210.a == true) goto L5;
        ContextWindowHiddenReason r0 = ContextWindowHiddenReason.FEATURE_OFF;
    L23:
        if (r0 == null) goto L26;
        a.getClass();
        return new com.larus.contextwindow.api.a.a(r0);
    L26:
        Iterable r1 = CollectionsKt.withIndex(r210.g);
        ArrayList r3 = new ArrayList();
        Iterator r4 = r1.iterator();
    L27:
        boolean r5 = false;
        if (r4.hasNext() == false) goto L50;
        Object r6 = r4.next();
        ContextWindowMessageSnapshot r7 = (ContextWindowMessageSnapshot) ((IndexedValue) r6).component2();
        g r8 = a;
        String r9 = r210.b;
        r8.getClass();
        if (Intrinsics.areEqual(r7.a, r9) == true) goto L32;
    L48:
        if (r5 == false) goto L27;
        r3.add(r6);
        goto L27
    L32:
        if ((!StringsKt.isBlank(r7.b)) == false) goto L48;
        if (r7.d == true) goto L48;
        if (r7.e == false) goto L48;
        if (r7.f == false) goto L48;
        String r10 = r7.h;
        if (r10 != null) goto L42;
    L45:
        boolean r11 = true;
    L46:
        if (r11 == true) goto L48;
        r5 = true;
        goto L48
    L42:
        if (StringsKt.isBlank(r10) == true) goto L45;
        r11 = false;
        goto L46
    L50:
        List r12 = CollectionsKt.sortedWith(r3, ComparisonsKt.compareBy(new Function1[]{new e(), new f()}));
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator r14 = r12.iterator();
    L52:
        if (r14.hasNext() == false) goto L54;
        r13.add((ContextWindowMessageSnapshot) ((IndexedValue) r14.next()).getValue());
        goto L52
    L54:
        String r15 = r210.c;
        List r16 = r13;
        if (r15 == null) goto L71;
        Iterator r17 = r13.iterator();
        int r18 = 0;
    L58:
        if (r17.hasNext() == false) goto L63;
        if (Intrinsics.areEqual(((ContextWindowMessageSnapshot) r17.next()).b, r15) == true) goto L64;
        r18 = r18 + 1;
    L64:
        if (r18 >= 0) goto L67;
        g r20 = a;
        ContextWindowHiddenReason r21 = ContextWindowHiddenReason.INVALID_ANCHOR;
        r20.getClass();
        return new com.larus.contextwindow.api.a.a(r21);
    L67:
        List r22 = CollectionsKt.take(r13, r18 + 1);
        r16 = r13;
        if (r22 == null) goto L71;
        r16 = r22;
        goto L71
    L63:
        r18 = -1;
    L71:
        ContextWindowMessageSnapshot r23 = (ContextWindowMessageSnapshot) CollectionsKt.lastOrNull(r16);
        if (r23 == null) goto L74;
        Iterator r24 = CollectionsKt.asReversed(r16).iterator();
    L77:
        if (r24.hasNext() == false) goto L81;
        Object r25 = r24.next();
        if (((ContextWindowMessageSnapshot) r25).g == false) goto L77;
    L82:
        ContextWindowMessageSnapshot r26 = (ContextWindowMessageSnapshot) r25;
        if (r26 != null) goto L85;
    L87:
        boolean r27 = false;
    L88:
        String r28 = b(r23);
        if (r28 == null) goto L92;
        a r30 = new a(r23, r28, ContextWindowUsageSource.CURRENT);
    L117:
        if (r30 == null) goto L119;
        d r31 = d.a;
        String r32 = r30.b;
        r31.getClass();
        Intrinsics.checkNotNullParameter(r32, "raw");
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L130
        JsonElement r34 = new JsonParser().parse(r32);     // Catch: Throwable -> L130
        if (r34.isJsonObject() == true) goto L125;
        r34 = null;
    L125:
        if (r34 == null) goto L127;
        JsonObject r35 = r34.getAsJsonObject();     // Catch: Throwable -> L130
    L128:
        Object r36 = Result.constructor-impl(r35);     // Catch: Throwable -> L130
    L133:
        if (Result.isFailure-impl(r36) == false) goto L135;
        r36 = null;
    L135:
        JsonObject r37 = (JsonObject) r36;
        if (r37 != null) goto L138;
        Object r38 = new b(ContextWindowHiddenReason.USAGE_INVALID);
    L191:
        if ((r38 instanceof c) == false) goto L225;
        c r40 = (c) r38;
        ContextWindowUsageSource r41 = r30.c;
        Long r42 = r40.c;
        boolean r43 = r23.g;
        if (r43 == true) goto L195;
    L198:
        if (r43 == false) goto L203;
        Long r44 = r210.f;
        if (r44 == null) goto L215;
        r2 = TuplesKt.to(Long.valueOf(r44.longValue()), ContextWindowTotalSource.CURRENT_MODEL);
    L215:
        if (r2 != null) goto L219;
        return new com.larus.contextwindow.api.a.a(ContextWindowHiddenReason.TOTAL_MISSING);
    L219:
        if (((Number) r2.getFirst()).longValue() <= 0) goto L221;
        String r45 = r210.b;
        String r46 = r210.c;
        String r110 = r30.a.b;
        ContextWindowUsageParts r111 = r40.a;
        long r112 = r40.b;
        long r113 = ((Number) r2.getFirst()).longValue();
        int r47 = x29.a.a;
        return new a$b(new ContextWindowSnapshot(r45, r46, r110, r111, r112, r113, x29.a.b(r40.b, ((Number) r2.getFirst()).longValue()), r30.c, (ContextWindowTotalSource) r2.getSecond(), r23.g, r27));
    L221:
        return new com.larus.contextwindow.api.a.a(ContextWindowHiddenReason.TOTAL_INVALID);
    L203:
        if (r41 != ContextWindowUsageSource.CURRENT) goto L212;
        Long r48 = r210.f;
        if (r48 == null) goto L210;
        Pair r50 = TuplesKt.to(Long.valueOf(r48.longValue()), ContextWindowTotalSource.CURRENT_MODEL);
        if (r50 == null) goto L210;
        r2 = r50;
    L210:
        if (r42 == null) goto L215;
        r2 = TuplesKt.to(Long.valueOf(r42.longValue()), ContextWindowTotalSource.MESSAGE_FALLBACK);
        goto L215
    L212:
        Long r51 = r210.f;
        if (r51 == null) goto L215;
        r2 = TuplesKt.to(Long.valueOf(r51.longValue()), ContextWindowTotalSource.CURRENT_MODEL);
        goto L215
    L195:
        if (r41 != ContextWindowUsageSource.CURRENT) goto L198;
        if (r42 == null) goto L215;
        r2 = TuplesKt.to(Long.valueOf(r42.longValue()), ContextWindowTotalSource.MESSAGE);
        goto L215
    L225:
        if ((r38 instanceof b) == false) goto L229;
        return new com.larus.contextwindow.api.a.a(((b) r38).a);
    L229:
        throw new NoWhenBranchMatchedException();
    L138:
        Long r52 = d.a(r37.get("messages"));
        if (r52 == null) goto L189;
        long r211 = r52.longValue();
        Long r53 = d.a(r37.get("system_prompt"));
        if (r53 == null) goto L188;
        long r212 = r53.longValue();
        Long r54 = d.a(r37.get("tools"));
        if (r54 == null) goto L187;
        long r213 = r54.longValue();
        Long r55 = d.a(r37.get("skills"));
        if (r55 == null) goto L186;
        long r214 = r55.longValue();
        ContextWindowUsageParts r56 = new ContextWindowUsageParts(r211, r212, r213, r214);
        long r114 = r211 + r212;
        if ((r212 ^ r211) >= 0) goto L149;
        boolean r115 = true;
    L151:
        if ((r211 ^ r114) < 0) goto L153;
        boolean r116 = true;
    L232:
        if ((r115 | r116) == false) goto L184;
        long r117 = r213 + r214;
        if ((r214 ^ r213) >= 0) goto L159;
        boolean r118 = true;
    L161:
        if ((r213 ^ r117) < 0) goto L163;
        boolean r119 = true;
    L165:
        if ((r118 | r119) == false) goto L182;
        long r120 = r114 + r117;
        if ((r117 ^ r114) >= 0) goto L169;
        boolean r121 = true;
    L171:
        if ((r114 ^ r120) < 0) goto L174;
        r5 = true;
    L174:
        if ((r5 | r121) == false) goto L180;
        if (r120 != 0) goto L178;
        r38 = new b(ContextWindowHiddenReason.USED_EMPTY);
        goto L191
    L178:
        r38 = new c(r56, r120, d.a(r37.get("total_window_size")));
        goto L191
    L180:
        throw new ArithmeticException();     // Catch: ArithmeticException -> L185
    L169:
        r121 = false;
        goto L171
    L182:
        throw new ArithmeticException();     // Catch: ArithmeticException -> L185
    L163:
        r119 = false;
        goto L165
    L159:
        r118 = false;
        goto L161
    L184:
        throw new ArithmeticException();     // Catch: ArithmeticException -> L185
    L185:
        r38 = new b(ContextWindowHiddenReason.USED_OVERFLOW);
        goto L191
    L153:
        r116 = false;
        goto L232
    L149:
        r115 = false;
        goto L151
    L186:
        r38 = new b(ContextWindowHiddenReason.USAGE_INVALID);
        goto L191
    L187:
        r38 = new b(ContextWindowHiddenReason.USAGE_INVALID);
        goto L191
    L188:
        r38 = new b(ContextWindowHiddenReason.USAGE_INVALID);
        goto L191
    L189:
        r38 = new b(ContextWindowHiddenReason.USAGE_INVALID);
        goto L191
    L127:
        r35 = null;
    L130:
        th = move-exception;
        Result.Companion r57 = Result.Companion;
        r36 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L133
    L119:
        return new com.larus.contextwindow.api.a.a(ContextWindowHiddenReason.USAGE_MISSING);
    L92:
        if (r23.g == false) goto L100;
        ContextWindowMessageSnapshot r58 = (ContextWindowMessageSnapshot) CollectionsKt.getOrNull(r16, CollectionsKt.getLastIndex(r16) - 1);
        if (r58 == null) goto L115;
        String r60 = b(r58);
        if (r60 == null) goto L115;
        r30 = new a(r58, r60, ContextWindowUsageSource.FALLBACK_ADJACENT);
    L115:
        r30 = null;
        goto L117
    L100:
        Iterator r61 = CollectionsKt.asReversed(CollectionsKt.dropLast(r16, 1)).iterator();
    L102:
        if (r61.hasNext() == false) goto L109;
        Object r62 = r61.next();
        a.getClass();
        if (b((ContextWindowMessageSnapshot) r62) == null) goto L106;
        boolean r63 = true;
    L107:
        if (r63 == false) goto L102;
    L110:
        ContextWindowMessageSnapshot r64 = (ContextWindowMessageSnapshot) r62;
        if (r64 == null) goto L115;
        String r65 = b(r64);
        if (r65 == null) goto L115;
        r30 = new a(r64, r65, ContextWindowUsageSource.FALLBACK_HISTORICAL);
        goto L117
    L106:
        r63 = false;
        goto L107
    L109:
        r62 = null;
        goto L110
    L85:
        if (r26.j != true) goto L87;
        r27 = true;
        goto L88
    L81:
        r25 = null;
        goto L82
    L74:
        return new com.larus.contextwindow.api.a.a(ContextWindowHiddenReason.NO_CANDIDATE);
    L5:
        ContextWindowContainer r66 = r210.d;
        if (r66 != ContextWindowContainer.DEFAULT_CHAT) goto L8;
    L10:
        ContextWindowMode r67 = r210.e;
        if (r67 != ContextWindowMode.CLOSE) goto L13;
    L22:
        r0 = ContextWindowHiddenReason.UNSUPPORTED_MODE;
        goto L23
    L13:
        if (r67 == ContextWindowMode.PRO) goto L22;
        if (r67 != ContextWindowMode.UNKNOWN) goto L19;
        r0 = ContextWindowHiddenReason.MODE_UNAVAILABLE;
        goto L23
    L19:
        if (StringsKt.isBlank(r210.b) == false) goto L21;
        r0 = ContextWindowHiddenReason.INVALID_CONVERSATION;
        goto L23
    L21:
        r0 = null;
        goto L23
    L8:
        if (r66 == ContextWindowContainer.NATIVE_ROUTE) goto L10;
        r0 = ContextWindowHiddenReason.UNSUPPORTED_CONTAINER;
        goto L23
    }

    public static String b(ContextWindowMessageSnapshot r1) {
        String r2 = r1.i;
        if (r2 != null) goto L5;
    L7:
        return null;
    L5:
        if ((!StringsKt.isBlank(r2)) == false) goto L7;
        return r2;
    }
}
