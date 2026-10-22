package com.bytedance.android.live.broadcastgame.xplay;

import com.bytedance.android.live.broadcastgame.api.xplay.XplayScene;
import com.bytedance.android.live.broadcastgame.xplay.singlecast.XplayGameCastAbility;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.config.m30;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/XplayMainService;", "Lcom/bytedance/android/scope/o;", "Lcom/bytedance/android/live/broadcastgame/xplay/IXplayMainService;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "a", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class XplayMainService implements com.bytedance.android.scope.o, IXplayMainService, Observer<KVData> {
    public static final /* synthetic */ int m = 0;
    public final CompositeDisposable a;
    public IXplayMainService.State b;
    public final PublishSubject<IXplayMainService.State> c;
    public final PublishSubject<c1> d;
    public Throwable e;
    public final boolean f;
    public Disposable g;
    public final g1 h;
    public final com.bytedance.android.live.broadcastgame.api.xplay.p i;
    public final e j;
    public final XplayInternalContext k;
    public final XplayMonitorSession l;

    public static final class a {
    }

    public static final class b implements Action {
        public final /* synthetic */ XplayMainService a;

        public b(XplayMainService r1) {
            this.a = r1;
        }

        public final void run() {
            XplayMainService r0 = this.a;
            IXplayMainService.State r1 = IXplayMainService.State.Starting;
            IXplayMainService.State r2 = r0.b;
            if (r2 == r1) goto L6;
            r1 = null;
        L6:
            if (r1 != null) goto L8;
            return;
        L8:
            r0.e = null;
            IXplayMainService.State r3 = IXplayMainService.State.Started;
            if (r3 == r2) goto L12;
            r0.b = r3;
            r0.c.onNext(r3);
        L12:
            if (((XplayScene) this.a.k.getCurrentScene().getValue()) != XplayScene.Video) goto L14;
            this.a.d();
        L14:
            s.a(r3, null, null);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ XplayMainService a;

        public c(XplayMainService r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            XplayMainService r0 = this.a;
            r0.e = r6;
            IXplayMainService.State r1 = IXplayMainService.State.StartingFailed;
            if (r1 == r0.b) goto L5;
            r0.b = r1;
            r0.c.onNext(r1);
        L5:
            this.a.l.d(r6);
            Set<g10.b> r2 = s.a;
            boolean r3 = r6 instanceof XplayException;
            String r4 = null;
            if (r3 == true) goto L8;
            Throwable r7 = null;
        L9:
            XplayException r8 = (XplayException) r7;
            if (r8 == null) goto L14;
            q r9 = r8.getErrorInfo();
            if (r9 == null) goto L14;
            Integer r11 = Integer.valueOf(r9.a());
        L15:
            if (r3 == true) goto L17;
            r6 = null;
        L17:
            XplayException r12 = (XplayException) r6;
            if (r12 == null) goto L22;
            q r13 = r12.getErrorInfo();
            if (r13 == null) goto L22;
            r4 = r13.b();
        L22:
            s.a(r1, r11, r4);
            return;
        L14:
            r11 = null;
            goto L15
        L8:
            r7 = r6;
            goto L9
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.IXplayMainService
    public final void a() {
        com.bytedance.android.scope.m r0 = com.bytedance.android.scope.m.e;
        com.bytedance.android.live.broadcastgame.xplay.singlecast.b r1 = (com.bytedance.android.live.broadcastgame.xplay.singlecast.b) r0.a(this.h, com.bytedance.android.live.broadcastgame.xplay.singlecast.b.class);
        if (r1 != null) goto L5;
        return;
    L5:
        if (((XplayGameCastAbility) r0.d(r1, XplayGameCastAbility.class)) == null) goto L9;
        XplayGameCastAbility.c(false, null);
        return;
    }

    public final void c() {
        IXplayMainService.State r0 = this.b;
        IXplayMainService.State r1 = IXplayMainService.State.Starting;
        if (r0.isAtLeast(r1) == false) goto L5;
        return;
    L5:
        XplayLog.c("XplayMainService", "starting");
        if (r1 == this.b) goto L8;
        this.b = r1;
        this.c.onNext(r1);
    L8:
        c1 r2 = new c1();
        this.d.onNext(r2);
        XplayMainService$start$1 r3 = new XplayMainService$start$1(this, r2);
        Intrinsics.checkNotNullParameter(r3, "block");
        XplayCompositeTaskBuilderScopeImpl r4 = new XplayCompositeTaskBuilderScopeImpl(XplayTasksDslKt$taskGraph$1.INSTANCE);
        r3.invoke(r4);
        RxUtilKt.c(((j1) r4.c.invoke(r4, r4.a)).a().a().subscribe(new b(this), new c(this)), this.a);
    }

    public final void d() {
        com.bytedance.android.live.broadcastgame.xplay.singlecast.d r0 = new com.bytedance.android.live.broadcastgame.xplay.singlecast.d(this.h);     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r0, "scope");     // Catch: Throwable -> L16
        Object r1 = e33.k.a;     // Catch: Throwable -> L16
        if (r0.e != r1) goto L6;
        String r2 = "newEnv";
    L12:
        if (r2 != null) goto L15;
        com.bytedance.android.scope.l.a(r0);     // Catch: Throwable -> L16
        return;
    L15:
        throw new UninitializedPropertyAccessException(r2);     // Catch: Throwable -> L16
    L6:
        if (r0.f != r1) goto L9;
        r2 = "instance";
        goto L12
    L9:
        if (r0.g != r1) goto L11;
        r2 = "xplayInternalContext";
        goto L12
    L11:
        r2 = null;
    L16:
        th = move-exception;
        ExceptionUtils.handleException(this.i.getContext(), th);
        int r3 = XplayLog.a;
        XplayLog.b("XplayMainService", "Failed to enter single cast scope: " + th);
    }

    public final void onStart() {
        RxUtilKt.c(this.c.switchMap(new m0(this)).subscribe(), this.a);
        RxUtilKt.c(Observable.merge(this.j.f(), q1.b).subscribe(new n0(this)), this.a);
        DataCenter r0 = this.i.i;
        if (r0 == null) goto L6;
        r0.observe("data_link_state", this);
        return;
    }

    public final void onStop() {
        this.a.dispose();
        this.a.clear();
        this.c.onComplete();
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        if (r6 == null) goto L5;
        String r1 = r6.getKey();
    L6:
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.hashCode() == 872172481) goto L12;
        return;
    L12:
        if (r1.equals("data_link_state") == false) goto L49;
        Integer r7 = (Integer) r6.getData();
        if (r7 != null) goto L16;
        r7 = 0;
    L16:
        int r8 = r7.intValue();
        if (r8 != 32) goto L46;
        Disposable r2 = this.g;
        if (r2 == null) goto L21;
        r2.dispose();
    L21:
        this.g = null;
        int r0 = XplayLog.a;
        XplayLog.c("XplayMainService", "switchToMultiCastInGaming， isEnableSeverMergeStreamForMultiLink: " + q1.e());
        com.bytedance.android.live.broadcastgame.xplay.singlecast.b r3 = (com.bytedance.android.live.broadcastgame.xplay.singlecast.b) com.bytedance.android.scope.m.e.a(this.h, com.bytedance.android.live.broadcastgame.xplay.singlecast.b.class);
        if (r3 == null) goto L25;
        com.bytedance.android.scope.l.c(r3);
    L25:
        if (q1.e() == false) goto L36;
        XplayGlobalServiceImpl r4 = XplayGlobalServiceImpl.c;
        com.bytedance.android.live.broadcastgame.api.xplay.f r9 = r4.n();
        if (r9 == null) goto L31;
        IXplayCoreService r11 = (IXplayCoreService) r9.getService(IXplayCoreService.class);
        if (r11 == null) goto L31;
        r11.updateEnableVideoFrame(false);
    L31:
        com.bytedance.android.live.broadcastgame.api.xplay.f r12 = r4.n();
        if (r12 == null) goto L46;
        IXplayCoreService r13 = (IXplayCoreService) r12.getService(IXplayCoreService.class);
        if (r13 == null) goto L46;
        r13.R();
        goto L46
    L36:
        XplayGlobalServiceImpl r14 = XplayGlobalServiceImpl.c;
        com.bytedance.android.live.broadcastgame.api.xplay.f r15 = r14.n();
        if (r15 == null) goto L41;
        IXplayCoreService r16 = (IXplayCoreService) r15.getService(IXplayCoreService.class);
        if (r16 == null) goto L41;
        r16.updateEnableVideoFrame(true);
    L41:
        com.bytedance.android.live.broadcastgame.api.xplay.f r17 = r14.n();
        if (r17 == null) goto L46;
        IXplayCoreService r18 = (IXplayCoreService) r17.getService(IXplayCoreService.class);
        if (r18 == null) goto L46;
        r18.R();
    L46:
        if (r8 != 0) goto L50;
        Disposable r19 = Observable.timer(500, TimeUnit.MILLISECONDS).subscribe(new h0(this));
        RxUtilKt.c(r19, this.a);
        this.g = r19;
        return;
    L50:
        return;
    L49:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public XplayMainService(g1 r2, com.bytedance.android.live.broadcastgame.api.xplay.p r3, e r4, XplayInternalContext r5, XplayMonitorSession r6) {
        Intrinsics.checkNotNullParameter(r2, "xplayScope");
        Intrinsics.checkNotNullParameter(r3, "newEnv");
        Intrinsics.checkNotNullParameter(r4, "xplayPanelService");
        Intrinsics.checkNotNullParameter(r5, "xplayInternalContext");
        Intrinsics.checkNotNullParameter(r6, "monitorSession");
        this.h = r2;
        this.i = r3;
        this.j = r4;
        this.k = r5;
        this.l = r6;
        this.a = new CompositeDisposable();
        this.b = IXplayMainService.State.Uninitialized;
        this.c = PublishSubject.create();
        this.d = PublishSubject.create();
        if (((Boolean) m30.a.getValue()).booleanValue() == true) goto L5;
    L7:
        boolean r7 = false;
    L8:
        this.f = r7;
        return;
    L5:
        if (((XplayScene) r5.getCurrentScene().getValue()) == XplayScene.RevenueLink) goto L7;
        r7 = true;
        goto L8
    }
}
