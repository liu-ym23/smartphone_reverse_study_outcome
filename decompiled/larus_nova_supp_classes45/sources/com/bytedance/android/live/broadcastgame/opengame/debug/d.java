package com.bytedance.android.live.broadcastgame.opengame.debug;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.live.broadcastgame.api.openplatform.PluginType;
import com.bytedance.android.live.broadcastgame.opengame.q;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d {
    public static final /* synthetic */ int c = 0;
    public boolean a;
    public OpenPlatformBaseDebugger b;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.live.broadcastgame.opengame.i.a {
        public final /* synthetic */ d a;

        @Override // com.bytedance.android.live.broadcastgame.opengame.i.a
        public final void onInitSuccess() {
            d.b(this.a);
        }

        public b(d r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.broadcastgame.opengame.i.a
        public final void a(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "throwable");
            d.a(this.a, r2);
        }
    }

    static {
    }

    public d() {
    }

    public static final void b(d r2) {
        r2.a = true;
        int r0 = q.a;
        StringBuilder r1 = new StringBuilder("debugger 初始化成功，类型：");
        OpenPlatformBaseDebugger r3 = r2.b;
        if (r3 == null) goto L5;
        String r4 = r3.getClass().getName();
    L6:
        r1.append(r4);
        q.g(r1.toString(), "OP_Debugger_Provider");
        return;
    L5:
        r4 = null;
        goto L6
    }

    public static final void a(d r1, Throwable r2) {
        r1.a = false;
        OpenPlatformBaseDebugger r3 = r1.b;
        if (r3 == null) goto L6;
        r3.releaseDebug();
    L6:
        if ((!Intrinsics.areEqual(r2.getMessage(), "OpenPlatformMiniAppDebugger 初始化失败。原因：小程序观众端不需要 debugger")) == false) goto L9;
        q.j(r2, "OP_Debugger_Provider", 4);
        return;
    }

    public final void c(PluginType r9, Context r11, DataCenter r12, ViewGroup r13, com.bytedance.android.live.broadcastgame.api.openplatform.b r14, Map<String, ? extends Object> r15) {
        Intrinsics.checkNotNullParameter(r9, "pluginType");
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "dataCenter");
        Intrinsics.checkNotNullParameter(r13, "containerView");
        Intrinsics.checkNotNullParameter(r14, "gameManager");
        Intrinsics.checkNotNullParameter(r15, "extraParams");
        OpenPlatformBaseDebugger r0 = this.b;
        if (r0 == null) goto L5;
        r0.releaseDebug();
    L5:
        OpenPlatformBaseDebugger r1 = null;
        this.b = null;
        this.a = false;
        int r2 = e.a[r9.ordinal()];
        if (r2 != 1) goto L8;
    L13:
        r1 = new OpenPlatformLiveGameDebugManager();
    L14:
        OpenPlatformBaseDebugger r3 = r1;
        this.b = r3;
        if (r3 == null) goto L17;
        r3.initDebug(r11, r12, r13, r14, r15, new b(this));
        return;
    L17:
        int r16 = q.a;
        q.j(new Throwable("开平 debugger 创建失败，原因：没有适配的 debugger。"), "OP_Debugger_Provider", 4);
        return;
    L8:
        if (r2 == 2) goto L13;
        if (r2 != 3) goto L14;
        OpenPlatformMiniAppDebugger r4 = new OpenPlatformMiniAppDebugger();
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r4.f = r9;
        Unit r17 = Unit.INSTANCE;
        r1 = r4;
        goto L14
    }
}
