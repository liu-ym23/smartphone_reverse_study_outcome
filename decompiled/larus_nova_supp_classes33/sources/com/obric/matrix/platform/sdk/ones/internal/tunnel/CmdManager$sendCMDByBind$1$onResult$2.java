package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import com.obric.matrix.platform.server.IServerCallback;
import com.obric.matrix.proto.Response;
import io.reactivex.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"com/obric/matrix/platform/sdk/ones/internal/tunnel/CmdManager$sendCMDByBind$1$onResult$2", "Lcom/obric/matrix/platform/server/IServerCallback$Stub;", "", "cmd", "", "bytes", "", "onResult", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0})
public final class CmdManager$sendCMDByBind$1$onResult$2 extends IServerCallback.Stub {
    final /* synthetic */ j<Pair<Integer, Response>> $emitter;
    final /* synthetic */ bka.b $sendCMDResultCallback;
    final /* synthetic */ long $start;

    @Override // com.obric.matrix.platform.server.IServerCallback
    public void onResult(int r9, byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "bytes");
        String r2 = "invokeAsyn complete 2 cost " + (System.currentTimeMillis() - this.$start);
        int r3 = gka.b.a;
        Intrinsics.checkNotNullParameter("CmdManager", "tag");
        Intrinsics.checkNotNullParameter(r2, "msg");
        bka.a r4 = bka.a.a;
        Response r11 = (Response) Response.ADAPTER.decode(r10);     // Catch: Exception -> L11
        gka.b.a("CmdManager", "onResult() called with: cmd = " + r9 + ", response = " + r11);     // Catch: Exception -> L11
        fka.a.a(r9, r11);     // Catch: Exception -> L11
        j<Pair<Integer, Response>> r1 = this.$emitter;     // Catch: Exception -> L11
        if (r1 == null) goto L6;
        r1.onSuccess(new Pair(Integer.valueOf(r9), r11));     // Catch: Exception -> L11
    L6:
        bka.b r5 = this.$sendCMDResultCallback;     // Catch: Exception -> L11
        if (r5 == null) goto L9;
        r5.a(r11);     // Catch: Exception -> L11
    L9:
        String r12 = "invokeAsyn complete 3 cost " + (System.currentTimeMillis() - this.$start);     // Catch: Exception -> L11
        Intrinsics.checkNotNullParameter("CmdManager", "tag");     // Catch: Exception -> L11
        Intrinsics.checkNotNullParameter(r12, "msg");     // Catch: Exception -> L11
        return;
    L11:
        List<Integer> r13 = a.a;
        a.a(r9, this.$emitter, this.$sendCMDResultCallback, -20004, "receive result exception");
    }

    public CmdManager$sendCMDByBind$1$onResult$2(long r1, j<Pair<Integer, Response>> r3, bka.b r4) {
        this.$start = r1;
        this.$emitter = r3;
        this.$sendCMDResultCallback = r4;
    }
}
