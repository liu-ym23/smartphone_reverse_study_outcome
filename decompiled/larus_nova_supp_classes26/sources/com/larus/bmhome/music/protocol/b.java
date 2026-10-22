package com.larus.bmhome.music.protocol;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/larus/bmhome/music/protocol/FetchMessageRequest;", "", "conversationId", "", "cursor", "", "batchSize", "", "<init>", "(Ljava/lang/String;JI)V", "getConversationId", "()Ljava/lang/String;", "getCursor", "()J", "getBatchSize", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    @SerializedName("batch_size")
    private final int batchSize;

    @SerializedName(MusicAppletPage.KEY_CONVERSATION_ID)
    private final String conversationId;

    @SerializedName("cursor")
    private final long cursor;

    public b() {
        this("", 0, 1);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof b) == true) goto L8;
        return false;
    L8:
        b r9 = (b) r8;
        if (Intrinsics.areEqual(this.conversationId, r9.conversationId) == true) goto L12;
        return false;
    L12:
        if (this.cursor == r9.cursor) goto L15;
        return false;
    L15:
        if (this.batchSize == r9.batchSize) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r0 = this.conversationId;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        long r2 = this.cursor;
        return (((r1 * 31) + ((int) (r2 ^ (r2 >>> 32)))) * 31) + this.batchSize;
    L5:
        r1 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "FetchMessageRequest(conversationId=" + this.conversationId + ", cursor=" + this.cursor + ", batchSize=" + this.batchSize + ')';
    }

    public b(String r1, long r2, int r4) {
        this.conversationId = r1;
        this.cursor = r2;
        this.batchSize = r4;
    }
}
