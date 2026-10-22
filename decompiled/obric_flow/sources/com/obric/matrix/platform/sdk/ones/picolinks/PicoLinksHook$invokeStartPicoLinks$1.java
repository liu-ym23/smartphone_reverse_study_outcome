package com.obric.matrix.platform.sdk.ones.picolinks;

import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import com.obric.matrix.proto.Response;
import com.obric.matrix.proto.ResponseBody;
import com.obric.matrix.proto.StartPicoLinksResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", ST.IMPLICIT_ARG_NAME, "Lcom/obric/matrix/proto/Response;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class PicoLinksHook$invokeStartPicoLinks$1 extends Lambda implements Function1<Response, Unit> {
    final /* synthetic */ a $callback;
    final /* synthetic */ Ref.ObjectRef<Response> $response;

    public PicoLinksHook$invokeStartPicoLinks$1(Ref.ObjectRef<Response> r5, a r10) {
        this.$response = r5;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Response r5) {
        invoke2(r5);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Response r5) {
        Intrinsics.checkNotNullParameter(r5, ST.IMPLICIT_ARG_NAME);
        this.$response.element = r5;
        ResponseBody r10 = r5.body;
        if (r10 == null) goto L15;
        StartPicoLinksResponse r11 = r10.startPicoLinksResponse;
        if (r11 == null) goto L16;
        StartPicoLinksResponse.Phase r12 = r11.phase;
        if (r12 != null) goto L9;
        int r13 = -1;
    L11:
        if (r13 != 1) goto L17;
        String r14 = r11.phaseData.get("redirectUrl");
        return;
    L17:
        return;
    L9:
        r13 = b.f11903a[r12.ordinal()];
        goto L11
    L16:
        return;
    }
}
