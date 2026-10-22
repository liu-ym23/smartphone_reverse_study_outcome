package com.larus.uaigc.instruction.kmp;

import com.larus.bmhome.actionbar.model.w;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.OptionItem;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationImage;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateImage;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;
import com.larus.uaigc.impl.databinding.LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding;
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
@DebugMetadata(c = "com.larus.uaigc.instruction.kmp.KmpDropFeatureSelectorWidget$bindObservers$3$1$1", f = "KmpDropFeatureSelectorWidget.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class KmpDropFeatureSelectorWidget$bindObservers$3$1$1 extends SuspendLambda implements Function2<com.larus.bmhome.creative.utils.b, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ KmpDropFeatureSelectorWidget this$0;

    public KmpDropFeatureSelectorWidget$bindObservers$3$1$1(KmpDropFeatureSelectorWidget r1, Continuation<? super KmpDropFeatureSelectorWidget$bindObservers$3$1$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        KmpDropFeatureSelectorWidget$bindObservers$3$1$1 r0 = new KmpDropFeatureSelectorWidget$bindObservers$3$1$1(this.this$0, r4);
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
        if (this.label != 0) goto L115;
        ResultKt.throwOnFailure(r23);
        com.larus.bmhome.creative.utils.b r1 = (com.larus.bmhome.creative.utils.b) this.L$0;
        boolean r2 = r1.c;
        if (r2 == false) goto L9;
        TemplateInfo$TemplateInfo r4 = r1.a;
        if (r4 == null) goto L9;
        r1.c = false;
        this.this$0.n.invoke(r4, r1.b, r1.e);
    L113:
        return Unit.INSTANCE;
    L9:
        LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding r5 = null;
        TemplateInfo$TemplateImage r6 = null;
        r6 = null;
        r6 = null;
        r6 = null;
        r6 = null;
        if (r2 == false) goto L93;
        UserCreation r14 = r1.d;
        if (r14 == null) goto L93;
        r1.c = false;
        b r3 = this.this$0.n;
        String r7 = r14.a;
        if (r7 == null) goto L18;
        Long r8 = StringsKt.toLongOrNull(r7);
        if (r8 == null) goto L18;
        long r9 = r8.longValue();
    L19:
        UserCreation r10 = r1.d;
        if (r10 == null) goto L26;
        UserCreationContent r11 = r10.e;
        if (r11 == null) goto L26;
        UserCreationImage r12 = r11.a;
        if (r12 == null) goto L26;
        String r13 = r12.c;
    L27:
        if (r10 == null) goto L37;
        UserCreationContent r15 = r10.e;
        if (r15 == null) goto L37;
        UserCreationImage r16 = r15.a;
        if (r16 == null) goto L37;
        ImageInfo r17 = r16.a;
        if (r17 == null) goto L37;
        Image r18 = r17.b;
        if (r18 == null) goto L37;
        TemplateInfo$TemplateImage r19 = io8.a.a(r18);
    L38:
        UserCreation r110 = r1.d;
        if (r110 == null) goto L49;
        UserCreationContent r111 = r110.e;
        if (r111 == null) goto L49;
        UserCreationImage r112 = r111.a;
        if (r112 == null) goto L49;
        ImageInfo r113 = r112.a;
        if (r113 == null) goto L49;
        Image r114 = r113.a;
        if (r114 == null) goto L49;
        TemplateInfo$TemplateImage r115 = io8.a.a(r114);
    L50:
        UserCreation r116 = r1.d;
        if (r116 == null) goto L61;
        UserCreationContent r117 = r116.e;
        if (r117 == null) goto L61;
        UserCreationImage r118 = r117.a;
        if (r118 == null) goto L61;
        ImageInfo r119 = r118.a;
        if (r119 == null) goto L61;
        Image r120 = r119.c;
        if (r120 == null) goto L61;
        r6 = io8.a.a(r120);
    L61:
        TemplateInfo$TemplateImage r121 = r6;
        UserCreation r20 = r1.d;
        long r122 = -1;
        if (r20 == null) goto L72;
        UserCreationContent r21 = r20.e;
        if (r21 == null) goto L72;
        UserCreationImage r22 = r21.a;
        if (r22 == null) goto L72;
        OptionItem r24 = r22.d;
        if (r24 == null) goto L72;
        Long r25 = r24.a;
        if (r25 == null) goto L72;
        long r123 = r25.longValue();
    L73:
        UserCreation r26 = r1.d;
        if (r26 == null) goto L84;
        UserCreationContent r27 = r26.e;
        if (r27 == null) goto L84;
        UserCreationImage r28 = r27.a;
        if (r28 == null) goto L84;
        OptionItem r29 = r28.e;
        if (r29 == null) goto L84;
        Long r30 = r29.a;
        if (r30 == null) goto L84;
        r122 = r30.longValue();
    L84:
        long r124 = r122;
        UserCreation r31 = r1.d;
        if (r31 == null) goto L91;
        String r32 = r31.a;
        if (r32 == null) goto L91;
        Long r33 = StringsKt.toLongOrNull(r32);
        if (r33 == null) goto L91;
        long r125 = r33.longValue();
    L92:
        r3.invoke(new TemplateInfo$TemplateInfo(r9, r13, r19, r115, r121, r123, r124, r125, r14, 2), r1.b, r1.e);
    L91:
        r125 = 0;
    L72:
        r123 = -1;
    L49:
        r115 = null;
    L37:
        r19 = null;
    L26:
        r13 = null;
    L18:
        r9 = 0;
    L93:
        if (r2 == false) goto L113;
        if (r1.f == false) goto L113;
        com.larus.bmhome.actionbar.model.h r34 = KmpDropFeatureSelectorWidget.Y5(this.this$0);
        if (r34 == null) goto L104;
        List r35 = r34.e;
        if (r35 == null) goto L104;
        Iterator r36 = r35.iterator();
    L102:
        if (r36.hasNext() == false) goto L104;
        ((w) r36.next()).s = Boxing.boxInt(0);
    L104:
        LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding r37 = this.this$0.f;
        if (r37 != null) goto L107;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r37 = null;
    L107:
        e1.o(r37.f);
        LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding r38 = this.this$0.f;
        if (r38 != null) goto L110;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L111:
        r5.f.setText("");
        this.this$0.Z5();
        goto L113
    L110:
        r5 = r38;
        goto L111
    L115:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
