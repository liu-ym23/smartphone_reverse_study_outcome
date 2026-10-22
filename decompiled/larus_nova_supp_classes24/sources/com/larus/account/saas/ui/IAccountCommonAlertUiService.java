package com.larus.account.saas.ui;

import android.app.Activity;
import f48.a;
import f48.c;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/larus/account/saas/ui/IAccountCommonAlertUiService;", "Lf48/c;", "Companion", "account-saas-api_release"}, k = 1, mv = {1, 7, 1})
public interface IAccountCommonAlertUiService extends c {
    public static final Companion b = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/account/saas/ui/IAccountCommonAlertUiService$Companion;", "Lcom/larus/account/saas/ui/IAccountCommonAlertUiService;", "<init>", "()V", "account-saas-api_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion implements IAccountCommonAlertUiService {
        public static final /* synthetic */ Companion e = null;
        public static final Lazy<Set<IAccountCommonAlertUiService>> f = null;

        private Companion() {
        }

        @Override // f48.c
        public final void priority() {
        }

        static {
            e = new Companion();
            f = LazyKt.lazy(IAccountCommonAlertUiService$Companion$services$2.INSTANCE);
        }

        @Override // com.larus.account.saas.ui.IAccountCommonAlertUiService
        public final boolean b(final Activity r3, final AccountCommonAlertData r4, final Function1<? super AccountCommonAlertAction, Unit> r5, final Function0<Unit> r6) {
            Intrinsics.checkNotNullParameter(r3, "activity");
            Intrinsics.checkNotNullParameter(r4, "data");
            Intrinsics.checkNotNullParameter(r5, "onAction");
            Intrinsics.checkNotNullParameter(r6, "onCancel");
            int r0 = a.a;
            return a.a((Set) f.getValue(), new IAccountCommonAlertUiService$Companion$showCommonAlert$1(r3, r4, r5, r6));
        }
    }

    static {
        b = Companion.e;
    }

    boolean b(Activity r1, AccountCommonAlertData r2, Function1<? super AccountCommonAlertAction, Unit> r3, Function0<Unit> r4);
}
