package com.larus.bmhome.chat.standarduikit.localfileblock.viewmodel;

import android.app.Application;
import android.content.Context;
import com.larus.common.apphost.AppHost;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ int b;

    public /* synthetic */ d(Context r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context r0 = this.a;
        int r1 = this.b;
        s r2 = s.a;
        Application r3 = AppHost.a.getApplication();
        String r4 = r0.getString(r1);
        r2.getClass();
        s.c(r3, r4);
    }
}
