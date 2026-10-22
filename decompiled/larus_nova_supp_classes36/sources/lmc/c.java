package lmc;

import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.ugc.live.sdk.msg.utils.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c extends PthreadHandlerThreadV2 {
    public final /* synthetic */ a c;

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLooperPrepared() {
        super/*android.os.HandlerThread*/.onLooperPrepared();
        a r0 = this.c;
        r0.c = new i(getLooper(), this.c);
        a r1 = this.c;
        r1.d = new i(getLooper(), this.c);
        a r2 = this.c;
        r2.e = new i(getLooper(), this.c);
    }

    public c(a r1) {
        this.c = r1;
        super("UplinkClient");
    }
}
