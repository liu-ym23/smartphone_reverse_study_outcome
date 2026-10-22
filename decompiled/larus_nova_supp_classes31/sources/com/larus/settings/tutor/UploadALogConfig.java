package com.larus.settings.tutor;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/larus/settings/tutor/UploadALogConfig;", "", "enable", "", "headerTimesDebug", "Lcom/larus/settings/tutor/UploadALogConfigModel;", "loadingCatchError", "feedbackUpload", "<init>", "(ZLcom/larus/settings/tutor/UploadALogConfigModel;Lcom/larus/settings/tutor/UploadALogConfigModel;Lcom/larus/settings/tutor/UploadALogConfigModel;)V", "getEnable", "()Z", "getHeaderTimesDebug", "()Lcom/larus/settings/tutor/UploadALogConfigModel;", "getLoadingCatchError", "getFeedbackUpload", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class UploadALogConfig {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("feedback_upload")
    private final UploadALogConfigModel feedbackUpload;

    @SerializedName("header_times_debug")
    private final UploadALogConfigModel headerTimesDebug;

    @SerializedName("loading_catch_error")
    private final UploadALogConfigModel loadingCatchError;

    public UploadALogConfig() {
        this(false, null, null, null, 15, null);
    }

    public static /* synthetic */ UploadALogConfig copy$default(UploadALogConfig r0, boolean r1, UploadALogConfigModel r2, UploadALogConfigModel r3, UploadALogConfigModel r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.enable;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.headerTimesDebug;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.loadingCatchError;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.feedbackUpload;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final UploadALogConfigModel component2() {
        return this.headerTimesDebug;
    }

    public final UploadALogConfigModel component3() {
        return this.loadingCatchError;
    }

    public final UploadALogConfigModel component4() {
        return this.feedbackUpload;
    }

    public final UploadALogConfig copy(boolean r2, UploadALogConfigModel r3, UploadALogConfigModel r4, UploadALogConfigModel r5) {
        return new UploadALogConfig(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UploadALogConfig) == true) goto L8;
        return false;
    L8:
        UploadALogConfig r6 = (UploadALogConfig) r5;
        if (this.enable == r6.enable) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.headerTimesDebug, r6.headerTimesDebug) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.loadingCatchError, r6.loadingCatchError) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.feedbackUpload, r6.feedbackUpload) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        if (this.enable == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = r0 * 31;
        UploadALogConfigModel r2 = this.headerTimesDebug;
        int r3 = 0;
        if (r2 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (r1 + r4) * 31;
        UploadALogConfigModel r6 = this.loadingCatchError;
        if (r6 != null) goto L13;
        int r7 = 0;
    L14:
        int r8 = (r5 + r7) * 31;
        UploadALogConfigModel r9 = this.feedbackUpload;
        if (r9 == null) goto L19;
        r3 = r9.hashCode();
    L19:
        return r8 + r3;
    L13:
        r7 = r6.hashCode();
        goto L14
    L9:
        r4 = r2.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "UploadALogConfig(enable=" + this.enable + ", headerTimesDebug=" + this.headerTimesDebug + ", loadingCatchError=" + this.loadingCatchError + ", feedbackUpload=" + this.feedbackUpload + ')';
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final UploadALogConfigModel getFeedbackUpload() {
        return this.feedbackUpload;
    }

    public final UploadALogConfigModel getHeaderTimesDebug() {
        return this.headerTimesDebug;
    }

    public final UploadALogConfigModel getLoadingCatchError() {
        return this.loadingCatchError;
    }

    public UploadALogConfig(boolean r1, UploadALogConfigModel r2, UploadALogConfigModel r3, UploadALogConfigModel r4) {
        this.enable = r1;
        this.headerTimesDebug = r2;
        this.loadingCatchError = r3;
        this.feedbackUpload = r4;
    }

    public /* synthetic */ UploadALogConfig(boolean r2, UploadALogConfigModel r3, UploadALogConfigModel r4, UploadALogConfigModel r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
