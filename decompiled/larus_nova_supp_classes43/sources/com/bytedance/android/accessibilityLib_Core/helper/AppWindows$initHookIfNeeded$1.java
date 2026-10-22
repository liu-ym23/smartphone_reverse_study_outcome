package com.bytedance.android.accessibilityLib_Core.helper;

import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
final /* synthetic */ class AppWindows$initHookIfNeeded$1 extends MutablePropertyReference0 {
    public AppWindows$initHookIfNeeded$1(AppWindows r1) {
        super(r1);
    }

    public String getName() {
        return "windowSession";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(AppWindows.class);
    }

    public String getSignature() {
        return "getWindowSession()Ljava/lang/Object;";
    }

    public Object get() {
        Object r0 = ((AppWindows) ((CallableReference) this).receiver).b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("windowSession");
    L5:
        return r0;
    }

    public void set(Object r10) {
        ((AppWindows) ((CallableReference) this).receiver).b = r10;
    }
}
