package com.larus.app.settings.impl;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.network.bean.BizResponse;
import com.larus.uaigc.api.SettingWatermarkConfigApi;
import java.util.LinkedHashMap;
import java.util.Map;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/uaigc/api/SetSettingWatermarkConfigData;", "Lcom/larus/uaigc/api/SettingWatermarkConfigApi;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.app.settings.impl.RemoveAiWatermarkFragment$updateWatermarkConfig$1$result$1", f = "RemoveAiWatermarkActivity.kt", i = {}, l = {192}, m = "invokeSuspend", n = {}, s = {})
public final class RemoveAiWatermarkFragment$updateWatermarkConfig$1$result$1 extends SuspendLambda implements Function2<SettingWatermarkConfigApi, Continuation<? super BizResponse<com.larus.uaigc.api.t>>, Object> {
    final /* synthetic */ int $configType;
    final /* synthetic */ boolean $isOn;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RemoveAiWatermarkFragment this$0;

    public RemoveAiWatermarkFragment$updateWatermarkConfig$1$result$1(int r1, boolean r2, RemoveAiWatermarkFragment r3, Continuation<? super RemoveAiWatermarkFragment$updateWatermarkConfig$1$result$1> r4) {
        this.$configType = r1;
        this.$isOn = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        RemoveAiWatermarkFragment$updateWatermarkConfig$1$result$1 r0 = new RemoveAiWatermarkFragment$updateWatermarkConfig$1$result$1(this.$configType, this.$isOn, this.this$0, r6);
        r0.L$0 = r5;
        return r0;
    }

    public final Object invoke(SettingWatermarkConfigApi r1, Continuation<? super BizResponse<com.larus.uaigc.api.t>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((SettingWatermarkConfigApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L15:
        return r9;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        SettingWatermarkConfigApi r10 = (SettingWatermarkConfigApi) this.L$0;
        int r4 = this.$configType;
        boolean r5 = this.$isOn;
        Map<Integer, Long> r6 = this.this$0.h;
        LinkedHashMap r7 = (LinkedHashMap) r6;
        Long r8 = (Long) r7.get(Boxing.boxInt(r4));
        if (r8 == null) goto L11;
        long r11 = r8.longValue();
    L12:
        com.larus.uaigc.api.u r2 = new com.larus.uaigc.api.u(CollectionsKt.listOf(new com.larus.uaigc.api.v(r4, r5 ? 1 : 0, r11)));
        this.label = 1;
        r9 = r10.setConfig(r2, this);
        if (r9 != r0) goto L15;
        return r0;
    L11:
        r11 = 0;
        goto L12
    }
}
