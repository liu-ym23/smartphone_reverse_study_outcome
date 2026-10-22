package db;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final /* synthetic */ int d = 0;
    public final Map<String, Object> a;
    public final Map<String, Object> b;
    public final ConcurrentHashMap<String, Object> c;

    /* JADX INFO: renamed from: db.a$a, reason: collision with other inner class name */
    public static final class C0152a {
        public static Object a(String r10, Object r11) {
            Intrinsics.checkNotNullParameter(r10, "input");
            boolean r1 = false;
            if (StringsKt.startsWith$default(r10, "$", false, 2, null) == false) goto L5;
            r10 = r10.substring(2);
        L5:
            int r0 = StringsKt.indexOf$default(r10, ".", 0, false, 6, null);
            if (r0 != (-1)) goto L8;
            String r12 = "";
        L10:
            int r13 = r0 + 1;
            if (r10 == null) goto L55;
            String r14 = r10.substring(r13);
            if ((r11 instanceof Map) == false) goto L27;
            if (r12.length() != 0) goto L17;
            r1 = true;
        L17:
            if (r1 == true) goto L19;
            Map r15 = (Map) r11;
            if (r15.containsKey(r12) == false) goto L27;
            Object r16 = r15.get(r12);
            if (r16 == null) goto L58;
            int r17 = a.d;
            return a(r14, r16);
        L58:
            return null;
        L19:
            return ((Map) r11).get(r10);
        L27:
            if ((r11 instanceof String) == false) goto L38;
            if (Intrinsics.areEqual(r10, "length") == true) goto L31;
            int r18 = CastIntegerProtector.parseInt(r10);
            String r19 = (String) r11;
            if (r18 < r19.length()) goto L35;
            return null;
        L35:
            return String.valueOf(r19.charAt(r18));
        L31:
            return Integer.valueOf(((String) r11).length());
        L38:
            if ((r11 instanceof List) == true) goto L40;
            return null;
        L40:
            if (Intrinsics.areEqual(r10, "length") == true) goto L42;
            if (r0 >= 0) goto L47;
            List r110 = (List) r11;
            int r111 = CastIntegerProtector.parseInt(r10);
            if (r111 < r110.size()) goto L61;
            return null;
        L61:
            return ListProtector.get(r110, r111);
        L47:
            List r112 = (List) r11;
            int r20 = CastIntegerProtector.parseInt(r12);
            if (r20 >= r112.size()) goto L50;
            Object r113 = ListProtector.get(r112, r20);
        L51:
            if (r113 == null) goto L62;
            int r21 = a.d;
            return a(r10.substring(r13), r113);
        L62:
            return null;
        L50:
            r113 = null;
            goto L51
        L42:
            return Integer.valueOf(((List) r11).size());
        L55:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        L8:
            if (r10 == null) goto L57;
            r12 = r10.substring(0, r0);
            goto L10
        L57:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
    }

    static {
    }

    public a() {
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
        this.c = new ConcurrentHashMap();
    }
}
