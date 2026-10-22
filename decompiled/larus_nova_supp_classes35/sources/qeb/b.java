package qeb;

import com.ss.android.lark.feed.app.entity.FeedFolder;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.app.entity.UpdateUnreadStatusScene;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import z5c.p3;
import z5c.r;
import z5c.r0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final void a(String r1, FeedActionType r2, UIFeedCard r3, FeedFolder r4, UpdateUnreadStatusScene r5) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, Keys.API_RETURN_KEY_DATA);
        int r6 = c.a.a[r2.ordinal()];
        if (r6 == 1) goto L15;
        if (r6 == 2) goto L11;
        if (r6 == 3) goto L9;
        s5c.a r7 = r.c3.a(BuildConfig.FLAVOR);
    L18:
        s5c.a r0 = p3.c;
        r7.getClass();
        JSONObject r8 = s5c.d.b.b(r7, r0).toJson();
        r0 r9 = r0.c;     // Catch: JSONException -> L34
        if (r4 == null) goto L23;
        String r10 = r4.tabType();     // Catch: JSONException -> L34
        if (r10 == null) goto L23;
    L24:
        s5c.a r11 = r9.a(r10);     // Catch: JSONException -> L34
        r8.put(r11.a, r11.b);     // Catch: JSONException -> L34
        if (r5 != UpdateUnreadStatusScene.FEED_ITEM) goto L27;
        s5c.a r12 = z5c.b.c;     // Catch: JSONException -> L34
    L28:
        r8.put(r12.a, r12.b);     // Catch: JSONException -> L34
        Iterator<Map.Entry<String, Object>> r13 = d.a(r3).entrySet().iterator();     // Catch: JSONException -> L34
    L30:
        if (r13.hasNext() == false) goto L32;
        Map.Entry<String, Object> r14 = r13.next();     // Catch: JSONException -> L34
        r8.put(r14.getKey(), r14.getValue());     // Catch: JSONException -> L34
        goto L30
    L32:
        c.a(r8, r3.getIsDisplayInShortcut());     // Catch: JSONException -> L34
    L36:
        Statistics.sendEvent(r1, r8);
        return;
    L27:
        r12 = z5c.b.d;     // Catch: JSONException -> L34
    L23:
        r10 = "UNKNOWN";
    L34:
        e = move-exception;
        Log.e("An error occurred while adding key-value pair to JSONObject: " + e.getMessage(), e);
        goto L36
    L9:
        r7 = r.T2;
        goto L18
    L11:
        if (r3.isShortCut() == false) goto L13;
        r7 = r.L2;
        goto L18
    L13:
        r7 = r.K2;
        goto L18
    L15:
        if (r3.isFlag() == false) goto L17;
        r7 = r.o;
        goto L18
    L17:
        r7 = r.n;
        goto L18
    }
}
