package com.larus.voicecall.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.FastScrollButton;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class LarusLayoutRealtimeCallSubtitleBinding implements ViewBinding {
    public final View a;
    public final View b;
    public final RecyclerView c;
    public final FastScrollButton d;
    public final TextView e;

    public final View getRoot() {
        return this.a;
    }

    public LarusLayoutRealtimeCallSubtitleBinding(View r1, View r2, RecyclerView r3, FastScrollButton r4, TextView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
