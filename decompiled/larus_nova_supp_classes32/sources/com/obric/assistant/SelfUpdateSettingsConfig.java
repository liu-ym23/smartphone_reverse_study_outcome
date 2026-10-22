package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/SelfUpdateSettingsConfig;", NameKeys.UnloadStrategy_No_Strategy, "obricAutoCheckDialogInterval", NameKeys.UnloadStrategy_No_Strategy, "obricCheckDownloadProgressInterval", "<init>", "(II)V", "getObricAutoCheckDialogInterval", "()I", "getObricCheckDownloadProgressInterval", "component1", "component2", "copy", "equals", NameKeys.UnloadStrategy_No_Strategy, "other", "hashCode", "toString", NameKeys.UnloadStrategy_No_Strategy, "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelfUpdateSettingsConfig {

    @SerializedName("obric_auto_check_update_dialog_show_limit_in_seconds")
    private final int obricAutoCheckDialogInterval;

    @SerializedName("obric_check_download_progress_interval_in_seconds")
    private final int obricCheckDownloadProgressInterval;

    public SelfUpdateSettingsConfig() {
        int r2 = 0;
        this(r2, r2, 3, null);
    }

    public static /* synthetic */ SelfUpdateSettingsConfig copy$default(SelfUpdateSettingsConfig r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.obricAutoCheckDialogInterval;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.obricCheckDownloadProgressInterval;
    L9:
        return r0.copy(r1, r2);
    }

    public final int component1() {
        return this.obricAutoCheckDialogInterval;
    }

    public final int component2() {
        return this.obricCheckDownloadProgressInterval;
    }

    public final SelfUpdateSettingsConfig copy(int r2, int r3) {
        return new SelfUpdateSettingsConfig(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SelfUpdateSettingsConfig) == true) goto L8;
        return false;
    L8:
        SelfUpdateSettingsConfig r6 = (SelfUpdateSettingsConfig) r5;
        if (this.obricAutoCheckDialogInterval == r6.obricAutoCheckDialogInterval) goto L12;
        return false;
    L12:
        if (this.obricCheckDownloadProgressInterval == r6.obricCheckDownloadProgressInterval) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.obricAutoCheckDialogInterval * 31) + this.obricCheckDownloadProgressInterval;
    }

    public String toString() {
        return "SelfUpdateSettingsConfig(obricAutoCheckDialogInterval=" + this.obricAutoCheckDialogInterval + ", obricCheckDownloadProgressInterval=" + this.obricCheckDownloadProgressInterval + ')';
    }

    public final int getObricAutoCheckDialogInterval() {
        return this.obricAutoCheckDialogInterval;
    }

    public final int getObricCheckDownloadProgressInterval() {
        return this.obricCheckDownloadProgressInterval;
    }

    public SelfUpdateSettingsConfig(int r1, int r2) {
        this.obricAutoCheckDialogInterval = r1;
        this.obricCheckDownloadProgressInterval = r2;
    }

    public /* synthetic */ SelfUpdateSettingsConfig(int r1, int r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 86400;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = 3;
    L8:
        this(r1, r2);
    }
}
