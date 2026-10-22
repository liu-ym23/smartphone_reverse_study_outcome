package com.obric.assistant.card.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.widget.roundlayout.RoundRelativeLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class ObricBlockLocalSearchItemWithRowImageBinding implements ViewBinding {
    public final RoundRelativeLayout a;
    public final SimpleDraweeView b;
    public final TextView c;
    public final View d;

    public final View getRoot() {
        return this.a;
    }

    public ObricBlockLocalSearchItemWithRowImageBinding(RoundRelativeLayout r1, SimpleDraweeView r2, TextView r3, View r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
