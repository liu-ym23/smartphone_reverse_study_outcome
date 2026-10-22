package to1;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c<T, R> implements Function {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public final Object apply(Object r2) {
        Gson r0 = GsonHelper.getDefault();
        return GsonProtectorUtils.toJson(r0, (JsonObject) r2);
    }
}
