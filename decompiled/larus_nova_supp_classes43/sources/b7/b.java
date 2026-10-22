package b7;

import android.view.View;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.resource.AnnieResType;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface b {
    void onAttachView(View r1, IHybridComponent.HybridType r10, String r11);

    void onAttachedToWindow(String r1);

    void onBeforeCreateRenderData(View r1);

    void onBeforeGlobalPropsInitialize();

    void onBeforeInitialPropsInitialize();

    void onBeforeJsbRegister();

    void onBeforeLoadRequest(String r1, AnnieResType r10, IHybridComponent.HybridType r11, Map<String, Object> r12);

    void onBeforeLynxEnvInitialize(boolean r1);

    void onBeforeOpenContainer();

    void onCardLoadStart();

    void onContainerError(View r1, int r10, String r11);

    void onContainerInitEnd();

    void onContainerInitStart();

    void onCreateRenderData(View r1, Set<String> r10);

    void onEngineLoadEnd();

    void onEngineLoadStart();

    boolean onFallback(int r1, String r10);

    void onGlobalPropsInitialized();

    void onInit(c7.a r1);

    void onInitialPropsInitialized();

    void onInnerFallback(int r1, String r10);

    void onJsbRegistered();

    void onLoadFail(View r1, String r10, String r11);

    void onLoadStart(View r1, boolean r10);

    void onLoadSuccess(View r1);

    void onLynxEnvInitialized();

    void onLynxFirstScreen();

    void onPrepareComponentEnd();

    void onPrepareComponentStart();

    void onPrepareInitDataEnd();

    void onPrepareInitDataStart(String r1, String r10, boolean r11);

    void onPrepareTemplateEnd(boolean r1);

    void onPrepareTemplateEnd(boolean r1, String r10);

    void onPrepareTemplateStart();

    void onRelease();
}
