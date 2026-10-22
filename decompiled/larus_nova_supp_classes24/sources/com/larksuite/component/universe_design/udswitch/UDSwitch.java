package com.larksuite.component.universe_design.udswitch;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.CompoundButton;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.call.dora.CommandStatus;
import h18.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\f\b\u0017\u0018\u0000 \u008a\u00012\u00020\u0001:\u0002\u008a\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ*\u0010C\u001a\u00020D2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\b\u0010E\u001a\u00020DH\u0002J\b\u0010F\u001a\u00020DH\u0002J\u0010\u0010G\u001a\u00020D2\b\u0010H\u001a\u0004\u0018\u00010'J\u000e\u0010I\u001a\u00020D2\u0006\u0010J\u001a\u00020\nJ\b\u0010K\u001a\u0004\u0018\u00010'J\u000e\u0010L\u001a\u00020D2\u0006\u0010M\u001a\u00020)J\b\u0010N\u001a\u0004\u0018\u00010)J\u0010\u0010O\u001a\u00020D2\b\u0010P\u001a\u0004\u0018\u00010'J\u000e\u0010Q\u001a\u00020D2\u0006\u0010J\u001a\u00020\nJ\b\u0010R\u001a\u0004\u0018\u00010'J\u000e\u0010S\u001a\u00020D2\u0006\u0010M\u001a\u00020)J\b\u0010T\u001a\u0004\u0018\u00010)J\u000e\u0010U\u001a\u00020D2\u0006\u0010V\u001a\u00020\nJ\u0018\u0010W\u001a\u00020D2\u0006\u0010X\u001a\u00020\n2\u0006\u0010Y\u001a\u00020\nH\u0014J\u0018\u0010Z\u001a\u00020-2\u0006\u0010[\u001a\u00020\u001f2\u0006\u0010\\\u001a\u00020\u001fH\u0002J\b\u0010]\u001a\u00020\nH\u0002J\b\u0010^\u001a\u00020\nH\u0002J\u0010\u0010_\u001a\u00020-2\u0006\u0010`\u001a\u00020aH\u0016J\u0010\u0010b\u001a\u00020D2\u0006\u0010`\u001a\u00020aH\u0002J\u0010\u0010c\u001a\u00020D2\u0006\u0010`\u001a\u00020aH\u0002J\b\u0010d\u001a\u00020-H\u0002J\u0010\u0010e\u001a\u00020D2\u0006\u0010f\u001a\u00020\u001fH\u0016J\b\u0010g\u001a\u00020DH\u0016J\u0010\u0010h\u001a\u00020D2\u0006\u0010i\u001a\u00020-H\u0016J\u000e\u0010j\u001a\u00020D2\u0006\u0010i\u001a\u00020-J\u000e\u0010k\u001a\u00020D2\u0006\u0010i\u001a\u00020-J\u0012\u0010l\u001a\u00020D2\b\u0010m\u001a\u0004\u0018\u00010BH\u0016J\u0010\u0010n\u001a\u00020D2\u0006\u0010o\u001a\u00020-H\u0002J\b\u0010p\u001a\u00020DH\u0002J0\u0010q\u001a\u00020D2\u0006\u0010r\u001a\u00020-2\u0006\u0010s\u001a\u00020\n2\u0006\u0010t\u001a\u00020\n2\u0006\u0010u\u001a\u00020\n2\u0006\u0010v\u001a\u00020\nH\u0014J\u0010\u0010w\u001a\u00020D2\u0006\u0010x\u001a\u00020yH\u0016J\u0010\u0010z\u001a\u00020D2\u0006\u0010{\u001a\u00020yH\u0014J\b\u0010|\u001a\u00020\nH\u0016J\b\u0010}\u001a\u00020\nH\u0016J\u0013\u0010~\u001a\u0004\u0018\u00010\u007f2\u0007\u0010\u0080\u0001\u001a\u00020\nH\u0014J\t\u0010\u0081\u0001\u001a\u00020DH\u0014J\u0019\u0010\u0082\u0001\u001a\u00020D2\u0006\u0010[\u001a\u00020\u001f2\u0006\u0010\\\u001a\u00020\u001fH\u0016J\u0012\u0010\u0083\u0001\u001a\u00020-2\u0007\u0010\u0084\u0001\u001a\u00020'H\u0014J\t\u0010\u0085\u0001\u001a\u00020DH\u0016J$\u0010\u0086\u0001\u001a\u00020\u001f2\u0007\u0010\u0087\u0001\u001a\u00020\u001f2\u0007\u0010\u0088\u0001\u001a\u00020\u001f2\u0007\u0010\u0089\u0001\u001a\u00020\u001fH\u0002R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R\u001a\u0010#\u001a\u00020\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010\u0014R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00103\u001a\n 5*\u0004\u0018\u00010404X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u008b\u0001"}, d2 = {"Lcom/larksuite/component/universe_design/udswitch/UDSwitch;", "Landroid/widget/CompoundButton;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mSwitchWidth", "mSwitchHeight", "mSwitchLeft", "getMSwitchLeft", "()I", "setMSwitchLeft", "(I)V", "mSwitchTop", "getMSwitchTop", "setMSwitchTop", "mSwitchRight", "getMSwitchRight", "setMSwitchRight", "mSwitchBottom", "getMSwitchBottom", "setMSwitchBottom", "mThumbPosition", "", "thumbInitialLeft", "getThumbInitialLeft", "setThumbInitialLeft", "mThumbWidth", "getMThumbWidth", "setMThumbWidth", "mThumbDrawable", "Landroid/graphics/drawable/Drawable;", "mThumbTintList", "Landroid/content/res/ColorStateList;", "mThumbTintMode", "Landroid/graphics/PorterDuff$Mode;", "mHasThumbTint", "", "mHasThumbTintMode", "mTouchMode", "mTouchSlop", "mTouchX", "mTouchY", "mVelocityTracker", "Landroid/view/VelocityTracker;", "kotlin.jvm.PlatformType", "mMinFlingVelocity", "mTrackDrawable", "mTrackTintList", "mTrackTintMode", "mHasTrackTint", "mHasTrackTintMode", "mSwitchMinWidth", "mTempRect", "Landroid/graphics/Rect;", "mPositionAnimator", "Landroid/animation/ObjectAnimator;", "mOnCheckedChangeListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "initView", "", "applyTrackTint", "applyThumbTint", "setThumbDrawable", "thumb", "setThumbResource", "resId", "getThumbDrawable", "setThumbTintList", "tint", "getThumbTintList", "setTrackDrawable", "track", "setTrackResource", "getTrackDrawable", "setTrackTintList", "getTrackTintList", "setSwitchMinWidth", "pixels", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "hitThumb", "x", "y", "getThumbOffset", "getThumbScrollRange", "onTouchEvent", "ev", "Landroid/view/MotionEvent;", "cancelSuperTouch", "stopDrag", "getTargetCheckedState", "setThumbPosition", "position", "toggle", "setChecked", "checked", "setCheckedImmediately", "setCheckedIgnoreEvent", "setOnCheckedChangeListener", "listener", "animateThumbToCheckedState", "newCheckedState", "cancelPositionAnimator", "onLayout", "changed", "left", "top", "right", "bottom", "draw", "c", "Landroid/graphics/Canvas;", "onDraw", "canvas", "getCompoundPaddingLeft", "getCompoundPaddingRight", "onCreateDrawableState", "", "extraSpace", "drawableStateChanged", "drawableHotspotChanged", "verifyDrawable", "who", "jumpDrawablesToCurrentState", "constrain", "amount", "low", "high", "Companion", "universe-ui-switch_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class UDSwitch extends CompoundButton {
    public static final a A = null;
    public static final int[] z = null;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public float g;
    public int h;
    public int i;
    public Drawable j;
    public ColorStateList k;
    public boolean l;
    public int m;
    public int n;
    public float o;
    public float p;
    public final VelocityTracker q;
    public int r;
    public Drawable s;
    public ColorStateList t;
    public boolean u;
    public int v;
    public final Rect w;
    public ObjectAnimator x;
    public CompoundButton.OnCheckedChangeListener y;

    public static final class a extends Property<UDSwitch, Float> {
        public a(Class<Float> r2) {
            super(r2, "thumbPos");
        }

        @Override // android.util.Property
        public final Float get(UDSwitch r2) {
            UDSwitch r3 = r2;
            Intrinsics.checkNotNullParameter(r3, "udSwitch");
            return Float.valueOf(r3.g);
        }

        @Override // android.util.Property
        public final void set(UDSwitch r2, Float r3) {
            UDSwitch r4 = r2;
            float r5 = r3.floatValue();
            Intrinsics.checkNotNullParameter(r4, "udSwitch");
            r4.setThumbPosition(r5);
        }
    }

    public static final class b {
    }

    static {
        z = new int[]{R.attr.state_checked};
        A = new a(Float.TYPE);
    }

    private final boolean getTargetCheckedState() {
        if (this.g <= 0.5f) goto L5;
        return true;
    L5:
        return false;
    }

    private final int getThumbScrollRange() {
        Drawable r0 = this.s;
        if (r0 == null) goto L9;
        Rect r1 = this.w;
        Intrinsics.checkNotNull(r0);
        r0.getPadding(r1);
        Drawable r2 = this.j;
        if (r2 == null) goto L7;
        Rect r3 = h18.a.b(r2);
    L8:
        Intrinsics.checkNotNull(r3);
        return ((((this.a - this.i) - r1.left) - r1.right) - r3.left) - r3.right;
    L7:
        r3 = h18.a.a;
        goto L8
    L9:
        return 0;
    }

    public final void a() {
        Drawable r0 = this.j;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.l == false) goto L16;
        Intrinsics.checkNotNull(r0);
        Drawable r1 = DrawableCompat.wrap(r0).mutate();
        this.j = r1;
        if (this.l == false) goto L10;
        Intrinsics.checkNotNull(r1);
        DrawableCompat.setTintList(r1, this.k);
    L10:
        Drawable r2 = this.j;
        Intrinsics.checkNotNull(r2);
        if (r2.isStateful() == false) goto L15;
        Drawable r3 = this.j;
        Intrinsics.checkNotNull(r3);
        r3.setState(getDrawableState());
        return;
    L15:
        return;
    }

    public final void b() {
        Drawable r0 = this.s;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.u == false) goto L16;
        Intrinsics.checkNotNull(r0);
        Drawable r1 = DrawableCompat.wrap(r0).mutate();
        this.s = r1;
        if (this.u == false) goto L10;
        Intrinsics.checkNotNull(r1);
        DrawableCompat.setTintList(r1, this.t);
    L10:
        Drawable r2 = this.s;
        Intrinsics.checkNotNull(r2);
        if (r2.isStateful() == false) goto L15;
        Drawable r3 = this.s;
        Intrinsics.checkNotNull(r3);
        r3.setState(getDrawableState());
        return;
    L15:
        return;
    }

    private final int getThumbOffset() {
        if (h.a(this) == false) goto L5;
        float r0 = 1.0f - this.g;
    L7:
        return (int) ((r0 * getThumbScrollRange()) + 0.5f);
    L5:
        r0 = this.g;
        goto L7
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r0 = getDrawableState();
        Drawable r1 = this.j;
        boolean r2 = false;
        if (r1 != null) goto L5;
    L7:
        Drawable r3 = this.s;
        if (r3 != null) goto L10;
    L12:
        if (r2 == false) goto L15;
        invalidate();
        return;
    L15:
        return;
    L10:
        if (r3.isStateful() == false) goto L12;
        r2 = r2 | r3.setState(r0);
        goto L12
    L5:
        if (r1.isStateful() == false) goto L7;
        r2 = false | r1.setState(r0);
        goto L7
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (h.a(this) == true) goto L7;
        return super.getCompoundPaddingLeft();
    L7:
        return super.getCompoundPaddingLeft() + this.a;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (h.a(this) == false) goto L7;
        return super.getCompoundPaddingRight();
    L7:
        return super.getCompoundPaddingRight() + this.a;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable r0 = this.j;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r0);
        r0.jumpToCurrentState();
    L5:
        Drawable r1 = this.s;
        if (r1 == null) goto L8;
        Intrinsics.checkNotNull(r1);
        r1.jumpToCurrentState();
    L8:
        ObjectAnimator r2 = this.x;
        if (r2 == null) goto L14;
        Intrinsics.checkNotNull(r2);
        if (r2.isStarted() == false) goto L15;
        ObjectAnimator r3 = this.x;
        Intrinsics.checkNotNull(r3);
        r3.end();
        this.x = null;
        return;
    L15:
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    public final int getMSwitchBottom() {
        return this.f;
    }

    public final int getMSwitchLeft() {
        return this.c;
    }

    public final int getMSwitchRight() {
        return this.e;
    }

    public final int getMSwitchTop() {
        return this.d;
    }

    public final int getMThumbWidth() {
        return this.i;
    }

    public final Drawable getThumbDrawable() {
        return this.j;
    }

    public final int getThumbInitialLeft() {
        return this.h;
    }

    public final ColorStateList getThumbTintList() {
        return this.k;
    }

    public final Drawable getTrackDrawable() {
        return this.s;
    }

    public final ColorStateList getTrackTintList() {
        return this.t;
    }

    public UDSwitch(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    @Override // android.view.View
    public void draw(Canvas r11) {
        Intrinsics.checkNotNullParameter(r11, "c");
        Rect r0 = this.w;
        int r1 = this.c;
        int r2 = this.d;
        int r3 = this.e;
        int r4 = this.f;
        this.h = getThumbOffset() + r1;
        Drawable r5 = this.j;
        if (r5 == null) goto L5;
        Rect r6 = h18.a.b(r5);
    L6:
        Drawable r7 = this.s;
        if (r7 == null) goto L26;
        r7.getPadding(r0);
        int r8 = this.h;
        int r9 = r0.left;
        this.h = r8 + r9;
        if (r6 == null) goto L23;
        int r10 = r6.left;
        if (r10 <= r9) goto L13;
        r1 = r1 + (r10 - r9);
    L13:
        int r12 = r6.top;
        int r13 = r0.top;
        if (r12 <= r13) goto L16;
        int r14 = (r12 - r13) + r2;
    L17:
        int r15 = r6.right;
        int r16 = r0.right;
        if (r15 <= r16) goto L20;
        r3 = r3 - (r15 - r16);
    L20:
        int r17 = r6.bottom;
        int r19 = r0.bottom;
        if (r17 <= r19) goto L24;
        int r20 = r4 - (r17 - r19);
    L25:
        r7.setBounds(r1, r14, r3, r20);
    L24:
        r20 = r4;
        goto L25
    L16:
        r14 = r2;
        goto L17
    L23:
        r14 = r2;
    L26:
        Drawable r21 = this.j;
        if (r21 == null) goto L31;
        r21.getPadding(r0);
        int r22 = this.h;
        int r23 = r22 - r0.left;
        int r24 = (r22 + this.i) + r0.right;
        r21.setBounds(r23, r2, r24, r4);
        Drawable r25 = getBackground();
        if (r25 == null) goto L31;
        DrawableCompat.setHotspotBounds(r25, r23, r2, r24, r4);
    L31:
        super.draw(r11);
        return;
    L5:
        r6 = h18.a.a;
        goto L6
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int r2) {
        int[] r3 = super.onCreateDrawableState(r2 + 1);
        if (isChecked() == false) goto L5;
        View.mergeDrawableStates(r3, z);
    L5:
        return r3;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        super.onDraw(r3);
        Rect r0 = this.w;
        Drawable r1 = this.s;
        if (r1 == null) goto L5;
        r1.getPadding(r0);
    L6:
        Drawable r2 = this.j;
        if (r1 == null) goto L9;
        r1.draw(r3);
    L9:
        int r4 = r3.save();
        if (r2 == null) goto L12;
        r2.draw(r3);
    L12:
        r3.restoreToCount(r4);
        return;
    L5:
        r0.setEmpty();
        goto L6
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r11) {
        Intrinsics.checkNotNullParameter(r11, "ev");
        this.q.addMovement(r11);
        int r0 = r11.getActionMasked();
        boolean r1 = false;
        if (r0 == 0) goto L67;
        float r4 = 0.0f;
        if (r0 == 1) goto L43;
        if (r0 == 2) goto L9;
        if (r0 == 3) goto L43;
    L84:
        return super.onTouchEvent(r11);
    L9:
        int r2 = this.m;
        if (r2 == 1) goto L36;
        if (r2 != 2) goto L84;
        float r12 = r11.getX();
        int r3 = getThumbScrollRange();
        float r5 = r12 - this.o;
        if (r3 == 0) goto L17;
        float r6 = r5 / r3;
    L21:
        if (h.a(this) == false) goto L23;
        r6 = -r6;
    L23:
        float r7 = this.g;
        float r8 = r6 + r7;
        if (r8 < 0.0f) goto L31;
        if (r8 <= 1.0f) goto L29;
        r4 = 1.0f;
        goto L31
    L29:
        r4 = r8;
    L31:
        if (r4 != r7) goto L33;
        r1 = true;
    L33:
        if (r1 == true) goto L35;
        this.o = r12;
        setThumbPosition(r4);
    L35:
        return true;
    L17:
        if (r5 <= 0.0f) goto L19;
        r6 = 1.0f;
        goto L21
    L19:
        r6 = -1.0f;
        goto L21
    L36:
        float r9 = r11.getX();
        float r10 = r11.getY();
        if (Math.abs(r9 - this.o) <= this.n) goto L39;
    L40:
        this.m = 2;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.o = r9;
        this.p = r10;
        return true;
    L39:
        if (Math.abs(r10 - this.p) <= this.n) goto L84;
    L43:
        if (this.m != 2) goto L66;
        this.m = 0;
        if (r11.getAction() == 1) goto L47;
    L49:
        boolean r13 = false;
    L50:
        boolean r14 = isChecked();
        if (r13 == false) goto L64;
        this.q.computeCurrentVelocity(CommandStatus.DORA_TRACE);
        float r15 = this.q.getXVelocity();
        if (Math.abs(r15) > this.r) goto L55;
        r14 = getTargetCheckedState();
        goto L64
    L55:
        if (h.a(this) == false) goto L60;
        if (r15 < 0.0f) goto L61;
    L62:
        r14 = r1;
    L61:
        r1 = true;
        goto L62
    L60:
        if (r15 <= 0.0f) goto L62;
    L64:
        setChecked(r14);
        MotionEvent r16 = MotionEvent.obtain(r11);
        r16.setAction(3);
        super.onTouchEvent(r16);
        r16.recycle();
        super.onTouchEvent(r11);
        return true;
    L47:
        if (isEnabled() == false) goto L49;
        r13 = true;
        goto L50
    L66:
        this.m = 0;
        this.q.clear();
        goto L84
    L67:
        float r17 = r11.getX();
        float r19 = r11.getY();
        if (isEnabled() == false) goto L84;
        if (this.j == null) goto L81;
        int r20 = getThumbOffset();
        Drawable r21 = this.j;
        Intrinsics.checkNotNull(r21);
        r21.getPadding(this.w);
        int r22 = this.d;
        int r23 = this.n;
        int r24 = r22 - r23;
        int r25 = (this.c + r20) - r23;
        int r26 = this.i + r25;
        Rect r27 = this.w;
        int r29 = ((r26 + r27.left) + r27.right) + r23;
        int r30 = this.f + r23;
        if (r17 <= r25) goto L81;
        if (r17 >= r29) goto L81;
        if (r19 <= r24) goto L81;
        if (r19 >= r30) goto L81;
        r1 = true;
    L81:
        if (r1 == false) goto L84;
        this.m = 1;
        this.o = r17;
        this.p = r19;
        goto L84
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r5) {
        super.setChecked(r5);
        boolean r6 = isChecked();
        float r1 = 0.0f;
        if (getWindowToken() != null) goto L5;
    L11:
        ObjectAnimator r0 = this.x;
        if (r0 == null) goto L14;
        r0.cancel();
    L14:
        if (r6 == false) goto L16;
        r1 = 1.0f;
    L16:
        setThumbPosition(r1);
        return;
    L5:
        if (ViewCompat.isLaidOut(this) == false) goto L11;
        if (r6 == false) goto L8;
        r1 = 1.0f;
    L8:
        ObjectAnimator r7 = ObjectAnimator.ofFloat(this, A, new float[]{r1});
        this.x = r7;
        if (r7 == null) goto L18;
        r7.setDuration(250);
        r7.setAutoCancel(true);
        r7.start();
        return;
    }

    public final void setCheckedIgnoreEvent(boolean r2) {
        if (this.y != null) goto L5;
        setChecked(r2);
        return;
    L5:
        super.setOnCheckedChangeListener(null);
        setChecked(r2);
        super.setOnCheckedChangeListener(this.y);
    }

    public final void setCheckedImmediately(boolean r1) {
        if (r1 == false) goto L4;
        float r2 = 1.0f;
    L5:
        setThumbPosition(r2);
        return;
    L4:
        r2 = 0.0f;
        goto L5
    }

    public final void setMSwitchBottom(int r1) {
        this.f = r1;
    }

    public final void setMSwitchLeft(int r1) {
        this.c = r1;
    }

    public final void setMSwitchRight(int r1) {
        this.e = r1;
    }

    public final void setMSwitchTop(int r1) {
        this.d = r1;
    }

    public final void setMThumbWidth(int r1) {
        this.i = r1;
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener r1) {
        super.setOnCheckedChangeListener(r1);
        this.y = r1;
    }

    public final void setSwitchMinWidth(int r1) {
        this.v = r1;
        requestLayout();
    }

    public final void setThumbDrawable(Drawable r3) {
        Drawable r0 = this.j;
        if (r0 == null) goto L5;
        r0.setCallback(null);
    L5:
        this.j = r3;
        if (r3 == null) goto L8;
        r3.setCallback(this);
    L8:
        requestLayout();
    }

    public final void setThumbInitialLeft(int r1) {
        this.h = r1;
    }

    public void setThumbPosition(float r1) {
        this.g = r1;
        invalidate();
    }

    public final void setThumbResource(int r2) {
        setThumbDrawable(AppCompatResources.getDrawable(getContext(), r2));
    }

    public final void setThumbTintList(ColorStateList r2) {
        Intrinsics.checkNotNullParameter(r2, "tint");
        this.k = r2;
        this.l = true;
        a();
    }

    public final void setTrackDrawable(Drawable r3) {
        Drawable r0 = this.s;
        if (r0 == null) goto L5;
        r0.setCallback(null);
    L5:
        this.s = r3;
        if (r3 == null) goto L8;
        r3.setCallback(this);
    L8:
        requestLayout();
    }

    public final void setTrackResource(int r2) {
        setTrackDrawable(AppCompatResources.getDrawable(getContext(), r2));
    }

    public final void setTrackTintList(ColorStateList r2) {
        Intrinsics.checkNotNullParameter(r2, "tint");
        this.t = r2;
        this.u = true;
        b();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final boolean verifyDrawable(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "who");
        if (super.verifyDrawable(r2) == false) goto L5;
    L10:
        return true;
    L5:
        if (r2 == this.j) goto L10;
        if (r2 == this.s) goto L10;
        return false;
    }

    public UDSwitch(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableHotspotChanged(float r2, float r3) {
        super.drawableHotspotChanged(r2, r3);
        Drawable r0 = this.j;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r0);
        DrawableCompat.setHotspot(r0, r2, r3);
    L5:
        Drawable r1 = this.s;
        if (r1 == null) goto L9;
        Intrinsics.checkNotNull(r1);
        DrawableCompat.setHotspot(r1, r2, r3);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r8, int r9) {
        Rect r0 = this.w;
        Drawable r1 = this.j;
        int r2 = 0;
        if (r1 == null) goto L5;
        Intrinsics.checkNotNull(r1);
        r1.getPadding(r0);
        Drawable r3 = this.j;
        Intrinsics.checkNotNull(r3);
        int r4 = (r3.getIntrinsicWidth() - r0.left) - r0.right;
        Drawable r5 = this.j;
        Intrinsics.checkNotNull(r5);
        int r6 = r5.getIntrinsicHeight();
    L6:
        this.i = r4;
        Drawable r7 = this.s;
        if (r7 == null) goto L9;
        Intrinsics.checkNotNull(r7);
        r7.getPadding(r0);
        Drawable r10 = this.s;
        Intrinsics.checkNotNull(r10);
        r2 = r10.getIntrinsicHeight();
    L10:
        int r11 = r0.left;
        int r12 = r0.right;
        Drawable r13 = this.j;
        if (r13 == null) goto L13;
        Rect r14 = h18.a.b(r13);
        r11 = Math.max(r11, r14.left);
        r12 = Math.max(r12, r14.right);
    L13:
        int r15 = (int) Math.max(this.v * 1.0f, ((this.i * 1.6f) + r11) + r12);
        int r16 = Math.max(r2, r6);
        this.a = r15;
        this.b = r16;
        super.onMeasure(r8, r9);
        if (getMeasuredHeight() >= r16) goto L17;
        setMeasuredDimension(getMeasuredWidthAndState(), r16);
        return;
    L17:
        return;
    L9:
        r0.setEmpty();
        goto L10
    L5:
        r4 = 0;
        r6 = 0;
        goto L6
    }

    public UDSwitch(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, r4, 0);
    }

    public UDSwitch(Context r2, AttributeSet r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4, 2131953905);
        this.q = VelocityTracker.obtain();
        this.w = new Rect();
        TypedArray r6 = r2.obtainStyledAttributes(r3, new int[]{R.attr.thumb, 2130974951, 2130974952, 2130974953, 2130974954}, r4, 2131953905);
        this.j = r6.getDrawable(0);
        ColorStateList r7 = r6.getColorStateList(2);
        this.k = r7;
        if (r7 == null) goto L5;
        this.l = true;
        a();
    L5:
        this.s = r6.getDrawable(3);
        this.t = r6.getColorStateList(4);
        if (this.k == null) goto L8;
        this.u = true;
        b();
    L8:
        this.v = r6.getDimensionPixelSize(1, 0);
        r6.recycle();
        ViewConfiguration r8 = ViewConfiguration.get(r2);
        this.n = r8.getScaledTouchSlop();
        this.r = r8.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        int r6 = 0;
        if (this.j == null) goto L9;
        Rect r7 = this.w;
        Drawable r8 = this.s;
        if (r8 == null) goto L7;
        Intrinsics.checkNotNull(r8);
        r8.getPadding(r7);
    L8:
        Rect r9 = h18.a.b(this.j);
        int r10 = Math.max(0, r9.left - r7.left);
        r6 = Math.max(0, r9.right - r7.right);
    L11:
        if (h.a(this) == false) goto L13;
        int r11 = getPaddingLeft() + r10;
        int r12 = ((this.a + r11) - r10) - r6;
    L14:
        int r13 = getGravity() & 112;
        if (r13 != 16) goto L17;
        int r14 = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
        int r15 = this.b;
        int r16 = r14 - (r15 / 2);
    L24:
        int r17 = r15 + r16;
    L25:
        this.c = r11;
        this.d = r16;
        this.f = r17;
        this.e = r12;
        return;
    L17:
        if (r13 != 48) goto L19;
        r16 = getPaddingTop();
        r15 = this.b;
        goto L24
    L19:
        if (r13 == 80) goto L21;
        r16 = getPaddingTop();
        r15 = this.b;
        goto L24
    L21:
        r17 = getHeight() - getPaddingBottom();
        r16 = r17 - this.b;
        goto L25
    L13:
        r12 = (getWidth() - getPaddingRight()) - r6;
        r11 = ((r12 - this.a) + r10) + r6;
        goto L14
    L7:
        r7.setEmpty();
        goto L8
    L9:
        r10 = 0;
        goto L11
    }
}
