package com.larus.profile.impl.bind_phone;

import com.bytedance.keva.Keva;
import com.larus.login.api.i0;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.o2;
import com.larus.profile.impl.mine.r;
import com.larus.utils.logger.FLogger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c {
    public static final c a = null;
    public static final Keva b = null;
    public static g c;
    public static String d;

    public c() {
    }

    static {
        a = new c();
        b = Keva.getRepo(AccountService.a.getSecUserId() + '_' + o2.a.e(), 0);
    }

    public static boolean b(g r5) {
        if (r5 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L28;
        String r6 = r5.a();
        if (r6 != null) goto L12;
    L15:
        boolean r3 = true;
    L16:
        if (r3 == true) goto L24;
        Keva r4 = b;
        if (Intrinsics.areEqual(r6, r4.getString("key.bind.dialog.show.number", "BindPhoneManager")) == true) goto L24;
        if (r4.getBoolean("key.account.mix.has.show", false) == true) goto L24;
        boolean r7 = false;
    L25:
        if (r7 == true) goto L29;
        return true;
    L29:
        return false;
    L24:
        r7 = true;
        goto L25
    L12:
        if (r6.length() == 0) goto L15;
        r3 = false;
        goto L16
    L28:
        return false;
    L5:
        if (r5.b() != true) goto L7;
        r2 = true;
        goto L8
    }

    public final Object a(r r14, Continuation r15) {
        if ((r15 instanceof BindPhoneManager$checkBindPhoneInfo$1) == false) goto L7;
        BindPhoneManager$checkBindPhoneInfo$1 r0 = (BindPhoneManager$checkBindPhoneInfo$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        BindPhoneManager$checkBindPhoneInfo$1 r11 = r0;
        Object r16 = r11.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r11.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Function0 r17 = (Function0) r11.L$0;
        ResultKt.throwOnFailure(r16);
        Function0 r18 = r17;
    L27:
        com.larus.network.http.a r19 = (com.larus.network.http.a) r16;
        if ((r19 instanceof com.larus.network.http.f) == false) goto L30;
        FLogger.a.w("BindPhoneManager", "checkBindPhoneInfo request failed");
    L34:
        return Unit.INSTANCE;
    L30:
        g r110 = (g) r19.b;
        c = r110;
        if (b(r110) == false) goto L34;
        r18.invoke();
        goto L34
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        String r111 = d;
        AccountService r4 = AccountService.a;
        if (Intrinsics.areEqual(r111, r4.getUserId()) == true) goto L17;
        d = r4.getUserId();
        c = null;
    L17:
        g r112 = c;
        if (r112 != null) goto L20;
        String r5 = i0.d;
        JSONObject r6 = new JSONObject();
        r11.L$0 = r14;
        r11.label = 1;
        r16 = HttpExtKt.k("Basic", g.class, r5, r6, null, null, false, null, null, null, r11, 1008);
        r18 = r14;
        if (r16 != r2) goto L27;
        return r2;
    L20:
        if (b(r112) == false) goto L23;
        r14.invoke();
    L23:
        return Unit.INSTANCE;
    L7:
        r0 = new BindPhoneManager$checkBindPhoneInfo$1(this, r15);
        goto L8
    }
}
