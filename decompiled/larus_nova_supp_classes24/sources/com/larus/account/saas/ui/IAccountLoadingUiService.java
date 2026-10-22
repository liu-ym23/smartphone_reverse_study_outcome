package com.larus.account.saas.ui;

import android.app.Activity;
import f48.a;
import f48.c;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/larus/account/saas/ui/IAccountLoadingUiService;", "Lf48/c;", "Companion", "account-saas-api_release"}, k = 1, mv = {1, 7, 1})
public interface IAccountLoadingUiService extends c {
    public static final Companion c = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/account/saas/ui/IAccountLoadingUiService$Companion;", "Lcom/larus/account/saas/ui/IAccountLoadingUiService;", "<init>", "()V", "account-saas-api_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion implements IAccountLoadingUiService {
        public static final /* synthetic */ Companion e = null;
        public static final Lazy<Set<IAccountLoadingUiService>> f = null;

        private Companion() {
        }

        @Override // f48.c
        public final void priority() {
        }

        static {
            e = new Companion();
            f = LazyKt.lazy(IAccountLoadingUiService$Companion$services$2.INSTANCE);
        }

        @Override // com.larus.account.saas.ui.IAccountLoadingUiService
        public final boolean d(final Activity r3) {
            Intrinsics.checkNotNullParameter(r3, "activity");
            int r0 = a.a;
            return a.a((Set) f.getValue(), new IAccountLoadingUiService$Companion$dismissLoading$1(r3));
        }

        @Override // com.larus.account.saas.ui.IAccountLoadingUiService
        public final boolean showLoading(final Activity r3) {
            Intrinsics.checkNotNullParameter(r3, "activity");
            int r0 = a.a;
            return a.a((Set) f.getValue(), new IAccountLoadingUiService$Companion$showLoading$1(r3));
        }
    }

    static {
        c = Companion.e;
    }

    boolean d(Activity r1);

    boolean showLoading(Activity r1);
}
