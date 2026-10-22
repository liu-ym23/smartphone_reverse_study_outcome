package com.bytedance.android.live.liveinteract.wrds;

import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.model.interact.t0;
import com.bytedance.android.livesdk.wrds.LinkMicRoomDataSyncModel;
import com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.functions.Consumer;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i<T> implements SingleOnSubscribe {
    public final /* synthetic */ LinkMicRoomDataSyncModel a;
    public final /* synthetic */ com.bytedance.android.live.network.response.e b;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ i a;
        public final /* synthetic */ long b;
        public final /* synthetic */ SingleEmitter c;

        public a(i r1, long r2, SingleEmitter r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }

        public final void accept(Object r11) {
            IRoomLinkMicSyncData r12 = (IRoomLinkMicSyncData) r11;
            int r0 = j.a;
            long r2 = this.b;
            long r4 = ((t0) this.a.b.data).getVersion();
            String r6 = k.n(IMiddlewareUserService.class).user().n();
            m r1 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
            if (r1 == null) goto L7;
            IRoom r3 = (IRoom) r1.getValue();
            if (r3 == null) goto L7;
            long r7 = r3.getRoomId();
        L8:
            j.a("update_position", r2, r4, r6, r7, TalkRoomBusinessFullLinkMonitor.WrdsStatusType.Success);
            ((t0) this.a.b.data).setLinkUsers(r12.getMLinkUsers());
            this.c.onSuccess(this.a.b);
            return;
        L7:
            r7 = 0;
            goto L8
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ i a;
        public final /* synthetic */ long b;
        public final /* synthetic */ SingleEmitter c;

        public b(i r1, long r2, SingleEmitter r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }

        public final void accept(Object r10) {
            Throwable r11 = (Throwable) r10;
            int r12 = j.a;
            long r1 = this.b;
            long r3 = ((t0) this.a.b.data).getVersion();
            String r5 = k.n(IMiddlewareUserService.class).user().n();
            m r13 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
            if (r13 == null) goto L7;
            IRoom r14 = (IRoom) r13.getValue();
            if (r14 == null) goto L7;
            long r6 = r14.getRoomId();
        L8:
            j.a("update_position", r1, r3, r5, r6, TalkRoomBusinessFullLinkMonitor.WrdsStatusType.Timeout);
            this.c.onSuccess(this.a.b);
            return;
        L7:
            r6 = 0;
            goto L8
        }
    }

    public i(LinkMicRoomDataSyncModel r1, com.bytedance.android.live.network.response.e r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(SingleEmitter<com.bytedance.android.live.network.response.e<t0>> r8) {
        Intrinsics.checkNotNullParameter(r8, "singleEmitter");
        if (LinkWRDSHelper.a() == true) goto L5;
    L9:
        r8.onSuccess(this.b);
        return;
    L5:
        if (this.a == null) goto L9;
        long r0 = System.currentTimeMillis();
        this.a.getTalkRoomListUserInfoPb().d(((t0) this.b.data).getVersion(), LinkWRDSHelper.c()).take(1).subscribe(new a(this, r0, r8), new b(this, r0, r8));
    }
}
