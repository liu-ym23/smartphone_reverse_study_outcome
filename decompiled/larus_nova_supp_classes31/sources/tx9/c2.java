package tx9;

import java.util.Iterator;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c2 {
    public static final Set<String> a = null;

    static {
        a = SetsKt.setOf(new String[]{"chat_id", "agent_mode", "card_source", "card_group_id", "card_id", "doc_id", "rich_media_type"});
    }

    public static final void a(JSONObject r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r4 == null) goto L9;
        Iterator<String> r0 = r4.keys();
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.hasNext() == false) goto L12;
        String r1 = r0.next();
        r3.putOpt(r1, r4.opt(r1));
        goto L7
    L12:
        return;
    }
}
