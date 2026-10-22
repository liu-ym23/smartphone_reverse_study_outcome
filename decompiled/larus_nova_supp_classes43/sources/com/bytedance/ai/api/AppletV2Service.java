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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0006H&¢\u0006\u0002\u0010\nJ\"\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H&J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\u0017\u0010\u0011\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\u0006H&¢\u0006\u0002\u0010\nJ\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006H&J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\bH&JC\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00030\u001eH&J=\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020\u00062!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00030\u001eH&JB\u0010%\u001a\u00020\u000328\u0010&\u001a4\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b((\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u00030'H&JB\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010/\u001a\u0004\u0018\u00010\u00062\u0014\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u000101H&J=\u00102\u001a\u00020\u00032\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0005\u001a\u00020\u00062#\u0010\u001d\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(3\u0012\u0004\u0012\u00020\u00030\u001eH\u0016J3\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u0002062!\u0010&\u001a\u001d\u0012\u0013\u0012\u001107¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00030\u001eH&J$\u00108\u001a\u00020\u00032\u0006\u00105\u001a\u0002092\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u00030\u001eH&J$\u0010:\u001a\u00020\u00032\u0006\u00105\u001a\u00020;2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u00030\u001eH&J~\u0010=\u001a\u00020\u00032\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001012\u0006\u00105\u001a\u0002092\u0006\u0010?\u001a\u00020\b2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u000628\u0010\u001d\u001a4\u0012\u0013\u0012\u001107¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u00030'H&JN\u0010B\u001a\u00020\u00032\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u000628\u0010\u001d\u001a4\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(C\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u00030'H&Jg\u0010D\u001a\u00020\u00032\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00062Q\u0010\u001d\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(F\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(G\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u00030EH&¨\u0006H"}, d2 = {"Lcom/bytedance/ai/api/AppletV2Service;", "", "init", "", "updateAppList", "appletId", "", "handleDebugScanCode", "", "code", "(Ljava/lang/String;)Ljava/lang/Boolean;", "resendUserQueryAfterLogin", "messageId", "success", "reason", "getNativeLoginCard", "Landroid/view/View;", "isDebugMode", com.bytedance.android.ec.core.event.a.KEY_RESULT, "showToast", "toastIconType", "Lcom/bytedance/ai/api/ToastIconType;", "toastContent", "resendQueryMsg", "queryMsgId", "updatePermissionApplyMsgContent", "msgId", "cardId", "contentDataStr", "completion", "Lkotlin/Function1;", "Lkotlin/ParameterName;", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "requestPermission", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "permissionName", "checkMusicLoginStatus", "callback", "Lkotlin/Function2;", "isLogin", "errorMsg", "onAppletSystemSheetMenuItemClick", "context", "Landroid/content/Context;", "itemId", "", "appletName", "extraInfo", "", "openAppletSettings", "errorMessage", "appletOnRequestLunaMusicAuth", "config", "Lcom/bytedance/ai/api/AppletRequestLunaMusicConfig;", "Lcom/bytedance/ai/api/OperateResult;", "showMiniApplicationDialog", "Lcom/bytedance/ai/api/MiniApplicationDialogConfig;", "showDoubaoBottomSheet", "Lcom/bytedance/ai/api/AppletBottomSheetConfig;", "Lcom/bytedance/ai/api/AppletBottomSheetResult;", "requestAppletFirstPartyAuth", "traceInfo", "isMiniApplication", "requiredScope", "optionalScope", "checkAppletFirstPartyAuthStatus", "isAuthorized", "getAppletFirstPartyAuthToken", "Lkotlin/Function3;", "openId", "accessToken", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface AppletV2Service {
    void a(Context r1, String r10, com.bytedance.ai.bridge.method.authorize.b r11);

    void b(String r1);

    void c(Function2<? super Boolean, ? super String, Unit> r1);

    void d(AppletAppActivity r1, int r10, String r11, String r12, Map r13);

    void e(String r1, n1 r10);

    void f(String r1, m1 r10);

    void g(FragmentActivity r1, String r10, Function1<? super Boolean, Unit> r11);

    void h(g r1, o1 r10);

    void i(p r1, k1 r10);

    void init();

    void j(String r1, String r10, String r11, Function1<? super Boolean, Unit> r12);

    void k(ToastIconType r1, String r10);

    Boolean l(String r1);

    Boolean m(String r1);

    void n(String r1, boolean r10);

    void o(Map r1, p r10, boolean r11, String r12, l1 r13);

    void p(e r1, p1 r10);
}
