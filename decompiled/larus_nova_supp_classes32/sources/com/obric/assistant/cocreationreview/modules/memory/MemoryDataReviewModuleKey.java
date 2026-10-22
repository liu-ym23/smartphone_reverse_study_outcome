package com.obric.assistant.cocreationreview.modules.memory;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0080\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/cocreationreview/modules/memory/MemoryDataReviewModuleKey;", NameKeys.UnloadStrategy_No_Strategy, "raw", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getRaw", "()Ljava/lang/String;", "SCREEN_MEMORY", "AUDIO_MEMORY", "AUTO_MEMORY_PRO", "COLLECTION_MEMORY", "PERSONAL_MEMORY", "Companion", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MemoryDataReviewModuleKey extends Enum<MemoryDataReviewModuleKey> {
    public static final MemoryDataReviewModuleKey AUDIO_MEMORY = null;
    public static final MemoryDataReviewModuleKey AUTO_MEMORY_PRO = null;
    public static final MemoryDataReviewModuleKey COLLECTION_MEMORY = null;
    public static final a Companion = null;
    public static final MemoryDataReviewModuleKey PERSONAL_MEMORY = null;
    public static final MemoryDataReviewModuleKey SCREEN_MEMORY = null;
    public static final /* synthetic */ MemoryDataReviewModuleKey[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String raw;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<MemoryDataReviewModuleKey> getEntries() {
        return b;
    }

    static {
        MemoryDataReviewModuleKey r0 = new MemoryDataReviewModuleKey("SCREEN_MEMORY", 0, "screen_memory");
        SCREEN_MEMORY = r0;
        MemoryDataReviewModuleKey r1 = new MemoryDataReviewModuleKey("AUDIO_MEMORY", 1, "auditory_memory");
        AUDIO_MEMORY = r1;
        MemoryDataReviewModuleKey r3 = new MemoryDataReviewModuleKey("AUTO_MEMORY_PRO", 2, "memory_task");
        AUTO_MEMORY_PRO = r3;
        MemoryDataReviewModuleKey r5 = new MemoryDataReviewModuleKey("COLLECTION_MEMORY", 3, "collection_memory");
        COLLECTION_MEMORY = r5;
        MemoryDataReviewModuleKey r7 = new MemoryDataReviewModuleKey("PERSONAL_MEMORY", 4, "personal_info_memory");
        PERSONAL_MEMORY = r7;
        MemoryDataReviewModuleKey[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
        Companion = new a();
    }

    public static MemoryDataReviewModuleKey[] values() {
        return (MemoryDataReviewModuleKey[]) a.clone();
    }

    public final String getRaw() {
        return this.raw;
    }

    public static MemoryDataReviewModuleKey valueOf(String r1) {
        return (MemoryDataReviewModuleKey) r27.a.a(MemoryDataReviewModuleKey.class, r1);
    }

    public MemoryDataReviewModuleKey(String r1, int r2, String r3) {
        super(r1, r2);
        this.raw = r3;
    }
}
