package com.ss.android.lark.chameleonv2.debug;

import android.content.DialogInterface;
import android.text.Editable;
import android.widget.EditText;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k implements DialogInterface.OnClickListener {
    public final /* synthetic */ EditText a;
    public final /* synthetic */ EditText b;

    public k(EditText r1, EditText r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        Editable r4 = this.a.getText();
        String r5 = BuildConfig.FLAVOR;
        if (r4 == null) goto L8;
        String r6 = r4.toString();
        if (r6 == null) goto L8;
        String r7 = StringsKt.trim(r6).toString();
        if (r7 == null) goto L8;
    L9:
        CmlDebugSettingUtil.b("chameleon_header_username", r7);
        Editable r8 = this.b.getText();
        if (r8 == null) goto L17;
        String r9 = r8.toString();
        if (r9 == null) goto L17;
        String r10 = StringsKt.trim(r9).toString();
        if (r10 == null) goto L17;
        r5 = r10;
    L17:
        CmlDebugSettingUtil.b("chameleon_header_pwd", r5);
        return;
    L8:
        r7 = BuildConfig.FLAVOR;
        goto L9
    }
}
