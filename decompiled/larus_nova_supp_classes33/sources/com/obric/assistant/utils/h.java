package com.obric.assistant.utils;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class h implements Executor {
    public final /* synthetic */ Handler a;

    public /* synthetic */ h(Handler r1) {
        this.a = r1;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r2) {
        this.a.post(r2);
    }
}
