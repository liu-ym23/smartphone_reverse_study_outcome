package com.obric.memorydata.migration.sdk.internal.file;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/migration/sdk/internal/file/FileRoot;", "", "<init>", "(Ljava/lang/String;I)V", "FILES", "CACHE", "EXTERNAL_FILES", "EXTERNAL_CACHE", "EXTERNAL", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final enum FileRoot extends Enum<FileRoot> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ FileRoot[] $VALUES = null;
    public static final FileRoot CACHE = null;
    public static final FileRoot EXTERNAL = null;
    public static final FileRoot EXTERNAL_CACHE = null;
    public static final FileRoot EXTERNAL_FILES = null;
    public static final FileRoot FILES = null;

    private static final /* synthetic */ FileRoot[] $values() {
        return new FileRoot[]{FILES, CACHE, EXTERNAL_FILES, EXTERNAL_CACHE, EXTERNAL};
    }

    static {
        FILES = new FileRoot("FILES", 0);
        CACHE = new FileRoot("CACHE", 1);
        EXTERNAL_FILES = new FileRoot("EXTERNAL_FILES", 2);
        EXTERNAL_CACHE = new FileRoot("EXTERNAL_CACHE", 3);
        EXTERNAL = new FileRoot("EXTERNAL", 4);
        FileRoot[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private FileRoot(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<FileRoot> getEntries() {
        return $ENTRIES;
    }

    public static FileRoot valueOf(String r2) {
        return (FileRoot) ZeusTransformUtils.preCheckCast(Enum.valueOf(FileRoot.class, r2), FileRoot.class, "com.obric.memorydata.plugin");
    }

    public static FileRoot[] values() {
        return (FileRoot[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FileRoot[].class, "com.obric.memorydata.plugin");
    }
}
