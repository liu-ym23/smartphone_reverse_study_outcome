package com.bytedance.android.ec.core.address;

import com.bytedance.android.ec.core.address.api.AddressItemVO;
import com.bytedance.android.ec.core.address.api.GetAddressResponse;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ Function2 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ boolean c;

    public f(Function2 r1, String r10, boolean r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }

    public final void accept(Object r10) {
        GetAddressResponse r11 = (GetAddressResponse) r10;
        List<AddressItemVO> r0 = null;
        if (r11 == null) goto L18;
        if (r11.isValid() != true) goto L18;
        List<AddressItemVO> r12 = r11.getAddressList();
        if (r12 != null) goto L9;
    L30:
        w r13 = AddressSDK.a;
        AddressSDK.h = Boolean.TRUE;
        return;
    L9:
        if ((!r12.isEmpty()) == false) goto L11;
        r0 = r12;
    L11:
        if (r0 == null) goto L30;
        Function2 r14 = this.a;
        if (r14 != null) goto L15;
    L16:
        w r1 = AddressSDK.a;
        AddressSDK.b(r11.getServerTime(), r0, this.b);
        goto L30
    L15:
        if (((Boolean) r14.invoke(Long.valueOf(r11.getServerTime()), r0)).booleanValue() == true) goto L30;
    L18:
        if (r11.getStatusCode() == 0) goto L20;
    L29:
        int r15 = s.a;
        s.b(true, Integer.valueOf(r11.getStatusCode()), this.b, r11.getLogId());
        w r16 = AddressSDK.a;
        AddressSDK.g("fetch address list fail:" + Integer.valueOf(r11.getStatusCode()), null, 6);
        goto L30
    L20:
        if (this.c == false) goto L29;
        AddressSDK r17 = AddressSDK.j;
        AddressSDKLog.a("clear all address in SDK", false);
        monitor-enter(r17);
        w r18 = AddressSDK.a;     // Catch: Throwable -> L26
        r18.b.a();     // Catch: Throwable -> L26
        r18.c.a();     // Catch: Throwable -> L26
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L26
        monitor-exit(r17);
    L26:
        th = move-exception;
        throw th;
    }
}
