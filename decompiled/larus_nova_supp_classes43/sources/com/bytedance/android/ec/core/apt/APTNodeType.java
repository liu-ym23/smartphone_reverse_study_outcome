package com.bytedance.android.ec.core.apt;

import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/ec/core/apt/APTNodeType;", "", "", a.KEY_LUBAN_VALUE, "I", "getValue", "()I", "DEFAULT", "ENTER_PAGE", "QUIT_PAGE", "NETWORK", "EVENT", "OUTER_SCHEMA", "DIFF", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum APTNodeType extends Enum<APTNodeType> {
    public static final APTNodeType DEFAULT = null;
    public static final APTNodeType DIFF = null;
    public static final APTNodeType ENTER_PAGE = null;
    public static final APTNodeType EVENT = null;
    public static final APTNodeType NETWORK = null;
    public static final APTNodeType OUTER_SCHEMA = null;
    public static final APTNodeType QUIT_PAGE = null;
    public static final /* synthetic */ APTNodeType[] a = null;
    private final int value;

    static {
        APTNodeType r1 = new APTNodeType("DEFAULT", 0, 0);
        DEFAULT = r1;
        APTNodeType r10 = new APTNodeType("ENTER_PAGE", 1, 1);
        ENTER_PAGE = r10;
        APTNodeType r11 = new APTNodeType("QUIT_PAGE", 2, 2);
        QUIT_PAGE = r11;
        APTNodeType r12 = new APTNodeType("NETWORK", 3, 3);
        NETWORK = r12;
        APTNodeType r13 = new APTNodeType("EVENT", 4, 4);
        EVENT = r13;
        APTNodeType r14 = new APTNodeType("OUTER_SCHEMA", 5, 5);
        OUTER_SCHEMA = r14;
        APTNodeType r15 = new APTNodeType("DIFF", 6, 99);
        DIFF = r15;
        a = new APTNodeType[]{r1, r10, r11, r12, r13, r14, r15};
    }

    public static APTNodeType valueOf(String r1) {
        return (APTNodeType) r27.a.a(APTNodeType.class, r1);
    }

    public static APTNodeType[] values() {
        return (APTNodeType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public APTNodeType(String r1, int r10, int r11) {
        super(r1, r10);
        this.value = r11;
    }
}
