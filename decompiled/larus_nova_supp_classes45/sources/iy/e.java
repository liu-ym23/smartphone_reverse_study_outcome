package iy;

import com.bytedance.android.live.anchormodelink.model.DynamicCenterGetType;
import com.bytedance.android.live.anchormodelink.model.DynamicCenterUpdateType;
import com.bytedance.android.live.liveinteract.jsbridge.method.k;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface e {
    JsonObject C(my.b r1);

    boolean a(DynamicCenterUpdateType r1);

    void b(my.c r1, k r2);

    boolean c(DynamicCenterGetType r1);

    void onStart();

    void onStop();
}
