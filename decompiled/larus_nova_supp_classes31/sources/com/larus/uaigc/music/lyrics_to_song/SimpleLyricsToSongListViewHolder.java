package com.larus.uaigc.music.lyrics_to_song;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.music.widget.LyricsToSongCardView;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/larus/uaigc/music/lyrics_to_song/SimpleLyricsToSongListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "cardView", "Lcom/larus/bmhome/music/widget/LyricsToSongCardView;", "itemPosition", "", "<init>", "(Lcom/larus/bmhome/music/widget/LyricsToSongCardView;Ljava/lang/Integer;)V", "getCardView", "()Lcom/larus/bmhome/music/widget/LyricsToSongCardView;", "getItemPosition", "()Ljava/lang/Integer;", "setItemPosition", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SimpleLyricsToSongListViewHolder extends RecyclerView.ViewHolder {
    public final LyricsToSongCardView a;
    public Integer b;

    public SimpleLyricsToSongListViewHolder(LyricsToSongCardView r2) {
        Intrinsics.checkNotNullParameter(r2, "cardView");
        super(r2);
        this.a = r2;
        this.b = null;
    }
}
