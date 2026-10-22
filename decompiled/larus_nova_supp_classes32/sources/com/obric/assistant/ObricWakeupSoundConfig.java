package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import com.obric.aivoice.core.data.NameKeys;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0003J=\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR \u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/obric/assistant/ObricWakeupSoundConfig;", NameKeys.UnloadStrategy_No_Strategy, "enable", NameKeys.UnloadStrategy_No_Strategy, "defaultSoundId", NameKeys.UnloadStrategy_No_Strategy, "previewAutoPlay", "options", NameKeys.UnloadStrategy_No_Strategy, "Lcom/obric/assistant/ObricWakeupSoundOption;", "<init>", "(ZLjava/lang/String;ZLjava/util/List;)V", "getEnable", "()Z", "getDefaultSoundId", "()Ljava/lang/String;", "getPreviewAutoPlay", "getOptions", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", NameKeys.UnloadStrategy_No_Strategy, "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricWakeupSoundConfig {

    @SerializedName(alternate = {"defaultSoundId"}, value = "default_sound_id")
    private final String defaultSoundId;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("options")
    private final List<ObricWakeupSoundOption> options;

    @SerializedName(alternate = {"previewAutoPlay"}, value = "preview_auto_play")
    private final boolean previewAutoPlay;

    public ObricWakeupSoundConfig() {
        this(false, null, false, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ObricWakeupSoundConfig copy$default(ObricWakeupSoundConfig r0, boolean r1, String r2, boolean r3, List r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.enable;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.defaultSoundId;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.previewAutoPlay;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.options;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final String component2() {
        return this.defaultSoundId;
    }

    public final boolean component3() {
        return this.previewAutoPlay;
    }

    public final List<ObricWakeupSoundOption> component4() {
        return this.options;
    }

    public final ObricWakeupSoundConfig copy(boolean r2, String r3, boolean r4, List<ObricWakeupSoundOption> r5) {
        return new ObricWakeupSoundConfig(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ObricWakeupSoundConfig) == true) goto L8;
        return false;
    L8:
        ObricWakeupSoundConfig r6 = (ObricWakeupSoundConfig) r5;
        if (this.enable == r6.enable) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.defaultSoundId, r6.defaultSoundId) == true) goto L15;
        return false;
    L15:
        if (this.previewAutoPlay == r6.previewAutoPlay) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.options, r6.options) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.enable == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        String r3 = this.defaultSoundId;
        int r4 = 0;
        if (r3 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r2 + r5) * 31;
        if (this.previewAutoPlay == true) goto L14;
        r1 = 1237;
    L14:
        int r7 = (r6 + r1) * 31;
        List<ObricWakeupSoundOption> r8 = this.options;
        if (r8 == null) goto L19;
        r4 = r8.hashCode();
    L19:
        return r7 + r4;
    L9:
        r5 = r3.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "ObricWakeupSoundConfig(enable=" + this.enable + ", defaultSoundId=" + this.defaultSoundId + ", previewAutoPlay=" + this.previewAutoPlay + ", options=" + this.options + ')';
    }

    public final String getDefaultSoundId() {
        return this.defaultSoundId;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final List<ObricWakeupSoundOption> getOptions() {
        return this.options;
    }

    public final boolean getPreviewAutoPlay() {
        return this.previewAutoPlay;
    }

    public ObricWakeupSoundConfig(boolean r1, String r2, boolean r3, List<ObricWakeupSoundOption> r4) {
        this.enable = r1;
        this.defaultSoundId = r2;
        this.previewAutoPlay = r3;
        this.options = r4;
    }

    public /* synthetic */ ObricWakeupSoundConfig(boolean r2, String r3, boolean r4, List r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = true;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
