package com.ss.android.lark.chameleonv2.debug;

import android.app.AlertDialog;
import android.preference.Preference;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements Preference.OnPreferenceClickListener {
    public final /* synthetic */ ChameleonDebugActivity a;

    public d(ChameleonDebugActivity r1) {
        this.a = r1;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public final boolean onPreferenceClick(Preference r10) {
        ChameleonDebugActivity r11 = this.a;
        r11.a.getClass();
        Intrinsics.checkNotNullParameter(r11, "context");
        String r0 = CmlDebugSettingUtil.a("chameleon_header_username", BuildConfig.FLAVOR);
        String r1 = CmlDebugSettingUtil.a("chameleon_header_pwd", BuildConfig.FLAVOR);
        TextView r2 = new TextView(r11);
        r2.setText("账号");
        EditText r3 = new EditText(r11);
        boolean r5 = false;
        if (r0.length() <= 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L8;
        r3.setText(r0);
        r3.setSelection(r0.length());
    L8:
        r3.setPadding(16, 16, 16, 16);
        TextView r6 = new TextView(r11);
        r6.setText("密码");
        EditText r7 = new EditText(r11);
        if (r1.length() <= 0) goto L11;
        r5 = true;
    L11:
        if (r5 == false) goto L13;
        r7.setText(r1);
        r7.setSelection(r1.length());
    L13:
        r7.setPadding(16, 16, 16, 16);
        LinearLayout r8 = new LinearLayout(r11);
        r8.setOrientation(1);
        r8.setPadding(32, 16, 32, 16);
        r8.addView(r2);
        r8.addView(r3);
        r8.addView(r6);
        r8.addView(r7);
        new AlertDialog.Builder(r11).setTitle("配置header下载鉴权").setView(r8).setPositiveButton("保存", new k(r3, r7)).setNegativeButton("取消", null).show();
        return true;
    L5:
        r4 = false;
        goto L6
    }
}
