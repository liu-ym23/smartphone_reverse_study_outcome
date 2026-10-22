package su1;

import com.bytedance.android.livesdk.dynamicstrategy.impl.express.exception.SimpleExpressException;
import java.util.LinkedList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements e {
    public static final a b = null;
    public final String a;

    public static final class a {
        public a() {
        }

        private final int getType(Number r2) {
            if ((r2 instanceof Double) == false) goto L6;
            return 4;
        L6:
            if ((r2 instanceof Float) == false) goto L9;
            return 3;
        L9:
            if ((r2 instanceof Long) == false) goto L11;
            return 2;
        L11:
            return 1;
        }

        public static final int a(a r3, Object r4, Object r5) {
            r3.getClass();
            if ((r4 instanceof String) == false) goto L8;
            if ((r5 instanceof String) == false) goto L8;
            return ((String) r4).compareTo((String) r5);
        L8:
            if ((r4 instanceof Boolean) == false) goto L16;
            if ((r5 instanceof Boolean) == false) goto L16;
            if (Intrinsics.areEqual(r4, r5) == false) goto L14;
            return 0;
        L14:
            return -1;
        L16:
            if ((r4 instanceof Number) == false) goto L31;
            if ((r5 instanceof Number) == false) goto L31;
            Number r6 = (Number) r4;
            Number r7 = (Number) r5;
            int r8 = Math.max(r3.getType(r6), r3.getType(r7));
            if (r8 == 2) goto L29;
            if (r8 == 3) goto L37;
            if (r8 == 4) goto L36;
            return Intrinsics.compare(r6.intValue(), r7.intValue());
        L36:
            return Double.compare(r6.doubleValue(), r7.doubleValue());
        L37:
            return Float.compare(r6.floatValue(), r7.floatValue());
        L29:
            return (r6.longValue() > r7.longValue() ? 1 : (r6.longValue() == r7.longValue() ? 0 : -1));
        L31:
            throw new SimpleExpressException("express execute failed, compare error, o1 is " + r4 + ", o2 is " + r5, null, 2, null);
        }
    }

    static {
        b = new a();
    }

    public b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "operator");
        this.a = r2;
    }

    public final Object b(qu1.a r6) {
        if (r6.a.isEmpty() == true) goto L10;
        Object r7 = ((LinkedList) r6.a).pop();
        if (r7 == null) goto L8;
        return r7;
    L8:
        throw new SimpleExpressException("express execute failed, " + this.a + " operation value is " + r7, null, 2, null);
    L10:
        throw new SimpleExpressException("express execute failed, " + this.a + " operation value is null", null, 2, null);
    }

    @Override // su1.e
    public final void a(qu1.a r4, Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r4, "environment");
        Intrinsics.checkNotNullParameter(r5, "context");
        Object r6 = b(r4);
        int r7 = a.a(b, b(r4), r6);
        String r0 = this.a;
        int r1 = r0.hashCode();
        if (r1 == 60) goto L37;
        if (r1 == 62) goto L33;
        if (r1 == 1084) goto L29;
        if (r1 == 1921) goto L24;
        if (r1 == 1952) goto L20;
        if (r1 != 1983) goto L44;
        if (r0.equals(">=") == false) goto L44;
        if (r7 == 0) goto L39;
        if (r7 > 0) goto L39;
    L40:
        boolean r8 = false;
    L41:
        ((LinkedList) r4.a).push(Boolean.valueOf(r8));
        return;
    L39:
        r8 = true;
    L44:
        throw new SimpleExpressException("express execute failed, unknown operator[" + this.a + ']', null, 2, null);
    L20:
        if (r0.equals("==") == false) goto L44;
        if (r7 != 0) goto L40;
    L24:
        if (r0.equals("<=") == false) goto L44;
        if (r7 == 0) goto L39;
        if (r7 >= 0) goto L40;
    L29:
        if (r0.equals("!=") == false) goto L44;
        if (r7 == 0) goto L40;
    L33:
        if (r0.equals(">") == false) goto L44;
        if (r7 <= 0) goto L40;
    L37:
        if (r0.equals("<") == false) goto L44;
        if (r7 >= 0) goto L40;
        goto L39
    }
}
