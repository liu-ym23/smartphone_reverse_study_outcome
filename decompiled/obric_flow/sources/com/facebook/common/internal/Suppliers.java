package com.facebook.common.internal;

import com.facebook.infer.annotation.Nullsafe;

/* JADX INFO: loaded from: classes2.dex */
@Nullsafe(Nullsafe.Mode.STRICT)
public abstract class Suppliers {

    /* JADX INFO: renamed from: com.facebook.common.internal.Suppliers$3, reason: invalid class name */
    public static class AnonymousClass3 implements Supplier<Boolean> {
        public AnonymousClass3() {
        }

        @Override // com.facebook.common.internal.Supplier
        public final /* bridge */ /* synthetic */ Object get() {
            return Boolean.FALSE;
        }
    }

    public static Supplier a() {
        return new AnonymousClass1();
    }
}
