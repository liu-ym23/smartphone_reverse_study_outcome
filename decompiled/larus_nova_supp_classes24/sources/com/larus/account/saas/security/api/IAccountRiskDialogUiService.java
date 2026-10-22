package com.larus.account.saas.security.api;

import e48.a;
import e48.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/larus/account/saas/security/api/IAccountRiskDialogUiService;", "", "Companion", "account-saas-security-api_release"}, k = 1, mv = {1, 7, 1})
public interface IAccountRiskDialogUiService {
    public static final Companion a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/account/saas/security/api/IAccountRiskDialogUiService$Companion;", "Lcom/larus/account/saas/security/api/IAccountRiskDialogUiService;", "<init>", "()V", "account-saas-security-api_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion implements IAccountRiskDialogUiService {
        public static final /* synthetic */ Companion b = null;
        public static final Lazy<IAccountRiskDialogUiService> c = null;

        private Companion() {
        }

        static {
            b = new Companion();
            c = LazyKt.lazy(IAccountRiskDialogUiService$Companion$impl$2.INSTANCE);
        }

        @Override // com.larus.account.saas.security.api.IAccountRiskDialogUiService
        public final boolean a(b r2, Function1<? super a, Unit> r3) {
            Intrinsics.checkNotNullParameter(r2, "riskInfo");
            IAccountRiskDialogUiService r0 = (IAccountRiskDialogUiService) c.getValue();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.a(r2, r3);
        }
    }

    static {
        a = Companion.b;
    }

    boolean a(b r1, Function1<? super a, Unit> r2);
}
