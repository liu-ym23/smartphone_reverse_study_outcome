package com.bytedance.android.live.platformplayer.layout;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.HSImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d1 extends com.bytedance.android.live.core.utils.q0 {
    public final /* synthetic */ LivePlayerWidget a;
    public final /* synthetic */ HSImageView b;

    public d1(LivePlayerWidget r1, HSImageView r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void f(py.k r3, Exception r4) {
        LivePlayerWidget r5 = this.a;
        int r0 = LivePlayerWidget.V2;
        r5.Pq();
        this.b.setBackgroundResource(2131251156);
        ALogger.d("ServerBlur", "[game] server setSmoothBackground load video background fail, url = " + this.a.U2.q() + ", error = " + r4.getMessage() + ", roomId = " + this.a.U2.x());
    }

    public final void h(py.k r1, int r2, int r3) {
        LivePlayerWidget r4 = this.a;
        int r5 = LivePlayerWidget.V2;
        r4.Pq();
        ALogger.d("ServerBlur", "[game] server setSmoothBackground load video background success, url = " + this.a.U2.q() + ", roomId = " + this.a.U2.x());
    }
}
