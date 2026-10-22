package com.ss.android.lark.filedetail.impl.folder.manage.page.extract_package;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.larksuite.framework.callback.Entity.ErrorResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a<T> implements Observer {
    public final /* synthetic */ ExtractPackageFragment a;

    public a(ExtractPackageFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r11) {
        ErrorResult r12 = (ErrorResult) r11;
        Intrinsics.checkNotNullParameter(r12, "state");
        Context r0 = this.a.requireContext();
        int r1 = r12.getCode();
        if (r1 == 0) goto L60;
        TextView r3 = null;
        if (r1 != 5610) goto L8;
    L22:
        ExtractPackageFragment r2 = this.a;
        View r4 = r2.v;
        if (r4 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("packageCleanedLayout");
        r4 = null;
    L25:
        r2.r = r4;
        TextView r5 = this.a.w;
        if (r5 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("fileName");
        r5 = null;
    L28:
        r5.setText(this.a.d.h);
        this.a.e.c();
        String r13 = r12.getDisplayMsg(r0.getString(2131891107));
    L29:
        boolean r6 = false;
        if (r13 != null) goto L32;
    L49:
        int r14 = pfb.d.a;
        String r15 = this.a.d.b;
        if (r15 != null) goto L52;
    L53:
        r6 = true;
    L54:
        if (r6 == true) goto L57;
        pfb.d.a.b(r15, "im_file_decompress_fail_time_out_view", null);
    L57:
        ExtractPackageFragment.U90(this.a, false, false, false, true, 7);
        return;
    L52:
        if (r15.length() != 0) goto L54;
    L32:
        if (r13.length() <= 0) goto L34;
        boolean r7 = true;
    L35:
        if (r7 == false) goto L49;
        int r8 = pfb.d.a;
        String r9 = this.a.d.b;
        if (r9 != null) goto L39;
    L40:
        r6 = true;
    L41:
        if (r6 == true) goto L44;
        pfb.d.a.b(r9, "im_file_decompress_fail_not_support_view", null);
    L44:
        TextView r10 = this.a.s;
        if (r10 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("failedTip");
    L48:
        r3.setText(r13);
        ExtractPackageFragment.U90(this.a, false, false, true, false, 11);
        return;
    L47:
        r3 = r10;
        goto L48
    L39:
        if (r9.length() != 0) goto L41;
    L34:
        r7 = false;
        goto L35
    L8:
        if (r1 == 5611) goto L22;
        if (r1 != 311123) goto L12;
    L21:
        r13 = r12.getDisplayMsg(r0.getString(2131891053));
        goto L29
    L12:
        if (r1 == 311125) goto L21;
        switch(r1) {
            case 5657: goto L20;
            case 5658: goto L19;
            case 5659: goto L18;
            case 5660: goto L17;
            case 5661: goto L16;
            case 5662: goto L15;
            default: goto L14;
        };
    L14:
        r13 = null;
        goto L29
    L15:
        r13 = r0.getString(2131890907);
        goto L29
    L16:
        r13 = r0.getString(2131890905);
        goto L29
    L17:
        r13 = r0.getString(2131890903);
        goto L29
    L18:
        r13 = r0.getString(2131890904);
        goto L29
    L19:
        r13 = r0.getString(2131890906);
        goto L29
    L20:
        r13 = r0.getString(2131890902);
        goto L29
    }
}
