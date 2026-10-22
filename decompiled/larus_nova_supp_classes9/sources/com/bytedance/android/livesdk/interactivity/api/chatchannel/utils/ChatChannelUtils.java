package com.bytedance.android.livesdk.interactivity.api.chatchannel.utils;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.model.PadOrientation;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.ContainerType;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class ChatChannelUtils {

    public static final class a implements Action {
        public final /* synthetic */ DataCenter a;
        public final /* synthetic */ Observer b;
        public final /* synthetic */ Disposable c;
        public final /* synthetic */ Disposable d;
        public final /* synthetic */ Disposable e;

        public a(DataCenter r1, c r2, Disposable r3, Disposable r4, Disposable r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void run() {
            this.a.removeObserver(this.b);
            Disposable r0 = this.c;
            if (r0 == null) goto L5;
            r0.dispose();
        L5:
            Disposable r1 = this.d;
            if (r1 == null) goto L8;
            r1.dispose();
        L8:
            Disposable r2 = this.e;
            if (r2 == null) goto L12;
            r2.dispose();
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ Function0 a;

        public b(Function0 r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Boolean r2 = (Boolean) r1;
            this.a.invoke();
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ Function0 a;

        public c(Function0 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            KVData r2 = (KVData) r1;
            this.a.invoke();
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ Function0 a;

        public d(Function0 r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            com.bytedance.android.livesdk.interactivity.api.base.d r2 = (com.bytedance.android.livesdk.interactivity.api.base.d) r1;
            this.a.invoke();
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ Function0 a;

        public e(Function0 r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            com.bytedance.android.livesdk.interactivity.api.base.d r2 = (com.bytedance.android.livesdk.interactivity.api.base.d) r1;
            this.a.invoke();
        }
    }

    static {
    }

    @JvmStatic
    public static final ContainerType a(RoomContext r1) {
        if (PadConfigUtils.c() == false) goto L16;
        if (i(r1) == false) goto L16;
        if (r1 == null) goto L10;
        com.bytedance.live.datacontext.n r2 = r1.getPadOrientation();
        if (r2 == null) goto L10;
        PadOrientation r3 = (PadOrientation) r2.getValue();
    L12:
        if (r3 != PadOrientation.PORTRAIT) goto L21;
        return ContainerType.MultiTab;
    L21:
        return ContainerType.PublicScreen;
    L10:
        r3 = null;
    L16:
        if (i(r1) == false) goto L19;
        return ContainerType.MultiTab;
    L19:
        return ContainerType.PublicScreen;
    }

    @JvmStatic
    public static final s22.e b(RoomContext r4) {
        if (r4 != null) goto L5;
        r4 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
    L5:
        if (r4 == null) goto L12;
        com.bytedance.android.livesdk.interactivity.api.f r5 = com.bytedance.android.livesdk.interactivity.api.g.a(r4);
        if (r5 == null) goto L13;
        com.bytedance.live.datacontext.j<s22.e> r6 = r5.getChatChannelManager();
        if (r6 != null) goto L11;
        return null;
    L11:
        return (s22.e) r6.getValue();
    L13:
        return null;
    L12:
        return null;
    }

    @JvmStatic
    public static final s22.a c(RoomContext r0) {
        s22.e r1 = b(r0);
        if (r1 == null) goto L9;
        com.bytedance.android.live.core.arch.mvvm.d<sh6.b<s22.a>> r2 = r1.getCurrentChannel();
        if (r2 == null) goto L9;
        sh6.b r3 = (sh6.b) r2.getValue();
        if (r3 == null) goto L9;
        return (s22.a) sh6.c.b(r3);
    L9:
        return null;
    }

    @JvmStatic
    public static final long d(RoomContext r2) {
        s22.a r3 = c(r2);
        if (r3 != null) goto L7;
        return -1;
    L7:
        return r3.getChannelId();
    }

    @JvmStatic
    public static final com.bytedance.live.datacontext.m<Boolean> e(RoomContext r4) {
        if (r4 != null) goto L5;
        r4 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
    L5:
        if (r4 == null) goto L10;
        com.bytedance.android.livesdk.interactivity.api.h r5 = com.bytedance.android.livesdk.interactivity.api.i.c(r4);
        if (r5 != null) goto L9;
        return null;
    L9:
        return r5.getChatChannelLandscapeDialogState();
    L10:
        return null;
    }

    @JvmStatic
    public static final com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a f(RoomContext r4) {
        if (r4 != null) goto L5;
        r4 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
    L5:
        if (r4 == null) goto L12;
        com.bytedance.android.livesdk.interactivity.api.h r5 = com.bytedance.android.livesdk.interactivity.api.i.c(r4);
        if (r5 == null) goto L13;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a> r6 = r5.getMultiChatTabAreaStateManager();
        if (r6 != null) goto L11;
        return null;
    L11:
        return (com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a) r6.getValue();
    L13:
        return null;
    L12:
        return null;
    }

    @JvmStatic
    public static final com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a g(RoomContext r4) {
        if (r4 != null) goto L5;
        r4 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
    L5:
        if (r4 == null) goto L12;
        com.bytedance.android.livesdk.interactivity.api.h r5 = com.bytedance.android.livesdk.interactivity.api.i.c(r4);
        if (r5 == null) goto L13;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a> r6 = r5.getPublicScreenAreaStateManager();
        if (r6 != null) goto L11;
        return null;
    L11:
        return (com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a) r6.getValue();
    L13:
        return null;
    L12:
        return null;
    }

    @JvmStatic
    public static final boolean h(DataCenter r4) {
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        Long r5 = (Long) r4.get("multi_selected_tab_id", 0L);
        if (r5 != null) goto L6;
    L8:
        return false;
    L6:
        if (r5.longValue() != 10) goto L8;
        return true;
    }

    @JvmStatic
    public static final boolean i(RoomContext r1) {
        s22.e r2 = b(r1);
        if (r2 == null) goto L7;
        s22.e.b r3 = r2.getConfig();
        if (r3 == null) goto L7;
        ContainerType r4 = r3.a;
    L9:
        if (r4 != ContainerType.MultiTab) goto L11;
        return true;
    L11:
        return false;
    L7:
        r4 = null;
        goto L9
    }

    @JvmStatic
    public static final boolean j(RoomContext r4) {
        if (r4 != null) goto L4;
        r4 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
    L4:
        if (r4 == null) goto L10;
        com.bytedance.live.datacontext.m r5 = r4.isPortraitInteraction();
        if (r5 == null) goto L10;
        Boolean r6 = (Boolean) r5.getValue();
        if (r6 == null) goto L10;
        return r6.booleanValue();
    L10:
        return true;
    }

    @JvmStatic
    public static final com.bytedance.live.datacontext.j<s22.e> n(RoomContext r4) {
        if (r4 != null) goto L5;
        r4 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
    L5:
        if (r4 == null) goto L10;
        com.bytedance.android.livesdk.interactivity.api.f r5 = com.bytedance.android.livesdk.interactivity.api.g.a(r4);
        if (r5 != null) goto L9;
        return null;
    L9:
        return r5.getChatChannelManager();
    L10:
        return null;
    }

    @JvmStatic
    public static final boolean k(RoomContext r4, DataCenter r5) {
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        if (a(r4) != ContainerType.MultiTab) goto L5;
        boolean r0 = true;
    L6:
        boolean r1 = j(r4);
        if (r0 == false) goto L21;
        if (r1 == false) goto L21;
        if (h(r5) == false) goto L35;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a r6 = f(r4);
        if (r6 == null) goto L18;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.interactivity.api.base.d> r7 = r6.getState();
        if (r7 == null) goto L18;
        com.bytedance.android.livesdk.interactivity.api.base.d r8 = (com.bytedance.android.livesdk.interactivity.api.base.d) r7.getValue();
        if (r8 == null) goto L18;
        boolean r9 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.b.a(r8);
    L19:
        if (r9 == false) goto L35;
        return true;
    L18:
        r9 = false;
    L35:
        return false;
    L21:
        if (r0 == true) goto L30;
        if (r1 == false) goto L30;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a r10 = g(r4);
        if (r10 == null) goto L35;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.interactivity.api.base.d> r11 = r10.getState();
        if (r11 == null) goto L35;
        com.bytedance.android.livesdk.interactivity.api.base.d r13 = (com.bytedance.android.livesdk.interactivity.api.base.d) r11.getValue();
        if (r13 == null) goto L35;
        return com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.b.a(r13);
    L30:
        com.bytedance.live.datacontext.m<Boolean> r14 = e(r4);
        if (r14 == null) goto L35;
        Boolean r15 = (Boolean) r14.getValue();
        if (r15 == null) goto L35;
        return r15.booleanValue();
    L5:
        r0 = false;
        goto L6
    }

    @JvmStatic
    public static final Disposable l(final DataCenter r5, final Function1<? super Boolean, Unit> r6) {
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        Intrinsics.checkNotNullParameter(r6, "callback");
        final AtomicBoolean r0 = new AtomicBoolean(k(RoomContext.a.c(RoomContext.Companion, r5, 0, 2), r5));
        r6.invoke(Boolean.valueOf(r0.get()));
        return p(r5, new ChatChannelUtils$observeChannelPageShowState$1(r5, r0, r6));
    }

    @JvmStatic
    public static final void m(final DataCenter r6, final Function1 r7) {
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        Intrinsics.checkNotNullParameter(r7, "callback");
        RoomContext.a r1 = RoomContext.Companion;
        final AtomicBoolean r0 = new AtomicBoolean(k(RoomContext.a.c(r1, r6, 0, 2), r6));
        final Function0<Unit> r5 = new ChatChannelUtils$observeChannelPageShowStateForever$wrapCallback$1(r6, r0, r7);
        r7.invoke(Boolean.valueOf(r0.get()));
        Disposable r8 = p(r6, new ChatChannelUtils$observeChannelPageShowStateForever$disposable1$1(r5));
        if (PadConfigUtils.c() == true) goto L12;
        RoomContext r9 = RoomContext.a.c(r1, r6, 0, 2);
        if (r9 == null) goto L12;
        com.bytedance.live.datacontext.m r10 = r9.getReportScreenOrientation();
        if (r10 == null) goto L12;
        Observable r11 = r10.a();
        if (r11 == null) goto L12;
        Disposable r13 = r11.subscribe(new n(r5));
    L13:
        Disposables.fromAction(new m(r8, r13));
        return;
    L12:
        r13 = null;
        goto L13
    }

    @JvmStatic
    public static final Disposable o(final RoomContext r4, final Function1<? super ContainerType, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "callback");
        if (r4 != null) goto L5;
        r4 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
    L5:
        if (r4 != null) goto L8;
        return null;
    L8:
        if (PadConfigUtils.c() == true) goto L10;
    L12:
        r5.invoke(a(r4));
        return null;
    L10:
        if (i(r4) == false) goto L12;
        return i80.a.b(r4.getPadOrientation(), new ChatChannelUtils$observerContainerTypeWithNotify$1(r5, r4));
    }

    @JvmStatic
    public static final Disposable p(DataCenter r7, Function0<Unit> r8) {
        Intrinsics.checkNotNullParameter(r7, "dataCenter");
        Intrinsics.checkNotNullParameter(r8, "callback");
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, r7, 0, 2);
        c r3 = new c(r8);
        r7.observe("multi_selected_tab_id", r3);
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a r1 = f(r0);
        if (r1 == null) goto L9;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.interactivity.api.base.d> r2 = r1.getState();
        if (r2 == null) goto L9;
        Observable r4 = r2.a();
        if (r4 == null) goto L9;
        Disposable r5 = r4.subscribe(new d(r8));
    L10:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a r6 = g(r0);
        if (r6 == null) goto L17;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.interactivity.api.base.d> r9 = r6.getState();
        if (r9 == null) goto L17;
        Observable r10 = r9.a();
        if (r10 == null) goto L17;
        Disposable r11 = r10.subscribe(new e(r8));
    L18:
        com.bytedance.live.datacontext.m<Boolean> r13 = e(r0);
        if (r13 == null) goto L23;
        Observable r14 = r13.a();
        if (r14 == null) goto L23;
        Disposable r15 = r14.subscribe(new b(r8));
    L25:
        return Disposables.fromAction(new a(r7, r3, r5, r11, r15));
    L23:
        r15 = null;
    L17:
        r11 = null;
    L9:
        r5 = null;
        goto L10
    }
}
