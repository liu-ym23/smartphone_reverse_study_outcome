package com.bytedance.ai.resource;

import com.bytedance.ai.resource.core.bean.OpenPlatformBaseResponse;
import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewAppInfoList;
import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewAppInfoRequest;
import com.bytedance.ai.resource.core.bean.OpenPlatformScanTarget;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewAppInfoList;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIPackageManager$getPreviewAppInfoList$2", f = "AIPackageManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AIPackageManager$getPreviewAppInfoList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super OpenPlatformPreviewAppInfoList>, Object> {
    final /* synthetic */ String $cursor;
    final /* synthetic */ String $deviceId;
    final /* synthetic */ int $limit;
    final /* synthetic */ int $mode;
    final /* synthetic */ List<OpenPlatformScanTarget> $scanTargets;
    final /* synthetic */ String $xToken;
    int label;

    public AIPackageManager$getPreviewAppInfoList$2(int r1, List<OpenPlatformScanTarget> r10, String r11, String r12, String r13, int r14, Continuation<? super AIPackageManager$getPreviewAppInfoList$2> r15) {
        this.$mode = r1;
        this.$scanTargets = r10;
        this.$xToken = r11;
        this.$deviceId = r12;
        this.$cursor = r13;
        this.$limit = r14;
        super(2, r15);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AIPackageManager$getPreviewAppInfoList$2(this.$mode, this.$scanTargets, this.$xToken, this.$deviceId, this.$cursor, this.$limit, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super OpenPlatformPreviewAppInfoList> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r11);
        String r12 = AIPackageManager.d(AIPackageManager.a, this.$mode, this.$scanTargets);
        Lazy r0 = o5.b.a;
        String r1 = this.$xToken;
        String r10 = this.$deviceId;
        List<OpenPlatformScanTarget> r13 = this.$scanTargets;
        String r14 = this.$cursor;
        boolean r15 = true;
        if ((!StringsKt.isBlank(r14)) == true) goto L8;
        r14 = null;
    L8:
        OpenPlatformPreviewAppInfoRequest r16 = new OpenPlatformPreviewAppInfoRequest(r10, r12, r13, r14, this.$limit);
        Intrinsics.checkNotNullParameter(r1, "xToken");
        Intrinsics.checkNotNullParameter(r16, "request");
        OpenPlatformBaseResponse<OpenPlatformPreviewAppInfoList> r17 = o5.b.a().getPreviewAppInfoList(r1, r16);
        if (r17.getCode() == 0) goto L12;
        r15 = false;
    L12:
        if (r15 == false) goto L17;
        OpenPlatformPreviewAppInfoList r18 = r17.getData();
        if (r18 == null) goto L16;
        return r18;
    L16:
        return new OpenPlatformPreviewAppInfoList(r12, null, null, null, false, 30, null);
    L17:
        com.bytedance.ai.utils.g.a.e("AIPackageManager", "Failed to get preview app info list: code = " + r17.getCode() + ", msg = " + r17.getMessage() + ", logId = " + r17.getLogId());
        return new OpenPlatformPreviewAppInfoList(r12, null, null, null, false, 30, null);
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
