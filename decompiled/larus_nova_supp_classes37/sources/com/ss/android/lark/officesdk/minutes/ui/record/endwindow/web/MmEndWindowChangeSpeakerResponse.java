package com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u000bHÆ\u0003J?\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0007HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/web/MmEndWindowChangeSpeakerResponse;", "Ljava/io/Serializable;", "isSuccess", "", "clusterId", "", "speakerInfoType", "", "larkSpeakerInfo", "Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/web/MmLarkSpeakerInfoToJS;", "speakerInfo", "Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/web/MmNonLarkSpeakerInfoToJS;", "<init>", "(ZLjava/lang/String;ILcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/web/MmLarkSpeakerInfoToJS;Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/web/MmNonLarkSpeakerInfoToJS;)V", "()Z", "getClusterId", "()Ljava/lang/String;", "getSpeakerInfoType", "()I", "getLarkSpeakerInfo", "()Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/web/MmLarkSpeakerInfoToJS;", "getSpeakerInfo", "()Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/web/MmNonLarkSpeakerInfoToJS;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "toString", "Companion", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmEndWindowChangeSpeakerResponse implements Serializable {
    public static final a Companion = null;

    @SerializedName("cluster_id")
    private final String clusterId;

    @SerializedName("is_success")
    private final boolean isSuccess;

    @SerializedName("lark_speaker_info")
    private final MmLarkSpeakerInfoToJS larkSpeakerInfo;

    @SerializedName("speaker_info")
    private final MmNonLarkSpeakerInfoToJS speakerInfo;

    @SerializedName("speaker_info_type")
    private final int speakerInfoType;

    public static final class a {
        public static MmEndWindowChangeSpeakerResponse a() {
            return new MmEndWindowChangeSpeakerResponse(false, "", 0, null, null, 24, null);
        }

        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ MmEndWindowChangeSpeakerResponse copy$default(MmEndWindowChangeSpeakerResponse r3, boolean r4, String r5, int r6, MmLarkSpeakerInfoToJS r7, MmNonLarkSpeakerInfoToJS r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.isSuccess;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.clusterId;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.speakerInfoType;
    L11:
        int r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.larkSpeakerInfo;
    L14:
        MmLarkSpeakerInfoToJS r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.speakerInfo;
    L17:
        boolean r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final boolean component1() {
        return this.isSuccess;
    }

    public final String component2() {
        return this.clusterId;
    }

    public final int component3() {
        return this.speakerInfoType;
    }

    public final MmLarkSpeakerInfoToJS component4() {
        return this.larkSpeakerInfo;
    }

    public final MmNonLarkSpeakerInfoToJS component5() {
        return this.speakerInfo;
    }

    public final MmEndWindowChangeSpeakerResponse copy(boolean r8, String r9, int r10, MmLarkSpeakerInfoToJS r11, MmNonLarkSpeakerInfoToJS r12) {
        Intrinsics.checkNotNullParameter(r9, "clusterId");
        return new MmEndWindowChangeSpeakerResponse(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MmEndWindowChangeSpeakerResponse) == true) goto L8;
        return false;
    L8:
        MmEndWindowChangeSpeakerResponse r6 = (MmEndWindowChangeSpeakerResponse) r5;
        if (this.isSuccess == r6.isSuccess) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.clusterId, r6.clusterId) == true) goto L15;
        return false;
    L15:
        if (this.speakerInfoType == r6.speakerInfoType) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.larkSpeakerInfo, r6.larkSpeakerInfo) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.speakerInfo, r6.speakerInfo) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        if (this.isSuccess == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = ((((r0 * 31) + this.clusterId.hashCode()) * 31) + this.speakerInfoType) * 31;
        MmLarkSpeakerInfoToJS r2 = this.larkSpeakerInfo;
        int r3 = 0;
        if (r2 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (r1 + r4) * 31;
        MmNonLarkSpeakerInfoToJS r6 = this.speakerInfo;
        if (r6 == null) goto L15;
        r3 = r6.hashCode();
    L15:
        return r5 + r3;
    L9:
        r4 = r2.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "MmEndWindowChangeSpeakerResponse(isSuccess=" + this.isSuccess + ", clusterId=" + this.clusterId + ", speakerInfoType=" + this.speakerInfoType + ", larkSpeakerInfo=" + this.larkSpeakerInfo + ", speakerInfo=" + this.speakerInfo + ')';
    }

    public final String getClusterId() {
        return this.clusterId;
    }

    public final MmLarkSpeakerInfoToJS getLarkSpeakerInfo() {
        return this.larkSpeakerInfo;
    }

    public final MmNonLarkSpeakerInfoToJS getSpeakerInfo() {
        return this.speakerInfo;
    }

    public final int getSpeakerInfoType() {
        return this.speakerInfoType;
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }

    public MmEndWindowChangeSpeakerResponse(boolean r2, String r3, int r4, MmLarkSpeakerInfoToJS r5, MmNonLarkSpeakerInfoToJS r6) {
        Intrinsics.checkNotNullParameter(r3, "clusterId");
        this.isSuccess = r2;
        this.clusterId = r3;
        this.speakerInfoType = r4;
        this.larkSpeakerInfo = r5;
        this.speakerInfo = r6;
    }

    public /* synthetic */ MmEndWindowChangeSpeakerResponse(boolean r8, String r9, int r10, MmLarkSpeakerInfoToJS r11, MmNonLarkSpeakerInfoToJS r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 8) == 0) goto L5;
        MmLarkSpeakerInfoToJS r5 = null;
    L7:
        if ((r13 & 16) == 0) goto L9;
        MmNonLarkSpeakerInfoToJS r6 = null;
    L10:
        this(r8, r9, r10, r5, r6);
        return;
    L9:
        r6 = r12;
        goto L10
    L5:
        r5 = r11;
        goto L7
    }
}
