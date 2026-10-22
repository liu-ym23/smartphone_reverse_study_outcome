package qeb;

import com.ss.android.lark.feed.export.feedcard.action.FeedActionType;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FeedActionType.values().length];
            r0[FeedActionType.FLAG_MARK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[FeedActionType.TOPPING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[FeedActionType.MARK_UNREAD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final void a(JSONObject r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 == false) goto L5;
        String r3 = "feed_top";
    L6:
        r1.put("action_location", r3);
        return;
    L5:
        r3 = "feed_item";
        goto L6
    }
}
