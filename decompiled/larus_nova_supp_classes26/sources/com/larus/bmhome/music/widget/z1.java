package com.larus.bmhome.music.widget;

import android.content.Context;
import com.larus.platform.api.ModifiedUserCreationMusic;
import com.larus.utils.logger.FLogger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class z1 implements com.larus.bmhome.music.edit.a {
    public final /* synthetic */ MusicPlayerDetailFragment a;

    @Override // com.larus.bmhome.music.edit.a
    public final void b(ModifiedUserCreationMusic r1) {
    }

    @Override // com.larus.bmhome.music.edit.a
    public final com.larus.bmhome.music.edit.j c() {
        com.larus.bmhome.music.player.j r1 = this.a.q;
        if (r1 == null) goto L6;
        String r2 = r1.j();
        if (r2 == null) goto L6;
    L8:
        return new com.larus.bmhome.music.edit.j(r2, "", this.a.p);
    L6:
        r2 = "";
        goto L8
    }

    public z1(MusicPlayerDetailFragment r1) {
        this.a = r1;
    }

    @Override // com.larus.bmhome.music.edit.a
    public final void a(com.larus.bmhome.music.edit.v r6) {
        Intrinsics.checkNotNullParameter(r6, "status");
        FLogger r0 = FLogger.a;
        r0.i("MusicPlayerDetailFragment", "[onUploadStatusChanged] status:" + r6);
        boolean r3 = true;
        if ((r6 instanceof com.larus.bmhome.music.edit.v.a) == false) goto L16;
        MusicPlayerDetailFragment r1 = this.a;
        String r7 = ((com.larus.bmhome.music.edit.v.a) r6).a;
        int r2 = MusicPlayerDetailFragment.O;
        com.larus.common_ui.dialog.l0 r4 = (com.larus.common_ui.dialog.l0) r1.K.getValue();
        if (r4 == null) goto L7;
        MusicPlayerDetailFragment.S90(r4);
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
        MusicPlayerDetailFragment r11 = this.a;
        int r12 = MusicPlayerDetailFragment.O;
        r11.ja0(true);
        return;
    L19:
        if (Intrinsics.areEqual(r6, com.larus.bmhome.music.edit.v.c.a) == false) goto L23;
        MusicPlayerDetailFragment r13 = this.a;
        int r14 = MusicPlayerDetailFragment.O;
        r13.getClass();
        r0.i("MusicPlayerDetailFragment", "[onEditCoverSuccess]");
        r13.ja0(false);
        return;
    L23:
        throw new NoWhenBranchMatchedException();
    }
}
