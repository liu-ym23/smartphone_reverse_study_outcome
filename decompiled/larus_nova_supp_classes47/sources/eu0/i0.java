package eu0;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.live.profit.fansclub.widget.entrance.mvistate.EntranceAnimState;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i0 extends MVIState<i0> {
    public static final /* synthetic */ KProperty[] g = null;
    public final com.bytedance.android.anya.internal.r a;
    public final com.bytedance.android.anya.internal.r b;
    public final com.bytedance.android.anya.internal.r c;
    public final com.bytedance.android.anya.internal.r d;
    public final com.bytedance.android.anya.internal.r e;
    public final com.bytedance.android.anya.internal.r f;

    static {
        g = new KProperty[]{Reflection.property1(new PropertyReference1Impl(i0.class, "show", "getShow()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(i0.class, "iconRes", "getIconRes()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(i0.class, "showIcon", "getShowIcon()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(i0.class, "backgroundRes", "getBackgroundRes()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(i0.class, "animState", "getAnimState()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(i0.class, "optIconRes", "getOptIconRes()Lcom/bytedance/android/anya/SimpleProperty;", 0))};
    }

    public final com.bytedance.android.anya.internal.r a() {
        com.bytedance.android.anya.internal.r r0 = this.e;
        KProperty r1 = g[4];
        r0.getClass();
        return r0;
    }

    public final com.bytedance.android.anya.internal.r b() {
        com.bytedance.android.anya.internal.r r0 = this.d;
        KProperty r1 = g[3];
        r0.getClass();
        return r0;
    }

    public final com.bytedance.android.anya.internal.r c() {
        com.bytedance.android.anya.internal.r r0 = this.b;
        KProperty r1 = g[1];
        r0.getClass();
        return r0;
    }

    public i0() {
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
        com.bytedance.android.anya.internal.r r7 = new com.bytedance.android.anya.internal.r(0, r5, r6);
        ((com.bytedance.android.anya.internal.c) r7).a = r4[1].getName();
        r6.invoke(r7);
        this.b = r7;
        Boolean r8 = Boolean.TRUE;
        Function1 r9 = ((MVIState) this).propertyChangeCallback;
        Function1 r10 = ((MVIState) this).propertyAddedCallback;
        com.bytedance.android.anya.internal.r r12 = new com.bytedance.android.anya.internal.r(r8, r9, r10);
        ((com.bytedance.android.anya.internal.c) r12).a = r4[2].getName();
        r10.invoke(r12);
        this.c = r12;
        Function1 r13 = ((MVIState) this).propertyChangeCallback;
        Function1 r14 = ((MVIState) this).propertyAddedCallback;
        com.bytedance.android.anya.internal.r r15 = new com.bytedance.android.anya.internal.r(0, r13, r14);
        ((com.bytedance.android.anya.internal.c) r15).a = r4[3].getName();
        r14.invoke(r15);
        this.d = r15;
        EntranceAnimState r16 = EntranceAnimState.NONE;
        Function1 r17 = ((MVIState) this).propertyChangeCallback;
        Function1 r18 = ((MVIState) this).propertyAddedCallback;
        com.bytedance.android.anya.internal.r r19 = new com.bytedance.android.anya.internal.r(r16, r17, r18);
        ((com.bytedance.android.anya.internal.c) r19).a = r4[4].getName();
        r18.invoke(r19);
        this.e = r19;
        vh7.c r20 = vh7.f.c(py.k.class);
        Function1 r22 = ((MVIState) this).propertyChangeCallback;
        Function1 r23 = ((MVIState) this).propertyAddedCallback;
        com.bytedance.android.anya.internal.r r24 = new com.bytedance.android.anya.internal.r(r20, r22, r23);
        ((com.bytedance.android.anya.internal.c) r24).a = r4[5].getName();
        r23.invoke(r24);
        this.f = r24;
    }
}
