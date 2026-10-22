package com.larksuite.component.universe_design.edittext;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import h18.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 52\u00020\u0001:\u00015B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u001f\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\fJ\u0006\u0010#\u001a\u00020!J\u0010\u0010#\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010\fJ\u0018\u0010#\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010\f2\u0006\u0010%\u001a\u00020\u0007J\u0006\u0010&\u001a\u00020!J\u0010\u0010&\u001a\u00020!2\b\u0010'\u001a\u0004\u0018\u00010\fJ\u0018\u0010&\u001a\u00020!2\b\u0010'\u001a\u0004\u0018\u00010\f2\u0006\u0010%\u001a\u00020\u0007J\u0018\u0010&\u001a\u00020!2\b\u0010'\u001a\u0004\u0018\u00010\f2\u0006\u0010%\u001a\u00020\u0013J \u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020!H\u0002J\b\u0010/\u001a\u00020!H\u0002J\u001a\u00100\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\f2\u0006\u0010%\u001a\u00020\u0007H\u0002J\b\u00101\u001a\u00020!H\u0002J\u001a\u00102\u001a\u00020!2\b\u00103\u001a\u0004\u0018\u00010\f2\u0006\u0010%\u001a\u00020\u0013H\u0002J\b\u00104\u001a\u00020!H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/larksuite/component/universe_design/edittext/UDTextInputLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mTitleText", "", "mTitleTextColor", "mTitleTextSize", "", "mTitleInputMargin", "mHelperText", "mHelperTextColor", "Landroid/content/res/ColorStateList;", "mBottomTextSize", "mBottomInputMargin", "mErrorText", "mErrorTextColor", "mInputFrame", "Landroid/widget/FrameLayout;", "mEditText", "Landroid/widget/EditText;", "mTopTextView", "Landroid/widget/TextView;", "mBottomTextView", "getEditText", "showTitleText", "", "titleText", "showErrorText", "errorText", "textColor", "showHelperText", "helperText", "addView", "child", "Landroid/view/View;", "index", "params", "Landroid/view/ViewGroup$LayoutParams;", "initView", "initBottomTextView", "refreshTitleText", "initInputFrame", "refreshBottomText", "showText", "initTopTextView", "Companion", "universe-ui-edittext_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class UDTextInputLayout extends LinearLayout {
    public final ColorStateList a;
    public final FrameLayout b;
    public EditText c;
    public final TextView d;

    public static final class a {
    }

    static {
    }

    public UDTextInputLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 0, 14);
    }

    public UDTextInputLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 12);
    }

    public UDTextInputLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, r4, 8);
    }

    public final EditText getEditText() {
        return this.c;
    }

    public final void b(CharSequence r2) {
        a(r2, this.a);
    }

    public final void a(CharSequence r2, ColorStateList r3) {
        if (TextUtils.isEmpty(r2) == true) goto L5;
        this.d.setText(r2);
        this.d.setTextColor(r3);
        this.d.setVisibility(0);
        return;
    L5:
        this.d.setVisibility(8);
    }

    @Override // android.view.ViewGroup
    public final void addView(View r2, int r3, ViewGroup.LayoutParams r4) {
        Intrinsics.checkNotNullParameter(r2, "child");
        Intrinsics.checkNotNullParameter(r4, "params");
        if ((r2 instanceof EditText) == true) goto L5;
        super.addView(r2, r3, r4);
        return;
    L5:
        if (this.c != null) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == false) goto L11;
        this.c = (EditText) r2;
        this.b.addView(r2, r4);
        return;
    L11:
        throw new IllegalArgumentException("We already have an EditText, can only have one".toString());
    L7:
        r5 = false;
        goto L8
    }

    public UDTextInputLayout(Context r17, AttributeSet r19, int r110, int r20) {
        if ((r20 & 2) == 0) goto L5;
        AttributeSet r2 = null;
    L7:
        if ((r20 & 4) == 0) goto L9;
        int r4 = 0;
    L10:
        Intrinsics.checkNotNullParameter(r17, "context");
        super(r17, r2, r4);
        ColorStateList.valueOf(0);
        this.a = ColorStateList.valueOf(0);
        FrameLayout r6 = new FrameLayout(r17);
        this.b = r6;
        TextView r7 = new TextView(r17);
        TextView r8 = new TextView(r17);
        this.d = r8;
        setOrientation(1);
        TypedArray r3 = r17.obtainStyledAttributes(r2, new int[]{2130974905, 2130974906, 2130974907, 2130974908, 2130974909, 2130974910, 2130974911, 2130974912, 2130974913, 2130974914}, r4, 0);
        String r5 = r3.getString(7);
        int r10 = r3.getColor(8, UDColorUtils.getColor(r17, 2131106622));
        float r12 = r3.getDimension(9, d.a(r17, 16.0f));
        int r14 = r3.getDimensionPixelSize(6, (int) d.a(r17, 8.0f));
        CharSequence r9 = r3.getString(4);
        ColorStateList r15 = r3.getColorStateList(5);
        if (r15 != null) goto L13;
        r15 = UDColorUtils.getColorStateList(r17, 2131108901);
    L13:
        r3.getString(2);
        ColorStateList r11 = r3.getColorStateList(3);
        if (r11 != null) goto L16;
        r11 = UDColorUtils.getColorStateList(r17, 2131102093);
    L16:
        this.a = r11;
        float r13 = r3.getDimension(1, d.a(r17, 14.0f));
        int r1 = r3.getDimensionPixelSize(0, (int) d.a(r17, 8.0f));
        r3.recycle();
        r7.setTextSize(0, r12);
        r7.setTextColor(r10);
        LinearLayout.LayoutParams r16 = new LinearLayout.LayoutParams(-1, -2);
        r16.bottomMargin = r14;
        if (TextUtils.isEmpty(r5) == true) goto L19;
        r7.setText(r5);
        r7.setVisibility(0);
    L20:
        addView(r7, r16);
        r6.setAddStatesFromChildren(true);
        r6.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        addView(r6);
        r8.setTextSize(0, r13);
        LinearLayout.LayoutParams r21 = new LinearLayout.LayoutParams(-1, -2);
        r21.topMargin = r1;
        addView(r8, r21);
        a(r9, r15);
        return;
    L19:
        r7.setVisibility(8);
        goto L20
    L9:
        r4 = r110;
        goto L10
    L5:
        r2 = r19;
        goto L7
    }
}
