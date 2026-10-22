package p3;

import com.bytedance.ai.bridge.method.calendar.remote.Property;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class t implements Property {
    public static final Property.NodeInfo c = null;
    public static final Property.NodeInfo d = null;
    public static final Property.NodeInfo e = null;
    public static final Property.NodeInfo f = null;
    public static final Property.NodeInfo g = null;
    public static final Property.NodeInfo h = null;
    public final Set<Property.NodeInfo> b;

    public static final class a {
    }

    static {
        c = new Property.NodeInfo("DAV:", "resourcetype");
        d = new Property.NodeInfo("DAV:", "collection");
        e = new Property.NodeInfo("DAV:", "principal");
        f = new Property.NodeInfo("urn:ietf:params:xml:ns:carddav", "addressbook");
        g = new Property.NodeInfo("urn:ietf:params:xml:ns:caldav", "calendar");
        h = new Property.NodeInfo("http://calendarserver.org/ns/", "subscribed");
    }

    public final String toString() {
        return "[" + CollectionsKt.joinToString$default(this.b, ", ", null, null, 0, null, null, 62, null) + ']';
    }

    public t() {
        this.b = new LinkedHashSet();
    }
}
