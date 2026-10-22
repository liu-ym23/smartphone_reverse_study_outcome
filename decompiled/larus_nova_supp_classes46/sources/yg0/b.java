package yg0;

import com.bytedance.android.livesdk.gecko.offline.OfflineResourceClient;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements nn0.b {
    public final /* synthetic */ zg0.a a;

    public static final class a implements OfflineResourceClient.a {
        public final /* synthetic */ nn0.b.a a;

        public a(nn0.b.a r1) {
            this.a = r1;
        }

        public final void onError(Throwable r2) {
            this.a.onError(r2);
        }

        public final void onSuccess(String r2) {
            this.a.onSuccess(r2);
        }
    }

    @Override // nn0.b
    public final zg0.a c() {
        return this.a;
    }

    public b(zg0.a r1) {
        this.a = r1;
    }

    @Override // nn0.b
    public final boolean b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "keyName");
        if (com.bytedance.android.livesdk.gecko.offline.f.b(r2) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // nn0.b
    public final void a(String r3, nn0.b.a r4) {
        Intrinsics.checkNotNullParameter(r3, "keyName");
        Intrinsics.checkNotNullParameter(r4, "callback");
        a r1 = new a(r4);
        String r5 = i.a;
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r1, "callback");
        Intrinsics.checkNotNullParameter(r3, "key");
        String r6 = i.a + r3;
        com.bytedance.android.livesdk.gecko.offline.g.a();
        boolean r7 = OfflineResourceClient.a;
        OfflineResourceClient.c(r6, r1);
    }
}
