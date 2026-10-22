package com.obric.assistant.special_input;

import com.google.gson.annotations.SerializedName;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0082\b\u0018\u0000 $2\u00020\u0001:\u0001$BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003JV\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010¨\u0006%"}, d2 = {"Lcom/obric/assistant/special_input/PhoneOperationSpecialPanelDraftRecord;", "", "requestType", "", "panelType", "", "omniTaskId", "refMessageId", "sourceFrom", "complexSourceType", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRequestType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPanelType", "()Ljava/lang/String;", "getOmniTaskId", "getRefMessageId", "getSourceFrom", "getComplexSourceType", "toContextOrNull", "Lcom/obric/assistant/special_input/PhoneOperationSpecialPanelDraftContext;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/obric/assistant/special_input/PhoneOperationSpecialPanelDraftRecord;", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "toString", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class r0 {
    public static final /* synthetic */ int a = 0;

    @SerializedName("complex_source_type")
    private final String complexSourceType;

    @SerializedName("omni_task_id")
    private final String omniTaskId;

    @SerializedName("panel_type")
    private final String panelType;

    @SerializedName("ref_message_id")
    private final String refMessageId;

    @SerializedName("request_type")
    private final Integer requestType;

    @SerializedName("source_from")
    private final String sourceFrom;

    public static final class a {
    }

    static {
    }

    public r0() {
        this(null, null, null, null, null, null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof r0) == true) goto L8;
        return false;
    L8:
        r0 r6 = (r0) r5;
        if (Intrinsics.areEqual(this.requestType, r6.requestType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.panelType, r6.panelType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.omniTaskId, r6.omniTaskId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.refMessageId, r6.refMessageId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.sourceFrom, r6.sourceFrom) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.complexSourceType, r6.complexSourceType) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.requestType;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.panelType;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.omniTaskId;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.refMessageId;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.sourceFrom;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.complexSourceType;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "PhoneOperationSpecialPanelDraftRecord(requestType=" + this.requestType + ", panelType=" + this.panelType + ", omniTaskId=" + this.omniTaskId + ", refMessageId=" + this.refMessageId + ", sourceFrom=" + this.sourceFrom + ", complexSourceType=" + this.complexSourceType + ')';
    }

    public final q0 a() {
        Integer r0 = this.requestType;
        if (r0 == null) goto L36;
        int r3 = r0.intValue();
        String r1 = this.panelType;
        if (r1 != null) goto L7;
    L9:
        String r4 = null;
    L10:
        String r2 = this.omniTaskId;
        if (r2 != null) goto L13;
    L15:
        String r5 = null;
    L16:
        String r6 = this.refMessageId;
        if (r6 != null) goto L19;
    L21:
        String r7 = null;
    L22:
        String r8 = this.sourceFrom;
        if (r8 != null) goto L25;
    L27:
        String r9 = null;
    L28:
        String r10 = this.complexSourceType;
        if (r10 != null) goto L31;
    L33:
        String r11 = null;
    L35:
        return new q0(r3, r4, r5, r7, r9, r11);
    L31:
        if ((!StringsKt.isBlank(r10)) == false) goto L33;
        r11 = r10;
        goto L35
    L25:
        if ((!StringsKt.isBlank(r8)) == false) goto L27;
        r9 = r8;
        goto L28
    L19:
        if ((!StringsKt.isBlank(r6)) == false) goto L21;
        r7 = r6;
        goto L22
    L13:
        if ((!StringsKt.isBlank(r2)) == false) goto L15;
        r5 = r2;
        goto L16
    L7:
        if ((!StringsKt.isBlank(r1)) == false) goto L9;
        r4 = r1;
        goto L10
    L36:
        return null;
    }

    public r0(Integer r1, String r2, String r3, String r4, String r5, String r6) {
        this.requestType = r1;
        this.panelType = r2;
        this.omniTaskId = r3;
        this.refMessageId = r4;
        this.sourceFrom = r5;
        this.complexSourceType = r6;
    }
}
