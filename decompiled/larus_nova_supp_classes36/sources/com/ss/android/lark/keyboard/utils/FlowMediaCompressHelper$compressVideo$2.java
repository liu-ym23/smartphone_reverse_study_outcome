package com.ss.android.lark.keyboard.utils;

import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.UplinkFileEntity;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.videosend.tools.CompressPathManager;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.utils.FlowMediaCompressHelper$compressVideo$2", f = "FlowMediaCompressHelper.kt", i = {}, l = {153}, m = "invokeSuspend", n = {}, s = {})
final class FlowMediaCompressHelper$compressVideo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ UplinkFileEntity $entity;
    final /* synthetic */ String $localPath;
    final /* synthetic */ String $uploadId;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public FlowMediaCompressHelper$compressVideo$2(String r1, UplinkFileEntity r2, String r3, Continuation<? super FlowMediaCompressHelper$compressVideo$2> r4) {
        this.$localPath = r1;
        this.$entity = r2;
        this.$uploadId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new FlowMediaCompressHelper$compressVideo$2(this.$localPath, this.$entity, this.$uploadId, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        String r2 = (String) this.L$2;
        UplinkFileEntity r3 = (UplinkFileEntity) this.L$1;
        String r4 = (String) this.L$0;
        ResultKt.throwOnFailure(r10);
    L13:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        String r11 = this.$localPath;
        UplinkFileEntity r5 = this.$entity;
        String r6 = this.$uploadId;
        this.L$0 = r11;
        this.L$1 = r5;
        this.L$2 = r6;
        this.label = 1;
        final SafeContinuation r7 = new SafeContinuation(IntrinsicsKt.intercepted(this));
        final String r8 = CompressPathManager.generateCompressFilePath(r11, Boxing.boxBoolean(Intrinsics.areEqual(r5.isOriginalImageChecked(), Boxing.boxBoolean(true))));
        com.ss.android.lark.videosend.compress.a r9 = new com.ss.android.lark.videosend.compress.a(UUID.randomUUID().hashCode(), r11, new FlowMediaCompressHelper.b(new FlowMediaCompressHelper$compressVideo$2$1$param$1(r8, r7)));
        r9.d = r8;
        r9.j = r6;
        new FlowMediaCompressHelper.a(r9).run();
        r10 = r7.getOrThrow();
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        DebugProbesKt.probeCoroutineSuspended(this);
    L11:
        if (r10 != r0) goto L13;
        return r0;
    }
}
