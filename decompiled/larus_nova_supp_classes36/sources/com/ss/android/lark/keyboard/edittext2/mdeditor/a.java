package com.ss.android.lark.keyboard.edittext2.mdeditor;

import com.ss.android.lark.coremd.facade.gennode.SpanToNodeMappers;
import com.ss.android.lark.keyboard.edittext2.base.b;
import com.ss.android.lark.keyboard.edittext2.base.c;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import u9b.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements com.ss.android.lark.keyboard.edittext2.base.a, c {
    public static final C0145a c = null;
    public List<? extends d<? extends Object>> a;
    public b b;

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.edittext2.mdeditor.a$a, reason: collision with other inner class name */
    public static final class C0145a implements com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC0134a<a> {
        public final /* synthetic */ com.ss.android.lark.keyboard.edittext2.base.d a;

        @Override // com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC0134a
        public final Class<a> a() {
            return this.a.a;
        }

        public C0145a() {
            this.a = new com.ss.android.lark.keyboard.edittext2.base.d(a.class);
        }
    }

    static {
        c = new C0145a();
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public final void d() {
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public final b getTarget() {
        b r0 = this.b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("target");
        return null;
    }

    public a() {
        SpanToNodeMappers r0 = SpanToNodeMappers.a;
        this.a = com.ss.android.lark.coremdbiz.facade.a.c();
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public final void A(b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public final void G(com.ss.android.lark.keyboard.edittext2.base.a r2) {
        Intrinsics.checkNotNullParameter(r2, "origin");
        this.a = ((a) r2).a;
    }
}
