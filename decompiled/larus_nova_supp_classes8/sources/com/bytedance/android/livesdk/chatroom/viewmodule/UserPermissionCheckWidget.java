package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.api.IRoomModuleService;
import com.bytedance.android.livesdk.config.ec1;
import com.bytedance.android.livesdk.config.kd0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class UserPermissionCheckWidget extends LiveRecyclableWidget {
    public Room a;
    public String b;
    public String c;
    public String d;
    public ii1.a e;
    public Disposable f;
    public final CompositeDisposable g;
    public final ge1.c h;
    public boolean i;

    public final String getSpm() {
        return "a100.a100.a125";
    }

    public final void onInit(Object[] r1) {
    }

    public final void wq() {
        Room r0 = this.a;
        if (r0 == null) goto L43;
        long r2 = 0;
        if (r0.getId() > 0) goto L7;
        return;
    L7:
        if (jc1.k.f(IRoomModuleService.class) == null) goto L45;
        ec1 r1 = kd0.a.getValue();
        if (r1 != null) goto L11;
    L39:
        xq("reEnter: " + this.a.getId());
        final long r3 = System.currentTimeMillis();
        ((ObservableSubscribeProxy) jc1.k.f(IRoomModuleService.class).getRoomManager().r1(this.a.getId(), this.a.getRequestId(), this.b, this.c, this.d).compose(RxUtil.rxSchedulerHelper()).as(autoDispose())).subscribe(new g3(this, r3), new h3(this, r3));
        return;
    L11:
        if (this.h == null) goto L39;
        if (r1.b() == false) goto L39;
        long r4 = System.currentTimeMillis();
        ge1.c r5 = this.h;
        int r6 = ge1.b.a(r5.a, r5.c, this.a.getId());
        if (r6 < 0) goto L19;
        r2 = r5.b[r6];
    L19:
        if ((r4 - r2) >= r1.a()) goto L22;
        ALogger.i("UserPermissionCheckWidget", "intercept double check");
        return;
    L22:
        ge1.c r7 = this.h;
        long r8 = this.a.getId();
        int r9 = ge1.b.a(r7.a, r7.c, r8);
        if (r9 < 0) goto L25;
        r7.b[r9] = r4;
        goto L39
    L25:
        int r10 = ~r9;
        int r11 = r7.c;
        if (r11 < r7.a.length) goto L35;
        int r12 = (r11 + 1) * 8;
        int r13 = 4;
    L29:
        if (r13 >= 32) goto L34;
        int r14 = (1 << r13) - 12;
        if (r12 <= r14) goto L32;
        r13 = r13 + 1;
        goto L29
    L32:
        r12 = r14;
    L34:
        int r15 = r12 / 8;
        long[] r16 = new long[r15];
        long[] r17 = new long[r15];
        long[] r18 = r7.a;
        System.arraycopy(r18, 0, r16, 0, r18.length);
        long[] r19 = r7.b;
        System.arraycopy(r19, 0, r17, 0, r19.length);
        r7.a = r16;
        r7.b = r17;
    L35:
        int r20 = r7.c - r10;
        if (r20 == 0) goto L38;
        long[] r21 = r7.a;
        int r22 = r10 + 1;
        System.arraycopy(r21, r10, r21, r22, r20);
        long[] r23 = r7.b;
        System.arraycopy(r23, r10, r23, r22, r7.c - r10);
    L38:
        r7.a[r10] = r8;
        r7.b[r10] = r4;
        r7.c++;
        goto L39
    L45:
        return;
    }

    public UserPermissionCheckWidget() {
        this.b = null;
        this.c = null;
        this.d = null;
        this.g = new CompositeDisposable();
        this.h = new ge1.c();
        this.i = false;
    }

    public final void onUnload() {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        Disposable r0 = this.f;
        if (r0 != null) goto L5;
    L7:
        CompositeDisposable r1 = this.g;
        if (r1 == null) goto L10;
        r1.clear();
    L10:
        ge1.c r2 = this.h;
        if (r2 == null) goto L14;
        r2.c = 0;
        return;
    L14:
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        this.f.dispose();
        goto L7
    }

    public void onEvent(zg1.l1 r1) {
        xq("pad_cast_login");
        wq();
    }

    public final void onLoad(Object[] r4) {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        this.a = (Room) ((Widget) this).dataCenter.get("data_room");
        ii1.a r5 = (ii1.a) ((Widget) this).dataCenter.get("data_room_logger");
        this.e = r5;
        if (r5 == null) goto L5;
        this.b = r5.e();
        this.c = this.e.o();
        this.d = this.e.f();
    L5:
        this.i = TTLiveSDKContext.getHostService().h().isLogin();
        this.f = TTLiveSDKContext.getHostService().h().m().subscribe(new i3(this));
        ((ObservableSubscribeProxy) xs2.b.a().b(zg1.l1.class).observeOn(AndroidSchedulers.mainThread()).as(autoDispose())).subscribe(new j3(this));
        if (kd0.a.getValue().b() == false) goto L10;
        Consumer r0 = new k3(this);
        CompositeDisposable r1 = this.g;
        if (r1 == null) goto L10;
        r1.add(xs2.b.a().b(zg1.h0.class).subscribe(r0));
    L10:
        ge1.c r6 = this.h;
        if (r6 == null) goto L14;
        r6.c = 0;
        return;
    }

    public final void xq(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return;
    L5:
        xs2.b.a().post(new zg1.h("login", r4));
        ALogger.d("UserPermissionCheckWidget", r4);
    }
}
