package ia;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.bytedance.android.anniex.container.util.AnnieXContainerManager;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import com.bytedance.ies.bullet.service.sdk.param.LaunchMode;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class b implements c {
    private ia.a _anniexContainerProxy;

    public static final class a extends ia.a {
        public a() {
        }
    }

    @Override // ia.c
    public void bindContainerId(String r10) {
        Intrinsics.checkNotNullParameter(r10, "containerId");
    }

    @Override // ia.c
    public boolean canBackPress() {
        return false;
    }

    @Override // ia.c
    public boolean canGoBack() {
        return false;
    }

    @Override // ia.c
    public void close() {
    }

    @Override // ia.c
    public void enterBackground() {
    }

    @Override // ia.c
    public void enterForeground() {
    }

    @Override // ia.c
    public void finish() {
    }

    @Override // ia.c
    public String getBDXTag() {
        return "";
    }

    @Override // ia.c
    public String getBid() {
        return "";
    }

    @Override // ia.c
    public String getContainerId() {
        return "";
    }

    @Override // ia.c
    public m16.b getContextProviderFactory() {
        return null;
    }

    @Override // ia.c
    public t36.d getCurrentSchema() {
        return null;
    }

    @Override // ia.c
    public String getCurrentUrl() {
        return "";
    }

    @Override // ia.c
    public View getKitView() {
        return null;
    }

    @Override // ia.c
    public t36.d getSchemaData() {
        return null;
    }

    @Override // ia.c
    public Context getSystemContext() {
        return null;
    }

    @Override // ia.c
    public String getViewType() {
        return "";
    }

    @Override // ia.c
    public void goBack() {
    }

    @Override // ia.c
    public void hideError() {
    }

    @Override // ia.c
    public void hideLoading() {
    }

    @Override // ia.c
    public void interceptBackPress(boolean r1) {
    }

    public boolean isVisibility() {
        return false;
    }

    @Override // ia.c
    public void loadSchema(String r1, Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
    }

    public void observerKeyboardStatusChange() {
    }

    @Override // ia.c
    public void onAttachToWindow() {
    }

    @Override // ia.c
    public void onCreate(Bundle r1) {
    }

    @Override // ia.c
    public void onVisibleChange(boolean r1, Boolean r10) {
    }

    public void preloadSchema(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
    }

    @Override // ia.c
    public <T> void registerWeakHolder(Class<T> r1, T r10) {
        Intrinsics.checkNotNullParameter(r1, "clazz");
    }

    @Override // ia.c
    public void reload(Map<String, ? extends Object> r1) {
    }

    @Override // ia.c
    public void reloadTemplate(Map<String, ? extends Object> r1) {
    }

    public void removeKitView() {
    }

    @Override // ia.c
    public void sendEvent(com.bytedance.ies.bullet.core.kit.bridge.h r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
    }

    @Override // ia.c
    public void showError() {
    }

    @Override // ia.c
    public void showLoading(String r1) {
    }

    public void updateData(String r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
    }

    @Override // ia.c
    public void updateData(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
    }

    @Override // ia.c
    public void updateGlobalProps(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "globalProps");
    }

    @Override // ia.c
    public void updateScreenMetrics(int r1, int r10) {
    }

    @Override // ia.c
    public Map<String, Long> getPerfMap() {
        return new LinkedHashMap();
    }

    @Override // ia.c
    public WeakReference<Context> getWeakContext() {
        return new WeakReference(null);
    }

    public final void onKitViewCreate() {
        ia.a r0 = this._anniexContainerProxy;
        if (r0 == null) goto L10;
        AnnieXContainerManager r1 = AnnieXContainerManager.INSTANCE;
        View r10 = getKitView();
        if (r10 == null) goto L7;
        int r11 = r10.hashCode();
    L8:
        r1.saveContainerProxyFromEngineHashCode(r11, r0);
        return;
    L7:
        r11 = -1;
        goto L8
    }

    @Override // ia.c
    public void release() {
        AnnieXContainerManager r0 = AnnieXContainerManager.INSTANCE;
        View r1 = getKitView();
        if (r1 == null) goto L5;
        int r10 = r1.hashCode();
    L6:
        r0.removeContainerProxyFromEngineHashCode(r10);
        this._anniexContainerProxy = null;
        return;
    L5:
        r10 = -1;
        goto L6
    }

    public b() {
        this._anniexContainerProxy = new a();
    }

    @Override // ia.c
    public LaunchMode getBDXLaunchMode() {
        return LaunchMode.MODE_UNSPECIFIED;
    }

    @Override // ia.c
    public KitType getKitType() {
        return KitType.UNKNOWN;
    }

    @Override // ia.c
    public t36.d generateSchemaData(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Lazy r11 = SchemaService.f;
        return SchemaService.a.a().b("default_bid", Uri.EMPTY);
    }

    @Override // ia.c
    public void onEngineReady(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "contextProviderFactory");
    }

    public void recreateKitView(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
    }

    public void loadSchema(String r1, Map<String, ? extends Object> r10, m16.b r11, com.bytedance.android.anniex.base.lifecycle.a r12) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
    }
}
