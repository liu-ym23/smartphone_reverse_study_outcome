package com.bytedance.android.livesdk.chatroom.viewmodule.shortterm;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.sti.framework.IShortTouchLifeCycle;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e implements IShortTouchLifeCycle {
    public final Context a;
    public final int b;

    public final void onPause() {
        IShortTouchLifeCycle.DefaultImpls.onPause(this);
        ALogger.d("CommonHybridComponent", "on pause");
        new JSONObject().put("visible", false);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public final void onResume() {
        IShortTouchLifeCycle.DefaultImpls.onResume(this);
        ALogger.d("CommonHybridComponent", "on resume");
        new JSONObject().put("visible", true);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public final Context getContext() {
        return this.a;
    }

    public e(Context r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = r3;
    }
}
