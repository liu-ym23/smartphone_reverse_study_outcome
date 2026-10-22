package com.obric.memorydata.database.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/database/entity/ProfileKey;", "", "<init>", "(Ljava/lang/String;I)V", "ADDRESS_HOME", "ADDRESS_COMPANY", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ProfileKey extends Enum<ProfileKey> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ProfileKey[] $VALUES = null;
    public static final ProfileKey ADDRESS_COMPANY = null;
    public static final ProfileKey ADDRESS_HOME = null;

    private static final /* synthetic */ ProfileKey[] $values() {
        return new ProfileKey[]{ADDRESS_HOME, ADDRESS_COMPANY};
    }

    static {
        ADDRESS_HOME = new ProfileKey("ADDRESS_HOME", 0);
        ADDRESS_COMPANY = new ProfileKey("ADDRESS_COMPANY", 1);
        ProfileKey[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private ProfileKey(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<ProfileKey> getEntries() {
        return $ENTRIES;
    }

    public static ProfileKey valueOf(String r2) {
        return (ProfileKey) ZeusTransformUtils.preCheckCast(Enum.valueOf(ProfileKey.class, r2), ProfileKey.class, "com.obric.memorydata.plugin");
    }

    public static ProfileKey[] values() {
        return (ProfileKey[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ProfileKey[].class, "com.obric.memorydata.plugin");
    }
}
