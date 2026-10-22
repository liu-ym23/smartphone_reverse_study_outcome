package e3;

import android.app.Activity;
import android.view.View;
import com.bytedance.ai.bridge.context.RefType;
import com.google.gson.JsonObject;
import d3.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface d {

    public static final class a {
        public static /* synthetic */ void a(e3.a r1, Class r10, Object r11) {
            r1.b(r10, r11, RefType.WEAK);
        }
    }

    void a(String r1, JsonObject r10);

    <T> void b(Class<T> r1, T r10, RefType r11);

    String c(int r1);

    <T> T d(Class<T> r1);

    a0 getContainerContext();

    View getEngineView();

    g getJsEventDelegate();

    Activity getOwnerActivity();
}
