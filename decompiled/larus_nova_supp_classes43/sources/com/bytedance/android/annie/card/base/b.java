package com.bytedance.android.annie.card.base;

import android.graphics.Bitmap;
import android.view.View;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.resource.AnnieResType;
import com.bytedance.ies.web.jsbridge2.c0;
import com.lynx.tasm.LynxView;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface b {
    void b(c0 r1);

    void c(JSONObject r1, c0 r10);

    void g(View r1, String r10);

    void h(View r1, com.bytedance.android.annie.card.web.resource.a r10);

    void i(LynxView r1, String r10, String r11);

    void j(View r1, String r10, String r11);

    void k(View r1, String r10, Bitmap r11, boolean r12);

    void l(String r1, AnnieResType r10, IHybridComponent.HybridType r11, Map<String, Long> r12);

    void m(boolean r1);

    void n(LynxView r1);

    void onBeforeCreateRenderData(View r1);

    void onBeforeGlobalPropsInitialize();

    void onBeforeInitialPropsInitialize();

    void onBeforeJsbRegister();

    void onBeforeLoadRequest(String r1, AnnieResType r10, IHybridComponent.HybridType r11, Map<String, Object> r12);

    void onBeforeLynxEnvInitialize(boolean r1);

    void onCardLoadStart();

    void onCreateRenderData(View r1, Set<String> r10);

    void onEngineLoadEnd();

    void onEngineLoadStart();

    void onGlobalPropsInitialized();

    void onInitialPropsInitialized();

    void onJsbRegistered();

    void onLynxEnvInitialized();

    void onRelease();

    @Deprecated(message = "使用 onTemplateLoaded(view: View?, resourceInfo: ResourceInfo) 替代")
    void onTemplateLoaded(View r1, boolean r10);
}
