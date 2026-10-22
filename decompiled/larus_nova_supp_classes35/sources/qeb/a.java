package qeb;

import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.statistics.Statistics;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends q5c.a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: qeb.a$a, reason: collision with other inner class name */
    public static final class C0285a {
        @JvmStatic
        public static void a(String r2, UIFeedCard r3) {
            Intrinsics.checkNotNullParameter(r2, "click");
            Intrinsics.checkNotNullParameter(r3, "uiFeedCard");
            JSONObject r1 = new JSONObject();
            r1.put("click", r2);
            r1.put("target", "none");
            c.a(r1, r3.getIsDisplayInShortcut());
            Statistics.sendEvent("feed_press_click", r1);
        }
    }

    static {
    }
}
