package androidx.appcompat.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.annotation.DoNotInline;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.text.AllCapsTransformationMethod;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.emoji2.text.EmojiCompat;
import com.google.android.material.color.utilities.Contrast;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class SwitchCompat extends CompoundButton implements EmojiCompatConfigurationView {
    private static final String ACCESSIBILITY_EVENT_CLASS_NAME = "android.widget.Switch";
    private static final int[] CHECKED_STATE_SET = null;
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    private static final int THUMB_ANIMATION_DURATION = 250;
    private static final Property<SwitchCompat, Float> THUMB_POS = null;
    private static final int TOUCH_MODE_DOWN = 1;
    private static final int TOUCH_MODE_DRAGGING = 2;
    private static final int TOUCH_MODE_IDLE = 0;

    @NonNull
    private AppCompatEmojiTextHelper mAppCompatEmojiTextHelper;

    @Nullable
    private EmojiCompatInitCallback mEmojiCompatInitCallback;
    private boolean mEnforceSwitchWidth;
    private boolean mHasThumbTint;
    private boolean mHasThumbTintMode;
    private boolean mHasTrackTint;
    private boolean mHasTrackTintMode;
    private int mMinFlingVelocity;
    private Layout mOffLayout;
    private Layout mOnLayout;
    ObjectAnimator mPositionAnimator;
    private boolean mShowText;
    private boolean mSplitTrack;
    private int mSwitchBottom;
    private int mSwitchHeight;
    private int mSwitchLeft;
    private int mSwitchMinWidth;
    private int mSwitchPadding;
    private int mSwitchRight;
    private int mSwitchTop;

    @Nullable
    private TransformationMethod mSwitchTransformationMethod;
    private int mSwitchWidth;
    private final Rect mTempRect;
    private ColorStateList mTextColors;
    private final AppCompatTextHelper mTextHelper;
    private CharSequence mTextOff;
    private CharSequence mTextOffTransformed;
    private CharSequence mTextOn;
    private CharSequence mTextOnTransformed;
    private final TextPaint mTextPaint;
    private Drawable mThumbDrawable;
    float mThumbPosition;
    private int mThumbTextPadding;
    private ColorStateList mThumbTintList;
    private PorterDuff.Mode mThumbTintMode;
    private int mThumbWidth;
    private int mTouchMode;
    private int mTouchSlop;
    private float mTouchX;
    private float mTouchY;
    private Drawable mTrackDrawable;
    private ColorStateList mTrackTintList;
    private PorterDuff.Mode mTrackTintMode;
    private VelocityTracker mVelocityTracker;

    @RequiresApi(18)
    public static class Api18Impl {
        private Api18Impl() {
        }

        @DoNotInline
        public static void setAutoCancel(ObjectAnimator r5, boolean r10) {
            r5.setAutoCancel(r10);
        }
    }

    public static class EmojiCompatInitCallback extends EmojiCompat.InitCallback {
        private final Reference<SwitchCompat> mOuterWeakRef;

        public EmojiCompatInitCallback(SwitchCompat r5) {
            this.mOuterWeakRef = new WeakReference(r5);
        }

        @Override // androidx.emoji2.text.EmojiCompat.InitCallback
        public void onFailed(@Nullable Throwable r5) {
            SwitchCompat r10 = this.mOuterWeakRef.get();
            if (r10 == null) goto L6;
            r10.onEmojiCompatInitializedForSwitchText();
            return;
        }

        @Override // androidx.emoji2.text.EmojiCompat.InitCallback
        public void onInitialized() {
            SwitchCompat r5 = this.mOuterWeakRef.get();
            if (r5 == null) goto L6;
            r5.onEmojiCompatInitializedForSwitchText();
            return;
        }
    }

    static {
        final Class<Float> r5 = Float.class;
        final String r10 = "thumbPos";
        THUMB_POS = new AnonymousClass1(r5, r10);
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
    }

    public SwitchCompat(@NonNull Context r5) {
        this(r5, null);
    }

    private void animateThumbToCheckedState(boolean r5) {
        if (r5 == false) goto L5;
        float r10 = 1.0f;
    L6:
        ObjectAnimator r11 = ObjectAnimator.ofFloat(this, THUMB_POS, new float[]{r10});
        this.mPositionAnimator = r11;
        r11.setDuration(250);
        Api18Impl.setAutoCancel(this.mPositionAnimator, true);
        this.mPositionAnimator.start();
        return;
    L5:
        r10 = 0.0f;
        goto L6
    }

    private void applyThumbTint() {
        Drawable r5 = this.mThumbDrawable;
        if (r5 != null) goto L5;
        return;
    L5:
        if (this.mHasThumbTint == false) goto L7;
    L8:
        Drawable r10 = DrawableCompat.wrap(r5).mutate();
        this.mThumbDrawable = r10;
        if (this.mHasThumbTint == false) goto L12;
        DrawableCompat.setTintList(r10, this.mThumbTintList);
    L12:
        if (this.mHasThumbTintMode == false) goto L15;
        DrawableCompat.setTintMode(this.mThumbDrawable, this.mThumbTintMode);
    L15:
        if (this.mThumbDrawable.isStateful() == false) goto L20;
        this.mThumbDrawable.setState(getDrawableState());
        return;
    L20:
        return;
    L7:
        if (this.mHasThumbTintMode == true) goto L8;
    }

    private void applyTrackTint() {
        Drawable r5 = this.mTrackDrawable;
        if (r5 != null) goto L5;
        return;
    L5:
        if (this.mHasTrackTint == false) goto L7;
    L8:
        Drawable r10 = DrawableCompat.wrap(r5).mutate();
        this.mTrackDrawable = r10;
        if (this.mHasTrackTint == false) goto L12;
        DrawableCompat.setTintList(r10, this.mTrackTintList);
    L12:
        if (this.mHasTrackTintMode == false) goto L15;
        DrawableCompat.setTintMode(this.mTrackDrawable, this.mTrackTintMode);
    L15:
        if (this.mTrackDrawable.isStateful() == false) goto L20;
        this.mTrackDrawable.setState(getDrawableState());
        return;
    L20:
        return;
    L7:
        if (this.mHasTrackTintMode == true) goto L8;
    }

    private void cancelPositionAnimator() {
        ObjectAnimator r5 = this.mPositionAnimator;
        if (r5 == null) goto L6;
        r5.cancel();
        return;
    }

    private void cancelSuperTouch(MotionEvent r5) {
        MotionEvent r10 = MotionEvent.obtain(r5);
        r10.setAction(3);
        super.onTouchEvent(r10);
        r10.recycle();
    }

    private static float constrain(float r5, float r10, float r11) {
        if (r5 >= r10) goto L6;
        return r10;
    L6:
        if (r5 > r11) goto L8;
        return r5;
    L8:
        return r11;
    }

    @Nullable
    private CharSequence doTransformForOnOffText(@Nullable CharSequence r5) {
        TransformationMethod r10 = getEmojiTextViewHelper().wrapTransformationMethod(this.mSwitchTransformationMethod);
        if (r10 != null) goto L5;
        return r5;
    L5:
        return r10.getTransformation(r5, this);
    }

    @NonNull
    private AppCompatEmojiTextHelper getEmojiTextViewHelper() {
        if (this.mAppCompatEmojiTextHelper != null) goto L6;
        this.mAppCompatEmojiTextHelper = new AppCompatEmojiTextHelper(this);
    L6:
        return this.mAppCompatEmojiTextHelper;
    }

    private boolean getTargetCheckedState() {
        if (this.mThumbPosition <= 0.5f) goto L5;
        return true;
    L5:
        return false;
    }

    private int getThumbOffset() {
        if (ViewUtils.isLayoutRtl(this) == false) goto L5;
        float r5 = 1.0f - this.mThumbPosition;
    L7:
        return (int) ((r5 * getThumbScrollRange()) + 0.5f);
    L5:
        r5 = this.mThumbPosition;
        goto L7
    }

    private int getThumbScrollRange() {
        Drawable r5 = this.mTrackDrawable;
        if (r5 == null) goto L10;
        Rect r10 = this.mTempRect;
        r5.getPadding(r10);
        Drawable r11 = this.mThumbDrawable;
        if (r11 == null) goto L7;
        Rect r12 = DrawableUtils.getOpticalBounds(r11);
    L9:
        return ((((this.mSwitchWidth - this.mThumbWidth) - r10.left) - r10.right) - r12.left) - r12.right;
    L7:
        r12 = DrawableUtils.INSETS_NONE;
        goto L9
    L10:
        return 0;
    }

    private boolean hitThumb(float r10, float r11) {
        if (this.mThumbDrawable != null) goto L5;
        return false;
    L5:
        int r5 = getThumbOffset();
        this.mThumbDrawable.getPadding(this.mTempRect);
        int r12 = this.mSwitchTop;
        int r13 = this.mTouchSlop;
        int r14 = r12 - r13;
        int r15 = (this.mSwitchLeft + r5) - r13;
        int r16 = this.mThumbWidth + r15;
        Rect r17 = this.mTempRect;
        int r18 = ((r16 + r17.left) + r17.right) + r13;
        int r19 = this.mSwitchBottom + r13;
        if (r10 > r15) goto L8;
        return false;
    L8:
        if (r10 < r18) goto L10;
        return false;
    L10:
        if (r11 > r14) goto L12;
        return false;
    L12:
        if (r11 >= r19) goto L18;
        return true;
    L18:
        return false;
    }

    private Layout makeLayout(CharSequence r10) {
        TextPaint r5 = this.mTextPaint;
        if (r10 == null) goto L6;
        int r11 = (int) Math.ceil(Layout.getDesiredWidth(r10, r5));
    L8:
        return new StaticLayout(r10, r5, r11, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    L6:
        r11 = 0;
        goto L8
    }

    private void setOffStateDescriptionOnRAndAbove() {
        CharSequence r5 = this.mTextOff;
        if (r5 != null) goto L5;
        r5 = getResources().getString(androidx.appcompat.R.string.abc_capital_off);
    L5:
        ViewCompat.setStateDescription(this, r5);
    }

    private void setOnStateDescriptionOnRAndAbove() {
        CharSequence r5 = this.mTextOn;
        if (r5 != null) goto L5;
        r5 = getResources().getString(androidx.appcompat.R.string.abc_capital_on);
    L5:
        ViewCompat.setStateDescription(this, r5);
    }

    private void setSwitchTypefaceByIndex(int r5, int r10) {
        if (r5 != 1) goto L5;
        Typeface r11 = Typeface.SANS_SERIF;
    L12:
        setSwitchTypeface(r11, r10);
        return;
    L5:
        if (r5 != 2) goto L7;
        r11 = Typeface.SERIF;
        goto L12
    L7:
        if (r5 == 3) goto L9;
        r11 = null;
        goto L12
    L9:
        r11 = Typeface.MONOSPACE;
        goto L12
    }

    private void setTextOffInternal(CharSequence r5) {
        this.mTextOff = r5;
        this.mTextOffTransformed = doTransformForOnOffText(r5);
        this.mOffLayout = null;
        if (this.mShowText == false) goto L6;
        setupEmojiCompatLoadCallback();
        return;
    }

    private void setTextOnInternal(CharSequence r5) {
        this.mTextOn = r5;
        this.mTextOnTransformed = doTransformForOnOffText(r5);
        this.mOnLayout = null;
        if (this.mShowText == false) goto L6;
        setupEmojiCompatLoadCallback();
        return;
    }

    private void setupEmojiCompatLoadCallback() {
        if (this.mEmojiCompatInitCallback == null) goto L5;
        return;
    L5:
        if (this.mAppCompatEmojiTextHelper.isEnabled() == true) goto L8;
        return;
    L8:
        if (EmojiCompat.isConfigured() == false) goto L15;
        EmojiCompat r5 = EmojiCompat.get();
        int r10 = r5.getLoadState();
        if (r10 == 3) goto L12;
        if (r10 == 0) goto L12;
        return;
    L12:
        EmojiCompatInitCallback r11 = new EmojiCompatInitCallback(this);
        this.mEmojiCompatInitCallback = r11;
        r5.registerInitCallback(r11);
        return;
    }

    private void stopDrag(MotionEvent r10) {
        this.mTouchMode = 0;
        boolean r5 = true;
        if (r10.getAction() == 1) goto L5;
    L7:
        boolean r11 = false;
    L8:
        boolean r12 = isChecked();
        if (r11 == false) goto L22;
        this.mVelocityTracker.computeCurrentVelocity(1000);
        float r13 = this.mVelocityTracker.getXVelocity();
        if (Math.abs(r13) > this.mMinFlingVelocity) goto L13;
        r5 = getTargetCheckedState();
    L23:
        if (r5 == r12) goto L25;
        playSoundEffect(0);
    L25:
        setChecked(r5);
        cancelSuperTouch(r10);
        return;
    L13:
        if (ViewUtils.isLayoutRtl(this) == false) goto L19;
        if (r13 < 0.0f) goto L23;
    L17:
        r5 = false;
        goto L23
    L19:
        if (r13 <= 0.0f) goto L17;
    L22:
        r5 = r12;
        goto L23
    L5:
        if (isEnabled() == false) goto L7;
        r11 = true;
        goto L8
    }

    @Override // android.view.View
    public void draw(Canvas r11) {
        Rect r5 = this.mTempRect;
        int r10 = this.mSwitchLeft;
        int r12 = this.mSwitchTop;
        int r13 = this.mSwitchRight;
        int r14 = this.mSwitchBottom;
        int r15 = getThumbOffset() + r10;
        Drawable r16 = this.mThumbDrawable;
        if (r16 == null) goto L5;
        Rect r17 = DrawableUtils.getOpticalBounds(r16);
    L6:
        Drawable r18 = this.mTrackDrawable;
        if (r18 == null) goto L26;
        r18.getPadding(r5);
        int r19 = r5.left;
        r15 = r15 + r19;
        if (r17 == null) goto L24;
        int r20 = r17.left;
        if (r20 <= r19) goto L13;
        r10 = r10 + (r20 - r19);
    L13:
        int r21 = r17.top;
        int r22 = r5.top;
        if (r21 <= r22) goto L16;
        int r23 = (r21 - r22) + r12;
    L17:
        int r24 = r17.right;
        int r25 = r5.right;
        if (r24 <= r25) goto L20;
        r13 = r13 - (r24 - r25);
    L20:
        int r26 = r17.bottom;
        int r27 = r5.bottom;
        if (r26 <= r27) goto L23;
        int r28 = r14 - (r26 - r27);
    L25:
        this.mTrackDrawable.setBounds(r10, r23, r13, r28);
    L23:
        r28 = r14;
        goto L25
    L16:
        r23 = r12;
        goto L17
    L24:
        r23 = r12;
    L26:
        Drawable r29 = this.mThumbDrawable;
        if (r29 == null) goto L31;
        r29.getPadding(r5);
        int r30 = r15 - r5.left;
        int r31 = (r15 + this.mThumbWidth) + r5.right;
        this.mThumbDrawable.setBounds(r30, r12, r31, r14);
        Drawable r32 = getBackground();
        if (r32 == null) goto L31;
        DrawableCompat.setHotspotBounds(r32, r30, r12, r31, r14);
    L31:
        super.draw(r11);
        return;
    L5:
        r17 = DrawableUtils.INSETS_NONE;
        goto L6
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float r5, float r10) {
        super.drawableHotspotChanged(r5, r10);
        Drawable r11 = this.mThumbDrawable;
        if (r11 == null) goto L5;
        DrawableCompat.setHotspot(r11, r5, r10);
    L5:
        Drawable r12 = this.mTrackDrawable;
        if (r12 == null) goto L9;
        DrawableCompat.setHotspot(r12, r5, r10);
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r5 = getDrawableState();
        Drawable r10 = this.mThumbDrawable;
        if (r10 != null) goto L5;
    L7:
        boolean r11 = false;
    L8:
        Drawable r12 = this.mTrackDrawable;
        if (r12 != null) goto L11;
    L13:
        if (r11 == false) goto L16;
        invalidate();
        return;
    L16:
        return;
    L11:
        if (r12.isStateful() == false) goto L13;
        r11 = r11 | r12.setState(r5);
        goto L13
    L5:
        if (r10.isStateful() == false) goto L7;
        r11 = r10.setState(r5);
        goto L8
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (ViewUtils.isLayoutRtl(this) == false) goto L5;
        int r5 = super.getCompoundPaddingLeft() + this.mSwitchWidth;
        if (TextUtils.isEmpty(getText()) == false) goto L9;
        return r5;
    L9:
        return r5 + this.mSwitchPadding;
    L5:
        return super.getCompoundPaddingLeft();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (ViewUtils.isLayoutRtl(this) == true) goto L5;
        int r5 = super.getCompoundPaddingRight() + this.mSwitchWidth;
        if (TextUtils.isEmpty(getText()) == false) goto L9;
        return r5;
    L9:
        return r5 + this.mSwitchPadding;
    L5:
        return super.getCompoundPaddingRight();
    }

    @Override // android.widget.TextView
    @Nullable
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.unwrapCustomSelectionActionModeCallback(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.mShowText;
    }

    public boolean getSplitTrack() {
        return this.mSplitTrack;
    }

    public int getSwitchMinWidth() {
        return this.mSwitchMinWidth;
    }

    public int getSwitchPadding() {
        return this.mSwitchPadding;
    }

    public CharSequence getTextOff() {
        return this.mTextOff;
    }

    public CharSequence getTextOn() {
        return this.mTextOn;
    }

    public Drawable getThumbDrawable() {
        return this.mThumbDrawable;
    }

    @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
    public final float getThumbPosition() {
        return this.mThumbPosition;
    }

    public int getThumbTextPadding() {
        return this.mThumbTextPadding;
    }

    @Nullable
    public ColorStateList getThumbTintList() {
        return this.mThumbTintList;
    }

    @Nullable
    public PorterDuff.Mode getThumbTintMode() {
        return this.mThumbTintMode;
    }

    public Drawable getTrackDrawable() {
        return this.mTrackDrawable;
    }

    @Nullable
    public ColorStateList getTrackTintList() {
        return this.mTrackTintList;
    }

    @Nullable
    public PorterDuff.Mode getTrackTintMode() {
        return this.mTrackTintMode;
    }

    @Override // androidx.appcompat.widget.EmojiCompatConfigurationView
    public boolean isEmojiCompatEnabled() {
        return getEmojiTextViewHelper().isEnabled();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable r5 = this.mThumbDrawable;
        if (r5 == null) goto L5;
        r5.jumpToCurrentState();
    L5:
        Drawable r10 = this.mTrackDrawable;
        if (r10 == null) goto L8;
        r10.jumpToCurrentState();
    L8:
        ObjectAnimator r11 = this.mPositionAnimator;
        if (r11 != null) goto L11;
        return;
    L11:
        if (r11.isStarted() == false) goto L15;
        this.mPositionAnimator.end();
        this.mPositionAnimator = null;
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int r5) {
        int[] r10 = super.onCreateDrawableState(r5 + 1);
        if (isChecked() == false) goto L5;
        View.mergeDrawableStates(r10, CHECKED_STATE_SET);
    L5:
        return r10;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas r10) {
        super.onDraw(r10);
        Rect r5 = this.mTempRect;
        Drawable r11 = this.mTrackDrawable;
        if (r11 == null) goto L5;
        r11.getPadding(r5);
    L6:
        int r12 = this.mSwitchTop;
        int r13 = this.mSwitchBottom;
        int r14 = r12 + r5.top;
        int r15 = r13 - r5.bottom;
        Drawable r16 = this.mThumbDrawable;
        if (r11 != null) goto L9;
    L13:
        int r17 = r10.save();
        if (r16 == null) goto L17;
        r16.draw(r10);
    L17:
        if (getTargetCheckedState() == false) goto L19;
        Layout r18 = this.mOnLayout;
    L20:
        if (r18 == null) goto L29;
        int[] r19 = getDrawableState();
        ColorStateList r20 = this.mTextColors;
        if (r20 == null) goto L24;
        this.mTextPaint.setColor(r20.getColorForState(r19, 0));
    L24:
        this.mTextPaint.drawableState = r19;
        if (r16 == null) goto L27;
        Rect r21 = r16.getBounds();
        int r22 = r21.left + r21.right;
    L28:
        r10.translate((r22 / 2) - (r18.getWidth() / 2), ((r14 + r15) / 2) - (r18.getHeight() / 2));
        r18.draw(r10);
        goto L29
    L27:
        r22 = getWidth();
    L29:
        r10.restoreToCount(r17);
        return;
    L19:
        r18 = this.mOffLayout;
        goto L20
    L9:
        if (this.mSplitTrack == false) goto L12;
        if (r16 == null) goto L12;
        Rect r23 = DrawableUtils.getOpticalBounds(r16);
        r16.copyBounds(r5);
        r5.left += r23.left;
        r5.right -= r23.right;
        int r24 = r10.save();
        r10.clipRect(r5, Region.Op.DIFFERENCE);
        r11.draw(r10);
        r10.restoreToCount(r24);
    L12:
        r11.draw(r10);
        goto L13
    L5:
        r5.setEmpty();
        goto L6
    }

    public void onEmojiCompatInitializedForSwitchText() {
        setTextOnInternal(this.mTextOn);
        setTextOffInternal(this.mTextOff);
        requestLayout();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent r5) {
        super.onInitializeAccessibilityEvent(r5);
        r5.setClassName(ACCESSIBILITY_EVENT_CLASS_NAME);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r5) {
        super.onInitializeAccessibilityNodeInfo(r5);
        r5.setClassName(ACCESSIBILITY_EVENT_CLASS_NAME);
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
        int r14 = 0;
        if (this.mThumbDrawable == null) goto L9;
        Rect r15 = this.mTempRect;
        Drawable r16 = this.mTrackDrawable;
        if (r16 == null) goto L7;
        r16.getPadding(r15);
    L8:
        Rect r17 = DrawableUtils.getOpticalBounds(this.mThumbDrawable);
        int r18 = Math.max(0, r17.left - r15.left);
        r14 = Math.max(0, r17.right - r15.right);
    L11:
        if (ViewUtils.isLayoutRtl(this) == false) goto L13;
        int r19 = getPaddingLeft() + r18;
        int r20 = ((this.mSwitchWidth + r19) - r18) - r14;
    L14:
        int r21 = getGravity() & 112;
        if (r21 != 16) goto L17;
        int r22 = ((getHeight() + getPaddingTop()) - getPaddingBottom()) / 2;
        int r23 = this.mSwitchHeight;
        int r24 = r22 - (r23 / 2);
        int r25 = r23 + r24;
        int r26 = r24;
    L21:
        this.mSwitchLeft = r19;
        this.mSwitchTop = r26;
        this.mSwitchBottom = r25;
        this.mSwitchRight = r20;
        return;
    L17:
        if (r21 == 80) goto L19;
        r26 = getPaddingTop();
        r25 = this.mSwitchHeight + r26;
        goto L21
    L19:
        r25 = getHeight() - getPaddingBottom();
        r26 = r25 - this.mSwitchHeight;
        goto L21
    L13:
        r20 = (getWidth() - getPaddingRight()) - r14;
        r19 = ((r20 - this.mSwitchWidth) + r18) + r14;
        goto L14
    L7:
        r15.setEmpty();
        goto L8
    L9:
        r18 = 0;
        goto L11
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r10, int r11) {
        if (this.mShowText == true) goto L5;
    L10:
        Rect r5 = this.mTempRect;
        Drawable r12 = this.mThumbDrawable;
        int r13 = 0;
        if (r12 == null) goto L13;
        r12.getPadding(r5);
        int r14 = (this.mThumbDrawable.getIntrinsicWidth() - r5.left) - r5.right;
        int r15 = this.mThumbDrawable.getIntrinsicHeight();
    L15:
        if (this.mShowText == false) goto L17;
        int r16 = (this.mThumbTextPadding * 2) + Math.max(this.mOnLayout.getWidth(), this.mOffLayout.getWidth());
    L18:
        this.mThumbWidth = Math.max(r16, r14);
        Drawable r17 = this.mTrackDrawable;
        if (r17 == null) goto L21;
        r17.getPadding(r5);
        r13 = this.mTrackDrawable.getIntrinsicHeight();
    L22:
        int r18 = r5.left;
        int r19 = r5.right;
        Drawable r20 = this.mThumbDrawable;
        if (r20 == null) goto L26;
        Rect r21 = DrawableUtils.getOpticalBounds(r20);
        r18 = Math.max(r18, r21.left);
        r19 = Math.max(r19, r21.right);
    L26:
        if (this.mEnforceSwitchWidth == false) goto L28;
        int r22 = Math.max(this.mSwitchMinWidth, ((this.mThumbWidth * 2) + r18) + r19);
    L29:
        int r23 = Math.max(r13, r15);
        this.mSwitchWidth = r22;
        this.mSwitchHeight = r23;
        super.onMeasure(r10, r11);
        if (getMeasuredHeight() >= r23) goto L33;
        setMeasuredDimension(getMeasuredWidthAndState(), r23);
        return;
    L33:
        return;
    L28:
        r22 = this.mSwitchMinWidth;
        goto L29
    L21:
        r5.setEmpty();
        goto L22
    L17:
        r16 = 0;
        goto L18
    L13:
        r14 = 0;
        r15 = 0;
        goto L15
    L5:
        if (this.mOnLayout != null) goto L8;
        this.mOnLayout = makeLayout(this.mTextOnTransformed);
    L8:
        if (this.mOffLayout != null) goto L10;
        this.mOffLayout = makeLayout(this.mTextOffTransformed);
        goto L10
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent r5) {
        super.onPopulateAccessibilityEvent(r5);
        if (isChecked() == false) goto L5;
        CharSequence r10 = this.mTextOn;
    L6:
        if (r10 == null) goto L9;
        r5.getText().add(r10);
        return;
    L9:
        return;
    L5:
        r10 = this.mTextOff;
        goto L6
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        this.mVelocityTracker.addMovement(r10);
        int r5 = r10.getActionMasked();
        if (r5 != 0) goto L5;
        float r11 = r10.getX();
        float r12 = r10.getY();
        if (isEnabled() == true) goto L42;
    L45:
        return super.onTouchEvent(r10);
    L42:
        if (hitThumb(r11, r12) == false) goto L45;
        this.mTouchMode = 1;
        this.mTouchX = r11;
        this.mTouchY = r12;
        goto L45
    L5:
        if (r5 == 1) goto L35;
        if (r5 != 2) goto L8;
        int r13 = this.mTouchMode;
        if (r13 == 1) goto L28;
        if (r13 != 2) goto L45;
        float r14 = r10.getX();
        int r15 = getThumbScrollRange();
        float r16 = r14 - this.mTouchX;
        if (r15 == 0) goto L18;
        float r17 = r16 / r15;
    L22:
        if (ViewUtils.isLayoutRtl(this) == false) goto L24;
        r17 = -r17;
    L24:
        float r18 = constrain(this.mThumbPosition + r17, 0.0f, 1.0f);
        if (r18 == this.mThumbPosition) goto L27;
        this.mTouchX = r14;
        setThumbPosition(r18);
    L27:
        return true;
    L18:
        if (r16 <= 0.0f) goto L20;
        r17 = 1.0f;
        goto L22
    L20:
        r17 = -1.0f;
        goto L22
    L28:
        float r19 = r10.getX();
        float r20 = r10.getY();
        if (Math.abs(r19 - this.mTouchX) <= this.mTouchSlop) goto L31;
    L32:
        this.mTouchMode = 2;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.mTouchX = r19;
        this.mTouchY = r20;
        return true;
    L31:
        if (Math.abs(r20 - this.mTouchY) <= this.mTouchSlop) goto L45;
    L8:
        if (r5 != 3) goto L45;
    L35:
        if (this.mTouchMode != 2) goto L38;
        stopDrag(r10);
        super.onTouchEvent(r10);
        return true;
    L38:
        this.mTouchMode = 0;
        this.mVelocityTracker.clear();
        goto L45
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean r5) {
        super.setAllCaps(r5);
        getEmojiTextViewHelper().setAllCaps(r5);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r5) {
        super.setChecked(r5);
        boolean r10 = isChecked();
        if (r10 == false) goto L5;
        setOnStateDescriptionOnRAndAbove();
    L7:
        if (getWindowToken() != null) goto L9;
    L11:
        cancelPositionAnimator();
        if (r10 == false) goto L14;
        float r11 = 1.0f;
    L15:
        setThumbPosition(r11);
        return;
    L14:
        r11 = 0.0f;
        goto L15
    L9:
        if (ViewCompat.isLaidOut(this) == false) goto L11;
        animateThumbToCheckedState(r10);
        return;
    L5:
        setOffStateDescriptionOnRAndAbove();
        goto L7
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(@Nullable ActionMode.Callback r5) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, r5));
    }

    @Override // androidx.appcompat.widget.EmojiCompatConfigurationView
    public void setEmojiCompatEnabled(boolean r5) {
        getEmojiTextViewHelper().setEnabled(r5);
        setTextOnInternal(this.mTextOn);
        setTextOffInternal(this.mTextOff);
        requestLayout();
    }

    public final void setEnforceSwitchWidth(boolean r5) {
        this.mEnforceSwitchWidth = r5;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setFilters(@NonNull InputFilter[] r5) {
        super.setFilters(getEmojiTextViewHelper().getFilters(r5));
    }

    public void setShowText(boolean r5) {
        if (this.mShowText == r5) goto L8;
        this.mShowText = r5;
        requestLayout();
        if (r5 == false) goto L9;
        setupEmojiCompatLoadCallback();
        return;
    L9:
        return;
    }

    public void setSplitTrack(boolean r5) {
        this.mSplitTrack = r5;
        invalidate();
    }

    public void setSwitchMinWidth(int r5) {
        this.mSwitchMinWidth = r5;
        requestLayout();
    }

    public void setSwitchPadding(int r5) {
        this.mSwitchPadding = r5;
        requestLayout();
    }

    public void setSwitchTextAppearance(Context r5, int r10) {
        TintTypedArray r11 = TintTypedArray.obtainStyledAttributes(r5, r10, androidx.appcompat.R.styleable.TextAppearance);
        ColorStateList r12 = r11.getColorStateList(androidx.appcompat.R.styleable.TextAppearance_android_textColor);
        if (r12 == null) goto L5;
        this.mTextColors = r12;
    L6:
        int r13 = r11.getDimensionPixelSize(androidx.appcompat.R.styleable.TextAppearance_android_textSize, 0);
        if (r13 == 0) goto L11;
        float r14 = r13;
        if (r14 == this.mTextPaint.getTextSize()) goto L11;
        this.mTextPaint.setTextSize(r14);
        requestLayout();
    L11:
        setSwitchTypefaceByIndex(r11.getInt(androidx.appcompat.R.styleable.TextAppearance_android_typeface, -1), r11.getInt(androidx.appcompat.R.styleable.TextAppearance_android_textStyle, -1));
        if (r11.getBoolean(androidx.appcompat.R.styleable.TextAppearance_textAllCaps, false) == false) goto L14;
        this.mSwitchTransformationMethod = new AllCapsTransformationMethod(getContext());
    L15:
        setTextOnInternal(this.mTextOn);
        setTextOffInternal(this.mTextOff);
        r11.recycle();
        return;
    L14:
        this.mSwitchTransformationMethod = null;
        goto L15
    L5:
        this.mTextColors = getTextColors();
        goto L6
    }

    public void setSwitchTypeface(Typeface r5, int r10) {
        float r11 = 0.0f;
        boolean r12 = false;
        if (r10 <= 0) goto L18;
        if (r5 != null) goto L6;
        Typeface r13 = Typeface.defaultFromStyle(r10);
    L7:
        setSwitchTypeface(r13);
        if (r13 == null) goto L10;
        int r14 = r13.getStyle();
    L11:
        int r15 = (~r14) & r10;
        TextPaint r16 = this.mTextPaint;
        if ((r15 & 1) == 0) goto L14;
        r12 = true;
    L14:
        r16.setFakeBoldText(r12);
        TextPaint r17 = this.mTextPaint;
        if ((r15 & 2) == 0) goto L17;
        r11 = -0.25f;
    L17:
        r17.setTextSkewX(r11);
        return;
    L10:
        r14 = 0;
        goto L11
    L6:
        r13 = Typeface.create(r5, r10);
        goto L7
    L18:
        this.mTextPaint.setFakeBoldText(false);
        this.mTextPaint.setTextSkewX(0.0f);
        setSwitchTypeface(r5);
    }

    public void setTextOff(CharSequence r5) {
        setTextOffInternal(r5);
        requestLayout();
        if (isChecked() == true) goto L6;
        setOffStateDescriptionOnRAndAbove();
        return;
    }

    public void setTextOn(CharSequence r5) {
        setTextOnInternal(r5);
        requestLayout();
        if (isChecked() == false) goto L6;
        setOnStateDescriptionOnRAndAbove();
        return;
    }

    public void setThumbDrawable(Drawable r5) {
        Drawable r10 = this.mThumbDrawable;
        if (r10 == null) goto L5;
        r10.setCallback(null);
    L5:
        this.mThumbDrawable = r5;
        if (r5 == null) goto L8;
        r5.setCallback(this);
    L8:
        requestLayout();
    }

    public void setThumbPosition(float r5) {
        this.mThumbPosition = r5;
        invalidate();
    }

    public void setThumbResource(int r5) {
        setThumbDrawable(AppCompatResources.getDrawable(getContext(), r5));
    }

    public void setThumbTextPadding(int r5) {
        this.mThumbTextPadding = r5;
        requestLayout();
    }

    public void setThumbTintList(@Nullable ColorStateList r5) {
        this.mThumbTintList = r5;
        this.mHasThumbTint = true;
        applyThumbTint();
    }

    public void setThumbTintMode(@Nullable PorterDuff.Mode r5) {
        this.mThumbTintMode = r5;
        this.mHasThumbTintMode = true;
        applyThumbTint();
    }

    public void setTrackDrawable(Drawable r5) {
        Drawable r10 = this.mTrackDrawable;
        if (r10 == null) goto L5;
        r10.setCallback(null);
    L5:
        this.mTrackDrawable = r5;
        if (r5 == null) goto L8;
        r5.setCallback(this);
    L8:
        requestLayout();
    }

    public void setTrackResource(int r5) {
        setTrackDrawable(AppCompatResources.getDrawable(getContext(), r5));
    }

    public void setTrackTintList(@Nullable ColorStateList r5) {
        this.mTrackTintList = r5;
        this.mHasTrackTint = true;
        applyTrackTint();
    }

    public void setTrackTintMode(@Nullable PorterDuff.Mode r5) {
        this.mTrackTintMode = r5;
        this.mHasTrackTintMode = true;
        applyTrackTint();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public boolean verifyDrawable(Drawable r5) {
        if (super.verifyDrawable(r5) == false) goto L5;
    L10:
        return true;
    L5:
        if (r5 == this.mThumbDrawable) goto L10;
        if (r5 == this.mTrackDrawable) goto L10;
        return false;
    }

    public SwitchCompat(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, androidx.appcompat.R.attr.switchStyle);
    }

    public SwitchCompat(@NonNull Context r12, @Nullable AttributeSet r13, int r14) {
        super(r12, r13, r14);
        this.mThumbTintList = null;
        this.mThumbTintMode = null;
        this.mHasThumbTint = false;
        this.mHasThumbTintMode = false;
        this.mTrackTintList = null;
        this.mTrackTintMode = null;
        this.mHasTrackTint = false;
        this.mHasTrackTintMode = false;
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mEnforceSwitchWidth = true;
        this.mTempRect = new Rect();
        ThemeUtils.checkAppCompatTheme(this, getContext());
        TextPaint r5 = new TextPaint(1);
        this.mTextPaint = r5;
        r5.density = getResources().getDisplayMetrics().density;
        TintTypedArray r10 = TintTypedArray.obtainStyledAttributes(r12, r13, androidx.appcompat.R.styleable.SwitchCompat, r14, 0);
        ViewCompat.saveAttributeDataForStyleable(this, r12, androidx.appcompat.R.styleable.SwitchCompat, r13, r10.getWrappedTypeArray(), r14, 0);
        Drawable r11 = r10.getDrawable(androidx.appcompat.R.styleable.SwitchCompat_android_thumb);
        this.mThumbDrawable = r11;
        if (r11 == null) goto L5;
        r11.setCallback(this);
    L5:
        Drawable r15 = r10.getDrawable(androidx.appcompat.R.styleable.SwitchCompat_track);
        this.mTrackDrawable = r15;
        if (r15 == null) goto L8;
        r15.setCallback(this);
    L8:
        setTextOnInternal(r10.getText(androidx.appcompat.R.styleable.SwitchCompat_android_textOn));
        setTextOffInternal(r10.getText(androidx.appcompat.R.styleable.SwitchCompat_android_textOff));
        this.mShowText = r10.getBoolean(androidx.appcompat.R.styleable.SwitchCompat_showText, true);
        this.mThumbTextPadding = r10.getDimensionPixelSize(androidx.appcompat.R.styleable.SwitchCompat_thumbTextPadding, 0);
        this.mSwitchMinWidth = r10.getDimensionPixelSize(androidx.appcompat.R.styleable.SwitchCompat_switchMinWidth, 0);
        this.mSwitchPadding = r10.getDimensionPixelSize(androidx.appcompat.R.styleable.SwitchCompat_switchPadding, 0);
        this.mSplitTrack = r10.getBoolean(androidx.appcompat.R.styleable.SwitchCompat_splitTrack, false);
        ColorStateList r16 = r10.getColorStateList(androidx.appcompat.R.styleable.SwitchCompat_thumbTint);
        if (r16 == null) goto L11;
        this.mThumbTintList = r16;
        this.mHasThumbTint = true;
    L11:
        PorterDuff.Mode r17 = DrawableUtils.parseTintMode(r10.getInt(androidx.appcompat.R.styleable.SwitchCompat_thumbTintMode, -1), null);
        if (this.mThumbTintMode == r17) goto L15;
        this.mThumbTintMode = r17;
        this.mHasThumbTintMode = true;
    L15:
        if (this.mHasThumbTint == false) goto L17;
    L18:
        applyThumbTint();
    L19:
        ColorStateList r18 = r10.getColorStateList(androidx.appcompat.R.styleable.SwitchCompat_trackTint);
        if (r18 == null) goto L22;
        this.mTrackTintList = r18;
        this.mHasTrackTint = true;
    L22:
        PorterDuff.Mode r19 = DrawableUtils.parseTintMode(r10.getInt(androidx.appcompat.R.styleable.SwitchCompat_trackTintMode, -1), null);
        if (this.mTrackTintMode == r19) goto L26;
        this.mTrackTintMode = r19;
        this.mHasTrackTintMode = true;
    L26:
        if (this.mHasTrackTint == false) goto L28;
    L29:
        applyTrackTint();
    L30:
        int r20 = r10.getResourceId(androidx.appcompat.R.styleable.SwitchCompat_switchTextAppearance, 0);
        if (r20 == 0) goto L33;
        setSwitchTextAppearance(r12, r20);
    L33:
        AppCompatTextHelper r21 = new AppCompatTextHelper(this);
        this.mTextHelper = r21;
        r21.loadFromAttributes(r13, r14);
        r10.recycle();
        ViewConfiguration r110 = ViewConfiguration.get(r12);
        this.mTouchSlop = r110.getScaledTouchSlop();
        this.mMinFlingVelocity = r110.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().loadFromAttributes(r13, r14);
        refreshDrawableState();
        setChecked(isChecked());
        return;
    L28:
        if (this.mHasTrackTintMode == false) goto L30;
    L17:
        if (this.mHasThumbTintMode == false) goto L19;
        goto L18
    }

    public void setSwitchTypeface(Typeface r5) {
        if (this.mTextPaint.getTypeface() == null) goto L7;
        if (this.mTextPaint.getTypeface().equals(r5) == true) goto L7;
    L9:
        this.mTextPaint.setTypeface(r5);
        requestLayout();
        invalidate();
        return;
    L7:
        if (this.mTextPaint.getTypeface() != null) goto L11;
        if (r5 != null) goto L9;
        return;
    }
}
