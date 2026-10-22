package p3;

import com.bytedance.ai.bridge.method.calendar.remote.Property;
import java.util.LinkedList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class p implements Property {
    public final LinkedList<String> b;

    public static abstract class a implements com.bytedance.ai.bridge.method.calendar.remote.e {
        public a() {
        }

        public static void b(XmlPullParser r10, p r11) {
            Intrinsics.checkNotNullParameter(r10, "parser");
            Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_LIST);
            XmlPullParserFactory r12 = q3.e.a;
            Property.NodeInfo r13 = com.bytedance.ai.bridge.method.calendar.remote.b.g;
            LinkedList<String> r14 = r11.b;
            Intrinsics.checkNotNullParameter(r10, "parser");
            Intrinsics.checkNotNullParameter(r13, "node");
            Intrinsics.checkNotNullParameter(r14, com.bytedance.android.ec.core.event.a.KEY_LIST);
            int r0 = r10.getDepth();
            int r1 = r10.getEventType();
        L4:
            if (r1 == 3) goto L8;
            if (r1 == 1) goto L8;
        L10:
            if (r1 != 2) goto L16;
            if (r10.getDepth() != (r0 + 1)) goto L16;
            if (Intrinsics.areEqual(q3.e.c(r10), r13) == false) goto L16;
            r14.add(r10.nextText());
        L16:
            r1 = r10.next();
        L8:
            if (r10.getDepth() != r0) goto L10;
        }
    }

    public final String toString() {
        return "href=[" + CollectionsKt.joinToString$default(this.b, ", ", null, null, 0, null, null, 62, null) + ']';
    }

    public p() {
        this.b = new LinkedList();
    }
}
