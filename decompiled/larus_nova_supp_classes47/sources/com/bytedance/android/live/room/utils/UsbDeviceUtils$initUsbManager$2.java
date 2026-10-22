package com.bytedance.android.live.room.utils;

import android.hardware.usb.UsbManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Landroid/hardware/usb/UsbManager;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.live.room.utils.UsbDeviceUtils$initUsbManager$2", f = "UsbDeviceUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class UsbDeviceUtils$initUsbManager$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super UsbManager>, Object> {
    int label;

    public UsbDeviceUtils$initUsbManager$2(Continuation r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "completion");
        return new UsbDeviceUtils$initUsbManager$2(r2);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r2);
        Object r3 = jc1.a.b().getSystemService("usb");
        if ((r3 instanceof UsbManager) == true) goto L8;
        r3 = null;
    L8:
        return (UsbManager) r3;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
