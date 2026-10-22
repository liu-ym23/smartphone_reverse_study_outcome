package qr1;

import com.bytedance.android.live.livepullstream.api.apm.APMEvent;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements Observer<Boolean> {
    public final /* synthetic */ i a;

    public c(i r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Boolean r0 = Boolean.TRUE;
        if (r0.equals((Boolean) r3) == false) goto L6;
        this.a.c(com.bytedance.android.live.livepullstream.api.apm.a.a(APMEvent.Level.I, "playing state ready"));
        return;
    }
}
