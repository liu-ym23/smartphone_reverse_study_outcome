package k4b;

import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.reaction.ReactionInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements Function1<f5b.b, Boolean> {
    public final String a;

    public e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "chatterId");
        this.a = r2;
    }

    public final Object invoke(Object r3) {
        f5b.b r4 = (f5b.b) r3;
        Intrinsics.checkNotNullParameter(r4, "chatMessage");
        List<ReactionInfo> r5 = r4.getReactionInfoList();
        if (CollectionUtils.isNotEmpty(r5) == false) goto L13;
        Iterator<ReactionInfo> r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L13;
        Map<String, ChatChatter> r0 = r6.next().getReactionChatters();
        if (CollectionUtils.isNotEmpty(r0) == false) goto L6;
        if (r0.get(this.a) == null) goto L6;
        return Boolean.TRUE;
    L13:
        return Boolean.FALSE;
    }
}
