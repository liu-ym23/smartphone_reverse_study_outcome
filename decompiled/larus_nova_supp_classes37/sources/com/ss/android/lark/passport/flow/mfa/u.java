package com.ss.android.lark.passport.flow.mfa;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.alibaba.fastjson.JSONObject;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@UserScope
public final class u implements yyb.b {
    public static final /* synthetic */ int c = 0;
    public final FlowMfaEngine a;
    public final Handler b;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FlowMfaTokenStatus.values().length];
            r0[FlowMfaTokenStatus.VALID.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[FlowMfaTokenStatus.INVALID.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[FlowMfaTokenStatus.UNKNOWN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    @Inject
    public u(FlowMfaEngine r2) {
        Intrinsics.checkNotNullParameter(r2, "engine");
        this.a = r2;
        this.b = new Handler(Looper.getMainLooper());
    }

    public static ErrorResult b(FlowMfaError r2) {
        return new ErrorResult(r2.getCategory().ordinal(), r2.getMessage());
    }

    @Override // yyb.b
    public final void a(Activity r12, String r13, JSONObject r14, IGetDataCallback r15) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r15, "callback");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new FlowPassportMFAServiceImpl$startMFA$1(this, r12, r13, r14, r15, null), 3, null);
    }
}
