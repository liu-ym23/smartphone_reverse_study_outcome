package com.larksuite.common_selection;

import android.os.Build;
import android.widget.Magnifier;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public final c a;

    public static final class a implements c {
        public a() {
        }

        @Override // com.larksuite.common_selection.b.c
        public final void a(float r1, float r2) {
        }

        @Override // com.larksuite.common_selection.b.c
        public final void dismiss() {
        }
    }

    /* JADX INFO: renamed from: com.larksuite.common_selection.b$b, reason: collision with other inner class name */
    public static final class C0008b implements c {
        public final Magnifier a;

        @Override // com.larksuite.common_selection.b.c
        public final void dismiss() {
            this.a.dismiss();
        }

        public C0008b(SelectionContainer r2) {
            Intrinsics.checkNotNullParameter(r2, "container");
            this.a = new Magnifier.Builder(r2).setCornerRadius(100.0f).build();
        }

        @Override // com.larksuite.common_selection.b.c
        public final void a(float r2, float r3) {
            this.a.show(r2, r3);
        }
    }

    public interface c {
        void a(float r1, float r2);

        void dismiss();
    }

    public b(SelectionContainer r3) {
        Intrinsics.checkNotNullParameter(r3, "container");
        if (Build.VERSION.SDK_INT < 29) goto L5;
        c r0 = new C0008b(r3);
    L6:
        this.a = r0;
        return;
    L5:
        r0 = new a();
        goto L6
    }
}
