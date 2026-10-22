package com.obric.matrix.platform.sdk.ones.picolinks;

import com.obric.matrix.proto.Response;
import com.obric.matrix.proto.ResponseBody;
import com.obric.matrix.proto.StartPicoLinksResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/matrix/proto/Response;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class PicoLinksHook$invokeStartPicoLinks$1 extends Lambda implements Function1<Response, Unit> {
    final /* synthetic */ com.obric.matrix.platform.sdk.ones.picolinks.a $callback;
    final /* synthetic */ Ref.ObjectRef<Response> $response;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[StartPicoLinksResponse.Phase.values().length];
            r0[StartPicoLinksResponse.Phase.URL_REDIRECT.ordinal()] = 1;
            r0[StartPicoLinksResponse.Phase.ASYNC_CALLBACK.ordinal()] = 2;
            a = r0;
        }
    }

    public PicoLinksHook$invokeStartPicoLinks$1(Ref.ObjectRef<Response> r1, com.obric.matrix.platform.sdk.ones.picolinks.a r2) {
        this.$response = r1;
        super(1);
    }

    public final void invoke(Response r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        this.$response.element = r3;
        ResponseBody r4 = r3.body;
        if (r4 == null) goto L15;
        StartPicoLinksResponse r5 = r4.startPicoLinksResponse;
        if (r5 == null) goto L16;
        StartPicoLinksResponse.Phase r0 = r5.phase;
        if (r0 != null) goto L9;
        int r1 = -1;
    L11:
        if (r1 != 1) goto L17;
        String r6 = r5.phaseData.get("redirectUrl");
        return;
    L17:
        return;
    L9:
        r1 = a.a[r0.ordinal()];
        goto L11
    L16:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Response) r1);
        return Unit.INSTANCE;
    }
}
