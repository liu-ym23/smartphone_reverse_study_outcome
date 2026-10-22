package com.larus.bmhome.chat.layout.holder.menu.item;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageEntity;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageItem;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.uaigc.utils.DataConverterKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.menu.item.SaveImageMenuHandler$handleAction$6", f = "SaveMenuItem.kt", i = {}, l = {448}, m = "invokeSuspend", n = {}, s = {})
public final class SaveImageMenuHandler$handleAction$6 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
    final /* synthetic */ ImageItem $imageItem;
    final /* synthetic */ String $imgUrl;
    final /* synthetic */ boolean $isAIGC;
    final /* synthetic */ ef8.b $menuContext;
    int label;

    public SaveImageMenuHandler$handleAction$6(String r1, ImageItem r2, ef8.b r3, boolean r4, Continuation<? super SaveImageMenuHandler$handleAction$6> r5) {
        this.$imgUrl = r1;
        this.$imageItem = r2;
        this.$menuContext = r3;
        this.$isAIGC = r4;
        super(1, r5);
    }

    public final Continuation<Unit> create(Continuation<?> r8) {
        return new SaveImageMenuHandler$handleAction$6(this.$imgUrl, this.$imageItem, this.$menuContext, this.$isAIGC, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super String> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L58:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        IUgcAIGCService.Companion r2 = IUgcAIGCService.a;
        String r11 = this.$imgUrl;
        ImageItem r4 = this.$imageItem;
        String r5 = null;
        if (r4 == null) goto L13;
        Integer r6 = r4.getTaskType();
        if (r6 == null) goto L13;
        String r7 = DataConverterKt.h(r6.intValue());
    L14:
        if (r7 != null) goto L16;
    L19:
        boolean r8 = true;
    L20:
        if (r8 == false) goto L23;
        r7 = null;
    L23:
        if (r7 != null) goto L27;
        r7 = ap8.a.b(this.$menuContext.a);
        if (r7 != null) goto L27;
        r7 = "";
    L27:
        boolean r9 = this.$isAIGC;
        if (r9 == false) goto L54;
        ImageItem r12 = this.$imageItem;
        if (r12 == null) goto L35;
        ImageEntity r13 = r12.getImageOrigin();
        if (r13 == null) goto L35;
        String r14 = r13.getUri();
        if (r14 == null) goto L35;
    L55:
        this.label = 1;
        r10 = r2.D(r11, "Creation", r7, "image", r9, r14, this);
        if (r10 != r0) goto L58;
        return r0;
    L35:
        ImageItem r15 = this.$imageItem;
        if (r15 == null) goto L40;
        ImageEntity r16 = r15.getPreviewImage();
        if (r16 == null) goto L40;
        r14 = r16.getUri();
    L41:
        if (r14 != null) goto L55;
        ImageItem r17 = this.$imageItem;
        if (r17 == null) goto L47;
        ImageEntity r18 = r17.getImageThumb();
        if (r18 == null) goto L47;
        r14 = r18.getUri();
    L48:
        if (r14 != null) goto L55;
        ImageItem r19 = this.$imageItem;
        if (r19 == null) goto L54;
        ImageEntity r20 = r19.getRawImage();
        if (r20 == null) goto L54;
        r5 = r20.getUri();
    L47:
        r14 = null;
    L40:
        r14 = null;
    L54:
        r14 = r5;
        goto L55
    L16:
        if (r7.length() == 0) goto L19;
        r8 = false;
    L13:
        r7 = null;
        goto L14
    }
}
