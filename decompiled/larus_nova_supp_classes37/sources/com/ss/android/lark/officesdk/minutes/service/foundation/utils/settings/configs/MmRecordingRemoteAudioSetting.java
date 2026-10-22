package com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.MmAnsMode;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@AppConfig(key = "vc_remote_audio_setting")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BU\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\u0017\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b\u0018\u00010\nHÆ\u0003JZ\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020\u000bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R$\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/MmRecordingRemoteAudioSetting;", "Ljava/io/Serializable;", "mmAnsLevel", "", "mmAecOption", "mmAudioChannel", "mmAudioSampleRate", "enableMMAudioMode", "", "mmAudioFg", "", "", "<init>", "(ILjava/lang/Integer;IIZLjava/util/Map;)V", "getMmAnsLevel", "()I", "getMmAecOption", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMmAudioChannel", "getMmAudioSampleRate", "getEnableMMAudioMode", "()Z", "getMmAudioFg", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ILjava/lang/Integer;IIZLjava/util/Map;)Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/MmRecordingRemoteAudioSetting;", "equals", "other", "", "hashCode", "toString", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmRecordingRemoteAudioSetting implements Serializable {

    @SerializedName("enableMMAudioMode")
    private final boolean enableMMAudioMode;

    @SerializedName("mmAecOption")
    private final Integer mmAecOption;

    @SerializedName("mmAnsLevel")
    private final int mmAnsLevel;

    @SerializedName("mmAudioChannel")
    private final int mmAudioChannel;

    @SerializedName("mmAudioFg")
    private final Map<String, Boolean> mmAudioFg;

    @SerializedName("mmAudioSampleRate")
    private final int mmAudioSampleRate;

    public MmRecordingRemoteAudioSetting() {
        this(0, null, 0, 0, false, null, 63, null);
    }

    public MmRecordingRemoteAudioSetting(int r10) {
        this(r10, null, 0, 0, false, null, 62, null);
    }

    public MmRecordingRemoteAudioSetting(int r10, Integer r11) {
        this(r10, r11, 0, 0, false, null, 60, null);
    }

    public MmRecordingRemoteAudioSetting(int r10, Integer r11, int r12) {
        this(r10, r11, r12, 0, false, null, 56, null);
    }

    public MmRecordingRemoteAudioSetting(int r10, Integer r11, int r12, int r13) {
        this(r10, r11, r12, r13, false, null, 48, null);
    }

    public MmRecordingRemoteAudioSetting(int r10, Integer r11, int r12, int r13, boolean r14) {
        this(r10, r11, r12, r13, r14, null, 32, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MmRecordingRemoteAudioSetting copy$default(MmRecordingRemoteAudioSetting r4, int r5, Integer r6, int r7, int r8, boolean r9, Map r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.mmAnsLevel;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.mmAecOption;
    L8:
        Integer r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.mmAudioChannel;
    L11:
        int r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.mmAudioSampleRate;
    L14:
        int r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.enableMMAudioMode;
    L17:
        boolean r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.mmAudioFg;
    L20:
        int r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final int component1() {
        return this.mmAnsLevel;
    }

    public final Integer component2() {
        return this.mmAecOption;
    }

    public final int component3() {
        return this.mmAudioChannel;
    }

    public final int component4() {
        return this.mmAudioSampleRate;
    }

    public final boolean component5() {
        return this.enableMMAudioMode;
    }

    public final Map<String, Boolean> component6() {
        return this.mmAudioFg;
    }

    public final MmRecordingRemoteAudioSetting copy(int r9, Integer r10, int r11, int r12, boolean r13, Map<String, Boolean> r14) {
        return new MmRecordingRemoteAudioSetting(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MmRecordingRemoteAudioSetting) == true) goto L8;
        return false;
    L8:
        MmRecordingRemoteAudioSetting r6 = (MmRecordingRemoteAudioSetting) r5;
        if (this.mmAnsLevel == r6.mmAnsLevel) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.mmAecOption, r6.mmAecOption) == true) goto L15;
        return false;
    L15:
        if (this.mmAudioChannel == r6.mmAudioChannel) goto L18;
        return false;
    L18:
        if (this.mmAudioSampleRate == r6.mmAudioSampleRate) goto L21;
        return false;
    L21:
        if (this.enableMMAudioMode == r6.enableMMAudioMode) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.mmAudioFg, r6.mmAudioFg) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = this.mmAnsLevel * 31;
        Integer r1 = this.mmAecOption;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((r0 + r3) * 31) + this.mmAudioChannel) * 31) + this.mmAudioSampleRate) * 31;
        if (this.enableMMAudioMode == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (r4 + r5) * 31;
        Map<String, Boolean> r7 = this.mmAudioFg;
        if (r7 == null) goto L15;
        r2 = r7.hashCode();
    L15:
        return r6 + r2;
    L9:
        r5 = 1237;
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "MmRecordingRemoteAudioSetting(mmAnsLevel=" + this.mmAnsLevel + ", mmAecOption=" + this.mmAecOption + ", mmAudioChannel=" + this.mmAudioChannel + ", mmAudioSampleRate=" + this.mmAudioSampleRate + ", enableMMAudioMode=" + this.enableMMAudioMode + ", mmAudioFg=" + this.mmAudioFg + ')';
    }

    public final boolean getEnableMMAudioMode() {
        return this.enableMMAudioMode;
    }

    public final Integer getMmAecOption() {
        return this.mmAecOption;
    }

    public final int getMmAnsLevel() {
        return this.mmAnsLevel;
    }

    public final int getMmAudioChannel() {
        return this.mmAudioChannel;
    }

    public final Map<String, Boolean> getMmAudioFg() {
        return this.mmAudioFg;
    }

    public final int getMmAudioSampleRate() {
        return this.mmAudioSampleRate;
    }

    public MmRecordingRemoteAudioSetting(int r1, Integer r2, int r3, int r4, boolean r5, Map<String, Boolean> r6) {
        this.mmAnsLevel = r1;
        this.mmAecOption = r2;
        this.mmAudioChannel = r3;
        this.mmAudioSampleRate = r4;
        this.enableMMAudioMode = r5;
        this.mmAudioFg = r6;
    }

    public /* synthetic */ MmRecordingRemoteAudioSetting(int r5, Integer r6, int r7, int r8, boolean r9, Map r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r5 = MmAnsMode.ANS_MODE_LOW.getValue();
    L5:
        Map r0 = null;
        if ((r11 & 2) == 0) goto L8;
        Integer r13 = null;
    L10:
        if ((r11 & 4) == 0) goto L12;
        int r1 = 2;
    L14:
        if ((r11 & 8) == 0) goto L16;
        int r2 = 16000;
    L18:
        if ((r11 & 16) == 0) goto L20;
        boolean r3 = true;
    L22:
        if ((r11 & 32) != 0) goto L25;
        r0 = r10;
    L25:
        this(r5, r13, r1, r2, r3, r0);
        return;
    L20:
        r3 = r9;
        goto L22
    L16:
        r2 = r8;
        goto L18
    L12:
        r1 = r7;
        goto L14
    L8:
        r13 = r6;
        goto L10
    }
}
