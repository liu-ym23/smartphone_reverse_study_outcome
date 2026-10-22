package com.larus.dora.impl.guide.strategy;

import com.larus.account.base.api.ILoginService;
import com.larus.dora.impl.util.b0;
import com.larus.platform.service.AccountService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Calendar;
import java.util.TimeZone;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d {

    public static final class a {
    }

    static {
    }

    public d() {
    }

    public static Object a() {
        boolean r1 = false;
        ILoginService r2 = (ILoginService) ServiceManager.get().getService(ILoginService.class);     // Catch: Exception -> L31
        if (r2 == null) goto L8;
        if (r2.isNewUser() != true) goto L8;
        boolean r3 = true;
    L9:
        String r4 = AccountService.a.getUserId();
        long r5 = System.currentTimeMillis();
        if (r3 == false) goto L13;
        b0.a.getClass();
        Intrinsics.checkNotNullParameter(r4, "uid");
        b0.j().storeLong("dora_first_main_bot_page_show_timestamp_".concat(r4), r5);
        g49.d.d("NotNewUserStrategy", "new user, condition not met");
        return Boxing.boxBoolean(false);
    L13:
        long r9 = -1;
        b0.a.getClass();     // Catch: Exception -> L16
        Intrinsics.checkNotNullParameter(r4, "uid");     // Catch: Exception -> L16
        r9 = b0.j().getLong("dora_first_main_bot_page_show_timestamp_".concat(r4), -1);     // Catch: Exception -> L16
    L19:
        if (r9 > 0) goto L36;
        g49.d.d("NotNewUserStrategy", "first main bot page show ts not saved");
        return Boxing.boxBoolean(true);
    L36:
        TimeZone r6 = TimeZone.getDefault();     // Catch: Exception -> L27
        Calendar r7 = Calendar.getInstance(r6);     // Catch: Exception -> L27
        Calendar r8 = Calendar.getInstance(r6);     // Catch: Exception -> L27
        r7.setTimeInMillis(r9);     // Catch: Exception -> L27
        r8.setTimeInMillis(r5);     // Catch: Exception -> L27
        if (r7.get(1) != r8.get(1)) goto L29;
        if (r7.get(6) != r8.get(6)) goto L29;
        r1 = true;
    L29:
        g49.d.d("NotNewUserStrategy", "flags: firstBotEnterTs=" + r9 + ", nowTs=" + r5 + ", isFirstDay=" + r1);
        return Boxing.boxBoolean(!r1);
    L27:
        e = move-exception;
        g49.d.c("NotNewUserStrategy", "isSameDay failed, error=" + e.getMessage(), e);
    L16:
        e = move-exception;
        g49.d.c("NotNewUserStrategy", "read first main bot page show ts failed, error=" + e.getMessage(), e);
    L8:
        r3 = false;
    L31:
        e = move-exception;
        g49.d.c("NotNewUserStrategy", "check isNewUser failed, error=" + e.getMessage(), e);
        return Boxing.boxBoolean(false);
    }
}
