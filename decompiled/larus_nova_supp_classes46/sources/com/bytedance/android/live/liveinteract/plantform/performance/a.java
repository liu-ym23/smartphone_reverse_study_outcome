package com.bytedance.android.live.liveinteract.plantform.performance;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.c60;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiLinkPerfBalanceConfig;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public Map<String, BehaviorSubject<d0>> a;
    public Disposable b;
    public final Map<String, c0> c;
    public boolean d;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.plantform.performance.a$a, reason: collision with other inner class name */
    public static final class C0060a {
    }

    static {
    }

    public a() {
        this.c = new LinkedHashMap();
    }

    public final boolean a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "abilityKey");
        Map<String, BehaviorSubject<d0>> r0 = this.a;
        if (r0 == null) goto L9;
        BehaviorSubject<d0> r3 = r0.get(r2);
        if (r3 == null) goto L9;
        d0 r4 = (d0) r3.getValue();
        if (r4 == null) goto L9;
        return r4.a;
    L9:
        return true;
    }

    public final void d(Function1 r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.c.remove(String.valueOf(r2.hashCode()));
        ALogger.i("MultiLinkAtomicAbility-Manager", "unRegisterPerfAbilityCBForAllAbility  bizSize=" + this.c.size());
    }

    public final String b(String r6, Function1<? super Map<String, d0>, Unit> r7) {
        Intrinsics.checkNotNullParameter(r6, "abilityKey");
        Intrinsics.checkNotNullParameter(r7, "callback");
        if (((MultiLinkPerfBalanceConfig) c60.a.getValue()).getPerfBalanceEnable() == true) goto L6;
        return "";
    L6:
        String r0 = String.valueOf(r7.hashCode());
        if (this.c.containsKey(r0) == false) goto L13;
        c0 r8 = (c0) ((LinkedHashMap) this.c).get(r0);
        if (r8 == null) goto L14;
        HashSet<String> r9 = r8.a;
        if (r9 == null) goto L14;
        r9.add(r6);
    L14:
        StringBuilder r10 = new StringBuilder("registerPerfAbilityCB abilityKey=");
        r10.append(r6);
        r10.append(" cbId=");
        r10.append(r0);
        r10.append(" currentBizSubSize=");
        c0 r11 = (c0) ((LinkedHashMap) this.c).get(r0);
        if (r11 == null) goto L19;
        HashSet<String> r12 = r11.a;
        if (r12 == null) goto L19;
        Integer r13 = Integer.valueOf(r12.size());
    L20:
        r10.append(r13);
        r10.append(" bizSize=");
        r10.append(this.c.size());
        ALogger.i("MultiLinkAtomicAbility-Manager", r10.toString());
        return r0;
    L19:
        r13 = null;
        goto L20
    L13:
        this.c.put(r0, new c0(SetsKt.hashSetOf(new String[]{r6}), r7));
        goto L14
    }

    public final boolean c(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "abilityKey");
        Intrinsics.checkNotNullParameter(r6, "cbId");
        c0 r0 = (c0) ((LinkedHashMap) this.c).get(r6);
        if (r0 == null) goto L18;
        Iterator<T> r1 = r0.a.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        Object r2 = r1.next();
        if (Intrinsics.areEqual((String) r2, r5) == false) goto L6;
    L12:
        if (((String) r2) == null) goto L23;
        r0.a.remove(r5);
        if (r0.a.isEmpty() == false) goto L16;
        this.c.remove(r6);
    L16:
        ALogger.i("MultiLinkAtomicAbility-Manager", "unRegisterPerfAbilityCBById abilityKey=" + r5 + " cbId=" + r6 + " currentBizSubSize=" + r0.a.size() + " bizSize=" + this.c.size());
        return true;
    L23:
        return false;
    L10:
        r2 = null;
        goto L12
    L18:
        return false;
    }
}
