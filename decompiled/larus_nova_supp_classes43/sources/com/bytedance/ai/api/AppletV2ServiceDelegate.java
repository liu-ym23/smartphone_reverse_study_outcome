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
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00050\tH\u0096\u0001JM\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u001028\u0010\u0011\u001a4\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0014\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00050\u0012H\u0096\u0001JC\u0010\u0016\u001a\u00020\u000528\u0010\b\u001a4\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0017\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00050\u0012H\u0096\u0001Jf\u0010\u0018\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102Q\u0010\u0011\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00050\u0019H\u0096\u0001J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0001J\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001f\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0002\u0010 J\t\u0010!\u001a\u00020\u0005H\u0096\u0001J\u0018\u0010\"\u001a\u0004\u0018\u00010\u00132\u0006\u0010\r\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0002\u0010 JC\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u00102\b\u0010)\u001a\u0004\u0018\u00010\u00102\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020,\u0018\u00010+H\u0096\u0001J>\u0010-\u001a\u00020\u00052\u0006\u0010$\u001a\u00020%2\u0006\u0010(\u001a\u00020\u00102#\u0010\u0011\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00050\tH\u0096\u0001J{\u0010/\u001a\u00020\u00052\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020,0+2\u0006\u0010\u0006\u001a\u0002012\u0006\u00102\u001a\u00020\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u00103\u001a\u0004\u0018\u00010\u001028\u0010\u0011\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00050\u0012H\u0096\u0001J>\u00104\u001a\u00020\u00052\b\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u00020\u00102!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020\u00050\tH\u0096\u0001J\u0019\u00109\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0013H\u0096\u0001J#\u0010;\u001a\u00020\u00132\u0006\u0010<\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u00132\b\u0010=\u001a\u0004\u0018\u00010\u0010H\u0096\u0001J%\u0010>\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020?2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\u00050\tH\u0096\u0001J%\u0010A\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u0002012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\tH\u0096\u0001J\u0019\u0010B\u001a\u00020\u00052\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u0010H\u0096\u0001J\u0011\u0010F\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u0010H\u0096\u0001JD\u0010G\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u00102\u0006\u0010I\u001a\u00020\u00102\u0006\u0010J\u001a\u00020\u00102!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020\u00050\tH\u0096\u0001¨\u0006K"}, d2 = {"Lcom/bytedance/ai/api/AppletV2ServiceDelegate;", "Lcom/bytedance/ai/api/AppletV2Service;", "<init>", "()V", "appletOnRequestLunaMusicAuth", "", "config", "Lcom/bytedance/ai/api/AppletRequestLunaMusicConfig;", "callback", "Lkotlin/Function1;", "Lcom/bytedance/ai/api/OperateResult;", "Lkotlin/ParameterName;", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, com.bytedance.android.ec.core.event.a.KEY_RESULT, "checkAppletFirstPartyAuthStatus", "requiredScope", "", "completion", "Lkotlin/Function2;", "", "isAuthorized", "errorMsg", "checkMusicLoginStatus", "isLogin", "getAppletFirstPartyAuthToken", "Lkotlin/Function3;", "openId", "accessToken", "getNativeLoginCard", "Landroid/view/View;", "handleDebugScanCode", "code", "(Ljava/lang/String;)Ljava/lang/Boolean;", "init", "isDebugMode", "onAppletSystemSheetMenuItemClick", "context", "Landroid/content/Context;", "itemId", "", "appletId", "appletName", "extraInfo", "", "", "openAppletSettings", "errorMessage", "requestAppletFirstPartyAuth", "traceInfo", "Lcom/bytedance/ai/api/MiniApplicationDialogConfig;", "isMiniApplication", "optionalScope", "requestPermission", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "permissionName", "success", "resendQueryMsg", "queryMsgId", "resendUserQueryAfterLogin", "messageId", "reason", "showDoubaoBottomSheet", "Lcom/bytedance/ai/api/AppletBottomSheetConfig;", "Lcom/bytedance/ai/api/AppletBottomSheetResult;", "showMiniApplicationDialog", "showToast", "toastIconType", "Lcom/bytedance/ai/api/ToastIconType;", "toastContent", "updateAppList", "updatePermissionApplyMsgContent", "msgId", "cardId", "contentDataStr", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletV2ServiceDelegate implements AppletV2Service {
    public static final AppletV2ServiceDelegate b = null;
    public final /* synthetic */ AppletV2Service a;

    static {
        b = new AppletV2ServiceDelegate();
    }

    @Override // com.bytedance.ai.api.AppletV2Service
    public final void a(Context r10, String r11, com.bytedance.ai.bridge.method.authorize.b r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "appletId");
        Intrinsics.checkNotNullParameter(r12, "completion");
        this.a.a(r10, r11, r12);
    }

    @Override // com.bytedance.ai.api.AppletV2Service
    public final void b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "appletId");
        this.a.b(r10);
    }

    @Override // com.bytedance.ai.api.AppletV2Service
    public final void c(Function2<? super Boolean, ? super String, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "callback");
        this.a.c(r10);
    }

    @Override // com.bytedance.ai.api.AppletV2Service
    public final void d(AppletAppActivity r10, int r11, String r12, String r13, Map r14) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this.a.d(r10, r11, r12, r13, r14);
    }

    @Override // com.bytedance.ai.api.AppletV2Service
    public final void e(String r10, n1 r11) {
        Intrinsics.checkNotNullParameter(r11, "completion");
        this.a.e(r10, r11);
    }

    @Override // com.bytedance.ai.api.AppletV2Service
    public final void f(String r10, m1 r11) {
        Intrinsics.checkNotNullParameter(r11, "completion");
        this.a.f(r10, r11);
    }

    @Override // com.bytedance.ai.api.AppletV2Service
    public final void g(FragmentActivity r10, String r11, Function1<? super Boolean, Unit> r12) {
        Intrinsics.checkNotNullParameter(r11, "permissionName");
        Intrinsics.checkNotNullParameter(r12, "completion");
        this.a.g(r10, r11, r12);
    }

    @Override // com.bytedance.ai.api.AppletV2Service
    public final void h(g r10, o1 r11) {
        Intrinsics.checkNotNullParameter(r10, "config");
        Intrinsics.checkNotNullParameter(r11, "callback");
        this.a.h(r10, r11);
    }

    @Override // com.bytedance.ai.api.AppletV2Service
    public final void i(p r10, k1 r11) {
        Intrinsics.checkNotNullParameter(r10, "config");
        Intrinsics.checkNotNullParameter(r11, "callback");
        this.a.i(r10, r11);
    }

    @Override // com.bytedance.ai.api.AppletV2Service
    public final void init() {
        this.a.init();
    }

    @Override // com.bytedance.ai.api.AppletV2Service
    public final void j(String r10, String r11, String r12, Function1<? super Boolean, Unit> r13) {
        Intrinsics.checkNotNullParameter(r10, "msgId");
        Intrinsics.checkNotNullParameter(r11, "cardId");
        Intrinsics.checkNotNullParameter(r12, "contentDataStr");
        Intrinsics.checkNotNullParameter(r13, "completion");
        this.a.j(r10, r11, r12, r13);
    }

    @Override // com.bytedance.ai.api.AppletV2Service
    public final void k(ToastIconType r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "toastIconType");
        Intrinsics.checkNotNullParameter(r11, "toastContent");
        this.a.k(r10, r11);
    }

    @Override // com.bytedance.ai.api.AppletV2Service
    public final Boolean l(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_RESULT);
        return this.a.l(r10);
    }

    @Override // com.bytedance.ai.api.AppletV2Service
    public final Boolean m(String r10) {
        Intrinsics.checkNotNullParameter(r10, "code");
        return this.a.m(r10);
    }

    @Override // com.bytedance.ai.api.AppletV2Service
    public final void n(String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "queryMsgId");
        this.a.n(r10, r11);
    }

    @Override // com.bytedance.ai.api.AppletV2Service
    public final void o(Map r10, p r11, boolean r12, String r13, l1 r14) {
        Intrinsics.checkNotNullParameter(r10, "traceInfo");
        Intrinsics.checkNotNullParameter(r11, "config");
        Intrinsics.checkNotNullParameter(r14, "completion");
        this.a.o(r10, r11, r12, r13, r14);
    }

    @Override // com.bytedance.ai.api.AppletV2Service
    public final void p(e r10, p1 r11) {
        Intrinsics.checkNotNullParameter(r10, "config");
        Intrinsics.checkNotNullParameter(r11, "callback");
        this.a.p(r10, r11);
    }

    private AppletV2ServiceDelegate() {
        AppletV2Service r0 = (AppletV2Service) ServiceManager.get().getService(AppletV2Service.class);
        if (r0 != null) goto L5;
        r0 = NoopAppletV2Service.a;
    L5:
        this.a = r0;
    }
}
