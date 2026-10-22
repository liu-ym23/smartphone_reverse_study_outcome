package com.larus.bmhome.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.databinding.LarusPageChatBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class l implements va8.l {
    public final LarusPageChatBinding a;

    public final GridLayout a() {
        return this.a.e;
    }

    public final View b() {
        return this.a.q;
    }

    public final View c() {
        return this.a.k;
    }

    public final ViewGroup d() {
        return this.a.g;
    }

    public final FrameLayout e() {
        return this.a.o;
    }

    public final FrameLayout getInput() {
        return this.a.i;
    }

    public final RecyclerView getMessageList() {
        return this.a.n;
    }

    public final ConstraintLayout getRootView() {
        return this.a.a;
    }

    public final FrameLayout getTitleContainer() {
        return this.a.r;
    }

    public final FrameLayout z8() {
        return this.a.d;
    }

    public l(LarusPageChatBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        this.a = r2;
    }
}
