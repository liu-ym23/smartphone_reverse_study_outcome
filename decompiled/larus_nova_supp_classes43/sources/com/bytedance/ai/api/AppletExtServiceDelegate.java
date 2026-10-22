package com.bytedance.ai.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import rv3.b0;
import rv3.c0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0013\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0001J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000bH\u0096\u0001J\t\u0010\u0010\u001a\u00020\u0005H\u0096\u0001J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012H\u0096\u0001J\u0011\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0017\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0015H\u0096\u0001J\u0011\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0096\u0001JG\u0010\u001a\u001a\u00020\u00172<\u0010\u001b\u001a8\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00170!¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00170\u001cH\u0096\u0001J\u001b\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0096\u0001J\t\u0010(\u001a\u00020\u0017H\u0096\u0001J\u0013\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010 \u001a\u00020\u001dH\u0096\u0001J\u001f\u0010+\u001a\u00020\u00052\u0014\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0015H\u0096\u0001J\u0011\u0010-\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u001dH\u0096\u0001J\u0013\u0010.\u001a\u0004\u0018\u00010'2\u0006\u0010&\u001a\u00020'H\u0096\u0001J^\u0010/\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u000b2\u0006\u00104\u001a\u0002022\b\u00105\u001a\u0004\u0018\u00010\u00052\b\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u00010\u000b2\b\u00109\u001a\u0004\u0018\u00010\u000bH\u0096\u0001¢\u0006\u0002\u0010:JA\u0010;\u001a\u00020\u00052\u0006\u0010$\u001a\u00020%2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00122\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020\u00170>2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00170!H\u0096\u0001J\u0011\u0010A\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u000bH\u0096\u0001J\u0011\u0010C\u001a\u00020\u00172\u0006\u0010D\u001a\u00020\u000bH\u0096\u0001J/\u0010E\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010F\u001a\u0004\u0018\u0001022\b\u0010G\u001a\u0004\u0018\u0001022\b\u0010H\u001a\u0004\u0018\u00010\u000bH\u0096\u0001¨\u0006I"}, d2 = {"Lcom/bytedance/ai/api/AppletExtServiceDelegate;", "Lcom/bytedance/ai/api/AppletExtService;", "<init>", "()V", "checkIsAppletAppActivity", "", com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY, "Landroid/app/Activity;", "createAppletAppFragment", "Landroidx/fragment/app/Fragment;", BdpAwemeConstant.KEY_APP_ID, "", "destroyLiveCardByKey", "Lcom/bytedance/ai/api/LiveCardClientResult;", "sessionKey", "reason", "dismissMapSelectDialog", "getAlarmListWithKeepStatus", "", "getAppletAppId", "getLastPageInfo", "", "init", "", "config", "Lcom/bytedance/ai/api/AppletAppConfig;", "injectWidgetMenuAction", "deleteAction", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "widgetContainer", "Lkotlin/Function0;", "callback", "interceptNavigation", "context", "Landroid/content/Context;", "args", "Landroid/os/Bundle;", "notifyChatWillReady", "obtainWidgetLongClickListener", "Landroid/view/View$OnLongClickListener;", "openAppletApp", "params", "processAISDKConfig", "processRequest", "showLiveCardByKey", "collapseTemplateId", "collapseTemplateData", "Lorg/json/JSONObject;", "expandTemplateId", "expandTemplateData", "canFrontShow", "autoDismissDurationMs", "", "traceBiz", "traceId", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/ai/api/LiveCardClientResult;", "showMapSelectDialog", "optionList", "selectedCallback", "Lkotlin/Function1;", "", "cancelCallback", "triggerCalendarSync", "userId", "updateAppList", "appletId", "updateLiveCardByKey", "collapsePatch", "expandPatch", "mode", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletExtServiceDelegate implements AppletExtService {
    public static final AppletExtServiceDelegate b = null;
    public final /* synthetic */ AppletExtService a;

    static {
        b = new AppletExtServiceDelegate();
    }

    @Override // com.bytedance.ai.api.AppletExtService
    public final void b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "appletId");
        this.a.b(r10);
    }

    @Override // com.bytedance.ai.api.AppletExtService
    public final List<String> d() {
        return this.a.d();
    }

    @Override // com.bytedance.ai.api.AppletExtService
    public final void e() {
        this.a.e();
    }

    @Override // com.bytedance.ai.api.AppletExtService
    public final boolean f(Context r10, List r11, b0 r12, c0 r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "optionList");
        Intrinsics.checkNotNullParameter(r12, "selectedCallback");
        Intrinsics.checkNotNullParameter(r13, "cancelCallback");
        return this.a.f(r10, r11, r12, r13);
    }

    @Override // com.bytedance.ai.api.AppletExtService
    public final String g(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        return this.a.g(r10);
    }

    @Override // com.bytedance.ai.api.AppletExtService
    public final boolean h(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "params");
        return this.a.h(r10);
    }

    @Override // com.bytedance.ai.api.AppletExtService
    public final boolean i(String r10) {
        Intrinsics.checkNotNullParameter(r10, "userId");
        return this.a.i(r10);
    }

    @Override // com.bytedance.ai.api.AppletExtService
    public final Map<String, String> j() {
        return this.a.j();
    }

    @Override // com.bytedance.ai.api.AppletExtService
    public final void k(Function2<Object, ? super Function0<Unit>, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "deleteAction");
        this.a.k(r10);
    }

    @Override // com.bytedance.ai.api.AppletExtService
    public final View.OnLongClickListener l(Object r10) {
        Intrinsics.checkNotNullParameter(r10, "widgetContainer");
        return this.a.l(r10);
    }

    @Override // com.bytedance.ai.api.AppletExtService
    public final Fragment m(String r10) {
        Intrinsics.checkNotNullParameter(r10, BdpAwemeConstant.KEY_APP_ID);
        return this.a.m(r10);
    }

    @Override // com.bytedance.ai.api.AppletExtService
    public final boolean n() {
        return this.a.n();
    }

    @Override // com.bytedance.ai.api.AppletExtService
    public final boolean o(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        return this.a.o(r10);
    }

    @Override // com.bytedance.ai.api.AppletExtService
    public final boolean p(Context r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        return this.a.p(r10, r11);
    }

    @Override // com.bytedance.ai.api.AppletExtService
    public final Bundle q(Bundle r10) {
        Intrinsics.checkNotNullParameter(r10, "args");
        return this.a.q(r10);
    }

    @Override // com.bytedance.ai.api.AppletExtService
    public final void r(a r10) {
        Intrinsics.checkNotNullParameter(r10, "config");
        this.a.r(r10);
    }

    @Override // com.bytedance.ai.api.AppletExtService
    public final void s(Object r10) {
        Intrinsics.checkNotNullParameter(r10, "config");
        this.a.s(r10);
    }

    private AppletExtServiceDelegate() {
        AppletExtService r0 = (AppletExtService) ServiceManager.get().getService(AppletExtService.class);
        if (r0 != null) goto L5;
        r0 = NoopAppletExtService.a;
    L5:
        this.a = r0;
    }
}
