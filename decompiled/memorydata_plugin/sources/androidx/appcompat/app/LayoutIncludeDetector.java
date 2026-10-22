package androidx.appcompat.app;

import android.util.AttributeSet;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Deque;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
class LayoutIncludeDetector {
    private final Deque<WeakReference<XmlPullParser>> mXmlParserStack;

    LayoutIncludeDetector() {
        this.mXmlParserStack = new ArrayDeque();
    }

    private static boolean isParserOutdated(XmlPullParser r3) {
        XmlPullParser r4 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L14;
        if (r4.getEventType() == 3) goto L15;
        if (r4.getEventType() == 1) goto L16;
        return false;
    L16:
        return true;
    L15:
        return true;
    L17:
        return true;
    L14:
        return true;
    }

    private static XmlPullParser popOutdatedAttrHolders(Deque<WeakReference<XmlPullParser>> r3) {
        Deque r4 = (Deque) ZeusTransformUtils.wrapperContextForParams(r3, Deque.class, "com.obric.memorydata.plugin");
    L4:
        if (r4.isEmpty() == true) goto L9;
        XmlPullParser r0 = (XmlPullParser) ZeusTransformUtils.preCheckCast(((WeakReference) ZeusTransformUtils.preCheckCast(r4.peek(), WeakReference.class, "com.obric.memorydata.plugin")).get(), XmlPullParser.class, "com.obric.memorydata.plugin");
        if (isParserOutdated(r0) == false) goto L8;
        r4.pop();
        goto L4
    L8:
        return r0;
    L9:
        return null;
    }

    private static boolean shouldInheritContext(XmlPullParser r2, XmlPullParser r3) {
        XmlPullParser r4 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r2, XmlPullParser.class, "com.obric.memorydata.plugin");
        XmlPullParser r5 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L9;
        if (r4 == r5) goto L14;
        if (r5.getEventType() != 2) goto L15;
        return "include".equals(r5.getName());
    L15:
        return false;
    L16:
        return false;
    L14:
        return false;
    L9:
        return false;
    }

    boolean detect(AttributeSet r4) {
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, XmlPullParser.class) == false) goto L9;
        XmlPullParser r6 = (XmlPullParser) ZeusTransformUtils.preCheckCast(r5, XmlPullParser.class, "com.obric.memorydata.plugin");
        if (r6.getDepth() != 1) goto L11;
        XmlPullParser r0 = popOutdatedAttrHolders(this.mXmlParserStack);
        this.mXmlParserStack.push(new WeakReference(r6));
        if (shouldInheritContext(r6, r0) == false) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    L9:
        return false;
    }
}
