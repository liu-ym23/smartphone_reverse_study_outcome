package com.obric.memorydata.recommend.statusbar;

import android.app.StatusBarManager;
import android.content.Context;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.utils.ao;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.cu;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.k;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0014H\u0002J\b\u0010\u0019\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/recommend/statusbar/StatusBarController;", "", "<init>", "()V", "TAG", "", "SLOT", "ICON_EYE_ID", "", "ICON_EYE_SILENT_ID", "statusBarManager", "Landroid/app/StatusBarManager;", "kotlin.jvm.PlatformType", "getStatusBarManager", "()Landroid/app/StatusBarManager;", "statusBarManager$delegate", "Lkotlin/Lazy;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "screenObservationEnable", "", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "refreshIcon", "isSecure", "hideIcon", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12632a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f12633b = 0;
    private static final int c = 0;
    private static final Lazy d = null;
    private static final al e = null;
    private static boolean f;

    static {
        f12632a = new a();
        f12633b = ZeusTransformUtils.mapRes(R.drawable.ic_memory_screen_observation_status_observe, "drawable", "ic_memory_screen_observation_status_observe");
        c = ZeusTransformUtils.mapRes(R.drawable.ic_memory_screen_observation_status_silent_inset, "drawable", "ic_memory_screen_observation_status_silent_inset");
        d = LazyKt.lazy($$Lambda$a$rCda2CuWFPcFv3UsllpR8NYeQrw.INSTANCE);
        e = am.a(ba.b().plus((CoroutineContext) ZeusTransformUtils.preCheckCast(cu.a(null, 1, null), CoroutineContext.class, "com.obric.memorydata.plugin")));
    }

    private a() {
    }

    public static final /* synthetic */ void a(a r0) {
        r0.c();
    }

    public static final /* synthetic */ void a(a r0, boolean r1) {
        r0.b(r1);
    }

    public static final /* synthetic */ void a(boolean r0) {
        f = r0;
    }

    private final StatusBarManager b() {
        return (StatusBarManager) ZeusTransformUtils.preCheckCast(d.getValue(), StatusBarManager.class, "com.obric.memorydata.plugin");
    }

    private final void b(boolean r5) {
        if (r5 == false) goto L4;
        int r6 = c;     // Catch: Exception -> L7
    L5:
        ao.call(b(), "setIcon", new Object[]{"screen_observation", Integer.valueOf(r6), 0, "Screen Observation"});     // Catch: Exception -> L7
        return;
    L4:
        r6 = f12633b;     // Catch: Exception -> L7
    L7:
        e = move-exception;
        RunLog.INSTANCE.error("StatusBarController", "showIcon: ", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final void c() {
        ao.call(b(), "removeIcon", new Object[]{"screen_observation"});     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        RunLog.INSTANCE.error("StatusBarController", "hideIcon: ", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private static final StatusBarManager d() {
        return (StatusBarManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService(StatusBarManager.class), StatusBarManager.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ StatusBarManager lambda$rCda2CuWFPcFv3UsllpR8NYeQrw() {
        return d();
    }

    public final void a() {
        i r4 = k.f((i) ZeusTransformUtils.preCheckCast(com.obric.memorydata.recommend.feature.a.f12505a.b(), i.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new StatusBarController$init$1(null), Function2.class, "com.obric.memorydata.plugin"));
        al r0 = e;
        k.b(r4, r0);
        k.b(k.f((i) ZeusTransformUtils.preCheckCast(com.obric.memorydata.recommend.feature.a.f12505a.a(), i.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new StatusBarController$init$2(null), Function2.class, "com.obric.memorydata.plugin")), r0);
    }
}
