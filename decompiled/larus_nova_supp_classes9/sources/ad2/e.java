package ad2;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.functions.Function;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e<T, R> implements Function {
    public final /* synthetic */ f a;
    public final /* synthetic */ String b;

    public e(f r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r5) {
        com.bytedance.android.live.network.response.e r6 = (com.bytedance.android.live.network.response.e) r5;
        Intrinsics.checkNotNullParameter(r6, "result");
        int r0 = this.a.b.incrementAndGet();
        CallContext r1 = this.a.c;
        JSONObject r2 = new JSONObject();
        r2.put("progress", (int) ((r0 / this.a.d) * 100));
        Unit r3 = Unit.INSTANCE;
        r1.b("subscribe.upload.progress", r2);
        String r4 = this.b;
        Gson r7 = GsonHelper.get();
        JsonElement r8 = ((com.bytedance.android.live.base.model.i) ((ExtraResponse) r6).data).b;
        if (r8 == null) goto L7;
        JsonObject r9 = r8.getAsJsonObject();
        if (r9 == null) goto L7;
        JsonElement r10 = r9.get("image");
    L9:
        return new Pair(r4, GsonProtectorUtils.fromJson(r7, r10, ImageModel.class));
    L7:
        r10 = null;
        goto L9
    }
}
