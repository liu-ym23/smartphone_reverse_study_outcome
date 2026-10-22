package com.ss.android.lark.keyboard.editor.input.interceptor;

import android.view.View;
import com.ss.android.lark.keyboard.keyboard2.c;
import com.ss.android.lark.keyboard.keyboard2.d;
import com.ss.android.lark.keyboard.keyboard2.f;
import com.ss.android.lark.keyboard.widget.KBMenuContainerView;
import cya.h;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ChatEditorMenuLayoutManager implements c {
    public static final a e = null;
    public final f.a a;
    public final com.ss.android.lark.keyboard.widget.a b;
    public com.ss.android.lark.keyboard.b c;
    public final b d;

    public static final class a implements c.a<ChatEditorMenuLayoutManager> {
        public a() {
        }
    }

    public static final class b implements f {
        public final /* synthetic */ ChatEditorMenuLayoutManager b;

        public b(ChatEditorMenuLayoutManager r1) {
            this.b = r1;
        }

        @Override // com.ss.android.lark.keyboard.keyboard2.f
        public final void a(KBMenuContainerView r4, List<? extends View> r5) {
            Intrinsics.checkNotNullParameter(r4, "container");
            Intrinsics.checkNotNullParameter(r5, "visibleChildViews");
            com.ss.android.lark.keyboard.b r0 = this.b.c;
            cya.c r1 = null;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("keyboard");
            r0 = null;
        L6:
            com.ss.android.lark.keyboard.keyboard2.b r2 = r0.L();
            if ((r2 instanceof cya.c) == false) goto L9;
            r1 = (cya.c) r2;
        L9:
            if (r1 != null) goto L11;
            this.b.a.a(r4, r5);
            return;
        L11:
            int r3 = r1.a().d().a();
            if (r3 != 4) goto L14;
        L18:
            this.b.a.a(r4, r5);
            return;
        L14:
            if (r3 == 8) goto L18;
            if (r3 == 16) goto L18;
            this.b.b.a(r4, r5);
        }
    }

    static {
        e = new a();
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void j() {
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void d() {
        com.ss.android.lark.keyboard.b r0 = this.c;
        com.ss.android.lark.keyboard.b r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("keyboard");
        r0 = null;
    L6:
        final d r2 = r0.H();
        com.ss.android.lark.keyboard.b r3 = this.c;
        if (r3 == null) goto L9;
        r1 = r3;
    L10:
        r1.e().of(this).d(h.class, new ChatEditorMenuLayoutManager$onAttached$1(r2));
        r2.C(this.d);
        r2.m();
        return;
    L9:
        Intrinsics.throwUninitializedPropertyAccessException("keyboard");
        goto L10
    }

    public ChatEditorMenuLayoutManager() {
        this.a = f.a;
        this.b = new com.ss.android.lark.keyboard.widget.a();
        this.d = new b(this);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void setKeyboard(com.ss.android.lark.keyboard.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }
}
