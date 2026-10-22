package com.bytedance.android.livesdk.gift.vs.panel.statemachine;

import ca0.w;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftListViewModelNew$mSyncGiftListCallback$1 extends w {
    public boolean a;
    public final /* synthetic */ GiftListViewModelNew b;

    public final void a() {
        if (this.a == false) goto L11;
        GiftStateMachineConfig.e r0 = (GiftStateMachineConfig.e) this.b.j.b();
        if ((r0 instanceof GiftStateMachineConfig.e.c) == false) goto L13;
        GiftStateMachineConfig.c r1 = ((GiftStateMachineConfig.e.c) r0).a;
        if (r1 == null) goto L14;
        List<w1> r2 = r1.a;
        if (r2 == null) goto L15;
        this.b.i(r2, false, new GiftListViewModelNew$mSyncGiftListCallback$1$onSyncGiftFailure$$inlined$let$lambda$1(this));
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    L11:
        StateMachine<GiftStateMachineConfig.e, GiftStateMachineConfig.Event, GiftStateMachineConfig.f> r3 = this.b.j;
        GiftStateMachineConfig.Event.x r4 = GiftStateMachineConfig.Event.x.b;
        StateMachine.a r5 = StateMachine.c;
        r3.d(r4, null);
    }

    public GiftListViewModelNew$mSyncGiftListCallback$1(GiftListViewModelNew r1) {
        this.b = r1;
        this.a = true;
    }

    public final void b(List<? extends w1> r7) {
        Intrinsics.checkNotNullParameter(r7, "giftPages");
        if (this.a == true) goto L14;
        List<w1> r0 = ((GiftStateMachineConfig.e) this.b.j.b()).a();
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L14;
        this.b.j.d(GiftStateMachineConfig.Event.x.b, null);
        return;
    L7:
        if (r0.isEmpty() == true) goto L10;
        r1 = false;
    L14:
        this.b.getClass();
        ArrayList r3 = new ArrayList();
        Iterator<T> r2 = r7.iterator();
    L16:
        if (r2.hasNext() == false) goto L20;
        Object r4 = r2.next();
        if (((w1) r4).getDisplay() == false) goto L16;
        r3.add(r4);
        goto L16
    L20:
        Iterator r5 = r3.iterator();
    L22:
        if (r5.hasNext() == false) goto L33;
        w1 r6 = (w1) r5.next();
        if (r6.getPageType() != 1) goto L22;
        r6.getGifts().size();
        List<h1> r8 = r6.getGifts();
        if (r8 == null) goto L22;
        Iterator<T> r9 = r8.iterator();
    L29:
        if (r9.hasNext() == false) goto L22;
        h1 r10 = (h1) r9.next();
        r10.isDisplayedOnPanel();
        if (r10.isForLinkMic() == false) goto L29;
        r10.isDisplayedOnPanel();
        goto L29
    L33:
        this.b.i(r7, false, new GiftListViewModelNew$mSyncGiftListCallback$1$onSyncGiftPageListFinish$1(this));
    }
}
