package com.obric.memorydata.utils.e;

import android.graphics.Bitmap;
import com.obric.aiagent.product.platform.api.IPlatformService;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aiagent.product.platform.api.view.IObricWindowManager;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.am;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\"\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00052\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000fJ\"\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00052\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000fJ\b\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/utils/screen/ScreenCaptureExt;", "", "<init>", "()V", "TAG", "", "WHITE_PACKAGE_LIST", "", "cachedWindowManager", "Lcom/obric/aiagent/product/platform/api/view/IObricWindowManager;", "getWindowManager", "captureDisplayActive", "Landroid/graphics/Bitmap;", ObricMemoryConstants.KEY_PACKAGE_NAME, "excludeLayerPackages", "", "captureDisplay", "isFocusedWindowSecure", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f13216a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f13217b = null;
    private static IObricWindowManager c;

    static {
        f13216a = new c();
        f13217b = SetsKt.setOf("com.android.launcher3");
    }

    private c() {
    }

    public static /* synthetic */ Bitmap a(c r1, String r2, List r3, int r4, Object r5) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L6;
        r6 = null;
    L6:
        return r1.a(r2, r6);
    }

    private final IObricWindowManager a() {
        IObricWindowManager r2 = c;
        if (r2 == null) goto L6;
        return r2;
    L6:
        return (IObricWindowManager) ZeusTransformUtils.preCheckCast(y.a($$Lambda$c$ITvz6Za3RU10zJYWzkwwkFekT6Y.INSTANCE, $$Lambda$c$iROWn7vOkZYHEWOafr8ZDNanu8.INSTANCE), IObricWindowManager.class, "com.obric.memorydata.plugin");
    }

    private static final IObricWindowManager a(Exception r9) {
        Intrinsics.checkNotNullParameter(r9, "e");
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenCaptureExt", "fail to get IObricWindowManager: " + ExceptionsKt.stackTraceToString((Throwable) ZeusTransformUtils.preCheckCast(r9, Throwable.class, "com.obric.memorydata.plugin")), null, 4, null);
        return null;
    }

    private static final IObricWindowManager b() {
        IPlatformService r0 = am.f13169a.a();
        if (r0 == null) goto L7;
        IObricWindowManager r1 = r0.windowManager();
        if (r1 == null) goto L7;
        c = r1;
        return r1;
    L7:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenCaptureExt", "IObricWindowManager is not initialized", null, 4, null);
        return null;
    }

    public static /* synthetic */ IObricWindowManager lambda$ITvz6Za3RU10zJYWzkwwkFekT6Y(Exception r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$iROWn7vOkZYHEWO-afr8ZDNanu8, reason: not valid java name */
    public static /* synthetic */ IObricWindowManager m1246lambda$iROWn7vOkZYHEWOafr8ZDNanu8() {
        return b();
    }

    public final Bitmap a(String r3, List<String> r4) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        if (Intrinsics.areEqual(r3, "com.android.launcher3") == false) goto L9;
        RunLog.INSTANCE.debug("ScreenCaptureExt", "captureDisplayActive, exclude com.larus.nova when packageName is com.android.launcher3");
        IObricWindowManager r2 = a();
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.takeScreenshot(null, CollectionsKt.listOf("com.larus.nova"));
    L9:
        return b(r3, r5);
    }

    public final Bitmap b(String r17, List<String> r18) {
        List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r17, ObricMemoryConstants.KEY_PACKAGE_NAME);
        RunLog r3 = RunLog.INSTANCE;
        StringBuilder r4 = new StringBuilder().append("captureDisplay, packageName=").append(r17).append(", excludeLayerPackages=");
        if (r1 == null) goto L5;
        String r6 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, null, 63, null);
    L6:
        r3.debug("ScreenCaptureExt", r4.append(r6).toString());
        if (((Boolean) ZeusTransformUtils.preCheckCast(a.f13206a.a().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L27;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenCaptureExt", "captureDisplay failed, focused window is secure", null, 4, null);
        return null;
    L27:
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        if (r2 != null) goto L13;
    L16:
        boolean r5 = true;
    L17:
        if (r5 == false) goto L19;
        List<String> r0 = CollectionsKt.listOf(r17);     // Catch: Throwable -> L24
    L20:
        IObricWindowManager r7 = a();     // Catch: Throwable -> L24
        if (r7 == null) goto L29;
        return r7.takeScreenshot(r0, r1);
    L29:
        return null;
    L19:
        r0 = null;
        goto L20
    L13:
        if (r2.isEmpty() == true) goto L16;
        r5 = false;
    L24:
        th = move-exception;
        RunLog.INSTANCE.error("ScreenCaptureExt", "captureDisplay failed", th);
        return null;
    L5:
        r6 = null;
        goto L6
    }
}
