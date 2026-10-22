package p3;

import com.bytedance.ai.bridge.method.calendar.remote.Property;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class v implements Property {
    public static final Property.NodeInfo c = null;
    public final String b;

    public static final class a {
    }

    static {
        c = new Property.NodeInfo("urn:ietf:params:xml:ns:caldav", "schedule-tag");
    }

    public final String toString() {
        String r0 = this.b;
        if (r0 != null) goto L6;
        return "(null)";
    L6:
        return r0;
    }

    public v(String r1) {
        if (r1 == null) goto L5;
        String r10 = q3.b.a(r1);
    L6:
        this.b = r10;
        return;
    L5:
        r10 = null;
        goto L6
    }
}
