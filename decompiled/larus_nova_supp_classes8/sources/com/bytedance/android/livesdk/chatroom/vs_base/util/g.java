package com.bytedance.android.livesdk.chatroom.vs_base.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.foundation.depend.OnBindPhoneListener;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g {
    public static void a(Activity r7, OnBindPhoneListener r8, View.OnClickListener r9) {
        AlertDialog.Builder r0 = new AlertDialog.Builder(r7);
        SpannableString r1 = new SpannableString(r7.getString(2131922073));
        r1.setSpan(new ForegroundColorSpan(r7.getResources().getColor(2131108182)), 1, 16, 33);
        TextView r2 = new TextView(r7);
        r2.setTextSize(1, 18.0f);
        r2.setText(r1);
        r2.setPadding(s1.f(30.0f), s1.f(20.0f), s1.f(30.0f), s1.f(10.0f));
        r2.setTextColor(-16777216);
        r2.setOnClickListener(r9);
        r0.setCustomTitle(r2).setNegativeButton(2131922071, new f()).setPositiveButton(2131922072, new e(r7, r8)).setCancelable(false);
        AlertDialog r10 = r0.create();
        if (DialogLancet.shouldBlockDialogShow(r10) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r10);
    L7:
        r10.getButton(-1).setTextColor(r7.getResources().getColor(2131108182));
        r10.getButton(-2).setTextColor(r7.getResources().getColor(2131107654));
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(r10);
        r10.show();
        DialogLancet.afterDialogShow(r10);
        goto L7
    }
}
