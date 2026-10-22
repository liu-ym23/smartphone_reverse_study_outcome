package com.bytedance.android.live.revenue.platform.hybrid.api.shareview;

import android.content.Context;
import android.view.View;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface a extends dy0.a {
    c Ka(Context r1);

    void Y3(String r1, View r2);

    List<com.lynx.tasm.behavior.a> Z9();

    List<e> getMethods();

    void li(String r1, Object r2);

    void registerMethod(String r1, com.bytedance.ies.web.jsbridge2.f.b r2);

    Observable<Pair<String, View>> vd(Context r1, d r2);
}
