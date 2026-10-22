package com.larus.bmhome.view.actionbar.edit.component;

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
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.component.CommandWidget$parseGaokaoPreference$1$1", f = "CommandWidget.kt", i = {}, l = {608}, m = "invokeSuspend", n = {}, s = {})
final class CommandWidget$parseGaokaoPreference$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.bmhome.actionbar.model.c $commandData;
    int label;
    final /* synthetic */ CommandWidget this$0;

    public CommandWidget$parseGaokaoPreference$1$1(CommandWidget r1, com.larus.bmhome.actionbar.model.c r2, Continuation<? super CommandWidget$parseGaokaoPreference$1$1> r3) {
        this.this$0 = r1;
        this.$commandData = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CommandWidget$parseGaokaoPreference$1$1(this.this$0, this.$commandData, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [android.view.ViewGroup, com.larus.bmhome.view.actionbar.edit.component.CommandWidget] */
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
        t19.s.a.g(this.this$0.getContext(), 2131900505, false);
    L18:
        return Unit.INSTANCE;
    L14:
        if (r5.getData() == null) goto L16;
        final ?? r2 = this.this$0;
        final com.larus.bmhome.actionbar.model.c r3 = this.$commandData;
        r2.p = new x0(r2, r3);
        WeakReference<Function1<String, Unit>> r6 = GaokaoPreferenceDialogActivity.h;
        GaokaoPreferenceDialogActivity.a.a(r2.getContext(), (GaokaoProvinceConfResponse) r5.getData(), this.this$0.p, null);
        goto L18
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        PreloadGaokaoProvinceConfHelper r7 = PreloadGaokaoProvinceConfHelper.a;
        this.label = 1;
        r4 = PreloadGaokaoProvinceConfHelper.b(this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
