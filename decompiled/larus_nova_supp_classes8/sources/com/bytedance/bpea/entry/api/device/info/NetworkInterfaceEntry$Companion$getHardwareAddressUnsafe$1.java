package com.bytedance.bpea.entry.api.device.info;

import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import java.net.NetworkInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
final class NetworkInterfaceEntry$Companion$getHardwareAddressUnsafe$1 extends Lambda implements Function0<byte[]> {
    final /* synthetic */ NetworkInterface $this_getHardwareAddressUnsafe;

    public NetworkInterfaceEntry$Companion$getHardwareAddressUnsafe$1(NetworkInterface r1) {
        this.$this_getHardwareAddressUnsafe = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final byte[] m1617invoke() {
        NetworkInterface r8 = this.$this_getHardwareAddressUnsafe;
        f06.c r9 = new f06.c();
        Object[] r10 = new Object[0];
        f06.b r11 = new f06.b();
        f06.d r12 = r9.b(101701, "java/net/NetworkInterface", "getHardwareAddress", r8, r10, "byte[]", r11);
        if (r12.a == false) goto L5;
        r9.a(101701, "java/net/NetworkInterface", "getHardwareAddress", r8, r10, null, r11, false);
        return (byte[]) r12.b;
    L5:
        byte[] r13 = r8.getHardwareAddress();
        r9.a(101701, "java/net/NetworkInterface", "getHardwareAddress", r8, r10, r13, r11, true);
        return r13;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m1617invoke();
    }
}
