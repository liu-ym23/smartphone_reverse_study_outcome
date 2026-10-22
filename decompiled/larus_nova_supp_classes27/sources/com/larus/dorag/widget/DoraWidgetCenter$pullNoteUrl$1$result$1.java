package com.larus.dorag.widget;

import com.larus.dorag.widget.api.DoraWidgetGetNoteUrlApi;
import com.larus.dorag.widget.api.NoteUrl;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/dorag/widget/api/NoteUrl;", "Lcom/larus/dorag/widget/api/DoraWidgetGetNoteUrlApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dorag.widget.DoraWidgetCenter$pullNoteUrl$1$result$1", f = "DoraWidgetCenter.kt", i = {}, l = {285}, m = "invokeSuspend", n = {}, s = {})
public final class DoraWidgetCenter$pullNoteUrl$1$result$1 extends SuspendLambda implements Function2<DoraWidgetGetNoteUrlApi, Continuation<? super BizResponse<NoteUrl>>, Object> {
    final /* synthetic */ int $productId;
    final /* synthetic */ String $serialNumber;
    private /* synthetic */ Object L$0;
    int label;

    public DoraWidgetCenter$pullNoteUrl$1$result$1(int r1, String r2, Continuation<? super DoraWidgetCenter$pullNoteUrl$1$result$1> r3) {
        this.$productId = r1;
        this.$serialNumber = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        DoraWidgetCenter$pullNoteUrl$1$result$1 r0 = new DoraWidgetCenter$pullNoteUrl$1$result$1(this.$productId, this.$serialNumber, r5);
        r0.L$0 = r4;
        return r0;
    }

    public final Object invoke(DoraWidgetGetNoteUrlApi r1, Continuation<? super BizResponse<NoteUrl>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((DoraWidgetGetNoteUrlApi) r1, (Continuation) r2);
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
        DoraWidgetGetNoteUrlApi r6 = (DoraWidgetGetNoteUrlApi) this.L$0;
        String r2 = String.valueOf(this.$productId);
        String r3 = this.$serialNumber;
        this.label = 1;
        r5 = r6.getNoteUrl(r2, r3, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
