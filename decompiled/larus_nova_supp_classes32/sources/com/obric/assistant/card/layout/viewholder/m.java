package com.obric.assistant.card.layout.viewholder;

import android.os.Bundle;
import android.os.SystemClock;
import com.obric.assistant.card.manager.NetEaseMusicManager;
import com.obric.capabilitykit.entity.app.MusicEntity;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class m implements NetEaseMusicManager.a {
    public final /* synthetic */ String a;
    public final /* synthetic */ MusicEntity b;
    public final /* synthetic */ MusicViewHolder c;

    @Override // com.obric.assistant.card.manager.NetEaseMusicManager.a
    public final void onMusicStateChanged(Bundle r13) {
        Intrinsics.checkNotNullParameter(r13, "musicState");
        NetEaseMusicManager r0 = NetEaseMusicManager.a;
        String r1 = this.a;
        String r2 = this.b.getId();
        r0.getClass();
        boolean r3 = NetEaseMusicManager.d(r1, r2);
        MusicViewHolder r4 = this.c;
        int r5 = 0;
        if (r3 == false) goto L11;
        Intrinsics.checkNotNullParameter(r13, "bundle");
        int r6 = r13.getInt("total_time", 0);
        int r7 = r13.getInt("current_time", 0);
        long r8 = r13.getLong("music_info_update_time", 0);
        if (r6 <= 0) goto L11;
        if (r8 <= 0) goto L9;
        long r9 = (((long) r7) + SystemClock.elapsedRealtime()) - r8;
    L10:
        r5 = (int) RangesKt.coerceIn((r9 * ((long) 100)) / ((long) r6), 0, 100);
        goto L11
    L9:
        r9 = r7;
    L11:
        int r14 = MusicViewHolder.o;
        r4.a4(r3, r5);
    }

    public m(String r1, MusicEntity r2, MusicViewHolder r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
