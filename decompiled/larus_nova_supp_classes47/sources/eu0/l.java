package eu0;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.live.profit.fansclub.widget.entrance.mvistate.EntranceAnimState;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l extends MVIState<l> {
    public static final /* synthetic */ KProperty[] h = null;
    public final com.bytedance.android.anya.internal.r a;
    public final com.bytedance.android.anya.internal.r b;
    public final com.bytedance.android.anya.internal.r c;
    public final com.bytedance.android.anya.internal.r d;
    public final com.bytedance.android.anya.internal.r e;
    public final com.bytedance.android.anya.internal.r f;
    public final com.bytedance.android.anya.internal.r g;

    static {
        h = new KProperty[]{Reflection.property1(new PropertyReference1Impl(l.class, "show", "getShow()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(l.class, "hasAddIcon", "getHasAddIcon()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(l.class, "backgroundRes", "getBackgroundRes()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(l.class, "textColor", "getTextColor()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(l.class, "showText", "getShowText()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(l.class, "showProgressBar", "getShowProgressBar()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(l.class, "animState", "getAnimState()Lcom/bytedance/android/anya/SimpleProperty;", 0))};
    }

    public final com.bytedance.android.anya.internal.r a() {
        com.bytedance.android.anya.internal.r r0 = this.g;
        KProperty r1 = h[6];
        r0.getClass();
        return r0;
    }

    public final com.bytedance.android.anya.internal.r b() {
        com.bytedance.android.anya.internal.r r0 = this.f;
        KProperty r1 = h[5];
        r0.getClass();
        return r0;
    }

    public final com.bytedance.android.anya.internal.r c() {
        com.bytedance.android.anya.internal.r r0 = this.e;
        KProperty r1 = h[4];
        r0.getClass();
        return r0;
    }

    public final com.bytedance.android.anya.r0<l, Boolean> getShow() {
        com.bytedance.android.anya.internal.r r0 = this.a;
        KProperty r1 = h[0];
        r0.getClass();
        return r0;
    }

    public l() {
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
        com.bytedance.android.anya.internal.r r7 = new com.bytedance.android.anya.internal.r(r0, r5, r6);
        ((com.bytedance.android.anya.internal.c) r7).a = r4[1].getName();
        r6.invoke(r7);
        this.b = r7;
        Function1 r8 = ((MVIState) this).propertyChangeCallback;
        Function1 r9 = ((MVIState) this).propertyAddedCallback;
        com.bytedance.android.anya.internal.r r10 = new com.bytedance.android.anya.internal.r(0, r8, r9);
        ((com.bytedance.android.anya.internal.c) r10).a = r4[2].getName();
        r9.invoke(r10);
        this.c = r10;
        Function1 r12 = ((MVIState) this).propertyChangeCallback;
        Function1 r13 = ((MVIState) this).propertyAddedCallback;
        com.bytedance.android.anya.internal.r r14 = new com.bytedance.android.anya.internal.r(0, r12, r13);
        ((com.bytedance.android.anya.internal.c) r14).a = r4[3].getName();
        r13.invoke(r14);
        this.d = r14;
        Function1 r15 = ((MVIState) this).propertyChangeCallback;
        Function1 r16 = ((MVIState) this).propertyAddedCallback;
        com.bytedance.android.anya.internal.r r17 = new com.bytedance.android.anya.internal.r(r0, r15, r16);
        ((com.bytedance.android.anya.internal.c) r17).a = r4[4].getName();
        r16.invoke(r17);
        this.e = r17;
        Function1 r18 = ((MVIState) this).propertyChangeCallback;
        Function1 r19 = ((MVIState) this).propertyAddedCallback;
        com.bytedance.android.anya.internal.r r20 = new com.bytedance.android.anya.internal.r(r0, r18, r19);
        ((com.bytedance.android.anya.internal.c) r20).a = r4[5].getName();
        r19.invoke(r20);
        this.f = r20;
        EntranceAnimState r22 = EntranceAnimState.NONE;
        Function1 r23 = ((MVIState) this).propertyChangeCallback;
        Function1 r24 = ((MVIState) this).propertyAddedCallback;
        com.bytedance.android.anya.internal.r r25 = new com.bytedance.android.anya.internal.r(r22, r23, r24);
        ((com.bytedance.android.anya.internal.c) r25).a = r4[6].getName();
        r24.invoke(r25);
        this.g = r25;
    }
}
