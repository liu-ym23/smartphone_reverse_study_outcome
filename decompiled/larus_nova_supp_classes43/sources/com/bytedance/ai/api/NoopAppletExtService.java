package com.bytedance.ai.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import rv3.b0;
import rv3.c0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH\u0016JF\u0010\n\u001a\u00020\u00052<\u0010\u000b\u001a8\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00050\fH\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001a\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001e\u0010\u001e\u001a\u00020\u00142\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00070 H\u0016J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00180\"H\u0016J\u0012\u0010#\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0016\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00180 H\u0016J@\u0010%\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00180\"2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00050(2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010H\u0016J\u0012\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u0012\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020\u0018H\u0016J\u0010\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u0018H\u0016J\b\u00102\u001a\u00020\u0014H\u0016¨\u00063"}, d2 = {"Lcom/bytedance/ai/api/NoopAppletExtService;", "Lcom/bytedance/ai/api/AppletExtService;", "<init>", "()V", "processAISDKConfig", "", "config", "", "init", "Lcom/bytedance/ai/api/AppletAppConfig;", "injectWidgetMenuAction", "deleteAction", "Lkotlin/Function2;", "Lkotlin/ParameterName;", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "widgetContainer", "Lkotlin/Function0;", "callback", "notifyChatWillReady", "checkIsAppletAppActivity", "", com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY, "Landroid/app/Activity;", "getAppletAppId", "", "interceptNavigation", "context", "Landroid/content/Context;", "args", "Landroid/os/Bundle;", "openAppletApp", "params", "", "getAlarmListWithKeepStatus", "", "processRequest", "getLastPageInfo", "showMapSelectDialog", "optionList", "selectedCallback", "Lkotlin/Function1;", "", "cancelCallback", "obtainWidgetLongClickListener", "Landroid/view/View$OnLongClickListener;", "createAppletAppFragment", "Landroidx/fragment/app/Fragment;", BdpAwemeConstant.KEY_APP_ID, "updateAppList", "appletId", "dismissMapSelectDialog", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NoopAppletExtService implements AppletExtService {
    public static final NoopAppletExtService a = null;

    static {
        a = new NoopAppletExtService();
    }

    private NoopAppletExtService() {
    }

    @Override // com.bytedance.ai.api.AppletExtService
    public final void b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "appletId");
    }

    @Override // com.bytedance.ai.api.AppletExtService
    public final void e() {
    }

    @Override // com.bytedance.ai.api.AppletExtService
    public final boolean f(Context r10, List r11, b0 r12, c0 r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "optionList");
        Intrinsics.checkNotNullParameter(r12, "selectedCallback");
        Intrinsics.checkNotNullParameter(r13, "cancelCallback");
        return false;
    }

    @Override // com.bytedance.ai.api.AppletExtService
    public final String g(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        return "";
    }

    @Override // com.bytedance.ai.api.AppletExtService
    public final boolean h(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "params");
        return false;
    }

    @Override // com.bytedance.ai.api.AppletExtService
    public final void k(Function2<Object, ? super Function0<Unit>, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "deleteAction");
    }

    @Override // com.bytedance.ai.api.AppletExtService
    public final View.OnLongClickListener l(Object r10) {
        Intrinsics.checkNotNullParameter(r10, "widgetContainer");
        return null;
    }

    @Override // com.bytedance.ai.api.AppletExtService
    public final Fragment m(String r10) {
        Intrinsics.checkNotNullParameter(r10, BdpAwemeConstant.KEY_APP_ID);
        return null;
    }

    @Override // com.bytedance.ai.api.AppletExtService
    public final boolean n() {
        return false;
    }

    @Override // com.bytedance.ai.api.AppletExtService
    public final boolean o(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        return false;
    }

    @Override // com.bytedance.ai.api.AppletExtService
    public final boolean p(Context r1, Bundle r10) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return false;
    }

    @Override // com.bytedance.ai.api.AppletExtService
    public final Bundle q(Bundle r10) {
        Intrinsics.checkNotNullParameter(r10, "args");
        return null;
    }

    @Override // com.bytedance.ai.api.AppletExtService
    public final void r(a r10) {
        Intrinsics.checkNotNullParameter(r10, "config");
    }

    @Override // com.bytedance.ai.api.AppletExtService
    public final void s(Object r10) {
        Intrinsics.checkNotNullParameter(r10, "config");
    }

    @Override // com.bytedance.ai.api.AppletExtService
    public final List<String> d() {
        return CollectionsKt.emptyList();
    }

    @Override // com.bytedance.ai.api.AppletExtService
    public final Map<String, String> j() {
        return MapsKt.emptyMap();
    }

    @Override // com.bytedance.ai.api.AppletExtService
    public final boolean i(String r10) {
        Intrinsics.checkNotNullParameter(r10, "userId");
        return false;
    }
}
