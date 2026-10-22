package com.obric.oui.dialog.alert;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.k;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import u8.f;
import u8.h;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated(message = "已废弃, 请用 com/obric/oui/dialog/v2 下面的版本")
public final class ButtonStyleController implements com.obric.oui.dialog.alert.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private OButton f6411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private OButton f6412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private OButton f6413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private OAlertDialog f6414d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f6415e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private FrameLayout f6416f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f6417g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f6418h;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/dialog/alert/ButtonStyleController$TextColorType;", "", "<init>", "(Ljava/lang/String;I)V", "TextReverse", "TextReverse2", "Negative", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum TextColorType extends Enum<TextColorType> {
        private static final /* synthetic */ TextColorType[] $VALUES = null;
        public static final TextColorType Negative = null;
        public static final TextColorType TextReverse = null;
        public static final TextColorType TextReverse2 = null;

        static {
            TextColorType r10 = new TextColorType("TextReverse", 0);
            TextReverse = r10;
            TextColorType r11 = new TextColorType("TextReverse2", 1);
            TextReverse2 = r11;
            TextColorType r12 = new TextColorType("Negative", 2);
            Negative = r12;
            $VALUES = new TextColorType[]{r10, r11, r12};
        }

        private TextColorType(String r10, int r11) {
            super(r10, r11);
        }

        public static TextColorType valueOf(String r10) {
            return (TextColorType) Enum.valueOf(TextColorType.class, r10);
        }

        public static TextColorType[] values() {
            return (TextColorType[]) $VALUES.clone();
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ButtonStyleController f6419c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f6420g;

        b(ButtonStyleController r10, CharSequence r11, TextColorType r12, DialogInterface.OnClickListener r13) {
            this.f6419c = r10;
            this.f6420g = r13;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            DialogInterface.OnClickListener r11 = this.f6420g;
            if (r11 == null) goto L5;
            r11.onClick(ButtonStyleController.c(this.f6419c), -2);
        L5:
            ButtonStyleController.d(this.f6419c);
        }
    }

    static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ButtonStyleController f6421c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f6422g;

        c(ButtonStyleController r10, CharSequence r11, TextColorType r12, DialogInterface.OnClickListener r13) {
            this.f6421c = r10;
            this.f6422g = r13;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            DialogInterface.OnClickListener r11 = this.f6422g;
            if (r11 == null) goto L5;
            r11.onClick(ButtonStyleController.c(this.f6421c), -3);
        L5:
            ButtonStyleController.d(this.f6421c);
        }
    }

    static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ButtonStyleController f6423c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f6424g;

        d(ButtonStyleController r10, CharSequence r11, boolean r12, TextColorType r13, DialogInterface.OnClickListener r14) {
            this.f6423c = r10;
            this.f6424g = r14;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            DialogInterface.OnClickListener r11 = this.f6424g;
            if (r11 == null) goto L5;
            r11.onClick(ButtonStyleController.c(this.f6423c), -1);
        L5:
            ButtonStyleController.d(this.f6423c);
        }
    }

    static {
        new a(null);
    }

    public ButtonStyleController(Context r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this.f6417g = r10;
        this.f6418h = r11;
    }

    public static final /* synthetic */ OAlertDialog c(ButtonStyleController r10) {
        return r10.f6414d;
    }

    public static final /* synthetic */ void d(ButtonStyleController r10) {
        r10.k();
    }

    private final void j(OButton r10, TextColorType r11) {
        if (r11 == null) goto L16;
        int r12 = com.obric.oui.dialog.alert.a.f6456a[r11.ordinal()];
        if (r12 != 1) goto L6;
        int r13 = u8.c.Negative;
    L14:
        r10.setTextColor(ContextCompat.getColor(r10.getContext(), r13));
        return;
    L6:
        if (r12 != 2) goto L8;
        r13 = u8.c.TextReverse;
        goto L14
    L8:
        if (r12 != 3) goto L11;
        r13 = u8.c.TextReverse2;
        goto L14
    L11:
        throw new NoWhenBranchMatchedException();
    }

    private final void k() {
        OAlertDialog r10 = this.f6414d;
        if (r10 != null) goto L5;
    L7:
        OAlertDialog r11 = this.f6414d;
        if (r11 == null) goto L11;
        r11.dismiss();
        return;
    L11:
        return;
    L5:
        if (r10.t() == true) goto L7;
    }

    @Override // com.obric.oui.dialog.alert.c
    public void a(Context r10, FrameLayout r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "parent");
        FrameLayout.LayoutParams r12 = new FrameLayout.LayoutParams(-1, -2);
        int r13 = this.f6418h;
        if (r13 != 0) goto L5;
        int r14 = h.o_dialog_button_horizontal;
    L9:
        View r15 = LayoutInflater.from(r10).inflate(r14, r11, false);
        r11.addView(r15, r12);
        this.f6415e = r15;
        if (r15 == null) goto L12;
        r15.setVisibility(8);
    L12:
        this.f6411a = (OButton) r15.findViewById(f.actionPositive);
        this.f6412b = (OButton) r15.findViewById(f.actionNegative);
        this.f6413c = (OButton) r15.findViewById(f.actionNeutral);
        this.f6416f = (FrameLayout) r15.findViewById(f.custom_container);
        return;
    L5:
        if (r13 == 1) goto L7;
        r14 = h.o_dialog_button_primary;
        goto L9
    L7:
        r14 = h.o_dialog_button_vertical;
        goto L9
    }

    @Override // com.obric.oui.dialog.alert.c
    public void b(OAlertDialog r10) {
        Intrinsics.checkNotNullParameter(r10, "dialog");
        this.f6414d = r10;
    }

    public final void e() {
    }

    public final void f(View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        if (this.f6418h == 2) goto L5;
        return;
    L5:
        if (this.f6416f == null) goto L17;
        View r11 = this.f6415e;
        if (r11 == null) goto L9;
        r11.setVisibility(0);
    L9:
        FrameLayout r12 = this.f6416f;
        if (r12 == null) goto L12;
        r12.addView(r10);
    L12:
        FrameLayout r13 = this.f6416f;
        if (r13 == null) goto L18;
        k.h(r13);
        return;
    L18:
        return;
    }

    public final void g(CharSequence r10, DialogInterface.OnClickListener r11, TextColorType r12) {
        OButton r13 = this.f6412b;
        if (r13 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r10) == false) goto L8;
        r13.setVisibility(8);
        return;
    L8:
        View r14 = this.f6415e;
        if (r14 == null) goto L11;
        r14.setVisibility(0);
    L11:
        r13.setText(r10);
        j(r13, r12);
        r13.setVisibility(0);
        r13.setOnClickListener(new b(this, r10, r12, r11));
    }

    public final void h(CharSequence r10, DialogInterface.OnClickListener r11, TextColorType r12) {
        OButton r13 = this.f6413c;
        if (r13 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r10) == false) goto L8;
        r13.setVisibility(8);
        return;
    L8:
        View r14 = this.f6415e;
        if (r14 == null) goto L11;
        r14.setVisibility(0);
    L11:
        r13.setText(r10);
        j(r13, r12);
        r13.setVisibility(0);
        r13.setOnClickListener(new c(this, r10, r12, r11));
    }

    public final void i(CharSequence r10, DialogInterface.OnClickListener r11, TextColorType r12, boolean r13) {
        OButton r14 = this.f6411a;
        if (r14 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r10) == false) goto L8;
        r14.setVisibility(8);
        return;
    L8:
        View r15 = this.f6415e;
        if (r15 == null) goto L11;
        r15.setVisibility(0);
    L11:
        if (r13 == false) goto L13;
        r14.setBackgroundTintList(ContextCompat.getColorStateList(this.f6417g, u8.c.oui_red_6));
        r14.setTextColor(ContextCompat.getColor(this.f6417g, u8.c.white));
    L13:
        r14.setText(r10);
        j(r14, r12);
        r14.setVisibility(0);
        r14.setOnClickListener(new d(this, r10, r13, r12, r11));
    }
}
