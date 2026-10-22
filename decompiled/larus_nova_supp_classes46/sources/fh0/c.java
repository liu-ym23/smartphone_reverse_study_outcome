package fh0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.l;
import com.bytedance.android.live.liveinteract.plantform.model.n;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.QuickInteractTask;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import sh0.j0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends eh0.a {
    public String b;
    public long c;
    public String d;
    public l e;
    public boolean f;
    public final b g;
    public final DataCenter h;
    public final i<ILinkPlayerInfoBridge> i;

    public static final class a {
    }

    public static final class b extends i.d {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void g(String r4, long r5, String r7, l r8) {
            Intrinsics.checkNotNullParameter(r4, "userId");
            gh0.a.b("RemoteFanTicketUpdateHandler", "onTicketUpdated, userId: " + r4 + ", ticketStr: " + r7, 4);
            c r0 = this.a;
            r0.f = true;
            r0.b = r4;
            r0.c = r5;
            r0.d = r7;
            r0.e = r8;
            r0.c();
        }
    }

    static {
    }

    @Override // eh0.c
    public final void attach() {
        this.i.Q4(this.g);
        Lazy r0 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(this.h, "FanTicketUpdateHandler", "call attach, store = " + j0.a(this.h));
    }

    @Override // eh0.c
    public final void detach() {
        this.i.T4(this.g);
    }

    @Override // eh0.a, eh0.c
    public final h.a a(List<ch0.e> r15) {
        Intrinsics.checkNotNullParameter(r15, "oldMergeDataList");
        List<ch0.e> r16 = r15;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator<T> r17 = r16.iterator();
        ch0.e r4 = null;
        boolean r3 = false;
    L3:
        String r6 = "";
        if (r17.hasNext() == false) goto L46;
        ch0.e r5 = (ch0.e) r17.next();
        if (this.f == false) goto L25;
        IBaseUser r7 = r5.a.getUser();
        if (r7 == null) goto L10;
        String r8 = r7.getIdString();
    L12:
        if (Intrinsics.areEqual(r8, this.b) == true) goto L14;
    L23:
        ch0.e r9 = r5;
        boolean r10 = false;
    L24:
        Pair r11 = new Pair(r9, Boolean.valueOf(r10));
    L35:
        if (((Boolean) r11.getSecond()).booleanValue() == false) goto L37;
        r3 = true;
    L37:
        ch0.e r12 = (ch0.e) r11.getFirst();
        IBaseUser r13 = r12.a.getUser();
        if (r13 == null) goto L40;
        String r14 = r13.getIdString();
    L42:
        if (Intrinsics.areEqual(r14, gh0.a.c()) == false) goto L45;
        if (r12 == r5) goto L45;
        r4 = r12;
    L45:
        r0.add(r12);
        goto L3
    L40:
        r14 = null;
        goto L42
    L14:
        if (r5.a.getFanTicketDisplayStr().equals(this.d) == true) goto L23;
        ILinkPlayerInfoBridge r18 = n.a(r5.a);
        String r19 = this.d;
        if (r19 == null) goto L19;
        r6 = r19;
    L19:
        r18.setFanTicketDisplayStr(r6);
        r18.setFanTicket(this.c);
        HashMap r110 = new HashMap(r5.d);
        String r20 = this.d;
        if (r20 == null) goto L22;
        r110.put("EXT_KEY_QUICK_INTERACT_MESSAGE", new QuickInteractTask(this.b, r20, 0, this.e));
    L22:
        r9 = ch0.e.a(r5, r18, null, null, r110, 6);
        r10 = true;
        goto L24
    L10:
        r8 = null;
        goto L12
    L25:
        IBaseUser r21 = r5.a.getUser();
        if (r21 == null) goto L28;
        String r22 = r21.getIdString();
    L30:
        if (Intrinsics.areEqual(r22, null) == false) goto L32;
        HashMap r111 = new HashMap(r5.d);
        r111.put("EXT_KEY_QUICK_INTERACT_TASK", null);
        ch0.e r23 = ch0.e.a(r5, null, null, null, r111, 7);
        boolean r24 = true;
    L33:
        r11 = new Pair(r23, Boolean.valueOf(r24));
        goto L35
    L32:
        r23 = r5;
        r24 = false;
        goto L33
    L28:
        r22 = null;
        goto L30
    L46:
        if (r3 == true) goto L49;
        gh0.a.b("RemoteFanTicketUpdateHandler", "clearCache", 4);
        this.b = "";
        this.c = 0;
        this.d = null;
        this.e = null;
    L49:
        return new h.a(r3, r0, r4);
    }

    public c(DataCenter r2, i<ILinkPlayerInfoBridge> r3) {
        Intrinsics.checkNotNullParameter(r3, "linkUserCenter");
        this.h = r2;
        this.i = r3;
        this.b = "";
        this.f = true;
        this.g = new b(this);
    }
}
