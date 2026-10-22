package com.bytedance.android.anniex.container.holder;

import androidx.fragment.app.Fragment;
import com.bytedance.android.anniex.container.ui.AnnieXSLFragment;
import com.bytedance.android.anniex.salamander.SLPage;
import com.bytedance.salamander.anniex.AnnieXBaseViewModel;
import com.bytedance.salamander.anniex.g3;
import com.bytedance.salamander.anniex.l;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AnnieXSLFragmentHolder implements ja.b {
    public final com.bytedance.android.anniex.base.builder.b a;
    public AnnieXSLFragment b;
    public final Lazy c;

    public static final class a {
    }

    static {
    }

    @Override // ja.b
    public final boolean canBackPress() {
        return false;
    }

    @Override // ja.b
    public final void finish() {
    }

    @Override // ja.b
    public final void release() {
    }

    @Override // ja.b
    public final Fragment getFragment() {
        if (this.b != null) goto L10;
        AnnieXSLFragment r0 = new AnnieXSLFragment();
        r0.S90(this.a);
        ka.b r1 = this.a.k;
        if (r1 == null) goto L7;
        Intrinsics.checkNotNullParameter(r1, "listener");
        r0.h = r1;
    L7:
        r0.setArguments(this.a.c);
        this.b = r0;
        SLPage r10 = (SLPage) this.c.getValue();
        if (r10 == null) goto L10;
        r0.l = r10;
        r0.g = r10.n();
    L10:
        AnnieXSLFragment r11 = this.b;
        Intrinsics.checkNotNull(r11);
        return r11;
    }

    public AnnieXSLFragmentHolder(com.bytedance.android.anniex.base.builder.b r10) {
        Intrinsics.checkNotNullParameter(r10, "builder");
        this.a = r10;
        this.c = LazyKt.lazy(new AnnieXSLFragmentHolder$slPage$2(this));
    }

    @Override // ja.c
    public final void loadSchema(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        AnnieXSLFragment r11 = this.b;
        if (r11 == null) goto L13;
        AnnieXBaseViewModel r12 = r11.g;
        g3 r0 = null;
        if (r12 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("slPageViewModel");
        r12 = null;
    L7:
        r12.getClass();
        l r1 = new l(r12);
        g3 r13 = r12.a().a;
        if (r13 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("_engine");
    L11:
        r0.b(r1);
        return;
    L10:
        r0 = r13;
        goto L11
    }
}
