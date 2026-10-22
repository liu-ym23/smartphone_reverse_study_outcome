package com.bytedance.ies.xbridge.annotation;

import androidx.annotation.Keep;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/xbridge/annotation/DefaultType;", "", "(Ljava/lang/String;I)V", "STRING", "DOUBLE", "INT", "LONG", "BOOL", "NONE", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum DefaultType extends Enum<DefaultType> {
    private static final /* synthetic */ DefaultType[] $VALUES = null;
    public static final DefaultType BOOL = null;
    public static final DefaultType DOUBLE = null;
    public static final DefaultType INT = null;
    public static final DefaultType LONG = null;
    public static final DefaultType NONE = null;
    public static final DefaultType STRING = null;

    private static final /* synthetic */ DefaultType[] $values() {
        return new DefaultType[]{STRING, DOUBLE, INT, LONG, BOOL, NONE};
    }

    static {
        STRING = new DefaultType("STRING", 0);
        DOUBLE = new DefaultType("DOUBLE", 1);
        INT = new DefaultType("INT", 2);
        LONG = new DefaultType("LONG", 3);
        BOOL = new DefaultType("BOOL", 4);
        NONE = new DefaultType("NONE", 5);
        $VALUES = $values();
    }

    private DefaultType(String r5, int r10) {
        super(r5, r10);
    }

    public static DefaultType valueOf(String r5) {
        return (DefaultType) Enum.valueOf(DefaultType.class, r5);
    }

    public static DefaultType[] values() {
        return (DefaultType[]) $VALUES.clone();
    }
}
