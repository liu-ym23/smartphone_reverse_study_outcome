package com.bytedance.android.live.liveinteract.plantform.permission.checker;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.multilink.external.api.core.type.AckFromSource;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.model.interact.UpdateLinkTypeApplyResponse;
import com.bytedance.android.livesdk.chatroom.model.interact.d2;
import com.bytedance.android.livesdk.chatroom.model.interact.e2;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class u<T> implements Consumer {
    public final /* synthetic */ t a;
    public final /* synthetic */ long b;

    public u(t r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r7) {
        ExtraResponse r8 = (ExtraResponse) r7;
        t r0 = this.a;
        r0.b = false;
        j1 r1 = r0.e;
        if (r1 == null) goto L7;
        dn0.c r2 = (dn0.c) r1.getScopeServiceOrNullInMultiLinkRoom(dn0.c.class);
        if (r2 == null) goto L7;
        r2.Z(this.a.c.f, e2.a((d2) r8.data), AckFromSource.TALK_ROOM_CAMERA_API);
    L10:
        int r3 = nd0.g.a;
        qh0.f.h r4 = this.a.c;
        nd0.g.j(r4.f, r4.c, this.b, r8);
        ALogger.i("ttlive_link", "checkServerPermission success");
        qh0.f.h r5 = this.a.c;
        int r6 = r5.c;
        String r9 = r5.f;
        long r10 = this.b;
        InteractLinkFullLinkMonitor.s0(r6, r9, System.currentTimeMillis() - r10, r8.logId);
        if (((Boolean) vm2.d.D.getValue(null, vm2.d.a[27])).booleanValue() == false) goto L19;
        qh0.f.h r11 = this.a.c;
        UpdateLinkTypeApplyResponse r12 = (UpdateLinkTypeApplyResponse) r8.data;
        if (r12 == null) goto L15;
        Intrinsics.checkNotNullParameter(r12, "$this$getRtcExtInfo");
        r12.getRtcExtInfoRaw();
    L15:
        r11.getClass();
        qh0.f.h r13 = this.a.c;
        UpdateLinkTypeApplyResponse r14 = (UpdateLinkTypeApplyResponse) r8.data;
        if (r14 == null) goto L18;
        Intrinsics.checkNotNullParameter(r14, "$this$getLiveCoreExtInfo");
        r14.getLiveCoreExtInfoRaw();
    L18:
        r13.getClass();
    L19:
        qh0.d<rh0.a> r15 = this.a.a;
        if (r15 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L22:
        r15.onResult(new rh0.a((UpdateLinkTypeApplyResponse) r8.data));
        return;
    L7:
        t r16 = this.a;
        Function2<? super String, ? super String, Unit> r17 = r16.f;
        if (r17 == null) goto L10;
        Unit r18 = (Unit) r17.invoke(r16.c.f, e2.a((d2) r8.data));
        goto L10
    }
}
