package eu0;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.live.profit.fansclub.widget.entrance.mvistate.EntranceAnimState;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n extends MVIState<n> {
    public static final /* synthetic */ KProperty[] h = null;
    public final com.bytedance.android.anya.internal.r a;
    public final com.bytedance.android.anya.internal.r b;
    public final com.bytedance.android.anya.internal.r c;
    public final com.bytedance.android.anya.internal.r d;
    public final com.bytedance.android.anya.internal.r e;
    public final com.bytedance.android.anya.internal.r f;
    public final com.bytedance.android.anya.internal.r g;

    static {
        h = new KProperty[]{Reflection.property1(new PropertyReference1Impl(n.class, "show", "getShow()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(n.class, "iconRes", "getIconRes()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(n.class, "showIcon", "getShowIcon()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(n.class, "backgroundRes", "getBackgroundRes()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(n.class, "showLevel", "getShowLevel()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(n.class, "level", "getLevel()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(n.class, "animState", "getAnimState()Lcom/bytedance/android/anya/SimpleProperty;", 0))};
    }

    public final com.bytedance.android.anya.r0<n, Boolean> getShow() {
        com.bytedance.android.anya.internal.r r0 = this.a;
        KProperty r1 = h[0];
        r0.getClass();
        return r0;
    }

    public n() {
        Boolean r0 = Boolean.FALSE;
        Function1 r2 = ((MVIState) this).propertyChangeCallback;
        Function1 r3 = ((MVIState) this).propertyAddedCallback;
        com.bytedance.android.anya.internal.r r1 = new com.bytedance.android.anya.internal.r(r0, r2, r3);
        KCallable[] r4 = h;
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
        Function1 r16 = ((MVIState) this).propertyChangeCallback;
        Function1 r17 = ((MVIState) this).propertyAddedCallback;
        com.bytedance.android.anya.internal.r r18 = new com.bytedance.android.anya.internal.r(r0, r16, r17);
        ((com.bytedance.android.anya.internal.c) r18).a = r4[4].getName();
        r17.invoke(r18);
        this.e = r18;
        Function1 r19 = ((MVIState) this).propertyChangeCallback;
        Function1 r20 = ((MVIState) this).propertyAddedCallback;
        com.bytedance.android.anya.internal.r r22 = new com.bytedance.android.anya.internal.r(0, r19, r20);
        ((com.bytedance.android.anya.internal.c) r22).a = r4[5].getName();
        r20.invoke(r22);
        this.f = r22;
        EntranceAnimState r23 = EntranceAnimState.NONE;
        Function1 r24 = ((MVIState) this).propertyChangeCallback;
        Function1 r25 = ((MVIState) this).propertyAddedCallback;
        com.bytedance.android.anya.internal.r r26 = new com.bytedance.android.anya.internal.r(r23, r24, r25);
        ((com.bytedance.android.anya.internal.c) r26).a = r4[6].getName();
        r25.invoke(r26);
        this.g = r26;
    }
}
