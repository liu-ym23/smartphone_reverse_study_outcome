package com.larus.xbridge.custom;

import com.ivy.ivykit.api.bridge.core.IvyBridgeMethod;
import com.obric.aiagent.assistant.idl.bean.MessageContentType;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.xbridge.custom.AppSaveMsgExportFileMethod$handle$4", f = "AppSaveMsgExportFileMethod.kt", i = {}, l = {MessageContentType.CONTENT_TYPE_USER_EVALUATE}, m = "invokeSuspend", n = {}, s = {})
final class AppSaveMsgExportFileMethod$handle$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $base64Content;
    final /* synthetic */ IvyBridgeMethod.a $callback;
    final /* synthetic */ String $fileName;
    final /* synthetic */ cx7.d $params;
    int label;
    final /* synthetic */ y this$0;

    public AppSaveMsgExportFileMethod$handle$4(y r1, String r2, String r3, IvyBridgeMethod.a r4, cx7.d r5, Continuation<? super AppSaveMsgExportFileMethod$handle$4> r6) {
        this.this$0 = r1;
        this.$base64Content = r2;
        this.$fileName = r3;
        this.$callback = r4;
        this.$params = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new AppSaveMsgExportFileMethod$handle$4(this.this$0, this.$base64Content, this.$fileName, this.$callback, this.$params, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        y r4 = this.this$0;
        String r12 = this.$base64Content;
        String r3 = this.$fileName;
        IvyBridgeMethod.a r5 = this.$callback;
        cx7.d r6 = this.$params;
        this.label = 1;
        int r2 = y.b;
        r4.getClass();
        Object r13 = BuildersKt.withContext(Dispatchers.getIO(), new AppSaveMsgExportFileMethod$saveBase64$2(r12, r3, r4, r5, r6, null), this);
        if (r13 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        r13 = Unit.INSTANCE;
    L12:
        if (r13 != r0) goto L15;
        return r0;
    }
}
