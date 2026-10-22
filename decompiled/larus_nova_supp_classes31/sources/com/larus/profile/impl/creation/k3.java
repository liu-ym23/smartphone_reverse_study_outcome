package com.larus.profile.impl.creation;

import android.content.Context;
import com.larus.bmhome.music.databinding.LarusFragmentMusicPlayerDetailBinding;
import com.larus.bmhome.music.widget.PlaylistViewPagerAdapter;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.ModifiedUserCreationMusic;
import com.larus.utils.logger.FLogger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class k3 implements com.larus.bmhome.music.edit.a {
    public final /* synthetic */ MusicDetailFragment a;

    public final com.larus.bmhome.music.edit.j c() {
        MusicDetailFragment r0 = this.a;
        com.larus.bmhome.music.protocol.f r1 = r0.r;
        String r3 = null;
        if ((r1 instanceof com.larus.bmhome.music.protocol.f) == false) goto L5;
        com.larus.bmhome.music.protocol.f r2 = r1;
    L6:
        if (r2 == null) goto L8;
        r3 = r2.a;
    L8:
        com.larus.bmhome.music.player.j r4 = r0.s;
        if (r4 == null) goto L12;
        String r5 = r4.j();
        if (r5 == null) goto L12;
    L14:
        return new com.larus.bmhome.music.edit.j(r5, r3, this.a.r);
    L12:
        r5 = "";
        goto L14
    L5:
        r2 = null;
        goto L6
    }

    public k3(MusicDetailFragment r1) {
        this.a = r1;
    }

    public final void a(com.larus.bmhome.music.edit.v r6) {
        Intrinsics.checkNotNullParameter(r6, "status");
        FLogger r0 = FLogger.a;
        r0.i("MusicPlayerDetailFragment", "[onUploadStatusChanged] status:" + r6);
        boolean r3 = true;
        if ((r6 instanceof com.larus.bmhome.music.edit.v.a) == false) goto L16;
        MusicDetailFragment r1 = this.a;
        String r7 = ((com.larus.bmhome.music.edit.v.a) r6).a;
        int r2 = MusicDetailFragment.J;
        com.larus.common_ui.dialog.l0 r4 = (com.larus.common_ui.dialog.l0) r1.G.getValue();
        if (r4 == null) goto L7;
        MusicDetailFragment.S90(r4);
    L7:
        if (r7 != null) goto L9;
    L12:
        if (r3 == false) goto L14;
        t19.s r8 = t19.s.a;
        Context r5 = r1.getViewContext();
        r8.getClass();
        t19.s.b(r5, 2131907942, false);
        return;
    L14:
        t19.s r9 = t19.s.a;
        Context r10 = r1.getViewContext();
        r9.getClass();
        t19.s.c(r10, r7);
        return;
    L9:
        if (r7.length() == 0) goto L12;
        r3 = false;
        goto L12
    L16:
        if (Intrinsics.areEqual(r6, com.larus.bmhome.music.edit.v.b.a) == false) goto L19;
        MusicDetailFragment r11 = this.a;
        int r12 = MusicDetailFragment.J;
        r11.ba0(true);
        return;
    L19:
        if (Intrinsics.areEqual(r6, com.larus.bmhome.music.edit.v.c.a) == false) goto L23;
        MusicDetailFragment r13 = this.a;
        int r14 = MusicDetailFragment.J;
        r13.getClass();
        r0.i("MusicPlayerDetailFragment", "[onEditCoverSuccess]");
        r13.ba0(false);
        return;
    L23:
        throw new NoWhenBranchMatchedException();
    }

    public final void b(ModifiedUserCreationMusic r24) {
        if (r24 == null) goto L23;
        ImageInfo r3 = r24.b;
        if (r3 == null) goto L23;
        MusicDetailFragment r4 = this.a;
        MusicCreationContent r5 = r4.r;
        if (r5 == null) goto L17;
        String r7 = r3.e;
        Image r6 = r3.b;
        if (r6 == null) goto L11;
        ImageObj r9 = is9.a.a(r6);
    L12:
        Image r8 = r3.a;
        if (r8 == null) goto L15;
        ImageObj r10 = is9.a.a(r8);
    L16:
        r5.setCover(new com.larus.im.bean.message.Image(r7, null, r9, r10, null, null, null, null, null, null, null, null, null, null, 16370, null));
        goto L17
    L15:
        r10 = null;
        goto L16
    L11:
        r9 = null;
    L17:
        MusicCreationContent r2 = r4.r;
        if (r2 != null) goto L20;
        return;
    L20:
        PlaylistViewPagerAdapter r11 = r4.q;
        if (r11 == null) goto L23;
        r11.A2(r2);
    L23:
        boolean r12 = false;
        if (r24 == null) goto L42;
        String r13 = r24.a;
        if (r13 == null) goto L42;
        MusicDetailFragment r14 = this.a;
        if (r13.length() != 0) goto L30;
        boolean r15 = true;
    L31:
        if (r15 == false) goto L33;
        return;
    L33:
        MusicCreationContent r16 = r14.r;
        if (r16 == null) goto L36;
        r16.setTitle(r13);
    L36:
        LarusFragmentMusicPlayerDetailBinding r17 = r14.p;
        if (r17 == null) goto L42;
        MusicCreationContent r18 = r14.r;
        if (r18 != null) goto L41;
        return;
    L41:
        r14.W90(r17, r13, r18);
        goto L42
    L30:
        r15 = false;
    L42:
        if (r24 == null) goto L56;
        String r19 = r24.c;
        if (r19 == null) goto L56;
        MusicDetailFragment r20 = this.a;
        if (r19.length() != 0) goto L48;
        r12 = true;
    L48:
        if (r12 == false) goto L50;
        return;
    L50:
        MusicCreationContent r21 = r20.r;
        if (r21 == null) goto L54;
        r21.setCoverMainColor(r19);
    L54:
        if (r20.p == null) goto L56;
        r20.U90(r20.r);
    L56:
        j2 r22 = this.a.getParentFragment();
        if ((r22 instanceof j2) == false) goto L59;
        j2 r23 = r22;
    L60:
        if (r23 == null) goto L63;
        r23.J50(r24);
        return;
    L63:
        return;
    L59:
        r23 = null;
        goto L60
    }
}
