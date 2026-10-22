package com.bytedance.android.live.core.tetris.layer.core.engine;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.tetris.ComponentManagerFactory$config$1;
import com.bytedance.android.live.core.tetris.layer.core.delegate.ServiceLayerDelegate;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.core.element.service.ServiceElement;
import com.larus.apm.impl.protector.RunnableProtector;
import g70.e;
import j70.d;
import j70.h;
import j70.i;
import j70.p;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public boolean a;
    public final k70.c b;
    public final com.bytedance.android.live.core.tetris.componentx.component.b c;
    public final com.bytedance.android.live.core.tetris.componentx.a d;

    /* JADX INFO: renamed from: com.bytedance.android.live.core.tetris.layer.core.engine.a$a, reason: collision with other inner class name */
    public static final class RunnableC0159a implements Runnable {
        public final /* synthetic */ d a;
        public final /* synthetic */ a b;
        public final /* synthetic */ i70.b c;
        public final /* synthetic */ h70.b d;

        public RunnableC0159a(d r1, a r2, i70.b r3, h70.b r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            if (this.b.a == false) goto L5;
            return;
        L5:
            long r0 = System.currentTimeMillis();
            ALogger.i("ServiceLayerEngineV2", " OPT_____ [ServiceLayerEngine] load " + this.a.C(this.d) + " state:[" + this.b.a(this.c, this.a, this.d) + "] takes " + (System.currentTimeMillis() - r0) + "ms");
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public a(e r2, com.bytedance.android.live.core.tetris.componentx.component.b r3, ComponentManagerFactory$config$1 r4) {
        Intrinsics.checkNotNullParameter(r2, "elementFactory");
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean a(i70.b r5, d<h70.b> r6, h70.b r7) {
        Intrinsics.checkNotNullParameter(r5, "layer");
        Intrinsics.checkNotNullParameter(r6, "descriptor");
        Intrinsics.checkNotNullParameter(r7, "layerContext");
        if (this.a == false) goto L6;
        return false;
    L6:
        if (r5.f2(r6.C(r7)) == null) goto L9;
        return false;
    L9:
        if ((r6 instanceof i) == false) goto L11;
    L13:
        Element<?> r0 = this.b.a(r6.C(r7), (j70.e) r6);
        if ((r0 instanceof ServiceElement) == true) goto L16;
        return false;
    L16:
        com.bytedance.android.live.core.tetris.componentx.component.b r1 = this.c;
        if (r1 == null) goto L20;
        r1.a(r0);
    L20:
        if ((r6 instanceof h) == false) goto L25;
        Map<String, String> r2 = r0.g;
        if (r2 != null) goto L24;
        r2 = new LinkedHashMap();
    L24:
        HashMap<String, String> r3 = p.a;
        r2.put("widget_level", p.a(((h) r6).H(r7)));
        r0.setExtraInfo(r2);
    L25:
        Intrinsics.checkNotNullParameter(r0, "element");
        ServiceLayerDelegate r8 = r5.a;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r0, "element");
        r8.d.put(r0.d, r0);
        com.bytedance.android.live.core.tetris.componentx.component.b r9 = this.c;
        if (r9 == null) goto L28;
        r9.f(r0);
    L28:
        Intrinsics.checkNotNullParameter(r0, "element");
        r5.a.b(r0);
        return true;
    L11:
        if ((r6 instanceof e70.b) == true) goto L13;
        return false;
    }

    public final void b(i70.b r8, h70.b r9, boolean r11) {
        Intrinsics.checkNotNullParameter(r8, "layer");
        Intrinsics.checkNotNullParameter(r9, "layerContext");
        if (this.a == false) goto L5;
        return;
    L5:
        h70.c.a();
        System.currentTimeMillis();
        if (r11 == true) goto L8;
    L17:
        Iterator<T> r12 = r8.a.e.iterator();
    L19:
        if (r12.hasNext() == false) goto L21;
        d<h70.b> r0 = (d) r12.next();
        long r1 = System.currentTimeMillis();
        ALogger.i("ServiceLayerEngineV2", " No opt  ____ [ServiceLayerEngine] load " + r0.C(r9) + " state:[" + a(r8, r0, r9) + "] takes " + (System.currentTimeMillis() - r1) + "ms");
    L21:
        int r13 = h70.c.a;
        System.currentTimeMillis();
        h70.c.a();
        return;
    L8:
        if (LiveInfraSettingKeys.LIVE_COMPONENT_SERVICE_OPT_ENABLE.getValue().booleanValue() == false) goto L17;
        Iterator<T> r14 = r8.a.e.iterator();
    L11:
        if (r14.hasNext() == false) goto L21;
        RunnableC0159a r2 = new RunnableC0159a((d) r14.next(), this, r8, r9);
        com.bytedance.android.live.core.tetris.componentx.a r3 = this.d;
        if (r3 == null) goto L11;
        Function1<Runnable, Unit> r4 = r3.d();
        if (r4 == null) goto L11;
        Unit r5 = (Unit) r4.invoke(r2);
        goto L11
    }
}
