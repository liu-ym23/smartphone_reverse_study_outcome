package sq9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003JG\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/larus/platform/model/creation/CreationDetailLayoutConfig;", "", "experimentGroup", "", "layoutDirection", "showPlusButton", "", "albumAttachAppendRawImage", "publishInSharePanel", "toolPresentationBySource", "Lcom/larus/platform/model/creation/ToolPresentationBySource;", "<init>", "(IIZZZLcom/larus/platform/model/creation/ToolPresentationBySource;)V", "getExperimentGroup", "()I", "getLayoutDirection", "getShowPlusButton", "()Z", "getAlbumAttachAppendRawImage", "getPublishInSharePanel", "getToolPresentationBySource", "()Lcom/larus/platform/model/creation/ToolPresentationBySource;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class e {

    @SerializedName("albumAttachAppendRawImage")
    private final boolean albumAttachAppendRawImage;

    @SerializedName("experimentGroup")
    private final int experimentGroup;

    @SerializedName("layoutDirection")
    private final int layoutDirection;

    @SerializedName("isPublishInSharePanel")
    private final boolean publishInSharePanel;

    @SerializedName("showPlusButton")
    private final boolean showPlusButton;

    @SerializedName("toolPresentationBySource")
    private final z toolPresentationBySource;

    public e() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (this.experimentGroup == r6.experimentGroup) goto L12;
        return false;
    L12:
        if (this.layoutDirection == r6.layoutDirection) goto L15;
        return false;
    L15:
        if (this.showPlusButton == r6.showPlusButton) goto L18;
        return false;
    L18:
        if (this.albumAttachAppendRawImage == r6.albumAttachAppendRawImage) goto L21;
        return false;
    L21:
        if (this.publishInSharePanel == r6.publishInSharePanel) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.toolPresentationBySource, r6.toolPresentationBySource) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.experimentGroup * 31) + this.layoutDirection) * 31;
        int r2 = 1231;
        if (this.showPlusButton == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.albumAttachAppendRawImage == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.publishInSharePanel == true) goto L14;
        r2 = 1237;
    L14:
        int r6 = (r5 + r2) * 31;
        z r7 = this.toolPresentationBySource;
        if (r7 != null) goto L17;
        int r8 = 0;
    L19:
        return r6 + r8;
    L17:
        r8 = r7.hashCode();
        goto L19
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "CreationDetailLayoutConfig(experimentGroup=" + this.experimentGroup + ", layoutDirection=" + this.layoutDirection + ", showPlusButton=" + this.showPlusButton + ", albumAttachAppendRawImage=" + this.albumAttachAppendRawImage + ", publishInSharePanel=" + this.publishInSharePanel + ", toolPresentationBySource=" + this.toolPresentationBySource + ')';
    }

    public final boolean b() {
        return this.albumAttachAppendRawImage;
    }

    public final int c() {
        return this.experimentGroup;
    }

    public final int d() {
        return this.layoutDirection;
    }

    public final boolean e() {
        return this.publishInSharePanel;
    }

    public final boolean f() {
        return this.showPlusButton;
    }

    public final z g() {
        return this.toolPresentationBySource;
    }

    public /* synthetic */ e(int r8) {
        this(0, 0, false, false, false, null);
    }

    public static e a(e r7) {
        return new e(0, r7.layoutDirection, r7.showPlusButton, r7.albumAttachAppendRawImage, r7.publishInSharePanel, r7.toolPresentationBySource);
    }

    public e(int r1, int r2, boolean r3, boolean r4, boolean r5, z r6) {
        this.experimentGroup = r1;
        this.layoutDirection = r2;
        this.showPlusButton = r3;
        this.albumAttachAppendRawImage = r4;
        this.publishInSharePanel = r5;
        this.toolPresentationBySource = r6;
    }
}
