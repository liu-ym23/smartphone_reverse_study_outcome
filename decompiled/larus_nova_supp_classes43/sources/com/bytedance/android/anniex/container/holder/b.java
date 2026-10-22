package com.bytedance.android.anniex.container.holder;

import androidx.fragment.app.Fragment;
import com.bytedance.android.anniex.container.ui.AnnieXFragment;
import com.bytedance.android.anniex.lite.container.AnnieXFlowPageContainer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b extends d implements ja.b {
    public final com.bytedance.android.anniex.base.builder.b a;
    public final ia.b b;
    public ka.b c;
    public AnnieXFragment d;

    @Override // ja.b
    public final boolean canBackPress() {
        return this.b.canBackPress();
    }

    @Override // ja.b
    public final void finish() {
        this.b.finish();
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [ia.b, ia.d, java.lang.Object] */
    @Override // ja.b
    public final Fragment getFragment() {
        if (this.d != null) goto L12;
        AnnieXFragment r0 = new AnnieXFragment(this.a);
        this.d = r0;
        ?? r1 = this.b;
        Intrinsics.checkNotNullParameter(r1, "container");
        r0.f = r1;
        if (r1 == 0) goto L7;
        r1.j((na.b) r0.j.getValue());
    L7:
        ka.b r10 = this.c;
        if (r10 == null) goto L12;
        AnnieXFragment r11 = this.d;
        if (r11 == null) goto L12;
        Intrinsics.checkNotNullParameter(r10, "listener");
        r11.g = r10;
    L12:
        AnnieXFragment r12 = this.d;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.bytedance.android.anniex.container.ui.AnnieXFragment");
        return r12;
    }

    @Override // ja.b
    public final void release() {
        this.b.release();
        this.c = null;
    }

    @Override // com.bytedance.android.anniex.container.holder.d
    public final ia.b a() {
        return this.b;
    }

    public b(com.bytedance.android.anniex.base.builder.b r10) {
        Intrinsics.checkNotNullParameter(r10, "builder");
        this.a = r10;
        if (r10.c.getBoolean("bundle_annie_x_flow", false) == false) goto L5;
        ia.b r0 = new AnnieXFlowPageContainer(r10);
    L6:
        this.b = r0;
        this.c = r10.k;
        return;
    L5:
        r0 = new com.bytedance.android.anniex.container.c(r10);
        goto L6
    }
}
