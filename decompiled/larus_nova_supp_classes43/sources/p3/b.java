package p3;

import com.bytedance.ai.bridge.method.calendar.remote.Property;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements Property {
    public static final Property.NodeInfo c = null;
    public final String b;

    public static final class a {
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.b, ((b) r10).b) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        String r0 = this.b;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public final String toString() {
        return "CalendarData(iCalendar=" + this.b + ')';
    }

    static {
        c = new Property.NodeInfo("urn:ietf:params:xml:ns:caldav", "calendar-data");
    }

    public b(String r1) {
        this.b = r1;
    }
}
