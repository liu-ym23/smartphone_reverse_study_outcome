package dha;

import com.obric.assistant.state.api.v2.core.bean.ObricState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public static final boolean a(ObricState r2, ObricState r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 != null) goto L6;
    L14:
        return false;
    L6:
        if (r2.getCurrentIslandState() != r3.getCurrentIslandState()) goto L14;
        if (Intrinsics.areEqual(r2.getConversationId(), r3.getConversationId()) == false) goto L14;
        if (r2.getScene() != r3.getScene()) goto L14;
        if (Intrinsics.areEqual(r2.getExt(), r3.getExt()) == false) goto L14;
        return true;
    }
}
