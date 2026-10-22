package kv9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/larus/settings/provider/music/MusicCreateConfig;", "", "musicLyricsCustomWordMax", "", "musicLyricsCustomWordMin", "musicLyricsPromptWordMax", "musicLyricsPromptWordMin", "saveVideoBlackListStrategy", "<init>", "(IIIII)V", "getMusicLyricsCustomWordMax", "()I", "getMusicLyricsCustomWordMin", "getMusicLyricsPromptWordMax", "getMusicLyricsPromptWordMin", "getSaveVideoBlackListStrategy", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class a {

    @SerializedName("music_lyrics_custom_word_max")
    private final int musicLyricsCustomWordMax;

    @SerializedName("music_lyrics_custom_word_min")
    private final int musicLyricsCustomWordMin;

    @SerializedName("music_lyrics_prompt_word_max")
    private final int musicLyricsPromptWordMax;

    @SerializedName("music_lyrics_prompt_word_min")
    private final int musicLyricsPromptWordMin;

    @SerializedName("save_video_black_list_strategy")
    private final int saveVideoBlackListStrategy;

    public a() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (this.musicLyricsCustomWordMax == r6.musicLyricsCustomWordMax) goto L12;
        return false;
    L12:
        if (this.musicLyricsCustomWordMin == r6.musicLyricsCustomWordMin) goto L15;
        return false;
    L15:
        if (this.musicLyricsPromptWordMax == r6.musicLyricsPromptWordMax) goto L18;
        return false;
    L18:
        if (this.musicLyricsPromptWordMin == r6.musicLyricsPromptWordMin) goto L21;
        return false;
    L21:
        if (this.saveVideoBlackListStrategy == r6.saveVideoBlackListStrategy) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.musicLyricsCustomWordMax * 31) + this.musicLyricsCustomWordMin) * 31) + this.musicLyricsPromptWordMax) * 31) + this.musicLyricsPromptWordMin) * 31) + this.saveVideoBlackListStrategy;
    }

    public final String toString() {
        return "MusicCreateConfig(musicLyricsCustomWordMax=" + this.musicLyricsCustomWordMax + ", musicLyricsCustomWordMin=" + this.musicLyricsCustomWordMin + ", musicLyricsPromptWordMax=" + this.musicLyricsPromptWordMax + ", musicLyricsPromptWordMin=" + this.musicLyricsPromptWordMin + ", saveVideoBlackListStrategy=" + this.saveVideoBlackListStrategy + ')';
    }

    public final int a() {
        return this.musicLyricsCustomWordMax;
    }

    public final int b() {
        return this.musicLyricsCustomWordMin;
    }

    public final int c() {
        return this.musicLyricsPromptWordMax;
    }

    public final int d() {
        return this.musicLyricsPromptWordMin;
    }

    public final int e() {
        return this.saveVideoBlackListStrategy;
    }

    public /* synthetic */ a(int r7) {
        this(200, 5, 200, 3, 0);
    }

    public a(int r1, int r2, int r3, int r4, int r5) {
        this.musicLyricsCustomWordMax = r1;
        this.musicLyricsCustomWordMin = r2;
        this.musicLyricsPromptWordMax = r3;
        this.musicLyricsPromptWordMin = r4;
        this.saveVideoBlackListStrategy = r5;
    }
}
