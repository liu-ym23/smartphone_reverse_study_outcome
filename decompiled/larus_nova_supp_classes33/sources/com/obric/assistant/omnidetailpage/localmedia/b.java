package com.obric.assistant.omnidetailpage.localmedia;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.bmhome.bigimg.download.CommonDownLoadLayout;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b extends com.larus.gallery.api.t<ifa.c> {
    public CommonDownLoadLayout f;
    public boolean g;

    public final boolean m() {
        return false;
    }

    public final void y() {
        CommonDownLoadLayout r0 = this.f;
        if (r0 == null) goto L6;
        r0.setLayoutEnable(!this.g);
    L6:
        if (this.g == false) goto L10;
        CommonDownLoadLayout r1 = this.f;
        if (r1 == null) goto L14;
        r1.T5();
        return;
    L14:
        return;
    L10:
        CommonDownLoadLayout r2 = this.f;
        if (r2 == null) goto L16;
        r2.R5();
        return;
    }

    public b() {
    }

    public final View p(ViewGroup r6) {
        if (r6 == null) goto L5;
        Context r7 = r6.getContext();
        if (r7 == null) goto L5;
    L7:
        if (r7 == null) goto L11;
        FrameLayout r0 = new FrameLayout(r7);
        r0.setPadding(i5.h(), i5.g(), i5.h(), i5.h());
        CommonDownLoadLayout r8 = new CommonDownLoadLayout(r0.getContext(), null, 6, 0);
        r8.setBackgroundResource(2131238694);
        r8.setOnClickListener(new a(this));
        this.f = r8;
        r0.addView(r8, new FrameLayout.LayoutParams(-1, i5.h0(), 17));
        return r0;
    L11:
        throw new IllegalStateException("context is null");
    L5:
        r7 = getContext();
        goto L7
    }

    public final void w(Object r1, int r2) {
        ifa.c r3 = (ifa.c) r1;
        Intrinsics.checkNotNullParameter(r3, "data");
        ((com.larus.gallery.api.t) this).d = r3;
        y();
        com.larus.gallery.api.w r4 = ((com.larus.gallery.api.t) this).e;
        if (r4 == null) goto L8;
        com.larus.gallery.api.s r5 = r4.AQ(Reflection.getOrCreateKotlinClass(com.larus.gallery.api.s.class));
        if (r5 == null) goto L9;
        r5.c();
        return;
    L9:
        return;
    }
}
