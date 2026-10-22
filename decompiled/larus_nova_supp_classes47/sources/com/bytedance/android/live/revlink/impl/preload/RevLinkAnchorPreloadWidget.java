package com.bytedance.android.live.revlink.impl.preload;

import af2.e;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.revenuelink.connect.d;
import com.bytedance.android.live.revenuelink.connect.f;
import com.bytedance.android.live.revlink.impl.control.dialog.LinkRevPanelDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.service.RevLinkLayoutPreloadContext;
import com.bytedance.android.live.revlink.impl.pk.utils.AutoMatchSource;
import com.bytedance.android.livesdk.link.model.h0;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.r4;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import com.larus.apm.impl.protector.RunnableProtector;
import d11.g;
import i41.p;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import wp2.l;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/preload/RevLinkAnchorPreloadWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "Lcom/bytedance/android/live/revlink/impl/preload/a;", "Li41/p;", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevLinkAnchorPreloadWidget extends LiveWidget implements com.bytedance.android.live.revlink.impl.preload.a, p {
    public final CompositeDisposable a;
    public IRoom b;
    public long c;
    public LiveMode d;
    public boolean e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final f i;
    public Handler j;
    public b k;
    public final c l;

    public static final class a implements Runnable {
        public final /* synthetic */ RevLinkAnchorPreloadWidget a;
        public final /* synthetic */ String b;

        /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.preload.RevLinkAnchorPreloadWidget$a$a, reason: collision with other inner class name */
        public static final class C0195a implements l {
            public C0195a() {
            }
        }

        public a(RevLinkAnchorPreloadWidget r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            rq2.a r0 = vh6.c.b(rq2.a.class);
            JSONObject r1 = new JSONObject();
            r1.put("anchor_id", String.valueOf(iz.a.a(vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).b())));
            r1.put("room_id", String.valueOf(this.a.c));
            r1.put("prediction_interval", String.valueOf(b51.b.c0.g().x1()));
            Unit r2 = Unit.INSTANCE;
            r0.i9(r1);
            if (Intrinsics.areEqual(this.b, "init") == false) goto L6;
            r0.pg(new C0195a());
            return;
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

    public static final class b implements MessageQueue.IdleHandler {
        public final /* synthetic */ RevLinkAnchorPreloadWidget a;
        public final /* synthetic */ String b;

        public static final class a implements l {
            public a() {
            }
        }

        public b(RevLinkAnchorPreloadWidget r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            rq2.a r0 = vh6.c.b(rq2.a.class);
            JSONObject r1 = new JSONObject();
            r1.put("anchor_id", String.valueOf(iz.a.a(vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).b())));
            r1.put("room_id", String.valueOf(this.a.c));
            r1.put("prediction_interval", String.valueOf(b51.b.c0.g().x1()));
            Unit r2 = Unit.INSTANCE;
            r0.i9(r1);
            if (Intrinsics.areEqual(this.b, "init") == false) goto L7;
            r0.pg(new a());
            return false;
        L7:
            return false;
        }
    }

    public static final class c extends d {
        public final /* synthetic */ RevLinkAnchorPreloadWidget a;

        public c(RevLinkAnchorPreloadWidget r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void A3(d11.d r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            Intrinsics.checkNotNullParameter(r2, "params");
            this.a.wq();
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void Z3(g r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            Intrinsics.checkNotNullParameter(r2, "params");
            if (r2.e != 1) goto L6;
            this.a.wq();
            return;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void O8(d11.b r2, com.bytedance.android.livesdk.link.model.f r3, long r4, ey.l r6) {
            Intrinsics.checkNotNullParameter(r2, "params");
            Intrinsics.checkNotNullParameter(r3, "applyResult");
            super.O8(r2, r3, r4, r6);
            this.a.wq();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.preload.RevLinkAnchorPreloadWidget$onCreate$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/live/revlink/impl/multianchor/service/RevLinkLayoutPreloadContext;", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function0<RevLinkLayoutPreloadContext> {
        public static final AnonymousClass3 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass3();
        }

        public AnonymousClass3() {
            super(0, RevLinkLayoutPreloadContext.class, "<init>", "<init>()V", 0);
        }

        public final RevLinkLayoutPreloadContext invoke() {
            return new RevLinkLayoutPreloadContext();
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m855invoke() {
            return invoke();
        }
    }

    @Override // i41.p
    public final void Bl() {
    }

    @Override // i41.p
    public final void F8(AutoMatchSource r3) {
        Intrinsics.checkNotNullParameter("", "activityName");
        Intrinsics.checkNotNullParameter(r3, "source");
    }

    @Override // i41.p
    public final void Nh(e r1, String r2, com.bytedance.android.live.revlink.impl.pk.vm.linkout.p r3) {
        Intrinsics.checkNotNullParameter(r1, "autoMatch");
        Intrinsics.checkNotNullParameter(r2, "activityName");
    }

    @Override // i41.p
    public final void Ug(r4 r1, boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "activityName");
    }

    @Override // i41.p
    public final void qn(boolean r1, boolean r2, AutoMatchSource r3) {
        Intrinsics.checkNotNullParameter(r3, "source");
    }

    @Override // i41.p
    public final void r4(long r1, long r3, h0 r5) {
        Intrinsics.checkNotNullParameter(r5, "previewUser");
    }

    @Override // i41.p
    public final void x9(i6 r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
    }

    @Override // i41.p
    public final void z1(int r1, int r2) {
    }

    @Override // com.bytedance.android.live.revlink.impl.preload.a
    public final void Tm() {
        ((com.bytedance.android.live.revlink.impl.preload.c) this.h.getValue()).d = true;
    }

    @Override // i41.p
    public final void aq() {
        LinkRevPanelDataContext r0 = LinkRevPanelDataContext.Companion.getContext();
        if (r0 == null) goto L10;
        j<com.bytedance.android.live.revlink.impl.control.dialog.b> r1 = r0.getLoader();
        if (r1 == null) goto L11;
        com.bytedance.android.live.revlink.impl.control.dialog.b r2 = (com.bytedance.android.live.revlink.impl.control.dialog.b) r1.getValue();
        if (r2 == null) goto L12;
        r2.o();
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void wq() {
        if (((Boolean) this.f.getValue()).booleanValue() == false) goto L5;
    L6:
        RevLinkLayoutPreloadContext r0 = RevLinkLayoutPreloadContext.Companion.getContext(Long.valueOf(this.c));
        if (r0 == null) goto L11;
        j<com.bytedance.android.live.revlink.impl.multianchor.service.f> r1 = r0.getService();
        if (r1 == null) goto L11;
        com.bytedance.android.live.revlink.impl.multianchor.service.f r2 = (com.bytedance.android.live.revlink.impl.multianchor.service.f) r1.getValue();
    L12:
        if (r2 != null) goto L14;
        return;
    L14:
        if (((Boolean) this.f.getValue()).booleanValue() == false) goto L17;
        r2.c();
    L17:
        if (((Boolean) this.g.getValue()).booleanValue() == false) goto L22;
        r2.b(4);
        return;
    L22:
        return;
    L11:
        r2 = null;
        goto L12
    L5:
        if (((Boolean) this.g.getValue()).booleanValue() == true) goto L6;
    }

    @Override // com.bytedance.android.live.revlink.impl.preload.a
    public final void ze() {
        ((com.bytedance.android.live.revlink.impl.preload.c) this.h.getValue()).d = false;
    }

    public RevLinkAnchorPreloadWidget() {
        this.a = new CompositeDisposable();
        this.f = LazyKt.lazy(RevLinkAnchorPreloadWidget$pkPreInflateEnable$2.INSTANCE);
        this.g = LazyKt.lazy(RevLinkAnchorPreloadWidget$multiPreInflateEnable$2.INSTANCE);
        this.h = LazyKt.lazy(RevLinkAnchorPreloadWidget$popHandler$2.INSTANCE);
        this.i = com.bytedance.android.live.revlink.impl.global.b.a();
        this.l = new c(this);
    }

    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.live.revenue.core.util.j.a r0 = com.bytedance.android.live.revenue.core.util.j.C0;
        k r1 = (k) com.bytedance.android.live.revenue.core.util.f.d(r0.a(), k.class);
        LiveMode r2 = null;
        if (r1 == null) goto L5;
        IRoom r3 = r1.getRoom();
    L6:
        this.b = r3;
        if (r3 == null) goto L9;
        long r4 = r3.getRoomId();
    L10:
        this.c = r4;
        com.bytedance.android.livesdk.revenue.service.room.c r5 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(r0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r5 == null) goto L15;
        com.bytedance.android.livesdk.revenue.room.a r6 = r5.getRoomContext();
        if (r6 == null) goto L15;
        boolean r7 = r6.getCommonIsAnchor();
    L16:
        this.e = r7;
        ld.a r8 = ld.d.a();
        if (r8 == null) goto L21;
        NextLiveData r9 = r8.getLiveMode();
        if (r9 == null) goto L21;
        r2 = (LiveMode) r9.getValue();
    L21:
        this.d = r2;
        f r10 = this.i;
        if (r10 == null) goto L24;
        r10.addLinkOutListener(7, this.l);
    L24:
        Pair r12 = com.bytedance.live.datacontext.d.a(AnonymousClass1.INSTANCE);
        com.bytedance.live.datacontext.b.a((DataContext) r12.getFirst(), com.bytedance.android.live.revlink.impl.control.dialog.a.class);
        ((LinkRevPanelDataContext) r12.getFirst()).getLoader().d(new com.bytedance.android.live.revlink.impl.control.dialog.b());
        this.a.add((Disposable) r12.getSecond());
        Pair r13 = com.bytedance.live.datacontext.d.a(AnonymousClass3.INSTANCE);
        DataContext r14 = (DataContext) r13.getFirst();
        RevLinkLayoutPreloadContext.a r15 = RevLinkLayoutPreloadContext.Companion;
        long r16 = this.c;
        r15.getClass();
        com.bytedance.live.datacontext.b.a(r14, "RevLinkLayoutPreloadContext_" + r16);
        ((RevLinkLayoutPreloadContext) r13.getFirst()).getService().d(new p31.a(((Widget) this).context));
        ((RevLinkLayoutPreloadContext) r13.getFirst()).getAnchorService().d(this);
        this.a.add((Disposable) r13.getSecond());
        if (this.d != LiveMode.VIDEO) goto L39;
        xq("init");
        LinkRevPanelDataContext r17 = LinkRevPanelDataContext.Companion.getContext();
        if (r17 == null) goto L33;
        j<com.bytedance.android.live.revlink.impl.control.dialog.b> r18 = r17.getLoader();
        if (r18 == null) goto L33;
        com.bytedance.android.live.revlink.impl.control.dialog.b r19 = (com.bytedance.android.live.revlink.impl.control.dialog.b) r18.getValue();
        if (r19 == null) goto L33;
        r19.n("live");
    L33:
        d31.e r20 = com.bytedance.android.live.revlink.impl.global.b.d0();
        if (r20 == null) goto L36;
        d31.e.f(r20, 0, 3);
    L36:
        i41.a r22 = com.bytedance.android.live.revlink.impl.global.b.g();
        if (r22 == null) goto L39;
        r22.a(this);
    L39:
        LinkRevPanelDataContext.b r23 = LinkRevPanelDataContext.Companion;
        LinkRevPanelDataContext r24 = r23.getContext();
        if (r24 == null) goto L42;
        r24.asyncInflate(((Widget) this).context);
    L42:
        com.bytedance.android.live.revlink.impl.preload.c r25 = (com.bytedance.android.live.revlink.impl.preload.c) this.h.getValue();
        r25.getClass();
        if (b51.b.c0.e().getEnable() == false) goto L59;
        LinkRevPanelDataContext r26 = r23.getContext();
        if (r26 == null) goto L55;
        com.bytedance.live.datacontext.k<Pair<String, com.bytedance.android.live.revlink.impl.control.dialog.e>> r27 = r26.getLoadCompleteEvent();
        if (r27 == null) goto L56;
        PublishSubject r28 = r27.onEvent();
        if (r28 == null) goto L57;
        Disposable r29 = r28.subscribe(new com.bytedance.android.live.revlink.impl.preload.b(r25));
        if (r29 == null) goto L58;
        r25.a.add(r29);
        return;
    L58:
        return;
    L57:
        return;
    L56:
        return;
    L55:
        return;
    L59:
        return;
    L15:
        r7 = false;
        goto L16
    L9:
        r4 = 0;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public final void onDestroy() {
        super.onDestroy();
        d31.e r0 = com.bytedance.android.live.revlink.impl.global.b.d0();
        if (r0 == null) goto L5;
        d31.e.f(r0, 3, 2);
    L5:
        b51.b r1 = b51.b.c0;
        if (r1.g().getEnable() == true) goto L9;
    L23:
        com.bytedance.android.live.revlink.impl.preload.c r2 = (com.bytedance.android.live.revlink.impl.preload.c) this.h.getValue();
        r2.getClass();
        if (r1.e().getEnable() == false) goto L27;
        r2.a.dispose();
    L27:
        this.a.dispose();
        f r3 = this.i;
        if (r3 == null) goto L30;
        r3.removeLinkOutListener(1, this.l);
    L30:
        f r4 = this.i;
        if (r4 == null) goto L33;
        r4.removeLinkOutListener(7, this.l);
    L33:
        LinkRevPanelDataContext r5 = LinkRevPanelDataContext.Companion.getContext();
        if (r5 == null) goto L40;
        j<com.bytedance.android.live.revlink.impl.control.dialog.b> r6 = r5.getLoader();
        if (r6 == null) goto L40;
        com.bytedance.android.live.revlink.impl.control.dialog.b r7 = (com.bytedance.android.live.revlink.impl.control.dialog.b) r6.getValue();
        if (r7 == null) goto L40;
        int r8 = com.bytedance.android.live.revlink.impl.control.dialog.b.r;
        r7.f("clear");
    L40:
        i41.a r9 = com.bytedance.android.live.revlink.impl.global.b.g();
        if (r9 == null) goto L46;
        Intrinsics.checkNotNullParameter(this, "listener");
        if (((ArrayList) r9.a).contains(this) == false) goto L46;
        ((ArrayList) r9.a).remove(this);
    L46:
        RevLinkLayoutPreloadContext r10 = RevLinkLayoutPreloadContext.Companion.getContext(Long.valueOf(this.c));
        if (r10 == null) goto L54;
        j<com.bytedance.android.live.revlink.impl.multianchor.service.f> r12 = r10.getService();
        if (r12 == null) goto L55;
        com.bytedance.android.live.revlink.impl.multianchor.service.f r13 = (com.bytedance.android.live.revlink.impl.multianchor.service.f) r12.getValue();
        if (r13 == null) goto L56;
        r13.d("anchor_detach");
        return;
    L56:
        return;
    L55:
        return;
    L54:
        return;
    L9:
        if (Build.VERSION.SDK_INT < 23) goto L20;
        b r14 = this.k;
        if (r14 == null) goto L19;
        Handler r15 = this.j;
        if (r15 == null) goto L19;
        Looper r16 = r15.getLooper();
        if (r16 == null) goto L19;
        MessageQueue r17 = r16.getQueue();
        if (r17 == null) goto L19;
        r17.removeIdleHandler(r14);
    L19:
        this.k = null;
    L20:
        Handler r18 = this.j;
        if (r18 == null) goto L23;
        r18.removeCallbacksAndMessages(null);
        goto L23
    }

    public final void xq(String r5) {
        if (b51.b.c0.g().getEnable() == true) goto L6;
        return;
    L6:
        if (this.j != null) goto L9;
        this.j = new Handler(Looper.getMainLooper());
    L9:
        if (Build.VERSION.SDK_INT < 23) goto L27;
        b r0 = this.k;
        if (r0 == null) goto L19;
        Handler r1 = this.j;
        if (r1 == null) goto L19;
        Looper r2 = r1.getLooper();
        if (r2 == null) goto L19;
        MessageQueue r3 = r2.getQueue();
        if (r3 == null) goto L19;
        r3.removeIdleHandler(r0);
    L19:
        b r4 = new b(this, r5);
        Handler r6 = this.j;
        if (r6 == null) goto L26;
        Looper r7 = r6.getLooper();
        if (r7 == null) goto L26;
        MessageQueue r8 = r7.getQueue();
        if (r8 == null) goto L26;
        r8.addIdleHandler(r4);
    L26:
        this.k = r4;
        return;
    L27:
        Handler r9 = this.j;
        if (r9 == null) goto L30;
        r9.removeCallbacksAndMessages(null);
    L30:
        Handler r10 = this.j;
        if (r10 == null) goto L35;
        r10.postDelayed(new a(this, r5), 7000);
        return;
    }
}
