package com.obric.update.impl.v2.handler;

import com.larus.utils.logger.FLogger;
import com.ss.android.update.OnUpdateStatusChangedListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class h implements OnUpdateStatusChangedListener {
    public final /* synthetic */ f a;

    public h(f r1) {
        this.a = r1;
    }

    @Override // yhc.i
    public final void b(boolean r4) {
        FLogger.a.i("ObricInitHandler", "sdk onPrepare pre:" + r4);
    }

    @Override // com.ss.android.update.OnUpdateStatusChangedListener
    public final void c(int r4) {
        FLogger.a.i("ObricInitHandler", "sdk onUpdateStatusChanged status:" + r4);
        this.a.b.invoke(Integer.valueOf(r4));
    }

    @Override // yhc.i
    public final void a(boolean r4, boolean r5) {
        FLogger.a.i("ObricInitHandler", "sdk downloadResult isSuccess:" + r4 + ",pre:" + r5);
        this.a.d.invoke(Boolean.valueOf(r4), Boolean.valueOf(r5));
    }

    @Override // yhc.i
    public final void e(int r4, boolean r5) {
        FLogger.a.i("ObricInitHandler", "sdk saveDownloadInfo size:" + r4 + ",etag:,pre:" + r5);
    }

    @Override // yhc.i
    public final void d(int r4, int r5, boolean r6) {
        FLogger.a.i("ObricInitHandler", "sdk updateProgress byteSoFar:" + r4 + ",contentLength:" + r5 + ",pre:" + r6);
        this.a.c.invoke(Integer.valueOf(r4), Integer.valueOf(r5), Boolean.valueOf(r6));
    }
}
