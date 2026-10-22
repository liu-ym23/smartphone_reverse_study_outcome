package com.larus.voicecall.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class LarusItemRecyclerSubtitleTextBinding implements ViewBinding {
    public final FrameLayout a;
    public final CustomMarkdownTextView b;
    public final ImageView c;
    public final AppCompatTextView d;

    public final View getRoot() {
        return this.a;
    }

    public LarusItemRecyclerSubtitleTextBinding(FrameLayout r1, CustomMarkdownTextView r2, ImageView r3, AppCompatTextView r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
