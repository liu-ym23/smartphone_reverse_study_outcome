package com.larus.platform.model.camera;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0001\"BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0014¨\u0006#"}, d2 = {"Lcom/larus/platform/model/camera/CameraSettings;", "", "support1080p", "", "asyncDestroyRecorder", "firstStopPreview", "asyncStopPreview", "asyncCloseCapture", "veLogLevel", "isStartCameraSync", "", "<init>", "(IIIIIIZ)V", "getSupport1080p", "()I", "getAsyncDestroyRecorder", "getFirstStopPreview", "getAsyncStopPreview", "getAsyncCloseCapture", "getVeLogLevel", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CameraSettings {
    public static final a Companion = null;
    private static final CameraSettings default_in_api_26_or_27 = null;
    private static final CameraSettings default_normal = null;

    @SerializedName("async_close_capture")
    private final int asyncCloseCapture;

    @SerializedName("async_destroy_recorder")
    private final int asyncDestroyRecorder;

    @SerializedName("async_stop_preview")
    private final int asyncStopPreview;

    @SerializedName("first_stop_preview")
    private final int firstStopPreview;

    @SerializedName("is_start_camera_sync")
    private final boolean isStartCameraSync;

    @SerializedName("support_1080p")
    private final int support1080p;

    @SerializedName("ve_log_level")
    private final int veLogLevel;

    public static final class a {
        public a() {
        }
    }

    public CameraSettings() {
        this(0, 0, 0, 0, 0, 0, false, 127, null);
    }

    public static /* synthetic */ CameraSettings copy$default(CameraSettings r5, int r6, int r7, int r8, int r9, int r10, int r11, boolean r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.support1080p;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.asyncDestroyRecorder;
    L8:
        int r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.firstStopPreview;
    L11:
        int r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.asyncStopPreview;
    L14:
        int r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.asyncCloseCapture;
    L17:
        int r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.veLogLevel;
    L20:
        int r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.isStartCameraSync;
    L23:
        int r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final int component1() {
        return this.support1080p;
    }

    public final int component2() {
        return this.asyncDestroyRecorder;
    }

    public final int component3() {
        return this.firstStopPreview;
    }

    public final int component4() {
        return this.asyncStopPreview;
    }

    public final int component5() {
        return this.asyncCloseCapture;
    }

    public final int component6() {
        return this.veLogLevel;
    }

    public final boolean component7() {
        return this.isStartCameraSync;
    }

    public final CameraSettings copy(int r10, int r11, int r12, int r13, int r14, int r15, boolean r16) {
        return new CameraSettings(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CameraSettings) == true) goto L8;
        return false;
    L8:
        CameraSettings r6 = (CameraSettings) r5;
        if (this.support1080p == r6.support1080p) goto L12;
        return false;
    L12:
        if (this.asyncDestroyRecorder == r6.asyncDestroyRecorder) goto L15;
        return false;
    L15:
        if (this.firstStopPreview == r6.firstStopPreview) goto L18;
        return false;
    L18:
        if (this.asyncStopPreview == r6.asyncStopPreview) goto L21;
        return false;
    L21:
        if (this.asyncCloseCapture == r6.asyncCloseCapture) goto L24;
        return false;
    L24:
        if (this.veLogLevel == r6.veLogLevel) goto L27;
        return false;
    L27:
        if (this.isStartCameraSync == r6.isStartCameraSync) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((((this.support1080p * 31) + this.asyncDestroyRecorder) * 31) + this.firstStopPreview) * 31) + this.asyncStopPreview) * 31) + this.asyncCloseCapture) * 31) + this.veLogLevel) * 31;
        if (this.isStartCameraSync == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public String toString() {
        return "CameraSettings(support1080p=" + this.support1080p + ", asyncDestroyRecorder=" + this.asyncDestroyRecorder + ", firstStopPreview=" + this.firstStopPreview + ", asyncStopPreview=" + this.asyncStopPreview + ", asyncCloseCapture=" + this.asyncCloseCapture + ", veLogLevel=" + this.veLogLevel + ", isStartCameraSync=" + this.isStartCameraSync + ')';
    }

    static {
        Companion = new a();
        default_normal = new CameraSettings(0, 0, 0, 0, 0, 0, false, 127, null);
        default_in_api_26_or_27 = new CameraSettings(0, 1, 0, 0, 0, 0, false, 125, null);
    }

    public static final /* synthetic */ CameraSettings access$getDefault_in_api_26_or_27$cp() {
        return default_in_api_26_or_27;
    }

    public static final /* synthetic */ CameraSettings access$getDefault_normal$cp() {
        return default_normal;
    }

    public final int getAsyncCloseCapture() {
        return this.asyncCloseCapture;
    }

    public final int getAsyncDestroyRecorder() {
        return this.asyncDestroyRecorder;
    }

    public final int getAsyncStopPreview() {
        return this.asyncStopPreview;
    }

    public final int getFirstStopPreview() {
        return this.firstStopPreview;
    }

    public final int getSupport1080p() {
        return this.support1080p;
    }

    public final int getVeLogLevel() {
        return this.veLogLevel;
    }

    public final boolean isStartCameraSync() {
        return this.isStartCameraSync;
    }

    public CameraSettings(int r1, int r2, int r3, int r4, int r5, int r6, boolean r7) {
        this.support1080p = r1;
        this.asyncDestroyRecorder = r2;
        this.firstStopPreview = r3;
        this.asyncStopPreview = r4;
        this.asyncCloseCapture = r5;
        this.veLogLevel = r6;
        this.isStartCameraSync = r7;
    }

    public /* synthetic */ CameraSettings(int r6, int r7, int r8, int r9, int r10, int r11, boolean r12, int r13, DefaultConstructorMarker r14) {
        int r0 = 0;
        if ((r13 & 1) == 0) goto L5;
        int r15 = 0;
    L7:
        if ((r13 & 2) == 0) goto L9;
        int r1 = 0;
    L11:
        if ((r13 & 4) == 0) goto L13;
        int r2 = 1;
    L15:
        if ((r13 & 8) != 0) goto L19;
        r0 = r9;
    L19:
        if ((r13 & 16) == 0) goto L21;
        int r3 = 1;
    L23:
        if ((r13 & 32) == 0) goto L25;
        int r4 = 2;
    L27:
        if ((r13 & 64) == 0) goto L29;
        boolean r16 = true;
    L30:
        this(r15, r1, r2, r0, r3, r4, r16);
        return;
    L29:
        r16 = r12;
        goto L30
    L25:
        r4 = r11;
        goto L27
    L21:
        r3 = r10;
        goto L23
    L13:
        r2 = r8;
        goto L15
    L9:
        r1 = r7;
        goto L11
    L5:
        r15 = r6;
        goto L7
    }
}
