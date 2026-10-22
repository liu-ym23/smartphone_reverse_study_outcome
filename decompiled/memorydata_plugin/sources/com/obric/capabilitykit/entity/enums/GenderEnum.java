package com.obric.capabilitykit.entity.enums;

import android.util.Log;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0006"}, d2 = {"Lcom/obric/capabilitykit/entity/enums/GenderEnum;", "", "(Ljava/lang/String;I)V", "MALE", "FEMALE", "Companion", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum GenderEnum extends Enum<GenderEnum> {
    private static final /* synthetic */ GenderEnum[] $VALUES = null;
    public static final Companion Companion = null;
    public static final GenderEnum FEMALE = null;
    public static final GenderEnum MALE = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/enums/GenderEnum$Companion;", "", "()V", "from", "Lcom/obric/capabilitykit/entity/enums/GenderEnum;", ActivityLifecycle.NAME, "", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final GenderEnum from(String r3) {
            GenderEnum r2 = null;
            if (r3 == null) goto L9;
            r2 = GenderEnum.valueOf(r3);     // Catch: IllegalArgumentException -> L7
        L7:
            Log.w("EntityEnum", "failed to create enum from name " + r3 + " for enum type " + Reflection.getOrCreateKotlinClass(GenderEnum.class).getSimpleName() + ' ');
        L9:
            return (GenderEnum) ZeusTransformUtils.preCheckCast(r2, GenderEnum.class, "com.obric.memorydata.plugin");
        }
    }

    private static final /* synthetic */ GenderEnum[] $values() {
        return new GenderEnum[]{MALE, FEMALE};
    }

    static {
        MALE = new GenderEnum("MALE", 0);
        FEMALE = new GenderEnum("FEMALE", 1);
        $VALUES = $values();
        Companion = new Companion(null);
    }

    private GenderEnum(String r1, int r2) {
        super(r1, r2);
    }

    public static GenderEnum valueOf(String r2) {
        return (GenderEnum) ZeusTransformUtils.preCheckCast(Enum.valueOf(GenderEnum.class, r2), GenderEnum.class, "com.obric.memorydata.plugin");
    }

    public static GenderEnum[] values() {
        return (GenderEnum[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), GenderEnum[].class, "com.obric.memorydata.plugin");
    }
}
