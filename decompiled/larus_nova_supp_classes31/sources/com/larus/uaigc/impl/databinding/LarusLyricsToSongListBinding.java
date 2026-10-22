package com.larus.uaigc.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.music.widget.NestedRecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusLyricsToSongListBinding implements ViewBinding {
    public final LinearLayout a;
    public final TextView b;
    public final NestedRecyclerView c;

    public final View getRoot() {
        return this.a;
    }

    public LarusLyricsToSongListBinding(LinearLayout r1, TextView r2, NestedRecyclerView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
