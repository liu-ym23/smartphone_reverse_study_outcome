package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.core.log.ALogger;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class NetworkRequestMethod$onResponseFailed$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Throwable $t;
    final /* synthetic */ NetworkRequestMethod this$0;

    public NetworkRequestMethod$onResponseFailed$1(NetworkRequestMethod r1, Throwable r2) {
        this.this$0 = r1;
        this.$t = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m246invoke() {
        Throwable r0 = this.$t;
        if ((r0 instanceof TimeoutException) == false) goto L5;
        NetworkRequestMethod r1 = this.this$0;
        OpenApiErrorInfo r2 = OpenApiErrorInfo.NET_REQUEST_TIMEOUT;
        int r3 = BaseOpenMethod.g;
        r1.n(r2, null);
        return;
    L5:
        this.this$0.n(OpenApiErrorInfo.NETWORK_ERROR, r0);
        ALogger.d("NetworkRequestMethod", this.$t.toString());
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m246invoke();
        return Unit.INSTANCE;
    }
}
