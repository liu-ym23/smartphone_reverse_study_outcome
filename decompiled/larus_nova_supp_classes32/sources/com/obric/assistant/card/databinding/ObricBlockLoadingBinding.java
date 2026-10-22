package com.obric.assistant.card.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.layout.widget.ShimmerTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class ObricBlockLoadingBinding implements ViewBinding {
    public final LinearLayout a;
    public final SimpleDraweeView b;
    public final ShimmerTextView c;

    public final View getRoot() {
        return this.a;
    }

    public ObricBlockLoadingBinding(LinearLayout r1, SimpleDraweeView r2, ShimmerTextView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
