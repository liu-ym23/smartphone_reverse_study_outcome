package j30;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.browser.IBrowserService;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import jc1.k;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f extends com.bytedance.android.live.browser.jsbridge.state.b<JsonObject> {
    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final /* bridge */ /* synthetic */ Object b() {
        return null;
    }

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final com.bytedance.android.live.browser.jsbridge.state.a<JsonObject> g() {
        return this;
    }

    public f() {
    }

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final com.bytedance.android.live.browser.jsbridge.i.f d() {
        return com.bytedance.android.live.browser.jsbridge.i.g.h.b;
    }

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final JsonElement e(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        return GsonHelper.parser().parse(String.valueOf(((IBrowserService) k.n(IBrowserService.class)).getCacheJsonByScheme(r3)));
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return JsonNull.INSTANCE;
    }
}
