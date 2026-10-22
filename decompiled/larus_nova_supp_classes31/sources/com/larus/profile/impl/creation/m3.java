package com.larus.profile.impl.creation;

import android.text.TextUtils;
import com.larus.bmhome.music.databinding.LarusFragmentMusicPlayerDetailBinding;
import com.larus.common_ui.video.progress.PlayerProgressView;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class m3 implements PlayerProgressView.a {
    public double a;
    public final /* synthetic */ MusicDetailFragment b;
    public final /* synthetic */ LarusFragmentMusicPlayerDetailBinding c;

    public final void a(double r1) {
    }

    public final void b() {
        MusicDetailFragment r1 = this.b;
        r1.u = false;
        r1.A = System.currentTimeMillis();
        FLogger.a.d("MusicPlayerDetailFragment", "[IProgressChangedListener] onUserDragStopped, userDragProgress:" + this.a);
        double r3 = ((double) (this.b.o.j(null, null) * 1000)) * this.a;
        if (this.b.o.isStreaming() == false) goto L37;
        MusicCreationContent r2 = this.b.r;
        if (r2 == null) goto L7;
        String r4 = r2.getVideoModel();
    L9:
        if (TextUtils.isEmpty(r4) == false) goto L11;
        this.c.h.b6();
        MusicDetailFragment r5 = this.b;
        r5.y = r3;
        r5.z = this.a;
        return;
    L11:
        this.b.o.k(true);
        MusicDetailFragment r6 = this.b;
        com.larus.bmhome.music.player.a r7 = r6.o;
        MusicCreationContent r8 = r6.r;
        String r9 = "";
        if (r8 == null) goto L17;
        String r10 = r8.getVid();
        if (r10 == null) goto L17;
        String r16 = r10;
    L18:
        MusicCreationContent r11 = this.b.r;
        if (r11 == null) goto L24;
        String r12 = r11.getVideoModel();
        if (r12 == null) goto L24;
        String r15 = r12;
    L25:
        r7.e(new com.larus.bmhome.music.player.j(null, null, null, null, null, 0, r15, r16, false, false, null, 0, null, null, null, false, null, null, null, false, false, null, false, false, null, null, 67108671));
        this.b.o.seekTo((int) r3);
        MusicCreationContent r13 = this.b.r;
        if (r13 == null) goto L29;
        String r14 = r13.getVid();
        if (r14 == null) goto L29;
    L30:
        com.larus.bmhome.music.player.j r17 = this.b.s;
        if (r17 == null) goto L36;
        String r18 = r17.d();
        if (r18 == null) goto L36;
        r9 = r18;
    L36:
        kr8.l.a.b(new kr8.m(r14, "ai_generated", r9, 1), null, 3);
        return;
    L29:
        r14 = "";
    L24:
        r15 = "";
    L17:
        r16 = "";
        goto L18
    L7:
        r4 = null;
        goto L9
    L37:
        this.b.o.seekTo((int) r3);
    }

    public final void c() {
        this.b.u = true;
        this.c.h.c6();
    }

    public final void onProgressChanged(double r1) {
        this.a = r1;
    }

    public m3(MusicDetailFragment r1, LarusFragmentMusicPlayerDetailBinding r2) {
        this.b = r1;
        this.c = r2;
        this.a = 1.0d;
    }
}
