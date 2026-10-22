package com.bytedance.ai.jsb.lynx;

import android.content.Context;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.utils.c;
import com.lynx.jsbridge.LynxModule;
import com.lynx.jsbridge.n;
import com.lynx.react.bridge.ReadableMap;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t0.d;
import v2.a;
import ym.h;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u000e\u0010\n\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tH\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ai/jsb/lynx/LynxAppletModelClass;", "Lcom/lynx/jsbridge/LynxModule;", "Landroid/content/Context;", "context", "", "remoteMessageCache", "<init>", "(Landroid/content/Context;Ljava/lang/Object;)V", "Lcom/lynx/react/bridge/ReadableMap;", "Lcom/bytedance/ai/utils/LynxReadableMap;", "message", "", "postMessage", "(Lcom/lynx/react/bridge/ReadableMap;)V", "", "schema", "", "canIUse", "(Ljava/lang/String;)Z", "Ljava/lang/Object;", "Companion", "v2/a", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LynxAppletModelClass extends LynxModule {
    public static final a Companion = null;
    private static final String TAG = "LynxAppletModelClass";
    private final Object remoteMessageCache;

    static {
        Companion = new a();
    }

    public LynxAppletModelClass(Context r5, Object r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
        this.remoteMessageCache = r10;
        Intrinsics.checkNotNullParameter("LynxAppletModelClass", "tag");
        d r11 = c.f2846a;
        if (r11 == null) goto L6;
        r11.d("LynxAppletModelClass", "LynxAppletModelClass constructor");
        return;
    }

    @n
    public final boolean canIUse(String r5) {
        Intrinsics.checkNotNullParameter(r5, "schema");
        String r10 = "LynxMethod(jsb-lynx) canIUse --> " + r5;
        Intrinsics.checkNotNullParameter("LynxAppletModelClass", "tag");
        d r11 = c.f2846a;
        if (r11 == null) goto L6;
        r11.d("LynxAppletModelClass", r10);
    L6:
        return h.h(r5, ContainerType.f1801c);
    }

    @n
    public final void postMessage(ReadableMap r5) {
        String r10 = "LynxMethod postMessage --> " + r5;
        Intrinsics.checkNotNullParameter("LynxAppletModelClass", "tag");
        d r11 = c.f2846a;
        if (r11 == null) goto L5;
        r11.d("LynxAppletModelClass", r10);
    L5:
        if (r5 == null) goto L20;
        Object r12 = this.remoteMessageCache;
        l2.a r13 = null;
        if ((r12 instanceof ArrayList) == false) goto L10;
        ArrayList r14 = (ArrayList) r12;
    L11:
        if (r14 == null) goto L18;
        Object r15 = r14.get(0);
        if ((r15 instanceof l2.a) == false) goto L15;
        r13 = (l2.a) r15;
    L15:
        if (r13 == null) goto L19;
        r13.c(r5);
        return;
    L19:
        return;
    L18:
        return;
    L10:
        r14 = null;
        goto L11
    }
}
