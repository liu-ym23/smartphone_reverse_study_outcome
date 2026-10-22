package com.obric.memorydata.middleware.impl.app;

import android.os.StrictMode;
import android.os.strictmode.Violation;
import com.bytedance.crash.Ensure;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/middleware/impl/app/StrictModeMonitor;", "", "<init>", "()V", "TAG", "", "executor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "Ljava/util/concurrent/ExecutorService;", "WHITELIST", "", "setupIfDebug", "", "setupThreadPolicy", "setupVmPolicy", "isWhitelisted", "", "stack", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f11700a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ExecutorService f11701b = null;
    private static final Set<String> c = null;

    static {
        f11700a = new b();
        f11701b = Executors.newSingleThreadExecutor();
        c = SetsKt.setOf(new String[]{"android.content.res.IconManager.isPackageRedirected", "File.delete", "File.mkdir", "File.exists", "File.isDirectory", "File.list", "ClassLoader.getResources", "com.obric.cae.log.CaeLog", "android.app.SharedPreferences", "LazyClassPathLookupIterator.parse", "libcore.io.IoBridge", "com.obric.memorydata.debug"});
    }

    private b() {
    }

    private static final void a(Violation r6) {
        Intrinsics.checkNotNull(r6);
        String r0 = ExceptionsKt.stackTraceToString((Throwable) ZeusTransformUtils.preCheckCast(r6, Throwable.class, "com.obric.memorydata.plugin"));
        if (f11700a.a(r0) == false) goto L6;
        return;
    L6:
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(AppContext.INSTANCE.getPackageName(), CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L8;
        return;
    L8:
        String r1 = "StrictMode mainThread violation: type=" + r6.getClass().getSimpleName() + " message=" + r6.getMessage();
        RunLog.INSTANCE.error("StrictModeMonitor", r1, (Throwable) ZeusTransformUtils.preCheckCast(r6, Throwable.class, "com.obric.memorydata.plugin"));
        Ensure.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(r6, Throwable.class, "com.obric.memorydata.plugin"), r1);
    }

    private final boolean a(String r7) {
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(c, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L5;
    L7:
        Iterator r8 = r6.iterator();
    L9:
        if (r8.hasNext() == false) goto L18;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        return false;
    }

    private final void b() {
        StrictMode.ThreadPolicy.Builder r3 = new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().penaltyListener((Executor) ZeusTransformUtils.preCheckCast(f11701b, Executor.class, "com.obric.memorydata.plugin"), $$Lambda$b$11ljAFHG3H6CWa_0tZkhshI_a8M.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(r3, "penaltyListener(...)");
        StrictMode.setThreadPolicy(r3.build());
    }

    private static final void b(Violation r6) {
        Intrinsics.checkNotNull(r6);
        String r0 = ExceptionsKt.stackTraceToString((Throwable) ZeusTransformUtils.preCheckCast(r6, Throwable.class, "com.obric.memorydata.plugin"));
        if (f11700a.a(r0) == false) goto L6;
        return;
    L6:
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(AppContext.INSTANCE.getPackageName(), CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L8;
        return;
    L8:
        String r1 = "StrictMode vm violation: type=" + r6.getClass().getSimpleName() + " message=" + r6.getMessage();
        RunLog.INSTANCE.error("StrictModeMonitor", r1, (Throwable) ZeusTransformUtils.preCheckCast(r6, Throwable.class, "com.obric.memorydata.plugin"));
        Ensure.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(r6, Throwable.class, "com.obric.memorydata.plugin"), r1);
    }

    private final void c() {
        StrictMode.VmPolicy.Builder r3 = new StrictMode.VmPolicy.Builder().detectLeakedClosableObjects().detectActivityLeaks().detectFileUriExposure().penaltyListener((Executor) ZeusTransformUtils.preCheckCast(f11701b, Executor.class, "com.obric.memorydata.plugin"), $$Lambda$b$wXDIVoVkD33uSOQ1KfcS6CX5pFE.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(r3, "penaltyListener(...)");
        StrictMode.setVmPolicy(r3.build());
    }

    public static /* synthetic */ void lambda$11ljAFHG3H6CWa_0tZkhshI_a8M(Violation r0) {
        a(r0);
    }

    public static /* synthetic */ void lambda$wXDIVoVkD33uSOQ1KfcS6CX5pFE(Violation r0) {
        b(r0);
    }

    public final void a() {
        if (AppContext.INSTANCE.isDebug() == true) goto L5;
        return;
    L5:
        b();
        c();
    }
}
