package com.obric.matrix.platform.sdk.ones.account;

import android.os.Bundle;
import android.os.Parcel;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/account/d;", NotificationCompat.CATEGORY_SERVICE, "", "invoke", "(Lcom/obric/matrix/platform/sdk/ones/account/d;)V", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class OAccount$verifySmsCode$1 extends Lambda implements Function1<d, Unit> {
    final /* synthetic */ String $code;
    final /* synthetic */ String $mobile;
    final /* synthetic */ Function2<Integer, String, Unit> $onFailed;
    final /* synthetic */ Function1<Bundle, Unit> $onSuccess;
    final /* synthetic */ int $scene;

    /* JADX WARN: Multi-variable type inference failed */
    public OAccount$verifySmsCode$1(String r5, String r10, int r11, Function2<? super Integer, ? super String, Unit> r12, Function1<? super Bundle, Unit> r13) {
        this.$mobile = r5;
        this.$code = r10;
        this.$scene = r11;
        this.$onFailed = r12;
        this.$onSuccess = r13;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(d r5) {
        invoke2(r5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(d r10) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_SERVICE);
        String r5 = this.$mobile;
        String r11 = this.$code;
        int r12 = this.$scene;
        f r13 = new f("verifySmsCode", null, this.$onFailed, this.$onSuccess);
        ((b) r10).getClass();
        Parcel r14 = Parcel.obtain();
        Parcel r15 = Parcel.obtain();
        r14.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountService");     // Catch: Throwable -> L5
        r14.writeString(r5);     // Catch: Throwable -> L5
        r14.writeString(r11);     // Catch: Throwable -> L5
        r14.writeInt(r12);     // Catch: Throwable -> L5
        r14.writeStrongBinder(r13);     // Catch: Throwable -> L5
        throw null;     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        r15.recycle();
        r14.recycle();
        throw th;
    }
}
