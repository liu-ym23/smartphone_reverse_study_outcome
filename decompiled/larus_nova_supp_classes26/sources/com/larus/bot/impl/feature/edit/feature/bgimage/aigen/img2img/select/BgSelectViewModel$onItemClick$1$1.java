package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bot.impl.feature.edit.viewmodel.BotImageUploadViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select.BgSelectViewModel$onItemClick$1$1", f = "BgSelectViewModel.kt", i = {}, l = {496, 499, 502}, m = "invokeSuspend", n = {}, s = {})
public final class BgSelectViewModel$onItemClick$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $position;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BgSelectViewModel this$0;

    public BgSelectViewModel$onItemClick$1$1(int r1, BgSelectViewModel r2, Continuation<? super BgSelectViewModel$onItemClick$1$1> r3) {
        this.$position = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        BgSelectViewModel$onItemClick$1$1 r0 = new BgSelectViewModel$onItemClick$1$1(this.$position, this.this$0, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L11;
        if (r1 == 1) goto L10;
        if (r1 == 2) goto L10;
        if (r1 == 3) goto L10;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r12);
    L44:
        return Unit.INSTANCE;
    L11:
        ResultKt.throwOnFailure(r12);
        CoroutineScope r13 = (CoroutineScope) this.L$0;
        if (this.$position == 0) goto L14;
    L40:
        BgSelectViewModel r14 = this.this$0;
        int r2 = this.$position / BgSelectViewModel.access$getOnePageImageNum$p(r14);
        this.label = 3;
        if (BgSelectViewModel.access$genBg(r14, r2, this) != r0) goto L44;
        return r0;
    L14:
        if (((l) this.this$0.getUiState().getValue()).a.size() != 1) goto L40;
        String r15 = BgSelectViewModel.access$getBgImageEditInfo$p(this.this$0).f;
        if (r15 != null) goto L18;
    L21:
        boolean r16 = true;
    L22:
        if (r16 == false) goto L37;
        String r17 = BgSelectViewModel.access$getBgImageEditInfo$p(this.this$0).g;
        if (r17 == null) goto L34;
        Uri r18 = UriProtector.parse(r17);
        if (r18 == null) goto L34;
        if (Intrinsics.areEqual(r18.getScheme(), ShareType.FILE) == true) goto L31;
        r18 = null;
    L31:
        Uri r6 = r18;
        if (r6 == null) goto L34;
        BotImageUploadViewModel.upload$default(BgSelectViewModel.access$getUploadViewModel(this.this$0), r6, 6, false, 4, null);
    L34:
        BgSelectViewModel r19 = this.this$0;
        this.label = 1;
        if (BgSelectViewModel.access$genBg(r19, 0, this) != r0) goto L44;
        return r0;
    L37:
        BgSelectViewModel r110 = this.this$0;
        this.label = 2;
        if (BgSelectViewModel.access$genBg(r110, 0, this) != r0) goto L44;
        return r0;
    L18:
        if (StringsKt.isBlank(r15) == true) goto L21;
        r16 = false;
        goto L22
    }
}
