package du9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/larus/settings/provider/chat/NewPreviewTotalConfig;", "", "sendImageConfig", "Lcom/larus/settings/provider/chat/ChatSendPreviewConfig;", "creationImageConfig", "Lcom/larus/settings/provider/chat/CreationPreviewConfig;", "previewPageConfig", "Lcom/larus/settings/provider/chat/PreviewPageConfig;", "<init>", "(Lcom/larus/settings/provider/chat/ChatSendPreviewConfig;Lcom/larus/settings/provider/chat/CreationPreviewConfig;Lcom/larus/settings/provider/chat/PreviewPageConfig;)V", "getSendImageConfig", "()Lcom/larus/settings/provider/chat/ChatSendPreviewConfig;", "getCreationImageConfig", "()Lcom/larus/settings/provider/chat/CreationPreviewConfig;", "getPreviewPageConfig", "()Lcom/larus/settings/provider/chat/PreviewPageConfig;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class u1 {

    @SerializedName("creation_image_config")
    private final b0 creationImageConfig;

    @SerializedName("preview_page_config")
    private final z1 previewPageConfig;

    @SerializedName("send_image_config")
    private final a0 sendImageConfig;

    public u1() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof u1) == true) goto L8;
        return false;
    L8:
        u1 r6 = (u1) r5;
        if (Intrinsics.areEqual(this.sendImageConfig, r6.sendImageConfig) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.creationImageConfig, r6.creationImageConfig) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.previewPageConfig, r6.previewPageConfig) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        a0 r0 = this.sendImageConfig;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        b0 r4 = this.creationImageConfig;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        z1 r7 = this.previewPageConfig;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "NewPreviewTotalConfig(sendImageConfig=" + this.sendImageConfig + ", creationImageConfig=" + this.creationImageConfig + ", previewPageConfig=" + this.previewPageConfig + ')';
    }

    public final b0 a() {
        return this.creationImageConfig;
    }

    public final z1 b() {
        return this.previewPageConfig;
    }

    public final a0 c() {
        return this.sendImageConfig;
    }

    public u1(int r4) {
        a0 r5 = new a0(null);
        b0 r0 = new b0(0);
        z1 r2 = new z1(0);
        this.sendImageConfig = r5;
        this.creationImageConfig = r0;
        this.previewPageConfig = r2;
    }
}
