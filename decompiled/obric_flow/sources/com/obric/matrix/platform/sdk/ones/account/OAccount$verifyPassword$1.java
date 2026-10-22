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
final class OAccount$verifyPassword$1 extends Lambda implements Function1<d, Unit> {
    final /* synthetic */ String $mobile;
    final /* synthetic */ Function2<Integer, String, Unit> $onFailed;
    final /* synthetic */ Function1<Bundle, Unit> $onSuccess;
    final /* synthetic */ String $password;

    /* JADX WARN: Multi-variable type inference failed */
    public OAccount$verifyPassword$1(String r5, String r10, Function2<? super Integer, ? super String, Unit> r11, Function1<? super Bundle, Unit> r12) {
        this.$mobile = r5;
        this.$password = r10;
        this.$onFailed = r11;
        this.$onSuccess = r12;
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
        String r11 = this.$password;
        f r12 = new f("verifyPassword", null, this.$onFailed, this.$onSuccess);
        ((b) r10).getClass();
        Parcel r13 = Parcel.obtain();
        Parcel r14 = Parcel.obtain();
        r13.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.account.IAccountService");     // Catch: Throwable -> L5
        r13.writeString(r5);     // Catch: Throwable -> L5
        r13.writeString(r11);     // Catch: Throwable -> L5
        r13.writeStrongBinder(r12);     // Catch: Throwable -> L5
        throw null;     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        r14.recycle();
        r13.recycle();
        throw th;
    }
}
