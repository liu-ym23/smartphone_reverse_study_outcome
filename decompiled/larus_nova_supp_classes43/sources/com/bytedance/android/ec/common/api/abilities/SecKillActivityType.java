package com.bytedance.android.ec.common.api.abilities;

import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/common/api/abilities/SecKillActivityType;", "", "", a.KEY_LUBAN_VALUE, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "NONE", "PRE_SECKILL", "SECKILL", "END", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public final enum SecKillActivityType extends Enum<SecKillActivityType> {
    public static final SecKillActivityType END = null;
    public static final SecKillActivityType NONE = null;
    public static final SecKillActivityType PRE_SECKILL = null;
    public static final SecKillActivityType SECKILL = null;
    public static final /* synthetic */ SecKillActivityType[] a = null;
    private final String value;

    static {
        SecKillActivityType r1 = new SecKillActivityType("NONE", 0, "");
        NONE = r1;
        SecKillActivityType r10 = new SecKillActivityType("PRE_SECKILL", 1, a.VALUE_PRE_SECKILL);
        PRE_SECKILL = r10;
        SecKillActivityType r11 = new SecKillActivityType("SECKILL", 2, a.VALUE_SECKILL);
        SECKILL = r11;
        SecKillActivityType r12 = new SecKillActivityType("END", 3, "");
        END = r12;
        a = new SecKillActivityType[]{r1, r10, r11, r12};
    }

    public static SecKillActivityType valueOf(String r1) {
        return (SecKillActivityType) r27.a.a(SecKillActivityType.class, r1);
    }

    public static SecKillActivityType[] values() {
        return (SecKillActivityType[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public SecKillActivityType(String r1, int r10, String r11) {
        super(r1, r10);
        this.value = r11;
    }
}
