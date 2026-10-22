package com.larus.account.saas.core.ttaccount;

import b48.j;
import b48.l;
import com.google.gson.reflect.TypeToken;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.account.saas.FlowAccountSdk;
import com.larus.account.saas.core.internal.network.CommonResponse;
import com.larus.account.saas.core.internal.network.UpdateProfileResponse;
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
import kotlin.text.StringsKt;
import x38.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = WheelView.WHEEL_ITEM_HEIGHT)
final class AccountProfileService$editUserInfo$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $avatarUrl;
    final /* synthetic */ g<Unit> $callback;
    final /* synthetic */ boolean $isRegister;
    final /* synthetic */ String $nickName;
    final /* synthetic */ String $userId;
    final /* synthetic */ String $userName;

    public AccountProfileService$editUserInfo$1(String r1, String r2, String r3, String r4, boolean r5, g<Unit> r6) {
        this.$userId = r1;
        this.$nickName = r2;
        this.$userName = r3;
        this.$avatarUrl = r4;
        this.$isRegister = r5;
        this.$callback = r6;
        super(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m371invoke() {
        w38.a r0 = w38.a.a;
        String r2 = this.$userId;
        String r3 = this.$nickName;
        String r4 = this.$userName;
        String r5 = this.$avatarUrl;
        boolean r6 = this.$isRegister;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "nickName");
        Intrinsics.checkNotNullParameter(r4, "userName");
        Intrinsics.checkNotNullParameter(r5, "avatarUrl");
        w38.a.a("/alice/profile/update_profile");
        j r9 = null;
        String r10 = null;
        r10 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L18
        c48.a.a().c();     // Catch: Throwable -> L18
        com.larus.init.task.accountsdk.g r7 = com.larus.init.task.accountsdk.g.a;     // Catch: Throwable -> L18
        LinkedHashMap r12 = new LinkedHashMap();     // Catch: Throwable -> L18
        r12.put("entity_id", r2);     // Catch: Throwable -> L18
        r12.put("nickname", r3);     // Catch: Throwable -> L18
        r12.put("user_name", r4);     // Catch: Throwable -> L18
        r12.put("avatar_url", r5);     // Catch: Throwable -> L18
        r12.put("is_register", Boolean.valueOf(r6));     // Catch: Throwable -> L18
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L18
        d48.a r11 = r7.b("/alice/profile/update_profile", r12, FlowAccountSdk.f().getCommonParams(), null);     // Catch: Throwable -> L18
        if (r11.a() == true) goto L6;
        Object r13 = new w38.b.a(new w38.b.C0134b(r11.b, r11.e, null, 12));     // Catch: Throwable -> L18
    L16:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L18
    L20:
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 == null) goto L24;
        com.larus.account.saas.runtime.internal.delegate.a.a.a("AccountApi", "/alice/profile/update_profile error: " + r15.getMessage());
        r14 = new w38.b.a(new w38.b.C0134b(-1, r15.getMessage(), r15, 8));
    L24:
        w38.b r16 = (w38.b) r14;
        w38.a.b("/alice/profile/update_profile", r16);
        if ((r16 instanceof w38.b.d) == false) goto L92;
        com.larus.account.saas.runtime.internal.delegate.a r17 = com.larus.account.saas.runtime.internal.delegate.a.a;
        StringBuilder r19 = new StringBuilder("editUserInfo ");
        UpdateProfileResponse r20 = (UpdateProfileResponse) ((w38.b.d) r16).a;
        if (r20 == null) goto L29;
        String r21 = r20.getUserID();
    L30:
        r19.append(r21);
        r17.d("AccountProfileService", r19.toString());
        b48.b r22 = FlowAccountSdk.f().getAccountInfo();
        if (r22.a == true) goto L33;
    L91:
        this.$callback.onSuccess(Unit.INSTANCE);
        return;
    L33:
        if (Intrinsics.areEqual(r22.b, this.$userId) == false) goto L91;
        com.larus.account.saas.core.internal.a r23 = com.larus.account.saas.core.internal.a.a;
        String r24 = this.$nickName;
        String r25 = this.$userName;
        String r26 = this.$avatarUrl;
        Intrinsics.checkNotNullParameter(r22, "baseInfo");
        if (r22.a == false) goto L91;
        l r27 = com.larus.account.saas.core.internal.a.a(r22.c);
        if (r27 != null) goto L40;
    L42:
        r27 = null;
    L43:
        if (r24 != null) goto L45;
    L49:
        if (r27 == null) goto L52;
        r24 = r27.c;
    L51:
        String r110 = r24;
    L53:
        if (r25 != null) goto L55;
    L61:
        if (r27 == null) goto L63;
        String r111 = r27.d;
    L64:
        if (r26 != null) goto L66;
    L68:
        r26 = null;
    L69:
        if (r26 != null) goto L71;
        if (r27 == null) goto L78;
        r9 = r27.e;
    L78:
        j r112 = r9;
    L80:
        if (r27 == null) goto L82;
        int r113 = r27.a;
    L83:
        String r114 = r22.b;
        if (r27 == null) goto L86;
        boolean r115 = r27.f;
    L87:
        if (r27 == null) goto L89;
        boolean r116 = r27.g;
    L90:
        r23.b(r22, new l(r113, r114, r110, r111, r112, r115, r116));
        goto L91
    L89:
        r116 = false;
        goto L90
    L86:
        r115 = false;
        goto L87
    L82:
        r113 = 0;
        goto L83
    L71:
        if (r27 == null) goto L75;
        j r29 = r27.e;
        if (r29 == null) goto L75;
        r10 = r29.a;
    L75:
        r112 = new j(r10, r26, r26);
        goto L80
    L66:
        if ((!StringsKt.isBlank(r26)) == false) goto L68;
    L63:
        r111 = null;
        goto L64
    L55:
        if ((!StringsKt.isBlank(r25)) == true) goto L58;
        r25 = null;
    L58:
        if (r25 == null) goto L61;
        r111 = r25;
        goto L64
    L52:
        r110 = null;
        goto L53
    L45:
        if ((!StringsKt.isBlank(r24)) == true) goto L48;
        r24 = null;
    L48:
        if (r24 != null) goto L51;
    L40:
        if (Intrinsics.areEqual(r27.b, r22.b) == false) goto L42;
    L29:
        r21 = null;
        goto L30
    L92:
        com.larus.account.saas.runtime.internal.delegate.a.a.d("AccountProfileService", "editUserInfo failed error = " + r16.a());
        this.$callback.a(new x38.a(r16.a().getCode(), r16.a().getTips(), r16.a().getException()));
        return;
    L6:
        String r30 = r11.d;     // Catch: Throwable -> L18
        Type r31 = TypeToken.getParameterized(CommonResponse.class, new Type[]{UpdateProfileResponse.class}).getType();     // Catch: Throwable -> L18
        Lazy r32 = GsonHolder.a;     // Catch: Throwable -> L18
        CommonResponse r33 = (CommonResponse) GsonHolder.b(r30, r31);     // Catch: Throwable -> L18
        if (r33 != null) goto L10;
        r13 = new w38.b.a(new w38.b.C0134b(-1, "json parse error", null, 12));     // Catch: Throwable -> L18
        goto L16
    L10:
        if (r33.getCode() != 0) goto L12;
        boolean r34 = true;
    L13:
        if (r34 == false) goto L15;
        r13 = new w38.b.d(r33.getData());     // Catch: Throwable -> L18
        goto L16
    L15:
        r13 = new w38.b.a(new w38.b.C0134b(r33.getCode(), r33.getMsg(), null, 12));     // Catch: Throwable -> L18
        goto L16
    L12:
        r34 = false;
    L18:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m371invoke();
        return Unit.INSTANCE;
    }
}
