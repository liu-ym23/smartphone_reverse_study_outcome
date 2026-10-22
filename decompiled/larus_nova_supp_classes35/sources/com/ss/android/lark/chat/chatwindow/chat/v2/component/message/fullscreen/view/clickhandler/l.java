package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l implements View.OnClickListener {
    public final c a;

    public final c getContext() {
        return this.a;
    }

    public l(c r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        Fragment r3 = this.a.b;
        if (r3.isAdded() == false) goto L11;
        com.suite.lark.component.navroute.forseti.g r0 = com.suite.lark.component.navroute.forseti.f.b(r3);
        if (r0 == null) goto L7;
        r0.g(null);
        return;
    L7:
        FragmentActivity r4 = r3.getActivity();
        if (r4 == null) goto L13;
        r4.finish();
        return;
    L13:
        return;
    }
}
