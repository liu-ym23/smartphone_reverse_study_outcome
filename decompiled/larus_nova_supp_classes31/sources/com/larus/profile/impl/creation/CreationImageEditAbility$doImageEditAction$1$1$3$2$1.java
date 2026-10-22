package com.larus.profile.impl.creation;

import android.graphics.Bitmap;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.creation.CreationImageEditAbility$doImageEditAction$1$1$3$2$1", f = "CreationImageEditAbility.kt", i = {}, l = {208}, m = "invokeSuspend", n = {}, s = {})
public final class CreationImageEditAbility$doImageEditAction$1$1$3$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.bmhome.actionbar.model.r $conf;
    final /* synthetic */ CreationImageEditAbility$doImageEditAction$1.a $hitPointData;
    final /* synthetic */ Map<String, String> $instructionParamMap;
    final /* synthetic */ String $instructionParams;
    final /* synthetic */ com.larus.bmhome.actionbar.model.p1 $msgTemplate;
    final /* synthetic */ com.larus.uaigc.api.q $result;
    final /* synthetic */ String $upScreenText;
    final /* synthetic */ String $uri;
    final /* synthetic */ List<com.larus.bmhome.actionbar.model.u> $userSelectedInstructionItemList;
    int label;
    final /* synthetic */ CreationImageEditAbility this$0;

    public CreationImageEditAbility$doImageEditAction$1$1$3$2$1(CreationImageEditAbility r1, String r2, com.larus.uaigc.api.q r3, com.larus.bmhome.actionbar.model.p1 r4, String r5, CreationImageEditAbility$doImageEditAction$1.a r6, List<com.larus.bmhome.actionbar.model.u> r7, Map<String, String> r8, com.larus.bmhome.actionbar.model.r r9, String r10, Continuation<? super CreationImageEditAbility$doImageEditAction$1$1$3$2$1> r11) {
        this.this$0 = r1;
        this.$uri = r2;
        this.$result = r3;
        this.$msgTemplate = r4;
        this.$upScreenText = r5;
        this.$hitPointData = r6;
        this.$userSelectedInstructionItemList = r7;
        this.$instructionParamMap = r8;
        this.$conf = r9;
        this.$instructionParams = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
        return new CreationImageEditAbility$doImageEditAction$1$1$3$2$1(this.this$0, this.$uri, this.$result, this.$msgTemplate, this.$upScreenText, this.$hitPointData, this.$userSelectedInstructionItemList, this.$instructionParamMap, this.$conf, this.$instructionParams, r14);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r18);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r18);
        final CreationImageEditAbility r3 = this.this$0;
        String r15 = r3.c.a;
        final String r6 = this.$uri;
        final com.larus.uaigc.api.q r7 = this.$result;
        final com.larus.bmhome.actionbar.model.p1 r8 = this.$msgTemplate;
        final String r9 = this.$upScreenText;
        final CreationImageEditAbility$doImageEditAction$1.a r10 = this.$hitPointData;
        final List<com.larus.bmhome.actionbar.model.u> r11 = this.$userSelectedInstructionItemList;
        final Map<String, String> r12 = this.$instructionParamMap;
        final com.larus.bmhome.actionbar.model.r r13 = this.$conf;
        final String r14 = this.$instructionParams;
        Function1<? super Bitmap, Unit> r5 = new f1(r3, r6, r7, r8, r9, r10, r11, r12, r13, r14);
        this.label = 1;
        if (r3.d(r15, r5, null, this) != r1) goto L12;
        return r1;
    }
}
