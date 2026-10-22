package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.obric.cae.R;

/* JADX INFO: loaded from: classes.dex */
public class m extends ImageButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f1216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f1217b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f1218m;

    public m(Context r8, AttributeSet r10) {
        this(r8, r10, R.attr.imageButtonStyle);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        d r8 = this.f1216a;
        if (r8 == null) goto L5;
        r8.a();
    L5:
        n r10 = this.f1217b;
        if (r10 == null) goto L9;
        r10.a();
        return;
    }

    public ColorStateList getSupportBackgroundTintList() {
        d r8 = this.f1216a;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.b();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d r8 = this.f1216a;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.c();
    }

    public ColorStateList getSupportImageTintList() {
        n r8 = this.f1217b;
        if (r8 == null) goto L8;
        t0 r10 = r8.f1220b;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.f1262a;
    L8:
        return null;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        n r8 = this.f1217b;
        if (r8 == null) goto L8;
        t0 r10 = r8.f1220b;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.f1263b;
    L8:
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public final boolean hasOverlappingRendering() {
        if ((!(this.f1217b.f1219a.getBackground() instanceof RippleDrawable)) == true) goto L5;
    L7:
        return false;
    L5:
        if (super.hasOverlappingRendering() == false) goto L7;
        return true;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r8) {
        super.setBackgroundDrawable(r8);
        d r10 = this.f1216a;
        if (r10 == null) goto L6;
        r10.e();
        return;
    }

    @Override // android.view.View
    public void setBackgroundResource(int r8) {
        super.setBackgroundResource(r8);
        d r10 = this.f1216a;
        if (r10 == null) goto L6;
        r10.f(r8);
        return;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap r8) {
        super.setImageBitmap(r8);
        n r10 = this.f1217b;
        if (r10 == null) goto L6;
        r10.a();
        return;
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable r8) {
        n r10 = this.f1217b;
        if (r10 == null) goto L8;
        if (r8 == null) goto L8;
        if (this.f1218m == true) goto L8;
        r10.f1221c = r8.getLevel();
    L8:
        super.setImageDrawable(r8);
        if (r10 == null) goto L16;
        r10.a();
        if (this.f1218m == true) goto L17;
        ImageView r11 = r10.f1219a;
        if (r11.getDrawable() == null) goto L18;
        r11.getDrawable().setLevel(r10.f1221c);
        return;
    L18:
        return;
    L17:
        return;
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int r8) {
        super.setImageLevel(r8);
        this.f1218m = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int r8) {
        n r10 = this.f1217b;
        ImageView r11 = r10.f1219a;
        if (r8 == 0) goto L7;
        Drawable r12 = d.a.a(r11.getContext(), r8);
        if (r12 == null) goto L8;
        Rect r13 = d0.f1115a;
    L8:
        r11.setImageDrawable(r12);
        r10.a();
        return;
    L7:
        r12 = null;
        goto L8
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri r8) {
        super.setImageURI(r8);
        n r10 = this.f1217b;
        if (r10 == null) goto L6;
        r10.a();
        return;
    }

    public void setSupportBackgroundTintList(ColorStateList r8) {
        d r10 = this.f1216a;
        if (r10 == null) goto L6;
        r10.h(r8);
        return;
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode r8) {
        d r10 = this.f1216a;
        if (r10 == null) goto L6;
        r10.i(r8);
        return;
    }

    public void setSupportImageTintList(ColorStateList r8) {
        n r10 = this.f1217b;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.f1220b != null) goto L7;
        r10.f1220b = new t0();
    L7:
        t0 r11 = r10.f1220b;
        r11.f1262a = r8;
        r11.f1265d = true;
        r10.a();
    }

    public void setSupportImageTintMode(PorterDuff.Mode r8) {
        n r10 = this.f1217b;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.f1220b != null) goto L7;
        r10.f1220b = new t0();
    L7:
        t0 r11 = r10.f1220b;
        r11.f1263b = r8;
        r11.f1264c = true;
        r10.a();
    }

    public m(Context r8, AttributeSet r10, int r11) {
        s0.a(r8);
        super(r8, r10, r11);
        this.f1218m = false;
        q0.a(this, getContext());
        d r12 = new d(this);
        this.f1216a = r12;
        r12.d(r10, r11);
        n r13 = new n(this);
        this.f1217b = r13;
        r13.b(r10, r11);
    }
}
