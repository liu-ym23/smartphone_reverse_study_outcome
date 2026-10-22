package com.obric.memorydata.memory.review.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u000e\b\u0080\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/memory/review/model/MemoryReviewModule;", "", "key", "", "legacyKeys", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/util/Set;)V", "getKey", "()Ljava/lang/String;", "SCREEN_MEMORY", "AUDIO_MEMORY", "AUTO_MEMORY_PRO", "COLLECTION_MEMORY", "PERSONAL_MEMORY", "acceptedKeys", "getAcceptedKeys", "()Ljava/util/Set;", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum MemoryReviewModule extends Enum<MemoryReviewModule> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MemoryReviewModule[] $VALUES = null;
    public static final MemoryReviewModule AUDIO_MEMORY = null;
    public static final MemoryReviewModule AUTO_MEMORY_PRO = null;
    public static final MemoryReviewModule COLLECTION_MEMORY = null;
    public static final a Companion = null;
    public static final MemoryReviewModule PERSONAL_MEMORY = null;
    public static final MemoryReviewModule SCREEN_MEMORY = null;
    private final Set<String> acceptedKeys;
    private final String key;
    private final Set<String> legacyKeys;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/review/model/MemoryReviewModule$Companion;", "", "<init>", "()V", "fromKey", "Lcom/obric/memorydata/memory/review/model/MemoryReviewModule;", "key", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final MemoryReviewModule a(String r5) {
            Intrinsics.checkNotNullParameter(r5, "key");
            MemoryReviewModule[] r4 = MemoryReviewModule.values();
            int r0 = r4.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L8;
            MemoryReviewModule r2 = r4[r1];
            if (r2.getAcceptedKeys().contains(r5) == true) goto L12;
            r1 = r1 + 1;
            goto L3
        L12:
            return r2;
        L8:
            return null;
        }
    }

    private static final /* synthetic */ MemoryReviewModule[] $values() {
        return new MemoryReviewModule[]{SCREEN_MEMORY, AUDIO_MEMORY, AUTO_MEMORY_PRO, COLLECTION_MEMORY, PERSONAL_MEMORY};
    }

    static {
        SCREEN_MEMORY = new MemoryReviewModule("SCREEN_MEMORY", 0, "screen_memory", null, 2, null);
        AUDIO_MEMORY = new MemoryReviewModule("AUDIO_MEMORY", 1, "auditory_memory", SetsKt.setOf("audio_memory"));
        AUTO_MEMORY_PRO = new MemoryReviewModule("AUTO_MEMORY_PRO", 2, "memory_task", SetsKt.setOf("auto_memory_pro"));
        COLLECTION_MEMORY = new MemoryReviewModule("COLLECTION_MEMORY", 3, "collection_memory", null, 2, null);
        PERSONAL_MEMORY = new MemoryReviewModule("PERSONAL_MEMORY", 4, "personal_info_memory", SetsKt.setOf("personal_memory"));
        MemoryReviewModule[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        Companion = new a(null);
    }

    private MemoryReviewModule(String r3, int r4, String r5, Set r6) {
        Set<String> r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
        super(r3, r4);
        this.key = r5;
        this.legacyKeys = r7;
        this.acceptedKeys = SetsKt.plus(r7, r5);
    }

    /* synthetic */ MemoryReviewModule(String r2, int r3, String r4, Set r5, int r6, DefaultConstructorMarker r7) {
        Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L5;
        r8 = SetsKt.emptySet();
    L5:
        this(r2, r3, r4, r8);
    }

    public static EnumEntries<MemoryReviewModule> getEntries() {
        return $ENTRIES;
    }

    public static MemoryReviewModule valueOf(String r2) {
        return (MemoryReviewModule) ZeusTransformUtils.preCheckCast(Enum.valueOf(MemoryReviewModule.class, r2), MemoryReviewModule.class, "com.obric.memorydata.plugin");
    }

    public static MemoryReviewModule[] values() {
        return (MemoryReviewModule[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MemoryReviewModule[].class, "com.obric.memorydata.plugin");
    }

    public final Set<String> getAcceptedKeys() {
        return this.acceptedKeys;
    }

    public final String getKey() {
        return this.key;
    }
}
