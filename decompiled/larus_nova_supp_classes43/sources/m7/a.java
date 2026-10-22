package m7;

import android.view.View;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.param.AnnieXLiveContext;
import com.bytedance.android.anniex.container.AnnieXContainer;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import ia.d;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a extends com.bytedance.android.anniex.base.lifecycle.a {
    public final AnnieXLiveContext a;
    public final com.bytedance.android.anniex.base.lifecycle.a b;
    public final b7.b c;
    public ia.c d;

    /* JADX INFO: renamed from: m7.a$a, reason: collision with other inner class name */
    public static final class C0180a {
    }

    static {
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.a
    public final void j(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        this.b.j(r10);
        HybridLogger r0 = HybridLogger.a;
        k7.a.b("AnnieXLifeCycle", "===onRelease: ".concat(r10), this.a);
        b7.b r11 = this.c;
        if (r11 == null) goto L6;
        r11.onRelease();
        return;
    }

    public a(AnnieXLiveContext r10, com.bytedance.android.anniex.base.lifecycle.a r11) {
        Intrinsics.checkNotNullParameter(r11, "containerLifeCycle");
        this.a = r10;
        this.b = r11;
        if (r10 == null) goto L5;
        b7.b r12 = r10.getCommonLifecycle();
    L6:
        this.c = r12;
        return;
    L5:
        r12 = null;
        goto L6
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.a
    public final void a(String r10, ia.c r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r11, "container");
        super.a(r10, r11);
        this.b.a(r10, r11);
        View r12 = r11.getKitView();
        if (r12 == null) goto L12;
        b7.b r0 = this.c;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r11.getKitType() != KitType.LYNX) goto L9;
        IHybridComponent.HybridType r1 = IHybridComponent.HybridType.LYNX;
    L10:
        r0.onAttachView(r12, r1, r11.getViewType());
        return;
    L9:
        r1 = IHybridComponent.HybridType.H5;
        goto L10
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.a
    public final void b(int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "errorMessage");
        Intrinsics.checkNotNullParameter(r11, "errorMessage");
        this.b.b(r10, r11);
        b7.b r0 = this.c;
        View r1 = null;
        if (r0 == null) goto L5;
        r0.onContainerError(null, r10, r11);
    L5:
        HybridLogger r12 = HybridLogger.a;
        HybridLogger.i("AnnieXLifeCycle", "message: ".concat(r11), null, 12);
        ExecutorService r13 = com.bytedance.ies.bullet.service.monitor.a.a;
        ia.c r14 = this.d;
        if (r14 == null) goto L8;
        r1 = r14.getKitView();
    L8:
        ia.c r15 = this.d;
        if (r15 == null) goto L12;
        String r16 = r15.getContainerId();
        if (r16 == null) goto L12;
    L13:
        com.bytedance.ies.bullet.service.monitor.a.d(r1, r16, this.d + " onContainerError fail:" + r11);
        return;
    L12:
        r16 = "";
        goto L13
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.a
    public final void e(String r10, ia.c r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r11, "container");
        super.e(r10, r11);
        this.b.e(r10, r11);
        b7.b r12 = this.c;
        if (r12 == null) goto L5;
        r12.onPrepareComponentEnd();
    L5:
        HybridLogger r13 = HybridLogger.a;
        k7.a.b("AnnieXLifeCycle", "===onKitViewCreate: ".concat(r10), this.a);
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.a
    public final void f(String r10, ia.c r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r11, "container");
        super.f(r10, r11);
        this.b.f(r10, r11);
        HybridLogger r12 = HybridLogger.a;
        k7.a.b("AnnieXLifeCycle", "===onKitViewDestroy: ".concat(r10), this.a);
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.a
    public final void h(String r10, ia.c r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r11, "container");
        super.h(r10, r11);
        this.b.h(r10, r11);
        b7.b r12 = this.c;
        if (r12 == null) goto L5;
        r12.onPrepareComponentStart();
    L5:
        HybridLogger r13 = HybridLogger.a;
        k7.a.b("AnnieXLifeCycle", "===onLoadStart: ".concat(r10), this.a);
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.a
    public final void i(String r10, ia.c r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r11, "container");
        super.i(r10, r11);
        this.b.i(r10, r11);
        r11.hideError();
        HybridLogger r12 = HybridLogger.a;
        k7.a.b("AnnieXLifeCycle", "===onLoadSuccess: ".concat(r10), this.a);
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.a
    public final void k(String r10, ia.c r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r11, "container");
        super.k(r10, r11);
        this.b.k(r10, r11);
        HybridLogger r12 = HybridLogger.a;
        k7.a.b("AnnieXLifeCycle", "===onRuntimeReady: ".concat(r10), this.a);
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.a
    public final void c(String r10, AnnieXContainer r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r11, "container");
        Intrinsics.checkNotNullParameter(r12, "throwable");
        super.c(r10, r11, r12);
        this.b.c(r10, r11, r12);
        if ((r11 instanceof d) == true) goto L10;
        b7.b r13 = this.c;
        if (r13 == null) goto L10;
        String r0 = r12.getMessage();
        if (r0 != null) goto L9;
        r0 = "unknow message";
    L9:
        r13.onFallback(500, r0);
    L10:
        ExecutorService r14 = com.bytedance.ies.bullet.service.monitor.a.a;
        com.bytedance.ies.bullet.service.monitor.a.d(null, r11.getContainerId(), "AnnieXLiveFragment onFallback: " + r12.getMessage());
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.a
    public final void g(String r10, ia.c r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r11, "container");
        Intrinsics.checkNotNullParameter(r12, "throwable");
        super.g(r10, r11, r12);
        this.b.g(r10, r11, r12);
        b7.b r0 = this.c;
        if (r0 == null) goto L5;
        r0.onLoadFail(r11.getKitView(), r10, "AnnieXLiveCard onLoadFailed:" + r12.getMessage());
    L5:
        HybridLogger r1 = HybridLogger.a;
        k7.a.b("AnnieXLifeCycle", "===onLoadFail: throwable is " + r12.getMessage() + ' ' + r10, this.a);
        ExecutorService r13 = com.bytedance.ies.bullet.service.monitor.a.a;
        com.bytedance.ies.bullet.service.monitor.a.d(r11.getKitView(), r11.getContainerId(), "AnnieXLiveCard onLoadFailed:" + r12.getMessage());
    }
}
