package com.obric.oui.privacy;

import android.graphics.Rect;
import android.view.View;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.orecyclerview.widget.h0;
import com.obric.oui.orecyclerview.widget.u0;
import com.obric.oui.privacy.recyclerview.PrivacyTopDownAlphaMaskRecyclerView;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f14175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PrivacyTopDownAlphaMaskRecyclerView f14176b;

    public a(b r5, PrivacyTopDownAlphaMaskRecyclerView r10) {
        this.f14175a = r5;
        this.f14176b = r10;
    }

    @Override // com.obric.oui.orecyclerview.widget.h0
    public final void a(Rect r5, View r10, RecyclerView r11, u0 r12) {
        Intrinsics.checkNotNullParameter(r5, "outRect");
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "parent");
        Intrinsics.checkNotNullParameter(r12, "state");
        int r13 = r11.D(r10);
        if (r13 <= 0) goto L11;
        b r14 = this.f14175a;
        d r15 = (d) CollectionsKt.getOrNull(r14.f14182b.d, r13);
        d r16 = (d) CollectionsKt.getOrNull(r14.f14182b.d, r13 - 1);
        if (r15 == null) goto L12;
        if (r16 != null) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(r15.getClass()), Reflection.getOrCreateKotlinClass(r16.getClass())) == true) goto L14;
        r5.top = com.lynx.tasm.utils.a.p(16, this.f14176b.getContext());
        return;
    L14:
        return;
    L12:
        return;
    }
}
