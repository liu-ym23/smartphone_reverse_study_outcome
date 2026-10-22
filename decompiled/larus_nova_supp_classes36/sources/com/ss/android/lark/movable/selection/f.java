package com.ss.android.lark.movable.selection;

import android.os.Build;
import android.view.View;
import android.widget.Magnifier;
import com.ss.android.lark.movable.MovableView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f {
    public final View a;
    public final c b;

    public static final class a implements c {
        public a() {
        }

        @Override // com.ss.android.lark.movable.selection.f.c
        public final void a(float r1, float r2) {
        }

        @Override // com.ss.android.lark.movable.selection.f.c
        public final void dismiss() {
        }
    }

    public static final class b implements c {
        public final Magnifier a;

        @Override // com.ss.android.lark.movable.selection.f.c
        public final void dismiss() {
            this.a.dismiss();
        }

        public b(MovableView r2) {
            Intrinsics.checkNotNullParameter(r2, "container");
            this.a = new Magnifier.Builder(r2).setCornerRadius(100.0f).build();
        }

        @Override // com.ss.android.lark.movable.selection.f.c
        public final void a(float r2, float r3) {
            this.a.show(r2, r3);
        }
    }

    public interface c {
        void a(float r1, float r2);

        void dismiss();
    }

    public f(MovableView r3) {
        Intrinsics.checkNotNullParameter(r3, "container");
        this.a = r3;
        if (Build.VERSION.SDK_INT < 29) goto L5;
        c r0 = new b(r3);
    L6:
        this.b = r0;
        return;
    L5:
        r0 = new a();
        goto L6
    }
}
