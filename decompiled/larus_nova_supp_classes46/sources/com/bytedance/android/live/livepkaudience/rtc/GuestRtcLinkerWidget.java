package com.bytedance.android.live.livepkaudience.rtc;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.k6;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.service.g;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerBattleConnectContent;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import gd0.i;
import gd0.x;
import gi6.e;
import hh1.v0;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/rtc/GuestRtcLinkerWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "Lcom/bytedance/android/live/livepkaudience/rtc/c;", "<init>", "()V", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GuestRtcLinkerWidget extends LiveWidget implements c {
    public a a;
    public Room b;
    public final CompositeDisposable c;
    public LinkerBattleConnectContent d;

    @Override // com.bytedance.android.live.livepkaudience.rtc.c
    public final x createRtcData() {
        a r0 = this.a;
        if (r0 == null) goto L5;
        x r9 = new x(r0.a, r0.j, r0.s, r0.b, false, r0.c, 16);
        r0.j = false;
        return r9;
    L5:
        return null;
    }

    @Override // com.bytedance.android.live.livepkaudience.rtc.c
    public final v0 getLiveVideoClientFactory() {
        a r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.q;
    }

    @Override // com.bytedance.android.live.livepkaudience.rtc.c
    public final boolean isRtcEngineOn() {
        a r0 = this.a;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.j;
    }

    public GuestRtcLinkerWidget() {
        this.c = new CompositeDisposable();
    }

    public final void onCreate() {
        super.onCreate();
        Room r4 = null;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L7;
        m r1 = r0.getRoom();
        if (r1 == null) goto L7;
        r4 = (Room) r1.getValue();
    L7:
        this.b = r4;
        ((Boolean) ((Widget) this).dataCenter.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        Room r2 = this.b;
        if (r2 == null) goto L10;
        this.a = new a(r2);
    L10:
        Pair r3 = com.bytedance.live.datacontext.d.a(GuestRtcLinkerWidget$onCreate$pair$1.INSTANCE);
        ((GuestRtcLinkerContext) r3.getFirst()).getService().d(this);
        com.bytedance.live.datacontext.b.a((DataContext) r3.getFirst(), "rtc__rev_guest_linker_service");
        this.c.add((Disposable) r3.getSecond());
    }

    public final void onDestroy() {
        super.onDestroy();
        this.c.dispose();
        a r0 = this.a;
        if (r0 == null) goto L14;
        IInteractService r1 = (IInteractService) k.f(IInteractService.class);
        if (r1 == null) goto L11;
        i r2 = r1.getInteractFloatWindowService();
        if (r2 == null) goto L11;
        boolean r3 = true;
        if (((g) r2).b() != true) goto L11;
    L12:
        r0.d(r3);
    L11:
        r3 = false;
    L14:
        if (((Boolean) k6.a.getValue()).booleanValue() == false) goto L17;
        ((Widget) this).widgetCallback = null;
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.rtc.c
    public final LinkerBattleConnectContent getLinkerContentMap() {
        return this.d;
    }

    @Override // com.bytedance.android.live.livepkaudience.rtc.c
    public final a getRtcManager() {
        return this.a;
    }

    @Override // com.bytedance.android.live.livepkaudience.rtc.c
    public final void I7(LinkerBattleConnectContent r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        this.d = r2;
    }

    @Override // com.bytedance.android.live.livepkaudience.rtc.c
    public final void rd(x r4, v0 r5) {
        Intrinsics.checkNotNullParameter(r4, "rtcManagerData");
        a r1 = this.a;
        if (r1 == null) goto L14;
        Intrinsics.checkNotNullParameter(r4, "rtcManagerData");
        r1.q = r5;
        ei6.a r0 = r4.a;
        r1.a = r0;
        r1.b = r4.d;
        r1.s = r4.c;
        r1.j = r4.b;
        if (r0 == null) goto L9;
        e r2 = r0.getEventManager();
        if (r2 == null) goto L9;
        r2.b(r1.p);
    L9:
        ALogger.e("ttlive_pk", "GuestRtcManager.setClient map.size = " + r1.s.size() + ", isEngineOn = " + r1.j);
        if (r4.a == null) goto L12;
        if (r5 == null) goto L12;
        return;
    L12:
        ALogger.e("ttlive_pk", "GuestRtcManager.setClient mClient = null", new IllegalStateException());
        return;
    }
}
