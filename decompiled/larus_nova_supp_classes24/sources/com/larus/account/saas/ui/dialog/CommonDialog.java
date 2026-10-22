package com.larus.account.saas.ui.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.larus.account.saas.ui.internal.DimensExtKt;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import h48.a;
import h48.b;
import h48.c;
import h48.d;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/account/saas/ui/dialog/CommonDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "account-saas-ui-android_release"}, k = 1, mv = {1, 7, 1})
public final class CommonDialog extends DialogFragment {
    public static final /* synthetic */ int x = 0;
    public CharSequence d;
    public boolean e;
    public CharSequence f;
    public Integer g;
    public Integer h;
    public String i;
    public int j;
    public boolean k;
    public d l;
    public d m;
    public boolean n;
    public String o;
    public int p;
    public boolean q;
    public boolean r;
    public a s;
    public boolean t;
    public DialogInterface.OnDismissListener u;
    public boolean v;
    public boolean w;

    public CommonDialog() {
        this.e = true;
        this.n = true;
        this.r = true;
        this.t = true;
        this.v = true;
        this.w = true;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        Dialog r0 = getDialog();
        if (r0 == null) goto L11;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L12;
        r1.setLayout(-1, -2);
        WindowManager.LayoutParams r2 = r1.getAttributes();
        Resources r3 = r1.getWindowStyle().getResources();
        int r4 = WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).widthPixels - (((Number) DimensExtKt.c.getValue()).intValue() * 2);
        r2.width = r4;
        Lazy r5 = DimensExtKt.d;
        if (r4 <= ((Number) r5.getValue()).intValue()) goto L9;
        r2.width = ((Number) r5.getValue()).intValue();
    L9:
        r1.setAttributes(r2);
        return;
    L12:
        return;
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L7
        super.onDismiss(r2);     // Catch: Throwable -> L7
        DialogInterface.OnDismissListener r0 = this.u;     // Catch: Throwable -> L7
        if (r0 == null) goto L5;
        r0.onDismiss(r2);     // Catch: Throwable -> L7
    L5:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L7:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r9, r10);
        TextView r11 = (TextView) r9.findViewById(2131368982);
        TextView r0 = (TextView) r9.findViewById(2131368971);
        TextView r1 = (TextView) r9.findViewById(2131364643);
        View r2 = r9.findViewById(2131369197);
        TextView r12 = (TextView) r9.findViewById(2131364689);
        r11.setText(this.d);
        CharSequence r3 = this.d;
        boolean r4 = true;
        if (r3 != null) goto L5;
    L8:
        boolean r5 = true;
    L10:
        if (r5 == false) goto L13;
        r11.setVisibility(8);
        LinearLayout.LayoutParams r13 = new LinearLayout.LayoutParams(-1, -2);
        r13.topMargin = ((Number) DimensExtKt.b.getValue()).intValue();
        Lazy r6 = DimensExtKt.a;
        r13.leftMargin = ((Number) r6.getValue()).intValue();
        r13.rightMargin = ((Number) r6.getValue()).intValue();
        r0.setLayoutParams(r13);
    L13:
        if (this.e == false) goto L15;
        int r14 = 0;
    L16:
        r0.setVisibility(r14);
        r0.setText(this.f);
        if ((this.f instanceof SpannableString) == false) goto L19;
        r0.setMovementMethod(LinkMovementMethod.getInstance());
        r0.setHighlightColor(0);
    L19:
        Integer r15 = this.g;
        if (r15 == null) goto L22;
        r0.setTextColor(r15.intValue());
    L22:
        Integer r16 = this.h;
        if (r16 == null) goto L26;
        r0.setGravity(r16.intValue());
    L26:
        if (this.r == true) goto L28;
        r1.setVisibility(8);
        r2.setVisibility(8);
        r12.setBackgroundResource(2131231198);
    L44:
        String r17 = this.i;
        if (r17 != null) goto L47;
    L50:
        if (r4 == true) goto L52;
        r12.setText(this.i);
    L52:
        int r19 = this.j;
        if (r19 == 0) goto L56;
        r12.setTextColor(r19);
    L56:
        if (this.k == false) goto L58;
        r12.setTypeface(Typeface.create("sans-serif-medium", 0));
    L58:
        r12.setOnClickListener(new b(this));
        Dialog r20 = getDialog();
        if (r20 == null) goto L62;
        r20.setCanceledOnTouchOutside(this.v);
        r20.setCancelable(this.w);
        return;
    L62:
        return;
    L47:
        if (r17.length() == 0) goto L50;
        r4 = false;
        goto L50
    L28:
        String r110 = this.o;
        if (r110 != null) goto L31;
    L34:
        boolean r111 = true;
    L35:
        if (r111 == true) goto L37;
        r1.setText(this.o);
    L37:
        int r112 = this.p;
        if (r112 == 0) goto L41;
        r1.setTextColor(r112);
    L41:
        if (this.q == false) goto L43;
        r1.setTypeface(Typeface.DEFAULT_BOLD);
    L43:
        r1.setOnClickListener(new c(this));
        goto L44
    L31:
        if (r110.length() == 0) goto L34;
        r111 = false;
        goto L35
    L15:
        r14 = 8;
        goto L16
    L5:
        if (r3.length() == 0) goto L8;
        r5 = false;
        goto L10
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Dialog r6 = getDialog();
        if (r6 == null) goto L8;
        Window r7 = r6.getWindow();
        if (r7 == null) goto L8;
        r7.setBackgroundDrawable(new ColorDrawable(0));
    L8:
        return r3.inflate(2131558434, r4, false);
    }
}
