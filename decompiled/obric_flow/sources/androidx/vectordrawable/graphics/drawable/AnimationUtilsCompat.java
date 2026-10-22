package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import androidx.annotation.RestrictTo;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class AnimationUtilsCompat {
    private AnimationUtilsCompat() {
    }

    private static Interpolator createInterpolatorFromXml(Context r5, Resources r10, Resources.Theme r11, XmlPullParser r12) throws XmlPullParserException, IOException {
        int r13 = r12.getDepth();
        Interpolator r14 = null;
    L3:
        int r15 = r12.next();
        if (r15 != 3) goto L8;
        if (r12.getDepth() > r13) goto L8;
    L45:
        return r14;
    L8:
        if (r15 == 1) goto L45;
        if (r15 != 2) goto L3;
        AttributeSet r16 = Xml.asAttributeSet(r12);
        String r17 = r12.getName();
        if (r17.equals("linearInterpolator") == true) goto L14;
        if (r17.equals("accelerateInterpolator") == true) goto L17;
        if (r17.equals("decelerateInterpolator") == true) goto L21;
        if (r17.equals("accelerateDecelerateInterpolator") == false) goto L26;
        r14 = new AccelerateDecelerateInterpolator();
        goto L3
    L26:
        if (r17.equals("cycleInterpolator") == true) goto L27;
        if (r17.equals("anticipateInterpolator") == true) goto L30;
        if (r17.equals("overshootInterpolator") == true) goto L33;
        if (r17.equals("anticipateOvershootInterpolator") == true) goto L36;
        if (r17.equals("bounceInterpolator") == false) goto L41;
        r14 = new BounceInterpolator();
        goto L3
    L41:
        if (r17.equals("pathInterpolator") == false) goto L44;
        Interpolator r18 = new PathInterpolatorCompat(r5, r16, r12);
    L18:
        r14 = r18;
        goto L3
    L44:
        throw new RuntimeException("Unknown interpolator name: " + r12.getName());
    L36:
        r18 = new AnticipateOvershootInterpolator(r5, r16);
        goto L18
    L33:
        r18 = new OvershootInterpolator(r5, r16);
        goto L18
    L30:
        r18 = new AnticipateInterpolator(r5, r16);
        goto L18
    L27:
        r18 = new CycleInterpolator(r5, r16);
        goto L18
    L21:
        r18 = new DecelerateInterpolator(r5, r16);
        goto L18
    L17:
        r18 = new AccelerateInterpolator(r5, r16);
        goto L18
    L14:
        r14 = new LinearInterpolator();
        goto L3
    }

    public static Interpolator loadInterpolator(Context r5, int r10) throws Resources.NotFoundException {
        return AnimationUtils.loadInterpolator(r5, r10);
    }
}
