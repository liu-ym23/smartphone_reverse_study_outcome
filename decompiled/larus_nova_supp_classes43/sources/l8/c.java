package l8;

import android.os.Bundle;
import android.view.View;
import com.bytedance.ai.bridge.service.IHostStyleUIDepend;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.monitor.common.timing.PerformanceTiming;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c extends b7.a {
    public String a;
    public c7.a b;

    @Override // b7.a, b7.b
    public final void onBeforeGlobalPropsInitialize() {
        ConcurrentHashMap<String, PerformanceTiming> r0 = b.a;
        b.b(this.a, "prepare_component_global_props_start");
    }

    @Override // b7.a, b7.b
    public final void onBeforeInitialPropsInitialize() {
        ConcurrentHashMap<String, PerformanceTiming> r0 = b.a;
        b.b(this.a, "prepare_component_initial_props_start");
    }

    @Override // b7.a, b7.b
    public final void onBeforeJsbRegister() {
        ConcurrentHashMap<String, PerformanceTiming> r0 = b.a;
        b.b(this.a, "prepare_component_jsb_start");
    }

    @Override // b7.a, b7.b
    public final void onBeforeOpenContainer() {
        ConcurrentHashMap<String, PerformanceTiming> r0 = b.a;
        b.b(this.a, "open_time");
    }

    @Override // b7.a, b7.b
    public final void onCardLoadStart() {
        ConcurrentHashMap<String, PerformanceTiming> r0 = b.a;
        b.b(this.a, "prepare_card_load_start");
    }

    @Override // b7.a, b7.b
    public final void onContainerInitEnd() {
        ConcurrentHashMap<String, PerformanceTiming> r0 = b.a;
        b.b(this.a, "container_init_end");
    }

    @Override // b7.a, b7.b
    public final void onContainerInitStart() {
        ConcurrentHashMap<String, PerformanceTiming> r0 = b.a;
        b.b(this.a, "container_init_start");
    }

    @Override // b7.a, b7.b
    public final void onEngineLoadEnd() {
        ConcurrentHashMap<String, PerformanceTiming> r0 = b.a;
        b.b(this.a, "prepare_engine_load_end");
    }

    @Override // b7.a, b7.b
    public final void onEngineLoadStart() {
        ConcurrentHashMap<String, PerformanceTiming> r0 = b.a;
        b.b(this.a, "prepare_engine_load_start");
    }

    @Override // b7.a, b7.b
    public final void onGlobalPropsInitialized() {
        ConcurrentHashMap<String, PerformanceTiming> r0 = b.a;
        b.b(this.a, "prepare_component_global_props_end");
    }

    @Override // b7.a, b7.b
    public final void onInitialPropsInitialized() {
        ConcurrentHashMap<String, PerformanceTiming> r0 = b.a;
        b.b(this.a, "prepare_component_initial_props_end");
    }

    @Override // b7.a, b7.b
    public final void onJsbRegistered() {
        ConcurrentHashMap<String, PerformanceTiming> r0 = b.a;
        b.b(this.a, "prepare_component_jsb_end");
    }

    @Override // b7.a, b7.b
    public final void onLynxEnvInitialized() {
        ConcurrentHashMap<String, PerformanceTiming> r0 = b.a;
        b.b(this.a, "prepare_component_lynx_env_end");
    }

    @Override // b7.a, b7.b
    public final void onPrepareComponentEnd() {
        ConcurrentHashMap<String, PerformanceTiming> r0 = b.a;
        b.b(this.a, "prepare_component_end");
    }

    @Override // b7.a, b7.b
    public final void onPrepareComponentStart() {
        ConcurrentHashMap<String, PerformanceTiming> r0 = b.a;
        b.b(this.a, "prepare_component_start");
    }

    @Override // b7.a, b7.b
    public final void onPrepareInitDataEnd() {
        ConcurrentHashMap<String, PerformanceTiming> r0 = b.a;
        b.b(this.a, "prepare_init_data_end");
    }

    @Override // b7.a, b7.b
    public final void onPrepareTemplateStart() {
        ConcurrentHashMap<String, PerformanceTiming> r0 = b.a;
        b.b(this.a, "prepare_template_start");
    }

    @Override // b7.a, b7.b
    public final void onRelease() {
        ConcurrentHashMap<String, PerformanceTiming> r0 = b.a;
        String r1 = this.a;
        Intrinsics.checkNotNullParameter(r1, "uuid");
        b.a.remove(r1);
    }

    public c() {
        this.a = UUID.randomUUID().toString();
    }

    @Override // b7.a, b7.b
    public final void onBeforeCreateRenderData(View r10) {
        Intrinsics.checkNotNullParameter(r10, "hybridView");
        ConcurrentHashMap<String, PerformanceTiming> r11 = b.a;
        b.b(this.a, "prepare_render_data_start");
    }

    @Override // b7.a, b7.b
    public final void onBeforeLynxEnvInitialize(boolean r10) {
        ConcurrentHashMap<String, PerformanceTiming> r11 = b.a;
        b.b(this.a, "prepare_component_lynx_env_start");
    }

    @Override // b7.a, b7.b
    public final void onInit(c7.a r10) {
        Intrinsics.checkNotNullParameter(r10, "annieContext");
        this.b = r10;
        Bundle r11 = r10.getBundle();
        if (r11 == null) goto L9;
        String r0 = r11.getString("annie_uuid_key");
        if (r0 == null) goto L7;
        this.a = r0;
    L7:
        ConcurrentHashMap<String, PerformanceTiming> r1 = b.a;
        String r12 = this.a;
        Intrinsics.checkNotNullParameter(r12, "uuid");
        Intrinsics.checkNotNullParameter(r11, "bundle");
        b.a(r12).setInitBundle(r11);
        return;
    }

    @Override // b7.a, b7.b
    public final void onLoadSuccess(View r10) {
        ConcurrentHashMap<String, PerformanceTiming> r11 = b.a;
        b.b(this.a, "prepare_engine_js_load_end");
        String r12 = this.a;
        c7.a r0 = this.b;
        if (r0 == null) goto L6;
        String r1 = r0.getBizKey();
        if (r1 == null) goto L6;
    L7:
        b.c(r12, r1);
        return;
    L6:
        r1 = "host";
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onPrepareTemplateEnd(boolean r10) {
        ConcurrentHashMap<String, PerformanceTiming> r0 = b.a;
        String r1 = this.a;
        Intrinsics.checkNotNullParameter(r1, "uuid");
        Intrinsics.checkNotNullParameter("prepare_template_end", "stageName");
        PerformanceTiming r11 = b.a(r1);
        if (r10 == false) goto L5;
        String r12 = "gecko";
    L6:
        r11.setTemplateResType(r12);
        r11.put("prepare_template_end", Long.valueOf(System.currentTimeMillis()));
        return;
    L5:
        r12 = "cdn";
        goto L6
    }

    @Override // b7.a, b7.b
    public final void onCreateRenderData(View r10, Set<String> r11) {
        Intrinsics.checkNotNullParameter(r10, "hybridView");
        Intrinsics.checkNotNullParameter(r11, "stateKeys");
        ConcurrentHashMap<String, PerformanceTiming> r12 = b.a;
        b.b(this.a, "prepare_render_data_end");
    }

    @Override // b7.a, b7.b
    public final boolean onFallback(int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "errorMessage");
        a(r10, r11, "fallback");
        return false;
    }

    @Override // b7.a, b7.b
    public final void onInnerFallback(int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "errorMessage");
        a(r10, r11, "fallback");
    }

    @Override // b7.a, b7.b
    public final void onLoadStart(View r1, boolean r10) {
        ConcurrentHashMap<String, PerformanceTiming> r11 = b.a;
        b.b(this.a, "prepare_engine_js_load_start");
    }

    public final void a(int r10, String r11, String r12) {
        ConcurrentHashMap<String, PerformanceTiming> r0 = b.a;
        String r1 = this.a;
        Intrinsics.checkNotNullParameter(r1, "uuid");
        Intrinsics.checkNotNullParameter(r11, "errorMsg");
        Intrinsics.checkNotNullParameter(r12, "reason");
        PerformanceTiming r13 = b.a(r1);
        r13.setErrorMsg(r11);
        r13.setErrorCode(Integer.valueOf(r10));
        r13.setErrorReason(r12);
        String r14 = this.a;
        c7.a r15 = this.b;
        if (r15 == null) goto L6;
        String r16 = r15.getBizKey();
        if (r16 == null) goto L6;
    L7:
        b.c(r14, r16);
        return;
    L6:
        r16 = "host";
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onAttachView(View r10, IHybridComponent.HybridType r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "hybridType");
        ConcurrentHashMap<String, PerformanceTiming> r1 = b.a;
        String r13 = this.a;
        Intrinsics.checkNotNullParameter(r13, "uuid");
        Intrinsics.checkNotNullParameter(r11, "hybridType");
        PerformanceTiming r0 = b.a(r13);
        r0.setEngineType(r11.getHybridName());
        if (r10 == null) goto L5;
        r0.setViewRef(new WeakReference(r10));
    L5:
        if (r12 == null) goto L8;
        r0.setPageType(r12);
        return;
    }

    @Override // b7.a, b7.b
    public final void onContainerError(View r1, int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "errorMessage");
        a(r10, r11, IHostStyleUIDepend.TOAST_TYPE_ERROR);
    }

    @Override // b7.a, b7.b
    public final void onPrepareInitDataStart(String r1, String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_SCHEME);
        Intrinsics.checkNotNullParameter(r10, "fallbackUrl");
        ConcurrentHashMap<String, PerformanceTiming> r12 = b.a;
        b.b(this.a, "prepare_init_data_start");
    }
}
