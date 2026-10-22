package com.larus.bmhome.chat.layout.holder.image;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageShareClickMethod;
import com.larus.uaigc.service.ICreationReportService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.image.ScrollImageViewHolder$initShareDownloadClickAction$1$1$1", f = "ImageScrollAdapter.kt", i = {}, l = {352}, m = "invokeSuspend", n = {}, s = {})
final class ScrollImageViewHolder$initShareDownloadClickAction$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ m0 $data;
    final /* synthetic */ df8.a $imageItemInfo;
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ ScrollImageViewHolder this$0;

    public ScrollImageViewHolder$initShareDownloadClickAction$1$1$1(ScrollImageViewHolder r1, String r2, df8.a r3, m0 r4, Continuation<? super ScrollImageViewHolder$initShareDownloadClickAction$1$1$1> r5) {
        this.this$0 = r1;
        this.$url = r2;
        this.$imageItemInfo = r3;
        this.$data = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ScrollImageViewHolder$initShareDownloadClickAction$1$1$1(this.this$0, this.$url, this.$imageItemInfo, this.$data, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L15:
        ICreationReportService.a.j().e().a(ImageShareClickMethod.OverviewClick, this.$imageItemInfo, ap8.a.b(this.$data.a), null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        ScrollImageViewHolder r2 = this.this$0;
        String r10 = this.$url;
        df8.a r3 = this.$imageItemInfo;
        m0 r4 = this.$data;
        JSONObject r5 = new JSONObject();
        Integer r6 = this.this$0.l;
        if (r6 == null) goto L11;
        int r7 = r6.intValue();
    L12:
        r5.putOpt("position", Boxing.boxInt(r7 + 1));
        Unit r8 = Unit.INSTANCE;
        this.label = 1;
        if (ScrollImageViewHolder.V3(r2, r10, r3, r4, r5, this) != r0) goto L15;
        return r0;
    L11:
        r7 = 0;
        goto L12
    }
}
