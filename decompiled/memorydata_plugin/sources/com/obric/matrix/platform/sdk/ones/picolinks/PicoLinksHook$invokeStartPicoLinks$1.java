package com.obric.matrix.platform.sdk.ones.picolinks;

import android.util.Log;
import com.obric.matrix.proto.Response;
import com.obric.matrix.proto.ResponseBody;
import com.obric.matrix.proto.StartPicoLinksResponse;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/matrix/proto/Response;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class PicoLinksHook$invokeStartPicoLinks$1 extends Lambda implements Function1<Response, Unit> {
    final /* synthetic */ com.obric.matrix.platform.sdk.ones.picolinks.a.InterfaceC0405a $callback;
    final /* synthetic */ Ref.ObjectRef<Response> $response;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8120a = null;

        static {
            int[] r0 = new int[StartPicoLinksResponse.Phase.values().length];
            r0[StartPicoLinksResponse.Phase.URL_REDIRECT.ordinal()] = 1;
            r0[StartPicoLinksResponse.Phase.ASYNC_CALLBACK.ordinal()] = 2;
            f8120a = r0;
        }
    }

    PicoLinksHook$invokeStartPicoLinks$1(Ref.ObjectRef<Response> r3, com.obric.matrix.platform.sdk.ones.picolinks.a.InterfaceC0405a r4) {
        com.obric.matrix.platform.sdk.ones.picolinks.a.InterfaceC0405a r5 = (com.obric.matrix.platform.sdk.ones.picolinks.a.InterfaceC0405a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.matrix.platform.sdk.ones.picolinks.a.InterfaceC0405a.class, "com.obric.memorydata.plugin");
        this.$response = r3;
        this.$callback = r5;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(Response r3) {
        invoke2((Response) ZeusTransformUtils.preCheckCast(r3, Response.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Response r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        this.$response.element = r5;
        ResponseBody r6 = r5.body;
        if (r6 == null) goto L33;
        StartPicoLinksResponse r7 = r6.startPicoLinksResponse;
        if (r7 == null) goto L34;
        com.obric.matrix.platform.sdk.ones.picolinks.a.InterfaceC0405a r4 = this.$callback;
        StartPicoLinksResponse.Phase r0 = r7.phase;
        if (r0 != null) goto L9;
        int r1 = -1;
    L10:
        boolean r2 = true;
        if (r1 != 1) goto L13;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7.phaseData.get("redirectUrl"), String.class, "com.obric.memorydata.plugin");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L23;
    L26:
        if (r2 == true) goto L37;
        if (r4 == null) goto L38;
        r4.a(r8);     // Catch: Throwable -> L18
    L30:
        return;
    L38:
        return;
    L37:
        return;
    L23:
        if (r3.length() == 0) goto L26;
        r2 = false;
        goto L26
    L13:
        if (r1 != 2) goto L39;
        if (r4 == null) goto L35;
        Map<String, String> r9 = r7.phaseData;     // Catch: Throwable -> L18
        Intrinsics.checkNotNullExpressionValue(r9, "resp.phaseData");     // Catch: Throwable -> L18
        r4.a(r9);     // Catch: Throwable -> L18
        goto L30
    L35:
        return;
    L39:
        return;
    L18:
        th = move-exception;
        Log.w("PicoLinksHook", th);
        return;
    L9:
        r1 = a.f8120a[r0.ordinal()];
        goto L10
    L34:
        return;
    }
}
