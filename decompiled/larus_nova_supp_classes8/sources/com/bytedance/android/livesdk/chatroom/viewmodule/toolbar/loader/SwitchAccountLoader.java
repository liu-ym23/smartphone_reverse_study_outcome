package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.foundation.depend.SwitchAccountSource;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.m5;
import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveSwitchAccountConfig;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/SwitchAccountLoader;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AbsDynamicLoader;", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SwitchAccountLoader extends AbsDynamicLoader {
    public static final /* synthetic */ int k = 0;
    public final m5 h;
    public final CompositeDisposable i;
    public boolean j;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ SwitchAccountLoader a;

        public b(SwitchAccountLoader r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            SubscriberJsEvent r3 = (SubscriberJsEvent) r2;
            SwitchAccountLoader r4 = this.a;
            int r0 = SwitchAccountLoader.k;
            r4.getClass();
            IInteractService r5 = k.f(IInteractService.class);
            if (r5 != null) goto L5;
        L7:
            LiveSwitchAccountConfig r6 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.helper.a.b;
            com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.helper.a.b(SwitchAccountSource.SOURCE_PERSONAL_CENTER);
            return;
        L5:
            if (r5.isAudienceLinkEngineOn() != true) goto L7;
            f2.b(2131922674, 0);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ SwitchAccountLoader a;

        public c(SwitchAccountLoader r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            IUser r4 = (IUser) r3;
            SwitchAccountLoader r0 = this.a;
            if (r4 == null) goto L7;
            py.d r5 = r4.getUserHonor();
            if (r5 == null) goto L7;
            int r6 = r5.getLevel();
        L8:
            int r1 = SwitchAccountLoader.k;
            r0.f(r6);
            return;
        L7:
            r6 = 0;
            goto L8
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
            RxUtil.getNoOpThrowable();
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final boolean b() {
        return !z.e(this.a, false);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final List<a2> c() {
        return CollectionsKt.listOf(ToolbarButton.SWITCH_ACCOUNT);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void onLoad() {
        IUserService r0 = k.f(IUserService.class);
        if (r0 == null) goto L5;
        com.bytedance.android.livesdk.user.f r1 = r0.user();
    L6:
        if (r1 == null) goto L12;
        IUser r2 = r1.b();
        if (r2 == null) goto L12;
        py.d r3 = r2.getUserHonor();
        if (r3 == null) goto L12;
        int r4 = r3.getLevel();
    L13:
        f(r4);
        if (r1 == null) goto L25;
        Observable r5 = r1.p();
        if (r5 == null) goto L26;
        Observable r6 = r5.compose(RxUtil.rxSchedulerHelper());
        if (r6 == null) goto L27;
        Observable r7 = r6.take(1);
        if (r7 == null) goto L28;
        Disposable r8 = r7.subscribe(new c(this), d.a);
        if (r8 == null) goto L29;
        RxUtilKt.c(r8, this.i);
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L12:
        r4 = 0;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void onUnLoad() {
        super.onUnLoad();
        this.j = false;
        this.i.clear();
    }

    public SwitchAccountLoader(e r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        super(r2);
        this.h = new m5();
        this.i = new CompositeDisposable();
    }

    public final void f(int r3) {
        if (this.j == false) goto L6;
        return;
    L6:
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.helper.a.a(r3) == false) goto L18;
        y3.f(this.a).k(ToolbarButton.SWITCH_ACCOUNT, this.h);
        IBrowserService r4 = k.f(IBrowserService.class);
        if (r4 == null) goto L16;
        Observable r5 = r4.registerJsEventSubscriber("live.open_switch_account_page");
        if (r5 == null) goto L16;
        Observable r6 = r5.compose(RxUtil.rxSchedulerHelper());
        if (r6 == null) goto L16;
        Disposable r7 = r6.subscribe(new b(this));
        if (r7 == null) goto L16;
        RxUtilKt.c(r7, this.i);
    L16:
        this.j = true;
        return;
    }
}
