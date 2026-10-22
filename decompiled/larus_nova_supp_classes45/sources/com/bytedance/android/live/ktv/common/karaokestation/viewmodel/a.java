package com.bytedance.android.live.ktv.common.karaokestation.viewmodel;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.karaokestation.model.d;
import com.bytedance.android.live.ktv.common.karaokestation.model.x;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.live.ktv.common.model.api.o0;
import com.bytedance.android.livesdk.config.t61;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements nb0.b {
    public a() {
    }

    @Override // nb0.b
    public final void addFavorite(MusicPanel r2, ic0.a r3) {
        Intrinsics.checkNotNullParameter(r2, "musicPanel");
        Intrinsics.checkNotNullParameter(r3, "favoriteCallback");
    }

    @Override // nb0.b
    public final void addSong(Context r2, MusicPanel r3, RecyclerView.ViewHolder r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "musicPanel");
        Intrinsics.checkNotNullParameter(r4, "viewHolder");
    }

    @Override // nb0.b
    public final String c() {
        return null;
    }

    @Override // nb0.b
    public final void delFavorite(MusicPanel r2, ic0.a r3) {
        Intrinsics.checkNotNullParameter(r2, "musicPanel");
        Intrinsics.checkNotNullParameter(r3, "favoriteCallback");
    }

    @Override // nb0.b
    public final t61 e() {
        return null;
    }

    @Override // nb0.b
    public final int g() {
        return -1;
    }

    @Override // nb0.b
    public final String getRequiredSongInfo() {
        return "";
    }

    @Override // nb0.b
    public final String h() {
        return null;
    }

    @Override // nb0.b
    public final x getRoomInfo() {
        return new x(0);
    }

    @Override // nb0.b
    public final Map<String, y> f(d r2) {
        Intrinsics.checkNotNullParameter(r2, "firstLevelTabData");
        Intrinsics.checkNotNullParameter(r2, "firstLevelTabData");
        return null;
    }

    @Override // nb0.b
    public final void postSyncSongListData(y r2) {
        Intrinsics.checkNotNullParameter(r2, "secondLevelTabData");
        Intrinsics.checkNotNullParameter(r2, "secondLevelTabData");
    }

    @Override // nb0.b
    public final void postSyncTabListData(d r2) {
        Intrinsics.checkNotNullParameter(r2, "firstLevelTabData");
        Intrinsics.checkNotNullParameter(r2, "firstLevelTabData");
    }

    @Override // nb0.b
    public final void updateMusicPanelState(MusicPanel r2) {
        Intrinsics.checkNotNullParameter(r2, "musicPanel");
        Intrinsics.checkNotNullParameter(r2, "musicPanel");
    }

    @Override // nb0.b
    public final void a(d r1, List<o0> r2) {
        Intrinsics.checkNotNullParameter(r1, "firstLevelTabData");
        Intrinsics.checkNotNullParameter(r1, "firstLevelTabData");
    }

    @Override // nb0.b
    public final void b(boolean r1, Throwable r2, y r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, "secondLevelTabData");
        Intrinsics.checkNotNullParameter(r3, "secondLevelTabData");
    }

    @Override // nb0.b
    public final void d(boolean r1, Throwable r2, d r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, "firstLevelTabData");
        Intrinsics.checkNotNullParameter(r3, "firstLevelTabData");
    }
}
