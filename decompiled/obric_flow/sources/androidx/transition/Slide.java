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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

    public interface CalculateSlide {
        float getGoneX(ViewGroup r5, View r10);

        float getGoneY(ViewGroup r5, View r10);
    }

    public static abstract class CalculateSlideHorizontal implements CalculateSlide {
        private CalculateSlideHorizontal() {
        }

        @Override // androidx.transition.Slide.CalculateSlide
        public float getGoneY(ViewGroup r5, View r10) {
            return r10.getTranslationY();
        }

        public /* synthetic */ CalculateSlideHorizontal(AnonymousClass1 r5) {
            this();
        }
    }

    public static abstract class CalculateSlideVertical implements CalculateSlide {
        private CalculateSlideVertical() {
        }

        @Override // androidx.transition.Slide.CalculateSlide
        public float getGoneX(ViewGroup r5, View r10) {
            return r10.getTranslationX();
        }

        public /* synthetic */ CalculateSlideVertical(AnonymousClass1 r5) {
            this();
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

    private void captureValues(TransitionValues r5) {
        int[] r10 = new int[2];
        r5.view.getLocationOnScreen(r10);
        r5.values.put(PROPNAME_SCREEN_POSITION, r10);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues r5) {
        super.captureEndValues(r5);
        captureValues(r5);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues r5) {
        super.captureStartValues(r5);
        captureValues(r5);
    }

    public int getSlideEdge() {
        return this.mSlideEdge;
    }

    @Override // androidx.transition.Transition
    public boolean isSeekingSupported() {
        return true;
    }

    @Override // androidx.transition.Visibility
    @Nullable
    public Animator onAppear(@NonNull ViewGroup r11, @NonNull View r12, @Nullable TransitionValues r13, @Nullable TransitionValues r14) {
        if (r14 != null) goto L5;
        return null;
    L5:
        int[] r15 = (int[]) r14.values.get(PROPNAME_SCREEN_POSITION);
        float r10 = r12.getTranslationX();
        float r16 = r12.getTranslationY();
        float r5 = this.mSlideCalculator.getGoneX(r11, r12);
        float r17 = this.mSlideCalculator.getGoneY(r11, r12);
        return TranslationAnimationCreator.createAnimation(r12, r14, r15[0], r15[1], r5, r17, r10, r16, sDecelerate, this);
    }

    @Override // androidx.transition.Visibility
    @Nullable
    public Animator onDisappear(@NonNull ViewGroup r11, @NonNull View r12, @Nullable TransitionValues r13, @Nullable TransitionValues r14) {
        if (r13 != null) goto L5;
        return null;
    L5:
        int[] r15 = (int[]) r13.values.get(PROPNAME_SCREEN_POSITION);
        float r5 = r12.getTranslationX();
        float r10 = r12.getTranslationY();
        float r16 = this.mSlideCalculator.getGoneX(r11, r12);
        float r17 = this.mSlideCalculator.getGoneY(r11, r12);
        return TranslationAnimationCreator.createAnimation(r12, r13, r15[0], r15[1], r5, r10, r16, r17, sAccelerate, this);
    }

    public void setSlideEdge(int r5) {
        if (r5 != 3) goto L5;
        this.mSlideCalculator = sCalculateLeft;
    L22:
        this.mSlideEdge = r5;
        SidePropagation r10 = new SidePropagation();
        r10.setSide(r5);
        setPropagation(r10);
        return;
    L5:
        if (r5 != 5) goto L7;
        this.mSlideCalculator = sCalculateRight;
        goto L22
    L7:
        if (r5 != 48) goto L9;
        this.mSlideCalculator = sCalculateTop;
        goto L22
    L9:
        if (r5 != 80) goto L11;
        this.mSlideCalculator = sCalculateBottom;
        goto L22
    L11:
        if (r5 != 8388611) goto L13;
        this.mSlideCalculator = sCalculateStart;
        goto L22
    L13:
        if (r5 != 8388613) goto L16;
        this.mSlideCalculator = sCalculateEnd;
        goto L22
    L16:
        throw new IllegalArgumentException("Invalid slide direction");
    }

    public Slide(int r5) {
        this.mSlideCalculator = sCalculateBottom;
        this.mSlideEdge = 80;
        setSlideEdge(r5);
    }

    public Slide(@NonNull Context r5, @NonNull AttributeSet r10) {
        super(r5, r10);
        this.mSlideCalculator = sCalculateBottom;
        this.mSlideEdge = 80;
        TypedArray r11 = r5.obtainStyledAttributes(r10, Styleable.SLIDE);
        int r12 = TypedArrayUtils.getNamedInt(r11, (XmlPullParser) r10, "slideEdge", 0, 80);
        r11.recycle();
        setSlideEdge(r12);
    }
}
