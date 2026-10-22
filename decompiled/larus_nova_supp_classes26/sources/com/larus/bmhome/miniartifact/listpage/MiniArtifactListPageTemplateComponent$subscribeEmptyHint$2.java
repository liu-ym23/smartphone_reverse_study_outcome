package com.larus.bmhome.miniartifact.listpage;

import android.widget.TextView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.miniartifact.listpage.MiniArtifactListPageTemplateComponent$subscribeEmptyHint$2", f = "MiniArtifactListPageTemplateComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MiniArtifactListPageTemplateComponent$subscribeEmptyHint$2 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MiniArtifactListPageTemplateComponent this$0;

    public MiniArtifactListPageTemplateComponent$subscribeEmptyHint$2(MiniArtifactListPageTemplateComponent r1, Continuation<? super MiniArtifactListPageTemplateComponent$subscribeEmptyHint$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MiniArtifactListPageTemplateComponent$subscribeEmptyHint$2 r0 = new MiniArtifactListPageTemplateComponent$subscribeEmptyHint$2(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((String) r1, (Continuation) r2);
    }

    public final Object invoke(String r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r2);
        String r3 = (String) this.L$0;
        TextView r0 = this.this$0.n;
        if (r0 == null) goto L8;
        r0.setText(r3);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
