package c2b;

import com.ss.android.lark.chat.core.model.ObservableMappedArrayList;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements b {
    public final ObservableMappedArrayList<String, MessageInfo> a;

    public a(ObservableMappedArrayList<String, MessageInfo> r2) {
        Intrinsics.checkNotNullParameter(r2, "messageList");
        this.a = r2;
    }

    @Override // c2b.b
    public final c a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "anchorMsgId");
        this.a.acquireReadAccess();
        int r6 = this.a.getItemPosByKey(new String[]{r5});
        this.a.size();
        if (r6 > 0) goto L5;
    L7:
        List<MessageInfo> r7 = null;
    L8:
        this.a.releaseReadAccess();
        return new c(r7);
    L5:
        if (r6 >= this.a.size()) goto L7;
        ObservableMappedArrayList<String, MessageInfo> r0 = this.a;
        r7 = r0.subList(r6, Math.min((0 + r6) + 1, r0.size()));
        goto L8
    }
}
