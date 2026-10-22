package du9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\nHÖ\u0001J\t\u0010\u001e\u001a\u00020\bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR \u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/larus/settings/provider/chat/ChatSendPreviewConfig;", "", "enablePreview", "", "enableInput", "enableAiEdit", "aiEditFilterScene", "", "", "prefetchSize", "", "<init>", "(ZZZLjava/util/List;I)V", "getEnablePreview", "()Z", "getEnableInput", "getEnableAiEdit", "getAiEditFilterScene", "()Ljava/util/List;", "getPrefetchSize", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class a0 {

    @SerializedName("ai_edit_filter_scene")
    private final List<String> aiEditFilterScene;

    @SerializedName("enable_ai_edit")
    private final boolean enableAiEdit;

    @SerializedName("enable_input")
    private final boolean enableInput;

    @SerializedName("enable_preview")
    private final boolean enablePreview;

    @SerializedName("prefetch_size")
    private final int prefetchSize;

    public a0() {
        this(null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r6 = (a0) r5;
        if (this.enablePreview == r6.enablePreview) goto L12;
        return false;
    L12:
        if (this.enableInput == r6.enableInput) goto L15;
        return false;
    L15:
        if (this.enableAiEdit == r6.enableAiEdit) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.aiEditFilterScene, r6.aiEditFilterScene) == true) goto L21;
        return false;
    L21:
        if (this.prefetchSize == r6.prefetchSize) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.enablePreview == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.enableInput == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.enableAiEdit == true) goto L14;
        r1 = 1237;
    L14:
        int r5 = (r4 + r1) * 31;
        List<String> r6 = this.aiEditFilterScene;
        if (r6 != null) goto L17;
        int r7 = 0;
    L19:
        return ((r5 + r7) * 31) + this.prefetchSize;
    L17:
        r7 = r6.hashCode();
        goto L19
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "ChatSendPreviewConfig(enablePreview=" + this.enablePreview + ", enableInput=" + this.enableInput + ", enableAiEdit=" + this.enableAiEdit + ", aiEditFilterScene=" + this.aiEditFilterScene + ", prefetchSize=" + this.prefetchSize + ')';
    }

    public final List<String> a() {
        return this.aiEditFilterScene;
    }

    public final boolean b() {
        return this.enableAiEdit;
    }

    public final boolean c() {
        return this.enableInput;
    }

    public final boolean d() {
        return this.enablePreview;
    }

    public final int e() {
        return this.prefetchSize;
    }

    public a0(Object r2) {
        List<String> r3 = CollectionsKt.emptyList();
        this.enablePreview = false;
        this.enableInput = false;
        this.enableAiEdit = false;
        this.aiEditFilterScene = r3;
        this.prefetchSize = 0;
    }
}
