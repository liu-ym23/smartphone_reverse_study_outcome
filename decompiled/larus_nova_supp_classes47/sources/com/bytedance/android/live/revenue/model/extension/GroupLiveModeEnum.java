package com.bytedance.android.live.revenue.model.extension;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/revenue/model/extension/GroupLiveModeEnum;", "", "", "value", "I", "getValue", "()I", "GroupLiveModeNormal", "GroupLiveModeFactionCompetition", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum GroupLiveModeEnum extends Enum<GroupLiveModeEnum> {
    public static final GroupLiveModeEnum GroupLiveModeFactionCompetition = null;
    public static final GroupLiveModeEnum GroupLiveModeNormal = null;
    public static final /* synthetic */ GroupLiveModeEnum[] a = null;
    private final int value;

    static {
        GroupLiveModeEnum r1 = new GroupLiveModeEnum("GroupLiveModeNormal", 0, 0);
        GroupLiveModeNormal = r1;
        GroupLiveModeEnum r2 = new GroupLiveModeEnum("GroupLiveModeFactionCompetition", 1, 1);
        GroupLiveModeFactionCompetition = r2;
        a = new GroupLiveModeEnum[]{r1, r2};
    }

    public static GroupLiveModeEnum valueOf(String r1) {
        return (GroupLiveModeEnum) a.a(GroupLiveModeEnum.class, r1);
    }

    public static GroupLiveModeEnum[] values() {
        return (GroupLiveModeEnum[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public GroupLiveModeEnum(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
