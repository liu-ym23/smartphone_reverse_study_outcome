package n8;

import android.view.View;
import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f11273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RunMode f11274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private RepeatMode f11275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<? extends j8.a<?>> f11276d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private WeakReference<View> f11277e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f11278f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f11279g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f11280h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f11281i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f11282j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f11283k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f11284l;

    public c() {
        this.f11274b = RunMode.PARALLEL;
        this.f11275c = RepeatMode.NORMAL;
        this.f11276d = CollectionsKt.emptyList();
        this.f11279g = -1;
        this.f11280h = 1.0f;
        this.f11284l = true;
    }

    public final void a(boolean r10) {
        WeakReference<View> r11 = this.f11277e;
        if (r11 == null) goto L5;
        r11.clear();
    L5:
        Iterator<T> r12 = this.f11276d.iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        ((j8.a) r12.next()).m(false, false, r10);
        goto L7
    L9:
        this.f11278f = 0;
        this.f11279g = -1;
        this.f11280h = 1.0f;
        this.f11281i = false;
        this.f11282j = 0;
        this.f11283k = 0;
    }

    public final long b() {
        return this.f11283k;
    }

    public final List<j8.a<?>> c() {
        return this.f11276d;
    }

    public final int d() {
        return this.f11279g;
    }

    public final long e() {
        return this.f11273a;
    }

    public final long f() {
        return this.f11282j;
    }

    public final RepeatMode g() {
        return this.f11275c;
    }

    public final RunMode h() {
        return this.f11274b;
    }

    public final float i() {
        return this.f11280h;
    }

    public final long j() {
        return this.f11278f;
    }

    public final View k() {
        WeakReference<View> r10 = this.f11277e;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.get();
    }

    public final boolean l() {
        List<? extends j8.a<?>> r10 = this.f11276d;
        if ((r10 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r11 = r10.iterator();
    L9:
        if (r11.hasNext() == false) goto L18;
        if (((j8.a) r11.next()).l() == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r10.isEmpty() == false) goto L7;
        return false;
    }

    public final boolean m() {
        return this.f11281i;
    }

    public final boolean n() {
        return this.f11284l;
    }

    public final void o(long r10) {
        this.f11283k = r10;
    }

    public final void p(List<? extends j8.a<?>> r10) {
        Intrinsics.checkNotNullParameter(r10, "animationInfos");
        this.f11276d = r10;
    }

    public final void q(int r10) {
        this.f11279g = r10;
    }

    public final void r(long r10) {
        this.f11273a = r10;
    }

    public final void s(long r10) {
        this.f11282j = r10;
    }

    public final void t(RepeatMode r10) {
        Intrinsics.checkNotNullParameter(r10, "repeatMode");
        this.f11275c = r10;
    }

    public final void u(RunMode r10) {
        Intrinsics.checkNotNullParameter(r10, "runMode");
        this.f11274b = r10;
    }

    public final void v(float r10) {
        this.f11280h = r10;
    }

    public final void w(long r10) {
        this.f11278f = r10;
    }

    public final void x(float r10) {
    }

    public final void y(View r10) {
        if (r10 == null) goto L4;
        boolean r11 = true;
    L5:
        this.f11284l = r11;
        this.f11277e = new WeakReference(r10);
        return;
    L4:
        r11 = false;
        goto L5
    }
}
