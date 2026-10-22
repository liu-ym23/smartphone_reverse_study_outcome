package com.obric.flow.cardlistpage.ui.view;

import android.view.View;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.orecyclerview.widget.n0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f11845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f11846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f11847c;
    public final /* synthetic */ Ref.BooleanRef d;

    public f(View r5, View r10, Ref.BooleanRef r11, Ref.BooleanRef r12) {
        this.f11845a = r5;
        this.f11846b = r10;
        this.f11847c = r11;
        this.d = r12;
    }

    @Override // com.obric.oui.orecyclerview.widget.n0
    public final void b(RecyclerView r10) {
        Intrinsics.checkNotNullParameter(r10, "rv");
        boolean r5 = r10.canScrollVertically(-1);
        Ref.BooleanRef r11 = this.f11847c;
        Ref.BooleanRef r12 = this.d;
        i.a(r11, r12, this.f11845a, r5, true);
        boolean r13 = r10.canScrollVertically(1);
        i.a(r11, r12, this.f11846b, r13, false);
    }
}
