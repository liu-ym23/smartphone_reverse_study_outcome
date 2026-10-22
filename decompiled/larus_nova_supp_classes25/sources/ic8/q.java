package ic8;

import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class q {
    public static final boolean a(DeepThinkFoldStatus r1) {
        if (r1 != DeepThinkFoldStatus.CompleteFold) goto L6;
        return true;
    L6:
        return false;
    }

    public static final boolean b(DeepThinkFoldStatus r1) {
        if (r1 != DeepThinkFoldStatus.CompleteExpand) goto L5;
        return true;
    L5:
        if (r1 == DeepThinkFoldStatus.HalfFold) goto L11;
        return false;
    L11:
        return true;
    }
}
