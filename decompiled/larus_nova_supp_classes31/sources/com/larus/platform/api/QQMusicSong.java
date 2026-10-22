package com.larus.platform.api;

import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b,\b\u0087\b\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010,\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00103\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010&J\u0010\u00104\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010&J\u0010\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00106\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010&J°\u0001\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u00108J\u0013\u00109\u001a\u00020\u00112\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020\u0005HÖ\u0001J\t\u0010<\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b%\u0010\u001aR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010'\u001a\u0004\b\u0010\u0010&R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010'\u001a\u0004\b\u0012\u0010&R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b(\u0010\u001aR\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010'\u001a\u0004\b)\u0010&¨\u0006="}, d2 = {"Lcom/larus/platform/api/QQMusicSong;", "", "album", "Lcom/larus/platform/api/QQMusicAlbum;", "duration", "", "genre", "", "id", "labelIdList", "", "mid", "singer", "Lcom/larus/platform/api/QQMusicSinger;", "title", "type", "isAudition", "", "isOrigin", "vipState", "hasCopyRight", "<init>", "(Lcom/larus/platform/api/QQMusicAlbum;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/larus/platform/api/QQMusicSinger;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getAlbum", "()Lcom/larus/platform/api/QQMusicAlbum;", "getDuration", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getGenre", "()Ljava/lang/String;", "getId", "getLabelIdList", "()Ljava/util/List;", "getMid", "getSinger", "()Lcom/larus/platform/api/QQMusicSinger;", "getTitle", "getType", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getVipState", "getHasCopyRight", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Lcom/larus/platform/api/QQMusicAlbum;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/larus/platform/api/QQMusicSinger;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/larus/platform/api/QQMusicSong;", "equals", "other", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class QQMusicSong {
    private final QQMusicAlbum album;
    private final Integer duration;
    private final String genre;
    private final Boolean hasCopyRight;
    private final String id;
    private final Boolean isAudition;
    private final Boolean isOrigin;
    private final List<Integer> labelIdList;
    private final String mid;
    private final QQMusicSinger singer;
    private final String title;
    private final Integer type;
    private final Integer vipState;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QQMusicSong copy$default(QQMusicSong r14, QQMusicAlbum r15, Integer r16, String r17, String r18, List r19, String r20, QQMusicSinger r21, String r22, Integer r23, Boolean r24, Boolean r25, Integer r26, Boolean r27, int r28, Object r29) {
        if ((r28 & 1) == 0) goto L5;
        QQMusicAlbum r2 = r14.album;
    L7:
        if ((r28 & 2) == 0) goto L9;
        Integer r3 = r14.duration;
    L11:
        if ((r28 & 4) == 0) goto L13;
        String r4 = r14.genre;
    L15:
        if ((r28 & 8) == 0) goto L17;
        String r5 = r14.id;
    L19:
        if ((r28 & 16) == 0) goto L21;
        List r6 = r14.labelIdList;
    L23:
        if ((r28 & 32) == 0) goto L25;
        String r7 = r14.mid;
    L27:
        if ((r28 & 64) == 0) goto L29;
        QQMusicSinger r8 = r14.singer;
    L31:
        if ((r28 & 128) == 0) goto L33;
        String r9 = r14.title;
    L35:
        if ((r28 & 256) == 0) goto L37;
        Integer r10 = r14.type;
    L39:
        if ((r28 & 512) == 0) goto L41;
        Boolean r11 = r14.isAudition;
    L43:
        if ((r28 & 1024) == 0) goto L45;
        Boolean r12 = r14.isOrigin;
    L47:
        if ((r28 & 2048) == 0) goto L49;
        Integer r13 = r14.vipState;
    L51:
        if ((r28 & 4096) == 0) goto L53;
        Boolean r1 = r14.hasCopyRight;
    L55:
        return r14.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r1);
    L53:
        r1 = r27;
        goto L55
    L49:
        r13 = r26;
        goto L51
    L45:
        r12 = r25;
        goto L47
    L41:
        r11 = r24;
        goto L43
    L37:
        r10 = r23;
        goto L39
    L33:
        r9 = r22;
        goto L35
    L29:
        r8 = r21;
        goto L31
    L25:
        r7 = r20;
        goto L27
    L21:
        r6 = r19;
        goto L23
    L17:
        r5 = r18;
        goto L19
    L13:
        r4 = r17;
        goto L15
    L9:
        r3 = r16;
        goto L11
    L5:
        r2 = r15;
        goto L7
    }

    public final QQMusicAlbum component1() {
        return this.album;
    }

    public final Boolean component10() {
        return this.isAudition;
    }

    public final Boolean component11() {
        return this.isOrigin;
    }

    public final Integer component12() {
        return this.vipState;
    }

    public final Boolean component13() {
        return this.hasCopyRight;
    }

    public final Integer component2() {
        return this.duration;
    }

    public final String component3() {
        return this.genre;
    }

    public final String component4() {
        return this.id;
    }

    public final List<Integer> component5() {
        return this.labelIdList;
    }

    public final String component6() {
        return this.mid;
    }

    public final QQMusicSinger component7() {
        return this.singer;
    }

    public final String component8() {
        return this.title;
    }

    public final Integer component9() {
        return this.type;
    }

    public final QQMusicSong copy(QQMusicAlbum r16, Integer r17, String r18, String r19, List<Integer> r20, String r21, QQMusicSinger r22, String r23, Integer r24, Boolean r25, Boolean r26, Integer r27, Boolean r28) {
        return new QQMusicSong(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof QQMusicSong) == true) goto L8;
        return false;
    L8:
        QQMusicSong r6 = (QQMusicSong) r5;
        if (Intrinsics.areEqual(this.album, r6.album) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.duration, r6.duration) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.genre, r6.genre) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.labelIdList, r6.labelIdList) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.mid, r6.mid) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.singer, r6.singer) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.type, r6.type) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.isAudition, r6.isAudition) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.isOrigin, r6.isOrigin) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.vipState, r6.vipState) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.hasCopyRight, r6.hasCopyRight) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public int hashCode() {
        QQMusicAlbum r0 = this.album;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.duration;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.genre;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.id;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        List<Integer> r13 = this.labelIdList;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.mid;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        QQMusicSinger r19 = this.singer;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.title;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Integer r25 = this.type;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Boolean r28 = this.isAudition;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        Boolean r31 = this.isOrigin;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        Integer r34 = this.vipState;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        Boolean r37 = this.hasCopyRight;
        if (r37 == null) goto L55;
        r1 = r37.hashCode();
    L55:
        return r36 + r1;
    L49:
        r35 = r34.hashCode();
        goto L50
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "QQMusicSong(album=" + this.album + ", duration=" + this.duration + ", genre=" + this.genre + ", id=" + this.id + ", labelIdList=" + this.labelIdList + ", mid=" + this.mid + ", singer=" + this.singer + ", title=" + this.title + ", type=" + this.type + ", isAudition=" + this.isAudition + ", isOrigin=" + this.isOrigin + ", vipState=" + this.vipState + ", hasCopyRight=" + this.hasCopyRight + ')';
    }

    public final QQMusicAlbum getAlbum() {
        return this.album;
    }

    public final Integer getDuration() {
        return this.duration;
    }

    public final String getGenre() {
        return this.genre;
    }

    public final Boolean getHasCopyRight() {
        return this.hasCopyRight;
    }

    public final String getId() {
        return this.id;
    }

    public final List<Integer> getLabelIdList() {
        return this.labelIdList;
    }

    public final String getMid() {
        return this.mid;
    }

    public final QQMusicSinger getSinger() {
        return this.singer;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Integer getType() {
        return this.type;
    }

    public final Integer getVipState() {
        return this.vipState;
    }

    public final Boolean isAudition() {
        return this.isAudition;
    }

    public final Boolean isOrigin() {
        return this.isOrigin;
    }

    public QQMusicSong(QQMusicAlbum r1, Integer r2, String r3, String r4, List<Integer> r5, String r6, QQMusicSinger r7, String r8, Integer r9, Boolean r10, Boolean r11, Integer r12, Boolean r13) {
        this.album = r1;
        this.duration = r2;
        this.genre = r3;
        this.id = r4;
        this.labelIdList = r5;
        this.mid = r6;
        this.singer = r7;
        this.title = r8;
        this.type = r9;
        this.isAudition = r10;
        this.isOrigin = r11;
        this.vipState = r12;
        this.hasCopyRight = r13;
    }
}
