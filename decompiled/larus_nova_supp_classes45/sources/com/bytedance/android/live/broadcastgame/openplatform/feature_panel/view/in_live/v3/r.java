package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r implements TextWatcher {
    public final /* synthetic */ LiveOpenFeatureSearchFragmentV3 a;

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "s");
    }

    public r(LiveOpenFeatureSearchFragmentV3 r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r2) {
        Intrinsics.checkNotNullParameter(r2, "s");
        if (r2.length() != 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L10;
        ImageView r4 = this.a.k;
        if (r4 == null) goto L14;
        r4.setVisibility(4);
        return;
    L14:
        return;
    L10:
        ImageView r5 = this.a.k;
        if (r5 == null) goto L16;
        r5.setVisibility(0);
        return;
    L16:
        return;
    L5:
        r3 = false;
        goto L6
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "s");
        LiveOpenFeatureSearchFragmentV3 r5 = this.a;
        int r6 = LiveOpenFeatureSearchFragmentV3.s;
        r5.U90(true);
        RecyclerView r7 = this.a.f;
        if (r7 == null) goto L7;
        RecyclerView.Adapter r8 = r7.getAdapter();
        if (r8 == null) goto L7;
        int r9 = r8.getItemCount();
    L8:
        if (r9 < 1) goto L12;
        TextView r11 = this.a.d;
        if (r11 == null) goto L15;
        UtilityKotlinExtentionsKt.w(r11);
    L15:
        LiveOpenFeatureSearchFragmentV3 r12 = this.a;
        LinearLayout r13 = r12.h;
        if (r13 == null) goto L18;
        r13.setVisibility(8);
    L18:
        RecyclerView r14 = r12.g;
        if (r14 == null) goto L21;
        r14.setVisibility(8);
    L21:
        LiveDoubleColorBallAnimationView r15 = r12.e;
        if (r15 == null) goto L25;
        UtilityKotlinExtentionsKt.t(r15);
        return;
    L25:
        return;
    L12:
        TextView r16 = this.a.d;
        if (r16 == null) goto L15;
        UtilityKotlinExtentionsKt.t(r16);
    L7:
        r9 = 0;
        goto L8
    }
}
