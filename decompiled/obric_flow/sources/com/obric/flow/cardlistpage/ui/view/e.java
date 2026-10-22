package com.obric.flow.cardlistpage.ui.view;

import android.graphics.Rect;
import android.view.View;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.orecyclerview.widget.h0;
import com.obric.oui.orecyclerview.widget.u0;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f11844a;

    public e(i r5) {
        this.f11844a = r5;
    }

    @Override // com.obric.oui.orecyclerview.widget.h0
    public final void a(Rect r5, View r10, RecyclerView r11, u0 r12) {
        Intrinsics.checkNotNullParameter(r5, "outRect");
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "parent");
        Intrinsics.checkNotNullParameter(r12, "state");
        int r13 = r11.D(r10);
        if (r13 <= 0) goto L11;
        i r14 = this.f11844a;
        com.obric.oui.privacy.d r15 = (com.obric.oui.privacy.d) CollectionsKt.getOrNull(r14.f11853a.d, r13);
        com.obric.oui.privacy.d r16 = (com.obric.oui.privacy.d) CollectionsKt.getOrNull(r14.f11853a.d, r13 - 1);
        if (r15 == null) goto L12;
        if (r16 != null) goto L8;
        return;
    L8:
        if (r15.getClass() == r16.getClass()) goto L14;
        r5.top = androidx.room.jarjarred.org.antlr.runtime.a.a(16, 1);
        return;
    L14:
        return;
    L12:
        return;
    }
}
