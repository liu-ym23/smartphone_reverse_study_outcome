package m0a;

import com.larus.ugc.feed.api.model.UserCreationKmp;
import com.larus.ugc.feed.api.model.UserCreationModelKmp;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class o {
    public static final void a(UserCreationModelKmp r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        List<UserCreationKmp> r0 = r1.getCreationList();
        if (r0 == null) goto L8;
        UserCreationKmp r2 = (UserCreationKmp) CollectionsKt.firstOrNull(r0);
        if (r2 == null) goto L8;
        String r3 = r2.getCreationId();
        if (r3 == null) goto L8;
    L9:
        r1.setModelId(r3);
        return;
    L8:
        r3 = "";
        goto L9
    }
}
