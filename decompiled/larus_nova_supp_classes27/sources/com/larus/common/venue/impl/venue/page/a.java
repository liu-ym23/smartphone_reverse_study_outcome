package com.larus.common.venue.impl.venue.page;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.common.venue.impl.databinding.LarusFragmentCommonVenueBinding;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import va8.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a implements l {
    public final LarusFragmentCommonVenueBinding a;

    public final GridLayout a() {
        return this.a.c;
    }

    public final View b() {
        return this.a.h;
    }

    public final View c() {
        return this.a.f;
    }

    public final ViewGroup d() {
        return this.a.d;
    }

    public final FrameLayout e() {
        return new FrameLayout(this.a.g.getContext());
    }

    public final FrameLayout getInput() {
        return this.a.e;
    }

    public final RecyclerView getMessageList() {
        return new RecyclerView(this.a.g.getContext());
    }

    public final ConstraintLayout getRootView() {
        return this.a.d;
    }

    public final FrameLayout getTitleContainer() {
        throw new NotImplementedError("titleContainer is not supported");
    }

    public final FrameLayout z8() {
        return this.a.b;
    }

    public a(LarusFragmentCommonVenueBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        this.a = r2;
    }
}
