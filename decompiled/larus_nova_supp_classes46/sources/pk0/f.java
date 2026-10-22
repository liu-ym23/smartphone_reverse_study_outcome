package pk0;

import com.bytedance.android.live.liveinteract.wrds.LinkWRDSHelper;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.wrds.LinkMicRoomDataSyncModel;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f<T, R> implements Function {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
    }

    public final Object apply(Object r5) {
        ExtraResponse r6 = (ExtraResponse) r5;
        Intrinsics.checkNotNullParameter(r6, "it");
        Intrinsics.checkNotNullParameter(r6, "response");
        LinkMicRoomDataSyncModel r1 = LinkWRDSHelper.b();
        com.bytedance.android.live.network.response.f.b r2 = new com.bytedance.android.live.network.response.f.b(r6.data, r6.extra);
        Intrinsics.checkNotNullParameter(r2, "response");
        return Single.create(new com.bytedance.android.live.liveinteract.wrds.b(r1, r2)).map(gc6.a.a).toObservable();
    }
}
