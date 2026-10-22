package com.bytedance.android.live.profit.livepet.container;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.core.utils.w;
import com.bytedance.android.live.profit.livepet.instance.LivePetInstance;
import com.bytedance.android.live.profit.livepet.utils.DebugModeKt;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/profit/livepet/container/LivePetContainerWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "<init>", "()V", "a", "live-privilege-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LivePetContainerWidget extends MiddlewareRoomWidget {
    public final CompositeDisposable a;
    public ViewGroup b;
    public ru0.a c;
    public View d;

    public static final class a {
    }

    static {
    }

    public final int getLayoutId() {
        return 2131566862;
    }

    public LivePetContainerWidget() {
        this.a = new CompositeDisposable();
    }

    public final void onCreate() {
        super.onCreate();
        jy0.b.a("LivePet/ContainerWidget", "onCreate");
        com.bytedance.android.live.profit.livepet.d r0 = (com.bytedance.android.live.profit.livepet.d) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.live.profit.livepet.d.class);
        DataCenter r1 = ((Widget) this).dataCenter;
        Intrinsics.checkNotNullParameter(r1, "roomKey");
        ru0.a r2 = r0.a.get(Integer.valueOf(r1.hashCode()));
        if (r2 != null) goto L5;
        return;
    L5:
        this.c = r2;
        ViewGroup r3 = (ViewGroup) findViewById(2131382194);
        this.b = r3;
        if (qu0.b.c.a().getDebugMode() <= 0) goto L10;
        int r4 = w.a;
        if (v.a() == false) goto L10;
        boolean r5 = true;
    L11:
        if (r5 == false) goto L13;
        DebugModeKt.a(this, r2, findViewById(2131367866), r3);
    L13:
        ru0.a r6 = this.c;
        if (r6 == null) goto L16;
        c r7 = (c) com.bytedance.android.scope.m.e.d(r6, c.class);
    L17:
        if (r7 == null) goto L26;
        Intrinsics.checkNotNullParameter(this, "widget");
        LivePetInstance r8 = r7.c;
        int r9 = c.j;
        r7.a(r8, this);
        ViewGroup r10 = this.b;
        if (r10 == null) goto L24;
        e r12 = r7.i;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r10, "petContainer");
        if (r12.b == null) goto L23;
        jy0.b.f("LivePet/LayoutManager", "petContainer is already set", null, 4);
        return;
    L23:
        r12.b = r10;
        RxUtilKt.c(RxUtilKt.g(r10, true).map(new h(r10)).distinctUntilChanged().subscribe(new i(r12)), r12.a);
        int r13 = com.bytedance.android.live.revenue.common.i.b(128);
        com.bytedance.android.live.core.utils.statusbar.a.b.a();
        ALogger.e("ImmersiveStatusBarMgr", "Config not initialized, returning default false");
        k r14 = r12.d;
        r14.b = r13 + 0;
        r14.a = 0;
        r14.c = 0;
        RxUtilKt.c(RxUtilKt.b(r12.g.getDataCenter(), "cmd_data_interact_public_screen_height_change", true).distinctUntilChanged(f.a).map(g.a).subscribe(new j(r12)), r12.a);
        return;
    L24:
        jy0.b.f("LivePet/ContainerService", "pet container view is null", null, 4);
        return;
    L26:
        return;
    L16:
        r7 = null;
    L10:
        r5 = false;
        goto L11
    }

    public final void onDestroy() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onDestroy();
        jy0.b.a("LivePet/ContainerWidget", "onDestroy");
        ru0.a r0 = this.c;
        if (r0 == null) goto L5;
        c r1 = (c) com.bytedance.android.scope.m.e.d(r0, c.class);
    L6:
        if (r1 == null) goto L10;
        Intrinsics.checkNotNullParameter(this, "widget");
        if (Intrinsics.areEqual(r1.d, this) == false) goto L10;
        r1.a(r1.c, null);
    L10:
        this.c = null;
        this.b = null;
        this.d = null;
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void wq(View r3) {
        if (Intrinsics.areEqual(this.d, r3) == false) goto L5;
        return;
    L5:
        ViewGroup r0 = this.b;
        if (r0 != null) goto L8;
        return;
    L8:
        View r1 = this.d;
        if (r1 == null) goto L11;
        r0.removeView(r1);
    L11:
        if (r3 == null) goto L13;
        r0.addView(r3);
    L13:
        this.d = r3;
    }
}
