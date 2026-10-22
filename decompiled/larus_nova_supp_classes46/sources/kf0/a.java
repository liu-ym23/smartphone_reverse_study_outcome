package kf0;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.interact.audience.contract.InteractAudienceApplyContract$View;
import com.bytedance.android.live.liveinteract.interact.audience.fragment.InteractAudienceApplyFragment;
import com.bytedance.android.live.liveinteract.linkpanel.api.LinkAnchorApi;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.a1;
import com.bytedance.android.live.liveinteract.plantform.model.m0;
import com.bytedance.android.live.liveinteract.plantform.model.n0;
import com.bytedance.android.livesdk.utils.d5;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends hf0.a {

    /* JADX INFO: renamed from: kf0.a$a, reason: collision with other inner class name */
    public static final class C0225a<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ long b;

        public C0225a(a r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r8) {
            com.bytedance.android.live.network.response.e r9 = (com.bytedance.android.live.network.response.e) r8;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            long r1 = this.b;
            String r3 = r9.logId;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.F(r1, r3);
            m0 r10 = (m0) r9.data;
            if (r10 == null) goto L39;
            List<n0> r11 = r10.getMWaitingUserInfo();
            if (r11 == null) goto L40;
            ArrayList<ILinkPlayerInfoBridge> r12 = je0.d.e0(r11);
            InteractAudienceApplyContract$View r2 = (InteractAudienceApplyContract$View) this.a.b;
            if (r2 == null) goto L41;
            ArrayList r4 = new ArrayList();
            Iterator<ILinkPlayerInfoBridge> r13 = r12.iterator();
        L9:
            boolean r5 = false;
            if (r13.hasNext() == false) goto L18;
            ILinkPlayerInfoBridge r6 = r13.next();
            ILinkPlayerInfoBridge r7 = r6;
            if (r7.getUser() != null) goto L14;
        L16:
            if (r5 == false) goto L9;
            r4.add(r6);
            goto L9
        L14:
            if (1 == r7.getRoleType()) goto L16;
            r5 = true;
            goto L16
        L18:
            ArrayList r14 = new ArrayList();
            Iterator r15 = r4.iterator();
        L20:
            if (r15.hasNext() == false) goto L27;
            Object r16 = r15.next();
            if (((ILinkPlayerInfoBridge) r16).getLinkStatus() != 1) goto L24;
            boolean r17 = true;
        L25:
            if (r17 == false) goto L20;
            r14.add(r16);
            goto L20
        L24:
            r17 = false;
            goto L25
        L27:
            r2.ba0(r14);
            return;
        L41:
            return;
        L40:
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ long b;

        public b(a r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            long r1 = this.b;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.E(r1, (Throwable) r4);
            f2.b(2131920668, 0);
            InteractAudienceApplyContract$View r5 = (InteractAudienceApplyContract$View) this.a.b;
            if (r5 == null) goto L6;
            r5.aa0();
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ a a;

        public c(a r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            com.bytedance.android.live.network.response.e r9 = (com.bytedance.android.live.network.response.e) r8;
            if (r9 == null) goto L41;
            a1 r10 = (a1) r9.data;
            if (r10 == null) goto L42;
            List<ILinkPlayerInfoBridge> r11 = r10.getPlayerInfo();
            if (r11 == null) goto L43;
            InteractAudienceApplyContract$View r0 = (InteractAudienceApplyContract$View) this.a.b;
            if (r0 == null) goto L44;
            ArrayList r1 = new ArrayList();
            Iterator<T> r12 = r11.iterator();
        L11:
            boolean r3 = false;
            if (r12.hasNext() == false) goto L20;
            T r2 = r12.next();
            ILinkPlayerInfoBridge r5 = (ILinkPlayerInfoBridge) r2;
            if (r5.getUser() != null) goto L16;
        L18:
            if (r3 == false) goto L11;
            r1.add(r2);
            goto L11
        L16:
            if (1 == r5.getRoleType()) goto L18;
            r3 = true;
            goto L18
        L20:
            ArrayList r13 = new ArrayList();
            Iterator r4 = r1.iterator();
        L22:
            if (r4.hasNext() == false) goto L29;
            Object r6 = r4.next();
            if (((ILinkPlayerInfoBridge) r6).getLinkStatus() != 1) goto L26;
            boolean r7 = true;
        L27:
            if (r7 == false) goto L22;
            r13.add(r6);
            goto L22
        L26:
            r7 = false;
            goto L27
        L29:
            r0.ba0(r13);
            return;
        L44:
            return;
        L43:
            return;
        L42:
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ a a;

        public d(a r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            f2.b(2131920668, 0);
            InteractAudienceApplyContract$View r4 = (InteractAudienceApplyContract$View) this.a.b;
            if (r4 == null) goto L6;
            r4.aa0();
            return;
        }
    }

    public a(InteractAudienceApplyFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
    }

    @Override // hf0.a
    public final void d(long r11, String r13) {
        Intrinsics.checkNotNullParameter(r13, "anchorId");
        if (vm2.d.k() == false) goto L5;
        long r0 = System.currentTimeMillis();
        ((SingleSubscribeProxy) ((LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class)).getLinkWaitingList(r11, 50, "").as(c())).subscribe(new C0225a(this, r0), new b(this, r0));
        return;
    L5:
        ((SingleSubscribeProxy) ((LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class)).getAllList(r11, r13, d5.c(r13), 1, 0, false).as(c())).subscribe(new c(this), new d(this));
    }
}
