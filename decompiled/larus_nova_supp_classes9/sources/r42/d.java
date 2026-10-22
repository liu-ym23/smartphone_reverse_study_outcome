package r42;

import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ vlc.m a;

    public d(com.bytedance.android.livesdk.interactivity.publicscreen.repository.first.g r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        com.ss.ugc.live.sdk.msg.utils.g.c r3 = (com.ss.ugc.live.sdk.msg.utils.g) r2;
        if ((r3 instanceof com.ss.ugc.live.sdk.msg.utils.g.c) == false) goto L6;
        List r4 = (List) r3.b;
        this.a.a(r4);
        return;
    L6:
        if ((r3 instanceof com.ss.ugc.live.sdk.msg.utils.g.b) == false) goto L10;
        Throwable r5 = ((com.ss.ugc.live.sdk.msg.utils.g.b) r3).b;
        this.a.b(r5);
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
