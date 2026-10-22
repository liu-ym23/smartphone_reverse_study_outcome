package oi0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.revenue.game.LinkMicGameContext;
import com.bytedance.android.live.liveinteract.wrds.LinkWRDSHelper;
import com.bytedance.android.livesdk.wrds.LinkMicRoomDataSyncModel;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.message.VideoChatDynamic1V7Info;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import sh0.h0;
import sh0.i0;
import sh0.j0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements oi0.a {
    public boolean b;
    public final CompositeDisposable c;
    public final DataCenter d;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ d a;

        public b(d r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            ClientUIInfo r8 = ((IRoomLinkMicSyncData) r7).getClientUIInfo();
            if (r8 == null) goto L7;
            VideoChatDynamic1V7Info r9 = r8.getVideoChatDynamic1V7Info();
            if (r9 == null) goto L7;
            Long r10 = Long.valueOf(r9.getStatus());
        L8:
            oi0.a.a.getClass();
            if (r10 != null) goto L12;
        L14:
            boolean r1 = false;
        L16:
            if (this.a.b == r1) goto L29;
            ALogger.i("MicSeatStatusController#Guest", "WRDS#status: " + r10 + ", WRDS#isMicSeatFold change from " + this.a.b + " to " + r1);
            LinkMicGameContext r11 = LinkMicGameContext.Companion.getContext();
            if (r11 != null) goto L21;
        L23:
            d r12 = this.a;
            r12.b = r1;
            i0 r13 = j0.e(r12.d);
            if (r13 == null) goto L28;
            int r0 = h0.a;
            r13.b("is_mic_seat_fold", Boolean.valueOf(this.a.b));
            return;
        L28:
            return;
        L21:
            if (r11.getHasClickFoldButtonBySelf() != true) goto L23;
            ALogger.i("MicSeatStatusController#Guest", "hasClickFoldButtonBySelf");
            return;
        L29:
            return;
        L12:
            if (r10.longValue() != 2) goto L14;
            r1 = true;
        L7:
            r10 = null;
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
        ALogger.i("MicSeatStatusController#Guest", "onDestroy");
        this.c.clear();
        LinkMicGameContext r0 = LinkMicGameContext.Companion.getContext();
        if (r0 == null) goto L6;
        r0.setHasClickFoldButtonBySelf(false);
        return;
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
        i0 r7 = j0.a(this.d);
        if (r7 == null) goto L24;
        int r8 = h0.a;
        r7.b("is_mic_seat_fold", Boolean.valueOf(this.b));
    L24:
        ALogger.i("MicSeatStatusController#Guest", "onCreate, WRDS#status: " + r5 + ", isCurrentMicSeatStash: " + this.b);
        LinkMicRoomDataSyncModel r9 = LinkWRDSHelper.b();
        if (r9 == null) goto L34;
        dc2.c r10 = r9.getTalkRoomListUserInfoPb();
        if (r10 == null) goto L35;
        Observable r11 = r10.d;
        if (r11 == null) goto L36;
        Disposable r12 = r11.subscribe(new b(this));
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

    public d(DataCenter r1) {
        this.d = r1;
        this.c = new CompositeDisposable();
    }

    @Override // oi0.a
    public final void w0(boolean r4) {
        ALogger.i("MicSeatStatusController#Guest", "onClickFoldButton: " + r4);
        boolean r5 = r4 ^ true;
        LinkMicGameContext r1 = LinkMicGameContext.Companion.getContext();
        if (r1 == null) goto L5;
        r1.setHasClickFoldButtonBySelf(true);
    L5:
        this.b = r5;
        i0 r0 = j0.a(this.d);
        if (r0 == null) goto L8;
        int r2 = h0.a;
        r0.b("is_mic_seat_fold", Boolean.valueOf(this.b));
    L8:
        String r3 = qi0.c.b;
        qi0.c.l(r5);
    }
}
