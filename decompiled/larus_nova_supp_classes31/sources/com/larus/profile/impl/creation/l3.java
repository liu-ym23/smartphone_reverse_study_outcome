package com.larus.profile.impl.creation;

import android.text.TextUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.music.databinding.LarusMusicCoverViewHolderBinding;
import com.larus.bmhome.music.widget.PlaylistViewPagerAdapter;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class l3 implements PlaylistViewPagerAdapter.b {
    public final /* synthetic */ MusicDetailFragment a;

    public final MusicCreationContent a() {
        return this.a.r;
    }

    public final int b() {
        return this.a.v;
    }

    public l3(MusicDetailFragment r1) {
        this.a = r1;
    }

    public final void c(PlaylistViewPagerAdapter.MusicCoverViewHolder r4, MusicCreationContent r5) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r5, "musicContent");
        final MusicDetailFragment r0 = this.a;
        final LarusMusicCoverViewHolderBinding r6 = r4.a;
        int r1 = MusicDetailFragment.J;
        r0.getClass();
        Image r7 = r5.getCover();
        String r2 = null;
        if (r0.h == false) goto L12;
        if (r7 == null) goto L8;
        ImageObj r3 = r7.imageThumb;
        if (r3 == null) goto L8;
        String r8 = r3.url;
    L10:
        if (TextUtils.isEmpty(r8) == false) goto L12;
        r6.c.setActualImageResource(2131241610);
        r6.b.pauseAnimation();
        com.larus.utils.e1.q(r6.b);
        com.larus.utils.e1.x(r6.c);
        SimpleDraweeView r9 = r6.c;
        r9.setOnClickListener(new y2(r0));
        r9.setOnLongClickListener(new z2(r0));
        return;
    L8:
        r8 = null;
    L12:
        if (r7 == null) goto L17;
        ImageObj r10 = r7.imageOri;
        if (r10 == null) goto L17;
        r2 = r10.url;
    L17:
        if (TextUtils.isEmpty(r2) == false) goto L19;
        FLogger.a.e("MusicPlayerDetailFragment", "[loadCoverImage] failed, empty musicContent");
        return;
    L19:
        com.larus.utils.e1.x(r6.c);
        ImageLoaderKt.y(r6.c, r2, "chat.music", new m2(r6, r0), 4);
    }
}
