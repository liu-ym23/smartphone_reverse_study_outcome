package com.larus.account.saas.ui;

import android.content.Context;
import f48.a;
import f48.b;
import f48.c;
import java.util.Iterator;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/larus/account/saas/ui/IAccountSaasUiResourceResolver;", "Lf48/c;", "Companion", "account-saas-api_release"}, k = 1, mv = {1, 7, 1})
public interface IAccountSaasUiResourceResolver extends c {
    public static final Companion d = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/account/saas/ui/IAccountSaasUiResourceResolver$Companion;", "Lcom/larus/account/saas/ui/IAccountSaasUiResourceResolver;", "<init>", "()V", "account-saas-api_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion implements IAccountSaasUiResourceResolver {
        public static final /* synthetic */ Companion e = null;
        public static final Lazy<Set<IAccountSaasUiResourceResolver>> f = null;

        private Companion() {
        }

        @Override // f48.c
        public final void priority() {
        }

        static {
            e = new Companion();
            f = LazyKt.lazy(IAccountSaasUiResourceResolver$Companion$resolvers$2.INSTANCE);
        }

        @Override // com.larus.account.saas.ui.IAccountSaasUiResourceResolver
        public final Integer c(final Context r3, final AccountSaasUiColorToken r4) {
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r4, "token");
            int r0 = a.a;
            Set r1 = (Set) f.getValue();
            Function1<IAccountSaasUiResourceResolver, Integer> r2 = new IAccountSaasUiResourceResolver$Companion$resolveColor$1(r3, r4);
            Intrinsics.checkNotNullParameter(r1, "services");
            Intrinsics.checkNotNullParameter(r2, "block");
            Iterator r5 = CollectionsKt.sortedWith(r1, new b()).iterator();
        L4:
            if (r5.hasNext() == false) goto L8;
            Object r6 = r2.invoke(r5.next());
            if (r6 == null) goto L4;
        L10:
            return (Integer) r6;
        L8:
            r6 = null;
            goto L10
        }
    }

    static {
        d = Companion.e;
    }

    Integer c(Context r1, AccountSaasUiColorToken r2);
}
