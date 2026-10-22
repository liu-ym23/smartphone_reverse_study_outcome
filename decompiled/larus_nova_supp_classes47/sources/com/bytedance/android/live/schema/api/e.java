package com.bytedance.android.live.schema.api;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface e {

    public static final class a implements e {
        public static final /* synthetic */ int a = 0;

        @Override // com.bytedance.android.live.schema.api.e
        public final void a(String r2, JSONObject r3, JSONObject r4, JSONObject r5, JSONObject r6) {
            Intrinsics.checkNotNullParameter(r2, "eventName");
            Intrinsics.checkNotNullParameter(r3, "category");
            Intrinsics.checkNotNullParameter(r4, "metric");
            Intrinsics.checkNotNullParameter(r5, "extra");
            Intrinsics.checkNotNullParameter(r6, "common");
        }

        static {
        }
    }

    void a(String r1, JSONObject r2, JSONObject r3, JSONObject r4, JSONObject r5);
}
