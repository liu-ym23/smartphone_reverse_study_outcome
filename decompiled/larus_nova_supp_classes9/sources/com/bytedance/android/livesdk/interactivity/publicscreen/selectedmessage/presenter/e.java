package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ SelectedMsgViewManager a;

    public e(SelectedMsgViewManager r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        o42.b r4 = (o42.b) r3;
        SelectedMsgViewManager r0 = this.a;
        if (r0.c == false) goto L7;
        r0.d().onEvent(r4);
        return;
    }
}
