package eu0;

import com.bytedance.android.anya.MVIState;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h0 extends MVIState<h0> {
    public static final /* synthetic */ KProperty[] c = null;
    public final com.bytedance.android.anya.internal.r a;
    public final com.bytedance.android.anya.internal.r b;

    static {
        c = new KProperty[]{Reflection.property1(new PropertyReference1Impl(h0.class, "show", "getShow()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(h0.class, "iconRes", "getIconRes()Lcom/bytedance/android/anya/SimpleProperty;", 0))};
    }

    public h0() {
        Boolean r0 = Boolean.FALSE;
        Function1 r2 = ((MVIState) this).propertyChangeCallback;
        Function1 r3 = ((MVIState) this).propertyAddedCallback;
        com.bytedance.android.anya.internal.r r1 = new com.bytedance.android.anya.internal.r(r0, r2, r3);
        KCallable[] r4 = c;
        ((com.bytedance.android.anya.internal.c) r1).a = r4[0].getName();
        r3.invoke(r1);
        this.a = r1;
        vh7.c r5 = vh7.f.c(py.k.class);
        Function1 r6 = ((MVIState) this).propertyChangeCallback;
        Function1 r7 = ((MVIState) this).propertyAddedCallback;
        com.bytedance.android.anya.internal.r r8 = new com.bytedance.android.anya.internal.r(r5, r6, r7);
        ((com.bytedance.android.anya.internal.c) r8).a = r4[1].getName();
        r7.invoke(r8);
        this.b = r8;
    }
}
