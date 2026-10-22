package com.bytedance.android.live.impl;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.h5;
import com.bytedance.android.live.impl.monitor.StrategyTeaLogHelper;
import com.bytedance.android.live.impl.strategy.Strategy;
import com.bytedance.android.live.strategy.api.CombineInfo;
import com.bytedance.android.live.strategy.api.IStrategyService;
import com.bytedance.android.live.strategy.api.StrategyMutableLiveData;
import com.bytedance.android.live.v3.StrategyManagerV3;
import com.bytedance.android.livesdk.c3;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.StrategyV3Config;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J;\u0010\u0007\u001a\n\u0012\u0004\u0012\u0002H\t\u0018\u00010\b\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u0002H\t2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\u000fJ5\u0010\u0007\u001a\u0004\u0018\u0001H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u0002H\t2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\u0018\u0010\u0019\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000bH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/impl/StrategyService;", "Lcom/bytedance/android/live/strategy/api/IStrategyService;", "()V", "ebableV3", "", "getEbableV3", "()Z", "getFactor", "Landroidx/lifecycle/LiveData;", "T", "faName", "", "default", "sendTeaLog", "useCache", "(Ljava/lang/String;Ljava/lang/Object;ZZ)Landroidx/lifecycle/LiveData;", "anchorId", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Z)Ljava/lang/Object;", "getShotStrategy", "Lcom/bytedance/android/live/strategy/api/CombineInfo;", "init", "", "isSmartSDKInit", "isStrategyFactor", "releaseCache", "sendLog", "value", "livestrategy-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class StrategyService implements IStrategyService {
    private final boolean ebableV3;

    public void init() {
        if (this.ebableV3 == false) goto L5;
        StrategyManagerV3.t.g();
        return;
    L5:
        StrategyManager.s.g();
    }

    public boolean isSmartSDKInit() {
        if (this.ebableV3 == false) goto L6;
        StrategyManagerV3.t.getClass();
        return StrategyManagerV3.k;
    L6:
        StrategyManager.s.getClass();
        return StrategyManager.j;
    }

    public void releaseCache() {
        if (((Boolean) h5.a.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        if (this.ebableV3 == false) goto L7;
        StrategyManagerV3.t.getClass();
        ((ConcurrentHashMap) StrategyManagerV3.d).keySet().retainAll(StrategyManagerV3.h);
        ((ArrayList) StrategyManagerV3.j).clear();
        return;
    L7:
        StrategyManager.s.getClass();
        ((ConcurrentHashMap) StrategyManager.d).keySet().retainAll(StrategyManager.h);
        ((ArrayList) StrategyManager.i).clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StrategyService() {
        this.ebableV3 = ((StrategyV3Config) c3.a.getValue()).getEnable_v3();
        if (k.h(IStrategyService.class) == true) goto L6;
        k.l(IStrategyService.class, this);
        return;
    }

    public final boolean getEbableV3() {
        return this.ebableV3;
    }

    public CombineInfo getShotStrategy(String r18) {
        Intrinsics.checkNotNullParameter(r18, "faName");
        if (this.ebableV3 == false) goto L24;
        StrategyManagerV3.t.getClass();
        Intrinsics.checkNotNullParameter(r18, "faName");
        if (StrategyManagerV3.k == false) goto L23;
        String r0 = StrategyTeaLogHelper.b(r18);
        Strategy r1 = StrategyManagerV3.a;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("strategy");
    L9:
        if (r1 == null) goto L23;
        CopyOnWriteArrayList<CombineInfo> r2 = r1.getCombineStrategys();
        if (r2 == null) goto L23;
        Iterator<T> r3 = r2.iterator();
    L14:
        if (r3.hasNext() == false) goto L23;
        CombineInfo r4 = (CombineInfo) r3.next();
        if (r4 == null) goto L14;
        String r5 = r4.getCombineId();
        if (r5 == null) goto L14;
        if (r5.equals(r0) != true) goto L14;
        return r4;
    L23:
        return new CombineInfo(null, null, null, null, null, null, null, null, 255, null);
    L24:
        StrategyManager.s.getClass();
        Intrinsics.checkNotNullParameter(r18, "faName");
        if (StrategyManager.j == false) goto L43;
        String r6 = StrategyTeaLogHelper.b(r18);
        Strategy r7 = StrategyManager.a;
        if (r7 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("strategy");
    L29:
        if (r7 == null) goto L43;
        CopyOnWriteArrayList<CombineInfo> r8 = r7.getCombineStrategys();
        if (r8 == null) goto L43;
        Iterator<T> r9 = r8.iterator();
    L34:
        if (r9.hasNext() == false) goto L43;
        CombineInfo r11 = (CombineInfo) r9.next();
        if (r11 == null) goto L34;
        String r12 = r11.getCombineId();
        if (r12 == null) goto L34;
        if (r12.equals(r6) != true) goto L34;
        return r11;
    L43:
        return new CombineInfo(null, null, null, null, null, null, null, null, 255, null);
    }

    public boolean isStrategyFactor(String r4) {
        Intrinsics.checkNotNullParameter(r4, "faName");
        if (this.ebableV3 == false) goto L8;
        StrategyManagerV3.t.getClass();
        Intrinsics.checkNotNullParameter(r4, "faName");
        if (StrategyManagerV3.n == true) goto L7;
        return false;
    L7:
        return StrategyManagerV3.e.contains(r4);
    L8:
        StrategyManager.s.getClass();
        Intrinsics.checkNotNullParameter(r4, "faName");
        if (StrategyManager.m == true) goto L11;
        return false;
    L11:
        return StrategyManager.e.contains(r4);
    }

    public void sendLog(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "faName");
        Intrinsics.checkNotNullParameter(r6, "value");
        HashMap r2 = new HashMap();
        r2.put("faName", r5);
        r2.put("value", r6);
        IRoomContextService r7 = k.f(IRoomContextService.class);
        Class r8 = null;
        if (r7 == null) goto L7;
        o r9 = IRoomContextService.a.a(r7, null, 0, 3);
        if (r9 == null) goto L7;
        r8 = r9.Q2();
    L7:
        j0.l().sendLog("livesdk_strategy_fa_monitor", r2, new Object[]{r8});
    }

    public <T> LiveData<T> getFactor(String r2, T r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "faName");
    L9:
        e = move-exception;
        ALogger.i("strategy_tag", e.getMessage());
        StrategyMutableLiveData r6 = new StrategyMutableLiveData();
        r6.setValue(r3);
        return r6;
    L4:
        if (this.ebableV3 == false) goto L8;
        return StrategyManagerV3.t.d(r2, r3, r4, r5);
    L8:
        return StrategyManager.s.d(r2, r3, r4, r5);
    }

    public <T> T getFactor(String r1, T r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "faName");
        Intrinsics.checkNotNullParameter(r3, "anchorId");
    L9:
        e = move-exception;
        ALogger.i("strategy_tag", e.getMessage());
        return r2;
    L4:
        if (this.ebableV3 == false) goto L8;
        return (T) StrategyManagerV3.t.e(r1, r3, r2);
    L8:
        return (T) StrategyManager.s.e(r1, r3, r2);
    }
}
