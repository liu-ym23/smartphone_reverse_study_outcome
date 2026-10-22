package com.obric.oui.popover.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.LinearLayout;
import com.obric.cae.R;
import ge.p;
import he.i;
import xd.j;

/* JADX INFO: loaded from: classes2.dex */
public class PopoverMenuLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f6450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f6451b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public p<? super Boolean, ? super Integer, j> f6452m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public GradientDrawable f6453n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f6454o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f6455p;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6456a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ a[] f6457b = null;

        static {
            a r8 = new a("FIRST", 0);
            a r10 = new a("LAST", 1);
            a r11 = new a("OTHER", 2);
            f6456a = r11;
            f6457b = new a[]{r8, r10, r11, new a("ONLY_ONE", 3)};
        }

        public a(String r8, int r10) {
            super(r8, r10);
        }

        public static a valueOf(String r8) {
            return (a) Enum.valueOf(a.class, r8);
        }

        public static a[] values() {
            return (a[]) f6457b.clone();
        }
    }

    public PopoverMenuLinearLayout(Context r8, AttributeSet r10) {
        i.f(r8, "context");
        super(r8, r10, 0);
        Resources r11 = Resources.getSystem();
        i.e(r11, "Resources.getSystem()");
        this.f6450a = TypedValue.applyDimension(1, 20, r11.getDisplayMetrics());
        this.f6451b = a.f6456a;
        Object r12 = androidx.core.content.a.f1674a;
        this.f6454o = androidx.core.content.a.c.a(r8, R.color.oui_state_overlay_pressed);
    }

    public final boolean getForceDark() {
        return this.f6455p;
    }

    public final a getIndexPos() {
        return this.f6451b;
    }

    public final p<Boolean, Integer, j> getNotifyPressedCallback() {
        return this.f6452m;
    }

    public final float getPressedCornerRadius() {
        return this.f6450a;
    }

    public final GradientDrawable getStateBackground() {
        return this.f6453n;
    }

    public final void setForceDark(boolean r8) {
        Drawable r10 = null;
        if (r8 == false) goto L7;
        this.f6454o = Color.parseColor("#1affffff");
        Context r11 = getContext();
        Object r12 = androidx.core.content.a.f1674a;
        Drawable r13 = androidx.core.content.a.b.b(r11, R.drawable.o_pop_list_item_dark);
        if ((r13 instanceof GradientDrawable) == false) goto L11;
    L10:
        r10 = r13;
    L11:
        this.f6453n = (GradientDrawable) r10;
        GradientDrawable r14 = this.f6453n;
        if (r14 == null) goto L14;
        setBackground(r14);
    L14:
        this.f6455p = r8;
        return;
    L7:
        Context r15 = getContext();
        Object r16 = androidx.core.content.a.f1674a;
        this.f6454o = androidx.core.content.a.c.a(r15, R.color.oui_state_overlay_pressed);
        r13 = androidx.core.content.a.b.b(getContext(), R.drawable.o_pop_list_item);
        if ((r13 instanceof GradientDrawable) == true) goto L10;
        goto L10
    }

    public final void setIndexPos(a r8) {
        i.f(r8, "<set-?>");
        this.f6451b = r8;
    }

    public final void setNotifyPressedCallback(p<? super Boolean, ? super Integer, j> r8) {
        this.f6452m = r8;
    }

    @Override // android.view.View
    public void setPressed(boolean r8) {
        super.setPressed(r8);
        p<? super Boolean, ? super Integer, j> r10 = this.f6452m;
        if (r10 == null) goto L6;
        j r11 = r10.invoke(Boolean.valueOf(r8), Integer.valueOf(this.f6454o));
        return;
    }

    public final void setPressedCornerRadius(float r8) {
        this.f6450a = r8;
    }

    public final void setStateBackground(GradientDrawable r8) {
        this.f6453n = r8;
    }
}
