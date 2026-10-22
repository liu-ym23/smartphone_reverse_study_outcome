package com.obric.oui.privacy.adapter;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.x0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends x0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f14177i = 0;
    public final OCardListItem g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinearLayout f14178h;

    public a(OCardListItem r10) {
        Intrinsics.checkNotNullParameter(r10, "cardListItem");
        super(r10);
        this.g = r10;
        r10.setCardType(2);
        r10.C = 0;
        com.obric.oui.lisitem.c r5 = r10.f13541a;
        r5.a(0, r5.f13603c, false);
        LinearLayout r11 = new LinearLayout(r10.getContext());
        r11.setOrientation(1);
        r11.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f14178h = r11;
        r10.setCustomStartView(r11);
        r10.f13546j.setVisibility(0);
        r10.f();
    }
}
