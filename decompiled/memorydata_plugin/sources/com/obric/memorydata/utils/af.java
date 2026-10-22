package com.obric.memorydata.utils;

import android.content.Context;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t*\u0001\u0014\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\"B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012H\u0002J\u0012\u0010\u001c\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\u001e\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005H\u0002J\u000e\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\bJ\u000e\u0010!\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006#"}, d2 = {"Lcom/obric/memorydata/utils/MemoryAppStateListener;", "", "<init>", "()V", "TAG", "", "appSwitchListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/memorydata/utils/MemoryAppStateListener$AppSwitchListener;", "curAppName", "getCurAppName", "()Ljava/lang/String;", "setCurAppName", "(Ljava/lang/String;)V", "curPackageName", "getCurPackageName", "setCurPackageName", "registrationStrategy", "Lcom/obric/memorydata/utils/appstate/AppStateRegistrationStrategy;", "registrationCallback", "com/obric/memorydata/utils/MemoryAppStateListener$registrationCallback$1", "Lcom/obric/memorydata/utils/MemoryAppStateListener$registrationCallback$1;", "initialise", "", "registerAppStateStrategy", "registerStrategySafely", "", "strategy", "handleAppForeground", ObricMemoryConstants.KEY_PACKAGE_NAME, "handleAppBackground", "addAppSwitchListener", "listener", "removeAppSwitchListener", "AppSwitchListener", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class af {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final af f13160a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final CopyOnWriteArrayList<a> f13161b = null;
    private static String c;
    private static String d;
    private static com.obric.memorydata.utils.a.b e;
    private static final b f = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/utils/MemoryAppStateListener$AppSwitchListener;", "", "onAppOpen", "", "appName", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "onAppClose", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface a {
        void a(String r1, String r2);

        void b(String r1, String r2);
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/obric/memorydata/utils/MemoryAppStateListener$registrationCallback$1", "Lcom/obric/memorydata/utils/appstate/AppStateRegistrationCallback;", "onAppForeground", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "onAppBackground", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements com.obric.memorydata.utils.a.a {
        b() {
        }

        @Override // com.obric.memorydata.utils.a.a
        public void a(String r1) {
            af.a(af.f13160a, r1);
        }

        @Override // com.obric.memorydata.utils.a.a
        public void b(String r1) {
            af.b(af.f13160a, r1);
        }
    }

    static {
        f13160a = new af();
        f13161b = new CopyOnWriteArrayList();
        c = "";
        d = "";
        f = new b();
    }

    private af() {
    }

    public static final /* synthetic */ void a(af r0, String r1) {
        r0.a(r1);
    }

    private final void a(String r9) {
        RunLog.INSTANCE.debug("MemoryAppStateListener", "handleAppForeground packageName=" + r9);
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r2 = false;
        if (r8 != null) goto L5;
    L8:
        boolean r10 = true;
    L9:
        if (r10 == false) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(d, r9) == false) goto L14;
        return;
    L14:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(d, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L16;
        r2 = true;
    L16:
        if (r2 == false) goto L21;
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(f13161b, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L19:
        if (r11.hasNext() == false) goto L21;
        ((a) ZeusTransformUtils.preCheckCast(r11.next(), a.class, "com.obric.memorydata.plugin")).b(c, d);
    L21:
        d = r9;
        c.a r12 = c.a(c.f13193a, r9, null, 2, null);
        if (r12 == null) goto L25;
        String r13 = r12.a();
        if (r13 == null) goto L25;
    L26:
        c = r13;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryAppStateListener", "current pkg = " + d, false, 4, null);
        RunLog.INSTANCE.debug("MemoryAppStateListener", "onAppOpen " + d);
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(f13161b, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L28:
        if (r14.hasNext() == false) goto L34;
        ((a) ZeusTransformUtils.preCheckCast(r14.next(), a.class, "com.obric.memorydata.plugin")).a(c, d);
        goto L28
    L34:
        return;
    L25:
        r13 = "";
        goto L26
    L5:
        if (r8.length() == 0) goto L8;
        r10 = false;
        goto L9
    }

    private final boolean a(com.obric.memorydata.utils.a.b r9) {
        final com.obric.memorydata.utils.a.b r8 = (com.obric.memorydata.utils.a.b) ZeusTransformUtils.wrapperContextForParams(r9, com.obric.memorydata.utils.a.b.class, "com.obric.memorydata.plugin");
        Boolean r1 = (Boolean) ZeusTransformUtils.preCheckCast(y.a(new $$Lambda$af$Oau4biDu865uX3Uan0fxgRspUjg(r8), new $$Lambda$af$wxIYKQn1kuD_riiO7h_myZVYxZY(r8)), Boolean.class, "com.obric.memorydata.plugin");     // Catch: NoClassDefFoundError -> L7
        if (r1 == null) goto L12;
        return r1.booleanValue();
    L12:
        return false;
    L7:
        e = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryAppStateListener", "register strategy=" + r8.a() + " not supported on this system: " + e.getMessage(), null, 4, null);
        return false;
    }

    private static final boolean a(com.obric.memorydata.utils.a.b r7, Exception r8) {
        com.obric.memorydata.utils.a.b r9 = (com.obric.memorydata.utils.a.b) ZeusTransformUtils.wrapperContextForParams(r7, com.obric.memorydata.utils.a.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "e");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryAppStateListener", "register strategy=" + r9.a() + " failed: " + r8.getMessage(), null, 4, null);
        return false;
    }

    public static final /* synthetic */ void b(af r0, String r1) {
        r0.b(r1);
    }

    private final void b(String r4) {
        RunLog.INSTANCE.debug("MemoryAppStateListener", "handleAppBackground packageName=" + r4);
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r5 == false) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(r4, d) == false) goto L21;
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(f13161b, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L15:
        if (r6.hasNext() == false) goto L17;
        ((a) ZeusTransformUtils.preCheckCast(r6.next(), a.class, "com.obric.memorydata.plugin")).b(c, d);
        goto L15
    L17:
        d = "";
        c = "";
        return;
    L21:
        return;
    L5:
        if (r3.length() == 0) goto L8;
        r5 = false;
        goto L9
    }

    private static final boolean b(com.obric.memorydata.utils.a.b r2) {
        return ((com.obric.memorydata.utils.a.b) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.memorydata.utils.a.b.class, "com.obric.memorydata.plugin")).b();
    }

    private final void d() {
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.a.c.f13148a.a((com.obric.memorydata.utils.a.a) ZeusTransformUtils.preCheckCast(f, com.obric.memorydata.utils.a.a.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Object r0 = r11.next();
        com.obric.memorydata.utils.a.b r1 = (com.obric.memorydata.utils.a.b) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.utils.a.b.class, "com.obric.memorydata.plugin");
        boolean r3 = f13160a.a(r1);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryAppStateListener", "register strategy=" + r1.a() + ", result=" + r3, false, 4, null);
        if (r3 == false) goto L4;
    L9:
        com.obric.memorydata.utils.a.b r12 = (com.obric.memorydata.utils.a.b) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.utils.a.b.class, "com.obric.memorydata.plugin");
        e = r12;
        if (r12 != null) goto L12;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryAppStateListener", "no app state registration strategy registered", null, 4, null);
        return;
    L12:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryAppStateListener", "selected app state strategy=" + r12.a(), false, 4, null);
        return;
    L8:
        r0 = null;
        goto L9
    }

    public static /* synthetic */ boolean lambda$Oau4biDu865uX3Uan0fxgRspUjg(com.obric.memorydata.utils.a.b r0, Exception r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ boolean lambda$wxIYKQn1kuD_riiO7h_myZVYxZY(com.obric.memorydata.utils.a.b r0) {
        return b(r0);
    }

    public final String a() {
        return c;
    }

    public final void a(a r2) {
        a r1 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "listener");
        f13161b.addIfAbsent(r1);
    }

    public final String b() {
        return d;
    }

    public final void b(a r2) {
        a r1 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "listener");
        f13161b.remove(r1);
    }

    public final void c() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryAppStateListener", "initialise start", false, 4, null);
        String r0 = ba.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        d = r0;
        c.a r2 = c.a(c.f13193a, d, null, 2, null);
        if (r2 == null) goto L11;
        String r3 = r2.a();
        if (r3 == null) goto L11;
        r1 = r3;
    L11:
        c = r1;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryAppStateListener", "current pkg = " + d, false, 4, null);
        d();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryAppStateListener", "initialise end", false, 4, null);
    }
}
