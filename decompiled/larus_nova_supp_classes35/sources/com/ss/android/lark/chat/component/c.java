package com.ss.android.lark.chat.component;

import android.content.Intent;
import android.os.Bundle;
import com.ss.android.lark.chat.chatwindow.biz.plugin.NewIntentScrollMessagePlugin$newIntentHandler$2;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.platform.dispatcher.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements h {
    public final /* synthetic */ com.ss.android.lark.chat.chatwindow.chat.v2.component.c.d a;

    public c(NewIntentScrollMessagePlugin$newIntentHandler$2.a r1) {
        this.a = r1;
    }

    public final void A0(Intent r2) {
        if (r2 == null) goto L6;
        Bundle r3 = r2.getExtras();
        if (r3 == null) goto L6;
        fxa.b r4 = fxa.a.a(r3);
    L7:
        if (r4 != null) goto L10;
        Log.w("ChatDependencyComponent", "chatBundle == null");
        return;
    L10:
        this.a.a(r4);
        return;
    L6:
        r4 = null;
        goto L7
    }
}
