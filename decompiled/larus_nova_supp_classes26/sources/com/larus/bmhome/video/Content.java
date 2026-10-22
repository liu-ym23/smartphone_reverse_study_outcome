package com.larus.bmhome.video;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.im.bean.message.ItemData;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001Bé\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\n\u0010B\u001a\u0004\u0018\u00010\u0003H\u0016J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010J\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010K\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0017\u0010O\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010Q\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010S\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\t\u0010U\u001a\u00020\u001aHÆ\u0003J\u0010\u0010V\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jð\u0001\u0010X\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010YJ\u0013\u0010Z\u001a\u00020\u001a2\b\u0010[\u001a\u0004\u0018\u00010\\HÖ\u0003J\t\u0010]\u001a\u00020\u0005HÖ\u0001J\t\u0010^\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b$\u0010\"R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b%\u0010\"R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R$\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010 R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b1\u0010\"R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010 R\u001f\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b3\u0010/R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b<\u0010\"\"\u0004\b=\u0010>R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010 \"\u0004\b@\u0010AR\u0014\u0010C\u001a\u00020DX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010F¨\u0006_"}, d2 = {"Lcom/larus/bmhome/video/Content;", "Lcom/larus/im/bean/message/ItemData;", "itemId", "", "itemType", "", MusicAppletPage.KEY_SOURCE, "status", "authorInfo", "Lcom/larus/bmhome/video/AuthorInfo;", "cover", "Lcom/larus/bmhome/video/ContentCover;", "contentDescription", "Lcom/larus/bmhome/video/ContentDescription;", "interactInfo", "Lcom/larus/bmhome/video/InteractInfo;", "extra", "", "requestId", "recChannelId", "searchId", "clientExt", "", "ratioStrategy", "Lcom/larus/bmhome/video/CardRatioStrategy;", "hasExposed", "", "imprIndex", "bizTag", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/bmhome/video/AuthorInfo;Lcom/larus/bmhome/video/ContentCover;Lcom/larus/bmhome/video/ContentDescription;Lcom/larus/bmhome/video/InteractInfo;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;Lcom/larus/bmhome/video/CardRatioStrategy;ZLjava/lang/Integer;Ljava/lang/String;)V", "getItemId", "()Ljava/lang/String;", "getItemType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSource", "getStatus", "getAuthorInfo", "()Lcom/larus/bmhome/video/AuthorInfo;", "getCover", "()Lcom/larus/bmhome/video/ContentCover;", "getContentDescription", "()Lcom/larus/bmhome/video/ContentDescription;", "getInteractInfo", "()Lcom/larus/bmhome/video/InteractInfo;", "getExtra", "()Ljava/util/Map;", "getRequestId", "getRecChannelId", "getSearchId", "getClientExt", "getRatioStrategy", "()Lcom/larus/bmhome/video/CardRatioStrategy;", "setRatioStrategy", "(Lcom/larus/bmhome/video/CardRatioStrategy;)V", "getHasExposed", "()Z", "setHasExposed", "(Z)V", "getImprIndex", "setImprIndex", "(Ljava/lang/Integer;)V", "getBizTag", "setBizTag", "(Ljava/lang/String;)V", "getId", "searchItemType", "Lcom/larus/im/bean/message/ItemType;", "getSearchItemType", "()Lcom/larus/im/bean/message/ItemType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/bmhome/video/AuthorInfo;Lcom/larus/bmhome/video/ContentCover;Lcom/larus/bmhome/video/ContentDescription;Lcom/larus/bmhome/video/InteractInfo;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;Lcom/larus/bmhome/video/CardRatioStrategy;ZLjava/lang/Integer;Ljava/lang/String;)Lcom/larus/bmhome/video/Content;", "equals", "other", "", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Content extends ItemData {

    @SerializedName("author_info")
    private final AuthorInfo authorInfo;
    private transient String bizTag;
    private final transient Map<String, String> clientExt;

    @SerializedName("content_description")
    private final ContentDescription contentDescription;

    @SerializedName("cover")
    private final ContentCover cover;

    @SerializedName("extra")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final Map<String, String> extra;
    private transient boolean hasExposed;
    private transient Integer imprIndex;

    @SerializedName("interaction_info")
    private final InteractInfo interactInfo;

    @SerializedName("item_id")
    private final String itemId;

    @SerializedName("item_type")
    private final Integer itemType;
    private transient CardRatioStrategy ratioStrategy;

    @SerializedName("rec_channel_id")
    private final Integer recChannelId;

    @SerializedName("request_id")
    private final String requestId;

    @SerializedName("search_id")
    private final String searchId;
    private final transient com.larus.im.bean.message.ItemType searchItemType;

    @SerializedName(MusicAppletPage.KEY_SOURCE)
    private final Integer source;

    @SerializedName("status")
    private final Integer status;

    public Content() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, 131071, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Content copy$default(Content r17, String r18, Integer r19, Integer r20, Integer r21, AuthorInfo r22, ContentCover r23, ContentDescription r24, InteractInfo r25, Map r26, String r27, Integer r28, String r29, Map r30, CardRatioStrategy r31, boolean r32, Integer r33, String r34, int r35, Object r36) {
        if ((r35 & 1) == 0) goto L5;
        String r2 = r17.itemId;
    L7:
        if ((r35 & 2) == 0) goto L9;
        Integer r3 = r17.itemType;
    L11:
        if ((r35 & 4) == 0) goto L13;
        Integer r4 = r17.source;
    L15:
        if ((r35 & 8) == 0) goto L17;
        Integer r5 = r17.status;
    L19:
        if ((r35 & 16) == 0) goto L21;
        AuthorInfo r6 = r17.authorInfo;
    L23:
        if ((r35 & 32) == 0) goto L25;
        ContentCover r7 = r17.cover;
    L27:
        if ((r35 & 64) == 0) goto L29;
        ContentDescription r8 = r17.contentDescription;
    L31:
        if ((r35 & 128) == 0) goto L33;
        InteractInfo r9 = r17.interactInfo;
    L35:
        if ((r35 & 256) == 0) goto L37;
        Map r10 = r17.extra;
    L39:
        if ((r35 & 512) == 0) goto L41;
        String r11 = r17.requestId;
    L43:
        if ((r35 & 1024) == 0) goto L45;
        Integer r12 = r17.recChannelId;
    L47:
        if ((r35 & 2048) == 0) goto L49;
        String r13 = r17.searchId;
    L51:
        if ((r35 & 4096) == 0) goto L53;
        Map r14 = r17.clientExt;
    L55:
        if ((r35 & 8192) == 0) goto L57;
        CardRatioStrategy r15 = r17.ratioStrategy;
    L58:
        CardRatioStrategy r37 = r15;
        if ((r35 & 16384) == 0) goto L61;
        boolean r16 = r17.hasExposed;
    L62:
        boolean r38 = r16;
        if ((r35 & 32768) == 0) goto L65;
        Integer r110 = r17.imprIndex;
    L67:
        if ((r35 & 65536) == 0) goto L69;
        String r1 = r17.bizTag;
    L71:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r37, r38, r110, r1);
    L69:
        r1 = r34;
        goto L71
    L65:
        r110 = r33;
        goto L67
    L61:
        r16 = r32;
        goto L62
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final String component1() {
        return this.itemId;
    }

    public final String component10() {
        return this.requestId;
    }

    public final Integer component11() {
        return this.recChannelId;
    }

    public final String component12() {
        return this.searchId;
    }

    public final Map<String, String> component13() {
        return this.clientExt;
    }

    public final CardRatioStrategy component14() {
        return this.ratioStrategy;
    }

    public final boolean component15() {
        return this.hasExposed;
    }

    public final Integer component16() {
        return this.imprIndex;
    }

    public final String component17() {
        return this.bizTag;
    }

    public final Integer component2() {
        return this.itemType;
    }

    public final Integer component3() {
        return this.source;
    }

    public final Integer component4() {
        return this.status;
    }

    public final AuthorInfo component5() {
        return this.authorInfo;
    }

    public final ContentCover component6() {
        return this.cover;
    }

    public final ContentDescription component7() {
        return this.contentDescription;
    }

    public final InteractInfo component8() {
        return this.interactInfo;
    }

    public final Map<String, String> component9() {
        return this.extra;
    }

    public final Content copy(String r20, Integer r21, Integer r22, Integer r23, AuthorInfo r24, ContentCover r25, ContentDescription r26, InteractInfo r27, Map<String, String> r28, String r29, Integer r30, String r31, Map<String, String> r32, CardRatioStrategy r33, boolean r34, Integer r35, String r36) {
        return new Content(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Content) == true) goto L8;
        return false;
    L8:
        Content r6 = (Content) r5;
        if (Intrinsics.areEqual(this.itemId, r6.itemId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.itemType, r6.itemType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.source, r6.source) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.status, r6.status) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.authorInfo, r6.authorInfo) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.cover, r6.cover) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.contentDescription, r6.contentDescription) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.interactInfo, r6.interactInfo) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.extra, r6.extra) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.requestId, r6.requestId) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.recChannelId, r6.recChannelId) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.searchId, r6.searchId) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.clientExt, r6.clientExt) == true) goto L48;
        return false;
    L48:
        if (this.ratioStrategy == r6.ratioStrategy) goto L51;
        return false;
    L51:
        if (this.hasExposed == r6.hasExposed) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.imprIndex, r6.imprIndex) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.bizTag, r6.bizTag) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public int hashCode() {
        String r0 = this.itemId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.itemType;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.source;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.status;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        AuthorInfo r13 = this.authorInfo;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        ContentCover r16 = this.cover;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        ContentDescription r19 = this.contentDescription;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        InteractInfo r22 = this.interactInfo;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Map<String, String> r25 = this.extra;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.requestId;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        Integer r31 = this.recChannelId;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.searchId;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        Map<String, String> r37 = this.clientExt;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        CardRatioStrategy r40 = this.ratioStrategy;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        if (this.hasExposed == false) goto L61;
        int r43 = 1231;
    L62:
        int r44 = (r42 + r43) * 31;
        Integer r45 = this.imprIndex;
        if (r45 != null) goto L65;
        int r46 = 0;
    L66:
        int r47 = (r44 + r46) * 31;
        String r48 = this.bizTag;
        if (r48 == null) goto L71;
        r1 = r48.hashCode();
    L71:
        return r47 + r1;
    L65:
        r46 = r45.hashCode();
        goto L66
    L61:
        r43 = 1237;
        goto L62
    L57:
        r41 = r40.hashCode();
        goto L58
    L53:
        r38 = r37.hashCode();
        goto L54
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
        return "Content(itemId=" + this.itemId + ", itemType=" + this.itemType + ", source=" + this.source + ", status=" + this.status + ", authorInfo=" + this.authorInfo + ", cover=" + this.cover + ", contentDescription=" + this.contentDescription + ", interactInfo=" + this.interactInfo + ", extra=" + this.extra + ", requestId=" + this.requestId + ", recChannelId=" + this.recChannelId + ", searchId=" + this.searchId + ", clientExt=" + this.clientExt + ", ratioStrategy=" + this.ratioStrategy + ", hasExposed=" + this.hasExposed + ", imprIndex=" + this.imprIndex + ", bizTag=" + this.bizTag + ')';
    }

    public final AuthorInfo getAuthorInfo() {
        return this.authorInfo;
    }

    public final String getBizTag() {
        return this.bizTag;
    }

    public final Map<String, String> getClientExt() {
        return this.clientExt;
    }

    public final ContentDescription getContentDescription() {
        return this.contentDescription;
    }

    public final ContentCover getCover() {
        return this.cover;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final boolean getHasExposed() {
        return this.hasExposed;
    }

    public String getId() {
        return this.itemId;
    }

    public final Integer getImprIndex() {
        return this.imprIndex;
    }

    public final InteractInfo getInteractInfo() {
        return this.interactInfo;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final Integer getItemType() {
        return this.itemType;
    }

    public final CardRatioStrategy getRatioStrategy() {
        return this.ratioStrategy;
    }

    public final Integer getRecChannelId() {
        return this.recChannelId;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public String getSearchId() {
        return this.searchId;
    }

    public com.larus.im.bean.message.ItemType getSearchItemType() {
        return this.searchItemType;
    }

    public final Integer getSource() {
        return this.source;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final void setBizTag(String r1) {
        this.bizTag = r1;
    }

    public final void setHasExposed(boolean r1) {
        this.hasExposed = r1;
    }

    public final void setImprIndex(Integer r1) {
        this.imprIndex = r1;
    }

    public final void setRatioStrategy(CardRatioStrategy r1) {
        this.ratioStrategy = r1;
    }

    public Content(String r3, Integer r4, Integer r5, Integer r6, AuthorInfo r7, ContentCover r8, ContentDescription r9, InteractInfo r10, Map<String, String> r11, String r12, Integer r13, String r14, Map<String, String> r15, CardRatioStrategy r16, boolean r17, Integer r18, String r19) {
        this.itemId = r3;
        this.itemType = r4;
        this.source = r5;
        this.status = r6;
        this.authorInfo = r7;
        this.cover = r8;
        this.contentDescription = r9;
        this.interactInfo = r10;
        this.extra = r11;
        this.requestId = r12;
        this.recChannelId = r13;
        this.searchId = r14;
        this.clientExt = r15;
        this.ratioStrategy = r16;
        this.hasExposed = r17;
        this.imprIndex = r18;
        this.bizTag = r19;
        this.searchItemType = com.larus.im.bean.message.ItemType.TYPE_CARD_MIXED_MEDIA;
    }

    public /* synthetic */ Content(String r19, Integer r20, Integer r21, Integer r22, AuthorInfo r23, ContentCover r24, ContentDescription r25, InteractInfo r26, Map r27, String r28, Integer r29, String r30, Map r31, CardRatioStrategy r32, boolean r33, Integer r34, String r35, int r36, DefaultConstructorMarker r37) {
        if ((r36 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r36 & 2) == 0) goto L9;
        Integer r3 = null;
    L11:
        if ((r36 & 4) == 0) goto L13;
        Integer r4 = null;
    L15:
        if ((r36 & 8) == 0) goto L17;
        Integer r5 = null;
    L19:
        if ((r36 & 16) == 0) goto L21;
        AuthorInfo r6 = null;
    L23:
        if ((r36 & 32) == 0) goto L25;
        ContentCover r7 = null;
    L27:
        if ((r36 & 64) == 0) goto L29;
        ContentDescription r8 = null;
    L31:
        if ((r36 & 128) == 0) goto L33;
        InteractInfo r9 = null;
    L35:
        if ((r36 & 256) == 0) goto L37;
        Map r10 = null;
    L39:
        if ((r36 & 512) == 0) goto L41;
        String r11 = null;
    L43:
        if ((r36 & 1024) == 0) goto L45;
        Integer r12 = null;
    L47:
        if ((r36 & 2048) == 0) goto L49;
        String r13 = null;
    L51:
        if ((r36 & 4096) == 0) goto L53;
        Map r14 = null;
    L55:
        if ((r36 & 8192) == 0) goto L57;
        CardRatioStrategy r15 = null;
    L59:
        if ((r36 & 16384) == 0) goto L61;
        boolean r2 = false;
    L63:
        if ((r36 & 32768) == 0) goto L65;
        Integer r16 = null;
    L67:
        if ((r36 & 65536) == 0) goto L69;
        String r0 = null;
    L70:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r16, r0);
        return;
    L69:
        r0 = r35;
        goto L70
    L65:
        r16 = r34;
        goto L67
    L61:
        r2 = r33;
        goto L63
    L57:
        r15 = r32;
        goto L59
    L53:
        r14 = r31;
        goto L55
    L49:
        r13 = r30;
        goto L51
    L45:
        r12 = r29;
        goto L47
    L41:
        r11 = r28;
        goto L43
    L37:
        r10 = r27;
        goto L39
    L33:
        r9 = r26;
        goto L35
    L29:
        r8 = r25;
        goto L31
    L25:
        r7 = r24;
        goto L27
    L21:
        r6 = r23;
        goto L23
    L17:
        r5 = r22;
        goto L19
    L13:
        r4 = r21;
        goto L15
    L9:
        r3 = r20;
        goto L11
    L5:
        r1 = r19;
        goto L7
    }
}
