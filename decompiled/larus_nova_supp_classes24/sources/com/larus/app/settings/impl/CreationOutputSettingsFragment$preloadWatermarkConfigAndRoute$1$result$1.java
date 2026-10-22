package com.larus.app.settings.impl;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.network.bean.BizResponse;
import com.larus.uaigc.api.SettingWatermarkConfigApi;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/uaigc/api/GetSettingWatermarkConfigData;", "Lcom/larus/uaigc/api/SettingWatermarkConfigApi;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.app.settings.impl.CreationOutputSettingsFragment$preloadWatermarkConfigAndRoute$1$result$1", f = "CreationOutputSettingsActivity.kt", i = {}, l = {224}, m = "invokeSuspend", n = {}, s = {})
public final class CreationOutputSettingsFragment$preloadWatermarkConfigAndRoute$1$result$1 extends SuspendLambda implements Function2<SettingWatermarkConfigApi, Continuation<? super BizResponse<com.larus.uaigc.api.k>>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public CreationOutputSettingsFragment$preloadWatermarkConfigAndRoute$1$result$1(Continuation<? super CreationOutputSettingsFragment$preloadWatermarkConfigAndRoute$1$result$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        CreationOutputSettingsFragment$preloadWatermarkConfigAndRoute$1$result$1 r0 = new CreationOutputSettingsFragment$preloadWatermarkConfigAndRoute$1$result$1(r3);
        r0.L$0 = r2;
        return r0;
    }

    public final Object invoke(SettingWatermarkConfigApi r1, Continuation<? super BizResponse<com.larus.uaigc.api.k>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((SettingWatermarkConfigApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        return r7;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        SettingWatermarkConfigApi r8 = (SettingWatermarkConfigApi) this.L$0;
        com.larus.uaigc.api.l r2 = new com.larus.uaigc.api.l(CollectionsKt.listOf(new Integer[]{Boxing.boxInt(150), Boxing.boxInt(151)}));
        this.label = 1;
        r7 = r8.getConfig(r2, this);
        if (r7 != r0) goto L11;
        return r0;
    }
}
