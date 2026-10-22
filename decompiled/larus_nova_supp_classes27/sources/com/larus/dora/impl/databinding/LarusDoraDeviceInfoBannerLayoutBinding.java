package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.dora.impl.view.DoraTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraDeviceInfoBannerLayoutBinding implements ViewBinding {
    public final ItemGroup a;
    public final LinearLayoutCompat b;
    public final ImageView c;
    public final AppCompatTextView d;
    public final DoraTextView e;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraDeviceInfoBannerLayoutBinding(ItemGroup r1, LinearLayoutCompat r2, ImageView r3, AppCompatTextView r4, DoraTextView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
