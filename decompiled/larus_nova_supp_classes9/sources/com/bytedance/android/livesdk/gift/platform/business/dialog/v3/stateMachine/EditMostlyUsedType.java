package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/EditMostlyUsedType;", BuildConfig.FLAVOR, "(Ljava/lang/String;I)V", "ADD", "REMOVE", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EditMostlyUsedType extends Enum<EditMostlyUsedType> {
    private static final /* synthetic */ EditMostlyUsedType[] $VALUES = null;
    public static final EditMostlyUsedType ADD = null;
    public static final EditMostlyUsedType REMOVE = null;

    static {
        EditMostlyUsedType r1 = new EditMostlyUsedType("ADD", 0);
        ADD = r1;
        EditMostlyUsedType r2 = new EditMostlyUsedType("REMOVE", 1);
        REMOVE = r2;
        $VALUES = new EditMostlyUsedType[]{r1, r2};
    }

    public static EditMostlyUsedType valueOf(String r1) {
        return (EditMostlyUsedType) a.a(EditMostlyUsedType.class, r1);
    }

    public static EditMostlyUsedType[] values() {
        return (EditMostlyUsedType[]) $VALUES.clone();
    }

    private EditMostlyUsedType(String r1, int r2) {
        super(r1, r2);
    }
}
