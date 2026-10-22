package eu0;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.SubStatePropertyImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m0 extends MVIState<m0> {
    public static final /* synthetic */ KProperty[] g = null;
    public final com.bytedance.android.anya.internal.r a;
    public final com.bytedance.android.anya.internal.r b;
    public final SubStatePropertyImpl c;
    public final SubStatePropertyImpl d;
    public final SubStatePropertyImpl e;
    public final SubStatePropertyImpl f;

    static {
        g = new KProperty[]{Reflection.property1(new PropertyReference1Impl(m0.class, "show", "getShow()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(m0.class, "showLog", "getShowLog()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(m0.class, "liveFansClubIconState", "getLiveFansClubIconState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(m0.class, "ecomFansClubIconState", "getEcomFansClubIconState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(m0.class, "singleVipIconState", "getSingleVipIconState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(m0.class, "singleCommonVipState", "getSingleCommonVipState()Lcom/bytedance/android/anya/SubStateProperty;", 0))};
    }

    public final com.bytedance.android.anya.r0<m0, Boolean> getShow() {
        com.bytedance.android.anya.internal.r r0 = this.a;
        KProperty r1 = g[0];
        r0.getClass();
        return r0;
    }

    public m0() {
        Boolean r0 = Boolean.FALSE;
        Function1 r2 = ((MVIState) this).propertyChangeCallback;
        Function1 r3 = ((MVIState) this).propertyAddedCallback;
        com.bytedance.android.anya.internal.r r1 = new com.bytedance.android.anya.internal.r(r0, r2, r3);
        KCallable[] r4 = g;
        ((com.bytedance.android.anya.internal.c) r1).a = r4[0].getName();
        r3.invoke(r1);
        this.a = r1;
        Function1 r5 = ((MVIState) this).propertyChangeCallback;
        Function1 r6 = ((MVIState) this).propertyAddedCallback;
        com.bytedance.android.anya.internal.r r7 = new com.bytedance.android.anya.internal.r(r0, r5, r6);
        ((com.bytedance.android.anya.internal.c) r7).a = r4[1].getName();
        r6.invoke(r7);
        this.b = r7;
        Function1 r8 = ((MVIState) this).propertyChangeCallback;
        Function1 r9 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r10 = new SubStatePropertyImpl(n0.class, null, r8, r9);
        ((com.bytedance.android.anya.internal.c) r10).a = r4[2].getName();
        r9.invoke(r10);
        this.c = r10;
        Function1 r12 = ((MVIState) this).propertyChangeCallback;
        Function1 r13 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r14 = new SubStatePropertyImpl(l0.class, null, r12, r13);
        ((com.bytedance.android.anya.internal.c) r14).a = r4[3].getName();
        r13.invoke(r14);
        this.d = r14;
        Function1 r15 = ((MVIState) this).propertyChangeCallback;
        Function1 r16 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r17 = new SubStatePropertyImpl(o0.class, null, r15, r16);
        ((com.bytedance.android.anya.internal.c) r17).a = r4[4].getName();
        r16.invoke(r17);
        this.e = r17;
        Function1 r18 = ((MVIState) this).propertyChangeCallback;
        Function1 r19 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r20 = new SubStatePropertyImpl(k0.class, null, r18, r19);
        ((com.bytedance.android.anya.internal.c) r20).a = r4[5].getName();
        r19.invoke(r20);
        this.f = r20;
    }
}
