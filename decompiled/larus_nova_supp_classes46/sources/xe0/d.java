package xe0;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ a a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;

    public d(a r1, String r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r6) {
        Throwable r7 = (Throwable) r6;
        Intrinsics.checkNotNullParameter(r7, "throwable");
        String r0 = this.b;
        this.a.d = false;
        long r1 = this.c;
        InteractLinkFullLinkMonitor.W(r0, System.currentTimeMillis() - r1, r7);
        x.x0(this.b, r7, "");
        a.InterfaceC0292a r2 = this.a.b;
        if (r2 == null) goto L6;
        r2.F(this.b, r7);
        return;
    }
}
