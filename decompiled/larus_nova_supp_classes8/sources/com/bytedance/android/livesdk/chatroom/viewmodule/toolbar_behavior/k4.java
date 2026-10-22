package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PaidLiveData;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PaidProductData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k4 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.i {
    public final /* synthetic */ h4 a;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.i
    public final void a() {
        this.a.e("livesdk_paidlive_carry_ticket_sale_pop_show");
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.i
    public final void onCancelClick() {
        h4.b(this.a, "cancel");
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.i
    public final void onConfirmClick() {
        h4.b(this.a, "sure");
    }

    public k4(h4 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.i
    public final void b(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r2, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "from");
        Intrinsics.checkNotNullParameter(r3, "to");
        if (r4 == false) goto L13;
        Room r5 = this.a.c;
        if (r5 == null) goto L11;
        PaidLiveData r6 = r5.getPaidLiveData();
        if (r6 == null) goto L11;
        PaidProductData r7 = r6.getPaidProductData();
        if (r7 == null) goto L11;
        r7.bringProductFlag = 1;
    L11:
        this.a.f();
        return;
    }
}
