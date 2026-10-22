package com.bytedance.android.annie.service.prefetch;

import com.bytedance.android.annie.api.card.IHybridComponent;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface p extends com.bytedance.android.annie.service.a {
    String A0(String r1);

    void E(t r1);

    JSONObject getCacheJsonByScheme(String r1);

    List<n> o();

    void prefetch(String r1);

    void r0(IHybridComponent r1);
}
