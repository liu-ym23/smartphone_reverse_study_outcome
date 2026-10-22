package com.bytedance.android.live.room.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\u0086@"}, d2 = {"Lkotlin/coroutines/Continuation;", "Landroid/hardware/usb/UsbManager;", "continuation", "", "initUsbManager"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.live.room.utils.UsbDeviceUtils", f = "UsbDeviceUtils.kt", i = {}, l = {21}, m = "initUsbManager", n = {}, s = {})
public final class UsbDeviceUtils$initUsbManager$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UsbDeviceUtils this$0;

    public UsbDeviceUtils$initUsbManager$1(UsbDeviceUtils r1, Continuation r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(this);
    }
}
