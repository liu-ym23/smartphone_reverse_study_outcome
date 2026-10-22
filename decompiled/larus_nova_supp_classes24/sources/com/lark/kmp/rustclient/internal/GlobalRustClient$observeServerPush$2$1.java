package com.lark.kmp.rustclient.internal;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0012\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
final class GlobalRustClient$observeServerPush$2$1 extends Lambda implements Function0<byte[]> {
    final /* synthetic */ rpc.c.a $serverPush;

    public GlobalRustClient$observeServerPush$2$1(rpc.c.a r1) {
        this.$serverPush = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final byte[] m193invoke() {
        ByteString r0 = this.$serverPush.b.getPayload();
        if (r0 != null) goto L6;
        r0 = ByteString.EMPTY;
    L6:
        return r0.toByteArray();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m193invoke();
    }
}
