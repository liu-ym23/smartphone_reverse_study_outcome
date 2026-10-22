package com.larus.bmhome.auth;

import com.google.gson.Gson;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.platform.api.IAccountRemovedCacheService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/larus/bmhome/auth/LaunchAccountRemovedCacheServiceImpl;", "Lcom/larus/platform/api/IAccountRemovedCacheService;", "<init>", "()V", "onAccountRemoved", "", "secUserId", "", "Companion", "impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class LaunchAccountRemovedCacheServiceImpl implements IAccountRemovedCacheService {

    public static final class a {
    }

    static {
    }

    public LaunchAccountRemovedCacheServiceImpl() {
    }

    public final void a(final String r5) {
        Intrinsics.checkNotNullParameter(r5, "secUserId");
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("clear split launch cache, scene=remove, hasSecUserId=");
        r2.append(!StringsKt.isBlank(r5));
        r1.i("LaunchAccountRemovedCache", r2.toString());
        Gson r3 = z0.a;
        Intrinsics.checkNotNullParameter(r5, "secUserId");
        if (StringsKt.isBlank(r5) == true) goto L7;
        z0.l = null;
        z0.m = null;
        z0.n = null;
        z0.o = null;
        t0.a(new s0(r5));
        return;
    }
}
