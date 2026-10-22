package com.bytedance.android.live.incentive.exchange;

import android.content.Context;
import com.bytedance.android.live.recharge.exchange.saas.CashExchangeDialog;
import com.bytedance.android.live.recharge.model.ExchangeType;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class SaasOldExchangeDialogHelper {
    public static final wh6.a a = null;
    public static WeakReference<CashExchangeDialog> b;
    public static final boolean c = false;

    static {
        wh6.a r0 = vh6.c.b(wh6.a.class);
        a = r0;
        c = !r0.Wb();
    }

    public static void a(final Context r8, final ExchangeType r9, final long r11, final zv0.e r12, final py.k r13) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "type");
        Intrinsics.checkNotNullParameter(r12, "listener");
        Function0<Unit> r0 = new SaasOldExchangeDialogHelper$showExchangeDialog$1(r11, r12, r8, r9, r13);
        Intrinsics.checkNotNullParameter(r0, "action");
        com.bytedance.live.kmp.util.f.a(r0);
    }
}
