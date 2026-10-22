package com.larus.dora.impl.device.settings.lab.headcontrol;

import com.larus.utils.j0;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rj\u0002\b\bj\u0002\b\t¨\u0006\u000e"}, d2 = {"Lcom/larus/dora/impl/device/settings/lab/headcontrol/HeadControlGestureType;", "", "titleRes", "", "<init>", "(Ljava/lang/String;II)V", "getTitleRes", "()I", "NOD", "SHAKE", "title", "", "getTitle", "()Ljava/lang/String;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum HeadControlGestureType extends Enum<HeadControlGestureType> {
    public static final HeadControlGestureType NOD = null;
    public static final HeadControlGestureType SHAKE = null;
    public static final /* synthetic */ HeadControlGestureType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int titleRes;

    public static EnumEntries<HeadControlGestureType> getEntries() {
        return b;
    }

    static {
        HeadControlGestureType r0 = new HeadControlGestureType("NOD", 0, 2131902757);
        NOD = r0;
        HeadControlGestureType r1 = new HeadControlGestureType("SHAKE", 1, 2131902758);
        SHAKE = r1;
        HeadControlGestureType[] r2 = {r0, r1};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static HeadControlGestureType[] values() {
        return (HeadControlGestureType[]) a.clone();
    }

    public final String getTitle() {
        int r0 = j0.a;
        return j0.d(this.titleRes);
    }

    public final int getTitleRes() {
        return this.titleRes;
    }

    public static HeadControlGestureType valueOf(String r1) {
        return (HeadControlGestureType) a.a(HeadControlGestureType.class, r1);
    }

    public HeadControlGestureType(String r1, int r2, int r3) {
        super(r1, r2);
        this.titleRes = r3;
    }
}
