package com.obric.memorydata.database.entity;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006\u0004"}, d2 = {"isUnique", "", "Lcom/obric/memorydata/database/entity/ProfileKey;", "(Lcom/obric/memorydata/database/entity/ProfileKey;)Z", "database_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ho {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9189a = null;

        static {
            int[] r0 = new int[ProfileKey.values().length];
            r0[ProfileKey.ADDRESS_HOME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ProfileKey.ADDRESS_COMPANY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f9189a = r0;
        }
    }

    public static final boolean a(ProfileKey r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        int r3 = a.f9189a[r2.ordinal()];
        if (r3 != 1) goto L5;
    L9:
        return true;
    L5:
        if (r3 == 2) goto L9;
        throw new NoWhenBranchMatchedException();
    }
}
