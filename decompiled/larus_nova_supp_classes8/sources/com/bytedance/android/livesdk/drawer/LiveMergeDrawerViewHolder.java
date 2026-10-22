package com.bytedance.android.livesdk.drawer;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.viewmodel.MergeDrawerViewModel;
import com.bytedance.android.livesdk.viewmodel.g;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.lighten.loader.SmartImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/drawer/LiveMergeDrawerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveMergeDrawerViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int h = 0;
    public final SmartImageView a;
    public final FrameLayout b;
    public final LottieAnimationView c;
    public final TextView d;
    public final TextView e;
    public Room f;
    public MergeDrawerViewModel g;

    public static final class a {
    }

    static {
    }

    public final void T3() {
        UtilityKotlinExtentionsKt.w(this.c);
        UtilityKotlinExtentionsKt.w(this.b);
        this.c.playAnimation();
        Room r0 = this.f;
        if (r0 == null) goto L10;
        long r1 = r0.getRoomId();
        MergeDrawerViewModel r2 = this.g;
        if (r2 == null) goto L11;
        MutableLiveData r3 = r2.getGotoPosition();
        if (r3 == null) goto L12;
        r3.setValue(new g(getAdapterPosition(), r1));
        return;
    L12:
        return;
    L11:
        return;
    }

    public LiveMergeDrawerViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.a = r2.findViewById(2131379943);
        this.b = (FrameLayout) r2.findViewById(2131379944);
        this.c = r2.findViewById(2131379945);
        this.d = (TextView) r2.findViewById(2131379942);
        this.e = (TextView) r2.findViewById(2131379946);
    }
}
