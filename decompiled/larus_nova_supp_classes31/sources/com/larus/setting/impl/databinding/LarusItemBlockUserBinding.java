package com.larus.setting.impl.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.RoundAvatarImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusItemBlockUserBinding implements ViewBinding {
    public final LinearLayout a;
    public final RoundAvatarImageView b;
    public final Button c;
    public final TextView d;

    public final View getRoot() {
        return this.a;
    }

    public LarusItemBlockUserBinding(LinearLayout r1, RoundAvatarImageView r2, Button r3, TextView r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
