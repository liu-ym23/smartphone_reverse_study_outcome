package com.obric.memorydata.memory.review.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/memory/review/model/MemoryReviewVote;", "", "key", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "UP", "DOWN", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum MemoryReviewVote extends Enum<MemoryReviewVote> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MemoryReviewVote[] $VALUES = null;
    public static final a Companion = null;
    public static final MemoryReviewVote DOWN = null;
    public static final MemoryReviewVote UP = null;
    private final String key;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/review/model/MemoryReviewVote$Companion;", "", "<init>", "()V", "fromKey", "Lcom/obric/memorydata/memory/review/model/MemoryReviewVote;", "key", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final MemoryReviewVote a(String r5) {
            Intrinsics.checkNotNullParameter(r5, "key");
            MemoryReviewVote[] r4 = MemoryReviewVote.values();
            int r0 = r4.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L8;
            MemoryReviewVote r2 = r4[r1];
            if (Intrinsics.areEqual(r2.getKey(), r5) == true) goto L12;
            r1 = r1 + 1;
            goto L3
        L12:
            return r2;
        L8:
            return null;
        }
    }

    private static final /* synthetic */ MemoryReviewVote[] $values() {
        return new MemoryReviewVote[]{UP, DOWN};
    }

    static {
        UP = new MemoryReviewVote("UP", 0, "up");
        DOWN = new MemoryReviewVote("DOWN", 1, "down");
        MemoryReviewVote[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        Companion = new a(null);
    }

    private MemoryReviewVote(String r1, int r2, String r3) {
        super(r1, r2);
        this.key = r3;
    }

    public static EnumEntries<MemoryReviewVote> getEntries() {
        return $ENTRIES;
    }

    public static MemoryReviewVote valueOf(String r2) {
        return (MemoryReviewVote) ZeusTransformUtils.preCheckCast(Enum.valueOf(MemoryReviewVote.class, r2), MemoryReviewVote.class, "com.obric.memorydata.plugin");
    }

    public static MemoryReviewVote[] values() {
        return (MemoryReviewVote[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MemoryReviewVote[].class, "com.obric.memorydata.plugin");
    }

    public final String getKey() {
        return this.key;
    }
}
