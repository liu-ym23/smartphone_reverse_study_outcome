package yib;

import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.forwardv3.settings.MergeForwardLimitSettings;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public static int a() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl((MergeForwardLimitSettings) SettingManager.getInstance().get(MergeForwardLimitSettings.class));     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r1) == false) goto L9;
        r1 = null;
    L9:
        MergeForwardLimitSettings r2 = (MergeForwardLimitSettings) r1;
        if (r2 == null) goto L14;
        Integer r3 = r2.getSelectCountLimit();
        if (r3 == null) goto L14;
        return r3.intValue();
    L14:
        return 20;
    L4:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
