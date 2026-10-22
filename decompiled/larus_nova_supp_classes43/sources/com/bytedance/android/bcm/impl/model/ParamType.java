package com.bytedance.android.bcm.impl.model;

import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/bcm/impl/model/ParamType;", "", "", a.KEY_LUBAN_VALUE, "I", "getValue", "()I", "UNDEFINED", "ENUM", "ID", "NAME", "bcm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
public final enum ParamType extends Enum<ParamType> {
    public static final ParamType ENUM = null;
    public static final ParamType ID = null;
    public static final ParamType NAME = null;
    public static final ParamType UNDEFINED = null;
    public static final /* synthetic */ ParamType[] a = null;
    private final int value;

    static {
        ParamType r1 = new ParamType("UNDEFINED", 0, 0);
        UNDEFINED = r1;
        ParamType r10 = new ParamType("ENUM", 1, 1);
        ENUM = r10;
        ParamType r11 = new ParamType("ID", 2, 2);
        ID = r11;
        ParamType r12 = new ParamType("NAME", 3, 3);
        NAME = r12;
        a = new ParamType[]{r1, r10, r11, r12};
    }

    public static ParamType valueOf(String r1) {
        return (ParamType) r27.a.a(ParamType.class, r1);
    }

    public static ParamType[] values() {
        return (ParamType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public ParamType(String r1, int r10, int r11) {
        super(r1, r10);
        this.value = r11;
    }
}
