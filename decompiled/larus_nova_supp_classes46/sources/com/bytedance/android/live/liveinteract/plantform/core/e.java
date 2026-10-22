package com.bytedance.android.live.liveinteract.plantform.core;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.wrds.LinkWRDSHelper;
import com.bytedance.android.livesdk.chatroom.model.interact.t2;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.link.model.bridge.ILinkMicGuideMessageBridge;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.wrds.LinkMicRoomDataSyncModel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class e implements vlc.l {
    public final vlc.d a;
    public final CompositeDisposable b;
    public final IRoom c;
    public final boolean d;
    public final ArrayList<uf0.a> e;
    public final HashSet<String> f;
    public final HashSet<String> g;
    public boolean h;
    public boolean i;
    public final DataCenter j;

    public static final class a<T, R> implements Function {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r3) {
            com.bytedance.android.live.network.response.e r4 = (com.bytedance.android.live.network.response.e) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            LinkMicRoomDataSyncModel r0 = LinkWRDSHelper.b();
            Intrinsics.checkNotNullParameter(r4, "response");
            return Single.create(new com.bytedance.android.live.liveinteract.wrds.b(r0, r4));
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ e a;
        public final /* synthetic */ long b;

        public b(e r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r10) {
            com.bytedance.android.live.network.response.e<com.bytedance.android.livesdk.link.model.bridge.i0> r11 = (com.bytedance.android.live.network.response.e) r10;
            this.a.h = false;
            com.bytedance.android.livesdk.link.model.bridge.i0 r0 = r11.data;
            String r1 = null;
            if (r0 == null) goto L5;
            String r2 = r0.getToken();
        L6:
            com.bytedance.android.livesdk.link.model.bridge.i0 r3 = r11.data;
            if (r3 == null) goto L9;
            Long r4 = Long.valueOf(r3.getVersion());
        L10:
            com.bytedance.android.livesdk.link.model.bridge.i0 r5 = r11.data;
            if (r5 == null) goto L15;
            List r6 = r5.getLinkedUsers();
            if (r6 == null) goto L15;
            String r7 = je0.d.g0(r6);
        L16:
            InteractLinkFullLinkMonitor.r(r2, r4, r7, System.currentTimeMillis() - this.b, r11.logId);
            long r8 = System.currentTimeMillis() - this.b;
            com.bytedance.android.livesdk.link.model.bridge.i0 r9 = r11.data;
            if (r9 == null) goto L19;
            String r12 = r9.getToken();
        L20:
            com.bytedance.android.livesdk.link.model.bridge.i0 r13 = r11.data;
            if (r13 == null) goto L23;
            Long r14 = Long.valueOf(r13.getVersion());
        L24:
            com.bytedance.android.livesdk.link.model.bridge.i0 r15 = r11.data;
            if (r15 == null) goto L29;
            List r16 = r15.getLinkedUsers();
            if (r16 == null) goto L29;
            r1 = je0.d.g0(r16);
        L29:
            com.bytedance.android.live.liveinteract.plantform.utils.x.v(r8, r12, r14, r1);
            TalkRoomBusinessFullLinkMonitor r17 = TalkRoomBusinessFullLinkMonitor.a;
            long r18 = this.b;
            r17.getClass();
            TalkRoomBusinessFullLinkMonitor.N(r11, r18);
            Iterator<uf0.a> r19 = this.a.e.iterator();
        L31:
            if (r19.hasNext() == false) goto L33;
            r19.next().b2(r11);
            goto L31
        L33:
            return;
        L23:
            r14 = null;
            goto L24
        L19:
            r12 = null;
        L15:
            r7 = null;
            goto L16
        L9:
            r4 = null;
            goto L10
        L5:
            r2 = null;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ e a;
        public final /* synthetic */ long b;

        public c(e r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            this.a.h = false;
            long r0 = this.b;
            InteractLinkFullLinkMonitor.q(System.currentTimeMillis() - r0, r6);
            long r1 = this.b;
            com.bytedance.android.live.liveinteract.plantform.utils.x.u(r6, System.currentTimeMillis() - r1);
            TalkRoomBusinessFullLinkMonitor r2 = TalkRoomBusinessFullLinkMonitor.a;
            long r3 = this.b;
            r2.getClass();
            TalkRoomBusinessFullLinkMonitor.M(r6, r3);
            Iterator<uf0.a> r4 = this.a.e.iterator();
        L4:
            if (r4.hasNext() == false) goto L6;
            r4.next().m0(r6);
            goto L4
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ e a;

        public d(e r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            KVData r3 = (KVData) r2;
            if (r3 == null) goto L5;
            Boolean r4 = (Boolean) r3.getData();
        L7:
            if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L10;
            this.a.d();
            return;
        L10:
            return;
        L5:
            r4 = null;
            goto L7
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.plantform.core.e$e, reason: collision with other inner class name */
    public static final class C0053e<T> implements Consumer {
        public final /* synthetic */ e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;
        public final /* synthetic */ String d;

        public C0053e(e r1, String r2, long r3, String r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
        }

        public final void accept(Object r6) {
            com.bytedance.android.live.network.response.e r7 = (com.bytedance.android.live.network.response.e) r6;
            Iterator<uf0.a> r0 = this.a.e.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().If();
            goto L4
        L6:
            String r1 = this.b;
            long r2 = this.c;
            InteractLinkFullLinkMonitor.u(r1, System.currentTimeMillis() - r2, r7.logId);
            TalkRoomBusinessFullLinkMonitor r3 = TalkRoomBusinessFullLinkMonitor.a;
            String r4 = this.b;
            String r5 = this.d;
            long r8 = this.c;
            String r9 = r7.logId;
            r3.getClass();
            TalkRoomBusinessFullLinkMonitor.P(r4, r5, r8, r9);
            String r10 = this.b;
            int r11 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
            Intrinsics.checkNotNullParameter(r10, "targetId");
            LinkedHashMap r12 = new LinkedHashMap();
            r12.put("target_user_id", r10);
            com.bytedance.android.live.liveinteract.plantform.utils.x.t0("kickout_audience_success", r12);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;
        public final /* synthetic */ String d;

        public f(e r1, String r2, long r3, String r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
        }

        public final void accept(Object r6) {
            Throwable r7 = (Throwable) r6;
            Iterator<uf0.a> r0 = this.a.e.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().k5(this.b, r7);
            goto L4
        L6:
            String r1 = this.b;
            long r2 = this.c;
            InteractLinkFullLinkMonitor.t(r1, System.currentTimeMillis() - r2, r7);
            TalkRoomBusinessFullLinkMonitor r3 = TalkRoomBusinessFullLinkMonitor.a;
            String r4 = this.b;
            String r5 = this.d;
            long r8 = this.c;
            r3.getClass();
            TalkRoomBusinessFullLinkMonitor.O(r4, r5, r8, r7);
            String r9 = this.b;
            int r10 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
            Intrinsics.checkNotNullParameter(r9, "targetId");
            LinkedHashMap r11 = new LinkedHashMap();
            r11.put("target_user_id", r9);
            com.bytedance.android.live.liveinteract.plantform.utils.x.X(r7, r11);
            com.bytedance.android.live.liveinteract.plantform.utils.x.t0("kickout_audience_failed", r11);
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ long d;

        public g(e r1, String r2, String r3, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r10) {
            com.bytedance.android.live.network.response.e r11 = (com.bytedance.android.live.network.response.e) r10;
            this.a.f.remove(this.b);
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            String r1 = this.b;
            String r2 = this.c;
            long r3 = this.d;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.f0(r1, r2, r3, r11);
            if (((t2) r11.data) == null) goto L9;
            Iterator<uf0.a> r4 = this.a.e.iterator();
        L6:
            if (r4.hasNext() == false) goto L8;
            r4.next().onPermitSuccess(this.b);
            goto L6
        L8:
            String r5 = this.b;
            String r6 = this.c;
            long r7 = this.d;
            InteractLinkFullLinkMonitor.I(r5, r6, System.currentTimeMillis() - r7, r11.logId, (t2) r11.data);
            String r12 = this.b;
            long r8 = this.d;
            com.bytedance.android.live.liveinteract.plantform.utils.x.Y(r12, System.currentTimeMillis() - r8);
        L9:
            IKtvService r13 = jc1.k.f(IKtvService.class);
            if (r13 == null) goto L14;
            r13.onPermitSuccess(this.b);
            return;
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ long d;

        public h(e r1, String r2, String r3, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r7) {
            Throwable r8 = (Throwable) r7;
            this.a.f.remove(this.b);
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            String r1 = this.b;
            String r2 = this.c;
            long r3 = this.d;
            r0.getClass();
            JSONObject r4 = new JSONObject();
            r4.put("target_user_id", r1);
            r4.put("target_sec_user_id", r2);
            TalkRoomBusinessFullLinkMonitor.Y(LinkMonitorData.PermitApiMonitorData, TalkRoomBusinessFullLinkMonitor.h(r3), r8, r4);
            Iterator<uf0.a> r5 = this.a.e.iterator();
        L4:
            if (r5.hasNext() == false) goto L6;
            r5.next().l(this.b, r8);
            goto L4
        L6:
            String r6 = this.b;
            String r9 = this.c;
            long r10 = this.d;
            InteractLinkFullLinkMonitor.H(r6, r9, System.currentTimeMillis() - r10, r8);
            String r11 = this.b;
            long r12 = this.d;
            com.bytedance.android.live.liveinteract.plantform.utils.x.Z(r11, r8, System.currentTimeMillis() - r12);
        }
    }

    public final void b() {
        vlc.d r0 = this.a;
        if (r0 == null) goto L6;
        r0.removeMessageListener(this);
    L6:
        if (this.b.isDisposed() == true) goto L8;
        this.b.dispose();
    L8:
        this.e.clear();
        this.f.clear();
        this.g.clear();
    }

    public final void d() {
        Boolean r0 = (Boolean) this.j.get("cmd_ready_starting_live", Boolean.FALSE);
        d r1 = new d(this);
        if (r0.booleanValue() == true) goto L6;
        this.j.observe("cmd_ready_starting_live", r1);
        return;
    L6:
        this.j.removeObserver(r1);
        if (this.h == false) goto L9;
        return;
    L9:
        this.h = true;
        com.bytedance.android.live.liveinteract.plantform.utils.r.a("join channel");
        long r2 = System.currentTimeMillis();
        InteractLinkFullLinkMonitor.p();
        Disposable r3 = ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).joinChannelV1(this.c.getId()).subscribeOn(Schedulers.io()).flatMap(a.a).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r2), new c(this, r2));
        this.b.add(r3);
    }

    public final void a(uf0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "linkListener");
        this.e.add(r2);
    }

    public final void g(uf0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "linkListener");
        if (this.e.contains(r2) == false) goto L6;
        this.e.remove(r2);
        return;
    }

    public final void onMessage(tlc.d r4) {
        if ((r4 instanceof z0) == false) goto L20;
        z0 r5 = (z0) r4;
        switch(((int) r5.getType2())) {
            case 13: goto L15;
            case 14: goto L11;
            case 15: goto L7;
            default: goto L30;
        };
    L7:
        InteractLinkFullLinkMonitor.J((com.bytedance.android.live.liveinteract.multianchor.model.b) r5.castToOrNull(com.bytedance.android.live.liveinteract.multianchor.model.b.class));
        Iterator<uf0.a> r0 = this.e.iterator();
    L9:
        if (r0.hasNext() == false) goto L31;
        r0.next().Ba(r5);
        goto L9
    L31:
        return;
    L11:
        com.bytedance.android.live.liveinteract.plantform.utils.x.c(r5.getFromUserIdStr(), r5.getMessageId2());
        Iterator<uf0.a> r1 = this.e.iterator();
    L13:
        if (r1.hasNext() == false) goto L32;
        r1.next().eo(r5);
        goto L13
    L32:
        return;
    L15:
        com.bytedance.android.live.liveinteract.plantform.utils.x.b(r5.getMessageId2(), r5.getReplyType());
        InteractLinkFullLinkMonitor.K(r5.castToOrNull(com.bytedance.android.live.liveinteract.multianchor.model.b.class));
        TalkRoomBusinessFullLinkMonitor r2 = TalkRoomBusinessFullLinkMonitor.a;
        z0 r3 = r5.castToOrNull(com.bytedance.android.live.liveinteract.multianchor.model.b.class);
        r2.getClass();
        TalkRoomBusinessFullLinkMonitor.o0(r3);
        Iterator<uf0.a> r6 = this.e.iterator();
    L17:
        if (r6.hasNext() == false) goto L33;
        r6.next().Ff(r5);
        goto L17
    L33:
        return;
    L30:
        return;
    L20:
        if ((r4 instanceof ILinkMicGuideMessageBridge) == false) goto L25;
        Iterator<uf0.a> r7 = this.e.iterator();
    L23:
        if (r7.hasNext() == false) goto L34;
        r7.next().vf((ILinkMicGuideMessageBridge) r4);
        goto L23
    L34:
        return;
    }

    public e(DataCenter r2, tf0.i r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "dataHolder");
        this.j = r2;
        this.a = (vlc.d) r2.get("data_message_manager");
        this.b = new CompositeDisposable();
        this.c = (IRoom) r2.get("data_room", vh7.f.c(IRoom.class));
        this.d = ((Boolean) r2.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        this.e = new ArrayList();
        this.f = new HashSet();
        this.g = new HashSet();
    }

    public final void f(String r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "uid");
        if (this.f.contains(r12) == false) goto L7;
        ALogger.e("ttlive_link", "permit request already sent for " + r12);
        return;
    L7:
        if (jc1.k.n(IMultiLinkServiceExternal.class).getMultiDataHolderExternal().getChannelId() == 0) goto L10;
        f2.b(2131917544, 0);
        return;
    L10:
        this.f.add(r12);
        long r7 = System.currentTimeMillis();
        InteractLinkFullLinkMonitor.G(r12, r13);
        this.b.add(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).permit(this.c.getId(), r12, r12, r13).compose(RxUtil.rxSchedulerHelper()).subscribe(new g(this, r12, r13, r7), new h(this, r12, r13, r7)));
    }

    public final void e(String r18, String r19, String r20) {
        Intrinsics.checkNotNullParameter(r18, "uid");
        Intrinsics.checkNotNullParameter(r20, "requestFrom");
        long r15 = System.currentTimeMillis();
        InteractLinkFullLinkMonitor.s(r18);
        Disposable r0 = ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).kickOut(this.c.getId(), r18, r18, r19, r20).compose(RxUtil.rxSchedulerHelper()).subscribe(new C0053e(this, r18, r15, r19), new f(this, r18, r15, r19));
        this.b.add(r0);
        if (this.d == false) goto L5;
        String r1 = "anchor";
    L6:
        TalkRoomLogUtils.h(r18, r1, je0.d.k0(r18));
        return;
    L5:
        r1 = "administrator";
        goto L6
    }

    public static void c(e r28, long r29, String r31, String r32, long r33, int r35) {
        if ((r35 & 128) == 0) goto L5;
        long r24 = 0;
    L6:
        r28.getClass();
        Intrinsics.checkNotNullParameter(r31, "uid");
        Intrinsics.checkNotNullParameter(r32, "secUid");
        if (r28.g.contains(r31) == false) goto L9;
        ALogger.e("ttlive_link", "invite request already sent for " + r31);
        return;
    L9:
        r28.g.add(r31);
        long r26 = System.currentTimeMillis();
        InteractLinkFullLinkMonitor.m(r31, r32);
        r28.b.add(((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).invite(r29, r32, r31, null, null, 1, -1, 0, 0, r24, 0).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.live.liveinteract.plantform.core.c(r28, r31, r32, r26, 0, r24), new com.bytedance.android.live.liveinteract.plantform.core.d(r28, r31, r32, r26, r24)));
        return;
    L5:
        r24 = r33;
        goto L6
    }
}
