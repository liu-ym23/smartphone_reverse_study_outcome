package uz8;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public static final /* synthetic */ int e = 0;
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    public static final class a {
        public static String a(List r5) {
            Intrinsics.checkNotNullParameter(r5, "featureDetails");
            if (r5.isEmpty() == false) goto L6;
            return null;
        L6:
            LinkedHashMap r0 = new LinkedHashMap();
            Iterator r6 = r5.iterator();
        L8:
            if (r6.hasNext() == false) goto L10;
            C0138b r1 = (C0138b) r6.next();
            r0.put(r1.a, r1.b);
            goto L8
        L10:
            JSONArray r7 = new JSONArray();
            Iterator r2 = r0.entrySet().iterator();
        L12:
            if (r2.hasNext() == false) goto L15;
            Map.Entry r3 = (Map.Entry) r2.next();
            String r4 = (String) r3.getKey();
            String r8 = (String) r3.getValue();
            JSONObject r9 = new JSONObject();
            r9.put("feature_type", r4);
            r9.put("feature_detail", r8);
            r7.put(r9);
            goto L12
        L15:
            return r7.toString();
        }
    }

    /* JADX INFO: renamed from: uz8.b$b, reason: collision with other inner class name */
    public static final class C0138b {
        public static final /* synthetic */ int c = 0;
        public final String a;
        public final String b;

        /* JADX INFO: renamed from: uz8.b$b$a */
        public static final class a {
            public static C0138b a(String r9, String r10, Integer r11) {
                if (r9 == null) goto L30;
                String r12 = StringsKt.trim(r9).toString();
                if (r12 == null) goto L30;
                boolean r2 = false;
                if (r12.length() <= 0) goto L9;
                boolean r1 = true;
            L10:
                if (r1 == true) goto L13;
                r12 = null;
            L13:
                if (r12 == null) goto L30;
                if (r10 == null) goto L30;
                String r13 = StringsKt.trim(r10).toString();
                if (r13 == null) goto L30;
                if (r13.length() <= 0) goto L21;
                r2 = true;
            L21:
                if (r2 == false) goto L23;
                String r3 = r13;
            L24:
                if (r3 == null) goto L30;
                if (r11 == null) goto L29;
                r3 = StringsKt.replace$default(r3, "{duration}", String.valueOf(r11.intValue()), false, 4, null);
            L29:
                return new C0138b(r12, r3);
            L23:
                r3 = null;
                goto L24
            L9:
                r1 = false;
            L30:
                return null;
            }
        }

        static {
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0138b) == true) goto L8;
            return false;
        L8:
            C0138b r6 = (C0138b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "CreationSubscriptionFeatureDetail(key=" + this.a + ", value=" + this.b + ')';
        }

        public C0138b(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, "value");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }

    public b() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "CreationSubscriptionTrackingExtra(enterMethod=" + this.a + ", triggerScene=" + this.b + ", featureKey=" + this.c + ", featureDetail=" + this.d + ')';
    }

    public b(String r1, String r2, String r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
