package com.larus.avlink.impl.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.avlink.gallery.view.AlbumSyncBanner;
import com.larus.common_res.common_ui.databinding.LarusAccountDialogBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class LarusFragmentMineAlbumListBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final LarusPageAlbumListEmptyBinding b;
    public final AppCompatTextView c;
    public final RecyclerView d;
    public final LarusAccountDialogBinding e;
    public final AlbumSyncBanner f;
    public final View g;
    public final AppCompatTextView h;

    public final View getRoot() {
        return this.a;
    }

    public LarusFragmentMineAlbumListBinding(ConstraintLayout r1, LarusPageAlbumListEmptyBinding r2, AppCompatTextView r3, RecyclerView r4, LarusAccountDialogBinding r5, AlbumSyncBanner r6, View r7, AppCompatTextView r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }
}
