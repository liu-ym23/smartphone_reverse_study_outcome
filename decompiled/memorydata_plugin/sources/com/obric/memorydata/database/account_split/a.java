package com.obric.memorydata.database.account_split;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/database/account_split/AccountSplitUserIdUtil;", "", "<init>", "()V", "isValid", "", "userId", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8813a = null;

    static {
        f8813a = new a();
    }

    private a() {
    }

    public final boolean a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "userId");
        Long r2 = StringsKt.toLongOrNull(r3);
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.longValue() == 0) goto L7;
        return true;
    }
}
