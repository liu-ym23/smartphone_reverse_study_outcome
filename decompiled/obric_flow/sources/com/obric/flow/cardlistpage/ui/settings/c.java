package com.obric.flow.cardlistpage.ui.settings;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.obric.flow.cardlistpage.R$id;
import com.obric.oui.orecyclerview.widget.x0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends x0 {
    public final ViewGroup g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ImageView f11822h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f11823i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f11824j;

    public c(ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r5, "root");
        super(r5);
        this.g = r5;
        this.f11822h = (ImageView) r5.findViewById(R$id.icon);
        this.f11823i = (TextView) r5.findViewById(R$id.tv_title);
        this.f11824j = (TextView) r5.findViewById(R$id.tv_subtitle);
    }
}
