package com.larus.bmhome.music.widget;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.larus.bmhome.music.databinding.LarusMusicCoverViewHolderBinding;
import com.larus.im.bean.message.block.MusicCreationContent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class y1 extends BaseControllerListener<Object> {
    public final /* synthetic */ MusicPlayerDetailFragment a;
    public final /* synthetic */ LarusMusicCoverViewHolderBinding b;
    public final /* synthetic */ MusicCreationContent c;

    public final void onFailure(String r1, Throwable r2) {
        super.onFailure(r1, r2);
        this.b.b.pauseAnimation();
        com.larus.utils.e1.q(this.b.b);
    }

    public final void onSubmit(String r1, Object r2) {
        super.onSubmit(r1, r2);
    }

    public y1(MusicPlayerDetailFragment r1, LarusMusicCoverViewHolderBinding r2, MusicCreationContent r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onFinalImageSet(String r5, Object r6, Animatable r7) {
        MusicPlayerDetailFragment r0 = this.a;
        LarusMusicCoverViewHolderBinding r1 = this.b;
        MusicCreationContent r2 = this.c;
        int r3 = MusicPlayerDetailFragment.O;
        r0.ga0(r1, r2);
        this.b.b.pauseAnimation();
        com.larus.utils.e1.q(this.b.b);
        super.onFinalImageSet(r5, r6, r7);
    }
}
