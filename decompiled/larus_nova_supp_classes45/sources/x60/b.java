package x60;

import com.bytedance.android.live.core.setting.v2.helper.MapDeserializerDoubleAsIntFix;
import com.bytedance.android.live.core.setting.v2.helper.SettingBooleanTypeAdapter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public static final Gson a = null;

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00050\u0001¨\u0006\u0006"}, d2 = {"x60/b$a", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "live-setting_release"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<HashMap<String, Object>> {
        public a() {
        }
    }

    static {
        a = new GsonBuilder().registerTypeAdapter(new a().getType(), new MapDeserializerDoubleAsIntFix()).registerTypeAdapter(Boolean.TYPE, new SettingBooleanTypeAdapter()).create();
    }

    public static Object a(Object r1, Type r2) {
        Intrinsics.checkNotNullParameter(r1, "value");
        if (Intrinsics.areEqual(r2, String.class) == false) goto L5;
    L8:
        Gson r0 = a;
        return GsonProtectorUtils.fromJson(r0, GsonProtectorUtils.toJson(r0, r1.toString()), r2);
    L5:
        if (Intrinsics.areEqual(r2, null) == true) goto L8;
        return GsonProtectorUtils.fromJson(a, r1.toString(), r2);
    }
}
