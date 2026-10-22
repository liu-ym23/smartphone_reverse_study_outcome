package com.obric.assistant.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricGuideForLocalDataSearchBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final OButton b;
    public final OButton c;
    public final OFloatingTitleBar d;
    public final ImageView e;

    public final View getRoot() {
        return this.a;
    }

    public ObricGuideForLocalDataSearchBinding(ConstraintLayout r1, OButton r2, OButton r3, OFloatingTitleBar r4, ImageView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
