package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class ObricDoraDeviceBindPageBinding implements ViewBinding {
    public final RelativeLayout a;
    public final OButton b;
    public final OButton c;
    public final OFloatingTitleBar d;
    public final SimpleDraweeView e;
    public final TextView f;
    public final TextView g;

    public final View getRoot() {
        return this.a;
    }

    public ObricDoraDeviceBindPageBinding(RelativeLayout r1, OButton r2, OButton r3, OFloatingTitleBar r4, SimpleDraweeView r5, TextView r6, TextView r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
