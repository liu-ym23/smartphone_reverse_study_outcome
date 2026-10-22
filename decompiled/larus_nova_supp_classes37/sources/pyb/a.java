package pyb;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.flow.mfa.FlowMfaEngine;
import javax.inject.Inject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@OfficeSDKUserScope
public final class a implements azb.a {
    public final FlowMfaEngine a;

    /* JADX INFO: renamed from: pyb.a$a, reason: collision with other inner class name */
    public static final class C0178a {
    }

    static {
    }

    @Inject
    public a(FlowMfaEngine r2) {
        Intrinsics.checkNotNullParameter(r2, "engine");
        this.a = r2;
    }

    @Override // azb.a
    public final boolean Wd(String r7) {
        Intrinsics.checkNotNullParameter(r7, "url");
        PassportLog.d("OfficeSDKIdpApplink", "handleApplinkIfNeeded called");
        boolean r2 = false;
        if (StringsKt.isBlank(r7) == false) goto L37;
        PassportLog.b("OfficeSDKIdpApplink", "parse applink failed: url is blank");
        return false;
    L37:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        Object r1 = Result.constructor-impl(UriProtector.parse(r7));     // Catch: Throwable -> L8
    L10:
        Throwable r3 = Result.exceptionOrNull-impl(r1);
        if (r3 != null) goto L35;
        Uri r4 = (Uri) r1;
        boolean r5 = true;
        if (StringsKt.equals("doubaolarkauth", r4.getScheme(), true) == true) goto L15;
    L19:
        r5 = false;
    L20:
        PassportLog.d("OfficeSDKIdpApplink", "parse applink success: scheme=" + r4.getScheme() + ", host=" + r4.getHost() + ", path=" + r4.getPath() + ", isTargetApplink=" + r5);
        if (r5 == true) goto L39;
        return false;
    L39:
        Object r8 = Result.constructor-impl(Boolean.valueOf(this.a.b(r7)));     // Catch: Throwable -> L25
    L27:
        Throwable r6 = Result.exceptionOrNull-impl(r8);
        if (r6 != null) goto L33;
        r2 = ((Boolean) r8).booleanValue();
        if (r2 == false) goto L32;
        PassportLog.d("OfficeSDKIdpApplink", "handle external browser IdP applink success");
    L34:
        return r2;
    L32:
        PassportLog.b("OfficeSDKIdpApplink", "handle external browser IdP applink failed: not handled");
        goto L34
    L33:
        PassportLog.c("OfficeSDKIdpApplink", "handle external browser IdP applink failed", r6);
    L25:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    L15:
        if (StringsKt.equals("flow", r4.getHost(), true) == false) goto L19;
        if (Intrinsics.areEqual("/officesdk/passport/sso", r4.getPath()) == false) goto L19;
    L35:
        PassportLog.c("OfficeSDKIdpApplink", "parse applink failed", r3);
        return false;
    L8:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }
}
