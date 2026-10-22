package com.bytedance.android.livesdk.gift.platform.business.pkTray;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.r;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i extends MVIState<i> {
    public static final /* synthetic */ KProperty[] e = null;
    public final r a;
    public final r b;
    public final r c;
    public final r d;

    static {
        e = new KProperty[]{Reflection.property1(new PropertyReference1Impl(i.class, "comboCount", "getComboCount()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(i.class, "icon", "getIcon()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(i.class, "action", "getAction()Lcom/bytedance/android/anya/SimpleProperty;", 0)), Reflection.property1(new PropertyReference1Impl(i.class, "marginTop", "getMarginTop()Lcom/bytedance/android/anya/SimpleProperty;", 0))};
    }

    public i() {
        Function1 r1 = ((MVIState) this).propertyChangeCallback;
        Function1 r2 = ((MVIState) this).propertyAddedCallback;
        r r0 = new r(BuildConfig.FLAVOR, r1, r2);
        KCallable[] r3 = e;
        ((com.bytedance.android.anya.internal.c) r0).a = r3[0].getName();
        r2.invoke(r0);
        this.a = r0;
        vh7.c r4 = vh7.f.c(py.k.class);
        Function1 r5 = ((MVIState) this).propertyChangeCallback;
        Function1 r6 = ((MVIState) this).propertyAddedCallback;
        r r7 = new r(r4, r5, r6);
        ((com.bytedance.android.anya.internal.c) r7).a = r3[1].getName();
        r6.invoke(r7);
        this.b = r7;
        o r8 = new o(TrayActionType.DEFAULT, 0);
        Function1 r9 = ((MVIState) this).propertyChangeCallback;
        Function1 r10 = ((MVIState) this).propertyAddedCallback;
        r r11 = new r(r8, r9, r10);
        ((com.bytedance.android.anya.internal.c) r11).a = r3[2].getName();
        r10.invoke(r11);
        this.c = r11;
        Function1 r13 = ((MVIState) this).propertyChangeCallback;
        Function1 r14 = ((MVIState) this).propertyAddedCallback;
        r r15 = new r(0, r13, r14);
        ((com.bytedance.android.anya.internal.c) r15).a = r3[3].getName();
        r14.invoke(r15);
        this.d = r15;
    }
}
