package nr;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController$TextColorType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import zm.p;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f20304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OButton f20305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public OButton f20306c;
    public OButton d;
    public Object e;
    public View f;
    public FrameLayout g;

    public e(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.f20304a = r5;
    }

    public static void f(OButton r5, ButtonStyleController$TextColorType r10) {
        if (r10 == null) goto L16;
        int r11 = d.f20303a[r10.ordinal()];
        if (r11 != 1) goto L6;
        int r12 = R$color.Negative;
    L14:
        r5.setTextColor(ContextCompat.getColor(r5.getContext(), r12));
        return;
    L6:
        if (r11 != 2) goto L8;
        r12 = R$color.TextReverse;
        goto L14
    L8:
        if (r11 != 3) goto L11;
        r12 = R$color.TextReverse2;
        goto L14
    L11:
        throw new NoWhenBranchMatchedException();
    }

    @Override // nr.g
    public final void a(Context r5, f r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "dialogContainer");
        FrameLayout r11 = r10.getButtonSlot();
        FrameLayout.LayoutParams r12 = new FrameLayout.LayoutParams(-1, -2);
        if (p.t(this.f20304a.getResources().getConfiguration().fontScale) == false) goto L5;
        int r13 = R$layout.o_dialog_button_vertical;
    L6:
        View r14 = LayoutInflater.from(r5).inflate(r13, r11, false);
        r11.addView(r14, r12);
        this.f = r14;
        if (r14 == null) goto L10;
        r14.setVisibility(8);
    L10:
        this.f20305b = (OButton) r14.findViewById(R$id.actionPositive);
        this.f20306c = (OButton) r14.findViewById(R$id.actionNegative);
        this.d = (OButton) r14.findViewById(R$id.actionNeutral);
        this.g = (FrameLayout) r14.findViewById(R$id.custom_container);
        return;
    L5:
        r13 = R$layout.o_dialog_button_horizontal;
        goto L6
    }

    @Override // nr.g
    public final void b(a r5) {
        Intrinsics.checkNotNullParameter(r5, "host");
        this.e = r5;
        if ((r5 instanceof com.obric.oui.dialog.v2.alert.b) == false) goto L6;
        Intrinsics.checkNotNullParameter((com.obric.oui.dialog.base.d) r5, "dialog");
        return;
    }

    public final void c(String r5, DialogInterface.OnClickListener r10, ButtonStyleController$TextColorType r11) {
        OButton r12 = this.f20306c;
        if (r12 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r5) == false) goto L9;
        r12.setVisibility(8);
        return;
    L9:
        View r13 = this.f;
        if (r13 == null) goto L13;
        r13.setVisibility(0);
    L13:
        r12.setText(r5);
        f(r12, r11);
        r12.setVisibility(0);
        r12.setOnClickListener(new c(this, r10, 0));
    }

    public final void d() {
        OButton r5 = this.d;
        if (r5 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(null) == false) goto L9;
        r5.setVisibility(8);
        return;
    L9:
        View r10 = this.f;
        if (r10 == null) goto L13;
        r10.setVisibility(0);
    L13:
        r5.setText(null);
        r5.setVisibility(0);
        r5.setOnClickListener(new ar.a(this, 22));
    }

    public final void e(String r5, DialogInterface.OnClickListener r10, ButtonStyleController$TextColorType r11, boolean r12) {
        OButton r13 = this.f20305b;
        if (r13 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r5) == false) goto L9;
        r13.setVisibility(8);
        return;
    L9:
        View r14 = this.f;
        if (r14 == null) goto L13;
        r14.setVisibility(0);
    L13:
        if (r12 == false) goto L15;
        int r15 = R$color.oui_basic_fill_element_2;
        Context r16 = this.f20304a;
        r13.setBackgroundColor(ContextCompat.getColor(r16, r15));
        r13.setTextColor(ContextCompat.getColor(r16, R$color.oui_functional_red_6));
    L15:
        r13.setText(r5);
        f(r13, r11);
        r13.setVisibility(0);
        r13.setOnClickListener(new c(this, r10, 1));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, nr.a] */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.content.DialogInterface, java.lang.Object] */
    public final void g() {
        ?? r5 = this.e;
        if (r5 != 0) goto L6;
    L8:
        ?? r10 = this.e;
        if (r10 == 0) goto L13;
        r10.dismiss();
        return;
    L13:
        return;
    L6:
        if (r5.c() == true) goto L8;
    }
}
