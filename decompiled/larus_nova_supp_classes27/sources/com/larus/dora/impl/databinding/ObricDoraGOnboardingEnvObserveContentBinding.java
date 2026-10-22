package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.ScrollView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.dora.impl.view.DoraTextViewWithAnim;
import com.obric.oui.button.OButton;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class ObricDoraGOnboardingEnvObserveContentBinding implements ViewBinding {
    public final ScrollView a;
    public final SimpleDraweeView b;

    public final View getRoot() {
        return this.a;
    }

    public ObricDoraGOnboardingEnvObserveContentBinding(ScrollView r1, OButton r2, SimpleDraweeView r3, DoraTextViewWithAnim r4) {
        this.a = r1;
        this.b = r3;
    }
}
