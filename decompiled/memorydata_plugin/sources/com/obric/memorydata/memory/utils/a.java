package com.obric.memorydata.memory.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.TypedValue;
import android.view.WindowManager;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0015\u001a\u00020\u0005J\u0006\u0010\u0016\u001a\u00020\u0005J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0011R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u00020\u000f8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\t\u001a\u0004\b\u0013\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/memory/utils/AssistantWindowUtils;", "", "<init>", "()V", "bottomWindowMarginForSlideDismiss", "", "getBottomWindowMarginForSlideDismiss", "()I", "bottomWindowMarginForSlideDismiss$delegate", "Lkotlin/Lazy;", "extendedHeight", "getExtendedHeight", "setExtendedHeight", "(I)V", "wm", "Landroid/view/WindowManager;", "outSize", "Landroid/graphics/Point;", "bottomSlideDismissDistance", "getBottomSlideDismissDistance", "bottomSlideDismissDistance$delegate", "getWindowHeight", "getWindowWidth", "isPortrait", "", "getScreenSize", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11530a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f11531b = null;
    private static int c;
    private static final WindowManager d = null;
    private static final Point e = null;
    private static final Lazy f = null;

    static {
        f11530a = new a();
        f11531b = LazyKt.lazy($$Lambda$a$_WcAA3MecuOdc2Ku2FfpEzVcY64.INSTANCE);
        c = MathKt.roundToInt(TypedValue.applyDimension(1, 54, Resources.getSystem().getDisplayMetrics()));
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("window");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager r1 = (WindowManager) ZeusTransformUtils.preCheckCast(r0, WindowManager.class, "com.obric.memorydata.plugin");
        d = r1;
        Point r2 = new Point();
        r1.getDefaultDisplay().getRealSize(r2);
        e = r2;
        f = LazyKt.lazy($$Lambda$a$bcBzEGMMrmnhGkJgb8xY6SMbnYE.INSTANCE);
    }

    private a() {
    }

    private static final int c() {
        return x.a((Number) ZeusTransformUtils.preCheckCast(20, Number.class, "com.obric.memorydata.plugin"));
    }

    private static final int d() {
        a r0 = f11530a;
        return c + r0.a();
    }

    public static /* synthetic */ int lambda$_WcAA3MecuOdc2Ku2FfpEzVcY64() {
        return c();
    }

    public static /* synthetic */ int lambda$bcBzEGMMrmnhGkJgb8xY6SMbnYE() {
        return d();
    }

    public final int a() {
        return ((Number) ZeusTransformUtils.preCheckCast(f11531b.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    public final int b() {
        if (Resources.getSystem().getDisplayMetrics().heightPixels <= Resources.getSystem().getDisplayMetrics().widthPixels) goto L5;
        Point r1 = e;
        return Math.max(r1.x, r1.y);
    L5:
        Point r2 = e;
        return Math.min(r2.x, r2.y);
    }
}
