package br8;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.common_ui.widget.BaseConstraintLayout;
import com.larus.mainbot.impl.databinding.LarusMiniArtifactInputBinding;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b implements va8.l {
    public final LarusMiniArtifactInputBinding a;
    public final BaseConstraintLayout b;

    public final GridLayout a() {
        return this.a.c;
    }

    public final View b() {
        return this.a.g;
    }

    public final View c() {
        return this.a.f;
    }

    public final FrameLayout e() {
        return new FrameLayout(this.a.a.getContext());
    }

    public final FrameLayout getInput() {
        return this.a.e;
    }

    public final RecyclerView getMessageList() {
        return new RecyclerView(this.a.a.getContext());
    }

    public final FrameLayout getTitleContainer() {
        throw new NotImplementedError("titleContainer is not supported");
    }

    public final FrameLayout z8() {
        return this.a.b;
    }

    public final ViewGroup d() {
        return this.b;
    }

    public final ConstraintLayout getRootView() {
        return this.b;
    }

    public b(LarusMiniArtifactInputBinding r2, ChatConstraintLayout r3) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        Intrinsics.checkNotNullParameter(r3, "root");
        this.a = r2;
        this.b = r3;
    }
}
