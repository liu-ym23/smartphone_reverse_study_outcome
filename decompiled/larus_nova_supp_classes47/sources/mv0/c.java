package mv0;

import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcast.api.UpdateRoomInfoApi;
import com.bytedance.android.live.broadcast.api.model.g1;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c extends qs0.a<IBroadcastService> implements qs0.d {

    public static final class a<T, R> implements Function {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r2) {
            Intrinsics.checkNotNullParameter((g1) r2, "it");
            return new qs0.d.a();
        }
    }

    public c() {
        super(va1.b.a.a.a(IBroadcastService.class));
    }

    @Override // qs0.d
    public final boolean isPlayingGame() {
        IBroadcastService r0 = (IBroadcastService) this.a;
        return InteractGameContext.Companion.b();
    }

    @Override // qs0.d
    public final boolean isUserInAnchorLink(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        IBroadcastService r0 = (IBroadcastService) this.a;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isUserInAnchorLink(r2);
    }

    @Override // qs0.d
    public final Observable<qs0.d.a> f(long r3, long r5) {
        return ((UpdateRoomInfoApi) com.bytedance.android.live.network.c.b().e(UpdateRoomInfoApi.class)).updateRoomInfo(r3, r5).map(a.a);
    }
}
