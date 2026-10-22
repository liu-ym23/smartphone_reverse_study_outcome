package oq9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/larus/platform/model/camera/CameraResultTabConfig;", "", "enableResultTab", "", "defaultQuestionMode", "", "enableResultInput", "freeInputImagePolicy", "enableImageDewarp", "<init>", "(ZIZIZ)V", "getEnableResultTab", "()Z", "getDefaultQuestionMode", "()I", "getEnableResultInput", "getFreeInputImagePolicy", "getEnableImageDewarp", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class g {

    @SerializedName("default_question_mode")
    private final int defaultQuestionMode;

    @SerializedName("enable_image_dewarp")
    private final boolean enableImageDewarp;

    @SerializedName("enable_result_input")
    private final boolean enableResultInput;

    @SerializedName("enable_result_tab")
    private final boolean enableResultTab;

    @SerializedName("free_input_image_policy")
    private final int freeInputImagePolicy;

    public static final class a {
    }

    static {
    }

    public g() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (this.enableResultTab == r6.enableResultTab) goto L12;
        return false;
    L12:
        if (this.defaultQuestionMode == r6.defaultQuestionMode) goto L15;
        return false;
    L15:
        if (this.enableResultInput == r6.enableResultInput) goto L18;
        return false;
    L18:
        if (this.freeInputImagePolicy == r6.freeInputImagePolicy) goto L21;
        return false;
    L21:
        if (this.enableImageDewarp == r6.enableImageDewarp) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.enableResultTab == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = ((r0 * 31) + this.defaultQuestionMode) * 31;
        if (this.enableResultInput == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (((r2 + r3) * 31) + this.freeInputImagePolicy) * 31;
        if (this.enableImageDewarp == true) goto L15;
        r1 = 1237;
    L15:
        return r4 + r1;
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "CameraResultTabConfig(enableResultTab=" + this.enableResultTab + ", defaultQuestionMode=" + this.defaultQuestionMode + ", enableResultInput=" + this.enableResultInput + ", freeInputImagePolicy=" + this.freeInputImagePolicy + ", enableImageDewarp=" + this.enableImageDewarp + ')';
    }

    public final int a() {
        return this.defaultQuestionMode;
    }

    public final boolean b() {
        return this.enableImageDewarp;
    }

    public final boolean c() {
        return this.enableResultInput;
    }

    public final boolean d() {
        return this.enableResultTab;
    }

    public final int e() {
        return this.freeInputImagePolicy;
    }

    public g(int r1) {
        this.enableResultTab = false;
        this.defaultQuestionMode = 0;
        this.enableResultInput = false;
        this.freeInputImagePolicy = 0;
        this.enableImageDewarp = false;
    }
}
