package com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement;

import ch0.e;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.linkbase.api.SeatItemId;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.GiftIconElementInfo;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.QuickInteractTask;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.LinkMicQuickInteractView;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.message.Text;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import tf0.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MultiLinkMicSeatGiftIconElement extends a<MultiLinkGuestViewBinder.a> {
    public int b;
    public LinkMicQuickInteractView c;
    public final boolean d;

    public final GiftIconElementInfo b() {
        MultiLinkGuestViewBinder.a r0 = (MultiLinkGuestViewBinder.a) this.a;
        d r1 = null;
        if (r0 == null) goto L7;
        HashMap<String, d> r2 = r0.i;
        if (r2 == null) goto L7;
        d r3 = r2.get(SeatItemId.GIFT_ICON.name());
    L9:
        if ((r3 instanceof GiftIconElementInfo) == false) goto L13;
        r1 = r3;
    L13:
        return (GiftIconElementInfo) r1;
    L7:
        r3 = null;
        goto L9
    }

    public final void d() {
        GiftIconElementInfo r1 = b();
        boolean r3 = true;
        int r4 = 0;
        ILinkPlayerInfoBridge r5 = null;
        if (r1 == null) goto L31;
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C0101b r6 = com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.r0;
        MultiLinkGuestViewBinder.a r7 = (MultiLinkGuestViewBinder.a) this.a;
        if (r7 == null) goto L9;
        e r8 = r7.k;
        if (r8 == null) goto L9;
        r5 = r8.a;
    L9:
        r6.getClass();
        if (com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C0101b.c(r5) == false) goto L18;
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b r9 = com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C0101b.a();
        if (r9 == null) goto L22;
        String r10 = String.valueOf(r1.c());
        String r11 = r1.h();
        if (r11 != null) goto L16;
        String r12 = "0";
    L17:
        r9.Si(new QuickInteractTask(r10, r12, 0, r1.g(), QuickInteractTask.Source.Dynamic), true);
        goto L22
    L16:
        r12 = r11;
    L22:
        if (r1.d() == 1) goto L25;
        r3 = false;
    L25:
        LinkMicQuickInteractView r2 = this.c;
        if (r2 == null) goto L59;
        if (r3 == true) goto L30;
        r4 = 8;
    L30:
        r2.setVisibility(r4);
        return;
    L59:
        return;
    L18:
        LinkMicQuickInteractView r13 = this.c;
        if (r13 == null) goto L22;
        r13.j(r1.h());
        goto L22
    L31:
        LinkMicQuickInteractView r14 = this.c;
        if (r14 == null) goto L34;
        LinkMicQuickInteractView.a(r14, true, false, 2);
        r14.x = "0";
        r14.n.f();
    L34:
        MultiLinkGuestViewBinder.a r15 = (MultiLinkGuestViewBinder.a) this.a;
        if (r15 == null) goto L41;
        e r16 = r15.k;
        if (r16 == null) goto L41;
        ILinkPlayerInfoBridge r17 = r16.a;
        if (r17 == null) goto L41;
        String r18 = r17.getFanTicketDisplayStr();
    L42:
        if (r18 == null) goto L57;
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C0101b r19 = com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.r0;
        MultiLinkGuestViewBinder.a r20 = (MultiLinkGuestViewBinder.a) this.a;
        if (r20 == null) goto L49;
        e r21 = r20.k;
        if (r21 == null) goto L49;
        r5 = r21.a;
    L49:
        r19.getClass();
        if (com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C0101b.c(r5) == false) goto L54;
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b r22 = com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C0101b.a();
        if (r22 == null) goto L57;
        r22.Si(new QuickInteractTask(je0.d.b0(), r18, 0, null, null, null, 0, null, false, null, null, null, null, 8188), true);
        goto L57
    L54:
        LinkMicQuickInteractView r23 = this.c;
        if (r23 == null) goto L57;
        r23.j(r18);
    L57:
        e(this.b);
        return;
    L41:
        r18 = null;
        goto L42
    }

    public final void a(final QuickInteractTask r3) {
        Intrinsics.checkNotNullParameter(r3, "task");
        if (b() != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
    L9:
        Text r1 = r3.j;
        if (r1 == null) goto L12;
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.d.a(r1, new MultiLinkMicSeatGiftIconElement$consumeInteractTask$1(this, r3));
        return;
    L12:
        LinkMicQuickInteractView r2 = this.c;
        if (r2 == null) goto L18;
        r2.c(r3);
        return;
    L18:
        return;
    L8:
        if (r3.h == QuickInteractTask.Source.Dynamic) goto L9;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void c(QuickInteractTask r3) {
        Intrinsics.checkNotNullParameter(r3, "task");
        if (b() != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L11;
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.r0.getClass();
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b r1 = com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C0101b.a();
        if (r1 == null) goto L12;
        r1.Si(r3, true);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void e(int r4) {
        StringBuilder r0 = new StringBuilder("updateVisibility one position:");
        MultiLinkGuestViewBinder.a r1 = (MultiLinkGuestViewBinder.a) this.a;
        String r2 = null;
        if (r1 == null) goto L5;
        Integer r3 = Integer.valueOf(r1.a);
    L6:
        r0.append(r3);
        r0.append(" visibility:");
        r0.append(r4);
        r0.append(" lastVisible:");
        r0.append(this.b);
        ALogger.i("MultiLinkMicSeatGiftIconElement-DEBUG", r0.toString());
        if (this.d == false) goto L25;
        MultiLinkGuestViewBinder.a r5 = (MultiLinkGuestViewBinder.a) this.a;
        if (r5 == null) goto L17;
        e r6 = r5.k;
        if (r6 == null) goto L17;
        ILinkPlayerInfoBridge r7 = r6.a;
        if (r7 == null) goto L17;
        IBaseUser r8 = r7.getUser();
        if (r8 == null) goto L17;
        String r9 = r8.getIdString();
    L18:
        Room r10 = m.i().getCurrentRoom();
        if (r10 == null) goto L22;
        r2 = r10.getOwnerUserIdString();
    L22:
        if (Intrinsics.areEqual(r9, r2) == false) goto L25;
        if (r4 != 0) goto L25;
        return;
    L17:
        r9 = null;
    L25:
        this.b = r4;
        if (b() != null) goto L28;
        boolean r11 = true;
    L29:
        if (r11 == false) goto L34;
        LinkMicQuickInteractView r12 = this.c;
        if (r12 == null) goto L35;
        r12.setVisibility(r4);
        return;
    L35:
        return;
    L34:
        return;
    L28:
        r11 = false;
        goto L29
    L5:
        r3 = null;
        goto L6
    }

    public MultiLinkMicSeatGiftIconElement(LinkMicQuickInteractView r1, boolean r2) {
        this.c = r1;
        this.d = r2;
    }
}
