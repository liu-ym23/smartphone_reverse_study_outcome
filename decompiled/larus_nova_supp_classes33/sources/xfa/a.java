package xfa;

import android.os.Bundle;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String c(String r4) {
        StringBuilder r0 = new StringBuilder(r4.length());
        int r1 = 0;
    L4:
        if (r1 >= r4.length()) goto L24;
        char r2 = r4.charAt(r1);
        if (r2 != '\f') goto L8;
        r0.append("\\f");
    L22:
        r1 = r1 + 1;
        goto L4
    L8:
        if (r2 != '\r') goto L10;
        r0.append("\\r");
        goto L22
    L10:
        if (r2 != '\"') goto L12;
        r0.append("\\\"");
        goto L22
    L12:
        if (r2 == '\\') goto L18;
        switch(r2) {
            case 8: goto L17;
            case 9: goto L16;
            case 10: goto L15;
            default: goto L14;
        };
    L14:
        r0.append(r2);
        goto L22
    L15:
        r0.append("\\n");
        goto L22
    L16:
        r0.append("\\t");
        goto L22
    L17:
        r0.append("\\b");
        goto L22
    L18:
        r0.append("\\\\");
        goto L22
    L24:
        return r0.toString();
    }

    public static String b(Bundle r12, int r13) {
        StringBuilder r0 = new StringBuilder();
        r0.append("{");
        List r1 = CollectionsKt.toList(r12.keySet());
        int r2 = Math.min(r1.size(), 30);
        Iterator r4 = CollectionsKt.take(r1, 30).iterator();
        int r5 = 0;
    L4:
        if (r4.hasNext() == false) goto L18;
        Object r6 = r4.next();
        int r10 = r5 + 1;
        if (r5 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        String r7 = (String) r6;
        r0.append('\"');     // Catch: Exception -> L13
        Intrinsics.checkNotNull(r7);     // Catch: Exception -> L13
        r0.append(c(r7));     // Catch: Exception -> L13
        r0.append('\"');     // Catch: Exception -> L13
        r0.append(": ");     // Catch: Exception -> L13
        a(r0, r12.get(r7), r13);     // Catch: Exception -> L13
        if (r5 >= (r2 - 1)) goto L16;
        r0.append(", ");     // Catch: Exception -> L13
    L16:
        r5 = r10;
    L13:
        r0.append('\"');
        Intrinsics.checkNotNull(r7);
        r0.append(c(r7));
        r0.append('\"');
        r0.append(": ");
        r0.append('\"');
        r0.append(c("[Error serializing value]"));
        r0.append('\"');
        if (r5 >= (r2 - 1)) goto L16;
        r0.append(", ");
        goto L16
    L18:
        if (r1.size() <= 30) goto L22;
        if (r2 <= 0) goto L21;
        r0.append(", ");
    L21:
        r0.append('\"');
        r0.append(c("[TRUNCATED: more than 30 keys]"));
        r0.append('\"');
        r0.append(": ");
        r0.append('\"');
        r0.append(c("..."));
        r0.append('\"');
    L22:
        r0.append("}");
        return r0.toString();
    }

    public static void a(StringBuilder r7, Object r8, int r9) {
        if (r8 != null) goto L5;
        r7.append("null");
        return;
    L5:
        if ((r8 instanceof String) == false) goto L8;
        r7.append('\"');
        r7.append(c((String) r8));
        r7.append('\"');
        return;
    L8:
        if ((r8 instanceof Integer) == false) goto L10;
    L79:
        r7.append(r8);
        return;
    L10:
        if ((r8 instanceof Long) == true) goto L79;
        if ((r8 instanceof Float) == true) goto L79;
        if ((r8 instanceof Double) == true) goto L79;
        if ((r8 instanceof Boolean) == true) goto L79;
        if ((r8 instanceof Bundle) == true) goto L21;
        int r2 = 0;
        if ((r8 instanceof int[]) == false) goto L34;
        r7.append("[");
        int[] r10 = (int[]) r8;
        int r11 = r10.length;
        int r0 = 0;
    L27:
        if (r2 >= r11) goto L32;
        int r5 = r0 + 1;
        r7.append(r10[r2]);
        if (r0 >= (r10.length - 1)) goto L31;
        r7.append(", ");
    L31:
        r2 = r2 + 1;
        r0 = r5;
        goto L27
    L32:
        r7.append("]");
        return;
    L34:
        if ((r8 instanceof long[]) == false) goto L43;
        r7.append("[");
        long[] r12 = (long[]) r8;
        int r13 = r12.length;
        int r1 = 0;
    L36:
        if (r2 >= r13) goto L41;
        int r3 = r1 + 1;
        r7.append(r12[r2]);
        if (r1 >= (r12.length - 1)) goto L40;
        r7.append(", ");
    L40:
        r2 = r2 + 1;
        r1 = r3;
        goto L36
    L41:
        r7.append("]");
        return;
    L43:
        if ((r8 instanceof float[]) == false) goto L52;
        r7.append("[");
        float[] r14 = (float[]) r8;
        int r15 = r14.length;
        int r4 = 0;
    L45:
        if (r2 >= r15) goto L50;
        int r6 = r4 + 1;
        r7.append(r14[r2]);
        if (r4 >= (r14.length - 1)) goto L49;
        r7.append(", ");
    L49:
        r2 = r2 + 1;
        r4 = r6;
        goto L45
    L50:
        r7.append("]");
        return;
    L52:
        if ((r8 instanceof double[]) == false) goto L61;
        r7.append("[");
        double[] r16 = (double[]) r8;
        int r17 = r16.length;
        int r18 = 0;
    L54:
        if (r2 >= r17) goto L59;
        int r19 = r18 + 1;
        r7.append(r16[r2]);
        if (r18 >= (r16.length - 1)) goto L58;
        r7.append(", ");
    L58:
        r2 = r2 + 1;
        r18 = r19;
        goto L54
    L59:
        r7.append("]");
        return;
    L61:
        if ((r8 instanceof boolean[]) == false) goto L70;
        r7.append("[");
        boolean[] r20 = (boolean[]) r8;
        int r21 = r20.length;
        int r22 = 0;
    L63:
        if (r2 >= r21) goto L68;
        int r23 = r22 + 1;
        r7.append(r20[r2]);
        if (r22 >= (r20.length - 1)) goto L67;
        r7.append(", ");
    L67:
        r2 = r2 + 1;
        r22 = r23;
        goto L63
    L68:
        r7.append("]");
        return;
    L70:
        if ((r8 instanceof Object[]) == false) goto L78;
        r7.append("[");
        Object[] r24 = (Object[]) r8;
        int r25 = r24.length;
        int r26 = 0;
    L72:
        if (r2 >= r25) goto L77;
        int r27 = r26 + 1;
        a(r7, r24[r2], r9);
        if (r26 >= (r24.length - 1)) goto L76;
        r7.append(", ");
    L76:
        r2 = r2 + 1;
        r26 = r27;
        goto L72
    L77:
        r7.append("]");
        return;
    L78:
        r7.append('\"');
        r7.append(c(r8.toString()));
        r7.append('\"');
        return;
    L21:
        if (r9 >= 3) goto L23;
        r7.append(b((Bundle) r8, r9 + 1));
        return;
    L23:
        r7.append('\"');
        r7.append(c("[TRUNCATED: max recursion depth reached]"));
        r7.append('\"');
    }
}
