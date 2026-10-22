package com.obric.aikernel.model.device;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.res.metadata.data.f;
import com.obric.aikernel.runtime.AIInferRuntime;
import com.obric.aikernel.runtime.utils.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJB\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0013\u001a\u00020\tH\u0002J\u0016\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007J\u000e\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ$\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0002R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/aikernel/model/device/UnNamedExceptionStrategy;", "", "runtime", "Lcom/obric/aikernel/runtime/AIInferRuntime;", "(Lcom/obric/aikernel/runtime/AIInferRuntime;)V", "corruptedSet", "Ljava/util/concurrent/ConcurrentHashMap;", "", "errorCounter", "", "onException", "", "wrapper", "Lcom/obric/aikernel/runtime/AIInferRuntime$PackageWrapper;", LocationMonitorConst.TAG, ObricMemoryConstants.KEY_PACKAGE_NAME, "packageVersion", "loraName", "loraVersion", "weight", "onServiceLoadFailed", "onSuccess", "requestUpdateIfNeed", "Companion", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0251a f5991a = null;
    private static final long e = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AIInferRuntime f5992b;
    private final ConcurrentHashMap<String, Integer> c;
    private final ConcurrentHashMap<String, Object> d;

    /* JADX INFO: renamed from: com.obric.aikernel.model.device.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/aikernel/model/device/UnNamedExceptionStrategy$Companion;", "", "()V", "CORRUPT_RECOVER_INTERVAL", "", "SERVICE_LOAD_FAILED_WEIGHT", "", "TAG", "", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C0251a {
        private C0251a() {
        }

        public /* synthetic */ C0251a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f5991a = new C0251a(null);
        Duration.Companion r0 = Duration.Companion;
        e = Duration.m2793toLongimpl(DurationKt.toDuration(6, DurationUnit.HOURS), DurationUnit.MILLISECONDS);
    }

    public a(AIInferRuntime r2) {
        Intrinsics.checkNotNullParameter(r2, "runtime");
        this.f5992b = r2;
        this.c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
    }

    public static final /* synthetic */ long a() {
        return e;
    }

    public static final /* synthetic */ AIInferRuntime a(a r0) {
        return r0.f5992b;
    }

    private static final Integer a(Function2 r2, Object r3, Object r4) {
        Function2 r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r2, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "$tmp0");
        return (Integer) ZeusTransformUtils.preCheckCast(r5.invoke(r3, r4), Integer.class, "com.obric.memorydata.plugin");
    }

    static /* synthetic */ void a(a r9, String r10, String r11, String r12, String r13, String r14, int r15, int r16, Object r17) {
        if ((r16 & 8) == 0) goto L5;
        String r6 = null;
    L7:
        if ((r16 & 16) == 0) goto L9;
        String r7 = null;
    L11:
        if ((r16 & 32) == 0) goto L13;
        int r8 = 1;
    L14:
        r9.a(r10, r11, r12, r6, r7, r8);
        return;
    L13:
        r8 = r15;
        goto L14
    L9:
        r7 = r14;
        goto L11
    L5:
        r6 = r13;
        goto L7
    }

    private final void a(String r10, String r11, String r12) {
        Object r0 = this.d.get(r10);
        if (r0 != null) goto L5;
        ((Map) ZeusTransformUtils.preCheckCast(this.d, Map.class, "com.obric.memorydata.plugin")).put(r10, Unit.INSTANCE);
        return;
    L5:
        boolean r2 = true;
        if (ZeusTransformUtils.instanceOf(r0, ar.class) == true) goto L8;
    L10:
        if (r2 == false) goto L14;
        ((Map) ZeusTransformUtils.preCheckCast(this.d, Map.class, "com.obric.memorydata.plugin")).put(r10, i.b(this.f5992b.b(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new UnNamedExceptionStrategy$requestUpdateIfNeed$1(this, r11, r12, null), Function2.class, "com.obric.memorydata.plugin"), 3, null));
        return;
    L14:
        return;
    L8:
        if (((ar) ZeusTransformUtils.preCheckCast(r0, ar.class, "com.obric.memorydata.plugin")).a() == false) goto L10;
        r2 = false;
        goto L10
    }

    private final void a(String r9, String r10, String r11, String r12, String r13, int r14) {
        ConcurrentHashMap<String, Integer> r0 = this.c;
        Integer r1 = Integer.valueOf(r14);
        final Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(UnNamedExceptionStrategy$onException$exceptionCount$1.INSTANCE, Function2.class, "com.obric.memorydata.plugin");
        Integer r3 = (Integer) ZeusTransformUtils.preCheckCast(r0.merge(r9, r1, new $$Lambda$a$Rg_m_ltgiorG7brpaVE7LISdCE(r2)), Integer.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L6;
        r3 = Integer.valueOf(r14);
    L6:
        if (((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue() <= this.f5992b.a().a()) goto L21;
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L9:
        if (this.c.remove(r9) == null) goto L15;
        d.f6216a.g("UnNamedExceptionStrategy", "notePackageCorrupt: " + r9);     // Catch: Throwable -> L18
        if (r12 == null) goto L14;
        if (r13 == null) goto L14;
        AIInferRuntime.a(this.f5992b, r12, r13, false, 4, null);     // Catch: Throwable -> L18
    L14:
        this.f5992b.a(r10, r11, true);     // Catch: Throwable -> L18
        a(r9, r10, r12);     // Catch: Throwable -> L18
    L15:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    }

    /* JADX INFO: renamed from: lambda$Rg_m_ltgiorG7brpaV-E7LISdCE, reason: not valid java name */
    public static /* synthetic */ Integer m187lambda$Rg_m_ltgiorG7brpaVE7LISdCE(Function2 r0, Object r1, Object r2) {
        return a(r0, r1, r2);
    }

    public final void a(AIInferRuntime.g r14) {
        Intrinsics.checkNotNullParameter(r14, "wrapper");
        StringBuilder r0 = new StringBuilder().append(r14.a().s()).append('@').append(r14.a().t()).append(',');
        f r2 = r14.c();
        String r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.s();
    L6:
        StringBuilder r1 = r0.append(r4).append('@');
        f r5 = r14.c();
        if (r5 == null) goto L9;
        String r6 = r5.t();
    L10:
        String r7 = r1.append(r6).toString();
        String r8 = r14.a().s();
        String r9 = r14.a().t();
        f r10 = r14.c();
        if (r10 == null) goto L13;
        String r11 = r10.s();
    L14:
        f r15 = r14.c();
        if (r15 == null) goto L17;
        r3 = r15.t();
    L17:
        a(this, r7, r8, r9, r11, r3, 0, 32, null);
        return;
    L13:
        r11 = null;
        goto L14
    L9:
        r6 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    public final void a(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r12, "packageVersion");
        boolean r2 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")).length() == 0) goto L11;
        r2 = false;
    L11:
        if (r2 == true) goto L16;
        a(this, r11 + '@' + r12 + ",null@null", r11, r12, null, null, 10, 24, null);
        return;
    L16:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void b(AIInferRuntime.g r5) {
        Intrinsics.checkNotNullParameter(r5, "wrapper");
        StringBuilder r0 = new StringBuilder().append(r5.a().s()).append('@').append(r5.a().t()).append(',');
        f r2 = r5.c();
        String r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.s();
    L6:
        StringBuilder r1 = r0.append(r4).append('@');
        f r6 = r5.c();
        if (r6 == null) goto L9;
        r3 = r6.t();
    L9:
        String r7 = r1.append(r3).toString();
        this.c.remove(r7);
        this.d.remove(r7);
        return;
    L5:
        r4 = null;
        goto L6
    }
}
