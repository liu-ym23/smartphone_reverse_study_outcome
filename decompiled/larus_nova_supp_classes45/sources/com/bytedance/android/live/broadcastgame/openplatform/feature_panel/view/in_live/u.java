package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class u implements TextWatcher {
    public final /* synthetic */ LiveOpenFeatureSearchFragment a;

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "s");
    }

    public u(LiveOpenFeatureSearchFragment r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r3) {
        Intrinsics.checkNotNullParameter(r3, "s");
        if (r3.length() != 0) goto L5;
        boolean r4 = true;
    L7:
        if (r4 == false) goto L9;
        ((ImageView) this.a.S90(2131366949)).setVisibility(4);
        return;
    L9:
        ((ImageView) this.a.S90(2131366949)).setVisibility(0);
        return;
    L5:
        r4 = false;
        goto L7
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "s");
        LiveOpenFeatureSearchFragment r5 = this.a;
        int r6 = LiveOpenFeatureSearchFragment.l;
        r5.W90(true);
        RecyclerView.Adapter r7 = this.a.S90(2131384074).getAdapter();
        if (r7 == null) goto L5;
        int r8 = r7.getItemCount();
    L7:
        if (r8 < 1) goto L9;
        UtilityKotlinExtentionsKt.w(this.a.S90(2131366935));
    L10:
        this.a.U90();
        return;
    L9:
        UtilityKotlinExtentionsKt.t(this.a.S90(2131366935));
        goto L10
    L5:
        r8 = 0;
        goto L7
    }
}
