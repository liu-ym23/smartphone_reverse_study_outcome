package com.bytedance.ai.api;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.applet.app.AppletAppActivity;
import com.bytedance.applet.impl.k1;
import com.bytedance.applet.impl.l1;
import com.bytedance.applet.impl.m1;
import com.bytedance.applet.impl.n1;
import com.bytedance.applet.impl.o1;
import com.bytedance.applet.impl.p1;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0017\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\fJ\"\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0017\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0014\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\fJ\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bH\u0016J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\nH\u0016JC\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\b2!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00050 H\u0016J=\u0010#\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\b2!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00050 H\u0016JB\u0010'\u001a\u00020\u000528\u0010(\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(*\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u00050)H\u0016JB\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u00101\u001a\u0004\u0018\u00010\b2\u0014\u00102\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u000204\u0018\u000103H\u0016J3\u00105\u001a\u00020\u00052\u0006\u00106\u001a\u0002072!\u0010(\u001a\u001d\u0012\u0013\u0012\u001108¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00050 H\u0016J$\u00109\u001a\u00020\u00052\u0006\u00106\u001a\u00020:2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u00050 H\u0016J$\u0010;\u001a\u00020\u00052\u0006\u00106\u001a\u00020<2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020\u00050 H\u0016Jz\u0010>\u001a\u00020\u00052\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u000204032\u0006\u00106\u001a\u00020:2\u0006\u0010@\u001a\u00020\n2\b\u0010A\u001a\u0004\u0018\u00010\b2\b\u0010B\u001a\u0004\u0018\u00010\b28\u0010\u001f\u001a4\u0012\u0013\u0012\u001108¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0014\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u00050)H\u0016JL\u0010C\u001a\u00020\u00052\b\u0010A\u001a\u0004\u0018\u00010\b28\u0010\u001f\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(D\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u00050)H\u0016Je\u0010E\u001a\u00020\u00052\b\u0010A\u001a\u0004\u0018\u00010\b2Q\u0010\u001f\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(G\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(H\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u00050FH\u0016R\u000e\u0010I\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/bytedance/ai/api/NoopAppletV2Service;", "Lcom/bytedance/ai/api/AppletV2Service;", "<init>", "()V", "init", "", "updateAppList", "appletId", "", "handleDebugScanCode", "", "code", "(Ljava/lang/String;)Ljava/lang/Boolean;", "resendUserQueryAfterLogin", "messageId", "success", "reason", "getNativeLoginCard", "Landroid/view/View;", "isDebugMode", com.bytedance.android.ec.core.event.a.KEY_RESULT, "showToast", "toastIconType", "Lcom/bytedance/ai/api/ToastIconType;", "toastContent", "resendQueryMsg", "queryMsgId", "updatePermissionApplyMsgContent", "msgId", "cardId", "contentDataStr", "completion", "Lkotlin/Function1;", "Lkotlin/ParameterName;", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "requestPermission", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "permissionName", "checkMusicLoginStatus", "callback", "Lkotlin/Function2;", "isLogin", "errorMsg", "onAppletSystemSheetMenuItemClick", "context", "Landroid/content/Context;", "itemId", "", "appletName", "extraInfo", "", "", "appletOnRequestLunaMusicAuth", "config", "Lcom/bytedance/ai/api/AppletRequestLunaMusicConfig;", "Lcom/bytedance/ai/api/OperateResult;", "showMiniApplicationDialog", "Lcom/bytedance/ai/api/MiniApplicationDialogConfig;", "showDoubaoBottomSheet", "Lcom/bytedance/ai/api/AppletBottomSheetConfig;", "Lcom/bytedance/ai/api/AppletBottomSheetResult;", "requestAppletFirstPartyAuth", "traceInfo", "isMiniApplication", "requiredScope", "optionalScope", "checkAppletFirstPartyAuthStatus", "isAuthorized", "getAppletFirstPartyAuthToken", "Lkotlin/Function3;", "openId", "accessToken", "MSG_UNAVAILABLE", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NoopAppletV2Service implements AppletV2Service {
    public static final NoopAppletV2Service a = null;

    static {
        a = new NoopAppletV2Service();
    }

    private NoopAppletV2Service() {
    }

    @Override // com.bytedance.ai.api.AppletV2Service
    public final void b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "appletId");
    }

    @Override // com.bytedance.ai.api.AppletV2Service
    public final void d(AppletAppActivity r1, int r10, String r11, String r12, Map r13) {
        Intrinsics.checkNotNullParameter(r1, "context");
    }

    @Override // com.bytedance.ai.api.AppletV2Service
    public final void init() {
    }

    @Override // com.bytedance.ai.api.AppletV2Service
    public final void k(ToastIconType r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "toastIconType");
        Intrinsics.checkNotNullParameter(r11, "toastContent");
    }

    @Override // com.bytedance.ai.api.AppletV2Service
    public final void n(String r1, boolean r10) {
        Intrinsics.checkNotNullParameter(r1, "queryMsgId");
    }

    @Override // com.bytedance.ai.api.AppletV2Service
    public final void c(Function2<? super Boolean, ? super String, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "callback");
        r10.invoke(Boolean.FALSE, "AppletV2Service unavailable");
    }

    @Override // com.bytedance.ai.api.AppletV2Service
    public final Boolean l(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_RESULT);
        return Boolean.FALSE;
    }

    @Override // com.bytedance.ai.api.AppletV2Service
    public final Boolean m(String r10) {
        Intrinsics.checkNotNullParameter(r10, "code");
        return Boolean.FALSE;
    }

    @Override // com.bytedance.ai.api.AppletV2Service
    public final void e(String r10, n1 r11) {
        Intrinsics.checkNotNullParameter(r11, "completion");
        r11.invoke(null, null, "AppletV2Service unavailable");
    }

    @Override // com.bytedance.ai.api.AppletV2Service
    public final void f(String r10, m1 r11) {
        Intrinsics.checkNotNullParameter(r11, "completion");
        r11.invoke(Boolean.FALSE, "AppletV2Service unavailable");
    }

    @Override // com.bytedance.ai.api.AppletV2Service
    public final void h(g r10, o1 r11) {
        Intrinsics.checkNotNullParameter(r10, "config");
        Intrinsics.checkNotNullParameter(r11, "callback");
        r11.invoke(OperateResult.CANCEL);
    }

    @Override // com.bytedance.ai.api.AppletV2Service
    public final void i(p r10, k1 r11) {
        Intrinsics.checkNotNullParameter(r10, "config");
        Intrinsics.checkNotNullParameter(r11, "callback");
        r11.invoke(OperateResult.CANCEL);
    }

    @Override // com.bytedance.ai.api.AppletV2Service
    public final void p(e r10, p1 r11) {
        Intrinsics.checkNotNullParameter(r10, "config");
        Intrinsics.checkNotNullParameter(r11, "callback");
        int r12 = f.d;
        r11.invoke(f.a.a(AppletBottomSheetCancelSource.HOST_UNAVAILABLE));
    }

    @Override // com.bytedance.ai.api.AppletV2Service
    public final void a(Context r10, String r11, com.bytedance.ai.bridge.method.authorize.b r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "appletId");
        Intrinsics.checkNotNullParameter(r12, "completion");
        r12.invoke("applet settings are not supported by host");
    }

    @Override // com.bytedance.ai.api.AppletV2Service
    public final void g(FragmentActivity r1, String r10, Function1<? super Boolean, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "permissionName");
        Intrinsics.checkNotNullParameter(r11, "completion");
        r11.invoke(Boolean.FALSE);
    }

    @Override // com.bytedance.ai.api.AppletV2Service
    public final void j(String r10, String r11, String r12, Function1<? super Boolean, Unit> r13) {
        Intrinsics.checkNotNullParameter(r10, "msgId");
        Intrinsics.checkNotNullParameter(r11, "cardId");
        Intrinsics.checkNotNullParameter(r12, "contentDataStr");
        Intrinsics.checkNotNullParameter(r13, "completion");
        r13.invoke(Boolean.FALSE);
    }

    @Override // com.bytedance.ai.api.AppletV2Service
    public final void o(Map r1, p r10, boolean r11, String r12, l1 r13) {
        Intrinsics.checkNotNullParameter(r1, "traceInfo");
        Intrinsics.checkNotNullParameter(r10, "config");
        Intrinsics.checkNotNullParameter(r13, "completion");
        r13.invoke(OperateResult.CANCEL, "AppletV2Service unavailable");
    }
}
