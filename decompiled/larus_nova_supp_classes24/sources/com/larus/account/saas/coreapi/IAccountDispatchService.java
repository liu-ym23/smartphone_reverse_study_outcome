package com.larus.account.saas.coreapi;

import android.net.Uri;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/larus/account/saas/coreapi/IAccountDispatchService;", "", "Companion", "account-saas-api_release"}, k = 1, mv = {1, 7, 1})
public interface IAccountDispatchService {
    public static final Companion a = null;

    public static final class Companion {
        public static final /* synthetic */ Companion a = null;
        public static final IAccountDispatchService$Companion$EMPTY$1 b = null;

        public Companion() {
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.account.saas.coreapi.IAccountDispatchService$Companion$EMPTY$1] */
        static {
            a = new Companion();
            b = new IAccountDispatchService$Companion$EMPTY$1();
        }
    }

    static {
        a = Companion.a;
    }

    boolean c(int r1, int r2, String r3);

    boolean e(Uri r1);
}
