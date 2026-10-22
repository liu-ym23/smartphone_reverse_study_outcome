package com.obric.sva.sdk.logger;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/sva/sdk/logger/SpecialCategory;", "", "fileName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getFileName", "()Ljava/lang/String;", "WAKEUP_DURATION", "WAKEUP_FILE", "ENROLL_FILE", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final enum SpecialCategory extends Enum<SpecialCategory> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ SpecialCategory[] $VALUES = null;
    public static final SpecialCategory ENROLL_FILE = null;
    public static final SpecialCategory WAKEUP_DURATION = null;
    public static final SpecialCategory WAKEUP_FILE = null;
    private final String fileName;

    private static final /* synthetic */ SpecialCategory[] $values() {
        return new SpecialCategory[]{WAKEUP_DURATION, WAKEUP_FILE, ENROLL_FILE};
    }

    public static EnumEntries<SpecialCategory> getEntries() {
        return $ENTRIES;
    }

    static {
        WAKEUP_DURATION = new SpecialCategory("WAKEUP_DURATION", 0, "wakeup_duration.log");
        WAKEUP_FILE = new SpecialCategory("WAKEUP_FILE", 1, "wakeup_file.log");
        ENROLL_FILE = new SpecialCategory("ENROLL_FILE", 2, "enroll_file.log");
        SpecialCategory[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static SpecialCategory[] values() {
        return (SpecialCategory[]) $VALUES.clone();
    }

    public final String getFileName() {
        return this.fileName;
    }

    public static SpecialCategory valueOf(String r1) {
        return (SpecialCategory) r27.a.a(SpecialCategory.class, r1);
    }

    private SpecialCategory(String r1, int r2, String r3) {
        super(r1, r2);
        this.fileName = r3;
    }
}
