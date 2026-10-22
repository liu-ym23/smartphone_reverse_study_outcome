package pk;

import android.util.Log;
import java.lang.reflect.Method;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f21358a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class f21359b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Method f21360c;

    static {
        f21358a = new a();
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L5
        Object r10 = Result.m124constructorimpl(Class.forName("com.bytedance.lynx.webview.TTWebSdk"));     // Catch: Throwable -> L5
    L7:
        Throwable r11 = Result.m127exceptionOrNullimpl(r10);
        if (r11 == null) goto L11;
        Log.e(qo.a.a("TTWeb"), "Get TTWebSdk class failed:", r11);
    L11:
        if (Result.m130isFailureimpl(r10) == false) goto L13;
        r10 = null;
    L13:
        f21359b = (Class) r10;
        return;
    L5:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
