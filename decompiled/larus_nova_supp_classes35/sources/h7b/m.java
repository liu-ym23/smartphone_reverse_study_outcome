package h7b;

import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.reaction.Reaction;
import com.ss.android.lark.chat.entity.reaction.ReactionInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class m {
    public static boolean a(List<ReactionInfo> r3, String r4, String r5) {
        if (CollectionUtils.isEmpty(r3) == false) goto L5;
        return false;
    L5:
        Iterator<ReactionInfo> r6 = r3.iterator();
    L7:
        if (r6.hasNext() == false) goto L26;
        Reaction r0 = r6.next().getReaction();
        if (Objects.equals(r4, r0.getType()) == false) goto L7;
        if (r0.getChatterIds() == null) goto L25;
        Iterator r7 = new ArrayList(r0.getChatterIds()).iterator();
    L14:
        if (r7.hasNext() == false) goto L27;
        if (((String) r7.next()).equals(r5) == false) goto L14;
        return true;
    L27:
        return false;
    L25:
        return false;
    L26:
        return false;
    }
}
