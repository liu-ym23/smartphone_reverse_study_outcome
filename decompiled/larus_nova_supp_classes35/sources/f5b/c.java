package f5b;

import com.ss.android.lark.chat.entity.message.SmartReplyEntryInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public static final boolean a(SmartReplyEntryInfo r4, SmartReplyEntryInfo r5) {
        if (r4 != r5) goto L6;
        return true;
    L6:
        if (r4 == null) goto L18;
        if (r5 == null) goto L18;
        if (r4.getHasPreGenerated() == r5.getHasPreGenerated()) goto L12;
    L16:
        return false;
    L12:
        if (Intrinsics.areEqual(r4.getAiMessageId(), r5.getAiMessageId()) == false) goto L16;
        if (Intrinsics.areEqual(r4.getRecommendContent(), r5.getRecommendContent()) == false) goto L16;
        return true;
    L18:
        return false;
    }
}
