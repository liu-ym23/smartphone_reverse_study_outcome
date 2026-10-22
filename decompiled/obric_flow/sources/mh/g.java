package mh;

import com.bytedance.pia.core.api.bridge.PiaMethod$Error;
import com.bytedance.pia.core.plugins.RenderingPlugin;
import com.bytedance.vmsdk.jsbridge.utils.Callback;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements fh.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f20104b;

    public /* synthetic */ g(Object r5, int r10) {
        this.f20103a = r10;
        this.f20104b = r5;
    }

    @Override // fh.a
    public final void accept(Object r5) {
        switch(this.f20103a) {
            case 0: goto L14;
            case 1: goto L12;
            default: goto L4;
        };
    L4:
        JsonObject r10 = (JsonObject) r5;
        Callback r11 = (Callback) this.f20104b;
        if (r11 == null) goto L16;
        JavaOnlyMap r12 = new JavaOnlyMap();
        r12.put("code", 1);
        if (r10 == null) goto L10;
        r12.put("data", com.bytedance.pia.core.utils.j.e(r10));
    L10:
        r11.invoke(new Object[]{r12});
        return;
    L16:
        return;
    L12:
        PiaMethod$Error r13 = (PiaMethod$Error) r5;
        ((RenderingPlugin) this.f20104b).getClass();
        throw null;
    L14:
        Gson r14 = com.bytedance.pia.core.utils.i.a();
        Map r15 = (Map) r14.fromJson((JsonObject) r5, Map.class);
        ((RenderingPlugin) this.f20104b).getClass();
        throw null;
    }
}
