package com.obric.flow.cardlistpage.ui.settings;

import android.view.ViewGroup;
import android.widget.TextView;
import com.obric.flow.cardlistpage.R$id;
import com.obric.oui.orecyclerview.widget.x0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends x0 {
    public final ViewGroup g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f11820h;

    public a(ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r5, "root");
        super(r5);
        this.g = r5;
        this.f11820h = (TextView) r5.findViewById(R$id.tv_title);
    }
}
