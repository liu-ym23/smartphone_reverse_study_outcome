package com.bytedance.android.live.liveinteract.wrds;

import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.interact.model.y;
import com.bytedance.android.livesdk.chatroom.model.interact.RoomLinkMicAnchorSettings;
import com.bytedance.android.livesdk.chatroom.model.interact.n;
import com.bytedance.android.livesdk.wrds.LinkMicRoomDataSyncModel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import io.reactivex.Observable;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e<T> implements SingleOnSubscribe {
    public final /* synthetic */ LinkMicRoomDataSyncModel a;
    public final /* synthetic */ long b;
    public final /* synthetic */ Ref.ObjectRef c;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ e a;
        public final /* synthetic */ SingleEmitter b;

        public a(e r1, SingleEmitter r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r11) {
            RoomLinkMicAnchorSettings r12 = (RoomLinkMicAnchorSettings) r11;
            int r0 = j.a;
            long r2 = this.a.b;
            String r6 = k.n(IMiddlewareUserService.class).user().n();
            m r1 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
            if (r1 == null) goto L7;
            IRoom r3 = (IRoom) r1.getValue();
            if (r3 == null) goto L7;
            long r7 = r3.getRoomId();
        L8:
            j.a("get_settings", r2, 0, r6, r7, TalkRoomBusinessFullLinkMonitor.WrdsStatusType.Success);
            ((n) this.a.c.element).setSettingsExt(r12.settings);
            List r13 = r12.settings;
            if (r13 == null) goto L41;
            Iterator<T> r14 = r13.iterator();
        L12:
            if (r14.hasNext() == false) goto L41;
            y r4 = (y) r14.next();
            boolean r5 = false;
            switch(r4.getKey()) {
                case 8: goto L40;
                case 9: goto L36;
                case 10: goto L12;
                case 11: goto L12;
                case 12: goto L32;
                case 13: goto L12;
                case 14: goto L28;
                case 15: goto L24;
                case 16: goto L20;
                case 17: goto L16;
                default: goto L12;
            };
        L16:
            n r8 = (n) this.a.c.element;
            if (r4.getValue() != 1) goto L19;
            r5 = true;
        L19:
            r8.setAudioChatOnlyAcceptFollowerApply(r5);
            goto L12
        L20:
            n r9 = (n) this.a.c.element;
            if (r4.getValue() != 1) goto L23;
            r5 = true;
        L23:
            r9.setAudioChatAcceptNeedVerified(r5);
            goto L12
        L24:
            n r10 = (n) this.a.c.element;
            if (r4.getValue() != 1) goto L27;
            r5 = true;
        L27:
            r10.setIntimateChatAcceptNeedVerified(r5);
            goto L12
        L28:
            n r15 = (n) this.a.c.element;
            if (r4.getValue() != 1) goto L31;
            r5 = true;
        L31:
            r15.setIntimateChatOnlyJoinThroughInvitation(r5);
            goto L12
        L32:
            n r16 = (n) this.a.c.element;
            if (r4.getValue() != 1) goto L35;
            r5 = true;
        L35:
            r16.setIntimateOnlyAcceptFollowerApply(r5);
            goto L12
        L36:
            n r17 = (n) this.a.c.element;
            if (r4.getValue() != 1) goto L39;
            r5 = true;
        L39:
            r17.setAcceptNeedVerified(r5);
            goto L12
        L40:
            ((n) this.a.c.element).setTurnOn(r4.getValue());
        L41:
            this.b.onSuccess((n) this.a.c.element);
            return;
        L7:
            r7 = 0;
            goto L8
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ e a;
        public final /* synthetic */ SingleEmitter b;

        public b(e r1, SingleEmitter r2) {
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
            j.a("get_settings", r1, 0, r5, r6, TalkRoomBusinessFullLinkMonitor.WrdsStatusType.Timeout);
            this.b.onSuccess((n) this.a.c.element);
            return;
        L7:
            r6 = 0;
            goto L8
        }
    }

    public e(LinkMicRoomDataSyncModel r1, long r2, Ref.ObjectRef r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final void subscribe(SingleEmitter<n> r6) {
        Intrinsics.checkNotNullParameter(r6, "singleEmitter");
        LinkMicRoomDataSyncModel r0 = this.a;
        if (r0 == null) goto L12;
        dc2.c r1 = r0.getTalkRoomSettingPb();
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
