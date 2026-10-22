package com.larus.account.saas.ui;

import android.content.Context;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/account/saas/ui/DefaultAccountSaasUiResourceResolver;", "Lcom/larus/account/saas/ui/IAccountSaasUiResourceResolver;", "<init>", "()V", "account-saas-ui-android_release"}, k = 1, mv = {1, 7, 1})
public final class DefaultAccountSaasUiResourceResolver implements IAccountSaasUiResourceResolver {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AccountSaasUiColorToken.values().length];
            r0[AccountSaasUiColorToken.STATUS_BAR_BACKGROUND.ordinal()] = 1;
            a = r0;
        }
    }

    @Override // f48.c
    public final void priority() {
    }

    public DefaultAccountSaasUiResourceResolver() {
    }

    @Override // com.larus.account.saas.ui.IAccountSaasUiResourceResolver
    public final Integer c(Context r2, AccountSaasUiColorToken r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "token");
        if (a.a[r3.ordinal()] != 1) goto L7;
        return Integer.valueOf(ContextCompat.getColor(r2, 2131100112));
    L7:
        throw new NoWhenBranchMatchedException();
    }
}
