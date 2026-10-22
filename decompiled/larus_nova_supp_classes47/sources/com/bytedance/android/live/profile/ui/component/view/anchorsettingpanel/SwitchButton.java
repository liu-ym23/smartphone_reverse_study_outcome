package com.bytedance.android.live.profile.ui.component.view.anchorsettingpanel;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0013B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J)\u0010\n\u001a\u00020\u00042!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00040\u0006¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/view/anchorsettingpanel/SwitchButton;", "Landroid/widget/FrameLayout;", "", "isChecked", "", "setState", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "action", "setSwitchListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SwitchButton extends FrameLayout {
    public ConstraintLayout a;
    public View b;
    public boolean c;
    public Function1<? super Boolean, Unit> d;

    public static final class a {
    }

    static {
    }

    public SwitchButton(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SwitchButton(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a(boolean r4) {
        if (r4 == false) goto L4;
        int r5 = ColorProtector.parseColor("#33E088");
    L5:
        ConstraintLayout r0 = this.a;
        Drawable r1 = null;
        if (r0 == null) goto L8;
        Drawable r2 = r0.getBackground();
    L10:
        if ((r2 instanceof GradientDrawable) == false) goto L13;
        r1 = r2;
    L13:
        GradientDrawable r3 = (GradientDrawable) r1;
        if (r3 != null) goto L16;
        return;
    L16:
        r3.mutate();
        r3.setColor(r5);
        return;
    L8:
        r2 = null;
        goto L10
    L4:
        r5 = ColorProtector.parseColor("#33161823");
        goto L5
    }

    public final void setState(boolean r2) {
        this.c = r2;
        a(r2);
        b(r2, true);
    }

    public final void setSwitchListener(Function1<? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        this.d = r2;
    }

    public final void b(boolean r7, boolean r8) {
        ConstraintLayout r0 = this.a;
        if (r0 == null) goto L12;
        ConstraintSet r1 = new ConstraintSet();
        r1.clone(r0);
        if (r7 == false) goto L7;
        r1.clear(2131364981, 1);
        r1.connect(2131364981, 2, 0, 2);
    L8:
        if (r8 == false) goto L10;
        TransitionManager.beginDelayedTransition(r0);
    L10:
        r1.applyTo(r0);
        return;
    L7:
        r1.clear(2131364981, 2);
        r1.connect(2131364981, 1, 0, 1);
        goto L8
    }

    public SwitchButton(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(getContext()).inflate(2131567174, this, true);
        this.a = findViewById(2131384813);
        this.b = findViewById(2131364981);
        ConstraintLayout r5 = this.a;
        if (r5 == null) goto L6;
        r5.setOnClickListener(new com.bytedance.android.live.profile.ui.component.view.anchorsettingpanel.a(new SwitchButton$init$1(this)));
        return;
    }

    public /* synthetic */ SwitchButton(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
