package com.larus.bmhome.chat.search;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.video.Content;
import com.larus.im.bean.message.SearchImageInfo;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0004/012BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u000bHÆ\u0003JE\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020.HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u00063"}, d2 = {"Lcom/larus/bmhome/chat/search/SearchResult;", "", "videoCard", "Lcom/larus/bmhome/chat/search/SearchResult$VideoCard;", "textCard", "Lcom/larus/bmhome/chat/search/SearchResult$TextCard;", "imageCard", "Lcom/larus/bmhome/chat/search/SearchResult$ImageCard;", "mixedMediaCard", "Lcom/larus/bmhome/chat/search/SearchResult$MixedMediaCard;", "cardParam", "Lcom/larus/bmhome/chat/search/CardParam;", "<init>", "(Lcom/larus/bmhome/chat/search/SearchResult$VideoCard;Lcom/larus/bmhome/chat/search/SearchResult$TextCard;Lcom/larus/bmhome/chat/search/SearchResult$ImageCard;Lcom/larus/bmhome/chat/search/SearchResult$MixedMediaCard;Lcom/larus/bmhome/chat/search/CardParam;)V", "getVideoCard", "()Lcom/larus/bmhome/chat/search/SearchResult$VideoCard;", "setVideoCard", "(Lcom/larus/bmhome/chat/search/SearchResult$VideoCard;)V", "getTextCard", "()Lcom/larus/bmhome/chat/search/SearchResult$TextCard;", "setTextCard", "(Lcom/larus/bmhome/chat/search/SearchResult$TextCard;)V", "getImageCard", "()Lcom/larus/bmhome/chat/search/SearchResult$ImageCard;", "setImageCard", "(Lcom/larus/bmhome/chat/search/SearchResult$ImageCard;)V", "getMixedMediaCard", "()Lcom/larus/bmhome/chat/search/SearchResult$MixedMediaCard;", "setMixedMediaCard", "(Lcom/larus/bmhome/chat/search/SearchResult$MixedMediaCard;)V", "getCardParam", "()Lcom/larus/bmhome/chat/search/CardParam;", "setCardParam", "(Lcom/larus/bmhome/chat/search/CardParam;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "VideoCard", "TextCard", "ImageCard", "MixedMediaCard", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class b {

    @SerializedName("card_params")
    private oi8.c cardParam;

    @SerializedName("image_card")
    private a imageCard;

    @SerializedName("mixed_media_card")
    private C0073b mixedMediaCard;

    @SerializedName("text_card")
    private c textCard;

    @SerializedName("video_card")
    private d videoCard;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\u000b\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R&\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/chat/search/SearchResult$ImageCard;", "", "cardList", "", "Lcom/larus/im/bean/message/SearchImageInfo;", "<init>", "(Ljava/util/List;)V", "getCardList", "()Ljava/util/List;", "setCardList", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class a {

        @SerializedName("card_list")
        @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
        private List<SearchImageInfo> cardList;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.cardList, ((a) r4).cardList) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            List<SearchImageInfo> r0 = this.cardList;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "ImageCard(cardList=" + this.cardList + ')';
        }

        public a() {
            this.cardList = null;
        }

        public final List<SearchImageInfo> a() {
            return this.cardList;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.search.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\u000b\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R&\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/chat/search/SearchResult$MixedMediaCard;", "", "cardList", "", "Lcom/larus/bmhome/video/Content;", "<init>", "(Ljava/util/List;)V", "getCardList", "()Ljava/util/List;", "setCardList", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class C0073b {

        @SerializedName("card_list")
        @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
        private List<Content> cardList;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0073b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.cardList, ((C0073b) r4).cardList) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            List<Content> r0 = this.cardList;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "MixedMediaCard(cardList=" + this.cardList + ')';
        }

        public C0073b() {
            this.cardList = null;
        }

        public final List<Content> a() {
            return this.cardList;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\u000b\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R&\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/chat/search/SearchResult$TextCard;", "", "cardList", "", "Lcom/larus/bmhome/chat/search/ArticleInfo;", "<init>", "(Ljava/util/List;)V", "getCardList", "()Ljava/util/List;", "setCardList", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class c {

        @SerializedName("card_list")
        @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
        private List<ArticleInfo> cardList;

        public c() {
            this(null);
        }

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.cardList, ((c) r4).cardList) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            List<ArticleInfo> r0 = this.cardList;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "TextCard(cardList=" + this.cardList + ')';
        }

        public final List<ArticleInfo> a() {
            return this.cardList;
        }

        public c(List<ArticleInfo> r1) {
            this.cardList = r1;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\u000b\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R&\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/chat/search/SearchResult$VideoCard;", "", "cardList", "", "Lcom/larus/bmhome/chat/search/VideoInfo;", "<init>", "(Ljava/util/List;)V", "getCardList", "()Ljava/util/List;", "setCardList", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class d {

        @SerializedName("card_list")
        @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
        private List<VideoInfo> cardList;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.cardList, ((d) r4).cardList) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            List<VideoInfo> r0 = this.cardList;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "VideoCard(cardList=" + this.cardList + ')';
        }

        public d() {
            this.cardList = null;
        }

        public final List<VideoInfo> a() {
            return this.cardList;
        }
    }

    public b() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.videoCard, r6.videoCard) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.textCard, r6.textCard) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.imageCard, r6.imageCard) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.mixedMediaCard, r6.mixedMediaCard) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.cardParam, r6.cardParam) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        d r0 = this.videoCard;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        c r4 = this.textCard;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        a r7 = this.imageCard;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        C0073b r10 = this.mixedMediaCard;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        oi8.c r13 = this.cardParam;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
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

    public final String toString() {
        return "SearchResult(videoCard=" + this.videoCard + ", textCard=" + this.textCard + ", imageCard=" + this.imageCard + ", mixedMediaCard=" + this.mixedMediaCard + ", cardParam=" + this.cardParam + ')';
    }

    public final oi8.c b() {
        return this.cardParam;
    }

    public final a c() {
        return this.imageCard;
    }

    public final C0073b d() {
        return this.mixedMediaCard;
    }

    public final c e() {
        return this.textCard;
    }

    public final d f() {
        return this.videoCard;
    }

    public /* synthetic */ b(int r7) {
        this(null, null, null, null, null);
    }

    public final void g(oi8.c r1) {
        this.cardParam = r1;
    }

    public static b a(b r8, c r9, int r10) {
        oi8.c r1 = null;
        if ((r10 & 1) == 0) goto L5;
        d r3 = r8.videoCard;
    L7:
        if ((r10 & 2) == 0) goto L9;
        r9 = r8.textCard;
    L9:
        c r4 = r9;
        if ((r10 & 4) == 0) goto L12;
        a r5 = r8.imageCard;
    L14:
        if ((r10 & 8) == 0) goto L16;
        C0073b r6 = r8.mixedMediaCard;
    L18:
        if ((r10 & 16) == 0) goto L21;
        r1 = r8.cardParam;
    L21:
        return new b(r3, r4, r5, r6, r1);
    L16:
        r6 = null;
        goto L18
    L12:
        r5 = null;
        goto L14
    L5:
        r3 = null;
        goto L7
    }

    public b(d r1, c r2, a r3, C0073b r4, oi8.c r5) {
        this.videoCard = r1;
        this.textCard = r2;
        this.imageCard = r3;
        this.mixedMediaCard = r4;
        this.cardParam = r5;
    }
}
