package com.larus.bmhome.music.edit;

import android.content.Context;
import com.larus.common_ui.dialog.l0;
import com.larus.platform.api.ModifiedUserCreationMusic;
import com.larus.utils.logger.FLogger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h implements a {
    public final /* synthetic */ MusicEditDialogFragment a;

    @Override // com.larus.bmhome.music.edit.a
    public final j c() {
        MusicEditDialogFragment r1 = this.a;
        return new j(r1.f, r1.g, r1.d);
    }

    public h(MusicEditDialogFragment r1) {
        this.a = r1;
    }

    @Override // com.larus.bmhome.music.edit.a
    public final void a(v r5) {
        Intrinsics.checkNotNullParameter(r5, "status");
        FLogger.a.i("MusicEditDialogFragment", "[onUploadStatusChanged] status:" + r5);
        boolean r1 = true;
        if ((r5 instanceof v.a) == false) goto L19;
        MusicEditDialogFragment r0 = this.a;
        String r6 = ((v.a) r5).a;
        int r3 = MusicEditDialogFragment.t;
        Context r4 = r0.getContext();
        if (r4 == null) goto L30;
        l0 r2 = r0.U90();
        if (r2 == null) goto L10;
        MusicEditDialogFragment.T90(r2);
    L10:
        if (r6 != null) goto L12;
    L15:
        if (r1 == false) goto L17;
        t19.s.a.getClass();
        t19.s.b(r4, 2131907942, false);
        return;
    L17:
        t19.s.a.getClass();
        t19.s.c(r4, r6);
        return;
    L12:
        if (r6.length() == 0) goto L15;
        r1 = false;
        goto L15
    L30:
        return;
    L19:
        if (Intrinsics.areEqual(r5, v.b.a) == false) goto L22;
        MusicEditDialogFragment r7 = this.a;
        int r8 = MusicEditDialogFragment.t;
        r7.showLoading(true);
        return;
    L22:
        if (Intrinsics.areEqual(r5, v.c.a) == false) goto L26;
        MusicEditDialogFragment r9 = this.a;
        int r10 = MusicEditDialogFragment.t;
        r9.showLoading(false);
        MusicEditDialogFragment.S90(r9);
        return;
    L26:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.larus.bmhome.music.edit.a
    public final void b(ModifiedUserCreationMusic r2) {
        a r0 = this.a.k;
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }
}
