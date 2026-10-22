package com.larus.uaigc.createpage.component.stylelist;

import com.larus.bmhome.actionbar.model.w;
import com.larus.im.bean.message.Image;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import ny9.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.stylelist.ImageStyleListComponent$preloadImageStyleList$1", f = "ImageStyleListComponent.kt", i = {}, l = {180, 187}, m = "invokeSuspend", n = {}, s = {})
final class ImageStyleListComponent$preloadImageStyleList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ImageStyleListComponent this$0;

    public ImageStyleListComponent$preloadImageStyleList$1(ImageStyleListComponent r1, Continuation<? super ImageStyleListComponent$preloadImageStyleList$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ImageStyleListComponent$preloadImageStyleList$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 == 2) goto L9;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
    L55:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r6);
        ImageStyleListComponent r7 = this.this$0;
        int r2 = ImageStyleListComponent.p;
        s r8 = (s) r7.o.getValue();
        List<w> r3 = null;
        if (r8 == null) goto L13;
        String r9 = r8.o();
    L15:
        if (r9 != null) goto L17;
    L20:
        boolean r10 = true;
    L21:
        if (r10 == false) goto L41;
        s r11 = (s) this.this$0.o.getValue();
        if (r11 == null) goto L25;
        String r12 = r11.p();
    L26:
        if (r12 != null) goto L28;
    L31:
        boolean r13 = true;
    L32:
        if (r13 == false) goto L41;
        s r14 = (s) this.this$0.o.getValue();
        if (r14 == null) goto L36;
        Image r15 = r14.r();
    L37:
        if (r15 != null) goto L41;
        ImageStyleListComponent r16 = this.this$0;
        this.label = 1;
        if (r16.N2(true, this) != r0) goto L55;
        return r0;
    L36:
        r15 = null;
        goto L37
    L28:
        if (r12.length() == 0) goto L31;
        r13 = false;
        goto L32
    L25:
        r12 = null;
    L41:
        ImageStyleListComponent r17 = this.this$0;
        if (r17.j == false) goto L55;
        List<w> r4 = r17.l;
        if (r4 != null) goto L48;
        ys8.a r5 = r17.L2();
        if (r5 == null) goto L49;
        r3 = r5.getCurImageList();
    L49:
        r17.l = r3;
        ImageStyleListComponent r18 = this.this$0;
        if (r18.h == true) goto L55;
        this.label = 2;
        if (r18.N2(false, this) != r0) goto L55;
        return r0;
    L48:
        r3 = r4;
        goto L49
    L17:
        if (r9.length() == 0) goto L20;
        r10 = false;
        goto L21
    L13:
        r9 = null;
        goto L15
    }
}
