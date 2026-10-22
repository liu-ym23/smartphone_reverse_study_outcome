package jc;

import com.bytedance.crash.tracker.ActivityLifecycle;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nTask.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Task.kt\nokhttp3/internal/concurrent/Task\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,71:1\n1#2:72\n*E\n"})
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f9915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d f9916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f9917d;

    public a(String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        this.f9914a = r10;
        this.f9915b = r11;
        this.f9917d = -1;
    }

    public /* synthetic */ a(String r10, boolean r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = true;
    L5:
        this(r10, r11);
    }

    public final boolean a() {
        return this.f9915b;
    }

    public final String b() {
        return this.f9914a;
    }

    public final long c() {
        return this.f9917d;
    }

    public final d d() {
        return this.f9916c;
    }

    public final void e(d r10) {
        Intrinsics.checkNotNullParameter(r10, "queue");
        d r11 = this.f9916c;
        if (r11 != r10) goto L5;
        return;
    L5:
        if (r11 != null) goto L7;
        boolean r12 = true;
    L8:
        if (r12 == false) goto L12;
        this.f9916c = r10;
        return;
    L12:
        throw new IllegalStateException("task is in multiple queues".toString());
    L7:
        r12 = false;
        goto L8
    }

    public abstract long f();

    public final void g(long r10) {
        this.f9917d = r10;
    }

    public String toString() {
        return this.f9914a;
    }
}
