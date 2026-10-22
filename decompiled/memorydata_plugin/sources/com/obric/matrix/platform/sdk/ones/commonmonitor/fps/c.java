package com.obric.matrix.platform.sdk.ones.commonmonitor.fps;

import android.os.SystemClock;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\r\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/FPSSceneMonitor;", "", MemoryInfoSectionEditActivity.KIND_SCENE, "", "forceCollect", "", "fpsCallBack", "Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/IFPSCallBack;", "(Ljava/lang/String;ZLcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/IFPSCallBack;)V", "mFpsBean", "Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/FpsBean;", "mFpsTracer", "Lcom/bytedance/apm/trace/fps/FpsTracer;", CommonConsts.APM_INNER_EVENT_COST_START, "", "", "stop", "Companion", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8089a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8090b;
    private final boolean c;
    private final e d;
    private final com.bytedance.apm.trace.fps.b e;
    private d f;
    private long g;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/FPSSceneMonitor$Companion;", "", "()V", "TAG", "", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8089a = new a(null);
    }

    public c(String r3, boolean r4, e r5) {
        e r6 = (e) ZeusTransformUtils.wrapperContextForParams(r5, e.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, MemoryInfoSectionEditActivity.KIND_SCENE);
        this.f8090b = r3;
        this.c = r4;
        this.d = r6;
        com.bytedance.apm.trace.fps.b r7 = new com.bytedance.apm.trace.fps.b(r3, r4);
        this.e = r7;
        r7.a((com.bytedance.apm.trace.fps.b.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), com.bytedance.apm.trace.fps.b.d.class, "com.obric.memorydata.plugin"));
        r7.a((com.bytedance.apm.trace.fps.b.c) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this), com.bytedance.apm.trace.fps.b.c.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ d a(c r0) {
        return r0.f;
    }

    public static final /* synthetic */ void a(c r0, long r1) {
        r0.g = r1;
    }

    public static final /* synthetic */ void a(c r0, d r1) {
        r0.f = r1;
    }

    public static final /* synthetic */ String b(c r0) {
        return r0.f8090b;
    }

    public static final /* synthetic */ e c(c r0) {
        return r0.d;
    }

    public final void a() {
        if (this.g <= 0) goto L6;
        com.obric.matrix.platform.sdk.ones.internal.b.b.c("FPSSceneMonitor", "start: already start", null, 4, null);
        return;
    L6:
        this.g = SystemClock.elapsedRealtime();
        this.e.a();
    }

    public final void b() {
        if (this.g > 0) goto L6;
        com.obric.matrix.platform.sdk.ones.internal.b.b.c("FPSSceneMonitor", "stop: not start", null, 4, null);
        return;
    L6:
        d r0 = d.f8093a.a();
        r0.a(SystemClock.elapsedRealtime() - this.g);
        this.f = r0;
        this.e.b();
        this.g = 0;
    }
}
