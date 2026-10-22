package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.revlink.impl.control.LinkRevControlWidget;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.framework.LoadState;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/LinkDelegateWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/p;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkDelegateWidget extends MiddlewareRoomWidget implements p {
    public static final /* synthetic */ int i = 0;
    public kc0.r a;
    public boolean b;
    public com.bytedance.android.live.revenue.core.b c;
    public final boolean d;
    public c e;
    public d f;
    public a0 g;
    public Disposable h;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ LinkDelegateWidget a;

        public static final class a<T> implements h80.a {
            public final /* synthetic */ b a;

            public a(b r1) {
                this.a = r1;
            }

            public final void accept(Object r3) {
                IRoom r4 = (IRoom) r3;
                LinkDelegateWidget r0 = this.a.a;
                if (r4 != null) goto L6;
                int r5 = LinkDelegateWidget.i;
                r0.getClass();
                return;
            L6:
                if (r0.b == true) goto L8;
                r0.g = new a0(r0, r4);
                return;
            L8:
                kc0.r r1 = r0.a;
                if (r1 == null) goto L14;
                r1.p3(r4);
                return;
            }
        }

        public b(LinkDelegateWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.runWithRoomEntered(new a(this));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ LinkDelegateWidget a;
        public final /* synthetic */ String b;

        public c(LinkDelegateWidget r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            kc0.r r0 = this.a.a;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.onSei(this.b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ LinkDelegateWidget a;
        public final /* synthetic */ hh1.v0 b;

        public d(LinkDelegateWidget r1, hh1.v0 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            kc0.r r0 = this.a.a;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.q3(new vc0.a(this.b));     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    public final /* synthetic */ void onAbilityClear() {
        IAbility.-CC.$default$onAbilityClear(this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.p
    public final kf1.a cf() {
        kc0.r r0 = this.a;
        if (r0 == null) goto L5;
        LinkRevControlWidget r1 = r0.getWidget();
    L7:
        if ((r1 instanceof kf1.a) == true) goto L10;
        return null;
    L10:
        return r1;
    L5:
        r1 = null;
        goto L7
    }

    public final void wq() {
        if (this.b == false) goto L6;
        return;
    L6:
        if (this.c != null) goto L8;
        return;
    L8:
        kc0.r r0 = this.a;
        if (r0 == null) goto L30;
        LinkRevControlWidget r1 = r0.getWidget();
        if (r1 == null) goto L31;
        h70.b r2 = getComponentContext();
        if (r2 == null) goto L16;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r3 = ho1.a.c(r2);
    L17:
        if (r3 == null) goto L19;
        com.bytedance.android.livesdk.chatroom.ui.framework.a.C0015a.a(r3, 2131375532, r1, this.d, 8);
    L19:
        this.b = true;
        a0 r4 = this.g;
        if (r4 == null) goto L22;
        r4.run();
    L22:
        this.g = null;
        d r5 = this.f;
        if (r5 == null) goto L25;
        r5.run();
    L25:
        this.f = null;
        c r6 = this.e;
        if (r6 == null) goto L28;
        r6.run();
    L28:
        this.e = null;
        return;
    L16:
        r3 = null;
        goto L17
    L31:
        return;
    }

    public LinkDelegateWidget() {
        this.d = true;
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = ho1.a.d(getComponentContext());
        if (r0 == null) goto L7;
        hh1.v0 r1 = r0.getLiveVideoClientFactory();
        if (r1 == null) goto L7;
        vq(r1);
    L7:
        h70.b r2 = getComponentContext();
        RoomContext r3 = null;
        if ((r2 instanceof com.bytedance.android.livesdk.widgetdescriptor.e0) == true) goto L10;
        r2 = null;
    L10:
        com.bytedance.android.livesdk.widgetdescriptor.e0 r4 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r2;
        if (r4 == null) goto L14;
        r3 = r4.b();
    L14:
        if (((Boolean) com.bytedance.android.livesdk.e1.a.getValue()).booleanValue() == false) goto L19;
        if (r3 == null) goto L23;
        com.bytedance.live.datacontext.i r5 = r3.getRevenueInstanceInitialized();
        if (r5 == null) goto L23;
        r5.c(new LinkDelegateWidget$onRoomContextReady$1(this));
    L23:
        h70.b r6 = getComponentContext();
        if (r6 == null) goto L49;
        IAbilityCenter r7 = r6.a();
        if (r7 == null) goto L49;
        final com.bytedance.android.livesdk.chatroom.ui.framework.c r8 = (com.bytedance.android.livesdk.chatroom.ui.framework.c) r7.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.c.class);
        if (r8 == null) goto L49;
        h70.b r9 = getComponentContext();
        if (r9 == null) goto L49;
        IAbilityCenter r10 = r9.a();
        if (r10 == null) goto L49;
        final com.bytedance.android.livesdk.chatroom.ui.framework.a r11 = (com.bytedance.android.livesdk.chatroom.ui.framework.a) r10.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.a.class);
        if (r11 == null) goto L49;
        if (r8.V9() == false) goto L42;
        int r12 = LoadState.P0_BEGIN.getValue();
    L40:
        final int r13 = r12;
        final Ref.BooleanRef r14 = new Ref.BooleanRef();
        r14.element = false;
        this.h = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.p.a(r11.getLoadState(), new LinkDelegateWidget$onLoadBatchReady$1(this, r14, r13, r8, r11));
        goto L49
    L42:
        if (r8.o5() == false) goto L45;
        r12 = LoadState.P3_END.getValue();
        goto L40
    L45:
        if (r8.dg() == false) goto L47;
        r12 = LoadState.P0_BEGIN.getValue();
        goto L40
    L47:
        r12 = LoadState.P3_END.getValue();
    L49:
        MainThreadPostUtils.b(new b(this));
        h70.b r15 = getComponentContext();
        if (r15 == null) goto L55;
        IAbilityCenter r16 = r15.a();
        if (r16 == null) goto L56;
        r16.registerAbility(p.class, this);
        return;
    L56:
        return;
    L55:
        return;
    L19:
        if (r3 == null) goto L23;
        com.bytedance.live.datacontext.j r17 = r3.getRevenueInstance();
        if (r17 == null) goto L23;
        r17.c(new LinkDelegateWidget$onRoomContextReady$2(this));
        goto L23
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        h70.b r0 = getComponentContext();
        if (r0 == null) goto L7;
        IAbilityCenter r1 = r0.a();
        if (r1 == null) goto L7;
        r1.unregisterAbility(p.class);
    L7:
        Disposable r2 = this.h;
        if (r2 == null) goto L11;
        r2.dispose();
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.p
    public final void b0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        if (this.b == true) goto L5;
        return;
    L5:
        kc0.r r0 = this.a;
        if (r0 == null) goto L9;
        r0.b0(r2);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.p
    public final void onSei(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        if (this.b == true) goto L6;
        this.e = new c(this, r2);
        return;
    L6:
        kc0.r r0 = this.a;
        if (r0 == null) goto L10;
        r0.onSei(r2);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.p
    public final void vq(hh1.v0 r3) {
        Intrinsics.checkNotNullParameter(r3, "videoClientFactory");
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = ho1.a.d(getComponentContext());
        if (r0 == null) goto L5;
        LiveMode r1 = r0.getLiveMode();
    L7:
        if (r1 == LiveMode.SCREEN_RECORD) goto L10;
        return;
    L10:
        if (this.b == true) goto L13;
        this.f = new d(this, r3);
        return;
    L13:
        kc0.r r2 = this.a;
        if (r2 == null) goto L17;
        r2.q3(new vc0.a(r3));
        return;
    L17:
        return;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.p
    public final void a(View r2, MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r2, "v");
        Intrinsics.checkNotNullParameter(r3, "event");
        if (this.b == true) goto L5;
        return;
    L5:
        kc0.r r0 = this.a;
        if (r0 == null) goto L9;
        r0.a(r2, r3);
        return;
    }
}
