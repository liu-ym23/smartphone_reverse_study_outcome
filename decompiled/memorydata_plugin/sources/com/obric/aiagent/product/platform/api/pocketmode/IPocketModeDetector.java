package com.obric.aiagent.product.platform.api.pocketmode;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J*\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH&J\u000e\u0010\f\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0005H&J\b\u0010\u0010\u001a\u00020\u0005H&J\b\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\u0005H&¨\u0006\u0013"}, d2 = {"Lcom/obric/aiagent/product/platform/api/pocketmode/IPocketModeDetector;", "", "checkAsync", "", "isCheckPassed", "", "showProximityNearAlert", "onUserActionBlocked", "needVibrate", "isAppBackground", "showToastAction", "Lkotlin/Function0;", "awaitCheckPassed", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", CommonConsts.APM_INNER_EVENT_COST_INIT, "isPocketModeEnabled", "isPocketModeManuallyDismissed", "hideProximityNearAlert", "isProximityNearAlertShowing", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IPocketModeDetector {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void onUserActionBlocked$default(IPocketModeDetector r2, boolean r3, boolean r4, Function0 r5, int r6, Object r7) {
            IPocketModeDetector r8 = (IPocketModeDetector) ZeusTransformUtils.wrapperContextForParams(r2, IPocketModeDetector.class, "com.obric.memorydata.plugin");
            Function0<Unit> r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
            if (r7 != null) goto L13;
            if ((r6 & 1) == 0) goto L8;
            r3 = true;
        L8:
            if ((r6 & 2) == 0) goto L10;
            r4 = false;
        L10:
            r8.onUserActionBlocked(r3, r4, r9);
            return;
        L13:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onUserActionBlocked");
        }
    }

    Object awaitCheckPassed(Continuation<? super Boolean> r1);

    void checkAsync();

    void hideProximityNearAlert();

    void init();

    boolean isCheckPassed();

    boolean isPocketModeEnabled();

    boolean isPocketModeManuallyDismissed();

    boolean isProximityNearAlertShowing();

    void onUserActionBlocked(boolean r1, boolean r2, Function0<Unit> r3);

    void showProximityNearAlert();
}
