package com.larus.account.saas.core.ttaccount;

import com.google.gson.reflect.TypeToken;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.account.saas.FlowAccountSdk;
import com.larus.account.saas.core.internal.network.CheckUserNameResponse;
import com.larus.account.saas.core.internal.network.CommonResponse;
import com.larus.account.saas.runtime.internal.util.GsonHolder;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import x38.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = WheelView.WHEEL_ITEM_HEIGHT)
final class AccountProfileService$checkUserName$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ g<Boolean> $callback;
    final /* synthetic */ String $userName;

    public AccountProfileService$checkUserName$1(String r1, g<Boolean> r2) {
        this.$userName = r1;
        this.$callback = r2;
        super(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m370invoke() {
        w38.a r0 = w38.a.a;
        String r1 = this.$userName;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "userName");
        w38.a.a("/alice/profile/user_name_unique");
        boolean r2 = false;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L18
        c48.a.a().c();     // Catch: Throwable -> L18
        com.larus.init.task.accountsdk.g r7 = com.larus.init.task.accountsdk.g.a;     // Catch: Throwable -> L18
        LinkedHashMap r8 = new LinkedHashMap();     // Catch: Throwable -> L18
        r8.put("user_name", r1);     // Catch: Throwable -> L18
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L18
        d48.a r4 = r7.b("/alice/profile/user_name_unique", r8, FlowAccountSdk.f().getCommonParams(), null);     // Catch: Throwable -> L18
        if (r4.a() == true) goto L6;
        Object r9 = new w38.b.a(new w38.b.C0134b(r4.b, r4.e, null, 12));     // Catch: Throwable -> L18
    L16:
        Object r5 = Result.constructor-impl(r9);     // Catch: Throwable -> L18
    L20:
        Throwable r10 = Result.exceptionOrNull-impl(r5);
        if (r10 == null) goto L24;
        com.larus.account.saas.runtime.internal.delegate.a.a.a("AccountApi", "/alice/profile/user_name_unique error: " + r10.getMessage());
        r5 = new w38.b.a(new w38.b.C0134b(-1, r10.getMessage(), r10, 8));
    L24:
        w38.b r11 = (w38.b) r5;
        w38.a.b("/alice/profile/user_name_unique", r11);
        if ((r11 instanceof w38.b.d) == false) goto L42;
        com.larus.account.saas.runtime.internal.delegate.a r12 = com.larus.account.saas.runtime.internal.delegate.a.a;
        StringBuilder r13 = new StringBuilder("checkUserName ");
        w38.b.d r14 = (w38.b.d) r11;
        CheckUserNameResponse r15 = (CheckUserNameResponse) r14.a;
        if (r15 == null) goto L29;
        String r16 = r15.getUserName();
    L30:
        r13.append(r16);
        r13.append(' ');
        CheckUserNameResponse r17 = (CheckUserNameResponse) r14.a;
        if (r17 == null) goto L33;
        Boolean r19 = Boolean.valueOf(r17.isUnique());
    L34:
        r13.append(r19);
        r12.d("AccountProfileService", r13.toString());
        CheckUserNameResponse r20 = (CheckUserNameResponse) r14.a;
        if (r20 != null) goto L37;
    L39:
        if (r2 == false) goto L41;
        this.$callback.onSuccess(Boolean.TRUE);
        return;
    L41:
        this.$callback.a(new x38.a(-1, "User name is unavailable", null));
        return;
    L37:
        if (r20.isUnique() != true) goto L39;
        r2 = true;
        goto L39
    L33:
        r19 = null;
        goto L34
    L29:
        r16 = null;
        goto L30
    L42:
        com.larus.account.saas.runtime.internal.delegate.a.a.d("AccountProfileService", "checkUserName failed error = " + r11.a());
        this.$callback.a(new x38.a(r11.a().getCode(), r11.a().getTips(), r11.a().getException()));
        return;
    L6:
        String r21 = r4.d;     // Catch: Throwable -> L18
        Type r22 = TypeToken.getParameterized(CommonResponse.class, new Type[]{CheckUserNameResponse.class}).getType();     // Catch: Throwable -> L18
        Lazy r23 = GsonHolder.a;     // Catch: Throwable -> L18
        CommonResponse r24 = (CommonResponse) GsonHolder.b(r21, r22);     // Catch: Throwable -> L18
        if (r24 != null) goto L10;
        r9 = new w38.b.a(new w38.b.C0134b(-1, "json parse error", null, 12));     // Catch: Throwable -> L18
        goto L16
    L10:
        if (r24.getCode() != 0) goto L12;
        boolean r25 = true;
    L13:
        if (r25 == false) goto L15;
        r9 = new w38.b.d(r24.getData());     // Catch: Throwable -> L18
        goto L16
    L15:
        r9 = new w38.b.a(new w38.b.C0134b(r24.getCode(), r24.getMsg(), null, 12));     // Catch: Throwable -> L18
        goto L16
    L12:
        r25 = false;
    L18:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m370invoke();
        return Unit.INSTANCE;
    }
}
