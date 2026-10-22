package com.larus.bmhome.instruction;

import android.content.Context;
import com.larus.bmhome.view.actionbar.gaokao.GaokaoPreferenceDialogActivity;
import com.larus.bmhome.view.actionbar.gaokao.network.GaokaoProvinceConfResponse;
import com.larus.bmhome.view.actionbar.gaokao.network.PreloadGaokaoProvinceConfHelper;
import com.larus.network.bean.BizResponse;
import java.lang.ref.WeakReference;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.instruction.InstructionInputComponent$openGaokaoPreferenceDialog$1", f = "InstructionInputComponent.kt", i = {}, l = {2101}, m = "invokeSuspend", n = {}, s = {})
final class InstructionInputComponent$openGaokaoPreferenceDialog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    int label;
    final /* synthetic */ InstructionInputComponent this$0;

    public InstructionInputComponent$openGaokaoPreferenceDialog$1(InstructionInputComponent r1, Context r2, Continuation<? super InstructionInputComponent$openGaokaoPreferenceDialog$1> r3) {
        this.this$0 = r1;
        this.$context = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new InstructionInputComponent$openGaokaoPreferenceDialog$1(this.this$0, this.$context, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        BizResponse r5 = (BizResponse) r4;
        if (r5.isSuccess() == true) goto L14;
    L16:
        t19.s.a.g(this.$context, 2131900505, false);
    L18:
        return Unit.INSTANCE;
    L14:
        if (r5.getData() == null) goto L16;
        final InstructionInputComponent r2 = this.this$0;
        r2.U2 = new t1(r2);
        r2.V2 = new u1(r2);
        WeakReference<Function1<String, Unit>> r3 = GaokaoPreferenceDialogActivity.h;
        Context r6 = this.$context;
        GaokaoProvinceConfResponse r7 = (GaokaoProvinceConfResponse) r5.getData();
        InstructionInputComponent r8 = this.this$0;
        GaokaoPreferenceDialogActivity.a.a(r6, r7, r8.U2, r8.V2);
        goto L18
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        PreloadGaokaoProvinceConfHelper r9 = PreloadGaokaoProvinceConfHelper.a;
        this.label = 1;
        r4 = PreloadGaokaoProvinceConfHelper.b(this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
