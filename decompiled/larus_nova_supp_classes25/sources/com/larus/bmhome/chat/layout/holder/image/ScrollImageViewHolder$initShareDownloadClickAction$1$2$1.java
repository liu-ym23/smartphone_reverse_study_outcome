package com.larus.bmhome.chat.layout.holder.image;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageShareClickMethod;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.service.z2;
import com.larus.uaigc.service.ICreationMetadataService;
import com.larus.uaigc.service.ICreationReportService;
import hq9.v1;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.image.ScrollImageViewHolder$initShareDownloadClickAction$1$2$1", f = "ImageScrollAdapter.kt", i = {}, l = {369, 373}, m = "invokeSuspend", n = {}, s = {})
final class ScrollImageViewHolder$initShareDownloadClickAction$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ m0 $data;
    final /* synthetic */ df8.a $imageItemInfo;
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ ScrollImageViewHolder this$0;

    public ScrollImageViewHolder$initShareDownloadClickAction$1$2$1(m0 r1, ScrollImageViewHolder r2, String r3, df8.a r4, Continuation<? super ScrollImageViewHolder$initShareDownloadClickAction$1$2$1> r5) {
        this.$data = r1;
        this.this$0 = r2;
        this.$url = r3;
        this.$imageItemInfo = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ScrollImageViewHolder$initShareDownloadClickAction$1$2$1(this.$data, this.this$0, this.$url, this.$imageItemInfo, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        int r3 = 0;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r15);
    L44:
        ky9.b r5 = ICreationReportService.a.j().e();
        ImageShareClickMethod r6 = ImageShareClickMethod.OverviewClick;
        df8.a r7 = this.$imageItemInfo;
        String r8 = ap8.a.b(this.$data.a);
        Integer r16 = this.this$0.l;
        if (r16 == null) goto L47;
        r3 = r16.intValue();
    L47:
        Integer r9 = Boxing.boxInt(r3 + 1);
        ICreationMetadataService.Companion r17 = ICreationMetadataService.a;
        ScrollImageViewHolder r2 = this.this$0;
        Message r4 = r2.k;
        m0 r10 = r2.j;
        if (r10 == null) goto L50;
        String r11 = r10.e;
    L51:
        UserCreationFromIM r18 = r17.I(r4, r11, String.valueOf(r2.l));
        if (r18 == null) goto L54;
        String r12 = r18.getCreationId();
    L55:
        r5.b(r6, r7, r8, r9, null, r12, null, null);
    L57:
        return Unit.INSTANCE;
    L54:
        r12 = null;
        goto L55
    L50:
        r11 = null;
        goto L51
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r15);
        goto L57
    L10:
        ResultKt.throwOnFailure(r15);
        z2 r19 = z2.a;
        v1 r13 = r19.getCreationShareSettings().a();
        if (r13 != null) goto L13;
    L15:
        boolean r14 = false;
    L16:
        if (r14 == false) goto L41;
        v1 r110 = r19.getCreationShareSettings().a();
        if (r110 != null) goto L20;
    L22:
        boolean r111 = false;
    L24:
        if (r111 == false) goto L29;
        if (Intrinsics.areEqual(ap8.a.b(this.$data.a), "avatar_image") == true) goto L33;
    L27:
        boolean r112 = true;
    L34:
        if (r112 == false) goto L41;
        ScrollImageViewHolder r20 = this.this$0;
        String r21 = this.$url;
        df8.a r22 = this.$imageItemInfo;
        m0 r23 = this.$data;
        JSONObject r24 = new JSONObject();
        Integer r113 = this.this$0.l;
        if (r113 == null) goto L38;
        r3 = r113.intValue();
    L38:
        r24.putOpt("position", Boxing.boxInt(r3 + 1));
        Unit r114 = Unit.INSTANCE;
        this.label = 1;
        if (ScrollImageViewHolder.V3(r20, r21, r22, r23, r24, this) != r0) goto L57;
        return r0;
    L33:
        r112 = false;
        goto L34
    L29:
        if (Intrinsics.areEqual(ap8.a.b(this.$data.a), "avatar_image") == true) goto L33;
        if (Intrinsics.areEqual(ap8.a.b(this.$data.a), "image") == true) goto L33;
    L20:
        if (r110.f() != true) goto L22;
        r111 = true;
    L41:
        ScrollImageViewHolder r115 = this.this$0;
        String r25 = this.$url;
        this.label = 2;
        if (ScrollImageViewHolder.U3(r115, r25, this) != r0) goto L44;
        return r0;
    L13:
        if (r13.b() != true) goto L15;
        r14 = true;
        goto L16
    }
}
