package com.ss.android.lark.chat.chatwindow.chat.menu.handler;

import android.content.DialogInterface;
import com.ss.android.lark.im.sdk.service.ImSdkService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final /* synthetic */ class s implements DialogInterface.OnClickListener {
    public final /* synthetic */ t a;
    public final /* synthetic */ y6b.a b;
    public final /* synthetic */ Boolean c;

    public /* synthetic */ s(t r1, y6b.a r2, Boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r5, int r6) {
        final t r7 = this.a;
        final y6b.a r8 = this.b;
        Boolean r0 = this.c;
        r7.getClass();
        if (r8.h() == true) goto L9;
        if (r0 != null) goto L6;
    L8:
        boolean r1 = false;
    L10:
        ImSdkService.f().B8(r8.getId(), r1, new RecallMenuHandler$1(r7, r8));
        return;
    L6:
        if (r0.booleanValue() == false) goto L8;
    L9:
        r1 = true;
        goto L10
    }
}
