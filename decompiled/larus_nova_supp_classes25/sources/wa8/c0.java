package wa8;

import com.larus.bmhome.actionbar.model.ActionBarItemLocation;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c0 {
    public static final Map<String, b0> a = null;

    public static final class a {
        public final String a;
        public final String b;
        public final int c;

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
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c;
        }

        public final String toString() {
            return "ItemIdentity(scopeId=" + this.a + ", actionBarKey=" + this.b + ", showPosition=" + this.c + ')';
        }

        public a(String r2, String r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "scopeId");
            Intrinsics.checkNotNullParameter(r3, "actionBarKey");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public c0() {
    }

    static {
        a = new LinkedHashMap();
    }

    public static a c(Map r6, Integer r7) {
        if (r6 == null) goto L47;
        String r1 = (String) r6.get("__action_bar_item_event_scope_id");
        if (r1 == null) goto L47;
        boolean r3 = true;
        if ((!StringsKt.isBlank(r1)) == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L47;
        String r2 = (String) r6.get("__action_bar_item_event_key");
        if (r2 == null) goto L47;
        if ((!StringsKt.isBlank(r2)) == true) goto L18;
        r2 = null;
    L18:
        if (r2 == null) goto L47;
        String r8 = (String) r6.get("__action_bar_item_event_position");
        if (r8 == null) goto L23;
        Integer r9 = StringsKt.toIntOrNull(r8);
    L25:
        if (r7 != null) goto L27;
    L35:
        if (r9 != null) goto L37;
    L42:
        r9 = null;
    L43:
        if (r9 == null) goto L47;
        int r10 = r9.intValue();
    L46:
        return new a(r1, r2, r10);
    L37:
        if (r9.intValue() > 0) goto L40;
        r3 = false;
    L40:
        if (r3 == false) goto L42;
    L27:
        if (r7.intValue() <= 0) goto L29;
        boolean r5 = true;
    L30:
        if (r5 == true) goto L33;
        r7 = null;
    L33:
        if (r7 == null) goto L35;
        r10 = r7.intValue();
        goto L46
    L29:
        r5 = false;
        goto L30
    L23:
        r9 = null;
    L47:
        return null;
    }

    public static boolean a(Map r2, ActionBarItemLocation r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r3, "location");
        a r5 = c(r2, r4);
        if (r5 != null) goto L5;
        return false;
    L5:
        Map<String, b0> r0 = a;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        b0 r6 = (b0) r1.get(r5.a);
        if (r6 != null) goto L8;
        return false;
    L8:
        r6.b(r3, r5.b, r5.c);
        return true;
    }

    public static boolean b(Map r2, ActionBarItemLocation r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r3, "location");
        a r5 = c(r2, r4);
        if (r5 != null) goto L5;
        return false;
    L5:
        Map<String, b0> r0 = a;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        b0 r6 = (b0) r1.get(r5.a);
        if (r6 != null) goto L8;
        return false;
    L8:
        r6.a(r3, r5.b, r5.c);
        return true;
    }
}
