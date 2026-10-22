package com.obric.memorydata.database.aging;

import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\u0010\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\tJ\u0006\u0010\u0012\u001a\u00020\rR\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/database/aging/ScreenshotAttachmentAgingCheckpointStore;", "", "<init>", "()V", "store", "Lcom/obric/memorydata/middleware/api/store/IStore;", "getStore", "()Lcom/obric/memorydata/middleware/api/store/IStore;", "getLastProcessedCutoff", "", AILabCheckPermissionTask.KEY_SOURCE, "Lcom/obric/memorydata/database/aging/ScreenshotAttachmentAgingCheckpointStore$Source;", "saveLastProcessedCutoff", "", "cutoff", "getLastProcessedPrimaryKey", "saveLastProcessedPrimaryKey", "primaryKey", "resetAll", "Source", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScreenshotAttachmentAgingCheckpointStore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ScreenshotAttachmentAgingCheckpointStore f8838a = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/database/aging/ScreenshotAttachmentAgingCheckpointStore$Source;", "", "timeKey", "", "countKey", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getTimeKey", "()Ljava/lang/String;", "getCountKey", "RAW_OBSERVATION", "SCREEN_OBSERVATION", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum Source extends Enum<Source> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Source[] $VALUES = null;
        public static final Source RAW_OBSERVATION = null;
        public static final Source SCREEN_OBSERVATION = null;
        private final String countKey;
        private final String timeKey;

        private static final /* synthetic */ Source[] $values() {
            return new Source[]{RAW_OBSERVATION, SCREEN_OBSERVATION};
        }

        static {
            RAW_OBSERVATION = new Source("RAW_OBSERVATION", 0, "raw_observation_screenshot_aging_cutoff", "raw_observation_screenshot_aging_primary_key");
            SCREEN_OBSERVATION = new Source("SCREEN_OBSERVATION", 1, "screen_observation_screenshot_aging_cutoff", "screen_observation_screenshot_aging_primary_key");
            Source[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private Source(String r1, int r2, String r3, String r4) {
            super(r1, r2);
            this.timeKey = r3;
            this.countKey = r4;
        }

        public static EnumEntries<Source> getEntries() {
            return $ENTRIES;
        }

        public static Source valueOf(String r2) {
            return (Source) ZeusTransformUtils.preCheckCast(Enum.valueOf(Source.class, r2), Source.class, "com.obric.memorydata.plugin");
        }

        public static Source[] values() {
            return (Source[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Source[].class, "com.obric.memorydata.plugin");
        }

        public final String getCountKey() {
            return this.countKey;
        }

        public final String getTimeKey() {
            return this.timeKey;
        }
    }

    static {
        f8838a = new ScreenshotAttachmentAgingCheckpointStore();
    }

    private ScreenshotAttachmentAgingCheckpointStore() {
    }

    private final IStore b() {
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
    }

    public final long a(Source r3) {
        Intrinsics.checkNotNullParameter(r3, AILabCheckPermissionTask.KEY_SOURCE);
        return b().getLong(r3.getTimeKey(), 0);
    }

    public final void a() {
        Source[] r0 = Source.values();
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        int r2 = r0.length;
        int r5 = 0;
    L3:
        if (r5 >= r2) goto L5;
        Source r6 = r0[r5];
        CollectionsKt.addAll(r1, (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new String[]{r6.getTimeKey(), r6.getCountKey()}), Iterable.class, "com.obric.memorydata.plugin"));
        r5 = r5 + 1;
        goto L3
    L5:
        List r3 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
        IStore r9 = b();
        String[] r4 = (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin");
        r9.remove((String[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r4, r4.length), String[].class, "com.obric.memorydata.plugin"));
    }

    public final void a(Source r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, AILabCheckPermissionTask.KEY_SOURCE);
        b().save(r2.getTimeKey(), r3);
    }

    public final long b(Source r3) {
        Intrinsics.checkNotNullParameter(r3, AILabCheckPermissionTask.KEY_SOURCE);
        return b().getLong(r3.getCountKey(), 0);
    }

    public final void b(Source r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, AILabCheckPermissionTask.KEY_SOURCE);
        b().save(r2.getCountKey(), r3);
    }
}
