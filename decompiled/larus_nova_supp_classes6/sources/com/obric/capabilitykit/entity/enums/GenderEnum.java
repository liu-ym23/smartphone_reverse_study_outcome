package com.obric.capabilitykit.entity.enums;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/capabilitykit/entity/enums/GenderEnum;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "MALE", "FEMALE", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1})
public final enum GenderEnum extends Enum<GenderEnum> {
    private static final /* synthetic */ GenderEnum[] $VALUES = null;
    public static final a Companion = null;
    public static final GenderEnum FEMALE = null;
    public static final GenderEnum MALE = null;

    private static final /* synthetic */ GenderEnum[] $values() {
        return new GenderEnum[]{MALE, FEMALE};
    }

    static {
        MALE = new GenderEnum("MALE", 0);
        FEMALE = new GenderEnum("FEMALE", 1);
        $VALUES = $values();
        Companion = new a();
    }

    private GenderEnum(String r1, int r2) {
        super(r1, r2);
    }

    public static GenderEnum valueOf(String r1) {
        return (GenderEnum) a.a(GenderEnum.class, r1);
    }

    public static GenderEnum[] values() {
        return (GenderEnum[]) $VALUES.clone();
    }
}
