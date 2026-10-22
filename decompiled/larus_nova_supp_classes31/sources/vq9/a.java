package vq9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/larus/platform/model/mainbot/BlockRefactorConfig;", "", "enableSearchCotBlock", "", "enableTextBlock", "enableReplyTextLoadingBlock", "enableImageGroupBlock", "enableIgnoreTyping", "<init>", "(ZZZZZ)V", "getEnableSearchCotBlock", "()Z", "getEnableTextBlock", "getEnableReplyTextLoadingBlock", "getEnableImageGroupBlock", "getEnableIgnoreTyping", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class a {

    @SerializedName("enable_cot_ignore_typing")
    private final boolean enableIgnoreTyping;

    @SerializedName("enable_image_group_block")
    private final boolean enableImageGroupBlock;

    @SerializedName("enable_reply_text_loading_block")
    private final boolean enableReplyTextLoadingBlock;

    @SerializedName("enable_search_cot_block")
    private final boolean enableSearchCotBlock;

    @SerializedName("enable_text_block")
    private final boolean enableTextBlock;

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
        if (this.enableSearchCotBlock == r6.enableSearchCotBlock) goto L12;
        return false;
    L12:
        if (this.enableTextBlock == r6.enableTextBlock) goto L15;
        return false;
    L15:
        if (this.enableReplyTextLoadingBlock == r6.enableReplyTextLoadingBlock) goto L18;
        return false;
    L18:
        if (this.enableImageGroupBlock == r6.enableImageGroupBlock) goto L21;
        return false;
    L21:
        if (this.enableIgnoreTyping == r6.enableIgnoreTyping) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.enableSearchCotBlock == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.enableTextBlock == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.enableReplyTextLoadingBlock == false) goto L13;
        int r5 = 1231;
    L14:
        int r6 = (r4 + r5) * 31;
        if (this.enableImageGroupBlock == false) goto L17;
        int r7 = 1231;
    L18:
        int r8 = (r6 + r7) * 31;
        if (this.enableIgnoreTyping == true) goto L23;
        r1 = 1237;
    L23:
        return r8 + r1;
    L17:
        r7 = 1237;
        goto L18
    L13:
        r5 = 1237;
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "BlockRefactorConfig(enableSearchCotBlock=" + this.enableSearchCotBlock + ", enableTextBlock=" + this.enableTextBlock + ", enableReplyTextLoadingBlock=" + this.enableReplyTextLoadingBlock + ", enableImageGroupBlock=" + this.enableImageGroupBlock + ", enableIgnoreTyping=" + this.enableIgnoreTyping + ')';
    }

    public final boolean a() {
        return this.enableIgnoreTyping;
    }

    public final boolean b() {
        return this.enableImageGroupBlock;
    }

    public final boolean c() {
        return this.enableTextBlock;
    }

    public a(int r1) {
        this.enableSearchCotBlock = false;
        this.enableTextBlock = false;
        this.enableReplyTextLoadingBlock = false;
        this.enableImageGroupBlock = false;
        this.enableIgnoreTyping = true;
    }
}
