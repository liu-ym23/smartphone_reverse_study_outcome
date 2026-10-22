package com.ss.android.lark.keyboard.editor.input.interceptor;

import com.ss.android.lark.keyboard.keyboard2.KeyboardMenuItemKey;
import com.ss.android.lark.keyboard.keyboard2.c;
import com.ss.android.lark.keyboard.keyboard2.e;
import com.ss.android.lark.keyboard.keyboard2.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements c {
    public static final C0133a c = null;
    public final i7b.a a;
    public com.ss.android.lark.keyboard.b b;

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.editor.input.interceptor.a$a, reason: collision with other inner class name */
    public static final class C0133a implements c.a<a> {
        public C0133a() {
        }
    }

    public static final class b implements e {
        public final /* synthetic */ a a;

        @Override // com.ss.android.lark.keyboard.keyboard2.e
        public final boolean u(m r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            return true;
        }

        public b(a r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.keyboard.keyboard2.e
        public final boolean n(m r4) {
            Intrinsics.checkNotNullParameter(r4, "item");
            if (r4.g() == KeyboardMenuItemKey.At) goto L5;
            return true;
        L5:
            int r5 = com.ss.android.lark.chat.chatwindow.biz.component.keyboard.c.a;
            i7b.a r6 = this.a.a;
            return !com.ss.android.lark.chat.chatwindow.biz.component.keyboard.c.b(r6.f, r6.g, r6.i);
        }
    }

    static {
        c = new C0133a();
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void j() {
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void d() {
        com.ss.android.lark.keyboard.b r0 = this.b;
        com.ss.android.lark.keyboard.b r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("keyboard");
        r0 = null;
    L6:
        r0.H().M(new b(this));
        com.ss.android.lark.keyboard.b r2 = this.b;
        if (r2 == null) goto L9;
        r1 = r2;
    L10:
        r1.H().m();
        return;
    L9:
        Intrinsics.throwUninitializedPropertyAccessException("keyboard");
        goto L10
    }

    public a(i7b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "initData");
        this.a = r2;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void setKeyboard(com.ss.android.lark.keyboard.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }
}
