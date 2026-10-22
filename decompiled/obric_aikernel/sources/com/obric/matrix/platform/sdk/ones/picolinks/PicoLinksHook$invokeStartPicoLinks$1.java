package com.obric.matrix.platform.sdk.ones.picolinks;

import android.util.Log;
import com.obric.matrix.proto.Response;
import com.obric.matrix.proto.ResponseBody;
import com.obric.matrix.proto.StartPicoLinksResponse;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
final class PicoLinksHook$invokeStartPicoLinks$1 extends Lambda implements Function1<Response, Unit> {
    final /* synthetic */ com.obric.matrix.platform.sdk.ones.picolinks.a $callback;
    final /* synthetic */ Ref.ObjectRef<Response> $response;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5913a = null;

        static {
            int[] r10 = new int[StartPicoLinksResponse.Phase.values().length];
            r10[StartPicoLinksResponse.Phase.URL_REDIRECT.ordinal()] = 1;
            r10[StartPicoLinksResponse.Phase.ASYNC_CALLBACK.ordinal()] = 2;
            f5913a = r10;
        }
    }

    PicoLinksHook$invokeStartPicoLinks$1(Ref.ObjectRef<Response> r10, com.obric.matrix.platform.sdk.ones.picolinks.a r11) {
        this.$response = r10;
        this.$callback = r11;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Response r10) {
        invoke2(r10);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Response r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
        this.$response.element = r10;
        ResponseBody r11 = r10.body;
        if (r11 == null) goto L33;
        StartPicoLinksResponse r12 = r11.startPicoLinksResponse;
        if (r12 == null) goto L34;
        com.obric.matrix.platform.sdk.ones.picolinks.a r13 = this.$callback;
        StartPicoLinksResponse.Phase r14 = r12.phase;
        if (r14 != null) goto L9;
        int r15 = -1;
    L10:
        boolean r16 = true;
        if (r15 != 1) goto L13;
        String r17 = r12.phaseData.get("redirectUrl");
        if (r17 != null) goto L23;
    L26:
        if (r16 == true) goto L37;
        if (r13 == null) goto L38;
        r13.a(r17);     // Catch: Throwable -> L18
    L30:
        return;
    L38:
        return;
    L37:
        return;
    L23:
        if (r17.length() == 0) goto L26;
        r16 = false;
        goto L26
    L13:
        if (r15 != 2) goto L39;
        if (r13 == null) goto L35;
        Map<String, String> r18 = r12.phaseData;     // Catch: Throwable -> L18
        Intrinsics.checkNotNullExpressionValue(r18, "resp.phaseData");     // Catch: Throwable -> L18
        r13.b(r18);     // Catch: Throwable -> L18
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
        r15 = a.f5913a[r14.ordinal()];
        goto L10
    L34:
        return;
    }
}
