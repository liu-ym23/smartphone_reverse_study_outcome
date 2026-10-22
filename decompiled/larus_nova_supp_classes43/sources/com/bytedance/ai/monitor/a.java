package com.bytedance.ai.monitor;

import android.view.View;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.monitor.bridge.BridgeType;
import com.ivy.ivykit.api.bridge.c;
import com.ivy.ivykit.api.bridge.e;
import java.util.Map;
import k5.g;
import k5.i;
import kotlin.jvm.internal.Intrinsics;
import l5.w;
import l5.y;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements e {

    /* JADX INFO: renamed from: com.bytedance.ai.monitor.a$a, reason: collision with other inner class name */
    public static final class C0045a implements i {
        public final /* synthetic */ String a;
        public final /* synthetic */ c b;

        @Override // k5.i
        public final void a(AppletJSBEvent r10) {
            Intrinsics.checkNotNullParameter(r10, "event");
            r10.f = this.a;
            AppletJSBEvent.JSBType r0 = AppletJSBEvent.JSBType.XBridge;
            Intrinsics.checkNotNullParameter(r0, "<set-?>");
            r10.m = r0;
            Map r1 = this.b.d;
            if (r1 == null) goto L5;
            JSONObject r11 = new JSONObject(r1);
        L6:
            r10.p = r11;
            c r12 = this.b;
            String r13 = r12.e;
            r10.n = r12.f;
            r10.o = r12.g;
            r10.q = r12.h;
            return;
        L5:
            r11 = null;
            goto L6
        }

        public C0045a(String r1, c r10) {
            this.a = r1;
            this.b = r10;
        }
    }

    public a() {
    }

    public final void b(c r10) {
        Intrinsics.checkNotNullParameter(r10, "call");
        String r0 = b.e.remove(r10.a);
        if (r0 == null) goto L6;
        final String r11 = r10.b;
        final int r12 = r10.c;
        final C0045a r13 = new C0045a(r0, r10);
        Intrinsics.checkNotNullParameter(r11, "bridgeName");
        Intrinsics.checkNotNullParameter(r13, "builder");
        final long r14 = System.currentTimeMillis();
        b.e(new g(r11, r12, r13, r14));
        w r1 = w.b;
        String r15 = r10.b;
        BridgeType r16 = BridgeType.XBridge;
        Intrinsics.checkNotNullParameter(r15, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r16, "type");
        b.b("applet_old_bridge", new y(r15, r16, r0, r10));
        return;
    }

    public final void a(String r10, View r11) {
        Intrinsics.checkNotNullParameter(r10, "callId");
        AppletRuntimeManager.INSTANCE.getClass();
        k2.i r12 = AppletRuntimeManager.d(r11);
        if (r12 == null) goto L8;
        String r13 = r12.getAppletId();
        if (r13 == null) goto L9;
        b.e.put(r10, r13);
        return;
    L9:
        return;
    }
}
