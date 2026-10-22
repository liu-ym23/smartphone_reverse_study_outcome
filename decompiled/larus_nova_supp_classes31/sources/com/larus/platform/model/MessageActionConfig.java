package com.larus.platform.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/larus/platform/model/MessageActionConfig;", "Ljava/io/Serializable;", "disableReplyFold", "", "<init>", "(Z)V", "getDisableReplyFold", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MessageActionConfig implements Serializable {

    @SerializedName("disable_reply_fold")
    private final boolean disableReplyFold;

    public MessageActionConfig() {
        boolean r2 = false;
        this(r2, 1, null);
    }

    public static /* synthetic */ MessageActionConfig copy$default(MessageActionConfig r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.disableReplyFold;
    L6:
        return r0.copy(r1);
    }

    public final boolean component1() {
        return this.disableReplyFold;
    }

    public final MessageActionConfig copy(boolean r2) {
        return new MessageActionConfig(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof MessageActionConfig) == true) goto L9;
        return false;
    L9:
        if (this.disableReplyFold == ((MessageActionConfig) r4).disableReplyFold) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        if (this.disableReplyFold == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public String toString() {
        return "MessageActionConfig(disableReplyFold=" + this.disableReplyFold + ')';
    }

    public final boolean getDisableReplyFold() {
        return this.disableReplyFold;
    }

    public MessageActionConfig(boolean r1) {
        this.disableReplyFold = r1;
    }

    public /* synthetic */ MessageActionConfig(boolean r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        this(r1);
    }
}
