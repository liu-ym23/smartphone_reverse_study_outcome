package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.quickability.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import ia2.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/selectedmessage/view/aiagent/quickability/viewholder/QuickAbilityTextViewHolder;", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/selectedmessage/view/aiagent/quickability/viewholder/QuickAbilityBaseViewHolder;", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class QuickAbilityTextViewHolder extends QuickAbilityBaseViewHolder {
    public static final /* synthetic */ int f = 0;
    public final TextView d;
    public final LottieAnimationView e;

    public static final class a {
        public static View a(ViewGroup r3) {
            Intrinsics.checkNotNullParameter(r3, "parent");
            return LayoutInflater.from(r3.getContext()).inflate(2131565130, r3, false);
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.quickability.viewholder.QuickAbilityBaseViewHolder
    public boolean V3(b r1) {
        return false;
    }

    public final void W3() {
        TextView r0 = this.d;
        if (r0 == null) goto L5;
        UtilityKotlinExtentionsKt.w(r0);
    L5:
        LottieAnimationView r1 = this.e;
        if (r1 == null) goto L8;
        UtilityKotlinExtentionsKt.u(r1);
    L8:
        LottieAnimationView r2 = this.e;
        if (r2 == null) goto L12;
        r2.pauseAnimation();
        return;
    }

    public QuickAbilityTextViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        super(r2);
        this.d = (TextView) r2.findViewById(2131388367);
        this.e = r2.findViewById(2131378977);
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.quickability.viewholder.QuickAbilityBaseViewHolder
    public final void U3(b r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r3, "data");
        View r0 = this.c;
        if (r3.d == false) goto L5;
        int r1 = 28;
    L6:
        a1.k(r0, UtilityKotlinExtentionsKt.i(r1));
        TextView r2 = this.d;
        if (r2 == null) goto L10;
        r2.setText(r3.a.getText());
    L10:
        if (r3.b == false) goto L20;
        TextView r4 = this.d;
        if (r4 == null) goto L14;
        UtilityKotlinExtentionsKt.u(r4);
    L14:
        LottieAnimationView r5 = this.e;
        if (r5 == null) goto L17;
        UtilityKotlinExtentionsKt.w(r5);
    L17:
        LottieAnimationView r6 = this.e;
        if (r6 == null) goto L22;
        r6.playAnimation();
        return;
    L22:
        return;
    L20:
        W3();
        return;
    L5:
        r1 = 24;
        goto L6
    }
}
