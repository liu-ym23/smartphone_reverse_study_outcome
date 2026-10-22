package q3;

import com.bytedance.ai.bridge.method.calendar.remote.Property;
import java.io.IOException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public static final XmlPullParserFactory a = null;

    public e() {
    }

    static {
        XmlPullParserFactory r0 = XmlPullParserFactory.newInstance();     // Catch: XmlPullParserException -> L5
        a = r0;     // Catch: XmlPullParserException -> L5
        r0.setNamespaceAware(true);     // Catch: XmlPullParserException -> L5
        return;
    L5:
        e = move-exception;
        throw new RuntimeException("Couldn't create XmlPullParserFactory", e);
    }

    public static Property.NodeInfo c(XmlPullParser r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        String r0 = r10.getNamespace();
        String r11 = r10.getName();
        if (r0 == null) goto L8;
        if (r11 == null) goto L8;
        return new Property.NodeInfo(r0, r11);
    L8:
        throw new IllegalStateException("invalid node");
    }

    public static String d(XmlPullParser r10) throws IOException, XmlPullParserException {
        Intrinsics.checkNotNullParameter(r10, "parser");
        int r0 = r10.getDepth();
        int r1 = r10.getEventType();
        String r11 = null;
    L4:
        if (r1 != 3) goto L10;
        if (r10.getDepth() != r0) goto L10;
        return r11;
    L10:
        if (r1 != 4) goto L14;
        if (r10.getDepth() != r0) goto L14;
        r11 = r10.getText();
    L14:
        r1 = r10.next();
        goto L4
    }

    public static /* synthetic */ void b(XmlSerializer r1, Property.NodeInfo r10) {
        a(r1, r10, new d());
    }

    public static void a(XmlSerializer r10, Property.NodeInfo r11, Function1 r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "node");
        Intrinsics.checkNotNullParameter(r12, "contentGenerator");
        r10.startTag(r11.getNamespace(), r11.getName());
        r12.invoke(r10);
        r10.endTag(r11.getNamespace(), r11.getName());
    }
}
