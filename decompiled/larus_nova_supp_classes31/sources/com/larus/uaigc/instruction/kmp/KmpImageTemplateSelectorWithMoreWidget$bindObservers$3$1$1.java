package com.larus.uaigc.instruction.kmp;

import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.OptionItem;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationImage;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateImage;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/larus/bmhome/creative/utils/ImageTemplateChooseData;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.instruction.kmp.KmpImageTemplateSelectorWithMoreWidget$bindObservers$3$1$1", f = "KmpImageTemplateSelectorWithMoreWidget.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class KmpImageTemplateSelectorWithMoreWidget$bindObservers$3$1$1 extends SuspendLambda implements Function2<com.larus.bmhome.creative.utils.b, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ KmpImageTemplateSelectorWithMoreWidget this$0;

    public KmpImageTemplateSelectorWithMoreWidget$bindObservers$3$1$1(KmpImageTemplateSelectorWithMoreWidget r1, Continuation<? super KmpImageTemplateSelectorWithMoreWidget$bindObservers$3$1$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        KmpImageTemplateSelectorWithMoreWidget$bindObservers$3$1$1 r0 = new KmpImageTemplateSelectorWithMoreWidget$bindObservers$3$1$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(com.larus.bmhome.creative.utils.b r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((com.larus.bmhome.creative.utils.b) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r23) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L94;
        ResultKt.throwOnFailure(r23);
        com.larus.bmhome.creative.utils.b r1 = (com.larus.bmhome.creative.utils.b) this.L$0;
        boolean r2 = r1.c;
        if (r2 == false) goto L9;
        TemplateInfo$TemplateInfo r4 = r1.a;
        if (r4 == null) goto L9;
        r1.c = false;
        this.this$0.p.invoke(r4, r1.b, r1.e);
    L92:
        return Unit.INSTANCE;
    L9:
        if (r2 == false) goto L92;
        UserCreation r3 = r1.d;
        if (r3 == null) goto L92;
        r1.c = false;
        g r5 = this.this$0.p;
        String r6 = r3.a;
        long r7 = 0;
        if (r6 == null) goto L17;
        Long r8 = StringsKt.toLongOrNull(r6);
        if (r8 == null) goto L17;
        long r9 = r8.longValue();
    L18:
        UserCreation r10 = r1.d;
        TemplateInfo$TemplateImage r11 = null;
        if (r10 == null) goto L25;
        UserCreationContent r12 = r10.e;
        if (r12 == null) goto L25;
        UserCreationImage r13 = r12.a;
        if (r13 == null) goto L25;
        String r14 = r13.c;
    L26:
        if (r10 == null) goto L36;
        UserCreationContent r15 = r10.e;
        if (r15 == null) goto L36;
        UserCreationImage r16 = r15.a;
        if (r16 == null) goto L36;
        ImageInfo r17 = r16.a;
        if (r17 == null) goto L36;
        Image r18 = r17.b;
        if (r18 == null) goto L36;
        TemplateInfo$TemplateImage r19 = io8.a.a(r18);
    L37:
        UserCreation r110 = r1.d;
        if (r110 == null) goto L48;
        UserCreationContent r111 = r110.e;
        if (r111 == null) goto L48;
        UserCreationImage r112 = r111.a;
        if (r112 == null) goto L48;
        ImageInfo r113 = r112.a;
        if (r113 == null) goto L48;
        Image r114 = r113.a;
        if (r114 == null) goto L48;
        TemplateInfo$TemplateImage r115 = io8.a.a(r114);
    L49:
        UserCreation r116 = r1.d;
        if (r116 == null) goto L60;
        UserCreationContent r117 = r116.e;
        if (r117 == null) goto L60;
        UserCreationImage r118 = r117.a;
        if (r118 == null) goto L60;
        ImageInfo r119 = r118.a;
        if (r119 == null) goto L60;
        Image r120 = r119.c;
        if (r120 == null) goto L60;
        r11 = io8.a.a(r120);
    L60:
        TemplateInfo$TemplateImage r121 = r11;
        UserCreation r20 = r1.d;
        long r122 = -1;
        if (r20 == null) goto L71;
        UserCreationContent r21 = r20.e;
        if (r21 == null) goto L71;
        UserCreationImage r22 = r21.a;
        if (r22 == null) goto L71;
        OptionItem r24 = r22.d;
        if (r24 == null) goto L71;
        Long r25 = r24.a;
        if (r25 == null) goto L71;
        long r123 = r25.longValue();
    L72:
        UserCreation r26 = r1.d;
        if (r26 == null) goto L83;
        UserCreationContent r27 = r26.e;
        if (r27 == null) goto L83;
        UserCreationImage r28 = r27.a;
        if (r28 == null) goto L83;
        OptionItem r29 = r28.e;
        if (r29 == null) goto L83;
        Long r30 = r29.a;
        if (r30 == null) goto L83;
        r122 = r30.longValue();
    L83:
        long r124 = r122;
        UserCreation r31 = r1.d;
        if (r31 == null) goto L90;
        String r32 = r31.a;
        if (r32 == null) goto L90;
        Long r33 = StringsKt.toLongOrNull(r32);
        if (r33 == null) goto L90;
        r7 = r33.longValue();
    L90:
        r5.invoke(new TemplateInfo$TemplateInfo(r9, r14, r19, r115, r121, r123, r124, r7, r3, 2), r1.b, r1.e);
    L71:
        r123 = -1;
    L48:
        r115 = null;
    L36:
        r19 = null;
    L25:
        r14 = null;
    L17:
        r9 = 0;
        goto L18
    L94:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
