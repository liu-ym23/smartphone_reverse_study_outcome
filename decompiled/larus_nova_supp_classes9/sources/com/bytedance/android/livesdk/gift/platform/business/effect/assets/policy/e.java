package com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy;

import androidx.lifecycle.LiveData;
import java.util.List;
import kotlin.Pair;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface e {
    void a(JSONObject r1);

    void f(List r1, boolean r2);

    void g(List<com.bytedance.android.live.core.resources.e> r1, int r2, boolean r3);

    LiveData<List<Pair<com.bytedance.android.live.core.resources.e, Boolean>>> h0();
}
