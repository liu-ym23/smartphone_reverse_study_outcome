package com.ss.android.lark.flow.common.utils;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/flow/common/utils/FlowTagType;", "", "order", "", "<init>", "(Ljava/lang/String;II)V", "getOrder", "()I", "RESIGNED", "FROZEN", "ON_LEAVE", "EXTERNAL", "PUBLIC", "DEPARTMENT", "BLOCK", "AGENT", "flow-common_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum FlowTagType extends Enum<FlowTagType> {
    public static final FlowTagType AGENT = null;
    public static final FlowTagType BLOCK = null;
    public static final FlowTagType DEPARTMENT = null;
    public static final FlowTagType EXTERNAL = null;
    public static final FlowTagType FROZEN = null;
    public static final FlowTagType ON_LEAVE = null;
    public static final FlowTagType PUBLIC = null;
    public static final FlowTagType RESIGNED = null;
    public static final /* synthetic */ FlowTagType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int order;

    public static EnumEntries<FlowTagType> getEntries() {
        return b;
    }

    static {
        FlowTagType r0 = new FlowTagType("RESIGNED", 0, -100);
        RESIGNED = r0;
        FlowTagType r1 = new FlowTagType("FROZEN", 1, -1);
        FROZEN = r1;
        FlowTagType r2 = new FlowTagType("ON_LEAVE", 2, 0);
        ON_LEAVE = r2;
        FlowTagType r4 = new FlowTagType("EXTERNAL", 3, 4);
        EXTERNAL = r4;
        FlowTagType r7 = new FlowTagType("PUBLIC", 4, 5);
        PUBLIC = r7;
        FlowTagType r10 = new FlowTagType("DEPARTMENT", 5, 7);
        DEPARTMENT = r10;
        FlowTagType r12 = new FlowTagType("BLOCK", 6, 102);
        BLOCK = r12;
        FlowTagType r14 = new FlowTagType("AGENT", 7, 50);
        AGENT = r14;
        FlowTagType[] r11 = {r0, r1, r2, r4, r7, r10, r12, r14};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static FlowTagType[] values() {
        return (FlowTagType[]) a.clone();
    }

    public final int getOrder() {
        return this.order;
    }

    public static FlowTagType valueOf(String r1) {
        return (FlowTagType) r27.a.a(FlowTagType.class, r1);
    }

    public FlowTagType(String r1, int r2, int r3) {
        super(r1, r2);
        this.order = r3;
    }
}
