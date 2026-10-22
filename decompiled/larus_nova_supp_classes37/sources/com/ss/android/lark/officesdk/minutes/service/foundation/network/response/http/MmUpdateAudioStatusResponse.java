package com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.d;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u000f\u001a\u00020\u0010R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmUpdateAudioStatusResponse;", "Ljava/io/Serializable;", "isForceSaveAudio", "", "forceSaveReason", "unavailableReason", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/audiosave/MmForceSaveUnavailableReason;", "benefitCenterUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/audiosave/MmForceSaveUnavailableReason;Ljava/lang/String;)V", "()Ljava/lang/String;", "getForceSaveReason", "getUnavailableReason", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/audiosave/MmForceSaveUnavailableReason;", "getBenefitCenterUrl", "shouldForceSaveAudio", "", "Companion", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmUpdateAudioStatusResponse implements Serializable {

    @SerializedName("benefit_center_url")
    private final String benefitCenterUrl;

    @SerializedName("force_save_reason")
    private final String forceSaveReason;

    @SerializedName("is_force_save")
    private final String isForceSaveAudio;

    @SerializedName("unavailable_reason")
    private final d unavailableReason;

    public static final class a {
    }

    static {
    }

    public MmUpdateAudioStatusResponse() {
        this(null, null, null, null, 15, null);
    }

    public final boolean shouldForceSaveAudio() {
        return Intrinsics.areEqual(this.isForceSaveAudio, "1");
    }

    public final String getBenefitCenterUrl() {
        return this.benefitCenterUrl;
    }

    public final String getForceSaveReason() {
        return this.forceSaveReason;
    }

    public final d getUnavailableReason() {
        return this.unavailableReason;
    }

    public final String isForceSaveAudio() {
        return this.isForceSaveAudio;
    }

    public MmUpdateAudioStatusResponse(String r1, String r2, d r3, String r4) {
        this.isForceSaveAudio = r1;
        this.forceSaveReason = r2;
        this.unavailableReason = r3;
        this.benefitCenterUrl = r4;
    }

    public /* synthetic */ MmUpdateAudioStatusResponse(String r2, String r3, d r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
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
