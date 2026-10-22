package com.obric.matrix.platform.sdk.ones.commonmonitor.fps;

import android.os.Looper;
import android.util.Printer;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J.\u0010\u0012\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/FPSMonitor;", "", "()V", "TAG", "", "printerHasReset", "", "checkResetPrinter", "", "monitorLifecycleOwnerFps", "owner", "Landroidx/lifecycle/LifecycleOwner;", "monitorPeriodFps", MemoryInfoSectionEditActivity.KIND_SCENE, "durationInSecond", "", "durationInMs", "", "monitorRecyclerView", "view", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/FPSMonitorOnScrollListener;", "forceCollect", "fpsCallback", "Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/IFPSCallBack;", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8087a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f8088b;

    static {
        f8087a = new b();
    }

    private b() {
    }

    private final void a() {
        if (f8088b == false) goto L5;
        return;
    L5:
        if (a.f8086a.a() != null) goto L17;
        com.obric.matrix.platform.sdk.ones.internal.b.b.a("FPSMonitor", "CurrentPrinter() == null, now reset.", null, 4, null);
        Field r3 = f.class.getDeclaredField("b");     // Catch: Exception -> L12
        r3.setAccessible(true);     // Catch: Exception -> L12
        Object r4 = r3.get(null);     // Catch: Exception -> L12
        if (r4 == null) goto L11;
        Printer r5 = (Printer) ZeusTransformUtils.preCheckCast(r4, Printer.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L12
        Looper.getMainLooper().setMessageLogging(r5);     // Catch: Exception -> L12
        f8088b = true;     // Catch: Exception -> L12
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.util.Printer");     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static final /* synthetic */ void a(b r0) {
        r0.a();
    }
}
