package com.larus.app.settings.impl;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
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
@DebugMetadata(c = "com.larus.app.settings.impl.RemoveAiWatermarkFragment$refreshSwitchState$1", f = "RemoveAiWatermarkActivity.kt", i = {}, l = {133}, m = "invokeSuspend", n = {}, s = {})
final class RemoveAiWatermarkFragment$refreshSwitchState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RemoveAiWatermarkFragment this$0;

    public RemoveAiWatermarkFragment$refreshSwitchState$1(RemoveAiWatermarkFragment r1, Continuation<? super RemoveAiWatermarkFragment$refreshSwitchState$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new RemoveAiWatermarkFragment$refreshSwitchState$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        List r4 = null;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L15
    L13:
        dm9.a r7 = (dm9.a) r6;     // Catch: Throwable -> L15
    L18:
        if ((r7 instanceof dm9.a.b) == false) goto L20;
        dm9.a.b r8 = (dm9.a.b) r7;
    L21:
        if (r8 != null) goto L23;
    L25:
        r8 = null;
    L26:
        if (r8 != null) goto L38;
        FLogger.a.w("RemoveAiWatermark", "get setting watermark config failed, exit page");
        RemoveAiWatermarkFragment r9 = this.this$0;
        int r2 = RemoveAiWatermarkFragment.i;
        Context r3 = r9.getContext();
        if (r3 == null) goto L37;
        t19.s r5 = t19.s.a;
        int r10 = c0.a;
        String r11 = r3.getString(2131897436);
        if (r11 != null) goto L33;
        r11 = "";
    L33:
        r5.getClass();
        t19.s.t(r3, r11);
        FragmentActivity r12 = r9.getActivity();
        if (r12 == null) goto L37;
        r12.finish();
    L37:
        return Unit.INSTANCE;
    L38:
        com.larus.uaigc.api.k r13 = (com.larus.uaigc.api.k) r8.a.getData();
        if (r13 == null) goto L41;
        r4 = r13.a();
    L41:
        RemoveAiWatermarkFragment.V90(this.this$0, r4);
        this.this$0.Y90(v.c(r4, 150), v.c(r4, 151));
        return Unit.INSTANCE;
    L23:
        if (r8.a.isSuccess() == false) goto L25;
    L20:
        r8 = null;
        goto L21
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
        SettingWatermarkConfigApi.Companion r14 = SettingWatermarkConfigApi.a;     // Catch: Throwable -> L15
        RemoveAiWatermarkFragment$refreshSwitchState$1$result$1 r15 = new RemoveAiWatermarkFragment$refreshSwitchState$1$result$1(null);     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r14.getClass();     // Catch: Throwable -> L15
        r6 = SettingWatermarkConfigApi.Companion.a(r15, this);     // Catch: Throwable -> L15
        if (r6 != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        FLogger.a.w("RemoveAiWatermark", "get setting watermark config failed, msg=" + th.getMessage());
        r7 = null;
        goto L18
    }
}
