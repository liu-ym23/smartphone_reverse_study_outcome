package com.obric.matrix.platform.sdk.ones.account;

import android.os.Bundle;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u00128\u0010\u0007\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b\u0012\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000f¢\u0006\u0002\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0010H\u0016R@\u0010\u0012\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/account/OAccount$AsyncResultCallback;", "Lcom/obric/matrix/platform/sdk/ones/account/IAccountActionCallback$Stub;", "methodName", "", "onSuccess", "Lkotlin/Function0;", "", "onFailed", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "errorCode", "errorMsg", "onSuccessEx", "Lkotlin/Function1;", "Landroid/os/Bundle;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "_onFailed", "_onSuccess", "_onSuccessEx", "onResult", WindowEvent.WindowOpenPerfResult.SUCCESS, "", "extra", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OAccount$AsyncResultCallback extends IAccountActionCallback.Stub {
    private Function2<? super Integer, ? super String, Unit> _onFailed;
    private Function0<Unit> _onSuccess;
    private Function1<? super Bundle, Unit> _onSuccessEx;
    private final String methodName;

    public static final /* synthetic */ void access$set_onFailed$p(OAccount$AsyncResultCallback r0, Function2 r1) {
        r0._onFailed = r1;
    }

    public static final /* synthetic */ void access$set_onSuccess$p(OAccount$AsyncResultCallback r0, Function0 r1) {
        r0._onSuccess = r1;
    }

    public static final /* synthetic */ void access$set_onSuccessEx$p(OAccount$AsyncResultCallback r0, Function1 r1) {
        r0._onSuccessEx = r1;
    }

    public void onResult(boolean r11, Bundle r12) {
        OAccount r0 = OAccount.a;
        String r3 = this.methodName;
        Function0<Unit> r6 = this._onSuccess;
        Function1<? super Bundle, Unit> r4 = this._onSuccessEx;
        Function2<? super Integer, ? super String, Unit> r8 = this._onFailed;
        Function0<Unit> r7 = new OAccount$AsyncResultCallback$onResult$1(this);
        r0.getClass();
        OAccount.e.post(new e(r11, r3, r4, r12, r6, r7, r8));
    }

    public OAccount$AsyncResultCallback(String r2, Function0<Unit> r3, Function2<? super Integer, ? super String, Unit> r4, Function1<? super Bundle, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "methodName");
        this.methodName = r2;
        this._onSuccess = r3;
        this._onFailed = r4;
        this._onSuccessEx = r5;
    }

    public /* synthetic */ OAccount$AsyncResultCallback(String r1, Function0 r2, Function2 r3, Function1 r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        this(r1, r2, r3, r4);
    }
}
