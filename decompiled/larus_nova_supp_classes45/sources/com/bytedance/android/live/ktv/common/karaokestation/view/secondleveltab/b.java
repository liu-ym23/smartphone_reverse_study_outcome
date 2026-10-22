package com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab;

import android.view.View;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ CommonSongListItemViewHolder a;

    public b(CommonSongListItemViewHolder r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        MusicPanel r4 = this.a.i;
        if (r4 == null) goto L13;
        KtvMusic r5 = r4.a;
        if (r5 == null) goto L13;
        if (r5.isFavorite() != true) goto L13;
        CommonSongListItemViewHolder r6 = this.a;
        MusicPanel r0 = r6.i;
        if (r0 == null) goto L19;
        d r1 = r6.k;
        if (r1 == null) goto L20;
        r1.d(r0, r6.j);
        return;
    L20:
        return;
    L19:
        return;
    L13:
        CommonSongListItemViewHolder r7 = this.a;
        MusicPanel r2 = r7.i;
        if (r2 == null) goto L22;
        d r8 = r7.k;
        if (r8 == null) goto L23;
        r8.f(r2, r7.j);
        return;
    L23:
        return;
    }
}
