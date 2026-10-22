package p3;

import com.bytedance.ai.bridge.method.calendar.remote.Property;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class s implements com.bytedance.ai.bridge.method.calendar.remote.e {
    public s() {
    }

    @Override // com.bytedance.ai.bridge.method.calendar.remote.e
    public final Property.NodeInfo getNode() {
        return t.c;
    }

    @Override // com.bytedance.ai.bridge.method.calendar.remote.e
    public final Property a(XmlPullParser r10) {
        Intrinsics.checkNotNullParameter(r10, "parser");
        t r0 = new t();
        int r1 = r10.getDepth();
        int r11 = r10.getEventType();
    L4:
        if (r11 != 3) goto L11;
        if (r10.getDepth() != r1) goto L11;
        r10.getDepth();
        return r0;
    L11:
        if (r11 != 2) goto L30;
        if (r10.getDepth() != (r1 + 1)) goto L30;
        Property.NodeInfo r12 = new Property.NodeInfo(r10.getNamespace(), r10.getName());
        Property.NodeInfo r13 = t.d;
        if (Intrinsics.areEqual(r12, r13) == false) goto L17;
    L16:
        r12 = r13;
    L29:
        r0.b.add(r12);
        goto L30
    L17:
        r13 = t.e;
        if (Intrinsics.areEqual(r12, r13) == true) goto L16;
        r13 = t.f;
        if (Intrinsics.areEqual(r12, r13) == true) goto L16;
        r13 = t.g;
        if (Intrinsics.areEqual(r12, r13) == true) goto L16;
        r13 = t.h;
        if (Intrinsics.areEqual(r12, r13) == false) goto L29;
    L30:
        r11 = r10.next();
        goto L4
    }
}
