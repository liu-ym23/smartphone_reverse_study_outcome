package com.larus.bmhome.music.widget;

import android.text.TextUtils;
import com.larus.bmhome.music.databinding.LarusMusicCoverViewHolderBinding;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a2 implements PlaylistViewPagerAdapter.b {
    public final /* synthetic */ MusicPlayerDetailFragment a;

    @Override // com.larus.bmhome.music.widget.PlaylistViewPagerAdapter.b
    public final MusicCreationContent a() {
        return this.a.p;
    }

    @Override // com.larus.bmhome.music.widget.PlaylistViewPagerAdapter.b
    public final int b() {
        return this.a.v;
    }

    public a2(MusicPlayerDetailFragment r1) {
        this.a = r1;
    }

    @Override // com.larus.bmhome.music.widget.PlaylistViewPagerAdapter.b
    public final void c(PlaylistViewPagerAdapter.MusicCoverViewHolder r5, final MusicCreationContent r6) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r6, "musicContent");
        final MusicPlayerDetailFragment r0 = this.a;
        final LarusMusicCoverViewHolderBinding r7 = r5.a;
        int r1 = MusicPlayerDetailFragment.O;
        r0.getClass();
        Image r2 = r6.getCover();
        String r3 = null;
        if (r0.h == false) goto L12;
        if (r2 == null) goto L8;
        ImageObj r4 = r2.imageThumb;
        if (r4 == null) goto L8;
        String r8 = r4.url;
    L10:
        if (TextUtils.isEmpty(r8) == false) goto L12;
        r7.c.setActualImageResource(2131241610);
        r7.b.pauseAnimation();
        com.larus.utils.e1.q(r7.b);
        com.larus.utils.e1.x(r7.c);
        r0.ga0(r7, r6);
        return;
    L8:
        r8 = null;
    L12:
        if (r2 == null) goto L16;
        ImageObj r9 = r2.previewImage;
        if (r9 == null) goto L16;
        String r10 = r9.url;
    L17:
        if (r2 == null) goto L22;
        ImageObj r11 = r2.imageOri;
        if (r11 == null) goto L22;
        r3 = r11.url;
    L22:
        if (com.larus.utils.o0.d(r10) == true) goto L26;
        r10 = r3;
    L26:
        if (TextUtils.isEmpty(r10) == false) goto L28;
        FLogger.a.e("MusicPlayerDetailFragment", "[loadCoverImage] failed, empty musicContent");
        return;
    L28:
        com.larus.utils.e1.x(r7.c);
        ImageLoaderKt.y(r7.c, r10, "chat.music", new h1(r7, r0, r6), 4);
        return;
    L16:
        r10 = null;
        goto L17
    }
}
