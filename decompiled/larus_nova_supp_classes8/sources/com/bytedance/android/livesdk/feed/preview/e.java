package com.bytedance.android.livesdk.feed.preview;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e implements Runnable {
    public final /* synthetic */ LiveFeedPreview a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;

    public e(LiveFeedPreview r1, int r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    L16:
        return;
    L3:
        if (this.a.b() != null) goto L5;
        return;
    L5:
        if (this.a.b().getVisibility() != 0) goto L15;
        this.a.b().setVideoSize(this.b, this.c);     // Catch: Throwable -> L8
        return;
    }
}
