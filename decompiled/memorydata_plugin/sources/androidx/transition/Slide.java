package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.core.content.res.TypedArrayUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class Slide extends Visibility {
    private static final String PROPNAME_SCREEN_POSITION = "android:slide:screenPosition";
    private static final TimeInterpolator sAccelerate = null;
    private static final CalculateSlide sCalculateBottom = null;
    private static final CalculateSlide sCalculateEnd = null;
    private static final CalculateSlide sCalculateLeft = null;
    private static final CalculateSlide sCalculateRight = null;
    private static final CalculateSlide sCalculateStart = null;
    private static final CalculateSlide sCalculateTop = null;
    private static final TimeInterpolator sDecelerate = null;
    private CalculateSlide mSlideCalculator;
    private int mSlideEdge;

    private interface CalculateSlide {
        float getGoneX(ViewGroup r1, View r2);

        float getGoneY(ViewGroup r1, View r2);
    }

    private static abstract class CalculateSlideHorizontal implements CalculateSlide {
        private CalculateSlideHorizontal() {
        }

        /* synthetic */ CalculateSlideHorizontal(AnonymousClass1 r1) {
            this();
        }

        @Override // androidx.transition.Slide.CalculateSlide
        public float getGoneY(ViewGroup r1, View r2) {
            return r2.getTranslationY();
        }
    }

    private static abstract class CalculateSlideVertical implements CalculateSlide {
        private CalculateSlideVertical() {
        }

        /* synthetic */ CalculateSlideVertical(AnonymousClass1 r1) {
            this();
        }

        @Override // androidx.transition.Slide.CalculateSlide
        public float getGoneX(ViewGroup r1, View r2) {
            return r2.getTranslationX();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface GravityFlag {
    }

    static {
        sDecelerate = new DecelerateInterpolator();
        sAccelerate = new AccelerateInterpolator();
        sCalculateLeft = new AnonymousClass1();
        sCalculateStart = new AnonymousClass2();
        sCalculateTop = new AnonymousClass3();
        sCalculateRight = new AnonymousClass4();
        sCalculateEnd = new AnonymousClass5();
        sCalculateBottom = new AnonymousClass6();
    }

    public Slide() {
        this.mSlideCalculator = sCalculateBottom;
        this.mSlideEdge = 80;
        setSlideEdge(80);
    }

    public Slide(int r2) {
        this.mSlideCalculator = sCalculateBottom;
        this.mSlideEdge = 80;
        setSlideEdge(r2);
    }

    public Slide(Context r4, AttributeSet r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r6, r7);
        this.mSlideCalculator = sCalculateBottom;
        this.mSlideEdge = 80;
        TypedArray r8 = r6.obtainStyledAttributes(r7, Styleable.SLIDE);
        int r9 = TypedArrayUtils.getNamedInt(r8, (XmlPullParser) ZeusTransformUtils.preCheckCast(r7, XmlPullParser.class, "com.obric.memorydata.plugin"), "slideEdge", 0, 80);
        r8.recycle();
        setSlideEdge(r9);
    }

    private void captureValues(TransitionValues r2) {
        int[] r0 = new int[2];
        r2.view.getLocationOnScreen(r0);
        r2.values.put(PROPNAME_SCREEN_POSITION, r0);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureEndValues(TransitionValues r1) {
        super.captureEndValues(r1);
        captureValues(r1);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(TransitionValues r1) {
        super.captureStartValues(r1);
        captureValues(r1);
    }

    public int getSlideEdge() {
        return this.mSlideEdge;
    }

    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup r11, View r12, TransitionValues r13, TransitionValues r14) {
        if (r14 != null) goto L6;
        return null;
    L6:
        int[] r15 = (int[]) ZeusTransformUtils.preCheckCast((int[]) ZeusTransformUtils.preCheckCast(r14.values.get(PROPNAME_SCREEN_POSITION), int[].class, "com.obric.memorydata.plugin"), int[].class, "com.obric.memorydata.plugin");
        float r6 = r12.getTranslationX();
        float r7 = r12.getTranslationY();
        float r4 = this.mSlideCalculator.getGoneX(r11, r12);
        float r5 = this.mSlideCalculator.getGoneY(r11, r12);
        return TranslationAnimationCreator.createAnimation(r12, r14, r15[0], r15[1], r4, r5, r6, r7, sDecelerate, this);
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup r11, View r12, TransitionValues r13, TransitionValues r14) {
        if (r13 != null) goto L6;
        return null;
    L6:
        int[] r15 = (int[]) ZeusTransformUtils.preCheckCast((int[]) ZeusTransformUtils.preCheckCast(r13.values.get(PROPNAME_SCREEN_POSITION), int[].class, "com.obric.memorydata.plugin"), int[].class, "com.obric.memorydata.plugin");
        float r4 = r12.getTranslationX();
        float r5 = r12.getTranslationY();
        float r6 = this.mSlideCalculator.getGoneX(r11, r12);
        float r7 = this.mSlideCalculator.getGoneY(r11, r12);
        return TranslationAnimationCreator.createAnimation(r12, r13, r15[0], r15[1], r4, r5, r6, r7, sAccelerate, this);
    }

    public void setSlideEdge(int r2) {
        if (r2 != 3) goto L5;
        CalculateSlide r0 = sCalculateLeft;
    L22:
        this.mSlideCalculator = r0;
        this.mSlideEdge = r2;
        SidePropagation r1 = new SidePropagation();
        r1.setSide(r2);
        setPropagation(r1);
        return;
    L5:
        if (r2 != 5) goto L7;
        r0 = sCalculateRight;
        goto L22
    L7:
        if (r2 != 48) goto L9;
        r0 = sCalculateTop;
        goto L22
    L9:
        if (r2 != 80) goto L11;
        r0 = sCalculateBottom;
        goto L22
    L11:
        if (r2 != 8388611) goto L13;
        r0 = sCalculateStart;
        goto L22
    L13:
        if (r2 != 8388613) goto L16;
        r0 = sCalculateEnd;
        goto L22
    L16:
        throw new IllegalArgumentException("Invalid slide direction");
    }
}
