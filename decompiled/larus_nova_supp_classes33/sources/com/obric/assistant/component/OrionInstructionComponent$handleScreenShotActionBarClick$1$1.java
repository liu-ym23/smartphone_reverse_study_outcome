package com.obric.assistant.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import com.larus.bmhome.chat.component.bottom.multimodal.MultimodalBizScene;
import com.obric.assistant.util.BitmapHelper;
import java.io.File;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.component.OrionInstructionComponent$handleScreenShotActionBarClick$1$1", f = "OrionInstructionComponent.kt", i = {}, l = {1889}, m = "invokeSuspend", n = {}, s = {})
final class OrionInstructionComponent$handleScreenShotActionBarClick$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $fileId;
    final /* synthetic */ Bitmap $it;
    int label;
    final /* synthetic */ OrionInstructionComponent this$0;

    public OrionInstructionComponent$handleScreenShotActionBarClick$1$1(OrionInstructionComponent r1, Bitmap r2, long r3, Continuation<? super OrionInstructionComponent$handleScreenShotActionBarClick$1$1> r5) {
        this.this$0 = r1;
        this.$it = r2;
        this.$fileId = r3;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new OrionInstructionComponent$handleScreenShotActionBarClick$1$1(this.this$0, this.$it, this.$fileId, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L11:
        File r12 = (File) r11;
        if (r12 == null) goto L17;
        OrionInstructionComponent r2 = this.this$0;
        int r3 = OrionInstructionComponent.p1;
        com.larus.bmhome.chat.component.bottom.multimodal.g r4 = r2.W3();
        if (r4 == null) goto L17;
        r4.gx(new com.larus.bmhome.chat.component.bottom.multimodal.n(CollectionsKt.listOf(new com.larus.bmhome.chat.component.bottom.multimodal.a.a(Uri.fromFile(r12), null, 2)), new com.larus.bmhome.chat.component.bottom.multimodal.g1(true, MultimodalBizScene.ObricSpecialType, false), null, MapsKt.mapOf(new Pair[]{TuplesKt.to("enter_method_trace", "obric_screen_qa"), TuplesKt.to("is_from_obric_action_bar", "obric_screen_qa")}), null, 20));
    L17:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        int r13 = BitmapHelper.a;
        Context r14 = this.this$0.getContext();
        Bitmap r5 = this.$it;
        String r6 = this.$fileId + ".jpg";
        this.label = 1;
        r11 = BitmapHelper.a(r14, r5, r6, this);
        if (r11 != r0) goto L11;
        return r0;
    }
}
