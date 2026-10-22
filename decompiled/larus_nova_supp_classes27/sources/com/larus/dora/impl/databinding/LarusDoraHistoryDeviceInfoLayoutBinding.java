package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraHistoryDeviceInfoLayoutBinding implements ViewBinding {
    public final LinearLayout a;
    public final SimpleDraweeView b;
    public final AppCompatTextView c;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraHistoryDeviceInfoLayoutBinding(LinearLayout r1, SimpleDraweeView r2, AppCompatTextView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
