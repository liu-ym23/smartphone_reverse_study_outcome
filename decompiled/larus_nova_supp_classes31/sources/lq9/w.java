package lq9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/larus/platform/model/audio/RealtimeCallNewStyleConfig;", "", "newTitleBar", "", "showThinkingStatus", "useFlashlight", "floatVideoSubtitle", "scrollToBottomBtn", "<init>", "(ZZZZZ)V", "getNewTitleBar", "()Z", "getShowThinkingStatus", "getUseFlashlight", "getFloatVideoSubtitle", "getScrollToBottomBtn", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class w {

    @SerializedName("float_video_subtitle")
    private final boolean floatVideoSubtitle;

    @SerializedName("new_title_bar")
    private final boolean newTitleBar;

    @SerializedName("scroll_to_bottom_btn")
    private final boolean scrollToBottomBtn;

    @SerializedName("show_thinking_status")
    private final boolean showThinkingStatus;

    @SerializedName("use_flashlight")
    private final boolean useFlashlight;

    public w() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof w) == true) goto L8;
        return false;
    L8:
        w r6 = (w) r5;
        if (this.newTitleBar == r6.newTitleBar) goto L12;
        return false;
    L12:
        if (this.showThinkingStatus == r6.showThinkingStatus) goto L15;
        return false;
    L15:
        if (this.useFlashlight == r6.useFlashlight) goto L18;
        return false;
    L18:
        if (this.floatVideoSubtitle == r6.floatVideoSubtitle) goto L21;
        return false;
    L21:
        if (this.scrollToBottomBtn == r6.scrollToBottomBtn) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.newTitleBar == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.showThinkingStatus == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.useFlashlight == false) goto L13;
        int r5 = 1231;
    L14:
        int r6 = (r4 + r5) * 31;
        if (this.floatVideoSubtitle == false) goto L17;
        int r7 = 1231;
    L18:
        int r8 = (r6 + r7) * 31;
        if (this.scrollToBottomBtn == true) goto L23;
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
        return "RealtimeCallNewStyleConfig(newTitleBar=" + this.newTitleBar + ", showThinkingStatus=" + this.showThinkingStatus + ", useFlashlight=" + this.useFlashlight + ", floatVideoSubtitle=" + this.floatVideoSubtitle + ", scrollToBottomBtn=" + this.scrollToBottomBtn + ')';
    }

    public final boolean a() {
        return this.floatVideoSubtitle;
    }

    public final boolean b() {
        return this.newTitleBar;
    }

    public final boolean c() {
        return this.scrollToBottomBtn;
    }

    public final boolean d() {
        return this.showThinkingStatus;
    }

    public final boolean e() {
        return this.useFlashlight;
    }

    public /* synthetic */ w(int r7) {
        this(false, false, false, false, false);
    }

    public w(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5) {
        this.newTitleBar = r1;
        this.showThinkingStatus = r2;
        this.useFlashlight = r3;
        this.floatVideoSubtitle = r4;
        this.scrollToBottomBtn = r5;
    }
}
