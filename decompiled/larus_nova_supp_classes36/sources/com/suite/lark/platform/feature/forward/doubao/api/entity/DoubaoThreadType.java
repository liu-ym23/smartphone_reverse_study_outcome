package com.suite.lark.platform.feature.forward.doubao.api.entity;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/suite/lark/platform/feature/forward/doubao/api/entity/DoubaoThreadType;", "", "<init>", "(Ljava/lang/String;I)V", "ALL", "NORMAL_THREAD", "MSG_THREAD", "forward-doubao-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum DoubaoThreadType extends Enum<DoubaoThreadType> {
    public static final DoubaoThreadType ALL = null;
    public static final DoubaoThreadType MSG_THREAD = null;
    public static final DoubaoThreadType NORMAL_THREAD = null;
    public static final /* synthetic */ DoubaoThreadType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DoubaoThreadType> getEntries() {
        return b;
    }

    static {
        DoubaoThreadType r0 = new DoubaoThreadType("ALL", 0);
        ALL = r0;
        DoubaoThreadType r1 = new DoubaoThreadType("NORMAL_THREAD", 1);
        NORMAL_THREAD = r1;
        DoubaoThreadType r3 = new DoubaoThreadType("MSG_THREAD", 2);
        MSG_THREAD = r3;
        DoubaoThreadType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static DoubaoThreadType[] values() {
        return (DoubaoThreadType[]) a.clone();
    }

    public static DoubaoThreadType valueOf(String r1) {
        return (DoubaoThreadType) a.a(DoubaoThreadType.class, r1);
    }

    public DoubaoThreadType(String r1, int r2) {
        super(r1, r2);
    }
}
