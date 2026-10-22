package c91;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.q0;
import com.bytedance.android.livesdk.message.model.j4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m extends q0 {
    public final /* synthetic */ a a;
    public final /* synthetic */ j4 b;

    public final void h(py.k r1, int r2, int r3) {
    }

    public final void g(py.k r2) {
        this.a.g.setVisibility(0);
    }

    public m(a r1, j4 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void f(py.k r3, Exception r4) {
        this.a.g.setVisibility(8);
        ALogger.e("gift_exhibition", "load light animation gift model failed,msg id = " + this.b.getMessageId());
    }
}
