package com.larus.platform.model.action;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/larus/platform/model/action/InstructionConfig;", "Ljava/io/Serializable;", "redirectionType", "", "messageText", "", "<init>", "(ILjava/lang/String;)V", "getRedirectionType", "()I", "getMessageText", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class InstructionConfig implements Serializable {

    @SerializedName("message_text")
    private final String messageText;

    @SerializedName("instruction_redirect_type")
    private final int redirectionType;

    public InstructionConfig() {
        String r0 = null;
        int r2 = 0;
        this(r2, r0, 3, r0);
    }

    public static /* synthetic */ InstructionConfig copy$default(InstructionConfig r0, int r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.redirectionType;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.messageText;
    L9:
        return r0.copy(r1, r2);
    }

    public final int component1() {
        return this.redirectionType;
    }

    public final String component2() {
        return this.messageText;
    }

    public final InstructionConfig copy(int r2, String r3) {
        return new InstructionConfig(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof InstructionConfig) == true) goto L8;
        return false;
    L8:
        InstructionConfig r6 = (InstructionConfig) r5;
        if (this.redirectionType == r6.redirectionType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.messageText, r6.messageText) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.redirectionType * 31;
        String r1 = this.messageText;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "InstructionConfig(redirectionType=" + this.redirectionType + ", messageText=" + this.messageText + ')';
    }

    public final String getMessageText() {
        return this.messageText;
    }

    public final int getRedirectionType() {
        return this.redirectionType;
    }

    public InstructionConfig(int r1, String r2) {
        this.redirectionType = r1;
        this.messageText = r2;
    }

    public /* synthetic */ InstructionConfig(int r1, String r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = null;
    L8:
        this(r1, r2);
    }
}
