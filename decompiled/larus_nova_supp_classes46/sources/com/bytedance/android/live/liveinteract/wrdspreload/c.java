package com.bytedance.android.live.liveinteract.wrdspreload;

import com.bytedance.android.livesdk.message.model.in;
import com.bytedance.android.livesdkapi.depend.message.RoomLinkMicSyncData;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public final Map<String, Map<Long, RoomLinkMicSyncData>> a;
    public final Map<String, Map<Long, in>> b;

    public static final class a {
    }

    static {
    }

    public c() {
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
    }
}
