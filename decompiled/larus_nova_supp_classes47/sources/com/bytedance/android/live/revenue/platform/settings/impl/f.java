package com.bytedance.android.live.revenue.platform.settings.impl;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.core.setting.c7;
import com.bytedance.android.live.core.setting.v2.update.SettingIncStrategy;
import com.bytedance.android.live.strategy.api.IStrategyService;
import com.bytedance.android.live.strategy.api.StrategyMutableLiveData;
import com.bytedance.android.livesdkapi.strategy.StrategyConvertHelper;
import java.lang.reflect.Type;
import java.util.concurrent.ConcurrentHashMap;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public static final Boolean a = null;
    public static final ConcurrentHashMap<String, Pair<Object, Type>> b = null;
    public static final StrategyMutableLiveData<Object> c = null;
    public static final Boolean d = null;
    public static volatile IStrategyService e;

    public static final class a implements b70.a {
        public a() {
        }

        public final void onSuccess() {
            f.b.clear();
        }
    }

    static {
        Class r0 = Boolean.TYPE;
        a = (Boolean) c7.e("ultra_setting_cache_enable", r0, Boolean.FALSE, false, false);
        b = new ConcurrentHashMap();
        c = new StrategyMutableLiveData();
        d = (Boolean) c7.e("ultra_setting_strategy_enable", r0, Boolean.TRUE, true, false);
        SettingIncStrategy.a(new a());
    }

    public static Object a(String r3, Object r4, Type r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r5, "type");
        Boolean r0 = a;
        if (r0.booleanValue() == false) goto L10;
        Pair<Object, Type> r1 = b.get(r3);
        if (r1 == null) goto L10;
        if (Intrinsics.areEqual((Type) r1.getSecond(), r5) == false) goto L10;
        return r1.getFirst();
    L10:
        Object r7 = c7.e(r3, r5, r4, r6, false);
        if (d.booleanValue() == false) goto L46;
        if (r6 == true) goto L46;
        if (k.h(IStrategyService.class) == false) goto L46;
        if (e != null) goto L18;
        e = k.f(IStrategyService.class);
    L18:
        IStrategyService r8 = e;
        if (r8 == null) goto L46;
        if (r8.isStrategyFactor(r3) != true) goto L46;
        if ((r7 instanceof Boolean) == false) goto L25;
    L34:
        IStrategyService r9 = e;
        if (r9 == null) goto L37;
        LiveData r10 = r9.getFactor(r3, r7, true, true);
    L38:
        if (r10 == null) goto L40;
        Object r12 = r10.getValue();
    L41:
        if (r12 == null) goto L46;
        if (r12 == c.getValue()) goto L46;
        r7 = r12;
        goto L46
    L40:
        r12 = null;
        goto L41
    L37:
        r10 = null;
        goto L38
    L25:
        if ((r7 instanceof Integer) == true) goto L34;
        if ((r7 instanceof String) == true) goto L34;
        if ((r7 instanceof Float) == true) goto L34;
        if ((r7 instanceof Double) == true) goto L34;
        r12 = StrategyConvertHelper.getObjectStrategyValue(r3, r7, true, true);
    L46:
        if (r0.booleanValue() == false) goto L49;
        if (r7 == null) goto L49;
        b.put(r3, TuplesKt.to(r7, r5));
    L49:
        return r7;
    }
}
