package androidx.appcompat.app;

import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Deque;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
class LayoutIncludeDetector {

    @NonNull
    private final Deque<WeakReference<XmlPullParser>> mXmlParserStack;

    public LayoutIncludeDetector() {
        this.mXmlParserStack = new ArrayDeque();
    }

    private static boolean isParserOutdated(@Nullable XmlPullParser r5) {
        if (r5 == null) goto L14;
        if (r5.getEventType() == 3) goto L15;
        if (r5.getEventType() == 1) goto L16;
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

    @Nullable
    private static XmlPullParser popOutdatedAttrHolders(@NonNull Deque<WeakReference<XmlPullParser>> r5) {
    L3:
        if (r5.isEmpty() == true) goto L8;
        XmlPullParser r10 = r5.peek().get();
        if (isParserOutdated(r10) == false) goto L7;
        r5.pop();
        goto L3
    L7:
        return r10;
    L8:
        return null;
    }

    private static boolean shouldInheritContext(@NonNull XmlPullParser r5, @Nullable XmlPullParser r10) {
        if (r10 == null) goto L8;
        if (r5 == r10) goto L13;
        if (r10.getEventType() != 2) goto L14;
        return "include".equals(r10.getName());
    L14:
        return false;
    L15:
        return false;
    L13:
        return false;
    L8:
        return false;
    }

    public boolean detect(@NonNull AttributeSet r5) {
        if ((r5 instanceof XmlPullParser) == false) goto L9;
        XmlPullParser r10 = (XmlPullParser) r5;
        if (r10.getDepth() != 1) goto L11;
        XmlPullParser r11 = popOutdatedAttrHolders(this.mXmlParserStack);
        this.mXmlParserStack.push(new WeakReference(r10));
        if (shouldInheritContext(r10, r11) == false) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    L9:
        return false;
    }
}
