package com.ss.android.lark.flow.chat.message.image;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.message.image.FlowYunPanFileUtils$driveDownloadImageWithFile$filePath$1", f = "FlowYunPanFileUtils.kt", i = {}, l = {197}, m = "invokeSuspend", n = {}, s = {})
public final class FlowYunPanFileUtils$driveDownloadImageWithFile$filePath$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $localPath;
    final /* synthetic */ String $token;
    int label;

    public FlowYunPanFileUtils$driveDownloadImageWithFile$filePath$1(String r1, String r2, Continuation<? super FlowYunPanFileUtils$driveDownloadImageWithFile$filePath$1> r3) {
        this.$token = r1;
        this.$localPath = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new FlowYunPanFileUtils$driveDownloadImageWithFile$filePath$1(this.$token, this.$localPath, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        return r5;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        FlowYunPanFileUtils r6 = FlowYunPanFileUtils.a;
        String r2 = this.$token;
        String r3 = this.$localPath;
        this.label = 1;
        r5 = FlowYunPanFileUtils.a(r6, r2, r3, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
