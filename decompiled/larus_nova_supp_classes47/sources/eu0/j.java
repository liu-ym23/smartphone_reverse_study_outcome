package eu0;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.SubStatePropertyImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j extends MVIState<j> {
    public static final /* synthetic */ KProperty[] e = null;
    public final SubStatePropertyImpl a;
    public final SubStatePropertyImpl b;
    public final SubStatePropertyImpl c;
    public final SubStatePropertyImpl d;

    static {
        e = new KProperty[]{Reflection.property1(new PropertyReference1Impl(j.class, "followIconState", "getFollowIconState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(j.class, "singleEntranceState", "getSingleEntranceState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(j.class, "doubleEntranceState", "getDoubleEntranceState()Lcom/bytedance/android/anya/SubStateProperty;", 0)), Reflection.property1(new PropertyReference1Impl(j.class, "tipState", "getTipState()Lcom/bytedance/android/anya/SubStateProperty;", 0))};
    }

    public j() {
        Function1 r2 = ((MVIState) this).propertyChangeCallback;
        Function1 r3 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r1 = new SubStatePropertyImpl(l.class, null, r2, r3);
        KCallable[] r0 = e;
        ((com.bytedance.android.anya.internal.c) r1).a = r0[0].getName();
        r3.invoke(r1);
        this.a = r1;
        Function1 r4 = ((MVIState) this).propertyChangeCallback;
        Function1 r5 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r6 = new SubStatePropertyImpl(m0.class, null, r4, r5);
        ((com.bytedance.android.anya.internal.c) r6).a = r0[1].getName();
        r5.invoke(r6);
        this.b = r6;
        Function1 r7 = ((MVIState) this).propertyChangeCallback;
        Function1 r8 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r9 = new SubStatePropertyImpl(f.class, null, r7, r8);
        ((com.bytedance.android.anya.internal.c) r9).a = r0[2].getName();
        r8.invoke(r9);
        this.c = r9;
        Function1 r10 = ((MVIState) this).propertyChangeCallback;
        Function1 r12 = ((MVIState) this).propertyAddedCallback;
        SubStatePropertyImpl r13 = new SubStatePropertyImpl(p0.class, null, r10, r12);
        ((com.bytedance.android.anya.internal.c) r13).a = r0[3].getName();
        r12.invoke(r13);
        this.d = r13;
    }
}
