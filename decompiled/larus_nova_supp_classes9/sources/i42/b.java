package i42;

import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livesdk.utils.LimitedSizeHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public final LimitedSizeHashMap<String, Object> a;

    public b() {
        this.a = new LimitedSizeHashMap(128);
    }

    public final void a(String r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (this.a.containsKey(r3) == true) goto L8;
        TTLiveSDK.hostService().hostOpenPlatform().preloadMiniApp(r3);
        this.a.put(r3, null);
        return;
    }
}
