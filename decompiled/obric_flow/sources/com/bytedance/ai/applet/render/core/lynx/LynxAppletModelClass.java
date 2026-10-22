package com.bytedance.ai.applet.render.core.lynx;

import android.content.Context;
import com.bytedance.ai.bridge.ContainerType;
import com.lynx.jsbridge.LynxModule;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.react.bridge.ReadableMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0002\u0017\u0013B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u000e\u0010\n\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tH\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ai/applet/render/core/lynx/LynxAppletModelClass;", "Lcom/lynx/jsbridge/LynxModule;", "Landroid/content/Context;", "context", "", "remoteParams", "<init>", "(Landroid/content/Context;Ljava/lang/Object;)V", "Lcom/lynx/react/bridge/ReadableMap;", "Lcom/bytedance/ai/applet/render/core/lynx/LynxReadableMap;", "message", "", "postMessage", "(Lcom/lynx/react/bridge/ReadableMap;)V", "", "schema", "", "canIUse", "(Ljava/lang/String;)Z", "Lcom/bytedance/ai/applet/render/core/lynx/f;", LynxResourceModule.PARAMS_KEY, "Lcom/bytedance/ai/applet/render/core/lynx/f;", "Companion", "com/bytedance/ai/applet/render/core/lynx/e", "applet-render-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LynxAppletModelClass extends LynxModule {
    public static final e Companion = null;
    public static final String NAME = "AppletBridgeModule";
    public static final String TAG = "LynxAppletModelClass";
    private final f params;

    static {
        Companion = new e();
    }

    public LynxAppletModelClass(Context r5, Object r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
        if ((r10 instanceof f) == false) goto L5;
        f r11 = (f) r10;
    L6:
        this.params = r11;
        return;
    L5:
        r11 = null;
        goto L6
    }

    @com.lynx.jsbridge.n
    public final boolean canIUse(String r10) {
        Intrinsics.checkNotNullParameter(r10, "schema");
        String r5 = "LynxMethod canIUse --> " + r10;
        Intrinsics.checkNotNullParameter("LynxAppletModelClass", "tag");
        Intrinsics.checkNotNullParameter(r5, "msg");
        a1.a.f43a.d("LynxAppletModelClass", r5);
        f r11 = this.params;
        if (r11 != null) goto L6;
        Intrinsics.checkNotNullParameter("LynxAppletModelClass", "tag");
        Intrinsics.checkNotNullParameter("params is NULL", "msg");
        a1.a.f43a.e("LynxAppletModelClass", "params is NULL", null);
        return false;
    L6:
        com.bytedance.ai.applet.components.view.a r12 = r11.f1765b;
        if (r12 != null) goto L11;
        Intrinsics.checkNotNullParameter("LynxAppletModelClass", "tag");
        Intrinsics.checkNotNullParameter("checkCanIUse is NULL", "msg");
        a1.a.f43a.e("LynxAppletModelClass", "checkCanIUse is NULL", null);
        return false;
    L11:
        return ((Boolean) r12.mo2invoke(r10, ContainerType.f1800b)).booleanValue();
    }

    @com.lynx.jsbridge.n
    public final void postMessage(ReadableMap r10) {
        String r5 = "LynxMethod postMessage --> " + r10;
        Intrinsics.checkNotNullParameter("LynxAppletModelClass", "tag");
        Intrinsics.checkNotNullParameter(r5, "msg");
        a1.a.f43a.d("LynxAppletModelClass", r5);
        if (r10 != null) goto L5;
        return;
    L5:
        f r11 = this.params;
        if (r11 == null) goto L8;
        l2.a r12 = r11.f1764a;
    L9:
        if (r12 != null) goto L12;
        r12 = null;
    L12:
        if (r12 == null) goto L15;
        r12.c(r10);
        return;
    L15:
        Intrinsics.checkNotNullParameter("LynxAppletModelClass", "tag");
        Intrinsics.checkNotNullParameter("remoteMessageCache is NULL", "msg");
        a1.a.f43a.e("LynxAppletModelClass", "remoteMessageCache is NULL", null);
        return;
    L8:
        r12 = null;
        goto L9
    }
}
