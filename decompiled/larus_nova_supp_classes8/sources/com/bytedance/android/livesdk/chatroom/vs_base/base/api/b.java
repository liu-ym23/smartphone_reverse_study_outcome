package com.bytedance.android.livesdk.chatroom.vs_base.base.api;

import java.util.Map;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ void a(b r1, Class r2) {
            r1.start(r2, MapsKt.emptyMap());
        }
    }

    boolean isDestroyed();

    void start(Class<? extends com.bytedance.android.livesdk.chatroom.vs_base.base.api.a> r1, Map<String, ? extends Object> r2);
}
