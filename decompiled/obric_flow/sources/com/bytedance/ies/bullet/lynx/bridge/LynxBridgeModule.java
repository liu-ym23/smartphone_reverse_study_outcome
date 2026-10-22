package com.bytedance.ies.bullet.lynx.bridge;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.core.app.NotificationCompat;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.airbnb.lottie.k;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.o;
import com.bytedance.ies.xbridge.BridgeDataConverterHolder$Strategy;
import com.lynx.jsbridge.LynxModule;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.jsbridge.n;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import io.reactivex.internal.observers.h;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated(message = "XBridge3.0 is ready, XBridge2.0's Lynx Bridge Module is not recommended to continue to use", replaceWith = @ReplaceWith(expression = "XBridgeLynxModule", imports = {}))
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\b\b\u0007\u0018\u0000 C2\u00020\u0001:\u0003DEFB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J=\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00122\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0016\u001a\u00020\n*\u00020\n2\u0006\u0010\u0015\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0016\u0010\u0017JY\u0010\"\u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\bH\u0003¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020!2\u0006\u0010$\u001a\u00020\u001aH\u0003¢\u0006\u0004\b%\u0010&J\u001b\u0010'\u001a\u00020!*\u00020\u00102\u0006\u0010\u0018\u001a\u00020\bH\u0002¢\u0006\u0004\b'\u0010(J'\u0010)\u001a\u00020!2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b)\u0010*J\u001d\u0010+\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b+\u0010,J\u001d\u0010.\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u000e¢\u0006\u0004\b.\u0010/R\u0016\u00100\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00103\u001a\u0004\u0018\u0001028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00106\u001a\u0004\u0018\u0001058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010;\u001a\u0004\u0018\u0001088BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0014\u0010>\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020\b0?8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b@\u0010A¨\u0006G"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/bridge/LynxBridgeModule;", "Lcom/lynx/jsbridge/LynxModule;", "Landroid/content/Context;", "context", "", "param", "<init>", "(Landroid/content/Context;Ljava/lang/Object;)V", "", "func", "Lcom/lynx/react/bridge/ReadableMap;", LynxResourceModule.PARAMS_KEY, "Lcom/lynx/react/bridge/Callback;", "callback", "", "executeThread", "Lcom/bytedance/ies/bullet/core/kit/bridge/c;", "perfData", "Ljava/util/concurrent/Callable;", "getExecuteTask", "(Ljava/lang/String;Lcom/lynx/react/bridge/ReadableMap;Lcom/lynx/react/bridge/Callback;ILcom/bytedance/ies/bullet/core/kit/bridge/c;)Ljava/util/concurrent/Callable;", STGroup.DICT_KEY, "optMap", "(Lcom/lynx/react/bridge/ReadableMap;Ljava/lang/String;)Lcom/lynx/react/bridge/ReadableMap;", "methodName", "message", "", "invokeTime", "bridgeType", "", "success", "errorCode", "errorMsg", "", "doMonitorLog", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;IZLjava/lang/Integer;Ljava/lang/String;)V", "initTime", "doMonitorInitLog", "(J)V", "onReady", "(Lcom/bytedance/ies/bullet/core/kit/bridge/c;Ljava/lang/String;)V", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/String;Lcom/lynx/react/bridge/ReadableMap;Lcom/lynx/react/bridge/Callback;)V", "getExecuteThread", "(Ljava/lang/String;Lcom/lynx/react/bridge/ReadableMap;)I", "code", "composeErrorMessage", "(Ljava/lang/String;I)Ljava/lang/String;", "firstBridgeInit", "Z", "Lcom/bytedance/ies/bullet/core/e;", "bulletContext", "Lcom/bytedance/ies/bullet/core/e;", "Lcom/bytedance/ies/bullet/service/base/o;", "testService", "Lcom/bytedance/ies/bullet/service/base/o;", "Lcom/bytedance/ies/bullet/core/kit/bridge/e;", "getBridgeRegistry", "()Lcom/bytedance/ies/bullet/core/kit/bridge/e;", "bridgeRegistry", "getBridgeExecuteStrategy", "()I", "bridgeExecuteStrategy", "", "getBridgeAsyncExecuteList", "()Ljava/util/List;", "bridgeAsyncExecuteList", "Companion", "com/bytedance/ies/bullet/lynx/bridge/a", "com/bytedance/ies/bullet/lynx/bridge/b", "com/bytedance/ies/bullet/lynx/bridge/c", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class LynxBridgeModule extends LynxModule {
    public static final int BRIDGE_EXECUTE_STRATEGY_BACKGROUND = 1;
    public static final int BRIDGE_EXECUTE_STRATEGY_CURRENT = 2;
    public static final int BRIDGE_EXECUTE_STRATEGY_UI_THREAD = 0;
    public static final b Companion = null;
    public static final String KEY_DATA = "data";
    public static final String KEY_USE_UI_THREAD = "useUIThread";
    public static final String NAME = "bridge";
    public static final String TAG = "LynxBridgeModule";
    private final com.bytedance.ies.bullet.core.e bulletContext;
    private boolean firstBridgeInit;
    private final o testService;

    static {
        Companion = new b();
    }

    public LynxBridgeModule(Context r5, Object r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "param");
        super(r5, r10);
        if ((r10 instanceof com.bytedance.ies.bullet.core.e) == false) goto L5;
        com.bytedance.ies.bullet.core.e r11 = (com.bytedance.ies.bullet.core.e) r10;
    L6:
        this.bulletContext = r11;
        tc.c r12 = tc.c.f22119c;
        tc.c r13 = tc.c.f22119c;
        if (r11 == null) goto L10;
        String r14 = r11.f;
        if (r14 == null) goto L10;
    L12:
        if (r13.a(o.class, r14) != null) goto L18;
        g r15 = new g(0);
        LinkedHashMap r16 = de.a.f16641a;
        BridgeDataConverterHolder$Strategy r17 = BridgeDataConverterHolder$Strategy.f6317a;
        Intrinsics.checkNotNullParameter("LYNX", WsConstants.KEY_PLATFORM);
        Intrinsics.checkNotNullParameter(r15, "typeConverter");
        Intrinsics.checkNotNullParameter(r17, "strategy");
        LinkedHashMap r18 = de.a.f16642b;
        if (r18.containsKey("LYNX") == true) goto L19;
        r18.put("LYNX", r15);
        return;
    L19:
        return;
    L18:
        throw new ClassCastException();
    L10:
        r14 = "default_bid";
        goto L12
    L5:
        r11 = null;
        goto L6
    }

    public static final /* synthetic */ void access$doMonitorInitLog(LynxBridgeModule r5, long r10) {
        r5.doMonitorInitLog(r10);
    }

    public static final /* synthetic */ void access$doMonitorLog(LynxBridgeModule r5, String r10, String r11, long r12, String r13, int r14, boolean r15, Integer r16, String r17) {
        r5.doMonitorLog(r10, r11, r12, r13, r14, r15, r16, r17);
    }

    public static final /* synthetic */ com.bytedance.ies.bullet.core.kit.bridge.e access$getBridgeRegistry(LynxBridgeModule r5) {
        return r5.getBridgeRegistry();
    }

    public static final /* synthetic */ com.bytedance.ies.bullet.core.e access$getBulletContext$p(LynxBridgeModule r5) {
        return r5.bulletContext;
    }

    public static final /* synthetic */ o access$getTestService$p(LynxBridgeModule r5) {
        r5.getClass();
        return null;
    }

    public static final /* synthetic */ void access$onReady(LynxBridgeModule r5, com.bytedance.ies.bullet.core.kit.bridge.c r10, String r11) {
        r5.onReady(r10, r11);
    }

    @JvmOverloads
    private final void doMonitorInitLog(long r5) {
        h.f.b(new d(this, r5, 1), h.f.g);
    }

    @JvmOverloads
    private final void doMonitorLog(String r13, String r14, long r15, String r17, int r18) {
        doMonitorLog$default(this, r13, r14, r15, r17, r18, false, null, null, 224, null);
    }

    public static /* synthetic */ void doMonitorLog$default(LynxBridgeModule r12, String r13, String r14, long r15, String r17, int r18, boolean r19, Integer r20, String r21, int r22, Object r23) {
        if ((r22 & 32) == 0) goto L5;
        boolean r10 = true;
    L7:
        if ((r22 & 64) == 0) goto L9;
        Integer r11 = null;
    L11:
        if ((r22 & 128) == 0) goto L13;
        String r16 = null;
    L14:
        r12.doMonitorLog(r13, r14, r15, r17, r18, r10, r11, r16);
        return;
    L13:
        r16 = r21;
        goto L14
    L9:
        r11 = r20;
        goto L11
    L5:
        r10 = r19;
        goto L7
    }

    private final List<String> getBridgeAsyncExecuteList() {
        ConcurrentHashMap r5 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r10 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r10 == null) goto L5;
        xc.d r11 = (xc.d) r10.a(xc.d.class);
    L6:
        if (r11 == null) goto L14;
        xc.c r12 = r11.k0();
        if (r12 == null) goto L14;
        List<String> r13 = r12.b();
        if (r13 == null) goto L14;
        return r13;
    L14:
        return CollectionsKt.emptyList();
    L5:
        r11 = null;
        goto L6
    }

    private final int getBridgeExecuteStrategy() {
        ConcurrentHashMap r5 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r10 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r10 == null) goto L5;
        xc.d r11 = (xc.d) r10.a(xc.d.class);
    L6:
        if (r11 == null) goto L11;
        xc.c r12 = r11.k0();
        if (r12 != null) goto L10;
        return 0;
    L10:
        return r12.a();
    L11:
        return 0;
    L5:
        r11 = null;
        goto L6
    }

    private final com.bytedance.ies.bullet.core.kit.bridge.e getBridgeRegistry() {
        com.bytedance.ies.bullet.core.e r5 = this.bulletContext;
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.f5301o;
    }

    private final Callable<?> getExecuteTask(String r10, ReadableMap r11, Callback r12, int r13, com.bytedance.ies.bullet.core.kit.bridge.c r14) {
        return new f(r10, this, r14, r11, r12, r13);
    }

    private final void onReady(com.bytedance.ies.bullet.core.kit.bridge.c r5, String r10) {
        h.f.b(new k(this, r5, r10, 4), h.f.g);
    }

    private final ReadableMap optMap(ReadableMap r5, String r10) {
        if (r5.hasKey(r10) == false) goto L6;
        return r5.getMap(r10);
    L6:
        return new JavaOnlyMap();
    L8:
        return new JavaOnlyMap();
    }

    @n
    @Keep
    public final void call(String r10, ReadableMap r11, Callback r12) {
        Intrinsics.checkNotNullParameter(r10, "func");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r12, "callback");
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return;
    L6:
        if (getBridgeRegistry() != null) goto L9;
        boolean r13 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d("bridgeRegistry is null", LogLevel.d, "XLynxKit");
        return;
    L9:
        com.bytedance.ies.bullet.core.kit.bridge.e r5 = getBridgeRegistry();
        Intrinsics.checkNotNull(r5);
        if (((com.bytedance.ies.bullet.core.kit.bridge.d) r5).g == false) goto L13;
        boolean r14 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d("bridgeRegistry is released", LogLevel.d, "XLynxKit");
        return;
    L13:
        com.bytedance.ies.bullet.core.kit.bridge.e r15 = getBridgeRegistry();
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type com.bytedance.ies.bullet.core.kit.bridge.BridgeRegistry");
        if (((com.bytedance.ies.bullet.core.kit.bridge.d) r15).f5344h == false) goto L16;
    L18:
        com.bytedance.ies.bullet.core.kit.bridge.c r16 = new com.bytedance.ies.bullet.core.kit.bridge.c();
        long r17 = System.currentTimeMillis();
        r16.f5336a = r17;
        r16.f5337b = r17;
        int r18 = getExecuteThread(r10, r11);
        Callable<?> r19 = getExecuteTask(r10, r11, r12, r18, r16);
        if (r18 == 0) goto L28;
        if (r18 != 1) goto L22;
        h.f.b(r19, h.f.g);
        return;
    L22:
        if (r18 == 2) goto L24;
        return;
    L24:
        h.f.b(r19, h.f.f17262h);
        return;
    L28:
        h.f.b(r19, h.f.f17263i);
        return;
    L16:
        if (this.firstBridgeInit == true) goto L18;
        long r20 = SystemClock.elapsedRealtime();
        this.firstBridgeInit = true;
        boolean r21 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d("init bridge", LogLevel.f5953a, "XLynxKit");
        h.f.b(new d(this, r20, 0), h.f.f17263i);
        goto L18
    }

    public final String composeErrorMessage(String r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "message");
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L5
        return new JSONObject().putOpt("message", r5).putOpt("code", Integer.valueOf(r10)).toString();
    L5:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        return r5;
    }

    public final int getExecuteThread(String r5, ReadableMap r10) {
        Intrinsics.checkNotNullParameter(r5, "func");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        com.bytedance.ies.bullet.core.kit.bridge.e r11 = getBridgeRegistry();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.bytedance.ies.bullet.core.kit.bridge.BridgeRegistry");
        if (((com.bytedance.ies.bullet.core.kit.bridge.d) r11).f5344h == true) goto L7;
        boolean r12 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d(h.b(r5, " use main thread"), LogLevel.f5953a, "XLynxKit");
        return 0;
    L7:
        if (r10.hasKey("data") == false) goto L10;
        r10 = optMap(r10, "data");
    L10:
        if (r10.hasKey(KEY_USE_UI_THREAD) == true) goto L12;
        int r13 = getBridgeExecuteStrategy();
        if (r13 != 0) goto L16;
    L22:
        return 0;
    L16:
        if (getBridgeAsyncExecuteList().contains(r5) == false) goto L22;
        if (r13 != 1) goto L19;
    L21:
        return r13;
    L19:
        if (r13 == 2) goto L21;
        return 0;
    L12:
        return !r10.getBoolean(KEY_USE_UI_THREAD) ? 1 : 0;
    }

    @JvmOverloads
    private final void doMonitorLog(String r13, String r14, long r15, String r17, int r18, boolean r19) {
        doMonitorLog$default(this, r13, r14, r15, r17, r18, r19, null, null, 192, null);
    }

    @JvmOverloads
    private final void doMonitorLog(String r13, String r14, long r15, String r17, int r18, boolean r19, Integer r20) {
        doMonitorLog$default(this, r13, r14, r15, r17, r18, r19, r20, null, 128, null);
    }

    @JvmOverloads
    private final void doMonitorLog(String r10, String r11, long r12, String r13, int r14, boolean r15, Integer r16, String r17) {
        h.f.b(new e(r15, this, r14, r10, r13), h.f.g);
    }
}
