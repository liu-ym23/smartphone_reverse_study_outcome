package n5a;

import com.lynx.clay.embedding.engine.plugins.platformview.PlatformMethodCallback;
import com.lynx.clay.embedding.engine.plugins.platformview.PlatformMethodCallbackResult;
import com.lynx.clay.embedding.engine.plugins.platformview.PlatformViewDataProtocol;
import com.lynx.clay.embedding.engine.plugins.platformview.PlatformViewPlugin;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public final PlatformMethodCallback a;

    public a(PlatformViewPlugin.b r1) {
        this.a = r1;
    }

    public final void a(PlatformMethodCallbackResult r4) {
        this.a.invoke(r4.ordinal(), "{}", PlatformViewDataProtocol.JSON_STRING);
    }

    public final void b(PlatformMethodCallbackResult r3, Map<String, Object> r4) {
        JSONObject r0 = new JSONObject(r4);
        this.a.invoke(r3.ordinal(), r0.toString(), PlatformViewDataProtocol.JSON_STRING);
    }
}
