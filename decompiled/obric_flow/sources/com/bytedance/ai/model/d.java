package com.bytedance.ai.model;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class d implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2236a;

    public /* synthetic */ d(int r5) {
        this.f2236a = r5;
    }

    private final void a(DialogInterface r5, int r10) {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r5, int r10) {
        switch(this.f2236a) {
            case 0: goto L7;
            case 1: goto L5;
            default: goto L4;
        };
    L4:
        return;
    L5:
        int r11 = AppletRuntime.f2196x;
        r5.dismiss();
        return;
    L7:
        int r12 = AppletRuntime.f2196x;
        r5.dismiss();
    }
}
