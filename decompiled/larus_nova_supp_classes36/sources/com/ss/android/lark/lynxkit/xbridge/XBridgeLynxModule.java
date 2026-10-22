package com.ss.android.lark.lynxkit.xbridge;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.lynx.jsbridge.LynxMethod;
import com.lynx.jsbridge.LynxModule;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.lynxkit.bridge.LarkLynxBridgeCallContext;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J \u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00152\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/lynxkit/xbridge/XBridgeLynxModule;", "Lcom/lynx/jsbridge/LynxModule;", "androidContext", "Landroid/content/Context;", "param", "", "<init>", "(Landroid/content/Context;Ljava/lang/Object;)V", "runtime", "Lcom/ss/android/lark/lynxkit/xbridge/XBridgeLynxKitRuntime;", "mainHandler", "Landroid/os/Handler;", "call", "", "bridgeName", "", "params", "Lcom/lynx/react/bridge/ReadableMap;", "callback", "Lcom/lynx/react/bridge/Callback;", "unwrapData", "", "errorResult", "Lcom/lynx/react/bridge/JavaOnlyMap;", "code", "", INotificationHitPoint.NoticeType.MESSAGE, "Companion", "lark-lynx-xbridge_chinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class XBridgeLynxModule extends LynxModule {
    public static final Companion Companion = null;
    private static final String KEY_DATA = "data";
    public static final String NAME = "bridge";
    private static final String TAG = "XBridgeLynxModule";
    private final Handler mainHandler;
    private final XBridgeLynxKitRuntime runtime;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/lynxkit/xbridge/XBridgeLynxModule$Companion;", "", "<init>", "()V", "TAG", "", "NAME", "KEY_DATA", "lark-lynx-xbridge_chinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final Map<String, Object> unwrapData(ReadableMap r3) {
        if (r3 == null) goto L5;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        if (r3.hasKey(KEY_DATA) == false) goto L9;
        r3 = r3.getMap(KEY_DATA);     // Catch: Throwable -> L11
    L9:
        Object r4 = Result.constructor-impl(r3);     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r4) == false) goto L16;
        r4 = null;
    L16:
        LynxReadableMapConverter r0 = LynxReadableMapConverter.INSTANCE;
        return r0.toMap((ReadableMap) r4);
    L11:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L5:
        return MapsKt.emptyMap();
    }

    public XBridgeLynxModule(Context r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "androidContext");
        super(r2, r3);
        if ((r3 instanceof XBridgeLynxKitRuntime) == false) goto L5;
        XBridgeLynxKitRuntime r4 = (XBridgeLynxKitRuntime) r3;
    L6:
        this.runtime = r4;
        this.mainHandler = new Handler(Looper.getMainLooper());
        return;
    L5:
        r4 = null;
        goto L6
    }

    private final JavaOnlyMap errorResult(int r3, String r4) {
        JavaOnlyMap r0 = new JavaOnlyMap();
        r0.put("code", Integer.valueOf(r3));
        r0.put("msg", r4);
        return r0;
    }

    public static final /* synthetic */ JavaOnlyMap access$errorResult(XBridgeLynxModule r0, int r1, String r2) {
        return r0.errorResult(r1, r2);
    }

    @LynxMethod
    public final void call(final String r12, ReadableMap r13, final Callback r14) {
        XBridgeLynxKitRuntime r0 = this.runtime;
        if (r0 != null) goto L8;
        Log.e(TAG, "call failed, runtime is null");
        if (r14 == null) goto L31;
        r14.invoke(new Object[]{errorResult(-999, "runtime is null")});
        return;
    L31:
        return;
    L8:
        if (r12 != null) goto L10;
    L13:
        boolean r4 = true;
    L15:
        if (r4 == false) goto L20;
        Log.e(TAG, "call failed, bridgeName is empty");
        if (r14 == null) goto L32;
        r14.invoke(new Object[]{errorResult(-2, "bridgeName is empty")});
        return;
    L32:
        return;
    L20:
        final XBridge2To3Adapter r10 = r0.loadMethod(r12);
        if (r10 != null) goto L26;
        Log.e(TAG, "call failed, method not found: " + r12);
        if (r14 == null) goto L33;
        r14.invoke(new Object[]{errorResult(-2, "method not found")});
        return;
    L33:
        return;
    L26:
        final Map<String, Object> r6 = unwrapData(r13);
        final LarkLynxBridgeCallContext r5 = r0.createCallContext();
        Runnable r15 = new XBridgeLynxModule$call$callTask$1(r10, r5, r6, r12, r14, this);
        if (r10.shouldRunOnCallingThread(Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) == false) goto L29;
        r15.run();
        return;
    L29:
        this.mainHandler.post(r15);
        return;
    L10:
        if (r12.length() == 0) goto L13;
        r4 = false;
        goto L15
    }
}
