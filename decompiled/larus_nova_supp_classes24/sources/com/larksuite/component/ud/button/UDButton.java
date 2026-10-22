package com.larksuite.component.ud.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import com.larksuite.component.ud.radius.UDRadius;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002J\u000f\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\b\u0010\u0010\u001a\u00020\rH\u0007J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0007J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013¨\u0006\u001d"}, d2 = {"Lcom/larksuite/component/ud/button/UDButton;", "Landroidx/appcompat/widget/AppCompatButton;", "", "color", "", "setBackgroundColor", "Landroid/content/res/ColorStateList;", "colors", "setStrokeColor", "width", "setStrokeWidth", "getStrokeWidth", "()Ljava/lang/Integer;", "", "radius", "setCornerRadius", "getCornerRadius", "", "getCornerRadii", "", "isRadiusAdjustBounds", "setRadiusAdjustBounds", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "chameleon-base_release"}, k = 1, mv = {1, 7, 1})
public class UDButton extends AppCompatButton {
    public final nz7.a a;

    public UDButton(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public UDButton(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final float[] getCornerRadii() {
        return this.a.getCornerRadii();
    }

    public final float getCornerRadius() {
        return this.a.getCornerRadius();
    }

    public final Integer getStrokeWidth() {
        return Integer.valueOf(this.a.c);
    }

    public void setBackgroundColor(int r2) {
        nz7.a r0 = this.a;
        ColorStateList r3 = ColorStateList.valueOf(r2);
        r0.a = r3;
        r0.setColor(r3);
    }

    public final void setCornerRadius(float r2) {
        this.a.setCornerRadius(r2);
    }

    public final void setRadiusAdjustBounds(boolean r3) {
        nz7.a r0 = this.a;
        if (r0.d == r3) goto L10;
        r0.d = r3;
        if (r3 == false) goto L8;
        r0.setCornerRadius(Math.min(r0.getBounds().width(), r0.getBounds().height()) / 2);
    L8:
        r0.invalidateSelf();
        return;
    }

    public final void setStrokeColor(ColorStateList r3) {
        Intrinsics.checkNotNullParameter(r3, "colors");
        nz7.a r0 = this.a;
        int r1 = r0.c;
        r0.c = r1;
        r0.b = r3;
        r0.setStroke(r1, r3);
    }

    public final void setStrokeWidth(int r3) {
        nz7.a r0 = this.a;
        ColorStateList r1 = r0.b;
        r0.c = r3;
        r0.b = r1;
        r0.setStroke(r3, r1);
    }

    public final void setBackgroundColor(ColorStateList r2) {
        nz7.a r0 = this.a;
        r0.a = r2;
        r0.setColor(r2);
    }

    public final void setStrokeColor(int r1) {
        setStrokeColor(ColorStateList.valueOf(r1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UDButton(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, r11);
        boolean r1 = false;
        TypedArray r12 = r9.obtainStyledAttributes(r10, new int[]{R.attr.textAppearance, R.attr.ellipsize, R.attr.gravity, R.attr.paddingLeft, R.attr.paddingRight, R.attr.layout_width, R.attr.layout_height, R.attr.layout_marginLeft, R.attr.layout_marginRight, R.attr.minWidth, R.attr.maxLines, 2130974844, 2130974915, 2130974935, 2130974936, 2130974937, 2130974938, 2130974939, 2130974945, 2130974946}, r11, 0);
        ColorStateList r13 = r12.getColorStateList(11);
        ColorStateList r0 = r12.getColorStateList(18);
        int r2 = r12.getDimensionPixelSize(19, 0);
        boolean r3 = r12.getBoolean(12, false);
        int r4 = r12.getInt(13, 0);
        if (r4 < 0) goto L17;
        UDRadius.Companion.getClass();
        switch(r4) {
            case 0: goto L15;
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L7;
        };
    L8:
        UDRadius r5 = UDRadius.ROUND;
    L16:
        r4 = r5.getRadiusSize(r9);
        goto L17
    L9:
        r5 = UDRadius.XXL;
        goto L16
    L10:
        r5 = UDRadius.XL;
        goto L16
    L11:
        r5 = UDRadius.L;
        goto L16
    L12:
        r5 = UDRadius.M;
        goto L16
    L13:
        r5 = UDRadius.S;
        goto L16
    L14:
        r5 = UDRadius.XS;
        goto L16
    L15:
        r5 = UDRadius.NONE;
        goto L16
    L7:
        throw new IllegalArgumentException("no radius for value " + r4 + '!');
    L17:
        int r14 = r12.getDimensionPixelSize(16, 0);
        int r6 = r12.getDimensionPixelSize(17, 0);
        int r7 = r12.getDimensionPixelSize(14, 0);
        int r8 = r12.getDimensionPixelSize(15, 0);
        r12.recycle();
        nz7.a r15 = new nz7.a();
        r15.a = r13;
        r15.setColor(r13);
        r15.c = r2;
        r15.b = r0;
        r15.setStroke(r2, r0);
        if (r14 > 0) goto L27;
        if (r6 > 0) goto L27;
        if (r7 > 0) goto L27;
        if (r8 > 0) goto L27;
        r15.setCornerRadius(r4);
        if (r4 > 0) goto L28;
        r1 = r3;
    L28:
        r15.d = r1;
        this.a = r15;
        setBackground(r15);
        return;
    L27:
        float r16 = r14;
        float r17 = r6;
        float r19 = r8;
        float r20 = r7;
        r15.setCornerRadii(new float[]{r16, r16, r17, r17, r19, r19, r20, r20});
        goto L28
    }

    public /* synthetic */ UDButton(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
