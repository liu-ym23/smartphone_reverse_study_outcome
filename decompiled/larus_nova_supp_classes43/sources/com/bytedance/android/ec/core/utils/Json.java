package com.bytedance.android.ec.core.utils;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class Json {
    public static final Lazy a = null;
    public static final Json b = null;

    public Json() {
    }

    static {
        b = new Json();
        a = LazyKt.lazy(Json$gson$2.INSTANCE);
    }

    public static String d(Object r1) {
        return GsonProtectorUtils.toJson((Gson) a.getValue(), r1);
    }

    public final String a(Object[] r10) {
        StringBuilder r0 = new StringBuilder();
        r0.append("[");
        if (r10 != null) goto L5;
    L10:
        r0.append("]");
    L12:
        return r0.toString();
    L5:
        if (r10.length <= 0) goto L10;
        int r1 = r10.length;
        int r11 = 0;
    L7:
        if (r11 >= r1) goto L9;
        r0.append(c(r10[r11]));
        r0.append(",");
        r11 = r11 + 1;
        goto L7
    L9:
        r0.setCharAt(r0.length() - 1, ']');
        goto L12
    }

    public final String b(List<?> r10) {
        StringBuilder r0 = new StringBuilder();
        r0.append("[");
        if (r10 != null) goto L5;
    L11:
        r0.append("]");
    L13:
        return r0.toString();
    L5:
        if (r10.size() <= 0) goto L11;
        Iterator<?> r11 = r10.iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        r0.append(c(r11.next()));
        r0.append(",");
        goto L8
    L10:
        r0.setCharAt(r0.length() - 1, ']');
        goto L13
    }

    public final String c(Object r10) {
        StringBuilder r0 = new StringBuilder();
        if (r10 != null) goto L6;
        r0.append("\"\"");
    L92:
        return r0.toString();
    L6:
        if ((r10 instanceof String) == false) goto L8;
    L54:
        r0.append("\"");
        String r11 = r10.toString();
        if (r11 != null) goto L57;
        String r12 = "";
    L90:
        r0.append(r12);
        r0.append("\"");
        goto L92
    L57:
        StringBuilder r13 = new StringBuilder();
        int r14 = r11.length();
        int r15 = 0;
    L58:
        if (r15 >= r14) goto L89;
        char r16 = r11.charAt(r15);
        if (r16 != '\f') goto L62;
        r13.append("\\f");
    L88:
        r15 = r15 + 1;
        goto L58
    L62:
        if (r16 != '\r') goto L64;
        r13.append("\\r");
        goto L88
    L64:
        if (r16 != '\"') goto L66;
        r13.append("\\\"");
        goto L88
    L66:
        if (r16 != '/') goto L68;
        r13.append("\\/");
        goto L88
    L68:
        if (r16 == '\\') goto L83;
        switch(r16) {
            case 8: goto L77;
            case 9: goto L76;
            case 10: goto L75;
            default: goto L71;
        };
    L75:
        r13.append("\\n");
        goto L88
    L76:
        r13.append("\\t");
        goto L88
    L77:
        r13.append("\\b");
        goto L88
    L71:
        if (Intrinsics.compare(r16, 0) >= 0) goto L73;
    L82:
        r13.append(r16);
        goto L88
    L73:
        if (Intrinsics.compare(r16, 31) > 0) goto L82;
        String r17 = Integer.toHexString(r16);
        r13.append("\\u");
        int r18 = 0;
    L79:
        if (r18 >= (4 - r17.length())) goto L81;
        r13.append('0');
        r18 = r18 + 1;
        goto L79
    L81:
        r13.append(r17.toUpperCase(Locale.ROOT));
        goto L88
    L83:
        r13.append("\\\\");
        goto L88
    L89:
        r12 = r13.toString();
        goto L90
    L8:
        if ((r10 instanceof Integer) == true) goto L54;
        if ((r10 instanceof Float) == true) goto L54;
        if ((r10 instanceof Boolean) == true) goto L54;
        if ((r10 instanceof Short) == true) goto L54;
        if ((r10 instanceof Double) == true) goto L54;
        if ((r10 instanceof Long) == true) goto L54;
        if ((r10 instanceof BigDecimal) == true) goto L54;
        if ((r10 instanceof BigInteger) == true) goto L54;
        if ((r10 instanceof Byte) == true) goto L54;
        if ((r10 instanceof Object[]) == false) goto L30;
        r0.append(a((Object[]) r10));
        goto L92
    L30:
        if ((r10 instanceof List) == false) goto L33;
        r0.append(b((List) r10));
        goto L92
    L33:
        if ((r10 instanceof Map) == false) goto L44;
        Map r19 = (Map) r10;
        StringBuilder r1 = new StringBuilder();
        r1.append("{");
        if (r19.size() <= 0) goto L41;
        Iterator r20 = r19.keySet().iterator();
    L38:
        if (r20.hasNext() == false) goto L40;
        Object r21 = r20.next();
        r1.append(c(r21));
        r1.append(":");
        r1.append(c(r19.get(r21)));
        r1.append(",");
        goto L38
    L40:
        r1.setCharAt(r1.length() - 1, '}');
    L42:
        r0.append(r1.toString());
        goto L92
    L41:
        r1.append("}");
        goto L42
    L44:
        if ((r10 instanceof Set) == false) goto L92;
        Set r110 = (Set) r10;
        StringBuilder r22 = new StringBuilder();
        r22.append("[");
        if (r110.size() <= 0) goto L52;
        Iterator r111 = r110.iterator();
    L49:
        if (r111.hasNext() == false) goto L51;
        r22.append(c(r111.next()));
        r22.append(",");
        goto L49
    L51:
        r22.setCharAt(r22.length() - 1, ']');
    L53:
        r0.append(r22.toString());
        goto L92
    L52:
        r22.append("]");
        goto L53
    }
}
