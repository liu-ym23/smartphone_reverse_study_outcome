package com.bytedance.android.live.liveinteract.wrds;

import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.model.w0;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.link.model.bridge.k1;
import com.bytedance.android.livesdk.link.model.bridge.l1;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdk.wrds.LinkMicRoomDataSyncModel;
import com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import io.reactivex.Observable;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d<T> implements SingleOnSubscribe {
    public final /* synthetic */ LinkMicRoomDataSyncModel a;
    public final /* synthetic */ long b;
    public final /* synthetic */ Ref.ObjectRef c;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ d a;
        public final /* synthetic */ SingleEmitter b;

        public a(d r1, SingleEmitter r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r13) {
            IRoomLinkMicSyncData r14 = (IRoomLinkMicSyncData) r13;
            int r0 = j.a;
            long r2 = this.a.b;
            String r6 = k.n(IMiddlewareUserService.class).user().n();
            m r1 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
            if (r1 == null) goto L7;
            IRoom r3 = (IRoom) r1.getValue();
            if (r3 == null) goto L7;
            long r7 = r3.getRoomId();
        L8:
            j.a("list_v2", r2, 0, r6, r7, TalkRoomBusinessFullLinkMonitor.WrdsStatusType.Success);
            if (r14.getLinkerBaseInfo() != null) goto L11;
            this.b.onSuccess((w0) this.a.c.element);
            return;
        L11:
            List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r4 = r14.getMLinkUsers();
            m r5 = com.bytedance.android.live.liveinteract.api.utils.m.d().j();
            if (r5 == null) goto L14;
            r5.setValue(Boolean.TRUE);
        L14:
            if (r4 == null) goto L36;
            Iterator<T> r8 = r4.iterator();
        L17:
            if (r8.hasNext() == false) goto L36;
            com.bytedance.android.livesdk.link.model.bridge.k r9 = (com.bytedance.android.livesdk.link.model.bridge.k) r8.next();
            k1 r10 = r9.getContent();
            if (r10 == null) goto L23;
            l1 r11 = r10.getLinkMicAudienceContent();
            if (r11 == null) goto L23;
            long r12 = r11.getSelfDisciplineStartTime();
        L25:
            if (r12 == 0) goto L31;
            k1 r15 = r9.getContent();
            if (r15 == null) goto L31;
            l1 r16 = r15.getLinkMicAudienceContent();
            if (r16 == null) goto L31;
            r16.setSelfDisciplineDurationTime((p6.b() - r12) / ((long) 1000));
        L31:
            k1 r17 = r9.getContent();
            if (r17 == null) goto L17;
            l1 r18 = r17.getLinkMicAudienceContent();
            if (r18 == null) goto L17;
            r18.setCurrentTime(p6.b() / ((long) 1000));
        L23:
            r12 = 0;
        L36:
            ((w0) this.a.c.element).setMPlayerInfo(r4);
            ((w0) this.a.c.element).setLinkerContentMap(r14.getLinkerContentMap());
            ((w0) this.a.c.element).setLockedPositions(r14.getLockedPositions());
            ((w0) this.a.c.element).setPositions(r14.getPositions());
            ((w0) this.a.c.element).setHasMore(false);
            ((w0) this.a.c.element).setTotalCount(0);
            ((w0) this.a.c.element).setPreOnlineList(new ArrayList());
            ((w0) this.a.c.element).setClientUiInfo(r14.getClientUIInfo());
            this.b.onSuccess((w0) this.a.c.element);
            return;
        L7:
            r7 = 0;
            goto L8
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ d a;
        public final /* synthetic */ SingleEmitter b;

        public b(d r1, SingleEmitter r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r10) {
            Throwable r11 = (Throwable) r10;
            int r12 = j.a;
            long r1 = this.a.b;
            String r5 = k.n(IMiddlewareUserService.class).user().n();
            m r13 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
            if (r13 == null) goto L7;
            IRoom r14 = (IRoom) r13.getValue();
            if (r14 == null) goto L7;
            long r6 = r14.getRoomId();
        L8:
            j.a("list_v2", r1, 0, r5, r6, TalkRoomBusinessFullLinkMonitor.WrdsStatusType.Timeout);
            this.b.onSuccess((w0) this.a.c.element);
            return;
        L7:
            r6 = 0;
            goto L8
        }
    }

    public d(LinkMicRoomDataSyncModel r1, long r2, Ref.ObjectRef r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final void subscribe(SingleEmitter<w0> r6) {
        Intrinsics.checkNotNullParameter(r6, "singleEmitter");
        LinkMicRoomDataSyncModel r0 = this.a;
        if (r0 == null) goto L12;
        dc2.c r1 = r0.getTalkRoomListUserInfoPb();
        if (r1 == null) goto L13;
        Observable r2 = r1.d(0, LinkWRDSHelper.c());
        if (r2 == null) goto L14;
        Observable r3 = r2.take(1);
        if (r3 == null) goto L15;
        r3.subscribe(new a(this, r6), new b(this, r6));
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }
}
