package com.larus.share.impl.sdk.special;

import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.share.impl.sdk.special.ShareImageSpecialHandler$handleShareImage$1", f = "ShareImageSpecialHandler.kt", i = {}, l = {418}, m = "invokeSuspend", n = {}, s = {})
public final class ShareImageSpecialHandler$handleShareImage$1 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
    final /* synthetic */ String $imageUrl;
    final /* synthetic */ com.larus.bmhome.share.panel.b $shareContent;
    final /* synthetic */ Integer $taskType;
    int label;
    final /* synthetic */ ShareImageSpecialHandler this$0;

    public ShareImageSpecialHandler$handleShareImage$1(String r1, Integer r2, ShareImageSpecialHandler r3, com.larus.bmhome.share.panel.b r4, Continuation<? super ShareImageSpecialHandler$handleShareImage$1> r5) {
        this.$imageUrl = r1;
        this.$taskType = r2;
        this.this$0 = r3;
        this.$shareContent = r4;
        super(1, r5);
    }

    public final Continuation<Unit> create(Continuation<?> r8) {
        return new ShareImageSpecialHandler$handleShareImage$1(this.$imageUrl, this.$taskType, this.this$0, this.$shareContent, r8);
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
    L21:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        IAIChatUgcAIGCService.Companion r2 = IAIChatUgcAIGCService.a;
        String r11 = this.$imageUrl;
        Integer r3 = this.$taskType;
        String r4 = "";
        if (r3 == null) goto L11;
        String r5 = "Creation";
    L12:
        if (r3 == null) goto L14;
        ShareImageSpecialHandler r6 = this.this$0;
        int r7 = r3.intValue();
        r6.getClass();
        String r8 = ShareImageSpecialHandler.k(r7);
    L15:
        if (r8 == null) goto L18;
        r4 = r8;
    L18:
        com.larus.bmhome.share.panel.b r9 = this.$shareContent;
        boolean r12 = r9.q;
        String r13 = r9.s;
        this.label = 1;
        r10 = r2.D(r11, r5, r4, "image", r12, r13, this);
        if (r10 != r0) goto L21;
        return r0;
    L14:
        r8 = null;
        goto L15
    L11:
        r5 = "";
        goto L12
    }
}
