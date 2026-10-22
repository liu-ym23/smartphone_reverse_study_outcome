package jx1;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Ljx1/b;", "", "", "feedType", "Ljava/lang/String;", "getFeedType", "()Ljava/lang/String;", "packScene", "getPackScene", "", "Ljx1/c;", "roomIndexes", "Ljava/util/List;", "getRoomIndexes", "()Ljava/util/List;", "room_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("feed_type")
    private final String feedType;

    @SerializedName("pack_scene")
    private final String packScene;

    @SerializedName("room_indexs")
    private final List<c> roomIndexes;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L12;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.feedType, r4.feedType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.packScene, r4.packScene) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.roomIndexes, r4.roomIndexes) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r0 = this.feedType;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.packScene;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<c> r7 = this.roomIndexes;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "InsertRoomConfig(feedType=" + this.feedType + ", packScene=" + this.packScene + ", roomIndexes=" + this.roomIndexes + ")";
    }

    public b() {
        this.feedType = "homepage_hot";
        this.packScene = "debug_live_ai_hot";
        this.roomIndexes = null;
    }
}
