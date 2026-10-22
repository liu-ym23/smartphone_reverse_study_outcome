package com.bytedance.android.live.ktv.common.view;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.util.u;
import com.bytedance.android.livehostapi.business.view.ISurfaceViewService;
import com.bytedance.common.utility.DeviceUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.reflect.Field;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0018B\u001d\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/ktv/common/view/ContinuousSurfaceAdapterView;", "Landroid/view/SurfaceView;", "Landroid/view/SurfaceHolder$Callback;", "Lcom/bytedance/android/live/ktv/common/util/u;", "Landroid/graphics/Rect;", "getSurfaceViewPos", "", "visible", "", "setBusinessVisible", "Landroid/view/SurfaceHolder;", "c", "Landroid/view/SurfaceHolder;", "getSurfaceHolder", "()Landroid/view/SurfaceHolder;", "setSurfaceHolder", "(Landroid/view/SurfaceHolder;)V", "surfaceHolder", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class ContinuousSurfaceAdapterView extends SurfaceView implements SurfaceHolder.Callback, u {
    public boolean a;
    public boolean b;
    public SurfaceHolder c;
    public int d;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ ContinuousSurfaceAdapterView a;

        public b(ContinuousSurfaceAdapterView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ContinuousSurfaceAdapterView.a(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    private final Rect getSurfaceViewPos() {
        Class<? super Object> r1 = getClass().getSuperclass();     // Catch: Exception -> L16
        if (r1 == null) goto L6;
        Field r2 = r1.getDeclaredField("mRTLastReportedPosition");     // Catch: Exception -> L16
    L7:
        if (r2 == null) goto L9;
        r2.setAccessible(true);     // Catch: Exception -> L16
    L9:
        if (r2 == null) goto L11;
        Object r3 = r2.get(this);     // Catch: Exception -> L16
    L12:
        if (r3 == null) goto L15;
        return (Rect) r3;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");     // Catch: Exception -> L16
    L11:
        r3 = null;
        goto L12
    L6:
        r2 = null;
    L16:
        e = move-exception;
        e.toString();
        return null;
    }

    public final void c() {
        setZOrderOnTop(true);
        getHolder().setFormat(-3);
        SurfaceHolder r0 = getHolder();
        this.c = r0;
        if (r0 == null) goto L5;
        r0.addCallback(this);
    L5:
        ISurfaceViewService r1 = k.f(ISurfaceViewService.class);
        if (r1 == null) goto L9;
        r1.fixPositionChangedCrash("ktv", this);
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.util.u
    public final void onVHPaused() {
        this.b = true;
    }

    @Override // com.bytedance.android.live.ktv.common.util.u
    public final void onVHResume() {
        this.b = false;
    }

    @Override // com.bytedance.android.live.ktv.common.util.u
    public final void onVHSelected() {
        this.a = true;
    }

    @Override // com.bytedance.android.live.ktv.common.util.u
    public final void onVHUnBind() {
        this.a = false;
        this.b = false;
    }

    @Override // com.bytedance.android.live.ktv.common.util.u
    public final void onVHUnSelected() {
        this.a = false;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder r1, int r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "holder");
    }

    private final void b() {
        Rect r0 = getSurfaceViewPos();
        int r1 = DeviceUtils.getScreenWidth(getContext());
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.centerX() >= r1) goto L13;
        setVisibility(8);
        if (Build.VERSION.SDK_INT < 33) goto L9;
        return;
    L9:
        if (this.d != 0) goto L15;
        setVisibility(0);
        return;
    L15:
        return;
    }

    public final SurfaceHolder getSurfaceHolder() {
        return this.c;
    }

    @Override // com.bytedance.android.live.ktv.common.util.u
    public final boolean isVHPaused() {
        return this.b;
    }

    @Override // com.bytedance.android.live.ktv.common.util.u
    public final boolean isVHSelected() {
        return this.a;
    }

    public ContinuousSurfaceAdapterView(Context r2) {
        this(r2, null);
    }

    public static final /* synthetic */ void a(ContinuousSurfaceAdapterView r0) {
        r0.b();
    }

    @Override // com.bytedance.android.live.ktv.common.util.u
    public final void attachFromWindow(String r3) {
        Intrinsics.checkNotNullParameter(r3, "log");
        ALogger.i("SurfaceAdapterView", name() + ", attachFromWindow: msg=" + r3);
        if (getVisibility() != 0) goto L5;
        return;
    L5:
        if (this.d != 0) goto L9;
        setVisibility(0);
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.util.u
    public final void detachFromWindow(String r3) {
        Intrinsics.checkNotNullParameter(r3, "log");
        if (getVisibility() != 8) goto L5;
        return;
    L5:
        setVisibility(8);
        ALogger.i("SurfaceAdapterView", name() + ", detachFromWindow: msg=" + r3);
        b();
        postDelayed(new b(this), 100);
    }

    public void setBusinessVisible(int r1) {
        this.d = r1;
    }

    public final void setSurfaceHolder(SurfaceHolder r1) {
        this.c = r1;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder r3) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        if (Build.VERSION.SDK_INT >= 33) goto L6;
        return;
    L6:
        if (this.a == true) goto L11;
        postDelayed(new c(this), 100);
        return;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        detachFromWindow("surfaceDestroyed");
    }

    public ContinuousSurfaceAdapterView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        c();
    }
}
