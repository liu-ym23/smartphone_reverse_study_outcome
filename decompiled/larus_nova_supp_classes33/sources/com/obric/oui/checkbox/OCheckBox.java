package com.obric.oui.checkbox;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import pla.d;
import pla.j;
import vma.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0003()*B\u0011\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"B\u001b\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\b\u0010$\u001a\u0004\u0018\u00010#¢\u0006\u0004\b!\u0010%B#\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u0012\u0006\u0010&\u001a\u00020\u0003¢\u0006\u0004\b!\u0010'J\u0010\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0004\u001a\u00020\u0003J\u0010\u0010\b\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u0003J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\tJ\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0014\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0013R0\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00038\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0004\b\u0016\u0010\u0017\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006+"}, d2 = {"Lcom/obric/oui/checkbox/OCheckBox;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/widget/Checkable;", "", "styleRes", "", "setStyle", "color", "setPrimaryColor", "", "light", "setAlwaysLight", "enableExpand", "setEnableExpandTouchRect", "checked", "setChecked", "Lcom/obric/oui/checkbox/OCheckBox$b;", "listener", "setOnCheckedStateChangedListener", "Lcom/obric/oui/checkbox/OCheckBox$a;", "setOnCheckedChangeListener", "value", "d", "I", "getCheckedState", "()I", "setCheckedState", "(I)V", "getCheckedState$annotations", "()V", "checkedState", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "a", "b", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OCheckBox extends AppCompatImageView implements Checkable {
    public static final int[] n = null;
    public static final int[] o = null;
    public Drawable a;
    public int b;
    public final int c;
    public int d;
    public boolean e;
    public boolean f;
    public ColorFilter g;
    public ColorFilter h;
    public a i;
    public int j;
    public int k;
    public int l;
    public boolean m;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/obric/oui/checkbox/OCheckBox$Companion$CheckedState;", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface CheckedState {
        }
    }

    public interface a {
        void a(OCheckBox r1, boolean r2);
    }

    public interface b {
    }

    public static /* synthetic */ void getCheckedState$annotations() {
    }

    public final void setOnCheckedStateChangedListener(b r1) {
    }

    static {
        n = new int[]{R.attr.state_checked};
        o = new int[]{2130973313};
    }

    public final void createColorFilter() {
        int r0 = this.k;
        if (r0 == (-1)) goto L6;
        this.g = new ColorMatrixColorFilter(new float[]{1.0f, 0.0f, 0.0f, 0.0f, Color.red(r0), 0.0f, 1.0f, 0.0f, 0.0f, Color.green(r0), 0.0f, 0.0f, 1.0f, 0.0f, Color.blue(r0), 0.0f, 0.0f, 0.0f, (Color.alpha(r0) * 1.0f) / 255, 0.0f});
    L6:
        if (this.l == (-1)) goto L9;
        this.h = new PorterDuffColorFilter(this.l, PorterDuff.Mode.SRC_IN);
        return;
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        if (this.d == 1) goto L7;
        return false;
    L7:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void syncDrawableStyle() {
        if (this.f == false) goto L6;
        Drawable r0 = getResources().getDrawable(2131244119, null);
    L12:
        int r1 = this.j;
        if (r1 != (-1)) goto L15;
    L31:
        setImageDrawable(r0);
        return;
    L15:
        if ((r0 instanceof StateListDrawable) == false) goto L31;
        if (Build.VERSION.SDK_INT < 29) goto L31;
        int r2 = g.a;
        StateListDrawable r3 = (StateListDrawable) r0;
        Intrinsics.checkNotNullParameter(r3, "drawable");
        Intrinsics.checkNotNullParameter("primary_shape", "pathName");
        int r4 = r3.getStateCount();
        int r5 = 0;
    L19:
        if (r5 >= r4) goto L31;
        int r6 = r5 + 1;
        Drawable r7 = r3.getStateDrawable(r5);
        if ((r7 instanceof VectorDrawable) == false) goto L27;
        VectorDrawable r8 = (VectorDrawable) r7;
        g.b(r8, r1);     // Catch: Exception -> L25
        r8.invalidateSelf();     // Catch: Exception -> L25
    L30:
        r5 = r6;
        goto L19
    L27:
        if ((r7 instanceof AnimatedVectorDrawable) == false) goto L30;
        AnimatedVectorDrawable r9 = (AnimatedVectorDrawable) r7;
        g.c(r9, r1);     // Catch: Exception -> L25
        r9.invalidateSelf();     // Catch: Exception -> L25
        goto L30
    L6:
        if (this.b != 1) goto L8;
        r0 = getResources().getDrawable(2131244122, null);
        goto L12
    L8:
        r0 = this.a;
        if (r0 != null) goto L12;
        r0 = getResources().getDrawable(2131244118, null);
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.widget.ImageView*/.onAttachedToWindow();
        if (this.m == false) goto L6;
        j.a(this, d.n(this, 44));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean performClick() {
        toggle();
        boolean r0 = super/*android.widget.ImageView*/.performClick();
        if (r0 == true) goto L6;
        playSoundEffect(0);
    L6:
        if (isChecked() == false) goto L8;
        bma.a.c(getContext(), 1);
    L8:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void syncButtonCheckState() {
        Drawable r0 = getDrawable();
        if (r0 == null) goto L6;
        r0.clearColorFilter();
    L6:
        createColorFilter();
        Drawable r1 = getDrawable();
        if (r1 != null) goto L10;
        return;
    L10:
        if (isChecked() == false) goto L12;
        ColorFilter r2 = this.g;
    L13:
        r1.setColorFilter(r2);
        return;
    L12:
        r2 = this.h;
        goto L13
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    public final int getCheckedState() {
        return this.d;
    }

    public OCheckBox(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void j(TypedArray r4) {
        this.b = r4.getInt(4, 0);
        this.j = r4.getColor(5, -1);
        this.k = r4.getColor(3, -1);
        this.l = r4.getColor(6, -1);
        Drawable r0 = r4.getDrawable(2);
        if (r0 != null) goto L5;
        r0 = null;
    L5:
        this.a = r0;
        this.f = r4.getBoolean(1, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int[] onCreateDrawableState(int r3) {
        int[] r4 = super/*android.widget.ImageView*/.onCreateDrawableState(r3 + 2);
        if (this.d != 2) goto L6;
        ImageView.mergeDrawableStates(r4, o);
    L6:
        if (isChecked() == false) goto L8;
        View.mergeDrawableStates(r4, n);
    L8:
        return r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setAlwaysLight(boolean r1) {
        this.f = r1;
        syncDrawableStyle();
        invalidate();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r1) {
        setCheckedState(r1 ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setCheckedState(int r2) {
        if (this.d == r2) goto L15;
        this.d = r2;
        syncButtonCheckState();
        refreshDrawableState();
        if (this.e == false) goto L7;
        return;
    L7:
        this.e = true;
        if (this.d == 2) goto L13;
        a r3 = this.i;
        if (r3 == null) goto L13;
        r3.a(this, isChecked());
    L13:
        this.e = false;
        return;
    }

    public final void setEnableExpandTouchRect(boolean r1) {
        this.m = r1;
    }

    public final void setOnCheckedChangeListener(a r1) {
        this.i = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setPrimaryColor(int r1) {
        this.j = r1;
        syncDrawableStyle();
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setStyle(int r5) {
        TypedArray r6 = getContext().obtainStyledAttributes(null, new int[]{2130973027, 2130973073, 2130973074, 2130973075, 2130973076, 2130973077, 2130973078, 2130973079, 2130973313}, 0, r5);
        j(r6);
        r6.recycle();
        createColorFilter();
        syncDrawableStyle();
        syncButtonCheckState();
        invalidate();
    }

    public OCheckBox(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 2130968657);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r1, int r2) {
        int r3 = View.MeasureSpec.makeMeasureSpec(this.c, 1073741824);
        super/*android.widget.ImageView*/.onMeasure(r3, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OCheckBox(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.c = d.n(this, 18);
        this.j = -1;
        this.k = -1;
        this.l = -1;
        this.m = true;
        TypedArray r7 = r4.obtainStyledAttributes(r5, new int[]{2130973027, 2130973073, 2130973074, 2130973075, 2130973076, 2130973077, 2130973078, 2130973079, 2130973313}, r6, 2131952966);
        j(r7);
        this.m = r7.getBoolean(0, true);
        if (r7.hasValue(7) == false) goto L5;
        setCheckedState(r7.getInt(7, 0));
    L5:
        r7.recycle();
        createColorFilter();
        syncDrawableStyle();
        setBackground(null);
        syncButtonCheckState();
        setClickable(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super/*android.widget.ImageView*/.onLayout(r1, r2, r3, r4, r5);
    }
}
