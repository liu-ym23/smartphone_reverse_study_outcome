package com.ss.android.lark.filedetail.impl.detail;

import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.lark.officesdk.integrator.mock.FileDetailModuleDependencyMock;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class u implements DialogInterface.OnClickListener {
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;
    public final /* synthetic */ FileTransmissionPresenter c;

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r3, int r4) {
        ytb.g r5 = this.c.c.getBrowserDependency();
        Context r0 = this.a;
        String r1 = this.b;
        r5.getClass();
        FileDetailModuleDependencyMock.g(r0, r1);
        r3.dismiss();
    }

    public u(FileTransmissionPresenter r1, Context r2, String r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
