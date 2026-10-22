package com.bytedance.sdk.xbridge.cn.platform.lynx;

import android.content.Context;
import android.view.View;
import androidx.annotation.Keep;
import androidx.core.app.NotificationCompat;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.lynx.jsbridge.LynxModule;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.jsbridge.n;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxView;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/platform/lynx/XBridgeLynxModule;", "Lcom/lynx/jsbridge/LynxModule;", "Landroid/content/Context;", "androidContext", "", "bdxBridge", "<init>", "(Landroid/content/Context;Ljava/lang/Object;)V", "", "bridgeName", "Lcom/lynx/react/bridge/ReadableMap;", LynxResourceModule.PARAMS_KEY, "Lcom/lynx/react/bridge/Callback;", "callback", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/String;Lcom/lynx/react/bridge/ReadableMap;Lcom/lynx/react/bridge/Callback;)V", "Landroid/content/Context;", "getAndroidContext", "()Landroid/content/Context;", "Ljava/lang/Object;", "getBdxBridge", "()Ljava/lang/Object;", "Companion", "com/bytedance/sdk/xbridge/cn/platform/lynx/l", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class XBridgeLynxModule extends LynxModule {
    public static final l Companion = null;
    public static final String NAME = "bridge";
    private final Context androidContext;
    private final Object bdxBridge;

    static {
        Companion = new l();
    }

    public XBridgeLynxModule(Context r5, Object r10) {
        Intrinsics.checkNotNullParameter(r5, "androidContext");
        Intrinsics.checkNotNullParameter(r10, "bdxBridge");
        super(r5, r10);
        this.androidContext = r5;
        this.bdxBridge = r10;
    }

    @n
    @Keep
    public final void call(String r10, ReadableMap r11, Callback r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeName");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r12, "callback");
        Object r5 = this.bdxBridge;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBDXBridge");
        a r13 = (a) r5;
        monitor-enter(r13);
        monitor-exit(r13);
        LynxView r14 = (LynxView) ((View) r13.t().e.get());
        if (r14 == null) goto L9;
        String r15 = r14.getTemplateUrl();
        if (r15 == null) goto L9;
    L10:
        b r16 = new b(r10, r15, r11);
        if (Intrinsics.areEqual(((a) this.bdxBridge).f7360k, "webcast") == false) goto L14;
        a r17 = (a) this.bdxBridge;
        Lazy r18 = com.bytedance.sdk.xbridge.cn.optimize.b.f7355a;
        r17.getClass();
        Intrinsics.checkNotNullParameter("mix_jsb_opt_switch", STGroup.DICT_KEY);
        if (Intrinsics.areEqual(r17.e.get("mix_jsb_opt_switch"), Boolean.TRUE) == false) goto L14;
    L20:
        ((a) this.bdxBridge).m(r16, new g(r12, r16, r13.t()));
        return;
    L14:
        Boolean r19 = ((a) this.bdxBridge).f7366q;
        boolean r20 = false;
        if (r19 == null) goto L17;
        boolean r21 = r19.booleanValue();
    L19:
        if (r21 == true) goto L20;
        if (Intrinsics.areEqual(((a) this.bdxBridge).f7360k, "Loki") == false) goto L26;
        a r22 = (a) this.bdxBridge;
        Lazy r23 = com.bytedance.sdk.xbridge.cn.optimize.b.f7355a;
        r22.getClass();
        Intrinsics.checkNotNullParameter("loki_jsb_opt_switch", STGroup.DICT_KEY);
        if (Intrinsics.areEqual(r22.e.get("loki_jsb_opt_switch"), Boolean.TRUE) == false) goto L26;
    L30:
        ((a) this.bdxBridge).m(r16, new g(r12, r16, r13.t()));
        return;
    L26:
        Boolean r24 = ((a) this.bdxBridge).f7366q;
        if (r24 == null) goto L29;
        r20 = r24.booleanValue();
    L29:
        if (r20 == true) goto L30;
        ((a) this.bdxBridge).l(r16, new g(r12, r16, r13.t()));
        return;
    L17:
        r21 = false;
    L9:
        r15 = "";
        goto L10
    }

    public final Context getAndroidContext() {
        return this.androidContext;
    }

    public final Object getBdxBridge() {
        return this.bdxBridge;
    }
}
