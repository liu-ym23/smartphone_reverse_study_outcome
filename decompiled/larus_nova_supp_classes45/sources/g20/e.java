package g20;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.base.OpenFeatureIconCallbackFrom;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.AbsOpenFeatureTabListItemViewHolder;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.delegate.v3.OpenFeatureTabListItemViewHolderV3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e extends f20.g<f10.f, OpenFeatureTabListItemViewHolderV3> {
    public final a20.e a;
    public final OpenFeatureIconCallbackFrom b;
    public final Function1<f10.f, Unit> c;

    @Override // f20.c
    public final boolean accept(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return true;
    }

    @Override // f20.a
    public final RecyclerView.ViewHolder a(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new OpenFeatureTabListItemViewHolderV3(r3.inflate(2131567069, r4, false), this.a, this.b);
    }

    @Override // f20.g
    public final void b(AbsOpenFeatureTabListItemViewHolder r2, f10.f r3) {
        OpenFeatureTabListItemViewHolderV3 r4 = (OpenFeatureTabListItemViewHolderV3) r2;
        f10.f r5 = r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r5, "data");
        super.b(r4, r5);
        Function1<f10.f, Unit> r6 = this.c;
        if (r6 == null) goto L6;
        Unit r7 = (Unit) r6.invoke(r5);
        return;
    }

    @Override // f20.g, f20.a
    public final void d(RecyclerView.ViewHolder r2, Object r3) {
        OpenFeatureTabListItemViewHolderV3 r4 = (OpenFeatureTabListItemViewHolderV3) r2;
        f10.f r5 = (f10.f) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r5, "data");
        super.b(r4, r5);
        Function1<f10.f, Unit> r6 = this.c;
        if (r6 == null) goto L6;
        Unit r7 = (Unit) r6.invoke(r5);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(a20.e r2, OpenFeatureIconCallbackFrom r3, Function1<? super f10.f, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "callbackFrom");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
