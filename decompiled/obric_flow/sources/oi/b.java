package oi;

import kotlin.Result;
import kotlin.ResultKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends a {
    public b() {
    }

    @Override // oi.a
    public final String a() {
        return "BuiltInPermissionConfigLoader";
    }

    @Override // oi.a
    public final JSONObject c() {
        if (this.f20582a == null) goto L5;
        String r5 = "";
    L6:
        if (r5 != null) goto L12;
    L11:
        return null;
    L12:
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L9
        return new JSONObject(r5);
    L9:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.m123boximpl(Result.m124constructorimpl(ResultKt.createFailure(th)));
        goto L11
    L5:
        r5 = null;
        goto L6
    }
}
