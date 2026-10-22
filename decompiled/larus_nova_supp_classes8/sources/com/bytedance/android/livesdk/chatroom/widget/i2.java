package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i2 implements WidgetManager.IWidgetConfigHandler {
    public u60.a a;
    public bn0.b b;
    public final CompositeDisposable c;
    public final RoomContext d;
    public final DataCenter e;

    public static final class a implements Runnable {
        public final /* synthetic */ i2 a;

        public a(i2 r1) {
            this.a = r1;
        }

        public final void a() {
            i2 r0 = this.a;
            com.bytedance.android.live.revenue.core.b r1 = (com.bytedance.android.live.revenue.core.b) r0.d.getRevenueInstance().getValue();
            u60.a r2 = null;
            if (r1 == null) goto L7;
            cy0.l r3 = r1.e();
            if (r3 == null) goto L7;
            com.bytedance.android.live.revenue.core.b r4 = r3.A();
        L9:
            if ((r4 instanceof com.bytedance.live.kmp.core.a) == true) goto L11;
            r4 = null;
        L11:
            com.bytedance.live.kmp.core.a r5 = (com.bytedance.live.kmp.core.a) r4;
            if (r5 == null) goto L14;
            r2 = r5.c();
        L14:
            r0.a = r2;
            i2 r6 = this.a;
            u60.a r7 = r6.a;
            if (r7 == null) goto L17;
            r6.b = com.bytedance.android.scope.m.e.a(r7, bn0.b.class);
        L17:
            this.a.d.getMultiLinkRoomScope().setValue(this.a.b);
            return;
        L7:
            r4 = null;
            goto L9
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ f0 a;
        public final /* synthetic */ i2 b;
        public final /* synthetic */ Widget c;

        public b(f0 r1, i2 r2, Widget r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            ALogger.e("RoomContextInjector", "call onLoad, widget = " + this.c + ", \nroomId = " + ((Room) this.b.d.getRoom().getValue()).getRoomId() + " \nHasMultiLinkRoomScope = " + (this.c instanceof f0) + " \nliveRoomScope = " + this.b.a + " \nmultiLinkRoomScope = " + this.b.b);
            this.a.setMultiLinkRoomScope(this.b.b);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void onDestroy(Widget r3) {
        Intrinsics.checkNotNullParameter(r3, "widget");
        if ((r3 instanceof g0) == true) goto L5;
        r3 = null;
    L5:
        g0 r4 = (g0) r3;
        if (r4 == null) goto L8;
        r4.setRoomContext(null);
    L8:
        this.c.clear();
    }

    public final void onLoad(Widget r7) {
        Intrinsics.checkNotNullParameter(r7, "widget");
        Widget r1 = null;
        if ((r7 instanceof h0) == true) goto L5;
        Widget r0 = null;
    L6:
        h0 r2 = (h0) r0;
        if (r2 == null) goto L10;
        r2.setRoomContext(this.d);
    L10:
        if ((r7 instanceof g0) == true) goto L12;
        Widget r3 = null;
    L13:
        g0 r4 = (g0) r3;
        if (r4 == null) goto L17;
        r4.setRoomContext(this.d);
    L17:
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == true) goto L26;
        boolean r5 = r7 instanceof f0;
        if (r5 == false) goto L22;
        r1 = r7;
    L22:
        f0 r6 = (f0) r1;
        if (r6 == null) goto L32;
        ALogger.e("RoomContextInjector", "call onLoad, widget = " + r7 + ", \nroomId = " + ((Room) this.d.getRoom().getValue()).getRoomId() + " \nHasMultiLinkRoomScope = " + r5 + " \nliveRoomScope = " + this.a + " \nmultiLinkRoomScope = " + this.b);
        r6.setMultiLinkRoomScope(this.b);
    L32:
        LocalTestManager.a(new Class[]{wy.a.class});
        return;
    L26:
        if ((r7 instanceof f0) == false) goto L29;
        r1 = r7;
    L29:
        f0 r8 = (f0) r1;
        if (r8 == null) goto L32;
        int r9 = com.bytedance.android.live.room.y.a;
        com.bytedance.android.live.room.y.a(this.e, this.c, "RoomContextInjector", new b(r8, this, r7));
        goto L32
    L12:
        r3 = r7;
        goto L13
    L5:
        r0 = r7;
        goto L6
    }

    public final void onUnload(Widget r3) {
        Intrinsics.checkNotNullParameter(r3, "widget");
        if ((r3 instanceof g0) == true) goto L5;
        r3 = null;
    L5:
        g0 r4 = (g0) r3;
        if (r4 == null) goto L9;
        r4.setRoomContext(null);
        return;
    }

    public i2(RoomContext r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r3, "dataContext");
        this.d = r3;
        this.e = r4;
        CompositeDisposable r0 = new CompositeDisposable();
        this.c = r0;
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == true) goto L20;
        com.bytedance.android.live.revenue.core.b r5 = (com.bytedance.android.live.revenue.core.b) r3.getRevenueInstance().getValue();
        u60.a r1 = null;
        if (r5 == null) goto L9;
        cy0.l r6 = r5.e();
        if (r6 == null) goto L9;
        com.bytedance.android.live.revenue.core.b r7 = r6.A();
    L11:
        if ((r7 instanceof com.bytedance.live.kmp.core.a) == true) goto L13;
        r7 = null;
    L13:
        com.bytedance.live.kmp.core.a r8 = (com.bytedance.live.kmp.core.a) r7;
        if (r8 == null) goto L16;
        r1 = r8.c();
    L16:
        this.a = r1;
        if (r1 == null) goto L19;
        this.b = com.bytedance.android.scope.m.e.a(r1, bn0.b.class);
    L19:
        r3.getMultiLinkRoomScope().setValue(this.b);
        return;
    L9:
        r7 = null;
        goto L11
    L20:
        com.bytedance.android.live.room.y.a(r4, r0, "RoomContextInjector", new a(this));
    }
}
