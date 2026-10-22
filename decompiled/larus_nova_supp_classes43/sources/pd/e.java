package pd;

import android.app.Activity;
import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface e {
    b createAnnieComponent(Context r1, String r10, c r11);

    j createLynxComponent(Activity r1, String r10, h r11, boolean r12);

    g createWebViewRecord(Activity r1, String r10, i r11, boolean r12);

    void enqueueEvent(String r1, JSONObject r10);

    f getExternalJsBridgeMethodInjectorAdapter();

    boolean initAnnie();

    boolean isAnnieInit();

    void preloadResourceForLynx(String r1, boolean r10);

    void prerenderAnnieWithSchema(Context r1, String r10, String r11, Integer r12, String r13, d r14);

    JSONObject readGeckoFromChannel(String r1, String r10, String r11);

    void releasePrerender(String r1, String r10);

    <T> void sendEventToAllJsBridges(String r1, T r10);

    String tranceUrlToGeckoUrl(String r1, String r10, String r11);
}
