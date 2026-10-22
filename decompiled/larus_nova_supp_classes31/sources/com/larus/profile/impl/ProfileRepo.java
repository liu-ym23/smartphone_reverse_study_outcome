package com.larus.profile.impl;

import com.larus.platform.api.UserCreationPrivateStatus;
import com.larus.platform.api.UserCreationStatus;
import com.larus.profile.api.bean.UpdateUserCreationContent;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class ProfileRepo {
    public static final Lazy<ProfileRepo> b = null;
    public final Lazy a;

    public static final class a {
        public static ProfileRepo a() {
            return (ProfileRepo) ProfileRepo.b.getValue();
        }
    }

    static {
        b = LazyKt.lazy(new c2());
    }

    public ProfileRepo() {
        this.a = LazyKt.lazy(new d2());
    }

    public static Object g(Continuation r3) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ProfileRepo$updateDefaultProfile$2(null), r3);
    }

    public static Object d(fs9.x r3, Continuation r4) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ProfileRepo$requestUserCreationList$2(r3, null), r4);
    }

    public final Object f(fs9.u r4, Continuation<? super Unit> r5) {
        Object r6 = BuildersKt.withContext(Dispatchers.getIO(), new ProfileRepo$saveProfileOverviewData$2(r4, this, null), r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r6;
    L6:
        return Unit.INSTANCE;
    }

    public static Object a(ProfileRepo r2, List r3, Integer r4, Continuation r5) {
        r2.getClass();
        return BuildersKt.withContext(Dispatchers.getIO(), new ProfileRepo$batchUpdateUserCreation$2(r3, r4, null, null), r5);
    }

    public static Object e(String r3, ProfileRequestSource r4, boolean r5, Continuation r6) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ProfileRepo$requireProfileOverview$2(r4, r5, r3, null), r6);
    }

    public static Object b(int r8, String r9, String r10, String r11, Continuation r12) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ProfileRepo$requestPrivateCreationGroupList$2(r9, r8, r10, r11, null), r12);
    }

    public static Object c(String r9, String r10, ProfileRequestSource r11, boolean r12, Continuation r13) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ProfileRepo$requestProfileInfo$2(r11, r12, r9, r10, 10, null), r13);
    }

    public static Object h(String r9, UpdateUserCreationContent r10, @UserCreationStatus Integer r11, @UserCreationPrivateStatus Integer r12, boolean r13, ContinuationImpl r14) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ProfileRepo$updateUserCreation$2(r11, r13, r12, r9, r10, null), r14);
    }

    public static /* synthetic */ Object i(ProfileRepo r2, String r3, UpdateUserCreationContent r4, Integer r5, Integer r6, boolean r7, ContinuationImpl r8, int r9) {
        if ((r9 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r9 & 4) == 0) goto L9;
        r5 = null;
    L9:
        if ((r9 & 8) == 0) goto L12;
        r6 = null;
    L12:
        if ((r9 & 16) == 0) goto L14;
        r7 = false;
    L14:
        r2.getClass();
        return h(r3, r4, r5, r6, r7, r8);
    }
}
