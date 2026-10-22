package com.ss.android.lark.chatwindow.statistics;

import com.ss.android.lark.log.Log;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import o5c.b;
import org.json.JSONObject;
import q5c.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatWindowHitPoint extends a {
    public static final ChatWindowHitPoint a = null;
    public static final Lazy b = null;

    static {
        a = new ChatWindowHitPoint();
        b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, ChatWindowHitPoint$statistics$2.INSTANCE);
    }

    @JvmStatic
    public static final void a() {
        Intrinsics.checkNotNullParameter("1", "location");
        new JSONObject().put("stickerpack_stickerforward_location", "1");     // Catch: Throwable -> L5
        a.getClass();     // Catch: Throwable -> L5
        ((b) b.getValue()).sendEvent("stickerpack_stickerforward", null);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Log.e(th.getMessage());
    }

    public ChatWindowHitPoint() {
    }
}
