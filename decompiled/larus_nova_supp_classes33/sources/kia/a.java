package kia;

import com.google.gson.annotations.SerializedName;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b+\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010+\u001a\u00020\bHÆ\u0003J\t\u0010,\u001a\u00020\nHÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\bHÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J]\u00100\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u00101\u001a\u00020\u00052\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\nHÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013R\u001e\u0010\f\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001b\"\u0004\b%\u0010\u001dR\u001e\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0011\"\u0004\b'\u0010\u0013¨\u00065"}, d2 = {"Lcom/obric/audio/enroll/asr/AsrResponse;", "", "AsrState", "", "VadEnd", "", "AsrEnd", "endTime", "", "errorCode", "", "errorMessage", "startTime", "text", "<init>", "(Ljava/lang/String;ZLjava/lang/String;FILjava/lang/String;FLjava/lang/String;)V", "getAsrState", "()Ljava/lang/String;", "setAsrState", "(Ljava/lang/String;)V", "getVadEnd", "()Z", "setVadEnd", "(Z)V", "getAsrEnd", "setAsrEnd", "getEndTime", "()F", "setEndTime", "(F)V", "getErrorCode", "()I", "setErrorCode", "(I)V", "getErrorMessage", "setErrorMessage", "getStartTime", "setStartTime", "getText", "setText", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("AsrEnd")
    private String AsrEnd;

    @SerializedName("AsrState")
    private String AsrState;

    @SerializedName("VadEnd")
    private boolean VadEnd;

    @SerializedName("endTime")
    private float endTime;

    @SerializedName("errorCode")
    private int errorCode;

    @SerializedName("errorMessage")
    private String errorMessage;

    @SerializedName("startTime")
    private float startTime;

    @SerializedName("text")
    private String text;

    public a() {
        this(null, false, null, 0.0f, 0, null, 0.0f, null, 255);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.AsrState, r6.AsrState) == true) goto L12;
        return false;
    L12:
        if (this.VadEnd == r6.VadEnd) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.AsrEnd, r6.AsrEnd) == true) goto L18;
        return false;
    L18:
        if (Float.compare(this.endTime, r6.endTime) == 0) goto L21;
        return false;
    L21:
        if (this.errorCode == r6.errorCode) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.errorMessage, r6.errorMessage) == true) goto L27;
        return false;
    L27:
        if (Float.compare(this.startTime, r6.startTime) == 0) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        String r0 = this.AsrState;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        if (this.VadEnd == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        String r6 = this.AsrEnd;
        if (r6 == null) goto L15;
        r1 = r6.hashCode();
    L15:
        return ((((((((((r5 + r1) * 31) + Float.floatToIntBits(this.endTime)) * 31) + this.errorCode) * 31) + this.errorMessage.hashCode()) * 31) + Float.floatToIntBits(this.startTime)) * 31) + this.text.hashCode();
    L9:
        r4 = 1237;
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "AsrResponse(AsrState=" + this.AsrState + ", VadEnd=" + this.VadEnd + ", AsrEnd=" + this.AsrEnd + ", endTime=" + this.endTime + ", errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ", startTime=" + this.startTime + ", text=" + this.text + ')';
    }

    public final int a() {
        return this.errorCode;
    }

    public final String b() {
        return this.text;
    }

    public final boolean c() {
        return this.VadEnd;
    }

    public a(String r5, boolean r6, String r7, float r8, int r9, String r10, float r11, String r12, int r13) {
        if ((r13 & 1) == 0) goto L6;
        r5 = "";
    L6:
        if ((r13 & 2) == 0) goto L9;
        r6 = false;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r7 = "";
    L12:
        if ((r13 & 8) == 0) goto L15;
        r8 = 0.0f;
    L15:
        if ((r13 & 16) == 0) goto L18;
        r9 = 0;
    L18:
        if ((r13 & 32) == 0) goto L21;
        r10 = "";
    L21:
        if ((r13 & 64) == 0) goto L24;
        r11 = 0.0f;
    L24:
        if ((r13 & 128) == 0) goto L26;
        r12 = "";
    L26:
        Intrinsics.checkNotNullParameter(r10, "errorMessage");
        Intrinsics.checkNotNullParameter(r12, "text");
        this.AsrState = r5;
        this.VadEnd = r6;
        this.AsrEnd = r7;
        this.endTime = r8;
        this.errorCode = r9;
        this.errorMessage = r10;
        this.startTime = r11;
        this.text = r12;
    }
}
