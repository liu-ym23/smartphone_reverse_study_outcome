package com.obric.assistant.appintent;

import android.content.Context;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.google.android.material.card.MaterialCardView;
import com.obric.memorydata.memory.utils.u;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.am;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/appintent/ScreenAnimWindow;", "", "<init>", "()V", "animView", "Lcom/obric/assistant/appintent/CommonProcessingView;", "isShowing", "Ljava/util/concurrent/atomic/AtomicBoolean;", "windowParams", "Landroid/view/WindowManager$LayoutParams;", "windowManager", "Landroid/view/WindowManager;", "showTask", "Ljava/lang/Runnable;", "onActionStart", "", "onActionEnd", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6934a = null;
    private static final String g = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CommonProcessingView f6935b;
    private AtomicBoolean c;
    private final WindowManager.LayoutParams d;
    private WindowManager e;
    private final Runnable f;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0018\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/assistant/appintent/ScreenAnimWindow$Companion;", "", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "Ljava/lang/String;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f6934a = new a(null);
        g = b.class.getSimpleName();
    }

    public b() {
        this.c = new AtomicBoolean(false);
        final Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        WindowManager.LayoutParams r3 = new WindowManager.LayoutParams();
        r3.width = -1;
        r3.height = com.obric.memorydata.memory.utils.a.f11530a.b();
        r3.type = 2038;
        r3.flags = 83886360;
        r3.format = -3;
        r3.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START;
        r3.setTitle((CharSequence) ZeusTransformUtils.preCheckCast("screen_anim_window", CharSequence.class, "com.obric.memorydata.plugin"));
        if (r0 == null) goto L5;
        String r4 = r0.getPackageName();
    L6:
        r3.packageName = r4;
        r3.setFitInsetsTypes(0);
        r3.layoutInDisplayCutoutMode = 1;
        this.d = r3;
        Object r1 = r0.getSystemService("window");
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.view.WindowManager");
        this.e = (WindowManager) ZeusTransformUtils.preCheckCast(r1, WindowManager.class, "com.obric.memorydata.plugin");
        this.f = new $$Lambda$b$o8CzC5Qz1yBfQKTUoEC5JAU4d0(this, r0);
        return;
    L5:
        r4 = null;
        goto L6
    }

    public static final /* synthetic */ CommonProcessingView a(b r0) {
        return r0.f6935b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void a(final b r10, Context r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        RunLog r0 = RunLog.INSTANCE;
        String r8 = g;
        Intrinsics.checkNotNullExpressionValue(r8, "TAG");
        r0.debug(r8, "onActionStart run task");
        if (r10.c.get() == false) goto L7;
        RunLog r13 = RunLog.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r8, "TAG");
        r13.debug(r8, "onActionStart isShowing true, ignore");
        return;
    L7:
        if (r10.f6935b != null) goto L9;
        IRunLog r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r8, "TAG");
        IRunLog.a.a(r2, r8, "onActionStart animView is null", null, 4, null);
        AttributeSet r3 = null;
        r10.f6935b = new CommonProcessingView(r12, r3, 2, 0 == true ? 1 : 0);
    L9:
        r10.c.set(true);
        WindowManager r14 = r10.e;
        if (r14 == null) goto L12;
        r14.addView((View) ZeusTransformUtils.preCheckCast(r10.f6935b, View.class, "com.obric.memorydata.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r10.d, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
    L12:
        CommonProcessingView r15 = r10.f6935b;
        if (r15 == null) goto L15;
        r15.a();
    L15:
        RunLog r16 = RunLog.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r8, "TAG");
        r16.debug(r8, "onActionStart add view and show");
        CommonProcessingView r17 = r10.f6935b;
        if (r17 == null) goto L19;
        r17.post(new $$Lambda$b$y0GQTe62Jb6_K4iQQpoweGiuJo(r10));
        return;
    }

    public static final /* synthetic */ void a(b r0, CommonProcessingView r1) {
        r0.f6935b = r1;
    }

    public static final /* synthetic */ WindowManager b(b r0) {
        return r0.e;
    }

    public static final /* synthetic */ String c() {
        return g;
    }

    public static final /* synthetic */ AtomicBoolean c(b r0) {
        return r0.c;
    }

    private static final void d(b r4) {
        u.f11564a.a((SurfaceView) ZeusTransformUtils.preCheckCast(r4.f6935b, SurfaceView.class, "com.obric.memorydata.plugin"));
        u.f11564a.a((View) ZeusTransformUtils.preCheckCast(r4.f6935b, View.class, "com.obric.memorydata.plugin"), new Region(0, 0, 1, 1));
    }

    /* JADX INFO: renamed from: lambda$o8CzC5Qz1yBfQ-KTUoEC5JAU4d0, reason: not valid java name */
    public static /* synthetic */ void m369lambda$o8CzC5Qz1yBfQKTUoEC5JAU4d0(b r0, Context r1) {
        a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$y0GQTe62Jb6_K4iQQpoweG-iuJo, reason: not valid java name */
    public static /* synthetic */ void m370lambda$y0GQTe62Jb6_K4iQQpoweGiuJo(b r0) {
        d(r0);
    }

    public final void a() {
        RunLog r0 = RunLog.INSTANCE;
        String r1 = g;
        Intrinsics.checkNotNullExpressionValue(r1, "TAG");
        r0.debug(r1, "onActionStart");
        this.f.run();
    }

    public final void b() {
        RunLog r0 = RunLog.INSTANCE;
        String r1 = g;
        Intrinsics.checkNotNullExpressionValue(r1, "TAG");
        r0.debug(r1, "onActionEnd");
        if (this.c.get() == false) goto L6;
        RunLog r2 = RunLog.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r1, "TAG");
        r2.debug(r1, "onActionEnd, isShowing " + this.c.get());
        i.a(am.a(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new ScreenAnimWindow$onActionEnd$1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    }
}
