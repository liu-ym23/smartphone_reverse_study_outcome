package d0c;

import android.app.Application;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.y;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import dagger.hilt.android.internal.Contexts;
import e0c.k;
import e0c.l;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final /* synthetic */ class b {
    public static m a(c r1) {
        return (m) k.b(r1.provideComponent(), m.class);
    }

    public static l b(c r6) {
        UserSession r0 = r6.e9();
        Application r1 = Contexts.getApplication(d.a(r6).getApplicationContext());
        Intrinsics.checkNotNull(r1);
        l r2 = ((v) k.a(r1, v.class)).c(r0);
        UserSession r3 = ((m) k.b(r2, m.class)).getSession();
        if (y.a(r0.b) == false) goto L5;
    L18:
        return r2;
    L5:
        if (y.a(r3.b) == false) goto L18;
        int r4 = m0c.c.a;
        Intrinsics.checkNotNullParameter(r1, "app");
        Intrinsics.checkNotNullParameter(r6, "scopeView");
        Intrinsics.checkNotNullParameter(r0, "userSession");
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L9
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L9
        r7.put("scenario", "user_container_not_found");     // Catch: Throwable -> L9
        r7.put("payload1", r6.getClass().getSimpleName());     // Catch: Throwable -> L9
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r8) == false) goto L14;
        r8 = null;
    L14:
        JSONObject r9 = (JSONObject) r8;
        if (r9 == null) goto L17;
        ((o5c.b) k.a(r1, o5c.b.class)).sendEvent("lark_user_container_runtime_defect_dev", r9);
    L17:
        Log.w("passport_container", "[lark_user_container_runtime_defect_dev](scenario: user_container_not_found, view_simple_name: " + r6.getClass().getSimpleName() + ", uid: " + r0.b + ", view_full_name: " + r6.getClass().getCanonicalName() + ')');
    L9:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }
}
