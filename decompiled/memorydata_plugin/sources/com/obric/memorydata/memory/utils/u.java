package com.obric.memorydata.memory.utils;

import android.app.Application;
import android.graphics.Region;
import android.security.obric.guard.ObricSecurityGuardStub;
import android.util.Log;
import android.view.SurfaceControl;
import android.view.SurfaceView;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.Api;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0018\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0014\u001a\u00020\fJ\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0017\u001a\u00020\u0015J\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00182\b\u0010\u0016\u001a\u0004\u0018\u00010\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u0010\u0010\u001a\u001a\u00020\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u000e\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#J\u0006\u0010%\u001a\u00020\u0012J\u0016\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020)J\u0016\u0010*\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010+\u001a\u00020)J\b\u0010,\u001a\u0004\u0018\u00010\u0005J\u0016\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\fJ\u0016\u00100\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\fJ\b\u00101\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/obric/memorydata/memory/utils/SystemHideApiHelper;", "", "<init>", "()V", "TAG", "", "systemStatusBarManager", "getSystemStatusBarManager", "()Ljava/lang/Object;", "systemStatusBarManager$delegate", "Lkotlin/Lazy;", "DISABLE_NAVIGATION", "", "getSurfaceControl", "Landroid/view/SurfaceControl;", BaseSwitches.V, "Landroid/view/View;", "setTouchableRegion", "", "capsuleView", TypedValues.CycleType.S_WAVE_OFFSET, "Landroid/graphics/Rect;", "view", "rect", "Landroid/graphics/Region;", Api.KEY_REGION, "setSurfaceView", "surfaceView", "Landroid/view/SurfaceView;", "getStatusBarHeight", "context", "Landroid/content/Context;", "getNavigationBarHeight", "addIslandWindowPrivateFlags", TrackerImpl.PARAMS, "Landroid/view/WindowManager$LayoutParams;", "addTrustedOverLayFlags", "collapseStatusBarPanels", "performHapticFeedback", "effectId", ObricSecurityGuardStub.PermissionLevel.PERMISSION_LEVEL_ALWAYS, "", "enableHome", "enabled", "detectCountryIso", "asyncTraceBegin", "methodName", "cookie", "asyncTraceEnd", "getCurrentAudioFocusHolder", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f11564a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f11565b = null;

    static {
        f11564a = new u();
        f11565b = LazyKt.lazy($$Lambda$u$TsE17yvtuuX7TeHJDMtgJR_4s.INSTANCE);
    }

    private u() {
    }

    private static final Object a() {
        return ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getSystemService("statusbar");
    L5:
        e = move-exception;
        Log.e("HideApiHelper", "Failed to get statusbar service", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return null;
    }

    /* JADX INFO: renamed from: lambda$TsE17yv-tuuX7T-eHJDMtgJR_4s, reason: not valid java name */
    public static /* synthetic */ Object m997lambda$TsE17yvtuuX7TeHJDMtgJR_4s() {
        return a();
    }

    public final Region a(View r7, Region r8) {
        if (r7 != null) goto L13;
        return null;
    L13:
        Method r0 = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);     // Catch: Exception -> L10
        r0.setAccessible(true);     // Catch: Exception -> L10
        Object r9 = r0.invoke(r7, new Object[0]);     // Catch: Exception -> L10
        if (r9 == null) goto L12;
        if (r8 == null) goto L12;
        Method r1 = r9.getClass().getDeclaredMethod("setTouchableRegion", new Class[]{Region.class});     // Catch: Exception -> L10
        r1.setAccessible(true);     // Catch: Exception -> L10
        r1.invoke(r9, new Object[]{r8});     // Catch: Exception -> L10
    L12:
        return null;
    L10:
        e = move-exception;
        Log.e("HideApiHelper", "Failed to set touchable region with region", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L12
    }

    public final void a(SurfaceView r9) {
        Method r0 = SurfaceView.class.getDeclaredMethod("getSurfaceControl", new Class[0]);     // Catch: Exception -> L10
        r0.setAccessible(true);     // Catch: Exception -> L10
        Object r10 = r0.invoke(r9, new Object[0]);     // Catch: Exception -> L10
        if (ZeusTransformUtils.instanceOf(r10, SurfaceControl.class) == false) goto L6;
        SurfaceControl r11 = (SurfaceControl) ZeusTransformUtils.preCheckCast(r10, SurfaceControl.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L10
    L7:
        if (r11 == null) goto L15;
        SurfaceControl.Transaction r1 = new SurfaceControl.Transaction();     // Catch: Exception -> L10
        Method r3 = SurfaceControl.Transaction.class.getDeclaredMethod("setTrustedOverlay", new Class[]{SurfaceControl.class, Boolean.TYPE});     // Catch: Exception -> L10
        r3.setAccessible(true);     // Catch: Exception -> L10
        r3.invoke(r1, new Object[]{r11, true});     // Catch: Exception -> L10
        r1.apply();     // Catch: Exception -> L10
        return;
    L15:
        return;
    L6:
        r11 = null;
    L10:
        e = move-exception;
        Log.e("HideApiHelper", "Failed to set surface view", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }
}
