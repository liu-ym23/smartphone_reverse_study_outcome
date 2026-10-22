package com.larus.bmhome.chat.resp;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R$\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/chat/resp/UnreadNotificationCount;", "", "unreadCount", "", "", "", "<init>", "(Ljava/util/Map;)V", "getUnreadCount", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class UnreadNotificationCount {

    @SerializedName("unread_count_map")
    private final Map<String, Integer> unreadCount;

    public UnreadNotificationCount() {
        Map r0 = null;
        this(r0, 1, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UnreadNotificationCount copy$default(UnreadNotificationCount r0, Map r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.unreadCount;
    L6:
        return r0.copy(r1);
    }

    public final Map<String, Integer> component1() {
        return this.unreadCount;
    }

    public final UnreadNotificationCount copy(Map<String, Integer> r2) {
        return new UnreadNotificationCount(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof UnreadNotificationCount) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.unreadCount, ((UnreadNotificationCount) r4).unreadCount) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        Map<String, Integer> r0 = this.unreadCount;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "UnreadNotificationCount(unreadCount=" + this.unreadCount + ')';
    }

    public final Map<String, Integer> getUnreadCount() {
        return this.unreadCount;
    }

    public UnreadNotificationCount(Map<String, Integer> r1) {
        this.unreadCount = r1;
    }

    public /* synthetic */ UnreadNotificationCount(Map r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
