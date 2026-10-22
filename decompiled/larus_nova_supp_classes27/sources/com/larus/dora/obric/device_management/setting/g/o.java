package com.larus.dora.obric.device_management.setting.g;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.bytedance.router.SmartRouter;
import java.util.Iterator;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class o<T> implements FlowCollector {
    public final /* synthetic */ DoraObricGSettingsFragment a;

    public o(DoraObricGSettingsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r7, Continuation r8) {
        s r9 = (s) r7;
        if ((r9 instanceof s.a) == false) goto L32;
        DoraObricGSettingsFragment r10 = this.a;
        s.a r11 = (s.a) r9;
        int r0 = DoraObricGSettingsFragment.m;
        Context r1 = r10.getContext();
        if (r1 == null) goto L30;
        Bundle r2 = new Bundle();
        Bundle r3 = r10.getArguments();
        if (r3 == null) goto L10;
        r2.putAll(r3);
    L10:
        String r4 = r10.aa0().targetDeviceMac();
        if (r4 == null) goto L13;
        r2.putString("mac", r4);
    L13:
        Iterator<Map.Entry<String, Object>> r5 = r11.b.entrySet().iterator();
    L15:
        if (r5.hasNext() == false) goto L28;
        Map.Entry<String, Object> r6 = r5.next();
        String r12 = r6.getKey();
        Object r13 = r6.getValue();
        if ((r13 instanceof String) == true) goto L18;
        if ((r13 instanceof Boolean) == true) goto L21;
        if ((r13 instanceof Integer) == true) goto L24;
        if ((r13 instanceof Parcelable) == false) goto L15;
        r2.putParcelable(r12, (Parcelable) r13);
        goto L15
    L24:
        r2.putInt(r12, ((Number) r13).intValue());
        goto L15
    L21:
        r2.putBoolean(r12, ((Boolean) r13).booleanValue());
        goto L15
    L18:
        r2.putString(r12, (String) r13);
        goto L15
    L28:
        by7.h.k(r2, r10);
        com.bytedance.router.i r14 = SmartRouter.buildRoute(r1, r11.a);
        r14.c.putExtras(r2);
        r14.d();
    L30:
        return Unit.INSTANCE;
    L32:
        throw new NoWhenBranchMatchedException();
    }
}
