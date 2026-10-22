package com.larus.uaigc.instruction;

import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.OptionItem;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationImage;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateImage;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;
import com.larus.utils.e1;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.List;
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
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/larus/bmhome/creative/utils/ImageTemplateChooseData;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.instruction.DropFeatureSelectorWidget$bindObservers$3$1$1", f = "DropFeatureSelectorWidget.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DropFeatureSelectorWidget$bindObservers$3$1$1 extends SuspendLambda implements Function2<com.larus.bmhome.creative.utils.b, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DropFeatureSelectorWidget this$0;

    public DropFeatureSelectorWidget$bindObservers$3$1$1(DropFeatureSelectorWidget r1, Continuation<? super DropFeatureSelectorWidget$bindObservers$3$1$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        DropFeatureSelectorWidget$bindObservers$3$1$1 r0 = new DropFeatureSelectorWidget$bindObservers$3$1$1(this.this$0, r4);
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
        if (this.label != 0) goto L106;
        ResultKt.throwOnFailure(r23);
        com.larus.bmhome.creative.utils.b r1 = (com.larus.bmhome.creative.utils.b) this.L$0;
        boolean r2 = r1.c;
        if (r2 == false) goto L9;
        TemplateInfo$TemplateInfo r4 = r1.a;
        if (r4 == null) goto L9;
        r1.c = false;
        t r3 = this.this$0.j;
        Intrinsics.checkNotNull(r4);
        r3.invoke(r4, r1.b, r1.e);
    L104:
        return Unit.INSTANCE;
    L9:
        if (r2 == false) goto L91;
        UserCreation r5 = r1.d;
        if (r5 == null) goto L91;
        r1.c = false;
        t r6 = this.this$0.j;
        String r7 = r5.a;
        long r8 = 0;
        if (r7 == null) goto L17;
        Long r9 = StringsKt.toLongOrNull(r7);
        if (r9 == null) goto L17;
        long r10 = r9.longValue();
    L18:
        UserCreation r11 = r1.d;
        TemplateInfo$TemplateImage r12 = null;
        if (r11 == null) goto L25;
        UserCreationContent r13 = r11.e;
        if (r13 == null) goto L25;
        UserCreationImage r14 = r13.a;
        if (r14 == null) goto L25;
        String r15 = r14.c;
    L26:
        if (r11 == null) goto L36;
        UserCreationContent r16 = r11.e;
        if (r16 == null) goto L36;
        UserCreationImage r17 = r16.a;
        if (r17 == null) goto L36;
        ImageInfo r18 = r17.a;
        if (r18 == null) goto L36;
        Image r19 = r18.b;
        if (r19 == null) goto L36;
        TemplateInfo$TemplateImage r20 = io8.a.a(r19);
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
        r12 = io8.a.a(r120);
    L60:
        TemplateInfo$TemplateImage r121 = r12;
        UserCreation r21 = r1.d;
        long r122 = -1;
        if (r21 == null) goto L71;
        UserCreationContent r22 = r21.e;
        if (r22 == null) goto L71;
        UserCreationImage r24 = r22.a;
        if (r24 == null) goto L71;
        OptionItem r25 = r24.d;
        if (r25 == null) goto L71;
        Long r26 = r25.a;
        if (r26 == null) goto L71;
        long r123 = r26.longValue();
    L72:
        UserCreation r27 = r1.d;
        if (r27 == null) goto L83;
        UserCreationContent r28 = r27.e;
        if (r28 == null) goto L83;
        UserCreationImage r29 = r28.a;
        if (r29 == null) goto L83;
        OptionItem r30 = r29.e;
        if (r30 == null) goto L83;
        Long r31 = r30.a;
        if (r31 == null) goto L83;
        r122 = r31.longValue();
    L83:
        long r124 = r122;
        UserCreation r32 = r1.d;
        if (r32 == null) goto L90;
        String r33 = r32.a;
        if (r33 == null) goto L90;
        Long r34 = StringsKt.toLongOrNull(r33);
        if (r34 == null) goto L90;
        r8 = r34.longValue();
    L90:
        r6.invoke(new TemplateInfo$TemplateInfo(r10, r15, r20, r115, r121, r123, r124, r8, r5, 2), r1.b, r1.e);
    L71:
        r123 = -1;
    L48:
        r115 = null;
    L36:
        r20 = null;
    L25:
        r15 = null;
    L17:
        r10 = 0;
    L91:
        if (r2 == false) goto L104;
        if (r1.f == false) goto L104;
        com.larus.bmhome.actionbar.model.h r35 = this.this$0.getCurrentBindData();
        if (r35 == null) goto L102;
        List r36 = r35.e;
        if (r36 == null) goto L102;
        Iterator r37 = r36.iterator();
    L100:
        if (r37.hasNext() == false) goto L102;
        ((com.larus.bmhome.actionbar.model.w) r37.next()).s = Boxing.boxInt(0);
    L102:
        e1.o(this.this$0.getBinding().f);
        this.this$0.getBinding().f.setText("");
        goto L104
    L106:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
