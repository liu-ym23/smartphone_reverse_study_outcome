package com.bytedance.ai.model;

import android.content.Context;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.monitor.bridge.BridgeType;
import com.bytedance.vmsdk.jsbridge.JSModule;
import com.bytedance.vmsdk.jsbridge.utils.Callback;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u000f8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ai/model/AppletJSModule;", "Lcom/bytedance/vmsdk/jsbridge/JSModule;", "Landroid/content/Context;", "context", "", "appletRuntime", "<init>", "(Landroid/content/Context;Ljava/lang/Object;)V", "Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;", "message", "Lcom/bytedance/vmsdk/jsbridge/utils/Callback;", "callback", "", "appletPostMessage", "(Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;Lcom/bytedance/vmsdk/jsbridge/utils/Callback;)V", "", "log", "(Ljava/lang/String;)V", "schema", "", "canIUse", "(Ljava/lang/String;)Z", "TAG", "Ljava/lang/String;", "Companion", "com/bytedance/ai/model/a", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AppletJSModule extends JSModule {
    public static final a Companion = null;
    public static final String NAME = "AppletJSModule";
    private final String TAG;

    static {
        Companion = new a();
    }

    public AppletJSModule(Context r5, Object r10) {
        Intrinsics.checkNotNullParameter(r10, "appletRuntime");
        super(r5, r10);
        this.TAG = NAME;
    }

    @com.bytedance.vmsdk.jsbridge.b
    public final void appletPostMessage(ReadableMap r10, Callback r11) {
        Intrinsics.checkNotNullParameter(r10, "message");
        Intrinsics.checkNotNullParameter(r11, "callback");
        Object r12 = this.mParam;
        if ((r12 instanceof AppletRuntime) == false) goto L5;
        AppletRuntime r13 = (AppletRuntime) r12;
    L6:
        a3.i r5 = a3.i.f83a;
        if (r13 == null) goto L11;
        Applet r14 = r13.f2197h;
        if (r14 == null) goto L11;
        String r15 = r14.i();
    L12:
        BridgeType r16 = BridgeType.f2387b;
        Intrinsics.checkNotNullParameter("appletPostMessageWorker", "name");
        Intrinsics.checkNotNullParameter(r16, "type");
        z2.d.b("applet_old_bridge", new com.bytedance.ies.web.jsbridge2.p(1, "appletPostMessageWorker", r16, r15, null));
        String r17 = r10.getString("viewId");
        String r18 = ((JavaOnlyMap) r10).a().toString();
        if (r13 == null) goto L15;
        Intrinsics.checkNotNull(r17);
        int r19 = AppletRuntime.f2196x;
        Intrinsics.checkNotNullParameter(r17, "viewId");
        Intrinsics.checkNotNullParameter(r18, "message");
        c1.b.b(new f(r17, r18));
    L15:
        JavaOnlyMap r20 = new JavaOnlyMap();
        r20.put("success", Boolean.TRUE);
        Unit r21 = Unit.INSTANCE;
        r11.invoke(new Object[]{r20});
        return;
    L11:
        r15 = null;
        goto L12
    L5:
        r13 = null;
        goto L6
    }

    @com.bytedance.vmsdk.jsbridge.b
    public final boolean canIUse(String r5) {
        Intrinsics.checkNotNullParameter(r5, "schema");
        Object r10 = this.mParam;
        String r11 = null;
        if ((r10 instanceof AppletRuntime) == false) goto L5;
        AppletRuntime r12 = (AppletRuntime) r10;
    L6:
        if (r12 == null) goto L10;
        Applet r13 = r12.f2197h;
        if (r13 == null) goto L10;
        r11 = r13.i();
    L10:
        String r14 = this.TAG;
        String r15 = com.lynx.tasm.utils.b.j("canIUse: ", r5, ", appletId: ", r11);
        Intrinsics.checkNotNullParameter(r14, "tag");
        t0.d r16 = com.bytedance.ai.utils.c.f2846a;
        if (r16 == null) goto L14;
        r16.d(r14, r15);
    L14:
        return ym.h.h(r5, ContainerType.d);
    L5:
        r12 = null;
        goto L6
    }

    @com.bytedance.vmsdk.jsbridge.b
    public final void log(String r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        Object r10 = this.mParam;
        if ((r10 instanceof AppletRuntime) == false) goto L5;
        AppletRuntime r11 = (AppletRuntime) r10;
    L6:
        if (r11 == null) goto L11;
        Applet r12 = r11.f2197h;
        if (r12 == null) goto L11;
        String r13 = r12.i();
        if (r13 == null) goto L11;
    L12:
        String r14 = this.TAG;
        String r15 = com.lynx.tasm.utils.b.j("console.log: ", r5, ", appletId: ", r13);
        Intrinsics.checkNotNullParameter(r14, "tag");
        t0.d r16 = com.bytedance.ai.utils.c.f2846a;
        if (r16 == null) goto L16;
        r16.d(r14, r15);
        return;
    L16:
        return;
    L11:
        r13 = "unknown_id";
        goto L12
    L5:
        r11 = null;
        goto L6
    }
}
