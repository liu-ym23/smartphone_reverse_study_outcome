package kw1;

import com.bytedance.android.live.core.log.g;
import com.bytedance.android.livesdk.feed.context.LiveFeedContext;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b extends g {
    public static b a;

    public static synchronized b o() {
        monitor-enter(b.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (a != null) goto L7;
        a = new b();     // Catch: Throwable -> L10
    L7:
        b r1 = a;     // Catch: Throwable -> L10
        monitor-exit(b.class);
        return r1;
    }

    public final JSONObject h() {
        JSONObject r0 = new JSONObject();
        r0.put("user_id", LiveFeedContext.hostService().user().getCurUserId());     // Catch: JSONException -> L5
    L7:
        return r0;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public b() {
    }
}
