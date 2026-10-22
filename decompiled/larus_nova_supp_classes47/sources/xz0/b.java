package xz0;

import com.bytedance.android.live.revenue.platform.network.dynamic.g;
import com.bytedance.android.live.revenue.platform.network.dynamic.k;
import com.bytedance.android.live.revenue.platform.room.impl.BaseRoomMessageService;
import com.bytedance.android.livesdk.revenue.message.d;
import com.bytedance.android.livesdkapi.message.OnWRDSDataUpdateListener;
import com.bytedance.android.scope.o;
import com.bytedance.livesdk.preview.viewmodel.VHPreviewContext;
import io.reactivex.subjects.BehaviorSubject;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b extends BaseRoomMessageService implements o {
    public final VHPreviewContext k;
    public final Map<ylc.c, OnWRDSDataUpdateListener> l;
    public final vh6.b m;
    public final com.bytedance.android.livesdk.revenue.service.message.c n;

    public static final class a implements d {
        public final /* synthetic */ b a;

        public final com.ss.ugc.live.sdk.message.wrsc.data.a b(k r2) {
            Intrinsics.checkNotNullParameter(r2, "type");
            return null;
        }

        public a(b r1) {
            this.a = r1;
        }

        public final void a(k r2, g r3) {
            Intrinsics.checkNotNullParameter(r2, "type");
            Intrinsics.checkNotNullParameter(r3, "listener");
            if (((OnWRDSDataUpdateListener) ((LinkedHashMap) this.a.l).get(r3)) == null) goto L6;
            this.a.k.getMMessageManager();
            OnWRDSDataUpdateListener r4 = this.a.l.remove(r3);
            return;
        }

        public final void c(k r2, g r3) {
            Intrinsics.checkNotNullParameter(r2, "type");
            Intrinsics.checkNotNullParameter(r3, "listener");
            xz0.a r4 = new xz0.a(r3);
            this.a.k.getMMessageManager();
            this.a.l.put(r3, r4);
        }
    }

    @Override // com.bytedance.android.live.revenue.platform.room.impl.BaseRoomMessageService
    public final void onStart() {
        this.k.getMMessageManager();
        this.b.onNext(sh6.c.a(new a(this)));
    }

    @Override // com.bytedance.android.live.revenue.platform.room.impl.BaseRoomMessageService
    public final void onStop() {
        BehaviorSubject<sh6.b<com.bytedance.android.livesdk.revenue.message.b>> r0 = this.a;
        sh6.a r1 = sh6.a.a;
        r0.onNext(r1);
        this.a.onComplete();
        this.b.onNext(r1);
        this.b.onComplete();
        this.f.clear();
        this.g.clear();
    }

    public b(vh6.b r2, com.bytedance.android.livesdk.revenue.service.message.c r3) {
        Intrinsics.checkNotNullParameter(r2, "dependencyResolver");
        Intrinsics.checkNotNullParameter(r3, "converter");
        this.m = r2;
        this.n = r3;
        Object r4 = r2.a(com.bytedance.livesdk.preview.viewmodel.b.a);
        Intrinsics.checkNotNull(r4);
        this.k = (VHPreviewContext) r4;
        this.l = new LinkedHashMap();
    }
}
