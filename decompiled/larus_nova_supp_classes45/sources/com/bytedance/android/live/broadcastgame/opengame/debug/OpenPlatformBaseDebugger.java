package com.bytedance.android.live.broadcastgame.opengame.debug;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.api.opengame.qrcode.IQRCodeService;
import com.bytedance.android.live.broadcastgame.api.openplatform.PluginType;
import com.bytedance.android.live.broadcastgame.opengame.q;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0017\b'\u0018\u0000 E2\u00020\u00012\u00020\u0002:\u0001FB\u0007¢\u0006\u0004\bC\u0010DJF\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0004J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\u0012\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\fH&J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H&J\b\u0010\u001c\u001a\u00020\u0011H\u0016R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR(\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070 8\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R(\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030 8\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b'\u0010\"\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\"\u0010*\u001a\u00020\f8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00101\u001a\u0002008\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u00107\u001a\u0004\u0018\u00010\t8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010=\u001a\u0004\u0018\u00010\u000f8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006G"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/debug/OpenPlatformBaseDebugger;", "Lcom/bytedance/android/live/broadcastgame/opengame/i;", "Lcom/bytedance/android/live/broadcastgame/opengame/debug/c;", "Landroid/content/Context;", "context", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Landroid/view/ViewGroup;", "containerView", "Lcom/bytedance/android/live/broadcastgame/api/openplatform/b;", "gameManager", "", "", "", "extraParams", "Lcom/bytedance/android/live/broadcastgame/opengame/i$a;", "callback", "", "initDebug", "releaseDebug", "createDebugFloatBall", "scanQRCode", "resultStr", "", "onScanSuccess", "", "errorType", "onScanFail", "stopDebug", "Lcom/bytedance/android/live/broadcastgame/opengame/debug/OpenGameDebugFloatBall;", "debugFloatBall", "Lcom/bytedance/android/live/broadcastgame/opengame/debug/OpenGameDebugFloatBall;", "Ljava/lang/ref/WeakReference;", "containerViewWeakRef", "Ljava/lang/ref/WeakReference;", "getContainerViewWeakRef", "()Ljava/lang/ref/WeakReference;", "setContainerViewWeakRef", "(Ljava/lang/ref/WeakReference;)V", "contextWeakRef", "getContextWeakRef", "setContextWeakRef", "appId", "Ljava/lang/String;", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "", "gameId", "J", "getGameId", "()J", "setGameId", "(J)V", "pluginManager", "Lcom/bytedance/android/live/broadcastgame/api/openplatform/b;", "getPluginManager", "()Lcom/bytedance/android/live/broadcastgame/api/openplatform/b;", "setPluginManager", "(Lcom/bytedance/android/live/broadcastgame/api/openplatform/b;)V", "initCallback", "Lcom/bytedance/android/live/broadcastgame/opengame/i$a;", "getInitCallback", "()Lcom/bytedance/android/live/broadcastgame/opengame/i$a;", "setInitCallback", "(Lcom/bytedance/android/live/broadcastgame/opengame/i$a;)V", "<init>", "()V", "Companion", "a", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class OpenPlatformBaseDebugger implements com.bytedance.android.live.broadcastgame.opengame.i, c {
    public static final String APP_ID = "app_id";
    public static final int CODE_CAN_DEBUG = 1;
    public static final a Companion = null;
    public static final String DEBUG_GAME_ID = "debug_game_id";
    public static final String DEVELOP = "develop";
    public static final int ERROR_CODE_APP_ID_NOT_MATCH = 102;
    public static final int ERROR_CODE_INVALID_QR_CODE = 101;
    public static final String SIGN = "sign";
    private String appId;
    protected WeakReference<ViewGroup> containerViewWeakRef;
    protected WeakReference<Context> contextWeakRef;
    private OpenGameDebugFloatBall debugFloatBall;
    private long gameId;
    private com.bytedance.android.live.broadcastgame.opengame.i.a initCallback;
    private com.bytedance.android.live.broadcastgame.api.openplatform.b pluginManager;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements IQRCodeService.b {
        public final /* synthetic */ OpenPlatformBaseDebugger a;

        public b(OpenPlatformBaseDebugger r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.broadcastgame.api.opengame.qrcode.IQRCodeService.b
        public final boolean b(int r2) {
            return this.a.onScanFail(r2);
        }

        @Override // com.bytedance.android.live.broadcastgame.api.opengame.qrcode.IQRCodeService.b
        public final boolean c(String r2) {
            return this.a.onScanSuccess(r2);
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.debug.c
    public abstract /* synthetic */ PluginType getPluginType();

    public abstract boolean onScanFail(int r1);

    public abstract boolean onScanSuccess(String r1);

    public abstract /* synthetic */ void setPluginType(PluginType r1);

    @Override // com.bytedance.android.live.broadcastgame.opengame.i
    public void stopDebug() {
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [android.view.View, com.bytedance.android.live.broadcastgame.opengame.debug.OpenGameDebugFloatBall] */
    public final void createDebugFloatBall() {
        int r0 = OpenGameDebugFloatBall.b;
        WeakReference<Context> r1 = this.contextWeakRef;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("contextWeakRef");
    L5:
        Context r2 = r1.get();
        if (r2 != null) goto L8;
        return;
    L8:
        WeakReference<ViewGroup> r3 = this.containerViewWeakRef;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("containerViewWeakRef");
    L11:
        ViewGroup r4 = r3.get();
        if (r4 != null) goto L14;
        return;
    L14:
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "rootView");
        Intrinsics.checkNotNullParameter(this, "executor");
        ?? r5 = new OpenGameDebugFloatBall(r4, r2);
        r5.a = this;
        this.debugFloatBall = r5;
        UtilityKotlinExtentionsKt.w(r5);
        InteractGameContext r6 = InteractGameContext.Companion.getContext();
        if (r6 == null) goto L19;
        com.bytedance.live.datacontext.m<Boolean> r7 = r6.getHasDebugFloatBallShow();
        if (r7 == null) goto L19;
        r7.setValue(Boolean.TRUE);
    L19:
        int r8 = q.a;
        q.g("执行 createDebugFloatBall()，显示调试悬浮球", "");
    }

    public final WeakReference<ViewGroup> getContainerViewWeakRef() {
        WeakReference<ViewGroup> r0 = this.containerViewWeakRef;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("containerViewWeakRef");
    L5:
        return r0;
    }

    public final WeakReference<Context> getContextWeakRef() {
        WeakReference<Context> r0 = this.contextWeakRef;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("contextWeakRef");
    L5:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, com.bytedance.android.live.broadcastgame.opengame.debug.OpenGameDebugFloatBall] */
    @Override // com.bytedance.android.live.broadcastgame.opengame.i
    public void releaseDebug() {
        ?? r0 = this.debugFloatBall;
        if (r0 == 0) goto L11;
        WeakReference<ViewGroup> r2 = this.containerViewWeakRef;
        if (r2 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("containerViewWeakRef");
    L7:
        ViewGroup r3 = r2.get();
        if (r3 == 0) goto L10;
        r3.removeView(r0);
    L10:
        UtilityKotlinExtentionsKt.t(r0);
        r0.a = null;
    L11:
        this.debugFloatBall = null;
        this.pluginManager = null;
        this.initCallback = null;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.debug.c
    public void scanQRCode() {
        int r0 = q.a;
        q.g("扫描二维码", "");
        IQRCodeService r1 = (IQRCodeService) jc1.k.f(IQRCodeService.class);
        if (r1 == null) goto L12;
        WeakReference<Context> r2 = this.contextWeakRef;
        if (r2 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("contextWeakRef");
    L7:
        Context r3 = r2.get();
        if (r3 != null) goto L10;
        return;
    L10:
        r1.startScanQRCode(r3, new b(this));
        return;
    }

    public OpenPlatformBaseDebugger() {
        this.appId = "";
    }

    public final String getAppId() {
        return this.appId;
    }

    public final long getGameId() {
        return this.gameId;
    }

    public final com.bytedance.android.live.broadcastgame.opengame.i.a getInitCallback() {
        return this.initCallback;
    }

    public final com.bytedance.android.live.broadcastgame.api.openplatform.b getPluginManager() {
        return this.pluginManager;
    }

    public final void setAppId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.appId = r2;
    }

    public final void setContainerViewWeakRef(WeakReference<ViewGroup> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.containerViewWeakRef = r2;
    }

    public final void setContextWeakRef(WeakReference<Context> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.contextWeakRef = r2;
    }

    public final void setGameId(long r1) {
        this.gameId = r1;
    }

    public final void setInitCallback(com.bytedance.android.live.broadcastgame.opengame.i.a r1) {
        this.initCallback = r1;
    }

    public final void setPluginManager(com.bytedance.android.live.broadcastgame.api.openplatform.b r1) {
        this.pluginManager = r1;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.i
    public void initDebug(Context r2, DataCenter r3, ViewGroup r4, com.bytedance.android.live.broadcastgame.api.openplatform.b r5, Map<String, ? extends Object> r6, com.bytedance.android.live.broadcastgame.opengame.i.a r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "containerView");
        Intrinsics.checkNotNullParameter(r5, "gameManager");
        Intrinsics.checkNotNullParameter(r6, "extraParams");
        Intrinsics.checkNotNullParameter(r7, "callback");
        this.contextWeakRef = new WeakReference(r2);
        this.containerViewWeakRef = new WeakReference(r4);
        this.pluginManager = r5;
        this.initCallback = r7;
    }
}
