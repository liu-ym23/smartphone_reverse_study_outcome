package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ SelectedMsgViewManager a;

    public f(SelectedMsgViewManager r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        o42.d r3 = (o42.d) r2;
        SelectedMsgViewManager r4 = this.a;
        if (r4.c == true) goto L6;
        return;
    L6:
        if (r4.d().d() == false) goto L9;
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r5 = SelectedMsgViewManager.m;
        Boolean r0 = Boolean.TRUE;
        r5.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r5, r0);
        return;
    }
}
