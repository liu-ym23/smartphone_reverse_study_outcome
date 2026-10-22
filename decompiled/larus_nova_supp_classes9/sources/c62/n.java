package c62;

import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n implements vlc.l {
    public final long a;
    public final vlc.l b;

    public final void onMessage(tlc.d r6) {
        if (o.b(r6) != this.a) goto L6;
        this.b.onMessage(r6);
        return;
    }

    public n(long r2, com.bytedance.android.livesdk.interactivity.chatchannel.manager.c r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.a = r2;
        this.b = r4;
    }
}
