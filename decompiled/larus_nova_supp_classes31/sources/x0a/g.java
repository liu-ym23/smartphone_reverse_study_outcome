package x0a;

import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.larus.ugc.feed.impl.quickmenu.DismissReason;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g implements b {
    public final /* synthetic */ Function1<DismissReason, Unit> a;

    public g(com.larus.ugc.feed.impl.quickmenu.doSame.d r1) {
        this.a = r1;
    }

    @Override // x0a.b
    public final void a(DismissReason r2) {
        Intrinsics.checkNotNullParameter(r2, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
        this.a.invoke(r2);
    }
}
