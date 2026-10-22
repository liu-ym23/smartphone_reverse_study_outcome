package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver;

import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ GiftReceiverRepoService a;

    public l(GiftReceiverRepoService r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        List<? extends ILinkPlayerInfoBridge> r8 = (List) r7;
        gq2.b r0 = this.a.Qc();
        GiftReceiverRepoService r1 = this.a;
        int r2 = v.a(r1.i, r1.j);
        jy0.b.d("GiftReceiver", "observeLinkMicUserList change " + r2 + ", " + r8.size());
        r0.c();
        if (r0.d(r2, 4) == true) goto L5;
    L22:
        GiftReceiverRepoService r3 = this.a;
        r3.Y(r3.d(r8), 1);
        IRoomBase r4 = this.a.k.getRoom();
        com.bytedance.android.livesdk.revenue.service.microom.a r5 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.microom.a.class);
        if ((r4 instanceof IRoom) == true) goto L26;
        r4 = null;
    L26:
        if (r5.isMicRoom((IRoom) r4) == false) goto L34;
        GiftReceiverRepoService r6 = this.a;
        r6.Y(r6.w(r8), 5);
        return;
    L34:
        return;
    L5:
        if (vh6.c.b(qr2.c.class) == null) goto L7;
        boolean r9 = true;
    L8:
        if (r9 == false) goto L22;
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = r8.iterator();
    L11:
        if (r11.hasNext() == false) goto L21;
        T r13 = r11.next();
        ILinkPlayerInfoBridge r14 = (ILinkPlayerInfoBridge) r13;
        Intrinsics.checkNotNullParameter(r14, "$this$interactIdKt");
        String r15 = r14.getInteractId();
        qr2.c r16 = vh6.c.b(qr2.c.class);
        if (r16 != null) goto L15;
    L17:
        boolean r17 = false;
    L19:
        if ((!r17) == false) goto L11;
        r10.add(r13);
        goto L11
    L15:
        if (r16.pm(r15) != true) goto L17;
        r17 = true;
        goto L19
    L21:
        r8 = r10;
        goto L22
    L7:
        r9 = false;
        goto L8
    }
}
