package com.larus.bmhome.clarification;

import android.app.Application;
import com.larus.common.apphost.AppHost;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.clarification.ClarificationAttachmentManager$showCountLimitTips$1", f = "ClarificationAttachmentManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ClarificationAttachmentManager$showCountLimitTips$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isFromFileBrowser;
    int label;
    final /* synthetic */ ClarificationAttachmentManager this$0;

    public ClarificationAttachmentManager$showCountLimitTips$1(ClarificationAttachmentManager r1, boolean r2, Continuation<? super ClarificationAttachmentManager$showCountLimitTips$1> r3) {
        this.this$0 = r1;
        this.$isFromFileBrowser = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ClarificationAttachmentManager$showCountLimitTips$1(this.this$0, this.$isFromFileBrowser, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r3);
        com.larus.bmhome.chat.component.bottom.multimodal.g r4 = (com.larus.bmhome.chat.component.bottom.multimodal.g) this.this$0.g.invoke();
        if (r4 == null) goto L10;
        String r5 = r4.mS(this.$isFromFileBrowser, null);
        if (r5 == null) goto L10;
        t19.s r0 = t19.s.a;
        Application r1 = AppHost.a.getApplication();
        r0.getClass();
        t19.s.t(r1, r5);
    L10:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
