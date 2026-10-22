package com.larus.dora.o.impl.diary.style;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.larus.common.baidunavi.api.bean.consts.BaiduNaviStatus;
import com.larus.dora.o.impl.databinding.DoraODialogDiaryStyleInputBinding;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.sheet.v2.OSheetBase;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b0 {
    public static final /* synthetic */ int e = 0;
    public final Function3<String, String, Function1<? super Boolean, Unit>, Unit> a;
    public final OSheet b;
    public final DoraODialogDiaryStyleInputBinding c;
    public boolean d;

    public static final class a {
    }

    static {
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

    public final void b(Context r4, int r5) {
        this.c.c.setText(r4.getString(2131903424, new Object[]{Integer.valueOf(r5), Integer.valueOf(BaiduNaviStatus.WRONG_AK_PARAM)}));
    }

    public b0(final Context r11, int r12, String r13, String r14, v r15) {
        this.a = r15;
        int r1 = 0;
        final OSheet r16 = new OSheet(r11, 0, false, 30);
        this.b = r16;
        View r0 = LayoutInflater.from(r11).inflate(2131560141, null, false);
        int r2 = 2131387504;
        EditText r3 = (EditText) ViewBindings.findChildViewById(r0, 2131387504);
        if (r3 == null) goto L18;
        r2 = 2131387505;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r0, 2131387505);
        if (r4 == null) goto L18;
        r2 = 2131387506;
        EditText r5 = (EditText) ViewBindings.findChildViewById(r0, 2131387506);
        if (r5 == null) goto L18;
        LinearLayout r9 = (LinearLayout) r0;
        this.c = new DoraODialogDiaryStyleInputBinding(r9, r3, r4, r5);
        r3.setText(r13);
        r5.setText(r14);
        Editable r17 = r5.getText();
        if (r17 == null) goto L11;
        int r18 = r17.length();
    L12:
        r5.setSelection(r18);
        Editable r110 = r5.getText();
        if (r110 == null) goto L15;
        r1 = r110.length();
    L15:
        b(r11, r1);
        r5.addTextChangedListener(new a0(this, r11));
        OSheetBase.DefaultImpls.q(r16, OSheet.HeightMode.WRAP_HEIGHT);
        OSheetBase.DefaultImpls.o(r16, OSheet.Header.ACTION, Integer.valueOf(r12), null, null, true, new w(r16), new x(this, r11, r16), 16156);
        OSheetBase.DefaultImpls.j(r16, r9);
        return;
    L11:
        r18 = 0;
    L18:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r2)));
    }
}
