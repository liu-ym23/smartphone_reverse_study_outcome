package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen;

import androidx.lifecycle.Observer;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i<T> implements Observer {
    public final /* synthetic */ MessageFullScreenFragment a;

    public i(MessageFullScreenFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Log.e("MessageFullScreenFragment", "finish page reason: " + ((ErrorResult) r3).getDebugMsg());
        com.suite.lark.component.navroute.forseti.g r4 = com.suite.lark.component.navroute.forseti.f.b(this.a);
        if (r4 == null) goto L5;
        r4.g(null);
        return;
    L5:
        this.a.finish();
    }
}
