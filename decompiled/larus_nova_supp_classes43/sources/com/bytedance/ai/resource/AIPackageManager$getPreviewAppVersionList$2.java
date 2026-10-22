package com.bytedance.ai.resource;

import com.bytedance.ai.resource.core.bean.OpenPlatformBaseResponse;
import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewAppVersionList;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewAppVersionList;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIPackageManager$getPreviewAppVersionList$2", f = "AIPackageManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AIPackageManager$getPreviewAppVersionList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super OpenPlatformPreviewAppVersionList>, Object> {
    final /* synthetic */ String $appKey;
    final /* synthetic */ String $cursor;
    final /* synthetic */ String $deviceId;
    final /* synthetic */ int $limit;
    final /* synthetic */ int $mode;
    final /* synthetic */ String $xToken;
    int label;

    public AIPackageManager$getPreviewAppVersionList$2(int r1, String r10, String r11, String r12, String r13, int r14, Continuation<? super AIPackageManager$getPreviewAppVersionList$2> r15) {
        this.$mode = r1;
        this.$appKey = r10;
        this.$deviceId = r11;
        this.$xToken = r12;
        this.$cursor = r13;
        this.$limit = r14;
        super(2, r15);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AIPackageManager$getPreviewAppVersionList$2(this.$mode, this.$appKey, this.$deviceId, this.$xToken, this.$cursor, this.$limit, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super OpenPlatformPreviewAppVersionList> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r10);
        String r11 = AIPackageManager.d(AIPackageManager.a, this.$mode, null);
        Lazy r12 = o5.b.a;
        String r13 = this.$appKey;
        String r14 = this.$deviceId;
        String r15 = this.$xToken;
        String r16 = this.$cursor;
        int r17 = this.$limit;
        Intrinsics.checkNotNullParameter(r13, "appKey");
        Intrinsics.checkNotNullParameter(r14, "deviceId");
        Intrinsics.checkNotNullParameter(r11, "mode");
        Intrinsics.checkNotNullParameter(r15, "xToken");
        Intrinsics.checkNotNullParameter(r16, "cursor");
        OpenPlatformBaseResponse<OpenPlatformPreviewAppVersionList> r18 = o5.b.a().getPreviewAppVersionList(r13, r14, r11, r15, r16, r17);
        if (r18.getCode() != 0) goto L7;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L14;
        OpenPlatformPreviewAppVersionList r19 = r18.getData();
        if (r19 == null) goto L13;
        return r19;
    L13:
        return new OpenPlatformPreviewAppVersionList(this.$appKey, null, 2, null);
    L14:
        com.bytedance.ai.utils.g.a.e("AIPackageManager", "Failed to get preview app version list: appKey = " + this.$appKey + ", code = " + r18.getCode() + ", msg = " + r18.getMessage() + ", logId = " + r18.getLogId());
        return new OpenPlatformPreviewAppVersionList(this.$appKey, null, 2, null);
    L7:
        r0 = false;
        goto L9
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
