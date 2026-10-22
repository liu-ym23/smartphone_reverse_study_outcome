package ee8;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.mainbot.impl.databinding.LarusPageCotDetailBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a implements va8.l {
    public final LarusPageCotDetailBinding a;

    @Override // va8.l
    public final FrameLayout getTitleContainer() {
        return null;
    }

    @Override // va8.l
    public final GridLayout a() {
        return this.a.c;
    }

    @Override // va8.l
    public final View b() {
        return this.a.p;
    }

    @Override // va8.l
    public final View c() {
        return this.a.i;
    }

    @Override // va8.l
    public final ViewGroup d() {
        return this.a.d;
    }

    @Override // va8.l
    public final FrameLayout e() {
        return (FrameLayout) this.a.e.findViewById(2131384402);
    }

    @Override // va8.l
    public final FrameLayout getInput() {
        return this.a.g;
    }

    @Override // va8.l
    public final RecyclerView getMessageList() {
        return this.a.e.findViewById(2131384401);
    }

    @Override // va8.l
    public final ConstraintLayout getRootView() {
        return this.a.d;
    }

    @Override // va8.l
    public final FrameLayout z8() {
        return this.a.b;
    }

    public a(LarusPageCotDetailBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        this.a = r2;
    }
}
