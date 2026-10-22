package com.bytedance.android.live.broadcastgame.xplay.littlewindow;

import android.graphics.Rect;
import com.bytedance.android.live.broadcastgame.api.xplay.LittleWindowPos;
import com.bytedance.android.live.broadcastgame.api.xplay.p;
import com.bytedance.android.live.broadcastgame.xplay.XplayInternalContext;
import com.bytedance.android.live.broadcastgame.xplay.XplayLog;
import com.bytedance.android.live.broadcastgame.xplay.g0;
import com.bytedance.android.live.broadcastgame.xplay.s;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.scope.o;
import com.bytedance.live.datacontext.m;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class XplayLittleWindowService implements o, com.bytedance.android.live.broadcastgame.xplay.littlewindow.b {
    public final CompositeDisposable a;
    public final XplayLittleWindowContext b;
    public g10.a c;
    public final com.bytedance.android.live.broadcastgame.xplay.littlewindow.c d;
    public final Observable<Unit> e;
    public final p f;
    public final XplayInternalContext g;
    public final com.bytedance.android.live.broadcastgame.api.xplay.f h;
    public final com.bytedance.android.live.broadcastgame.xplay.littlewindow.a i;
    public final com.bytedance.android.live.broadcastgame.xplay.container.a j;

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.xplay.littlewindow.XplayLittleWindowService$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/live/broadcastgame/xplay/littlewindow/XplayLittleWindowContext;", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<XplayLittleWindowContext> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(0, XplayLittleWindowContext.class, "<init>", "<init>()V", 0);
        }

        public final XplayLittleWindowContext invoke() {
            return new XplayLittleWindowContext();
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m450invoke() {
            return invoke();
        }
    }

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ XplayLittleWindowService a;

        public b(XplayLittleWindowService r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Boolean r4 = (Boolean) r3;
            int r0 = XplayLog.a;
            XplayLog.c("XplayLittleWindowService", "open capture value changed: " + r4);
            this.a.i.setRadioMode(r4.booleanValue() ^ true);
            this.a.d.b(r4.booleanValue());
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ XplayLittleWindowService a;

        public c(XplayLittleWindowService r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            XplayLittleWindowService r0 = this.a;
            boolean r3 = ((Boolean) r2).booleanValue();
            r0.b.getZoomButtonEnabled().setValue(Boolean.valueOf(r3));
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.littlewindow.b
    public final LittleWindowPos c() {
        return ((g) this.b.getLittleWindowState().getValue()).a;
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.littlewindow.b
    public final Rect d() {
        boolean r0 = ((Boolean) this.b.isHidden().getValue()).booleanValue();
        if (r0 != true) goto L5;
        return null;
    L5:
        if (r0 == true) goto L9;
        return (Rect) this.b.getLittleWindowRect().getValue();
    L9:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.littlewindow.b
    public final boolean g() {
        return ((g) this.b.getLittleWindowState().getValue()).c;
    }

    public final void i() {
        Iterator<T> r0 = s.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        g10.b r1 = (g10.b) r0.next();
        if ((r1 instanceof g10.a) == false) goto L4;
        g10.a r2 = (g10.a) r1;
    L9:
        if (r2 != null) goto L11;
        r2 = new i();
    L11:
        this.c = r2;
        if (r2.isEnable() == true) goto L14;
        return;
    L14:
        com.bytedance.android.live.broadcastgame.xplay.littlewindow.c r3 = this.d;
        g10.a r4 = this.c;
        Intrinsics.checkNotNull(r4);
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "cameraDisplayProvider");
        if (r3.a != null) goto L18;
        XplayLog.c("LittleWindowLayer", "create cast little window");
        d r5 = new d(r3.getContext(), r3.d, r3.e, r3.f);
        r3.addView(r5);
        r3.a = r5;
        com.bytedance.android.live.broadcastgame.api.xplay.h r6 = r4.e(r3.c);
        LittleWindowLayer$createCastLittleWindow$1 r7 = new LittleWindowLayer$createCastLittleWindow$1(r6);
        Intrinsics.checkNotNullParameter(r7, "displayCreator");
        r7.invoke(r5.e);
        r3.b = r6;
    L18:
        boolean r8 = ((Boolean) this.g.getOpenCapture().getValue()).booleanValue();
        com.bytedance.android.live.broadcastgame.api.xplay.s r9 = this.f.j;
        if (r9 != null) goto L21;
    L23:
        this.d.b(r8);
        return;
    L21:
        if (r9.h != true) goto L23;
        this.d.b(false);
        return;
    L8:
        r2 = null;
        goto L9
    }

    public final void onStart() {
        this.j.g().addView(this.d, 0);
        this.g.getOpenCapture().setValue(Boolean.TRUE);
        RxUtilKt.c(this.g.getOpenCapture().a().subscribe(new b(this)), this.a);
        RxUtilKt.c(this.j.h().startWith(Boolean.valueOf(this.j.i())).subscribe(new c(this)), this.a);
    }

    public final void onStop() {
        this.a.dispose();
        this.d.a();
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.littlewindow.b
    public final com.bytedance.android.live.broadcastgame.xplay.littlewindow.c a() {
        return this.d;
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.littlewindow.b
    public final Observable<Unit> f() {
        return this.e;
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.littlewindow.b
    public final void h(LittleWindowPos r5) {
        Intrinsics.checkNotNullParameter(r5, "value");
        m<g> r0 = this.b.getLittleWindowState();
        r0.setValue(g.a((g) r0.getValue(), r5, false, 30));
        this.b.getLittleWindowStateChangedExternally().post(Unit.INSTANCE);
    }

    public XplayLittleWindowService(p r7, XplayInternalContext r8, com.bytedance.android.live.broadcastgame.api.xplay.f r9, g0 r11, com.bytedance.android.live.broadcastgame.xplay.littlewindow.a r12, com.bytedance.android.live.broadcastgame.xplay.container.a r13) {
        Intrinsics.checkNotNullParameter(r7, "newEnv");
        Intrinsics.checkNotNullParameter(r8, "xplayInternalContext");
        Intrinsics.checkNotNullParameter(r9, "inst");
        Intrinsics.checkNotNullParameter(r11, "xplayLogService");
        Intrinsics.checkNotNullParameter(r12, "xplayCaptureService");
        Intrinsics.checkNotNullParameter(r13, "xplayContainerService");
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r12;
        this.j = r13;
        CompositeDisposable r14 = new CompositeDisposable();
        this.a = r14;
        Pair r15 = com.bytedance.live.datacontext.d.a(AnonymousClass1.INSTANCE);
        XplayLittleWindowContext r16 = (XplayLittleWindowContext) r15.component1();
        RxUtilKt.c((Disposable) r15.component2(), r14);
        this.b = r16;
        this.d = new com.bytedance.android.live.broadcastgame.xplay.littlewindow.c(r7.getContext(), r9, r16, r7, r11);
        this.e = r16.getUpdateMixerParams().onEvent();
    }
}
