package com.obric.memorydata.recommend;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/recommend/RecorderSettingsContract;", "", "<init>", "()V", "AUTHORITY", "", "PATH_CELLULAR", "PATH_BLOCK_RULES", "CELLULAR_URI", "BLOCK_RULES_URI", "COLUMN_ENABLED", "COLUMN_CONTENT", "COLUMN_SOURCE", "requireQuery", "Lcom/obric/memorydata/recommend/RecorderSettingsContract$Query;", "uri", "Query", "recommend_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RecorderSettingsContract {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RecorderSettingsContract f12492a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/recommend/RecorderSettingsContract$Query;", "", "<init>", "(Ljava/lang/String;I)V", "CELLULAR", "BLOCK_RULES", "recommend_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum Query extends Enum<Query> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Query[] $VALUES = null;
        public static final Query BLOCK_RULES = null;
        public static final Query CELLULAR = null;

        private static final /* synthetic */ Query[] $values() {
            return new Query[]{CELLULAR, BLOCK_RULES};
        }

        static {
            CELLULAR = new Query("CELLULAR", 0);
            BLOCK_RULES = new Query("BLOCK_RULES", 1);
            Query[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private Query(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<Query> getEntries() {
            return $ENTRIES;
        }

        public static Query valueOf(String r2) {
            return (Query) ZeusTransformUtils.preCheckCast(Enum.valueOf(Query.class, r2), Query.class, "com.obric.memorydata.plugin");
        }

        public static Query[] values() {
            return (Query[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Query[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f12492a = new RecorderSettingsContract();
    }

    private RecorderSettingsContract() {
    }

    public final Query a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        if (Intrinsics.areEqual(r1, "content://com.obric.memorydata.memory.ailabprovider/recorder_settings/cellular") == false) goto L6;
        return Query.CELLULAR;
    L6:
        if (Intrinsics.areEqual(r1, "content://com.obric.memorydata.memory.ailabprovider/recorder_settings/block_rules") == false) goto L10;
        return Query.BLOCK_RULES;
    L10:
        throw new IllegalArgumentException("Unknown recorder settings URI");
    }
}
