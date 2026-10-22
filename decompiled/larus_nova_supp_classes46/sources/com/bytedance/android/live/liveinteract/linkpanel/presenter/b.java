package com.bytedance.android.live.liveinteract.linkpanel.presenter;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.linkpanel.api.LinkAnchorApi;
import com.bytedance.android.live.liveinteract.linkpanel.contract.BaseTalkInviteListContract$View;
import com.bytedance.android.live.liveinteract.linkpanel.util.j;
import com.bytedance.android.live.liveinteract.linkpanel.util.o;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.a1;
import com.bytedance.android.livesdk.chatroom.interact.model.v;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.functions.Consumer;
import java.text.SimpleDateFormat;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class b extends yf0.b {
    public final IRoom c;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ b a;
        public final /* synthetic */ long b;

        public a(b r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            com.bytedance.android.live.network.response.e r6 = (com.bytedance.android.live.network.response.e) r5;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            long r1 = this.b;
            String r3 = r6.logId;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.D(r1, r3);
            a1 r7 = (a1) r6.data;
            if (r7 == null) goto L8;
            BaseTalkInviteListContract$View r2 = (BaseTalkInviteListContract$View) this.a.b;
            if (r2 == null) goto L9;
            r2.ca0(r7);
            return;
        L9:
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.linkpanel.presenter.b$b, reason: collision with other inner class name */
    public static final class C0041b<T> implements Consumer {
        public final /* synthetic */ b a;
        public final /* synthetic */ long b;

        public C0041b(b r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            long r1 = this.b;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.C(r1, r5);
            BaseTalkInviteListContract$View r2 = (BaseTalkInviteListContract$View) this.a.b;
            if (r2 == null) goto L6;
            r2.aa0(r5);
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ b a;
        public final /* synthetic */ ILinkPlayerInfoBridge b;
        public final /* synthetic */ long c;

        public c(b r1, ILinkPlayerInfoBridge r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r8) {
            com.bytedance.android.live.network.response.e r9 = (com.bytedance.android.live.network.response.e) r8;
            BaseTalkInviteListContract$View r0 = (BaseTalkInviteListContract$View) this.a.b;
            if (r0 == null) goto L5;
            IBaseUser r1 = this.b.getUser();
            Intrinsics.checkNotNull(r1);
            r0.ba0(r1, ((v) r9.data).getNoticeInfoList());
        L5:
            IBaseUser r2 = this.b.getUser();
            if (r2 == null) goto L9;
            String r3 = r2.getIdString();
            if (r3 == null) goto L9;
        L10:
            String r4 = r3;
            IBaseUser r5 = this.b.getUser();
            if (r5 == null) goto L13;
            Intrinsics.checkNotNullParameter(r5, "$this$secUidExt");
            String r6 = r5.getCastSecUid();
        L14:
            String r7 = r6;
            long r10 = this.c;
            SimpleDateFormat r11 = o.a;
            InteractLinkFullLinkMonitor.o(r4, r7, System.currentTimeMillis() - r10, r9.logId, (v) r9.data);
            return;
        L13:
            r6 = null;
        L9:
            r3 = "";
            goto L10
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ b a;
        public final /* synthetic */ ILinkPlayerInfoBridge b;
        public final /* synthetic */ long c;

        public d(b r1, ILinkPlayerInfoBridge r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r7) {
            Throwable r8 = (Throwable) r7;
            IBaseUser r0 = this.b.getUser();
            if (r0 == null) goto L6;
            String r1 = r0.getIdString();
            if (r1 == null) goto L6;
        L7:
            IBaseUser r2 = this.b.getUser();
            if (r2 == null) goto L10;
            Intrinsics.checkNotNullParameter(r2, "$this$secUidExt");
            String r3 = r2.getCastSecUid();
        L11:
            String r4 = String.valueOf(r3);
            long r5 = this.c;
            SimpleDateFormat r6 = o.a;
            InteractLinkFullLinkMonitor.n(r1, r4, System.currentTimeMillis() - r5, r8);
            ExceptionUtils.handleException(((BaseTalkInviteListContract$View) this.a.b).getContext(), r8);
            return;
        L10:
            r3 = null;
        L6:
            r1 = "";
            goto L7
        }
    }

    @Override // yf0.b
    public final void d(boolean r7) {
        IRoom r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        long r1 = System.currentTimeMillis();
        LinkAnchorApi r3 = (LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class);
        long r4 = r0.getId();
        if (r7 == false) goto L8;
        byte r8 = (byte) 3;
    L9:
        ((SingleSubscribeProxy) r3.getInviteList(r4, r8).as(c())).subscribe(new a(this, r1), new C0041b(this, r1));
        return;
    L8:
        r8 = 2;
        goto L9
    }

    @Override // yf0.b
    public final void e(ILinkPlayerInfoBridge r22) {
        Intrinsics.checkNotNullParameter(r22, "userInfo");
        IRoom r2 = this.c;
        if (r2 != null) goto L5;
        return;
    L5:
        long r13 = System.currentTimeMillis();
        IBaseUser r3 = r22.getUser();
        Intrinsics.checkNotNull(r3);
        String r4 = r3.getIdString();
        IBaseUser r5 = r22.getUser();
        Intrinsics.checkNotNull(r5);
        InteractLinkFullLinkMonitor.m(r4, com.bytedance.android.live.base.model.user.o.a(r5));
        int r6 = j.a;
        j.a.a("panel_audience");
        LinkAudienceApi r7 = (LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class);
        long r8 = r2.getRoomId();
        IBaseUser r9 = r22.getUser();
        String r10 = null;
        if (r9 == null) goto L8;
        String r11 = r9.getIdString();
    L9:
        IBaseUser r12 = r22.getUser();
        if (r12 == null) goto L12;
        r10 = r12.getIdString();
    L12:
        IBaseUser r14 = r22.getUser();
        Intrinsics.checkNotNull(r14);
        String r15 = new JSONArray(CollectionsKt.listOf(r14.getIdString())).toString();
        IBaseUser r16 = r22.getUser();
        Intrinsics.checkNotNull(r16);
        ((ObservableSubscribeProxy) r7.invite(r8, r11, r10, r15, new JSONArray(CollectionsKt.listOf(r16.getIdString())).toString(), 1, -1, 0, 0, 0, 0).as(c())).subscribe(new com.bytedance.android.live.liveinteract.linkpanel.presenter.c(this, r22, r13), new com.bytedance.android.live.liveinteract.linkpanel.presenter.d(this, r22, r13));
        return;
    L8:
        r11 = null;
        goto L9
    }

    @Override // yf0.b
    public final void f(ILinkPlayerInfoBridge r22) {
        Intrinsics.checkNotNullParameter(r22, "userInfo");
        IRoom r2 = this.c;
        if (r2 != null) goto L5;
        return;
    L5:
        int r3 = j.a;
        j.a.a("panel_friend");
        IBaseUser r4 = r22.getUser();
        if (r4 == null) goto L9;
        String r5 = r4.getIdString();
        if (r5 == null) goto L9;
    L10:
        IBaseUser r6 = r22.getUser();
        String r7 = null;
        if (r6 == null) goto L13;
        Intrinsics.checkNotNullParameter(r6, "$this$secUidExt");
        String r8 = r6.getCastSecUid();
    L14:
        InteractLinkFullLinkMonitor.m(r5, r8);
        long r9 = System.currentTimeMillis();
        LinkAudienceApi r10 = (LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class);
        long r11 = r2.getId();
        IBaseUser r12 = r22.getUser();
        if (r12 == null) goto L17;
        String r13 = r12.getIdString();
    L18:
        IBaseUser r14 = r22.getUser();
        if (r14 == null) goto L21;
        String r15 = r14.getIdString();
    L22:
        IBaseUser r16 = r22.getUser();
        if (r16 == null) goto L25;
        String r17 = r16.getIdString();
    L26:
        String r18 = new JSONArray(CollectionsKt.listOf(r17)).toString();
        IBaseUser r19 = r22.getUser();
        if (r19 == null) goto L29;
        r7 = r19.getIdString();
    L29:
        ((ObservableSubscribeProxy) r10.invite(r11, r13, r15, r18, new JSONArray(CollectionsKt.listOf(r7)).toString(), 0, 0, 0, 0, 0, 0).as(c())).subscribe(new c(this, r22, r9), new d(this, r22, r9));
        return;
    L25:
        r17 = null;
        goto L26
    L21:
        r15 = null;
        goto L22
    L17:
        r13 = null;
        goto L18
    L13:
        r8 = null;
    L9:
        r5 = "";
        goto L10
    }

    public b(IRoom r2, BaseTalkInviteListContract$View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super(r3);
        this.c = r2;
    }
}
