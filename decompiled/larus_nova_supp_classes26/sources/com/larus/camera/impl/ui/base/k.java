package com.larus.camera.impl.ui.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.ViewGroupKt;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.camera.impl.widget.title.TitleRightIconGroupView;
import com.larus.camera.impl.widget.title.TitleRightIconView;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class k extends com.larus.camera.impl.ui.arch.b {
    public k() {
        com.larus.camera.impl.ui.arch.c r0 = com.larus.camera.impl.ui.arch.c.a;
        super(48, com.larus.camera.impl.ui.arch.c.c);
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public CameraContainer.b f(int r5) {
        CameraContainer.b r6 = super.f(r5);
        ((FrameLayout.LayoutParams) r6).width = -1;
        ((FrameLayout.LayoutParams) r6).height = getContext().getResources().getDimensionPixelSize(v19.c.b(2130971490, getContext(), 2131166621));
        return r6;
    }

    public final void p(Function1<? super ImageView, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        r2.invoke(h(2131377773));
    }

    public final void q(Function1<? super TitleRightIconGroupView, ? extends List<ay8.e>> r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        TitleRightIconGroupView r0 = (TitleRightIconGroupView) h(2131384590);
        r0.setIconList((List) r2.invoke(r0));
    }

    public final void r(Function1<? super TitleRightIconView, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        Iterator r0 = ViewGroupKt.getChildren((TitleRightIconGroupView) h(2131384590)).iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        View r1 = (View) r0.next();
        if ((r1 instanceof TitleRightIconView) == false) goto L8;
        TitleRightIconView r2 = (TitleRightIconView) r1;
    L9:
        if (r2 == null) goto L4;
        r4.invoke(r2);
        goto L4
    L8:
        r2 = null;
        goto L9
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final View g(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return r3.inflate(2131562929, r4, false);
    }
}
