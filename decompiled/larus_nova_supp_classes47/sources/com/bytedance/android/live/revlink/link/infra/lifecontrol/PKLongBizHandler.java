package com.bytedance.android.live.revlink.link.infra.lifecontrol;

import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import com.bytedance.android.livesdk.link.model.a5;
import com.bytedance.android.livesdk.revenue.service.message.d;
import com.bytedance.android.livesdk.revenue.service.room.c;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import yh6.b;
import yz0.f;
import yz0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class PKLongBizHandler {
    public final CompositeDisposable a;
    public final boolean b;
    public final f c;
    public final d d;
    public final c e;

    public final void a() {
        f r0 = this.c;
        com.bytedance.android.live.revenue.common.message.a r1 = com.bytedance.android.live.revenue.common.message.a.g;
        Lazy r2 = CommonMessageTypeKt.a;
        Intrinsics.checkNotNullParameter(r1, "$this$LINK_MIC_BATTLE_FINISH");
        Observable r3 = h.a.a(r0, (b) CommonMessageTypeKt.h.getValue(), false, 6);
        final PKLongBizHandler$attach$1 r4 = new PKLongBizHandler$attach$1(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r3.subscribe(new a(r4)), this.a);
    }

    public final void b(a5 r5) {
        String r0 = r5.getCutShortPrompt();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L24;
        IRoomBase r2 = this.e.getRoomContext().getCommonRoom();
        String r3 = null;
        if ((r2 instanceof IRoom) == true) goto L13;
        r2 = null;
    L13:
        IRoom r4 = (IRoom) r2;
        if (r4 == null) goto L16;
        r3 = r4.getIdStr();
    L16:
        d r6 = this.d;
        if (r6 == null) goto L25;
        if (r3 != null) goto L20;
        r3 = "";
    L20:
        yh6.c r7 = r6.u4(r3, r5.getCutShortPrompt());
        if (r7 == null) goto L26;
        this.c.insert(r7, true);
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public PKLongBizHandler(boolean r2, f r3, d r4, c r5) {
        Intrinsics.checkNotNullParameter(r3, "messageService");
        Intrinsics.checkNotNullParameter(r5, "roomService");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.a = new CompositeDisposable();
    }
}
