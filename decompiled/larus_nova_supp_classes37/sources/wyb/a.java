package wyb;

import com.alibaba.fastjson.JSONObject;
import java.util.Locale;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final Set<String> b = null;
    public final String a;

    /* JADX INFO: renamed from: wyb.a$a, reason: collision with other inner class name */
    public static final class C0203a {
        public static a a(JSONObject r2) {
            if (r2 == null) goto L5;
            String r3 = r2.getString("channel");
        L7:
            return new a(r3);
        L5:
            r3 = null;
            goto L7
        }

        public static boolean b(String r1) {
            if (r1 != null) goto L4;
            r1 = "";
        L4:
            String r2 = r1.toLowerCase(Locale.US);
            if (StringsKt.isBlank(r2) == false) goto L7;
        L10:
            return true;
        L7:
            if (a.b.contains(r2) == true) goto L10;
            return false;
        }
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public final String toString() {
        return "FlowIdpAuthInfo(channel=" + this.a + ')';
    }

    static {
        b = SetsKt.setOf(new String[]{"enterprise", "b_idp", "bidp"});
    }

    public final boolean a() {
        return C0203a.b(this.a);
    }

    public a(String r1) {
        this.a = r1;
    }
}
