package com.larus.dora.o.impl.memory;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.InputFilter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.sheet.v2.OSheetBase;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class l {
    public final Context a;
    public final Function1<String, Unit> b;
    public final OSheet c;
    public EditText d;
    public TextView e;

    public static final class a {
    }

    static {
    }

    public final void c() {
        OSheet r0 = this.c;
        if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r0);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r0);
        r0.show();
        DialogLancet.afterDialogShow(r0);
    }

    public static void a(OSheet r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static final int b(l r1, int r2) {
        Resources r3 = r1.a.getResources();
        return (int) ((WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density * r2) + 0.5f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(Context r12, String r13, Function1<? super String, Unit> r14) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r14, "onSave");
        this.a = r12;
        this.b = r14;
        int r10 = 0;
        final OSheet r15 = new OSheet(r12, 0, false, 30);
        this.c = r15;
        OSheetBase.DefaultImpls.q(r15, OSheet.HeightMode.WRAP_HEIGHT);
        OSheet.Header r2 = OSheet.Header.ACTION;
        if (r13 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        int r3 = 2131902518;
    L12:
        OSheetBase.DefaultImpls.o(r15, r2, Integer.valueOf(r3), null, null, true, new j(r15), new k(this, r15), 16156);
        LinearLayout r4 = new LinearLayout(r12);
        r4.setOrientation(1);
        r4.setPadding(b(this, 12), b(this, 8), b(this, 12), b(this, 16));
        LinearLayout r5 = new LinearLayout(r12);
        r5.setOrientation(1);
        r5.setBackground(ContextCompat.getDrawable(r5.getContext(), 2131233936));
        r5.setPadding(b(this, 20), b(this, 16), b(this, 20), b(this, 16));
        r5.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        EditText r6 = new EditText(r12);
        r6.setLayoutParams(new LinearLayout.LayoutParams(-1, b(this, 132)));
        r6.setBackground(null);
        r6.setPadding(0, 0, 0, 0);
        r6.setGravity(48);
        r6.setInputType(131073);
        r6.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(300)});
        r6.setTextSize(16.0f);
        r6.setTextColor(ContextCompat.getColor(r6.getContext(), 2131101368));
        r6.setHintTextColor(ContextCompat.getColor(r6.getContext(), 2131101370));
        r6.setHint(r6.getContext().getString(2131903457));
        if (r13 != null) goto L15;
        r13 = "";
    L15:
        r6.setText(r13);
        Editable r16 = r6.getText();
        if (r16 == null) goto L18;
        int r17 = r16.length();
    L19:
        r6.setSelection(r17);
        this.d = r6;
        FrameLayout r18 = new FrameLayout(r12);
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-1, -2);
        r0.topMargin = b(this, 6);
        r18.setLayoutParams(r0);
        TextView r7 = new TextView(r12);
        FrameLayout.LayoutParams r110 = new FrameLayout.LayoutParams(-2, -2);
        r110.gravity = 8388613;
        r7.setLayoutParams(r110);
        r7.setTextSize(10.0f);
        r7.setTextColor(ContextCompat.getColor(r7.getContext(), 2131101369));
        this.e = r7;
        r18.addView(r7);
        Editable r111 = r6.getText();
        if (r111 == null) goto L22;
        r10 = r111.length();
    L22:
        TextView r112 = this.e;
        if (r112 == null) goto L25;
        r112.setText(r10 + "/300");
    L25:
        r6.addTextChangedListener(new m(this));
        r5.addView(r6);
        r5.addView(r18);
        r4.addView(r5);
        OSheetBase.DefaultImpls.j(r15, r4);
        return;
    L18:
        r17 = 0;
        goto L19
    L11:
        r3 = 2131903461;
        goto L12
    L5:
        if (r13.length() == 0) goto L8;
        r1 = false;
        goto L9
    }
}
