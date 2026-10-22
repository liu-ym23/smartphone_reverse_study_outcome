package com.bytedance.android.live.platformplayer.layout;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.HSImageView;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f1 extends com.bytedance.android.live.core.utils.q0 {
    public final /* synthetic */ List a;
    public final /* synthetic */ LivePlayerWidget b;
    public final /* synthetic */ HSImageView c;

    public final void f(py.k r4, Exception r5) {
        LivePlayerWidget r6 = this.b;
        int r0 = LivePlayerWidget.V2;
        r6.Pq();
        this.c.setBackgroundResource(2131251156);
        ALogger.d(this.b.y, "setSmoothBackground load video background fail, url = " + this.a + ", error = " + r5.getMessage() + ", roomId = " + this.b.U2.x());
    }

    public f1(List r1, LivePlayerWidget r2, HSImageView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void h(py.k r3, int r4, int r5) {
        LivePlayerWidget r6 = this.b;
        int r7 = LivePlayerWidget.V2;
        r6.Pq();
        ALogger.d(this.b.y, "setSmoothBackground load video background success, url = " + this.a + ", roomId = " + this.b.U2.x());
    }
}
