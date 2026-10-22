package com.larus.bmhome.music.widget;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.larus.bmhome.chat.layout.holder.progressloading.ImageWebpLoadingBgView;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.utils.logger.FLogger;
import com.lynx.lottieadapter.LottieAdapterView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e0 extends BaseControllerListener<Object> {
    public final /* synthetic */ LyricsToSongCardView a;
    public final /* synthetic */ MusicCreationContent b;

    public e0(LyricsToSongCardView r1, MusicCreationContent r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFailure(String r5, Throwable r6) {
        FLogger r0 = FLogger.a;
        r0.i("LyricsToSong", "cover image failed");
        LyricsToSongCardView r1 = this.a;
        r1.getClass();
        r0.i("LyricsToSong", "loading view hide");
        r1.B = false;
        LottieAdapterView r2 = r1.p;
        if (r2 == null) goto L5;
        r2.setAlpha(0.0f);
    L5:
        LyricsToSongCardView r3 = this.a;
        r3.L = false;
        ImageWebpLoadingBgView r4 = r3.f;
        if (r4 == null) goto L8;
        com.larus.utils.e1.o(r4);
    L8:
        super.onFailure(r5, r6);
    }

    public final void onSubmit(String r4, Object r5) {
        FLogger.a.i("LyricsToSong", "cover image submit");
        super.onSubmit(r4, r5);
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        super.onFinalImageSet(r1, r2, r3);
        FLogger.a.i("LyricsToSong", "cover image set");
        LyricsToSongCardView r4 = this.a;
        r4.B = false;
        r4.L = false;
        ImageWebpLoadingBgView r5 = r4.f;
        if (r5 == null) goto L5;
        com.larus.utils.e1.o(r5);
    L5:
        LyricsToSongCardView.f(this.a, this.b.getCoverMainColor());
    }
}
