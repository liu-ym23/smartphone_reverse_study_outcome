package com.ss.android.lark.officesdk.internal;

import com.ss.android.lark.officesdk.api.OfficeSDKDriveErrorCodes;
import com.ss.android.lark.officesdk.api.OfficeSDKDriveResult;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class UserManagerImpl$driveRx$1<T> implements SingleOnSubscribe {
    public final /* synthetic */ UserManagerImpl a;
    public final /* synthetic */ Function0<UserManagerImpl.c> b;
    public final /* synthetic */ long c;
    public final /* synthetic */ String d;

    public static final class a implements ttc.c {
        public final /* synthetic */ Job a;

        public a(Job r1) {
            this.a = r1;
        }

        public final void cancel() {
            Job.DefaultImpls.cancel$default(this.a, null, 1, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UserManagerImpl$driveRx$1(UserManagerImpl r1, Function0<? extends UserManagerImpl.c> r2, long r3, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }

    public final void subscribe(SingleEmitter<OfficeSDKDriveResult> r14) {
        Intrinsics.checkNotNullParameter(r14, "emitter");
        if (this.a.h.invoke() != null) goto L6;
        r14.onSuccess(OfficeSDKDriveResult.Companion.failure$default(OfficeSDKDriveResult.Companion, OfficeSDKDriveErrorCodes.HOST_CAPABILITY_NOT_CONFIGURED, "hostSessionProvider not configured in OfficeSDKInitConfig", null, 4, null));
        return;
    L6:
        UserManagerImpl.c r6 = (UserManagerImpl.c) this.b.invoke();
        r14.setCancellable(new a(BuildersKt.launch$default(this.a.e, null, null, new UserManagerImpl$driveRx$1$waiter$1(this.c, this.d, r14, r6, null), 3, null)));
    }
}
