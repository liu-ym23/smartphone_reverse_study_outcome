package c3;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.applet.render.core.relax.monitor.RelaxViewMonitorModule;
import com.bytedance.ai.settings.AISDKSettingConfigManager;
import com.relax.RelaxView;
import com.relax.RuntimeType;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RelaxView f1114a;

    public c(FragmentActivity r5, RelaxView r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "relaxView");
        this.f1114a = r10;
        r10.registerBridgeModule("hybridMonitor", new RelaxViewMonitorModule(r10));
    }

    public final void a() {
        b r5 = new b();
        this.f1114a.setRelaxViewClient(r5);
    }

    public final void b(f9.a r5) {
        Intrinsics.checkNotNullParameter(r5, "listener");
        a r10 = new a();
        this.f1114a.SetRedirectListener(r10);
    }

    public final void c(String r5, byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "buffer");
        Intrinsics.checkNotNullParameter(r5, "url");
        this.f1114a.loadFile(r10, r5);
    }

    public final void d(Map r5) {
        Intrinsics.checkNotNullParameter(r5, "props");
        this.f1114a.setGlobalProps(r5);
    }

    public final void e() {
        this.f1114a.destroy();
    }

    public final void f() {
        this.f1114a.onEnterBackground();
    }

    public final void g() {
        this.f1114a.onEnterForeground();
    }

    public /* synthetic */ c(FragmentActivity r10) {
        this(r10, new RelaxView(r10, e.a(AISDKSettingConfigManager.INSTANCE.getRELAX_CONFIG().getValue().c()), RuntimeType.RuntimeTypeVM, true, true, null));
    }
}
