package com.larus.app.settings.impl;

import android.content.Context;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.uaigc.api.SettingWatermarkConfigApi;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.app.settings.impl.RemoveAiWatermarkFragment$updateWatermarkConfig$1", f = "RemoveAiWatermarkActivity.kt", i = {}, l = {191}, m = "invokeSuspend", n = {}, s = {})
final class RemoveAiWatermarkFragment$updateWatermarkConfig$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $configType;
    final /* synthetic */ boolean $isOn;
    int label;
    final /* synthetic */ RemoveAiWatermarkFragment this$0;

    public RemoveAiWatermarkFragment$updateWatermarkConfig$1(int r1, RemoveAiWatermarkFragment r2, boolean r3, Continuation<? super RemoveAiWatermarkFragment$updateWatermarkConfig$1> r4) {
        this.$configType = r1;
        this.this$0 = r2;
        this.$isOn = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new RemoveAiWatermarkFragment$updateWatermarkConfig$1(this.$configType, this.this$0, this.$isOn, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        List r4 = null;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L15
    L13:
        dm9.a r10 = (dm9.a) r9;     // Catch: Throwable -> L15
    L18:
        if ((r10 instanceof dm9.a.b) == false) goto L20;
        dm9.a.b r11 = (dm9.a.b) r10;
    L21:
        if (r11 != null) goto L23;
    L25:
        r11 = null;
    L26:
        if (r11 != null) goto L35;
        FLogger.a.w("RemoveAiWatermark", "set setting watermark config biz failed, configType=" + this.$configType);
        RemoveAiWatermarkFragment r12 = this.this$0;
        int r2 = this.$configType;
        boolean r3 = !this.$isOn;
        int r5 = RemoveAiWatermarkFragment.i;
        r12.X90(r2, r3);
        Context r13 = this.this$0.getContext();
        if (r13 == null) goto L34;
        t19.s r6 = t19.s.a;
        int r7 = c0.a;
        String r8 = r13.getString(2131897436);
        if (r8 != null) goto L32;
        r8 = "";
    L32:
        r6.getClass();
        t19.s.t(r13, r8);
    L34:
        return Unit.INSTANCE;
    L35:
        RemoveAiWatermarkFragment r14 = this.this$0;
        com.larus.uaigc.api.t r15 = (com.larus.uaigc.api.t) r11.a.getData();
        if (r15 == null) goto L38;
        r4 = r15.a();
    L38:
        RemoveAiWatermarkFragment.V90(r14, r4);
        return Unit.INSTANCE;
    L23:
        if (r11.a.isSuccess() == false) goto L25;
    L20:
        r11 = null;
        goto L21
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r9);
        SettingWatermarkConfigApi.Companion r16 = SettingWatermarkConfigApi.a;     // Catch: Throwable -> L15
        RemoveAiWatermarkFragment$updateWatermarkConfig$1$result$1 r17 = new RemoveAiWatermarkFragment$updateWatermarkConfig$1$result$1(this.$configType, this.$isOn, this.this$0, null);     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r16.getClass();     // Catch: Throwable -> L15
        r9 = SettingWatermarkConfigApi.Companion.a(r17, this);     // Catch: Throwable -> L15
        if (r9 != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        FLogger.a.w("RemoveAiWatermark", "set setting watermark config failed, msg=" + th.getMessage());
        r10 = null;
        goto L18
    }
}
