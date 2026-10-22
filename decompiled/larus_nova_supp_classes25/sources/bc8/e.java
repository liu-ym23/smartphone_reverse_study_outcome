package bc8;

import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.larus.platform.model.action.SuggestedActionData;
import com.larus.platform.service.AccountService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e {
    public static final e a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;

    public e() {
    }

    static {
        a = new e();
        b = LazyKt.lazy(new c());
        c = LazyKt.lazy(new d());
    }

    public final SuggestedActionData b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "botId");
        boolean r1 = false;
        if (r5.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        Object r3 = null;
        if (r0 == false) goto L9;
        return null;
    L9:
        String r6 = ((Keva) b.getValue()).getString(a(this, r5), null);
        if (r6 != null) goto L13;
        return null;
    L13:
        if (r6.length() != 0) goto L15;
        r1 = true;
    L15:
        if (r1 == false) goto L27;
        return null;
    L27:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L19
        Object r7 = Result.constructor-impl((SuggestedActionData) ((Gson) c.getValue()).fromJson(r6, SuggestedActionData.class));     // Catch: Throwable -> L19
    L22:
        if (Result.isFailure-impl(r7) == true) goto L26;
        r3 = r7;
    L26:
        return (SuggestedActionData) r3;
    L19:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    L5:
        r0 = false;
        goto L6
    }

    public static String a(e r1, String r2) {
        String r0 = AccountService.a.getUserId();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "botId");
        Intrinsics.checkNotNullParameter(r0, "uid");
        return r2 + '_' + r0;
    }
}
