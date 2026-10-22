package com.bytedance.android.livesdk.interactivity.like;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements u32.j {
    public Disposable a;
    public int b;
    public com.bytedance.android.livesdk.interactivity.like.api.a c;
    public final long d;
    public final String e;
    public final String f;

    public static final class a {
    }

    static {
    }

    @Override // u32.j
    public final void dispose() {
        Disposable r0 = this.a;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Long r1 = null;
        this.a = null;
        if (this.b <= 0) goto L23;
        ALogger.i("DiggHandler", "postRemainingDiggCount, current diggCount: " + this.b);
        DiggApi r2 = (DiggApi) com.bytedance.android.live.network.c.b().e(DiggApi.class);
        long r3 = this.d;
        int r5 = this.b;
        nm1.m r4 = pm1.f.l();
        long r6 = 0;
        if (r4 == null) goto L21;
        RoomContext.a r8 = RoomContext.Companion;
        RoomContext r10 = RoomContext.a.c(r8, null, 0, 3);
        if (r10 == null) goto L14;
        com.bytedance.live.datacontext.m r11 = r10.getRoom();
        if (r11 == null) goto L14;
        Room r13 = (Room) r11.getValue();
    L15:
        RoomContext r7 = RoomContext.a.c(r8, null, 0, 3);
        if (r7 == null) goto L20;
        com.bytedance.live.datacontext.m r9 = r7.getCameraId();
        if (r9 == null) goto L20;
        r1 = (Long) r9.getValue();
    L20:
        r6 = r4.k(r13, r1);
    L14:
        r13 = null;
    L21:
        DiggApi.a.a(r2, r3, r5, r6, "linkmic_guest_like", this.e, 32).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this), new f(this));
        return;
    }

    @Override // u32.j
    public final void onDiggButtonClick() {
        if (this.c != null) goto L5;
        this.c = (com.bytedance.android.livesdk.interactivity.like.api.a) JsonUtil.parse(this.f, com.bytedance.android.livesdk.interactivity.like.api.a.class);
    L5:
        this.b++;
        ALogger.i("DiggHandler", "onDiggButtonClick, current diggCount: " + this.b);
        Disposable r0 = this.a;
        if (r0 != null) goto L8;
    L10:
        this.a = Observable.interval(2, 2, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).filter(new g(this)).map(new h(this)).observeOn(Schedulers.io()).flatMap(new i(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new j(this), new k(this));
        return;
    L8:
        if (r0.isDisposed() == true) goto L10;
    }

    @Override // u32.j
    public final void a(DataCenter r7) {
        if (r7 == null) goto L5;
        Room r1 = com.bytedance.android.live.core.utils.z.o(r7);
    L6:
        int r2 = 0;
        if (r7 == null) goto L9;
        boolean r3 = com.bytedance.android.live.core.utils.z.e(r7, false);
    L10:
        if (r7 == null) goto L29;
        int r4 = com.bytedance.android.livesdk.interactivity.like.utils.b.a;
        boolean r8 = ((Boolean) r7.get("data_is_portrait", Boolean.FALSE)).booleanValue();
        if (jc1.k.n(IUserService.class).user().isLogin() == true) goto L14;
        r2 = 1;
    L27:
        InteractivityMonitor.c(InteractivityMonitor.Event.ProfileDiggDisable, r1, Integer.valueOf(r2), null, 24);
        return;
    L14:
        if (r1 == null) goto L21;
        RoomAuthStatus r5 = r1.getRoomAuthStatus();
        if (r5 == null) goto L21;
        if (r5.getEnableDigg() == true) goto L21;
        r2 = 2;
    L21:
        if (((Boolean) l42.a.g.getValue()).booleanValue() == false) goto L23;
    L24:
        if (r8 == true) goto L27;
        if (r3 == true) goto L27;
        r2 = 4;
        goto L27
    L23:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.G0.getValue()).booleanValue() == false) goto L27;
    L29:
        return;
    L9:
        r3 = false;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public d(long r2, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "diggTargetUid");
        this.d = r2;
        this.e = r4;
        this.f = r5;
    }
}
