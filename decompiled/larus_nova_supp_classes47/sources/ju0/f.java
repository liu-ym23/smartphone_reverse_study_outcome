package ju0;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.bullet.service.base.x;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f extends b {
    public final List<String> b;

    public f(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, Constants.Keys.DATA);
        super(r3);
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        JSONArray r4 = r3.optJSONArray("topics");     // Catch: Throwable -> L9
        if (r4 == null) goto L6;
        List r5 = x.b(r4);     // Catch: Throwable -> L9
    L7:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r6) == true) goto L15;
        r0 = r6;
    L15:
        List<String> r2 = (List) r0;
        if (r2 != null) goto L18;
        r2 = CollectionsKt.emptyList();
    L18:
        this.b = r2;
        return;
    L6:
        r5 = null;
    L9:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }
}
