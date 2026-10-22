package p3;

import com.bytedance.ai.bridge.method.calendar.remote.Property;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g implements com.bytedance.ai.bridge.method.calendar.remote.e {
    public g() {
    }

    @Override // com.bytedance.ai.bridge.method.calendar.remote.e
    public final Property.NodeInfo getNode() {
        return h.c;
    }

    @Override // com.bytedance.ai.bridge.method.calendar.remote.e
    public final Property a(XmlPullParser r10) {
        Intrinsics.checkNotNullParameter(r10, "parser");
        XmlPullParserFactory r1 = q3.e.a;
        return new h(q3.e.d(r10));
    }
}
