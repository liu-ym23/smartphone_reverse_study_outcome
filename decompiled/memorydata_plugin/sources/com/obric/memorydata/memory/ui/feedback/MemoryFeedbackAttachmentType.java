package com.obric.memorydata.memory.ui.feedback;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackAttachmentType;", "", "<init>", "(Ljava/lang/String;I)V", "SCREEN_ENTITY_JSON", "AUDIO_ENTITY_JSON", "AUTO_MEMORY_PRO_PACKAGE", "COLLECTION_OR_PROFILE_LEGACY", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum MemoryFeedbackAttachmentType extends Enum<MemoryFeedbackAttachmentType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MemoryFeedbackAttachmentType[] $VALUES = null;
    public static final MemoryFeedbackAttachmentType AUDIO_ENTITY_JSON = null;
    public static final MemoryFeedbackAttachmentType AUTO_MEMORY_PRO_PACKAGE = null;
    public static final MemoryFeedbackAttachmentType COLLECTION_OR_PROFILE_LEGACY = null;
    public static final MemoryFeedbackAttachmentType SCREEN_ENTITY_JSON = null;

    private static final /* synthetic */ MemoryFeedbackAttachmentType[] $values() {
        return new MemoryFeedbackAttachmentType[]{SCREEN_ENTITY_JSON, AUDIO_ENTITY_JSON, AUTO_MEMORY_PRO_PACKAGE, COLLECTION_OR_PROFILE_LEGACY};
    }

    static {
        SCREEN_ENTITY_JSON = new MemoryFeedbackAttachmentType("SCREEN_ENTITY_JSON", 0);
        AUDIO_ENTITY_JSON = new MemoryFeedbackAttachmentType("AUDIO_ENTITY_JSON", 1);
        AUTO_MEMORY_PRO_PACKAGE = new MemoryFeedbackAttachmentType("AUTO_MEMORY_PRO_PACKAGE", 2);
        COLLECTION_OR_PROFILE_LEGACY = new MemoryFeedbackAttachmentType("COLLECTION_OR_PROFILE_LEGACY", 3);
        MemoryFeedbackAttachmentType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private MemoryFeedbackAttachmentType(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<MemoryFeedbackAttachmentType> getEntries() {
        return $ENTRIES;
    }

    public static MemoryFeedbackAttachmentType valueOf(String r2) {
        return (MemoryFeedbackAttachmentType) ZeusTransformUtils.preCheckCast(Enum.valueOf(MemoryFeedbackAttachmentType.class, r2), MemoryFeedbackAttachmentType.class, "com.obric.memorydata.plugin");
    }

    public static MemoryFeedbackAttachmentType[] values() {
        return (MemoryFeedbackAttachmentType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MemoryFeedbackAttachmentType[].class, "com.obric.memorydata.plugin");
    }
}
