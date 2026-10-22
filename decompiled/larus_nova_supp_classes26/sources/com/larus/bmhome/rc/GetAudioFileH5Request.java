package com.larus.bmhome.rc;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/rc/GetAudioFileH5Request;", "", "resourceIds", "", "", "botId", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getResourceIds", "()Ljava/util/List;", "getBotId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetAudioFileH5Request {

    @SerializedName("bot_id")
    private final String botId;

    @SerializedName("resource_ids")
    private final List<String> resourceIds;

    /* JADX WARN: Multi-variable type inference failed */
    public GetAudioFileH5Request() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetAudioFileH5Request copy$default(GetAudioFileH5Request r0, List r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.resourceIds;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.botId;
    L9:
        return r0.copy(r1, r2);
    }

    public final List<String> component1() {
        return this.resourceIds;
    }

    public final String component2() {
        return this.botId;
    }

    public final GetAudioFileH5Request copy(List<String> r2, String r3) {
        return new GetAudioFileH5Request(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof GetAudioFileH5Request) == true) goto L8;
        return false;
    L8:
        GetAudioFileH5Request r6 = (GetAudioFileH5Request) r5;
        if (Intrinsics.areEqual(this.resourceIds, r6.resourceIds) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.botId, r6.botId) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<String> r0 = this.resourceIds;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.botId;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "GetAudioFileH5Request(resourceIds=" + this.resourceIds + ", botId=" + this.botId + ')';
    }

    public final String getBotId() {
        return this.botId;
    }

    public final List<String> getResourceIds() {
        return this.resourceIds;
    }

    public GetAudioFileH5Request(List<String> r1, String r2) {
        this.resourceIds = r1;
        this.botId = r2;
    }

    public /* synthetic */ GetAudioFileH5Request(List r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
