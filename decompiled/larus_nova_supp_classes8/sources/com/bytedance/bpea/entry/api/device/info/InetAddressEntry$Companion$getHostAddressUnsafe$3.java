package com.bytedance.bpea.entry.api.device.info;

import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import java.net.Inet6Address;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
final class InetAddressEntry$Companion$getHostAddressUnsafe$3 extends Lambda implements Function0<String> {
    final /* synthetic */ Inet6Address $this_getHostAddressUnsafe;

    public InetAddressEntry$Companion$getHostAddressUnsafe$3(Inet6Address r1) {
        this.$this_getHostAddressUnsafe = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m1613invoke() {
        return this.$this_getHostAddressUnsafe.getHostAddress();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m1613invoke();
    }
}
