package xe0;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.linkbase.api.MediaOperation;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ a a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;
    public final /* synthetic */ MediaOperation.a d;

    public g(a r1, String r2, long r3, MediaOperation.a r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }

    public final void accept(Object r6) {
        Throwable r7 = (Throwable) r6;
        Intrinsics.checkNotNullParameter(r7, "throwable");
        String r0 = this.b;
        this.a.e = false;
        long r1 = this.c;
        InteractLinkFullLinkMonitor.o0(r0, System.currentTimeMillis() - r1, r7);
        x.E0(this.b, r7, "");
        a.InterfaceC0292a r2 = this.a.b;
        if (r2 == null) goto L5;
        r2.r(this.b, r7);
    L5:
        MediaOperation.a r3 = this.d;
        if (r3 == null) goto L9;
        r3.onError(r7);
        return;
    }
}
