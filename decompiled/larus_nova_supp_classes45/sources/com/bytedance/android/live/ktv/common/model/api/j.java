package com.bytedance.android.live.ktv.common.model.api;

import com.bytedance.android.livesdk.message.model.MusicInterval;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b8\u00109R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR*\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000fR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010%\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR$\u0010(\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR$\u0010,\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00102\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010-\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R$\u00105\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010\u000b\u001a\u0004\b6\u0010\r\"\u0004\b7\u0010\u000f¨\u0006:"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/j;", "", "", "songId", "Ljava/lang/Long;", "h", "()Ljava/lang/Long;", "s", "(Ljava/lang/Long;)V", "", "foldingInfo", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "l", "(Ljava/lang/String;)V", "lyricInfo", "c", "n", "", "Lcom/bytedance/android/livesdk/message/model/MusicInterval;", "musicClimax", "Ljava/util/List;", "d", "()Ljava/util/List;", "o", "(Ljava/util/List;)V", "songEmoTag", "g", "r", "", "type", "I", "getType", "()I", "t", "(I)V", "sameGroupIdV3", "e", "p", "simGroupIdV3", "f", "q", "", "isFilter", "Ljava/lang/Boolean;", "i", "()Ljava/lang/Boolean;", "k", "(Ljava/lang/Boolean;)V", "isNonVocal", "j", "setNonVocal", "fontInfo", "b", "m", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class j implements vh7.h {

    @SerializedName("folding_info")
    protected String foldingInfo;

    @SerializedName("font_info")
    protected String fontInfo;

    @SerializedName("is_filter")
    protected Boolean isFilter;

    @SerializedName("is_non_vocal")
    protected Boolean isNonVocal;

    @SerializedName("lyric_info")
    protected String lyricInfo;

    @SerializedName("music_climax")
    protected List<MusicInterval> musicClimax;

    @SerializedName("same_group_id_v3")
    protected Long sameGroupIdV3;

    @SerializedName("sim_group_id_v3")
    protected Long simGroupIdV3;

    @SerializedName("tagging_info")
    protected String songEmoTag;

    @SerializedName("song_id")
    protected Long songId;

    @SerializedName("type")
    protected int type;

    public final void m() {
        this.fontInfo = "[{\"font_family\":\"FZZhengCuHei\",\"font_size\":18,\"url\":\"https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/multilink-font-FZZhengCuHei.TTF\"}]";
    }

    public j() {
        this.songId = 0L;
        this.foldingInfo = "";
        this.lyricInfo = "";
        Boolean r0 = Boolean.FALSE;
        this.isFilter = r0;
        this.isNonVocal = r0;
    }

    public final void l() {
        this.foldingInfo = "{\"ResourceID\":1754277767915,\"AudioID\":\"6874972841490515969\",\"Similarity\":0.81,\"QueryStartTime\":0,\"QueryEndTime\":15.0,\"MatchStartTime\":0.0,\"MatchEndTime\":15.0,\"QueryDuration\":15.0,\"MatchDuration\":15.0,\"MatchPeriods\":[{\"Similarity\":0.81,\"QueryStartTime\":0,\"QueryEndTime\":15.0,\"MatchStartTime\":0.0,\"MatchEndTime\":15.0,\"QueryDuration\":15.0,\"MatchDuration\":15.0}],\"SongInfo\":{\"ID\":6874972841490515969,\"SongName\":\"隐形的翅膀-2007年央视春晚\",\"ArtistName\":\"张韶涵\",\"AlbumName\":\"\",\"Tagging\":\"{\\\"Languages\\\":[\\\"Chinese\\\"],\\\"Moods\\\":[\\\"Inspirational\\\",\\\"Memory\\\"],\\\"Genres\\\":[\\\"Pop\\\",\\\"Chinese Pop\\\"],\\\"Themes\\\":[\\\"Travel\\\",\\\"Spring\\\"],\\\"AEDs\\\":[\\\"Female\\\",\\\"Vocal\\\",\\\"Female\\\"],\\\"SingingVersions\\\":null,\\\"Instruments\\\":null}\",\"BaseGroupID\":6815073757028157452,\"ISRC\":\"\",\"UPC\":\"\",\"GroupID\":6875533669084170243,\"FullPlayURL\":\"https://sf5-hl-cdn-tos.douyinstatic.com/obj/tos-cn-ve-2774/013671b044d2479f8f8e2d6eb5e9549e\",\"FullDuration\":199},\"FingerprintType\":2,\"TrackID\":\"6874972841490515969\",\"Source\":\"cover_master\"}";
    }

    public final void n() {
        this.lyricInfo = "{\"LyricID\":6877725132089985026,\"LyricType\":3,\"LyricUrlInfo\":{\"Uri\":\"tos-cn-v-2774c002/39193955a5a642e19df578f540931a51\",\"Urls\":[\"https://sf5-hl-cdn-tos.douyinstatic.com/obj/tos-cn-v-2774c002/39193955a5a642e19df578f540931a51\",\"https://sf5-hl-ali-cdn-tos.douyinstatic.com/obj/tos-cn-v-2774c002/39193955a5a642e19df578f540931a51\",\"https://sf6-cdn-tos.douyinstatic.com/obj/tos-cn-v-2774c002/39193955a5a642e19df578f540931a51\"]}}";
    }

    public final void r() {
        this.songEmoTag = "{\"moods\":[\"Inspirational\",\"Memory\"],\"genres\":[\"Pop\",\"Chinese Pop\"]}";
    }

    public final String a() {
        return this.foldingInfo;
    }

    public final String b() {
        return this.fontInfo;
    }

    public final String c() {
        return this.lyricInfo;
    }

    public final List<MusicInterval> d() {
        return this.musicClimax;
    }

    public final Long e() {
        return this.sameGroupIdV3;
    }

    public final Long f() {
        return this.simGroupIdV3;
    }

    public final String g() {
        return this.songEmoTag;
    }

    public final int getType() {
        return this.type;
    }

    public final Long h() {
        return this.songId;
    }

    public final Boolean i() {
        return this.isFilter;
    }

    public final Boolean j() {
        return this.isNonVocal;
    }

    public j(am3.g r5) {
        this.musicClimax = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L18;
        switch(r2) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L6;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            case 11: goto L8;
            case 12: goto L7;
            default: goto L6;
        };
    L7:
        this.fontInfo = am3.h.c(r5);
        goto L3
    L8:
        this.isNonVocal = Boolean.valueOf(am3.h.a(r5));
        goto L3
    L9:
        this.isFilter = Boolean.valueOf(am3.h.a(r5));
        goto L3
    L10:
        this.simGroupIdV3 = Long.valueOf(r5.j());
        goto L3
    L11:
        this.sameGroupIdV3 = Long.valueOf(r5.j());
        goto L3
    L12:
        this.songEmoTag = am3.h.c(r5);
        goto L3
    L13:
        this.type = (int) r5.j();
        goto L3
    L14:
        this.musicClimax.add(new MusicInterval(r5));
        goto L3
    L15:
        this.lyricInfo = am3.h.c(r5);
        goto L3
    L16:
        this.foldingInfo = am3.h.c(r5);
        goto L3
    L17:
        this.songId = Long.valueOf(r5.j());
        goto L3
    L6:
        am3.h.e(r5);
        goto L3
    L18:
        r5.d(r0);
        if (this.songId != null) goto L22;
        this.songId = 0L;
    L22:
        if (this.foldingInfo != null) goto L25;
        this.foldingInfo = "";
    L25:
        if (this.lyricInfo != null) goto L28;
        this.lyricInfo = "";
    L28:
        if (this.isFilter != null) goto L31;
        this.isFilter = Boolean.FALSE;
    L31:
        if (this.isNonVocal != null) goto L60;
        this.isNonVocal = Boolean.FALSE;
        return;
    }

    public final void k(Boolean r1) {
        this.isFilter = r1;
    }

    public final void o(List<MusicInterval> r1) {
        this.musicClimax = r1;
    }

    public final void p(Long r1) {
        this.sameGroupIdV3 = r1;
    }

    public final void q(Long r1) {
        this.simGroupIdV3 = r1;
    }

    public final void s(Long r1) {
        this.songId = r1;
    }

    public final void t(int r1) {
        this.type = 2;
    }
}
