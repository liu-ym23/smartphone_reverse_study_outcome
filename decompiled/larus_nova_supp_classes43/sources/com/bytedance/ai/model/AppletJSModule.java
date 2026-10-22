package com.bytedance.ai.model;

import android.content.Context;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.monitor.bridge.BridgeType;
import com.bytedance.vmsdk.jsbridge.JSMethod;
import com.bytedance.vmsdk.jsbridge.JSModule;
import com.bytedance.vmsdk.jsbridge.utils.Callback;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\tH\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ai/model/AppletJSModule;", "Lcom/bytedance/vmsdk/jsbridge/JSModule;", "context", "Landroid/content/Context;", "appletRuntime", "", "<init>", "(Landroid/content/Context;Ljava/lang/Object;)V", "TAG", "", "appletPostMessage", "", com.bytedance.android.ec.core.event.a.KEY_MSG, "Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;", "callback", "Lcom/bytedance/vmsdk/jsbridge/utils/Callback;", "log", "canIUse", "", com.bytedance.android.ec.core.event.a.KEY_SCHEMA, "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletJSModule extends JSModule {
    public static final a Companion = null;
    public static final String NAME = "AppletJSModule";
    private final String TAG;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @JSMethod
    public final boolean canIUse(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Object r0 = ((JSModule) this).mParam;
        String r11 = null;
        if ((r0 instanceof AppletRuntime) == false) goto L5;
        AppletRuntime r1 = (AppletRuntime) r0;
    L6:
        if (r1 == null) goto L10;
        Applet r12 = r1.h;
        if (r12 == null) goto L10;
        r11 = r12.o();
    L10:
        com.bytedance.ai.utils.g.a.d(this.TAG, "canIUse: " + r10 + ", appletId: " + r11);
        s4.d r13 = s4.d.a;
        ContainerType r14 = ContainerType.WORKER;
        r13.getClass();
        return s4.d.a(r10, r14);
    L5:
        r1 = null;
        goto L6
    }

    @JSMethod
    public final void log(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_MSG);
        Object r0 = ((JSModule) this).mParam;
        if ((r0 instanceof AppletRuntime) == false) goto L5;
        AppletRuntime r1 = (AppletRuntime) r0;
    L6:
        if (r1 == null) goto L11;
        Applet r11 = r1.h;
        if (r11 == null) goto L11;
        String r12 = r11.o();
        if (r12 == null) goto L11;
    L12:
        com.bytedance.ai.utils.g.a.d(this.TAG, "console.log: " + r10 + ", appletId: " + r12);
        return;
    L11:
        r12 = "unknown_id";
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public AppletJSModule(Context r10, Object r11) {
        Intrinsics.checkNotNullParameter(r11, "appletRuntime");
        super(r10, r11);
        this.TAG = NAME;
    }

    @JSMethod
    public final void appletPostMessage(ReadableMap r10, Callback r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_MSG);
        Intrinsics.checkNotNullParameter(r11, "callback");
        Object r1 = ((JSModule) this).mParam;
        if ((r1 instanceof AppletRuntime) == false) goto L5;
        AppletRuntime r12 = (AppletRuntime) r1;
    L6:
        l5.w r13 = l5.w.b;
        if (r12 == null) goto L11;
        Applet r14 = r12.h;
        if (r14 == null) goto L11;
        String r15 = r14.o();
    L12:
        BridgeType r16 = BridgeType.V1;
        Intrinsics.checkNotNullParameter("appletPostMessageWorker", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r16, "type");
        com.bytedance.ai.monitor.b.b("applet_old_bridge", new l5.y("appletPostMessageWorker", r16, r15, null));
        final String r17 = r10.getString("viewId");
        final String r18 = ((JavaOnlyMap) r10).toJSONObject().toString();
        if (r12 == null) goto L15;
        Intrinsics.checkNotNull(r17);
        Intrinsics.checkNotNullParameter(r17, "viewId");
        Intrinsics.checkNotNullParameter(r18, com.bytedance.android.ec.core.event.a.KEY_MSG);
        p2.c.d(new m(r17, r18));
    L15:
        JavaOnlyMap r0 = new JavaOnlyMap();
        r0.put("success", Boolean.TRUE);
        Unit r19 = Unit.INSTANCE;
        r11.invoke(new Object[]{r0});
        return;
    L11:
        r15 = null;
        goto L12
    L5:
        r12 = null;
        goto L6
    }
}
