package com.bytedance.android.ec.ab.opt;

import com.google.gson.Gson;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class JSONDefaultLocalConfig<Config> extends com.bytedance.android.ec.ab.opt.a<Config> {
    public static final Lazy d = null;
    public final Class<Config> c;

    public static final class a {
    }

    static {
        d = LazyKt.lazy(JSONDefaultLocalConfig$Companion$gson$2.INSTANCE);
    }

    @Override // com.bytedance.android.ec.ab.opt.a
    public final Config b() {
        return (Config) ((Gson) d.getValue()).fromJson("{\n    \"rules\": [\n        {\n            \"replace_domain\": \"p3-aio.ecombdimg.com\",\n            \"match\": [\n                {\n                    \"contains\": \"/ecom-shop-material/\"\n                }\n            ]\n        }\n    ]\n}", this.c);
    L4:
        return null;
    }

    public JSONDefaultLocalConfig(Class<Config> r10) {
        Intrinsics.checkNotNullParameter(r10, "classOfT");
        this.c = r10;
    }
}
