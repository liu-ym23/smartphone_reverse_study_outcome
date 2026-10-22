package com.larus.avlink.impl.databinding;

import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class FragmentDoraEnvObserveDiaryDetailBinding implements ViewBinding {
    public final LinearLayoutCompat a;
    public final RecyclerView b;
    public final ProgressBar c;
    public final NovaTitleBarEx d;

    public final View getRoot() {
        return this.a;
    }

    public FragmentDoraEnvObserveDiaryDetailBinding(LinearLayoutCompat r1, RecyclerView r2, ProgressBar r3, NovaTitleBarEx r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
