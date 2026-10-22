package com.obric.memorydata.sdk.screencapture;

import com.obric.aikernel.sdk.ext.CozeCloudExt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a8\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0018\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0000¨\u0006\t"}, d2 = {"handleCaptureCurrentBindFailure", "", "pendingCaptureOperations", "", "Lcom/obric/memorydata/sdk/screencapture/PendingCaptureOperation;", "operation", CozeCloudExt.API_KEY_HTTP_POST_METHOD, "Lkotlin/Function1;", "Lkotlin/Function0;", "memoryDataSDK_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class g {
    private static final Unit a(e r1) {
        r1.c().invoke(null);
        return Unit.INSTANCE;
    }

    public static final void a(List<e> r2, final e r3, Function1<? super Function0<Unit>, Unit> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "pendingCaptureOperations");
        Intrinsics.checkNotNullParameter(r3, "operation");
        Intrinsics.checkNotNullParameter(r6, CozeCloudExt.API_KEY_HTTP_POST_METHOD);
        r5.remove(r3);
        r6.invoke(new $$Lambda$g$auiapyHxptU2nkCooJjlKcHery4(r3));
    }

    public static /* synthetic */ Unit lambda$auiapyHxptU2nkCooJjlKcHery4(e r0) {
        return a(r0);
    }
}
