package com.bytedance.android.live.livepkaudience.base;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.livesdk.chatroom.model.interact.l2;
import com.bytedance.android.livesdk.chatroom.model.interact.t2;
import com.bytedance.android.livesdk.message.model.xe;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class o implements vlc.l {
    public final vlc.d a;
    public final CompositeDisposable b;
    public final Room c;
    public final boolean d;
    public final ArrayList<g> e;
    public final HashSet<String> f;
    public final HashSet<String> g;
    public boolean h;
    public final DataCenter i;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ o a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ long d;
        public final /* synthetic */ String e;

        public a(o r1, String r2, String r3, long r4, String r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r6;
        }

        public final void accept(Object r13) {
            com.bytedance.android.live.network.response.e r14 = (com.bytedance.android.live.network.response.e) r13;
            Iterator<g> r0 = this.a.e.iterator();
        L4:
            if (r0.hasNext() == false) goto L12;
            g r1 = r0.next();
            String r2 = this.b;
            if (r14 == null) goto L10;
            l2 r3 = (l2) r14.data;
            if (r3 == null) goto L10;
            String r4 = r3.getOpenId();
        L11:
            r1.c7(r2, r4);
        L10:
            r4 = null;
            goto L11
        L12:
            String r5 = this.b;
            String r6 = this.c;
            long r7 = this.d;
            long r9 = System.currentTimeMillis() - r7;
            String r15 = r14.logId;
            if (this.a.d == false) goto L15;
            String r8 = "anchor";
        L16:
            String r10 = this.e;
            dl0.m r11 = dl0.m.a;
            Intrinsics.checkNotNullParameter(r5, "userId");
            Intrinsics.checkNotNullParameter(r15, "logId");
            Intrinsics.checkNotNullParameter(r8, "role");
            Intrinsics.checkNotNullParameter(r10, "reqFrom");
            JSONObject r12 = new JSONObject();
            BaseMonitor.add(r12, "to_user_id", r5);
            if (r6 != null) goto L19;
            r6 = "";
        L19:
            BaseMonitor.add(r12, "sec_to_user_id", r6);
            BaseMonitor.add(r12, "api_log_id", r15);
            BaseMonitor.add(r12, "operate_role_type", r8);
            BaseMonitor.add(r12, "request_source", r10);
            dl0.m.a.getClass();
            dl0.m.z("audience_kick_out", 0, "", r9, r12);
            return;
        L15:
            r8 = "administrator";
            goto L16
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ o a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ long d;
        public final /* synthetic */ String e;

        public b(o r1, String r2, String r3, long r4, String r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r6;
        }

        public final void accept(Object r13) {
            Throwable r14 = (Throwable) r13;
            Iterator<g> r0 = this.a.e.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().k5(this.b, r14);
            goto L4
        L6:
            String r1 = this.b;
            String r2 = this.c;
            long r3 = this.d;
            long r9 = System.currentTimeMillis() - r3;
            if (this.a.d == false) goto L9;
            String r4 = "anchor";
        L10:
            String r5 = this.e;
            dl0.m r6 = dl0.m.a;
            Intrinsics.checkNotNullParameter(r1, "userId");
            Intrinsics.checkNotNullParameter(r4, "role");
            Intrinsics.checkNotNullParameter(r5, "reqFrom");
            JSONObject r11 = new JSONObject();
            BaseMonitor.add(r11, "to_user_id", r1);
            if (r2 != null) goto L13;
            r2 = "";
        L13:
            BaseMonitor.add(r11, "sec_to_user_id", r2);
            BaseMonitor.add(r11, "operate_role_type", r4);
            BaseMonitor.add(r11, "request_source", r5);
            if (r14 != null) goto L16;
            return;
        L16:
            if ((r14 instanceof ApiServerException) == false) goto L22;
            dl0.m r7 = dl0.m.a;
            ApiServerException r15 = (ApiServerException) r14;
            int r8 = r15.getErrorCode();
            String r16 = r15.getErrorMsg();
            if (r16 != null) goto L20;
            String r10 = "";
        L21:
            r7.getClass();
            dl0.m.z("audience_kick_out", r8, r10, r9, r11);
            return;
        L20:
            r10 = r16;
            goto L21
        L22:
            dl0.m r12 = dl0.m.a;
            String r17 = r14.toString();
            r12.getClass();
            dl0.m.z("audience_kick_out", 1, r17, r9, r11);
            return;
        L9:
            r4 = "administrator";
            goto L10
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ o a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ long d;

        public c(o r1, String r2, String r3, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r12) {
            com.bytedance.android.live.network.response.e r13 = (com.bytedance.android.live.network.response.e) r12;
            this.a.f.remove(this.b);
            if (r13 != null) goto L5;
            return;
        L5:
            if (((t2) r13.data) == null) goto L18;
            Iterator<g> r14 = this.a.e.iterator();
        L8:
            if (r14.hasNext() == false) goto L10;
            r14.next().onPermitSuccess(this.b);
            goto L8
        L10:
            String r15 = this.b;
            String r0 = this.c;
            long r1 = this.d;
            long r8 = System.currentTimeMillis() - r1;
            if (this.a.d == false) goto L13;
            String r2 = "anchor";
        L14:
            dl0.m r3 = dl0.m.a;
            Intrinsics.checkNotNullParameter(r15, "toUserId");
            Intrinsics.checkNotNullParameter("", "permitType");
            Intrinsics.checkNotNullParameter(r2, "role");
            JSONObject r10 = new JSONObject();
            BaseMonitor.add(r10, "to_user_id", r15.toString());
            BaseMonitor.add(r10, "sec_to_user_id", String.valueOf(r0));
            BaseMonitor.add(r10, "permit_type", "");
            BaseMonitor.add(r10, "operate_role_type", r2);
            dl0.m.a.getClass();
            dl0.m.z("audience_permit", 0, "", r8, r10);
            return;
        L13:
            r2 = "administrator";
            goto L14
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ o a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ long d;

        public d(o r1, String r2, String r3, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r13) {
            Throwable r14 = (Throwable) r13;
            this.a.f.remove(this.b);
            Iterator<g> r0 = this.a.e.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().l(this.b, r14);
            goto L4
        L6:
            String r1 = this.b;
            String r2 = this.c;
            long r3 = this.d;
            long r9 = System.currentTimeMillis() - r3;
            if (this.a.d == false) goto L9;
            String r4 = "anchor";
        L10:
            dl0.m r5 = dl0.m.a;
            Intrinsics.checkNotNullParameter(r1, "toUserId");
            Intrinsics.checkNotNullParameter("", "permitType");
            Intrinsics.checkNotNullParameter(r4, "role");
            JSONObject r11 = new JSONObject();
            BaseMonitor.add(r11, "to_user_id", r1.toString());
            BaseMonitor.add(r11, "sec_to_user_id", String.valueOf(r2));
            BaseMonitor.add(r11, "permit_type", "");
            BaseMonitor.add(r11, "operate_role_type", r4);
            if (r14 != null) goto L13;
            return;
        L13:
            if ((r14 instanceof ApiServerException) == false) goto L19;
            dl0.m r6 = dl0.m.a;
            ApiServerException r15 = (ApiServerException) r14;
            int r7 = r15.getErrorCode();
            String r16 = r15.getErrorMsg();
            if (r16 != null) goto L17;
            String r8 = "";
        L18:
            r6.getClass();
            dl0.m.z("audience_permit", r7, r8, r9, r11);
            return;
        L17:
            r8 = r16;
            goto L18
        L19:
            dl0.m r10 = dl0.m.a;
            String r12 = r14.toString();
            r10.getClass();
            dl0.m.z("audience_permit", 1, r12, r9, r11);
            return;
        L9:
            r4 = "administrator";
            goto L10
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

    public o(DataCenter r3) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.i = r3;
        this.a = (vlc.d) r3.get("data_message_manager");
        this.b = new CompositeDisposable();
        this.c = (Room) r3.get("data_room", new Room());
        this.d = ((Boolean) r3.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        this.e = new ArrayList();
        this.f = new HashSet();
        this.g = new HashSet();
    }

    public final void a(g r2) {
        Intrinsics.checkNotNullParameter(r2, "linkListener");
        this.e.add(r2);
    }

    public final void f(g r2) {
        Intrinsics.checkNotNullParameter(r2, "linkListener");
        if (this.e.contains(r2) == false) goto L6;
        this.e.remove(r2);
        return;
    }

    public final void onMessage(tlc.d r10) {
        if ((r10 instanceof xe) == false) goto L17;
        xe r11 = (xe) r10;
        int r1 = (int) r11.getType2();
        if (r1 != 13) goto L7;
        int r0 = r11.getReplyType();
        dl0.m r2 = dl0.m.a;
        Intrinsics.checkNotNullParameter(r11, MultiLinkOpenSource.MESSAGE);
        JSONObject r7 = new JSONObject();
        BaseMonitor.add(r7, "reply_type", r0);
        dl0.m.x(r11, r11.getChannelId(), (int) r11.getType2(), System.currentTimeMillis(), r7);
        Intrinsics.checkNotNullParameter(r11, MultiLinkOpenSource.MESSAGE);
        dl0.m.y(r11, r11.getChannelId(), (int) r11.getType2(), System.currentTimeMillis());
        Iterator<g> r3 = this.e.iterator();
    L15:
        if (r3.hasNext() == false) goto L22;
        r3.next().Em(r11);
        goto L15
    L22:
        return;
    L7:
        if (r1 != 14) goto L20;
        Intrinsics.checkNotNullParameter(r11, MultiLinkOpenSource.MESSAGE);
        dl0.m.y(r11, r11.getChannelId(), (int) r11.getType2(), System.currentTimeMillis());
        Iterator<g> r4 = this.e.iterator();
    L11:
        if (r4.hasNext() == false) goto L21;
        r4.next().nm(r11);
        goto L11
    L21:
        return;
    L20:
        return;
    }

    public final void e(String r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "uid");
        if (this.f.contains(r12) == false) goto L7;
        ALogger.e("ttlive_pk", "permit request already sent for " + r12);
        return;
    L7:
        if (dl0.p.a().getChannelId() != 0) goto L9;
    L12:
        this.f.add(r12);
        long r7 = System.currentTimeMillis();
        this.b.add(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).permit(this.c.id, r12, r12.toString(), r13).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(this, r12, r13, r7), new d(this, r12, r13, r7)));
        return;
    L9:
        if (us1.b.a() == true) goto L12;
        f2.b(2131917544, 0);
    }

    public final void d(String r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r13, "uid");
        Intrinsics.checkNotNullParameter(r15, "requestFrom");
        long r8 = System.currentTimeMillis();
        Disposable r16 = ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).kickOut(this.c.id, r13, r13, r14, r15).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this, r13, r14, r8, r15), new b(this, r13, r14, r8, r15));
        this.b.add(r16);
    }

    public static void c(o r16, long r17, String r19, String r20, int r21, long r22, int r24) {
        if ((r24 & 64) == 0) goto L5;
        long r12 = 0;
    L6:
        r16.getClass();
        Intrinsics.checkNotNullParameter(r19, "uid");
        if (dl0.k.a() == false) goto L10;
        f2.c(s1.B(2131917794), 0);
        return;
    L10:
        if (r16.g.contains(r19) == false) goto L12;
        ALogger.e("ttlive_link", "invite request already sent for " + r19);
        return;
    L12:
        r16.g.add(r19);
        long r14 = System.currentTimeMillis();
        r16.b.add(((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).invite(r17, r20, r21, -1, 0, r12).compose(RxUtil.rxSchedulerHelper()).subscribe(new m(r16, r19, r20, r14, 0, r12), new n(r16, r19, r20, r14)));
        return;
    L5:
        r12 = r22;
        goto L6
    }
}
