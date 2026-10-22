package com.bytedance.android.live.broadcastgame.xplay.floatwindow;

import android.content.Context;
import android.graphics.Rect;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.broadcastgame.api.xplay.LittleWindowPos;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayGuestType;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayScene;
import com.bytedance.android.live.broadcastgame.api.xplay.p;
import com.bytedance.android.live.broadcastgame.api.xplay.s;
import com.bytedance.android.live.broadcastgame.xplay.XplayInternalContext;
import com.bytedance.android.live.broadcastgame.xplay.XplayLog;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Consumer;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class XplayFloatWindowService implements o {
    public final CompositeDisposable a;
    public com.bytedance.android.live.broadcastgame.xplay.floatwindow.c b;
    public com.bytedance.android.live.broadcastgame.xplay.floatwindow.a c;
    public final PropertyOwner<Boolean> d;
    public final p e;
    public final com.bytedance.android.live.broadcastgame.xplay.container.a f;
    public final com.bytedance.android.live.broadcastgame.xplay.littlewindow.b g;
    public final XplayInternalContext h;

    public static final class a {
    }

    public static final class b<T1, T2> implements BiPredicate {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final boolean test(Object r3, Object r4) {
            i32.a r5 = (i32.a) r3;
            i32.a r6 = (i32.a) r4;
            Intrinsics.checkNotNullParameter(r5, "a");
            Intrinsics.checkNotNullParameter(r6, "b");
            if (r5.a == r6.a) goto L5;
        L7:
            return false;
        L5:
            if (r5.b != r6.b) goto L7;
            return true;
        }
    }

    public final class c implements Consumer {
        public final /* synthetic */ Function1 a;

        public c(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void accept(Object r2) {
            this.a.invoke(r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.xplay.floatwindow.XplayFloatWindowService$onStart$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public AnonymousClass1(XplayFloatWindowService r8) {
            super(1, r8, XplayFloatWindowService.class, "onInteractivityChanged", "onInteractivityChanged(Z)V", 0);
        }

        public final void invoke(boolean r4) {
            XplayFloatWindowService r0 = (XplayFloatWindowService) ((CallableReference) this).receiver;
            com.bytedance.android.live.broadcastgame.xplay.floatwindow.c r1 = r0.b;
            if (r1 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        L6:
            if (r1.f == r4) goto L10;
            r1.f = r4;
            r1.a();
        L10:
            if (r4 == r0.f.i()) goto L13;
            r0.f.f(r4);
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke(((Boolean) r1).booleanValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.xplay.floatwindow.XplayFloatWindowService$onStart$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "p1", "invoke", "(Lkotlin/Unit;)V"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Unit, Unit> {
        public AnonymousClass2(XplayFloatWindowService r8) {
            super(1, r8, XplayFloatWindowService.class, "onLittleWindowSpecChanged", "onLittleWindowSpecChanged(Lkotlin/Unit;)V", 0);
        }

        public final void invoke(Unit r3) {
            Intrinsics.checkNotNullParameter(r3, "p1");
            XplayFloatWindowService r4 = (XplayFloatWindowService) ((CallableReference) this).receiver;
            com.bytedance.android.live.broadcastgame.xplay.floatwindow.c r0 = r4.b;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        L5:
            LittleWindowPos r1 = r4.g.c();
            Rect r5 = r4.g.d();
            if (r5 == null) goto L8;
            int r6 = r5.height();
        L9:
            Pair<? extends LittleWindowPos, Integer> r7 = TuplesKt.to(r1, Integer.valueOf(r6));
            r0.getClass();
            Intrinsics.checkNotNullParameter(r7, "value");
            if (Intrinsics.areEqual(r0.g, r7) == true) goto L14;
            r0.g = r7;
            r0.a();
            return;
        L14:
            return;
        L8:
            r6 = 0;
            goto L9
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((Unit) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.xplay.floatwindow.XplayFloatWindowService$onStart$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Li32/a;", "p1", "", "invoke", "(Li32/a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<i32.a, Unit> {
        public AnonymousClass4(XplayFloatWindowService r8) {
            super(1, r8, XplayFloatWindowService.class, "onPublicScreenHeightChanged", "onPublicScreenHeightChanged(Lcom/bytedance/android/livesdk/interactivity/api/enteranim/PublicScreenHeightUpdateData;)V", 0);
        }

        public final void invoke(i32.a r3) {
            Intrinsics.checkNotNullParameter(r3, "p1");
            com.bytedance.android.live.broadcastgame.xplay.floatwindow.c r0 = ((XplayFloatWindowService) ((CallableReference) this).receiver).b;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        L5:
            int r4 = r3.a;
            if (r0.h == r4) goto L10;
            r0.h = r4;
            r0.a();
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((i32.a) r1);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final void onStart() {
        if (((XplayScene) this.h.getCurrentScene().getValue()) != XplayScene.RevenueLink) goto L5;
        return;
    L5:
        XplayScene r0 = (XplayScene) this.h.getCurrentScene().getValue();
        XplayScene r1 = XplayScene.TalkRoom;
        if (r0 != r1) goto L13;
        IInteractService r2 = k.f(IInteractService.class);
        if (r2 != null) goto L10;
        return;
    L10:
        if (r2.isEnableDanmuGameClearScreen() == true) goto L13;
        return;
    L13:
        if (((XplayScene) this.h.getCurrentScene().getValue()) != r1) goto L21;
        s r3 = this.e.j;
        if (r3 == null) goto L17;
        XplayGuestType r4 = r3.i;
    L19:
        if (r4 != XplayGuestType.SILENCE) goto L21;
        return;
    L17:
        r4 = null;
    L21:
        this.b = new com.bytedance.android.live.broadcastgame.xplay.floatwindow.c(this.e.getContext());
        DataCenter r5 = this.e.i;
        Intrinsics.checkNotNull(r5);
        this.c = new com.bytedance.android.live.broadcastgame.xplay.floatwindow.a(r5, this.d, this.e);
        ViewGroup r6 = this.f.a();
        Context r7 = this.e.getContext();
        com.bytedance.android.live.broadcastgame.xplay.floatwindow.a r8 = this.c;
        if (r8 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("floatWindowContext");
    L24:
        com.bytedance.android.live.broadcastgame.xplay.floatwindow.b r9 = new com.bytedance.android.live.broadcastgame.xplay.floatwindow.b(r7, r8, this.h);
        r9.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.android.live.broadcastgame.xplay.floatwindow.c r11 = this.b;
        if (r11 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
    L28:
        if (Intrinsics.areEqual(r11.e, r9) == true) goto L31;
        r11.e = r9;
        r11.a();
    L31:
        r6.addView(r9);
        this.f.h().subscribe(this.d);
        RxUtilKt.c(com.bytedance.android.live.core.arch.mvvm.f.b(this.d).subscribe(new c(new AnonymousClass1(this))), this.a);
        RxUtilKt.c(this.g.f().subscribe(new c(new AnonymousClass2(this))), this.a);
        DataCenter r12 = this.e.i;
        if (r12 == null) goto L34;
        RxUtilKt.c(RxUtilKt.b(r12, "cmd_data_interact_public_screen_height_change", true).distinctUntilChanged(b.a).subscribe(new c(new AnonymousClass4(this))), this.a);
        return;
    L34:
        XplayLog.b("XplayFloatWindowService", "cannot obtain dataCenter, public screen adaption is disabled");
    }

    public final void onStop() {
        this.a.dispose();
        this.d.onComplete();
    }

    public XplayFloatWindowService(p r2, com.bytedance.android.live.broadcastgame.xplay.container.a r3, com.bytedance.android.live.broadcastgame.xplay.littlewindow.b r4, XplayInternalContext r5) {
        Intrinsics.checkNotNullParameter(r2, "env");
        Intrinsics.checkNotNullParameter(r3, "xplayContainerService");
        Intrinsics.checkNotNullParameter(r4, "xplayLittleWindowService");
        Intrinsics.checkNotNullParameter(r5, "internalContext");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.a = new CompositeDisposable();
        this.d = new PropertyOwner(Boolean.valueOf(r3.i()), XplayFloatWindowService$isInteractive$1.INSTANCE);
    }
}
