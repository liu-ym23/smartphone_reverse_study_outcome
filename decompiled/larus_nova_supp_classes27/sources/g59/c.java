package g59;

import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c {
    public final Lazy a;
    public final Lazy b;

    public static final class a {
    }

    static {
    }

    public final d59.f a() {
        String r0 = ((Keva) this.a.getValue()).getString("dora_lab_feature_config", null);
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L20;
        FLogger.a.i("DoraFeatureConfigRepository", "get success: " + r0);
        return (d59.f) ((Gson) this.b.getValue()).fromJson(r0, d59.f.class);
    L14:
        e = move-exception;
        FLogger.a.e("DoraFeatureConfigRepository", "get error", e);
        return null;
    L20:
        return null;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public c() {
        this.a = LazyKt.lazy(new g59.a());
        this.b = LazyKt.lazy(new b());
    }

    public final void b(d59.f r5) {
        if (r5 != null) goto L10;
        return;
    L10:
        String r6 = ((Gson) this.b.getValue()).toJson(r5);     // Catch: Exception -> L7
        ((Keva) this.a.getValue()).storeString("dora_lab_feature_config", r6);     // Catch: Exception -> L7
        FLogger.a.i("DoraFeatureConfigRepository", "save success: " + r6);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        FLogger.a.e("DoraFeatureConfigRepository", "save error", e);
    }
}
