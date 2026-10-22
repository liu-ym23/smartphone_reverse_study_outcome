package com.bytedance.applog.map.api;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/applog/map/api/IdSource;", "", "(Ljava/lang/String;I)V", "toString", "", "Auto", "NxET", "BTM", TypedValues.Custom.NAME, "map-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum IdSource extends Enum<IdSource> {
    private static final /* synthetic */ IdSource[] $VALUES = null;
    public static final IdSource Auto = null;
    public static final IdSource BTM = null;
    public static final IdSource Custom = null;
    public static final IdSource NxET = null;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1659a = null;

        static {
            int[] r0 = new int[IdSource.values().length];
            r0[IdSource.Auto.ordinal()] = 1;
            r0[IdSource.NxET.ordinal()] = 2;
            r0[IdSource.BTM.ordinal()] = 3;
            r0[IdSource.Custom.ordinal()] = 4;
            f1659a = r0;
        }
    }

    private static final /* synthetic */ IdSource[] $values() {
        return new IdSource[]{Auto, NxET, BTM, Custom};
    }

    static {
        Auto = new IdSource("Auto", 0);
        NxET = new IdSource("NxET", 1);
        BTM = new IdSource("BTM", 2);
        Custom = new IdSource(TypedValues.Custom.NAME, 3);
        $VALUES = $values();
    }

    private IdSource(String r1, int r2) {
        super(r1, r2);
    }

    public static IdSource valueOf(String r2) {
        return (IdSource) ZeusTransformUtils.preCheckCast(Enum.valueOf(IdSource.class, r2), IdSource.class, "com.obric.memorydata.plugin");
    }

    public static IdSource[] values() {
        return (IdSource[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), IdSource[].class, "com.obric.memorydata.plugin");
    }

    @Override // java.lang.Enum
    public String toString() {
        int r1 = a.f1659a[ordinal()];
        if (r1 != 1) goto L5;
        return "auto";
    L5:
        if (r1 != 2) goto L7;
        return "nxet";
    L7:
        if (r1 != 3) goto L9;
        return "btm";
    L9:
        if (r1 != 4) goto L12;
        return "custom";
    L12:
        throw new NoWhenBranchMatchedException();
    }
}
