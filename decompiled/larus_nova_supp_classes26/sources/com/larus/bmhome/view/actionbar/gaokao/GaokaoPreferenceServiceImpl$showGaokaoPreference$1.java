package com.larus.bmhome.view.actionbar.gaokao;

import androidx.fragment.app.FragmentActivity;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.gaokao.GaokaoPreferenceServiceImpl$showGaokaoPreference$1", f = "GaokaoPreferenceServiceImpl.kt", i = {}, l = {24}, m = "invokeSuspend", n = {}, s = {})
final class GaokaoPreferenceServiceImpl$showGaokaoPreference$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ Function0<Unit> $onError;
    final /* synthetic */ Function1<String, Unit> $onTextSelected;
    final /* synthetic */ PreloadGaokaoProvinceConfHelper $preloadHelper;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public GaokaoPreferenceServiceImpl$showGaokaoPreference$1(PreloadGaokaoProvinceConfHelper r1, FragmentActivity r2, Function1<? super String, Unit> r3, Function0<Unit> r4, Continuation<? super GaokaoPreferenceServiceImpl$showGaokaoPreference$1> r5) {
        this.$preloadHelper = r1;
        this.$activity = r2;
        this.$onTextSelected = r3;
        this.$onError = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new GaokaoPreferenceServiceImpl$showGaokaoPreference$1(this.$preloadHelper, this.$activity, this.$onTextSelected, this.$onError, r8);
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
        GaokaoProvinceConfResponse r2 = (GaokaoProvinceConfResponse) r5.getData();
        if (r5.isSuccess() == false) goto L15;
        if (r2 == null) goto L15;
        WeakReference<Function1<String, Unit>> r6 = GaokaoPreferenceDialogActivity.h;
        GaokaoPreferenceDialogActivity.a.a(this.$activity, r2, this.$onTextSelected, null);
    L19:
        return Unit.INSTANCE;
    L15:
        Function0<Unit> r7 = this.$onError;
        if (r7 == null) goto L19;
        r7.invoke();
        goto L19
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        PreloadGaokaoProvinceConfHelper r8 = this.$preloadHelper;
        this.label = 1;
        r8.getClass();
        r4 = PreloadGaokaoProvinceConfHelper.b(this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
