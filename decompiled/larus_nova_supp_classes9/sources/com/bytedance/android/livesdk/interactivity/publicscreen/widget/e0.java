package com.bytedance.android.livesdk.interactivity.publicscreen.widget;

import com.bytedance.android.live.core.log.ALogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e0 implements v92.a {
    public final /* synthetic */ TextMessageWidget a;

    @Override // v92.a
    public final void preload() {
        ALogger.i("HistoryMessageDebug", "hasPullDown = " + this.a.O);
        TextMessageWidget r0 = this.a;
        if (r0.r != null) goto L5;
        return;
    L5:
        if (r0.O == false) goto L9;
        ALogger.i("HistoryMessageDebug", "用户手动下拉触发预加载");
        this.a.r.a();
        return;
    }

    public e0(TextMessageWidget r1) {
        this.a = r1;
    }
}
