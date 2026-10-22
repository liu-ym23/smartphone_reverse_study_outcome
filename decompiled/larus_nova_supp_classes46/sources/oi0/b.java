package oi0;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.revenue.game.api.LinkMicGameApi;
import com.bytedance.android.live.liveinteract.wrds.LinkWRDSHelper;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.wrds.LinkMicRoomDataSyncModel;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.message.VideoChatDynamic1V7Info;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import sh0.h0;
import sh0.i0;
import sh0.j0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements oi0.a {
    public boolean b;
    public final CompositeDisposable c;
    public final Context d;
    public final DataCenter e;

    public static final class a {
    }

    /* JADX INFO: renamed from: oi0.b$b, reason: collision with other inner class name */
    public static final class C0248b<T> implements Consumer {
        public final /* synthetic */ b a;
        public final /* synthetic */ boolean b;

        public C0248b(b r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            e r5 = (e) r4;
            ALogger.i("MicSeatStatusController#Anchor", "positionStashPop success, targetIsMicSeatFold: " + this.b);
            b r6 = this.a;
            boolean r1 = r6.b;
            boolean r2 = this.b;
            if (r1 == r2) goto L10;
            r6.b = r2;
            i0 r7 = j0.a(r6.e);
            if (r7 == null) goto L8;
            int r3 = h0.a;
            r7.b("is_mic_seat_fold", Boolean.valueOf(this.a.b));
        L8:
            b r8 = this.a;
            boolean r9 = this.b;
            r8.getClass();
            ALogger.i("MicSeatStatusController#Anchor", "updateSei, isMicSeatFold: " + r9);
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ b a;

        public c(b r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            ALogger.e("MicSeatStatusController#Anchor", "positionStashPop failed", r4);
            ExceptionUtils.handleException(this.a.getContext(), r4);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ b a;

        public d(b r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            ClientUIInfo r7 = ((IRoomLinkMicSyncData) r6).getClientUIInfo();
            if (r7 == null) goto L7;
            VideoChatDynamic1V7Info r8 = r7.getVideoChatDynamic1V7Info();
            if (r8 == null) goto L7;
            Long r9 = Long.valueOf(r8.getStatus());
        L8:
            oi0.a.a.getClass();
            if (r9 != null) goto L12;
        L14:
            boolean r0 = false;
        L16:
            if (this.a.b == r0) goto L23;
            ALogger.i("MicSeatStatusController#Anchor", "WRDS#status: " + r9 + ", WRDS#isMicSeatFold change from " + this.a.b + " to " + r0);
            b r10 = this.a;
            r10.b = r0;
            i0 r11 = j0.a(r10.e);
            if (r11 == null) goto L21;
            int r2 = h0.a;
            r11.b("is_mic_seat_fold", Boolean.valueOf(this.a.b));
        L21:
            this.a.getClass();
            ALogger.i("MicSeatStatusController#Anchor", "updateSei, isMicSeatFold: " + r0);
            return;
        L23:
            return;
        L12:
            if (r9.longValue() != 2) goto L14;
            r0 = true;
        L7:
            r9 = null;
            goto L8
        }
    }

    static {
    }

    @Override // oi0.a
    public final void onSeiUpdated(SeiAppData r1) {
    }

    @Override // oi0.a
    public final void onDestroy() {
        ALogger.i("MicSeatStatusController#Anchor", "onDestroy");
        this.c.clear();
    }

    @Override // oi0.a
    public final void onCreate() {
        LinkMicRoomDataSyncModel r0 = LinkWRDSHelper.b();
        if (r0 == null) goto L13;
        dc2.c r1 = r0.getTalkRoomListUserInfoPb();
        if (r1 == null) goto L13;
        IRoomLinkMicSyncData r2 = (IRoomLinkMicSyncData) r1.c();
        if (r2 == null) goto L13;
        ClientUIInfo r3 = r2.getClientUIInfo();
        if (r3 == null) goto L13;
        VideoChatDynamic1V7Info r4 = r3.getVideoChatDynamic1V7Info();
        if (r4 == null) goto L13;
        Long r5 = Long.valueOf(r4.getStatus());
    L14:
        oi0.a.a.getClass();
        if (r5 != null) goto L18;
    L20:
        boolean r6 = false;
    L21:
        this.b = r6;
        i0 r7 = j0.a(this.e);
        if (r7 == null) goto L24;
        int r8 = h0.a;
        r7.b("is_mic_seat_fold", Boolean.valueOf(this.b));
    L24:
        ALogger.i("MicSeatStatusController#Anchor", "onCreate, status: " + r5 + ", isCurrentMicSeatStash: " + this.b);
        LinkMicRoomDataSyncModel r9 = LinkWRDSHelper.b();
        if (r9 == null) goto L34;
        dc2.c r10 = r9.getTalkRoomListUserInfoPb();
        if (r10 == null) goto L35;
        Observable r11 = r10.d;
        if (r11 == null) goto L36;
        Disposable r12 = r11.subscribe(new d(this));
        if (r12 == null) goto L37;
        RxUtilKt.c(r12, this.c);
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L18:
        if (r5.longValue() != 2) goto L20;
        r6 = true;
    L13:
        r5 = null;
        goto L14
    }

    public final Context getContext() {
        return this.d;
    }

    @Override // oi0.a
    public final void w0(boolean r5) {
        ALogger.i("MicSeatStatusController#Anchor", "onClickFoldButton: " + r5);
        int r0 = 1;
        boolean r6 = r5 ^ true;
        LinkMicGameApi r1 = (LinkMicGameApi) com.bytedance.android.live.network.c.b().e(LinkMicGameApi.class);
        o r2 = m.i();
        if (r2 == null) goto L9;
        com.bytedance.live.datacontext.m r3 = r2.getRoom();
        if (r3 == null) goto L9;
        IRoom r4 = (IRoom) r3.getValue();
        if (r4 == null) goto L9;
        long r7 = r4.getRoomId();
    L10:
        if (r6 == false) goto L12;
        r0 = 2;
    L12:
        Disposable r8 = RxUtilKt.i(r1.positionStashPop(r7, r0)).subscribe(new C0248b(this, r6), new c(this));
        if (r8 == null) goto L15;
        RxUtilKt.c(r8, this.c);
    L15:
        String r9 = qi0.c.b;
        qi0.c.l(r6);
        return;
    L9:
        r7 = 0;
        goto L10
    }

    public b(Context r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.d = r2;
        this.e = r3;
        this.c = new CompositeDisposable();
    }
}
