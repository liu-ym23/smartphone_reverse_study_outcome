package com.larus.settings.provider.chat;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0011"}, d2 = {"Lcom/larus/settings/provider/chat/MessageTrackThreadConfig;", "", "messageTrackThreshold", "", "<init>", "(I)V", "getMessageTrackThreshold", "()I", "setMessageTrackThreshold", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MessageTrackThreadConfig {

    @SerializedName("message_track_threshold")
    private int messageTrackThreshold;

    public MessageTrackThreadConfig() {
        int r2 = 0;
        this(r2, 1, null);
    }

    public static /* synthetic */ MessageTrackThreadConfig copy$default(MessageTrackThreadConfig r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.messageTrackThreshold;
    L6:
        return r0.copy(r1);
    }

    public final int component1() {
        return this.messageTrackThreshold;
    }

    public final MessageTrackThreadConfig copy(int r2) {
        return new MessageTrackThreadConfig(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof MessageTrackThreadConfig) == true) goto L9;
        return false;
    L9:
        if (this.messageTrackThreshold == ((MessageTrackThreadConfig) r4).messageTrackThreshold) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.messageTrackThreshold;
    }

    public String toString() {
        return "MessageTrackThreadConfig(messageTrackThreshold=" + this.messageTrackThreshold + ')';
    }

    public final int getMessageTrackThreshold() {
        return this.messageTrackThreshold;
    }

    public MessageTrackThreadConfig(int r1) {
        this.messageTrackThreshold = r1;
    }

    public final void setMessageTrackThreshold(int r1) {
        this.messageTrackThreshold = r1;
    }

    public /* synthetic */ MessageTrackThreadConfig(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 1000;
    L5:
        this(r1);
    }
}
