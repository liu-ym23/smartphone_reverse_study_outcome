package n8;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f11285d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f11286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private n8.a f11287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f11288c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static final class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f11289c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ float f11290g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ View f11291h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ RunMode f11292i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ float f11293j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ RepeatMode f11294k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ List f11295l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ Function3 f11296m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final /* synthetic */ Function2 f11297n;

        b(d r10, float r11, View r12, RunMode r13, float r14, RepeatMode r15, List r16, Function3 r17, Function2 r18) {
            this.f11289c = r10;
            this.f11290g = r11;
            this.f11291h = r12;
            this.f11292i = r13;
            this.f11293j = r14;
            this.f11294k = r15;
            this.f11295l = r16;
            this.f11296m = r17;
            this.f11297n = r18;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.a(this.f11289c, this.f11290g, this.f11291h, this.f11292i, this.f11293j, this.f11294k, this.f11295l, this.f11296m, this.f11297n);
        }
    }

    static {
        new a(null);
        new t8.c();
    }

    public d() {
        this.f11286a = new c();
        int r10 = f11285d;
        f11285d = r10 + 1;
        this.f11288c = r10;
    }

    public static final /* synthetic */ void a(d r10, float r11, View r12, RunMode r13, float r14, RepeatMode r15, List r16, Function3 r17, Function2 r18) {
        r10.d(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public static /* synthetic */ void c(d r10, boolean r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = false;
    L5:
        r10.b(r11);
    }

    private final void d(float r18, View r19, RunMode r20, float r21, RepeatMode r22, List<? extends j8.a<?>> r23, Function3<? super String, Object, ? super Float, Unit> r24, Function2<? super Boolean, ? super Throwable, Unit> r25) {
        t8.b r10 = t8.b.f12973c;
        StringBuilder r11 = new StringBuilder();
        r11.append("start, instanceId: [");
        r11.append(this.f11288c);
        r11.append("], runAnimation, mode: ");
        r11.append(r20);
        r11.append(", speed: ");
        r11.append(r21);
        r11.append(", repeatMode: ");
        r11.append(r22);
        r11.append(", animationInfos: ");
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10));
        Iterator<T> r13 = r23.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r12.add(((j8.a) r13.next()).a());
        goto L4
    L6:
        r11.append(CollectionsKt.joinToString$default(r12, "\n", null, null, 0, null, null, 62, null));
        r10.f("AnimationManager", r11.toString());
        this.f11286a.x(r18);
        this.f11286a.u(r20);
        this.f11286a.t(r22);
        this.f11286a.p(r23);
        this.f11286a.y(r19);
        this.f11286a.v(r21);
        n8.a r14 = new n8.a(this.f11286a, r24, r25);
        this.f11287b = r14;
        r14.n();
    }

    public final void b(boolean r10) {
        t8.b.f12973c.f("AnimationManager", "cancel, instanceId: [" + this.f11288c + "], clearVelocity: " + r10);
        n8.a r11 = this.f11287b;
        if (r11 == null) goto L6;
        r11.f(r10);
        return;
    }

    public final void e(float r13, View r14, RunMode r15, float r16, RepeatMode r17, List<? extends j8.a<?>> r18, Function3<? super String, Object, ? super Float, Unit> r19, Function2<? super Boolean, ? super Throwable, Unit> r20) {
        Intrinsics.checkNotNullParameter(r15, "mode");
        Intrinsics.checkNotNullParameter(r17, "repeatMode");
        Intrinsics.checkNotNullParameter(r18, "animationInfos");
        Looper r10 = Looper.getMainLooper();
        Intrinsics.checkNotNullExpressionValue(r10, "Looper.getMainLooper()");
        if ((!Intrinsics.areEqual(r10.getThread(), Thread.currentThread())) == false) goto L5;
        new Handler(Looper.getMainLooper()).post(new b(this, r13, r14, r15, r16, r17, r18, r19, r20));
        return;
    L5:
        d(r13, r14, r15, r16, r17, r18, r19, r20);
    }
}
