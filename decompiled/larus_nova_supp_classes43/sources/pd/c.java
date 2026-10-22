package pd;

import android.view.View;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface c {
    void onAttachView(View r1, String r10);

    void onBeforeCreateRenderData(View r1);

    void onBeforeGlobalPropsInitialize();

    void onBeforeInitialPropsInitialize();

    void onBeforeJsbRegister();

    void onBeforeLynxEnvInitialize(boolean r1);

    void onBeforeOpenContainer();

    void onContainerError(View r1, int r10, String r11);

    void onContainerInitEnd();

    void onContainerInitStart();

    void onCreateRenderData(View r1, Set<String> r10);

    boolean onFallback(int r1, String r10);

    void onGlobalPropsInitialized();

    void onInitialPropsInitialized();

    void onInnerFallback(int r1, String r10);

    void onJsbRegistered();

    void onLoadFail(View r1, String r10, String r11);

    void onLoadStart(View r1, boolean r10);

    void onLoadSuccess(View r1);

    void onLynxEnvInitialized();

    void onPrepareComponentEnd();

    void onPrepareComponentStart();

    void onPrepareInitDataEnd();

    void onPrepareInitDataStart(String r1, String r10, boolean r11);

    void onPrepareTemplateEnd();

    void onPrepareTemplateStart();

    void onRelease();
}
