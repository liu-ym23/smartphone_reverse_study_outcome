package com.obric.memorydata.database.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/database/entity/AppStateType;", "", "state", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getState", "()Ljava/lang/String;", "FG", "BG", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum AppStateType extends Enum<AppStateType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AppStateType[] $VALUES = null;
    public static final AppStateType BG = null;
    public static final AppStateType FG = null;
    private final String state;

    private static final /* synthetic */ AppStateType[] $values() {
        return new AppStateType[]{FG, BG};
    }

    static {
        FG = new AppStateType("FG", 0, "fg");
        BG = new AppStateType("BG", 1, "bg");
        AppStateType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private AppStateType(String r1, int r2, String r3) {
        super(r1, r2);
        this.state = r3;
    }

    public static EnumEntries<AppStateType> getEntries() {
        return $ENTRIES;
    }

    public static AppStateType valueOf(String r2) {
        return (AppStateType) ZeusTransformUtils.preCheckCast(Enum.valueOf(AppStateType.class, r2), AppStateType.class, "com.obric.memorydata.plugin");
    }

    public static AppStateType[] values() {
        return (AppStateType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AppStateType[].class, "com.obric.memorydata.plugin");
    }

    public final String getState() {
        return this.state;
    }
}
