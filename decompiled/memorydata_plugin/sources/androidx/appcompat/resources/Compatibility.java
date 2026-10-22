package androidx.appcompat.resources;

import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public final class Compatibility {

    public static class Api15Impl {
        private Api15Impl() {
        }

        public static void getValueForDensity(Resources r0, int r1, int r2, TypedValue r3, boolean r4) {
            r0.getValueForDensity(r1, r2, r3, r4);
        }
    }

    public static class Api18Impl {
        private Api18Impl() {
        }

        public static void setAutoCancel(ObjectAnimator r0, boolean r1) {
            r0.setAutoCancel(r1);
        }
    }

    public static class Api21Impl {
        private Api21Impl() {
        }

        public static Drawable createFromXmlInner(Resources r2, XmlPullParser r3, AttributeSet r4, Resources.Theme r5) {
            return Drawable.createFromXmlInner(r2, (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), r5);
        }

        public static int getChangingConfigurations(TypedArray r0) {
            return r0.getChangingConfigurations();
        }

        public static void inflate(Drawable r2, Resources r3, XmlPullParser r4, AttributeSet r5, Resources.Theme r6) {
            r2.inflate(r3, (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r4, XmlPullParser.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin"), r6);
        }
    }

    private Compatibility() {
    }
}
