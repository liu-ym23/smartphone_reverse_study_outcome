package or1;

import com.bytedance.android.livesdkapi.depend.event.FollowStateChangeEvent;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q<T> implements Consumer {
    public final /* synthetic */ Function1 a;

    public q(bm1.b r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        this.a.invoke(((FollowStateChangeEvent) r2).getFollowPair());
    }
}
