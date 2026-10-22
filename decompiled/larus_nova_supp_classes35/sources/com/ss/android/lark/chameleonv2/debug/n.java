package com.ss.android.lark.chameleonv2.debug;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class n implements DialogInterface.OnClickListener {
    public final /* synthetic */ AutoCompleteTextView a;
    public final /* synthetic */ EditText b;
    public final /* synthetic */ f c;
    public final /* synthetic */ Context d;
    public final /* synthetic */ Function0<Unit> e;

    public n(AutoCompleteTextView r1, EditText r2, f r3, ChameleonDebugActivity r4, Function0 r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r4, int r5) {
        String r6 = StringsKt.trim(this.a.getText().toString()).toString();
        String r7 = StringsKt.trim(this.b.getText().toString()).toString();
        boolean r1 = false;
        if (r6.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        CmlDebugSettingUtil.b("chameleon_ip_proxy_bizname", r6);
    L9:
        if (r7.length() <= 0) goto L11;
        r1 = true;
    L11:
        if (r1 == false) goto L13;
        CmlDebugSettingUtil.b("chameleon_ip_proxy_url", r7);
    L13:
        f.a(this.c, this.d, "保存成功，请前往指定页面调试");
        Function0<Unit> r8 = this.e;
        if (r8 == null) goto L17;
        r8.invoke();
        return;
    L17:
        return;
    L5:
        r0 = false;
        goto L6
    }
}
