package p3;

import com.bytedance.ai.bridge.method.calendar.remote.Property;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class o implements Property {
    public static final Property.NodeInfo c = null;
    public final String b;

    public static final class a {
    }

    static {
        c = new Property.NodeInfo("DAV:", "getetag");
    }

    public final String toString() {
        String r0 = this.b;
        if (r0 != null) goto L6;
        return "(null)";
    L6:
        return r0;
    }

    public o(String r10) {
        String r0 = null;
        if (r10 != null) goto L5;
    L10:
        this.b = r0;
        return;
    L5:
        if (StringsKt.startsWith$default(r10, "W/", false, 2, null) == true) goto L7;
    L9:
        r0 = q3.b.a(r10);
        goto L10
    L7:
        if (r10.length() < 3) goto L9;
        r10 = r10.substring(2);
        goto L9
    }
}
