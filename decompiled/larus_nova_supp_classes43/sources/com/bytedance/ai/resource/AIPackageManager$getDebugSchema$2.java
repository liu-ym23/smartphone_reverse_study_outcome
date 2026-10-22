package com.bytedance.ai.resource;

import com.byted.mgl.merge.service.api.share.BdpShareBaseInfo;
import com.bytedance.ai.resource.core.bean.OpenPlatformBaseResponse;
import com.bytedance.ai.resource.core.bean.OpenPlatformDebugSchemaData;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIPackageManager$getDebugSchema$2", f = "AIPackageManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AIPackageManager$getDebugSchema$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $token;
    private /* synthetic */ Object L$0;
    int label;

    public AIPackageManager$getDebugSchema$2(String r1, Continuation<? super AIPackageManager$getDebugSchema$2> r10) {
        this.$token = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        AIPackageManager$getDebugSchema$2 r0 = new AIPackageManager$getDebugSchema$2(this.$token, r11);
        r0.L$0 = r10;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L28;
        ResultKt.throwOnFailure(r10);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        Lazy r12 = o5.b.a;
        String r13 = this.$token;
        Intrinsics.checkNotNullParameter(r13, BdpShareBaseInfo.CHANNEL_TOKEN);
        OpenPlatformBaseResponse<OpenPlatformDebugSchemaData> r14 = o5.b.a().getDebugSchema(r13);
        boolean r1 = false;
        if (r14.getCode() != 0) goto L7;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L25;
        OpenPlatformDebugSchemaData r15 = r14.getData();
        com.bytedance.ai.utils.g r16 = com.bytedance.ai.utils.g.a;
        r16.i("AIPackageManager", "Succeed to get debug schema : " + r15);
        if (r15 == null) goto L23;
        String r17 = r15.getUrl();
        if (r17 != null) goto L15;
    L16:
        r1 = true;
    L17:
        if (r1 == false) goto L19;
        r16.e("AIPackageManager", "debug schema is EMPTY， logId = " + r14.getLogId());
        String r18 = null;
    L20:
        if (r18 == null) goto L23;
        return r18;
    L19:
        r18 = r15.getUrl();
        goto L20
    L15:
        if (r17.length() != 0) goto L17;
    L23:
        r16.e("AIPackageManager", "Failed to get debug schema. data is NULL");
        return null;
    L25:
        com.bytedance.ai.utils.g.a.e("AIPackageManager", "Failed to get debug schema : code = " + r14.getCode() + ", msg = " + r14.getMessage() + ", logId = " + r14.getLogId());
        return null;
    L7:
        r0 = false;
        goto L9
    L28:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
