package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.strategy;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.arch.mvvm.f;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyContext;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.BaseTimingUpdater;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.model.e;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.q;
import com.bytedance.android.livesdk.interactivity.api.settings.config.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IPublicScreenSpeedConfig;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends BaseTimingUpdater<c> {
    public final int c;
    public final IPublicScreenSpeedConfig d;
    public final Disposable e;
    public e f;
    public final j0 g;
    public final InterfaceC0192a h;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.strategy.a$a, reason: collision with other inner class name */
    public interface InterfaceC0192a {
        void update(int r1, long r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.BaseTimingUpdater
    public final void c() {
        e(new c(this.f.b));
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.BaseTimingUpdater
    public final long d() {
        return this.f.a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.BaseTimingUpdater
    public final void i() {
        super.i();
        Disposable r0 = this.e;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public a(DataCenter r6, j0 r7, com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter.c r8) {
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        Intrinsics.checkNotNullParameter(r7, "config");
        Intrinsics.checkNotNullParameter(r8, "speedListener");
        this.g = r7;
        this.h = r8;
        this.c = 2;
        IRoomContextService r1 = k.f(IRoomContextService.class);
        Disposable r2 = null;
        if (r1 == null) goto L11;
        o r0 = IRoomContextService.a.a(r1, r6, 0, 2);
        if (r0 == null) goto L11;
        j r3 = r0.r2();
        if (r3 == null) goto L11;
        IDynamicStrategyContext r4 = (IDynamicStrategyContext) r3.getValue();
        if (r4 == null) goto L11;
        PropertyOwner r5 = r4.getStrategy("public_screen_speed_strategy");
    L12:
        int r9 = q.a;
        IPublicScreenSpeedConfig r10 = q.g((IRoom) r6.get("data_room"));
        this.d = r10;
        if (r5 == null) goto L19;
        Observable r11 = f.b(r5);
        if (r11 == null) goto L19;
        Observable r13 = RxUtilKt.h(r11);
        if (r13 == null) goto L19;
        r2 = r13.subscribe(new b(this));
    L19:
        this.e = r2;
        e r14 = q.h(r7, -1, r10);
        this.f = r14;
        int r15 = ga2.d.a;
        ga2.d.c(r14.a, r14.b, r14.d);
        e r16 = this.f;
        r8.update(r16.d, r16.a);
        return;
    L11:
        r5 = null;
        goto L12
    }
}
