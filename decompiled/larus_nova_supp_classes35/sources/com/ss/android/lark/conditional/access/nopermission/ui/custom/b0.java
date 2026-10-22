package com.ss.android.lark.conditional.access.nopermission.ui.custom;

import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.lark.pb.security.v1.CustomDisplayHandler;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ a a;
    public final /* synthetic */ CustomDisplayHandler b;
    public final /* synthetic */ InternalSecurityAction c;
    public final /* synthetic */ Context d;

    public b0(a r1, CustomDisplayHandler r2, InternalSecurityAction r3, Context r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r3, int r4) {
        this.a.dL(this.b, this.c, this.d);
    }
}
