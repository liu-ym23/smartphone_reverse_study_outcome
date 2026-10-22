package j1;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.ai.applet.render.core.RenderType;
import com.bytedance.ai.model.widgets.s;
import com.bytedance.ies.bullet.ui.common.BulletContainerView;
import com.ivy.ivykit.plugin.impl.web.h;
import com.ivy.ivykit.plugin.impl.web.j;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import m1.i;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements g1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f18224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a1.c f18225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g1.d f18226c;
    public final h d;
    public WebView e;
    public boolean f;

    public e(Context r11, String r12) {
        this.f18224a = r11;
        this.f18225b = new a1.c("WebRenderView");
        this.f18226c = new g1.d();
        this.d = new h("schema", new j(r12, "schema", new r6.a(this), new s(this, 1), new b(this), new c(this), new d(this), null), r11);
    }

    @Override // g1.b
    public final View a() {
        return this.e;
    }

    @Override // g1.b
    public final void b() {
        this.f18226c.f = null;
    }

    @Override // g1.b
    public final void c() {
        this.f18226c.e = null;
    }

    @Override // g1.b
    public final View d() {
        BulletContainerView r5 = this.d.f9542a;
        Intrinsics.checkNotNull(r5);
        return r5;
    }

    @Override // g1.b
    public final void destroy() {
        this.f18225b.a("will destroy");
        new Handler(Looper.getMainLooper()).postDelayed(new com.obric.oui.lisitem.a(this, 11), 2000);
    }

    @Override // g1.b
    public final boolean e() {
        return false;
    }

    @Override // g1.b
    public final i getBridge() {
        return this.f18226c.f17015a;
    }

    @Override // g1.b
    public final g1.d getComposition() {
        throw null;
    }

    @Override // g1.b
    public final RenderType getRenderType() {
        return RenderType.f1752c;
    }

    @Override // g1.b
    public final void setGlobalProperties(Map r5) {
        Intrinsics.checkNotNullParameter(r5, "props");
        g1.d r10 = this.f18226c;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r10.f17016b = r5;
    }

    @Override // g1.b
    public final void setOnTouchEventListener(g1.a r5) {
        Intrinsics.checkNotNullParameter(r5, "listener");
        this.f18226c.f = r5;
    }

    @Override // g1.b
    public final void setReused(boolean r5) {
    }

    @Override // g1.b
    public final void setViewClient(g1.c r5) {
        Intrinsics.checkNotNullParameter(r5, "client");
        this.f18226c.e = r5;
    }

    @Override // g1.b
    public final void setViewContext(Map r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        g1.d r10 = this.f18226c;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r10.f17017c = r5;
    }

    @Override // g1.b
    public final void setViewData(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        g1.d r10 = this.f18226c;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r10.d = r5;
    }

    @Override // g1.b
    public final Object a(String r5, JSONObject r10, ContinuationImpl r11) {
        this.d.a(r5);
        return Unit.INSTANCE;
    }

    @Override // g1.b
    public final void a(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        AtomicInteger r10 = a1.c.f44c;
        this.f18225b.b("reload is not supported", null);
    }
}
