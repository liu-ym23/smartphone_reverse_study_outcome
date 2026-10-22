package obric.flow.miniappwidget;

import android.os.SystemClock;
import com.obric.widget.host.HostedWidget;
import com.obric.widget.host.runtime.WidgetDataChangedEvent;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f20458c;
    public final String d;
    public final String e;
    public final HostedWidget f;
    public final CoroutineScope g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0 f20459h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function3 f20460i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicBoolean f20461j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile Boolean f20462k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile String f20463l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile String f20464m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile long f20465n;

    public a(String r5, String r10, String r11, String r12, String r13, HostedWidget r14, CoroutineScope r15, Function0 r16, Function3 r17) {
        Intrinsics.checkNotNullParameter(r5, "hostId");
        Intrinsics.checkNotNullParameter(r10, "instanceId");
        Intrinsics.checkNotNullParameter(r12, "appletId");
        Intrinsics.checkNotNullParameter(r13, "widgetId");
        Intrinsics.checkNotNullParameter(r14, "sdkWidget");
        Intrinsics.checkNotNullParameter(r16, "onDestroyed");
        Intrinsics.checkNotNullParameter(r17, "onRenderInvalidated");
        this.f20456a = r5;
        this.f20457b = r10;
        this.f20458c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.f20459h = r16;
        this.f20460i = r17;
        this.f20461j = new AtomicBoolean(false);
    }

    public final boolean a() {
        String r10 = this.e;
        String r11 = this.d;
        String r12 = this.f20458c;
        String r13 = this.f20457b;
        String r14 = this.f20456a;
        if (this.f20461j.compareAndSet(false, true) == true) goto L24;
        return true;
    L24:
        String r5 = "destroy hostId=" + r14 + " instanceId=" + r13 + " cardId=" + r12 + " appletId=" + r11 + " widgetId=" + r10;     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter("MiniAppHostedWidget", "tag");     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r5, "msg");     // Catch: Throwable -> L9
        org.koin.core.a r15 = su.a.f22013b;     // Catch: Throwable -> L9
        if (r15 == null) goto L12;
        ((ju.b) r15.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("MiniAppHostedWidget", r5);     // Catch: Throwable -> L9
        this.f.destroy();     // Catch: Throwable -> L9
        this.f20459h.invoke();     // Catch: Throwable -> L9
        return true;
    L12:
        String r16 = "KoinApplication has not been started";
    L15:
        th = th;
    L16:
        StringBuilder r17 = androidx.constraintlayout.motion.widget.a.y("destroy failed hostId=", r14, " instanceId=", r13, " cardId=");
        androidx.constraintlayout.motion.widget.a.C(r17, r12, " appletId=", r11, " widgetId=");
        String r18 = androidx.room.jarjarred.org.antlr.runtime.a.w(r17, r10, "MiniAppHostedWidget", "tag", "msg");
        Intrinsics.checkNotNullParameter(th, "t");
        org.koin.core.a r19 = su.a.f22013b;
        if (r19 == null) goto L21;
        ((ju.b) r19.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("MiniAppHostedWidget", r18, th);
        return false;
    L21:
        throw new IllegalStateException(r16);
    L14:
        throw new IllegalStateException(r16);     // Catch: Throwable -> L15
    L9:
        th = th;
        r16 = "KoinApplication has not been started";
        goto L16
    }

    public final void b(String r10, String r11) {
        this.f20463l = r10;
        this.f20464m = r11;
        String r12 = this.f20456a;
        String r5 = this.f20457b;
        String r13 = this.f20458c;
        String r14 = this.d;
        String r15 = this.e;
        Boolean r16 = this.f20462k;
        StringBuilder r17 = androidx.constraintlayout.motion.widget.a.y("mark pending render hostId=", r12, " instanceId=", r5, " cardId=");
        androidx.constraintlayout.motion.widget.a.C(r17, r13, " appletId=", r14, " widgetId=");
        r17.append(r15);
        r17.append(" visible=");
        r17.append(r16);
        r17.append(" reason=");
        String r18 = androidx.room.jarjarred.org.antlr.runtime.a.w(r17, r10, "MiniAppHostedWidget", "tag", "msg");
        org.koin.core.a r19 = su.a.f22013b;
        if (r19 == null) goto L7;
        ((ju.b) r19.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("MiniAppHostedWidget", r18);
        return;
    L7:
        throw new IllegalStateException("KoinApplication has not been started");
    }

    public final void c() {
        Class<ju.b> r5 = ju.b.class;
        String r10 = "msg";
        String r11 = this.e;
        String r12 = this.d;
        String r13 = this.f20458c;
        String r14 = this.f20457b;
        String r15 = this.f20456a;
        String r16 = "foreground hostId=" + r15 + " instanceId=" + r14 + " cardId=" + r13 + " appletId=" + r12 + " widgetId=" + r11;     // Catch: Throwable -> L20
        Intrinsics.checkNotNullParameter("MiniAppHostedWidget", "tag");     // Catch: Throwable -> L20
        Intrinsics.checkNotNullParameter(r16, "msg");     // Catch: Throwable -> L20
        org.koin.core.a r17 = su.a.f22013b;     // Catch: Throwable -> L20
        if (r17 == null) goto L14;
        ((ju.b) r17.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(r5), null)).i("MiniAppHostedWidget", r16);     // Catch: Throwable -> L10
        this.f.onForeground();     // Catch: Throwable -> L10
        g("onForeground");     // Catch: Throwable -> L10
        return;
    L12:
        th = th;
    L11:
        String r18 = "KoinApplication has not been started";
    L22:
        StringBuilder r19 = androidx.constraintlayout.motion.widget.a.y("foreground failed hostId=", r15, " instanceId=", r14, " cardId=");
        androidx.constraintlayout.motion.widget.a.C(r19, r13, " appletId=", r12, " widgetId=");
        String r20 = androidx.room.jarjarred.org.antlr.runtime.a.w(r19, r11, "MiniAppHostedWidget", "tag", r10);
        Intrinsics.checkNotNullParameter(th, "t");
        org.koin.core.a r21 = su.a.f22013b;
        if (r21 == null) goto L27;
        ((ju.b) r21.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(r5), null)).e("MiniAppHostedWidget", r20, th);
        return;
    L27:
        throw new IllegalStateException(r18);
    L14:
        r5 = r5;
        r10 = "msg";
        r18 = "KoinApplication has not been started";
    L18:
        th = th;
        goto L22
    L17:
        throw new IllegalStateException(r18);     // Catch: Throwable -> L18
    L10:
        th = th;
    L20:
        th = th;
        goto L11
    }

    public final boolean d() {
        String r10 = this.e;
        String r11 = this.d;
        String r12 = this.f20458c;
        String r13 = this.f20457b;
        String r14 = this.f20456a;
        String r15 = "visible hostId=" + r14 + " visible=false instanceId=" + r13 + " cardId=" + r12 + " appletId=" + r11 + " widgetId=" + r10;     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter("MiniAppHostedWidget", "tag");     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r15, "msg");     // Catch: Throwable -> L16
        org.koin.core.a r16 = su.a.f22013b;     // Catch: Throwable -> L16
        if (r16 == null) goto L15;
        ((ju.b) r16.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("MiniAppHostedWidget", r15);     // Catch: Throwable -> L10
        this.f.onHide();     // Catch: Throwable -> L10
        return true;
    L12:
        th = th;
    L18:
        StringBuilder r5 = androidx.constraintlayout.motion.widget.a.y("onHide failed hostId=", r14, " instanceId=", r13, " cardId=");
        androidx.constraintlayout.motion.widget.a.C(r5, r12, " appletId=", r11, " widgetId=");
        String r17 = androidx.room.jarjarred.org.antlr.runtime.a.w(r5, r10, "MiniAppHostedWidget", "tag", "msg");
        Intrinsics.checkNotNullParameter(th, "t");
        org.koin.core.a r18 = su.a.f22013b;
        if (r18 == null) goto L23;
        ((ju.b) r18.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("MiniAppHostedWidget", r17, th);
        return false;
    L23:
        throw new IllegalStateException("KoinApplication has not been started");
    L15:
        throw new IllegalStateException("KoinApplication has not been started");     // Catch: Throwable -> L10
    L10:
        th = th;
    L16:
        th = th;
        goto L18
    }

    public final boolean e() {
        String r10 = this.e;
        String r11 = this.d;
        String r12 = this.f20458c;
        String r13 = this.f20457b;
        String r14 = this.f20456a;
        String r15 = "visible hostId=" + r14 + " visible=true instanceId=" + r13 + " cardId=" + r12 + " appletId=" + r11 + " widgetId=" + r10;     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter("MiniAppHostedWidget", "tag");     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r15, "msg");     // Catch: Throwable -> L16
        org.koin.core.a r16 = su.a.f22013b;     // Catch: Throwable -> L16
        if (r16 == null) goto L15;
        ((ju.b) r16.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("MiniAppHostedWidget", r15);     // Catch: Throwable -> L10
        this.f.onShow();     // Catch: Throwable -> L10
        g("onShow");     // Catch: Throwable -> L10
        return true;
    L12:
        th = th;
    L18:
        StringBuilder r5 = androidx.constraintlayout.motion.widget.a.y("onShow failed hostId=", r14, " instanceId=", r13, " cardId=");
        androidx.constraintlayout.motion.widget.a.C(r5, r12, " appletId=", r11, " widgetId=");
        String r17 = androidx.room.jarjarred.org.antlr.runtime.a.w(r5, r10, "MiniAppHostedWidget", "tag", "msg");
        Intrinsics.checkNotNullParameter(th, "t");
        org.koin.core.a r18 = su.a.f22013b;
        if (r18 == null) goto L23;
        ((ju.b) r18.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("MiniAppHostedWidget", r17, th);
        return false;
    L23:
        throw new IllegalStateException("KoinApplication has not been started");
    L15:
        throw new IllegalStateException("KoinApplication has not been started");     // Catch: Throwable -> L10
    L10:
        th = th;
    L16:
        th = th;
        goto L18
    }

    public final Object f(ContinuationImpl r22) {
        a r5 = this;
        String r10 = "refresh hostId=";
        if ((r22 instanceof MiniAppHostedWidget$refresh$1) == false) goto L7;
        MiniAppHostedWidget$refresh$1 r11 = (MiniAppHostedWidget$refresh$1) r22;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L18;
        if (r15 != 1) goto L17;
        Boolean r16 = (Boolean) r11.L$2;
        r10 = (String) r11.L$1;
        a r17 = (a) r11.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L14
        boolean r18 = true;
    L78:
        return Boxing.boxBoolean(r18);
    L14:
        th = th;
        r14 = r16;
        r5 = r17;
        String r19 = "KoinApplication has not been started";
    L55:
        String r20 = r5.f20456a;
        StringBuilder r21 = new StringBuilder();
        r21.append(r10);
        r21.append(" failed hostId=");
        r21.append(r20);
        r21.append(" instanceId=");
        r21.append(r5.f20457b);
        r21.append(" cardId=");
        r21.append(r5.f20458c);
        r21.append(" appletId=");
        r21.append(r5.d);
        r21.append(" widgetId=");
        String r23 = androidx.room.jarjarred.org.antlr.runtime.a.w(r21, r5.e, "MiniAppHostedWidget", "tag", "msg");
        Intrinsics.checkNotNullParameter(th, "t");
        org.koin.core.a r24 = su.a.f22013b;
        if (r24 == null) goto L60;
        ((ju.b) r24.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("MiniAppHostedWidget", r23, th);
        return r14;
    L60:
        throw new IllegalStateException(r19);
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r13);
        Boolean r25 = Boxing.boxBoolean(false);
        String r26 = r5.f20456a;     // Catch: Throwable -> L53
        String r27 = r5.f20457b;     // Catch: Throwable -> L51
        String r28 = r5.f20458c;     // Catch: Throwable -> L51
        String r29 = r5.d;     // Catch: Throwable -> L49
        MiniAppHostedWidget$refresh$1 r210 = r11;
        String r30 = "refresh hostId=" + r26 + " instanceId=" + r27 + " cardId=" + r28 + " appletId=" + r29 + " widgetId=" + r5.e;     // Catch: Throwable -> L47
        Intrinsics.checkNotNullParameter("MiniAppHostedWidget", "tag");     // Catch: Throwable -> L47
        Intrinsics.checkNotNullParameter(r30, "msg");     // Catch: Throwable -> L47
        org.koin.core.a r31 = su.a.f22013b;     // Catch: Throwable -> L47
        if (r31 != null) goto L68;
        r14 = r25;
        r10 = "refresh";
        r19 = "KoinApplication has not been started";
    L45:
        th = th;
        goto L55
    L44:
        throw new IllegalStateException(r19);     // Catch: Throwable -> L45
    L68:
        ((ju.b) r31.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("MiniAppHostedWidget", r30);     // Catch: Throwable -> L39
        HostedWidget r32 = r5.f;     // Catch: Throwable -> L39
        r210.L$0 = r5;     // Catch: Throwable -> L39
        r10 = "refresh";
        r210.L$1 = r10;     // Catch: Throwable -> L37
        r210.L$2 = r25;     // Catch: Throwable -> L35
        r18 = true;
        r210.label = 1;     // Catch: Throwable -> L35
        if (r32.refresh(r210) != r14) goto L78;
        return r14;
    L37:
        th = th;
        r14 = r25;
    L36:
        r19 = "KoinApplication has not been started";
    L39:
        th = th;
        r14 = r25;
        r10 = "refresh";
    L47:
        th = th;
        r19 = "KoinApplication has not been started";
        r14 = r25;
        r10 = "refresh";
    L49:
        th = th;
        r10 = "refresh";
        r19 = "KoinApplication has not been started";
        r14 = r25;
    L51:
        th = th;
        r10 = "refresh";
        r14 = r25;
    L53:
        th = th;
        r10 = "refresh";
        r19 = "KoinApplication has not been started";
        r14 = r25;
    L35:
        th = th;
    L7:
        r11 = new MiniAppHostedWidget$refresh$1(r5, r22);
        goto L8
    }

    public final void g(String r16) {
        String r5 = this.f20463l;
        if (r5 != null) goto L5;
        return;
    L5:
        CoroutineScope r10 = this.g;
        if (r10 != null) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(this.f20462k, Boolean.TRUE) == true) goto L16;
        String r11 = this.f20456a;
        String r12 = this.f20457b;
        String r13 = this.f20458c;
        String r14 = this.d;
        String r15 = this.e;
        Boolean r17 = this.f20462k;
        StringBuilder r18 = androidx.constraintlayout.motion.widget.a.y("keep pending render until visible hostId=", r11, " instanceId=", r12, " cardId=");
        androidx.constraintlayout.motion.widget.a.C(r18, r13, " appletId=", r14, " widgetId=");
        androidx.constraintlayout.motion.widget.a.C(r18, r15, " trigger=", r16, " reason=");
        r18.append(r5);
        r18.append(" visible=");
        r18.append(r17);
        String r19 = r18.toString();
        Intrinsics.checkNotNullParameter("MiniAppHostedWidget", "tag");
        Intrinsics.checkNotNullParameter(r19, "msg");
        org.koin.core.a r20 = su.a.f22013b;
        if (r20 == null) goto L15;
        ((ju.b) r20.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("MiniAppHostedWidget", r19);
        return;
    L15:
        throw new IllegalStateException("KoinApplication has not been started");
    L16:
        long r21 = SystemClock.elapsedRealtime();
        long r110 = 1000 - (r21 - this.f20465n);
        if (r110 <= 0) goto L20;
        b.a(r10, new MiniAppHostedWidget$requestPendingRenderIfNeeded$1(r110, this, r16, null));
        return;
    L20:
        this.f20463l = null;
        String r22 = this.f20464m;
        this.f20464m = null;
        this.f20465n = r21;
        b.a(r10, new MiniAppHostedWidget$requestPendingRenderIfNeeded$2(this, r16, r5, r22, null));
    }

    public final boolean h(WidgetDataChangedEvent r10) {
        String r5 = r10.getWidgetData();
        if (r5 != null) goto L5;
    L7:
        String r11 = null;
    L8:
        if (r11 != null) goto L18;
        if (Intrinsics.areEqual(r10.getReason(), "packageUpdate") == false) goto L18;
        String r12 = r10.getReason();
        StringBuilder r13 = new StringBuilder("packageUpdate need force restore hostId=");
        r13.append(this.f20456a);
        r13.append(" instanceId=");
        r13.append(this.f20457b);
        r13.append(" cardId=");
        r13.append(this.f20458c);
        r13.append(" appletId=");
        r13.append(this.d);
        r13.append(" widgetId=");
        String r14 = androidx.constraintlayout.motion.widget.a.t(r13, this.e, " reason=", r12);
        Intrinsics.checkNotNullParameter("MiniAppHostedWidget", "tag");
        Intrinsics.checkNotNullParameter(r14, "msg");
        org.koin.core.a r15 = su.a.f22013b;
        if (r15 == null) goto L16;
        ((ju.b) r15.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("MiniAppHostedWidget", r14);
        return false;
    L16:
        throw new IllegalStateException("KoinApplication has not been started");
    L18:
        return this.f.dispatchDataChanged(r11, r10.getReason(), r10.getDataVersion(), r10.getUpdatedAt(), r10.getState());
    L5:
        if (StringsKt.isBlank(r5) == true) goto L7;
        r11 = r5;
        goto L8
    }
}
