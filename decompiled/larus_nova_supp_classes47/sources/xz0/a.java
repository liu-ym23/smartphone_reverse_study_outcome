package xz0;

import com.bytedance.android.live.revenue.platform.network.dynamic.g;
import com.bytedance.android.livesdkapi.message.OnWRDSDataUpdateListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements OnWRDSDataUpdateListener {
    public ylc.c a;
    public final /* synthetic */ ylc.c b;

    public final void onWRDSDataUpdate(String r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "syncKey");
    }

    public final ylc.c getDataSyncListener() {
        return this.a;
    }

    public a(g r1) {
        this.b = r1;
        this.a = r1;
    }

    public final void setDataSyncListener(ylc.c r1) {
        this.a = r1;
    }
}
