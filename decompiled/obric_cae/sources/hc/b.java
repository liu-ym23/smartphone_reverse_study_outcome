package hc;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.obric.cae.R;
import com.obric.oui.button.OButton;
import ha.t;
import he.i;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends hc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OButton f8029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OButton f8030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public OButton f8031c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public fc.a f8032d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f8033e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f8034f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f8035g;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f8036a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnClickListener f8037b;

        public a(b r8, DialogInterface.OnClickListener r10) {
            this.f8036a = r8;
            this.f8037b = r10;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r8) {
            b r10 = this.f8036a;
            DialogInterface.OnClickListener r11 = this.f8037b;
            if (r11 == null) goto L5;
            r11.onClick(r10.f8032d, -2);
        L5:
            fc.a r12 = r10.f8032d;
            if (r12 != null) goto L8;
        L10:
            if (r12 == null) goto L13;
            r12.dismiss();
            return;
        L13:
            return;
        L8:
            if (r12.f7365r == true) goto L10;
        }
    }

    /* JADX INFO: renamed from: hc.b$b, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0089b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f8038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnClickListener f8039b;

        public ViewOnClickListenerC0089b(b r8, DialogInterface.OnClickListener r10) {
            this.f8038a = r8;
            this.f8039b = r10;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r8) {
            b r10 = this.f8038a;
            DialogInterface.OnClickListener r11 = this.f8039b;
            if (r11 == null) goto L5;
            r11.onClick(r10.f8032d, -1);
        L5:
            fc.a r12 = r10.f8032d;
            if (r12 != null) goto L8;
        L10:
            if (r12 == null) goto L13;
            r12.dismiss();
            return;
        L13:
            return;
        L8:
            if (r12.f7365r == true) goto L10;
        }
    }

    public b(Context r8) {
        i.f(r8, "context");
        this.f8034f = r8;
        this.f8035g = 0;
    }

    public static void f(OButton r8, hc.a.EnumC0088a r10) {
        if (r10 == null) goto L16;
        int r11 = r10.ordinal();
        if (r11 != 0) goto L6;
        int r12 = R.color.TextReverse;
    L14:
        Context r13 = r8.getContext();
        Object r14 = androidx.core.content.a.f1674a;
        r8.setTextColor(androidx.core.content.a.c.a(r13, r12));
        return;
    L6:
        if (r11 != 1) goto L8;
        r12 = R.color.TextReverse2;
        goto L14
    L8:
        if (r11 != 2) goto L11;
        r12 = R.color.Negative;
        goto L14
    L11:
        throw new t();
    }

    public final void a(CharSequence r8, DialogInterface.OnClickListener r10, hc.a.EnumC0088a r11) {
        OButton r12 = this.f8030b;
        if (r12 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r8) == false) goto L8;
        r12.setVisibility(8);
        return;
    L8:
        View r13 = this.f8033e;
        if (r13 == null) goto L11;
        r13.setVisibility(0);
    L11:
        r12.setText(r8);
        f(r12, r11);
        r12.setVisibility(0);
        r12.setOnClickListener(new a(this, r10));
    }

    @Override // hc.f
    public final void b(fc.a r8) {
        i.f(r8, "dialog");
        this.f8032d = r8;
    }

    @Override // hc.f
    public final void c(Context r8, d r10) {
        i.f(r10, "dialogContainer");
        FrameLayout r11 = r10.c();
        FrameLayout.LayoutParams r12 = new FrameLayout.LayoutParams(-1, -2);
        int r13 = this.f8035g;
        if (r13 != 0) goto L5;
        int r14 = R.layout.o_dialog_button_horizontal;
    L9:
        View r15 = LayoutInflater.from(r8).inflate(r14, r11, false);
        r11.addView(r15, r12);
        this.f8033e = r15;
        if (r15 == null) goto L12;
        r15.setVisibility(8);
    L12:
        this.f8029a = (OButton) r15.findViewById(R.id.actionPositive);
        this.f8030b = (OButton) r15.findViewById(R.id.actionNegative);
        this.f8031c = (OButton) r15.findViewById(R.id.actionNeutral);
        FrameLayout r16 = (FrameLayout) r15.findViewById(R.id.custom_container);
        return;
    L5:
        if (r13 == 1) goto L7;
        r14 = R.layout.o_dialog_button_primary;
        goto L9
    L7:
        r14 = R.layout.o_dialog_button_vertical;
        goto L9
    }

    public final void d() {
        OButton r8 = this.f8031c;
        if (r8 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(null) == false) goto L8;
        r8.setVisibility(8);
        return;
    L8:
        View r10 = this.f8033e;
        if (r10 == null) goto L11;
        r10.setVisibility(0);
    L11:
        r8.setText(null);
        r8.setVisibility(0);
        r8.setOnClickListener(new c(this));
    }

    public final void e(CharSequence r8, DialogInterface.OnClickListener r10, hc.a.EnumC0088a r11, boolean r12) {
        OButton r13 = this.f8029a;
        if (r13 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r8) == false) goto L8;
        r13.setVisibility(8);
        return;
    L8:
        View r14 = this.f8033e;
        if (r14 == null) goto L11;
        r14.setVisibility(0);
    L11:
        if (r12 == false) goto L13;
        Object r15 = androidx.core.content.a.f1674a;
        Context r16 = this.f8034f;
        r13.setBackgroundColor(androidx.core.content.a.c.a(r16, R.color.oui_basic_fill_element_2));
        r13.setTextColor(androidx.core.content.a.c.a(r16, R.color.oui_functional_red_6));
    L13:
        r13.setText(r8);
        f(r13, r11);
        r13.setVisibility(0);
        r13.setOnClickListener(new ViewOnClickListenerC0089b(this, r10));
    }
}
