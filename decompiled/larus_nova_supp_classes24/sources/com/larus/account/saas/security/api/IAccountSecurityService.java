package com.larus.account.saas.security.api;

import android.content.Context;
import android.content.Intent;
import com.larus.login.impl.riskcontrol.a;
import e48.c;
import e48.d;
import e48.f;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/larus/account/saas/security/api/IAccountSecurityService;", "", "Companion", "account-saas-security-api_release"}, k = 1, mv = {1, 7, 1})
public interface IAccountSecurityService {
    public static final Companion a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/account/saas/security/api/IAccountSecurityService$Companion;", "Lcom/larus/account/saas/security/api/IAccountSecurityService;", "<init>", "()V", "account-saas-security-api_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion implements IAccountSecurityService {
        public static final /* synthetic */ Companion b = null;
        public static final Lazy<IAccountSecurityService> c = null;

        private Companion() {
        }

        static {
            b = new Companion();
            c = LazyKt.lazy(IAccountSecurityService$Companion$impl$2.INSTANCE);
        }

        public static IAccountSecurityService i() {
            return (IAccountSecurityService) c.getValue();
        }

        @Override // com.larus.account.saas.security.api.IAccountSecurityService
        public final void a(c r2) {
            Intrinsics.checkNotNullParameter(r2, "request");
            IAccountSecurityService r0 = i();
            if (r0 == null) goto L6;
            r0.a(r2);
            return;
        }

        @Override // com.larus.account.saas.security.api.IAccountSecurityService
        public final boolean e(long r3) {
            Intrinsics.checkNotNullParameter("foreground_dialog", "messageId");
            IAccountSecurityService r0 = i();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.e(r3);
        }

        @Override // com.larus.account.saas.security.api.IAccountSecurityService
        public final void g(f r2) {
            IAccountSecurityService r0 = i();
            if (r0 == null) goto L6;
            r0.g(r2);
            return;
        }

        @Override // com.larus.account.saas.security.api.IAccountSecurityService
        public final void h(d r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            IAccountSecurityService r0 = i();
            if (r0 == null) goto L6;
            r0.h(r2);
            return;
        }

        @Override // com.larus.account.saas.security.api.IAccountSecurityService
        public final void b(String r2, String r3) {
            IAccountSecurityService r0 = i();
            if (r0 == null) goto L6;
            r0.b(r2, r3);
            return;
        }

        @Override // com.larus.account.saas.security.api.IAccountSecurityService
        public final void c(long r2, a r4) {
            IAccountSecurityService r0 = i();
            if (r0 == null) goto L6;
            r0.c(r2, r4);
            return;
        }

        @Override // com.larus.account.saas.security.api.IAccountSecurityService
        public final Intent d(Context r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "openUrl");
            IAccountSecurityService r0 = i();
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.d(r2, r3);
        }

        @Override // com.larus.account.saas.security.api.IAccountSecurityService
        public final f f(String r2, JSONObject r3) {
            IAccountSecurityService r0 = i();
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.f(r2, r3);
        }
    }

    static {
        a = Companion.b;
    }

    void a(c r1);

    void b(String r1, String r2);

    void c(long r1, a r3);

    Intent d(Context r1, String r2);

    boolean e(long r1);

    f f(String r1, JSONObject r2);

    void g(f r1);

    void h(d r1);
}
