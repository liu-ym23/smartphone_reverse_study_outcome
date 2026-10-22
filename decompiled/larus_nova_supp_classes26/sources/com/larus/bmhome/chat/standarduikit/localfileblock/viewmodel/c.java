package com.larus.bmhome.chat.standarduikit.localfileblock.viewmodel;

import android.app.Application;
import com.larus.common.apphost.AppHost;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class c implements Runnable {
    public /* synthetic */ c() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        s r0 = s.a;
        Application r1 = AppHost.a.getApplication();
        r0.getClass();
        s.c(r1, "文件已不存在");
    }
}
