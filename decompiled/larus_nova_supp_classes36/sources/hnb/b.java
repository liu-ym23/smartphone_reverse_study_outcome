package hnb;

import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@UserScope
public final class b implements scb.b {

    public static final class a {
    }

    static {
    }

    @Inject
    public b() {
    }

    public final Object a() {
        Result.Companion r0 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("Endpoint security factor reporting is not supported in OfficeSDK")));
    }
}
