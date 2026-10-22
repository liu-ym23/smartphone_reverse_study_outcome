package j30;

import android.content.SharedPreferences;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i extends com.bytedance.android.live.browser.jsbridge.state.b<JsonObject> {
    public final String c;

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final /* bridge */ /* synthetic */ Object b() {
        return null;
    }

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final com.bytedance.android.live.browser.jsbridge.state.a<JsonObject> g() {
        return this;
    }

    public i() {
        this.c = "js_kv_methods_20191113";
    }

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final com.bytedance.android.live.browser.jsbridge.i.f d() {
        return com.bytedance.android.live.browser.jsbridge.i.g.j.b;
    }

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final JsonElement e(String r9) {
        Intrinsics.checkNotNullParameter(r9, "key");
        List r1 = StringsKt.split$default(r9, new String[]{"."}, false, 0, 6, null);
        if (r1.size() <= 1) goto L7;
        String r11 = (String) ListProtector.get(r1, 1);
        Intrinsics.checkNotNullParameter(r11, "key");
        SharedPreferences r0 = s1.getContext().getSharedPreferences(this.c, 0);
        JsonObject r2 = new JsonObject();
        r2.addProperty(r11, r0.getString(r11, ""));
        return r2;
    L7:
        return super.e(r9);
    }
}
