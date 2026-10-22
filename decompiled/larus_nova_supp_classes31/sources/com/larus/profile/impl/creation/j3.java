package com.larus.profile.impl.creation;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.music.databinding.LarusMusicCoverViewHolderBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class j3 extends BaseControllerListener<Object> {
    public final /* synthetic */ MusicDetailFragment a;
    public final /* synthetic */ LarusMusicCoverViewHolderBinding b;

    public j3(MusicDetailFragment r1, LarusMusicCoverViewHolderBinding r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFailure(String r1, Throwable r2) {
        super.onFailure(r1, r2);
        this.b.b.pauseAnimation();
        com.larus.utils.e1.q(this.b.b);
    }

    public final void onSubmit(String r1, Object r2) {
        super.onSubmit(r1, r2);
    }

    public final void onFinalImageSet(String r4, Object r5, Animatable r6) {
        MusicDetailFragment r0 = this.a;
        LarusMusicCoverViewHolderBinding r1 = this.b;
        int r2 = MusicDetailFragment.J;
        r0.getClass();
        SimpleDraweeView r3 = r1.c;
        r3.setOnClickListener(new y2(r0));
        r3.setOnLongClickListener(new z2(r0));
        this.b.b.pauseAnimation();
        com.larus.utils.e1.q(this.b.b);
        super.onFinalImageSet(r4, r5, r6);
    }
}
