package com.bytedance.android.anya;

import com.bytedance.android.anya.internal.MVIBindingImpl;
import com.bytedance.android.livesdk.gift.framework.base.GiftMVITraceListener;
import com.google.common.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class b {
    public b() {
    }

    public abstract Collection<BaseMVIViewModel<?, ?>> d();

    public abstract <STATE extends MVIState<?>, ACTION extends p> BaseMVIViewModel<STATE, ACTION> f(Class<? extends BaseMVIViewModel<STATE, ACTION>> r1);

    public final <ACTION extends p> void a(ACTION r11) {
        Iterator<T> r0 = d().iterator();
    L4:
        if (r0.hasNext() == false) goto L20;
        BaseMVIViewModel r1 = (BaseMVIViewModel) r0.next();
        if ((r1 instanceof b0) == true) goto L4;
        Map<com.bytedance.android.anya.internal.a.C0100a, Boolean> r10 = com.bytedance.android.anya.internal.a.a;
        Class<?> r12 = r1.getClass();
        Class<?> r13 = r11.getClass();
        com.bytedance.android.anya.internal.a.C0100a r14 = new com.bytedance.android.anya.internal.a.C0100a(r12, r13);
        LinkedHashMap r15 = (LinkedHashMap) com.bytedance.android.anya.internal.a.a;
        Object r16 = r15.get(r14);
        if (r16 != null) goto L14;
        LinkedHashMap r17 = (LinkedHashMap) com.bytedance.android.anya.internal.a.b;
        Object r18 = r17.get(r12);
        if (r18 != null) goto L12;
        r18 = TypeToken.of(r12).getSupertype(BaseMVIViewModel.class).resolveType(BaseMVIViewModel.class.getTypeParameters()[1]).getRawType();
        r17.put(r12, r18);
    L12:
        r16 = Boolean.valueOf(((Class) r18).isAssignableFrom(r13));
        r15.put(r14, r16);
    L14:
        if (((Boolean) r16).booleanValue() == false) goto L4;
        mb.c r19 = mb.a.a;
        String r20 = "broadcastAction " + r11;
        mb.c r21 = mb.a.a;
        if (r21 == null) goto L19;
        r21.logW("ttlive_anya", r20);
    L19:
        r1.b0(r11);
        goto L4
    }

    public final MVIBindingImpl c(BaseMVIView r10, Class r11) {
        BaseMVIViewModel r12 = f(r11);
        if (r12 == null) goto L5;
        MVIBindingImpl r0 = new MVIBindingImpl(r10, r12);
    L6:
        if (r0 == null) goto L14;
        Collection r13 = lb.c.b.a;
        ArrayList r1 = new ArrayList();
        Iterator r14 = r13.iterator();
    L9:
        if (r14.hasNext() == false) goto L13;
        GiftMVITraceListener r15 = ((lb.d) r14.next()).a(this, r0);
        if (r15 == null) goto L9;
        r1.add(r15);
        goto L9
    L13:
        r0.d = new lb.a(r12, r1);
    L14:
        return r0;
    L5:
        r0 = null;
        goto L6
    }
}
