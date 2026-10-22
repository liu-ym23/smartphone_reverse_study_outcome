package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
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
        float getGoneX(ViewGroup r10, View r11);

        float getGoneY(ViewGroup r10, View r11);
    }

    private static abstract class CalculateSlideHorizontal implements CalculateSlide {
        private CalculateSlideHorizontal() {
        }

        /* synthetic */ CalculateSlideHorizontal(AnonymousClass1 r10) {
            this();
        }

        @Override // androidx.transition.Slide.CalculateSlide
        public float getGoneY(ViewGroup r10, View r11) {
            return r11.getTranslationY();
        }
    }

    private static abstract class CalculateSlideVertical implements CalculateSlide {
        private CalculateSlideVertical() {
        }

        /* synthetic */ CalculateSlideVertical(AnonymousClass1 r10) {
            this();
        }

        @Override // androidx.transition.Slide.CalculateSlide
        public float getGoneX(ViewGroup r10, View r11) {
            return r11.getTranslationX();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
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

    public Slide(int r10) {
        this.mSlideCalculator = sCalculateBottom;
        this.mSlideEdge = 80;
        setSlideEdge(r10);
    }

    @SuppressLint({"RestrictedApi"})
    public Slide(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.mSlideCalculator = sCalculateBottom;
        this.mSlideEdge = 80;
        TypedArray r12 = r10.obtainStyledAttributes(r11, Styleable.SLIDE);
        int r13 = TypedArrayUtils.getNamedInt(r12, (XmlPullParser) r11, "slideEdge", 0, 80);
        r12.recycle();
        setSlideEdge(r13);
    }

    private void captureValues(TransitionValues r10) {
        int[] r11 = new int[2];
        r10.view.getLocationOnScreen(r11);
        r10.values.put(PROPNAME_SCREEN_POSITION, r11);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues r10) {
        super.captureEndValues(r10);
        captureValues(r10);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues r10) {
        super.captureStartValues(r10);
        captureValues(r10);
    }

    public int getSlideEdge() {
        return this.mSlideEdge;
    }

    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup r11, View r12, TransitionValues r13, TransitionValues r14) {
        if (r14 != null) goto L5;
        return null;
    L5:
        int[] r15 = (int[]) r14.values.get(PROPNAME_SCREEN_POSITION);
        float r10 = r12.getTranslationX();
        float r16 = r12.getTranslationY();
        float r17 = this.mSlideCalculator.getGoneX(r11, r12);
        float r18 = this.mSlideCalculator.getGoneY(r11, r12);
        return TranslationAnimationCreator.createAnimation(r12, r14, r15[0], r15[1], r17, r18, r10, r16, sDecelerate, this);
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup r11, View r12, TransitionValues r13, TransitionValues r14) {
        if (r13 != null) goto L5;
        return null;
    L5:
        int[] r15 = (int[]) r13.values.get(PROPNAME_SCREEN_POSITION);
        float r10 = r12.getTranslationX();
        float r16 = r12.getTranslationY();
        float r17 = this.mSlideCalculator.getGoneX(r11, r12);
        float r18 = this.mSlideCalculator.getGoneY(r11, r12);
        return TranslationAnimationCreator.createAnimation(r12, r13, r15[0], r15[1], r10, r16, r17, r18, sAccelerate, this);
    }

    public void setSlideEdge(int r10) {
        if (r10 != 3) goto L5;
        CalculateSlide r11 = sCalculateLeft;
    L22:
        this.mSlideCalculator = r11;
        this.mSlideEdge = r10;
        SidePropagation r12 = new SidePropagation();
        r12.setSide(r10);
        setPropagation(r12);
        return;
    L5:
        if (r10 != 5) goto L7;
        r11 = sCalculateRight;
        goto L22
    L7:
        if (r10 != 48) goto L9;
        r11 = sCalculateTop;
        goto L22
    L9:
        if (r10 != 80) goto L11;
        r11 = sCalculateBottom;
        goto L22
    L11:
        if (r10 != 8388611) goto L13;
        r11 = sCalculateStart;
        goto L22
    L13:
        if (r10 != 8388613) goto L16;
        r11 = sCalculateEnd;
        goto L22
    L16:
        throw new IllegalArgumentException("Invalid slide direction");
    }
}
