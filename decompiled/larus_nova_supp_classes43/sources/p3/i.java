package p3;

import com.bytedance.ai.bridge.method.calendar.remote.Property;
import com.bytedance.ai.bridge.service.IHostStyleUIDepend;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i {
    public static final Property.NodeInfo a = null;

    public static final class a {
        public static List a(XmlPullParser r10) {
            Intrinsics.checkNotNullParameter(r10, "parser");
            LinkedHashSet r0 = new LinkedHashSet();
            int r1 = r10.getDepth();
            int r11 = r10.getEventType();
        L4:
            if (r11 != 3) goto L14;
            if (r10.getDepth() != r1) goto L14;
            ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
            Iterator r13 = r0.iterator();
        L10:
            if (r13.hasNext() == false) goto L12;
            r12.add(new i((Property.NodeInfo) r13.next()));
            goto L10
        L12:
            return r12;
        L14:
            if (r11 != 2) goto L18;
            if (r10.getDepth() != (r1 + 1)) goto L18;
            r0.add(new Property.NodeInfo(r10.getNamespace(), r10.getName()));
        L18:
            r11 = r10.next();
            goto L4
        }
    }

    static {
        a = new Property.NodeInfo("DAV:", IHostStyleUIDepend.TOAST_TYPE_ERROR);
        new i(new Property.NodeInfo("DAV:", "need-privileges"));
        new i(new Property.NodeInfo("DAV:", "valid-sync-token"));
    }

    public i(Property.NodeInfo r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
    }
}
