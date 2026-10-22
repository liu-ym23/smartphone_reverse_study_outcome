package com.obric.aikernel.model.device;

import com.obric.aikernel.res.metadata.data.Lora;
import com.obric.aikernel.runtime.AIInferRuntime;
import com.obric.aikernel.runtime.utils.d;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.h;
import kotlinx.coroutines.r0;

/* JADX INFO: loaded from: classes2.dex */
public final class UnNamedExceptionStrategy {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f4678d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AIInferRuntime f4679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, Integer> f4680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap<String, Object> f4681c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
        Duration.Companion r10 = Duration.Companion;
        f4678d = Duration.m1430toLongimpl(DurationKt.toDuration(6, DurationUnit.HOURS), DurationUnit.MILLISECONDS);
    }

    public UnNamedExceptionStrategy(AIInferRuntime r10) {
        Intrinsics.checkNotNullParameter(r10, "runtime");
        this.f4679a = r10;
        this.f4680b = new ConcurrentHashMap();
        this.f4681c = new ConcurrentHashMap();
    }

    public static final /* synthetic */ long a() {
        return f4678d;
    }

    public static final /* synthetic */ AIInferRuntime b(UnNamedExceptionStrategy r10) {
        return r10.f4679a;
    }

    private final void e(String r10, AIInferRuntime.PackageWrapper r11) {
        Object r12 = this.f4681c.get(r10);
        if (r12 != null) goto L5;
        this.f4681c.put(r10, Unit.INSTANCE);
        return;
    L5:
        boolean r13 = true;
        if ((r12 instanceof r0) == true) goto L8;
    L10:
        if (r13 == false) goto L14;
        this.f4681c.put(r10, h.b(this.f4679a.a0(), null, null, new UnNamedExceptionStrategy$requestUpdateIfNeed$1(this, r11, null), 3, null));
        return;
    L14:
        return;
    L8:
        if (((r0) r12).isActive() == false) goto L10;
        r13 = false;
        goto L10
    }

    public final void c(AIInferRuntime.PackageWrapper r10) {
        Intrinsics.checkNotNullParameter(r10, "wrapper");
        StringBuilder r11 = new StringBuilder();
        r11.append(r10.g().w());
        r11.append('@');
        r11.append(r10.g().D());
        r11.append(',');
        Lora r12 = r10.d();
        String r13 = null;
        if (r12 == null) goto L5;
        String r14 = r12.w();
    L6:
        r11.append(r14);
        r11.append('@');
        Lora r15 = r10.d();
        if (r15 == null) goto L9;
        r13 = r15.D();
    L9:
        r11.append(r13);
        String r16 = r11.toString();
        Integer r17 = this.f4680b.get(r16);
        if (r17 != null) goto L12;
        r17 = 0;
    L12:
        int r18 = r17.intValue() + 1;
        this.f4680b.put(r16, Integer.valueOf(r18));
        if (r18 <= this.f4679a.R().c()) goto L27;
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L16:
        if (this.f4680b.remove(r16) == null) goto L21;
        d.f5417a.e("UnNamedExceptionStrategy", "notePackageCorrupt: " + r16);     // Catch: Throwable -> L24
        Lora r19 = r10.d();     // Catch: Throwable -> L24
        if (r19 == null) goto L20;
        AIInferRuntime.j0(this.f4679a, r19.w(), r19.D(), false, 4, null);     // Catch: Throwable -> L24
    L20:
        this.f4679a.i0(r10.g().w(), r10.g().D(), true);     // Catch: Throwable -> L24
        e(r16, r10);     // Catch: Throwable -> L24
    L21:
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L27:
        return;
    L5:
        r14 = null;
        goto L6
    }

    public final void d(AIInferRuntime.PackageWrapper r10) {
        Intrinsics.checkNotNullParameter(r10, "wrapper");
        StringBuilder r11 = new StringBuilder();
        r11.append(r10.g().w());
        r11.append('@');
        r11.append(r10.g().D());
        r11.append(',');
        Lora r12 = r10.d();
        String r13 = null;
        if (r12 == null) goto L5;
        String r14 = r12.w();
    L6:
        r11.append(r14);
        r11.append('@');
        Lora r15 = r10.d();
        if (r15 == null) goto L9;
        r13 = r15.D();
    L9:
        r11.append(r13);
        String r16 = r11.toString();
        this.f4680b.remove(r16);
        this.f4681c.remove(r16);
        return;
    L5:
        r14 = null;
        goto L6
    }
}
