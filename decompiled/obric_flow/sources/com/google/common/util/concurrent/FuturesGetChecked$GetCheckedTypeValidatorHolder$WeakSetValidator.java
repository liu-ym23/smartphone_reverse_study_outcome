package com.google.common.util.concurrent;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes2.dex */
final enum FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator extends Enum<FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator> {
    public static final FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArraySet f9392a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator[] f9393b = null;

    static {
        FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator r5 = new FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator("INSTANCE", 0);
        INSTANCE = r5;
        f9393b = new FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator[]{r5};
        f9392a = new CopyOnWriteArraySet();
    }

    public static FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator valueOf(String r5) {
        return (FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator) Enum.valueOf(FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator.class, r5);
    }

    public static FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator[] values() {
        return (FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator[]) f9393b.clone();
    }

    public void validateClass(Class<? extends Exception> r5) {
        CopyOnWriteArraySet r10 = f9392a;
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        if (r5.equals(((WeakReference) r11.next()).get()) == false) goto L4;
        return;
    L8:
        s0.a(r5);
        if (r10.size() <= 1000) goto L11;
        r10.clear();
    L11:
        r10.add(new WeakReference(r5));
    }
}
