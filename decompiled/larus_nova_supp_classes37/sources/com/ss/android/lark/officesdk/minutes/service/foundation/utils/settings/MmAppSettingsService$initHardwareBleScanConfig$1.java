package com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings;

import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs.MmHardwareBleScanConfig;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.MmAppSettingsService$initHardwareBleScanConfig$1", f = "MmAppSettingsService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmAppSettingsService$initHardwareBleScanConfig$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ b this$0;

    public MmAppSettingsService$initHardwareBleScanConfig$1(b r1, Continuation<? super MmAppSettingsService$initHardwareBleScanConfig$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmAppSettingsService$initHardwareBleScanConfig$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r7);
        MmHardwareBleScanConfig r8 = (MmHardwareBleScanConfig) SettingManager.getInstance().get(MmHardwareBleScanConfig.class);
        if (r8 != null) goto L7;
        r8 = new MmHardwareBleScanConfig(false, false, false, 7, null);
    L7:
        b r0 = this.this$0;
        int r1 = b.l;
        r0.getClass();
        lvb.a.e("MmRecordAppSettingsService", "[initHardwareBleScanConfig] data: " + r8);
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
