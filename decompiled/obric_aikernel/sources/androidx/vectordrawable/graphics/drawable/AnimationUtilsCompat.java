package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Build;
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
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class AnimationUtilsCompat {
    private AnimationUtilsCompat() {
    }

    private static Interpolator createInterpolatorFromXml(Context r10, Resources r11, Resources.Theme r12, XmlPullParser r13) {
        int r14 = r13.getDepth();
        Interpolator r15 = null;
    L3:
        int r16 = r13.next();
        if (r16 != 3) goto L8;
        if (r13.getDepth() > r14) goto L8;
    L45:
        return r15;
    L8:
        if (r16 == 1) goto L45;
        if (r16 != 2) goto L3;
        AttributeSet r17 = Xml.asAttributeSet(r13);
        String r18 = r13.getName();
        if (r18.equals("linearInterpolator") == true) goto L14;
        if (r18.equals("accelerateInterpolator") == true) goto L17;
        if (r18.equals("decelerateInterpolator") == true) goto L21;
        if (r18.equals("accelerateDecelerateInterpolator") == false) goto L26;
        r15 = new AccelerateDecelerateInterpolator();
        goto L3
    L26:
        if (r18.equals("cycleInterpolator") == true) goto L27;
        if (r18.equals("anticipateInterpolator") == true) goto L30;
        if (r18.equals("overshootInterpolator") == true) goto L33;
        if (r18.equals("anticipateOvershootInterpolator") == true) goto L36;
        if (r18.equals("bounceInterpolator") == false) goto L41;
        r15 = new BounceInterpolator();
        goto L3
    L41:
        if (r18.equals("pathInterpolator") == false) goto L44;
        Interpolator r19 = new PathInterpolatorCompat(r10, r17, r13);
    L18:
        r15 = r19;
        goto L3
    L44:
        throw new RuntimeException("Unknown interpolator name: " + r13.getName());
    L36:
        r19 = new AnticipateOvershootInterpolator(r10, r17);
        goto L18
    L33:
        r19 = new OvershootInterpolator(r10, r17);
        goto L18
    L30:
        r19 = new AnticipateInterpolator(r10, r17);
        goto L18
    L27:
        r19 = new CycleInterpolator(r10, r17);
        goto L18
    L21:
        r19 = new DecelerateInterpolator(r10, r17);
        goto L18
    L17:
        r19 = new AccelerateInterpolator(r10, r17);
        goto L18
    L14:
        r15 = new LinearInterpolator();
        goto L3
    }

    public static Interpolator loadInterpolator(Context r10, int r11) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        XmlResourceParser r12 = null;
        if (r11 != 17563663) goto L17;
        return new FastOutLinearInInterpolator();
    L17:
        if (r11 != 17563661) goto L21;
        return new FastOutSlowInInterpolator();
    L21:
        if (r11 == 17563662) goto L23;
        XmlResourceParser r13 = r10.getResources().getAnimation(r11);     // Catch: Throwable -> L10 IOException -> L12 XmlPullParserException -> L14
        Interpolator r14 = createInterpolatorFromXml(r10, r10.getResources(), r10.getTheme(), r13);     // Catch: Throwable -> L10 IOException -> L12 XmlPullParserException -> L14
        if (r13 == null) goto L27;
        r13.close();
    L27:
        return r14;
    L23:
        return new LinearOutSlowInInterpolator();
    L10:
        th = move-exception;
        if (0 == 0) goto L34;
        r12.close();
    L34:
        throw th;
    L12:
        e = move-exception;
        Resources.NotFoundException r15 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(r11));     // Catch: Throwable -> L10
        r15.initCause(e);     // Catch: Throwable -> L10
        throw r15;     // Catch: Throwable -> L10
    L14:
        e = move-exception;
        Resources.NotFoundException r16 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(r11));     // Catch: Throwable -> L10
        r16.initCause(e);     // Catch: Throwable -> L10
        throw r16;     // Catch: Throwable -> L10
    L5:
        return AnimationUtils.loadInterpolator(r10, r11);
    }
}
