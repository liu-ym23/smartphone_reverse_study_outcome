package fh0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.l;
import com.bytedance.android.live.liveinteract.plantform.model.n;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.QuickInteractTask;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import sh0.i0;
import sh0.j0;
import sh0.w;
import sh0.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a {
    public String b;
    public long c;
    public String d;
    public l e;
    public QuickInteractTask f;
    public boolean g;
    public final c h;
    public final i<ILinkPlayerInfoBridge> i;
    public final DataCenter j;

    /* JADX INFO: renamed from: fh0.a$a, reason: collision with other inner class name */
    public static final class C0207a {
    }

    public static final class b implements ne0.a {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        @Override // ne0.a
        public final void a(ne0.e r2, Object r3) {
            Intrinsics.checkNotNullParameter(r2, "store");
            if ((r3 instanceof x) == false) goto L6;
            a r4 = this.a;
            r4.g = false;
            r4.f = ((x) r3).a;
            r4.c();
            gh0.a.b("FanTicketUpdateHandler", "OnReceiveInteractTask, task: " + this.a.f, 4);
            return;
        }
    }

    public static final class c extends i.d {
        public final /* synthetic */ a a;

        public c(a r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void g(String r4, long r5, String r7, l r8) {
            Intrinsics.checkNotNullParameter(r4, "userId");
            gh0.a.b("FanTicketUpdateHandler", "onTicketUpdated, userId: " + r4 + ", ticketStr: " + r7, 4);
            a r0 = this.a;
            r0.g = true;
            r0.b = r4;
            r0.c = r5;
            r0.d = r7;
            r0.e = r8;
            m r6 = com.bytedance.android.live.liveinteract.api.utils.m.n(r0.j, null, 2).getRoom();
            if (r6 == null) goto L7;
            IRoom r9 = (IRoom) r6.getValue();
            if (r9 == null) goto L7;
            String r10 = r9.getOwnerUserIdString();
        L9:
            if (Intrinsics.areEqual(r4, r10) == false) goto L11;
            com.bytedance.android.live.liveinteract.api.utils.m.h(this.a.j, null, 2).E(r7);
        L11:
            this.a.c();
            return;
        L7:
            r10 = null;
            goto L9
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void attach() {
        this.i.Q4(this.h);
        Lazy r0 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(this.j, "FanTicketUpdateHandler", "call attach, store = " + j0.a(this.j));
        i0 r1 = j0.a(this.j);
        if (r1 == null) goto L6;
        r1.d(w.b, new b(this));
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void detach() {
        this.i.T4(this.h);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a, com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final h.a b(List<ch0.e> r14) {
        Intrinsics.checkNotNullParameter(r14, "oldMergeDataList");
        List<ch0.e> r15 = r14;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator<T> r16 = r15.iterator();
        ch0.e r4 = null;
        boolean r3 = false;
    L4:
        if (r16.hasNext() == false) goto L50;
        ch0.e r5 = (ch0.e) r16.next();
        if (this.g == false) goto L24;
        IBaseUser r6 = r5.a.getUser();
        if (r6 == null) goto L10;
        String r7 = r6.getIdString();
    L12:
        if (Intrinsics.areEqual(r7, this.b) == true) goto L14;
    L22:
        ch0.e r8 = r5;
        boolean r9 = false;
    L23:
        Pair r10 = new Pair(r8, Boolean.valueOf(r9));
    L38:
        if (((Boolean) r10.getSecond()).booleanValue() == false) goto L40;
        r3 = true;
    L40:
        ch0.e r11 = (ch0.e) r10.getFirst();
        IBaseUser r12 = r11.a.getUser();
        if (r12 == null) goto L43;
        String r13 = r12.getIdString();
    L45:
        if (Intrinsics.areEqual(r13, gh0.a.c()) == false) goto L48;
        if (r11 == r5) goto L48;
        r4 = r11;
    L48:
        r0.add(r11);
        goto L4
    L43:
        r13 = null;
        goto L45
    L14:
        if (r5.a.getFanTicketDisplayStr().equals(this.d) == true) goto L22;
        ILinkPlayerInfoBridge r17 = n.a(r5.a);
        String r18 = this.d;
        if (r18 != null) goto L18;
        r18 = "";
    L18:
        r17.setFanTicketDisplayStr(r18);
        r17.setFanTicket(this.c);
        HashMap r19 = new HashMap(r5.d);
        String r20 = this.d;
        if (r20 == null) goto L21;
        r19.put("EXT_KEY_QUICK_INTERACT_MESSAGE", new QuickInteractTask(this.b, r20, 0, this.e));
    L21:
        r8 = ch0.e.a(r5, r17, null, null, r19, 6);
        r9 = true;
        goto L23
    L10:
        r7 = null;
        goto L12
    L24:
        IBaseUser r21 = r5.a.getUser();
        if (r21 == null) goto L27;
        String r22 = r21.getIdString();
    L28:
        QuickInteractTask r23 = this.f;
        if (r23 == null) goto L31;
        String r24 = r23.a;
    L33:
        if (Intrinsics.areEqual(r22, r24) == false) goto L35;
        HashMap r110 = new HashMap(r5.d);
        r110.put("EXT_KEY_QUICK_INTERACT_TASK", this.f);
        ch0.e r25 = ch0.e.a(r5, null, null, null, r110, 7);
        boolean r26 = true;
    L36:
        r10 = new Pair(r25, Boolean.valueOf(r26));
        goto L38
    L35:
        r25 = r5;
        r26 = false;
        goto L36
    L31:
        r24 = null;
        goto L33
    L27:
        r22 = null;
        goto L28
    L50:
        return new h.a(r3, r0, r4);
    }

    public a(i<ILinkPlayerInfoBridge> r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "linkUserCenter");
        this.i = r2;
        this.j = r3;
        this.b = "";
        this.g = true;
        this.h = new c(this);
    }
}
