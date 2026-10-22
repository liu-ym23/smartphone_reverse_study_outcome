package b7;

import android.view.View;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.resource.AnnieResType;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class a implements b {
    public a() {
    }

    public boolean enableInvoke(String r1, JSONObject r10, String r11) {
        return true;
    }

    @Override // b7.b
    public void onAttachView(View r1, IHybridComponent.HybridType r10, String r11) {
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r10, "hybridType");
    }

    @Override // b7.b
    public /* synthetic */ void onAttachedToWindow(String r1) {
    }

    @Override // b7.b
    public void onBeforeCreateRenderData(View r10) {
        Intrinsics.checkNotNullParameter(r10, "hybridView");
    }

    @Override // b7.b
    public void onBeforeGlobalPropsInitialize() {
    }

    @Override // b7.b
    public void onBeforeInitialPropsInitialize() {
    }

    @Override // b7.b
    public void onBeforeJsbRegister() {
    }

    @Override // b7.b
    public void onBeforeLoadRequest(String r1, AnnieResType r10, IHybridComponent.HybridType r11, Map<String, Object> r12) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r10, "resType");
        Intrinsics.checkNotNullParameter(r11, "type");
    }

    @Override // b7.b
    public void onBeforeLynxEnvInitialize(boolean r1) {
    }

    @Override // b7.b
    public void onBeforeOpenContainer() {
    }

    @Override // b7.b
    public void onCardLoadStart() {
    }

    @Override // b7.b
    public void onContainerError(View r1, int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "errorMessage");
    }

    @Override // b7.b
    public void onContainerInitEnd() {
    }

    @Override // b7.b
    public void onContainerInitStart() {
    }

    @Override // b7.b
    public void onCreateRenderData(View r10, Set<String> r11) {
        Intrinsics.checkNotNullParameter(r10, "hybridView");
        Intrinsics.checkNotNullParameter(r11, "stateKeys");
    }

    @Override // b7.b
    public void onEngineLoadEnd() {
    }

    @Override // b7.b
    public void onEngineLoadStart() {
    }

    @Override // b7.b
    public boolean onFallback(int r1, String r10) {
        Intrinsics.checkNotNullParameter(r10, "errorMessage");
        return false;
    }

    @Override // b7.b
    public void onGlobalPropsInitialized() {
    }

    @Override // b7.b
    public void onInit(c7.a r10) {
        Intrinsics.checkNotNullParameter(r10, "annieContext");
    }

    @Override // b7.b
    public void onInitialPropsInitialized() {
    }

    @Override // b7.b
    public void onInnerFallback(int r1, String r10) {
        Intrinsics.checkNotNullParameter(r10, "errorMessage");
    }

    @Override // b7.b
    public void onJsbRegistered() {
    }

    @Override // b7.b
    public void onLoadFail(View r1, String r10, String r11) {
    }

    @Override // b7.b
    public void onLoadStart(View r1, boolean r10) {
    }

    @Override // b7.b
    public void onLoadSuccess(View r1) {
    }

    @Override // b7.b
    public void onLynxEnvInitialized() {
    }

    @Override // b7.b
    public /* synthetic */ void onLynxFirstScreen() {
    }

    @Override // b7.b
    public void onPrepareComponentEnd() {
    }

    @Override // b7.b
    public void onPrepareComponentStart() {
    }

    @Override // b7.b
    public void onPrepareInitDataEnd() {
    }

    @Override // b7.b
    public void onPrepareInitDataStart(String r1, String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_SCHEME);
        Intrinsics.checkNotNullParameter(r10, "fallbackUrl");
    }

    @Override // b7.b
    public void onPrepareTemplateEnd(boolean r1) {
    }

    @Override // b7.b
    public void onPrepareTemplateEnd(boolean r1, String r10) {
        Intrinsics.checkNotNullParameter(r10, "resFrom");
    }

    @Override // b7.b
    public void onPrepareTemplateStart() {
    }

    @Override // b7.b
    public void onRelease() {
    }
}
