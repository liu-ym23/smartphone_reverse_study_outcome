package com.ss.android.lark.keyboard.edittext2.compat;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements com.ss.android.lark.keyboard.edittext2.base.a {
    public static final C0135a c = null;
    public com.ss.android.lark.keyboard.edittext2.base.b a;
    public String b;

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.edittext2.compat.a$a, reason: collision with other inner class name */
    public static final class C0135a implements com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC0134a<a> {
        public final /* synthetic */ com.ss.android.lark.keyboard.edittext2.base.d a;

        @Override // com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC0134a
        public final Class<a> a() {
            return this.a.a;
        }

        public C0135a() {
            this.a = new com.ss.android.lark.keyboard.edittext2.base.d(a.class);
        }
    }

    static {
        c = new C0135a();
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public final void d() {
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public final com.ss.android.lark.keyboard.edittext2.base.b getTarget() {
        com.ss.android.lark.keyboard.edittext2.base.b r0 = this.a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("target");
        return null;
    }

    public a() {
        this.b = "";
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public final void A(com.ss.android.lark.keyboard.edittext2.base.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public final void G(com.ss.android.lark.keyboard.edittext2.base.a r2) {
        Intrinsics.checkNotNullParameter(r2, "origin");
    }
}
