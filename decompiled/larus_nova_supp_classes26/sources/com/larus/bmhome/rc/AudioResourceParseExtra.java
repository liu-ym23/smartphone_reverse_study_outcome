package com.larus.bmhome.rc;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/rc/AudioResourceParseExtra;", "", "botId", "", "localMessageId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getBotId", "()Ljava/lang/String;", "getLocalMessageId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioResourceParseExtra {

    @SerializedName("bot_id")
    private final String botId;

    @SerializedName("local_message_id")
    private final String localMessageId;

    public AudioResourceParseExtra() {
        String r0 = null;
        this(r0, r0, 3, r0);
    }

    public static /* synthetic */ AudioResourceParseExtra copy$default(AudioResourceParseExtra r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.botId;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.localMessageId;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.botId;
    }

    public final String component2() {
        return this.localMessageId;
    }

    public final AudioResourceParseExtra copy(String r2, String r3) {
        return new AudioResourceParseExtra(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AudioResourceParseExtra) == true) goto L8;
        return false;
    L8:
        AudioResourceParseExtra r6 = (AudioResourceParseExtra) r5;
        if (Intrinsics.areEqual(this.botId, r6.botId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.localMessageId, r6.localMessageId) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.botId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.localMessageId;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "AudioResourceParseExtra(botId=" + this.botId + ", localMessageId=" + this.localMessageId + ')';
    }

    public final String getBotId() {
        return this.botId;
    }

    public final String getLocalMessageId() {
        return this.localMessageId;
    }

    public AudioResourceParseExtra(String r1, String r2) {
        this.botId = r1;
        this.localMessageId = r2;
    }

    public /* synthetic */ AudioResourceParseExtra(String r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
